package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class ConnectionController {
    private final ConnectionView connectionView;
    private TablesView tablesView;
    private GameView gameView;
    private final GameModel gameModel;
    
    private Socket socket;
    private BufferedReader socketReader;
    private PrintStream socketWriter;
    
    private String ip;
    private int port;
    private String nickname;
    
    public ConnectionController(ConnectionView cView, GameModel gModel) {
        this.connectionView = cView;
        this.gameModel = gModel;
        System.out.println("Connection controller created.");
        
        this.connectionView.addConnectButtonListener(new ConnectListener());
    }
    
    class ConnectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ip = connectionView.getIP();
                port = connectionView.getPort();
                nickname = connectionView.getLogin();

                if (nickname.equals(""))
                    throw new Exception("Write login!");
                
                connect();
                createTablesView();
                System.out.println("Connection established.");
                runGettingMessagesThread();
                
                sendMessage(new Message(MessageType.NICKNAME, nickname));
                
                disposeWindow(connectionView);
                tablesView.setVisible(true);
            } catch(IOException ex) {
                System.out.println(ex);
                connectionView.displayErrorMessage("Cannot connect server.");
            } catch(Exception ex) {
                System.out.println(ex);
                connectionView.displayErrorMessage(ex.getMessage());
            }
        }
        
        private void connect() throws IOException {
            socket = new Socket(ip, port);
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketWriter = new PrintStream(socket.getOutputStream());
        }
    }
    
    private void disposeWindow(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
    }
    
    private void sendMessage(Message msg) {
        String msgStr = msg.getMessage() + "&";
        try {
            socketWriter.write(msgStr.getBytes(Charset.forName("UTF-8")));
            System.out.println("Message sent: " + msgStr);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createTablesView() {
        this.tablesView = new TablesView();
        this.tablesView.setVisible(false);
        this.tablesView.addCreateButtonListener(new CreateTableListener());
        this.tablesView.addJoinButtonListener(new JoinTableListener());
        this.tablesView.addRequestTablesButtonListener(new RequestTablesListener());
    }
    
    private void runGettingMessagesThread() {
        
        Runnable MessageGet = new Runnable() {
            private String msg;
            
            @Override
            public void run() {
                while (true) {
                    msg = getMessage();
                    interpretMessage(msg);
                }
            }
        };
        
        new Thread(MessageGet).start();
    }
    
    private String getMessage() {
        String msg = "";
        
        try {
            msg = socketReader.readLine();
            System.out.println("Message received: " + msg);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msg;
    }
    
    private void interpretMessage(String message) {
        Message msg = new Message(message);
        MessageType type = msg.getMessageType();
        System.out.println("Message " + message + " interpreted as: " + type + " " + msg.getMessage());
        
        switch (type) {
            case SEND_TABLES: {
                showTables(msg);
                break;
            }
            case CARDS: {
                setCards(msg);
                break;
            }
            case START_BID: {
                gameView.displayErrorMessage("Your turn to bid.");
                break;
            }
            case SEND_BID: {
                setBidLabel(msg);
                break;
            }
            case BIDDING_RESULT: {
                setBiddingWinnerLabel(msg);
                break;
            }
            case PLAY_CARD: {
                gameView.displayErrorMessage("Play card!");
                break;
            }
            case SEND_CARD: {
                setCardImage(msg);
                break;
            }
            case ROUND_OVER: {
                updateResult(msg);
                break;
            }
            case GAME_RESULT: {
                endGame(msg);
                break;
            }
            case ACCEPTANCE: {
                interpretAcceptance(msg);
                break;
            }
        }
    }
    
    private void showTables(Message msg) {
        String tableId;
        String tableNumberOfPlayers;
        int numberOfTables = 0;
        tablesView.resetTables();
        
        try {
            numberOfTables = msg.getNumberOfTables();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        for (int i = 0; i < numberOfTables; i++) {
            try {
                tableId = msg.getTableID(i);
                tableNumberOfPlayers = msg.getTableNumberOfPlayers(i);
                tablesView.addTable(new String(tableId + "-" + tableNumberOfPlayers));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    private void setBidLabel(Message msg) {
        try {
            int playerLocation = msg.getBiddingPlayerLocation();
            String suit = msg.getBidSuit();
            int height = msg.getBidHeight();
            gameView.setBidLabel(playerLocation, suit, height);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void setBiddingWinnerLabel(Message msg) {
        try {
            int playerPosition = msg.getBiddingWinner();
            gameView.setBiddingWinnerLabel(playerPosition);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());     
        }
    }
    
    private void setCardImage(Message msg) {
        try {
            int playerLocation = msg.getPlayingLocation();
            String card = msg.getCard();
            gameView.setPlayedCard(playerLocation, card);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void updateResult(Message msg) {
        try {
            int winner = msg.getRoundWinner();
            if (winner % 2 == 0)
                gameModel.yourTricks++;
            else gameModel.opponentsTricks++;
            
            if (winner == 0)
                gameView.displayErrorMessage("You won round!");
            else 
                gameView.displayErrorMessage("Round winner is player " + String.valueOf(winner));
            
            gameView.updateYourScore(gameModel.yourTricks);
            gameView.updateOpponentsScore(gameModel.opponentsTricks);
            gameView.resetPlayedCards();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void endGame(Message msg) {
        try {
            int gameWinner = msg.getGameWinner();
            switch (gameWinner) {
                case 0: gameView.displayErrorMessage("Declarers won game!"); break;
                case 1: gameView.displayErrorMessage("Declarers lost game!"); break;
            }
            disposeWindow(gameView);
            tablesView.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void interpretAcceptance(Message msg) {
        try {
            MessageType msgType = msg.getAcceptanceType();
            boolean accepted = msg.isAccepted();

            switch(msgType) {
                case CREATE_TABLE: {
                    if (accepted) {
                        tablesView.setVisible(false);
                        createGameView();
                    }
                    else
                        tablesView.displayErrorMessage("Cannot create table.");
                    break;
                }
                case JOIN_TABLE: {
                    if (accepted) {
                        tablesView.setVisible(false);
                        createGameView();
                    } else
                        tablesView.displayErrorMessage("Cannot join selected table.");
                    break;
                }
                case GIVEN_BID: {
                    if (!accepted)
                        gameView.displayErrorMessage("You've bidden wrong.");
                    break;
                }
                case GIVEN_CARD: {
                    if (!accepted)
                        gameView.displayErrorMessage("You've played wrong card.");
                    break;
                }
                default: break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void createGameView() {
        this.gameView = new GameView();
        this.gameView.setVisible(true);
        this.gameView.addSendBidButtonListener(new SendBidListener());
        this.gameView.addPlayCardButtonListener(new PlayCardListener());
    }
    
    class SendBidListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sendMessage(new Message(MessageType.GIVEN_BID, gameView.getSelectedBid()));
        }
    }
    
    class PlayCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sendMessage(new Message(MessageType.GIVEN_CARD, gameView.getSelectedCard()));
        }
        
    }
        
    private void setCards(Message msg) {
        List<String> cards = new ArrayList();
        try {
            int numberOfCards = msg.getNumberOfCards();
            for (int i = 0; i < numberOfCards; i++) {
                cards.add(msg.getCard(i));
            }

            gameView.setCards(cards);
            gameView.setOthersCard(numberOfCards);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    class CreateTableListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sendMessage(new Message(MessageType.CREATE_TABLE, ""));
        }
        
    }
    
    class JoinTableListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String table = tablesView.getSelectedTable();
            table = table.substring(0, 1);
            System.out.println("Selected table is: " + table);
            sendMessage(new Message(MessageType.JOIN_TABLE, table));
        }
        
    }
    
    class RequestTablesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sendMessage(new Message(MessageType.REQUEST_TABLES, ""));
        }
        
    }
}


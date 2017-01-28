package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class ConnectionController {
    private final ConnectionView connectionView;
    private TablesView tablesView;
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
                createTablesView();

                if (nickname.equals(""))
                    throw new Exception("Podaj login!");
                
                connect();
                System.out.println("Connection established.");
                runGettingMessagesThread();
                
                sendMessage(new Message(MessageType.NICKNAME, nickname));
                
                disposeWindow(connectionView);
                tablesView.setVisible(true);
            } catch(IOException ex) {
                System.out.println(ex);
                connectionView.displayErrorMesage("Nie można się połączyć.");
            } catch(Exception ex) {
                System.out.println(ex);
                connectionView.displayErrorMesage(ex.getMessage());
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
        String msgStr = msg.getMessage();
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
    
    private void interpretAcceptance(Message msg) {
        MessageType msgType = msg.getAcceptanceType();
        boolean accepted = msg.isAccepted();
        
        switch(msgType) {
            case CREATE_TABLE: {
                if (accepted)
                    createTable();
                else
                    tablesView.displayErrorMesage("Cannot create table.");
                break;
            }
            case JOIN_TABLE: {
                if (accepted)
                    joinTable();
                else
                    tablesView.displayErrorMesage("Cannot join selected table.");
                break;
            }
            default: break;
        }
    }
    
    private void createTable() {
        tablesView.displayErrorMesage("Table created.");
    }
    
    private void joinTable() {
        tablesView.displayErrorMesage("Table joined.");
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
}


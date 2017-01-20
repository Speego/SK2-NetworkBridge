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
    private GameModel gameModel;
    
    private Socket socket;
    private BufferedReader socketReader;
    private PrintStream socketWriter;
    
    private String ip;
    private int port;
    private String nickname;
    
    public ConnectionController(ConnectionView cView, GameModel gModel) {
        this.connectionView = cView;
        this.gameModel = gModel;
        
        this.connectionView.addConnectButtonListener(new ConnectionListener());
    }
    
    class ConnectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ip = connectionView.getIP();
                port = connectionView.getPort();
                nickname = connectionView.getLogin();
                
                if (nickname.equals(""))
                    throw new Exception("Podaj login!");
                
                connect();
                runGettingMessagesThread();
                
                sendMessage(new Message(MessageType.NICKNAME, nickname));
                
                disposeWindow(connectionView);
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
    
    private void runGettingMessagesThread() {
        
        Runnable MessageGet = new Runnable() {
            private String msg;
            @Override
            public void run() {
                while (true) {
                    msg = getMessage();
                }
            }
        };
        
        new Thread(MessageGet).start();
    }
    
    private String getMessage() {
        String msg = new String("");
        
        try {
            msg = socketReader.readLine();
            System.out.println("Message received: " + msg);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return msg;
    }
}


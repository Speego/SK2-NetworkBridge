package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;


public class ConnectionController {
    private ConnectionView connectionView;
    private GameModel gameModel;
    
    private Socket socket;
    private BufferedReader socketReader;
    private PrintStream socketWriter;
    
    private String ip;
    private int port;
    
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
                
                connect();
//                connectionView.dispose();
            } catch(Exception ex) {
                System.out.println(ex);
                connectionView.displayErrorMesage("Cannot connect.");
            }
        }
        
        private void connect() throws IOException {
            socket = new Socket(ip, port);
            socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            socketWriter = new PrintStream(socket.getOutputStream());
            String writtenLine = inLine.readLine();
            socketWriter.write(writtenLine.getBytes(Charset.forName("UTF-8")));
        }
    }
}


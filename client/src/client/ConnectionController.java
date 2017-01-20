package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import javax.swing.JFrame;


public class ConnectionController {
    private final ConnectionView connectionView;
    private GameModel gameModel;
    
    private Socket socket;
    private BufferedReader socketReader;
    private PrintStream socketWriter;
    
    private String ip;
    private int port;
    private String name;
    
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
                name = connectionView.getLogin();
                
                if (name.equals(""))
                    throw new Exception("Podaj login!");
                
                connect();
                
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
//            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            socketWriter = new PrintStream(socket.getOutputStream());
//            String writtenLine = inLine.readLine();
//            socketWriter.write(writtenLine.getBytes(Charset.forName("UTF-8")));
        }
    }
    
    private void disposeWindow(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
    }
}


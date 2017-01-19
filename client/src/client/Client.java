package client;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException{
        ConnectionView connectionView = new ConnectionView();
        GameModel gameModel = new GameModel();
        ConnectionController connectionController = new ConnectionController(connectionView, gameModel);
        
        connectionView.setVisible(true);
    }
}

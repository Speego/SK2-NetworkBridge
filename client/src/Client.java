import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

public class Client {
	
    public static void main(String[] args) throws IOException{
        Socket clientSocket = new Socket("localhost", 1235);
//        BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
        PrintStream socketWriter = new PrintStream(clientSocket.getOutputStream());
        String writtenLine = inLine.readLine();
        socketWriter.write(writtenLine.getBytes(Charset.forName("UTF-8")));
//        String serverMessage = socketReader.readLine();
//        System.out.println(serverMessage);
        clientSocket.close();
     }
 }
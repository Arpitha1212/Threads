
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public void run() throws IOException {
        int port = 8080;
        InetAddress address = InetAddress.getByName("localhost");
        Socket serverSocket = new Socket(address,port);      
        PrintWriter toSocket = new PrintWriter(serverSocket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        toSocket.println("Hello from client! ");
        String line = fromSocket.readLine();
        System.out.println("Response from the socket: "+ line);
        serverSocket.close();
        toSocket.close();
        fromSocket.close();
        }
    public static void main(String[] args) {
        try {
            Client c = new Client();
            c.run();
        } catch (IOException ex) {
           ex.printStackTrace();    
        }
    }
}

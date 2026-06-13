
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run()throws IOException{
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
        while(true){ 
            try {
            System.out.println("server is listen for this port : "+ port);
            Socket acceptedConnection = serverSocket.accept();
            System.out.println("Connection accepted from client : " + acceptedConnection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("Hello from server...");
            toClient.close();
            fromClient.close();
            acceptedConnection.close();
              } catch (IOException e) {
                e.printStackTrace();
            }
           
        }
    }
    
    public static void main(String[] args){
        try {
            Server server = new Server();
            server.run();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

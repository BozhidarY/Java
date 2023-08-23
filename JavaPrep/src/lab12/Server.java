package lab12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4433)){
            while (true) {
                Socket client = serverSocket.accept();
                ClientResolver clientResolver = new ClientResolver(client);
                new Thread(clientResolver).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

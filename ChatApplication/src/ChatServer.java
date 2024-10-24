import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static int uniqueId = 0;
    private List<ClientHandler> clientList;
    private int port;

    public ChatServer(int port) {
        this.port = port;
        clientList = new ArrayList<>();
    }

    public static void main(String[] args) {
        int port = 3033;
        ChatServer server = new ChatServer(port);
        server.start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                
                ClientHandler clientHandler = new ClientHandler(socket, ++uniqueId);
                clientList.add(clientHandler);
                new Thread(clientHandler).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    synchronized void broadcast(String message, ClientHandler excludeClient) {
        for (ClientHandler client : clientList) {
            if (client != excludeClient) {
                client.sendMessage(message);
            }
        }
    }

    synchronized void removeClient(ClientHandler client) {
        clientList.remove(client);
        System.out.println("Client " + client.getId() + " disconnected");
    }

    // Inner class to handle each client
    class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter writer;
        private int id;
        private String userName;
        
        public ClientHandler(Socket socket, int id) {
            this.socket = socket;
            this.id = id;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                writer = new PrintWriter(socket.getOutputStream(), true);
                
                writer.println("Enter your username: ");
                userName = reader.readLine();
                broadcast(userName + " has joined the chat!", this);
                
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(userName + ": " + message, this);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                removeClient(this);
                broadcast(userName + " has left the chat.", this);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public int getId() {
            return id;
        }

        public void sendMessage(String message) {
            writer.println(message);
        }
    }
}

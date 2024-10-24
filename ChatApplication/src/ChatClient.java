import java.io.*;
import java.net.*;

public class ChatClient {
    private String serverName;
    private int serverPort;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    
    public ChatClient(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public void start() {
        try {
            socket = new Socket(serverName, serverPort);
            System.out.println("Connected to chat server");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            // Start thread to read messages from the server
            new Thread(new ReadMessages()).start();  
            
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter your messages: ");
            String message;
            while ((message = userInput.readLine()) != null) {
                // Send message to server
                writer.println(message);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handle incoming messages from the server
    class ReadMessages implements Runnable {
        @Override
        public void run() {
            try {
                String serverMessage;
                while ((serverMessage = reader.readLine()) != null) {
                    // Print received message
                    System.out.println(serverMessage);  
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String serverName = "localhost";
        int serverPort = 3033;
        
        ChatClient client = new ChatClient(serverName, serverPort);
        client.start();
    }
}

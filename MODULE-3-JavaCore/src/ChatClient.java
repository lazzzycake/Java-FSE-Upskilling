import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String serverIP = "localhost"; // Or use IP address if on different machines
        int port = 12345;

        try (Socket socket = new Socket(serverIP, port)) {
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            // Thread to read messages from server
            new Thread(() -> {
                String serverMsg;
                try {
                    while ((serverMsg = reader.readLine()) != null) {
                        System.out.println("Server: " + serverMsg);
                        System.out.print("You: ");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Loop to send messages to server
            String userMsg;
            while ((userMsg = consoleReader.readLine()) != null) {
                writer.println(userMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

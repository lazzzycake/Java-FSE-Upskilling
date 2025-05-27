import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 12345; // You can choose any free port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client to connect...");

            Socket socket = serverSocket.accept(); // Accepts client connection
            System.out.println("Client connected.");

            // Streams to read and write
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Read and respond in a loop
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Client: " + clientMessage);
                System.out.print("You: ");
                String reply = consoleReader.readLine();
                writer.println(reply);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

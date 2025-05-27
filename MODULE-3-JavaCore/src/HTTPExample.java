import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class HTTPExample {
    public static void main(String[] args) {
        // Create the HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create the request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com")) // Public GitHub API
            .GET()
            .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print status code and response body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:\n" + response.body());

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package testLLM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("evaluate the quality of CodeT5 model generation")
public class TestCodeT5 {
private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String API_URL = "http://localhost:5000/generate";

    @Test
    @DisplayName("evaluate the quality of CodeT5 model generation")
    void testModelGeneration() throws Exception {
        // 1. prepare for testing (For your Wukong tool's simple scenario)
        String testCode = "def add(a, b):";
        String jsonPayload = String.format("{\"code\": \"%s\"}", testCode);

        // 2. send requests
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // 3. assertions validation
        assertEquals(200, response.statusCode(), "API return 200 status code");
        assertNotNull(response.body(), "return content should not be null");
        assertTrue(response.body().contains("generated_code"), "response JSON should contain generated_code field");

        System.out.println("test result: " + response.body());
    }
}
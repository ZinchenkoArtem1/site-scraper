package ua.zinchenko.sitescraper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LeonBetAsyncHttpClient {

    private final HttpClient client = HttpClient.newBuilder()
            .build();

    public HttpResponse<String> sendGetRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.of(2, ChronoUnit.SECONDS))
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

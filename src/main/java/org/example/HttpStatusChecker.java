package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException, InterruptedException {
        String imageUrl = "https://http.cat/" + code + ".jpg";

        try {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(imageUrl))
                .GET()
                .build();

        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

        int responceStatusCode = response.statusCode();

        if (responceStatusCode == 404) {
            System.out.println("There is no image for HTTP status " + code);
        }
    } catch (IOException e) {
            try {
                throw new Exception("Error while checking for image availability: " + e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        return imageUrl;
    }
}
package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException, InterruptedException {
        String imageUrl = "https://http.cat/" + code + ".jpg";


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(imageUrl))
                .GET()
                .build();

        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

        int responceStatusCode = response.statusCode();

        if (responceStatusCode == 404) {
            throw new IOException("There is no picture for status code " + code);
        }

        return imageUrl;
    }
}
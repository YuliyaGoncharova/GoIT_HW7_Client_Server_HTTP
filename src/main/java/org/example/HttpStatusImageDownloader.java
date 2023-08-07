package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code){
        String imageUrl = null;
        try {
            imageUrl = new HttpStatusChecker().getStatusImage(code);
            try (InputStream in = new URL(imageUrl).openStream()) {
                Files.copy(in, Paths.get("./" + code + ".jpg"));
                System.out.println("The image for HTTP status " + code + " is downloaded successfully");
            } catch (IOException e) {
                System.out.println("Error downloading image: " + e.getMessage());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
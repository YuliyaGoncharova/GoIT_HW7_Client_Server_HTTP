package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code (or 'q' to quit):");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int code = scanner.nextInt();
                if (String.valueOf(code).length() == 3) {
                    new HttpStatusImageDownloader().downloadStatusImage(code);
                } else {
                    System.out.println("There is no image for HTTP status " + code);
                }
            } else if (scanner.hasNext("q")) {
                break;
            } else {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
        }
        scanner.close();
    }
}


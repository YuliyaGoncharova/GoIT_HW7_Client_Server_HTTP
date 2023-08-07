package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//                HttpStatusChecker checker = new HttpStatusChecker();
//                String statusImage = checker.getStatusImage(404);
//                System.out.println(statusImage);

//        System.out.println(new HttpStatusChecker().getStatusImage(288));

//          HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
//          downloader.downloadStatusImage(101);

        new HttpImageStatusCli().askStatus();
    }
}
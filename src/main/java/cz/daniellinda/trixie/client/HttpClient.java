package cz.daniellinda.trixie.client;

import cz.daniellinda.trixie.log.Logger;

import java.io.*;
import java.net.URL;

public class HttpClient {
    public static boolean download(String url) {
        byte[] dataBuffer = new byte[1024];
        int bytesRead;
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/cz/daniellinda/trixie/client/files/download.zip")) {
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            Logger.saveLog(e);
            return false;
        }
        return true;
    }
}

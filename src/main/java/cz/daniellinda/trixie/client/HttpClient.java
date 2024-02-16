package cz.daniellinda.trixie.client;

import cz.daniellinda.trixie.log.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

public class HttpClient {
    public static boolean download(String url) {
        HttpResponse response;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        String filePath = "src/main/java/cz/daniellinda/trixie/client/files/download.zip";
        int inByte;
        //Http request
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            response = client.execute(new HttpGet(url));
        } catch (IOException e) {
            Logger.saveLog(e);
            return false;
        }
        if (response.getStatusLine().getStatusCode() != 200) {
            Logger.saveLog(response.getStatusLine().getReasonPhrase());
            return false;
        }
        //Downloading the content
        try {
            bis = new BufferedInputStream(response.getEntity().getContent());
        } catch (IOException e) {
            Logger.saveLog(e);
            return false;
        }
        try {
            bos = new BufferedOutputStream(new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            Logger.saveLog(e);
            return false;
        }
        try {
            inByte = bis.read();
        } catch (IOException e) {
            Logger.saveLog(e);
            return false;
        }
        return true;
    }
}

package cz.daniellinda.trixie.client;

public class Service {
    public static void start(){
        System.out.println(HttpClient.download("https://www.smartform.cz/download/kopidlno.xml.zip"));
    }

}

package cz.daniellinda.trixie.client;

public class Service {
    public static void start() {
        if (HttpClient.download("https://www.smartform.cz/download/kopidlno.xml.zip"))
            if (Parser.unzip())
                Parser.parseXml();
    }
}

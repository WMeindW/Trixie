package cz.daniellinda.trixie.client;

import cz.daniellinda.trixie.log.Logger;

public class Service {
    public static void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Logger.saveLog("Shutting down");
        }));
        Logger.saveLog("Starting");
        if (HttpClient.download("https://www.smartform.cz/download/kopidlno.xml.zip")) {
            Logger.saveLog("Downloaded");
            if (Parser.unzip()) {
                Logger.saveLog("Unzipped");
                if (Parser.parseXml()) {
                    Logger.saveLog("Saved");
                }
            }
        }
    }
}

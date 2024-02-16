package cz.daniellinda.trixie.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Logger {
    public static void saveLog(String message) {
        File logFile = new File("src/main/java/cz/daniellinda/trixie/client/files/log.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.append("\n").append(LocalDateTime.now().toString()).append(" - ").append(message).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveLog(Exception e) {
        File logFile = new File("src/main/java/cz/daniellinda/trixie/client/files/log.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.append("\n").append(LocalDateTime.now().toString()).append(" - ").append(Arrays.toString(e.getStackTrace())).append(" ").append(e.getMessage()).append("\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

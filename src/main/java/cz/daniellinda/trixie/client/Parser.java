package cz.daniellinda.trixie.client;

import cz.daniellinda.trixie.log.Logger;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Parser {
    public static boolean unzip() {
        /*
            Code copied from digital ocean /tutorials
        */
        File dir = new File("src/main/java/cz/daniellinda/trixie/client/files/download/");
        if (!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream("src/main/java/cz/daniellinda/trixie/client/files/download.zip");
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String fileName = ze.getName();
                File newFile = new File("src/main/java/cz/daniellinda/trixie/client/files/download/" + File.separator + fileName);
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            Logger.saveLog(e);
            return false;
        }
        return true;
    }

    public static boolean parseXml() {
        return true;
    }
}

package cz.daniellinda.trixie.client;

import cz.daniellinda.trixie.database.CastObce;
import cz.daniellinda.trixie.database.Controller;
import cz.daniellinda.trixie.database.Obce;
import cz.daniellinda.trixie.log.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class Parser {
    private static String obceKod;

    public static boolean unzip() {
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
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File xmlFile = new File("src/main/java/cz/daniellinda/trixie/client/files/download/20210331_OB_573060_UZSZ.xml");
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Controller.saveObce(parseObce(doc));
            Controller.saveCastObce(parseCastObce(doc));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            Logger.saveLog(e);
            return false;
        }
        return true;
    }

    private static List<Obce> parseObce(Document doc) {
        NodeList obceNodes = doc.getElementsByTagName("vf:Obec");
        LinkedList<Obce> obce = new LinkedList<>();
        for (int i = 0; i < obceNodes.getLength(); i++) {
            Node obnode = obceNodes.item(i);
            Obce ob = new Obce();
            for (int j = 0; j < obnode.getChildNodes().getLength(); j++) {
                Node child = obnode.getChildNodes().item(j);
                if (child.getNodeName().equals("obi:Kod"))
                    ob.setKod(child.getTextContent());
                if (child.getNodeName().equals("obi:Nazev"))
                    ob.setNazev(child.getTextContent());
            }
            obceKod = ob.getKod();
            obce.add(ob);
        }
        return obce;
    }

    private static List<CastObce> parseCastObce(Document doc) {
        LinkedList<CastObce> castObce = new LinkedList<>();
        return castObce;
    }
}

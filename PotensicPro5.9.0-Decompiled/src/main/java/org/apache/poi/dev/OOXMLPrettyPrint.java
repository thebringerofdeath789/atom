package org.apache.poi.dev;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.util.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/* loaded from: classes4.dex */
public class OOXMLPrettyPrint {
    private final DocumentBuilder documentBuilder;
    private final DocumentBuilderFactory documentBuilderFactory;

    public OOXMLPrettyPrint() throws ParserConfigurationException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        this.documentBuilderFactory = newInstance;
        this.documentBuilder = newInstance.newDocumentBuilder();
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length <= 1 || strArr.length % 2 != 0) {
            System.err.println("Use:");
            System.err.println("\tjava OOXMLPrettyPrint [<filename> <outfilename>] ...");
            System.exit(1);
        }
        for (int i = 0; i < strArr.length; i += 2) {
            File file = new File(strArr[i]);
            if (!file.exists()) {
                System.err.println("Error, file not found!");
                System.err.println("\t" + file.toString());
                System.exit(2);
            }
            handleFile(file, new File(strArr[i + 1]));
        }
        System.out.println("Done.");
    }

    private static void handleFile(File file, File file2) throws ZipException, IOException, TransformerException, ParserConfigurationException {
        System.out.println("Reading zip-file " + file + " and writing pretty-printed XML to " + file2);
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            try {
                new OOXMLPrettyPrint().handle(zipFile, zipOutputStream);
            } finally {
                zipOutputStream.close();
            }
        } finally {
            zipFile.close();
            System.out.println();
        }
    }

    private void handle(ZipFile zipFile, ZipOutputStream zipOutputStream) throws IOException, TransformerException {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            zipOutputStream.putNextEntry(new ZipEntry(name));
            try {
                try {
                    if (!name.endsWith(".xml") && !name.endsWith(".rels")) {
                        System.out.println("Not pretty-printing non-XML file " + name);
                        IOUtils.copy(zipFile.getInputStream(nextElement), zipOutputStream);
                        zipOutputStream.closeEntry();
                        System.out.print(".");
                    }
                    pretty(this.documentBuilder.parse(new InputSource(zipFile.getInputStream(nextElement))), zipOutputStream, 2);
                    zipOutputStream.closeEntry();
                    System.out.print(".");
                } catch (Exception e) {
                    throw new IOException("While handling entry " + name, e);
                }
            } catch (Throwable th) {
                zipOutputStream.closeEntry();
                throw th;
            }
        }
    }

    private static void pretty(Document document, OutputStream outputStream, int i) throws TransformerException {
        Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
        newTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        if (i > 0) {
            newTransformer.setOutputProperty(OutputKeys.INDENT, BooleanUtils.YES);
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(i));
        }
        newTransformer.transform(new DOMSource(document), new StreamResult(outputStream));
    }
}

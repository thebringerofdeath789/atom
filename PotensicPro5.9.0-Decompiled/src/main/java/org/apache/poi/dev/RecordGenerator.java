package org.apache.poi.dev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Element;

/* loaded from: classes4.dex */
public class RecordGenerator {
    public static void main(String[] strArr) throws Exception {
        Class.forName("org.apache.poi.generator.FieldIterator");
        if (strArr.length != 4) {
            System.out.println("Usage:");
            System.out.println("  java org.apache.poi.hssf.util.RecordGenerator RECORD_DEFINTIONS RECORD_STYLES DEST_SRC_PATH TEST_SRC_PATH");
        } else {
            generateRecords(strArr[0], strArr[1], strArr[2], strArr[3]);
        }
    }

    private static void generateRecords(String str, String str2, String str3, String str4) throws Exception {
        File file = new File(str);
        int i = 0;
        int i2 = 0;
        while (i2 < file.listFiles().length) {
            File file2 = file.listFiles()[i2];
            if (file2.isFile() && (file2.getName().endsWith("_record.xml") || file2.getName().endsWith("_type.xml"))) {
                Element documentElement = XMLHelper.getDocumentBuilderFactory().newDocumentBuilder().parse(file2).getDocumentElement();
                String nodeValue = documentElement.getElementsByTagName("extends").item(i).getFirstChild().getNodeValue();
                String nodeValue2 = documentElement.getElementsByTagName("suffix").item(i).getFirstChild().getNodeValue();
                String nodeValue3 = documentElement.getAttributes().getNamedItem("name").getNodeValue();
                String replace = documentElement.getAttributes().getNamedItem("package").getNodeValue().replace('.', '/');
                String str5 = str3 + InternalZipConstants.ZIP_FILE_SEPARATOR + replace;
                new File(str5).mkdirs();
                String str6 = str5 + InternalZipConstants.ZIP_FILE_SEPARATOR + nodeValue3 + nodeValue2 + ".java";
                transform(file2, new File(str6), new File(str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + nodeValue.toLowerCase() + ".xsl"));
                System.out.println("Generated " + nodeValue2 + ": " + str6);
                String str7 = str4 + InternalZipConstants.ZIP_FILE_SEPARATOR + replace;
                new File(str7).mkdirs();
                String str8 = str7 + "/Test" + nodeValue3 + nodeValue2 + ".java";
                if (!new File(str8).exists()) {
                    transform(file2, new File(str8), new File(str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + nodeValue.toLowerCase() + "_test.xsl"));
                    System.out.println("Generated test: " + str8);
                } else {
                    System.out.println("Skipped test generation: " + str8);
                }
            }
            i2++;
            i = 0;
        }
    }

    private static void transform(File file, File file2, File file3) throws FileNotFoundException, TransformerException {
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new FileReader(file3)));
            Properties properties = new Properties();
            properties.setProperty("method", "text");
            newTransformer.setOutputProperties(properties);
            newTransformer.transform(new StreamSource(file), new StreamResult(file2));
        } catch (TransformerException e) {
            System.err.println("Error compiling XSL style sheet " + file3);
            throw e;
        }
    }
}

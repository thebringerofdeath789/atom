package repackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes6.dex */
public class EditBuildScript {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        strArr[0] = strArr[0].replace('/', File.separatorChar);
        File file = new File(strArr[0]);
        StringBuffer readFile = readFile(file);
        String stringBuffer = new StringBuffer().append("<property name=\"").append(strArr[1]).append("\" value=\"").toString();
        int indexOf = readFile.indexOf(stringBuffer);
        if (indexOf < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Can't find token: ").append(stringBuffer).toString());
        }
        int length = stringBuffer.length() + indexOf;
        while (readFile.charAt(length) != '\"') {
            length++;
        }
        readFile.replace(indexOf + stringBuffer.length(), length, strArr[2]);
        writeFile(file, readFile);
    }

    static StringBuffer readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        stringWriter.close();
        inputStreamReader.close();
        fileInputStream.close();
        return stringWriter.getBuffer();
    }

    static void writeFile(File file, StringBuffer stringBuffer) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        StringReader stringReader = new StringReader(stringBuffer.toString());
        copy(stringReader, outputStreamWriter);
        stringReader.close();
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    static void copy(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[16384];
        while (true) {
            int read = reader.read(cArr, 0, 16384);
            if (read < 0) {
                return;
            } else {
                writer.write(cArr, 0, read);
            }
        }
    }
}

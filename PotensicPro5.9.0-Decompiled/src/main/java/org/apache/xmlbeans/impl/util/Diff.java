package org.apache.xmlbeans.impl.util;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.List;

/* loaded from: classes5.dex */
public class Diff {
    public static void readersAsText(Reader reader, String str, Reader reader2, String str2, List list) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(reader);
        LineNumberReader lineNumberReader2 = new LineNumberReader(reader2);
        String readLine = lineNumberReader.readLine();
        String readLine2 = lineNumberReader2.readLine();
        while (true) {
            if (readLine == null || readLine2 == null) {
                break;
            }
            if (!readLine.equals(readLine2)) {
                list.add(new StringBuffer().append("File \"").append(str).append("\" and file \"").append(str2).append("\" differ at line ").append(lineNumberReader.getLineNumber()).append(":").append("\n").append(readLine).append("\n========\n").append(readLine2).toString());
                break;
            } else {
                readLine = lineNumberReader.readLine();
                readLine2 = lineNumberReader2.readLine();
            }
        }
        if (readLine == null && readLine2 != null) {
            list.add(new StringBuffer().append("File \"").append(str2).append("\" has extra lines at line ").append(lineNumberReader2.getLineNumber()).append(":\n").append(readLine2).toString());
        }
        if (readLine == null || readLine2 != null) {
            return;
        }
        list.add(new StringBuffer().append("File \"").append(str).append("\" has extra lines at line ").append(lineNumberReader.getLineNumber()).append(":\n").append(readLine).toString());
    }
}

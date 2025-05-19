package org.apache.xmlbeans.impl.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: classes5.dex */
public class SniffedXmlReader extends BufferedReader {
    public static int MAX_SNIFFED_CHARS = 192;
    private static Charset dummy1 = Charset.forName("UTF-8");
    private static Charset dummy2 = Charset.forName("UTF-16");
    private static Charset dummy3 = Charset.forName(CharEncoding.UTF_16BE);
    private static Charset dummy4 = Charset.forName("UTF-16LE");
    private static Charset dummy5 = Charset.forName("ISO-8859-1");
    private static Charset dummy6 = Charset.forName("US-ASCII");
    private static Charset dummy7 = Charset.forName("Cp1252");
    private String _encoding;

    public SniffedXmlReader(Reader reader) throws IOException {
        super(reader);
        this._encoding = sniffForXmlDecl();
    }

    private int readAsMuchAsPossible(char[] cArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = read(cArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    private String sniffForXmlDecl() throws IOException {
        mark(MAX_SNIFFED_CHARS);
        try {
            int i = MAX_SNIFFED_CHARS;
            char[] cArr = new char[i];
            return SniffedXmlInputStream.extractXmlDeclEncoding(cArr, 0, readAsMuchAsPossible(cArr, 0, i));
        } finally {
            reset();
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }
}

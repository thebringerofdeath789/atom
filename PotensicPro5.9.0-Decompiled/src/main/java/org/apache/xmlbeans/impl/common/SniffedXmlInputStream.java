package org.apache.xmlbeans.impl.common;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import javax.xml.transform.OutputKeys;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: classes5.dex */
public class SniffedXmlInputStream extends BufferedInputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static int MAX_SNIFFED_BYTES;
    private static char[] NOTNAME;
    private static char[] WHITESPACE;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$common$SniffedXmlInputStream;
    private static Charset dummy1;
    private static Charset dummy2;
    private static Charset dummy3;
    private static Charset dummy4;
    private static Charset dummy5;
    private static Charset dummy6;
    private static Charset dummy7;
    private String _encoding;

    static {
        if (class$org$apache$xmlbeans$impl$common$SniffedXmlInputStream == null) {
            class$org$apache$xmlbeans$impl$common$SniffedXmlInputStream = class$("org.apache.xmlbeans.impl.common.SniffedXmlInputStream");
        }
        $assertionsDisabled = true;
        MAX_SNIFFED_BYTES = 192;
        dummy1 = Charset.forName("UTF-8");
        dummy2 = Charset.forName("UTF-16");
        dummy3 = Charset.forName(CharEncoding.UTF_16BE);
        dummy4 = Charset.forName("UTF-16LE");
        dummy5 = Charset.forName("ISO-8859-1");
        dummy6 = Charset.forName("US-ASCII");
        dummy7 = Charset.forName("Cp1252");
        WHITESPACE = new char[]{' ', '\r', '\t', '\n'};
        NOTNAME = new char[]{'=', ' ', '\r', '\t', '\n', '?', Typography.greater, Typography.less, '\'', '\"'};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public SniffedXmlInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        String sniffForXmlDecl;
        String sniffFourBytes = sniffFourBytes();
        this._encoding = sniffFourBytes;
        if (sniffFourBytes != null && sniffFourBytes.equals("IBM037") && (sniffForXmlDecl = sniffForXmlDecl(this._encoding)) != null) {
            this._encoding = sniffForXmlDecl;
        }
        if (this._encoding == null) {
            this._encoding = sniffForXmlDecl("UTF-8");
        }
        if (this._encoding == null) {
            this._encoding = "UTF-8";
        }
    }

    private int readAsMuchAsPossible(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    private String sniffFourBytes() throws IOException {
        mark(4);
        try {
            byte[] bArr = new byte[4];
            if (readAsMuchAsPossible(bArr, 0, 4) < 4) {
                return null;
            }
            long j = ((-16777216) & (bArr[0] << 24)) | (16711680 & (bArr[1] << 16)) | (65280 & (bArr[2] << 8)) | (bArr[3] & 255);
            if (j == 65279) {
                return "UCS-4";
            }
            if (j == -131072) {
                return "UCS-4";
            }
            if (j == 60) {
                return "UCS-4BE";
            }
            if (j == 1006632960) {
                return "UCS-4LE";
            }
            if (j == 3932223) {
                return CharEncoding.UTF_16BE;
            }
            if (j == 1006649088) {
                return "UTF-16LE";
            }
            if (j == 1010792557) {
                return null;
            }
            if (j == 1282385812) {
                return "IBM037";
            }
            long j2 = (-65536) & j;
            if (j2 == -16842752) {
                return "UTF-16";
            }
            if (j2 == -131072) {
                return "UTF-16";
            }
            if ((j & (-256)) == -272908544) {
                return "UTF-8";
            }
            return null;
        } finally {
            reset();
        }
    }

    private String sniffForXmlDecl(String str) throws IOException {
        mark(MAX_SNIFFED_BYTES);
        try {
            int i = MAX_SNIFFED_BYTES;
            byte[] bArr = new byte[i];
            int readAsMuchAsPossible = readAsMuchAsPossible(bArr, 0, i);
            InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bArr, 0, readAsMuchAsPossible), Charset.forName(str));
            char[] cArr = new char[readAsMuchAsPossible];
            int i2 = 0;
            while (i2 < readAsMuchAsPossible) {
                int read = inputStreamReader.read(cArr, i2, readAsMuchAsPossible - i2);
                if (read < 0) {
                    break;
                }
                i2 += read;
            }
            return extractXmlDeclEncoding(cArr, 0, i2);
        } finally {
            reset();
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }

    static String extractXmlDeclEncoding(char[] cArr, int i, int i2) {
        int i3 = i2 + i;
        int firstIndexOf = firstIndexOf("<?xml", cArr, i, i3);
        if (firstIndexOf >= 0) {
            int i4 = firstIndexOf + 5;
            ScannedAttribute scannedAttribute = new ScannedAttribute();
            while (i4 < i3) {
                i4 = scanAttribute(cArr, i4, i3, scannedAttribute);
                if (i4 < 0) {
                    return null;
                }
                if (scannedAttribute.name.equals(OutputKeys.ENCODING)) {
                    return scannedAttribute.value;
                }
            }
        }
        return null;
    }

    private static int firstIndexOf(String str, char[] cArr, int i, int i2) {
        if (!$assertionsDisabled && str.length() <= 0) {
            throw new AssertionError();
        }
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        int length = i2 - charArray.length;
        while (i < length) {
            if (cArr[i] == c) {
                for (int i3 = 1; i3 < charArray.length; i3++) {
                    if (cArr[i + i3] != charArray[i3]) {
                        break;
                    }
                }
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000c, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int nextNonmatchingByte(char[] r3, char[] r4, int r5, int r6) {
        /*
        L0:
            if (r5 >= r6) goto L13
            char r0 = r4[r5]
            r1 = 0
        L5:
            int r2 = r3.length
            if (r1 >= r2) goto L12
            char r2 = r3[r1]
            if (r0 != r2) goto Lf
            int r5 = r5 + 1
            goto L0
        Lf:
            int r1 = r1 + 1
            goto L5
        L12:
            return r5
        L13:
            r3 = -1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.common.SniffedXmlInputStream.nextNonmatchingByte(char[], char[], int, int):int");
    }

    private static int nextMatchingByte(char[] cArr, char[] cArr2, int i, int i2) {
        while (i < i2) {
            char c = cArr2[i];
            for (char c2 : cArr) {
                if (c == c2) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    private static int nextMatchingByte(char c, char[] cArr, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static class ScannedAttribute {
        public String name;
        public String value;

        private ScannedAttribute() {
        }
    }

    private static int scanAttribute(char[] cArr, int i, int i2, ScannedAttribute scannedAttribute) {
        int nextMatchingByte;
        int nextNonmatchingByte;
        int i3;
        int nextMatchingByte2;
        int nextNonmatchingByte2 = nextNonmatchingByte(WHITESPACE, cArr, i, i2);
        if (nextNonmatchingByte2 < 0 || (nextMatchingByte = nextMatchingByte(NOTNAME, cArr, nextNonmatchingByte2, i2)) < 0 || (nextNonmatchingByte = nextNonmatchingByte(WHITESPACE, cArr, nextMatchingByte, i2)) < 0 || cArr[nextNonmatchingByte] != '=') {
            return -1;
        }
        int nextNonmatchingByte3 = nextNonmatchingByte(WHITESPACE, cArr, nextNonmatchingByte + 1, i2);
        if ((cArr[nextNonmatchingByte3] != '\'' && cArr[nextNonmatchingByte3] != '\"') || (nextMatchingByte2 = nextMatchingByte(cArr[nextNonmatchingByte3], cArr, (i3 = nextNonmatchingByte3 + 1), i2)) < 0) {
            return -1;
        }
        scannedAttribute.name = new String(cArr, nextNonmatchingByte2, nextMatchingByte - nextNonmatchingByte2);
        scannedAttribute.value = new String(cArr, i3, (nextMatchingByte2 - nextNonmatchingByte3) - 1);
        return nextMatchingByte2 + 1;
    }
}

package com.bea.xml.stream.reader;

import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.util.Hashtable;
import javax.xml.transform.OutputKeys;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes.dex */
public final class XmlReader extends Reader {
    private static final int MAXPUSHBACK = 512;
    private static final Hashtable charsets;
    private String assignedEncoding;
    private boolean closed;

    /* renamed from: in */
    private Reader f1793in;

    public static Reader createReader(InputStream inputStream) throws IOException {
        return new XmlReader(inputStream);
    }

    public static Reader createReader(InputStream inputStream, String str) throws IOException {
        if (str == null) {
            return new XmlReader(inputStream);
        }
        if ("UTF-8".equalsIgnoreCase(str) || InternalZipConstants.CHARSET_UTF8.equalsIgnoreCase(str)) {
            return new Utf8Reader(inputStream);
        }
        if ("US-ASCII".equalsIgnoreCase(str) || "ASCII".equalsIgnoreCase(str)) {
            return new AsciiReader(inputStream);
        }
        if ("ISO-8859-1".equalsIgnoreCase(str)) {
            return new Iso8859_1Reader(inputStream);
        }
        return new InputStreamReader(inputStream, std2java(str));
    }

    static {
        Hashtable hashtable = new Hashtable(31);
        charsets = hashtable;
        hashtable.put("UTF-16", "Unicode");
        hashtable.put("ISO-10646-UCS-2", "Unicode");
        hashtable.put("EBCDIC-CP-US", "cp037");
        hashtable.put("EBCDIC-CP-CA", "cp037");
        hashtable.put("EBCDIC-CP-NL", "cp037");
        hashtable.put("EBCDIC-CP-WT", "cp037");
        hashtable.put("EBCDIC-CP-DK", "cp277");
        hashtable.put("EBCDIC-CP-NO", "cp277");
        hashtable.put("EBCDIC-CP-FI", "cp278");
        hashtable.put("EBCDIC-CP-SE", "cp278");
        hashtable.put("EBCDIC-CP-IT", "cp280");
        hashtable.put("EBCDIC-CP-ES", "cp284");
        hashtable.put("EBCDIC-CP-GB", "cp285");
        hashtable.put("EBCDIC-CP-FR", "cp297");
        hashtable.put("EBCDIC-CP-AR1", "cp420");
        hashtable.put("EBCDIC-CP-HE", "cp424");
        hashtable.put("EBCDIC-CP-BE", "cp500");
        hashtable.put("EBCDIC-CP-CH", "cp500");
        hashtable.put("EBCDIC-CP-ROECE", "cp870");
        hashtable.put("EBCDIC-CP-YU", "cp870");
        hashtable.put("EBCDIC-CP-IS", "cp871");
        hashtable.put("EBCDIC-CP-AR2", "cp918");
    }

    private static String std2java(String str) {
        String str2 = (String) charsets.get(str.toUpperCase());
        return str2 != null ? str2 : str;
    }

    public String getEncoding() {
        return this.assignedEncoding;
    }

    private XmlReader(InputStream inputStream) throws IOException {
        super(inputStream);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 512);
        byte[] bArr = new byte[4];
        int read = pushbackInputStream.read(bArr);
        if (read > 0) {
            pushbackInputStream.unread(bArr, 0, read);
        }
        if (read == 4) {
            int i = bArr[0] & 255;
            if (i != 0) {
                if (i == 60) {
                    int i2 = bArr[1] & 255;
                    if (i2 == 0) {
                        if (bArr[2] == 63 && bArr[3] == 0) {
                            setEncoding(pushbackInputStream, "UnicodeLittle");
                            return;
                        }
                    } else if (i2 == 63 && bArr[2] == 120 && bArr[3] == 109) {
                        useEncodingDecl(pushbackInputStream, InternalZipConstants.CHARSET_UTF8);
                        return;
                    }
                } else if (i != 76) {
                    if (i == 254) {
                        if ((bArr[1] & 255) == 255) {
                            setEncoding(pushbackInputStream, "UTF-16");
                            return;
                        }
                    } else if (i == 255 && (bArr[1] & 255) == 254) {
                        setEncoding(pushbackInputStream, "UTF-16");
                        return;
                    }
                } else if (bArr[1] == 111 && (bArr[2] & 255) == 167 && (bArr[3] & 255) == 148) {
                    useEncodingDecl(pushbackInputStream, "CP037");
                    return;
                }
            } else if (bArr[1] == 60 && bArr[2] == 0 && bArr[3] == 63) {
                setEncoding(pushbackInputStream, "UnicodeBig");
                return;
            }
        }
        setEncoding(pushbackInputStream, "UTF-8");
    }

    private void useEncodingDecl(PushbackInputStream pushbackInputStream, String str) throws IOException {
        int read;
        byte[] bArr = new byte[512];
        int i = 0;
        int read2 = pushbackInputStream.read(bArr, 0, 512);
        pushbackInputStream.unread(bArr, 0, read2);
        InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bArr, 4, read2), str);
        if (inputStreamReader.read() != 108) {
            setEncoding(pushbackInputStream, "UTF-8");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 0;
        String str2 = null;
        StringBuffer stringBuffer2 = null;
        while (true) {
            if (i2 >= 507 || (read = inputStreamReader.read()) == -1) {
                break;
            }
            if (read != 32 && read != 9 && read != 10 && read != 13) {
                if (i2 == 0) {
                    break;
                }
                if (read == 63) {
                    i3 = 1;
                } else if (i3 != 0) {
                    if (read == 62) {
                        break;
                    } else {
                        i3 = i;
                    }
                }
                if (str2 != null && i4 != 0) {
                    char c2 = (char) read;
                    if (Character.isWhitespace(c2)) {
                        continue;
                    } else {
                        if (read == 34 || read == 39) {
                            if (c == 0) {
                                stringBuffer.setLength(i);
                                c = c2;
                            } else if (read == c) {
                                if (OutputKeys.ENCODING.equals(str2)) {
                                    this.assignedEncoding = stringBuffer.toString();
                                    while (i < this.assignedEncoding.length()) {
                                        char charAt = this.assignedEncoding.charAt(i);
                                        if ((charAt >= 'A' && charAt <= 'Z') || ((charAt >= 'a' && charAt <= 'z') || (i != 0 && i > 0 && (charAt == '-' || ((charAt >= '0' && charAt <= '9') || charAt == '.' || charAt == '_'))))) {
                                            i++;
                                        }
                                    }
                                    setEncoding(pushbackInputStream, this.assignedEncoding);
                                    return;
                                }
                                str2 = null;
                            }
                        }
                        stringBuffer.append(c2);
                    }
                } else if (stringBuffer2 == null) {
                    char c3 = (char) read;
                    if (!Character.isWhitespace(c3)) {
                        stringBuffer.setLength(i);
                        stringBuffer.append(c3);
                        stringBuffer2 = stringBuffer;
                        i4 = i;
                    }
                } else {
                    char c4 = (char) read;
                    if (Character.isWhitespace(c4)) {
                        str2 = stringBuffer2.toString();
                    } else if (read == 61) {
                        if (str2 == null) {
                            str2 = stringBuffer2.toString();
                        }
                        stringBuffer2 = null;
                        i4 = 1;
                        c = 0;
                    } else {
                        stringBuffer2.append(c4);
                    }
                }
            }
            i2++;
            i = 0;
        }
        setEncoding(pushbackInputStream, "UTF-8");
    }

    private void setEncoding(InputStream inputStream, String str) throws IOException {
        this.assignedEncoding = str;
        this.f1793in = createReader(inputStream, str);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        if (this.closed) {
            return -1;
        }
        int read = this.f1793in.read(cArr, i, i2);
        if (read == -1) {
            close();
        }
        return read;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
        int read = this.f1793in.read();
        if (read == -1) {
            close();
        }
        return read;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        Reader reader = this.f1793in;
        if (reader == null) {
            return false;
        }
        return reader.markSupported();
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        Reader reader = this.f1793in;
        if (reader != null) {
            reader.mark(i);
        }
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        Reader reader = this.f1793in;
        if (reader != null) {
            reader.reset();
        }
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        Reader reader = this.f1793in;
        if (reader == null) {
            return 0L;
        }
        return reader.skip(j);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.f1793in;
        if (reader == null) {
            return false;
        }
        return reader.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.f1793in.close();
        this.f1793in = null;
        this.closed = true;
    }

    public static abstract class BaseReader extends Reader {
        protected byte[] buffer;
        protected int finish;
        protected InputStream instream;
        protected int start;

        public abstract String getEncoding();

        BaseReader(InputStream inputStream) {
            super(inputStream);
            this.instream = inputStream;
            this.buffer = new byte[8192];
        }

        @Override // java.io.Reader
        public boolean ready() throws IOException {
            InputStream inputStream = this.instream;
            return inputStream == null || this.finish - this.start > 0 || inputStream.available() != 0;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.instream;
            if (inputStream != null) {
                inputStream.close();
                this.finish = 0;
                this.start = 0;
                this.buffer = null;
                this.instream = null;
            }
        }
    }

    static final class Utf8Reader extends BaseReader {
        private char nextChar;

        @Override // com.bea.xml.stream.reader.XmlReader.BaseReader
        public String getEncoding() {
            return "UTF-8";
        }

        Utf8Reader(InputStream inputStream) {
            super(inputStream);
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x0148 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0183 A[SYNTHETIC] */
        @Override // java.io.Reader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int read(char[] r10, int r11, int r12) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 454
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bea.xml.stream.reader.XmlReader.Utf8Reader.read(char[], int, int):int");
        }
    }

    static final class AsciiReader extends BaseReader {
        @Override // com.bea.xml.stream.reader.XmlReader.BaseReader
        public String getEncoding() {
            return "US-ASCII";
        }

        AsciiReader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.instream == null) {
                return -1;
            }
            if (i + i2 > cArr.length || i < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.finish - this.start;
            if (i3 < 1) {
                this.start = 0;
                this.finish = this.instream.read(this.buffer, 0, this.buffer.length);
                if (this.finish <= 0) {
                    close();
                    return -1;
                }
                if (i2 > this.finish) {
                    i2 = this.finish;
                }
            } else if (i2 > i3) {
                i2 = i3;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr = this.buffer;
                int i5 = this.start;
                this.start = i5 + 1;
                byte b = bArr[i5];
                if (b < 0) {
                    throw new CharConversionException(new StringBuffer().append("Illegal ASCII character, 0x").append(Integer.toHexString(b & 255)).toString());
                }
                cArr[i + i4] = (char) b;
            }
            return i2;
        }
    }

    static final class Iso8859_1Reader extends BaseReader {
        @Override // com.bea.xml.stream.reader.XmlReader.BaseReader
        public String getEncoding() {
            return "ISO-8859-1";
        }

        Iso8859_1Reader(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.instream == null) {
                return -1;
            }
            if (i + i2 > cArr.length || i < 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.finish - this.start;
            if (i3 < 1) {
                this.start = 0;
                this.finish = this.instream.read(this.buffer, 0, this.buffer.length);
                if (this.finish <= 0) {
                    close();
                    return -1;
                }
                if (i2 > this.finish) {
                    i2 = this.finish;
                }
            } else if (i2 > i3) {
                i2 = i3;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr = this.buffer;
                int i5 = this.start;
                this.start = i5 + 1;
                cArr[i + i4] = (char) (bArr[i5] & 255);
            }
            return i2;
        }
    }
}
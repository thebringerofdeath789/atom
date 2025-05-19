package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.IOException;
import java.io.Reader;
import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;

/* loaded from: classes5.dex */
public final class XMLReaderReader extends XMLInputReader {
    private static final int BUFFER_SIZE = 8192;
    private char[] cbuf;
    private int cbufEnd;
    private int cbufPos;
    private boolean eofReached;
    private Reader in;
    private char[] oneCharBuf;
    private boolean rewindDeclaration;
    private boolean sawCR;

    @Override // java.io.Reader
    public boolean markSupported() {
        return false;
    }

    public XMLReaderReader() {
        this.cbuf = new char[8192];
        this.cbufPos = 0;
        this.cbufEnd = 0;
        this.eofReached = false;
        this.sawCR = false;
        this.oneCharBuf = new char[1];
    }

    public XMLReaderReader(Reader reader) throws IOException {
        this(reader, true);
    }

    public XMLReaderReader(Reader reader, boolean z) throws IOException {
        this.cbuf = new char[8192];
        this.cbufPos = 0;
        this.cbufEnd = 0;
        this.eofReached = false;
        this.sawCR = false;
        this.oneCharBuf = new char[1];
        reset(reader, z);
    }

    public void reset(Reader reader, boolean z) throws IOException {
        super.resetInput();
        this.in = reader;
        this.rewindDeclaration = z;
        this.cbufEnd = 0;
        this.cbufPos = 0;
        this.sawCR = false;
        this.eofReached = false;
        fillCharBuffer();
        processXMLDecl();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.eofReached = true;
        this.cbufEnd = 0;
        this.cbufPos = 0;
        Reader reader = this.in;
        if (reader != null) {
            reader.close();
        }
    }

    @Override // java.io.Reader
    public void mark(int i) throws IOException {
        throw new UnsupportedOperationException("mark() not supported");
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int read = read(this.oneCharBuf, 0, 1);
        return read <= 0 ? read : this.oneCharBuf[0];
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = this.cbufPos;
            if (i5 < this.cbufEnd) {
                char[] cArr2 = this.cbuf;
                this.cbufPos = i5 + 1;
                char c = cArr2[i5];
                if (c < ' ') {
                    if (c == '\t') {
                        i3 = i4 + 1;
                        cArr[i4 + i] = '\t';
                    } else if (c != '\n') {
                        if (c == '\r') {
                            this.sawCR = true;
                            i3 = i4 + 1;
                            cArr[i4 + i] = '\n';
                        } else {
                            throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(c)).toString());
                        }
                    } else if (this.sawCR) {
                        this.sawCR = false;
                    } else {
                        i3 = i4 + 1;
                        cArr[i4 + i] = '\n';
                    }
                    i4 = i3;
                } else if (c <= 55295 || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535))) {
                    this.sawCR = false;
                    cArr[i4 + i] = c;
                    i4++;
                } else {
                    throw new IllegalCharException(new StringBuffer().append("Illegal XML Character: 0x").append(Integer.toHexString(c)).toString());
                }
            } else {
                if (this.eofReached || (i4 != 0 && !this.in.ready())) {
                    break;
                }
                fillCharBuffer();
            }
        }
        if (i4 == 0 && this.eofReached) {
            return -1;
        }
        return i4;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.cbufEnd - this.cbufPos > 0 || this.in.ready();
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        super.resetInput();
        this.in.reset();
        this.cbufEnd = 0;
        this.cbufPos = 0;
        this.sawCR = false;
        this.eofReached = false;
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        int i = 0;
        while (i < j) {
            int i2 = this.cbufPos;
            if (i2 < this.cbufEnd) {
                char[] cArr = this.cbuf;
                this.cbufPos = i2 + 1;
                char c = cArr[i2];
                if (c >= ' ') {
                    if (c <= 55295 || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535))) {
                        this.sawCR = false;
                    } else {
                        throw new IllegalCharException(new StringBuffer().append("Illegal XML Character: 0x").append(Integer.toHexString(c)).toString());
                    }
                } else if (c != '\t') {
                    if (c != '\n') {
                        if (c == '\r') {
                            this.sawCR = true;
                        } else {
                            throw new IllegalCharException(new StringBuffer().append("Illegal XML character: 0x").append(Integer.toHexString(c)).toString());
                        }
                    } else if (this.sawCR) {
                        this.sawCR = false;
                    }
                }
                i++;
            } else {
                if (this.eofReached) {
                    break;
                }
                fillCharBuffer();
            }
        }
        if (i == 0 && this.eofReached) {
            i = -1;
        }
        return i;
    }

    private void fillCharBuffer() throws IOException {
        this.cbufPos = 0;
        int read = this.in.read(this.cbuf, 0, 8192);
        this.cbufEnd = read;
        if (read <= 0) {
            this.eofReached = true;
        }
    }

    private void processXMLDecl() throws IOException {
        int parseXMLDeclaration = parseXMLDeclaration(this.cbuf, 0, this.cbufEnd);
        if (parseXMLDeclaration <= 0 || this.rewindDeclaration) {
            return;
        }
        this.cbufPos += parseXMLDeclaration;
    }
}

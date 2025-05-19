package org.apache.commons.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes4.dex */
final class ExtendedBufferedReader extends BufferedReader {
    private boolean closed;
    private long eolCounter;
    private int lastChar;
    private long position;

    ExtendedBufferedReader(Reader reader) {
        super(reader);
        this.lastChar = -2;
    }

    @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.lastChar = -1;
        super.close();
    }

    long getCurrentLineNumber() {
        int i = this.lastChar;
        if (i == 13 || i == 10 || i == -2 || i == -1) {
            return this.eolCounter;
        }
        return this.eolCounter + 1;
    }

    int getLastChar() {
        return this.lastChar;
    }

    long getPosition() {
        return this.position;
    }

    public boolean isClosed() {
        return this.closed;
    }

    int lookAhead() throws IOException {
        super.mark(1);
        int read = super.read();
        super.reset();
        return read;
    }

    char[] lookAhead(char[] cArr) throws IOException {
        int length = cArr.length;
        super.mark(length);
        super.read(cArr, 0, length);
        super.reset();
        return cArr;
    }

    char[] lookAhead(int i) throws IOException {
        return lookAhead(new char[i]);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        int i;
        int read = super.read();
        if (read == 13 || ((read == 10 && this.lastChar != 13) || (read == -1 && (i = this.lastChar) != 13 && i != 10 && i != -1))) {
            this.eolCounter++;
        }
        this.lastChar = read;
        this.position++;
        return read;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        int read = super.read(cArr, i, i2);
        if (read > 0) {
            int i4 = i;
            while (true) {
                i3 = i + read;
                if (i4 >= i3) {
                    break;
                }
                char c = cArr[i4];
                if (c == '\n') {
                    if (13 != (i4 > i ? cArr[i4 - 1] : this.lastChar)) {
                        this.eolCounter++;
                    }
                } else if (c == '\r') {
                    this.eolCounter++;
                }
                i4++;
            }
            this.lastChar = cArr[i3 - 1];
        } else if (read == -1) {
            this.lastChar = -1;
        }
        this.position += read;
        return read;
    }

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        if (lookAhead() == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = read();
            if (read == 13 && lookAhead() == 10) {
                read();
            }
            if (read == -1 || read == 10 || read == 13) {
                break;
            }
            sb.append((char) read);
        }
        return sb.toString();
    }
}

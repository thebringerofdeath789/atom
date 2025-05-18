package com.opencsv.stream.reader;

import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class LineReader {
    private final boolean keepCarriageReturns;
    private final BufferedReader reader;

    public LineReader(BufferedReader bufferedReader, boolean z) {
        this.reader = bufferedReader;
        this.keepCarriageReturns = z;
    }

    public String readLine() throws IOException {
        return this.keepCarriageReturns ? readUntilNewline() : this.reader.readLine();
    }

    private String readUntilNewline() throws IOException {
        StringBuilder sb = new StringBuilder(1024);
        while (true) {
            int read = this.reader.read();
            if (read <= -1 || read == 10) {
                break;
            }
            sb.append((char) read);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
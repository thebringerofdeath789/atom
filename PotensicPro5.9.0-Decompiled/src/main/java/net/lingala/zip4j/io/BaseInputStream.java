package net.lingala.zip4j.io;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.unzip.UnzipEngine;

/* loaded from: classes4.dex */
public abstract class BaseInputStream extends InputStream {
    @Override // java.io.InputStream
    public int available() throws IOException {
        return 0;
    }

    public UnzipEngine getUnzipEngine() {
        return null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return 0;
    }

    public void seek(long j) throws IOException {
    }
}

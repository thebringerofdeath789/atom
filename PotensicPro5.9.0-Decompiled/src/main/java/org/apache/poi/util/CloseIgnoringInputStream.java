package org.apache.poi.util;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class CloseIgnoringInputStream extends FilterInputStream {
    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public CloseIgnoringInputStream(InputStream inputStream) {
        super(inputStream);
    }
}

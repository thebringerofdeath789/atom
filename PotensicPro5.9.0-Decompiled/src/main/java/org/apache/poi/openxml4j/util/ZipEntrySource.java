package org.apache.poi.openxml4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* loaded from: classes5.dex */
public interface ZipEntrySource {
    void close() throws IOException;

    Enumeration<? extends ZipEntry> getEntries();

    InputStream getInputStream(ZipEntry zipEntry) throws IOException;
}

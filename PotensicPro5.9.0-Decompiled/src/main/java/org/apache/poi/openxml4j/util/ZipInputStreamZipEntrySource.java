package org.apache.poi.openxml4j.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes5.dex */
public class ZipInputStreamZipEntrySource implements ZipEntrySource {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ArrayList<FakeZipEntry> zipEntries = new ArrayList<>();

    public ZipInputStreamZipEntrySource(ZipInputStream zipInputStream) throws IOException {
        boolean z = true;
        while (z) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                z = false;
            } else {
                FakeZipEntry fakeZipEntry = new FakeZipEntry(nextEntry, zipInputStream);
                zipInputStream.closeEntry();
                this.zipEntries.add(fakeZipEntry);
            }
        }
        zipInputStream.close();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public Enumeration<? extends ZipEntry> getEntries() {
        return new EntryEnumerator();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public InputStream getInputStream(ZipEntry zipEntry) {
        return ((FakeZipEntry) zipEntry).getInputStream();
    }

    @Override // org.apache.poi.openxml4j.util.ZipEntrySource
    public void close() {
        this.zipEntries = null;
    }

    private class EntryEnumerator implements Enumeration<ZipEntry> {
        private Iterator<? extends ZipEntry> iterator;

        private EntryEnumerator() {
            this.iterator = ZipInputStreamZipEntrySource.this.zipEntries.iterator();
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Enumeration
        public ZipEntry nextElement() {
            return this.iterator.next();
        }
    }

    public static class FakeZipEntry extends ZipEntry {
        private byte[] data;

        public FakeZipEntry(ZipEntry zipEntry, ZipInputStream zipInputStream) throws IOException {
            super(zipEntry.getName());
            ByteArrayOutputStream byteArrayOutputStream;
            long size = zipEntry.getSize();
            if (size == -1) {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } else {
                if (size >= 2147483647L) {
                    throw new IOException("ZIP entry size is too large");
                }
                byteArrayOutputStream = new ByteArrayOutputStream((int) size);
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = zipInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    this.data = byteArrayOutputStream.toByteArray();
                    return;
                }
            }
        }

        public InputStream getInputStream() {
            return new ByteArrayInputStream(this.data);
        }
    }
}

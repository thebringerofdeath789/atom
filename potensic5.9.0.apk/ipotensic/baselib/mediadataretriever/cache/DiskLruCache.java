package com.ipotensic.baselib.mediadataretriever.cache;

import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final int IO_BUFFER_SIZE = 8192;
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_TMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final File directory;
    private final File journalFile;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    private long size = 0;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> cleanupCallable = new Callable<Void>() { // from class: com.ipotensic.baselib.mediadataretriever.cache.DiskLruCache.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                    return null;
                }
                DiskLruCache.this.trimToSize();
                if (DiskLruCache.this.journalRebuildRequired()) {
                    DiskLruCache.this.rebuildJournal();
                    DiskLruCache.this.redundantOpCount = 0;
                }
                return null;
            }
        }
    };

    private static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        System.arraycopy(tArr, i, tArr2, 0, min);
        return tArr2;
    }

    public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    return stringWriter.toString();
                }
            }
        } finally {
            reader.close();
        }
    }

    public static String readAsciiLine(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read != 10) {
                sb.append((char) read);
            } else {
                int length = sb.length();
                if (length > 0) {
                    int i = length - 1;
                    if (sb.charAt(i) == '\r') {
                        sb.setLength(i);
                    }
                }
                return sb.toString();
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void deleteContents(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IllegalArgumentException("not a directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TMP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
        if (diskLruCache.journalFile.exists()) {
            try {
                diskLruCache.readJournal();
                diskLruCache.processJournal();
                diskLruCache.journalWriter = new BufferedWriter(new FileWriter(diskLruCache.journalFile, true), 8192);
                return diskLruCache;
            } catch (IOException unused) {
                diskLruCache.delete();
            }
        }
        file.mkdirs();
        DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
        diskLruCache2.rebuildJournal();
        return diskLruCache2;
    }

    private void readJournal() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.journalFile), 8192);
        try {
            String readAsciiLine = readAsciiLine(bufferedInputStream);
            String readAsciiLine2 = readAsciiLine(bufferedInputStream);
            String readAsciiLine3 = readAsciiLine(bufferedInputStream);
            String readAsciiLine4 = readAsciiLine(bufferedInputStream);
            String readAsciiLine5 = readAsciiLine(bufferedInputStream);
            if (!MAGIC.equals(readAsciiLine) || !"1".equals(readAsciiLine2) || !Integer.toString(this.appVersion).equals(readAsciiLine3) || !Integer.toString(this.valueCount).equals(readAsciiLine4) || !"".equals(readAsciiLine5)) {
                throw new IOException("unexpected journal header: [" + readAsciiLine + ", " + readAsciiLine2 + ", " + readAsciiLine4 + ", " + readAsciiLine5 + "]");
            }
            while (true) {
                try {
                    readJournalLine(readAsciiLine(bufferedInputStream));
                } catch (EOFException unused) {
                    return;
                }
            }
        } finally {
            closeQuietly(bufferedInputStream);
        }
    }

    private void readJournalLine(String str) throws IOException {
        String[] split = str.split(StringUtils.SPACE);
        if (split.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = split[1];
        if (split[0].equals(REMOVE) && split.length == 2) {
            this.lruEntries.remove(str2);
            return;
        }
        Entry entry = this.lruEntries.get(str2);
        if (entry == null) {
            entry = new Entry(str2);
            this.lruEntries.put(str2, entry);
        }
        if (!split[0].equals(CLEAN) || split.length != this.valueCount + 2) {
            if (!split[0].equals(DIRTY) || split.length != 2) {
                if (!split[0].equals(READ) || split.length != 2) {
                    throw new IOException("unexpected journal line: " + str);
                }
                return;
            }
            entry.currentEditor = new Editor(entry);
            return;
        }
        entry.readable = true;
        entry.currentEditor = null;
        entry.setLengths((String[]) copyOfRange(split, 2, split.length));
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(next.getCleanFile(i));
                    deleteIfExists(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        Writer writer = this.journalWriter;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.journalFileTmp), 8192);
        bufferedWriter.write(MAGIC);
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.appVersion));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.valueCount));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (Entry entry : this.lruEntries.values()) {
            if (entry.currentEditor != null) {
                bufferedWriter.write("DIRTY " + entry.key + '\n');
            } else {
                bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
            }
        }
        bufferedWriter.close();
        this.journalFileTmp.renameTo(this.journalFile);
        this.journalWriter = new BufferedWriter(new FileWriter(this.journalFile, true), 8192);
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.valueCount];
        for (int i = 0; i < this.valueCount; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(entry.getCleanFile(i));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((CharSequence) ("READ " + str + '\n'));
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new Snapshot(str, entry.sequenceNumber, inputStreamArr);
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor edit(String str, long j) throws IOException {
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(str);
            this.lruEntries.put(str, entry);
        } else if (entry.currentEditor != null) {
            return null;
        }
        Editor editor = new Editor(entry);
        entry.currentEditor = editor;
        this.journalWriter.write("DIRTY " + str + '\n');
        this.journalWriter.flush();
        return editor;
    }

    public File getDirectory() {
        return this.directory;
    }

    public long maxSize() {
        return this.maxSize;
    }

    public synchronized long size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new IllegalStateException();
        }
        if (z && !entry.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!entry.getDirtyFile(i).exists()) {
                    editor.abort();
                    throw new IllegalStateException("edit didn't create file " + i);
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            File dirtyFile = entry.getDirtyFile(i2);
            if (z) {
                if (dirtyFile.exists()) {
                    File cleanFile = entry.getCleanFile(i2);
                    dirtyFile.renameTo(cleanFile);
                    long j = entry.lengths[i2];
                    long length = cleanFile.length();
                    entry.lengths[i2] = length;
                    this.size = (this.size - j) + length;
                }
            } else {
                deleteIfExists(dirtyFile);
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable | z) {
            entry.readable = true;
            this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.write("REMOVE " + entry.key + '\n');
        }
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.currentEditor == null) {
            for (int i = 0; i < this.valueCount; i++) {
                File cleanFile = entry.getCleanFile(i);
                if (!cleanFile.delete()) {
                    throw new IOException("failed to delete " + cleanFile);
                }
                this.size -= entry.lengths[i];
                entry.lengths[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((CharSequence) ("REMOVE " + str + '\n'));
            this.lruEntries.remove(str);
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return true;
        }
        return false;
    }

    public boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.journalWriter == null) {
            return;
        }
        Iterator it = new ArrayList(this.lruEntries.values()).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
        }
        trimToSize();
        this.journalWriter.close();
        this.journalWriter = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    public void delete() throws IOException {
        close();
        deleteContents(this.directory);
    }

    private void validateKey(String str) {
        if (str.contains(StringUtils.SPACE) || str.contains("\n") || str.contains(StringUtils.CR)) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return readFully(new InputStreamReader(inputStream, UTF_8));
    }

    public final class Snapshot implements Closeable {
        private final InputStream[] ins;
        private final String key;
        private final long sequenceNumber;

        private Snapshot(String str, long j, InputStream[] inputStreamArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.ins = inputStreamArr;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.inputStreamToString(getInputStream(i));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.ins) {
                DiskLruCache.closeQuietly(inputStream);
            }
        }
    }

    public final class Editor {
        private final Entry entry;
        private boolean hasErrors;

        private Editor(Entry entry) {
            this.entry = entry;
        }

        public InputStream newInputStream(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    return null;
                }
                return new FileInputStream(this.entry.getCleanFile(i));
            }
        }

        public String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public OutputStream newOutputStream(int i) throws IOException {
            FaultHidingOutputStream faultHidingOutputStream;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                faultHidingOutputStream = new FaultHidingOutputStream(new FileOutputStream(this.entry.getDirtyFile(i)));
            }
            return faultHidingOutputStream;
        }

        public void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i), DiskLruCache.UTF_8);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                DiskLruCache.closeQuietly(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                DiskLruCache.closeQuietly(outputStreamWriter2);
                throw th;
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
        }

        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    Editor.this.hasErrors = true;
                }
            }
        }
    }

    private final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        public String getLengths() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.lengths) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File getCleanFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + "." + i);
        }

        public File getDirtyFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + "." + i + DiskFileUpload.postfix);
        }
    }
}
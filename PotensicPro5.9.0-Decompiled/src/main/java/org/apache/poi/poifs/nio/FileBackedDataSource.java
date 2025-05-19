package org.apache.poi.poifs.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.util.IOUtils;

/* loaded from: classes5.dex */
public class FileBackedDataSource extends DataSource {
    private FileChannel channel;
    private RandomAccessFile srcFile;
    private boolean writable;

    public FileBackedDataSource(File file) throws FileNotFoundException {
        this(newSrcFile(file, InternalZipConstants.READ_MODE), true);
    }

    public FileBackedDataSource(File file, boolean z) throws FileNotFoundException {
        this(newSrcFile(file, z ? InternalZipConstants.READ_MODE : InternalZipConstants.WRITE_MODE), z);
    }

    public FileBackedDataSource(RandomAccessFile randomAccessFile, boolean z) {
        this(randomAccessFile.getChannel(), z);
        this.srcFile = randomAccessFile;
    }

    public FileBackedDataSource(FileChannel fileChannel, boolean z) {
        this.channel = fileChannel;
        this.writable = !z;
    }

    public boolean isWriteable() {
        return this.writable;
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public ByteBuffer read(int i, long j) throws IOException {
        ByteBuffer allocate;
        int readFully;
        if (j >= size()) {
            throw new IllegalArgumentException("Position " + j + " past the end of the file");
        }
        if (this.writable) {
            allocate = this.channel.map(FileChannel.MapMode.READ_WRITE, j, i);
            readFully = 0;
        } else {
            this.channel.position(j);
            allocate = ByteBuffer.allocate(i);
            readFully = IOUtils.readFully(this.channel, allocate);
        }
        if (readFully == -1) {
            throw new IllegalArgumentException("Position " + j + " past the end of the file");
        }
        allocate.position(0);
        return allocate;
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void write(ByteBuffer byteBuffer, long j) throws IOException {
        this.channel.write(byteBuffer, j);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void copyTo(OutputStream outputStream) throws IOException {
        WritableByteChannel newChannel = Channels.newChannel(outputStream);
        FileChannel fileChannel = this.channel;
        fileChannel.transferTo(0L, fileChannel.size(), newChannel);
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public long size() throws IOException {
        return this.channel.size();
    }

    @Override // org.apache.poi.poifs.nio.DataSource
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.srcFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        } else {
            this.channel.close();
        }
    }

    private static RandomAccessFile newSrcFile(File file, String str) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        return new RandomAccessFile(file, str);
    }
}

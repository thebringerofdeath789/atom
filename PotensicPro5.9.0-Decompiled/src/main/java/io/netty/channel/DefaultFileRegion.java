package io.netty.channel;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes3.dex */
public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultFileRegion.class);
    private final long count;
    private final File f;
    private FileChannel file;
    private final long position;
    private long transferred;

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion touch() {
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FileRegion touch(Object obj) {
        return this;
    }

    public DefaultFileRegion(FileChannel fileChannel, long j, long j2) {
        Objects.requireNonNull(fileChannel, StringLookupFactory.KEY_FILE);
        if (j < 0) {
            throw new IllegalArgumentException("position must be >= 0 but was " + j);
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("count must be >= 0 but was " + j2);
        }
        this.file = fileChannel;
        this.position = j;
        this.count = j2;
        this.f = null;
    }

    public DefaultFileRegion(File file, long j, long j2) {
        Objects.requireNonNull(file, "f");
        if (j < 0) {
            throw new IllegalArgumentException("position must be >= 0 but was " + j);
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("count must be >= 0 but was " + j2);
        }
        this.position = j;
        this.count = j2;
        this.f = file;
    }

    public boolean isOpen() {
        return this.file != null;
    }

    public void open() throws IOException {
        if (isOpen() || refCnt() <= 0) {
            return;
        }
        this.file = new RandomAccessFile(this.f, InternalZipConstants.READ_MODE).getChannel();
    }

    @Override // io.netty.channel.FileRegion
    public long position() {
        return this.position;
    }

    @Override // io.netty.channel.FileRegion
    public long count() {
        return this.count;
    }

    @Override // io.netty.channel.FileRegion
    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    @Override // io.netty.channel.FileRegion
    public long transferred() {
        return this.transferred;
    }

    @Override // io.netty.channel.FileRegion
    public long transferTo(WritableByteChannel writableByteChannel, long j) throws IOException {
        long j2 = this.count - j;
        if (j2 < 0 || j < 0) {
            throw new IllegalArgumentException("position out of range: " + j + " (expected: 0 - " + (this.count - 1) + PropertyUtils.MAPPED_DELIM2);
        }
        if (j2 == 0) {
            return 0L;
        }
        if (refCnt() == 0) {
            throw new IllegalReferenceCountException(0);
        }
        open();
        long transferTo = this.file.transferTo(this.position + j, j2, writableByteChannel);
        if (transferTo > 0) {
            this.transferred += transferTo;
        }
        return transferTo;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        FileChannel fileChannel = this.file;
        if (fileChannel == null) {
            return;
        }
        this.file = null;
        try {
            fileChannel.close();
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file.", (Throwable) e);
            }
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain(int i) {
        super.retain(i);
        return this;
    }
}

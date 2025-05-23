package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* loaded from: classes4.dex */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final FileChannel in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file) throws IOException {
        this(new FileInputStream(file).getChannel());
    }

    public ChunkedNioFile(File file, int i) throws IOException {
        this(new FileInputStream(file).getChannel(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel) throws IOException {
        this(fileChannel, 8192);
    }

    public ChunkedNioFile(FileChannel fileChannel, int i) throws IOException {
        this(fileChannel, 0L, fileChannel.size(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel, long j, long j2, int i) throws IOException {
        Objects.requireNonNull(fileChannel, "in");
        if (j < 0) {
            throw new IllegalArgumentException("offset: " + j + " (expected: 0 or greater)");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("length: " + j2 + " (expected: 0 or greater)");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkSize: " + i + " (expected: a positive integer)");
        }
        if (j != 0) {
            fileChannel.position(j);
        }
        this.in = fileChannel;
        this.chunkSize = i;
        this.startOffset = j;
        this.offset = j;
        this.endOffset = j + j2;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    public long currentOffset() {
        return this.offset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.in.isOpen();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.in.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        long j = this.offset;
        long j2 = this.endOffset;
        if (j >= j2) {
            return null;
        }
        int min = (int) Math.min(this.chunkSize, j2 - j);
        ByteBuf buffer = byteBufAllocator.buffer(min);
        int i = 0;
        do {
            try {
                int writeBytes = buffer.writeBytes(this.in, min - i);
                if (writeBytes < 0) {
                    break;
                }
                i += writeBytes;
            } catch (Throwable th) {
                buffer.release();
                throw th;
            }
        } while (i != min);
        this.offset += i;
        return buffer;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }
}

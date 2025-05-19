package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class OioByteStreamChannel extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN = new InputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    };
    private static final OutputStream CLOSED_OUT = new OutputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            throw new ClosedChannelException();
        }
    };
    private InputStream is;
    private OutputStream os;
    private WritableByteChannel outChannel;

    protected OioByteStreamChannel(Channel channel) {
        super(channel);
    }

    protected final void activate(InputStream inputStream, OutputStream outputStream) {
        if (this.is != null) {
            throw new IllegalStateException("input was set already");
        }
        if (this.os != null) {
            throw new IllegalStateException("output was set already");
        }
        Objects.requireNonNull(inputStream, "is");
        Objects.requireNonNull(outputStream, "os");
        this.is = inputStream;
        this.os = outputStream;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        OutputStream outputStream;
        InputStream inputStream = this.is;
        return (inputStream == null || inputStream == CLOSED_IN || (outputStream = this.os) == null || outputStream == CLOSED_OUT) ? false : true;
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected int available() {
        try {
            return this.is.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.attemptedBytesRead(Math.max(1, Math.min(available(), byteBuf.maxWritableBytes())));
        return byteBuf.writeBytes(this.is, recvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected void doWriteBytes(ByteBuf byteBuf) throws Exception {
        OutputStream outputStream = this.os;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        byteBuf.readBytes(outputStream, byteBuf.readableBytes());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected void doWriteFileRegion(FileRegion fileRegion) throws Exception {
        OutputStream outputStream = this.os;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        if (this.outChannel == null) {
            this.outChannel = Channels.newChannel(outputStream);
        }
        long j = 0;
        do {
            long transferTo = fileRegion.transferTo(this.outChannel, j);
            if (transferTo == -1) {
                checkEOF(fileRegion);
                return;
            }
            j += transferTo;
        } while (j < fileRegion.count());
    }

    private static void checkEOF(FileRegion fileRegion) throws IOException {
        if (fileRegion.transferred() < fileRegion.count()) {
            throw new EOFException("Expected to be able to write " + fileRegion.count() + " bytes, but only wrote " + fileRegion.transferred());
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        InputStream inputStream = this.is;
        OutputStream outputStream = this.os;
        this.is = CLOSED_IN;
        this.os = CLOSED_OUT;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }
}

package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes3.dex */
public abstract class SocketWritableByteChannel implements WritableByteChannel {
    private final FileDescriptor fd;

    protected abstract ByteBufAllocator alloc();

    protected SocketWritableByteChannel(FileDescriptor fileDescriptor) {
        this.fd = (FileDescriptor) ObjectUtil.checkNotNull(fileDescriptor, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        int write;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            write = this.fd.write(byteBuffer, position, byteBuffer.limit());
        } else {
            int i = limit - position;
            ByteBuf byteBuf = null;
            try {
                if (i == 0) {
                    byteBuf = Unpooled.EMPTY_BUFFER;
                } else {
                    ByteBufAllocator alloc = alloc();
                    if (alloc.isDirectBufferPooled()) {
                        byteBuf = alloc.directBuffer(i);
                    } else {
                        byteBuf = ByteBufUtil.threadLocalDirectBuffer();
                        if (byteBuf == null) {
                            byteBuf = Unpooled.directBuffer(i);
                        }
                    }
                }
                byteBuf.writeBytes(byteBuffer.duplicate());
                ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), i);
                write = this.fd.write(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
            } finally {
                if (byteBuf != null) {
                    byteBuf.release();
                }
            }
        }
        if (write > 0) {
            byteBuffer.position(position + write);
        }
        return write;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.fd.isOpen();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.fd.close();
    }
}

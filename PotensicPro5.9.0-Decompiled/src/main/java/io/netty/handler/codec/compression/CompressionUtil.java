package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class CompressionUtil {
    private CompressionUtil() {
    }

    static void checkChecksum(ByteBufChecksum byteBufChecksum, ByteBuf byteBuf, int i) {
        byteBufChecksum.reset();
        byteBufChecksum.update(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
        int value = (int) byteBufChecksum.getValue();
        if (value != i) {
            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(i)));
        }
    }

    static ByteBuffer safeNioBuffer(ByteBuf byteBuf) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
    }
}

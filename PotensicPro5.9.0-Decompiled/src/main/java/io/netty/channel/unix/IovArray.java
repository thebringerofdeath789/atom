package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    private static final int CAPACITY;
    private static final int IOV_SIZE;
    private int count;
    private long maxBytes = Limits.SSIZE_MAX;
    private final long memoryAddress = PlatformDependent.allocateMemory(CAPACITY);
    private long size;

    static {
        int addressSize = PlatformDependent.addressSize();
        ADDRESS_SIZE = addressSize;
        int i = addressSize * 2;
        IOV_SIZE = i;
        CAPACITY = Limits.IOV_MAX * i;
    }

    public void clear() {
        this.count = 0;
        this.size = 0L;
    }

    public boolean add(ByteBuf byteBuf) {
        if (this.count == Limits.IOV_MAX) {
            return false;
        }
        if (byteBuf.nioBufferCount() == 1) {
            int readableBytes = byteBuf.readableBytes();
            return readableBytes == 0 || add(byteBuf.memoryAddress(), byteBuf.readerIndex(), readableBytes);
        }
        for (ByteBuffer byteBuffer : byteBuf.nioBuffers()) {
            int remaining = byteBuffer.remaining();
            if (remaining != 0 && (!add(PlatformDependent.directBufferAddress(byteBuffer), byteBuffer.position(), remaining) || this.count == Limits.IOV_MAX)) {
                break;
            }
        }
        return true;
    }

    private boolean add(long j, int i, int i2) {
        if (i2 == 0) {
            return true;
        }
        long memoryAddress = memoryAddress(this.count);
        int i3 = ADDRESS_SIZE;
        long j2 = i3 + memoryAddress;
        long j3 = i2;
        long j4 = this.maxBytes - j3;
        long j5 = this.size;
        if (j4 < j5 && this.count > 0) {
            return false;
        }
        this.size = j5 + j3;
        this.count++;
        if (i3 == 8) {
            PlatformDependent.putLong(memoryAddress, j + i);
            PlatformDependent.putLong(j2, j3);
            return true;
        }
        PlatformDependent.putInt(memoryAddress, ((int) j) + i);
        PlatformDependent.putInt(j2, i2);
        return true;
    }

    public int count() {
        return this.count;
    }

    public long size() {
        return this.size;
    }

    public void maxBytes(long j) {
        this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(j, "maxBytes"));
    }

    public long maxBytes() {
        return this.maxBytes;
    }

    public long memoryAddress(int i) {
        return this.memoryAddress + (IOV_SIZE * i);
    }

    public void release() {
        PlatformDependent.freeMemory(this.memoryAddress);
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) throws Exception {
        return (obj instanceof ByteBuf) && add((ByteBuf) obj);
    }
}

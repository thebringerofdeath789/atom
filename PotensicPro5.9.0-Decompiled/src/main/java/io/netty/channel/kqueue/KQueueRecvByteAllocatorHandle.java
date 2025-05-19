package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
final class KQueueRecvByteAllocatorHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle.1
        @Override // io.netty.util.UncheckedBooleanSupplier, io.netty.util.BooleanSupplier
        public boolean get() {
            return KQueueRecvByteAllocatorHandle.this.maybeMoreDataToRead();
        }
    };
    private final RecvByteBufAllocator.ExtendedHandle delegate;
    private long numberBytesPending;
    private boolean overrideGuess;
    private boolean readEOF;

    KQueueRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        this.delegate = (RecvByteBufAllocator.ExtendedHandle) ObjectUtil.checkNotNull(extendedHandle, "handle");
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public int guess() {
        return this.overrideGuess ? guess0() : this.delegate.guess();
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public void reset(ChannelConfig channelConfig) {
        this.overrideGuess = ((KQueueChannelConfig) channelConfig).getRcvAllocTransportProvidesGuess();
        this.delegate.reset(channelConfig);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public void incMessagesRead(int i) {
        this.delegate.incMessagesRead(i);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
        return this.overrideGuess ? byteBufAllocator.ioBuffer(guess0()) : this.delegate.allocate(byteBufAllocator);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public void lastBytesRead(int i) {
        this.numberBytesPending = i >= 0 ? Math.max(0L, this.numberBytesPending - i) : 0L;
        this.delegate.lastBytesRead(i);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public int lastBytesRead() {
        return this.delegate.lastBytesRead();
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public void attemptedBytesRead(int i) {
        this.delegate.attemptedBytesRead(i);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public int attemptedBytesRead() {
        return this.delegate.attemptedBytesRead();
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public void readComplete() {
        this.delegate.readComplete();
    }

    @Override // io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
        return this.delegate.continueReading(uncheckedBooleanSupplier);
    }

    @Override // io.netty.channel.RecvByteBufAllocator.Handle
    public boolean continueReading() {
        return this.delegate.continueReading(this.defaultMaybeMoreDataSupplier);
    }

    void readEOF() {
        this.readEOF = true;
    }

    void numberBytesPending(long j) {
        this.numberBytesPending = j;
    }

    boolean maybeMoreDataToRead() {
        return this.numberBytesPending != 0 || this.readEOF;
    }

    private int guess0() {
        return (int) Math.min(this.numberBytesPending, 2147483647L);
    }
}

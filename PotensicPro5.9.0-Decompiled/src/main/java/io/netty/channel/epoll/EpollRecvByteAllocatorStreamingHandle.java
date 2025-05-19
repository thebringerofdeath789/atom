package io.netty.channel.epoll;

import io.netty.channel.RecvByteBufAllocator;

/* loaded from: classes3.dex */
final class EpollRecvByteAllocatorStreamingHandle extends EpollRecvByteAllocatorHandle {
    public EpollRecvByteAllocatorStreamingHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
    }

    @Override // io.netty.channel.epoll.EpollRecvByteAllocatorHandle
    boolean maybeMoreDataToRead() {
        return lastBytesRead() == attemptedBytesRead() || isReceivedRdHup();
    }
}

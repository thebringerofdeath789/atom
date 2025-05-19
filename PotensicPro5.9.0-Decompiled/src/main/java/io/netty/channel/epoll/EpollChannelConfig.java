package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.Limits;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class EpollChannelConfig extends DefaultChannelConfig {
    final AbstractEpollChannel channel;
    private volatile long maxBytesPerGatheringWrite;

    EpollChannelConfig(AbstractEpollChannel abstractEpollChannel) {
        super(abstractEpollChannel);
        this.maxBytesPerGatheringWrite = Limits.SSIZE_MAX;
        this.channel = abstractEpollChannel;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), EpollChannelOption.EPOLL_MODE);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        if (channelOption == EpollChannelOption.EPOLL_MODE) {
            return (T) getEpollMode();
        }
        return (T) super.getOption(channelOption);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t) {
        validate(channelOption, t);
        if (channelOption == EpollChannelOption.EPOLL_MODE) {
            setEpollMode((EpollMode) t);
            return true;
        }
        return super.setOption(channelOption, t);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setConnectTimeoutMillis(int i) {
        super.setConnectTimeoutMillis(i);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollChannelConfig setMaxMessagesPerRead(int i) {
        super.setMaxMessagesPerRead(i);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setWriteSpinCount(int i) {
        super.setWriteSpinCount(i);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        if (!(recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle)) {
            throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
        }
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollChannelConfig setWriteBufferHighWaterMark(int i) {
        super.setWriteBufferHighWaterMark(i);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollChannelConfig setWriteBufferLowWaterMark(int i) {
        super.setWriteBufferLowWaterMark(i);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public EpollMode getEpollMode() {
        return this.channel.isFlagSet(Native.EPOLLET) ? EpollMode.EDGE_TRIGGERED : EpollMode.LEVEL_TRIGGERED;
    }

    public EpollChannelConfig setEpollMode(EpollMode epollMode) {
        Objects.requireNonNull(epollMode, RtspHeaders.Values.MODE);
        try {
            int i = AnonymousClass1.$SwitchMap$io$netty$channel$epoll$EpollMode[epollMode.ordinal()];
            if (i == 1) {
                checkChannelNotRegistered();
                this.channel.setFlag(Native.EPOLLET);
            } else if (i == 2) {
                checkChannelNotRegistered();
                this.channel.clearFlag(Native.EPOLLET);
            } else {
                throw new Error();
            }
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    /* renamed from: io.netty.channel.epoll.EpollChannelConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$epoll$EpollMode;

        static {
            int[] iArr = new int[EpollMode.values().length];
            $SwitchMap$io$netty$channel$epoll$EpollMode = iArr;
            try {
                iArr[EpollMode.EDGE_TRIGGERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$epoll$EpollMode[EpollMode.LEVEL_TRIGGERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void checkChannelNotRegistered() {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("EpollMode can only be changed before channel is registered");
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig
    protected final void autoReadCleared() {
        this.channel.clearEpollIn();
    }

    final void setMaxBytesPerGatheringWrite(long j) {
        this.maxBytesPerGatheringWrite = j;
    }

    final long getMaxBytesPerGatheringWrite() {
        return this.maxBytesPerGatheringWrite;
    }
}

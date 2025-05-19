package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.NativeDatagramPacketArray;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Objects;
import kotlin.text.Typography;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class EpollDatagramChannel extends AbstractEpollChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EpollDatagramChannelConfig config;
    private volatile boolean connected;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + Typography.less + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + PropertyUtils.MAPPED_DELIM2;

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    public EpollDatagramChannel() {
        super(LinuxSocket.newSocketDgram(), Native.EPOLLIN);
        this.config = new EpollDatagramChannelConfig(this);
    }

    public EpollDatagramChannel(int i) {
        this(new LinuxSocket(i));
    }

    EpollDatagramChannel(LinuxSocket linuxSocket) {
        super((Channel) null, linuxSocket, Native.EPOLLIN, true);
        this.config = new EpollDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public boolean isActive() {
        return this.socket.isOpen() && ((this.config.getActiveOnOpen() && isRegistered()) || this.active);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return joinGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e) {
            channelPromise.setFailure((Throwable) e);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return joinGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        Objects.requireNonNull(inetAddress, "multicastAddress");
        Objects.requireNonNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e) {
            channelPromise.setFailure((Throwable) e);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return leaveGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        Objects.requireNonNull(inetAddress, "multicastAddress");
        Objects.requireNonNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        Objects.requireNonNull(inetAddress, "multicastAddress");
        Objects.requireNonNull(inetAddress2, "sourceToBlock");
        Objects.requireNonNull(networkInterface, "networkInterface");
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.active = true;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        NativeDatagramPacketArray nativeDatagramPacketArray;
        int count;
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearFlag(Native.EPOLLOUT);
                return;
            }
            try {
                boolean z = false;
                if (Native.IS_SUPPORTING_SENDMMSG && channelOutboundBuffer.size() > 1 && (count = (nativeDatagramPacketArray = NativeDatagramPacketArray.getInstance(channelOutboundBuffer)).count()) >= 1) {
                    NativeDatagramPacketArray.NativeDatagramPacket[] packets = nativeDatagramPacketArray.packets();
                    int i = 0;
                    while (count > 0) {
                        int sendmmsg = Native.sendmmsg(this.socket.intValue(), packets, i, count);
                        if (sendmmsg == 0) {
                            setFlag(Native.EPOLLOUT);
                            return;
                        }
                        for (int i2 = 0; i2 < sendmmsg; i2++) {
                            channelOutboundBuffer.remove();
                        }
                        count -= sendmmsg;
                        i += sendmmsg;
                    }
                } else {
                    int writeSpinCount = config().getWriteSpinCount();
                    while (true) {
                        if (writeSpinCount <= 0) {
                            break;
                        }
                        if (doWriteMessage(current)) {
                            z = true;
                            break;
                        }
                        writeSpinCount--;
                    }
                    if (z) {
                        channelOutboundBuffer.remove();
                    } else {
                        setFlag(Native.EPOLLOUT);
                        return;
                    }
                }
            } catch (IOException e) {
                channelOutboundBuffer.remove(e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean doWriteMessage(java.lang.Object r12) throws java.lang.Exception {
        /*
            r11 = this;
            boolean r0 = r12 instanceof io.netty.channel.AddressedEnvelope
            if (r0 == 0) goto L13
            io.netty.channel.AddressedEnvelope r12 = (io.netty.channel.AddressedEnvelope) r12
            java.lang.Object r0 = r12.content()
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            java.net.SocketAddress r12 = r12.recipient()
            java.net.InetSocketAddress r12 = (java.net.InetSocketAddress) r12
            goto L17
        L13:
            r0 = r12
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            r12 = 0
        L17:
            int r1 = r0.readableBytes()
            r2 = 1
            if (r1 != 0) goto L1f
            return r2
        L1f:
            boolean r1 = r0.hasMemoryAddress()
            r3 = 0
            if (r1 == 0) goto L53
            long r5 = r0.memoryAddress()
            if (r12 != 0) goto L3c
            io.netty.channel.epoll.LinuxSocket r12 = r11.socket
            int r1 = r0.readerIndex()
            int r0 = r0.writerIndex()
            int r12 = r12.writeAddress(r5, r1, r0)
            goto Lbd
        L3c:
            io.netty.channel.epoll.LinuxSocket r4 = r11.socket
            int r7 = r0.readerIndex()
            int r8 = r0.writerIndex()
            java.net.InetAddress r9 = r12.getAddress()
            int r10 = r12.getPort()
            int r12 = r4.sendToAddress(r5, r7, r8, r9, r10)
            goto Lbd
        L53:
            int r1 = r0.nioBufferCount()
            if (r1 <= r2) goto L8a
            io.netty.channel.EventLoop r1 = r11.eventLoop()
            io.netty.channel.epoll.EpollEventLoop r1 = (io.netty.channel.epoll.EpollEventLoop) r1
            io.netty.channel.unix.IovArray r1 = r1.cleanArray()
            r1.add(r0)
            int r7 = r1.count()
            if (r12 != 0) goto L77
            io.netty.channel.epoll.LinuxSocket r12 = r11.socket
            long r0 = r1.memoryAddress(r3)
            long r0 = r12.writevAddresses(r0, r7)
            goto Lbe
        L77:
            io.netty.channel.epoll.LinuxSocket r4 = r11.socket
            long r5 = r1.memoryAddress(r3)
            java.net.InetAddress r8 = r12.getAddress()
            int r9 = r12.getPort()
            int r12 = r4.sendToAddresses(r5, r7, r8, r9)
            goto Lbd
        L8a:
            int r1 = r0.readerIndex()
            int r4 = r0.readableBytes()
            java.nio.ByteBuffer r6 = r0.internalNioBuffer(r1, r4)
            if (r12 != 0) goto La7
            io.netty.channel.epoll.LinuxSocket r12 = r11.socket
            int r0 = r6.position()
            int r1 = r6.limit()
            int r12 = r12.write(r6, r0, r1)
            goto Lbd
        La7:
            io.netty.channel.epoll.LinuxSocket r5 = r11.socket
            int r7 = r6.position()
            int r8 = r6.limit()
            java.net.InetAddress r9 = r12.getAddress()
            int r10 = r12.getPort()
            int r12 = r5.sendTo(r6, r7, r8, r9, r10)
        Lbd:
            long r0 = (long) r12
        Lbe:
            r4 = 0
            int r12 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r12 <= 0) goto Lc5
            goto Lc6
        Lc5:
            r2 = r3
        Lc6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollDatagramChannel.doWriteMessage(java.lang.Object):boolean");
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf byteBuf = (ByteBuf) datagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? new DatagramPacket(newDirectBuffer(datagramPacket, byteBuf), datagramPacket.recipient()) : obj;
        }
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf2 = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? newDirectBuffer(byteBuf2) : byteBuf2;
        }
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof InetSocketAddress))) {
                ByteBuf byteBuf3 = (ByteBuf) addressedEnvelope.content();
                return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf3) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf3), (InetSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollDatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    final class EpollDatagramChannelUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        EpollDatagramChannelUnsafe() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        
            r1.lastBytesRead(-1);
            r5.release();
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00c2 A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #0 {all -> 0x00b8, blocks: (B:19:0x00ba, B:21:0x00c2, B:38:0x00b4), top: B:37:0x00b4 }] */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void epollInReady() {
            /*
                r11 = this;
                io.netty.channel.epoll.EpollDatagramChannel r0 = io.netty.channel.epoll.EpollDatagramChannel.this
                io.netty.channel.epoll.EpollDatagramChannelConfig r0 = r0.config()
                io.netty.channel.epoll.EpollDatagramChannel r1 = io.netty.channel.epoll.EpollDatagramChannel.this
                boolean r1 = r1.shouldBreakEpollInReady(r0)
                if (r1 == 0) goto L12
                r11.clearEpollIn0()
                return
            L12:
                io.netty.channel.epoll.EpollRecvByteAllocatorHandle r1 = r11.recvBufAllocHandle()
                io.netty.channel.epoll.EpollDatagramChannel r2 = io.netty.channel.epoll.EpollDatagramChannel.this
                int r3 = io.netty.channel.epoll.Native.EPOLLET
                boolean r2 = r2.isFlagSet(r3)
                r1.edgeTriggered(r2)
                io.netty.channel.epoll.EpollDatagramChannel r2 = io.netty.channel.epoll.EpollDatagramChannel.this
                io.netty.channel.ChannelPipeline r2 = r2.pipeline()
                io.netty.buffer.ByteBufAllocator r3 = r0.getAllocator()
                r1.reset(r0)
                r11.epollInBefore()
            L31:
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r1.allocate(r3)     // Catch: java.lang.Throwable -> Laf
                int r6 = r5.writableBytes()     // Catch: java.lang.Throwable -> Lad
                r1.attemptedBytesRead(r6)     // Catch: java.lang.Throwable -> Lad
                boolean r6 = r5.hasMemoryAddress()     // Catch: java.lang.Throwable -> Lad
                if (r6 == 0) goto L58
                io.netty.channel.epoll.EpollDatagramChannel r6 = io.netty.channel.epoll.EpollDatagramChannel.this     // Catch: java.lang.Throwable -> Lad
                io.netty.channel.epoll.LinuxSocket r6 = r6.socket     // Catch: java.lang.Throwable -> Lad
                long r7 = r5.memoryAddress()     // Catch: java.lang.Throwable -> Lad
                int r9 = r5.writerIndex()     // Catch: java.lang.Throwable -> Lad
                int r10 = r5.capacity()     // Catch: java.lang.Throwable -> Lad
                io.netty.channel.unix.DatagramSocketAddress r6 = r6.recvFromAddress(r7, r9, r10)     // Catch: java.lang.Throwable -> Lad
                goto L74
            L58:
                int r6 = r5.writerIndex()     // Catch: java.lang.Throwable -> Lad
                int r7 = r5.writableBytes()     // Catch: java.lang.Throwable -> Lad
                java.nio.ByteBuffer r6 = r5.internalNioBuffer(r6, r7)     // Catch: java.lang.Throwable -> Lad
                io.netty.channel.epoll.EpollDatagramChannel r7 = io.netty.channel.epoll.EpollDatagramChannel.this     // Catch: java.lang.Throwable -> Lad
                io.netty.channel.epoll.LinuxSocket r7 = r7.socket     // Catch: java.lang.Throwable -> Lad
                int r8 = r6.position()     // Catch: java.lang.Throwable -> Lad
                int r9 = r6.limit()     // Catch: java.lang.Throwable -> Lad
                io.netty.channel.unix.DatagramSocketAddress r6 = r7.recvFrom(r6, r8, r9)     // Catch: java.lang.Throwable -> Lad
            L74:
                if (r6 != 0) goto L7e
                r3 = -1
                r1.lastBytesRead(r3)     // Catch: java.lang.Throwable -> Lad
                r5.release()     // Catch: java.lang.Throwable -> Lad
                goto Lba
            L7e:
                r7 = 1
                r1.incMessagesRead(r7)     // Catch: java.lang.Throwable -> Lad
                int r7 = r6.receivedAmount()     // Catch: java.lang.Throwable -> Lad
                r1.lastBytesRead(r7)     // Catch: java.lang.Throwable -> Lad
                int r7 = r5.writerIndex()     // Catch: java.lang.Throwable -> Lad
                int r8 = r1.lastBytesRead()     // Catch: java.lang.Throwable -> Lad
                int r7 = r7 + r8
                r5.writerIndex(r7)     // Catch: java.lang.Throwable -> Lad
                r7 = 0
                r11.readPending = r7     // Catch: java.lang.Throwable -> Lad
                io.netty.channel.socket.DatagramPacket r7 = new io.netty.channel.socket.DatagramPacket     // Catch: java.lang.Throwable -> Lad
                java.net.SocketAddress r8 = r11.localAddress()     // Catch: java.lang.Throwable -> Lad
                java.net.InetSocketAddress r8 = (java.net.InetSocketAddress) r8     // Catch: java.lang.Throwable -> Lad
                r7.<init>(r5, r8, r6)     // Catch: java.lang.Throwable -> Lad
                r2.fireChannelRead(r7)     // Catch: java.lang.Throwable -> Lad
                boolean r5 = r1.continueReading()     // Catch: java.lang.Throwable -> Laf
                if (r5 != 0) goto L31
                goto Lba
            Lad:
                r3 = move-exception
                goto Lb1
            Laf:
                r3 = move-exception
                r5 = r4
            Lb1:
                r4 = r3
                if (r5 == 0) goto Lba
                r5.release()     // Catch: java.lang.Throwable -> Lb8
                goto Lba
            Lb8:
                r1 = move-exception
                goto Lc9
            Lba:
                r1.readComplete()     // Catch: java.lang.Throwable -> Lb8
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> Lb8
                if (r4 == 0) goto Lc5
                r2.fireExceptionCaught(r4)     // Catch: java.lang.Throwable -> Lb8
            Lc5:
                r11.epollInFinally(r0)
                return
            Lc9:
                r11.epollInFinally(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.EpollDatagramChannel.EpollDatagramChannelUnsafe.epollInReady():void");
        }
    }
}

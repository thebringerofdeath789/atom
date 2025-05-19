package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.kqueue.AbstractKQueueChannel;
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
public final class KQueueDatagramChannel extends AbstractKQueueChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final KQueueDatagramChannelConfig config;
    private volatile boolean connected;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + Typography.less + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + PropertyUtils.MAPPED_DELIM2;

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    public KQueueDatagramChannel() {
        super((Channel) null, BsdSocket.newSocketDgram(), false);
        this.config = new KQueueDatagramChannelConfig(this);
    }

    public KQueueDatagramChannel(int i) {
        this(new BsdSocket(i), true);
    }

    KQueueDatagramChannel(BsdSocket bsdSocket, boolean z) {
        super((Channel) null, bsdSocket, z);
        this.config = new KQueueDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
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
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.active = true;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object current = channelOutboundBuffer.current();
            boolean z = false;
            if (current == null) {
                writeFilter(false);
                return;
            }
            try {
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
            } catch (IOException e) {
                channelOutboundBuffer.remove(e);
            }
            if (z) {
                channelOutboundBuffer.remove();
            } else {
                writeFilter(true);
                return;
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
            io.netty.channel.kqueue.BsdSocket r12 = r11.socket
            int r1 = r0.readerIndex()
            int r0 = r0.writerIndex()
            int r12 = r12.writeAddress(r5, r1, r0)
            goto Lbd
        L3c:
            io.netty.channel.kqueue.BsdSocket r4 = r11.socket
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
            io.netty.channel.kqueue.KQueueEventLoop r1 = (io.netty.channel.kqueue.KQueueEventLoop) r1
            io.netty.channel.unix.IovArray r1 = r1.cleanArray()
            r1.add(r0)
            int r7 = r1.count()
            if (r12 != 0) goto L77
            io.netty.channel.kqueue.BsdSocket r12 = r11.socket
            long r0 = r1.memoryAddress(r3)
            long r0 = r12.writevAddresses(r0, r7)
            goto Lbe
        L77:
            io.netty.channel.kqueue.BsdSocket r4 = r11.socket
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
            io.netty.channel.kqueue.BsdSocket r12 = r11.socket
            int r0 = r6.position()
            int r1 = r6.limit()
            int r12 = r12.write(r6, r0, r1)
            goto Lbd
        La7:
            io.netty.channel.kqueue.BsdSocket r5 = r11.socket
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
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDatagramChannel.doWriteMessage(java.lang.Object):boolean");
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (!super.doConnect(socketAddress, socketAddress2)) {
            return false;
        }
        this.connected = true;
        return true;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    final class KQueueDatagramChannelUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        KQueueDatagramChannelUnsafe() {
            super();
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        
            r11.lastBytesRead(-1);
            r4.release();
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b3 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #1 {all -> 0x00a9, blocks: (B:20:0x00ab, B:22:0x00b3, B:39:0x00a5), top: B:38:0x00a5 }] */
        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r11) {
            /*
                r10 = this;
                io.netty.channel.kqueue.KQueueDatagramChannel r0 = io.netty.channel.kqueue.KQueueDatagramChannel.this
                io.netty.channel.kqueue.KQueueDatagramChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.KQueueDatagramChannel r1 = io.netty.channel.kqueue.KQueueDatagramChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L12
                r10.clearReadFilter0()
                return
            L12:
                io.netty.channel.kqueue.KQueueDatagramChannel r1 = io.netty.channel.kqueue.KQueueDatagramChannel.this
                io.netty.channel.ChannelPipeline r1 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r2 = r0.getAllocator()
                r11.reset(r0)
                r10.readReadyBefore()
            L22:
                r3 = 0
                io.netty.buffer.ByteBuf r4 = r11.allocate(r2)     // Catch: java.lang.Throwable -> La0
                int r5 = r4.writableBytes()     // Catch: java.lang.Throwable -> L9e
                r11.attemptedBytesRead(r5)     // Catch: java.lang.Throwable -> L9e
                boolean r5 = r4.hasMemoryAddress()     // Catch: java.lang.Throwable -> L9e
                if (r5 == 0) goto L49
                io.netty.channel.kqueue.KQueueDatagramChannel r5 = io.netty.channel.kqueue.KQueueDatagramChannel.this     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.kqueue.BsdSocket r5 = r5.socket     // Catch: java.lang.Throwable -> L9e
                long r6 = r4.memoryAddress()     // Catch: java.lang.Throwable -> L9e
                int r8 = r4.writerIndex()     // Catch: java.lang.Throwable -> L9e
                int r9 = r4.capacity()     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.unix.DatagramSocketAddress r5 = r5.recvFromAddress(r6, r8, r9)     // Catch: java.lang.Throwable -> L9e
                goto L65
            L49:
                int r5 = r4.writerIndex()     // Catch: java.lang.Throwable -> L9e
                int r6 = r4.writableBytes()     // Catch: java.lang.Throwable -> L9e
                java.nio.ByteBuffer r5 = r4.internalNioBuffer(r5, r6)     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.kqueue.KQueueDatagramChannel r6 = io.netty.channel.kqueue.KQueueDatagramChannel.this     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.kqueue.BsdSocket r6 = r6.socket     // Catch: java.lang.Throwable -> L9e
                int r7 = r5.position()     // Catch: java.lang.Throwable -> L9e
                int r8 = r5.limit()     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.unix.DatagramSocketAddress r5 = r6.recvFrom(r5, r7, r8)     // Catch: java.lang.Throwable -> L9e
            L65:
                if (r5 != 0) goto L6f
                r2 = -1
                r11.lastBytesRead(r2)     // Catch: java.lang.Throwable -> L9e
                r4.release()     // Catch: java.lang.Throwable -> L9e
                goto Lab
            L6f:
                r6 = 1
                r11.incMessagesRead(r6)     // Catch: java.lang.Throwable -> L9e
                int r6 = r5.receivedAmount()     // Catch: java.lang.Throwable -> L9e
                r11.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L9e
                int r6 = r4.writerIndex()     // Catch: java.lang.Throwable -> L9e
                int r7 = r11.lastBytesRead()     // Catch: java.lang.Throwable -> L9e
                int r6 = r6 + r7
                r4.writerIndex(r6)     // Catch: java.lang.Throwable -> L9e
                r6 = 0
                r10.readPending = r6     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.socket.DatagramPacket r6 = new io.netty.channel.socket.DatagramPacket     // Catch: java.lang.Throwable -> L9e
                java.net.SocketAddress r7 = r10.localAddress()     // Catch: java.lang.Throwable -> L9e
                java.net.InetSocketAddress r7 = (java.net.InetSocketAddress) r7     // Catch: java.lang.Throwable -> L9e
                r6.<init>(r4, r7, r5)     // Catch: java.lang.Throwable -> L9e
                r1.fireChannelRead(r6)     // Catch: java.lang.Throwable -> L9e
                boolean r4 = r11.continueReading()     // Catch: java.lang.Throwable -> La0
                if (r4 != 0) goto L22
                goto Lab
            L9e:
                r2 = move-exception
                goto La2
            La0:
                r2 = move-exception
                r4 = r3
            La2:
                r3 = r2
                if (r4 == 0) goto Lab
                r4.release()     // Catch: java.lang.Throwable -> La9
                goto Lab
            La9:
                r11 = move-exception
                goto Lba
            Lab:
                r11.readComplete()     // Catch: java.lang.Throwable -> La9
                r1.fireChannelReadComplete()     // Catch: java.lang.Throwable -> La9
                if (r3 == 0) goto Lb6
                r1.fireExceptionCaught(r3)     // Catch: java.lang.Throwable -> La9
            Lb6:
                r10.readReadyFinally(r0)
                return
            Lba:
                r10.readReadyFinally(r0)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDatagramChannel.KQueueDatagramChannelUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }
}

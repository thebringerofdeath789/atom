package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class OioDatagramChannel extends AbstractOioMessageChannel implements DatagramChannel {
    private final OioDatagramChannelConfig config;
    private final MulticastSocket socket;
    private final DatagramPacket tmpPacket;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OioDatagramChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) io.netty.channel.socket.DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + Typography.less + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) SocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + PropertyUtils.MAPPED_DELIM2;

    private static MulticastSocket newSocket() {
        try {
            return new MulticastSocket((SocketAddress) null);
        } catch (Exception e) {
            throw new ChannelException("failed to create a new socket", e);
        }
    }

    public OioDatagramChannel() {
        this(newSocket());
    }

    public OioDatagramChannel(MulticastSocket multicastSocket) {
        super(null);
        this.tmpPacket = new DatagramPacket(EmptyArrays.EMPTY_BYTES, 0);
        try {
            try {
                multicastSocket.setSoTimeout(1000);
                multicastSocket.setBroadcast(false);
                this.socket = multicastSocket;
                this.config = new DefaultOioDatagramChannelConfig(this, multicastSocket);
            } catch (SocketException e) {
                throw new ChannelException("Failed to configure the datagram socket timeout.", e);
            }
        } catch (Throwable th) {
            multicastSocket.close();
            throw th;
        }
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.Channel
    public DatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return isOpen() && ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || this.socket.isBound());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            this.socket.bind(socketAddress2);
        }
        try {
            this.socket.connect(socketAddress);
        } catch (Throwable th) {
            try {
                this.socket.close();
            } catch (Throwable th2) {
                logger.warn("Failed to close a socket.", th2);
            }
            throw th;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.socket.close();
    }

    @Override // io.netty.channel.oio.AbstractOioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        DatagramChannelConfig config = config();
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        ByteBuf heapBuffer = config.getAllocator().heapBuffer(recvBufAllocHandle.guess());
        try {
            try {
                try {
                    this.tmpPacket.setAddress(null);
                    this.tmpPacket.setData(heapBuffer.array(), heapBuffer.arrayOffset(), heapBuffer.capacity());
                    this.socket.receive(this.tmpPacket);
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) this.tmpPacket.getSocketAddress();
                    recvBufAllocHandle.lastBytesRead(this.tmpPacket.getLength());
                    list.add(new io.netty.channel.socket.DatagramPacket(heapBuffer.writerIndex(recvBufAllocHandle.lastBytesRead()), localAddress(), inetSocketAddress));
                    return 1;
                } catch (SocketException e) {
                    if (!e.getMessage().toLowerCase(Locale.US).contains("socket closed")) {
                        throw e;
                    }
                    heapBuffer.release();
                    return -1;
                } catch (SocketTimeoutException unused) {
                    heapBuffer.release();
                    return 0;
                }
            } catch (Throwable th) {
                PlatformDependent.throwException(th);
                heapBuffer.release();
                return -1;
            }
        } catch (Throwable th2) {
            heapBuffer.release();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[Catch: Exception -> 0x006b, TryCatch #0 {Exception -> 0x006b, blocks: (B:29:0x0022, B:22:0x0033, B:24:0x0039, B:25:0x005a, B:27:0x004c, B:8:0x0028, B:21:0x002e, B:11:0x0065, B:12:0x006a), top: B:28:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c A[Catch: Exception -> 0x006b, TryCatch #0 {Exception -> 0x006b, blocks: (B:29:0x0022, B:22:0x0033, B:24:0x0039, B:25:0x005a, B:27:0x004c, B:8:0x0028, B:21:0x002e, B:11:0x0065, B:12:0x006a), top: B:28:0x0022 }] */
    @Override // io.netty.channel.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doWrite(io.netty.channel.ChannelOutboundBuffer r6) throws java.lang.Exception {
        /*
            r5 = this;
        L0:
            java.lang.Object r0 = r6.current()
            if (r0 != 0) goto L7
            return
        L7:
            boolean r1 = r0 instanceof io.netty.channel.AddressedEnvelope
            r2 = 0
            if (r1 == 0) goto L19
            io.netty.channel.AddressedEnvelope r0 = (io.netty.channel.AddressedEnvelope) r0
            java.net.SocketAddress r1 = r0.recipient()
            java.lang.Object r0 = r0.content()
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            goto L1c
        L19:
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            r1 = r2
        L1c:
            int r3 = r0.readableBytes()
            if (r1 == 0) goto L28
            java.net.DatagramPacket r2 = r5.tmpPacket     // Catch: java.lang.Exception -> L6b
            r2.setSocketAddress(r1)     // Catch: java.lang.Exception -> L6b
            goto L33
        L28:
            boolean r1 = r5.isConnected()     // Catch: java.lang.Exception -> L6b
            if (r1 == 0) goto L65
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L6b
            r1.setAddress(r2)     // Catch: java.lang.Exception -> L6b
        L33:
            boolean r1 = r0.hasArray()     // Catch: java.lang.Exception -> L6b
            if (r1 == 0) goto L4c
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L6b
            byte[] r2 = r0.array()     // Catch: java.lang.Exception -> L6b
            int r4 = r0.arrayOffset()     // Catch: java.lang.Exception -> L6b
            int r0 = r0.readerIndex()     // Catch: java.lang.Exception -> L6b
            int r4 = r4 + r0
            r1.setData(r2, r4, r3)     // Catch: java.lang.Exception -> L6b
            goto L5a
        L4c:
            byte[] r1 = new byte[r3]     // Catch: java.lang.Exception -> L6b
            int r2 = r0.readerIndex()     // Catch: java.lang.Exception -> L6b
            r0.getBytes(r2, r1)     // Catch: java.lang.Exception -> L6b
            java.net.DatagramPacket r0 = r5.tmpPacket     // Catch: java.lang.Exception -> L6b
            r0.setData(r1)     // Catch: java.lang.Exception -> L6b
        L5a:
            java.net.MulticastSocket r0 = r5.socket     // Catch: java.lang.Exception -> L6b
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L6b
            r0.send(r1)     // Catch: java.lang.Exception -> L6b
            r6.remove()     // Catch: java.lang.Exception -> L6b
            goto L0
        L65:
            java.nio.channels.NotYetConnectedException r0 = new java.nio.channels.NotYetConnectedException     // Catch: java.lang.Exception -> L6b
            r0.<init>()     // Catch: java.lang.Exception -> L6b
            throw r0     // Catch: java.lang.Exception -> L6b
        L6b:
            r0 = move-exception
            r6.remove(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.socket.oio.OioDatagramChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if ((obj instanceof io.netty.channel.socket.DatagramPacket) || (obj instanceof ByteBuf)) {
            return obj;
        }
        if ((obj instanceof AddressedEnvelope) && (((AddressedEnvelope) obj).content() instanceof ByteBuf)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        ensureBound();
        try {
            this.socket.joinGroup(inetAddress);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure((Throwable) e);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        ensureBound();
        try {
            this.socket.joinGroup(inetSocketAddress, networkInterface);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure((Throwable) e);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }

    private void ensureBound() {
        if (!isActive()) {
            throw new IllegalStateException(DatagramChannel.class.getName() + " must be bound to join a group.");
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetAddress);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure((Throwable) e);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetSocketAddress, networkInterface);
            channelPromise.setSuccess();
        } catch (IOException e) {
            channelPromise.setFailure((Throwable) e);
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }
}

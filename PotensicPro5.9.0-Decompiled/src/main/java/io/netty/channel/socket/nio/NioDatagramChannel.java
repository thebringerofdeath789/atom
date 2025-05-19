package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.MembershipKey;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Typography;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class NioDatagramChannel extends AbstractNioMessageChannel implements DatagramChannel {
    private final DatagramChannelConfig config;
    private Map<InetAddress, List<MembershipKey>> memberships;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + Typography.less + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) SocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + PropertyUtils.MAPPED_DELIM2;

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean continueOnWriteError() {
        return true;
    }

    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openDatagramChannel();
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        if (internetProtocolFamily == null) {
            return newSocket(selectorProvider);
        }
        checkJavaVersion();
        try {
            return selectorProvider.openDatagramChannel(ProtocolFamilyConverter.convert(internetProtocolFamily));
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    private static void checkJavaVersion() {
        if (PlatformDependent.javaVersion() < 7) {
            throw new UnsupportedOperationException("Only supported on java 7+.");
        }
    }

    public NioDatagramChannel() {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER));
    }

    public NioDatagramChannel(SelectorProvider selectorProvider) {
        this(newSocket(selectorProvider));
    }

    public NioDatagramChannel(InternetProtocolFamily internetProtocolFamily) {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER, internetProtocolFamily));
    }

    public NioDatagramChannel(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        this(newSocket(selectorProvider, internetProtocolFamily));
    }

    public NioDatagramChannel(java.nio.channels.DatagramChannel datagramChannel) {
        super(null, datagramChannel, 1);
        this.config = new NioDatagramChannelConfig(this, datagramChannel);
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
    public boolean isActive() {
        java.nio.channels.DatagramChannel mo46javaChannel = mo46javaChannel();
        return mo46javaChannel.isOpen() && ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || mo46javaChannel.socket().isBound());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return mo46javaChannel().isConnected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    /* renamed from: javaChannel */
    public java.nio.channels.DatagramChannel mo46javaChannel() {
        return (java.nio.channels.DatagramChannel) super.mo46javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return mo46javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return mo46javaChannel().socket().getRemoteSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        doBind0(socketAddress);
    }

    private void doBind0(SocketAddress socketAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(mo46javaChannel(), socketAddress);
        } else {
            mo46javaChannel().socket().bind(socketAddress);
        }
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            doBind0(socketAddress2);
        }
        try {
            mo46javaChannel().connect(socketAddress);
            return true;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        throw new Error();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        mo46javaChannel().disconnect();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        mo46javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        java.nio.channels.DatagramChannel mo46javaChannel = mo46javaChannel();
        DatagramChannelConfig config = config();
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        ByteBuf allocate = recvBufAllocHandle.allocate(config.getAllocator());
        recvBufAllocHandle.attemptedBytesRead(allocate.writableBytes());
        try {
            ByteBuffer internalNioBuffer = allocate.internalNioBuffer(allocate.writerIndex(), allocate.writableBytes());
            int position = internalNioBuffer.position();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) mo46javaChannel.receive(internalNioBuffer);
            if (inetSocketAddress != null) {
                recvBufAllocHandle.lastBytesRead(internalNioBuffer.position() - position);
                list.add(new DatagramPacket(allocate.writerIndex(allocate.writerIndex() + recvBufAllocHandle.lastBytesRead()), localAddress(), inetSocketAddress));
                return 1;
            }
            return 0;
        } catch (Throwable th) {
            try {
                PlatformDependent.throwException(th);
                return -1;
            } finally {
                allocate.release();
            }
        }
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        ByteBuf byteBuf;
        SocketAddress socketAddress;
        int write;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            socketAddress = addressedEnvelope.recipient();
            byteBuf = (ByteBuf) addressedEnvelope.content();
        } else {
            byteBuf = (ByteBuf) obj;
            socketAddress = null;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return true;
        }
        ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), readableBytes);
        if (socketAddress != null) {
            write = mo46javaChannel().send(internalNioBuffer, socketAddress);
        } else {
            write = mo46javaChannel().write(internalNioBuffer);
        }
        return write > 0;
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf byteBuf = (ByteBuf) datagramPacket.content();
            return isSingleDirectBuffer(byteBuf) ? datagramPacket : new DatagramPacket(newDirectBuffer(datagramPacket, byteBuf), datagramPacket.recipient());
        }
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf2 = (ByteBuf) obj;
            return isSingleDirectBuffer(byteBuf2) ? byteBuf2 : newDirectBuffer(byteBuf2);
        }
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if (addressedEnvelope.content() instanceof ByteBuf) {
                ByteBuf byteBuf3 = (ByteBuf) addressedEnvelope.content();
                return isSingleDirectBuffer(byteBuf3) ? addressedEnvelope : new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf3), addressedEnvelope.recipient());
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    private static boolean isSingleDirectBuffer(ByteBuf byteBuf) {
        return byteBuf.isDirect() && byteBuf.nioBufferCount() == 1;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
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
        MembershipKey join;
        checkJavaVersion();
        Objects.requireNonNull(inetAddress, "multicastAddress");
        Objects.requireNonNull(networkInterface, "networkInterface");
        try {
            if (inetAddress2 == null) {
                join = mo46javaChannel().join(inetAddress, networkInterface);
            } else {
                join = mo46javaChannel().join(inetAddress, networkInterface, inetAddress2);
            }
            synchronized (this) {
                List<MembershipKey> list = null;
                Map<InetAddress, List<MembershipKey>> map = this.memberships;
                if (map == null) {
                    this.memberships = new HashMap();
                } else {
                    list = map.get(inetAddress);
                }
                if (list == null) {
                    list = new ArrayList<>();
                    this.memberships.put(inetAddress, list);
                }
                list.add(join);
            }
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
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
        List<MembershipKey> list;
        checkJavaVersion();
        Objects.requireNonNull(inetAddress, "multicastAddress");
        Objects.requireNonNull(networkInterface, "networkInterface");
        synchronized (this) {
            Map<InetAddress, List<MembershipKey>> map = this.memberships;
            if (map != null && (list = map.get(inetAddress)) != null) {
                Iterator<MembershipKey> it = list.iterator();
                while (it.hasNext()) {
                    MembershipKey next = it.next();
                    if (networkInterface.equals(next.networkInterface()) && ((inetAddress2 == null && next.sourceAddress() == null) || (inetAddress2 != null && inetAddress2.equals(next.sourceAddress())))) {
                        next.drop();
                        it.remove();
                    }
                }
                if (list.isEmpty()) {
                    this.memberships.remove(inetAddress);
                }
            }
        }
        channelPromise.setSuccess();
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        checkJavaVersion();
        Objects.requireNonNull(inetAddress, "multicastAddress");
        Objects.requireNonNull(inetAddress2, "sourceToBlock");
        Objects.requireNonNull(networkInterface, "networkInterface");
        synchronized (this) {
            Map<InetAddress, List<MembershipKey>> map = this.memberships;
            if (map != null) {
                for (MembershipKey membershipKey : map.get(inetAddress)) {
                    if (networkInterface.equals(membershipKey.networkInterface())) {
                        try {
                            membershipKey.block(inetAddress2);
                        } catch (IOException e) {
                            channelPromise.setFailure((Throwable) e);
                        }
                    }
                }
            }
        }
        channelPromise.setSuccess();
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
        } catch (SocketException e) {
            channelPromise.setFailure((Throwable) e);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    @Deprecated
    protected void setReadPending(boolean z) {
        super.setReadPending(z);
    }

    void clearReadPending0() {
        clearReadPending();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean closeOnReadError(Throwable th) {
        if (th instanceof SocketException) {
            return false;
        }
        return super.closeOnReadError(th);
    }
}

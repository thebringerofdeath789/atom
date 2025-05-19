package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.Limits;
import io.netty.channel.unix.NativeInetAddress;
import io.netty.util.concurrent.FastThreadLocal;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
final class NativeDatagramPacketArray implements ChannelOutboundBuffer.MessageProcessor {
    private static final FastThreadLocal<NativeDatagramPacketArray> ARRAY = new FastThreadLocal<NativeDatagramPacketArray>() { // from class: io.netty.channel.epoll.NativeDatagramPacketArray.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public NativeDatagramPacketArray initialValue() throws Exception {
            return new NativeDatagramPacketArray();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(NativeDatagramPacketArray nativeDatagramPacketArray) throws Exception {
            for (NativeDatagramPacket nativeDatagramPacket : nativeDatagramPacketArray.packets) {
                nativeDatagramPacket.release();
            }
        }
    };
    private int count;
    private final NativeDatagramPacket[] packets;

    private NativeDatagramPacketArray() {
        this.packets = new NativeDatagramPacket[Limits.UIO_MAX_IOV];
        int i = 0;
        while (true) {
            NativeDatagramPacket[] nativeDatagramPacketArr = this.packets;
            if (i >= nativeDatagramPacketArr.length) {
                return;
            }
            nativeDatagramPacketArr[i] = new NativeDatagramPacket();
            i++;
        }
    }

    boolean add(DatagramPacket datagramPacket) {
        if (this.count == this.packets.length) {
            return false;
        }
        ByteBuf byteBuf = (ByteBuf) datagramPacket.content();
        if (byteBuf.readableBytes() == 0) {
            return true;
        }
        if (!this.packets[this.count].init(byteBuf, datagramPacket.recipient())) {
            return false;
        }
        this.count++;
        return true;
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) throws Exception {
        return (obj instanceof DatagramPacket) && add((DatagramPacket) obj);
    }

    int count() {
        return this.count;
    }

    NativeDatagramPacket[] packets() {
        return this.packets;
    }

    static NativeDatagramPacketArray getInstance(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        NativeDatagramPacketArray nativeDatagramPacketArray = ARRAY.get();
        nativeDatagramPacketArray.count = 0;
        channelOutboundBuffer.forEachFlushedMessage(nativeDatagramPacketArray);
        return nativeDatagramPacketArray;
    }

    static final class NativeDatagramPacket {
        private byte[] addr;
        private final IovArray array = new IovArray();
        private int count;
        private long memoryAddress;
        private int port;
        private int scopeId;

        NativeDatagramPacket() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            this.array.release();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean init(ByteBuf byteBuf, InetSocketAddress inetSocketAddress) {
            this.array.clear();
            if (!this.array.add(byteBuf)) {
                return false;
            }
            this.memoryAddress = this.array.memoryAddress(0);
            this.count = this.array.count();
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet6Address) {
                this.addr = address.getAddress();
                this.scopeId = ((Inet6Address) address).getScopeId();
            } else {
                this.addr = NativeInetAddress.ipv4MappedIpv6Address(address.getAddress());
                this.scopeId = 0;
            }
            this.port = inetSocketAddress.getPort();
            return true;
        }
    }
}

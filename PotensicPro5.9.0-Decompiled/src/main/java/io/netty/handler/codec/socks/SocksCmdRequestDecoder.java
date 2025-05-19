package io.netty.handler.codec.socks;

import io.netty.handler.codec.ReplayingDecoder;

/* loaded from: classes3.dex */
public class SocksCmdRequestDecoder extends ReplayingDecoder<State> {
    private SocksAddressType addressType;
    private SocksCmdType cmdType;

    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_CMD_HEADER,
        READ_CMD_ADDRESS
    }

    public SocksCmdRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* renamed from: io.netty.handler.codec.socks.SocksCmdRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State[State.READ_CMD_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State[State.READ_CMD_ADDRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr2;
            try {
                iArr2[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r6, io.netty.buffer.ByteBuf r7, java.util.List<java.lang.Object> r8) throws java.lang.Exception {
        /*
            r5 = this;
            int[] r0 = io.netty.handler.codec.socks.SocksCmdRequestDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State
            java.lang.Object r1 = r5.state()
            io.netty.handler.codec.socks.SocksCmdRequestDecoder$State r1 = (io.netty.handler.codec.socks.SocksCmdRequestDecoder.State) r1
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L1e
            if (r0 == r2) goto L36
            if (r0 != r1) goto L18
            goto L52
        L18:
            java.lang.Error r6 = new java.lang.Error
            r6.<init>()
            throw r6
        L1e:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksProtocolVersion r4 = io.netty.handler.codec.socks.SocksProtocolVersion.SOCKS5
            byte r4 = r4.byteValue()
            if (r0 == r4) goto L31
            io.netty.handler.codec.socks.SocksRequest r7 = io.netty.handler.codec.socks.SocksCommonUtils.UNKNOWN_SOCKS_REQUEST
            r8.add(r7)
            goto Lbe
        L31:
            io.netty.handler.codec.socks.SocksCmdRequestDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdRequestDecoder.State.READ_CMD_HEADER
            r5.checkpoint(r0)
        L36:
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksCmdType r0 = io.netty.handler.codec.socks.SocksCmdType.valueOf(r0)
            r5.cmdType = r0
            r7.skipBytes(r3)
            byte r0 = r7.readByte()
            io.netty.handler.codec.socks.SocksAddressType r0 = io.netty.handler.codec.socks.SocksAddressType.valueOf(r0)
            r5.addressType = r0
            io.netty.handler.codec.socks.SocksCmdRequestDecoder$State r0 = io.netty.handler.codec.socks.SocksCmdRequestDecoder.State.READ_CMD_ADDRESS
            r5.checkpoint(r0)
        L52:
            int[] r0 = io.netty.handler.codec.socks.SocksCmdRequestDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType
            io.netty.handler.codec.socks.SocksAddressType r4 = r5.addressType
            int r4 = r4.ordinal()
            r0 = r0[r4]
            if (r0 == r3) goto La6
            if (r0 == r2) goto L8d
            if (r0 == r1) goto L71
            r7 = 4
            if (r0 != r7) goto L6b
            io.netty.handler.codec.socks.SocksRequest r7 = io.netty.handler.codec.socks.SocksCommonUtils.UNKNOWN_SOCKS_REQUEST
            r8.add(r7)
            goto Lbe
        L6b:
            java.lang.Error r6 = new java.lang.Error
            r6.<init>()
            throw r6
        L71:
            r0 = 16
            byte[] r0 = new byte[r0]
            r7.readBytes(r0)
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.ipv6toStr(r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdRequest r1 = new io.netty.handler.codec.socks.SocksCmdRequest
            io.netty.handler.codec.socks.SocksCmdType r2 = r5.cmdType
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
            goto Lbe
        L8d:
            byte r0 = r7.readByte()
            java.lang.String r0 = io.netty.handler.codec.socks.SocksCommonUtils.readUsAscii(r7, r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdRequest r1 = new io.netty.handler.codec.socks.SocksCmdRequest
            io.netty.handler.codec.socks.SocksCmdType r2 = r5.cmdType
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
            goto Lbe
        La6:
            int r0 = r7.readInt()
            java.lang.String r0 = io.netty.util.NetUtil.intToIpAddress(r0)
            int r7 = r7.readUnsignedShort()
            io.netty.handler.codec.socks.SocksCmdRequest r1 = new io.netty.handler.codec.socks.SocksCmdRequest
            io.netty.handler.codec.socks.SocksCmdType r2 = r5.cmdType
            io.netty.handler.codec.socks.SocksAddressType r3 = r5.addressType
            r1.<init>(r2, r3, r0, r7)
            r8.add(r1)
        Lbe:
            io.netty.channel.ChannelPipeline r6 = r6.pipeline()
            r6.remove(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socks.SocksCmdRequestDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}

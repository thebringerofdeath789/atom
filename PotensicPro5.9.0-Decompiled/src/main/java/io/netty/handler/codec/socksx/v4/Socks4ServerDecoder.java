package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.CharsetUtil;
import java.util.List;

/* loaded from: classes3.dex */
public class Socks4ServerDecoder extends ReplayingDecoder<State> {
    private static final int MAX_FIELD_LENGTH = 255;
    private String dstAddr;
    private int dstPort;
    private Socks4CommandType type;
    private String userId;

    enum State {
        START,
        READ_USERID,
        READ_DOMAIN,
        SUCCESS,
        FAILURE
    }

    public Socks4ServerDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    /* renamed from: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State = iArr;
            try {
                iArr[State.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.READ_USERID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.READ_DOMAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State[State.FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:2:0x0000, B:15:0x001f, B:17:0x0091, B:19:0x0097, B:22:0x0060, B:24:0x006a, B:26:0x0074, B:27:0x007c, B:28:0x0053, B:29:0x0028, B:31:0x0034, B:32:0x009f, B:33:0x00b7), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r5, io.netty.buffer.ByteBuf r6, java.util.List<java.lang.Object> r7) throws java.lang.Exception {
        /*
            r4 = this;
            int[] r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ServerDecoder$State     // Catch: java.lang.Exception -> Lb8
            java.lang.Object r0 = r4.state()     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r0 = (io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State) r0     // Catch: java.lang.Exception -> Lb8
            int r0 = r0.ordinal()     // Catch: java.lang.Exception -> Lb8
            r5 = r5[r0]     // Catch: java.lang.Exception -> Lb8
            r0 = 1
            if (r5 == r0) goto L28
            r0 = 2
            if (r5 == r0) goto L53
            r0 = 3
            if (r5 == r0) goto L60
            r0 = 4
            if (r5 == r0) goto L91
            r0 = 5
            if (r5 == r0) goto L1f
            goto Lbc
        L1f:
            int r5 = r4.actualReadableBytes()     // Catch: java.lang.Exception -> Lb8
            r6.skipBytes(r5)     // Catch: java.lang.Exception -> Lb8
            goto Lbc
        L28:
            short r5 = r6.readUnsignedByte()     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.SocksVersion r0 = io.netty.handler.codec.socksx.SocksVersion.SOCKS4a     // Catch: java.lang.Exception -> Lb8
            byte r0 = r0.byteValue()     // Catch: java.lang.Exception -> Lb8
            if (r5 != r0) goto L9f
            byte r5 = r6.readByte()     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.v4.Socks4CommandType r5 = io.netty.handler.codec.socksx.v4.Socks4CommandType.valueOf(r5)     // Catch: java.lang.Exception -> Lb8
            r4.type = r5     // Catch: java.lang.Exception -> Lb8
            int r5 = r6.readUnsignedShort()     // Catch: java.lang.Exception -> Lb8
            r4.dstPort = r5     // Catch: java.lang.Exception -> Lb8
            int r5 = r6.readInt()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r5 = io.netty.util.NetUtil.intToIpAddress(r5)     // Catch: java.lang.Exception -> Lb8
            r4.dstAddr = r5     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_USERID     // Catch: java.lang.Exception -> Lb8
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> Lb8
        L53:
            java.lang.String r5 = "userid"
            java.lang.String r5 = readString(r5, r6)     // Catch: java.lang.Exception -> Lb8
            r4.userId = r5     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.READ_DOMAIN     // Catch: java.lang.Exception -> Lb8
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> Lb8
        L60:
            java.lang.String r5 = "0.0.0.0"
            java.lang.String r0 = r4.dstAddr     // Catch: java.lang.Exception -> Lb8
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Exception -> Lb8
            if (r5 != 0) goto L7c
            java.lang.String r5 = r4.dstAddr     // Catch: java.lang.Exception -> Lb8
            java.lang.String r0 = "0.0.0."
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> Lb8
            if (r5 == 0) goto L7c
            java.lang.String r5 = "dstAddr"
            java.lang.String r5 = readString(r5, r6)     // Catch: java.lang.Exception -> Lb8
            r4.dstAddr = r5     // Catch: java.lang.Exception -> Lb8
        L7c:
            io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest r5 = new io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.v4.Socks4CommandType r0 = r4.type     // Catch: java.lang.Exception -> Lb8
            java.lang.String r1 = r4.dstAddr     // Catch: java.lang.Exception -> Lb8
            int r2 = r4.dstPort     // Catch: java.lang.Exception -> Lb8
            java.lang.String r3 = r4.userId     // Catch: java.lang.Exception -> Lb8
            r5.<init>(r0, r1, r2, r3)     // Catch: java.lang.Exception -> Lb8
            r7.add(r5)     // Catch: java.lang.Exception -> Lb8
            io.netty.handler.codec.socksx.v4.Socks4ServerDecoder$State r5 = io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.State.SUCCESS     // Catch: java.lang.Exception -> Lb8
            r4.checkpoint(r5)     // Catch: java.lang.Exception -> Lb8
        L91:
            int r5 = r4.actualReadableBytes()     // Catch: java.lang.Exception -> Lb8
            if (r5 <= 0) goto Lbc
            io.netty.buffer.ByteBuf r5 = r6.readRetainedSlice(r5)     // Catch: java.lang.Exception -> Lb8
            r7.add(r5)     // Catch: java.lang.Exception -> Lb8
            goto Lbc
        L9f:
            io.netty.handler.codec.DecoderException r6 = new io.netty.handler.codec.DecoderException     // Catch: java.lang.Exception -> Lb8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb8
            r0.<init>()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r1 = "unsupported protocol version: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lb8
            java.lang.StringBuilder r5 = r0.append(r5)     // Catch: java.lang.Exception -> Lb8
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Lb8
            r6.<init>(r5)     // Catch: java.lang.Exception -> Lb8
            throw r6     // Catch: java.lang.Exception -> Lb8
        Lb8:
            r5 = move-exception
            r4.fail(r7, r5)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.socksx.v4.Socks4ServerDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        Socks4CommandType socks4CommandType = this.type;
        if (socks4CommandType == null) {
            socks4CommandType = Socks4CommandType.CONNECT;
        }
        String str = this.dstAddr;
        if (str == null) {
            str = "";
        }
        int i = this.dstPort;
        if (i == 0) {
            i = 65535;
        }
        String str2 = this.userId;
        DefaultSocks4CommandRequest defaultSocks4CommandRequest = new DefaultSocks4CommandRequest(socks4CommandType, str, i, str2 != null ? str2 : "");
        defaultSocks4CommandRequest.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks4CommandRequest);
        checkpoint(State.FAILURE);
    }

    private static String readString(String str, ByteBuf byteBuf) {
        int bytesBefore = byteBuf.bytesBefore(256, (byte) 0);
        if (bytesBefore < 0) {
            throw new DecoderException("field '" + str + "' longer than 255 chars");
        }
        String byteBuf2 = byteBuf.readSlice(bytesBefore).toString(CharsetUtil.US_ASCII);
        byteBuf.skipBytes(1);
        return byteBuf2;
    }
}

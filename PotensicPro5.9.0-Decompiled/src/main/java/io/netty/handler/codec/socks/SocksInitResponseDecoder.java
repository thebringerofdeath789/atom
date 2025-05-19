package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* loaded from: classes3.dex */
public class SocksInitResponseDecoder extends ReplayingDecoder<State> {

    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_PREFERRED_AUTH_TYPE
    }

    public SocksInitResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* renamed from: io.netty.handler.codec.socks.SocksInitResponseDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State[State.READ_PREFERRED_AUTH_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksInitResponseDecoder$State[state().ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new Error();
            }
        } else {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_PREFERRED_AUTH_TYPE);
        }
        list.add(new SocksInitResponse(SocksAuthScheme.valueOf(byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}

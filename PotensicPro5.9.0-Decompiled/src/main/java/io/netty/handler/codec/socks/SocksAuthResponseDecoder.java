package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/* loaded from: classes3.dex */
public class SocksAuthResponseDecoder extends ReplayingDecoder<State> {

    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_RESPONSE
    }

    public SocksAuthResponseDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* renamed from: io.netty.handler.codec.socks.SocksAuthResponseDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State[State.READ_AUTH_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAuthResponseDecoder$State[state().ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new Error();
            }
        } else {
            if (byteBuf.readByte() != SocksSubnegotiationVersion.AUTH_PASSWORD.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_RESPONSE);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_AUTH_RESPONSE);
        }
        list.add(new SocksAuthResponse(SocksAuthStatus.valueOf(byteBuf.readByte())));
        channelHandlerContext.pipeline().remove(this);
    }
}

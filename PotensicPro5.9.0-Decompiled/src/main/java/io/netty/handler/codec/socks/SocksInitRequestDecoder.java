package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class SocksInitRequestDecoder extends ReplayingDecoder<State> {

    enum State {
        CHECK_PROTOCOL_VERSION,
        READ_AUTH_SCHEMES
    }

    public SocksInitRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* renamed from: io.netty.handler.codec.socks.SocksInitRequestDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[State.READ_AUTH_SCHEMES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        List emptyList;
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksInitRequestDecoder$State[state().ordinal()];
        if (i == 1) {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
                channelHandlerContext.pipeline().remove(this);
            }
            checkpoint(State.READ_AUTH_SCHEMES);
        } else if (i != 2) {
            throw new Error();
        }
        byte readByte = byteBuf.readByte();
        if (readByte > 0) {
            emptyList = new ArrayList(readByte);
            for (int i2 = 0; i2 < readByte; i2++) {
                emptyList.add(SocksAuthScheme.valueOf(byteBuf.readByte()));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        list.add(new SocksInitRequest(emptyList));
        channelHandlerContext.pipeline().remove(this);
    }
}

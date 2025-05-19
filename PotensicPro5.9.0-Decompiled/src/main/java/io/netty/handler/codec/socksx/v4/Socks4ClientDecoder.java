package io.netty.handler.codec.socksx.v4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.NetUtil;
import java.util.List;

/* loaded from: classes3.dex */
public class Socks4ClientDecoder extends ReplayingDecoder<State> {

    enum State {
        START,
        SUCCESS,
        FAILURE
    }

    public Socks4ClientDecoder() {
        super(State.START);
        setSingleDecode(true);
    }

    /* renamed from: io.netty.handler.codec.socksx.v4.Socks4ClientDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State = iArr;
            try {
                iArr[State.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State[State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State[State.FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socksx$v4$Socks4ClientDecoder$State[state().ordinal()];
            if (i == 1) {
                short readUnsignedByte = byteBuf.readUnsignedByte();
                if (readUnsignedByte != 0) {
                    throw new DecoderException("unsupported reply version: " + ((int) readUnsignedByte) + " (expected: 0)");
                }
                list.add(new DefaultSocks4CommandResponse(Socks4CommandStatus.valueOf(byteBuf.readByte()), NetUtil.intToIpAddress(byteBuf.readInt()), byteBuf.readUnsignedShort()));
                checkpoint(State.SUCCESS);
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                byteBuf.skipBytes(actualReadableBytes());
                return;
            }
            int actualReadableBytes = actualReadableBytes();
            if (actualReadableBytes > 0) {
                list.add(byteBuf.readRetainedSlice(actualReadableBytes));
            }
        } catch (Exception e) {
            fail(list, e);
        }
    }

    private void fail(List<Object> list, Exception exc) {
        if (!(exc instanceof DecoderException)) {
            exc = new DecoderException(exc);
        }
        DefaultSocks4CommandResponse defaultSocks4CommandResponse = new DefaultSocks4CommandResponse(Socks4CommandStatus.REJECTED_OR_FAILED);
        defaultSocks4CommandResponse.setDecoderResult(DecoderResult.failure(exc));
        list.add(defaultSocks4CommandResponse);
        checkpoint(State.FAILURE);
    }
}

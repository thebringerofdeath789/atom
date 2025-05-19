package io.netty.handler.codec.socksx.v5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.StringUtil;
import java.util.Objects;

@ChannelHandler.Sharable
/* loaded from: classes3.dex */
public class Socks5ServerEncoder extends MessageToByteEncoder<Socks5Message> {
    public static final Socks5ServerEncoder DEFAULT = new Socks5ServerEncoder(Socks5AddressEncoder.DEFAULT);
    private final Socks5AddressEncoder addressEncoder;

    protected Socks5ServerEncoder() {
        this(Socks5AddressEncoder.DEFAULT);
    }

    public Socks5ServerEncoder(Socks5AddressEncoder socks5AddressEncoder) {
        Objects.requireNonNull(socks5AddressEncoder, "addressEncoder");
        this.addressEncoder = socks5AddressEncoder;
    }

    protected final Socks5AddressEncoder addressEncoder() {
        return this.addressEncoder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, Socks5Message socks5Message, ByteBuf byteBuf) throws Exception {
        if (socks5Message instanceof Socks5InitialResponse) {
            encodeAuthMethodResponse((Socks5InitialResponse) socks5Message, byteBuf);
        } else if (socks5Message instanceof Socks5PasswordAuthResponse) {
            encodePasswordAuthResponse((Socks5PasswordAuthResponse) socks5Message, byteBuf);
        } else {
            if (socks5Message instanceof Socks5CommandResponse) {
                encodeCommandResponse((Socks5CommandResponse) socks5Message, byteBuf);
                return;
            }
            throw new EncoderException("unsupported message type: " + StringUtil.simpleClassName(socks5Message));
        }
    }

    private static void encodeAuthMethodResponse(Socks5InitialResponse socks5InitialResponse, ByteBuf byteBuf) {
        byteBuf.writeByte(socks5InitialResponse.version().byteValue());
        byteBuf.writeByte(socks5InitialResponse.authMethod().byteValue());
    }

    private static void encodePasswordAuthResponse(Socks5PasswordAuthResponse socks5PasswordAuthResponse, ByteBuf byteBuf) {
        byteBuf.writeByte(1);
        byteBuf.writeByte(socks5PasswordAuthResponse.status().byteValue());
    }

    private void encodeCommandResponse(Socks5CommandResponse socks5CommandResponse, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(socks5CommandResponse.version().byteValue());
        byteBuf.writeByte(socks5CommandResponse.status().byteValue());
        byteBuf.writeByte(0);
        Socks5AddressType bndAddrType = socks5CommandResponse.bndAddrType();
        byteBuf.writeByte(bndAddrType.byteValue());
        this.addressEncoder.encodeAddress(bndAddrType, socks5CommandResponse.bndAddr(), byteBuf);
        byteBuf.writeShort(socks5CommandResponse.bndPort());
    }
}

package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class SocksAuthResponse extends SocksResponse {
    private static final SocksSubnegotiationVersion SUBNEGOTIATION_VERSION = SocksSubnegotiationVersion.AUTH_PASSWORD;
    private final SocksAuthStatus authStatus;

    public SocksAuthResponse(SocksAuthStatus socksAuthStatus) {
        super(SocksResponseType.AUTH);
        Objects.requireNonNull(socksAuthStatus, "authStatus");
        this.authStatus = socksAuthStatus;
    }

    public SocksAuthStatus authStatus() {
        return this.authStatus;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(SUBNEGOTIATION_VERSION.byteValue());
        byteBuf.writeByte(this.authStatus.byteValue());
    }
}

package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class SocksMessage {
    private final SocksProtocolVersion protocolVersion = SocksProtocolVersion.SOCKS5;
    private final SocksMessageType type;

    @Deprecated
    public abstract void encodeAsByteBuf(ByteBuf byteBuf);

    protected SocksMessage(SocksMessageType socksMessageType) {
        Objects.requireNonNull(socksMessageType, "type");
        this.type = socksMessageType;
    }

    public SocksMessageType type() {
        return this.type;
    }

    public SocksProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }
}

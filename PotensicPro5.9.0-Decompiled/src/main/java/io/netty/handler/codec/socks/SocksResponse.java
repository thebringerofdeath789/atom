package io.netty.handler.codec.socks;

import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class SocksResponse extends SocksMessage {
    private final SocksResponseType responseType;

    protected SocksResponse(SocksResponseType socksResponseType) {
        super(SocksMessageType.RESPONSE);
        Objects.requireNonNull(socksResponseType, "responseType");
        this.responseType = socksResponseType;
    }

    public SocksResponseType responseType() {
        return this.responseType;
    }
}

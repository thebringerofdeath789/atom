package io.netty.handler.codec.socks;

import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class SocksRequest extends SocksMessage {
    private final SocksRequestType requestType;

    protected SocksRequest(SocksRequestType socksRequestType) {
        super(SocksMessageType.REQUEST);
        Objects.requireNonNull(socksRequestType, "requestType");
        this.requestType = socksRequestType;
    }

    public SocksRequestType requestType() {
        return this.requestType;
    }
}

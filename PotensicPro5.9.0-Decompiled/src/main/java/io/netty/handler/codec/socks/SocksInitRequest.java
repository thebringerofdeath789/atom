package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class SocksInitRequest extends SocksRequest {
    private final List<SocksAuthScheme> authSchemes;

    public SocksInitRequest(List<SocksAuthScheme> list) {
        super(SocksRequestType.INIT);
        Objects.requireNonNull(list, "authSchemes");
        this.authSchemes = list;
    }

    public List<SocksAuthScheme> authSchemes() {
        return Collections.unmodifiableList(this.authSchemes);
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.authSchemes.size());
        Iterator<SocksAuthScheme> it = this.authSchemes.iterator();
        while (it.hasNext()) {
            byteBuf.writeByte(it.next().byteValue());
        }
    }
}

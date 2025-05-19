package io.netty.handler.codec.socksx;

import io.netty.handler.codec.DecoderResult;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class AbstractSocksMessage implements SocksMessage {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        Objects.requireNonNull(decoderResult, "decoderResult");
        this.decoderResult = decoderResult;
    }
}

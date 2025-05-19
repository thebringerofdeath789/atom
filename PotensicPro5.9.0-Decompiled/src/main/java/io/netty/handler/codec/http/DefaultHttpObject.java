package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DefaultHttpObject implements HttpObject {
    private static final int HASH_CODE_PRIME = 31;
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    protected DefaultHttpObject() {
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.http.HttpObject
    @Deprecated
    public DecoderResult getDecoderResult() {
        return decoderResult();
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        Objects.requireNonNull(decoderResult, "decoderResult");
        this.decoderResult = decoderResult;
    }

    public int hashCode() {
        return 31 + this.decoderResult.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttpObject) {
            return decoderResult().equals(((DefaultHttpObject) obj).decoderResult());
        }
        return false;
    }
}

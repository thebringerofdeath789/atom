package io.netty.handler.codec.memcache;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.AbstractReferenceCounted;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class AbstractMemcacheObject extends AbstractReferenceCounted implements MemcacheObject {
    private DecoderResult decoderResult = DecoderResult.SUCCESS;

    protected AbstractMemcacheObject() {
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public DecoderResult decoderResult() {
        return this.decoderResult;
    }

    @Override // io.netty.handler.codec.DecoderResultProvider
    public void setDecoderResult(DecoderResult decoderResult) {
        Objects.requireNonNull(decoderResult, "DecoderResult should not be null.");
        this.decoderResult = decoderResult;
    }
}

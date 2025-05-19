package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes4.dex */
class PemValue extends AbstractReferenceCounted implements PemEncoded {
    private final ByteBuf content;
    private final boolean sensitive;

    public PemValue(ByteBuf byteBuf, boolean z) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.sensitive = z;
    }

    @Override // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return this.sensitive;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int refCnt = refCnt();
        if (refCnt <= 0) {
            throw new IllegalReferenceCountException(refCnt);
        }
        return this.content;
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemValue replace(ByteBuf byteBuf) {
        return new PemValue(byteBuf, this.sensitive);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemValue touch() {
        return (PemValue) super.touch();
    }

    @Override // io.netty.util.ReferenceCounted
    public PemValue touch(Object obj) {
        this.content.touch(obj);
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemValue retain() {
        return (PemValue) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemValue retain(int i) {
        return (PemValue) super.retain(i);
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        if (this.sensitive) {
            SslUtils.zeroout(this.content);
        }
        this.content.release();
    }
}

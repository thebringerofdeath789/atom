package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.security.PrivateKey;

/* loaded from: classes4.dex */
public final class PemPrivateKey extends AbstractReferenceCounted implements PrivateKey, PemEncoded {
    private static final byte[] BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n".getBytes(CharsetUtil.US_ASCII);
    private static final byte[] END_PRIVATE_KEY = "\n-----END PRIVATE KEY-----\n".getBytes(CharsetUtil.US_ASCII);
    private static final String PKCS8_FORMAT = "PKCS#8";
    private static final long serialVersionUID = 7978017465645018936L;
    private final ByteBuf content;

    @Override // java.security.Key
    public String getFormat() {
        return PKCS8_FORMAT;
    }

    @Override // io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return true;
    }

    static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, PrivateKey privateKey) {
        if (privateKey instanceof PemEncoded) {
            return ((PemEncoded) privateKey).retain();
        }
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(privateKey.getEncoded());
        try {
            ByteBuf base64 = SslUtils.toBase64(byteBufAllocator, wrappedBuffer);
            try {
                byte[] bArr = BEGIN_PRIVATE_KEY;
                int length = bArr.length + base64.readableBytes();
                byte[] bArr2 = END_PRIVATE_KEY;
                int length2 = length + bArr2.length;
                ByteBuf directBuffer = z ? byteBufAllocator.directBuffer(length2) : byteBufAllocator.buffer(length2);
                try {
                    directBuffer.writeBytes(bArr);
                    directBuffer.writeBytes(base64);
                    directBuffer.writeBytes(bArr2);
                    return new PemValue(directBuffer, true);
                } finally {
                }
            } finally {
                SslUtils.zerooutAndRelease(base64);
            }
        } finally {
            SslUtils.zerooutAndRelease(wrappedBuffer);
        }
    }

    public static PemPrivateKey valueOf(byte[] bArr) {
        return valueOf(Unpooled.wrappedBuffer(bArr));
    }

    public static PemPrivateKey valueOf(ByteBuf byteBuf) {
        return new PemPrivateKey(byteBuf);
    }

    private PemPrivateKey(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
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
    public PemPrivateKey copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // io.netty.handler.ssl.PemEncoded, io.netty.buffer.ByteBufHolder
    public PemPrivateKey replace(ByteBuf byteBuf) {
        return new PemPrivateKey(byteBuf);
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemPrivateKey touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public PemPrivateKey touch(Object obj) {
        this.content.touch(obj);
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemPrivateKey retain() {
        return (PemPrivateKey) super.retain();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public PemPrivateKey retain(int i) {
        return (PemPrivateKey) super.retain(i);
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        SslUtils.zerooutAndRelease(this.content);
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        release(refCnt());
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return refCnt() == 0;
    }
}

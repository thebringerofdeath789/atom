package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import java.util.Objects;
import javax.xml.transform.OutputKeys;

/* loaded from: classes3.dex */
public abstract class DefaultHttpMessage extends DefaultHttpObject implements HttpMessage {
    private static final int HASH_CODE_PRIME = 31;
    private final HttpHeaders headers;
    private HttpVersion version;

    protected DefaultHttpMessage(HttpVersion httpVersion) {
        this(httpVersion, true, false);
    }

    protected DefaultHttpMessage(HttpVersion httpVersion, boolean z, boolean z2) {
        this(httpVersion, z2 ? new CombinedHttpHeaders(z) : new DefaultHttpHeaders(z));
    }

    protected DefaultHttpMessage(HttpVersion httpVersion, HttpHeaders httpHeaders) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, OutputKeys.VERSION);
        this.headers = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders, "headers");
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    @Deprecated
    public HttpVersion getProtocolVersion() {
        return protocolVersion();
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpVersion protocolVersion() {
        return this.version;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((((this.headers.hashCode() + 31) * 31) + this.version.hashCode()) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpMessage)) {
            return false;
        }
        DefaultHttpMessage defaultHttpMessage = (DefaultHttpMessage) obj;
        return headers().equals(defaultHttpMessage.headers()) && protocolVersion().equals(defaultHttpMessage.protocolVersion()) && super.equals(obj);
    }

    public HttpMessage setProtocolVersion(HttpVersion httpVersion) {
        Objects.requireNonNull(httpVersion, OutputKeys.VERSION);
        this.version = httpVersion;
        return this;
    }
}

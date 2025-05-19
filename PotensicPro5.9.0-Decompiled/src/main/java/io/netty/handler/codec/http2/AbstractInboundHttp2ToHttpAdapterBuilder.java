package io.netty.handler.codec.http2;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder;
import io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public abstract class AbstractInboundHttp2ToHttpAdapterBuilder<T extends InboundHttp2ToHttpAdapter, B extends AbstractInboundHttp2ToHttpAdapterBuilder<T, B>> {
    private final Http2Connection connection;
    private int maxContentLength;
    private boolean propagateSettings;
    private boolean validateHttpHeaders;

    protected abstract T build(Http2Connection http2Connection, int i, boolean z, boolean z2) throws Exception;

    protected final B self() {
        return this;
    }

    protected AbstractInboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, RtspHeaders.CONNECTION);
    }

    protected Http2Connection connection() {
        return this.connection;
    }

    protected int maxContentLength() {
        return this.maxContentLength;
    }

    protected B maxContentLength(int i) {
        this.maxContentLength = i;
        return self();
    }

    protected boolean isValidateHttpHeaders() {
        return this.validateHttpHeaders;
    }

    protected B validateHttpHeaders(boolean z) {
        this.validateHttpHeaders = z;
        return self();
    }

    protected boolean isPropagateSettings() {
        return this.propagateSettings;
    }

    protected B propagateSettings(boolean z) {
        this.propagateSettings = z;
        return self();
    }

    protected T build() {
        try {
            T build = build(connection(), maxContentLength(), isValidateHttpHeaders(), isPropagateSettings());
            this.connection.addListener(build);
            return build;
        } catch (Throwable th) {
            throw new IllegalStateException("failed to create a new InboundHttp2ToHttpAdapter", th);
        }
    }
}

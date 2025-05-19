package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;

@Deprecated
/* loaded from: classes.dex */
public final class DefaultHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final TransferListener listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public DefaultHttpDataSourceFactory() {
        this(null);
    }

    public DefaultHttpDataSourceFactory(String str) {
        this(str, null);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener transferListener) {
        this(str, transferListener, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(String str, int i, int i2, boolean z) {
        this(str, null, i, i2, z);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener transferListener, int i, int i2, boolean z) {
        this.userAgent = str;
        this.listener = transferListener;
        this.connectTimeoutMillis = i;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.userAgent, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, requestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            defaultHttpDataSource.addTransferListener(transferListener);
        }
        return defaultHttpDataSource;
    }
}

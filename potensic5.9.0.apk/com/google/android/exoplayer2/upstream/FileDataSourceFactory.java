package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;

@Deprecated
/* loaded from: classes.dex */
public final class FileDataSourceFactory implements DataSource.Factory {
    private final FileDataSource.Factory wrappedFactory;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(TransferListener transferListener) {
        this.wrappedFactory = new FileDataSource.Factory().setListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public FileDataSource createDataSource() {
        return this.wrappedFactory.createDataSource();
    }
}
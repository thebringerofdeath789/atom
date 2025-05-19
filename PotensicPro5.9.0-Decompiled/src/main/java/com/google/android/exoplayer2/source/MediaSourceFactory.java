package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;

/* loaded from: classes.dex */
public interface MediaSourceFactory {
    MediaSource createMediaSource(MediaItem mediaItem);

    int[] getSupportedTypes();

    @Deprecated
    MediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory);

    @Deprecated
    MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager);

    MediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider);

    @Deprecated
    MediaSourceFactory setDrmUserAgent(String str);

    MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    @Deprecated
    default MediaSourceFactory setStreamKeys(List<StreamKey> list) {
        return this;
    }

    @Deprecated
    default MediaSource createMediaSource(Uri uri) {
        return createMediaSource(MediaItem.fromUri(uri));
    }
}

package xyz.doikki.videoplayer.exo;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.database.ExoDatabaseProvider;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSourceFactory;
import com.google.android.exoplayer2.ext.rtmp.RtmpDataSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.ipotensic.baselib.okhttp.ClientManager;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import okhttp3.OkHttpClient;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes6.dex */
public final class ExoMediaSourceHelper {
    public static boolean isServerVideo = true;
    private static ExoMediaSourceHelper sInstance;
    private final Context mAppContext;
    private Cache mCache;
    private HttpDataSource.Factory mHttpDataSourceFactory;
    private final String mUserAgent;

    private ExoMediaSourceHelper(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mUserAgent = Util.getUserAgent(applicationContext, applicationContext.getApplicationInfo().name);
    }

    public static ExoMediaSourceHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ExoMediaSourceHelper.class) {
                if (sInstance == null) {
                    sInstance = new ExoMediaSourceHelper(context);
                }
            }
        }
        return sInstance;
    }

    public MediaSource getMediaSource(String str) {
        return getMediaSource(str, null, false);
    }

    public MediaSource getMediaSource(String str, Map<String, String> map) {
        return getMediaSource(str, map, false);
    }

    public MediaSource getMediaSource(String str, boolean z) {
        return getMediaSource(str, null, z);
    }

    public MediaSource getMediaSource(String str, Map<String, String> map, boolean z) {
        DataSource.Factory dataSourceFactory;
        Uri parse = Uri.parse(str);
        if ("rtmp".equals(parse.getScheme())) {
            return new ProgressiveMediaSource.Factory(new RtmpDataSourceFactory(null)).createMediaSource(MediaItem.fromUri(parse));
        }
        if ("rtsp".equals(parse.getScheme())) {
            return new RtspMediaSource.Factory().createMediaSource(MediaItem.fromUri(parse));
        }
        int inferContentType = inferContentType(str);
        if (z) {
            dataSourceFactory = getCacheDataSourceFactory();
        } else {
            dataSourceFactory = getDataSourceFactory();
        }
        if (this.mHttpDataSourceFactory != null) {
            setHeaders(map);
        }
        if (inferContentType == 0) {
            return new DashMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(parse));
        }
        if (inferContentType == 2) {
            return new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(parse));
        }
        return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(parse));
    }

    private int inferContentType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains(".mpd")) {
            return 0;
        }
        return lowerCase.contains(".m3u8") ? 2 : 4;
    }

    private DataSource.Factory getCacheDataSourceFactory() {
        if (this.mCache == null) {
            this.mCache = newCache();
        }
        return new CacheDataSource.Factory().setCache(this.mCache).setUpstreamDataSourceFactory(getDataSourceFactory()).setFlags(2);
    }

    private Cache newCache() {
        return new SimpleCache(new File(this.mAppContext.getExternalCacheDir(), "exo-video-cache"), new LeastRecentlyUsedCacheEvictor(IjkMediaMeta.AV_CH_STEREO_LEFT), new ExoDatabaseProvider(this.mAppContext));
    }

    private DataSource.Factory getDataSourceFactory() {
        return new DefaultDataSourceFactory(this.mAppContext, getHttpDataSourceFactory());
    }

    private DataSource.Factory getHttpDataSourceFactory() {
        if (isServerVideo) {
            Log.e("ddlog", "使用okhttp");
            OkHttpClient client = ClientManager.getInstance().getClient();
            Context context = this.mAppContext;
            OkHttpDataSourceFactory okHttpDataSourceFactory = new OkHttpDataSourceFactory(client, Util.getUserAgent(context, context.getApplicationContext().getPackageName()), new DefaultBandwidthMeter());
            this.mHttpDataSourceFactory = okHttpDataSourceFactory;
            return okHttpDataSourceFactory;
        }
        DefaultHttpDataSource.Factory allowCrossProtocolRedirects = new DefaultHttpDataSource.Factory().setUserAgent(this.mUserAgent).setAllowCrossProtocolRedirects(true);
        this.mHttpDataSourceFactory = allowCrossProtocolRedirects;
        return allowCrossProtocolRedirects;
    }

    private void setHeaders(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        if (map.containsKey("User-Agent")) {
            String remove = map.remove("User-Agent");
            if (!TextUtils.isEmpty(remove)) {
                try {
                    Field declaredField = this.mHttpDataSourceFactory.getClass().getDeclaredField("userAgent");
                    declaredField.setAccessible(true);
                    declaredField.set(this.mHttpDataSourceFactory, remove);
                } catch (Exception unused) {
                }
            }
        }
        this.mHttpDataSourceFactory.setDefaultRequestProperties(map);
    }

    public void setCache(Cache cache) {
        this.mCache = cache;
    }
}

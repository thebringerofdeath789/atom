package com.ipotensic.baselib.mediadataretriever.cache;

import android.content.Context;
import com.ipotensic.baselib.mediadataretriever.utils.MD5Util;
import java.io.File;

/* loaded from: classes2.dex */
public class SettingBuilder {
    public static final int DEFAULT_DISK_CACHE_VALUE_COUNT = 100;
    public static final long DEFAULT_MAX_CACHE_SIZE = 209715200;
    private File cacheDir;
    private CacheKeyProvider cacheKeyProvider;
    private Context context;
    private int defaultPlaceHolder;
    private int diskCacheValueCount = 100;
    private long maxDiskCacheSize = DEFAULT_MAX_CACHE_SIZE;
    private int maxMemoryCacheSize;

    public interface CacheKeyProvider {
        String getCacheKey(String str);
    }

    public Context getContext() {
        return this.context;
    }

    public SettingBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

    public File getCacheDir() {
        return this.cacheDir;
    }

    public SettingBuilder setCacheDir(File file) {
        this.cacheDir = file;
        return this;
    }

    public int getDefaultPlaceHolder() {
        return this.defaultPlaceHolder;
    }

    public SettingBuilder setDefaultPlaceHolder(int i) {
        this.defaultPlaceHolder = i;
        return this;
    }

    public int getDiskCacheValueCount() {
        return this.diskCacheValueCount;
    }

    public SettingBuilder setDiskCacheValueCount(int i) {
        this.diskCacheValueCount = i;
        return this;
    }

    public int getMaxMemoryCacheSize() {
        return this.maxMemoryCacheSize;
    }

    public SettingBuilder setMaxMemoryCacheSize(int i) {
        this.maxMemoryCacheSize = i;
        return this;
    }

    public long getMaxDiskCacheSize() {
        return this.maxDiskCacheSize;
    }

    public SettingBuilder setMaxDiskCacheSize(long j) {
        this.maxDiskCacheSize = j;
        return this;
    }

    public CacheKeyProvider getCacheKeyProvider() {
        return this.cacheKeyProvider;
    }

    public SettingBuilder setCacheKeyProvider(CacheKeyProvider cacheKeyProvider) {
        this.cacheKeyProvider = cacheKeyProvider;
        return this;
    }

    public static class DefaultCacheKeyProvider implements CacheKeyProvider {
        @Override // com.ipotensic.baselib.mediadataretriever.cache.SettingBuilder.CacheKeyProvider
        public String getCacheKey(String str) {
            return MD5Util.md5(str);
        }
    }
}

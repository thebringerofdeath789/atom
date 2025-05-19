package com.ipotensic.baselib.mediadataretriever.cache;

import android.graphics.Bitmap;
import java.io.File;

/* loaded from: classes2.dex */
public class CacheManager {
    private static CacheManager instance;
    private final String TAG = "CacheManager";
    private DiskCacheManager mDiskCacheManager;
    private LruCacheManager mLruCacheManager;

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        if (instance == null) {
            synchronized (CacheManager.class) {
                if (instance == null) {
                    instance = new CacheManager();
                }
            }
        }
        return instance;
    }

    public boolean isHasInit() {
        return (this.mDiskCacheManager == null || this.mLruCacheManager == null) ? false : true;
    }

    public void init(SettingBuilder settingBuilder) {
        this.mDiskCacheManager = new DiskCacheManager(settingBuilder);
        this.mLruCacheManager = new LruCacheManager(settingBuilder);
    }

    public Bitmap getLruCache(String str) {
        return this.mLruCacheManager.getCache(str);
    }

    public Bitmap putLruCache(String str, Bitmap bitmap) {
        return this.mLruCacheManager.putCache(str, bitmap);
    }

    public boolean putDiskCache(String str, Bitmap bitmap) {
        return this.mDiskCacheManager.putDiskCache(str, bitmap);
    }

    public File getDiskCacheDirectory() {
        return this.mDiskCacheManager.getCacheDirectory();
    }

    public Bitmap getDiskCache(String str) {
        return this.mDiskCacheManager.getDiskCache(str);
    }
}

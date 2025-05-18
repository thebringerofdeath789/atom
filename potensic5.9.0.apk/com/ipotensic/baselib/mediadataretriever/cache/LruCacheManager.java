package com.ipotensic.baselib.mediadataretriever.cache;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class LruCacheManager {
    private LruCache<String, Bitmap> mLruCache;

    public LruCacheManager(SettingBuilder settingBuilder) {
        this.mLruCache = new LruCache<String, Bitmap>(settingBuilder.getMaxMemoryCacheSize()) { // from class: com.ipotensic.baselib.mediadataretriever.cache.LruCacheManager.1
            @Override // com.ipotensic.baselib.mediadataretriever.cache.LruCache
            protected int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    public Bitmap putCache(String str, Bitmap bitmap) {
        LruCache<String, Bitmap> lruCache;
        Bitmap cache = getCache(str);
        return (cache != null || (lruCache = this.mLruCache) == null || bitmap == null) ? cache : lruCache.put(str, bitmap);
    }

    public Bitmap getCache(String str) {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache != null) {
            return lruCache.get(str);
        }
        return null;
    }

    public void deleteCache() {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    public void removeCache(String str) {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.remove(str);
        }
    }

    public int size() {
        LruCache<String, Bitmap> lruCache = this.mLruCache;
        if (lruCache != null) {
            return 0 + lruCache.size();
        }
        return 0;
    }
}
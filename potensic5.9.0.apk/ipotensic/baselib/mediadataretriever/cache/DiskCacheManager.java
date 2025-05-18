package com.ipotensic.baselib.mediadataretriever.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.ipotensic.baselib.mediadataretriever.cache.DiskLruCache;
import com.ipotensic.baselib.mediadataretriever.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class DiskCacheManager {
    private DiskLruCache mDiskLruCache;
    private SettingBuilder settingBuilder;

    public DiskCacheManager(SettingBuilder settingBuilder) {
        this(settingBuilder.getCacheDir(), Utils.getAppVersion(settingBuilder.getContext()), settingBuilder.getDiskCacheValueCount(), settingBuilder.getMaxDiskCacheSize());
        this.settingBuilder = settingBuilder;
    }

    private DiskCacheManager(File file, int i, int i2, long j) {
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mDiskLruCache = DiskLruCache.open(file, i, i2, j);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getCacheDirectory() {
        return this.settingBuilder.getCacheDir();
    }

    private String getCacheKey(String str) {
        return this.settingBuilder.getCacheKeyProvider().getCacheKey(str);
    }

    public boolean putDiskCache(String str, Bitmap bitmap) {
        String cacheKey;
        DiskLruCache.Editor editor = null;
        try {
            cacheKey = getCacheKey(str);
        } catch (Exception e) {
            e.printStackTrace();
            if (0 != 0) {
                try {
                    editor.abort();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.mDiskLruCache.get(cacheKey) != null) {
            return true;
        }
        DiskLruCache.Editor edit = this.mDiskLruCache.edit(cacheKey);
        if (edit != null) {
            OutputStream newOutputStream = edit.newOutputStream(0);
            Utils.Bitmap2OutputStream(bitmap, newOutputStream);
            if (newOutputStream != null) {
                edit.commit();
                return true;
            }
            edit.abort();
            return false;
        }
        return false;
    }

    public void flushCache() {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            try {
                diskLruCache.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap getDiskCache(String str) {
        DiskLruCache.Snapshot snapshot;
        String cacheKey = getCacheKey(str);
        try {
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache == null || (snapshot = diskLruCache.get(cacheKey)) == null) {
                return null;
            }
            return BitmapFactory.decodeStream(snapshot.getInputStream(0));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteDiskCache() {
        try {
            DiskLruCache diskLruCache = this.mDiskLruCache;
            if (diskLruCache != null) {
                diskLruCache.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeDiskCache(String str) {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            try {
                diskLruCache.remove(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int size() {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            return (int) diskLruCache.size();
        }
        return 0;
    }

    public void close() {
        DiskLruCache diskLruCache = this.mDiskLruCache;
        if (diskLruCache != null) {
            try {
                diskLruCache.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
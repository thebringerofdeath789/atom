package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class LruCache implements Cache {
    private int evictionCount;
    private int hitCount;
    final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.squareup.picasso.Cache
    public Bitmap get(String str) {
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            Bitmap bitmap = this.map.get(str);
            if (bitmap != null) {
                this.hitCount++;
                return bitmap;
            }
            this.missCount++;
            return null;
        }
    }

    @Override // com.squareup.picasso.Cache
    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += Utils.getBitmapBytes(bitmap);
            Bitmap put = this.map.put(str, bitmap);
            if (put != null) {
                this.size -= Utils.getBitmapBytes(put);
            }
        }
        trimToSize(this.maxSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0072, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trimToSize(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.size     // Catch: java.lang.Throwable -> L73
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch: java.lang.Throwable -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L11
            int r0 = r3.size     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L52
        L11:
            int r0 = r3.size     // Catch: java.lang.Throwable -> L73
            if (r0 <= r4) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch: java.lang.Throwable -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.map     // Catch: java.lang.Throwable -> L73
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L73
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L73
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L73
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L73
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L73
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.map     // Catch: java.lang.Throwable -> L73
            r2.remove(r1)     // Catch: java.lang.Throwable -> L73
            int r1 = r3.size     // Catch: java.lang.Throwable -> L73
            int r0 = com.squareup.picasso.Utils.getBitmapBytes(r0)     // Catch: java.lang.Throwable -> L73
            int r1 = r1 - r0
            r3.size = r1     // Catch: java.lang.Throwable -> L73
            int r0 = r3.evictionCount     // Catch: java.lang.Throwable -> L73
            int r0 = r0 + 1
            r3.evictionCount = r0     // Catch: java.lang.Throwable -> L73
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            goto L0
        L50:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            return
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r0.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L73
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L73
            throw r4     // Catch: java.lang.Throwable -> L73
        L73:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.LruCache.trimToSize(int):void");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int size() {
        return this.size;
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int maxSize() {
        return this.maxSize;
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized void clear() {
        evictAll();
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized void clearKeyUri(String str) {
        int length = str.length();
        Iterator<Map.Entry<String, Bitmap>> it = this.map.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry<String, Bitmap> next = it.next();
            String key = next.getKey();
            Bitmap value = next.getValue();
            int indexOf = key.indexOf(10);
            if (indexOf == length && key.substring(0, indexOf).equals(str)) {
                it.remove();
                this.size -= Utils.getBitmapBytes(value);
                z = true;
            }
        }
        if (z) {
            trimToSize(this.maxSize);
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }
}

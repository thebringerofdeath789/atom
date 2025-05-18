package com.mapbox.mapboxsdk.style.sources;

import com.mapbox.mapboxsdk.LibraryLoader;
import com.mapbox.mapboxsdk.utils.ThreadUtils;

/* loaded from: classes3.dex */
public abstract class Source {
    private static final String TAG = "Mbgl-Source";
    protected boolean detached;
    private long nativePtr;

    protected native String nativeGetAttribution();

    protected native String nativeGetId();

    protected native Integer nativeGetMaxOverscaleFactorForParentTiles();

    protected native Long nativeGetMinimumTileUpdateInterval();

    protected native Integer nativeGetPrefetchZoomDelta();

    protected native Boolean nativeIsVolatile();

    protected native void nativeSetMaxOverscaleFactorForParentTiles(Integer num);

    protected native void nativeSetMinimumTileUpdateInterval(Long l);

    protected native void nativeSetPrefetchZoomDelta(Integer num);

    protected native void nativeSetVolatile(Boolean bool);

    static {
        LibraryLoader.load();
    }

    protected Source(long j) {
        checkThread();
        this.nativePtr = j;
    }

    public Source() {
        checkThread();
    }

    protected void checkThread() {
        ThreadUtils.checkThread(TAG);
    }

    public String getId() {
        checkThread();
        return nativeGetId();
    }

    public String getAttribution() {
        checkThread();
        return nativeGetAttribution();
    }

    public Integer getPrefetchZoomDelta() {
        return nativeGetPrefetchZoomDelta();
    }

    public void setPrefetchZoomDelta(Integer num) {
        nativeSetPrefetchZoomDelta(num);
    }

    public void setMaxOverscaleFactorForParentTiles(Integer num) {
        nativeSetMaxOverscaleFactorForParentTiles(num);
    }

    public Integer getMaxOverscaleFactorForParentTiles() {
        return nativeGetMaxOverscaleFactorForParentTiles();
    }

    public Boolean isVolatile() {
        return nativeIsVolatile();
    }

    public void setVolatile(Boolean bool) {
        nativeSetVolatile(bool);
    }

    public void setMinimumTileUpdateInterval(Long l) {
        nativeSetMinimumTileUpdateInterval(l);
    }

    public Long getMinimumTileUpdateInterval() {
        return nativeGetMinimumTileUpdateInterval();
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public void setDetached() {
        this.detached = true;
    }
}
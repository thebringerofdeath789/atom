package com.mapbox.mapboxsdk.style.layers;

import com.google.gson.JsonElement;
import com.mapbox.mapboxsdk.LibraryLoader;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.types.Formatted;
import com.mapbox.mapboxsdk.utils.ThreadUtils;

/* loaded from: classes3.dex */
public abstract class Layer {
    private static final String TAG = "Mbgl-Layer";
    private boolean detached;
    private boolean invalidated;
    private long nativePtr;

    protected native void finalize() throws Throwable;

    protected native JsonElement nativeGetFilter();

    protected native String nativeGetId();

    protected native float nativeGetMaxZoom();

    protected native float nativeGetMinZoom();

    protected native String nativeGetSourceId();

    protected native String nativeGetSourceLayer();

    protected native Object nativeGetVisibility();

    protected native void nativeSetFilter(Object[] objArr);

    protected native void nativeSetLayoutProperty(String str, Object obj);

    protected native void nativeSetMaxZoom(float f);

    protected native void nativeSetMinZoom(float f);

    protected native void nativeSetPaintProperty(String str, Object obj);

    protected native void nativeSetSourceLayer(String str);

    static {
        LibraryLoader.load();
    }

    protected Layer(long j) {
        checkThread();
        this.nativePtr = j;
    }

    public Layer() {
        checkThread();
    }

    protected void checkThread() {
        ThreadUtils.checkThread(TAG);
    }

    public void setProperties(PropertyValue<?>... propertyValueArr) {
        if (this.detached) {
            return;
        }
        checkThread();
        if (propertyValueArr.length == 0) {
            return;
        }
        for (PropertyValue<?> propertyValue : propertyValueArr) {
            Object convertValue = convertValue(propertyValue.value);
            if (propertyValue instanceof PaintPropertyValue) {
                nativeSetPaintProperty(propertyValue.name, convertValue);
            } else {
                nativeSetLayoutProperty(propertyValue.name, convertValue);
            }
        }
    }

    public String getId() {
        checkThread();
        return nativeGetId();
    }

    public PropertyValue<String> getVisibility() {
        checkThread();
        return new PaintPropertyValue("visibility", (String) nativeGetVisibility());
    }

    public float getMinZoom() {
        checkThread();
        return nativeGetMinZoom();
    }

    public float getMaxZoom() {
        checkThread();
        return nativeGetMaxZoom();
    }

    public void setMinZoom(float f) {
        checkThread();
        nativeSetMinZoom(f);
    }

    public void setMaxZoom(float f) {
        checkThread();
        nativeSetMaxZoom(f);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    private Object convertValue(Object obj) {
        if (obj instanceof Expression) {
            return ((Expression) obj).toArray();
        }
        return obj instanceof Formatted ? ((Formatted) obj).toArray() : obj;
    }

    public void setDetached() {
        this.detached = true;
    }

    public boolean isDetached() {
        return this.detached;
    }
}

package com.mapbox.mapboxsdk.style.sources;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLngQuad;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import java.net.URI;
import java.net.URL;

/* loaded from: classes3.dex */
public class ImageSource extends Source {
    protected native void finalize() throws Throwable;

    protected native void initialize(String str, LatLngQuad latLngQuad);

    protected native String nativeGetUrl();

    protected native void nativeSetCoordinates(LatLngQuad latLngQuad);

    protected native void nativeSetImage(Bitmap bitmap);

    protected native void nativeSetUrl(String str);

    ImageSource(long j) {
        super(j);
    }

    @Deprecated
    public ImageSource(String str, LatLngQuad latLngQuad, URL url) {
        initialize(str, latLngQuad);
        setUrl(url);
    }

    public ImageSource(String str, LatLngQuad latLngQuad, URI uri) {
        initialize(str, latLngQuad);
        setUri(uri);
    }

    public ImageSource(String str, LatLngQuad latLngQuad, Bitmap bitmap) {
        initialize(str, latLngQuad);
        setImage(bitmap);
    }

    public ImageSource(String str, LatLngQuad latLngQuad, int i) {
        initialize(str, latLngQuad);
        setImage(i);
    }

    @Deprecated
    public void setUrl(URL url) {
        setUrl(url.toExternalForm());
    }

    @Deprecated
    public void setUrl(String str) {
        checkThread();
        nativeSetUrl(str);
    }

    public void setUri(URI uri) {
        checkThread();
        nativeSetUrl(uri.toString());
    }

    public void setUri(String str) {
        checkThread();
        nativeSetUrl(str);
    }

    public void setImage(Bitmap bitmap) {
        checkThread();
        nativeSetImage(bitmap);
    }

    public void setImage(int i) throws IllegalArgumentException {
        checkThread();
        Drawable drawableFromRes = BitmapUtils.getDrawableFromRes(Mapbox.getApplicationContext(), i);
        if (drawableFromRes instanceof BitmapDrawable) {
            nativeSetImage(((BitmapDrawable) drawableFromRes).getBitmap());
            return;
        }
        throw new IllegalArgumentException("Failed to decode image. The resource provided must be a Bitmap.");
    }

    @Deprecated
    public String getUrl() {
        checkThread();
        return nativeGetUrl();
    }

    public String getUri() {
        checkThread();
        return nativeGetUrl();
    }

    public void setCoordinates(LatLngQuad latLngQuad) {
        checkThread();
        nativeSetCoordinates(latLngQuad);
    }
}
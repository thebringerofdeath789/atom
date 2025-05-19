package com.mapbox.mapboxsdk.offline;

import android.os.Parcelable;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;

/* loaded from: classes3.dex */
public interface OfflineRegionDefinition extends Parcelable {
    LatLngBounds getBounds();

    boolean getIncludeIdeographs();

    double getMaxZoom();

    double getMinZoom();

    float getPixelRatio();

    String getStyleURL();

    String getType();
}

package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.location.MapboxAnimator;
import com.mapbox.mapboxsdk.maps.MapboxMap;

/* loaded from: classes3.dex */
class MapboxCameraAnimatorAdapter extends MapboxFloatAnimator {
    MapboxCameraAnimatorAdapter(Float[] fArr, MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener, MapboxMap.CancelableCallback cancelableCallback) {
        super(fArr, animationsValueChangeListener, Integer.MAX_VALUE);
        addListener(new MapboxAnimatorListener(cancelableCallback));
    }
}

package com.mapbox.mapboxsdk.plugins.annotation;

import com.mapbox.mapboxsdk.plugins.annotation.Annotation;

/* loaded from: classes3.dex */
public interface OnAnnotationDragListener<T extends Annotation> {
    void onAnnotationDrag(T t);

    void onAnnotationDragFinished(T t);

    void onAnnotationDragStarted(T t);
}
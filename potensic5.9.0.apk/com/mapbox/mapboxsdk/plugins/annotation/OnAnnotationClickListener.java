package com.mapbox.mapboxsdk.plugins.annotation;

import com.mapbox.mapboxsdk.plugins.annotation.Annotation;

/* loaded from: classes3.dex */
public interface OnAnnotationClickListener<T extends Annotation> {
    boolean onAnnotationClick(T t);
}
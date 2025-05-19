package com.mapbox.mapboxsdk.plugins.annotation;

import com.mapbox.mapboxsdk.plugins.annotation.Annotation;

/* loaded from: classes3.dex */
public abstract class Options<T extends Annotation> {
    abstract T build(long j, AnnotationManager<?, T, ?, ?, ?, ?> annotationManager);
}

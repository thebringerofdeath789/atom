package com.mapbox.android.core.location;

/* loaded from: classes3.dex */
public interface LocationEngineCallback<T> {
    void onFailure(Exception exc);

    void onSuccess(T t);
}
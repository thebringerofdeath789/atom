package com.mapbox.api.matrix.p026v1;

import com.google.gson.TypeAdapterFactory;

/* loaded from: classes3.dex */
public abstract class MatrixAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_MatrixAdapterFactory();
    }
}
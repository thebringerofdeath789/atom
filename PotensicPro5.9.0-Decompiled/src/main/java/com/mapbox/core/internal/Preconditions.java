package com.mapbox.core.internal;

import java.util.Objects;

/* loaded from: classes3.dex */
public final class Preconditions {
    public static void checkNotNull(Object obj, String str) {
        Objects.requireNonNull(obj, str);
    }

    private Preconditions() {
        throw new AssertionError("No instances.");
    }
}

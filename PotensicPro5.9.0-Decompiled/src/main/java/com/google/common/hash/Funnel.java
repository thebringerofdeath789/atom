package com.google.common.hash;

import java.io.Serializable;

/* loaded from: classes2.dex */
public interface Funnel<T> extends Serializable {
    void funnel(T t, PrimitiveSink primitiveSink);
}

package com.google.common.graph;

/* loaded from: classes2.dex */
public interface SuccessorsFunction<N> {
    Iterable<? extends N> successors(N n);
}
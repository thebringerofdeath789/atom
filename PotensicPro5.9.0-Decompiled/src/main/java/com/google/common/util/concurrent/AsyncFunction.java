package com.google.common.util.concurrent;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@NullableDecl I i) throws Exception;
}

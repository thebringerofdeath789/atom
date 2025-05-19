package io.reactivex.rxjava3.core;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface SingleConverter<T, R> {
    R apply(Single<T> upstream);
}

package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

/* loaded from: classes4.dex */
public final class SingleJust<T> extends Single<T> {
    final T value;

    public SingleJust(T value) {
        this.value = value;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposable.disposed());
        singleObserver.onSuccess(this.value);
    }
}

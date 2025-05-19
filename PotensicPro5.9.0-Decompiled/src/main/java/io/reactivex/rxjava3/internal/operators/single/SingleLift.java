package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOperator;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class SingleLift<T, R> extends Single<R> {
    final SingleOperator<? extends R, ? super T> onLift;
    final SingleSource<T> source;

    public SingleLift(SingleSource<T> source, SingleOperator<? extends R, ? super T> onLift) {
        this.source = source;
        this.onLift = onLift;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(SingleObserver<? super R> observer) {
        try {
            this.source.subscribe((SingleObserver) Objects.requireNonNull(this.onLift.apply(observer), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}

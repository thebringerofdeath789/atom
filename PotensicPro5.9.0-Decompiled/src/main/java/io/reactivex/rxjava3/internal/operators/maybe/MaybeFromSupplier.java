package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

/* loaded from: classes4.dex */
public final class MaybeFromSupplier<T> extends Maybe<T> implements Supplier<T> {
    final Supplier<? extends T> supplier;

    public MaybeFromSupplier(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposable.empty();
        maybeObserver.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            T t = this.supplier.get();
            if (empty.isDisposed()) {
                return;
            }
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!empty.isDisposed()) {
                maybeObserver.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public T get() throws Throwable {
        return this.supplier.get();
    }
}

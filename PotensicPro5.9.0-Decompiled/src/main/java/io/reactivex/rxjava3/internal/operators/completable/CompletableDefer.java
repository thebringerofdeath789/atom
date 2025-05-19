package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class CompletableDefer extends Completable {
    final Supplier<? extends CompletableSource> completableSupplier;

    public CompletableDefer(Supplier<? extends CompletableSource> completableSupplier) {
        this.completableSupplier = completableSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        try {
            ((CompletableSource) Objects.requireNonNull(this.completableSupplier.get(), "The completableSupplier returned a null CompletableSource")).subscribe(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}

package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class CompletableErrorSupplier extends Completable {
    final Supplier<? extends Throwable> errorSupplier;

    public CompletableErrorSupplier(Supplier<? extends Throwable> errorSupplier) {
        this.errorSupplier = errorSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(CompletableObserver observer) {
        try {
            th = (Throwable) Objects.requireNonNull(this.errorSupplier.get(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, observer);
    }
}

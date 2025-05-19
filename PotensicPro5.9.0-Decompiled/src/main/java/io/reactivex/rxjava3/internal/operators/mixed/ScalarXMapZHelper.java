package io.reactivex.rxjava3.internal.operators.mixed;

import defpackage.C$r8$backportedMethods$utility$String$2$joinArray;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable;
import java.util.Objects;

/* loaded from: classes4.dex */
final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    static <T> boolean tryAsCompletable(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        if (!(obj instanceof Supplier)) {
            return false;
        }
        try {
            C$r8$backportedMethods$utility$String$2$joinArray c$r8$backportedMethods$utility$String$2$joinArray = (Object) ((Supplier) obj).get();
            CompletableSource completableSource = c$r8$backportedMethods$utility$String$2$joinArray != null ? (CompletableSource) Objects.requireNonNull(function.apply(c$r8$backportedMethods$utility$String$2$joinArray), "The mapper returned a null CompletableSource") : null;
            if (completableSource == null) {
                EmptyDisposable.complete(completableObserver);
            } else {
                completableSource.subscribe(completableObserver);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, completableObserver);
            return true;
        }
    }

    static <T, R> boolean tryAsMaybe(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        if (!(obj instanceof Supplier)) {
            return false;
        }
        try {
            C$r8$backportedMethods$utility$String$2$joinArray c$r8$backportedMethods$utility$String$2$joinArray = (Object) ((Supplier) obj).get();
            MaybeSource maybeSource = c$r8$backportedMethods$utility$String$2$joinArray != null ? (MaybeSource) Objects.requireNonNull(function.apply(c$r8$backportedMethods$utility$String$2$joinArray), "The mapper returned a null MaybeSource") : null;
            if (maybeSource == null) {
                EmptyDisposable.complete(observer);
            } else {
                maybeSource.subscribe(MaybeToObservable.create(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
            return true;
        }
    }

    static <T, R> boolean tryAsSingle(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        if (!(obj instanceof Supplier)) {
            return false;
        }
        try {
            C$r8$backportedMethods$utility$String$2$joinArray c$r8$backportedMethods$utility$String$2$joinArray = (Object) ((Supplier) obj).get();
            SingleSource singleSource = c$r8$backportedMethods$utility$String$2$joinArray != null ? (SingleSource) Objects.requireNonNull(function.apply(c$r8$backportedMethods$utility$String$2$joinArray), "The mapper returned a null SingleSource") : null;
            if (singleSource == null) {
                EmptyDisposable.complete(observer);
            } else {
                singleSource.subscribe(SingleToObservable.create(observer));
            }
            return true;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
            return true;
        }
    }
}

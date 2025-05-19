package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicFuseableObserver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Supplier<? extends Collection<? super K>> collectionSupplier;
    final Function<? super T, K> keySelector;

    public ObservableDistinct(ObservableSource<T> source, Function<? super T, K> keySelector, Supplier<? extends Collection<? super K>> collectionSupplier) {
        super(source);
        this.keySelector = keySelector;
        this.collectionSupplier = collectionSupplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        try {
            this.source.subscribe(new DistinctObserver(observer, this.keySelector, (Collection) ExceptionHelper.nullCheck(this.collectionSupplier.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }

    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Collection<? super K> collection;
        final Function<? super T, K> keySelector;

        DistinctObserver(Observer<? super T> actual, Function<? super T, K> keySelector, Collection<? super K> collection) {
            super(actual);
            this.keySelector = keySelector;
            this.collection = collection;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 0) {
                try {
                    if (this.collection.add(Objects.requireNonNull(this.keySelector.apply(value), "The keySelector returned a null key"))) {
                        this.downstream.onNext(value);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    fail(th);
                    return;
                }
            }
            this.downstream.onNext(null);
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            if (this.done) {
                RxJavaPlugins.onError(e);
                return;
            }
            this.done = true;
            this.collection.clear();
            this.downstream.onError(e);
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.collection.clear();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int mode) {
            return transitiveBoundaryFusion(mode);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T poll;
            do {
                poll = this.qd.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.collection.add((Object) Objects.requireNonNull(this.keySelector.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        @Override // io.reactivex.rxjava3.internal.observers.BasicFuseableObserver, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.collection.clear();
            super.clear();
        }
    }
}

package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class MaybeFlatMapObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapObservable(MaybeSource<T> source, Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.mapper);
        observer.onSubscribe(flatMapObserver);
        this.source.subscribe(flatMapObserver);
    }

    static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

        FlatMapObserver(Observer<? super R> downstream, Function<? super T, ? extends ObservableSource<? extends R>> mapper) {
            this.downstream = downstream;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(R t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable t) {
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            DisposableHelper.replace(this, d);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                ObservableSource observableSource = (ObservableSource) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                if (isDisposed()) {
                    return;
                }
                observableSource.subscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }
}

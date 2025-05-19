package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/* loaded from: classes4.dex */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    public CompletableFromObservable(ObservableSource<T> observable) {
        this.observable = observable;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    protected void subscribeActual(final CompletableObserver observer) {
        this.observable.subscribe(new CompletableFromObservableObserver(observer));
    }

    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver co;

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T value) {
        }

        CompletableFromObservableObserver(CompletableObserver co) {
            this.co = co;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable d) {
            this.co.onSubscribe(d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable e) {
            this.co.onError(e);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.co.onComplete();
        }
    }
}

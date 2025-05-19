package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class SingleDelay<T> extends Single<T> {
    final boolean delayError;
    final Scheduler scheduler;
    final SingleSource<? extends T> source;
    final long time;
    final TimeUnit unit;

    public SingleDelay(SingleSource<? extends T> source, long time, TimeUnit unit, Scheduler scheduler, boolean delayError) {
        this.source = source;
        this.time = time;
        this.unit = unit;
        this.scheduler = scheduler;
        this.delayError = delayError;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.source.subscribe(new Delay(sequentialDisposable, observer));
    }

    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> downstream;
        private final SequentialDisposable sd;

        Delay(SequentialDisposable sd, SingleObserver<? super T> observer) {
            this.sd = sd;
            this.downstream = observer;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.sd.replace(d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(final T value) {
            this.sd.replace(SingleDelay.this.scheduler.scheduleDirect(new OnSuccess(value), SingleDelay.this.time, SingleDelay.this.unit));
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(final Throwable e) {
            this.sd.replace(SingleDelay.this.scheduler.scheduleDirect(new OnError(e), SingleDelay.this.delayError ? SingleDelay.this.time : 0L, SingleDelay.this.unit));
        }

        final class OnSuccess implements Runnable {
            private final T value;

            OnSuccess(T value) {
                this.value = value;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.downstream.onSuccess(this.value);
            }
        }

        final class OnError implements Runnable {
            private final Throwable e;

            OnError(Throwable e) {
                this.e = e;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.downstream.onError(this.e);
            }
        }
    }
}

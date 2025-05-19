package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class SingleMap<T, R> extends Single<R> {
    final Function<? super T, ? extends R> mapper;
    final SingleSource<? extends T> source;

    public SingleMap(SingleSource<? extends T> source, Function<? super T, ? extends R> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override // io.reactivex.rxjava3.core.Single
    protected void subscribeActual(final SingleObserver<? super R> t) {
        this.source.subscribe(new MapSingleObserver(t, this.mapper));
    }

    static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        final Function<? super T, ? extends R> mapper;
        final SingleObserver<? super R> t;

        MapSingleObserver(SingleObserver<? super R> t, Function<? super T, ? extends R> mapper) {
            this.t = t;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable d) {
            this.t.onSubscribe(d);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T value) {
            try {
                this.t.onSuccess(Objects.requireNonNull(this.mapper.apply(value), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onError(Throwable e) {
            this.t.onError(e);
        }
    }
}

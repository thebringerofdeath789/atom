package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> other;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public FlowableZipIterable(Flowable<T> source, Iterable<U> other, BiFunction<? super T, ? super U, ? extends V> zipper) {
        super(source);
        this.other = other;
        this.zipper = zipper;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super V> t) {
        try {
            Iterator it = (Iterator) Objects.requireNonNull(this.other.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptySubscription.complete(t);
                } else {
                    this.source.subscribe((FlowableSubscriber) new ZipIterableSubscriber(t, it, this.zipper));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, t);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, t);
        }
    }

    static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super V> downstream;
        final Iterator<U> iterator;
        Subscription upstream;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        ZipIterableSubscriber(Subscriber<? super V> actual, Iterator<U> iterator, BiFunction<? super T, ? super U, ? extends V> zipper) {
            this.downstream = actual;
            this.iterator = iterator;
            this.zipper = zipper;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                try {
                    this.downstream.onNext(Objects.requireNonNull(this.zipper.apply(t, Objects.requireNonNull(this.iterator.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.iterator.hasNext()) {
                            return;
                        }
                        this.done = true;
                        this.upstream.cancel();
                        this.downstream.onComplete();
                    } catch (Throwable th) {
                        fail(th);
                    }
                } catch (Throwable th2) {
                    fail(th2);
                }
            } catch (Throwable th3) {
                fail(th3);
            }
        }

        void fail(Throwable e) {
            Exceptions.throwIfFatal(e);
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(e);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable t) {
            if (this.done) {
                RxJavaPlugins.onError(t);
            } else {
                this.done = true;
                this.downstream.onError(t);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long n) {
            this.upstream.request(n);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }
    }
}

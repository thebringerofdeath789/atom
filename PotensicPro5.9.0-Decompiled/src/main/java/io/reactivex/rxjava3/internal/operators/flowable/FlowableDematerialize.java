package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> selector;

    public FlowableDematerialize(Flowable<T> source, Function<? super T, ? extends Notification<R>> selector) {
        super(source);
        this.selector = selector;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DematerializeSubscriber(subscriber, this.selector));
    }

    static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super R> downstream;
        final Function<? super T, ? extends Notification<R>> selector;
        Subscription upstream;

        DematerializeSubscriber(Subscriber<? super R> downstream, Function<? super T, ? extends Notification<R>> selector) {
            this.downstream = downstream;
            this.selector = selector;
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription s) {
            if (SubscriptionHelper.validate(this.upstream, s)) {
                this.upstream = s;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                if (t instanceof Notification) {
                    Notification notification = (Notification) t;
                    if (notification.isOnError()) {
                        RxJavaPlugins.onError(notification.getError());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) Objects.requireNonNull(this.selector.apply(t), "The selector returned a null Notification");
                if (notification2.isOnError()) {
                    this.upstream.cancel();
                    onError(notification2.getError());
                } else if (notification2.isOnComplete()) {
                    this.upstream.cancel();
                    onComplete();
                } else {
                    this.downstream.onNext((Object) notification2.getValue());
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
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

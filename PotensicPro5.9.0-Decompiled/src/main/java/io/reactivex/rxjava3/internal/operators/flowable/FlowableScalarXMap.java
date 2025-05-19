package io.reactivex.rxjava3.internal.operators.flowable;

import defpackage.C$r8$backportedMethods$utility$String$2$joinArray;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableScalarXMap {
    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Supplier)) {
            return false;
        }
        try {
            C$r8$backportedMethods$utility$String$2$joinArray c$r8$backportedMethods$utility$String$2$joinArray = (Object) ((Supplier) publisher).get();
            if (c$r8$backportedMethods$utility$String$2$joinArray == null) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                Publisher publisher2 = (Publisher) Objects.requireNonNull(function.apply(c$r8$backportedMethods$utility$String$2$joinArray), "The mapper returned a null Publisher");
                if (publisher2 instanceof Supplier) {
                    try {
                        Object obj = ((Supplier) publisher2).get();
                        if (obj == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, obj));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return true;
                    }
                } else {
                    publisher2.subscribe(subscriber);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, subscriber);
            return true;
        }
    }

    public static <T, U> Flowable<U> scalarXMap(final T value, final Function<? super T, ? extends Publisher<? extends U>> mapper) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(value, mapper));
    }

    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final T value;

        ScalarXMapFlowable(T value, Function<? super T, ? extends Publisher<? extends R>> mapper) {
            this.value = value;
            this.mapper = mapper;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) Objects.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
                if (publisher instanceof Supplier) {
                    try {
                        Object obj = ((Supplier) publisher).get();
                        if (obj == null) {
                            EmptySubscription.complete(subscriber);
                            return;
                        } else {
                            subscriber.onSubscribe(new ScalarSubscription(subscriber, obj));
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return;
                    }
                }
                publisher.subscribe(subscriber);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }
    }
}

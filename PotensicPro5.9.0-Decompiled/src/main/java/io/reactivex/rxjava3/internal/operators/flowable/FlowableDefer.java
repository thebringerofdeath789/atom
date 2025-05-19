package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes4.dex */
public final class FlowableDefer<T> extends Flowable<T> {
    final Supplier<? extends Publisher<? extends T>> supplier;

    public FlowableDefer(Supplier<? extends Publisher<? extends T>> supplier) {
        this.supplier = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        try {
            ((Publisher) Objects.requireNonNull(this.supplier.get(), "The publisher supplied is null")).subscribe(s);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, s);
        }
    }
}

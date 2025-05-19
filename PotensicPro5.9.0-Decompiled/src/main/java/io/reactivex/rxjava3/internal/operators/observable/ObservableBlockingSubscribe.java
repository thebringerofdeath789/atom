package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.observers.BlockingObserver;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public final class ObservableBlockingSubscribe {
    private ObservableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void subscribe(ObservableSource<? extends T> o, Observer<? super T> observer) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        observer.onSubscribe(blockingObserver);
        o.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e) {
                    blockingObserver.dispose();
                    observer.onError(e);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || poll == BlockingObserver.TERMINATED || NotificationLite.acceptFull(poll, observer)) {
                return;
            }
        }
    }

    public static <T> void subscribe(ObservableSource<? extends T> o) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.emptyConsumer(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.emptyConsumer());
        o.subscribe(lambdaObserver);
        BlockingHelper.awaitForComplete(blockingIgnoringReceiver, lambdaObserver);
        Throwable th = blockingIgnoringReceiver.error;
        if (th != null) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static <T> void subscribe(ObservableSource<? extends T> o, final Consumer<? super T> onNext, final Consumer<? super Throwable> onError, final Action onComplete) {
        Objects.requireNonNull(onNext, "onNext is null");
        Objects.requireNonNull(onError, "onError is null");
        Objects.requireNonNull(onComplete, "onComplete is null");
        subscribe(o, new LambdaObserver(onNext, onError, onComplete, Functions.emptyConsumer()));
    }
}

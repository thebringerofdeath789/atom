package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Consumer<? super S> disposeState;
    final BiFunction<S, Emitter<T>, S> generator;
    final Supplier<S> stateSupplier;

    public FlowableGenerate(Supplier<S> stateSupplier, BiFunction<S, Emitter<T>, S> generator, Consumer<? super S> disposeState) {
        this.stateSupplier = stateSupplier;
        this.generator = generator;
        this.disposeState = disposeState;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> s) {
        try {
            s.onSubscribe(new GeneratorSubscription(s, this.generator, this.disposeState, this.stateSupplier.get()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, s);
        }
    }

    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        volatile boolean cancelled;
        final Consumer<? super S> disposeState;
        final Subscriber<? super T> downstream;
        final BiFunction<S, ? super Emitter<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(Subscriber<? super T> actual, BiFunction<S, ? super Emitter<T>, S> generator, Consumer<? super S> disposeState, S initialState) {
            this.downstream = actual;
            this.generator = generator;
            this.disposeState = disposeState;
            this.state = initialState;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            r9.state = r0;
            r10 = addAndGet(-r4);
         */
        @Override // org.reactivestreams.Subscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = io.reactivex.rxjava3.internal.util.BackpressureHelper.add(r9, r10)
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L12
                return
            L12:
                S r0 = r9.state
                io.reactivex.rxjava3.functions.BiFunction<S, ? super io.reactivex.rxjava3.core.Emitter<T>, S> r1 = r9.generator
            L16:
                r4 = r2
            L17:
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 == 0) goto L4d
                boolean r6 = r9.cancelled
                r7 = 0
                if (r6 == 0) goto L26
                r9.state = r7
                r9.dispose(r0)
                return
            L26:
                r6 = 0
                r9.hasNext = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3e
                boolean r8 = r9.terminate
                if (r8 == 0) goto L3a
                r9.cancelled = r6
                r9.state = r7
                r9.dispose(r0)
                return
            L3a:
                r6 = 1
                long r4 = r4 + r6
                goto L17
            L3e:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r10)
                r9.cancelled = r6
                r9.state = r7
                r9.onError(r10)
                r9.dispose(r0)
                return
            L4d:
                long r10 = r9.get()
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 != 0) goto L17
                r9.state = r0
                long r10 = -r4
                long r10 = r9.addAndGet(r10)
                int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                if (r4 != 0) goto L16
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.request(long):void");
        }

        private void dispose(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (BackpressureHelper.add(this, 1L) == 0) {
                S s = this.state;
                this.state = null;
                dispose(s);
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.hasNext = true;
                this.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable t) {
            if (this.terminate) {
                RxJavaPlugins.onError(t);
                return;
            }
            if (t == null) {
                t = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            this.terminate = true;
            this.downstream.onError(t);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.downstream.onComplete();
        }
    }
}

package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public final class Futures extends GwtFuturesCatchingSpecialization {
    private Futures() {
    }

    @Deprecated
    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> listenableFuture, Function<? super Exception, X> function) {
        return new MappingCheckedFuture((ListenableFuture) Preconditions.checkNotNull(listenableFuture), function);
    }

    public static <V> ListenableFuture<V> immediateFuture(@NullableDecl V v) {
        if (v == null) {
            return ImmediateFuture.ImmediateSuccessfulFuture.NULL;
        }
        return new ImmediateFuture.ImmediateSuccessfulFuture(v);
    }

    @Deprecated
    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@NullableDecl V v) {
        return new ImmediateFuture.ImmediateSuccessfulCheckedFuture(v);
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    @Deprecated
    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X x) {
        Preconditions.checkNotNull(x);
        return new ImmediateFuture.ImmediateFailedCheckedFuture(x);
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask create = TrustedListenableFutureTask.create(asyncCallable);
        executor.execute(create);
        return create;
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask create = TrustedListenableFutureTask.create(asyncCallable);
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(create, j, timeUnit);
        create.addListener(new Runnable() { // from class: com.google.common.util.concurrent.Futures.1
            @Override // java.lang.Runnable
            public void run() {
                schedule.cancel(false);
            }
        }, MoreExecutors.directExecutor());
        return create;
    }

    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, function, executor);
    }

    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, asyncFunction, executor);
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : TimeoutFuture.create(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, asyncFunction, executor);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new Future<O>() { // from class: com.google.common.util.concurrent.Futures.2
            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z) {
                return future.cancel(z);
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return future.isDone();
            }

            @Override // java.util.concurrent.Future
            public O get() throws InterruptedException, ExecutionException {
                return applyTransformation(future.get());
            }

            @Override // java.util.concurrent.Future
            public O get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return applyTransformation(future.get(j, timeUnit));
            }

            private O applyTransformation(I i) throws ExecutionException {
                try {
                    return (O) function.apply(i);
                } catch (Throwable th) {
                    throw new ExecutionException(th);
                }
            }
        };
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), true);
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), true);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(listenableFutureArr));
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(iterable));
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(listenableFutureArr));
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(iterable));
    }

    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        private FutureCombiner(boolean z, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.allMustSucceed = z;
            this.futures = immutableList;
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture(this.futures, this.allMustSucceed, executor, asyncCallable);
        }

        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture(this.futures, this.allMustSucceed, executor, callable);
        }

        public ListenableFuture<?> run(final Runnable runnable, Executor executor) {
            return call(new Callable<Void>() { // from class: com.google.common.util.concurrent.Futures.FutureCombiner.1
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    runnable.run();
                    return null;
                }
            }, executor);
        }
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.addListener(nonCancellationPropagatingFuture, MoreExecutors.directExecutor());
        return nonCancellationPropagatingFuture;
    }

    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        private ListenableFuture<V> delegate;

        NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String pendingToString() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                return "delegate=[" + listenableFuture + "]";
            }
            return null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void afterDone() {
            this.delegate = null;
        }
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(listenableFutureArr), false);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), false);
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        Collection copyOf;
        if (iterable instanceof Collection) {
            copyOf = (Collection) iterable;
        } else {
            copyOf = ImmutableList.copyOf(iterable);
        }
        ListenableFuture[] listenableFutureArr = (ListenableFuture[]) copyOf.toArray(new ListenableFuture[copyOf.size()]);
        final InCompletionOrderState inCompletionOrderState = new InCompletionOrderState(listenableFutureArr);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < listenableFutureArr.length; i++) {
            builder.add((ImmutableList.Builder) new InCompletionOrderFuture(inCompletionOrderState));
        }
        final ImmutableList<ListenableFuture<T>> build = builder.build();
        for (final int i2 = 0; i2 < listenableFutureArr.length; i2++) {
            listenableFutureArr[i2].addListener(new Runnable() { // from class: com.google.common.util.concurrent.Futures.3
                @Override // java.lang.Runnable
                public void run() {
                    InCompletionOrderState.this.recordInputCompletion(build, i2);
                }
            }, MoreExecutors.directExecutor());
        }
        return build;
    }

    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        private InCompletionOrderState<T> state;

        private InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            this.state = inCompletionOrderState;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (!super.cancel(z)) {
                return false;
            }
            inCompletionOrderState.recordOutputCancellation(z);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void afterDone() {
            this.state = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String pendingToString() {
            InCompletionOrderState<T> inCompletionOrderState = this.state;
            if (inCompletionOrderState != null) {
                return "inputCount=[" + ((InCompletionOrderState) inCompletionOrderState).inputFutures.length + "], remaining=[" + ((InCompletionOrderState) inCompletionOrderState).incompleteOutputCount.get() + "]";
            }
            return null;
        }
    }

    private static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        private final AtomicInteger incompleteOutputCount;
        private final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        private InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = listenableFutureArr;
            this.incompleteOutputCount = new AtomicInteger(listenableFutureArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordOutputCancellation(boolean z) {
            this.wasCancelled = true;
            if (!z) {
                this.shouldInterrupt = false;
            }
            recordCompletion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recordInputCompletion(ImmutableList<AbstractFuture<T>> immutableList, int i) {
            ListenableFuture<? extends T>[] listenableFutureArr = this.inputFutures;
            ListenableFuture<? extends T> listenableFuture = listenableFutureArr[i];
            listenableFutureArr[i] = null;
            for (int i2 = this.delegateIndex; i2 < immutableList.size(); i2++) {
                if (immutableList.get(i2).setFuture(listenableFuture)) {
                    recordCompletion();
                    this.delegateIndex = i2 + 1;
                    return;
                }
            }
            this.delegateIndex = immutableList.size();
        }

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0 && this.wasCancelled) {
                for (ListenableFuture<? extends T> listenableFuture : this.inputFutures) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.shouldInterrupt);
                    }
                }
            }
        }
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.future = future;
            this.callback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.callback.onSuccess(Futures.getDone(this.future));
            } catch (Error e) {
                e = e;
                this.callback.onFailure(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.callback.onFailure(e);
            } catch (ExecutionException e3) {
                this.callback.onFailure(e3.getCause());
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.callback).toString();
        }
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return (V) FuturesGetChecked.getChecked(future, cls);
    }

    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        return (V) FuturesGetChecked.getChecked(future, cls, j, timeUnit);
    }

    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e) {
            wrapAndThrowUnchecked(e.getCause());
            throw new AssertionError();
        }
    }

    private static void wrapAndThrowUnchecked(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
        final Function<? super Exception, X> mapper;

        MappingCheckedFuture(ListenableFuture<V> listenableFuture, Function<? super Exception, X> function) {
            super(listenableFuture);
            this.mapper = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.util.concurrent.AbstractCheckedFuture
        protected X mapException(Exception exc) {
            return this.mapper.apply(exc);
        }
    }
}

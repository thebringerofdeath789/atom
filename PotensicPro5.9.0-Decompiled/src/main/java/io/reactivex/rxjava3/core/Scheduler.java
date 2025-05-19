package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.NewThreadWorker;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = computeClockDrift(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    static long computeClockDrift(long time, String timeUnit) {
        if ("seconds".equalsIgnoreCase(timeUnit)) {
            return TimeUnit.SECONDS.toNanos(time);
        }
        if ("milliseconds".equalsIgnoreCase(timeUnit)) {
            return TimeUnit.MILLISECONDS.toNanos(time);
        }
        return TimeUnit.MINUTES.toNanos(time);
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(TimeUnit unit) {
        return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable run) {
        return scheduleDirect(run, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit) {
        Worker createWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(run), createWorker);
        createWorker.schedule(disposeTask, delay, unit);
        return disposeTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable run, long initialDelay, long period, TimeUnit unit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(run), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, initialDelay, period, unit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> combine) {
        Objects.requireNonNull(combine, "combine is null");
        return new SchedulerWhen(combine, this);
    }

    public static abstract class Worker implements Disposable {
        public abstract Disposable schedule(Runnable run, long delay, TimeUnit unit);

        public Disposable schedule(Runnable run) {
            return schedule(run, 0L, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable run, final long initialDelay, final long period, final TimeUnit unit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(run);
            long nanos = unit.toNanos(period);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new PeriodicTask(now + unit.toNanos(initialDelay), onSchedule, now, sequentialDisposable2, nanos), initialDelay, unit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }

        public long now(TimeUnit unit) {
            return unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            long count;
            final Runnable decoratedRun;
            long lastNowNanoseconds;
            final long periodInNanoseconds;
            final SequentialDisposable sd;
            long startInNanoseconds;

            PeriodicTask(long firstStartInNanoseconds, Runnable decoratedRun, long firstNowNanoseconds, SequentialDisposable sd, long periodInNanoseconds) {
                this.decoratedRun = decoratedRun;
                this.sd = sd;
                this.periodInNanoseconds = periodInNanoseconds;
                this.lastNowNanoseconds = firstNowNanoseconds;
                this.startInNanoseconds = firstStartInNanoseconds;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.decoratedRun.run();
                if (this.sd.isDisposed()) {
                    return;
                }
                long now = Worker.this.now(TimeUnit.NANOSECONDS);
                long j2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS + now;
                long j3 = this.lastNowNanoseconds;
                if (j2 < j3 || now >= j3 + this.periodInNanoseconds + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS) {
                    long j4 = this.periodInNanoseconds;
                    long j5 = now + j4;
                    long j6 = this.count + 1;
                    this.count = j6;
                    this.startInNanoseconds = j5 - (j4 * j6);
                    j = j5;
                } else {
                    long j7 = this.startInNanoseconds;
                    long j8 = this.count + 1;
                    this.count = j8;
                    j = j7 + (j8 * this.periodInNanoseconds);
                }
                this.lastNowNanoseconds = now;
                this.sd.replace(Worker.this.schedule(this, j - now, TimeUnit.NANOSECONDS));
            }

            @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.decoratedRun;
            }
        }
    }

    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        volatile boolean disposed;
        final Runnable run;
        final Worker worker;

        PeriodicDirectTask(Runnable run, Worker worker) {
            this.run = run;
            this.worker = worker;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.disposed) {
                return;
            }
            try {
                this.run.run();
            } catch (Throwable th) {
                dispose();
                RxJavaPlugins.onError(th);
                throw th;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.run;
        }
    }

    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        final Runnable decoratedRun;
        Thread runner;
        final Worker w;

        DisposeTask(Runnable decoratedRun, Worker w) {
            this.decoratedRun = decoratedRun;
            this.w = w;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.w;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.w.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.decoratedRun;
        }
    }
}

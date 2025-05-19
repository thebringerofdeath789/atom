package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class Schedulers {
    static final Scheduler SINGLE = RxJavaPlugins.initSingleScheduler(new SingleTask());
    static final Scheduler COMPUTATION = RxJavaPlugins.initComputationScheduler(new ComputationTask());
    static final Scheduler IO = RxJavaPlugins.initIoScheduler(new IOTask());
    static final Scheduler TRAMPOLINE = TrampolineScheduler.instance();
    static final Scheduler NEW_THREAD = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    static final class SingleHolder {
        static final Scheduler DEFAULT = new SingleScheduler();

        SingleHolder() {
        }
    }

    static final class ComputationHolder {
        static final Scheduler DEFAULT = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    static final class IoHolder {
        static final Scheduler DEFAULT = new IoScheduler();

        IoHolder() {
        }
    }

    static final class NewThreadHolder {
        static final Scheduler DEFAULT = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(COMPUTATION);
    }

    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(IO);
    }

    public static Scheduler trampoline() {
        return TRAMPOLINE;
    }

    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(NEW_THREAD);
    }

    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(SINGLE);
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor, false, false);
    }

    public static Scheduler from(Executor executor, boolean interruptibleWorker) {
        return new ExecutorScheduler(executor, interruptibleWorker, false);
    }

    public static Scheduler from(Executor executor, boolean interruptibleWorker, boolean fair) {
        return new ExecutorScheduler(executor, interruptibleWorker, fair);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    static final class IOTask implements Supplier<Scheduler> {
        IOTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() {
            return IoHolder.DEFAULT;
        }
    }

    static final class NewThreadTask implements Supplier<Scheduler> {
        NewThreadTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() {
            return NewThreadHolder.DEFAULT;
        }
    }

    static final class SingleTask implements Supplier<Scheduler> {
        SingleTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() {
            return SingleHolder.DEFAULT;
        }
    }

    static final class ComputationTask implements Supplier<Scheduler> {
        ComputationTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public Scheduler get() {
            return ComputationHolder.DEFAULT;
        }
    }
}

package io.netty.util.concurrent;

import io.netty.util.concurrent.EventExecutorChooserFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class DefaultEventExecutorChooserFactory implements EventExecutorChooserFactory {
    public static final DefaultEventExecutorChooserFactory INSTANCE = new DefaultEventExecutorChooserFactory();

    private static boolean isPowerOfTwo(int i) {
        return ((-i) & i) == i;
    }

    private DefaultEventExecutorChooserFactory() {
    }

    @Override // io.netty.util.concurrent.EventExecutorChooserFactory
    public EventExecutorChooserFactory.EventExecutorChooser newChooser(EventExecutor[] eventExecutorArr) {
        if (isPowerOfTwo(eventExecutorArr.length)) {
            return new PowerOfTwoEventExecutorChooser(eventExecutorArr);
        }
        return new GenericEventExecutorChooser(eventExecutorArr);
    }

    private static final class PowerOfTwoEventExecutorChooser implements EventExecutorChooserFactory.EventExecutorChooser {
        private final EventExecutor[] executors;
        private final AtomicInteger idx = new AtomicInteger();

        PowerOfTwoEventExecutorChooser(EventExecutor[] eventExecutorArr) {
            this.executors = eventExecutorArr;
        }

        @Override // io.netty.util.concurrent.EventExecutorChooserFactory.EventExecutorChooser
        public EventExecutor next() {
            return this.executors[this.idx.getAndIncrement() & (this.executors.length - 1)];
        }
    }

    private static final class GenericEventExecutorChooser implements EventExecutorChooserFactory.EventExecutorChooser {
        private final EventExecutor[] executors;
        private final AtomicInteger idx = new AtomicInteger();

        GenericEventExecutorChooser(EventExecutor[] eventExecutorArr) {
            this.executors = eventExecutorArr;
        }

        @Override // io.netty.util.concurrent.EventExecutorChooserFactory.EventExecutorChooser
        public EventExecutor next() {
            return this.executors[Math.abs(this.idx.getAndIncrement() % this.executors.length)];
        }
    }
}

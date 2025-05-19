package org.apache.commons.lang3.function;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.stream.Streams;

/* loaded from: classes4.dex */
public class Failable {
    public static <T, U, E extends Throwable> void accept(final FailableBiConsumer<T, U, E> failableBiConsumer, final T t, final U u) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$hL2CtOWvhikMW6r95Jr_Pu65Uv8
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                FailableBiConsumer.this.accept(t, u);
            }
        });
    }

    public static <T, E extends Throwable> void accept(final FailableConsumer<T, E> failableConsumer, final T t) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$2HnmE_CC4PQoljkAd0OZ7ZRns0g
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                FailableConsumer.this.accept(t);
            }
        });
    }

    public static <E extends Throwable> void accept(final FailableDoubleConsumer<E> failableDoubleConsumer, final double d) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$q-TVnUJ1BTUeYMmwvVqwehWYI3Y
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                FailableDoubleConsumer.this.accept(d);
            }
        });
    }

    public static <E extends Throwable> void accept(final FailableIntConsumer<E> failableIntConsumer, final int i) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$IZOPp94J2LZmS97LQgyaY3WYA4M
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                FailableIntConsumer.this.accept(i);
            }
        });
    }

    public static <E extends Throwable> void accept(final FailableLongConsumer<E> failableLongConsumer, final long j) {
        run(new FailableRunnable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$FkMuyGX1YORpTvpBaNgpXS58Su8
            @Override // org.apache.commons.lang3.function.FailableRunnable
            public final void run() {
                FailableLongConsumer.this.accept(j);
            }
        });
    }

    public static <T, U, R, E extends Throwable> R apply(final FailableBiFunction<T, U, R, E> failableBiFunction, final T t, final U u) {
        return (R) get(new FailableSupplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$LiEGE_d3bKDceVIN0DybO2asImA
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                Object apply;
                apply = FailableBiFunction.this.apply(t, u);
                return apply;
            }
        });
    }

    public static <T, R, E extends Throwable> R apply(final FailableFunction<T, R, E> failableFunction, final T t) {
        return (R) get(new FailableSupplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$M_5KNprf-CgehaLtGu-KXAo45FE
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                Object apply;
                apply = FailableFunction.this.apply(t);
                return apply;
            }
        });
    }

    public static <E extends Throwable> double applyAsDouble(final FailableDoubleBinaryOperator<E> failableDoubleBinaryOperator, final double d, final double d2) {
        return getAsDouble(new FailableDoubleSupplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$K0TKYDGaC9fA68FY33Mef-joM04
            @Override // org.apache.commons.lang3.function.FailableDoubleSupplier
            public final double getAsDouble() {
                double applyAsDouble;
                applyAsDouble = FailableDoubleBinaryOperator.this.applyAsDouble(d, d2);
                return applyAsDouble;
            }
        });
    }

    public static <T, U> BiConsumer<T, U> asBiConsumer(final FailableBiConsumer<T, U, ?> failableBiConsumer) {
        return new BiConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$Ln7FLK01lkrtQgPdQ9RZ11hipfg
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Failable.accept(FailableBiConsumer.this, obj, obj2);
            }
        };
    }

    public static <T, U, R> BiFunction<T, U, R> asBiFunction(final FailableBiFunction<T, U, R, ?> failableBiFunction) {
        return new BiFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$CIPsV_HEtcRrDDlhwOxA2X4oJHg
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = Failable.apply(FailableBiFunction.this, obj, obj2);
                return apply;
            }
        };
    }

    public static <T, U> BiPredicate<T, U> asBiPredicate(final FailableBiPredicate<T, U, ?> failableBiPredicate) {
        return new BiPredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$ZIuHEQWvA_bDAkVa3qYROhaakmo
            @Override // java.util.function.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean test;
                test = Failable.test(FailableBiPredicate.this, obj, obj2);
                return test;
            }
        };
    }

    public static <V> Callable<V> asCallable(final FailableCallable<V, ?> failableCallable) {
        return new Callable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$7waw8JeYJIuYzViudVPw9okNvFU
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object call;
                call = Failable.call(FailableCallable.this);
                return call;
            }
        };
    }

    public static <T> Consumer<T> asConsumer(final FailableConsumer<T, ?> failableConsumer) {
        return new Consumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$H9nODQNaDN6F19evEZ6JvelnUkY
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Failable.accept((FailableConsumer<Object, E>) FailableConsumer.this, obj);
            }
        };
    }

    public static <T, R> Function<T, R> asFunction(final FailableFunction<T, R, ?> failableFunction) {
        return new Function() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$JP91S70wMfz0er-gVNoIHgxE-T0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object apply;
                apply = Failable.apply(FailableFunction.this, obj);
                return apply;
            }
        };
    }

    public static <T> Predicate<T> asPredicate(final FailablePredicate<T, ?> failablePredicate) {
        return new Predicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$3-WiAp37z7ip_KUwjDF7ZnwAop4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean test;
                test = Failable.test(FailablePredicate.this, obj);
                return test;
            }
        };
    }

    public static Runnable asRunnable(final FailableRunnable<?> failableRunnable) {
        return new Runnable() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$0XmrSbV69VmxgamlDDH0__VyYGI
            @Override // java.lang.Runnable
            public final void run() {
                Failable.run(FailableRunnable.this);
            }
        };
    }

    public static <T> Supplier<T> asSupplier(final FailableSupplier<T, ?> failableSupplier) {
        return new Supplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$M7luA8lAqPaGPNr7FfbwwQMadw8
            @Override // java.util.function.Supplier
            public final Object get() {
                Object obj;
                obj = Failable.get(FailableSupplier.this);
                return obj;
            }
        };
    }

    public static <V, E extends Throwable> V call(final FailableCallable<V, E> failableCallable) {
        failableCallable.getClass();
        return (V) get(new FailableSupplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Jd8pLq6KdLAjZwAfZkEL9pDDNUQ
            @Override // org.apache.commons.lang3.function.FailableSupplier
            public final Object get() {
                return FailableCallable.this.call();
            }
        });
    }

    public static <T, E extends Throwable> T get(FailableSupplier<T, E> failableSupplier) {
        try {
            return failableSupplier.get();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<E> failableBooleanSupplier) {
        try {
            return failableBooleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> double getAsDouble(FailableDoubleSupplier<E> failableDoubleSupplier) {
        try {
            return failableDoubleSupplier.getAsDouble();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> int getAsInt(FailableIntSupplier<E> failableIntSupplier) {
        try {
            return failableIntSupplier.getAsInt();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> long getAsLong(FailableLongSupplier<E> failableLongSupplier) {
        try {
            return failableLongSupplier.getAsLong();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E extends Throwable> short getAsShort(FailableShortSupplier<E> failableShortSupplier) {
        try {
            return failableShortSupplier.getAsShort();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static RuntimeException rethrow(Throwable th) {
        Objects.requireNonNull(th, "throwable");
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th instanceof IOException) {
            throw new UncheckedIOException((IOException) th);
        }
        throw new UndeclaredThrowableException(th);
    }

    public static <E extends Throwable> void run(FailableRunnable<E> failableRunnable) {
        try {
            failableRunnable.run();
        } catch (Throwable th) {
            throw rethrow(th);
        }
    }

    public static <E> Streams.FailableStream<E> stream(Collection<E> collection) {
        return new Streams.FailableStream<>(collection.stream());
    }

    public static <T> Streams.FailableStream<T> stream(Stream<T> stream) {
        return new Streams.FailableStream<>(stream);
    }

    public static <T, U, E extends Throwable> boolean test(final FailableBiPredicate<T, U, E> failableBiPredicate, final T t, final U u) {
        return getAsBoolean(new FailableBooleanSupplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$7igc6_kKEf0jCnHJ8Nwx6ME5L-w
            @Override // org.apache.commons.lang3.function.FailableBooleanSupplier
            public final boolean getAsBoolean() {
                boolean test;
                test = FailableBiPredicate.this.test(t, u);
                return test;
            }
        });
    }

    public static <T, E extends Throwable> boolean test(final FailablePredicate<T, E> failablePredicate, final T t) {
        return getAsBoolean(new FailableBooleanSupplier() { // from class: org.apache.commons.lang3.function.-$$Lambda$Failable$atdANCr_kyXV5GrWKwoODo26b8Q
            @Override // org.apache.commons.lang3.function.FailableBooleanSupplier
            public final boolean getAsBoolean() {
                boolean test;
                test = FailablePredicate.this.test(t);
                return test;
            }
        });
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableConsumer<Throwable, ? extends Throwable> failableConsumer, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        if (failableConsumer == null) {
            failableConsumer = new FailableConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$7bQMbPPe-3JZxNDgqMpxMJBhj88
                @Override // org.apache.commons.lang3.function.FailableConsumer
                public final void accept(Object obj) {
                    Failable.rethrow((Throwable) obj);
                }
            };
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable2 : failableRunnableArr) {
                Objects.requireNonNull(failableRunnable2, "runnable");
            }
        }
        Throwable th = null;
        try {
            failableRunnable.run();
        } catch (Throwable th2) {
            th = th2;
        }
        if (failableRunnableArr != null) {
            for (FailableRunnable<? extends Throwable> failableRunnable3 : failableRunnableArr) {
                try {
                    failableRunnable3.run();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    }
                }
            }
        }
        if (th != null) {
            try {
                failableConsumer.accept(th);
            } catch (Throwable th4) {
                throw rethrow(th4);
            }
        }
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> failableRunnable, FailableRunnable<? extends Throwable>... failableRunnableArr) {
        tryWithResources(failableRunnable, null, failableRunnableArr);
    }

    private Failable() {
    }
}

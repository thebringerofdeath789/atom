package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionsConstuctor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00052\u0006\u0010\t\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"0\u0010\u0002\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionConstructors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt {
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionConstructors = new WeakHashMap<>();

    public static final <E extends Throwable> E tryCopyException(E exception) {
        int i;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        ReentrantReadWriteLock.ReadLock readLock = cacheLock.readLock();
        readLock.lock();
        try {
            Function1<Throwable, Throwable> function1 = exceptionConstructors.get(exception.getClass());
            if (function1 != null) {
                return (E) function1.invoke(exception);
            }
            Function1 function12 = (Function1) null;
            Constructor<?>[] constructors = exception.getClass().getConstructors();
            Intrinsics.checkExpressionValueIsNotNull(constructors, "exception.javaClass.constructors");
            Iterator it = ArraysKt.sortedWith(constructors, new Comparator<T>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Constructor it2 = (Constructor) t2;
                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                    Integer valueOf = Integer.valueOf(it2.getParameterTypes().length);
                    Constructor it3 = (Constructor) t;
                    Intrinsics.checkExpressionValueIsNotNull(it3, "it");
                    return ComparisonsKt.compareValues(valueOf, Integer.valueOf(it3.getParameterTypes().length));
                }
            }).iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                final Constructor constructor = (Constructor) it.next();
                Intrinsics.checkExpressionValueIsNotNull(constructor, "constructor");
                Class<?>[] parameters = constructor.getParameterTypes();
                boolean z = true;
                if (parameters.length == 2 && Intrinsics.areEqual(parameters[0], String.class) && Intrinsics.areEqual(parameters[1], Throwable.class)) {
                    function12 = new Function1<Throwable, E>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Throwable;)TE; */
                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable e) {
                            Object m51constructorimpl;
                            Object newInstance;
                            Intrinsics.checkParameterIsNotNull(e, "e");
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                newInstance = constructor.newInstance(e.getMessage(), e);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m51constructorimpl = Result.m51constructorimpl(ResultKt.createFailure(th));
                            }
                            if (newInstance == null) {
                                throw new TypeCastException("null cannot be cast to non-null type E");
                            }
                            m51constructorimpl = Result.m51constructorimpl((Throwable) newInstance);
                            if (Result.m57isFailureimpl(m51constructorimpl)) {
                                m51constructorimpl = null;
                            }
                            return (Throwable) m51constructorimpl;
                        }
                    };
                    break;
                }
                if (parameters.length == 1 && Intrinsics.areEqual(parameters[0], Throwable.class)) {
                    function12 = new Function1<Throwable, E>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Throwable;)TE; */
                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable e) {
                            Object m51constructorimpl;
                            Object newInstance;
                            Intrinsics.checkParameterIsNotNull(e, "e");
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                newInstance = constructor.newInstance(e);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m51constructorimpl = Result.m51constructorimpl(ResultKt.createFailure(th));
                            }
                            if (newInstance == null) {
                                throw new TypeCastException("null cannot be cast to non-null type E");
                            }
                            m51constructorimpl = Result.m51constructorimpl((Throwable) newInstance);
                            if (Result.m57isFailureimpl(m51constructorimpl)) {
                                m51constructorimpl = null;
                            }
                            return (Throwable) m51constructorimpl;
                        }
                    };
                    break;
                }
                Intrinsics.checkExpressionValueIsNotNull(parameters, "parameters");
                if (parameters.length != 0) {
                    z = false;
                }
                if (z) {
                    function12 = new Function1<Throwable, E>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Throwable;)TE; */
                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable e) {
                            Object m51constructorimpl;
                            Object newInstance;
                            Intrinsics.checkParameterIsNotNull(e, "e");
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                newInstance = constructor.newInstance(new Object[0]);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m51constructorimpl = Result.m51constructorimpl(ResultKt.createFailure(th));
                            }
                            if (newInstance == null) {
                                throw new TypeCastException("null cannot be cast to non-null type E");
                            }
                            m51constructorimpl = Result.m51constructorimpl((Throwable) newInstance);
                            if (Result.m57isFailureimpl(m51constructorimpl)) {
                                m51constructorimpl = null;
                            }
                            Throwable th2 = (Throwable) m51constructorimpl;
                            if (th2 == null) {
                                return null;
                            }
                            th2.initCause(e);
                            return th2;
                        }
                    };
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                exceptionConstructors.put(exception.getClass(), function12 != null ? function12 : new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(Throwable it2) {
                        Intrinsics.checkParameterIsNotNull(it2, "it");
                        return null;
                    }
                });
                Unit unit = Unit.INSTANCE;
                if (function12 != null) {
                    return (E) function12.invoke(exception);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock2.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
}

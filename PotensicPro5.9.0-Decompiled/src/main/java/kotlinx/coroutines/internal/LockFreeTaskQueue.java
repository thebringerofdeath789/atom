package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: LockFreeTaskQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\b¢\u0006\u0002\u0010\u001fR$\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "removeFirstOrNullIf", "predicate", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public class LockFreeTaskQueue<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _cur$FU$internal = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur$internal");
    public volatile /* synthetic */ Object _cur$internal;

    public LockFreeTaskQueue(boolean z) {
        this._cur$internal = new LockFreeTaskQueueCore(8, z);
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore) this._cur$internal).isEmpty();
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore) this._cur$internal).getSize();
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ((LockFreeTaskQueueCore) this._cur$internal).map(transform);
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore) this._cur$internal).isClosed();
    }

    public final void close() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            if (lockFreeTaskQueueCore.close()) {
                return;
            } else {
                _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            }
        }
    }

    public final boolean addLast(E element) {
        Intrinsics.checkParameterIsNotNull(element, "element");
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            int addLast = lockFreeTaskQueueCore.addLast(element);
            if (addLast == 0) {
                return true;
            }
            if (addLast == 1) {
                _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            } else if (addLast == 2) {
                return false;
            }
        }
    }

    public final E removeFirstOrNull() {
        E e;
        Object obj;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur$internal;
            while (true) {
                long j = lockFreeTaskQueueCore._state$internal;
                e = null;
                if ((LockFreeTaskQueueCore.FROZEN_MASK & j) != 0) {
                    e = (E) LockFreeTaskQueueCore.REMOVE_FROZEN;
                    break;
                }
                LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.INSTANCE;
                int i = (int) ((LockFreeTaskQueueCore.HEAD_MASK & j) >> 0);
                if ((((int) ((LockFreeTaskQueueCore.TAIL_MASK & j) >> 30)) & lockFreeTaskQueueCore.mask) == (lockFreeTaskQueueCore.mask & i)) {
                    break;
                }
                obj = lockFreeTaskQueueCore.array.get(lockFreeTaskQueueCore.mask & i);
                if (obj == null) {
                    if (lockFreeTaskQueueCore.singleConsumer) {
                        break;
                    }
                } else {
                    if (obj instanceof LockFreeTaskQueueCore.Placeholder) {
                        break;
                    }
                    int i2 = (i + 1) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                    if (LockFreeTaskQueueCore._state$FU$internal.compareAndSet(lockFreeTaskQueueCore, j, LockFreeTaskQueueCore.INSTANCE.updateHead(j, i2))) {
                        lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i, null);
                        break;
                    }
                    if (lockFreeTaskQueueCore.singleConsumer) {
                        LockFreeTaskQueueCore lockFreeTaskQueueCore2 = lockFreeTaskQueueCore;
                        do {
                            lockFreeTaskQueueCore2 = lockFreeTaskQueueCore2.removeSlowPath(i, i2);
                        } while (lockFreeTaskQueueCore2 != null);
                    }
                }
            }
            e = (E) obj;
            if (e != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e;
            }
            _cur$FU$internal.compareAndSet(this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
    
        r7 = (E) r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final E removeFirstOrNullIf(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
        L5:
            java.lang.Object r0 = r11._cur$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0
        L9:
            long r3 = r0._state$internal
            r1 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            r5 = 0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            r7 = 0
            if (r1 == 0) goto L19
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            goto L95
        L19:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.INSTANCE
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r5 = 0
            long r1 = r1 >> r5
            int r8 = (int) r1
            r1 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r1 = r1 & r3
            r5 = 30
            long r1 = r1 >> r5
            int r1 = (int) r1
            int r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getMask$p(r0)
            r1 = r1 & r2
            int r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getMask$p(r0)
            r2 = r2 & r8
            if (r1 != r2) goto L39
            goto L95
        L39:
            java.util.concurrent.atomic.AtomicReferenceArray r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getArray$p(r0)
            int r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getMask$p(r0)
            r2 = r2 & r8
            java.lang.Object r9 = r1.get(r2)
            if (r9 != 0) goto L4f
            boolean r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getSingleConsumer$p(r0)
            if (r1 == 0) goto L9
            goto L95
        L4f:
            boolean r1 = r9 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore.Placeholder
            if (r1 == 0) goto L54
            goto L95
        L54:
            java.lang.Object r1 = r12.invoke(r9)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L61
            goto L95
        L61:
            int r1 = r8 + 1
            r2 = 1073741823(0x3fffffff, float:1.9999999)
            r10 = r1 & r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.INSTANCE
            long r5 = r2.updateHead(r3, r10)
            r2 = r0
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L84
            java.util.concurrent.atomic.AtomicReferenceArray r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getArray$p(r0)
            int r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getMask$p(r0)
            r2 = r2 & r8
            r1.set(r2, r7)
            goto L94
        L84:
            boolean r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$getSingleConsumer$p(r0)
            if (r1 != 0) goto L8c
            goto L9
        L8c:
            r1 = r0
        L8d:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.access$removeSlowPath(r1, r8, r10)
            if (r1 == 0) goto L94
            goto L8d
        L94:
            r7 = r9
        L95:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN
            if (r7 == r1) goto L9a
            return r7
        L9a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeTaskQueue._cur$FU$internal
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = r0.next()
            r1.compareAndSet(r11, r0, r2)
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueue.removeFirstOrNullIf(kotlin.jvm.functions.Function1):java.lang.Object");
    }
}

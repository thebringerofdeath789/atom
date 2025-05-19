package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.util.CellUtil;

/* compiled from: Mutex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0007\"#$%&'(B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u001b\u0010\u0012\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014JR\u0010\u0016\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\"\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\"\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "", CellUtil.LOCKED, "", "(Z)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "isLocked", "()Z", "isLockedEmptyQueueState", "isLockedEmptyQueueState$kotlinx_coroutines_core", "onLock", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "owner", "lock", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "registerSelectClause2", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "toString", "", "tryLock", "unlock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryEnqueueLockDesc", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile Object _state;

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.EMPTY_LOCKED : MutexKt.EMPTY_UNLOCKED;
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        return (obj instanceof LockedQueue) && ((LockedQueue) obj).isEmpty();
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object obj, Continuation<? super Unit> continuation) {
        return tryLock(obj) ? Unit.INSTANCE : lockSuspend(obj, continuation);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> select, Object owner, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> block) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Intrinsics.checkParameterIsNotNull(select, "select");
        Intrinsics.checkParameterIsNotNull(block, "block");
        while (!select.isSelected()) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                Object obj2 = empty.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    _state$FU.compareAndSet(this, obj, new LockedQueue(empty.locked));
                } else {
                    Object performAtomicTrySelect = select.performAtomicTrySelect(new TryLockDesc(this, owner));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                        return;
                    } else {
                        if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                            return;
                        }
                        symbol2 = MutexKt.LOCK_FAIL;
                        if (performAtomicTrySelect != symbol2) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + performAtomicTrySelect).toString());
                        }
                    }
                }
            } else if (obj instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj;
                if (!(lockedQueue.owner != owner)) {
                    throw new IllegalStateException(("Already locked by " + owner).toString());
                }
                TryEnqueueLockDesc tryEnqueueLockDesc = new TryEnqueueLockDesc(this, owner, lockedQueue, select, block);
                Object performAtomicIfNotSelected = select.performAtomicIfNotSelected(tryEnqueueLockDesc);
                if (performAtomicIfNotSelected == null) {
                    select.disposeOnSelect((DisposableHandle) tryEnqueueLockDesc.node);
                    return;
                } else {
                    if (performAtomicIfNotSelected == SelectKt.getALREADY_SELECTED()) {
                        return;
                    }
                    symbol3 = MutexKt.ENQUEUE_FAIL;
                    if (performAtomicIfNotSelected != symbol3) {
                        throw new IllegalStateException(("performAtomicIfNotSelected(TryEnqueueLockDesc) returned " + performAtomicIfNotSelected).toString());
                    }
                }
            } else {
                if (!(obj instanceof OpDescriptor)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((OpDescriptor) obj).perform(this);
            }
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class TryLockDesc extends AtomicDesc {
        public final MutexImpl mutex;
        public final Object owner;

        public TryLockDesc(MutexImpl mutex, Object obj) {
            Intrinsics.checkParameterIsNotNull(mutex, "mutex");
            this.mutex = mutex;
            this.owner = obj;
        }

        /* compiled from: Mutex.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
        private final class PrepareOp extends OpDescriptor {
            private final AtomicOp<?> op;
            final /* synthetic */ TryLockDesc this$0;

            public PrepareOp(TryLockDesc tryLockDesc, AtomicOp<?> op) {
                Intrinsics.checkParameterIsNotNull(op, "op");
                this.this$0 = tryLockDesc;
                this.op = op;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public Object perform(Object affected) {
                Object obj = this.op.isDecided() ? MutexKt.EMPTY_UNLOCKED : this.op;
                if (affected == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
                }
                MutexImpl._state$FU.compareAndSet((MutexImpl) affected, this, obj);
                return null;
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public Object prepare(AtomicOp<?> op) {
            Empty empty;
            Symbol symbol;
            Intrinsics.checkParameterIsNotNull(op, "op");
            PrepareOp prepareOp = new PrepareOp(this, op);
            MutexImpl mutexImpl = this.mutex;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl._state$FU;
            empty = MutexKt.EMPTY_UNLOCKED;
            if (!atomicReferenceFieldUpdater.compareAndSet(mutexImpl, empty, prepareOp)) {
                symbol = MutexKt.LOCK_FAIL;
                return symbol;
            }
            return prepareOp.perform(this.mutex);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void complete(AtomicOp<?> op, Object failure) {
            Empty empty;
            Intrinsics.checkParameterIsNotNull(op, "op");
            if (failure != null) {
                empty = MutexKt.EMPTY_UNLOCKED;
            } else {
                empty = this.owner == null ? MutexKt.EMPTY_LOCKED : new Empty(this.owner);
            }
            MutexImpl._state$FU.compareAndSet(this.mutex, op, empty);
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003`\u0004BT\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0014R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryEnqueueLockDesc;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "Lkotlinx/coroutines/internal/AddLastDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "onPrepare", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class TryEnqueueLockDesc<R> extends LockFreeLinkedListNode.AddLastDesc<LockSelect<R>> {
        public final MutexImpl mutex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TryEnqueueLockDesc(MutexImpl mutex, Object obj, LockedQueue queue, SelectInstance<? super R> select, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> block) {
            super(queue, new LockSelect(obj, mutex, select, block));
            Intrinsics.checkParameterIsNotNull(mutex, "mutex");
            Intrinsics.checkParameterIsNotNull(queue, "queue");
            Intrinsics.checkParameterIsNotNull(select, "select");
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.mutex = mutex;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AddLastDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Symbol symbol;
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (this.mutex._state != this.queue) {
                symbol = MutexKt.ENQUEUE_FAIL;
                return symbol;
            }
            return super.onPrepare(affected, next);
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(Object owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Object obj = this._state;
        if (obj instanceof Empty) {
            if (((Empty) obj).locked == owner) {
                return true;
            }
        } else if ((obj instanceof LockedQueue) && ((LockedQueue) obj).owner == owner) {
            return true;
        }
        return false;
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class LockedQueue extends LockFreeLinkedListHead {
        public Object owner;

        public LockedQueue(Object owner) {
            Intrinsics.checkParameterIsNotNull(owner, "owner");
            this.owner = owner;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.owner + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H&J\u0006\u0010\t\u001a\u00020\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H&R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "owner", "", "(Ljava/lang/Object;)V", "completeResumeLockWaiter", "", "token", "dispose", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        public final Object owner;

        public abstract void completeResumeLockWaiter(Object token);

        public abstract Object tryResumeLockWaiter();

        public LockWaiter(Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    static final class LockCont extends LockWaiter {
        public final CancellableContinuation<Unit> cont;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, CancellableContinuation<? super Unit> cont) {
            super(obj);
            Intrinsics.checkParameterIsNotNull(cont, "cont");
            this.cont = cont;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public Object tryResumeLockWaiter() {
            return CancellableContinuation.DefaultImpls.tryResume$default(this.cont, Unit.INSTANCE, null, 2, null);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            this.cont.completeResume(token);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BL\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R1\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "owner", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/sync/Mutex;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class LockSelect<R> extends LockWaiter {
        public final Function2<Mutex, Continuation<? super R>, Object> block;
        public final Mutex mutex;
        public final SelectInstance<R> select;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(Object obj, Mutex mutex, SelectInstance<? super R> select, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> block) {
            super(obj);
            Intrinsics.checkParameterIsNotNull(mutex, "mutex");
            Intrinsics.checkParameterIsNotNull(select, "select");
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.mutex = mutex;
            this.select = select;
            this.block = block;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public Object tryResumeLockWaiter() {
            Symbol symbol;
            if (!this.select.trySelect(null)) {
                return null;
            }
            symbol = MutexKt.SELECT_SUCCESS;
            return symbol;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(Object token) {
            Symbol symbol;
            Intrinsics.checkParameterIsNotNull(token, "token");
            symbol = MutexKt.SELECT_SUCCESS;
            if (!(token == symbol)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            ContinuationKt.startCoroutine(this.block, this.mutex, this.select.getCompletion());
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockSelect[" + this.owner + ", " + this.mutex + ", " + this.select + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* compiled from: Mutex.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class UnlockOp extends OpDescriptor {
        public final LockedQueue queue;

        public UnlockOp(LockedQueue queue) {
            Intrinsics.checkParameterIsNotNull(queue, "queue");
            this.queue = queue;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object affected) {
            Symbol symbol;
            Object obj = this.queue.isEmpty() ? MutexKt.EMPTY_UNLOCKED : this.queue;
            if (affected != null) {
                MutexImpl mutexImpl = (MutexImpl) affected;
                MutexImpl._state$FU.compareAndSet(mutexImpl, this, obj);
                if (mutexImpl._state != this.queue) {
                    return null;
                }
                symbol = MutexKt.UNLOCK_FAIL;
                return symbol;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).locked;
                symbol = MutexKt.UNLOCKED;
                return obj2 != symbol;
            }
            if (obj instanceof LockedQueue) {
                return true;
            }
            if (!(obj instanceof OpDescriptor)) {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object owner) {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    return false;
                }
                if (_state$FU.compareAndSet(this, obj, owner == null ? MutexKt.EMPTY_LOCKED : new Empty(owner))) {
                    return true;
                }
            } else {
                if (obj instanceof LockedQueue) {
                    if (((LockedQueue) obj).owner != owner) {
                        return false;
                    }
                    throw new IllegalStateException(("Already locked by " + owner).toString());
                }
                if (!(obj instanceof OpDescriptor)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((OpDescriptor) obj).perform(this);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
    
        r0 = r10.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009f, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a1, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a4, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ java.lang.Object lockSuspend(final java.lang.Object r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.lockSuspend(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object owner) {
        Empty empty;
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                if (owner == null) {
                    Object obj2 = ((Empty) obj).locked;
                    symbol = MutexKt.UNLOCKED;
                    if (!(obj2 != symbol)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty2 = (Empty) obj;
                    if (!(empty2.locked == owner)) {
                        throw new IllegalStateException(("Mutex is locked by " + empty2.locked + " but expected " + owner).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                empty = MutexKt.EMPTY_UNLOCKED;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, empty)) {
                    return;
                }
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof LockedQueue) {
                if (owner != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj;
                    if (!(lockedQueue.owner == owner)) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + owner).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (_state$FU.compareAndSet(this, obj, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) removeFirstOrNull;
                    Object tryResumeLockWaiter = lockWaiter.tryResumeLockWaiter();
                    if (tryResumeLockWaiter != null) {
                        Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj3;
                        lockWaiter.completeResumeLockWaiter(tryResumeLockWaiter);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).locked + PropertyUtils.INDEXED_DELIM2;
            }
            if (!(obj instanceof OpDescriptor)) {
                if (obj instanceof LockedQueue) {
                    return "Mutex[" + ((LockedQueue) obj).owner + PropertyUtils.INDEXED_DELIM2;
                }
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
            ((OpDescriptor) obj).perform(this);
        }
    }
}

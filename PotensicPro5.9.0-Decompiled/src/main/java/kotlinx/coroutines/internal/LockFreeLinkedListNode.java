package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0004BCDEB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0019\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0086\bJ-\u0010\u001c\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\t0\u001eH\u0086\bJ=\u0010\u001f\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u000f\u0012\u0004\u0012\u00020\t0\u001e2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0086\bJ \u0010 \u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010!\u001a\u00020\t2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000fJ&\u0010\"\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\n\u0010\u0005\u001a\u00060\u0000j\u0002`\u000f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J'\u0010%\u001a\b\u0012\u0004\u0012\u0002H'0&\"\f\b\u0000\u0010'*\u00060\u0000j\u0002`\u000f2\u0006\u0010\u0018\u001a\u0002H'¢\u0006\u0002\u0010(J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000f0,J\f\u0010-\u001a\u00060\u0000j\u0002`\u000fH\u0002J\u0014\u0010.\u001a\u00020\u00172\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J\u0014\u0010/\u001a\u00020\u00172\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J\b\u00100\u001a\u00020\u0017H\u0001J\u0006\u00101\u001a\u00020\u0017J%\u00102\u001a\u0002032\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0081\bJ\f\u00104\u001a\u00060\u0000j\u0002`\u000fH\u0002J\b\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\rJ,\u00107\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020\t0\u001eH\u0086\b¢\u0006\u0002\u00108J\u000e\u00109\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fJ\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020<H\u0016J(\u0010=\u001a\u00020>2\n\u0010\u0018\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010?\u001a\u000203H\u0001J%\u0010@\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000¢\u0006\u0002\bAR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\u0014\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011¨\u0006F"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prev", "getPrev", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addLastIfPrev", "predicate", "Lkotlin/Function1;", "addLastIfPrevAndIf", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "describeAddLast", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeRemove", "Lkotlinx/coroutines/internal/AtomicDesc;", "describeRemoveFirst", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "findHead", "finishAdd", "finishRemove", "helpDelete", "helpRemove", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "markPrev", "remove", "removeFirstIfIsInstanceOf", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "validateNode$kotlinx_coroutines_core", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public class LockFreeLinkedListNode {
    static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        _removedRef$FU.lazySet(this, removed2);
        return removed2;
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(LockFreeLinkedListNode newNode) {
            Intrinsics.checkParameterIsNotNull(newNode, "newNode");
            this.newNode = newNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(LockFreeLinkedListNode affected, Object failure) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            boolean z = failure == null;
            LockFreeLinkedListNode lockFreeLinkedListNode = z ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode != null && LockFreeLinkedListNode._next$FU.compareAndSet(affected, this, lockFreeLinkedListNode) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.oldNext;
                if (lockFreeLinkedListNode3 == null) {
                    Intrinsics.throwNpe();
                }
                lockFreeLinkedListNode2.finishAdd(lockFreeLinkedListNode3);
            }
        }
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode node, Function0<Boolean> condition) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(condition, "condition");
        return new LockFreeLinkedListNode$makeCondAddOp$1(condition, node, node);
    }

    public final boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        return LockFreeLinkedListKt.unwrap(getPrev());
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, this);
        while (getNext() == this) {
            if (_next$FU.compareAndSet(this, this, node)) {
                node.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    public final void addLast(LockFreeLinkedListNode node) {
        Object prev;
        Intrinsics.checkParameterIsNotNull(node, "node");
        do {
            prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!((LockFreeLinkedListNode) prev).addNext(node, this));
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        return new AddLastDesc<>(this, node);
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode node, Function1<? super LockFreeLinkedListNode, Boolean> predicate) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        do {
            Object prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
            if (!predicate.invoke(lockFreeLinkedListNode).booleanValue()) {
                return false;
            }
        } while (!lockFreeLinkedListNode.addNext(node, this));
        return true;
    }

    public final boolean addNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(next, "next");
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, next, node)) {
            return false;
        }
        node.finishAdd(next);
        return true;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode node, LockFreeLinkedListNode next, CondAddOp condAdd) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(next, "next");
        Intrinsics.checkParameterIsNotNull(condAdd, "condAdd");
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (atomicReferenceFieldUpdater.compareAndSet(this, next, condAdd)) {
            return condAdd.perform(this) == null ? 1 : 2;
        }
        return 0;
    }

    public boolean remove() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if ((next instanceof Removed) || next == this) {
                return false;
            }
            if (next != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!_next$FU.compareAndSet(this, next, lockFreeLinkedListNode.removed()));
        finishRemove(lockFreeLinkedListNode);
        return true;
    }

    public final void helpRemove() {
        Object next = getNext();
        if (!(next instanceof Removed)) {
            next = null;
        }
        Removed removed = (Removed) next;
        if (removed == null) {
            throw new IllegalStateException("Must be invoked on a removed node".toString());
        }
        finishRemove(removed.ref);
    }

    /* renamed from: describeRemove */
    public AtomicDesc mo1370describeRemove() {
        if (isRemoved()) {
            return null;
        }
        return new AbstractAtomicDesc() { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$describeRemove$1
            private static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode$describeRemove$1.class, Object.class, "_originalNext");
            private volatile Object _originalNext = null;

            @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            /* renamed from: getAffectedNode, reason: from getter */
            protected LockFreeLinkedListNode getThis$0() {
                return LockFreeLinkedListNode.this;
            }

            @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            /* renamed from: getOriginalNext */
            protected LockFreeLinkedListNode getQueue() {
                return (LockFreeLinkedListNode) this._originalNext;
            }

            @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected Object failure(LockFreeLinkedListNode affected, Object next) {
                Intrinsics.checkParameterIsNotNull(affected, "affected");
                Intrinsics.checkParameterIsNotNull(next, "next");
                if (next instanceof Removed) {
                    return LockFreeLinkedListKt.getALREADY_REMOVED();
                }
                return null;
            }

            @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                Intrinsics.checkParameterIsNotNull(affected, "affected");
                Intrinsics.checkParameterIsNotNull(next, "next");
                _originalNext$FU.compareAndSet(this, null, next);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            public Removed updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                Intrinsics.checkParameterIsNotNull(affected, "affected");
                Intrinsics.checkParameterIsNotNull(next, "next");
                return next.removed();
            }

            @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
            protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
                Intrinsics.checkParameterIsNotNull(affected, "affected");
                Intrinsics.checkParameterIsNotNull(next, "next");
                LockFreeLinkedListNode.this.finishRemove(next);
            }
        };
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            Object next = getNext();
            if (next == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpDelete();
        }
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    private final <T> T removeFirstIfIsInstanceOf() {
        while (true) {
            Object next = getNext();
            if (next == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            ?? r0 = (T) ((LockFreeLinkedListNode) next);
            if (r0 == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(r0 instanceof Object)) {
                return null;
            }
            if (r0.remove()) {
                return r0;
            }
            r0.helpDelete();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    private final <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> predicate) {
        while (true) {
            Object next = getNext();
            if (next == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(lockFreeLinkedListNode instanceof Object)) {
                return null;
            }
            if (predicate.invoke(lockFreeLinkedListNode).booleanValue() || lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpDelete();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0019\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J \u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0013\u001a\u00020\u0015H\u0014J\u0014\u0010\u0018\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0004J \u0010\u001b\u001a\u00020\u00152\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0014R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "node", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "_affectedNode", "Lkotlinx/atomicfu/AtomicRef;", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "finishOnSuccess", "", "affected", "next", "onPrepare", "", "retry", "", "takeAffectedNode", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(LockFreeLinkedListNode queue, T node) {
            Intrinsics.checkParameterIsNotNull(queue, "queue");
            Intrinsics.checkParameterIsNotNull(node, "node");
            this.queue = queue;
            this.node = node;
            if (!(node._next == node && node._prev == node)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this._affectedNode = null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            Intrinsics.checkParameterIsNotNull(op, "op");
            while (true) {
                Object obj = this.queue._prev;
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object obj2 = lockFreeLinkedListNode._next;
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.queue;
                if (obj2 == lockFreeLinkedListNode2 || obj2 == op) {
                    return lockFreeLinkedListNode;
                }
                if (!(obj2 instanceof OpDescriptor)) {
                    LockFreeLinkedListNode correctPrev = lockFreeLinkedListNode2.correctPrev(lockFreeLinkedListNode, op);
                    if (correctPrev != null) {
                        return correctPrev;
                    }
                } else {
                    ((OpDescriptor) obj2).perform(lockFreeLinkedListNode);
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getAffectedNode */
        protected final LockFreeLinkedListNode getThis$0() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getOriginalNext, reason: from getter */
        protected final LockFreeLinkedListNode getQueue() {
            return this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected boolean retry(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            return next != this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            _affectedNode$FU.compareAndSet(this, null, affected);
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            LockFreeLinkedListNode._prev$FU.compareAndSet(this.node, this.node, affected);
            LockFreeLinkedListNode._next$FU.compareAndSet(this.node, this.node, this.queue);
            return this.node;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            this.node.finishAdd(this.queue);
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\u0014J \u0010\u0018\u001a\u00020\u00192\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005H\u0004J\"\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005H\u0004J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\u0004J\u0014\u0010\u001d\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0004J \u0010 \u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005H\u0004J\u0015\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010#R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0003\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "_affectedNode", "Lkotlinx/atomicfu/AtomicRef;", "_originalNext", "affectedNode", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "result", "result$annotations", "()V", "getResult", "()Ljava/lang/Object;", "failure", "", "affected", "next", "finishOnSuccess", "", "onPrepare", "retry", "", "takeAffectedNode", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "validatePrepared", "node", "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        private volatile Object _affectedNode;
        private volatile Object _originalNext;
        public final LockFreeLinkedListNode queue;

        public static /* synthetic */ void result$annotations() {
        }

        protected boolean validatePrepared(T node) {
            return true;
        }

        public RemoveFirstDesc(LockFreeLinkedListNode queue) {
            Intrinsics.checkParameterIsNotNull(queue, "queue");
            this.queue = queue;
            this._affectedNode = null;
            this._originalNext = null;
        }

        public final T getResult() {
            Object this$0 = getThis$0();
            if (this$0 == null) {
                Intrinsics.throwNpe();
            }
            return (T) this$0;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            Intrinsics.checkParameterIsNotNull(op, "op");
            Object next = this.queue.getNext();
            if (next != null) {
                return (LockFreeLinkedListNode) next;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getAffectedNode */
        protected final LockFreeLinkedListNode getThis$0() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        /* renamed from: getOriginalNext */
        protected final LockFreeLinkedListNode getQueue() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (affected == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean retry(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (!(next instanceof Removed)) {
                return false;
            }
            affected.helpDelete();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            if (!(!(affected instanceof LockFreeLinkedListHead))) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!validatePrepared(affected)) {
                obj = LockFreeLinkedListKt.REMOVE_PREPARED;
                return obj;
            }
            _affectedNode$FU.compareAndSet(this, null, affected);
            _originalNext$FU.compareAndSet(this, null, next);
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            return next.removed();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            affected.finishRemove(next);
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J \u0010\u0012\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J\u0014\u0010\u0017\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u0018H\u0014J \u0010\u0019\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0011\u001a\u00060\u0004j\u0002`\u0005H$R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "", "affected", "next", "finishOnSuccess", "onPrepare", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        protected Object failure(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            return null;
        }

        protected abstract void finishOnSuccess(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        /* renamed from: getAffectedNode */
        protected abstract LockFreeLinkedListNode getThis$0();

        /* renamed from: getOriginalNext */
        protected abstract LockFreeLinkedListNode getQueue();

        protected abstract Object onPrepare(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        protected boolean retry(LockFreeLinkedListNode affected, Object next) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            Intrinsics.checkParameterIsNotNull(next, "next");
            return false;
        }

        protected abstract Object updatedNext(LockFreeLinkedListNode affected, LockFreeLinkedListNode next);

        protected LockFreeLinkedListNode takeAffectedNode(OpDescriptor op) {
            Intrinsics.checkParameterIsNotNull(op, "op");
            LockFreeLinkedListNode this$0 = getThis$0();
            if (this$0 == null) {
                Intrinsics.throwNpe();
            }
            return this$0;
        }

        /* compiled from: LockFreeLinkedList.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "next", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/AtomicOp;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
        private static final class PrepareOp extends OpDescriptor {
            public final AbstractAtomicDesc desc;
            public final LockFreeLinkedListNode next;
            public final AtomicOp<LockFreeLinkedListNode> op;

            /* JADX WARN: Multi-variable type inference failed */
            public PrepareOp(LockFreeLinkedListNode next, AtomicOp<? super LockFreeLinkedListNode> op, AbstractAtomicDesc desc) {
                Intrinsics.checkParameterIsNotNull(next, "next");
                Intrinsics.checkParameterIsNotNull(op, "op");
                Intrinsics.checkParameterIsNotNull(desc, "desc");
                this.next = next;
                this.op = op;
                this.desc = desc;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public Object perform(Object affected) {
                Object obj;
                if (affected != null) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) affected;
                    Object onPrepare = this.desc.onPrepare(lockFreeLinkedListNode, this.next);
                    if (onPrepare != null) {
                        obj = LockFreeLinkedListKt.REMOVE_PREPARED;
                        if (onPrepare == obj) {
                            if (LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next.removed())) {
                                lockFreeLinkedListNode.helpDelete();
                            }
                        } else {
                            this.op.tryDecide(onPrepare);
                            LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.next);
                        }
                        return onPrepare;
                    }
                    LockFreeLinkedListNode._next$FU.compareAndSet(lockFreeLinkedListNode, this, this.op.isDecided() ? this.next : this.op);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final Object prepare(AtomicOp<?> op) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(op, "op");
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(op);
                Object obj2 = takeAffectedNode._next;
                if (obj2 == op || op.isDecided()) {
                    return null;
                }
                if (obj2 instanceof OpDescriptor) {
                    ((OpDescriptor) obj2).perform(takeAffectedNode);
                } else {
                    Object failure = failure(takeAffectedNode, obj2);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(takeAffectedNode, obj2)) {
                        continue;
                    } else if (obj2 != null) {
                        PrepareOp prepareOp = new PrepareOp((LockFreeLinkedListNode) obj2, op, this);
                        if (LockFreeLinkedListNode._next$FU.compareAndSet(takeAffectedNode, obj2, prepareOp)) {
                            Object perform = prepareOp.perform(takeAffectedNode);
                            obj = LockFreeLinkedListKt.REMOVE_PREPARED;
                            if (perform != obj) {
                                return perform;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(AtomicOp<?> op, Object failure) {
            Intrinsics.checkParameterIsNotNull(op, "op");
            boolean z = failure == null;
            LockFreeLinkedListNode this$0 = getThis$0();
            if (this$0 == null) {
                if (!(!z)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            LockFreeLinkedListNode queue = getQueue();
            if (queue == null) {
                if (!(!z)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                if (LockFreeLinkedListNode._next$FU.compareAndSet(this$0, op, z ? updatedNext(this$0, queue) : queue) && z) {
                    finishOnSuccess(this$0, queue);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishRemove(LockFreeLinkedListNode next) {
        helpDelete();
        next.correctPrev(LockFreeLinkedListKt.unwrap(this._prev), null);
    }

    private final LockFreeLinkedListNode findHead() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
        while (!(lockFreeLinkedListNode2 instanceof LockFreeLinkedListHead)) {
            lockFreeLinkedListNode2 = lockFreeLinkedListNode2.getNextNode();
            if (!(lockFreeLinkedListNode2 != lockFreeLinkedListNode)) {
                throw new IllegalStateException("Cannot loop to this while looking for list head".toString());
            }
        }
        return lockFreeLinkedListNode2;
    }

    public final void helpDelete() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) null;
        LockFreeLinkedListNode markPrev = markPrev();
        Object obj = this._next;
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = ((Removed) obj).ref;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode;
            while (true) {
                Object next2 = lockFreeLinkedListNode2.getNext();
                if (next2 instanceof Removed) {
                    lockFreeLinkedListNode2.markPrev();
                    lockFreeLinkedListNode2 = ((Removed) next2).ref;
                } else {
                    next = markPrev.getNext();
                    if (next instanceof Removed) {
                        if (lockFreeLinkedListNode3 != null) {
                            break;
                        } else {
                            markPrev = LockFreeLinkedListKt.unwrap(markPrev._prev);
                        }
                    } else if (next != this) {
                        if (next == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                        LockFreeLinkedListNode lockFreeLinkedListNode4 = (LockFreeLinkedListNode) next;
                        if (lockFreeLinkedListNode4 == lockFreeLinkedListNode2) {
                            return;
                        }
                        lockFreeLinkedListNode3 = markPrev;
                        markPrev = lockFreeLinkedListNode4;
                    } else if (_next$FU.compareAndSet(markPrev, this, lockFreeLinkedListNode2)) {
                        return;
                    }
                }
            }
            markPrev.markPrev();
            _next$FU.compareAndSet(lockFreeLinkedListNode3, markPrev, ((Removed) next).ref);
            markPrev = lockFreeLinkedListNode3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LockFreeLinkedListNode correctPrev(LockFreeLinkedListNode _prev, OpDescriptor op) {
        Object obj;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) null;
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                obj = _prev._next;
                if (obj == op) {
                    return _prev;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(_prev);
                } else if (!(obj instanceof Removed)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof Removed) {
                        return null;
                    }
                    if (obj != this) {
                        if (obj == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                        lockFreeLinkedListNode2 = _prev;
                        _prev = (LockFreeLinkedListNode) obj;
                    } else {
                        if (obj2 == _prev) {
                            return null;
                        }
                        if (_prev$FU.compareAndSet(this, obj2, _prev) && !(_prev._prev instanceof Removed)) {
                            return null;
                        }
                    }
                } else {
                    if (lockFreeLinkedListNode2 != null) {
                        break;
                    }
                    _prev = LockFreeLinkedListKt.unwrap(_prev._prev);
                }
            }
            _prev.markPrev();
            _next$FU.compareAndSet(lockFreeLinkedListNode2, _prev, ((Removed) obj).ref);
            _prev = lockFreeLinkedListNode2;
        }
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode prev, LockFreeLinkedListNode next) {
        Intrinsics.checkParameterIsNotNull(prev, "prev");
        Intrinsics.checkParameterIsNotNull(next, "next");
        if (!(prev == this._prev)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(next == this._next)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    public final Object getPrev() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return obj;
            }
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                if (lockFreeLinkedListNode.getNext() == this) {
                    return obj;
                }
                correctPrev(lockFreeLinkedListNode, null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final boolean addLastIf(LockFreeLinkedListNode node, Function0<Boolean> condition) {
        int tryCondAddNext;
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(condition, "condition");
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(condition, node, node);
        do {
            Object prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode node, Function1<? super LockFreeLinkedListNode, Boolean> predicate, Function0<Boolean> condition) {
        int tryCondAddNext;
        Intrinsics.checkParameterIsNotNull(node, "node");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Intrinsics.checkParameterIsNotNull(condition, "condition");
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(condition, node, node);
        do {
            Object prev = getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
            if (!predicate.invoke(lockFreeLinkedListNode).booleanValue()) {
                return false;
            }
            tryCondAddNext = lockFreeLinkedListNode.tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode next) {
        Object obj;
        do {
            obj = next._prev;
            if ((obj instanceof Removed) || getNext() != next) {
                return;
            }
        } while (!_prev$FU.compareAndSet(next, obj, this));
        if (getNext() instanceof Removed) {
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            next.correctPrev((LockFreeLinkedListNode) obj, null);
        }
    }

    private final LockFreeLinkedListNode markPrev() {
        Object obj;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).ref;
            }
            if (obj == this) {
                lockFreeLinkedListNode = findHead();
            } else {
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            }
        } while (!_prev$FU.compareAndSet(this, obj, lockFreeLinkedListNode.removed()));
        return (LockFreeLinkedListNode) obj;
    }
}

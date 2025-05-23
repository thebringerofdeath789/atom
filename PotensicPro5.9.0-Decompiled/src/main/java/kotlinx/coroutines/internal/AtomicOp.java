package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* compiled from: Atomic.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "Lkotlinx/coroutines/internal/OpDescriptor;", "()V", "_consensus", "Lkotlinx/atomicfu/AtomicRef;", "", "isDecided", "", "()Z", "complete", "", "affected", "failure", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decide", "decision", "perform", "prepare", "(Ljava/lang/Object;)Ljava/lang/Object;", "tryDecide", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public abstract class AtomicOp<T> extends OpDescriptor {
    private static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus;

    public abstract void complete(T affected, Object failure);

    public abstract Object prepare(T affected);

    public AtomicOp() {
        Object obj;
        obj = AtomicKt.NO_DECISION;
        this._consensus = obj;
    }

    public final boolean isDecided() {
        Object obj;
        Object obj2 = this._consensus;
        obj = AtomicKt.NO_DECISION;
        return obj2 != obj;
    }

    public final boolean tryDecide(Object decision) {
        Object obj;
        Object obj2;
        obj = AtomicKt.NO_DECISION;
        if (!(decision != obj)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _consensus$FU;
        obj2 = AtomicKt.NO_DECISION;
        return atomicReferenceFieldUpdater.compareAndSet(this, obj2, decision);
    }

    private final Object decide(Object decision) {
        return tryDecide(decision) ? decision : this._consensus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    public final Object perform(Object affected) {
        Object obj;
        Object obj2 = this._consensus;
        obj = AtomicKt.NO_DECISION;
        if (obj2 == obj) {
            obj2 = decide(prepare(affected));
        }
        complete(affected, obj2);
        return obj2;
    }
}

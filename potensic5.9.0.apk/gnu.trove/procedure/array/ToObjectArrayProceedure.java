package gnu.trove.procedure.array;

import gnu.trove.procedure.TObjectProcedure;

/* loaded from: classes3.dex */
public final class ToObjectArrayProceedure<T> implements TObjectProcedure<T> {
    private int pos = 0;
    private final T[] target;

    public ToObjectArrayProceedure(T[] tArr) {
        this.target = tArr;
    }

    @Override // gnu.trove.procedure.TObjectProcedure
    public final boolean execute(T t) {
        T[] tArr = this.target;
        int i = this.pos;
        this.pos = i + 1;
        tArr[i] = t;
        return true;
    }
}
package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TIntSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableIntSet extends TUnmodifiableIntCollection implements TIntSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableIntSet(TIntSet tIntSet) {
        super(tIntSet);
    }

    @Override // gnu.trove.TIntCollection
    public boolean equals(Object obj) {
        return obj == this || this.f3692c.equals(obj);
    }

    @Override // gnu.trove.TIntCollection
    public int hashCode() {
        return this.f3692c.hashCode();
    }
}
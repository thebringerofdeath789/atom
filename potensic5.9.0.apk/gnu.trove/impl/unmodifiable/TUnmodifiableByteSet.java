package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TByteSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableByteSet extends TUnmodifiableByteCollection implements TByteSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableByteSet(TByteSet tByteSet) {
        super(tByteSet);
    }

    @Override // gnu.trove.TByteCollection
    public boolean equals(Object obj) {
        return obj == this || this.f3652c.equals(obj);
    }

    @Override // gnu.trove.TByteCollection
    public int hashCode() {
        return this.f3652c.hashCode();
    }
}
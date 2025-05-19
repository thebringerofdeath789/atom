package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TFloatSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableFloatSet extends TUnmodifiableFloatCollection implements TFloatSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableFloatSet(TFloatSet tFloatSet) {
        super(tFloatSet);
    }

    @Override // gnu.trove.TFloatCollection
    public boolean equals(Object obj) {
        return obj == this || this.c.equals(obj);
    }

    @Override // gnu.trove.TFloatCollection
    public int hashCode() {
        return this.c.hashCode();
    }
}

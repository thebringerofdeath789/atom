package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TShortSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableShortSet extends TUnmodifiableShortCollection implements TShortSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableShortSet(TShortSet tShortSet) {
        super(tShortSet);
    }

    @Override // gnu.trove.TShortCollection
    public boolean equals(Object obj) {
        return obj == this || this.c.equals(obj);
    }

    @Override // gnu.trove.TShortCollection
    public int hashCode() {
        return this.c.hashCode();
    }
}

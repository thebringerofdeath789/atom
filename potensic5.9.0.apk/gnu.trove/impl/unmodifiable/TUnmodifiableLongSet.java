package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TLongSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableLongSet extends TUnmodifiableLongCollection implements TLongSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableLongSet(TLongSet tLongSet) {
        super(tLongSet);
    }

    @Override // gnu.trove.TLongCollection
    public boolean equals(Object obj) {
        return obj == this || this.f3702c.equals(obj);
    }

    @Override // gnu.trove.TLongCollection
    public int hashCode() {
        return this.f3702c.hashCode();
    }
}
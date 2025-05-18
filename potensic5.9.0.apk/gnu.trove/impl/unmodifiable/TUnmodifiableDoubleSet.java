package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TDoubleSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableDoubleSet extends TUnmodifiableDoubleCollection implements TDoubleSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableDoubleSet(TDoubleSet tDoubleSet) {
        super(tDoubleSet);
    }

    @Override // gnu.trove.TDoubleCollection
    public boolean equals(Object obj) {
        return obj == this || this.f3672c.equals(obj);
    }

    @Override // gnu.trove.TDoubleCollection
    public int hashCode() {
        return this.f3672c.hashCode();
    }
}
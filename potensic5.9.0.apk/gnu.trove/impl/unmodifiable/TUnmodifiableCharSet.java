package gnu.trove.impl.unmodifiable;

import gnu.trove.set.TCharSet;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TUnmodifiableCharSet extends TUnmodifiableCharCollection implements TCharSet, Serializable {
    private static final long serialVersionUID = -9215047833775013803L;

    public TUnmodifiableCharSet(TCharSet tCharSet) {
        super(tCharSet);
    }

    @Override // gnu.trove.TCharCollection
    public boolean equals(Object obj) {
        return obj == this || this.f3662c.equals(obj);
    }

    @Override // gnu.trove.TCharCollection
    public int hashCode() {
        return this.f3662c.hashCode();
    }
}
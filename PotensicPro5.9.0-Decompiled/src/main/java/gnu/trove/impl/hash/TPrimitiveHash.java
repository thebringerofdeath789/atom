package gnu.trove.impl.hash;

/* loaded from: classes3.dex */
public abstract class TPrimitiveHash extends THash {
    public static final byte FREE = 0;
    public static final byte FULL = 1;
    public static final byte REMOVED = 2;
    static final long serialVersionUID = 1;
    public transient byte[] _states;

    public TPrimitiveHash() {
    }

    public TPrimitiveHash(int i) {
        super(i, 0.5f);
    }

    public TPrimitiveHash(int i, float f) {
        super(i, f);
    }

    @Override // gnu.trove.impl.hash.THash
    public int capacity() {
        return this._states.length;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._states[i] = 2;
        super.removeAt(i);
    }

    @Override // gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._states = new byte[up];
        return up;
    }
}

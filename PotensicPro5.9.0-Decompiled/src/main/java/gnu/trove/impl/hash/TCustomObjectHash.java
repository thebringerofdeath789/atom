package gnu.trove.impl.hash;

import gnu.trove.strategy.HashingStrategy;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* loaded from: classes3.dex */
public abstract class TCustomObjectHash<T> extends TObjectHash<T> {
    static final long serialVersionUID = 8766048185963756400L;
    protected HashingStrategy<? super T> strategy;

    public TCustomObjectHash() {
    }

    public TCustomObjectHash(HashingStrategy<? super T> hashingStrategy) {
        this.strategy = hashingStrategy;
    }

    public TCustomObjectHash(HashingStrategy<? super T> hashingStrategy, int i) {
        super(i);
        this.strategy = hashingStrategy;
    }

    public TCustomObjectHash(HashingStrategy<? super T> hashingStrategy, int i, float f) {
        super(i, f);
        this.strategy = hashingStrategy;
    }

    @Override // gnu.trove.impl.hash.TObjectHash
    protected int hash(Object obj) {
        return this.strategy.computeHashCode(obj);
    }

    @Override // gnu.trove.impl.hash.TObjectHash
    protected boolean equals(Object obj, Object obj2) {
        return obj2 != REMOVED && this.strategy.equals(obj, obj2);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeObject(this.strategy);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.strategy = (HashingStrategy) objectInput.readObject();
    }
}

package gnu.trove.set.hash;

import gnu.trove.TDoubleCollection;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TDoubleHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.set.TDoubleSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TDoubleHashSet extends TDoubleHash implements TDoubleSet, Externalizable {
    static final long serialVersionUID = 1;

    public TDoubleHashSet() {
    }

    public TDoubleHashSet(int i) {
        super(i);
    }

    public TDoubleHashSet(int i, float f) {
        super(i, f);
    }

    public TDoubleHashSet(int i, float f, double d) {
        super(i, f, d);
        if (d != 0.0d) {
            Arrays.fill(this._set, d);
        }
    }

    public TDoubleHashSet(Collection<? extends Double> collection) {
        this(Math.max(collection.size(), 10));
        addAll(collection);
    }

    public TDoubleHashSet(TDoubleCollection tDoubleCollection) {
        this(Math.max(tDoubleCollection.size(), 10));
        if (tDoubleCollection instanceof TDoubleHashSet) {
            TDoubleHashSet tDoubleHashSet = (TDoubleHashSet) tDoubleCollection;
            this._loadFactor = tDoubleHashSet._loadFactor;
            this.no_entry_value = tDoubleHashSet.no_entry_value;
            if (this.no_entry_value != 0.0d) {
                Arrays.fill(this._set, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        addAll(tDoubleCollection);
    }

    public TDoubleHashSet(double[] dArr) {
        this(Math.max(dArr.length, 10));
        addAll(dArr);
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public TDoubleIterator iterator() {
        return new TDoubleHashIterator(this);
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public double[] toArray() {
        return toArray(new double[this._size]);
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public double[] toArray(double[] dArr) {
        if (dArr.length < this._size) {
            dArr = new double[this._size];
        }
        double[] dArr2 = this._set;
        byte[] bArr = this._states;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (bArr[i2] == 1) {
                dArr[i] = dArr2[i2];
                i++;
            }
            length = i2;
        }
        if (dArr.length > this._size) {
            dArr[this._size] = this.no_entry_value;
        }
        return dArr;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean add(double d) {
        if (insertKey(d) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean remove(double d) {
        int index = index(d);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Double) || !contains(((Double) obj).doubleValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean containsAll(TDoubleCollection tDoubleCollection) {
        TDoubleIterator it = tDoubleCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean containsAll(double[] dArr) {
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean addAll(Collection<? extends Double> collection) {
        Iterator<? extends Double> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().doubleValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean addAll(TDoubleCollection tDoubleCollection) {
        TDoubleIterator it = tDoubleCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean addAll(double[] dArr) {
        int length = dArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (add(dArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean retainAll(Collection<?> collection) {
        TDoubleIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Double.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean retainAll(TDoubleCollection tDoubleCollection) {
        boolean z = false;
        if (this == tDoubleCollection) {
            return false;
        }
        TDoubleIterator it = iterator();
        while (it.hasNext()) {
            if (!tDoubleCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean retainAll(double[] dArr) {
        Arrays.sort(dArr);
        double[] dArr2 = this._set;
        byte[] bArr = this._states;
        this._autoCompactTemporaryDisable = true;
        int length = dArr2.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (bArr[i] == 1 && Arrays.binarySearch(dArr, dArr2[i]) < 0) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            } else {
                this._autoCompactTemporaryDisable = false;
                return z;
            }
        }
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Double) && remove(((Double) obj).doubleValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean removeAll(TDoubleCollection tDoubleCollection) {
        TDoubleIterator it = tDoubleCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean removeAll(double[] dArr) {
        int length = dArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(dArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        double[] dArr = this._set;
        byte[] bArr = this._states;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            dArr[i] = this.no_entry_value;
            bArr[i] = 0;
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        double[] dArr = this._set;
        byte[] bArr = this._states;
        this._set = new double[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                insertKey(dArr[i2]);
            }
            length = i2;
        }
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public boolean equals(Object obj) {
        if (!(obj instanceof TDoubleSet)) {
            return false;
        }
        TDoubleSet tDoubleSet = (TDoubleSet) obj;
        if (tDoubleSet.size() != size()) {
            return false;
        }
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (this._states[i] == 1 && !tDoubleSet.contains(this._set[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
    public int hashCode() {
        int length = this._states.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (this._states[i2] == 1) {
                i += HashFunctions.hash(this._set[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this._size * 2) + 2);
        sb.append("{");
        int length = this._states.length;
        int i = 1;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                if (this._states[i2] == 1) {
                    sb.append(this._set[i2]);
                    int i3 = i + 1;
                    if (i < this._size) {
                        sb.append(",");
                    }
                    i = i3;
                }
                length = i2;
            } else {
                sb.append(StringSubstitutor.DEFAULT_VAR_END);
                return sb.toString();
            }
        }
    }

    class TDoubleHashIterator extends THashPrimitiveIterator implements TDoubleIterator {
        private final TDoubleHash _hash;

        public TDoubleHashIterator(TDoubleHash tDoubleHash) {
            super(tDoubleHash);
            this._hash = tDoubleHash;
        }

        @Override // gnu.trove.iterator.TDoubleIterator
        public double next() {
            moveToNextIndex();
            return this._hash._set[this._index];
        }
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(1);
        super.writeExternal(objectOutput);
        objectOutput.writeInt(this._size);
        objectOutput.writeFloat(this._loadFactor);
        objectOutput.writeDouble(this.no_entry_value);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeDouble(this._set[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        super.readExternal(objectInput);
        int readInt = objectInput.readInt();
        if (readByte >= 1) {
            this._loadFactor = objectInput.readFloat();
            this.no_entry_value = objectInput.readDouble();
            if (this.no_entry_value != 0.0d) {
                Arrays.fill(this._set, this.no_entry_value);
            }
        }
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            add(objectInput.readDouble());
            readInt = i;
        }
    }
}

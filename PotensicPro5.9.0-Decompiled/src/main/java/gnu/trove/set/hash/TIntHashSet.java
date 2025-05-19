package gnu.trove.set.hash;

import gnu.trove.TIntCollection;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TIntHash;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.TIntSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TIntHashSet extends TIntHash implements TIntSet, Externalizable {
    static final long serialVersionUID = 1;

    public TIntHashSet() {
    }

    public TIntHashSet(int i) {
        super(i);
    }

    public TIntHashSet(int i, float f) {
        super(i, f);
    }

    public TIntHashSet(int i, float f, int i2) {
        super(i, f, i2);
        if (i2 != 0) {
            Arrays.fill(this._set, i2);
        }
    }

    public TIntHashSet(Collection<? extends Integer> collection) {
        this(Math.max(collection.size(), 10));
        addAll(collection);
    }

    public TIntHashSet(TIntCollection tIntCollection) {
        this(Math.max(tIntCollection.size(), 10));
        if (tIntCollection instanceof TIntHashSet) {
            TIntHashSet tIntHashSet = (TIntHashSet) tIntCollection;
            this._loadFactor = tIntHashSet._loadFactor;
            this.no_entry_value = tIntHashSet.no_entry_value;
            if (this.no_entry_value != 0) {
                Arrays.fill(this._set, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        addAll(tIntCollection);
    }

    public TIntHashSet(int[] iArr) {
        this(Math.max(iArr.length, 10));
        addAll(iArr);
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public TIntIterator iterator() {
        return new TIntHashIterator(this);
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public int[] toArray() {
        return toArray(new int[this._size]);
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public int[] toArray(int[] iArr) {
        if (iArr.length < this._size) {
            iArr = new int[this._size];
        }
        int[] iArr2 = this._set;
        byte[] bArr = this._states;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (bArr[i2] == 1) {
                iArr[i] = iArr2[i2];
                i++;
            }
            length = i2;
        }
        if (iArr.length > this._size) {
            iArr[this._size] = this.no_entry_value;
        }
        return iArr;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean add(int i) {
        if (insertKey(i) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean remove(int i) {
        int index = index(i);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Integer) || !contains(((Integer) obj).intValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean containsAll(TIntCollection tIntCollection) {
        TIntIterator it = tIntCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean containsAll(int[] iArr) {
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean addAll(Collection<? extends Integer> collection) {
        Iterator<? extends Integer> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().intValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean addAll(TIntCollection tIntCollection) {
        TIntIterator it = tIntCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean addAll(int[] iArr) {
        int length = iArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (add(iArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean retainAll(Collection<?> collection) {
        TIntIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Integer.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean retainAll(TIntCollection tIntCollection) {
        boolean z = false;
        if (this == tIntCollection) {
            return false;
        }
        TIntIterator it = iterator();
        while (it.hasNext()) {
            if (!tIntCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean retainAll(int[] iArr) {
        Arrays.sort(iArr);
        int[] iArr2 = this._set;
        byte[] bArr = this._states;
        this._autoCompactTemporaryDisable = true;
        int length = iArr2.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (bArr[i] == 1 && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
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

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Integer) && remove(((Integer) obj).intValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean removeAll(TIntCollection tIntCollection) {
        TIntIterator it = tIntCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean removeAll(int[] iArr) {
        int length = iArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(iArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        int[] iArr = this._set;
        byte[] bArr = this._states;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            iArr[i] = this.no_entry_value;
            bArr[i] = 0;
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        int[] iArr = this._set;
        byte[] bArr = this._states;
        this._set = new int[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                insertKey(iArr[i2]);
            }
            length = i2;
        }
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
    public boolean equals(Object obj) {
        if (!(obj instanceof TIntSet)) {
            return false;
        }
        TIntSet tIntSet = (TIntSet) obj;
        if (tIntSet.size() != size()) {
            return false;
        }
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (this._states[i] == 1 && !tIntSet.contains(this._set[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
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

    class TIntHashIterator extends THashPrimitiveIterator implements TIntIterator {
        private final TIntHash _hash;

        public TIntHashIterator(TIntHash tIntHash) {
            super(tIntHash);
            this._hash = tIntHash;
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
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
        objectOutput.writeInt(this.no_entry_value);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeInt(this._set[i]);
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
            this.no_entry_value = objectInput.readInt();
            if (this.no_entry_value != 0) {
                Arrays.fill(this._set, this.no_entry_value);
            }
        }
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            add(objectInput.readInt());
            readInt = i;
        }
    }
}

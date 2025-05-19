package gnu.trove.set.hash;

import gnu.trove.TShortCollection;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TShortHash;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.set.TShortSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TShortHashSet extends TShortHash implements TShortSet, Externalizable {
    static final long serialVersionUID = 1;

    public TShortHashSet() {
    }

    public TShortHashSet(int i) {
        super(i);
    }

    public TShortHashSet(int i, float f) {
        super(i, f);
    }

    public TShortHashSet(int i, float f, short s) {
        super(i, f, s);
        if (s != 0) {
            Arrays.fill(this._set, s);
        }
    }

    public TShortHashSet(Collection<? extends Short> collection) {
        this(Math.max(collection.size(), 10));
        addAll(collection);
    }

    public TShortHashSet(TShortCollection tShortCollection) {
        this(Math.max(tShortCollection.size(), 10));
        if (tShortCollection instanceof TShortHashSet) {
            TShortHashSet tShortHashSet = (TShortHashSet) tShortCollection;
            this._loadFactor = tShortHashSet._loadFactor;
            this.no_entry_value = tShortHashSet.no_entry_value;
            if (this.no_entry_value != 0) {
                Arrays.fill(this._set, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        addAll(tShortCollection);
    }

    public TShortHashSet(short[] sArr) {
        this(Math.max(sArr.length, 10));
        addAll(sArr);
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public TShortIterator iterator() {
        return new TShortHashIterator(this);
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public short[] toArray() {
        return toArray(new short[this._size]);
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public short[] toArray(short[] sArr) {
        if (sArr.length < this._size) {
            sArr = new short[this._size];
        }
        short[] sArr2 = this._set;
        byte[] bArr = this._states;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (bArr[i2] == 1) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
        if (sArr.length > this._size) {
            sArr[this._size] = this.no_entry_value;
        }
        return sArr;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean add(short s) {
        if (insertKey(s) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean remove(short s) {
        int index = index(s);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Short) || !contains(((Short) obj).shortValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean containsAll(TShortCollection tShortCollection) {
        TShortIterator it = tShortCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean containsAll(short[] sArr) {
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean addAll(Collection<? extends Short> collection) {
        Iterator<? extends Short> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().shortValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean addAll(TShortCollection tShortCollection) {
        TShortIterator it = tShortCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean addAll(short[] sArr) {
        int length = sArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (add(sArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean retainAll(Collection<?> collection) {
        TShortIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Short.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean retainAll(TShortCollection tShortCollection) {
        boolean z = false;
        if (this == tShortCollection) {
            return false;
        }
        TShortIterator it = iterator();
        while (it.hasNext()) {
            if (!tShortCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean retainAll(short[] sArr) {
        Arrays.sort(sArr);
        short[] sArr2 = this._set;
        byte[] bArr = this._states;
        this._autoCompactTemporaryDisable = true;
        int length = sArr2.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
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

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean removeAll(TShortCollection tShortCollection) {
        TShortIterator it = tShortCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean removeAll(short[] sArr) {
        int length = sArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(sArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        short[] sArr = this._set;
        byte[] bArr = this._states;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            sArr[i] = this.no_entry_value;
            bArr[i] = 0;
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        short[] sArr = this._set;
        byte[] bArr = this._states;
        this._set = new short[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                insertKey(sArr[i2]);
            }
            length = i2;
        }
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public boolean equals(Object obj) {
        if (!(obj instanceof TShortSet)) {
            return false;
        }
        TShortSet tShortSet = (TShortSet) obj;
        if (tShortSet.size() != size()) {
            return false;
        }
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (this._states[i] == 1 && !tShortSet.contains(this._set[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
    public int hashCode() {
        int length = this._states.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (this._states[i2] == 1) {
                i += HashFunctions.hash((int) this._set[i2]);
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
                    sb.append((int) this._set[i2]);
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

    class TShortHashIterator extends THashPrimitiveIterator implements TShortIterator {
        private final TShortHash _hash;

        public TShortHashIterator(TShortHash tShortHash) {
            super(tShortHash);
            this._hash = tShortHash;
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
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
        objectOutput.writeShort(this.no_entry_value);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeShort(this._set[i]);
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
            this.no_entry_value = objectInput.readShort();
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
            add(objectInput.readShort());
            readInt = i;
        }
    }
}

package gnu.trove.set.hash;

import gnu.trove.TByteCollection;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TByteHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.set.TByteSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TByteHashSet extends TByteHash implements TByteSet, Externalizable {
    static final long serialVersionUID = 1;

    public TByteHashSet() {
    }

    public TByteHashSet(int i) {
        super(i);
    }

    public TByteHashSet(int i, float f) {
        super(i, f);
    }

    public TByteHashSet(int i, float f, byte b) {
        super(i, f, b);
        if (b != 0) {
            Arrays.fill(this._set, b);
        }
    }

    public TByteHashSet(Collection<? extends Byte> collection) {
        this(Math.max(collection.size(), 10));
        addAll(collection);
    }

    public TByteHashSet(TByteCollection tByteCollection) {
        this(Math.max(tByteCollection.size(), 10));
        if (tByteCollection instanceof TByteHashSet) {
            TByteHashSet tByteHashSet = (TByteHashSet) tByteCollection;
            this._loadFactor = tByteHashSet._loadFactor;
            this.no_entry_value = tByteHashSet.no_entry_value;
            if (this.no_entry_value != 0) {
                Arrays.fill(this._set, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        addAll(tByteCollection);
    }

    public TByteHashSet(byte[] bArr) {
        this(Math.max(bArr.length, 10));
        addAll(bArr);
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public TByteIterator iterator() {
        return new TByteHashIterator(this);
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public byte[] toArray() {
        return toArray(new byte[this._size]);
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public byte[] toArray(byte[] bArr) {
        if (bArr.length < this._size) {
            bArr = new byte[this._size];
        }
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr3.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
        if (bArr.length > this._size) {
            bArr[this._size] = this.no_entry_value;
        }
        return bArr;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean add(byte b) {
        if (insertKey(b) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean remove(byte b) {
        int index = index(b);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Byte) || !contains(((Byte) obj).byteValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean containsAll(TByteCollection tByteCollection) {
        TByteIterator it = tByteCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean containsAll(byte[] bArr) {
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(bArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean addAll(Collection<? extends Byte> collection) {
        Iterator<? extends Byte> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().byteValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean addAll(TByteCollection tByteCollection) {
        TByteIterator it = tByteCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean addAll(byte[] bArr) {
        int length = bArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (add(bArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean retainAll(Collection<?> collection) {
        TByteIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Byte.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean retainAll(TByteCollection tByteCollection) {
        boolean z = false;
        if (this == tByteCollection) {
            return false;
        }
        TByteIterator it = iterator();
        while (it.hasNext()) {
            if (!tByteCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean retainAll(byte[] bArr) {
        Arrays.sort(bArr);
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        this._autoCompactTemporaryDisable = true;
        int length = bArr2.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
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

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean removeAll(TByteCollection tByteCollection) {
        TByteIterator it = tByteCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean removeAll(byte[] bArr) {
        int length = bArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(bArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        byte[] bArr = this._set;
        byte[] bArr2 = this._states;
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            bArr[i] = this.no_entry_value;
            bArr2[i] = 0;
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        byte[] bArr = this._set;
        byte[] bArr2 = this._states;
        this._set = new byte[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                insertKey(bArr[i2]);
            }
            length = i2;
        }
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
    public boolean equals(Object obj) {
        if (!(obj instanceof TByteSet)) {
            return false;
        }
        TByteSet tByteSet = (TByteSet) obj;
        if (tByteSet.size() != size()) {
            return false;
        }
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (this._states[i] == 1 && !tByteSet.contains(this._set[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
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

    class TByteHashIterator extends THashPrimitiveIterator implements TByteIterator {
        private final TByteHash _hash;

        public TByteHashIterator(TByteHash tByteHash) {
            super(tByteHash);
            this._hash = tByteHash;
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
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
        objectOutput.writeByte(this.no_entry_value);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeByte(this._set[i]);
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
            this.no_entry_value = objectInput.readByte();
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
            add(objectInput.readByte());
            readInt = i;
        }
    }
}

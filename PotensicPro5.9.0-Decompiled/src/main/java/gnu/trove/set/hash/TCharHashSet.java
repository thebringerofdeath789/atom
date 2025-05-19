package gnu.trove.set.hash;

import gnu.trove.TCharCollection;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCharHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.set.TCharSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TCharHashSet extends TCharHash implements TCharSet, Externalizable {
    static final long serialVersionUID = 1;

    public TCharHashSet() {
    }

    public TCharHashSet(int i) {
        super(i);
    }

    public TCharHashSet(int i, float f) {
        super(i, f);
    }

    public TCharHashSet(int i, float f, char c) {
        super(i, f, c);
        if (c != 0) {
            Arrays.fill(this._set, c);
        }
    }

    public TCharHashSet(Collection<? extends Character> collection) {
        this(Math.max(collection.size(), 10));
        addAll(collection);
    }

    public TCharHashSet(TCharCollection tCharCollection) {
        this(Math.max(tCharCollection.size(), 10));
        if (tCharCollection instanceof TCharHashSet) {
            TCharHashSet tCharHashSet = (TCharHashSet) tCharCollection;
            this._loadFactor = tCharHashSet._loadFactor;
            this.no_entry_value = tCharHashSet.no_entry_value;
            if (this.no_entry_value != 0) {
                Arrays.fill(this._set, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        addAll(tCharCollection);
    }

    public TCharHashSet(char[] cArr) {
        this(Math.max(cArr.length, 10));
        addAll(cArr);
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public TCharIterator iterator() {
        return new TCharHashIterator(this);
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public char[] toArray() {
        return toArray(new char[this._size]);
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public char[] toArray(char[] cArr) {
        if (cArr.length < this._size) {
            cArr = new char[this._size];
        }
        char[] cArr2 = this._set;
        byte[] bArr = this._states;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (bArr[i2] == 1) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
        if (cArr.length > this._size) {
            cArr[this._size] = this.no_entry_value;
        }
        return cArr;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean add(char c) {
        if (insertKey(c) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean remove(char c) {
        int index = index(c);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Character) || !contains(((Character) obj).charValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean containsAll(TCharCollection tCharCollection) {
        TCharIterator it = tCharCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean containsAll(char[] cArr) {
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean addAll(Collection<? extends Character> collection) {
        Iterator<? extends Character> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().charValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean addAll(TCharCollection tCharCollection) {
        TCharIterator it = tCharCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean addAll(char[] cArr) {
        int length = cArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (add(cArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean retainAll(Collection<?> collection) {
        TCharIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Character.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean retainAll(TCharCollection tCharCollection) {
        boolean z = false;
        if (this == tCharCollection) {
            return false;
        }
        TCharIterator it = iterator();
        while (it.hasNext()) {
            if (!tCharCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean retainAll(char[] cArr) {
        Arrays.sort(cArr);
        char[] cArr2 = this._set;
        byte[] bArr = this._states;
        this._autoCompactTemporaryDisable = true;
        int length = cArr2.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
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

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Character) && remove(((Character) obj).charValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean removeAll(TCharCollection tCharCollection) {
        TCharIterator it = tCharCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean removeAll(char[] cArr) {
        int length = cArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(cArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        char[] cArr = this._set;
        byte[] bArr = this._states;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            cArr[i] = this.no_entry_value;
            bArr[i] = 0;
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        char[] cArr = this._set;
        byte[] bArr = this._states;
        this._set = new char[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                insertKey(cArr[i2]);
            }
            length = i2;
        }
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
    public boolean equals(Object obj) {
        if (!(obj instanceof TCharSet)) {
            return false;
        }
        TCharSet tCharSet = (TCharSet) obj;
        if (tCharSet.size() != size()) {
            return false;
        }
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (this._states[i] == 1 && !tCharSet.contains(this._set[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

    class TCharHashIterator extends THashPrimitiveIterator implements TCharIterator {
        private final TCharHash _hash;

        public TCharHashIterator(TCharHash tCharHash) {
            super(tCharHash);
            this._hash = tCharHash;
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
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
        objectOutput.writeChar(this.no_entry_value);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeChar(this._set[i]);
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
            this.no_entry_value = objectInput.readChar();
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
            add(objectInput.readChar());
            readInt = i;
        }
    }
}

package gnu.trove.set.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TFloatHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.set.TFloatSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TFloatHashSet extends TFloatHash implements TFloatSet, Externalizable {
    static final long serialVersionUID = 1;

    public TFloatHashSet() {
    }

    public TFloatHashSet(int i) {
        super(i);
    }

    public TFloatHashSet(int i, float f) {
        super(i, f);
    }

    public TFloatHashSet(int i, float f, float f2) {
        super(i, f, f2);
        if (f2 != 0.0f) {
            Arrays.fill(this._set, f2);
        }
    }

    public TFloatHashSet(Collection<? extends Float> collection) {
        this(Math.max(collection.size(), 10));
        addAll(collection);
    }

    public TFloatHashSet(TFloatCollection tFloatCollection) {
        this(Math.max(tFloatCollection.size(), 10));
        if (tFloatCollection instanceof TFloatHashSet) {
            TFloatHashSet tFloatHashSet = (TFloatHashSet) tFloatCollection;
            this._loadFactor = tFloatHashSet._loadFactor;
            this.no_entry_value = tFloatHashSet.no_entry_value;
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._set, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        addAll(tFloatCollection);
    }

    public TFloatHashSet(float[] fArr) {
        this(Math.max(fArr.length, 10));
        addAll(fArr);
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public TFloatIterator iterator() {
        return new TFloatHashIterator(this);
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public float[] toArray() {
        return toArray(new float[this._size]);
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public float[] toArray(float[] fArr) {
        if (fArr.length < this._size) {
            fArr = new float[this._size];
        }
        float[] fArr2 = this._set;
        byte[] bArr = this._states;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (bArr[i2] == 1) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
        if (fArr.length > this._size) {
            fArr[this._size] = this.no_entry_value;
        }
        return fArr;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean add(float f) {
        if (insertKey(f) < 0) {
            return false;
        }
        postInsertHook(this.consumeFreeSlot);
        return true;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean remove(float f) {
        int index = index(f);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!(obj instanceof Float) || !contains(((Float) obj).floatValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean containsAll(TFloatCollection tFloatCollection) {
        TFloatIterator it = tFloatCollection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean containsAll(float[] fArr) {
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!contains(fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean addAll(Collection<? extends Float> collection) {
        Iterator<? extends Float> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next().floatValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean addAll(TFloatCollection tFloatCollection) {
        TFloatIterator it = tFloatCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean addAll(float[] fArr) {
        int length = fArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (add(fArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean retainAll(Collection<?> collection) {
        TFloatIterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(Float.valueOf(it.next()))) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean retainAll(TFloatCollection tFloatCollection) {
        boolean z = false;
        if (this == tFloatCollection) {
            return false;
        }
        TFloatIterator it = iterator();
        while (it.hasNext()) {
            if (!tFloatCollection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean retainAll(float[] fArr) {
        Arrays.sort(fArr);
        float[] fArr2 = this._set;
        byte[] bArr = this._states;
        this._autoCompactTemporaryDisable = true;
        int length = fArr2.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
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

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if ((obj instanceof Float) && remove(((Float) obj).floatValue())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean removeAll(TFloatCollection tFloatCollection) {
        TFloatIterator it = tFloatCollection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean removeAll(float[] fArr) {
        int length = fArr.length;
        boolean z = false;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return z;
            }
            if (remove(fArr[i])) {
                z = true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        float[] fArr = this._set;
        byte[] bArr = this._states;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            fArr[i] = this.no_entry_value;
            bArr[i] = 0;
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        float[] fArr = this._set;
        byte[] bArr = this._states;
        this._set = new float[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                insertKey(fArr[i2]);
            }
            length = i2;
        }
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
    public boolean equals(Object obj) {
        if (!(obj instanceof TFloatSet)) {
            return false;
        }
        TFloatSet tFloatSet = (TFloatSet) obj;
        if (tFloatSet.size() != size()) {
            return false;
        }
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (this._states[i] == 1 && !tFloatSet.contains(this._set[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
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

    class TFloatHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        private final TFloatHash _hash;

        public TFloatHashIterator(TFloatHash tFloatHash) {
            super(tFloatHash);
            this._hash = tFloatHash;
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
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
        objectOutput.writeFloat(this.no_entry_value);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeFloat(this._set[i]);
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
            this.no_entry_value = objectInput.readFloat();
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._set, this.no_entry_value);
            }
        }
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            add(objectInput.readFloat());
            readInt = i;
        }
    }
}
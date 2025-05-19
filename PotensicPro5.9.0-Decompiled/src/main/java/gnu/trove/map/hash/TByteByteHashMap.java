package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TByteByteHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TByteByteIterator;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.map.TByteByteMap;
import gnu.trove.procedure.TByteByteProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.set.TByteSet;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TByteByteHashMap extends TByteByteHash implements TByteByteMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient byte[] _values;

    public TByteByteHashMap() {
    }

    public TByteByteHashMap(int i) {
        super(i);
    }

    public TByteByteHashMap(int i, float f) {
        super(i, f);
    }

    public TByteByteHashMap(int i, float f, byte b, byte b2) {
        super(i, f, b, b2);
    }

    public TByteByteHashMap(byte[] bArr, byte[] bArr2) {
        super(Math.max(bArr.length, bArr2.length));
        int min = Math.min(bArr.length, bArr2.length);
        for (int i = 0; i < min; i++) {
            put(bArr[i], bArr2[i]);
        }
    }

    public TByteByteHashMap(TByteByteMap tByteByteMap) {
        super(tByteByteMap.size());
        if (tByteByteMap instanceof TByteByteHashMap) {
            TByteByteHashMap tByteByteHashMap = (TByteByteHashMap) tByteByteMap;
            this._loadFactor = Math.abs(tByteByteHashMap._loadFactor);
            this.no_entry_key = tByteByteHashMap.no_entry_key;
            this.no_entry_value = tByteByteHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tByteByteMap);
    }

    @Override // gnu.trove.impl.hash.TByteByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new byte[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        byte[] bArr = this._set;
        byte[] bArr2 = this._values;
        byte[] bArr3 = this._states;
        this._set = new byte[i];
        this._values = new byte[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr3[i2] == 1) {
                this._values[insertKey(bArr[i2])] = bArr2[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte put(byte b, byte b2) {
        return doPut(b, b2, insertKey(b));
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte putIfAbsent(byte b, byte b2) {
        int insertKey = insertKey(b);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(b, b2, insertKey);
    }

    private byte doPut(byte b, byte b2, int i) {
        byte b3 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            b3 = this._values[i];
            z = false;
        }
        this._values[i] = b2;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return b3;
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(Map<? extends Byte, ? extends Byte> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Byte, ? extends Byte> entry : map.entrySet()) {
            put(entry.getKey().byteValue(), entry.getValue().byteValue());
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public void putAll(TByteByteMap tByteByteMap) {
        ensureCapacity(tByteByteMap.size());
        TByteByteIterator it = tByteByteMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte get(byte b) {
        int index = index(b);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        byte[] bArr = this._values;
        Arrays.fill(bArr, 0, bArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte remove(byte b) {
        byte b2 = this.no_entry_value;
        int index = index(b);
        if (index < 0) {
            return b2;
        }
        byte b3 = this._values[index];
        removeAt(index);
        return b3;
    }

    @Override // gnu.trove.impl.hash.TByteByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys() {
        int size = size();
        byte[] bArr = new byte[size];
        if (size == 0) {
            return bArr;
        }
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] keys(byte[] bArr) {
        int size = size();
        if (size == 0) {
            return bArr;
        }
        if (bArr.length < size) {
            bArr = new byte[size];
        }
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values() {
        int size = size();
        byte[] bArr = new byte[size];
        if (size == 0) {
            return bArr;
        }
        byte[] bArr2 = this._values;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte[] values(byte[] bArr) {
        int size = size();
        if (size == 0) {
            return bArr;
        }
        if (bArr.length < size) {
            bArr = new byte[size];
        }
        byte[] bArr2 = this._values;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsValue(byte b) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && b == bArr2[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean containsKey(byte b) {
        return contains(b);
    }

    @Override // gnu.trove.map.TByteByteMap
    public TByteByteIterator iterator() {
        return new TByteByteHashIterator(this);
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return forEach(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteProcedure.execute(bArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean forEachEntry(TByteByteProcedure tByteByteProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteByteProcedure.execute(bArr2[i], bArr3[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public void transformValues(TByteFunction tByteFunction) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                bArr2[i] = tByteFunction.execute(bArr2[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean retainEntries(TByteByteProcedure tByteByteProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._values;
        tempDisableAutoCompaction();
        try {
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tByteByteProcedure.execute(bArr2[i], bArr3[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean increment(byte b) {
        return adjustValue(b, (byte) 1);
    }

    @Override // gnu.trove.map.TByteByteMap
    public boolean adjustValue(byte b, byte b2) {
        int index = index(b);
        if (index < 0) {
            return false;
        }
        byte[] bArr = this._values;
        bArr[index] = (byte) (bArr[index] + b2);
        return true;
    }

    @Override // gnu.trove.map.TByteByteMap
    public byte adjustOrPutValue(byte b, byte b2, byte b3) {
        int insertKey = insertKey(b);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            byte[] bArr = this._values;
            byte b4 = (byte) (bArr[insertKey] + b2);
            bArr[insertKey] = b4;
            z = false;
            b3 = b4;
        } else {
            this._values[insertKey] = b3;
        }
        byte b5 = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return b3;
    }

    protected class TKeyView implements TByteSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TByteByteHashMap tByteByteHashMap = TByteByteHashMap.this;
            return tByteByteHashMap.new TByteByteKeyHashIterator(tByteByteHashMap);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TByteByteHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int size() {
            return TByteByteHashMap.this._size;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TByteByteHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TByteByteHashMap.this.contains(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray() {
            return TByteByteHashMap.this.keys();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TByteByteHashMap.this.keys(bArr);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean remove(byte b) {
            return TByteByteHashMap.this.no_entry_value != TByteByteHashMap.this.remove(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TByteByteHashMap.this.containsKey(((Byte) obj).byteValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(TByteCollection tByteCollection) {
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (!TByteByteHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TByteByteHashMap.this.contains(b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(Collection<? extends Byte> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(TByteCollection tByteCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(byte[] bArr) {
            throw new UnsupportedOperationException();
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
            byte[] bArr2 = TByteByteHashMap.this._set;
            byte[] bArr3 = TByteByteHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TByteByteHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
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
            if (this == tByteCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TByteIterator it = tByteCollection.iterator();
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

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public void clear() {
            TByteByteHashMap.this.clear();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TByteByteHashMap.this.forEachKey(tByteProcedure);
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
            int length = TByteByteHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TByteByteHashMap.this._states[i] == 1 && !tByteSet.contains(TByteByteHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int hashCode() {
            int length = TByteByteHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TByteByteHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TByteByteHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteByteHashMap.this.forEachKey(new TByteProcedure() { // from class: gnu.trove.map.hash.TByteByteHashMap.TKeyView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TByteProcedure
                public boolean execute(byte b) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append((int) b);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }
    }

    protected class TValueView implements TByteCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TByteByteHashMap tByteByteHashMap = TByteByteHashMap.this;
            return tByteByteHashMap.new TByteByteValueHashIterator(tByteByteHashMap);
        }

        @Override // gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TByteByteHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TByteCollection
        public int size() {
            return TByteByteHashMap.this._size;
        }

        @Override // gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TByteByteHashMap.this._size == 0;
        }

        @Override // gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TByteByteHashMap.this.containsValue(b);
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray() {
            return TByteByteHashMap.this.values();
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TByteByteHashMap.this.values(bArr);
        }

        @Override // gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean remove(byte b) {
            byte[] bArr = TByteByteHashMap.this._values;
            byte[] bArr2 = TByteByteHashMap.this._states;
            int length = bArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr2[i] != 0 && bArr2[i] != 2 && b == bArr[i]) {
                    TByteByteHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TByteByteHashMap.this.containsValue(((Byte) obj).byteValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(TByteCollection tByteCollection) {
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (!TByteByteHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TByteByteHashMap.this.containsValue(b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(Collection<? extends Byte> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(TByteCollection tByteCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
        public boolean retainAll(byte[] bArr) {
            Arrays.sort(bArr);
            byte[] bArr2 = TByteByteHashMap.this._values;
            byte[] bArr3 = TByteByteHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TByteByteHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
        public boolean removeAll(TByteCollection tByteCollection) {
            if (this == tByteCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
        public void clear() {
            TByteByteHashMap.this.clear();
        }

        @Override // gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TByteByteHashMap.this.forEachValue(tByteProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteByteHashMap.this.forEachValue(new TByteProcedure() { // from class: gnu.trove.map.hash.TByteByteHashMap.TValueView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TByteProcedure
                public boolean execute(byte b) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append((int) b);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }
    }

    class TByteByteKeyHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TByteByteKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TByteByteHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteByteValueHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TByteByteValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TByteByteHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteByteHashIterator extends THashPrimitiveIterator implements TByteByteIterator {
        TByteByteHashIterator(TByteByteHashMap tByteByteHashMap) {
            super(tByteByteHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TByteByteIterator
        public byte key() {
            return TByteByteHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TByteByteIterator
        public byte value() {
            return TByteByteHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TByteByteIterator
        public byte setValue(byte b) {
            byte value = value();
            TByteByteHashMap.this._values[this._index] = b;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TByteByteMap)) {
            return false;
        }
        TByteByteMap tByteByteMap = (TByteByteMap) obj;
        if (tByteByteMap.size() != size()) {
            return false;
        }
        byte[] bArr = this._values;
        byte[] bArr2 = this._states;
        byte noEntryValue = getNoEntryValue();
        byte noEntryValue2 = tByteByteMap.getNoEntryValue();
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr2[i] == 1) {
                byte b = this._set[i];
                if (!tByteByteMap.containsKey(b)) {
                    return false;
                }
                byte b2 = tByteByteMap.get(b);
                byte b3 = bArr[i];
                if (b3 != b2 && (b3 != noEntryValue || b2 != noEntryValue2)) {
                    break;
                }
            }
            length = i;
        }
        return false;
    }

    public int hashCode() {
        byte[] bArr = this._states;
        int length = this._values.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (bArr[i2] == 1) {
                i += HashFunctions.hash((int) this._set[i2]) ^ HashFunctions.hash((int) this._values[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TByteByteProcedure() { // from class: gnu.trove.map.hash.TByteByteHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TByteByteProcedure
            public boolean execute(byte b, byte b2) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) b);
                sb.append("=");
                sb.append((int) b2);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TByteByteHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeInt(this._size);
        int length = this._states.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._states[i] == 1) {
                objectOutput.writeByte(this._set[i]);
                objectOutput.writeByte(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TByteByteHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readByte(), objectInput.readByte());
            readInt = i;
        }
    }
}

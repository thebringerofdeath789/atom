package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TByteIntHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TByteIntIterator;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.map.TByteIntMap;
import gnu.trove.procedure.TByteIntProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TIntProcedure;
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
public class TByteIntHashMap extends TByteIntHash implements TByteIntMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient int[] _values;

    public TByteIntHashMap() {
    }

    public TByteIntHashMap(int i) {
        super(i);
    }

    public TByteIntHashMap(int i, float f) {
        super(i, f);
    }

    public TByteIntHashMap(int i, float f, byte b, int i2) {
        super(i, f, b, i2);
    }

    public TByteIntHashMap(byte[] bArr, int[] iArr) {
        super(Math.max(bArr.length, iArr.length));
        int min = Math.min(bArr.length, iArr.length);
        for (int i = 0; i < min; i++) {
            put(bArr[i], iArr[i]);
        }
    }

    public TByteIntHashMap(TByteIntMap tByteIntMap) {
        super(tByteIntMap.size());
        if (tByteIntMap instanceof TByteIntHashMap) {
            TByteIntHashMap tByteIntHashMap = (TByteIntHashMap) tByteIntMap;
            this._loadFactor = Math.abs(tByteIntHashMap._loadFactor);
            this.no_entry_key = tByteIntHashMap.no_entry_key;
            this.no_entry_value = tByteIntHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tByteIntMap);
    }

    @Override // gnu.trove.impl.hash.TByteIntHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new int[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        byte[] bArr = this._set;
        int[] iArr = this._values;
        byte[] bArr2 = this._states;
        this._set = new byte[i];
        this._values = new int[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                this._values[insertKey(bArr[i2])] = iArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public int put(byte b, int i) {
        return doPut(b, i, insertKey(b));
    }

    @Override // gnu.trove.map.TByteIntMap
    public int putIfAbsent(byte b, int i) {
        int insertKey = insertKey(b);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(b, i, insertKey);
    }

    private int doPut(byte b, int i, int i2) {
        int i3 = this.no_entry_value;
        boolean z = true;
        if (i2 < 0) {
            i2 = (-i2) - 1;
            i3 = this._values[i2];
            z = false;
        }
        this._values[i2] = i;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return i3;
    }

    @Override // gnu.trove.map.TByteIntMap
    public void putAll(Map<? extends Byte, ? extends Integer> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Byte, ? extends Integer> entry : map.entrySet()) {
            put(entry.getKey().byteValue(), entry.getValue().intValue());
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public void putAll(TByteIntMap tByteIntMap) {
        ensureCapacity(tByteIntMap.size());
        TByteIntIterator it = tByteIntMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public int get(byte b) {
        int index = index(b);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        int[] iArr = this._values;
        Arrays.fill(iArr, 0, iArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int remove(byte b) {
        int i = this.no_entry_value;
        int index = index(b);
        if (index < 0) {
            return i;
        }
        int i2 = this._values[index];
        removeAt(index);
        return i2;
    }

    @Override // gnu.trove.impl.hash.TByteIntHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TByteIntMap
    public TByteSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TByteIntMap
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

    @Override // gnu.trove.map.TByteIntMap
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

    @Override // gnu.trove.map.TByteIntMap
    public TIntCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TByteIntMap
    public int[] values() {
        int size = size();
        int[] iArr = new int[size];
        if (size == 0) {
            return iArr;
        }
        int[] iArr2 = this._values;
        byte[] bArr = this._states;
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return iArr;
            }
            if (bArr[i2] == 1) {
                iArr[i] = iArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public int[] values(int[] iArr) {
        int size = size();
        if (size == 0) {
            return iArr;
        }
        if (iArr.length < size) {
            iArr = new int[size];
        }
        int[] iArr2 = this._values;
        byte[] bArr = this._states;
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return iArr;
            }
            if (bArr[i2] == 1) {
                iArr[i] = iArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean containsValue(int i) {
        byte[] bArr = this._states;
        int[] iArr = this._values;
        int length = iArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i2] == 1 && i == iArr[i2]) {
                return true;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean containsKey(byte b) {
        return contains(b);
    }

    @Override // gnu.trove.map.TByteIntMap
    public TByteIntIterator iterator() {
        return new TByteIntHashIterator(this);
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return forEach(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachValue(TIntProcedure tIntProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tIntProcedure.execute(iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean forEachEntry(TByteIntProcedure tByteIntProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        int[] iArr = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteIntProcedure.execute(bArr2[i], iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public void transformValues(TIntFunction tIntFunction) {
        byte[] bArr = this._states;
        int[] iArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                iArr[i] = tIntFunction.execute(iArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean retainEntries(TByteIntProcedure tByteIntProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        int[] iArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tByteIntProcedure.execute(bArr2[i], iArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean increment(byte b) {
        return adjustValue(b, 1);
    }

    @Override // gnu.trove.map.TByteIntMap
    public boolean adjustValue(byte b, int i) {
        int index = index(b);
        if (index < 0) {
            return false;
        }
        int[] iArr = this._values;
        iArr[index] = iArr[index] + i;
        return true;
    }

    @Override // gnu.trove.map.TByteIntMap
    public int adjustOrPutValue(byte b, int i, int i2) {
        int insertKey = insertKey(b);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            int[] iArr = this._values;
            int i3 = i + iArr[insertKey];
            iArr[insertKey] = i3;
            z = false;
            i2 = i3;
        } else {
            this._values[insertKey] = i2;
        }
        byte b2 = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return i2;
    }

    protected class TKeyView implements TByteSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TByteIntHashMap tByteIntHashMap = TByteIntHashMap.this;
            return tByteIntHashMap.new TByteIntKeyHashIterator(tByteIntHashMap);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TByteIntHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int size() {
            return TByteIntHashMap.this._size;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TByteIntHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TByteIntHashMap.this.contains(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray() {
            return TByteIntHashMap.this.keys();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TByteIntHashMap.this.keys(bArr);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean remove(byte b) {
            return TByteIntHashMap.this.no_entry_value != TByteIntHashMap.this.remove(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TByteIntHashMap.this.containsKey(((Byte) obj).byteValue())) {
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
                if (!TByteIntHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TByteIntHashMap.this.contains(b)) {
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
            byte[] bArr2 = TByteIntHashMap.this._set;
            byte[] bArr3 = TByteIntHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TByteIntHashMap.this.removeAt(i);
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
            TByteIntHashMap.this.clear();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TByteIntHashMap.this.forEachKey(tByteProcedure);
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
            int length = TByteIntHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TByteIntHashMap.this._states[i] == 1 && !tByteSet.contains(TByteIntHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int hashCode() {
            int length = TByteIntHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TByteIntHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TByteIntHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteIntHashMap.this.forEachKey(new TByteProcedure() { // from class: gnu.trove.map.hash.TByteIntHashMap.TKeyView.1
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

    protected class TValueView implements TIntCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TIntCollection
        public TIntIterator iterator() {
            TByteIntHashMap tByteIntHashMap = TByteIntHashMap.this;
            return tByteIntHashMap.new TByteIntValueHashIterator(tByteIntHashMap);
        }

        @Override // gnu.trove.TIntCollection
        public int getNoEntryValue() {
            return TByteIntHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TIntCollection
        public int size() {
            return TByteIntHashMap.this._size;
        }

        @Override // gnu.trove.TIntCollection
        public boolean isEmpty() {
            return TByteIntHashMap.this._size == 0;
        }

        @Override // gnu.trove.TIntCollection
        public boolean contains(int i) {
            return TByteIntHashMap.this.containsValue(i);
        }

        @Override // gnu.trove.TIntCollection
        public int[] toArray() {
            return TByteIntHashMap.this.values();
        }

        @Override // gnu.trove.TIntCollection
        public int[] toArray(int[] iArr) {
            return TByteIntHashMap.this.values(iArr);
        }

        @Override // gnu.trove.TIntCollection
        public boolean add(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean remove(int i) {
            int[] iArr = TByteIntHashMap.this._values;
            byte[] bArr = TByteIntHashMap.this._states;
            int length = iArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i2] != 0 && bArr[i2] != 2 && i == iArr[i2]) {
                    TByteIntHashMap.this.removeAt(i2);
                    return true;
                }
                length = i2;
            }
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Integer) {
                    if (!TByteIntHashMap.this.containsValue(((Integer) obj).intValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(TIntCollection tIntCollection) {
            TIntIterator it = tIntCollection.iterator();
            while (it.hasNext()) {
                if (!TByteIntHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(int[] iArr) {
            for (int i : iArr) {
                if (!TByteIntHashMap.this.containsValue(i)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean addAll(TIntCollection tIntCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean addAll(int[] iArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
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

        @Override // gnu.trove.TIntCollection
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

        @Override // gnu.trove.TIntCollection
        public boolean retainAll(int[] iArr) {
            Arrays.sort(iArr);
            int[] iArr2 = TByteIntHashMap.this._values;
            byte[] bArr = TByteIntHashMap.this._states;
            int length = iArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
                    TByteIntHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TIntCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Integer) && remove(((Integer) obj).intValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TIntCollection
        public boolean removeAll(TIntCollection tIntCollection) {
            if (this == tIntCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TIntIterator it = tIntCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TIntCollection
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

        @Override // gnu.trove.TIntCollection
        public void clear() {
            TByteIntHashMap.this.clear();
        }

        @Override // gnu.trove.TIntCollection
        public boolean forEach(TIntProcedure tIntProcedure) {
            return TByteIntHashMap.this.forEachValue(tIntProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteIntHashMap.this.forEachValue(new TIntProcedure() { // from class: gnu.trove.map.hash.TByteIntHashMap.TValueView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TIntProcedure
                public boolean execute(int i) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }
    }

    class TByteIntKeyHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TByteIntKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TByteIntHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteIntHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteIntValueHashIterator extends THashPrimitiveIterator implements TIntIterator {
        TByteIntValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
            moveToNextIndex();
            return TByteIntHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteIntHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteIntHashIterator extends THashPrimitiveIterator implements TByteIntIterator {
        TByteIntHashIterator(TByteIntHashMap tByteIntHashMap) {
            super(tByteIntHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TByteIntIterator
        public byte key() {
            return TByteIntHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TByteIntIterator
        public int value() {
            return TByteIntHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TByteIntIterator
        public int setValue(int i) {
            int value = value();
            TByteIntHashMap.this._values[this._index] = i;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteIntHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TByteIntMap)) {
            return false;
        }
        TByteIntMap tByteIntMap = (TByteIntMap) obj;
        if (tByteIntMap.size() != size()) {
            return false;
        }
        int[] iArr = this._values;
        byte[] bArr = this._states;
        int noEntryValue = getNoEntryValue();
        int noEntryValue2 = tByteIntMap.getNoEntryValue();
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                byte b = this._set[i];
                if (!tByteIntMap.containsKey(b)) {
                    return false;
                }
                int i2 = tByteIntMap.get(b);
                int i3 = iArr[i];
                if (i3 != i2 && (i3 != noEntryValue || i2 != noEntryValue2)) {
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
                i += HashFunctions.hash((int) this._set[i2]) ^ HashFunctions.hash(this._values[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TByteIntProcedure() { // from class: gnu.trove.map.hash.TByteIntHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TByteIntProcedure
            public boolean execute(byte b, int i) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) b);
                sb.append("=");
                sb.append(i);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TByteIntHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeInt(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TByteIntHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readByte(), objectInput.readInt());
            readInt = i;
        }
    }
}

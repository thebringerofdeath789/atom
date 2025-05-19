package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TByteLongHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TByteLongIterator;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.map.TByteLongMap;
import gnu.trove.procedure.TByteLongProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TLongProcedure;
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
public class TByteLongHashMap extends TByteLongHash implements TByteLongMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient long[] _values;

    public TByteLongHashMap() {
    }

    public TByteLongHashMap(int i) {
        super(i);
    }

    public TByteLongHashMap(int i, float f) {
        super(i, f);
    }

    public TByteLongHashMap(int i, float f, byte b, long j) {
        super(i, f, b, j);
    }

    public TByteLongHashMap(byte[] bArr, long[] jArr) {
        super(Math.max(bArr.length, jArr.length));
        int min = Math.min(bArr.length, jArr.length);
        for (int i = 0; i < min; i++) {
            put(bArr[i], jArr[i]);
        }
    }

    public TByteLongHashMap(TByteLongMap tByteLongMap) {
        super(tByteLongMap.size());
        if (tByteLongMap instanceof TByteLongHashMap) {
            TByteLongHashMap tByteLongHashMap = (TByteLongHashMap) tByteLongMap;
            this._loadFactor = Math.abs(tByteLongHashMap._loadFactor);
            this.no_entry_key = tByteLongHashMap.no_entry_key;
            this.no_entry_value = tByteLongHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tByteLongMap);
    }

    @Override // gnu.trove.impl.hash.TByteLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new long[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        byte[] bArr = this._set;
        long[] jArr = this._values;
        byte[] bArr2 = this._states;
        this._set = new byte[i];
        this._values = new long[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                this._values[insertKey(bArr[i2])] = jArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public long put(byte b, long j) {
        return doPut(b, j, insertKey(b));
    }

    @Override // gnu.trove.map.TByteLongMap
    public long putIfAbsent(byte b, long j) {
        int insertKey = insertKey(b);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(b, j, insertKey);
    }

    private long doPut(byte b, long j, int i) {
        long j2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            j2 = this._values[i];
            z = false;
        }
        this._values[i] = j;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return j2;
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(Map<? extends Byte, ? extends Long> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Byte, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey().byteValue(), entry.getValue().longValue());
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public void putAll(TByteLongMap tByteLongMap) {
        ensureCapacity(tByteLongMap.size());
        TByteLongIterator it = tByteLongMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public long get(byte b) {
        int index = index(b);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        long[] jArr = this._values;
        Arrays.fill(jArr, 0, jArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long remove(byte b) {
        long j = this.no_entry_value;
        int index = index(b);
        if (index < 0) {
            return j;
        }
        long j2 = this._values[index];
        removeAt(index);
        return j2;
    }

    @Override // gnu.trove.impl.hash.TByteLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TByteLongMap
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

    @Override // gnu.trove.map.TByteLongMap
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

    @Override // gnu.trove.map.TByteLongMap
    public TLongCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values() {
        int size = size();
        long[] jArr = new long[size];
        if (size == 0) {
            return jArr;
        }
        long[] jArr2 = this._values;
        byte[] bArr = this._states;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (bArr[i2] == 1) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public long[] values(long[] jArr) {
        int size = size();
        if (size == 0) {
            return jArr;
        }
        if (jArr.length < size) {
            jArr = new long[size];
        }
        long[] jArr2 = this._values;
        byte[] bArr = this._states;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (bArr[i2] == 1) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsValue(long j) {
        byte[] bArr = this._states;
        long[] jArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && j == jArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean containsKey(byte b) {
        return contains(b);
    }

    @Override // gnu.trove.map.TByteLongMap
    public TByteLongIterator iterator() {
        return new TByteLongHashIterator(this);
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return forEach(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachValue(TLongProcedure tLongProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongProcedure.execute(jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean forEachEntry(TByteLongProcedure tByteLongProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        long[] jArr = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteLongProcedure.execute(bArr2[i], jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public void transformValues(TLongFunction tLongFunction) {
        byte[] bArr = this._states;
        long[] jArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                jArr[i] = tLongFunction.execute(jArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean retainEntries(TByteLongProcedure tByteLongProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        long[] jArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tByteLongProcedure.execute(bArr2[i], jArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean increment(byte b) {
        return adjustValue(b, 1L);
    }

    @Override // gnu.trove.map.TByteLongMap
    public boolean adjustValue(byte b, long j) {
        int index = index(b);
        if (index < 0) {
            return false;
        }
        long[] jArr = this._values;
        jArr[index] = jArr[index] + j;
        return true;
    }

    @Override // gnu.trove.map.TByteLongMap
    public long adjustOrPutValue(byte b, long j, long j2) {
        int insertKey = insertKey(b);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            long[] jArr = this._values;
            long j3 = j + jArr[insertKey];
            jArr[insertKey] = j3;
            z = false;
            j2 = j3;
        } else {
            this._values[insertKey] = j2;
        }
        byte b2 = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return j2;
    }

    protected class TKeyView implements TByteSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TByteLongHashMap tByteLongHashMap = TByteLongHashMap.this;
            return tByteLongHashMap.new TByteLongKeyHashIterator(tByteLongHashMap);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TByteLongHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int size() {
            return TByteLongHashMap.this._size;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TByteLongHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TByteLongHashMap.this.contains(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray() {
            return TByteLongHashMap.this.keys();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TByteLongHashMap.this.keys(bArr);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean remove(byte b) {
            return TByteLongHashMap.this.no_entry_value != TByteLongHashMap.this.remove(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TByteLongHashMap.this.containsKey(((Byte) obj).byteValue())) {
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
                if (!TByteLongHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TByteLongHashMap.this.contains(b)) {
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
            byte[] bArr2 = TByteLongHashMap.this._set;
            byte[] bArr3 = TByteLongHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TByteLongHashMap.this.removeAt(i);
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
            TByteLongHashMap.this.clear();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TByteLongHashMap.this.forEachKey(tByteProcedure);
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
            int length = TByteLongHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TByteLongHashMap.this._states[i] == 1 && !tByteSet.contains(TByteLongHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int hashCode() {
            int length = TByteLongHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TByteLongHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TByteLongHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteLongHashMap.this.forEachKey(new TByteProcedure() { // from class: gnu.trove.map.hash.TByteLongHashMap.TKeyView.1
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

    protected class TValueView implements TLongCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TLongCollection
        public TLongIterator iterator() {
            TByteLongHashMap tByteLongHashMap = TByteLongHashMap.this;
            return tByteLongHashMap.new TByteLongValueHashIterator(tByteLongHashMap);
        }

        @Override // gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TByteLongHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TLongCollection
        public int size() {
            return TByteLongHashMap.this._size;
        }

        @Override // gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TByteLongHashMap.this._size == 0;
        }

        @Override // gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TByteLongHashMap.this.containsValue(j);
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray() {
            return TByteLongHashMap.this.values();
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TByteLongHashMap.this.values(jArr);
        }

        @Override // gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean remove(long j) {
            long[] jArr = TByteLongHashMap.this._values;
            byte[] bArr = TByteLongHashMap.this._states;
            int length = jArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && j == jArr[i]) {
                    TByteLongHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TByteLongHashMap.this.containsValue(((Long) obj).longValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(TLongCollection tLongCollection) {
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (!TByteLongHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TByteLongHashMap.this.containsValue(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean addAll(TLongCollection tLongCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean addAll(long[] jArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean retainAll(Collection<?> collection) {
            TLongIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Long.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TLongCollection
        public boolean retainAll(TLongCollection tLongCollection) {
            boolean z = false;
            if (this == tLongCollection) {
                return false;
            }
            TLongIterator it = iterator();
            while (it.hasNext()) {
                if (!tLongCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TLongCollection
        public boolean retainAll(long[] jArr) {
            Arrays.sort(jArr);
            long[] jArr2 = TByteLongHashMap.this._values;
            byte[] bArr = TByteLongHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TByteLongHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Long) && remove(((Long) obj).longValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TLongCollection
        public boolean removeAll(TLongCollection tLongCollection) {
            if (this == tLongCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TLongCollection
        public boolean removeAll(long[] jArr) {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(jArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public void clear() {
            TByteLongHashMap.this.clear();
        }

        @Override // gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TByteLongHashMap.this.forEachValue(tLongProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteLongHashMap.this.forEachValue(new TLongProcedure() { // from class: gnu.trove.map.hash.TByteLongHashMap.TValueView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TLongProcedure
                public boolean execute(long j) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(j);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }
    }

    class TByteLongKeyHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TByteLongKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TByteLongHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteLongValueHashIterator extends THashPrimitiveIterator implements TLongIterator {
        TByteLongValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            moveToNextIndex();
            return TByteLongHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteLongHashIterator extends THashPrimitiveIterator implements TByteLongIterator {
        TByteLongHashIterator(TByteLongHashMap tByteLongHashMap) {
            super(tByteLongHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TByteLongIterator
        public byte key() {
            return TByteLongHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TByteLongIterator
        public long value() {
            return TByteLongHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TByteLongIterator
        public long setValue(long j) {
            long value = value();
            TByteLongHashMap.this._values[this._index] = j;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof gnu.trove.map.TByteLongMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TByteLongMap r14 = (gnu.trove.map.TByteLongMap) r14
            int r0 = r14.size()
            int r2 = r13.size()
            if (r0 == r2) goto L13
            return r1
        L13:
            long[] r0 = r13._values
            byte[] r2 = r13._states
            long r3 = r13.getNoEntryValue()
            long r5 = r14.getNoEntryValue()
            int r7 = r0.length
        L20:
            int r8 = r7 + (-1)
            r9 = 1
            if (r7 <= 0) goto L49
            r7 = r2[r8]
            if (r7 != r9) goto L47
            byte[] r7 = r13._set
            r7 = r7[r8]
            boolean r9 = r14.containsKey(r7)
            if (r9 != 0) goto L34
            return r1
        L34:
            long r9 = r14.get(r7)
            r11 = r0[r8]
            int r7 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r7 == 0) goto L47
            int r7 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r7 != 0) goto L46
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 == 0) goto L47
        L46:
            return r1
        L47:
            r7 = r8
            goto L20
        L49:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TByteLongHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TByteLongProcedure() { // from class: gnu.trove.map.hash.TByteLongHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TByteLongProcedure
            public boolean execute(byte b, long j) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) b);
                sb.append("=");
                sb.append(j);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TByteLongHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeLong(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TByteLongHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readByte(), objectInput.readLong());
            readInt = i;
        }
    }
}

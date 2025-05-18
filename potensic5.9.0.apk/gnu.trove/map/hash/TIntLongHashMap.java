package gnu.trove.map.hash;

import gnu.trove.TIntCollection;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TIntLongHash;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.iterator.TIntLongIterator;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.map.TIntLongMap;
import gnu.trove.procedure.TIntLongProcedure;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TIntSet;
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
public class TIntLongHashMap extends TIntLongHash implements TIntLongMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient long[] _values;

    public TIntLongHashMap() {
    }

    public TIntLongHashMap(int i) {
        super(i);
    }

    public TIntLongHashMap(int i, float f) {
        super(i, f);
    }

    public TIntLongHashMap(int i, float f, int i2, long j) {
        super(i, f, i2, j);
    }

    public TIntLongHashMap(int[] iArr, long[] jArr) {
        super(Math.max(iArr.length, jArr.length));
        int min = Math.min(iArr.length, jArr.length);
        for (int i = 0; i < min; i++) {
            put(iArr[i], jArr[i]);
        }
    }

    public TIntLongHashMap(TIntLongMap tIntLongMap) {
        super(tIntLongMap.size());
        if (tIntLongMap instanceof TIntLongHashMap) {
            TIntLongHashMap tIntLongHashMap = (TIntLongHashMap) tIntLongMap;
            this._loadFactor = Math.abs(tIntLongHashMap._loadFactor);
            this.no_entry_key = tIntLongHashMap.no_entry_key;
            this.no_entry_value = tIntLongHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tIntLongMap);
    }

    @Override // gnu.trove.impl.hash.TIntLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new long[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        int[] iArr = this._set;
        long[] jArr = this._values;
        byte[] bArr = this._states;
        this._set = new int[i];
        this._values = new long[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(iArr[i2])] = jArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public long put(int i, long j) {
        return doPut(i, j, insertKey(i));
    }

    @Override // gnu.trove.map.TIntLongMap
    public long putIfAbsent(int i, long j) {
        int insertKey = insertKey(i);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(i, j, insertKey);
    }

    private long doPut(int i, long j, int i2) {
        long j2 = this.no_entry_value;
        boolean z = true;
        if (i2 < 0) {
            i2 = (-i2) - 1;
            j2 = this._values[i2];
            z = false;
        }
        this._values[i2] = j;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return j2;
    }

    @Override // gnu.trove.map.TIntLongMap
    public void putAll(Map<? extends Integer, ? extends Long> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Integer, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey().intValue(), entry.getValue().longValue());
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public void putAll(TIntLongMap tIntLongMap) {
        ensureCapacity(tIntLongMap.size());
        TIntLongIterator it = tIntLongMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public long get(int i) {
        int index = index(i);
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

    @Override // gnu.trove.map.TIntLongMap
    public long remove(int i) {
        long j = this.no_entry_value;
        int index = index(i);
        if (index < 0) {
            return j;
        }
        long j2 = this._values[index];
        removeAt(index);
        return j2;
    }

    @Override // gnu.trove.impl.hash.TIntLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TIntLongMap
    public TIntSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TIntLongMap
    public int[] keys() {
        int size = size();
        int[] iArr = new int[size];
        if (size == 0) {
            return iArr;
        }
        int[] iArr2 = this._set;
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

    @Override // gnu.trove.map.TIntLongMap
    public int[] keys(int[] iArr) {
        int size = size();
        if (size == 0) {
            return iArr;
        }
        if (iArr.length < size) {
            iArr = new int[size];
        }
        int[] iArr2 = this._set;
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

    @Override // gnu.trove.map.TIntLongMap
    public TLongCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TIntLongMap
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

    @Override // gnu.trove.map.TIntLongMap
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

    @Override // gnu.trove.map.TIntLongMap
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

    @Override // gnu.trove.map.TIntLongMap
    public boolean containsKey(int i) {
        return contains(i);
    }

    @Override // gnu.trove.map.TIntLongMap
    public TIntLongIterator iterator() {
        return new TIntLongHashIterator(this);
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return forEach(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntLongMap
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

    @Override // gnu.trove.map.TIntLongMap
    public boolean forEachEntry(TIntLongProcedure tIntLongProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        long[] jArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tIntLongProcedure.execute(iArr[i], jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TIntLongMap
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

    @Override // gnu.trove.map.TIntLongMap
    public boolean retainEntries(TIntLongProcedure tIntLongProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        long[] jArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = iArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tIntLongProcedure.execute(iArr[i], jArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean increment(int i) {
        return adjustValue(i, 1L);
    }

    @Override // gnu.trove.map.TIntLongMap
    public boolean adjustValue(int i, long j) {
        int index = index(i);
        if (index < 0) {
            return false;
        }
        long[] jArr = this._values;
        jArr[index] = jArr[index] + j;
        return true;
    }

    @Override // gnu.trove.map.TIntLongMap
    public long adjustOrPutValue(int i, long j, long j2) {
        int insertKey = insertKey(i);
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
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return j2;
    }

    protected class TKeyView implements TIntSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public TIntIterator iterator() {
            TIntLongHashMap tIntLongHashMap = TIntLongHashMap.this;
            return tIntLongHashMap.new TIntLongKeyHashIterator(tIntLongHashMap);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int getNoEntryValue() {
            return TIntLongHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int size() {
            return TIntLongHashMap.this._size;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean isEmpty() {
            return TIntLongHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean contains(int i) {
            return TIntLongHashMap.this.contains(i);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int[] toArray() {
            return TIntLongHashMap.this.keys();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int[] toArray(int[] iArr) {
            return TIntLongHashMap.this.keys(iArr);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean add(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean remove(int i) {
            return TIntLongHashMap.this.no_entry_value != TIntLongHashMap.this.remove(i);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Integer) {
                    if (!TIntLongHashMap.this.containsKey(((Integer) obj).intValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(TIntCollection tIntCollection) {
            TIntIterator it = tIntCollection.iterator();
            while (it.hasNext()) {
                if (!TIntLongHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(int[] iArr) {
            for (int i : iArr) {
                if (!TIntLongHashMap.this.contains(i)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean addAll(TIntCollection tIntCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean addAll(int[] iArr) {
            throw new UnsupportedOperationException();
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
            int[] iArr2 = TIntLongHashMap.this._set;
            byte[] bArr = TIntLongHashMap.this._states;
            int length = iArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
                    TIntLongHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
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

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public void clear() {
            TIntLongHashMap.this.clear();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean forEach(TIntProcedure tIntProcedure) {
            return TIntLongHashMap.this.forEachKey(tIntProcedure);
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
            int length = TIntLongHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TIntLongHashMap.this._states[i] == 1 && !tIntSet.contains(TIntLongHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int hashCode() {
            int length = TIntLongHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TIntLongHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TIntLongHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TIntLongHashMap.this.forEachKey(new TIntProcedure() { // from class: gnu.trove.map.hash.TIntLongHashMap.TKeyView.1
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

    protected class TValueView implements TLongCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TLongCollection
        public TLongIterator iterator() {
            TIntLongHashMap tIntLongHashMap = TIntLongHashMap.this;
            return tIntLongHashMap.new TIntLongValueHashIterator(tIntLongHashMap);
        }

        @Override // gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TIntLongHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TLongCollection
        public int size() {
            return TIntLongHashMap.this._size;
        }

        @Override // gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TIntLongHashMap.this._size == 0;
        }

        @Override // gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TIntLongHashMap.this.containsValue(j);
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray() {
            return TIntLongHashMap.this.values();
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TIntLongHashMap.this.values(jArr);
        }

        @Override // gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean remove(long j) {
            long[] jArr = TIntLongHashMap.this._values;
            byte[] bArr = TIntLongHashMap.this._states;
            int length = jArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && j == jArr[i]) {
                    TIntLongHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TIntLongHashMap.this.containsValue(((Long) obj).longValue())) {
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
                if (!TIntLongHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TIntLongHashMap.this.containsValue(j)) {
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
            long[] jArr2 = TIntLongHashMap.this._values;
            byte[] bArr = TIntLongHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TIntLongHashMap.this.removeAt(i);
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
            TIntLongHashMap.this.clear();
        }

        @Override // gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TIntLongHashMap.this.forEachValue(tLongProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TIntLongHashMap.this.forEachValue(new TLongProcedure() { // from class: gnu.trove.map.hash.TIntLongHashMap.TValueView.1
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

    class TIntLongKeyHashIterator extends THashPrimitiveIterator implements TIntIterator {
        TIntLongKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
            moveToNextIndex();
            return TIntLongHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TIntLongValueHashIterator extends THashPrimitiveIterator implements TLongIterator {
        TIntLongValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            moveToNextIndex();
            return TIntLongHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TIntLongHashIterator extends THashPrimitiveIterator implements TIntLongIterator {
        TIntLongHashIterator(TIntLongHashMap tIntLongHashMap) {
            super(tIntLongHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TIntLongIterator
        public int key() {
            return TIntLongHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TIntLongIterator
        public long value() {
            return TIntLongHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TIntLongIterator
        public long setValue(long j) {
            long value = value();
            TIntLongHashMap.this._values[this._index] = j;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntLongHashMap.this.removeAt(this._index);
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
            boolean r0 = r14 instanceof gnu.trove.map.TIntLongMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TIntLongMap r14 = (gnu.trove.map.TIntLongMap) r14
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
            int[] r7 = r13._set
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TIntLongHashMap.equals(java.lang.Object):boolean");
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
                i += HashFunctions.hash(this._set[i2]) ^ HashFunctions.hash(this._values[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TIntLongProcedure() { // from class: gnu.trove.map.hash.TIntLongHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TIntLongProcedure
            public boolean execute(int i, long j) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(i);
                sb.append("=");
                sb.append(j);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TIntLongHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeInt(this._set[i]);
                objectOutput.writeLong(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TIntLongHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readInt(), objectInput.readLong());
            readInt = i;
        }
    }
}
package gnu.trove.map.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.TLongCollection;
import gnu.trove.function.TLongFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TFloatLongHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.iterator.TFloatLongIterator;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.map.TFloatLongMap;
import gnu.trove.procedure.TFloatLongProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TFloatSet;
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
public class TFloatLongHashMap extends TFloatLongHash implements TFloatLongMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient long[] _values;

    public TFloatLongHashMap() {
    }

    public TFloatLongHashMap(int i) {
        super(i);
    }

    public TFloatLongHashMap(int i, float f) {
        super(i, f);
    }

    public TFloatLongHashMap(int i, float f, float f2, long j) {
        super(i, f, f2, j);
    }

    public TFloatLongHashMap(float[] fArr, long[] jArr) {
        super(Math.max(fArr.length, jArr.length));
        int min = Math.min(fArr.length, jArr.length);
        for (int i = 0; i < min; i++) {
            put(fArr[i], jArr[i]);
        }
    }

    public TFloatLongHashMap(TFloatLongMap tFloatLongMap) {
        super(tFloatLongMap.size());
        if (tFloatLongMap instanceof TFloatLongHashMap) {
            TFloatLongHashMap tFloatLongHashMap = (TFloatLongHashMap) tFloatLongMap;
            this._loadFactor = Math.abs(tFloatLongHashMap._loadFactor);
            this.no_entry_key = tFloatLongHashMap.no_entry_key;
            this.no_entry_value = tFloatLongHashMap.no_entry_value;
            if (this.no_entry_key != 0.0f) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tFloatLongMap);
    }

    @Override // gnu.trove.impl.hash.TFloatLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new long[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        float[] fArr = this._set;
        long[] jArr = this._values;
        byte[] bArr = this._states;
        this._set = new float[i];
        this._values = new long[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(fArr[i2])] = jArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long put(float f, long j) {
        return doPut(f, j, insertKey(f));
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long putIfAbsent(float f, long j) {
        int insertKey = insertKey(f);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(f, j, insertKey);
    }

    private long doPut(float f, long j, int i) {
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

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(Map<? extends Float, ? extends Long> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Float, ? extends Long> entry : map.entrySet()) {
            put(entry.getKey().floatValue(), entry.getValue().longValue());
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public void putAll(TFloatLongMap tFloatLongMap) {
        ensureCapacity(tFloatLongMap.size());
        TFloatLongIterator it = tFloatLongMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long get(float f) {
        int index = index(f);
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

    @Override // gnu.trove.map.TFloatLongMap
    public long remove(float f) {
        long j = this.no_entry_value;
        int index = index(f);
        if (index < 0) {
            return j;
        }
        long j2 = this._values[index];
        removeAt(index);
        return j2;
    }

    @Override // gnu.trove.impl.hash.TFloatLongHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys() {
        int size = size();
        float[] fArr = new float[size];
        if (size == 0) {
            return fArr;
        }
        float[] fArr2 = this._set;
        byte[] bArr = this._states;
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return fArr;
            }
            if (bArr[i2] == 1) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public float[] keys(float[] fArr) {
        int size = size();
        if (size == 0) {
            return fArr;
        }
        if (fArr.length < size) {
            fArr = new float[size];
        }
        float[] fArr2 = this._set;
        byte[] bArr = this._states;
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return fArr;
            }
            if (bArr[i2] == 1) {
                fArr[i] = fArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TLongCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TFloatLongMap
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

    @Override // gnu.trove.map.TFloatLongMap
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

    @Override // gnu.trove.map.TFloatLongMap
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

    @Override // gnu.trove.map.TFloatLongMap
    public boolean containsKey(float f) {
        return contains(f);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public TFloatLongIterator iterator() {
        return new TFloatLongHashIterator(this);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return forEach(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatLongMap
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

    @Override // gnu.trove.map.TFloatLongMap
    public boolean forEachEntry(TFloatLongProcedure tFloatLongProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        long[] jArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatLongProcedure.execute(fArr[i], jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
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

    @Override // gnu.trove.map.TFloatLongMap
    public boolean retainEntries(TFloatLongProcedure tFloatLongProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        long[] jArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = fArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tFloatLongProcedure.execute(fArr[i], jArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean increment(float f) {
        return adjustValue(f, 1L);
    }

    @Override // gnu.trove.map.TFloatLongMap
    public boolean adjustValue(float f, long j) {
        int index = index(f);
        if (index < 0) {
            return false;
        }
        long[] jArr = this._values;
        jArr[index] = jArr[index] + j;
        return true;
    }

    @Override // gnu.trove.map.TFloatLongMap
    public long adjustOrPutValue(float f, long j, long j2) {
        int insertKey = insertKey(f);
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

    protected class TKeyView implements TFloatSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TFloatLongHashMap tFloatLongHashMap = TFloatLongHashMap.this;
            return tFloatLongHashMap.new TFloatLongKeyHashIterator(tFloatLongHashMap);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TFloatLongHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int size() {
            return TFloatLongHashMap.this._size;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TFloatLongHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TFloatLongHashMap.this.contains(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray() {
            return TFloatLongHashMap.this.keys();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TFloatLongHashMap.this.keys(fArr);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean remove(float f) {
            return TFloatLongHashMap.this.no_entry_value != TFloatLongHashMap.this.remove(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TFloatLongHashMap.this.containsKey(((Float) obj).floatValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(TFloatCollection tFloatCollection) {
            TFloatIterator it = tFloatCollection.iterator();
            while (it.hasNext()) {
                if (!TFloatLongHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TFloatLongHashMap.this.contains(f)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean addAll(Collection<? extends Float> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean addAll(TFloatCollection tFloatCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean addAll(float[] fArr) {
            throw new UnsupportedOperationException();
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
            float[] fArr2 = TFloatLongHashMap.this._set;
            byte[] bArr = TFloatLongHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TFloatLongHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
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
            if (this == tFloatCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TFloatIterator it = tFloatCollection.iterator();
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

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public void clear() {
            TFloatLongHashMap.this.clear();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TFloatLongHashMap.this.forEachKey(tFloatProcedure);
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
            int length = TFloatLongHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TFloatLongHashMap.this._states[i] == 1 && !tFloatSet.contains(TFloatLongHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int hashCode() {
            int length = TFloatLongHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TFloatLongHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TFloatLongHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatLongHashMap.this.forEachKey(new TFloatProcedure() { // from class: gnu.trove.map.hash.TFloatLongHashMap.TKeyView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TFloatProcedure
                public boolean execute(float f) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(f);
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
            TFloatLongHashMap tFloatLongHashMap = TFloatLongHashMap.this;
            return tFloatLongHashMap.new TFloatLongValueHashIterator(tFloatLongHashMap);
        }

        @Override // gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TFloatLongHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TLongCollection
        public int size() {
            return TFloatLongHashMap.this._size;
        }

        @Override // gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TFloatLongHashMap.this._size == 0;
        }

        @Override // gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TFloatLongHashMap.this.containsValue(j);
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray() {
            return TFloatLongHashMap.this.values();
        }

        @Override // gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TFloatLongHashMap.this.values(jArr);
        }

        @Override // gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TLongCollection
        public boolean remove(long j) {
            long[] jArr = TFloatLongHashMap.this._values;
            byte[] bArr = TFloatLongHashMap.this._states;
            int length = jArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && j == jArr[i]) {
                    TFloatLongHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TFloatLongHashMap.this.containsValue(((Long) obj).longValue())) {
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
                if (!TFloatLongHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TFloatLongHashMap.this.containsValue(j)) {
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
            long[] jArr2 = TFloatLongHashMap.this._values;
            byte[] bArr = TFloatLongHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TFloatLongHashMap.this.removeAt(i);
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
            TFloatLongHashMap.this.clear();
        }

        @Override // gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TFloatLongHashMap.this.forEachValue(tLongProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatLongHashMap.this.forEachValue(new TLongProcedure() { // from class: gnu.trove.map.hash.TFloatLongHashMap.TValueView.1
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

    class TFloatLongKeyHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TFloatLongKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TFloatLongHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatLongValueHashIterator extends THashPrimitiveIterator implements TLongIterator {
        TFloatLongValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            moveToNextIndex();
            return TFloatLongHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatLongHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatLongHashIterator extends THashPrimitiveIterator implements TFloatLongIterator {
        TFloatLongHashIterator(TFloatLongHashMap tFloatLongHashMap) {
            super(tFloatLongHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TFloatLongIterator
        public float key() {
            return TFloatLongHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TFloatLongIterator
        public long value() {
            return TFloatLongHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TFloatLongIterator
        public long setValue(long j) {
            long value = value();
            TFloatLongHashMap.this._values[this._index] = j;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatLongHashMap.this.removeAt(this._index);
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
            boolean r0 = r14 instanceof gnu.trove.map.TFloatLongMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TFloatLongMap r14 = (gnu.trove.map.TFloatLongMap) r14
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
            float[] r7 = r13._set
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TFloatLongHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TFloatLongProcedure() { // from class: gnu.trove.map.hash.TFloatLongHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TFloatLongProcedure
            public boolean execute(float f, long j) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(f);
                sb.append("=");
                sb.append(j);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TFloatLongHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeFloat(this._set[i]);
                objectOutput.writeLong(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TFloatLongHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readFloat(), objectInput.readLong());
            readInt = i;
        }
    }
}

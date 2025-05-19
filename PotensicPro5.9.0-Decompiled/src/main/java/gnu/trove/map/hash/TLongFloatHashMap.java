package gnu.trove.map.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.TLongCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TLongFloatHash;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.iterator.TLongFloatIterator;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.map.TLongFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TLongFloatProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
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
public class TLongFloatHashMap extends TLongFloatHash implements TLongFloatMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient float[] _values;

    public TLongFloatHashMap() {
    }

    public TLongFloatHashMap(int i) {
        super(i);
    }

    public TLongFloatHashMap(int i, float f) {
        super(i, f);
    }

    public TLongFloatHashMap(int i, float f, long j, float f2) {
        super(i, f, j, f2);
    }

    public TLongFloatHashMap(long[] jArr, float[] fArr) {
        super(Math.max(jArr.length, fArr.length));
        int min = Math.min(jArr.length, fArr.length);
        for (int i = 0; i < min; i++) {
            put(jArr[i], fArr[i]);
        }
    }

    public TLongFloatHashMap(TLongFloatMap tLongFloatMap) {
        super(tLongFloatMap.size());
        if (tLongFloatMap instanceof TLongFloatHashMap) {
            TLongFloatHashMap tLongFloatHashMap = (TLongFloatHashMap) tLongFloatMap;
            this._loadFactor = Math.abs(tLongFloatHashMap._loadFactor);
            this.no_entry_key = tLongFloatHashMap.no_entry_key;
            this.no_entry_value = tLongFloatHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tLongFloatMap);
    }

    @Override // gnu.trove.impl.hash.TLongFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new float[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        long[] jArr = this._set;
        float[] fArr = this._values;
        byte[] bArr = this._states;
        this._set = new long[i];
        this._values = new float[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(jArr[i2])] = fArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float put(long j, float f) {
        return doPut(j, f, insertKey(j));
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float putIfAbsent(long j, float f) {
        int insertKey = insertKey(j);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(j, f, insertKey);
    }

    private float doPut(long j, float f, int i) {
        float f2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            f2 = this._values[i];
            z = false;
        }
        this._values[i] = f;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f2;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void putAll(Map<? extends Long, ? extends Float> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Long, ? extends Float> entry : map.entrySet()) {
            put(entry.getKey().longValue(), entry.getValue().floatValue());
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void putAll(TLongFloatMap tLongFloatMap) {
        ensureCapacity(tLongFloatMap.size());
        TLongFloatIterator it = tLongFloatMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float get(long j) {
        int index = index(j);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        float[] fArr = this._values;
        Arrays.fill(fArr, 0, fArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float remove(long j) {
        float f = this.no_entry_value;
        int index = index(j);
        if (index < 0) {
            return f;
        }
        float f2 = this._values[index];
        removeAt(index);
        return f2;
    }

    @Override // gnu.trove.impl.hash.TLongFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys() {
        int size = size();
        long[] jArr = new long[size];
        if (size == 0) {
            return jArr;
        }
        long[] jArr2 = this._set;
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

    @Override // gnu.trove.map.TLongFloatMap
    public long[] keys(long[] jArr) {
        int size = size();
        if (size == 0) {
            return jArr;
        }
        if (jArr.length < size) {
            jArr = new long[size];
        }
        long[] jArr2 = this._set;
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

    @Override // gnu.trove.map.TLongFloatMap
    public TFloatCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values() {
        int size = size();
        float[] fArr = new float[size];
        if (size == 0) {
            return fArr;
        }
        float[] fArr2 = this._values;
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

    @Override // gnu.trove.map.TLongFloatMap
    public float[] values(float[] fArr) {
        int size = size();
        if (size == 0) {
            return fArr;
        }
        if (fArr.length < size) {
            fArr = new float[size];
        }
        float[] fArr2 = this._values;
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

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsValue(float f) {
        byte[] bArr = this._states;
        float[] fArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && f == fArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean containsKey(long j) {
        return contains(j);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public TLongFloatIterator iterator() {
        return new TLongFloatHashIterator(this);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return forEach(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachValue(TFloatProcedure tFloatProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatProcedure.execute(fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean forEachEntry(TLongFloatProcedure tLongFloatProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        float[] fArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongFloatProcedure.execute(jArr[i], fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public void transformValues(TFloatFunction tFloatFunction) {
        byte[] bArr = this._states;
        float[] fArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                fArr[i] = tFloatFunction.execute(fArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean retainEntries(TLongFloatProcedure tLongFloatProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        float[] fArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tLongFloatProcedure.execute(jArr[i], fArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean increment(long j) {
        return adjustValue(j, 1.0f);
    }

    @Override // gnu.trove.map.TLongFloatMap
    public boolean adjustValue(long j, float f) {
        int index = index(j);
        if (index < 0) {
            return false;
        }
        float[] fArr = this._values;
        fArr[index] = fArr[index] + f;
        return true;
    }

    @Override // gnu.trove.map.TLongFloatMap
    public float adjustOrPutValue(long j, float f, float f2) {
        int insertKey = insertKey(j);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            float[] fArr = this._values;
            f2 = fArr[insertKey] + f;
            fArr[insertKey] = f2;
            z = false;
        } else {
            this._values[insertKey] = f2;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f2;
    }

    protected class TKeyView implements TLongSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public TLongIterator iterator() {
            TLongFloatHashMap tLongFloatHashMap = TLongFloatHashMap.this;
            return tLongFloatHashMap.new TLongFloatKeyHashIterator(tLongFloatHashMap);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TLongFloatHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int size() {
            return TLongFloatHashMap.this._size;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TLongFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TLongFloatHashMap.this.contains(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray() {
            return TLongFloatHashMap.this.keys();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TLongFloatHashMap.this.keys(jArr);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean remove(long j) {
            return TLongFloatHashMap.this.no_entry_value != TLongFloatHashMap.this.remove(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TLongFloatHashMap.this.containsKey(((Long) obj).longValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(TLongCollection tLongCollection) {
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (!TLongFloatHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TLongFloatHashMap.this.contains(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(TLongCollection tLongCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(long[] jArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
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

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
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

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(long[] jArr) {
            Arrays.sort(jArr);
            long[] jArr2 = TLongFloatHashMap.this._set;
            byte[] bArr = TLongFloatHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TLongFloatHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Long) && remove(((Long) obj).longValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
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

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
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

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public void clear() {
            TLongFloatHashMap.this.clear();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TLongFloatHashMap.this.forEachKey(tLongProcedure);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TLongSet)) {
                return false;
            }
            TLongSet tLongSet = (TLongSet) obj;
            if (tLongSet.size() != size()) {
                return false;
            }
            int length = TLongFloatHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TLongFloatHashMap.this._states[i] == 1 && !tLongSet.contains(TLongFloatHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int hashCode() {
            int length = TLongFloatHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TLongFloatHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TLongFloatHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TLongFloatHashMap.this.forEachKey(new TLongProcedure() { // from class: gnu.trove.map.hash.TLongFloatHashMap.TKeyView.1
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

    protected class TValueView implements TFloatCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TLongFloatHashMap tLongFloatHashMap = TLongFloatHashMap.this;
            return tLongFloatHashMap.new TLongFloatValueHashIterator(tLongFloatHashMap);
        }

        @Override // gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TLongFloatHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TFloatCollection
        public int size() {
            return TLongFloatHashMap.this._size;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TLongFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TLongFloatHashMap.this.containsValue(f);
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray() {
            return TLongFloatHashMap.this.values();
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TLongFloatHashMap.this.values(fArr);
        }

        @Override // gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean remove(float f) {
            float[] fArr = TLongFloatHashMap.this._values;
            byte[] bArr = TLongFloatHashMap.this._states;
            int length = fArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && f == fArr[i]) {
                    TLongFloatHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TLongFloatHashMap.this.containsValue(((Float) obj).floatValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(TFloatCollection tFloatCollection) {
            TFloatIterator it = tFloatCollection.iterator();
            while (it.hasNext()) {
                if (!TLongFloatHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TLongFloatHashMap.this.containsValue(f)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean addAll(Collection<? extends Float> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean addAll(TFloatCollection tFloatCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean addAll(float[] fArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
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

        @Override // gnu.trove.TFloatCollection
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

        @Override // gnu.trove.TFloatCollection
        public boolean retainAll(float[] fArr) {
            Arrays.sort(fArr);
            float[] fArr2 = TLongFloatHashMap.this._values;
            byte[] bArr = TLongFloatHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TLongFloatHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Float) && remove(((Float) obj).floatValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TFloatCollection
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

        @Override // gnu.trove.TFloatCollection
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

        @Override // gnu.trove.TFloatCollection
        public void clear() {
            TLongFloatHashMap.this.clear();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TLongFloatHashMap.this.forEachValue(tFloatProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TLongFloatHashMap.this.forEachValue(new TFloatProcedure() { // from class: gnu.trove.map.hash.TLongFloatHashMap.TValueView.1
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

    class TLongFloatKeyHashIterator extends THashPrimitiveIterator implements TLongIterator {
        TLongFloatKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            moveToNextIndex();
            return TLongFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TLongFloatValueHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TLongFloatValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TLongFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TLongFloatHashIterator extends THashPrimitiveIterator implements TLongFloatIterator {
        TLongFloatHashIterator(TLongFloatHashMap tLongFloatHashMap) {
            super(tLongFloatHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TLongFloatIterator
        public long key() {
            return TLongFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TLongFloatIterator
        public float value() {
            return TLongFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TLongFloatIterator
        public float setValue(float f) {
            float value = value();
            TLongFloatHashMap.this._values[this._index] = f;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongFloatHashMap.this.removeAt(this._index);
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
    public boolean equals(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof gnu.trove.map.TLongFloatMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TLongFloatMap r10 = (gnu.trove.map.TLongFloatMap) r10
            int r0 = r10.size()
            int r2 = r9.size()
            if (r0 == r2) goto L13
            return r1
        L13:
            float[] r0 = r9._values
            byte[] r2 = r9._states
            float r3 = r9.getNoEntryValue()
            float r4 = r10.getNoEntryValue()
            int r5 = r0.length
        L20:
            int r6 = r5 + (-1)
            r7 = 1
            if (r5 <= 0) goto L49
            r5 = r2[r6]
            if (r5 != r7) goto L47
            long[] r5 = r9._set
            r7 = r5[r6]
            boolean r5 = r10.containsKey(r7)
            if (r5 != 0) goto L34
            return r1
        L34:
            float r5 = r10.get(r7)
            r7 = r0[r6]
            int r8 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r8 == 0) goto L47
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 != 0) goto L46
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 == 0) goto L47
        L46:
            return r1
        L47:
            r5 = r6
            goto L20
        L49:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TLongFloatHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TLongFloatProcedure() { // from class: gnu.trove.map.hash.TLongFloatHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TLongFloatProcedure
            public boolean execute(long j, float f) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(j);
                sb.append("=");
                sb.append(f);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TLongFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeLong(this._set[i]);
                objectOutput.writeFloat(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TLongFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readLong(), objectInput.readFloat());
            readInt = i;
        }
    }
}

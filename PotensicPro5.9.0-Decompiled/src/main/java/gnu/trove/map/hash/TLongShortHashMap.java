package gnu.trove.map.hash;

import gnu.trove.TLongCollection;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TLongShortHash;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.iterator.TLongShortIterator;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.map.TLongShortMap;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.procedure.TLongShortProcedure;
import gnu.trove.procedure.TShortProcedure;
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
public class TLongShortHashMap extends TLongShortHash implements TLongShortMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient short[] _values;

    public TLongShortHashMap() {
    }

    public TLongShortHashMap(int i) {
        super(i);
    }

    public TLongShortHashMap(int i, float f) {
        super(i, f);
    }

    public TLongShortHashMap(int i, float f, long j, short s) {
        super(i, f, j, s);
    }

    public TLongShortHashMap(long[] jArr, short[] sArr) {
        super(Math.max(jArr.length, sArr.length));
        int min = Math.min(jArr.length, sArr.length);
        for (int i = 0; i < min; i++) {
            put(jArr[i], sArr[i]);
        }
    }

    public TLongShortHashMap(TLongShortMap tLongShortMap) {
        super(tLongShortMap.size());
        if (tLongShortMap instanceof TLongShortHashMap) {
            TLongShortHashMap tLongShortHashMap = (TLongShortHashMap) tLongShortMap;
            this._loadFactor = Math.abs(tLongShortHashMap._loadFactor);
            this.no_entry_key = tLongShortHashMap.no_entry_key;
            this.no_entry_value = tLongShortHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tLongShortMap);
    }

    @Override // gnu.trove.impl.hash.TLongShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new short[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        long[] jArr = this._set;
        short[] sArr = this._values;
        byte[] bArr = this._states;
        this._set = new long[i];
        this._values = new short[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(jArr[i2])] = sArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public short put(long j, short s) {
        return doPut(j, s, insertKey(j));
    }

    @Override // gnu.trove.map.TLongShortMap
    public short putIfAbsent(long j, short s) {
        int insertKey = insertKey(j);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(j, s, insertKey);
    }

    private short doPut(long j, short s, int i) {
        short s2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            s2 = this._values[i];
            z = false;
        }
        this._values[i] = s;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return s2;
    }

    @Override // gnu.trove.map.TLongShortMap
    public void putAll(Map<? extends Long, ? extends Short> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Long, ? extends Short> entry : map.entrySet()) {
            put(entry.getKey().longValue(), entry.getValue().shortValue());
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public void putAll(TLongShortMap tLongShortMap) {
        ensureCapacity(tLongShortMap.size());
        TLongShortIterator it = tLongShortMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public short get(long j) {
        int index = index(j);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        short[] sArr = this._values;
        Arrays.fill(sArr, 0, sArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short remove(long j) {
        short s = this.no_entry_value;
        int index = index(j);
        if (index < 0) {
            return s;
        }
        short s2 = this._values[index];
        removeAt(index);
        return s2;
    }

    @Override // gnu.trove.impl.hash.TLongShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TLongShortMap
    public TLongSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TLongShortMap
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

    @Override // gnu.trove.map.TLongShortMap
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

    @Override // gnu.trove.map.TLongShortMap
    public TShortCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TLongShortMap
    public short[] values() {
        int size = size();
        short[] sArr = new short[size];
        if (size == 0) {
            return sArr;
        }
        short[] sArr2 = this._values;
        byte[] bArr = this._states;
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return sArr;
            }
            if (bArr[i2] == 1) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public short[] values(short[] sArr) {
        int size = size();
        if (size == 0) {
            return sArr;
        }
        if (sArr.length < size) {
            sArr = new short[size];
        }
        short[] sArr2 = this._values;
        byte[] bArr = this._states;
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return sArr;
            }
            if (bArr[i2] == 1) {
                sArr[i] = sArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean containsValue(short s) {
        byte[] bArr = this._states;
        short[] sArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && s == sArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean containsKey(long j) {
        return contains(j);
    }

    @Override // gnu.trove.map.TLongShortMap
    public TLongShortIterator iterator() {
        return new TLongShortHashIterator(this);
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return forEach(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachValue(TShortProcedure tShortProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tShortProcedure.execute(sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean forEachEntry(TLongShortProcedure tLongShortProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        short[] sArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongShortProcedure.execute(jArr[i], sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public void transformValues(TShortFunction tShortFunction) {
        byte[] bArr = this._states;
        short[] sArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                sArr[i] = tShortFunction.execute(sArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean retainEntries(TLongShortProcedure tLongShortProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        short[] sArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tLongShortProcedure.execute(jArr[i], sArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean increment(long j) {
        return adjustValue(j, (short) 1);
    }

    @Override // gnu.trove.map.TLongShortMap
    public boolean adjustValue(long j, short s) {
        int index = index(j);
        if (index < 0) {
            return false;
        }
        short[] sArr = this._values;
        sArr[index] = (short) (sArr[index] + s);
        return true;
    }

    @Override // gnu.trove.map.TLongShortMap
    public short adjustOrPutValue(long j, short s, short s2) {
        int insertKey = insertKey(j);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            short[] sArr = this._values;
            s2 = (short) (sArr[insertKey] + s);
            sArr[insertKey] = s2;
            z = false;
        } else {
            this._values[insertKey] = s2;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return s2;
    }

    protected class TKeyView implements TLongSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public TLongIterator iterator() {
            TLongShortHashMap tLongShortHashMap = TLongShortHashMap.this;
            return tLongShortHashMap.new TLongShortKeyHashIterator(tLongShortHashMap);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TLongShortHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int size() {
            return TLongShortHashMap.this._size;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TLongShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TLongShortHashMap.this.contains(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray() {
            return TLongShortHashMap.this.keys();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TLongShortHashMap.this.keys(jArr);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean remove(long j) {
            return TLongShortHashMap.this.no_entry_value != TLongShortHashMap.this.remove(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TLongShortHashMap.this.containsKey(((Long) obj).longValue())) {
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
                if (!TLongShortHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TLongShortHashMap.this.contains(j)) {
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
            long[] jArr2 = TLongShortHashMap.this._set;
            byte[] bArr = TLongShortHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TLongShortHashMap.this.removeAt(i);
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
            TLongShortHashMap.this.clear();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TLongShortHashMap.this.forEachKey(tLongProcedure);
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
            int length = TLongShortHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TLongShortHashMap.this._states[i] == 1 && !tLongSet.contains(TLongShortHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int hashCode() {
            int length = TLongShortHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TLongShortHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TLongShortHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TLongShortHashMap.this.forEachKey(new TLongProcedure() { // from class: gnu.trove.map.hash.TLongShortHashMap.TKeyView.1
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

    protected class TValueView implements TShortCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TShortCollection
        public TShortIterator iterator() {
            TLongShortHashMap tLongShortHashMap = TLongShortHashMap.this;
            return tLongShortHashMap.new TLongShortValueHashIterator(tLongShortHashMap);
        }

        @Override // gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TLongShortHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TShortCollection
        public int size() {
            return TLongShortHashMap.this._size;
        }

        @Override // gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TLongShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TLongShortHashMap.this.containsValue(s);
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray() {
            return TLongShortHashMap.this.values();
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TLongShortHashMap.this.values(sArr);
        }

        @Override // gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean remove(short s) {
            short[] sArr = TLongShortHashMap.this._values;
            byte[] bArr = TLongShortHashMap.this._states;
            int length = sArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && s == sArr[i]) {
                    TLongShortHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TLongShortHashMap.this.containsValue(((Short) obj).shortValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(TShortCollection tShortCollection) {
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (!TLongShortHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TLongShortHashMap.this.containsValue(s)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean addAll(Collection<? extends Short> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean addAll(TShortCollection tShortCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean addAll(short[] sArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
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

        @Override // gnu.trove.TShortCollection
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

        @Override // gnu.trove.TShortCollection
        public boolean retainAll(short[] sArr) {
            Arrays.sort(sArr);
            short[] sArr2 = TLongShortHashMap.this._values;
            byte[] bArr = TLongShortHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TLongShortHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TShortCollection
        public boolean removeAll(TShortCollection tShortCollection) {
            if (this == tShortCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TShortCollection
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

        @Override // gnu.trove.TShortCollection
        public void clear() {
            TLongShortHashMap.this.clear();
        }

        @Override // gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TLongShortHashMap.this.forEachValue(tShortProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TLongShortHashMap.this.forEachValue(new TShortProcedure() { // from class: gnu.trove.map.hash.TLongShortHashMap.TValueView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TShortProcedure
                public boolean execute(short s) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append((int) s);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }
    }

    class TLongShortKeyHashIterator extends THashPrimitiveIterator implements TLongIterator {
        TLongShortKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            moveToNextIndex();
            return TLongShortHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TLongShortValueHashIterator extends THashPrimitiveIterator implements TShortIterator {
        TLongShortValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            moveToNextIndex();
            return TLongShortHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TLongShortHashIterator extends THashPrimitiveIterator implements TLongShortIterator {
        TLongShortHashIterator(TLongShortHashMap tLongShortHashMap) {
            super(tLongShortHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TLongShortIterator
        public long key() {
            return TLongShortHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TLongShortIterator
        public short value() {
            return TLongShortHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TLongShortIterator
        public short setValue(short s) {
            short value = value();
            TLongShortHashMap.this._values[this._index] = s;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TLongShortMap)) {
            return false;
        }
        TLongShortMap tLongShortMap = (TLongShortMap) obj;
        if (tLongShortMap.size() != size()) {
            return false;
        }
        short[] sArr = this._values;
        byte[] bArr = this._states;
        short noEntryValue = getNoEntryValue();
        short noEntryValue2 = tLongShortMap.getNoEntryValue();
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                long j = this._set[i];
                if (!tLongShortMap.containsKey(j)) {
                    return false;
                }
                short s = tLongShortMap.get(j);
                short s2 = sArr[i];
                if (s2 != s && (s2 != noEntryValue || s != noEntryValue2)) {
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
                i += HashFunctions.hash(this._set[i2]) ^ HashFunctions.hash((int) this._values[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TLongShortProcedure() { // from class: gnu.trove.map.hash.TLongShortHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TLongShortProcedure
            public boolean execute(long j, short s) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(j);
                sb.append("=");
                sb.append((int) s);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TLongShortHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeShort(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TLongShortHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readLong(), objectInput.readShort());
            readInt = i;
        }
    }
}

package gnu.trove.map.hash;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.impl.hash.TShortShortHash;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.map.TShortShortMap;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.procedure.TShortShortProcedure;
import gnu.trove.set.TShortSet;
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
public class TShortShortHashMap extends TShortShortHash implements TShortShortMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient short[] _values;

    public TShortShortHashMap() {
    }

    public TShortShortHashMap(int i) {
        super(i);
    }

    public TShortShortHashMap(int i, float f) {
        super(i, f);
    }

    public TShortShortHashMap(int i, float f, short s, short s2) {
        super(i, f, s, s2);
    }

    public TShortShortHashMap(short[] sArr, short[] sArr2) {
        super(Math.max(sArr.length, sArr2.length));
        int min = Math.min(sArr.length, sArr2.length);
        for (int i = 0; i < min; i++) {
            put(sArr[i], sArr2[i]);
        }
    }

    public TShortShortHashMap(TShortShortMap tShortShortMap) {
        super(tShortShortMap.size());
        if (tShortShortMap instanceof TShortShortHashMap) {
            TShortShortHashMap tShortShortHashMap = (TShortShortHashMap) tShortShortMap;
            this._loadFactor = Math.abs(tShortShortHashMap._loadFactor);
            this.no_entry_key = tShortShortHashMap.no_entry_key;
            this.no_entry_value = tShortShortHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tShortShortMap);
    }

    @Override // gnu.trove.impl.hash.TShortShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new short[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        short[] sArr = this._set;
        short[] sArr2 = this._values;
        byte[] bArr = this._states;
        this._set = new short[i];
        this._values = new short[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(sArr[i2])] = sArr2[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public short put(short s, short s2) {
        return doPut(s, s2, insertKey(s));
    }

    @Override // gnu.trove.map.TShortShortMap
    public short putIfAbsent(short s, short s2) {
        int insertKey = insertKey(s);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(s, s2, insertKey);
    }

    private short doPut(short s, short s2, int i) {
        short s3 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            s3 = this._values[i];
            z = false;
        }
        this._values[i] = s2;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return s3;
    }

    @Override // gnu.trove.map.TShortShortMap
    public void putAll(Map<? extends Short, ? extends Short> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Short, ? extends Short> entry : map.entrySet()) {
            put(entry.getKey().shortValue(), entry.getValue().shortValue());
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public void putAll(TShortShortMap tShortShortMap) {
        ensureCapacity(tShortShortMap.size());
        TShortShortIterator it = tShortShortMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public short get(short s) {
        int index = index(s);
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

    @Override // gnu.trove.map.TShortShortMap
    public short remove(short s) {
        short s2 = this.no_entry_value;
        int index = index(s);
        if (index < 0) {
            return s2;
        }
        short s3 = this._values[index];
        removeAt(index);
        return s3;
    }

    @Override // gnu.trove.impl.hash.TShortShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TShortShortMap
    public short[] keys() {
        int size = size();
        short[] sArr = new short[size];
        if (size == 0) {
            return sArr;
        }
        short[] sArr2 = this._set;
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

    @Override // gnu.trove.map.TShortShortMap
    public short[] keys(short[] sArr) {
        int size = size();
        if (size == 0) {
            return sArr;
        }
        if (sArr.length < size) {
            sArr = new short[size];
        }
        short[] sArr2 = this._set;
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

    @Override // gnu.trove.map.TShortShortMap
    public TShortCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TShortShortMap
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

    @Override // gnu.trove.map.TShortShortMap
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

    @Override // gnu.trove.map.TShortShortMap
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

    @Override // gnu.trove.map.TShortShortMap
    public boolean containsKey(short s) {
        return contains(s);
    }

    @Override // gnu.trove.map.TShortShortMap
    public TShortShortIterator iterator() {
        return new TShortShortHashIterator(this);
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return forEach(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortShortMap
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

    @Override // gnu.trove.map.TShortShortMap
    public boolean forEachEntry(TShortShortProcedure tShortShortProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        short[] sArr2 = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tShortShortProcedure.execute(sArr[i], sArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TShortShortMap
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

    @Override // gnu.trove.map.TShortShortMap
    public boolean retainEntries(TShortShortProcedure tShortShortProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        short[] sArr2 = this._values;
        tempDisableAutoCompaction();
        try {
            int length = sArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tShortShortProcedure.execute(sArr[i], sArr2[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean increment(short s) {
        return adjustValue(s, (short) 1);
    }

    @Override // gnu.trove.map.TShortShortMap
    public boolean adjustValue(short s, short s2) {
        int index = index(s);
        if (index < 0) {
            return false;
        }
        short[] sArr = this._values;
        sArr[index] = (short) (sArr[index] + s2);
        return true;
    }

    @Override // gnu.trove.map.TShortShortMap
    public short adjustOrPutValue(short s, short s2, short s3) {
        int insertKey = insertKey(s);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            short[] sArr = this._values;
            short s4 = (short) (sArr[insertKey] + s2);
            sArr[insertKey] = s4;
            z = false;
            s3 = s4;
        } else {
            this._values[insertKey] = s3;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return s3;
    }

    protected class TKeyView implements TShortSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public TShortIterator iterator() {
            TShortShortHashMap tShortShortHashMap = TShortShortHashMap.this;
            return tShortShortHashMap.new TShortShortKeyHashIterator(tShortShortHashMap);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TShortShortHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int size() {
            return TShortShortHashMap.this._size;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TShortShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TShortShortHashMap.this.contains(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray() {
            return TShortShortHashMap.this.keys();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TShortShortHashMap.this.keys(sArr);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean remove(short s) {
            return TShortShortHashMap.this.no_entry_value != TShortShortHashMap.this.remove(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TShortShortHashMap.this.containsKey(((Short) obj).shortValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(TShortCollection tShortCollection) {
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (!TShortShortHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TShortShortHashMap.this.contains(s)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(Collection<? extends Short> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(TShortCollection tShortCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(short[] sArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean retainAll(short[] sArr) {
            Arrays.sort(sArr);
            short[] sArr2 = TShortShortHashMap.this._set;
            byte[] bArr = TShortShortHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TShortShortHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public void clear() {
            TShortShortHashMap.this.clear();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TShortShortHashMap.this.forEachKey(tShortProcedure);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TShortSet)) {
                return false;
            }
            TShortSet tShortSet = (TShortSet) obj;
            if (tShortSet.size() != size()) {
                return false;
            }
            int length = TShortShortHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TShortShortHashMap.this._states[i] == 1 && !tShortSet.contains(TShortShortHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int hashCode() {
            int length = TShortShortHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TShortShortHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TShortShortHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TShortShortHashMap.this.forEachKey(new TShortProcedure() { // from class: gnu.trove.map.hash.TShortShortHashMap.TKeyView.1
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

    protected class TValueView implements TShortCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TShortCollection
        public TShortIterator iterator() {
            TShortShortHashMap tShortShortHashMap = TShortShortHashMap.this;
            return tShortShortHashMap.new TShortShortValueHashIterator(tShortShortHashMap);
        }

        @Override // gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TShortShortHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TShortCollection
        public int size() {
            return TShortShortHashMap.this._size;
        }

        @Override // gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TShortShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TShortShortHashMap.this.containsValue(s);
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray() {
            return TShortShortHashMap.this.values();
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TShortShortHashMap.this.values(sArr);
        }

        @Override // gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean remove(short s) {
            short[] sArr = TShortShortHashMap.this._values;
            byte[] bArr = TShortShortHashMap.this._states;
            int length = sArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && s == sArr[i]) {
                    TShortShortHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TShortShortHashMap.this.containsValue(((Short) obj).shortValue())) {
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
                if (!TShortShortHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TShortShortHashMap.this.containsValue(s)) {
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
            short[] sArr2 = TShortShortHashMap.this._values;
            byte[] bArr = TShortShortHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TShortShortHashMap.this.removeAt(i);
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
            TShortShortHashMap.this.clear();
        }

        @Override // gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TShortShortHashMap.this.forEachValue(tShortProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TShortShortHashMap.this.forEachValue(new TShortProcedure() { // from class: gnu.trove.map.hash.TShortShortHashMap.TValueView.1
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

    class TShortShortKeyHashIterator extends THashPrimitiveIterator implements TShortIterator {
        TShortShortKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            moveToNextIndex();
            return TShortShortHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TShortShortValueHashIterator extends THashPrimitiveIterator implements TShortIterator {
        TShortShortValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            moveToNextIndex();
            return TShortShortHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TShortShortHashIterator extends THashPrimitiveIterator implements TShortShortIterator {
        TShortShortHashIterator(TShortShortHashMap tShortShortHashMap) {
            super(tShortShortHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TShortShortIterator
        public short key() {
            return TShortShortHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TShortShortIterator
        public short value() {
            return TShortShortHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TShortShortIterator
        public short setValue(short s) {
            short value = value();
            TShortShortHashMap.this._values[this._index] = s;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TShortShortMap)) {
            return false;
        }
        TShortShortMap tShortShortMap = (TShortShortMap) obj;
        if (tShortShortMap.size() != size()) {
            return false;
        }
        short[] sArr = this._values;
        byte[] bArr = this._states;
        short noEntryValue = getNoEntryValue();
        short noEntryValue2 = tShortShortMap.getNoEntryValue();
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                short s = this._set[i];
                if (!tShortShortMap.containsKey(s)) {
                    return false;
                }
                short s2 = tShortShortMap.get(s);
                short s3 = sArr[i];
                if (s3 != s2 && (s3 != noEntryValue || s2 != noEntryValue2)) {
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
        forEachEntry(new TShortShortProcedure() { // from class: gnu.trove.map.hash.TShortShortHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TShortShortProcedure
            public boolean execute(short s, short s2) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) s);
                sb.append("=");
                sb.append((int) s2);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TShortShortHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeShort(this._set[i]);
                objectOutput.writeShort(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TShortShortHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readShort(), objectInput.readShort());
            readInt = i;
        }
    }
}

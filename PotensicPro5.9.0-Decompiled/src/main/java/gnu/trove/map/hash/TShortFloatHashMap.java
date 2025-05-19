package gnu.trove.map.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.TShortCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.impl.hash.TShortFloatHash;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.iterator.TShortFloatIterator;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.map.TShortFloatMap;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TShortFloatProcedure;
import gnu.trove.procedure.TShortProcedure;
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
public class TShortFloatHashMap extends TShortFloatHash implements TShortFloatMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient float[] _values;

    public TShortFloatHashMap() {
    }

    public TShortFloatHashMap(int i) {
        super(i);
    }

    public TShortFloatHashMap(int i, float f) {
        super(i, f);
    }

    public TShortFloatHashMap(int i, float f, short s, float f2) {
        super(i, f, s, f2);
    }

    public TShortFloatHashMap(short[] sArr, float[] fArr) {
        super(Math.max(sArr.length, fArr.length));
        int min = Math.min(sArr.length, fArr.length);
        for (int i = 0; i < min; i++) {
            put(sArr[i], fArr[i]);
        }
    }

    public TShortFloatHashMap(TShortFloatMap tShortFloatMap) {
        super(tShortFloatMap.size());
        if (tShortFloatMap instanceof TShortFloatHashMap) {
            TShortFloatHashMap tShortFloatHashMap = (TShortFloatHashMap) tShortFloatMap;
            this._loadFactor = Math.abs(tShortFloatHashMap._loadFactor);
            this.no_entry_key = tShortFloatHashMap.no_entry_key;
            this.no_entry_value = tShortFloatHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tShortFloatMap);
    }

    @Override // gnu.trove.impl.hash.TShortFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new float[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        short[] sArr = this._set;
        float[] fArr = this._values;
        byte[] bArr = this._states;
        this._set = new short[i];
        this._values = new float[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(sArr[i2])] = fArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float put(short s, float f) {
        return doPut(s, f, insertKey(s));
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float putIfAbsent(short s, float f) {
        int insertKey = insertKey(s);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(s, f, insertKey);
    }

    private float doPut(short s, float f, int i) {
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

    @Override // gnu.trove.map.TShortFloatMap
    public void putAll(Map<? extends Short, ? extends Float> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Short, ? extends Float> entry : map.entrySet()) {
            put(entry.getKey().shortValue(), entry.getValue().floatValue());
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public void putAll(TShortFloatMap tShortFloatMap) {
        ensureCapacity(tShortFloatMap.size());
        TShortFloatIterator it = tShortFloatMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float get(short s) {
        int index = index(s);
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

    @Override // gnu.trove.map.TShortFloatMap
    public float remove(short s) {
        float f = this.no_entry_value;
        int index = index(s);
        if (index < 0) {
            return f;
        }
        float f2 = this._values[index];
        removeAt(index);
        return f2;
    }

    @Override // gnu.trove.impl.hash.TShortFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TShortSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
    public TFloatCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
    public boolean containsKey(short s) {
        return contains(s);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public TShortFloatIterator iterator() {
        return new TShortFloatHashIterator(this);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return forEach(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
    public boolean forEachEntry(TShortFloatProcedure tShortFloatProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        float[] fArr = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tShortFloatProcedure.execute(sArr[i], fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
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

    @Override // gnu.trove.map.TShortFloatMap
    public boolean retainEntries(TShortFloatProcedure tShortFloatProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        float[] fArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = sArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tShortFloatProcedure.execute(sArr[i], fArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean increment(short s) {
        return adjustValue(s, 1.0f);
    }

    @Override // gnu.trove.map.TShortFloatMap
    public boolean adjustValue(short s, float f) {
        int index = index(s);
        if (index < 0) {
            return false;
        }
        float[] fArr = this._values;
        fArr[index] = fArr[index] + f;
        return true;
    }

    @Override // gnu.trove.map.TShortFloatMap
    public float adjustOrPutValue(short s, float f, float f2) {
        int insertKey = insertKey(s);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            float[] fArr = this._values;
            float f3 = f + fArr[insertKey];
            fArr[insertKey] = f3;
            z = false;
            f2 = f3;
        } else {
            this._values[insertKey] = f2;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f2;
    }

    protected class TKeyView implements TShortSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public TShortIterator iterator() {
            TShortFloatHashMap tShortFloatHashMap = TShortFloatHashMap.this;
            return tShortFloatHashMap.new TShortFloatKeyHashIterator(tShortFloatHashMap);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TShortFloatHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int size() {
            return TShortFloatHashMap.this._size;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TShortFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TShortFloatHashMap.this.contains(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray() {
            return TShortFloatHashMap.this.keys();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TShortFloatHashMap.this.keys(sArr);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean remove(short s) {
            return TShortFloatHashMap.this.no_entry_value != TShortFloatHashMap.this.remove(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TShortFloatHashMap.this.containsKey(((Short) obj).shortValue())) {
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
                if (!TShortFloatHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TShortFloatHashMap.this.contains(s)) {
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
            short[] sArr2 = TShortFloatHashMap.this._set;
            byte[] bArr = TShortFloatHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TShortFloatHashMap.this.removeAt(i);
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
            TShortFloatHashMap.this.clear();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TShortFloatHashMap.this.forEachKey(tShortProcedure);
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
            int length = TShortFloatHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TShortFloatHashMap.this._states[i] == 1 && !tShortSet.contains(TShortFloatHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int hashCode() {
            int length = TShortFloatHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TShortFloatHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TShortFloatHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TShortFloatHashMap.this.forEachKey(new TShortProcedure() { // from class: gnu.trove.map.hash.TShortFloatHashMap.TKeyView.1
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

    protected class TValueView implements TFloatCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TShortFloatHashMap tShortFloatHashMap = TShortFloatHashMap.this;
            return tShortFloatHashMap.new TShortFloatValueHashIterator(tShortFloatHashMap);
        }

        @Override // gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TShortFloatHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TFloatCollection
        public int size() {
            return TShortFloatHashMap.this._size;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TShortFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TShortFloatHashMap.this.containsValue(f);
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray() {
            return TShortFloatHashMap.this.values();
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TShortFloatHashMap.this.values(fArr);
        }

        @Override // gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean remove(float f) {
            float[] fArr = TShortFloatHashMap.this._values;
            byte[] bArr = TShortFloatHashMap.this._states;
            int length = fArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && f == fArr[i]) {
                    TShortFloatHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TShortFloatHashMap.this.containsValue(((Float) obj).floatValue())) {
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
                if (!TShortFloatHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TShortFloatHashMap.this.containsValue(f)) {
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
            float[] fArr2 = TShortFloatHashMap.this._values;
            byte[] bArr = TShortFloatHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TShortFloatHashMap.this.removeAt(i);
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
            TShortFloatHashMap.this.clear();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TShortFloatHashMap.this.forEachValue(tFloatProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TShortFloatHashMap.this.forEachValue(new TFloatProcedure() { // from class: gnu.trove.map.hash.TShortFloatHashMap.TValueView.1
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

    class TShortFloatKeyHashIterator extends THashPrimitiveIterator implements TShortIterator {
        TShortFloatKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            moveToNextIndex();
            return TShortFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TShortFloatValueHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TShortFloatValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TShortFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TShortFloatHashIterator extends THashPrimitiveIterator implements TShortFloatIterator {
        TShortFloatHashIterator(TShortFloatHashMap tShortFloatHashMap) {
            super(tShortFloatHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TShortFloatIterator
        public short key() {
            return TShortFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TShortFloatIterator
        public float value() {
            return TShortFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TShortFloatIterator
        public float setValue(float f) {
            float value = value();
            TShortFloatHashMap.this._values[this._index] = f;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortFloatHashMap.this.removeAt(this._index);
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
            boolean r0 = r10 instanceof gnu.trove.map.TShortFloatMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TShortFloatMap r10 = (gnu.trove.map.TShortFloatMap) r10
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
            short[] r5 = r9._set
            short r5 = r5[r6]
            boolean r7 = r10.containsKey(r5)
            if (r7 != 0) goto L34
            return r1
        L34:
            float r5 = r10.get(r5)
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TShortFloatHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TShortFloatProcedure() { // from class: gnu.trove.map.hash.TShortFloatHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TShortFloatProcedure
            public boolean execute(short s, float f) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) s);
                sb.append("=");
                sb.append(f);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TShortFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeFloat(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TShortFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readShort(), objectInput.readFloat());
            readInt = i;
        }
    }
}

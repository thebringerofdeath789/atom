package gnu.trove.map.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TFloatFloatHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TFloatFloatIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.map.TFloatFloatMap;
import gnu.trove.procedure.TFloatFloatProcedure;
import gnu.trove.procedure.TFloatProcedure;
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
public class TFloatFloatHashMap extends TFloatFloatHash implements TFloatFloatMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient float[] _values;

    public TFloatFloatHashMap() {
    }

    public TFloatFloatHashMap(int i) {
        super(i);
    }

    public TFloatFloatHashMap(int i, float f) {
        super(i, f);
    }

    public TFloatFloatHashMap(int i, float f, float f2, float f3) {
        super(i, f, f2, f3);
    }

    public TFloatFloatHashMap(float[] fArr, float[] fArr2) {
        super(Math.max(fArr.length, fArr2.length));
        int min = Math.min(fArr.length, fArr2.length);
        for (int i = 0; i < min; i++) {
            put(fArr[i], fArr2[i]);
        }
    }

    public TFloatFloatHashMap(TFloatFloatMap tFloatFloatMap) {
        super(tFloatFloatMap.size());
        if (tFloatFloatMap instanceof TFloatFloatHashMap) {
            TFloatFloatHashMap tFloatFloatHashMap = (TFloatFloatHashMap) tFloatFloatMap;
            this._loadFactor = Math.abs(tFloatFloatHashMap._loadFactor);
            this.no_entry_key = tFloatFloatHashMap.no_entry_key;
            this.no_entry_value = tFloatFloatHashMap.no_entry_value;
            if (this.no_entry_key != 0.0f) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tFloatFloatMap);
    }

    @Override // gnu.trove.impl.hash.TFloatFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new float[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        float[] fArr = this._set;
        float[] fArr2 = this._values;
        byte[] bArr = this._states;
        this._set = new float[i];
        this._values = new float[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(fArr[i2])] = fArr2[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float put(float f, float f2) {
        return doPut(f, f2, insertKey(f));
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float putIfAbsent(float f, float f2) {
        int insertKey = insertKey(f);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(f, f2, insertKey);
    }

    private float doPut(float f, float f2, int i) {
        float f3 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            f3 = this._values[i];
            z = false;
        }
        this._values[i] = f2;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f3;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void putAll(Map<? extends Float, ? extends Float> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Float, ? extends Float> entry : map.entrySet()) {
            put(entry.getKey().floatValue(), entry.getValue().floatValue());
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public void putAll(TFloatFloatMap tFloatFloatMap) {
        ensureCapacity(tFloatFloatMap.size());
        TFloatFloatIterator it = tFloatFloatMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float get(float f) {
        int index = index(f);
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

    @Override // gnu.trove.map.TFloatFloatMap
    public float remove(float f) {
        float f2 = this.no_entry_value;
        int index = index(f);
        if (index < 0) {
            return f2;
        }
        float f3 = this._values[index];
        removeAt(index);
        return f3;
    }

    @Override // gnu.trove.impl.hash.TFloatFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean containsKey(float f) {
        return contains(f);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public TFloatFloatIterator iterator() {
        return new TFloatFloatHashIterator(this);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return forEach(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean forEachEntry(TFloatFloatProcedure tFloatFloatProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        float[] fArr2 = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatFloatProcedure.execute(fArr[i], fArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
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

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean retainEntries(TFloatFloatProcedure tFloatFloatProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        float[] fArr2 = this._values;
        tempDisableAutoCompaction();
        try {
            int length = fArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tFloatFloatProcedure.execute(fArr[i], fArr2[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean increment(float f) {
        return adjustValue(f, 1.0f);
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public boolean adjustValue(float f, float f2) {
        int index = index(f);
        if (index < 0) {
            return false;
        }
        float[] fArr = this._values;
        fArr[index] = fArr[index] + f2;
        return true;
    }

    @Override // gnu.trove.map.TFloatFloatMap
    public float adjustOrPutValue(float f, float f2, float f3) {
        int insertKey = insertKey(f);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            float[] fArr = this._values;
            float f4 = f2 + fArr[insertKey];
            fArr[insertKey] = f4;
            z = false;
            f3 = f4;
        } else {
            this._values[insertKey] = f3;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return f3;
    }

    protected class TKeyView implements TFloatSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TFloatFloatHashMap tFloatFloatHashMap = TFloatFloatHashMap.this;
            return tFloatFloatHashMap.new TFloatFloatKeyHashIterator(tFloatFloatHashMap);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TFloatFloatHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int size() {
            return TFloatFloatHashMap.this._size;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TFloatFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TFloatFloatHashMap.this.contains(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray() {
            return TFloatFloatHashMap.this.keys();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TFloatFloatHashMap.this.keys(fArr);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean remove(float f) {
            return TFloatFloatHashMap.this.no_entry_value != TFloatFloatHashMap.this.remove(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TFloatFloatHashMap.this.containsKey(((Float) obj).floatValue())) {
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
                if (!TFloatFloatHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TFloatFloatHashMap.this.contains(f)) {
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
            float[] fArr2 = TFloatFloatHashMap.this._set;
            byte[] bArr = TFloatFloatHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TFloatFloatHashMap.this.removeAt(i);
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
            TFloatFloatHashMap.this.clear();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TFloatFloatHashMap.this.forEachKey(tFloatProcedure);
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
            int length = TFloatFloatHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TFloatFloatHashMap.this._states[i] == 1 && !tFloatSet.contains(TFloatFloatHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int hashCode() {
            int length = TFloatFloatHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TFloatFloatHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TFloatFloatHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatFloatHashMap.this.forEachKey(new TFloatProcedure() { // from class: gnu.trove.map.hash.TFloatFloatHashMap.TKeyView.1
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

    protected class TValueView implements TFloatCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TFloatFloatHashMap tFloatFloatHashMap = TFloatFloatHashMap.this;
            return tFloatFloatHashMap.new TFloatFloatValueHashIterator(tFloatFloatHashMap);
        }

        @Override // gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TFloatFloatHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TFloatCollection
        public int size() {
            return TFloatFloatHashMap.this._size;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TFloatFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TFloatFloatHashMap.this.containsValue(f);
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray() {
            return TFloatFloatHashMap.this.values();
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TFloatFloatHashMap.this.values(fArr);
        }

        @Override // gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean remove(float f) {
            float[] fArr = TFloatFloatHashMap.this._values;
            byte[] bArr = TFloatFloatHashMap.this._states;
            int length = fArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && f == fArr[i]) {
                    TFloatFloatHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TFloatFloatHashMap.this.containsValue(((Float) obj).floatValue())) {
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
                if (!TFloatFloatHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TFloatFloatHashMap.this.containsValue(f)) {
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
            float[] fArr2 = TFloatFloatHashMap.this._values;
            byte[] bArr = TFloatFloatHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TFloatFloatHashMap.this.removeAt(i);
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
            TFloatFloatHashMap.this.clear();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TFloatFloatHashMap.this.forEachValue(tFloatProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatFloatHashMap.this.forEachValue(new TFloatProcedure() { // from class: gnu.trove.map.hash.TFloatFloatHashMap.TValueView.1
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

    class TFloatFloatKeyHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TFloatFloatKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TFloatFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatFloatValueHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TFloatFloatValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TFloatFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatFloatHashIterator extends THashPrimitiveIterator implements TFloatFloatIterator {
        TFloatFloatHashIterator(TFloatFloatHashMap tFloatFloatHashMap) {
            super(tFloatFloatHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TFloatFloatIterator
        public float key() {
            return TFloatFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TFloatFloatIterator
        public float value() {
            return TFloatFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TFloatFloatIterator
        public float setValue(float f) {
            float value = value();
            TFloatFloatHashMap.this._values[this._index] = f;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatFloatHashMap.this.removeAt(this._index);
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
            boolean r0 = r10 instanceof gnu.trove.map.TFloatFloatMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TFloatFloatMap r10 = (gnu.trove.map.TFloatFloatMap) r10
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
            float[] r5 = r9._set
            r5 = r5[r6]
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TFloatFloatHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TFloatFloatProcedure() { // from class: gnu.trove.map.hash.TFloatFloatHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TFloatFloatProcedure
            public boolean execute(float f, float f2) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(f);
                sb.append("=");
                sb.append(f2);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TFloatFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeFloat(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TFloatFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readFloat(), objectInput.readFloat());
            readInt = i;
        }
    }
}
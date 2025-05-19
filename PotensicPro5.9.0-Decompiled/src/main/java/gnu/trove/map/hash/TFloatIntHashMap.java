package gnu.trove.map.hash;

import gnu.trove.TFloatCollection;
import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TFloatIntHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TFloatIntIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.map.TFloatIntMap;
import gnu.trove.procedure.TFloatIntProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.procedure.TIntProcedure;
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
public class TFloatIntHashMap extends TFloatIntHash implements TFloatIntMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient int[] _values;

    public TFloatIntHashMap() {
    }

    public TFloatIntHashMap(int i) {
        super(i);
    }

    public TFloatIntHashMap(int i, float f) {
        super(i, f);
    }

    public TFloatIntHashMap(int i, float f, float f2, int i2) {
        super(i, f, f2, i2);
    }

    public TFloatIntHashMap(float[] fArr, int[] iArr) {
        super(Math.max(fArr.length, iArr.length));
        int min = Math.min(fArr.length, iArr.length);
        for (int i = 0; i < min; i++) {
            put(fArr[i], iArr[i]);
        }
    }

    public TFloatIntHashMap(TFloatIntMap tFloatIntMap) {
        super(tFloatIntMap.size());
        if (tFloatIntMap instanceof TFloatIntHashMap) {
            TFloatIntHashMap tFloatIntHashMap = (TFloatIntHashMap) tFloatIntMap;
            this._loadFactor = Math.abs(tFloatIntHashMap._loadFactor);
            this.no_entry_key = tFloatIntHashMap.no_entry_key;
            this.no_entry_value = tFloatIntHashMap.no_entry_value;
            if (this.no_entry_key != 0.0f) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tFloatIntMap);
    }

    @Override // gnu.trove.impl.hash.TFloatIntHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new int[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        float[] fArr = this._set;
        int[] iArr = this._values;
        byte[] bArr = this._states;
        this._set = new float[i];
        this._values = new int[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(fArr[i2])] = iArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int put(float f, int i) {
        return doPut(f, i, insertKey(f));
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int putIfAbsent(float f, int i) {
        int insertKey = insertKey(f);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(f, i, insertKey);
    }

    private int doPut(float f, int i, int i2) {
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

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(Map<? extends Float, ? extends Integer> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Float, ? extends Integer> entry : map.entrySet()) {
            put(entry.getKey().floatValue(), entry.getValue().intValue());
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public void putAll(TFloatIntMap tFloatIntMap) {
        ensureCapacity(tFloatIntMap.size());
        TFloatIntIterator it = tFloatIntMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int get(float f) {
        int index = index(f);
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

    @Override // gnu.trove.map.TFloatIntMap
    public int remove(float f) {
        int i = this.no_entry_value;
        int index = index(f);
        if (index < 0) {
            return i;
        }
        int i2 = this._values[index];
        removeAt(index);
        return i2;
    }

    @Override // gnu.trove.impl.hash.TFloatIntHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
    public TIntCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
    public boolean containsKey(float f) {
        return contains(f);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public TFloatIntIterator iterator() {
        return new TFloatIntHashIterator(this);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return forEach(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
    public boolean forEachEntry(TFloatIntProcedure tFloatIntProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        int[] iArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatIntProcedure.execute(fArr[i], iArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
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

    @Override // gnu.trove.map.TFloatIntMap
    public boolean retainEntries(TFloatIntProcedure tFloatIntProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        int[] iArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = fArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tFloatIntProcedure.execute(fArr[i], iArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean increment(float f) {
        return adjustValue(f, 1);
    }

    @Override // gnu.trove.map.TFloatIntMap
    public boolean adjustValue(float f, int i) {
        int index = index(f);
        if (index < 0) {
            return false;
        }
        int[] iArr = this._values;
        iArr[index] = iArr[index] + i;
        return true;
    }

    @Override // gnu.trove.map.TFloatIntMap
    public int adjustOrPutValue(float f, int i, int i2) {
        int insertKey = insertKey(f);
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
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return i2;
    }

    protected class TKeyView implements TFloatSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TFloatIntHashMap tFloatIntHashMap = TFloatIntHashMap.this;
            return tFloatIntHashMap.new TFloatIntKeyHashIterator(tFloatIntHashMap);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TFloatIntHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int size() {
            return TFloatIntHashMap.this._size;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TFloatIntHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TFloatIntHashMap.this.contains(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray() {
            return TFloatIntHashMap.this.keys();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TFloatIntHashMap.this.keys(fArr);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean remove(float f) {
            return TFloatIntHashMap.this.no_entry_value != TFloatIntHashMap.this.remove(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TFloatIntHashMap.this.containsKey(((Float) obj).floatValue())) {
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
                if (!TFloatIntHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TFloatIntHashMap.this.contains(f)) {
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
            float[] fArr2 = TFloatIntHashMap.this._set;
            byte[] bArr = TFloatIntHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TFloatIntHashMap.this.removeAt(i);
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
            TFloatIntHashMap.this.clear();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TFloatIntHashMap.this.forEachKey(tFloatProcedure);
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
            int length = TFloatIntHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TFloatIntHashMap.this._states[i] == 1 && !tFloatSet.contains(TFloatIntHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int hashCode() {
            int length = TFloatIntHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TFloatIntHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TFloatIntHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatIntHashMap.this.forEachKey(new TFloatProcedure() { // from class: gnu.trove.map.hash.TFloatIntHashMap.TKeyView.1
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

    protected class TValueView implements TIntCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TIntCollection
        public TIntIterator iterator() {
            TFloatIntHashMap tFloatIntHashMap = TFloatIntHashMap.this;
            return tFloatIntHashMap.new TFloatIntValueHashIterator(tFloatIntHashMap);
        }

        @Override // gnu.trove.TIntCollection
        public int getNoEntryValue() {
            return TFloatIntHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TIntCollection
        public int size() {
            return TFloatIntHashMap.this._size;
        }

        @Override // gnu.trove.TIntCollection
        public boolean isEmpty() {
            return TFloatIntHashMap.this._size == 0;
        }

        @Override // gnu.trove.TIntCollection
        public boolean contains(int i) {
            return TFloatIntHashMap.this.containsValue(i);
        }

        @Override // gnu.trove.TIntCollection
        public int[] toArray() {
            return TFloatIntHashMap.this.values();
        }

        @Override // gnu.trove.TIntCollection
        public int[] toArray(int[] iArr) {
            return TFloatIntHashMap.this.values(iArr);
        }

        @Override // gnu.trove.TIntCollection
        public boolean add(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TIntCollection
        public boolean remove(int i) {
            int[] iArr = TFloatIntHashMap.this._values;
            byte[] bArr = TFloatIntHashMap.this._states;
            int length = iArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i2] != 0 && bArr[i2] != 2 && i == iArr[i2]) {
                    TFloatIntHashMap.this.removeAt(i2);
                    return true;
                }
                length = i2;
            }
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Integer) {
                    if (!TFloatIntHashMap.this.containsValue(((Integer) obj).intValue())) {
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
                if (!TFloatIntHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TIntCollection
        public boolean containsAll(int[] iArr) {
            for (int i : iArr) {
                if (!TFloatIntHashMap.this.containsValue(i)) {
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
            int[] iArr2 = TFloatIntHashMap.this._values;
            byte[] bArr = TFloatIntHashMap.this._states;
            int length = iArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
                    TFloatIntHashMap.this.removeAt(i);
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
            TFloatIntHashMap.this.clear();
        }

        @Override // gnu.trove.TIntCollection
        public boolean forEach(TIntProcedure tIntProcedure) {
            return TFloatIntHashMap.this.forEachValue(tIntProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatIntHashMap.this.forEachValue(new TIntProcedure() { // from class: gnu.trove.map.hash.TFloatIntHashMap.TValueView.1
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

    class TFloatIntKeyHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TFloatIntKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TFloatIntHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatIntHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatIntValueHashIterator extends THashPrimitiveIterator implements TIntIterator {
        TFloatIntValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
            moveToNextIndex();
            return TFloatIntHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatIntHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatIntHashIterator extends THashPrimitiveIterator implements TFloatIntIterator {
        TFloatIntHashIterator(TFloatIntHashMap tFloatIntHashMap) {
            super(tFloatIntHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TFloatIntIterator
        public float key() {
            return TFloatIntHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TFloatIntIterator
        public int value() {
            return TFloatIntHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TFloatIntIterator
        public int setValue(int i) {
            int value = value();
            TFloatIntHashMap.this._values[this._index] = i;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatIntHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TFloatIntMap)) {
            return false;
        }
        TFloatIntMap tFloatIntMap = (TFloatIntMap) obj;
        if (tFloatIntMap.size() != size()) {
            return false;
        }
        int[] iArr = this._values;
        byte[] bArr = this._states;
        int noEntryValue = getNoEntryValue();
        int noEntryValue2 = tFloatIntMap.getNoEntryValue();
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                float f = this._set[i];
                if (!tFloatIntMap.containsKey(f)) {
                    return false;
                }
                int i2 = tFloatIntMap.get(f);
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
                i += HashFunctions.hash(this._set[i2]) ^ HashFunctions.hash(this._values[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TFloatIntProcedure() { // from class: gnu.trove.map.hash.TFloatIntHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TFloatIntProcedure
            public boolean execute(float f, int i) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(f);
                sb.append("=");
                sb.append(i);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TFloatIntHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeInt(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TFloatIntHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readFloat(), objectInput.readInt());
            readInt = i;
        }
    }
}

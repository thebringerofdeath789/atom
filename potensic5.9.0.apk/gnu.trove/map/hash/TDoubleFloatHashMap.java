package gnu.trove.map.hash;

import gnu.trove.TDoubleCollection;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TDoubleFloatHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TDoubleFloatIterator;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.map.TDoubleFloatMap;
import gnu.trove.procedure.TDoubleFloatProcedure;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TDoubleSet;
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
public class TDoubleFloatHashMap extends TDoubleFloatHash implements TDoubleFloatMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient float[] _values;

    public TDoubleFloatHashMap() {
    }

    public TDoubleFloatHashMap(int i) {
        super(i);
    }

    public TDoubleFloatHashMap(int i, float f) {
        super(i, f);
    }

    public TDoubleFloatHashMap(int i, float f, double d, float f2) {
        super(i, f, d, f2);
    }

    public TDoubleFloatHashMap(double[] dArr, float[] fArr) {
        super(Math.max(dArr.length, fArr.length));
        int min = Math.min(dArr.length, fArr.length);
        for (int i = 0; i < min; i++) {
            put(dArr[i], fArr[i]);
        }
    }

    public TDoubleFloatHashMap(TDoubleFloatMap tDoubleFloatMap) {
        super(tDoubleFloatMap.size());
        if (tDoubleFloatMap instanceof TDoubleFloatHashMap) {
            TDoubleFloatHashMap tDoubleFloatHashMap = (TDoubleFloatHashMap) tDoubleFloatMap;
            this._loadFactor = Math.abs(tDoubleFloatHashMap._loadFactor);
            this.no_entry_key = tDoubleFloatHashMap.no_entry_key;
            this.no_entry_value = tDoubleFloatHashMap.no_entry_value;
            if (this.no_entry_key != 0.0d) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tDoubleFloatMap);
    }

    @Override // gnu.trove.impl.hash.TDoubleFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new float[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        double[] dArr = this._set;
        float[] fArr = this._values;
        byte[] bArr = this._states;
        this._set = new double[i];
        this._values = new float[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(dArr[i2])] = fArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float put(double d, float f) {
        return doPut(d, f, insertKey(d));
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float putIfAbsent(double d, float f) {
        int insertKey = insertKey(d);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(d, f, insertKey);
    }

    private float doPut(double d, float f, int i) {
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(Map<? extends Double, ? extends Float> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Double, ? extends Float> entry : map.entrySet()) {
            put(entry.getKey().doubleValue(), entry.getValue().floatValue());
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public void putAll(TDoubleFloatMap tDoubleFloatMap) {
        ensureCapacity(tDoubleFloatMap.size());
        TDoubleFloatIterator it = tDoubleFloatMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float get(double d) {
        int index = index(d);
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public float remove(double d) {
        float f = this.no_entry_value;
        int index = index(d);
        if (index < 0) {
            return f;
        }
        float f2 = this._values[index];
        removeAt(index);
        return f2;
    }

    @Override // gnu.trove.impl.hash.TDoubleFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys() {
        int size = size();
        double[] dArr = new double[size];
        if (size == 0) {
            return dArr;
        }
        double[] dArr2 = this._set;
        byte[] bArr = this._states;
        int length = dArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return dArr;
            }
            if (bArr[i2] == 1) {
                dArr[i] = dArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public double[] keys(double[] dArr) {
        int size = size();
        if (size == 0) {
            return dArr;
        }
        if (dArr.length < size) {
            dArr = new double[size];
        }
        double[] dArr2 = this._set;
        byte[] bArr = this._states;
        int length = dArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return dArr;
            }
            if (bArr[i2] == 1) {
                dArr[i] = dArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TFloatCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean containsKey(double d) {
        return contains(d);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public TDoubleFloatIterator iterator() {
        return new TDoubleFloatHashIterator(this);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return forEach(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean forEachEntry(TDoubleFloatProcedure tDoubleFloatProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        float[] fArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tDoubleFloatProcedure.execute(dArr[i], fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
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

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean retainEntries(TDoubleFloatProcedure tDoubleFloatProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        float[] fArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = dArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tDoubleFloatProcedure.execute(dArr[i], fArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean increment(double d) {
        return adjustValue(d, 1.0f);
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public boolean adjustValue(double d, float f) {
        int index = index(d);
        if (index < 0) {
            return false;
        }
        float[] fArr = this._values;
        fArr[index] = fArr[index] + f;
        return true;
    }

    @Override // gnu.trove.map.TDoubleFloatMap
    public float adjustOrPutValue(double d, float f, float f2) {
        int insertKey = insertKey(d);
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

    protected class TKeyView implements TDoubleSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public TDoubleIterator iterator() {
            TDoubleFloatHashMap tDoubleFloatHashMap = TDoubleFloatHashMap.this;
            return tDoubleFloatHashMap.new TDoubleFloatKeyHashIterator(tDoubleFloatHashMap);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double getNoEntryValue() {
            return TDoubleFloatHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public int size() {
            return TDoubleFloatHashMap.this._size;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean isEmpty() {
            return TDoubleFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean contains(double d) {
            return TDoubleFloatHashMap.this.contains(d);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double[] toArray() {
            return TDoubleFloatHashMap.this.keys();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double[] toArray(double[] dArr) {
            return TDoubleFloatHashMap.this.keys(dArr);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean add(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean remove(double d) {
            return TDoubleFloatHashMap.this.no_entry_value != TDoubleFloatHashMap.this.remove(d);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Double) {
                    if (!TDoubleFloatHashMap.this.containsKey(((Double) obj).doubleValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(TDoubleCollection tDoubleCollection) {
            TDoubleIterator it = tDoubleCollection.iterator();
            while (it.hasNext()) {
                if (!TDoubleFloatHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(double[] dArr) {
            for (double d : dArr) {
                if (!TDoubleFloatHashMap.this.contains(d)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean addAll(Collection<? extends Double> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean addAll(TDoubleCollection tDoubleCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean addAll(double[] dArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean retainAll(Collection<?> collection) {
            TDoubleIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Double.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean retainAll(TDoubleCollection tDoubleCollection) {
            boolean z = false;
            if (this == tDoubleCollection) {
                return false;
            }
            TDoubleIterator it = iterator();
            while (it.hasNext()) {
                if (!tDoubleCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean retainAll(double[] dArr) {
            Arrays.sort(dArr);
            double[] dArr2 = TDoubleFloatHashMap.this._set;
            byte[] bArr = TDoubleFloatHashMap.this._states;
            int length = dArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(dArr, dArr2[i]) < 0) {
                    TDoubleFloatHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Double) && remove(((Double) obj).doubleValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean removeAll(TDoubleCollection tDoubleCollection) {
            if (this == tDoubleCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TDoubleIterator it = tDoubleCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean removeAll(double[] dArr) {
            int length = dArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(dArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public void clear() {
            TDoubleFloatHashMap.this.clear();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean forEach(TDoubleProcedure tDoubleProcedure) {
            return TDoubleFloatHashMap.this.forEachKey(tDoubleProcedure);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TDoubleSet)) {
                return false;
            }
            TDoubleSet tDoubleSet = (TDoubleSet) obj;
            if (tDoubleSet.size() != size()) {
                return false;
            }
            int length = TDoubleFloatHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TDoubleFloatHashMap.this._states[i] == 1 && !tDoubleSet.contains(TDoubleFloatHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public int hashCode() {
            int length = TDoubleFloatHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TDoubleFloatHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TDoubleFloatHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TDoubleFloatHashMap.this.forEachKey(new TDoubleProcedure() { // from class: gnu.trove.map.hash.TDoubleFloatHashMap.TKeyView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TDoubleProcedure
                public boolean execute(double d) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(d);
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
            TDoubleFloatHashMap tDoubleFloatHashMap = TDoubleFloatHashMap.this;
            return tDoubleFloatHashMap.new TDoubleFloatValueHashIterator(tDoubleFloatHashMap);
        }

        @Override // gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TDoubleFloatHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TFloatCollection
        public int size() {
            return TDoubleFloatHashMap.this._size;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TDoubleFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TDoubleFloatHashMap.this.containsValue(f);
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray() {
            return TDoubleFloatHashMap.this.values();
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TDoubleFloatHashMap.this.values(fArr);
        }

        @Override // gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean remove(float f) {
            float[] fArr = TDoubleFloatHashMap.this._values;
            byte[] bArr = TDoubleFloatHashMap.this._states;
            int length = fArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && f == fArr[i]) {
                    TDoubleFloatHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TDoubleFloatHashMap.this.containsValue(((Float) obj).floatValue())) {
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
                if (!TDoubleFloatHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TDoubleFloatHashMap.this.containsValue(f)) {
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
            float[] fArr2 = TDoubleFloatHashMap.this._values;
            byte[] bArr = TDoubleFloatHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TDoubleFloatHashMap.this.removeAt(i);
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
            TDoubleFloatHashMap.this.clear();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TDoubleFloatHashMap.this.forEachValue(tFloatProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TDoubleFloatHashMap.this.forEachValue(new TFloatProcedure() { // from class: gnu.trove.map.hash.TDoubleFloatHashMap.TValueView.1
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

    class TDoubleFloatKeyHashIterator extends THashPrimitiveIterator implements TDoubleIterator {
        TDoubleFloatKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TDoubleIterator
        public double next() {
            moveToNextIndex();
            return TDoubleFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TDoubleFloatValueHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TDoubleFloatValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TDoubleFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TDoubleFloatHashIterator extends THashPrimitiveIterator implements TDoubleFloatIterator {
        TDoubleFloatHashIterator(TDoubleFloatHashMap tDoubleFloatHashMap) {
            super(tDoubleFloatHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TDoubleFloatIterator
        public double key() {
            return TDoubleFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TDoubleFloatIterator
        public float value() {
            return TDoubleFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TDoubleFloatIterator
        public float setValue(float f) {
            float value = value();
            TDoubleFloatHashMap.this._values[this._index] = f;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleFloatHashMap.this.removeAt(this._index);
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
            boolean r0 = r10 instanceof gnu.trove.map.TDoubleFloatMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TDoubleFloatMap r10 = (gnu.trove.map.TDoubleFloatMap) r10
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
            double[] r5 = r9._set
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TDoubleFloatHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TDoubleFloatProcedure() { // from class: gnu.trove.map.hash.TDoubleFloatHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TDoubleFloatProcedure
            public boolean execute(double d, float f) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(d);
                sb.append("=");
                sb.append(f);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TDoubleFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeDouble(this._set[i]);
                objectOutput.writeFloat(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TDoubleFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readDouble(), objectInput.readFloat());
            readInt = i;
        }
    }
}
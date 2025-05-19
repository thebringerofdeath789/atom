package gnu.trove.map.hash;

import gnu.trove.TDoubleCollection;
import gnu.trove.TIntCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TIntDoubleHash;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.iterator.TIntDoubleIterator;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.map.TIntDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TIntDoubleProcedure;
import gnu.trove.procedure.TIntProcedure;
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
public class TIntDoubleHashMap extends TIntDoubleHash implements TIntDoubleMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient double[] _values;

    public TIntDoubleHashMap() {
    }

    public TIntDoubleHashMap(int i) {
        super(i);
    }

    public TIntDoubleHashMap(int i, float f) {
        super(i, f);
    }

    public TIntDoubleHashMap(int i, float f, int i2, double d) {
        super(i, f, i2, d);
    }

    public TIntDoubleHashMap(int[] iArr, double[] dArr) {
        super(Math.max(iArr.length, dArr.length));
        int min = Math.min(iArr.length, dArr.length);
        for (int i = 0; i < min; i++) {
            put(iArr[i], dArr[i]);
        }
    }

    public TIntDoubleHashMap(TIntDoubleMap tIntDoubleMap) {
        super(tIntDoubleMap.size());
        if (tIntDoubleMap instanceof TIntDoubleHashMap) {
            TIntDoubleHashMap tIntDoubleHashMap = (TIntDoubleHashMap) tIntDoubleMap;
            this._loadFactor = Math.abs(tIntDoubleHashMap._loadFactor);
            this.no_entry_key = tIntDoubleHashMap.no_entry_key;
            this.no_entry_value = tIntDoubleHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0.0d) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tIntDoubleMap);
    }

    @Override // gnu.trove.impl.hash.TIntDoubleHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new double[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        int[] iArr = this._set;
        double[] dArr = this._values;
        byte[] bArr = this._states;
        this._set = new int[i];
        this._values = new double[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(iArr[i2])] = dArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double put(int i, double d) {
        return doPut(i, d, insertKey(i));
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double putIfAbsent(int i, double d) {
        int insertKey = insertKey(i);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(i, d, insertKey);
    }

    private double doPut(int i, double d, int i2) {
        double d2 = this.no_entry_value;
        boolean z = true;
        if (i2 < 0) {
            i2 = (-i2) - 1;
            d2 = this._values[i2];
            z = false;
        }
        this._values[i2] = d;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return d2;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void putAll(Map<? extends Integer, ? extends Double> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Integer, ? extends Double> entry : map.entrySet()) {
            put(entry.getKey().intValue(), entry.getValue().doubleValue());
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void putAll(TIntDoubleMap tIntDoubleMap) {
        ensureCapacity(tIntDoubleMap.size());
        TIntDoubleIterator it = tIntDoubleMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double get(int i) {
        int index = index(i);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        double[] dArr = this._values;
        Arrays.fill(dArr, 0, dArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double remove(int i) {
        double d = this.no_entry_value;
        int index = index(i);
        if (index < 0) {
            return d;
        }
        double d2 = this._values[index];
        removeAt(index);
        return d2;
    }

    @Override // gnu.trove.impl.hash.TIntDoubleHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TIntSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TIntDoubleMap
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

    @Override // gnu.trove.map.TIntDoubleMap
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

    @Override // gnu.trove.map.TIntDoubleMap
    public TDoubleCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double[] values() {
        int size = size();
        double[] dArr = new double[size];
        if (size == 0) {
            return dArr;
        }
        double[] dArr2 = this._values;
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

    @Override // gnu.trove.map.TIntDoubleMap
    public double[] values(double[] dArr) {
        int size = size();
        if (size == 0) {
            return dArr;
        }
        if (dArr.length < size) {
            dArr = new double[size];
        }
        double[] dArr2 = this._values;
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

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean containsValue(double d) {
        byte[] bArr = this._states;
        double[] dArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && d == dArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean containsKey(int i) {
        return contains(i);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public TIntDoubleIterator iterator() {
        return new TIntDoubleHashIterator(this);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return forEach(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tDoubleProcedure.execute(dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean forEachEntry(TIntDoubleProcedure tIntDoubleProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        double[] dArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tIntDoubleProcedure.execute(iArr[i], dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        byte[] bArr = this._states;
        double[] dArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                dArr[i] = tDoubleFunction.execute(dArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean retainEntries(TIntDoubleProcedure tIntDoubleProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        double[] dArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = iArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tIntDoubleProcedure.execute(iArr[i], dArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean increment(int i) {
        return adjustValue(i, 1.0d);
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public boolean adjustValue(int i, double d) {
        int index = index(i);
        if (index < 0) {
            return false;
        }
        double[] dArr = this._values;
        dArr[index] = dArr[index] + d;
        return true;
    }

    @Override // gnu.trove.map.TIntDoubleMap
    public double adjustOrPutValue(int i, double d, double d2) {
        int insertKey = insertKey(i);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            double[] dArr = this._values;
            double d3 = d + dArr[insertKey];
            dArr[insertKey] = d3;
            z = false;
            d2 = d3;
        } else {
            this._values[insertKey] = d2;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return d2;
    }

    protected class TKeyView implements TIntSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public TIntIterator iterator() {
            TIntDoubleHashMap tIntDoubleHashMap = TIntDoubleHashMap.this;
            return tIntDoubleHashMap.new TIntDoubleKeyHashIterator(tIntDoubleHashMap);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int getNoEntryValue() {
            return TIntDoubleHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int size() {
            return TIntDoubleHashMap.this._size;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean isEmpty() {
            return TIntDoubleHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean contains(int i) {
            return TIntDoubleHashMap.this.contains(i);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int[] toArray() {
            return TIntDoubleHashMap.this.keys();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int[] toArray(int[] iArr) {
            return TIntDoubleHashMap.this.keys(iArr);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean add(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean remove(int i) {
            return TIntDoubleHashMap.this.no_entry_value != TIntDoubleHashMap.this.remove(i);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Integer) {
                    if (!TIntDoubleHashMap.this.containsKey(((Integer) obj).intValue())) {
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
                if (!TIntDoubleHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(int[] iArr) {
            for (int i : iArr) {
                if (!TIntDoubleHashMap.this.contains(i)) {
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
            int[] iArr2 = TIntDoubleHashMap.this._set;
            byte[] bArr = TIntDoubleHashMap.this._states;
            int length = iArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
                    TIntDoubleHashMap.this.removeAt(i);
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
            TIntDoubleHashMap.this.clear();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean forEach(TIntProcedure tIntProcedure) {
            return TIntDoubleHashMap.this.forEachKey(tIntProcedure);
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
            int length = TIntDoubleHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TIntDoubleHashMap.this._states[i] == 1 && !tIntSet.contains(TIntDoubleHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int hashCode() {
            int length = TIntDoubleHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TIntDoubleHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TIntDoubleHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TIntDoubleHashMap.this.forEachKey(new TIntProcedure() { // from class: gnu.trove.map.hash.TIntDoubleHashMap.TKeyView.1
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

    protected class TValueView implements TDoubleCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TDoubleCollection
        public TDoubleIterator iterator() {
            TIntDoubleHashMap tIntDoubleHashMap = TIntDoubleHashMap.this;
            return tIntDoubleHashMap.new TIntDoubleValueHashIterator(tIntDoubleHashMap);
        }

        @Override // gnu.trove.TDoubleCollection
        public double getNoEntryValue() {
            return TIntDoubleHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TDoubleCollection
        public int size() {
            return TIntDoubleHashMap.this._size;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean isEmpty() {
            return TIntDoubleHashMap.this._size == 0;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean contains(double d) {
            return TIntDoubleHashMap.this.containsValue(d);
        }

        @Override // gnu.trove.TDoubleCollection
        public double[] toArray() {
            return TIntDoubleHashMap.this.values();
        }

        @Override // gnu.trove.TDoubleCollection
        public double[] toArray(double[] dArr) {
            return TIntDoubleHashMap.this.values(dArr);
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean add(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean remove(double d) {
            double[] dArr = TIntDoubleHashMap.this._values;
            byte[] bArr = TIntDoubleHashMap.this._states;
            int length = dArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && d == dArr[i]) {
                    TIntDoubleHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Double) {
                    if (!TIntDoubleHashMap.this.containsValue(((Double) obj).doubleValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean containsAll(TDoubleCollection tDoubleCollection) {
            TDoubleIterator it = tDoubleCollection.iterator();
            while (it.hasNext()) {
                if (!TIntDoubleHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean containsAll(double[] dArr) {
            for (double d : dArr) {
                if (!TIntDoubleHashMap.this.containsValue(d)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean addAll(Collection<? extends Double> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean addAll(TDoubleCollection tDoubleCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean addAll(double[] dArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TDoubleCollection
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

        @Override // gnu.trove.TDoubleCollection
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

        @Override // gnu.trove.TDoubleCollection
        public boolean retainAll(double[] dArr) {
            Arrays.sort(dArr);
            double[] dArr2 = TIntDoubleHashMap.this._values;
            byte[] bArr = TIntDoubleHashMap.this._states;
            int length = dArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(dArr, dArr2[i]) < 0) {
                    TIntDoubleHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Double) && remove(((Double) obj).doubleValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TDoubleCollection
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

        @Override // gnu.trove.TDoubleCollection
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

        @Override // gnu.trove.TDoubleCollection
        public void clear() {
            TIntDoubleHashMap.this.clear();
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean forEach(TDoubleProcedure tDoubleProcedure) {
            return TIntDoubleHashMap.this.forEachValue(tDoubleProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TIntDoubleHashMap.this.forEachValue(new TDoubleProcedure() { // from class: gnu.trove.map.hash.TIntDoubleHashMap.TValueView.1
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

    class TIntDoubleKeyHashIterator extends THashPrimitiveIterator implements TIntIterator {
        TIntDoubleKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
            moveToNextIndex();
            return TIntDoubleHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntDoubleHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TIntDoubleValueHashIterator extends THashPrimitiveIterator implements TDoubleIterator {
        TIntDoubleValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TDoubleIterator
        public double next() {
            moveToNextIndex();
            return TIntDoubleHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntDoubleHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TIntDoubleHashIterator extends THashPrimitiveIterator implements TIntDoubleIterator {
        TIntDoubleHashIterator(TIntDoubleHashMap tIntDoubleHashMap) {
            super(tIntDoubleHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TIntDoubleIterator
        public int key() {
            return TIntDoubleHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TIntDoubleIterator
        public double value() {
            return TIntDoubleHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TIntDoubleIterator
        public double setValue(double d) {
            double value = value();
            TIntDoubleHashMap.this._values[this._index] = d;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntDoubleHashMap.this.removeAt(this._index);
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
            boolean r0 = r14 instanceof gnu.trove.map.TIntDoubleMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TIntDoubleMap r14 = (gnu.trove.map.TIntDoubleMap) r14
            int r0 = r14.size()
            int r2 = r13.size()
            if (r0 == r2) goto L13
            return r1
        L13:
            double[] r0 = r13._values
            byte[] r2 = r13._states
            double r3 = r13.getNoEntryValue()
            double r5 = r14.getNoEntryValue()
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
            double r9 = r14.get(r7)
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TIntDoubleHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TIntDoubleProcedure() { // from class: gnu.trove.map.hash.TIntDoubleHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TIntDoubleProcedure
            public boolean execute(int i, double d) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(i);
                sb.append("=");
                sb.append(d);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TIntDoubleHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeDouble(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TIntDoubleHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readInt(), objectInput.readDouble());
            readInt = i;
        }
    }
}

package gnu.trove.map.hash;

import gnu.trove.TDoubleCollection;
import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TDoubleShortHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.iterator.TDoubleShortIterator;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.map.TDoubleShortMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TDoubleShortProcedure;
import gnu.trove.procedure.TShortProcedure;
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
public class TDoubleShortHashMap extends TDoubleShortHash implements TDoubleShortMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient short[] _values;

    public TDoubleShortHashMap() {
    }

    public TDoubleShortHashMap(int i) {
        super(i);
    }

    public TDoubleShortHashMap(int i, float f) {
        super(i, f);
    }

    public TDoubleShortHashMap(int i, float f, double d, short s) {
        super(i, f, d, s);
    }

    public TDoubleShortHashMap(double[] dArr, short[] sArr) {
        super(Math.max(dArr.length, sArr.length));
        int min = Math.min(dArr.length, sArr.length);
        for (int i = 0; i < min; i++) {
            put(dArr[i], sArr[i]);
        }
    }

    public TDoubleShortHashMap(TDoubleShortMap tDoubleShortMap) {
        super(tDoubleShortMap.size());
        if (tDoubleShortMap instanceof TDoubleShortHashMap) {
            TDoubleShortHashMap tDoubleShortHashMap = (TDoubleShortHashMap) tDoubleShortMap;
            this._loadFactor = Math.abs(tDoubleShortHashMap._loadFactor);
            this.no_entry_key = tDoubleShortHashMap.no_entry_key;
            this.no_entry_value = tDoubleShortHashMap.no_entry_value;
            if (this.no_entry_key != 0.0d) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tDoubleShortMap);
    }

    @Override // gnu.trove.impl.hash.TDoubleShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new short[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        double[] dArr = this._set;
        short[] sArr = this._values;
        byte[] bArr = this._states;
        this._set = new double[i];
        this._values = new short[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(dArr[i2])] = sArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short put(double d, short s) {
        return doPut(d, s, insertKey(d));
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short putIfAbsent(double d, short s) {
        int insertKey = insertKey(d);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(d, s, insertKey);
    }

    private short doPut(double d, short s, int i) {
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

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(Map<? extends Double, ? extends Short> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Double, ? extends Short> entry : map.entrySet()) {
            put(entry.getKey().doubleValue(), entry.getValue().shortValue());
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public void putAll(TDoubleShortMap tDoubleShortMap) {
        ensureCapacity(tDoubleShortMap.size());
        TDoubleShortIterator it = tDoubleShortMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short get(double d) {
        int index = index(d);
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

    @Override // gnu.trove.map.TDoubleShortMap
    public short remove(double d) {
        short s = this.no_entry_value;
        int index = index(d);
        if (index < 0) {
            return s;
        }
        short s2 = this._values[index];
        removeAt(index);
        return s2;
    }

    @Override // gnu.trove.impl.hash.TDoubleShortHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
    public TShortCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean containsKey(double d) {
        return contains(d);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public TDoubleShortIterator iterator() {
        return new TDoubleShortHashIterator(this);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return forEach(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean forEachEntry(TDoubleShortProcedure tDoubleShortProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        short[] sArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tDoubleShortProcedure.execute(dArr[i], sArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
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

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean retainEntries(TDoubleShortProcedure tDoubleShortProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        short[] sArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = dArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tDoubleShortProcedure.execute(dArr[i], sArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean increment(double d) {
        return adjustValue(d, (short) 1);
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public boolean adjustValue(double d, short s) {
        int index = index(d);
        if (index < 0) {
            return false;
        }
        short[] sArr = this._values;
        sArr[index] = (short) (sArr[index] + s);
        return true;
    }

    @Override // gnu.trove.map.TDoubleShortMap
    public short adjustOrPutValue(double d, short s, short s2) {
        int insertKey = insertKey(d);
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

    protected class TKeyView implements TDoubleSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public TDoubleIterator iterator() {
            TDoubleShortHashMap tDoubleShortHashMap = TDoubleShortHashMap.this;
            return tDoubleShortHashMap.new TDoubleShortKeyHashIterator(tDoubleShortHashMap);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double getNoEntryValue() {
            return TDoubleShortHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public int size() {
            return TDoubleShortHashMap.this._size;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean isEmpty() {
            return TDoubleShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean contains(double d) {
            return TDoubleShortHashMap.this.contains(d);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double[] toArray() {
            return TDoubleShortHashMap.this.keys();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double[] toArray(double[] dArr) {
            return TDoubleShortHashMap.this.keys(dArr);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean add(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean remove(double d) {
            return TDoubleShortHashMap.this.no_entry_value != TDoubleShortHashMap.this.remove(d);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Double) {
                    if (!TDoubleShortHashMap.this.containsKey(((Double) obj).doubleValue())) {
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
                if (!TDoubleShortHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(double[] dArr) {
            for (double d : dArr) {
                if (!TDoubleShortHashMap.this.contains(d)) {
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
            double[] dArr2 = TDoubleShortHashMap.this._set;
            byte[] bArr = TDoubleShortHashMap.this._states;
            int length = dArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(dArr, dArr2[i]) < 0) {
                    TDoubleShortHashMap.this.removeAt(i);
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
            TDoubleShortHashMap.this.clear();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean forEach(TDoubleProcedure tDoubleProcedure) {
            return TDoubleShortHashMap.this.forEachKey(tDoubleProcedure);
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
            int length = TDoubleShortHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TDoubleShortHashMap.this._states[i] == 1 && !tDoubleSet.contains(TDoubleShortHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public int hashCode() {
            int length = TDoubleShortHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TDoubleShortHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TDoubleShortHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TDoubleShortHashMap.this.forEachKey(new TDoubleProcedure() { // from class: gnu.trove.map.hash.TDoubleShortHashMap.TKeyView.1
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

    protected class TValueView implements TShortCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TShortCollection
        public TShortIterator iterator() {
            TDoubleShortHashMap tDoubleShortHashMap = TDoubleShortHashMap.this;
            return tDoubleShortHashMap.new TDoubleShortValueHashIterator(tDoubleShortHashMap);
        }

        @Override // gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TDoubleShortHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TShortCollection
        public int size() {
            return TDoubleShortHashMap.this._size;
        }

        @Override // gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TDoubleShortHashMap.this._size == 0;
        }

        @Override // gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TDoubleShortHashMap.this.containsValue(s);
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray() {
            return TDoubleShortHashMap.this.values();
        }

        @Override // gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TDoubleShortHashMap.this.values(sArr);
        }

        @Override // gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TShortCollection
        public boolean remove(short s) {
            short[] sArr = TDoubleShortHashMap.this._values;
            byte[] bArr = TDoubleShortHashMap.this._states;
            int length = sArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && s == sArr[i]) {
                    TDoubleShortHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TDoubleShortHashMap.this.containsValue(((Short) obj).shortValue())) {
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
                if (!TDoubleShortHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TDoubleShortHashMap.this.containsValue(s)) {
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
            short[] sArr2 = TDoubleShortHashMap.this._values;
            byte[] bArr = TDoubleShortHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TDoubleShortHashMap.this.removeAt(i);
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
            TDoubleShortHashMap.this.clear();
        }

        @Override // gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TDoubleShortHashMap.this.forEachValue(tShortProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TDoubleShortHashMap.this.forEachValue(new TShortProcedure() { // from class: gnu.trove.map.hash.TDoubleShortHashMap.TValueView.1
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

    class TDoubleShortKeyHashIterator extends THashPrimitiveIterator implements TDoubleIterator {
        TDoubleShortKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TDoubleIterator
        public double next() {
            moveToNextIndex();
            return TDoubleShortHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TDoubleShortValueHashIterator extends THashPrimitiveIterator implements TShortIterator {
        TDoubleShortValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            moveToNextIndex();
            return TDoubleShortHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TDoubleShortHashIterator extends THashPrimitiveIterator implements TDoubleShortIterator {
        TDoubleShortHashIterator(TDoubleShortHashMap tDoubleShortHashMap) {
            super(tDoubleShortHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TDoubleShortIterator
        public double key() {
            return TDoubleShortHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TDoubleShortIterator
        public short value() {
            return TDoubleShortHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TDoubleShortIterator
        public short setValue(short s) {
            short value = value();
            TDoubleShortHashMap.this._values[this._index] = s;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleShortHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TDoubleShortMap)) {
            return false;
        }
        TDoubleShortMap tDoubleShortMap = (TDoubleShortMap) obj;
        if (tDoubleShortMap.size() != size()) {
            return false;
        }
        short[] sArr = this._values;
        byte[] bArr = this._states;
        short noEntryValue = getNoEntryValue();
        short noEntryValue2 = tDoubleShortMap.getNoEntryValue();
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                double d = this._set[i];
                if (!tDoubleShortMap.containsKey(d)) {
                    return false;
                }
                short s = tDoubleShortMap.get(d);
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
        forEachEntry(new TDoubleShortProcedure() { // from class: gnu.trove.map.hash.TDoubleShortHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TDoubleShortProcedure
            public boolean execute(double d, short s) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(d);
                sb.append("=");
                sb.append((int) s);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TDoubleShortHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeShort(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TDoubleShortHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readDouble(), objectInput.readShort());
            readInt = i;
        }
    }
}

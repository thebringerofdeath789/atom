package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.TDoubleCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TDoubleCharHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TDoubleCharIterator;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.map.TDoubleCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TDoubleCharProcedure;
import gnu.trove.procedure.TDoubleProcedure;
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
public class TDoubleCharHashMap extends TDoubleCharHash implements TDoubleCharMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient char[] _values;

    public TDoubleCharHashMap() {
    }

    public TDoubleCharHashMap(int i) {
        super(i);
    }

    public TDoubleCharHashMap(int i, float f) {
        super(i, f);
    }

    public TDoubleCharHashMap(int i, float f, double d, char c) {
        super(i, f, d, c);
    }

    public TDoubleCharHashMap(double[] dArr, char[] cArr) {
        super(Math.max(dArr.length, cArr.length));
        int min = Math.min(dArr.length, cArr.length);
        for (int i = 0; i < min; i++) {
            put(dArr[i], cArr[i]);
        }
    }

    public TDoubleCharHashMap(TDoubleCharMap tDoubleCharMap) {
        super(tDoubleCharMap.size());
        if (tDoubleCharMap instanceof TDoubleCharHashMap) {
            TDoubleCharHashMap tDoubleCharHashMap = (TDoubleCharHashMap) tDoubleCharMap;
            this._loadFactor = Math.abs(tDoubleCharHashMap._loadFactor);
            this.no_entry_key = tDoubleCharHashMap.no_entry_key;
            this.no_entry_value = tDoubleCharHashMap.no_entry_value;
            if (this.no_entry_key != 0.0d) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tDoubleCharMap);
    }

    @Override // gnu.trove.impl.hash.TDoubleCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new char[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        double[] dArr = this._set;
        char[] cArr = this._values;
        byte[] bArr = this._states;
        this._set = new double[i];
        this._values = new char[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(dArr[i2])] = cArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char put(double d, char c) {
        return doPut(d, c, insertKey(d));
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char putIfAbsent(double d, char c) {
        int insertKey = insertKey(d);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(d, c, insertKey);
    }

    private char doPut(double d, char c, int i) {
        char c2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            c2 = this._values[i];
            z = false;
        }
        this._values[i] = c;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(Map<? extends Double, ? extends Character> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Double, ? extends Character> entry : map.entrySet()) {
            put(entry.getKey().doubleValue(), entry.getValue().charValue());
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void putAll(TDoubleCharMap tDoubleCharMap) {
        ensureCapacity(tDoubleCharMap.size());
        TDoubleCharIterator it = tDoubleCharMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char get(double d) {
        int index = index(d);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        char[] cArr = this._values;
        Arrays.fill(cArr, 0, cArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char remove(double d) {
        char c = this.no_entry_value;
        int index = index(d);
        if (index < 0) {
            return c;
        }
        char c2 = this._values[index];
        removeAt(index);
        return c2;
    }

    @Override // gnu.trove.impl.hash.TDoubleCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TDoubleCharMap
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

    @Override // gnu.trove.map.TDoubleCharMap
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

    @Override // gnu.trove.map.TDoubleCharMap
    public TCharCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values() {
        int size = size();
        char[] cArr = new char[size];
        if (size == 0) {
            return cArr;
        }
        char[] cArr2 = this._values;
        byte[] bArr = this._states;
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return cArr;
            }
            if (bArr[i2] == 1) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char[] values(char[] cArr) {
        int size = size();
        if (size == 0) {
            return cArr;
        }
        if (cArr.length < size) {
            cArr = new char[size];
        }
        char[] cArr2 = this._values;
        byte[] bArr = this._states;
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return cArr;
            }
            if (bArr[i2] == 1) {
                cArr[i] = cArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsValue(char c) {
        byte[] bArr = this._states;
        char[] cArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && c == cArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean containsKey(double d) {
        return contains(d);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public TDoubleCharIterator iterator() {
        return new TDoubleCharHashIterator(this);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachKey(TDoubleProcedure tDoubleProcedure) {
        return forEach(tDoubleProcedure);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachValue(TCharProcedure tCharProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tCharProcedure.execute(cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean forEachEntry(TDoubleCharProcedure tDoubleCharProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        char[] cArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tDoubleCharProcedure.execute(dArr[i], cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public void transformValues(TCharFunction tCharFunction) {
        byte[] bArr = this._states;
        char[] cArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                cArr[i] = tCharFunction.execute(cArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean retainEntries(TDoubleCharProcedure tDoubleCharProcedure) {
        byte[] bArr = this._states;
        double[] dArr = this._set;
        char[] cArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = dArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tDoubleCharProcedure.execute(dArr[i], cArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean increment(double d) {
        return adjustValue(d, (char) 1);
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public boolean adjustValue(double d, char c) {
        int index = index(d);
        if (index < 0) {
            return false;
        }
        char[] cArr = this._values;
        cArr[index] = (char) (cArr[index] + c);
        return true;
    }

    @Override // gnu.trove.map.TDoubleCharMap
    public char adjustOrPutValue(double d, char c, char c2) {
        int insertKey = insertKey(d);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            char[] cArr = this._values;
            c2 = (char) (cArr[insertKey] + c);
            cArr[insertKey] = c2;
            z = false;
        } else {
            this._values[insertKey] = c2;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    protected class TKeyView implements TDoubleSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public TDoubleIterator iterator() {
            TDoubleCharHashMap tDoubleCharHashMap = TDoubleCharHashMap.this;
            return tDoubleCharHashMap.new TDoubleCharKeyHashIterator(tDoubleCharHashMap);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double getNoEntryValue() {
            return TDoubleCharHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public int size() {
            return TDoubleCharHashMap.this._size;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean isEmpty() {
            return TDoubleCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean contains(double d) {
            return TDoubleCharHashMap.this.contains(d);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double[] toArray() {
            return TDoubleCharHashMap.this.keys();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public double[] toArray(double[] dArr) {
            return TDoubleCharHashMap.this.keys(dArr);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean add(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean remove(double d) {
            return TDoubleCharHashMap.this.no_entry_value != TDoubleCharHashMap.this.remove(d);
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Double) {
                    if (!TDoubleCharHashMap.this.containsKey(((Double) obj).doubleValue())) {
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
                if (!TDoubleCharHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean containsAll(double[] dArr) {
            for (double d : dArr) {
                if (!TDoubleCharHashMap.this.contains(d)) {
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
            double[] dArr2 = TDoubleCharHashMap.this._set;
            byte[] bArr = TDoubleCharHashMap.this._states;
            int length = dArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(dArr, dArr2[i]) < 0) {
                    TDoubleCharHashMap.this.removeAt(i);
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
            TDoubleCharHashMap.this.clear();
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public boolean forEach(TDoubleProcedure tDoubleProcedure) {
            return TDoubleCharHashMap.this.forEachKey(tDoubleProcedure);
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
            int length = TDoubleCharHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TDoubleCharHashMap.this._states[i] == 1 && !tDoubleSet.contains(TDoubleCharHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TDoubleSet, gnu.trove.TDoubleCollection
        public int hashCode() {
            int length = TDoubleCharHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TDoubleCharHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TDoubleCharHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TDoubleCharHashMap.this.forEachKey(new TDoubleProcedure() { // from class: gnu.trove.map.hash.TDoubleCharHashMap.TKeyView.1
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

    protected class TValueView implements TCharCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TCharCollection
        public TCharIterator iterator() {
            TDoubleCharHashMap tDoubleCharHashMap = TDoubleCharHashMap.this;
            return tDoubleCharHashMap.new TDoubleCharValueHashIterator(tDoubleCharHashMap);
        }

        @Override // gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TDoubleCharHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TCharCollection
        public int size() {
            return TDoubleCharHashMap.this._size;
        }

        @Override // gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TDoubleCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TDoubleCharHashMap.this.containsValue(c);
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray() {
            return TDoubleCharHashMap.this.values();
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TDoubleCharHashMap.this.values(cArr);
        }

        @Override // gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean remove(char c) {
            char[] cArr = TDoubleCharHashMap.this._values;
            byte[] bArr = TDoubleCharHashMap.this._states;
            int length = cArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && c == cArr[i]) {
                    TDoubleCharHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TDoubleCharHashMap.this.containsValue(((Character) obj).charValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(TCharCollection tCharCollection) {
            TCharIterator it = tCharCollection.iterator();
            while (it.hasNext()) {
                if (!TDoubleCharHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TDoubleCharHashMap.this.containsValue(c)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean addAll(Collection<? extends Character> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean addAll(TCharCollection tCharCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean addAll(char[] cArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean retainAll(Collection<?> collection) {
            TCharIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Character.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean retainAll(TCharCollection tCharCollection) {
            boolean z = false;
            if (this == tCharCollection) {
                return false;
            }
            TCharIterator it = iterator();
            while (it.hasNext()) {
                if (!tCharCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean retainAll(char[] cArr) {
            Arrays.sort(cArr);
            char[] cArr2 = TDoubleCharHashMap.this._values;
            byte[] bArr = TDoubleCharHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TDoubleCharHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Character) && remove(((Character) obj).charValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean removeAll(TCharCollection tCharCollection) {
            if (this == tCharCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TCharIterator it = tCharCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TCharCollection
        public boolean removeAll(char[] cArr) {
            int length = cArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(cArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public void clear() {
            TDoubleCharHashMap.this.clear();
        }

        @Override // gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TDoubleCharHashMap.this.forEachValue(tCharProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TDoubleCharHashMap.this.forEachValue(new TCharProcedure() { // from class: gnu.trove.map.hash.TDoubleCharHashMap.TValueView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TCharProcedure
                public boolean execute(char c) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(c);
                    return true;
                }
            });
            sb.append(StringSubstitutor.DEFAULT_VAR_END);
            return sb.toString();
        }
    }

    class TDoubleCharKeyHashIterator extends THashPrimitiveIterator implements TDoubleIterator {
        TDoubleCharKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TDoubleIterator
        public double next() {
            moveToNextIndex();
            return TDoubleCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TDoubleCharValueHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TDoubleCharValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TDoubleCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TDoubleCharHashIterator extends THashPrimitiveIterator implements TDoubleCharIterator {
        TDoubleCharHashIterator(TDoubleCharHashMap tDoubleCharHashMap) {
            super(tDoubleCharHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TDoubleCharIterator
        public double key() {
            return TDoubleCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TDoubleCharIterator
        public char value() {
            return TDoubleCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TDoubleCharIterator
        public char setValue(char c) {
            char value = value();
            TDoubleCharHashMap.this._values[this._index] = c;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TDoubleCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TDoubleCharMap)) {
            return false;
        }
        TDoubleCharMap tDoubleCharMap = (TDoubleCharMap) obj;
        if (tDoubleCharMap.size() != size()) {
            return false;
        }
        char[] cArr = this._values;
        byte[] bArr = this._states;
        char noEntryValue = getNoEntryValue();
        char noEntryValue2 = tDoubleCharMap.getNoEntryValue();
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                double d = this._set[i];
                if (!tDoubleCharMap.containsKey(d)) {
                    return false;
                }
                char c = tDoubleCharMap.get(d);
                char c2 = cArr[i];
                if (c2 != c && (c2 != noEntryValue || c != noEntryValue2)) {
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
        forEachEntry(new TDoubleCharProcedure() { // from class: gnu.trove.map.hash.TDoubleCharHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TDoubleCharProcedure
            public boolean execute(double d, char c) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(d);
                sb.append("=");
                sb.append(c);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TDoubleCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeChar(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TDoubleCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readDouble(), objectInput.readChar());
            readInt = i;
        }
    }
}
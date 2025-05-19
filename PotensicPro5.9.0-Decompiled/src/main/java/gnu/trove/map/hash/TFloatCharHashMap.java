package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TFloatCharHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TFloatCharIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.map.TFloatCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatCharProcedure;
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
public class TFloatCharHashMap extends TFloatCharHash implements TFloatCharMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient char[] _values;

    public TFloatCharHashMap() {
    }

    public TFloatCharHashMap(int i) {
        super(i);
    }

    public TFloatCharHashMap(int i, float f) {
        super(i, f);
    }

    public TFloatCharHashMap(int i, float f, float f2, char c) {
        super(i, f, f2, c);
    }

    public TFloatCharHashMap(float[] fArr, char[] cArr) {
        super(Math.max(fArr.length, cArr.length));
        int min = Math.min(fArr.length, cArr.length);
        for (int i = 0; i < min; i++) {
            put(fArr[i], cArr[i]);
        }
    }

    public TFloatCharHashMap(TFloatCharMap tFloatCharMap) {
        super(tFloatCharMap.size());
        if (tFloatCharMap instanceof TFloatCharHashMap) {
            TFloatCharHashMap tFloatCharHashMap = (TFloatCharHashMap) tFloatCharMap;
            this._loadFactor = Math.abs(tFloatCharHashMap._loadFactor);
            this.no_entry_key = tFloatCharHashMap.no_entry_key;
            this.no_entry_value = tFloatCharHashMap.no_entry_value;
            if (this.no_entry_key != 0.0f) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tFloatCharMap);
    }

    @Override // gnu.trove.impl.hash.TFloatCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new char[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        float[] fArr = this._set;
        char[] cArr = this._values;
        byte[] bArr = this._states;
        this._set = new float[i];
        this._values = new char[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(fArr[i2])] = cArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char put(float f, char c) {
        return doPut(f, c, insertKey(f));
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char putIfAbsent(float f, char c) {
        int insertKey = insertKey(f);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(f, c, insertKey);
    }

    private char doPut(float f, char c, int i) {
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

    @Override // gnu.trove.map.TFloatCharMap
    public void putAll(Map<? extends Float, ? extends Character> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Float, ? extends Character> entry : map.entrySet()) {
            put(entry.getKey().floatValue(), entry.getValue().charValue());
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public void putAll(TFloatCharMap tFloatCharMap) {
        ensureCapacity(tFloatCharMap.size());
        TFloatCharIterator it = tFloatCharMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char get(float f) {
        int index = index(f);
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

    @Override // gnu.trove.map.TFloatCharMap
    public char remove(float f) {
        char c = this.no_entry_value;
        int index = index(f);
        if (index < 0) {
            return c;
        }
        char c2 = this._values[index];
        removeAt(index);
        return c2;
    }

    @Override // gnu.trove.impl.hash.TFloatCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TFloatSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
    public TCharCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
    public boolean containsKey(float f) {
        return contains(f);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public TFloatCharIterator iterator() {
        return new TFloatCharHashIterator(this);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachKey(TFloatProcedure tFloatProcedure) {
        return forEach(tFloatProcedure);
    }

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
    public boolean forEachEntry(TFloatCharProcedure tFloatCharProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        char[] cArr = this._values;
        int length = fArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tFloatCharProcedure.execute(fArr[i], cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
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

    @Override // gnu.trove.map.TFloatCharMap
    public boolean retainEntries(TFloatCharProcedure tFloatCharProcedure) {
        byte[] bArr = this._states;
        float[] fArr = this._set;
        char[] cArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = fArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tFloatCharProcedure.execute(fArr[i], cArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean increment(float f) {
        return adjustValue(f, (char) 1);
    }

    @Override // gnu.trove.map.TFloatCharMap
    public boolean adjustValue(float f, char c) {
        int index = index(f);
        if (index < 0) {
            return false;
        }
        char[] cArr = this._values;
        cArr[index] = (char) (cArr[index] + c);
        return true;
    }

    @Override // gnu.trove.map.TFloatCharMap
    public char adjustOrPutValue(float f, char c, char c2) {
        int insertKey = insertKey(f);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            char[] cArr = this._values;
            char c3 = (char) (cArr[insertKey] + c);
            cArr[insertKey] = c3;
            z = false;
            c2 = c3;
        } else {
            this._values[insertKey] = c2;
        }
        byte b = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    protected class TKeyView implements TFloatSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TFloatCharHashMap tFloatCharHashMap = TFloatCharHashMap.this;
            return tFloatCharHashMap.new TFloatCharKeyHashIterator(tFloatCharHashMap);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TFloatCharHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int size() {
            return TFloatCharHashMap.this._size;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TFloatCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TFloatCharHashMap.this.contains(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray() {
            return TFloatCharHashMap.this.keys();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TFloatCharHashMap.this.keys(fArr);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean remove(float f) {
            return TFloatCharHashMap.this.no_entry_value != TFloatCharHashMap.this.remove(f);
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TFloatCharHashMap.this.containsKey(((Float) obj).floatValue())) {
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
                if (!TFloatCharHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TFloatCharHashMap.this.contains(f)) {
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
            float[] fArr2 = TFloatCharHashMap.this._set;
            byte[] bArr = TFloatCharHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TFloatCharHashMap.this.removeAt(i);
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
            TFloatCharHashMap.this.clear();
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TFloatCharHashMap.this.forEachKey(tFloatProcedure);
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
            int length = TFloatCharHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TFloatCharHashMap.this._states[i] == 1 && !tFloatSet.contains(TFloatCharHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TFloatSet, gnu.trove.TFloatCollection
        public int hashCode() {
            int length = TFloatCharHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TFloatCharHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TFloatCharHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatCharHashMap.this.forEachKey(new TFloatProcedure() { // from class: gnu.trove.map.hash.TFloatCharHashMap.TKeyView.1
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

    protected class TValueView implements TCharCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TCharCollection
        public TCharIterator iterator() {
            TFloatCharHashMap tFloatCharHashMap = TFloatCharHashMap.this;
            return tFloatCharHashMap.new TFloatCharValueHashIterator(tFloatCharHashMap);
        }

        @Override // gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TFloatCharHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TCharCollection
        public int size() {
            return TFloatCharHashMap.this._size;
        }

        @Override // gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TFloatCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TFloatCharHashMap.this.containsValue(c);
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray() {
            return TFloatCharHashMap.this.values();
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TFloatCharHashMap.this.values(cArr);
        }

        @Override // gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean remove(char c) {
            char[] cArr = TFloatCharHashMap.this._values;
            byte[] bArr = TFloatCharHashMap.this._states;
            int length = cArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && c == cArr[i]) {
                    TFloatCharHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TFloatCharHashMap.this.containsValue(((Character) obj).charValue())) {
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
                if (!TFloatCharHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TFloatCharHashMap.this.containsValue(c)) {
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
            char[] cArr2 = TFloatCharHashMap.this._values;
            byte[] bArr = TFloatCharHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TFloatCharHashMap.this.removeAt(i);
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
            TFloatCharHashMap.this.clear();
        }

        @Override // gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TFloatCharHashMap.this.forEachValue(tCharProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TFloatCharHashMap.this.forEachValue(new TCharProcedure() { // from class: gnu.trove.map.hash.TFloatCharHashMap.TValueView.1
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

    class TFloatCharKeyHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TFloatCharKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TFloatCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatCharValueHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TFloatCharValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TFloatCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TFloatCharHashIterator extends THashPrimitiveIterator implements TFloatCharIterator {
        TFloatCharHashIterator(TFloatCharHashMap tFloatCharHashMap) {
            super(tFloatCharHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TFloatCharIterator
        public float key() {
            return TFloatCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TFloatCharIterator
        public char value() {
            return TFloatCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TFloatCharIterator
        public char setValue(char c) {
            char value = value();
            TFloatCharHashMap.this._values[this._index] = c;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TFloatCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TFloatCharMap)) {
            return false;
        }
        TFloatCharMap tFloatCharMap = (TFloatCharMap) obj;
        if (tFloatCharMap.size() != size()) {
            return false;
        }
        char[] cArr = this._values;
        byte[] bArr = this._states;
        char noEntryValue = getNoEntryValue();
        char noEntryValue2 = tFloatCharMap.getNoEntryValue();
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                float f = this._set[i];
                if (!tFloatCharMap.containsKey(f)) {
                    return false;
                }
                char c = tFloatCharMap.get(f);
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
        forEachEntry(new TFloatCharProcedure() { // from class: gnu.trove.map.hash.TFloatCharHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TFloatCharProcedure
            public boolean execute(float f, char c) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(f);
                sb.append("=");
                sb.append(c);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TFloatCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeChar(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TFloatCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readFloat(), objectInput.readChar());
            readInt = i;
        }
    }
}

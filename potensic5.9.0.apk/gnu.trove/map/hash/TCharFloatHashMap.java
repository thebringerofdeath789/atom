package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.TFloatCollection;
import gnu.trove.function.TFloatFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCharFloatHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TCharFloatIterator;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TFloatIterator;
import gnu.trove.map.TCharFloatMap;
import gnu.trove.procedure.TCharFloatProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TFloatProcedure;
import gnu.trove.set.TCharSet;
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
public class TCharFloatHashMap extends TCharFloatHash implements TCharFloatMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient float[] _values;

    public TCharFloatHashMap() {
    }

    public TCharFloatHashMap(int i) {
        super(i);
    }

    public TCharFloatHashMap(int i, float f) {
        super(i, f);
    }

    public TCharFloatHashMap(int i, float f, char c, float f2) {
        super(i, f, c, f2);
    }

    public TCharFloatHashMap(char[] cArr, float[] fArr) {
        super(Math.max(cArr.length, fArr.length));
        int min = Math.min(cArr.length, fArr.length);
        for (int i = 0; i < min; i++) {
            put(cArr[i], fArr[i]);
        }
    }

    public TCharFloatHashMap(TCharFloatMap tCharFloatMap) {
        super(tCharFloatMap.size());
        if (tCharFloatMap instanceof TCharFloatHashMap) {
            TCharFloatHashMap tCharFloatHashMap = (TCharFloatHashMap) tCharFloatMap;
            this._loadFactor = Math.abs(tCharFloatHashMap._loadFactor);
            this.no_entry_key = tCharFloatHashMap.no_entry_key;
            this.no_entry_value = tCharFloatHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0.0f) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tCharFloatMap);
    }

    @Override // gnu.trove.impl.hash.TCharFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new float[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        char[] cArr = this._set;
        float[] fArr = this._values;
        byte[] bArr = this._states;
        this._set = new char[i];
        this._values = new float[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(cArr[i2])] = fArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float put(char c, float f) {
        return doPut(c, f, insertKey(c));
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float putIfAbsent(char c, float f) {
        int insertKey = insertKey(c);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(c, f, insertKey);
    }

    private float doPut(char c, float f, int i) {
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

    @Override // gnu.trove.map.TCharFloatMap
    public void putAll(Map<? extends Character, ? extends Float> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Character, ? extends Float> entry : map.entrySet()) {
            put(entry.getKey().charValue(), entry.getValue().floatValue());
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public void putAll(TCharFloatMap tCharFloatMap) {
        ensureCapacity(tCharFloatMap.size());
        TCharFloatIterator it = tCharFloatMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float get(char c) {
        int index = index(c);
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

    @Override // gnu.trove.map.TCharFloatMap
    public float remove(char c) {
        float f = this.no_entry_value;
        int index = index(c);
        if (index < 0) {
            return f;
        }
        float f2 = this._values[index];
        removeAt(index);
        return f2;
    }

    @Override // gnu.trove.impl.hash.TCharFloatHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TCharSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TCharFloatMap
    public char[] keys() {
        int size = size();
        char[] cArr = new char[size];
        if (size == 0) {
            return cArr;
        }
        char[] cArr2 = this._set;
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

    @Override // gnu.trove.map.TCharFloatMap
    public char[] keys(char[] cArr) {
        int size = size();
        if (size == 0) {
            return cArr;
        }
        if (cArr.length < size) {
            cArr = new char[size];
        }
        char[] cArr2 = this._set;
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

    @Override // gnu.trove.map.TCharFloatMap
    public TFloatCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TCharFloatMap
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

    @Override // gnu.trove.map.TCharFloatMap
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

    @Override // gnu.trove.map.TCharFloatMap
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

    @Override // gnu.trove.map.TCharFloatMap
    public boolean containsKey(char c) {
        return contains(c);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public TCharFloatIterator iterator() {
        return new TCharFloatHashIterator(this);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return forEach(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharFloatMap
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

    @Override // gnu.trove.map.TCharFloatMap
    public boolean forEachEntry(TCharFloatProcedure tCharFloatProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        float[] fArr = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tCharFloatProcedure.execute(cArr[i], fArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
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

    @Override // gnu.trove.map.TCharFloatMap
    public boolean retainEntries(TCharFloatProcedure tCharFloatProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        float[] fArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = cArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tCharFloatProcedure.execute(cArr[i], fArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean increment(char c) {
        return adjustValue(c, 1.0f);
    }

    @Override // gnu.trove.map.TCharFloatMap
    public boolean adjustValue(char c, float f) {
        int index = index(c);
        if (index < 0) {
            return false;
        }
        float[] fArr = this._values;
        fArr[index] = fArr[index] + f;
        return true;
    }

    @Override // gnu.trove.map.TCharFloatMap
    public float adjustOrPutValue(char c, float f, float f2) {
        int insertKey = insertKey(c);
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

    protected class TKeyView implements TCharSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public TCharIterator iterator() {
            TCharFloatHashMap tCharFloatHashMap = TCharFloatHashMap.this;
            return tCharFloatHashMap.new TCharFloatKeyHashIterator(tCharFloatHashMap);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TCharFloatHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public int size() {
            return TCharFloatHashMap.this._size;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TCharFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TCharFloatHashMap.this.contains(c);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char[] toArray() {
            return TCharFloatHashMap.this.keys();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TCharFloatHashMap.this.keys(cArr);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean remove(char c) {
            return TCharFloatHashMap.this.no_entry_value != TCharFloatHashMap.this.remove(c);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TCharFloatHashMap.this.containsKey(((Character) obj).charValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(TCharCollection tCharCollection) {
            TCharIterator it = tCharCollection.iterator();
            while (it.hasNext()) {
                if (!TCharFloatHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TCharFloatHashMap.this.contains(c)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean addAll(Collection<? extends Character> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean addAll(TCharCollection tCharCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean addAll(char[] cArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean retainAll(char[] cArr) {
            Arrays.sort(cArr);
            char[] cArr2 = TCharFloatHashMap.this._set;
            byte[] bArr = TCharFloatHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TCharFloatHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Character) && remove(((Character) obj).charValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
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

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public void clear() {
            TCharFloatHashMap.this.clear();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TCharFloatHashMap.this.forEachKey(tCharProcedure);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TCharSet)) {
                return false;
            }
            TCharSet tCharSet = (TCharSet) obj;
            if (tCharSet.size() != size()) {
                return false;
            }
            int length = TCharFloatHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TCharFloatHashMap.this._states[i] == 1 && !tCharSet.contains(TCharFloatHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public int hashCode() {
            int length = TCharFloatHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TCharFloatHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TCharFloatHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TCharFloatHashMap.this.forEachKey(new TCharProcedure() { // from class: gnu.trove.map.hash.TCharFloatHashMap.TKeyView.1
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

    protected class TValueView implements TFloatCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TFloatCollection
        public TFloatIterator iterator() {
            TCharFloatHashMap tCharFloatHashMap = TCharFloatHashMap.this;
            return tCharFloatHashMap.new TCharFloatValueHashIterator(tCharFloatHashMap);
        }

        @Override // gnu.trove.TFloatCollection
        public float getNoEntryValue() {
            return TCharFloatHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TFloatCollection
        public int size() {
            return TCharFloatHashMap.this._size;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean isEmpty() {
            return TCharFloatHashMap.this._size == 0;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean contains(float f) {
            return TCharFloatHashMap.this.containsValue(f);
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray() {
            return TCharFloatHashMap.this.values();
        }

        @Override // gnu.trove.TFloatCollection
        public float[] toArray(float[] fArr) {
            return TCharFloatHashMap.this.values(fArr);
        }

        @Override // gnu.trove.TFloatCollection
        public boolean add(float f) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean remove(float f) {
            float[] fArr = TCharFloatHashMap.this._values;
            byte[] bArr = TCharFloatHashMap.this._states;
            int length = fArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && f == fArr[i]) {
                    TCharFloatHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Float) {
                    if (!TCharFloatHashMap.this.containsValue(((Float) obj).floatValue())) {
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
                if (!TCharFloatHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TFloatCollection
        public boolean containsAll(float[] fArr) {
            for (float f : fArr) {
                if (!TCharFloatHashMap.this.containsValue(f)) {
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
            float[] fArr2 = TCharFloatHashMap.this._values;
            byte[] bArr = TCharFloatHashMap.this._states;
            int length = fArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(fArr, fArr2[i]) < 0) {
                    TCharFloatHashMap.this.removeAt(i);
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
            TCharFloatHashMap.this.clear();
        }

        @Override // gnu.trove.TFloatCollection
        public boolean forEach(TFloatProcedure tFloatProcedure) {
            return TCharFloatHashMap.this.forEachValue(tFloatProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TCharFloatHashMap.this.forEachValue(new TFloatProcedure() { // from class: gnu.trove.map.hash.TCharFloatHashMap.TValueView.1
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

    class TCharFloatKeyHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TCharFloatKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TCharFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TCharFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TCharFloatValueHashIterator extends THashPrimitiveIterator implements TFloatIterator {
        TCharFloatValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TFloatIterator
        public float next() {
            moveToNextIndex();
            return TCharFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TCharFloatHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TCharFloatHashIterator extends THashPrimitiveIterator implements TCharFloatIterator {
        TCharFloatHashIterator(TCharFloatHashMap tCharFloatHashMap) {
            super(tCharFloatHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TCharFloatIterator
        public char key() {
            return TCharFloatHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TCharFloatIterator
        public float value() {
            return TCharFloatHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TCharFloatIterator
        public float setValue(float f) {
            float value = value();
            TCharFloatHashMap.this._values[this._index] = f;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TCharFloatHashMap.this.removeAt(this._index);
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
            boolean r0 = r10 instanceof gnu.trove.map.TCharFloatMap
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            gnu.trove.map.TCharFloatMap r10 = (gnu.trove.map.TCharFloatMap) r10
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
            char[] r5 = r9._set
            char r5 = r5[r6]
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
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.map.hash.TCharFloatHashMap.equals(java.lang.Object):boolean");
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
        forEachEntry(new TCharFloatProcedure() { // from class: gnu.trove.map.hash.TCharFloatHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TCharFloatProcedure
            public boolean execute(char c, float f) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(c);
                sb.append("=");
                sb.append(f);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TCharFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeChar(this._set[i]);
                objectOutput.writeFloat(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TCharFloatHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readChar(), objectInput.readFloat());
            readInt = i;
        }
    }
}
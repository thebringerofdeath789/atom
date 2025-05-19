package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.TIntCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TIntCharHash;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TIntCharIterator;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.map.TIntCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TIntCharProcedure;
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
public class TIntCharHashMap extends TIntCharHash implements TIntCharMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient char[] _values;

    public TIntCharHashMap() {
    }

    public TIntCharHashMap(int i) {
        super(i);
    }

    public TIntCharHashMap(int i, float f) {
        super(i, f);
    }

    public TIntCharHashMap(int i, float f, int i2, char c) {
        super(i, f, i2, c);
    }

    public TIntCharHashMap(int[] iArr, char[] cArr) {
        super(Math.max(iArr.length, cArr.length));
        int min = Math.min(iArr.length, cArr.length);
        for (int i = 0; i < min; i++) {
            put(iArr[i], cArr[i]);
        }
    }

    public TIntCharHashMap(TIntCharMap tIntCharMap) {
        super(tIntCharMap.size());
        if (tIntCharMap instanceof TIntCharHashMap) {
            TIntCharHashMap tIntCharHashMap = (TIntCharHashMap) tIntCharMap;
            this._loadFactor = Math.abs(tIntCharHashMap._loadFactor);
            this.no_entry_key = tIntCharHashMap.no_entry_key;
            this.no_entry_value = tIntCharHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tIntCharMap);
    }

    @Override // gnu.trove.impl.hash.TIntCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new char[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        int[] iArr = this._set;
        char[] cArr = this._values;
        byte[] bArr = this._states;
        this._set = new int[i];
        this._values = new char[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(iArr[i2])] = cArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public char put(int i, char c) {
        return doPut(i, c, insertKey(i));
    }

    @Override // gnu.trove.map.TIntCharMap
    public char putIfAbsent(int i, char c) {
        int insertKey = insertKey(i);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(i, c, insertKey);
    }

    private char doPut(int i, char c, int i2) {
        char c2 = this.no_entry_value;
        boolean z = true;
        if (i2 < 0) {
            i2 = (-i2) - 1;
            c2 = this._values[i2];
            z = false;
        }
        this._values[i2] = c;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    @Override // gnu.trove.map.TIntCharMap
    public void putAll(Map<? extends Integer, ? extends Character> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Integer, ? extends Character> entry : map.entrySet()) {
            put(entry.getKey().intValue(), entry.getValue().charValue());
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public void putAll(TIntCharMap tIntCharMap) {
        ensureCapacity(tIntCharMap.size());
        TIntCharIterator it = tIntCharMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public char get(int i) {
        int index = index(i);
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

    @Override // gnu.trove.map.TIntCharMap
    public char remove(int i) {
        char c = this.no_entry_value;
        int index = index(i);
        if (index < 0) {
            return c;
        }
        char c2 = this._values[index];
        removeAt(index);
        return c2;
    }

    @Override // gnu.trove.impl.hash.TIntCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TIntCharMap
    public TIntSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
    public TCharCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
    public boolean containsKey(int i) {
        return contains(i);
    }

    @Override // gnu.trove.map.TIntCharMap
    public TIntCharIterator iterator() {
        return new TIntCharHashIterator(this);
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachKey(TIntProcedure tIntProcedure) {
        return forEach(tIntProcedure);
    }

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
    public boolean forEachEntry(TIntCharProcedure tIntCharProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        char[] cArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tIntCharProcedure.execute(iArr[i], cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TIntCharMap
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

    @Override // gnu.trove.map.TIntCharMap
    public boolean retainEntries(TIntCharProcedure tIntCharProcedure) {
        byte[] bArr = this._states;
        int[] iArr = this._set;
        char[] cArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = iArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tIntCharProcedure.execute(iArr[i], cArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean increment(int i) {
        return adjustValue(i, (char) 1);
    }

    @Override // gnu.trove.map.TIntCharMap
    public boolean adjustValue(int i, char c) {
        int index = index(i);
        if (index < 0) {
            return false;
        }
        char[] cArr = this._values;
        cArr[index] = (char) (cArr[index] + c);
        return true;
    }

    @Override // gnu.trove.map.TIntCharMap
    public char adjustOrPutValue(int i, char c, char c2) {
        int insertKey = insertKey(i);
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

    protected class TKeyView implements TIntSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public TIntIterator iterator() {
            TIntCharHashMap tIntCharHashMap = TIntCharHashMap.this;
            return tIntCharHashMap.new TIntCharKeyHashIterator(tIntCharHashMap);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int getNoEntryValue() {
            return TIntCharHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int size() {
            return TIntCharHashMap.this._size;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean isEmpty() {
            return TIntCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean contains(int i) {
            return TIntCharHashMap.this.contains(i);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int[] toArray() {
            return TIntCharHashMap.this.keys();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int[] toArray(int[] iArr) {
            return TIntCharHashMap.this.keys(iArr);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean add(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean remove(int i) {
            return TIntCharHashMap.this.no_entry_value != TIntCharHashMap.this.remove(i);
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Integer) {
                    if (!TIntCharHashMap.this.containsKey(((Integer) obj).intValue())) {
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
                if (!TIntCharHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean containsAll(int[] iArr) {
            for (int i : iArr) {
                if (!TIntCharHashMap.this.contains(i)) {
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
            int[] iArr2 = TIntCharHashMap.this._set;
            byte[] bArr = TIntCharHashMap.this._states;
            int length = iArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(iArr, iArr2[i]) < 0) {
                    TIntCharHashMap.this.removeAt(i);
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
            TIntCharHashMap.this.clear();
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public boolean forEach(TIntProcedure tIntProcedure) {
            return TIntCharHashMap.this.forEachKey(tIntProcedure);
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
            int length = TIntCharHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TIntCharHashMap.this._states[i] == 1 && !tIntSet.contains(TIntCharHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TIntSet, gnu.trove.TIntCollection
        public int hashCode() {
            int length = TIntCharHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TIntCharHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TIntCharHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TIntCharHashMap.this.forEachKey(new TIntProcedure() { // from class: gnu.trove.map.hash.TIntCharHashMap.TKeyView.1
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

    protected class TValueView implements TCharCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TCharCollection
        public TCharIterator iterator() {
            TIntCharHashMap tIntCharHashMap = TIntCharHashMap.this;
            return tIntCharHashMap.new TIntCharValueHashIterator(tIntCharHashMap);
        }

        @Override // gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TIntCharHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TCharCollection
        public int size() {
            return TIntCharHashMap.this._size;
        }

        @Override // gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TIntCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TIntCharHashMap.this.containsValue(c);
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray() {
            return TIntCharHashMap.this.values();
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TIntCharHashMap.this.values(cArr);
        }

        @Override // gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean remove(char c) {
            char[] cArr = TIntCharHashMap.this._values;
            byte[] bArr = TIntCharHashMap.this._states;
            int length = cArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && c == cArr[i]) {
                    TIntCharHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TIntCharHashMap.this.containsValue(((Character) obj).charValue())) {
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
                if (!TIntCharHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TIntCharHashMap.this.containsValue(c)) {
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
            char[] cArr2 = TIntCharHashMap.this._values;
            byte[] bArr = TIntCharHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TIntCharHashMap.this.removeAt(i);
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
            TIntCharHashMap.this.clear();
        }

        @Override // gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TIntCharHashMap.this.forEachValue(tCharProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TIntCharHashMap.this.forEachValue(new TCharProcedure() { // from class: gnu.trove.map.hash.TIntCharHashMap.TValueView.1
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

    class TIntCharKeyHashIterator extends THashPrimitiveIterator implements TIntIterator {
        TIntCharKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TIntIterator
        public int next() {
            moveToNextIndex();
            return TIntCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TIntCharValueHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TIntCharValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TIntCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TIntCharHashIterator extends THashPrimitiveIterator implements TIntCharIterator {
        TIntCharHashIterator(TIntCharHashMap tIntCharHashMap) {
            super(tIntCharHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TIntCharIterator
        public int key() {
            return TIntCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TIntCharIterator
        public char value() {
            return TIntCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TIntCharIterator
        public char setValue(char c) {
            char value = value();
            TIntCharHashMap.this._values[this._index] = c;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TIntCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TIntCharMap)) {
            return false;
        }
        TIntCharMap tIntCharMap = (TIntCharMap) obj;
        if (tIntCharMap.size() != size()) {
            return false;
        }
        char[] cArr = this._values;
        byte[] bArr = this._states;
        char noEntryValue = getNoEntryValue();
        char noEntryValue2 = tIntCharMap.getNoEntryValue();
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                int i2 = this._set[i];
                if (!tIntCharMap.containsKey(i2)) {
                    return false;
                }
                char c = tIntCharMap.get(i2);
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
        forEachEntry(new TIntCharProcedure() { // from class: gnu.trove.map.hash.TIntCharHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TIntCharProcedure
            public boolean execute(int i, char c) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(i);
                sb.append("=");
                sb.append(c);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TIntCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeChar(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TIntCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readInt(), objectInput.readChar());
            readInt = i;
        }
    }
}

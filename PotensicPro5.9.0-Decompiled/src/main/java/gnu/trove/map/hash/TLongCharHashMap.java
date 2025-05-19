package gnu.trove.map.hash;

import gnu.trove.TCharCollection;
import gnu.trove.TLongCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TLongCharHash;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.iterator.TLongCharIterator;
import gnu.trove.iterator.TLongIterator;
import gnu.trove.map.TLongCharMap;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.procedure.TLongCharProcedure;
import gnu.trove.procedure.TLongProcedure;
import gnu.trove.set.TLongSet;
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
public class TLongCharHashMap extends TLongCharHash implements TLongCharMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient char[] _values;

    public TLongCharHashMap() {
    }

    public TLongCharHashMap(int i) {
        super(i);
    }

    public TLongCharHashMap(int i, float f) {
        super(i, f);
    }

    public TLongCharHashMap(int i, float f, long j, char c) {
        super(i, f, j, c);
    }

    public TLongCharHashMap(long[] jArr, char[] cArr) {
        super(Math.max(jArr.length, cArr.length));
        int min = Math.min(jArr.length, cArr.length);
        for (int i = 0; i < min; i++) {
            put(jArr[i], cArr[i]);
        }
    }

    public TLongCharHashMap(TLongCharMap tLongCharMap) {
        super(tLongCharMap.size());
        if (tLongCharMap instanceof TLongCharHashMap) {
            TLongCharHashMap tLongCharHashMap = (TLongCharHashMap) tLongCharMap;
            this._loadFactor = Math.abs(tLongCharHashMap._loadFactor);
            this.no_entry_key = tLongCharHashMap.no_entry_key;
            this.no_entry_value = tLongCharHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tLongCharMap);
    }

    @Override // gnu.trove.impl.hash.TLongCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new char[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        long[] jArr = this._set;
        char[] cArr = this._values;
        byte[] bArr = this._states;
        this._set = new long[i];
        this._values = new char[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i2] == 1) {
                this._values[insertKey(jArr[i2])] = cArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public char put(long j, char c) {
        return doPut(j, c, insertKey(j));
    }

    @Override // gnu.trove.map.TLongCharMap
    public char putIfAbsent(long j, char c) {
        int insertKey = insertKey(j);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(j, c, insertKey);
    }

    private char doPut(long j, char c, int i) {
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

    @Override // gnu.trove.map.TLongCharMap
    public void putAll(Map<? extends Long, ? extends Character> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Long, ? extends Character> entry : map.entrySet()) {
            put(entry.getKey().longValue(), entry.getValue().charValue());
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public void putAll(TLongCharMap tLongCharMap) {
        ensureCapacity(tLongCharMap.size());
        TLongCharIterator it = tLongCharMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public char get(long j) {
        int index = index(j);
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

    @Override // gnu.trove.map.TLongCharMap
    public char remove(long j) {
        char c = this.no_entry_value;
        int index = index(j);
        if (index < 0) {
            return c;
        }
        char c2 = this._values[index];
        removeAt(index);
        return c2;
    }

    @Override // gnu.trove.impl.hash.TLongCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TLongCharMap
    public TLongSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TLongCharMap
    public long[] keys() {
        int size = size();
        long[] jArr = new long[size];
        if (size == 0) {
            return jArr;
        }
        long[] jArr2 = this._set;
        byte[] bArr = this._states;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (bArr[i2] == 1) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public long[] keys(long[] jArr) {
        int size = size();
        if (size == 0) {
            return jArr;
        }
        if (jArr.length < size) {
            jArr = new long[size];
        }
        long[] jArr2 = this._set;
        byte[] bArr = this._states;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return jArr;
            }
            if (bArr[i2] == 1) {
                jArr[i] = jArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public TCharCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TLongCharMap
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

    @Override // gnu.trove.map.TLongCharMap
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

    @Override // gnu.trove.map.TLongCharMap
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

    @Override // gnu.trove.map.TLongCharMap
    public boolean containsKey(long j) {
        return contains(j);
    }

    @Override // gnu.trove.map.TLongCharMap
    public TLongCharIterator iterator() {
        return new TLongCharHashIterator(this);
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachKey(TLongProcedure tLongProcedure) {
        return forEach(tLongProcedure);
    }

    @Override // gnu.trove.map.TLongCharMap
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

    @Override // gnu.trove.map.TLongCharMap
    public boolean forEachEntry(TLongCharProcedure tLongCharProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        char[] cArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tLongCharProcedure.execute(jArr[i], cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TLongCharMap
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

    @Override // gnu.trove.map.TLongCharMap
    public boolean retainEntries(TLongCharProcedure tLongCharProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        char[] cArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tLongCharProcedure.execute(jArr[i], cArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean increment(long j) {
        return adjustValue(j, (char) 1);
    }

    @Override // gnu.trove.map.TLongCharMap
    public boolean adjustValue(long j, char c) {
        int index = index(j);
        if (index < 0) {
            return false;
        }
        char[] cArr = this._values;
        cArr[index] = (char) (cArr[index] + c);
        return true;
    }

    @Override // gnu.trove.map.TLongCharMap
    public char adjustOrPutValue(long j, char c, char c2) {
        int insertKey = insertKey(j);
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

    protected class TKeyView implements TLongSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public TLongIterator iterator() {
            TLongCharHashMap tLongCharHashMap = TLongCharHashMap.this;
            return tLongCharHashMap.new TLongCharKeyHashIterator(tLongCharHashMap);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long getNoEntryValue() {
            return TLongCharHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int size() {
            return TLongCharHashMap.this._size;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean isEmpty() {
            return TLongCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean contains(long j) {
            return TLongCharHashMap.this.contains(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray() {
            return TLongCharHashMap.this.keys();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public long[] toArray(long[] jArr) {
            return TLongCharHashMap.this.keys(jArr);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean add(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean remove(long j) {
            return TLongCharHashMap.this.no_entry_value != TLongCharHashMap.this.remove(j);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Long) {
                    if (!TLongCharHashMap.this.containsKey(((Long) obj).longValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(TLongCollection tLongCollection) {
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (!TLongCharHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean containsAll(long[] jArr) {
            for (long j : jArr) {
                if (!TLongCharHashMap.this.contains(j)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(TLongCollection tLongCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean addAll(long[] jArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(Collection<?> collection) {
            TLongIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Long.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(TLongCollection tLongCollection) {
            boolean z = false;
            if (this == tLongCollection) {
                return false;
            }
            TLongIterator it = iterator();
            while (it.hasNext()) {
                if (!tLongCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean retainAll(long[] jArr) {
            Arrays.sort(jArr);
            long[] jArr2 = TLongCharHashMap.this._set;
            byte[] bArr = TLongCharHashMap.this._states;
            int length = jArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(jArr, jArr2[i]) < 0) {
                    TLongCharHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Long) && remove(((Long) obj).longValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(TLongCollection tLongCollection) {
            if (this == tLongCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TLongIterator it = tLongCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean removeAll(long[] jArr) {
            int length = jArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(jArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public void clear() {
            TLongCharHashMap.this.clear();
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean forEach(TLongProcedure tLongProcedure) {
            return TLongCharHashMap.this.forEachKey(tLongProcedure);
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TLongSet)) {
                return false;
            }
            TLongSet tLongSet = (TLongSet) obj;
            if (tLongSet.size() != size()) {
                return false;
            }
            int length = TLongCharHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TLongCharHashMap.this._states[i] == 1 && !tLongSet.contains(TLongCharHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TLongSet, gnu.trove.TLongCollection
        public int hashCode() {
            int length = TLongCharHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TLongCharHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash(TLongCharHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TLongCharHashMap.this.forEachKey(new TLongProcedure() { // from class: gnu.trove.map.hash.TLongCharHashMap.TKeyView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TLongProcedure
                public boolean execute(long j) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(j);
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
            TLongCharHashMap tLongCharHashMap = TLongCharHashMap.this;
            return tLongCharHashMap.new TLongCharValueHashIterator(tLongCharHashMap);
        }

        @Override // gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TLongCharHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TCharCollection
        public int size() {
            return TLongCharHashMap.this._size;
        }

        @Override // gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TLongCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TLongCharHashMap.this.containsValue(c);
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray() {
            return TLongCharHashMap.this.values();
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TLongCharHashMap.this.values(cArr);
        }

        @Override // gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean remove(char c) {
            char[] cArr = TLongCharHashMap.this._values;
            byte[] bArr = TLongCharHashMap.this._states;
            int length = cArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && c == cArr[i]) {
                    TLongCharHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TLongCharHashMap.this.containsValue(((Character) obj).charValue())) {
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
                if (!TLongCharHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TLongCharHashMap.this.containsValue(c)) {
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
            char[] cArr2 = TLongCharHashMap.this._values;
            byte[] bArr = TLongCharHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TLongCharHashMap.this.removeAt(i);
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
            TLongCharHashMap.this.clear();
        }

        @Override // gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TLongCharHashMap.this.forEachValue(tCharProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TLongCharHashMap.this.forEachValue(new TCharProcedure() { // from class: gnu.trove.map.hash.TLongCharHashMap.TValueView.1
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

    class TLongCharKeyHashIterator extends THashPrimitiveIterator implements TLongIterator {
        TLongCharKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TLongIterator
        public long next() {
            moveToNextIndex();
            return TLongCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TLongCharValueHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TLongCharValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TLongCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TLongCharHashIterator extends THashPrimitiveIterator implements TLongCharIterator {
        TLongCharHashIterator(TLongCharHashMap tLongCharHashMap) {
            super(tLongCharHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TLongCharIterator
        public long key() {
            return TLongCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TLongCharIterator
        public char value() {
            return TLongCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TLongCharIterator
        public char setValue(char c) {
            char value = value();
            TLongCharHashMap.this._values[this._index] = c;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TLongCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TLongCharMap)) {
            return false;
        }
        TLongCharMap tLongCharMap = (TLongCharMap) obj;
        if (tLongCharMap.size() != size()) {
            return false;
        }
        char[] cArr = this._values;
        byte[] bArr = this._states;
        char noEntryValue = getNoEntryValue();
        char noEntryValue2 = tLongCharMap.getNoEntryValue();
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                long j = this._set[i];
                if (!tLongCharMap.containsKey(j)) {
                    return false;
                }
                char c = tLongCharMap.get(j);
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
        forEachEntry(new TLongCharProcedure() { // from class: gnu.trove.map.hash.TLongCharHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TLongCharProcedure
            public boolean execute(long j, char c) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(j);
                sb.append("=");
                sb.append(c);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TLongCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeLong(this._set[i]);
                objectOutput.writeChar(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TLongCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readLong(), objectInput.readChar());
            readInt = i;
        }
    }
}

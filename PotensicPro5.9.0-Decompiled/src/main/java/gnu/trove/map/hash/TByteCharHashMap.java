package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.TCharCollection;
import gnu.trove.function.TCharFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TByteCharHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TByteCharIterator;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.map.TByteCharMap;
import gnu.trove.procedure.TByteCharProcedure;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharProcedure;
import gnu.trove.set.TByteSet;
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
public class TByteCharHashMap extends TByteCharHash implements TByteCharMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient char[] _values;

    public TByteCharHashMap() {
    }

    public TByteCharHashMap(int i) {
        super(i);
    }

    public TByteCharHashMap(int i, float f) {
        super(i, f);
    }

    public TByteCharHashMap(int i, float f, byte b, char c) {
        super(i, f, b, c);
    }

    public TByteCharHashMap(byte[] bArr, char[] cArr) {
        super(Math.max(bArr.length, cArr.length));
        int min = Math.min(bArr.length, cArr.length);
        for (int i = 0; i < min; i++) {
            put(bArr[i], cArr[i]);
        }
    }

    public TByteCharHashMap(TByteCharMap tByteCharMap) {
        super(tByteCharMap.size());
        if (tByteCharMap instanceof TByteCharHashMap) {
            TByteCharHashMap tByteCharHashMap = (TByteCharHashMap) tByteCharMap;
            this._loadFactor = Math.abs(tByteCharHashMap._loadFactor);
            this.no_entry_key = tByteCharHashMap.no_entry_key;
            this.no_entry_value = tByteCharHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tByteCharMap);
    }

    @Override // gnu.trove.impl.hash.TByteCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new char[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        byte[] bArr = this._set;
        char[] cArr = this._values;
        byte[] bArr2 = this._states;
        this._set = new byte[i];
        this._values = new char[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                this._values[insertKey(bArr[i2])] = cArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public char put(byte b, char c) {
        return doPut(b, c, insertKey(b));
    }

    @Override // gnu.trove.map.TByteCharMap
    public char putIfAbsent(byte b, char c) {
        int insertKey = insertKey(b);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(b, c, insertKey);
    }

    private char doPut(byte b, char c, int i) {
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

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(Map<? extends Byte, ? extends Character> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Byte, ? extends Character> entry : map.entrySet()) {
            put(entry.getKey().byteValue(), entry.getValue().charValue());
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public void putAll(TByteCharMap tByteCharMap) {
        ensureCapacity(tByteCharMap.size());
        TByteCharIterator it = tByteCharMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public char get(byte b) {
        int index = index(b);
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

    @Override // gnu.trove.map.TByteCharMap
    public char remove(byte b) {
        char c = this.no_entry_value;
        int index = index(b);
        if (index < 0) {
            return c;
        }
        char c2 = this._values[index];
        removeAt(index);
        return c2;
    }

    @Override // gnu.trove.impl.hash.TByteCharHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys() {
        int size = size();
        byte[] bArr = new byte[size];
        if (size == 0) {
            return bArr;
        }
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public byte[] keys(byte[] bArr) {
        int size = size();
        if (size == 0) {
            return bArr;
        }
        if (bArr.length < size) {
            bArr = new byte[size];
        }
        byte[] bArr2 = this._set;
        byte[] bArr3 = this._states;
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return bArr;
            }
            if (bArr3[i2] == 1) {
                bArr[i] = bArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public TCharCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
    public boolean containsKey(byte b) {
        return contains(b);
    }

    @Override // gnu.trove.map.TByteCharMap
    public TByteCharIterator iterator() {
        return new TByteCharHashIterator(this);
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachKey(TByteProcedure tByteProcedure) {
        return forEach(tByteProcedure);
    }

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
    public boolean forEachEntry(TByteCharProcedure tByteCharProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        char[] cArr = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteCharProcedure.execute(bArr2[i], cArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TByteCharMap
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

    @Override // gnu.trove.map.TByteCharMap
    public boolean retainEntries(TByteCharProcedure tByteCharProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._set;
        char[] cArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tByteCharProcedure.execute(bArr2[i], cArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean increment(byte b) {
        return adjustValue(b, (char) 1);
    }

    @Override // gnu.trove.map.TByteCharMap
    public boolean adjustValue(byte b, char c) {
        int index = index(b);
        if (index < 0) {
            return false;
        }
        char[] cArr = this._values;
        cArr[index] = (char) (cArr[index] + c);
        return true;
    }

    @Override // gnu.trove.map.TByteCharMap
    public char adjustOrPutValue(byte b, char c, char c2) {
        int insertKey = insertKey(b);
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
        byte b2 = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return c2;
    }

    protected class TKeyView implements TByteSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TByteCharHashMap tByteCharHashMap = TByteCharHashMap.this;
            return tByteCharHashMap.new TByteCharKeyHashIterator(tByteCharHashMap);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TByteCharHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int size() {
            return TByteCharHashMap.this._size;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TByteCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TByteCharHashMap.this.contains(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray() {
            return TByteCharHashMap.this.keys();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TByteCharHashMap.this.keys(bArr);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean remove(byte b) {
            return TByteCharHashMap.this.no_entry_value != TByteCharHashMap.this.remove(b);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TByteCharHashMap.this.containsKey(((Byte) obj).byteValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(TByteCollection tByteCollection) {
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (!TByteCharHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TByteCharHashMap.this.contains(b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(Collection<? extends Byte> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(TByteCollection tByteCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean addAll(byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean retainAll(Collection<?> collection) {
            TByteIterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(Byte.valueOf(it.next()))) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean retainAll(TByteCollection tByteCollection) {
            boolean z = false;
            if (this == tByteCollection) {
                return false;
            }
            TByteIterator it = iterator();
            while (it.hasNext()) {
                if (!tByteCollection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean retainAll(byte[] bArr) {
            Arrays.sort(bArr);
            byte[] bArr2 = TByteCharHashMap.this._set;
            byte[] bArr3 = TByteCharHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TByteCharHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean removeAll(TByteCollection tByteCollection) {
            if (this == tByteCollection) {
                clear();
                return true;
            }
            boolean z = false;
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean removeAll(byte[] bArr) {
            int length = bArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (remove(bArr[i])) {
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public void clear() {
            TByteCharHashMap.this.clear();
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TByteCharHashMap.this.forEachKey(tByteProcedure);
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TByteSet)) {
                return false;
            }
            TByteSet tByteSet = (TByteSet) obj;
            if (tByteSet.size() != size()) {
                return false;
            }
            int length = TByteCharHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TByteCharHashMap.this._states[i] == 1 && !tByteSet.contains(TByteCharHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TByteSet, gnu.trove.TByteCollection
        public int hashCode() {
            int length = TByteCharHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TByteCharHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TByteCharHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteCharHashMap.this.forEachKey(new TByteProcedure() { // from class: gnu.trove.map.hash.TByteCharHashMap.TKeyView.1
                private boolean first = true;

                @Override // gnu.trove.procedure.TByteProcedure
                public boolean execute(byte b) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append((int) b);
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
            TByteCharHashMap tByteCharHashMap = TByteCharHashMap.this;
            return tByteCharHashMap.new TByteCharValueHashIterator(tByteCharHashMap);
        }

        @Override // gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TByteCharHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TCharCollection
        public int size() {
            return TByteCharHashMap.this._size;
        }

        @Override // gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TByteCharHashMap.this._size == 0;
        }

        @Override // gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TByteCharHashMap.this.containsValue(c);
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray() {
            return TByteCharHashMap.this.values();
        }

        @Override // gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TByteCharHashMap.this.values(cArr);
        }

        @Override // gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TCharCollection
        public boolean remove(char c) {
            char[] cArr = TByteCharHashMap.this._values;
            byte[] bArr = TByteCharHashMap.this._states;
            int length = cArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr[i] != 0 && bArr[i] != 2 && c == cArr[i]) {
                    TByteCharHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TByteCharHashMap.this.containsValue(((Character) obj).charValue())) {
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
                if (!TByteCharHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TByteCharHashMap.this.containsValue(c)) {
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
            char[] cArr2 = TByteCharHashMap.this._values;
            byte[] bArr = TByteCharHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TByteCharHashMap.this.removeAt(i);
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
            TByteCharHashMap.this.clear();
        }

        @Override // gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TByteCharHashMap.this.forEachValue(tCharProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TByteCharHashMap.this.forEachValue(new TCharProcedure() { // from class: gnu.trove.map.hash.TByteCharHashMap.TValueView.1
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

    class TByteCharKeyHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TByteCharKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TByteCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteCharValueHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TByteCharValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TByteCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TByteCharHashIterator extends THashPrimitiveIterator implements TByteCharIterator {
        TByteCharHashIterator(TByteCharHashMap tByteCharHashMap) {
            super(tByteCharHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TByteCharIterator
        public byte key() {
            return TByteCharHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TByteCharIterator
        public char value() {
            return TByteCharHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TByteCharIterator
        public char setValue(char c) {
            char value = value();
            TByteCharHashMap.this._values[this._index] = c;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TByteCharHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TByteCharMap)) {
            return false;
        }
        TByteCharMap tByteCharMap = (TByteCharMap) obj;
        if (tByteCharMap.size() != size()) {
            return false;
        }
        char[] cArr = this._values;
        byte[] bArr = this._states;
        char noEntryValue = getNoEntryValue();
        char noEntryValue2 = tByteCharMap.getNoEntryValue();
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1) {
                byte b = this._set[i];
                if (!tByteCharMap.containsKey(b)) {
                    return false;
                }
                char c = tByteCharMap.get(b);
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
                i += HashFunctions.hash((int) this._set[i2]) ^ HashFunctions.hash((int) this._values[i2]);
            }
            length = i2;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TByteCharProcedure() { // from class: gnu.trove.map.hash.TByteCharHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TByteCharProcedure
            public boolean execute(byte b, char c) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) b);
                sb.append("=");
                sb.append(c);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TByteCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeByte(this._set[i]);
                objectOutput.writeChar(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TByteCharHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readByte(), objectInput.readChar());
            readInt = i;
        }
    }
}

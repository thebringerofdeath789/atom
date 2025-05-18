package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.TCharCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.TCharByteHash;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TCharByteIterator;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.map.TCharByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TCharByteProcedure;
import gnu.trove.procedure.TCharProcedure;
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
public class TCharByteHashMap extends TCharByteHash implements TCharByteMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient byte[] _values;

    public TCharByteHashMap() {
    }

    public TCharByteHashMap(int i) {
        super(i);
    }

    public TCharByteHashMap(int i, float f) {
        super(i, f);
    }

    public TCharByteHashMap(int i, float f, char c, byte b) {
        super(i, f, c, b);
    }

    public TCharByteHashMap(char[] cArr, byte[] bArr) {
        super(Math.max(cArr.length, bArr.length));
        int min = Math.min(cArr.length, bArr.length);
        for (int i = 0; i < min; i++) {
            put(cArr[i], bArr[i]);
        }
    }

    public TCharByteHashMap(TCharByteMap tCharByteMap) {
        super(tCharByteMap.size());
        if (tCharByteMap instanceof TCharByteHashMap) {
            TCharByteHashMap tCharByteHashMap = (TCharByteHashMap) tCharByteMap;
            this._loadFactor = Math.abs(tCharByteHashMap._loadFactor);
            this.no_entry_key = tCharByteHashMap.no_entry_key;
            this.no_entry_value = tCharByteHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tCharByteMap);
    }

    @Override // gnu.trove.impl.hash.TCharByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new byte[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        char[] cArr = this._set;
        byte[] bArr = this._values;
        byte[] bArr2 = this._states;
        this._set = new char[i];
        this._values = new byte[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                this._values[insertKey(cArr[i2])] = bArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte put(char c, byte b) {
        return doPut(c, b, insertKey(c));
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte putIfAbsent(char c, byte b) {
        int insertKey = insertKey(c);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(c, b, insertKey);
    }

    private byte doPut(char c, byte b, int i) {
        byte b2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            b2 = this._values[i];
            z = false;
        }
        this._values[i] = b;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return b2;
    }

    @Override // gnu.trove.map.TCharByteMap
    public void putAll(Map<? extends Character, ? extends Byte> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Character, ? extends Byte> entry : map.entrySet()) {
            put(entry.getKey().charValue(), entry.getValue().byteValue());
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public void putAll(TCharByteMap tCharByteMap) {
        ensureCapacity(tCharByteMap.size());
        TCharByteIterator it = tCharByteMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte get(char c) {
        int index = index(c);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, this.no_entry_key);
        byte[] bArr = this._values;
        Arrays.fill(bArr, 0, bArr.length, this.no_entry_value);
        Arrays.fill(this._states, 0, this._states.length, (byte) 0);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TByteByteMap
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte remove(char c) {
        byte b = this.no_entry_value;
        int index = index(c);
        if (index < 0) {
            return b;
        }
        byte b2 = this._values[index];
        removeAt(index);
        return b2;
    }

    @Override // gnu.trove.impl.hash.TCharByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TCharByteMap
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

    @Override // gnu.trove.map.TCharByteMap
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

    @Override // gnu.trove.map.TCharByteMap
    public TByteCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values() {
        int size = size();
        byte[] bArr = new byte[size];
        if (size == 0) {
            return bArr;
        }
        byte[] bArr2 = this._values;
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

    @Override // gnu.trove.map.TCharByteMap
    public byte[] values(byte[] bArr) {
        int size = size();
        if (size == 0) {
            return bArr;
        }
        if (bArr.length < size) {
            bArr = new byte[size];
        }
        byte[] bArr2 = this._values;
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

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsValue(byte b) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (bArr[i] == 1 && b == bArr2[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean containsKey(char c) {
        return contains(c);
    }

    @Override // gnu.trove.map.TCharByteMap
    public TCharByteIterator iterator() {
        return new TCharByteHashIterator(this);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachKey(TCharProcedure tCharProcedure) {
        return forEach(tCharProcedure);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachValue(TByteProcedure tByteProcedure) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tByteProcedure.execute(bArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean forEachEntry(TCharByteProcedure tCharByteProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        byte[] bArr2 = this._values;
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tCharByteProcedure.execute(cArr[i], bArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public void transformValues(TByteFunction tByteFunction) {
        byte[] bArr = this._states;
        byte[] bArr2 = this._values;
        int length = bArr2.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr[i] == 1) {
                bArr2[i] = tByteFunction.execute(bArr2[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean retainEntries(TCharByteProcedure tCharByteProcedure) {
        byte[] bArr = this._states;
        char[] cArr = this._set;
        byte[] bArr2 = this._values;
        tempDisableAutoCompaction();
        try {
            int length = cArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tCharByteProcedure.execute(cArr[i], bArr2[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean increment(char c) {
        return adjustValue(c, (byte) 1);
    }

    @Override // gnu.trove.map.TCharByteMap
    public boolean adjustValue(char c, byte b) {
        int index = index(c);
        if (index < 0) {
            return false;
        }
        byte[] bArr = this._values;
        bArr[index] = (byte) (bArr[index] + b);
        return true;
    }

    @Override // gnu.trove.map.TCharByteMap
    public byte adjustOrPutValue(char c, byte b, byte b2) {
        int insertKey = insertKey(c);
        boolean z = true;
        if (insertKey < 0) {
            insertKey = (-insertKey) - 1;
            byte[] bArr = this._values;
            byte b3 = (byte) (bArr[insertKey] + b);
            bArr[insertKey] = b3;
            z = false;
            b2 = b3;
        } else {
            this._values[insertKey] = b2;
        }
        byte b4 = this._states[insertKey];
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return b2;
    }

    protected class TKeyView implements TCharSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public TCharIterator iterator() {
            TCharByteHashMap tCharByteHashMap = TCharByteHashMap.this;
            return tCharByteHashMap.new TCharByteKeyHashIterator(tCharByteHashMap);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char getNoEntryValue() {
            return TCharByteHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public int size() {
            return TCharByteHashMap.this._size;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean isEmpty() {
            return TCharByteHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean contains(char c) {
            return TCharByteHashMap.this.contains(c);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char[] toArray() {
            return TCharByteHashMap.this.keys();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public char[] toArray(char[] cArr) {
            return TCharByteHashMap.this.keys(cArr);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean add(char c) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean remove(char c) {
            return TCharByteHashMap.this.no_entry_value != TCharByteHashMap.this.remove(c);
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Character) {
                    if (!TCharByteHashMap.this.containsKey(((Character) obj).charValue())) {
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
                if (!TCharByteHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean containsAll(char[] cArr) {
            for (char c : cArr) {
                if (!TCharByteHashMap.this.contains(c)) {
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
            char[] cArr2 = TCharByteHashMap.this._set;
            byte[] bArr = TCharByteHashMap.this._states;
            int length = cArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(cArr, cArr2[i]) < 0) {
                    TCharByteHashMap.this.removeAt(i);
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
            TCharByteHashMap.this.clear();
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public boolean forEach(TCharProcedure tCharProcedure) {
            return TCharByteHashMap.this.forEachKey(tCharProcedure);
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
            int length = TCharByteHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TCharByteHashMap.this._states[i] == 1 && !tCharSet.contains(TCharByteHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TCharSet, gnu.trove.TCharCollection
        public int hashCode() {
            int length = TCharByteHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TCharByteHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TCharByteHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TCharByteHashMap.this.forEachKey(new TCharProcedure() { // from class: gnu.trove.map.hash.TCharByteHashMap.TKeyView.1
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

    protected class TValueView implements TByteCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TCharByteHashMap tCharByteHashMap = TCharByteHashMap.this;
            return tCharByteHashMap.new TCharByteValueHashIterator(tCharByteHashMap);
        }

        @Override // gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TCharByteHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TByteCollection
        public int size() {
            return TCharByteHashMap.this._size;
        }

        @Override // gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TCharByteHashMap.this._size == 0;
        }

        @Override // gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TCharByteHashMap.this.containsValue(b);
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray() {
            return TCharByteHashMap.this.values();
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TCharByteHashMap.this.values(bArr);
        }

        @Override // gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean remove(byte b) {
            byte[] bArr = TCharByteHashMap.this._values;
            byte[] bArr2 = TCharByteHashMap.this._states;
            int length = bArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr2[i] != 0 && bArr2[i] != 2 && b == bArr[i]) {
                    TCharByteHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TCharByteHashMap.this.containsValue(((Byte) obj).byteValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(TByteCollection tByteCollection) {
            TByteIterator it = tByteCollection.iterator();
            while (it.hasNext()) {
                if (!TCharByteHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TCharByteHashMap.this.containsValue(b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(Collection<? extends Byte> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(TByteCollection tByteCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean addAll(byte[] bArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
        public boolean retainAll(byte[] bArr) {
            Arrays.sort(bArr);
            byte[] bArr2 = TCharByteHashMap.this._values;
            byte[] bArr3 = TCharByteHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TCharByteHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Byte) && remove(((Byte) obj).byteValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
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

        @Override // gnu.trove.TByteCollection
        public void clear() {
            TCharByteHashMap.this.clear();
        }

        @Override // gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TCharByteHashMap.this.forEachValue(tByteProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TCharByteHashMap.this.forEachValue(new TByteProcedure() { // from class: gnu.trove.map.hash.TCharByteHashMap.TValueView.1
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

    class TCharByteKeyHashIterator extends THashPrimitiveIterator implements TCharIterator {
        TCharByteKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TCharIterator
        public char next() {
            moveToNextIndex();
            return TCharByteHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TCharByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TCharByteValueHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TCharByteValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TCharByteHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TCharByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TCharByteHashIterator extends THashPrimitiveIterator implements TCharByteIterator {
        TCharByteHashIterator(TCharByteHashMap tCharByteHashMap) {
            super(tCharByteHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TCharByteIterator
        public char key() {
            return TCharByteHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TCharByteIterator
        public byte value() {
            return TCharByteHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TCharByteIterator
        public byte setValue(byte b) {
            byte value = value();
            TCharByteHashMap.this._values[this._index] = b;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TCharByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TCharByteMap)) {
            return false;
        }
        TCharByteMap tCharByteMap = (TCharByteMap) obj;
        if (tCharByteMap.size() != size()) {
            return false;
        }
        byte[] bArr = this._values;
        byte[] bArr2 = this._states;
        byte noEntryValue = getNoEntryValue();
        byte noEntryValue2 = tCharByteMap.getNoEntryValue();
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr2[i] == 1) {
                char c = this._set[i];
                if (!tCharByteMap.containsKey(c)) {
                    return false;
                }
                byte b = tCharByteMap.get(c);
                byte b2 = bArr[i];
                if (b2 != b && (b2 != noEntryValue || b != noEntryValue2)) {
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
        forEachEntry(new TCharByteProcedure() { // from class: gnu.trove.map.hash.TCharByteHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TCharByteProcedure
            public boolean execute(char c, byte b) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(c);
                sb.append("=");
                sb.append((int) b);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TCharByteHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeByte(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TCharByteHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readChar(), objectInput.readByte());
            readInt = i;
        }
    }
}
package gnu.trove.map.hash;

import gnu.trove.TByteCollection;
import gnu.trove.TShortCollection;
import gnu.trove.function.TByteFunction;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THashPrimitiveIterator;
import gnu.trove.impl.hash.TPrimitiveHash;
import gnu.trove.impl.hash.TShortByteHash;
import gnu.trove.iterator.TByteIterator;
import gnu.trove.iterator.TShortByteIterator;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.map.TShortByteMap;
import gnu.trove.procedure.TByteProcedure;
import gnu.trove.procedure.TShortByteProcedure;
import gnu.trove.procedure.TShortProcedure;
import gnu.trove.set.TShortSet;
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
public class TShortByteHashMap extends TShortByteHash implements TShortByteMap, Externalizable {
    static final long serialVersionUID = 1;
    protected transient byte[] _values;

    public TShortByteHashMap() {
    }

    public TShortByteHashMap(int i) {
        super(i);
    }

    public TShortByteHashMap(int i, float f) {
        super(i, f);
    }

    public TShortByteHashMap(int i, float f, short s, byte b) {
        super(i, f, s, b);
    }

    public TShortByteHashMap(short[] sArr, byte[] bArr) {
        super(Math.max(sArr.length, bArr.length));
        int min = Math.min(sArr.length, bArr.length);
        for (int i = 0; i < min; i++) {
            put(sArr[i], bArr[i]);
        }
    }

    public TShortByteHashMap(TShortByteMap tShortByteMap) {
        super(tShortByteMap.size());
        if (tShortByteMap instanceof TShortByteHashMap) {
            TShortByteHashMap tShortByteHashMap = (TShortByteHashMap) tShortByteMap;
            this._loadFactor = Math.abs(tShortByteHashMap._loadFactor);
            this.no_entry_key = tShortByteHashMap.no_entry_key;
            this.no_entry_value = tShortByteHashMap.no_entry_value;
            if (this.no_entry_key != 0) {
                Arrays.fill(this._set, this.no_entry_key);
            }
            if (this.no_entry_value != 0) {
                Arrays.fill(this._values, this.no_entry_value);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tShortByteMap);
    }

    @Override // gnu.trove.impl.hash.TShortByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new byte[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        short[] sArr = this._set;
        byte[] bArr = this._values;
        byte[] bArr2 = this._states;
        this._set = new short[i];
        this._values = new byte[i];
        this._states = new byte[i];
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (bArr2[i2] == 1) {
                this._values[insertKey(sArr[i2])] = bArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte put(short s, byte b) {
        return doPut(s, b, insertKey(s));
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte putIfAbsent(short s, byte b) {
        int insertKey = insertKey(s);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(s, b, insertKey);
    }

    private byte doPut(short s, byte b, int i) {
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

    @Override // gnu.trove.map.TShortByteMap
    public void putAll(Map<? extends Short, ? extends Byte> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends Short, ? extends Byte> entry : map.entrySet()) {
            put(entry.getKey().shortValue(), entry.getValue().byteValue());
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public void putAll(TShortByteMap tShortByteMap) {
        ensureCapacity(tShortByteMap.size());
        TShortByteIterator it = tShortByteMap.iterator();
        while (it.hasNext()) {
            it.advance();
            put(it.key(), it.value());
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte get(short s) {
        int index = index(s);
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

    @Override // gnu.trove.map.TShortByteMap
    public byte remove(short s) {
        byte b = this.no_entry_value;
        int index = index(s);
        if (index < 0) {
            return b;
        }
        byte b2 = this._values[index];
        removeAt(index);
        return b2;
    }

    @Override // gnu.trove.impl.hash.TShortByteHash, gnu.trove.impl.hash.TPrimitiveHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TShortByteMap
    public TShortSet keySet() {
        return new TKeyView();
    }

    @Override // gnu.trove.map.TShortByteMap
    public short[] keys() {
        int size = size();
        short[] sArr = new short[size];
        if (size == 0) {
            return sArr;
        }
        short[] sArr2 = this._set;
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

    @Override // gnu.trove.map.TShortByteMap
    public short[] keys(short[] sArr) {
        int size = size();
        if (size == 0) {
            return sArr;
        }
        if (sArr.length < size) {
            sArr = new short[size];
        }
        short[] sArr2 = this._set;
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

    @Override // gnu.trove.map.TShortByteMap
    public TByteCollection valueCollection() {
        return new TValueView();
    }

    @Override // gnu.trove.map.TShortByteMap
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

    @Override // gnu.trove.map.TShortByteMap
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

    @Override // gnu.trove.map.TShortByteMap
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

    @Override // gnu.trove.map.TShortByteMap
    public boolean containsKey(short s) {
        return contains(s);
    }

    @Override // gnu.trove.map.TShortByteMap
    public TShortByteIterator iterator() {
        return new TShortByteHashIterator(this);
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachKey(TShortProcedure tShortProcedure) {
        return forEach(tShortProcedure);
    }

    @Override // gnu.trove.map.TShortByteMap
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

    @Override // gnu.trove.map.TShortByteMap
    public boolean forEachEntry(TShortByteProcedure tShortByteProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        byte[] bArr2 = this._values;
        int length = sArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == 1 && !tShortByteProcedure.execute(sArr[i], bArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TShortByteMap
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

    @Override // gnu.trove.map.TShortByteMap
    public boolean retainEntries(TShortByteProcedure tShortByteProcedure) {
        byte[] bArr = this._states;
        short[] sArr = this._set;
        byte[] bArr2 = this._values;
        tempDisableAutoCompaction();
        try {
            int length = sArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && !tShortByteProcedure.execute(sArr[i], bArr2[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean increment(short s) {
        return adjustValue(s, (byte) 1);
    }

    @Override // gnu.trove.map.TShortByteMap
    public boolean adjustValue(short s, byte b) {
        int index = index(s);
        if (index < 0) {
            return false;
        }
        byte[] bArr = this._values;
        bArr[index] = (byte) (bArr[index] + b);
        return true;
    }

    @Override // gnu.trove.map.TShortByteMap
    public byte adjustOrPutValue(short s, byte b, byte b2) {
        int insertKey = insertKey(s);
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

    protected class TKeyView implements TShortSet {
        protected TKeyView() {
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public TShortIterator iterator() {
            TShortByteHashMap tShortByteHashMap = TShortByteHashMap.this;
            return tShortByteHashMap.new TShortByteKeyHashIterator(tShortByteHashMap);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short getNoEntryValue() {
            return TShortByteHashMap.this.no_entry_key;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int size() {
            return TShortByteHashMap.this._size;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean isEmpty() {
            return TShortByteHashMap.this._size == 0;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean contains(short s) {
            return TShortByteHashMap.this.contains(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray() {
            return TShortByteHashMap.this.keys();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public short[] toArray(short[] sArr) {
            return TShortByteHashMap.this.keys(sArr);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean add(short s) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean remove(short s) {
            return TShortByteHashMap.this.no_entry_value != TShortByteHashMap.this.remove(s);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Short) {
                    if (!TShortByteHashMap.this.containsKey(((Short) obj).shortValue())) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(TShortCollection tShortCollection) {
            TShortIterator it = tShortCollection.iterator();
            while (it.hasNext()) {
                if (!TShortByteHashMap.this.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean containsAll(short[] sArr) {
            for (short s : sArr) {
                if (!TShortByteHashMap.this.contains(s)) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(Collection<? extends Short> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(TShortCollection tShortCollection) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean addAll(short[] sArr) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean retainAll(short[] sArr) {
            Arrays.sort(sArr);
            short[] sArr2 = TShortByteHashMap.this._set;
            byte[] bArr = TShortByteHashMap.this._states;
            int length = sArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr[i] == 1 && Arrays.binarySearch(sArr, sArr2[i]) < 0) {
                    TShortByteHashMap.this.removeAt(i);
                    z = true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object obj : collection) {
                if ((obj instanceof Short) && remove(((Short) obj).shortValue())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
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

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public void clear() {
            TShortByteHashMap.this.clear();
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean forEach(TShortProcedure tShortProcedure) {
            return TShortByteHashMap.this.forEachKey(tShortProcedure);
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public boolean equals(Object obj) {
            if (!(obj instanceof TShortSet)) {
                return false;
            }
            TShortSet tShortSet = (TShortSet) obj;
            if (tShortSet.size() != size()) {
                return false;
            }
            int length = TShortByteHashMap.this._states.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return true;
                }
                if (TShortByteHashMap.this._states[i] == 1 && !tShortSet.contains(TShortByteHashMap.this._set[i])) {
                    return false;
                }
                length = i;
            }
        }

        @Override // gnu.trove.set.TShortSet, gnu.trove.TShortCollection
        public int hashCode() {
            int length = TShortByteHashMap.this._states.length;
            int i = 0;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return i;
                }
                if (TShortByteHashMap.this._states[i2] == 1) {
                    i += HashFunctions.hash((int) TShortByteHashMap.this._set[i2]);
                }
                length = i2;
            }
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TShortByteHashMap.this.forEachKey(new TShortProcedure() { // from class: gnu.trove.map.hash.TShortByteHashMap.TKeyView.1
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

    protected class TValueView implements TByteCollection {
        protected TValueView() {
        }

        @Override // gnu.trove.TByteCollection
        public TByteIterator iterator() {
            TShortByteHashMap tShortByteHashMap = TShortByteHashMap.this;
            return tShortByteHashMap.new TShortByteValueHashIterator(tShortByteHashMap);
        }

        @Override // gnu.trove.TByteCollection
        public byte getNoEntryValue() {
            return TShortByteHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TByteCollection
        public int size() {
            return TShortByteHashMap.this._size;
        }

        @Override // gnu.trove.TByteCollection
        public boolean isEmpty() {
            return TShortByteHashMap.this._size == 0;
        }

        @Override // gnu.trove.TByteCollection
        public boolean contains(byte b) {
            return TShortByteHashMap.this.containsValue(b);
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray() {
            return TShortByteHashMap.this.values();
        }

        @Override // gnu.trove.TByteCollection
        public byte[] toArray(byte[] bArr) {
            return TShortByteHashMap.this.values(bArr);
        }

        @Override // gnu.trove.TByteCollection
        public boolean add(byte b) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TByteCollection
        public boolean remove(byte b) {
            byte[] bArr = TShortByteHashMap.this._values;
            byte[] bArr2 = TShortByteHashMap.this._states;
            int length = bArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (bArr2[i] != 0 && bArr2[i] != 2 && b == bArr[i]) {
                    TShortByteHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Byte) {
                    if (!TShortByteHashMap.this.containsValue(((Byte) obj).byteValue())) {
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
                if (!TShortByteHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TByteCollection
        public boolean containsAll(byte[] bArr) {
            for (byte b : bArr) {
                if (!TShortByteHashMap.this.containsValue(b)) {
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
            byte[] bArr2 = TShortByteHashMap.this._values;
            byte[] bArr3 = TShortByteHashMap.this._states;
            int length = bArr2.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (bArr3[i] == 1 && Arrays.binarySearch(bArr, bArr2[i]) < 0) {
                    TShortByteHashMap.this.removeAt(i);
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
            TShortByteHashMap.this.clear();
        }

        @Override // gnu.trove.TByteCollection
        public boolean forEach(TByteProcedure tByteProcedure) {
            return TShortByteHashMap.this.forEachValue(tByteProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TShortByteHashMap.this.forEachValue(new TByteProcedure() { // from class: gnu.trove.map.hash.TShortByteHashMap.TValueView.1
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

    class TShortByteKeyHashIterator extends THashPrimitiveIterator implements TShortIterator {
        TShortByteKeyHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TShortIterator
        public short next() {
            moveToNextIndex();
            return TShortByteHashMap.this._set[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TShortByteValueHashIterator extends THashPrimitiveIterator implements TByteIterator {
        TShortByteValueHashIterator(TPrimitiveHash tPrimitiveHash) {
            super(tPrimitiveHash);
        }

        @Override // gnu.trove.iterator.TByteIterator
        public byte next() {
            moveToNextIndex();
            return TShortByteHashMap.this._values[this._index];
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    class TShortByteHashIterator extends THashPrimitiveIterator implements TShortByteIterator {
        TShortByteHashIterator(TShortByteHashMap tShortByteHashMap) {
            super(tShortByteHashMap);
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TShortByteIterator
        public short key() {
            return TShortByteHashMap.this._set[this._index];
        }

        @Override // gnu.trove.iterator.TShortByteIterator
        public byte value() {
            return TShortByteHashMap.this._values[this._index];
        }

        @Override // gnu.trove.iterator.TShortByteIterator
        public byte setValue(byte b) {
            byte value = value();
            TShortByteHashMap.this._values[this._index] = b;
            return value;
        }

        @Override // gnu.trove.impl.hash.THashPrimitiveIterator, gnu.trove.iterator.TPrimitiveIterator, gnu.trove.iterator.TIterator, java.util.Iterator
        public void remove() {
            if (this._expectedSize != this._hash.size()) {
                throw new ConcurrentModificationException();
            }
            try {
                this._hash.tempDisableAutoCompaction();
                TShortByteHashMap.this.removeAt(this._index);
                this._hash.reenableAutoCompaction(false);
                this._expectedSize--;
            } catch (Throwable th) {
                this._hash.reenableAutoCompaction(false);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TShortByteMap)) {
            return false;
        }
        TShortByteMap tShortByteMap = (TShortByteMap) obj;
        if (tShortByteMap.size() != size()) {
            return false;
        }
        byte[] bArr = this._values;
        byte[] bArr2 = this._states;
        byte noEntryValue = getNoEntryValue();
        byte noEntryValue2 = tShortByteMap.getNoEntryValue();
        int length = bArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr2[i] == 1) {
                short s = this._set[i];
                if (!tShortByteMap.containsKey(s)) {
                    return false;
                }
                byte b = tShortByteMap.get(s);
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
        forEachEntry(new TShortByteProcedure() { // from class: gnu.trove.map.hash.TShortByteHashMap.1
            private boolean first = true;

            @Override // gnu.trove.procedure.TShortByteProcedure
            public boolean execute(short s, byte b) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(", ");
                }
                sb.append((int) s);
                sb.append("=");
                sb.append((int) b);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }

    @Override // gnu.trove.impl.hash.TShortByteHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
                objectOutput.writeShort(this._set[i]);
                objectOutput.writeByte(this._values[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.impl.hash.TShortByteHash, gnu.trove.impl.hash.THash, java.io.Externalizable
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
            put(objectInput.readShort(), objectInput.readByte());
            readInt = i;
        }
    }
}

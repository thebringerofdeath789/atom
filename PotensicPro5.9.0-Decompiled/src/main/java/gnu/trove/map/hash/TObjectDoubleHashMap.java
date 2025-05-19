package gnu.trove.map.hash;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.impl.Constants;
import gnu.trove.impl.HashFunctions;
import gnu.trove.impl.hash.THash;
import gnu.trove.impl.hash.TObjectHash;
import gnu.trove.iterator.TDoubleIterator;
import gnu.trove.iterator.TObjectDoubleIterator;
import gnu.trove.iterator.hash.TObjectHashIterator;
import gnu.trove.map.TObjectDoubleMap;
import gnu.trove.procedure.TDoubleProcedure;
import gnu.trove.procedure.TObjectDoubleProcedure;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class TObjectDoubleHashMap<K> extends TObjectHash<K> implements TObjectDoubleMap<K>, Externalizable {
    static final long serialVersionUID = 1;
    private final TObjectDoubleProcedure<K> PUT_ALL_PROC;
    protected transient double[] _values;
    protected double no_entry_value;

    public TObjectDoubleHashMap() {
        this.PUT_ALL_PROC = new TObjectDoubleProcedure<K>() { // from class: gnu.trove.map.hash.TObjectDoubleHashMap.1
            @Override // gnu.trove.procedure.TObjectDoubleProcedure
            public boolean execute(K k, double d) {
                TObjectDoubleHashMap.this.put(k, d);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_DOUBLE_NO_ENTRY_VALUE;
    }

    public TObjectDoubleHashMap(int i) {
        super(i);
        this.PUT_ALL_PROC = new TObjectDoubleProcedure<K>() { // from class: gnu.trove.map.hash.TObjectDoubleHashMap.1
            @Override // gnu.trove.procedure.TObjectDoubleProcedure
            public boolean execute(K k, double d) {
                TObjectDoubleHashMap.this.put(k, d);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_DOUBLE_NO_ENTRY_VALUE;
    }

    public TObjectDoubleHashMap(int i, float f) {
        super(i, f);
        this.PUT_ALL_PROC = new TObjectDoubleProcedure<K>() { // from class: gnu.trove.map.hash.TObjectDoubleHashMap.1
            @Override // gnu.trove.procedure.TObjectDoubleProcedure
            public boolean execute(K k, double d) {
                TObjectDoubleHashMap.this.put(k, d);
                return true;
            }
        };
        this.no_entry_value = Constants.DEFAULT_DOUBLE_NO_ENTRY_VALUE;
    }

    public TObjectDoubleHashMap(int i, float f, double d) {
        super(i, f);
        this.PUT_ALL_PROC = new TObjectDoubleProcedure<K>() { // from class: gnu.trove.map.hash.TObjectDoubleHashMap.1
            @Override // gnu.trove.procedure.TObjectDoubleProcedure
            public boolean execute(K k, double d2) {
                TObjectDoubleHashMap.this.put(k, d2);
                return true;
            }
        };
        this.no_entry_value = d;
        if (d != 0.0d) {
            Arrays.fill(this._values, d);
        }
    }

    public TObjectDoubleHashMap(TObjectDoubleMap<? extends K> tObjectDoubleMap) {
        this(tObjectDoubleMap.size(), 0.5f, tObjectDoubleMap.getNoEntryValue());
        if (tObjectDoubleMap instanceof TObjectDoubleHashMap) {
            TObjectDoubleHashMap tObjectDoubleHashMap = (TObjectDoubleHashMap) tObjectDoubleMap;
            this._loadFactor = Math.abs(tObjectDoubleHashMap._loadFactor);
            double d = tObjectDoubleHashMap.no_entry_value;
            this.no_entry_value = d;
            if (d != 0.0d) {
                Arrays.fill(this._values, d);
            }
            setUp(saturatedCast(fastCeil(10.0d / this._loadFactor)));
        }
        putAll(tObjectDoubleMap);
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    public int setUp(int i) {
        int up = super.setUp(i);
        this._values = new double[up];
        return up;
    }

    @Override // gnu.trove.impl.hash.THash
    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        double[] dArr = this._values;
        this._set = new Object[i];
        Arrays.fill(this._set, FREE);
        double[] dArr2 = new double[i];
        this._values = dArr2;
        Arrays.fill(dArr2, this.no_entry_value);
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                Object obj = objArr[i2];
                int insertKey = insertKey(obj);
                if (insertKey < 0) {
                    throwObjectContractViolation(this._set[(-insertKey) - 1], obj);
                }
                this._set[insertKey] = obj;
                this._values[insertKey] = dArr[i2];
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double getNoEntryValue() {
        return this.no_entry_value;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean containsValue(double d) {
        Object[] objArr = this._set;
        double[] dArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && d == dArr[i]) {
                return true;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double get(Object obj) {
        int index = index(obj);
        return index < 0 ? this.no_entry_value : this._values[index];
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double put(K k, double d) {
        return doPut(d, insertKey(k));
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double putIfAbsent(K k, double d) {
        int insertKey = insertKey(k);
        if (insertKey < 0) {
            return this._values[(-insertKey) - 1];
        }
        return doPut(d, insertKey);
    }

    private double doPut(double d, int i) {
        double d2 = this.no_entry_value;
        boolean z = true;
        if (i < 0) {
            i = (-i) - 1;
            z = false;
            d2 = this._values[i];
        }
        this._values[i] = d;
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return d2;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double remove(Object obj) {
        double d = this.no_entry_value;
        int index = index(obj);
        if (index < 0) {
            return d;
        }
        double d2 = this._values[index];
        removeAt(index);
        return d2;
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash
    protected void removeAt(int i) {
        this._values[i] = this.no_entry_value;
        super.removeAt(i);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void putAll(Map<? extends K, ? extends Double> map) {
        for (Map.Entry<? extends K, ? extends Double> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue().doubleValue());
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void putAll(TObjectDoubleMap<? extends K> tObjectDoubleMap) {
        tObjectDoubleMap.forEachEntry(this.PUT_ALL_PROC);
    }

    @Override // gnu.trove.impl.hash.THash, gnu.trove.map.TObjectByteMap
    public void clear() {
        super.clear();
        Arrays.fill(this._set, 0, this._set.length, FREE);
        double[] dArr = this._values;
        Arrays.fill(dArr, 0, dArr.length, this.no_entry_value);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public Set<K> keySet() {
        return new KeyView();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public Object[] keys() {
        Object[] objArr = new Object[size()];
        Object[] objArr2 = this._set;
        int length = objArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return objArr;
            }
            if (objArr2[i2] != FREE && objArr2[i2] != REMOVED) {
                objArr[i] = objArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public K[] keys(K[] kArr) {
        int size = size();
        if (kArr.length < size) {
            kArr = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), size));
        }
        Object[] objArr = this._set;
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return kArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                kArr[i] = objArr[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public TDoubleCollection valueCollection() {
        return new TDoubleValueCollection();
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double[] values() {
        double[] dArr = new double[size()];
        double[] dArr2 = this._values;
        Object[] objArr = this._set;
        int length = dArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return dArr;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                dArr[i] = dArr2[i2];
                i++;
            }
            length = i2;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double[] values(double[] dArr) {
        int size = size();
        if (dArr.length < size) {
            dArr = new double[size];
        }
        double[] dArr2 = this._values;
        Object[] objArr = this._set;
        int length = dArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                break;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                dArr[i] = dArr2[i2];
                i++;
            }
            length = i2;
        }
        if (dArr.length > size) {
            dArr[size] = this.no_entry_value;
        }
        return dArr;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public TObjectDoubleIterator<K> iterator() {
        return new TObjectDoubleHashIterator(this);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean increment(K k) {
        return adjustValue(k, 1.0d);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean adjustValue(K k, double d) {
        int index = index(k);
        if (index < 0) {
            return false;
        }
        double[] dArr = this._values;
        dArr[index] = dArr[index] + d;
        return true;
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public double adjustOrPutValue(K k, double d, double d2) {
        int insertKey = insertKey(k);
        boolean z = true;
        if (insertKey < 0) {
            int i = (-insertKey) - 1;
            double[] dArr = this._values;
            double d3 = d + dArr[i];
            dArr[i] = d3;
            z = false;
            d2 = d3;
        } else {
            this._values[insertKey] = d2;
        }
        if (z) {
            postInsertHook(this.consumeFreeSlot);
        }
        return d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachKey(TObjectProcedure<? super K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachValue(TDoubleProcedure tDoubleProcedure) {
        Object[] objArr = this._set;
        double[] dArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tDoubleProcedure.execute(dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean forEachEntry(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure) {
        Object[] objArr = this._set;
        double[] dArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectDoubleProcedure.execute(objArr[i], dArr[i])) {
                return false;
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean retainEntries(TObjectDoubleProcedure<? super K> tObjectDoubleProcedure) {
        Object[] objArr = this._set;
        double[] dArr = this._values;
        tempDisableAutoCompaction();
        try {
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != FREE && objArr[i] != REMOVED && !tObjectDoubleProcedure.execute(objArr[i], dArr[i])) {
                    removeAt(i);
                    z = true;
                }
                length = i;
            }
        } finally {
            reenableAutoCompaction(true);
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public void transformValues(TDoubleFunction tDoubleFunction) {
        Object[] objArr = this._set;
        double[] dArr = this._values;
        int length = dArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i] != null && objArr[i] != REMOVED) {
                dArr[i] = tDoubleFunction.execute(dArr[i]);
            }
            length = i;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public boolean equals(Object obj) {
        if (!(obj instanceof TObjectDoubleMap)) {
            return false;
        }
        TObjectDoubleMap tObjectDoubleMap = (TObjectDoubleMap) obj;
        if (tObjectDoubleMap.size() != size()) {
            return false;
        }
        try {
            TObjectDoubleIterator<K> it = iterator();
            while (it.hasNext()) {
                it.advance();
                K key = it.key();
                double value = it.value();
                if (value == this.no_entry_value) {
                    if (tObjectDoubleMap.get(key) != tObjectDoubleMap.getNoEntryValue() || !tObjectDoubleMap.containsKey(key)) {
                        return false;
                    }
                } else if (value != tObjectDoubleMap.get(key)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return true;
        }
    }

    @Override // gnu.trove.map.TObjectDoubleMap
    public int hashCode() {
        Object[] objArr = this._set;
        double[] dArr = this._values;
        int length = dArr.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return i;
            }
            if (objArr[i2] != FREE && objArr[i2] != REMOVED) {
                i += HashFunctions.hash(dArr[i2]) ^ (objArr[i2] == null ? 0 : objArr[i2].hashCode());
            }
            length = i2;
        }
    }

    protected class KeyView extends TObjectDoubleHashMap<K>.MapBackedView<K> {
        protected KeyView() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new TObjectHashIterator(TObjectDoubleHashMap.this);
        }

        @Override // gnu.trove.map.hash.TObjectDoubleHashMap.MapBackedView
        public boolean removeElement(K k) {
            return TObjectDoubleHashMap.this.no_entry_value != TObjectDoubleHashMap.this.remove(k);
        }

        @Override // gnu.trove.map.hash.TObjectDoubleHashMap.MapBackedView
        public boolean containsElement(K k) {
            return TObjectDoubleHashMap.this.contains(k);
        }
    }

    private abstract class MapBackedView<E> extends AbstractSet<E> implements Set<E>, Iterable<E> {
        public abstract boolean containsElement(E e);

        public abstract boolean removeElement(E e);

        private MapBackedView() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return containsElement(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return removeElement(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TObjectDoubleHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TObjectDoubleHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            Iterator<E> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            }
            return objArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            Iterator<E> it = iterator();
            for (int i = 0; i < size; i++) {
                tArr[i] = it.next();
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return TObjectDoubleHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    class TDoubleValueCollection implements TDoubleCollection {
        TDoubleValueCollection() {
        }

        @Override // gnu.trove.TDoubleCollection
        public TDoubleIterator iterator() {
            return new TObjectDoubleValueHashIterator();
        }

        @Override // gnu.trove.TDoubleCollection
        public double getNoEntryValue() {
            return TObjectDoubleHashMap.this.no_entry_value;
        }

        @Override // gnu.trove.TDoubleCollection
        public int size() {
            return TObjectDoubleHashMap.this._size;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean isEmpty() {
            return TObjectDoubleHashMap.this._size == 0;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean contains(double d) {
            return TObjectDoubleHashMap.this.containsValue(d);
        }

        @Override // gnu.trove.TDoubleCollection
        public double[] toArray() {
            return TObjectDoubleHashMap.this.values();
        }

        @Override // gnu.trove.TDoubleCollection
        public double[] toArray(double[] dArr) {
            return TObjectDoubleHashMap.this.values(dArr);
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean add(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean remove(double d) {
            double[] dArr = TObjectDoubleHashMap.this._values;
            Object[] objArr = TObjectDoubleHashMap.this._set;
            int length = dArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return false;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && d == dArr[i]) {
                    TObjectDoubleHashMap.this.removeAt(i);
                    return true;
                }
                length = i;
            }
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean containsAll(Collection<?> collection) {
            for (Object obj : collection) {
                if (obj instanceof Double) {
                    if (!TObjectDoubleHashMap.this.containsValue(((Double) obj).doubleValue())) {
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
                if (!TObjectDoubleHashMap.this.containsValue(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean containsAll(double[] dArr) {
            for (double d : dArr) {
                if (!TObjectDoubleHashMap.this.containsValue(d)) {
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
            double[] dArr2 = TObjectDoubleHashMap.this._values;
            Object[] objArr = TObjectDoubleHashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if (objArr[i] != TObjectHash.FREE && objArr[i] != TObjectHash.REMOVED && Arrays.binarySearch(dArr, dArr2[i]) < 0) {
                    TObjectDoubleHashMap.this.removeAt(i);
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
            TObjectDoubleHashMap.this.clear();
        }

        @Override // gnu.trove.TDoubleCollection
        public boolean forEach(TDoubleProcedure tDoubleProcedure) {
            return TObjectDoubleHashMap.this.forEachValue(tDoubleProcedure);
        }

        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            TObjectDoubleHashMap.this.forEachValue(new TDoubleProcedure() { // from class: gnu.trove.map.hash.TObjectDoubleHashMap.TDoubleValueCollection.1
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

        class TObjectDoubleValueHashIterator implements TDoubleIterator {
            protected int _expectedSize;
            protected THash _hash;
            protected int _index;

            TObjectDoubleValueHashIterator() {
                TObjectDoubleHashMap tObjectDoubleHashMap = TObjectDoubleHashMap.this;
                this._hash = tObjectDoubleHashMap;
                this._expectedSize = tObjectDoubleHashMap.size();
                this._index = this._hash.capacity();
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public boolean hasNext() {
                return nextIndex() >= 0;
            }

            @Override // gnu.trove.iterator.TDoubleIterator
            public double next() {
                moveToNextIndex();
                return TObjectDoubleHashMap.this._values[this._index];
            }

            @Override // gnu.trove.iterator.TIterator, java.util.Iterator
            public void remove() {
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                try {
                    this._hash.tempDisableAutoCompaction();
                    TObjectDoubleHashMap.this.removeAt(this._index);
                    this._hash.reenableAutoCompaction(false);
                    this._expectedSize--;
                } catch (Throwable th) {
                    this._hash.reenableAutoCompaction(false);
                    throw th;
                }
            }

            protected final void moveToNextIndex() {
                int nextIndex = nextIndex();
                this._index = nextIndex;
                if (nextIndex < 0) {
                    throw new NoSuchElementException();
                }
            }

            protected final int nextIndex() {
                int i;
                if (this._expectedSize != this._hash.size()) {
                    throw new ConcurrentModificationException();
                }
                Object[] objArr = TObjectDoubleHashMap.this._set;
                int i2 = this._index;
                while (true) {
                    i = i2 - 1;
                    if (i2 <= 0 || !(objArr[i] == TObjectHash.FREE || objArr[i] == TObjectHash.REMOVED)) {
                        break;
                    }
                    i2 = i;
                }
                return i;
            }
        }
    }

    class TObjectDoubleHashIterator<K> extends TObjectHashIterator<K> implements TObjectDoubleIterator<K> {
        private final TObjectDoubleHashMap<K> _map;

        public TObjectDoubleHashIterator(TObjectDoubleHashMap<K> tObjectDoubleHashMap) {
            super(tObjectDoubleHashMap);
            this._map = tObjectDoubleHashMap;
        }

        @Override // gnu.trove.iterator.TAdvancingIterator
        public void advance() {
            moveToNextIndex();
        }

        @Override // gnu.trove.iterator.TObjectDoubleIterator
        public K key() {
            return (K) this._map._set[this._index];
        }

        @Override // gnu.trove.iterator.TObjectDoubleIterator
        public double value() {
            return this._map._values[this._index];
        }

        @Override // gnu.trove.iterator.TObjectDoubleIterator
        public double setValue(double d) {
            double value = value();
            this._map._values[this._index] = d;
            return value;
        }
    }

    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        super.writeExternal(objectOutput);
        objectOutput.writeDouble(this.no_entry_value);
        objectOutput.writeInt(this._size);
        int length = this._set.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (this._set[i] != REMOVED && this._set[i] != FREE) {
                objectOutput.writeObject(this._set[i]);
                objectOutput.writeDouble(this._values[i]);
            }
            length = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gnu.trove.impl.hash.TObjectHash, gnu.trove.impl.hash.THash, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        super.readExternal(objectInput);
        this.no_entry_value = objectInput.readDouble();
        int readInt = objectInput.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt <= 0) {
                return;
            }
            put(objectInput.readObject(), objectInput.readDouble());
            readInt = i;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        forEachEntry(new TObjectDoubleProcedure<K>() { // from class: gnu.trove.map.hash.TObjectDoubleHashMap.2
            private boolean first = true;

            @Override // gnu.trove.procedure.TObjectDoubleProcedure
            public boolean execute(K k, double d) {
                if (this.first) {
                    this.first = false;
                } else {
                    sb.append(",");
                }
                sb.append(k).append("=").append(d);
                return true;
            }
        });
        sb.append(StringSubstitutor.DEFAULT_VAR_END);
        return sb.toString();
    }
}

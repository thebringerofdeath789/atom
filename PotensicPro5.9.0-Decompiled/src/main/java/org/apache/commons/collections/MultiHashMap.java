package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.iterators.EmptyIterator;

/* loaded from: classes4.dex */
public class MultiHashMap extends HashMap implements MultiMap {
    private static final long serialVersionUID = 1943563828307035349L;
    private transient Collection values;

    public MultiHashMap() {
        this.values = null;
    }

    public MultiHashMap(int i) {
        super(i);
        this.values = null;
    }

    public MultiHashMap(int i, float f) {
        super(i, f);
        this.values = null;
    }

    public MultiHashMap(Map map) {
        super((int) (map.size() * 1.4f));
        this.values = null;
        putAll(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        String str;
        objectInputStream.defaultReadObject();
        try {
            str = System.getProperty("java.version");
        } catch (SecurityException unused) {
            str = "1.2";
        }
        if (str.startsWith("1.2") || str.startsWith("1.3")) {
            for (Map.Entry entry : entrySet()) {
                super.put(entry.getKey(), ((Collection) entry.getValue()).iterator().next());
            }
        }
    }

    public int totalSize() {
        Iterator it = super.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Collection) it.next()).size();
        }
        return i;
    }

    public Collection getCollection(Object obj) {
        return (Collection) get(obj);
    }

    public int size(Object obj) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public Iterator iterator(Object obj) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return EmptyIterator.INSTANCE;
        }
        return collection.iterator();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    public Object put(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            collection = createCollection(null);
            super.put(obj, collection);
        }
        if (collection.add(obj2)) {
            return obj2;
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        if (map instanceof MultiMap) {
            for (Map.Entry entry : map.entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry entry2 : map.entrySet()) {
            put(entry2.getKey(), entry2.getValue());
        }
    }

    public boolean putAll(Object obj, Collection collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        Collection collection2 = getCollection(obj);
        if (collection2 == null) {
            Collection createCollection = createCollection(collection);
            if (createCollection.size() == 0) {
                return false;
            }
            super.put(obj, createCollection);
            return true;
        }
        return collection2.addAll(collection);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    public boolean containsValue(Object obj) {
        Set entrySet = super.entrySet();
        if (entrySet == null) {
            return false;
        }
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            if (((Collection) ((Map.Entry) it.next()).getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    @Override // java.util.HashMap, java.util.Map, org.apache.commons.collections.MultiMap
    public Object remove(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return null;
        }
        if (collection.isEmpty()) {
            remove(obj);
        }
        return obj2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator it = super.entrySet().iterator();
        while (it.hasNext()) {
            ((Collection) ((Map.Entry) it.next()).getValue()).clear();
        }
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    Iterator superValuesIterator() {
        return super.values().iterator();
    }

    private class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MultiHashMap.this.clear();
        }
    }

    private class ValueIterator implements Iterator {
        private Iterator backedIterator;
        private Iterator tempIterator;

        private ValueIterator() {
            this.backedIterator = MultiHashMap.this.superValuesIterator();
        }

        private boolean searchNextIterator() {
            while (true) {
                Iterator it = this.tempIterator;
                if (it != null && it.hasNext()) {
                    return true;
                }
                if (!this.backedIterator.hasNext()) {
                    return false;
                }
                this.tempIterator = ((Collection) this.backedIterator.next()).iterator();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return searchNextIterator();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!searchNextIterator()) {
                throw new NoSuchElementException();
            }
            return this.tempIterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator it = this.tempIterator;
            if (it == null) {
                throw new IllegalStateException();
            }
            it.remove();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public Object clone() {
        MultiHashMap multiHashMap = (MultiHashMap) super.clone();
        for (Map.Entry entry : multiHashMap.entrySet()) {
            entry.setValue(createCollection((Collection) entry.getValue()));
        }
        return multiHashMap;
    }

    protected Collection createCollection(Collection collection) {
        if (collection == null) {
            return new ArrayList();
        }
        return new ArrayList(collection);
    }
}

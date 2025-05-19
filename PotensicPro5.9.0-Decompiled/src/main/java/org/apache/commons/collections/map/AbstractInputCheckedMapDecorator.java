package org.apache.commons.collections.map;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections.set.AbstractSetDecorator;

/* loaded from: classes4.dex */
abstract class AbstractInputCheckedMapDecorator extends AbstractMapDecorator {
    protected abstract Object checkSetValue(Object obj);

    protected boolean isSetValueChecking() {
        return true;
    }

    protected AbstractInputCheckedMapDecorator() {
    }

    protected AbstractInputCheckedMapDecorator(Map map) {
        super(map);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set entrySet() {
        if (isSetValueChecking()) {
            return new EntrySet(this.map.entrySet(), this);
        }
        return this.map.entrySet();
    }

    static class EntrySet extends AbstractSetDecorator {
        private final AbstractInputCheckedMapDecorator parent;

        protected EntrySet(Set set, AbstractInputCheckedMapDecorator abstractInputCheckedMapDecorator) {
            super(set);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
        public Iterator iterator() {
            return new EntrySetIterator(this.collection.iterator(), this.parent);
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
        public Object[] toArray() {
            Object[] array = this.collection.toArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = new MapEntry((Map.Entry) array[i], this.parent);
            }
            return array;
        }

        @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            Object[] array = this.collection.toArray(objArr.length > 0 ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 0) : objArr);
            for (int i = 0; i < array.length; i++) {
                array[i] = new MapEntry((Map.Entry) array[i], this.parent);
            }
            if (array.length > objArr.length) {
                return array;
            }
            System.arraycopy(array, 0, objArr, 0, array.length);
            if (objArr.length > array.length) {
                objArr[array.length] = null;
            }
            return objArr;
        }
    }

    static class EntrySetIterator extends AbstractIteratorDecorator {
        private final AbstractInputCheckedMapDecorator parent;

        protected EntrySetIterator(Iterator it, AbstractInputCheckedMapDecorator abstractInputCheckedMapDecorator) {
            super(it);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            return new MapEntry((Map.Entry) this.iterator.next(), this.parent);
        }
    }

    static class MapEntry extends AbstractMapEntryDecorator {
        private final AbstractInputCheckedMapDecorator parent;

        protected MapEntry(Map.Entry entry, AbstractInputCheckedMapDecorator abstractInputCheckedMapDecorator) {
            super(entry);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public Object setValue(Object obj) {
            return this.entry.setValue(this.parent.checkSetValue(obj));
        }
    }
}

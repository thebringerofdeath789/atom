package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
public class FastArrayList extends ArrayList {
    protected boolean fast = false;
    protected ArrayList list;

    public FastArrayList() {
        this.list = null;
        this.list = new ArrayList();
    }

    public FastArrayList(int i) {
        this.list = null;
        this.list = new ArrayList(i);
    }

    public FastArrayList(Collection collection) {
        this.list = null;
        this.list = new ArrayList(collection);
    }

    public boolean getFast() {
        return this.fast;
    }

    public void setFast(boolean z) {
        this.fast = z;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        boolean add;
        boolean add2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                add2 = arrayList.add(obj);
                this.list = arrayList;
            }
            return add2;
        }
        synchronized (this.list) {
            add = this.list.add(obj);
        }
        return add;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.add(i, obj);
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.add(i, obj);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        boolean addAll;
        boolean addAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                addAll2 = arrayList.addAll(collection);
                this.list = arrayList;
            }
            return addAll2;
        }
        synchronized (this.list) {
            addAll = this.list.addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        boolean addAll;
        boolean addAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                addAll2 = arrayList.addAll(i, collection);
                this.list = arrayList;
            }
            return addAll2;
        }
        synchronized (this.list) {
            addAll = this.list.addAll(i, collection);
        }
        return addAll;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.clear();
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.clear();
        }
    }

    @Override // java.util.ArrayList
    public Object clone() {
        FastArrayList fastArrayList;
        FastArrayList fastArrayList2;
        if (this.fast) {
            fastArrayList2 = new FastArrayList(this.list);
        } else {
            synchronized (this.list) {
                fastArrayList = new FastArrayList(this.list);
            }
            fastArrayList2 = fastArrayList;
        }
        fastArrayList2.setFast(getFast());
        return fastArrayList2;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        boolean contains;
        if (this.fast) {
            return this.list.contains(obj);
        }
        synchronized (this.list) {
            contains = this.list.contains(obj);
        }
        return contains;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection collection) {
        boolean containsAll;
        if (this.fast) {
            return this.list.containsAll(collection);
        }
        synchronized (this.list) {
            containsAll = this.list.containsAll(collection);
        }
        return containsAll;
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int i) {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.ensureCapacity(i);
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.ensureCapacity(i);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (this.fast) {
            ListIterator listIterator = this.list.listIterator();
            ListIterator listIterator2 = list.listIterator();
            while (listIterator.hasNext() && listIterator2.hasNext()) {
                Object next = listIterator.next();
                Object next2 = listIterator2.next();
                if (next == null) {
                    if (next2 != null) {
                        return false;
                    }
                } else if (!next.equals(next2)) {
                    return false;
                }
            }
            return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
        }
        synchronized (this.list) {
            ListIterator listIterator3 = this.list.listIterator();
            ListIterator listIterator4 = list.listIterator();
            while (listIterator3.hasNext() && listIterator4.hasNext()) {
                Object next3 = listIterator3.next();
                Object next4 = listIterator4.next();
                if (next3 == null) {
                    if (next4 != null) {
                        return false;
                    }
                } else if (!next3.equals(next4)) {
                    return false;
                }
            }
            if (listIterator3.hasNext() || listIterator4.hasNext()) {
                z = false;
            }
            return z;
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object get(int i) {
        Object obj;
        if (this.fast) {
            return this.list.get(i);
        }
        synchronized (this.list) {
            obj = this.list.get(i);
        }
        return obj;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        if (this.fast) {
            Iterator it = this.list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                i = (i * 31) + (next == null ? 0 : next.hashCode());
            }
            return i;
        }
        synchronized (this.list) {
            Iterator it2 = this.list.iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                i = (i * 31) + (next2 == null ? 0 : next2.hashCode());
            }
        }
        return i;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int indexOf;
        if (this.fast) {
            return this.list.indexOf(obj);
        }
        synchronized (this.list) {
            indexOf = this.list.indexOf(obj);
        }
        return indexOf;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        boolean isEmpty;
        if (this.fast) {
            return this.list.isEmpty();
        }
        synchronized (this.list) {
            isEmpty = this.list.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        if (this.fast) {
            return new ListIter(0);
        }
        return this.list.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        if (this.fast) {
            return this.list.lastIndexOf(obj);
        }
        synchronized (this.list) {
            lastIndexOf = this.list.lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        if (this.fast) {
            return new ListIter(0);
        }
        return this.list.listIterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        if (this.fast) {
            return new ListIter(i);
        }
        return this.list.listIterator(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        Object remove;
        Object remove2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                remove2 = arrayList.remove(i);
                this.list = arrayList;
            }
            return remove2;
        }
        synchronized (this.list) {
            remove = this.list.remove(i);
        }
        return remove;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        boolean remove;
        boolean remove2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                remove2 = arrayList.remove(obj);
                this.list = arrayList;
            }
            return remove2;
        }
        synchronized (this.list) {
            remove = this.list.remove(obj);
        }
        return remove;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        boolean removeAll;
        boolean removeAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                removeAll2 = arrayList.removeAll(collection);
                this.list = arrayList;
            }
            return removeAll2;
        }
        synchronized (this.list) {
            removeAll = this.list.removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        boolean retainAll;
        boolean retainAll2;
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                retainAll2 = arrayList.retainAll(collection);
                this.list = arrayList;
            }
            return retainAll2;
        }
        synchronized (this.list) {
            retainAll = this.list.retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        Object obj2;
        if (this.fast) {
            return this.list.set(i, obj);
        }
        synchronized (this.list) {
            obj2 = this.list.set(i, obj);
        }
        return obj2;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int size;
        if (this.fast) {
            return this.list.size();
        }
        synchronized (this.list) {
            size = this.list.size();
        }
        return size;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List subList(int i, int i2) {
        if (this.fast) {
            return new SubList(i, i2);
        }
        return this.list.subList(i, i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] array;
        if (this.fast) {
            return this.list.toArray();
        }
        synchronized (this.list) {
            array = this.list.toArray();
        }
        return array;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        Object[] array;
        if (this.fast) {
            return this.list.toArray(objArr);
        }
        synchronized (this.list) {
            array = this.list.toArray(objArr);
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("FastArrayList[");
        stringBuffer.append(this.list.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        if (this.fast) {
            synchronized (this) {
                ArrayList arrayList = (ArrayList) this.list.clone();
                arrayList.trimToSize();
                this.list = arrayList;
            }
            return;
        }
        synchronized (this.list) {
            this.list.trimToSize();
        }
    }

    private class SubList implements List {
        private List expected;
        private int first;
        private int last;

        static /* synthetic */ int access$208(SubList subList) {
            int i = subList.last;
            subList.last = i + 1;
            return i;
        }

        static /* synthetic */ int access$210(SubList subList) {
            int i = subList.last;
            subList.last = i - 1;
            return i;
        }

        public SubList(int i, int i2) {
            this.first = i;
            this.last = i2;
            this.expected = FastArrayList.this.list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List get(List list) {
            if (FastArrayList.this.list != this.expected) {
                throw new ConcurrentModificationException();
            }
            return list.subList(this.first, this.last);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    get(arrayList).clear();
                    this.last = this.first;
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return;
            }
            synchronized (FastArrayList.this.list) {
                get(this.expected).clear();
            }
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            boolean remove;
            boolean remove2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    remove2 = get(arrayList).remove(obj);
                    if (remove2) {
                        this.last--;
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return remove2;
            }
            synchronized (FastArrayList.this.list) {
                remove = get(this.expected).remove(obj);
            }
            return remove;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            boolean removeAll;
            boolean removeAll2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    List list = get(arrayList);
                    removeAll2 = list.removeAll(collection);
                    if (removeAll2) {
                        this.last = this.first + list.size();
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return removeAll2;
            }
            synchronized (FastArrayList.this.list) {
                removeAll = get(this.expected).removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            boolean retainAll;
            boolean retainAll2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    List list = get(arrayList);
                    retainAll2 = list.retainAll(collection);
                    if (retainAll2) {
                        this.last = this.first + list.size();
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return retainAll2;
            }
            synchronized (FastArrayList.this.list) {
                retainAll = get(this.expected).retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.List, java.util.Collection
        public int size() {
            int size;
            if (FastArrayList.this.fast) {
                return get(this.expected).size();
            }
            synchronized (FastArrayList.this.list) {
                size = get(this.expected).size();
            }
            return size;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            if (FastArrayList.this.fast) {
                return get(this.expected).isEmpty();
            }
            synchronized (FastArrayList.this.list) {
                isEmpty = get(this.expected).isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            boolean contains;
            if (FastArrayList.this.fast) {
                return get(this.expected).contains(obj);
            }
            synchronized (FastArrayList.this.list) {
                contains = get(this.expected).contains(obj);
            }
            return contains;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            boolean containsAll;
            if (FastArrayList.this.fast) {
                return get(this.expected).containsAll(collection);
            }
            synchronized (FastArrayList.this.list) {
                containsAll = get(this.expected).containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            Object[] array;
            if (FastArrayList.this.fast) {
                return get(this.expected).toArray(objArr);
            }
            synchronized (FastArrayList.this.list) {
                array = get(this.expected).toArray(objArr);
            }
            return array;
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            Object[] array;
            if (FastArrayList.this.fast) {
                return get(this.expected).toArray();
            }
            synchronized (FastArrayList.this.list) {
                array = get(this.expected).toArray();
            }
            return array;
        }

        @Override // java.util.List, java.util.Collection
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            if (FastArrayList.this.fast) {
                return get(this.expected).equals(obj);
            }
            synchronized (FastArrayList.this.list) {
                equals = get(this.expected).equals(obj);
            }
            return equals;
        }

        @Override // java.util.List, java.util.Collection
        public int hashCode() {
            int hashCode;
            if (FastArrayList.this.fast) {
                return get(this.expected).hashCode();
            }
            synchronized (FastArrayList.this.list) {
                hashCode = get(this.expected).hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            boolean add;
            boolean add2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    add2 = get(arrayList).add(obj);
                    if (add2) {
                        this.last++;
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return add2;
            }
            synchronized (FastArrayList.this.list) {
                add = get(this.expected).add(obj);
            }
            return add;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            boolean addAll;
            boolean addAll2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    addAll2 = get(arrayList).addAll(collection);
                    if (addAll2) {
                        this.last += collection.size();
                    }
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return addAll2;
            }
            synchronized (FastArrayList.this.list) {
                addAll = get(this.expected).addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    get(arrayList).add(i, obj);
                    this.last++;
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return;
            }
            synchronized (FastArrayList.this.list) {
                get(this.expected).add(i, obj);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            boolean addAll;
            boolean addAll2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    addAll2 = get(arrayList).addAll(i, collection);
                    FastArrayList.this.list = arrayList;
                    if (addAll2) {
                        this.last += collection.size();
                    }
                    this.expected = arrayList;
                }
                return addAll2;
            }
            synchronized (FastArrayList.this.list) {
                addAll = get(this.expected).addAll(i, collection);
            }
            return addAll;
        }

        @Override // java.util.List
        public Object remove(int i) {
            Object remove;
            Object remove2;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    remove2 = get(arrayList).remove(i);
                    this.last--;
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return remove2;
            }
            synchronized (FastArrayList.this.list) {
                remove = get(this.expected).remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            Object obj2;
            Object obj3;
            if (FastArrayList.this.fast) {
                synchronized (FastArrayList.this) {
                    ArrayList arrayList = (ArrayList) FastArrayList.this.list.clone();
                    obj3 = get(arrayList).set(i, obj);
                    FastArrayList.this.list = arrayList;
                    this.expected = arrayList;
                }
                return obj3;
            }
            synchronized (FastArrayList.this.list) {
                obj2 = get(this.expected).set(i, obj);
            }
            return obj2;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new SubListIter(0);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new SubListIter(0);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return new SubListIter(i);
        }

        @Override // java.util.List
        public Object get(int i) {
            Object obj;
            if (FastArrayList.this.fast) {
                return get(this.expected).get(i);
            }
            synchronized (FastArrayList.this.list) {
                obj = get(this.expected).get(i);
            }
            return obj;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (FastArrayList.this.fast) {
                return get(this.expected).indexOf(obj);
            }
            synchronized (FastArrayList.this.list) {
                indexOf = get(this.expected).indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (FastArrayList.this.fast) {
                return get(this.expected).lastIndexOf(obj);
            }
            synchronized (FastArrayList.this.list) {
                lastIndexOf = get(this.expected).lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            if (FastArrayList.this.list != this.expected) {
                throw new ConcurrentModificationException();
            }
            return FastArrayList.this.new SubList(this.first + i, i + i2);
        }

        private class SubListIter implements ListIterator {
            private List expected;
            private ListIterator iter;
            private int lastReturnedIndex = -1;

            public SubListIter(int i) {
                ArrayList arrayList = FastArrayList.this.list;
                this.expected = arrayList;
                this.iter = SubList.this.get(arrayList).listIterator(i);
            }

            private void checkMod() {
                if (FastArrayList.this.list != this.expected) {
                    throw new ConcurrentModificationException();
                }
            }

            List get() {
                return SubList.this.get(this.expected);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                checkMod();
                return this.iter.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                checkMod();
                this.lastReturnedIndex = this.iter.nextIndex();
                return this.iter.next();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                checkMod();
                return this.iter.hasPrevious();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                checkMod();
                this.lastReturnedIndex = this.iter.previousIndex();
                return this.iter.previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                checkMod();
                return this.iter.previousIndex();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                checkMod();
                return this.iter.nextIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                checkMod();
                if (this.lastReturnedIndex < 0) {
                    throw new IllegalStateException();
                }
                get().remove(this.lastReturnedIndex);
                SubList.access$210(SubList.this);
                this.expected = FastArrayList.this.list;
                this.iter = get().listIterator(this.lastReturnedIndex);
                this.lastReturnedIndex = -1;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                checkMod();
                if (this.lastReturnedIndex < 0) {
                    throw new IllegalStateException();
                }
                get().set(this.lastReturnedIndex, obj);
                this.expected = FastArrayList.this.list;
                this.iter = get().listIterator(previousIndex() + 1);
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                checkMod();
                int nextIndex = nextIndex();
                get().add(nextIndex, obj);
                SubList.access$208(SubList.this);
                this.expected = FastArrayList.this.list;
                this.iter = get().listIterator(nextIndex + 1);
                this.lastReturnedIndex = -1;
            }
        }
    }

    private class ListIter implements ListIterator {
        private List expected;
        private ListIterator iter;
        private int lastReturnedIndex = -1;

        public ListIter(int i) {
            this.expected = FastArrayList.this.list;
            this.iter = get().listIterator(i);
        }

        private void checkMod() {
            if (FastArrayList.this.list != this.expected) {
                throw new ConcurrentModificationException();
            }
        }

        List get() {
            return this.expected;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            this.lastReturnedIndex = this.iter.nextIndex();
            return this.iter.next();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.iter.hasPrevious();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            this.lastReturnedIndex = this.iter.previousIndex();
            return this.iter.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.iter.previousIndex();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.iter.nextIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkMod();
            if (this.lastReturnedIndex < 0) {
                throw new IllegalStateException();
            }
            get().remove(this.lastReturnedIndex);
            this.expected = FastArrayList.this.list;
            this.iter = get().listIterator(this.lastReturnedIndex);
            this.lastReturnedIndex = -1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            checkMod();
            if (this.lastReturnedIndex < 0) {
                throw new IllegalStateException();
            }
            get().set(this.lastReturnedIndex, obj);
            this.expected = FastArrayList.this.list;
            this.iter = get().listIterator(previousIndex() + 1);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            checkMod();
            int nextIndex = nextIndex();
            get().add(nextIndex, obj);
            this.expected = FastArrayList.this.list;
            this.iter = get().listIterator(nextIndex + 1);
            this.lastReturnedIndex = -1;
        }
    }
}

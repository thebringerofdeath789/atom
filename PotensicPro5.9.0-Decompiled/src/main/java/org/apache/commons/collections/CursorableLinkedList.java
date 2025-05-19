package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public class CursorableLinkedList implements List, Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    protected transient int _size = 0;
    protected transient Listable _head = new Listable(null, null, null);
    protected transient int _modCount = 0;
    protected transient List _cursors = new ArrayList();

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        insertListable(this._head.prev(), null, obj);
        return true;
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        int i2 = this._size;
        if (i == i2) {
            add(obj);
        } else {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append(String.valueOf(i)).append(" < 0 or ").append(String.valueOf(i)).append(" > ").append(this._size).toString());
            }
            Listable listableAt = isEmpty() ? null : getListableAt(i);
            insertListable(listableAt != null ? listableAt.prev() : null, listableAt, obj);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            insertListable(this._head.prev(), null, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i2 = this._size;
        if (i2 == i || i2 == 0) {
            return addAll(collection);
        }
        Listable listableAt = getListableAt(i);
        Listable prev = listableAt == null ? null : listableAt.prev();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            prev = insertListable(prev, listableAt, it.next());
        }
        return true;
    }

    public boolean addFirst(Object obj) {
        insertListable(null, this._head.next(), obj);
        return true;
    }

    public boolean addLast(Object obj) {
        insertListable(this._head.prev(), null, obj);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Iterator it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            if (obj == null && next.value() == null) {
                return true;
            }
            if (obj != null && obj.equals(next.value())) {
                return true;
            }
            listable = next;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Cursor cursor() {
        return new Cursor(this, 0);
    }

    public Cursor cursor(int i) {
        return new Cursor(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        ListIterator listIterator = ((List) obj).listIterator();
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            if (listIterator.hasNext()) {
                if (next.value() == null) {
                    if (listIterator.next() == null) {
                        listable = next;
                    }
                } else if (next.value().equals(listIterator.next())) {
                    listable = next;
                }
            }
            return false;
        }
        return !listIterator.hasNext();
    }

    @Override // java.util.List
    public Object get(int i) {
        return getListableAt(i).value();
    }

    public Object getFirst() {
        try {
            return this._head.next().value();
        } catch (NullPointerException unused) {
            throw new NoSuchElementException();
        }
    }

    public Object getLast() {
        try {
            return this._head.prev().value();
        } catch (NullPointerException unused) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int i = 1;
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            i = (i * 31) + (next.value() == null ? 0 : next.value().hashCode());
            listable = next;
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Listable listable = null;
        int i = 0;
        if (obj == null) {
            Listable next = this._head.next();
            while (true) {
                Listable listable2 = listable;
                listable = next;
                if (listable == null || listable2 == this._head.prev()) {
                    return -1;
                }
                if (listable.value() == null) {
                    return i;
                }
                i++;
                next = listable.next();
            }
        } else {
            Listable listable3 = null;
            int i2 = 0;
            for (Listable next2 = this._head.next(); next2 != null && listable3 != this._head.prev(); next2 = next2.next()) {
                if (obj.equals(next2.value())) {
                    return i2;
                }
                i2++;
                listable3 = next2;
            }
            return -1;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this._size - 1;
        Listable listable = null;
        if (obj == null) {
            Listable prev = this._head.prev();
            while (true) {
                Listable listable2 = listable;
                listable = prev;
                if (listable == null || listable2 == this._head.next()) {
                    return -1;
                }
                if (listable.value() == null) {
                    return i;
                }
                i--;
                prev = listable.prev();
            }
        } else {
            Listable prev2 = this._head.prev();
            while (true) {
                Listable listable3 = prev2;
                Listable listable4 = listable;
                listable = listable3;
                if (listable == null || listable4 == this._head.next()) {
                    return -1;
                }
                if (obj.equals(listable.value())) {
                    return i;
                }
                i--;
                prev2 = listable.prev();
            }
        }
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append(i).append(" < 0 or > ").append(this._size).toString());
        }
        return new ListIter(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            if (obj == null && next.value() == null) {
                removeListable(next);
                return true;
            }
            if (obj == null || !obj.equals(next.value())) {
                listable = next;
            } else {
                removeListable(next);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public Object remove(int i) {
        Listable listableAt = getListableAt(i);
        Object value = listableAt.value();
        removeListable(listableAt);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        boolean z = false;
        if (collection.size() != 0 && this._size != 0) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    public Object removeFirst() {
        if (this._head.next() != null) {
            Object value = this._head.next().value();
            removeListable(this._head.next());
            return value;
        }
        throw new NoSuchElementException();
    }

    public Object removeLast() {
        if (this._head.prev() != null) {
            Object value = this._head.prev().value();
            removeListable(this._head.prev());
            return value;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        Iterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        Listable listableAt = getListableAt(i);
        Object value = listableAt.setValue(obj);
        broadcastListableChanged(listableAt);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this._size;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this._size];
        Listable next = this._head.next();
        int i = 0;
        Listable listable = null;
        while (next != null && listable != this._head.prev()) {
            objArr[i] = next.value();
            listable = next;
            next = next.next();
            i++;
        }
        return objArr;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this._size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this._size);
        }
        int i = 0;
        Listable next = this._head.next();
        Listable listable = null;
        while (next != null && listable != this._head.prev()) {
            objArr[i] = next.value();
            Listable listable2 = next;
            next = next.next();
            i++;
            listable = listable2;
        }
        int length = objArr.length;
        int i2 = this._size;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        Listable listable = null;
        for (Listable next = this._head.next(); next != null && listable != this._head.prev(); next = next.next()) {
            if (this._head.next() != next) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(next.value());
            listable = next;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        int i3;
        if (i < 0 || i2 > (i3 = this._size) || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        return (i == 0 && i2 == i3) ? this : new CursorableSubList(this, i, i2);
    }

    protected Listable insertListable(Listable listable, Listable listable2, Object obj) {
        this._modCount++;
        this._size++;
        Listable listable3 = new Listable(listable, listable2, obj);
        if (listable != null) {
            listable.setNext(listable3);
        } else {
            this._head.setNext(listable3);
        }
        if (listable2 != null) {
            listable2.setPrev(listable3);
        } else {
            this._head.setPrev(listable3);
        }
        broadcastListableInserted(listable3);
        return listable3;
    }

    protected void removeListable(Listable listable) {
        this._modCount++;
        this._size--;
        if (this._head.next() == listable) {
            this._head.setNext(listable.next());
        }
        if (listable.next() != null) {
            listable.next().setPrev(listable.prev());
        }
        if (this._head.prev() == listable) {
            this._head.setPrev(listable.prev());
        }
        if (listable.prev() != null) {
            listable.prev().setNext(listable.next());
        }
        broadcastListableRemoved(listable);
    }

    protected Listable getListableAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            throw new IndexOutOfBoundsException(new StringBuffer().append(String.valueOf(i)).append(" < 0 or ").append(String.valueOf(i)).append(" >= ").append(this._size).toString());
        }
        if (i <= i2 / 2) {
            Listable next = this._head.next();
            for (int i3 = 0; i3 < i; i3++) {
                next = next.next();
            }
            return next;
        }
        Listable prev = this._head.prev();
        for (int i4 = this._size - 1; i4 > i; i4--) {
            prev = prev.prev();
        }
        return prev;
    }

    protected void registerCursor(Cursor cursor) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        this._cursors.add(new WeakReference(cursor));
    }

    protected void unregisterCursor(Cursor cursor) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Cursor cursor2 = (Cursor) weakReference.get();
            if (cursor2 == null) {
                it.remove();
            } else if (cursor2 == cursor) {
                weakReference.clear();
                it.remove();
                return;
            }
        }
    }

    protected void invalidateCursors() {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Cursor cursor = (Cursor) weakReference.get();
            if (cursor != null) {
                cursor.invalidate();
                weakReference.clear();
            }
            it.remove();
        }
    }

    protected void broadcastListableChanged(Listable listable) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.listableChanged(listable);
            }
        }
    }

    protected void broadcastListableRemoved(Listable listable) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.listableRemoved(listable);
            }
        }
    }

    protected void broadcastListableInserted(Listable listable) {
        Iterator it = this._cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.listableInserted(listable);
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this._size);
        for (Listable next = this._head.next(); next != null; next = next.next()) {
            objectOutputStream.writeObject(next.value());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this._size = 0;
        this._modCount = 0;
        this._cursors = new ArrayList();
        this._head = new Listable(null, null, null);
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            add(objectInputStream.readObject());
        }
    }

    static class Listable implements Serializable {
        private Listable _next;
        private Listable _prev;
        private Object _val;

        Listable(Listable listable, Listable listable2, Object obj) {
            this._prev = null;
            this._next = null;
            this._val = null;
            this._prev = listable;
            this._next = listable2;
            this._val = obj;
        }

        Listable next() {
            return this._next;
        }

        Listable prev() {
            return this._prev;
        }

        Object value() {
            return this._val;
        }

        void setNext(Listable listable) {
            this._next = listable;
        }

        void setPrev(Listable listable) {
            this._prev = listable;
        }

        Object setValue(Object obj) {
            Object obj2 = this._val;
            this._val = obj;
            return obj2;
        }
    }

    class ListIter implements ListIterator {
        Listable _cur;
        int _expectedModCount;
        Listable _lastReturned = null;
        int _nextIndex;

        ListIter(int i) {
            this._cur = null;
            this._expectedModCount = CursorableLinkedList.this._modCount;
            this._nextIndex = 0;
            if (i == 0) {
                this._cur = new Listable(null, CursorableLinkedList.this._head.next(), null);
                this._nextIndex = 0;
            } else if (i == CursorableLinkedList.this._size) {
                this._cur = new Listable(CursorableLinkedList.this._head.prev(), null, null);
                this._nextIndex = CursorableLinkedList.this._size;
            } else {
                Listable listableAt = CursorableLinkedList.this.getListableAt(i);
                this._cur = new Listable(listableAt.prev(), listableAt, null);
                this._nextIndex = i;
            }
        }

        @Override // java.util.ListIterator
        public Object previous() {
            checkForComod();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Object value = this._cur.prev().value();
            this._lastReturned = this._cur.prev();
            Listable listable = this._cur;
            listable.setNext(listable.prev());
            Listable listable2 = this._cur;
            listable2.setPrev(listable2.prev().prev());
            this._nextIndex--;
            return value;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            checkForComod();
            return (this._cur.next() == null || this._cur.prev() == CursorableLinkedList.this._head.prev()) ? false : true;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            checkForComod();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object value = this._cur.next().value();
            this._lastReturned = this._cur.next();
            Listable listable = this._cur;
            listable.setPrev(listable.next());
            Listable listable2 = this._cur;
            listable2.setNext(listable2.next().next());
            this._nextIndex++;
            return value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            checkForComod();
            if (hasPrevious()) {
                return this._nextIndex - 1;
            }
            return -1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            checkForComod();
            return (this._cur.prev() == null || this._cur.next() == CursorableLinkedList.this._head.next()) ? false : true;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            checkForComod();
            try {
                this._lastReturned.setValue(obj);
            } catch (NullPointerException unused) {
                throw new IllegalStateException();
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            checkForComod();
            if (!hasNext()) {
                return CursorableLinkedList.this.size();
            }
            return this._nextIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComod();
            Listable listable = this._lastReturned;
            if (listable == null) {
                throw new IllegalStateException();
            }
            this._cur.setNext(listable == CursorableLinkedList.this._head.prev() ? null : this._lastReturned.next());
            this._cur.setPrev(this._lastReturned == CursorableLinkedList.this._head.next() ? null : this._lastReturned.prev());
            CursorableLinkedList.this.removeListable(this._lastReturned);
            this._lastReturned = null;
            this._nextIndex--;
            this._expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            checkForComod();
            Listable listable = this._cur;
            listable.setPrev(CursorableLinkedList.this.insertListable(listable.prev(), this._cur.next(), obj));
            this._lastReturned = null;
            this._nextIndex++;
            this._expectedModCount++;
        }

        protected void checkForComod() {
            if (this._expectedModCount != CursorableLinkedList.this._modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public class Cursor extends ListIter implements ListIterator {
        boolean _valid;
        private final /* synthetic */ CursorableLinkedList this$0;

        Cursor(CursorableLinkedList cursorableLinkedList, int i) {
            super(i);
            this.this$0 = cursorableLinkedList;
            this._valid = false;
            this._valid = true;
            cursorableLinkedList.registerCursor(this);
        }

        @Override // org.apache.commons.collections.CursorableLinkedList.ListIter, java.util.ListIterator
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections.CursorableLinkedList.ListIter, java.util.ListIterator
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections.CursorableLinkedList.ListIter, java.util.ListIterator
        public void add(Object obj) {
            checkForComod();
            Listable insertListable = this.this$0.insertListable(this._cur.prev(), this._cur.next(), obj);
            this._cur.setPrev(insertListable);
            this._cur.setNext(insertListable.next());
            this._lastReturned = null;
            this._nextIndex++;
            this._expectedModCount++;
        }

        protected void listableRemoved(Listable listable) {
            if (this.this$0._head.prev() == null) {
                this._cur.setNext(null);
            } else if (this._cur.next() == listable) {
                this._cur.setNext(listable.next());
            }
            if (this.this$0._head.next() == null) {
                this._cur.setPrev(null);
            } else if (this._cur.prev() == listable) {
                this._cur.setPrev(listable.prev());
            }
            if (this._lastReturned == listable) {
                this._lastReturned = null;
            }
        }

        protected void listableInserted(Listable listable) {
            if (this._cur.next() == null && this._cur.prev() == null) {
                this._cur.setNext(listable);
            } else if (this._cur.prev() == listable.prev()) {
                this._cur.setNext(listable);
            }
            if (this._cur.next() == listable.next()) {
                this._cur.setPrev(listable);
            }
            if (this._lastReturned == listable) {
                this._lastReturned = null;
            }
        }

        protected void listableChanged(Listable listable) {
            if (this._lastReturned == listable) {
                this._lastReturned = null;
            }
        }

        @Override // org.apache.commons.collections.CursorableLinkedList.ListIter
        protected void checkForComod() {
            if (!this._valid) {
                throw new ConcurrentModificationException();
            }
        }

        protected void invalidate() {
            this._valid = false;
        }

        public void close() {
            if (this._valid) {
                this._valid = false;
                this.this$0.unregisterCursor(this);
            }
        }
    }
}

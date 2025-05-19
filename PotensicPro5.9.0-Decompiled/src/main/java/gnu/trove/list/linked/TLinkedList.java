package gnu.trove.list.linked;

import gnu.trove.list.TLinkable;
import gnu.trove.procedure.TObjectProcedure;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public class TLinkedList<T extends TLinkable<T>> extends AbstractSequentialList<T> implements Externalizable {
    static final long serialVersionUID = 1;
    protected T _head;
    protected int _size = 0;
    protected T _tail;

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int i) {
        return new IteratorImpl(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this._size;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException("index:" + i);
        }
        insert(i, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        insert(this._size, t);
        return true;
    }

    public void addFirst(T t) {
        insert(0, t);
    }

    public void addLast(T t) {
        insert(size(), t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        T t = this._head;
        if (t != null) {
            for (TLinkable next = t.getNext(); next != null; next = next.getNext()) {
                next.getPrevious().setNext(null);
                next.setPrevious(null);
            }
            this._tail = null;
            this._head = null;
        }
        this._size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[this._size];
        TLinkable tLinkable = this._head;
        int i = 0;
        while (tLinkable != null) {
            objArr[i] = tLinkable;
            tLinkable = tLinkable.getNext();
            i++;
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [gnu.trove.list.TLinkable] */
    public Object[] toUnlinkedArray() {
        Object[] objArr = new Object[this._size];
        T t = this._head;
        int i = 0;
        while (t != null) {
            objArr[i] = t;
            ?? next = t.getNext();
            t.setNext(null);
            t.setPrevious(null);
            i++;
            t = next;
        }
        this._size = 0;
        this._tail = null;
        this._head = null;
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [gnu.trove.list.TLinkable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public T[] toUnlinkedArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((TLinkable[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        T t = this._head;
        int i = 0;
        while (t != null) {
            tArr[i] = t;
            ?? next = t.getNext();
            t.setNext(null);
            t.setPrevious(null);
            i++;
            t = next;
        }
        this._size = 0;
        this._tail = null;
        this._head = null;
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        for (TLinkable tLinkable = this._head; tLinkable != null; tLinkable = tLinkable.getNext()) {
            if (obj.equals(tLinkable)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public T get(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this._size);
        }
        if (i > (i2 >> 1)) {
            T t = this._tail;
            for (int i3 = i2 - 1; i3 > i; i3--) {
                t = (T) t.getPrevious();
            }
            return t;
        }
        T t2 = this._head;
        for (int i4 = 0; i4 < i; i4++) {
            t2 = (T) t2.getNext();
        }
        return t2;
    }

    public T getFirst() {
        return this._head;
    }

    public T getLast() {
        return this._tail;
    }

    public T getNext(T t) {
        return (T) t.getNext();
    }

    public T getPrevious(T t) {
        return (T) t.getPrevious();
    }

    public T removeFirst() {
        T t = this._head;
        if (t == null) {
            return null;
        }
        T t2 = (T) t.getNext();
        t.setNext(null);
        if (t2 != null) {
            t2.setPrevious(null);
        }
        this._head = t2;
        int i = this._size - 1;
        this._size = i;
        if (i == 0) {
            this._tail = null;
        }
        return t;
    }

    public T removeLast() {
        T t = this._tail;
        if (t == null) {
            return null;
        }
        T t2 = (T) t.getPrevious();
        t.setPrevious(null);
        if (t2 != null) {
            t2.setNext(null);
        }
        this._tail = t2;
        int i = this._size - 1;
        this._size = i;
        if (i == 0) {
            this._head = null;
        }
        return t;
    }

    protected void insert(int i, T t) {
        int i2 = this._size;
        if (i2 == 0) {
            this._tail = t;
            this._head = t;
        } else if (i == 0) {
            t.setNext(this._head);
            this._head.setPrevious(t);
            this._head = t;
        } else if (i == i2) {
            this._tail.setNext(t);
            t.setPrevious(this._tail);
            this._tail = t;
        } else {
            T t2 = get(i);
            TLinkable previous = t2.getPrevious();
            if (previous != null) {
                previous.setNext(t);
            }
            t.setPrevious(previous);
            t.setNext(t2);
            t2.setPrevious(t);
        }
        this._size++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        if (!(obj instanceof TLinkable)) {
            return false;
        }
        TLinkable tLinkable = (TLinkable) obj;
        T t = (T) tLinkable.getPrevious();
        T t2 = (T) tLinkable.getNext();
        if (t2 == null && t == null) {
            if (obj != this._head) {
                return false;
            }
            this._tail = null;
            this._head = null;
        } else if (t2 == null) {
            tLinkable.setPrevious(null);
            t.setNext(null);
            this._tail = t;
        } else if (t == null) {
            tLinkable.setNext(null);
            t2.setPrevious(null);
            this._head = t2;
        } else {
            t.setNext(t2);
            t2.setPrevious(t);
            tLinkable.setNext(null);
            tLinkable.setPrevious(null);
        }
        this._size--;
        return true;
    }

    public void addBefore(T t, T t2) {
        if (t == this._head) {
            addFirst(t2);
            return;
        }
        if (t == null) {
            addLast(t2);
            return;
        }
        TLinkable previous = t.getPrevious();
        t2.setNext(t);
        previous.setNext(t2);
        t2.setPrevious(previous);
        t.setPrevious(t2);
        this._size++;
    }

    public void addAfter(T t, T t2) {
        if (t == this._tail) {
            addLast(t2);
            return;
        }
        if (t == null) {
            addFirst(t2);
            return;
        }
        TLinkable next = t.getNext();
        t2.setPrevious(t);
        t2.setNext(next);
        t.setNext(t2);
        next.setPrevious(t2);
        this._size++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean forEachValue(TObjectProcedure<T> tObjectProcedure) {
        for (TLinkable tLinkable = this._head; tLinkable != null; tLinkable = tLinkable.getNext()) {
            if (!tObjectProcedure.execute(tLinkable)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(0);
        objectOutput.writeInt(this._size);
        objectOutput.writeObject(this._head);
        objectOutput.writeObject(this._tail);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readByte();
        this._size = objectInput.readInt();
        this._head = (T) objectInput.readObject();
        this._tail = (T) objectInput.readObject();
    }

    protected final class IteratorImpl implements ListIterator<T> {
        private T _lastReturned;
        private T _next;
        private int _nextIndex;

        IteratorImpl(int i) {
            this._nextIndex = 0;
            if (i < 0 || i > TLinkedList.this._size) {
                throw new IndexOutOfBoundsException();
            }
            this._nextIndex = i;
            if (i == 0) {
                this._next = TLinkedList.this._head;
                return;
            }
            if (i == TLinkedList.this._size) {
                this._next = null;
                return;
            }
            if (i < (TLinkedList.this._size >> 1)) {
                this._next = TLinkedList.this._head;
                for (int i2 = 0; i2 < i; i2++) {
                    this._next = (T) this._next.getNext();
                }
                return;
            }
            this._next = TLinkedList.this._tail;
            for (int i3 = TLinkedList.this._size - 1; i3 > i; i3--) {
                this._next = (T) this._next.getPrevious();
            }
        }

        @Override // java.util.ListIterator
        public final void add(T t) {
            this._lastReturned = null;
            this._nextIndex++;
            if (TLinkedList.this._size == 0) {
                TLinkedList.this.add((TLinkedList) t);
            } else {
                TLinkedList.this.addBefore(this._next, t);
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return this._nextIndex != TLinkedList.this._size;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return this._nextIndex != 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final T next() {
            if (this._nextIndex == TLinkedList.this._size) {
                throw new NoSuchElementException();
            }
            T t = this._next;
            this._lastReturned = t;
            this._next = (T) t.getNext();
            this._nextIndex++;
            return this._lastReturned;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this._nextIndex;
        }

        @Override // java.util.ListIterator
        public final T previous() {
            int i = this._nextIndex;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            if (i == TLinkedList.this._size) {
                T t = TLinkedList.this._tail;
                this._next = t;
                this._lastReturned = t;
            } else {
                T t2 = (T) this._next.getPrevious();
                this._next = t2;
                this._lastReturned = t2;
            }
            this._nextIndex--;
            return this._lastReturned;
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this._nextIndex - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            T t = this._lastReturned;
            if (t == null) {
                throw new IllegalStateException("must invoke next or previous before invoking remove");
            }
            if (t != this._next) {
                this._nextIndex--;
            }
            this._next = (T) t.getNext();
            TLinkedList.this.remove(this._lastReturned);
            this._lastReturned = null;
        }

        @Override // java.util.ListIterator
        public final void set(T t) {
            T t2 = this._lastReturned;
            if (t2 == null) {
                throw new IllegalStateException();
            }
            swap(t2, t);
            this._lastReturned = t;
        }

        private void swap(T t, T t2) {
            TLinkable previous = t.getPrevious();
            TLinkable next = t.getNext();
            TLinkable previous2 = t2.getPrevious();
            TLinkable next2 = t2.getNext();
            if (next == t2) {
                if (previous != null) {
                    previous.setNext(t2);
                }
                t2.setPrevious(previous);
                t2.setNext(t);
                t.setPrevious(t2);
                t.setNext(next2);
                if (next2 != null) {
                    next2.setPrevious(t);
                }
            } else if (next2 == t) {
                if (previous2 != null) {
                    previous2.setNext(t2);
                }
                t2.setPrevious(t);
                t2.setNext(next);
                t.setPrevious(previous2);
                t.setNext(t2);
                if (next != null) {
                    next.setPrevious(t2);
                }
            } else {
                t.setNext(next2);
                t.setPrevious(previous2);
                if (previous2 != null) {
                    previous2.setNext(t);
                }
                if (next2 != null) {
                    next2.setPrevious(t);
                }
                t2.setNext(next);
                t2.setPrevious(previous);
                if (previous != null) {
                    previous.setNext(t2);
                }
                if (next != null) {
                    next.setPrevious(t2);
                }
            }
            if (TLinkedList.this._head == t) {
                TLinkedList.this._head = t2;
            } else if (TLinkedList.this._head == t2) {
                TLinkedList.this._head = t;
            }
            if (TLinkedList.this._tail == t) {
                TLinkedList.this._tail = t2;
            } else if (TLinkedList.this._tail == t2) {
                TLinkedList.this._tail = t;
            }
            T t3 = this._lastReturned;
            if (t3 == t) {
                this._lastReturned = t2;
            } else if (t3 == t2) {
                this._lastReturned = t;
            }
            T t4 = this._next;
            if (t4 == t) {
                this._next = t2;
            } else if (t4 == t2) {
                this._next = t;
            }
        }
    }
}

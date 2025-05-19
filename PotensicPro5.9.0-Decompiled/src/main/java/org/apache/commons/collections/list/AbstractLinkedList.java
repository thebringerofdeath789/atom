package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;
import org.apache.commons.collections.OrderedIterator;

/* loaded from: classes4.dex */
public abstract class AbstractLinkedList implements List {
    protected transient Node header;
    protected transient int modCount;
    protected transient int size;

    protected AbstractLinkedList() {
    }

    protected AbstractLinkedList(Collection collection) {
        init();
        addAll(collection);
    }

    protected void init() {
        this.header = createHeaderNode();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List
    public Object get(int i) {
        return getNode(i, false).getValue();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new LinkedListIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new LinkedListIterator(this, i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        for (Node node = this.header.next; node != this.header; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.size - 1;
        Node node = this.header;
        while (true) {
            node = node.previous;
            if (node == this.header) {
                return -1;
            }
            if (isEqualValue(node.getValue(), obj)) {
                return i;
            }
            i--;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
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

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.size);
        }
        int i = 0;
        Node node = this.header.next;
        while (node != this.header) {
            objArr[i] = node.getValue();
            node = node.next;
            i++;
        }
        int length = objArr.length;
        int i2 = this.size;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new LinkedSubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        addNodeBefore(getNode(i, true), obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(this.size, collection);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        Node node = getNode(i, true);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addNodeBefore(node, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public Object remove(int i) {
        Node node = getNode(i, false);
        Object value = node.getValue();
        removeNode(node);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Node node = this.header;
        do {
            node = node.next;
            if (node == this.header) {
                return false;
            }
        } while (!isEqualValue(node.getValue(), obj));
        removeNode(node);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
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
        Node node = getNode(i, false);
        Object value = node.getValue();
        updateNode(node, obj);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        removeAllNodes();
    }

    public Object getFirst() {
        Node node = this.header.next;
        if (node == this.header) {
            throw new NoSuchElementException();
        }
        return node.getValue();
    }

    public Object getLast() {
        Node node = this.header.previous;
        if (node == this.header) {
            throw new NoSuchElementException();
        }
        return node.getValue();
    }

    public boolean addFirst(Object obj) {
        addNodeAfter(this.header, obj);
        return true;
    }

    public boolean addLast(Object obj) {
        addNodeBefore(this.header, obj);
        return true;
    }

    public Object removeFirst() {
        Node node = this.header.next;
        if (node == this.header) {
            throw new NoSuchElementException();
        }
        Object value = node.getValue();
        removeNode(node);
        return value;
    }

    public Object removeLast() {
        Node node = this.header.previous;
        if (node == this.header) {
            throw new NoSuchElementException();
        }
        Object value = node.getValue();
        removeNode(node);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != size()) {
            return false;
        }
        ListIterator listIterator = listIterator();
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

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator it = iterator();
        int i = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i = (i * 31) + (next == null ? 0 : next.hashCode());
        }
        return i;
    }

    public String toString() {
        if (size() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer(size() * 16);
        stringBuffer.append("[");
        Iterator it = iterator();
        boolean hasNext = it.hasNext();
        while (hasNext) {
            Object next = it.next();
            if (next == this) {
                next = "(this Collection)";
            }
            stringBuffer.append(next);
            hasNext = it.hasNext();
            if (hasNext) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    protected void updateNode(Node node, Object obj) {
        node.setValue(obj);
    }

    protected Node createHeaderNode() {
        return new Node();
    }

    protected Node createNode(Object obj) {
        return new Node(obj);
    }

    protected void addNodeBefore(Node node, Object obj) {
        addNode(createNode(obj), node);
    }

    protected void addNodeAfter(Node node, Object obj) {
        addNode(createNode(obj), node.next);
    }

    protected void addNode(Node node, Node node2) {
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.size++;
        this.modCount++;
    }

    protected void removeNode(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        this.size--;
        this.modCount++;
    }

    protected void removeAllNodes() {
        Node node = this.header;
        node.next = node;
        Node node2 = this.header;
        node2.previous = node2;
        this.size = 0;
        this.modCount++;
    }

    protected Node getNode(int i, boolean z) throws IndexOutOfBoundsException {
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Couldn't get the node: index (").append(i).append(") less than zero.").toString());
        }
        if (!z && i == this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Couldn't get the node: index (").append(i).append(") is the size of the list.").toString());
        }
        int i2 = this.size;
        if (i > i2) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Couldn't get the node: index (").append(i).append(") greater than the size of the ").append("list (").append(this.size).append(").").toString());
        }
        if (i < i2 / 2) {
            Node node = this.header.next;
            for (int i3 = 0; i3 < i; i3++) {
                node = node.next;
            }
            return node;
        }
        Node node2 = this.header;
        while (i2 > i) {
            node2 = node2.previous;
            i2--;
        }
        return node2;
    }

    protected Iterator createSubListIterator(LinkedSubList linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    protected ListIterator createSubListListIterator(LinkedSubList linkedSubList, int i) {
        return new LinkedSubListIterator(linkedSubList, i);
    }

    protected void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    protected void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        init();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            add(objectInputStream.readObject());
        }
    }

    protected static class Node {
        protected Node next;
        protected Node previous;
        protected Object value;

        protected Node() {
            this.previous = this;
            this.next = this;
        }

        protected Node(Object obj) {
            this.value = obj;
        }

        protected Node(Node node, Node node2, Object obj) {
            this.previous = node;
            this.next = node2;
            this.value = obj;
        }

        protected Object getValue() {
            return this.value;
        }

        protected void setValue(Object obj) {
            this.value = obj;
        }

        protected Node getPreviousNode() {
            return this.previous;
        }

        protected void setPreviousNode(Node node) {
            this.previous = node;
        }

        protected Node getNextNode() {
            return this.next;
        }

        protected void setNextNode(Node node) {
            this.next = node;
        }
    }

    protected static class LinkedListIterator implements ListIterator, OrderedIterator {
        protected Node current;
        protected int expectedModCount;
        protected Node next;
        protected int nextIndex;
        protected final AbstractLinkedList parent;

        protected LinkedListIterator(AbstractLinkedList abstractLinkedList, int i) throws IndexOutOfBoundsException {
            this.parent = abstractLinkedList;
            this.expectedModCount = abstractLinkedList.modCount;
            this.next = abstractLinkedList.getNode(i, true);
            this.nextIndex = i;
        }

        protected void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        protected Node getLastNodeReturned() throws IllegalStateException {
            Node node = this.current;
            if (node != null) {
                return node;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException(new StringBuffer().append("No element at index ").append(this.nextIndex).append(".").toString());
            }
            Object value = this.next.getValue();
            Node node = this.next;
            this.current = node;
            this.next = node.next;
            this.nextIndex++;
            return value;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.next.previous != this.parent.header;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            Node node = this.next.previous;
            this.next = node;
            Object value = node.getValue();
            this.current = this.next;
            this.nextIndex--;
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            Node node = this.current;
            Node node2 = this.next;
            if (node == node2) {
                this.next = node2.next;
                this.parent.removeNode(getLastNodeReturned());
            } else {
                this.parent.removeNode(getLastNodeReturned());
                this.nextIndex--;
            }
            this.current = null;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            checkModCount();
            getLastNodeReturned().setValue(obj);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            checkModCount();
            this.parent.addNodeBefore(this.next, obj);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }
    }

    protected static class LinkedSubListIterator extends LinkedListIterator {
        protected final LinkedSubList sub;

        protected LinkedSubListIterator(LinkedSubList linkedSubList, int i) {
            super(linkedSubList.parent, i + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(Object obj) {
            super.add(obj);
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size++;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            LinkedSubList linkedSubList = this.sub;
            linkedSubList.size--;
        }
    }

    protected static class LinkedSubList extends AbstractList {
        int expectedModCount;
        int offset;
        AbstractLinkedList parent;
        int size;

        protected LinkedSubList(AbstractLinkedList abstractLinkedList, int i, int i2) {
            if (i < 0) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("fromIndex = ").append(i).toString());
            }
            if (i2 > abstractLinkedList.size()) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("toIndex = ").append(i2).toString());
            }
            if (i > i2) {
                throw new IllegalArgumentException(new StringBuffer().append("fromIndex(").append(i).append(") > toIndex(").append(i2).append(")").toString());
            }
            this.parent = abstractLinkedList;
            this.offset = i;
            this.size = i2 - i;
            this.expectedModCount = abstractLinkedList.modCount;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            checkModCount();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            rangeCheck(i, this.size);
            checkModCount();
            return this.parent.get(i + this.offset);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            rangeCheck(i, this.size + 1);
            checkModCount();
            this.parent.add(i + this.offset, obj);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            rangeCheck(i, this.size);
            checkModCount();
            Object remove = this.parent.remove(i + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            this.modCount++;
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            return addAll(this.size, collection);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection collection) {
            rangeCheck(i, this.size + 1);
            int size = collection.size();
            if (size == 0) {
                return false;
            }
            checkModCount();
            this.parent.addAll(this.offset + i, collection);
            this.expectedModCount = this.parent.modCount;
            this.size += size;
            this.modCount++;
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            rangeCheck(i, this.size);
            checkModCount();
            return this.parent.set(i + this.offset, obj);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkModCount();
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            rangeCheck(i, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            AbstractLinkedList abstractLinkedList = this.parent;
            int i3 = this.offset;
            return new LinkedSubList(abstractLinkedList, i + i3, i2 + i3);
        }

        protected void rangeCheck(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(new StringBuffer().append("Index '").append(i).append("' out of bounds for size '").append(this.size).append("'").toString());
            }
        }

        protected void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

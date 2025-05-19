package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.list.AbstractLinkedList;

/* loaded from: classes4.dex */
public class CursorableLinkedList extends AbstractLinkedList implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    protected transient List cursors;

    public CursorableLinkedList() {
        this.cursors = new ArrayList();
        init();
    }

    public CursorableLinkedList(Collection collection) {
        super(collection);
        this.cursors = new ArrayList();
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void init() {
        super.init();
        this.cursors = new ArrayList();
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return super.listIterator(0);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList, java.util.List
    public ListIterator listIterator() {
        return cursor(0);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList, java.util.List
    public ListIterator listIterator(int i) {
        return cursor(i);
    }

    public Cursor cursor() {
        return cursor(0);
    }

    public Cursor cursor(int i) {
        Cursor cursor = new Cursor(this, i);
        registerCursor(cursor);
        return cursor;
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void updateNode(AbstractLinkedList.Node node, Object obj) {
        super.updateNode(node, obj);
        broadcastNodeChanged(node);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void addNode(AbstractLinkedList.Node node, AbstractLinkedList.Node node2) {
        super.addNode(node, node2);
        broadcastNodeInserted(node);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void removeNode(AbstractLinkedList.Node node) {
        super.removeNode(node);
        broadcastNodeRemoved(node);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected void removeAllNodes() {
        if (size() > 0) {
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    protected void registerCursor(Cursor cursor) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        this.cursors.add(new WeakReference(cursor));
    }

    protected void unregisterCursor(Cursor cursor) {
        Iterator it = this.cursors.iterator();
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

    protected void broadcastNodeChanged(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeChanged(node);
            }
        }
    }

    protected void broadcastNodeRemoved(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeRemoved(node);
            }
        }
    }

    protected void broadcastNodeInserted(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeInserted(node);
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    protected ListIterator createSubListListIterator(AbstractLinkedList.LinkedSubList linkedSubList, int i) {
        SubCursor subCursor = new SubCursor(linkedSubList, i);
        registerCursor(subCursor);
        return subCursor;
    }

    public static class Cursor extends AbstractLinkedList.LinkedListIterator {
        boolean currentRemovedByAnother;
        boolean nextIndexValid;
        boolean valid;

        protected void nodeChanged(AbstractLinkedList.Node node) {
        }

        protected Cursor(CursorableLinkedList cursorableLinkedList, int i) {
            super(cursorableLinkedList, i);
            this.valid = true;
            this.nextIndexValid = true;
            this.currentRemovedByAnother = false;
            this.valid = true;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.current != null || !this.currentRemovedByAnother) {
                checkModCount();
                this.parent.removeNode(getLastNodeReturned());
            }
            this.currentRemovedByAnother = false;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(Object obj) {
            super.add(obj);
            this.next = this.next.next;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            if (!this.nextIndexValid) {
                if (this.next == this.parent.header) {
                    this.nextIndex = this.parent.size();
                } else {
                    int i = 0;
                    for (AbstractLinkedList.Node node = this.parent.header.next; node != this.next; node = node.next) {
                        i++;
                    }
                    this.nextIndex = i;
                }
                this.nextIndexValid = true;
            }
            return this.nextIndex;
        }

        protected void nodeRemoved(AbstractLinkedList.Node node) {
            if (node == this.next && node == this.current) {
                this.next = node.next;
                this.current = null;
                this.currentRemovedByAnother = true;
            } else if (node == this.next) {
                this.next = node.next;
                this.currentRemovedByAnother = false;
            } else if (node == this.current) {
                this.current = null;
                this.currentRemovedByAnother = true;
                this.nextIndex--;
            } else {
                this.nextIndexValid = false;
                this.currentRemovedByAnother = false;
            }
        }

        protected void nodeInserted(AbstractLinkedList.Node node) {
            if (node.previous == this.current) {
                this.next = node;
            } else if (this.next.previous == node) {
                this.next = node;
            } else {
                this.nextIndexValid = false;
            }
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator
        protected void checkModCount() {
            if (!this.valid) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        public void close() {
            if (this.valid) {
                ((CursorableLinkedList) this.parent).unregisterCursor(this);
                this.valid = false;
            }
        }
    }

    protected static class SubCursor extends Cursor {
        protected final AbstractLinkedList.LinkedSubList sub;

        protected SubCursor(AbstractLinkedList.LinkedSubList linkedSubList, int i) {
            super((CursorableLinkedList) linkedSubList.parent, i + linkedSubList.offset);
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

        @Override // org.apache.commons.collections.list.CursorableLinkedList.Cursor, org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections.list.CursorableLinkedList.Cursor, org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(Object obj) {
            super.add(obj);
            this.sub.expectedModCount = this.parent.modCount;
            this.sub.size++;
        }

        @Override // org.apache.commons.collections.list.CursorableLinkedList.Cursor, org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            AbstractLinkedList.LinkedSubList linkedSubList = this.sub;
            linkedSubList.size--;
        }
    }
}

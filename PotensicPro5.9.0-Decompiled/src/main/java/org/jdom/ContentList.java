package org.jdom;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jdom.filter.Filter;

/* loaded from: classes5.dex */
final class ContentList extends AbstractList implements Serializable {
    private static final int ADD = 5;
    private static final int CREATE = 0;
    private static final String CVS_ID = "@(#) $RCSfile: ContentList.java,v $ $Revision: 1.39 $ $Date: 2004/02/28 03:30:27 $ $Name: jdom_1_0 $";
    private static final int HASNEXT = 2;
    private static final int HASPREV = 1;
    private static final int INITIAL_ARRAY_SIZE = 5;
    private static final int NEXT = 4;
    private static final int PREV = 3;
    private static final int REMOVE = 6;
    private Content[] elementData;
    private Parent parent;
    private int size;

    ContentList(Parent parent) {
        this.parent = parent;
    }

    final void uncheckedAddContent(Content content) {
        content.parent = this.parent;
        ensureCapacity(this.size + 1);
        Content[] contentArr = this.elementData;
        int i = this.size;
        this.size = i + 1;
        contentArr[i] = content;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        if (obj == null) {
            throw new IllegalAddException("Cannot add null object");
        }
        if (obj instanceof Content) {
            add(i, (Content) obj);
            return;
        }
        throw new IllegalAddException(new StringBuffer("Class ").append(obj.getClass().getName()).append(" is of unrecognized type and cannot be added").toString());
    }

    private void documentCanContain(int i, Content content) throws IllegalAddException {
        if (content instanceof Element) {
            if (indexOfFirstElement() >= 0) {
                throw new IllegalAddException("Cannot add a second root element, only one is allowed");
            }
            if (indexOfDocType() > i) {
                throw new IllegalAddException("A root element cannot be added before the DocType");
            }
        }
        if (content instanceof DocType) {
            if (indexOfDocType() >= 0) {
                throw new IllegalAddException("Cannot add a second doctype, only one is allowed");
            }
            int indexOfFirstElement = indexOfFirstElement();
            if (indexOfFirstElement != -1 && indexOfFirstElement < i) {
                throw new IllegalAddException("A DocType cannot be added after the root element");
            }
        }
        if (content instanceof CDATA) {
            throw new IllegalAddException("A CDATA is not allowed at the document root");
        }
        if (content instanceof Text) {
            throw new IllegalAddException("A Text is not allowed at the document root");
        }
        if (content instanceof EntityRef) {
            throw new IllegalAddException("An EntityRef is not allowed at the document root");
        }
    }

    private static void elementCanContain(int i, Content content) throws IllegalAddException {
        if (content instanceof DocType) {
            throw new IllegalAddException("A DocType is not allowed except at the document level");
        }
    }

    void add(int i, Content content) {
        if (content == null) {
            throw new IllegalAddException("Cannot add null object");
        }
        if (this.parent instanceof Document) {
            documentCanContain(i, content);
        } else {
            elementCanContain(i, content);
        }
        if (content.getParent() != null) {
            Parent parent = content.getParent();
            if (parent instanceof Document) {
                throw new IllegalAddException((Element) content, "The Content already has an existing parent document");
            }
            throw new IllegalAddException(new StringBuffer("The Content already has an existing parent \"").append(((Element) parent).getQualifiedName()).append("\"").toString());
        }
        Parent parent2 = this.parent;
        if (content == parent2) {
            throw new IllegalAddException("The Element cannot be added to itself");
        }
        if ((parent2 instanceof Element) && (content instanceof Element) && ((Element) content).isAncestor((Element) parent2)) {
            throw new IllegalAddException("The Element cannot be added as a descendent of itself");
        }
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        content.setParent(this.parent);
        ensureCapacity(this.size + 1);
        int i2 = this.size;
        if (i == i2) {
            Content[] contentArr = this.elementData;
            this.size = i2 + 1;
            contentArr[i2] = content;
        } else {
            Content[] contentArr2 = this.elementData;
            System.arraycopy(contentArr2, i, contentArr2, i + 1, i2 - i);
            this.elementData[i] = content;
            this.size++;
        }
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        int i2;
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        if (collection == null || collection.size() == 0) {
            return false;
        }
        ensureCapacity(size() + collection.size());
        try {
            Iterator it = collection.iterator();
            i2 = 0;
            while (it.hasNext()) {
                try {
                    add(i + i2, it.next());
                    i2++;
                } catch (RuntimeException e) {
                    e = e;
                    for (int i3 = 0; i3 < i2; i3++) {
                        remove(i);
                    }
                    throw e;
                }
            }
            return true;
        } catch (RuntimeException e2) {
            e = e2;
            i2 = 0;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (this.elementData != null) {
            for (int i = 0; i < this.size; i++) {
                removeParent(this.elementData[i]);
            }
            this.elementData = null;
            this.size = 0;
        }
        ((AbstractList) this).modCount++;
    }

    void clearAndSet(Collection collection) {
        Content[] contentArr = this.elementData;
        int i = this.size;
        this.elementData = null;
        this.size = 0;
        if (collection != null && collection.size() != 0) {
            ensureCapacity(collection.size());
            try {
                addAll(0, collection);
            } catch (RuntimeException e) {
                this.elementData = contentArr;
                this.size = i;
                throw e;
            }
        }
        if (contentArr != null) {
            for (int i2 = 0; i2 < i; i2++) {
                removeParent(contentArr[i2]);
            }
        }
        ((AbstractList) this).modCount++;
    }

    void ensureCapacity(int i) {
        Content[] contentArr = this.elementData;
        if (contentArr == null) {
            this.elementData = new Content[Math.max(i, 5)];
            return;
        }
        int length = contentArr.length;
        if (i > length) {
            int i2 = ((length * 3) / 2) + 1;
            if (i2 >= i) {
                i = i2;
            }
            Content[] contentArr2 = new Content[i];
            this.elementData = contentArr2;
            System.arraycopy(contentArr, 0, contentArr2, 0, this.size);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        return this.elementData[i];
    }

    List getView(Filter filter) {
        return new FilterList(filter);
    }

    int indexOfFirstElement() {
        if (this.elementData == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i] instanceof Element) {
                return i;
            }
        }
        return -1;
    }

    int indexOfDocType() {
        if (this.elementData == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i] instanceof DocType) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        Content content = this.elementData[i];
        removeParent(content);
        int i2 = (this.size - i) - 1;
        if (i2 > 0) {
            Content[] contentArr = this.elementData;
            System.arraycopy(contentArr, i + 1, contentArr, i, i2);
        }
        Content[] contentArr2 = this.elementData;
        int i3 = this.size - 1;
        this.size = i3;
        contentArr2[i3] = null;
        ((AbstractList) this).modCount++;
        return content;
    }

    private static void removeParent(Content content) {
        content.setParent(null);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int indexOfDocType;
        int indexOfFirstElement;
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        if ((obj instanceof Element) && (this.parent instanceof Document) && (indexOfFirstElement = indexOfFirstElement()) >= 0 && indexOfFirstElement != i) {
            throw new IllegalAddException("Cannot add a second root element, only one is allowed");
        }
        if ((obj instanceof DocType) && (this.parent instanceof Document) && (indexOfDocType = indexOfDocType()) >= 0 && indexOfDocType != i) {
            throw new IllegalAddException("Cannot add a second doctype, only one is allowed");
        }
        Object remove = remove(i);
        try {
            add(i, obj);
            return remove;
        } catch (RuntimeException e) {
            add(i, remove);
            throw e;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getModCount() {
        return ((AbstractList) this).modCount;
    }

    class FilterList extends AbstractList implements Serializable {
        int count = 0;
        int expected = -1;
        Filter filter;

        FilterList(Filter filter) {
            this.filter = filter;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            if (this.filter.matches(obj)) {
                ContentList.this.add(getAdjustedIndex(i), obj);
                this.expected++;
                this.count++;
                return;
            }
            throw new IllegalAddException(new StringBuffer("Filter won't allow the ").append(obj.getClass().getName()).append(" '").append(obj).append("' to be added to the list").toString());
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return ContentList.this.get(getAdjustedIndex(i));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return ContentList.this.new FilterListIterator(this.filter, 0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return ContentList.this.new FilterListIterator(this.filter, 0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            return ContentList.this.new FilterListIterator(this.filter, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            int adjustedIndex = getAdjustedIndex(i);
            Object obj = ContentList.this.get(adjustedIndex);
            if (this.filter.matches(obj)) {
                Object remove = ContentList.this.remove(adjustedIndex);
                this.expected++;
                this.count--;
                return remove;
            }
            throw new IllegalAddException(new StringBuffer("Filter won't allow the ").append(obj.getClass().getName()).append(" '").append(obj).append("' (index ").append(i).append(") to be removed").toString());
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            if (this.filter.matches(obj)) {
                int adjustedIndex = getAdjustedIndex(i);
                Object obj2 = ContentList.this.get(adjustedIndex);
                if (!this.filter.matches(obj2)) {
                    throw new IllegalAddException(new StringBuffer("Filter won't allow the ").append(obj2.getClass().getName()).append(" '").append(obj2).append("' (index ").append(i).append(") to be removed").toString());
                }
                Object obj3 = ContentList.this.set(adjustedIndex, obj);
                this.expected += 2;
                return obj3;
            }
            throw new IllegalAddException(new StringBuffer("Filter won't allow index ").append(i).append(" to be set to ").append(obj.getClass().getName()).toString());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            if (this.expected == ContentList.this.getModCount()) {
                return this.count;
            }
            this.count = 0;
            for (int i = 0; i < ContentList.this.size(); i++) {
                if (this.filter.matches(ContentList.this.elementData[i])) {
                    this.count++;
                }
            }
            this.expected = ContentList.this.getModCount();
            return this.count;
        }

        private final int getAdjustedIndex(int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < ContentList.this.size; i3++) {
                if (this.filter.matches(ContentList.this.elementData[i3])) {
                    if (i == i2) {
                        return i3;
                    }
                    i2++;
                }
            }
            return i == i2 ? ContentList.this.size : ContentList.this.size + 1;
        }
    }

    class FilterListIterator implements ListIterator {
        int cursor;
        int expected;
        Filter filter;
        int initialCursor;
        int last = -1;
        int lastOperation = 0;

        FilterListIterator(Filter filter, int i) {
            this.filter = filter;
            this.initialCursor = initializeCursor(i);
            this.expected = ContentList.this.getModCount();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            checkConcurrentModification();
            switch (this.lastOperation) {
                case 0:
                    this.cursor = this.initialCursor;
                    break;
                case 1:
                    this.cursor = moveForward(this.cursor + 1);
                    break;
                case 2:
                    break;
                case 3:
                    this.cursor = this.last;
                    break;
                case 4:
                case 5:
                    this.cursor = moveForward(this.last + 1);
                    break;
                case 6:
                    this.cursor = moveForward(this.last);
                    break;
                default:
                    throw new IllegalStateException("Unknown operation");
            }
            if (this.lastOperation != 0) {
                this.lastOperation = 2;
            }
            return this.cursor < ContentList.this.size();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            checkConcurrentModification();
            if (hasNext()) {
                int i = this.cursor;
                this.last = i;
                this.lastOperation = 4;
                return ContentList.this.get(i);
            }
            this.last = ContentList.this.size();
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            checkConcurrentModification();
            switch (this.lastOperation) {
                case 0:
                    this.cursor = this.initialCursor;
                    int size = ContentList.this.size();
                    if (this.cursor >= size) {
                        this.cursor = moveBackward(size - 1);
                        break;
                    }
                    break;
                case 1:
                    break;
                case 2:
                    this.cursor = moveBackward(this.cursor - 1);
                    break;
                case 3:
                case 6:
                    this.cursor = moveBackward(this.last - 1);
                    break;
                case 4:
                case 5:
                    this.cursor = this.last;
                    break;
                default:
                    throw new IllegalStateException("Unknown operation");
            }
            if (this.lastOperation != 0) {
                this.lastOperation = 1;
            }
            return this.cursor >= 0;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            checkConcurrentModification();
            if (hasPrevious()) {
                int i = this.cursor;
                this.last = i;
                this.lastOperation = 3;
                return ContentList.this.get(i);
            }
            this.last = -1;
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            checkConcurrentModification();
            hasNext();
            int i = 0;
            for (int i2 = 0; i2 < ContentList.this.size(); i2++) {
                if (this.filter.matches(ContentList.this.get(i2))) {
                    if (i2 == this.cursor) {
                        return i;
                    }
                    i++;
                }
            }
            this.expected = ContentList.this.getModCount();
            return i;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            checkConcurrentModification();
            if (!hasPrevious()) {
                return -1;
            }
            int i = 0;
            for (int i2 = 0; i2 < ContentList.this.size(); i2++) {
                if (this.filter.matches(ContentList.this.get(i2))) {
                    if (i2 == this.cursor) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            checkConcurrentModification();
            if (this.filter.matches(obj)) {
                int i = this.cursor + 1;
                this.last = i;
                ContentList.this.add(i, obj);
                this.expected = ContentList.this.getModCount();
                this.lastOperation = 5;
                return;
            }
            throw new IllegalAddException(new StringBuffer("Filter won't allow add of ").append(obj.getClass().getName()).toString());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i;
            checkConcurrentModification();
            int i2 = this.last;
            if (i2 < 0 || (i = this.lastOperation) == 6) {
                throw new IllegalStateException("no preceeding call to prev() or next()");
            }
            if (i == 5) {
                throw new IllegalStateException("cannot call remove() after add()");
            }
            Object obj = ContentList.this.get(i2);
            if (this.filter.matches(obj)) {
                ContentList.this.remove(this.last);
                this.expected = ContentList.this.getModCount();
                this.lastOperation = 6;
                return;
            }
            throw new IllegalAddException(new StringBuffer("Filter won't allow ").append(obj.getClass().getName()).append(" (index ").append(this.last).append(") to be removed").toString());
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            checkConcurrentModification();
            int i = this.lastOperation;
            if (i == 5 || i == 6) {
                throw new IllegalStateException("cannot call set() after add() or remove()");
            }
            if (this.last < 0) {
                throw new IllegalStateException("no preceeding call to prev() or next()");
            }
            if (this.filter.matches(obj)) {
                Object obj2 = ContentList.this.get(this.last);
                if (!this.filter.matches(obj2)) {
                    throw new IllegalAddException(new StringBuffer("Filter won't allow ").append(obj2.getClass().getName()).append(" (index ").append(this.last).append(") to be removed").toString());
                }
                ContentList.this.set(this.last, obj);
                this.expected = ContentList.this.getModCount();
                return;
            }
            throw new IllegalAddException(new StringBuffer("Filter won't allow index ").append(this.last).append(" to be set to ").append(obj.getClass().getName()).toString());
        }

        private int initializeCursor(int i) {
            if (i < 0) {
                throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).toString());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < ContentList.this.size(); i3++) {
                if (this.filter.matches(ContentList.this.get(i3))) {
                    if (i == i2) {
                        return i3;
                    }
                    i2++;
                }
            }
            if (i > i2) {
                throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(i2).toString());
            }
            return ContentList.this.size();
        }

        private int moveForward(int i) {
            if (i < 0) {
                i = 0;
            }
            while (i < ContentList.this.size()) {
                if (this.filter.matches(ContentList.this.get(i))) {
                    return i;
                }
                i++;
            }
            return ContentList.this.size();
        }

        private int moveBackward(int i) {
            if (i >= ContentList.this.size()) {
                i = ContentList.this.size() - 1;
            }
            while (i >= 0) {
                if (this.filter.matches(ContentList.this.get(i))) {
                    return i;
                }
                i--;
            }
            return -1;
        }

        private void checkConcurrentModification() {
            if (this.expected != ContentList.this.getModCount()) {
                throw new ConcurrentModificationException();
            }
        }
    }
}

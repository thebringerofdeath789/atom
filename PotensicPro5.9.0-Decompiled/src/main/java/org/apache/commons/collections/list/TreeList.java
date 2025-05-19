package org.apache.commons.collections.list;

import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.OrderedIterator;

/* loaded from: classes4.dex */
public class TreeList extends AbstractList {
    private AVLNode root;
    private int size;

    public TreeList() {
    }

    public TreeList(Collection collection) {
        addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        checkInterval(i, 0, size() - 1);
        return this.root.get(i).getValue();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        checkInterval(i, 0, size());
        return new TreeListIterator(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        AVLNode aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, aVLNode.relativePosition);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, aVLNode.relativePosition);
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        this.modCount++;
        checkInterval(i, 0, size());
        AVLNode aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode(i, obj, null, null);
        } else {
            this.root = aVLNode.insert(i, obj);
        }
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        checkInterval(i, 0, size() - 1);
        AVLNode aVLNode = this.root.get(i);
        Object obj2 = aVLNode.value;
        aVLNode.setValue(obj);
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        this.modCount++;
        checkInterval(i, 0, size() - 1);
        Object obj = get(i);
        this.root = this.root.remove(i);
        this.size--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.modCount++;
        this.root = null;
        this.size = 0;
    }

    private void checkInterval(int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Invalid index:").append(i).append(", size=").append(size()).toString());
        }
    }

    static class AVLNode {
        private int height;
        private AVLNode left;
        private boolean leftIsPrevious;
        private int relativePosition;
        private AVLNode right;
        private boolean rightIsNext;
        private Object value;

        private AVLNode(int i, Object obj, AVLNode aVLNode, AVLNode aVLNode2) {
            this.relativePosition = i;
            this.value = obj;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }

        Object getValue() {
            return this.value;
        }

        void setValue(Object obj) {
            this.value = obj;
        }

        AVLNode get(int i) {
            int i2 = i - this.relativePosition;
            if (i2 == 0) {
                return this;
            }
            AVLNode leftSubTree = i2 < 0 ? getLeftSubTree() : getRightSubTree();
            if (leftSubTree == null) {
                return null;
            }
            return leftSubTree.get(i2);
        }

        int indexOf(Object obj, int i) {
            if (getLeftSubTree() != null) {
                AVLNode aVLNode = this.left;
                int indexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i);
                if (indexOf != -1) {
                    return indexOf;
                }
            }
            Object obj2 = this.value;
            if (obj2 != null ? obj2.equals(obj) : obj2 == obj) {
                return i;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i + aVLNode2.relativePosition);
        }

        void toArray(Object[] objArr, int i) {
            objArr[i] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i);
            }
            if (getRightSubTree() != null) {
                AVLNode aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i + aVLNode2.relativePosition);
            }
        }

        AVLNode next() {
            AVLNode aVLNode;
            if (this.rightIsNext || (aVLNode = this.right) == null) {
                return this.right;
            }
            return aVLNode.min();
        }

        AVLNode previous() {
            AVLNode aVLNode;
            if (this.leftIsPrevious || (aVLNode = this.left) == null) {
                return this.left;
            }
            return aVLNode.max();
        }

        AVLNode insert(int i, Object obj) {
            int i2 = i - this.relativePosition;
            if (i2 <= 0) {
                return insertOnLeft(i2, obj);
            }
            return insertOnRight(i2, obj);
        }

        private AVLNode insertOnLeft(int i, Object obj) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode(-1, obj, this, this.left), null);
            } else {
                setLeft(this.left.insert(i, obj), null);
            }
            int i2 = this.relativePosition;
            if (i2 >= 0) {
                this.relativePosition = i2 + 1;
            }
            AVLNode balance = balance();
            recalcHeight();
            return balance;
        }

        private AVLNode insertOnRight(int i, Object obj) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode(1, obj, this.right, this), null);
            } else {
                setRight(this.right.insert(i, obj), null);
            }
            int i2 = this.relativePosition;
            if (i2 < 0) {
                this.relativePosition = i2 - 1;
            }
            AVLNode balance = balance();
            recalcHeight();
            return balance;
        }

        private AVLNode getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private AVLNode getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private AVLNode max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        AVLNode remove(int i) {
            int i2 = i - this.relativePosition;
            if (i2 == 0) {
                return removeSelf();
            }
            if (i2 > 0) {
                setRight(this.right.remove(i2), this.right.right);
                int i3 = this.relativePosition;
                if (i3 < 0) {
                    this.relativePosition = i3 + 1;
                }
            } else {
                setLeft(this.left.remove(i2), this.left.left);
                int i4 = this.relativePosition;
                if (i4 > 0) {
                    this.relativePosition = i4 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        private AVLNode removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i = this.relativePosition;
            if (i < 0) {
                this.relativePosition = i + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i = this.relativePosition;
            if (i > 0) {
                this.relativePosition = i - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            if (getRightSubTree() == null) {
                int i = this.relativePosition;
                if (i > 0) {
                    this.left.relativePosition += i + (i <= 0 ? 1 : 0);
                }
                this.left.max().setRight(null, this.right);
                return this.left;
            }
            if (getLeftSubTree() == null) {
                AVLNode aVLNode = this.right;
                int i2 = aVLNode.relativePosition;
                int i3 = this.relativePosition;
                aVLNode.relativePosition = i2 + (i3 - (i3 >= 0 ? 1 : 0));
                aVLNode.min().setLeft(null, this.left);
                return this.right;
            }
            if (heightRightMinusLeft() > 0) {
                AVLNode min = this.right.min();
                this.value = min.value;
                if (this.leftIsPrevious) {
                    this.left = min.left;
                }
                this.right = this.right.removeMin();
                int i4 = this.relativePosition;
                if (i4 < 0) {
                    this.relativePosition = i4 + 1;
                }
            } else {
                AVLNode max = this.left.max();
                this.value = max.value;
                if (this.rightIsNext) {
                    this.right = max.right;
                }
                AVLNode aVLNode2 = this.left;
                AVLNode aVLNode3 = aVLNode2.left;
                AVLNode removeMax = aVLNode2.removeMax();
                this.left = removeMax;
                if (removeMax == null) {
                    this.left = aVLNode3;
                    this.leftIsPrevious = true;
                }
                int i5 = this.relativePosition;
                if (i5 > 0) {
                    this.relativePosition = i5 - 1;
                }
            }
            recalcHeight();
            return this;
        }

        private AVLNode balance() {
            int heightRightMinusLeft = heightRightMinusLeft();
            if (heightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), null);
                }
                return rotateRight();
            }
            if (heightRightMinusLeft == -1 || heightRightMinusLeft == 0 || heightRightMinusLeft == 1) {
                return this;
            }
            if (heightRightMinusLeft == 2) {
                if (this.right.heightRightMinusLeft() < 0) {
                    setRight(this.right.rotateRight(), null);
                }
                return rotateLeft();
            }
            throw new RuntimeException("tree inconsistent!");
        }

        private int getOffset(AVLNode aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private int setOffset(AVLNode aVLNode, int i) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i;
            return offset;
        }

        private void recalcHeight() {
            this.height = Math.max(getLeftSubTree() == null ? -1 : getLeftSubTree().height, getRightSubTree() != null ? getRightSubTree().height : -1) + 1;
        }

        private int getHeight(AVLNode aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode rotateLeft() {
            AVLNode aVLNode = this.right;
            AVLNode leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(leftSubTree);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i);
            setOffset(leftSubTree, offset2);
            return aVLNode;
        }

        private AVLNode rotateRight() {
            AVLNode aVLNode = this.left;
            AVLNode rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(rightSubTree);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i);
            setOffset(rightSubTree, offset2);
            return aVLNode;
        }

        private void setLeft(AVLNode aVLNode, AVLNode aVLNode2) {
            boolean z = aVLNode == null;
            this.leftIsPrevious = z;
            if (z) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private void setRight(AVLNode aVLNode, AVLNode aVLNode2) {
            boolean z = aVLNode == null;
            this.rightIsNext = z;
            if (z) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        public String toString() {
            return new StringBuffer().append("AVLNode(").append(this.relativePosition).append(",").append(this.left != null).append(",").append(this.value).append(",").append(getRightSubTree() != null).append(", faedelung ").append(this.rightIsNext).append(" )").toString();
        }
    }

    static class TreeListIterator implements ListIterator, OrderedIterator {
        protected AVLNode current;
        protected int currentIndex;
        protected int expectedModCount;
        protected AVLNode next;
        protected int nextIndex;
        protected final TreeList parent;

        protected TreeListIterator(TreeList treeList, int i) throws IndexOutOfBoundsException {
            this.parent = treeList;
            this.expectedModCount = treeList.modCount;
            this.next = treeList.root == null ? null : treeList.root.get(i);
            this.nextIndex = i;
            this.currentIndex = -1;
        }

        protected void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException(new StringBuffer().append("No element at index ").append(this.nextIndex).append(".").toString());
            }
            if (this.next == null) {
                this.next = this.parent.root.get(this.nextIndex);
            }
            Object value = this.next.getValue();
            AVLNode aVLNode = this.next;
            this.current = aVLNode;
            int i = this.nextIndex;
            this.nextIndex = i + 1;
            this.currentIndex = i;
            this.next = aVLNode.next();
            return value;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            AVLNode aVLNode = this.next;
            if (aVLNode == null) {
                this.next = this.parent.root.get(this.nextIndex - 1);
            } else {
                this.next = aVLNode.previous();
            }
            Object value = this.next.getValue();
            this.current = this.next;
            int i = this.nextIndex - 1;
            this.nextIndex = i;
            this.currentIndex = i;
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
            int i = this.currentIndex;
            if (i == -1) {
                throw new IllegalStateException();
            }
            this.parent.remove(i);
            int i2 = this.nextIndex;
            if (i2 != this.currentIndex) {
                this.nextIndex = i2 - 1;
            }
            this.next = null;
            this.current = null;
            this.currentIndex = -1;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            checkModCount();
            AVLNode aVLNode = this.current;
            if (aVLNode == null) {
                throw new IllegalStateException();
            }
            aVLNode.setValue(obj);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            checkModCount();
            this.parent.add(this.nextIndex, obj);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }
    }
}

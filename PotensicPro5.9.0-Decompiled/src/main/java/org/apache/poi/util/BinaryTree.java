package org.apache.poi.util;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes5.dex */
public class BinaryTree extends AbstractMap {
    private static int _INDEX_COUNT = 2;
    static int _KEY = 0;
    private static int _MINIMUM_INDEX = 0;
    static int _VALUE = 1;
    private final Set[] _entry_set;
    private final Set[] _key_set;
    int _modifications;
    final Node[] _root;
    int _size;
    private final Collection[] _value_collection;
    private static int _INDEX_SUM = 0 + 1;
    private static String[] _data_name = {"key", "value"};

    public BinaryTree() {
        this._size = 0;
        this._modifications = 0;
        this._key_set = new Set[]{null, null};
        this._entry_set = new Set[]{null, null};
        this._value_collection = new Collection[]{null, null};
        this._root = new Node[]{null, null};
    }

    public BinaryTree(Map map) throws ClassCastException, NullPointerException, IllegalArgumentException {
        this();
        putAll(map);
    }

    public Object getKeyForValue(Object obj) throws ClassCastException, NullPointerException {
        return doGet((Comparable) obj, _VALUE);
    }

    public Object removeValue(Object obj) {
        return doRemove((Comparable) obj, _VALUE);
    }

    public Set entrySetByValue() {
        Set[] setArr = this._entry_set;
        int i = _VALUE;
        if (setArr[i] == null) {
            setArr[i] = new AbstractSet() { // from class: org.apache.poi.util.BinaryTree.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new BinaryTreeIterator(BinaryTree._VALUE) { // from class: org.apache.poi.util.BinaryTree.1.1
                        {
                            BinaryTree binaryTree = BinaryTree.this;
                        }

                        @Override // org.apache.poi.util.BinaryTree.BinaryTreeIterator
                        protected Object doGetNext() {
                            return this._last_returned_node;
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Node lookup = BinaryTree.this.lookup((Comparable) entry.getValue(), BinaryTree._VALUE);
                    return lookup != null && lookup.getData(BinaryTree._KEY).equals(key);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Node lookup = BinaryTree.this.lookup((Comparable) entry.getValue(), BinaryTree._VALUE);
                    if (lookup == null || !lookup.getData(BinaryTree._KEY).equals(key)) {
                        return false;
                    }
                    BinaryTree.this.doRedBlackDelete(lookup);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return BinaryTree.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    BinaryTree.this.clear();
                }
            };
        }
        return this._entry_set[_VALUE];
    }

    public Set keySetByValue() {
        Set[] setArr = this._key_set;
        int i = _VALUE;
        if (setArr[i] == null) {
            setArr[i] = new AbstractSet() { // from class: org.apache.poi.util.BinaryTree.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new BinaryTreeIterator(BinaryTree._VALUE) { // from class: org.apache.poi.util.BinaryTree.2.1
                        {
                            BinaryTree binaryTree = BinaryTree.this;
                        }

                        @Override // org.apache.poi.util.BinaryTree.BinaryTreeIterator
                        protected Object doGetNext() {
                            return this._last_returned_node.getData(BinaryTree._KEY);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return BinaryTree.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return BinaryTree.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    int i2 = BinaryTree.this._size;
                    BinaryTree.this.remove(obj);
                    return BinaryTree.this._size != i2;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    BinaryTree.this.clear();
                }
            };
        }
        return this._key_set[_VALUE];
    }

    public Collection valuesByValue() {
        Collection[] collectionArr = this._value_collection;
        int i = _VALUE;
        if (collectionArr[i] == null) {
            collectionArr[i] = new AbstractCollection() { // from class: org.apache.poi.util.BinaryTree.3
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator iterator() {
                    return new BinaryTreeIterator(BinaryTree._VALUE) { // from class: org.apache.poi.util.BinaryTree.3.1
                        {
                            BinaryTree binaryTree = BinaryTree.this;
                        }

                        @Override // org.apache.poi.util.BinaryTree.BinaryTreeIterator
                        protected Object doGetNext() {
                            return this._last_returned_node.getData(BinaryTree._VALUE);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return BinaryTree.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return BinaryTree.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean remove(Object obj) {
                    int i2 = BinaryTree.this._size;
                    BinaryTree.this.removeValue(obj);
                    return BinaryTree.this._size != i2;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection collection) {
                    Iterator it = collection.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (BinaryTree.this.removeValue(it.next()) != null) {
                            z = true;
                        }
                    }
                    return z;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    BinaryTree.this.clear();
                }
            };
        }
        return this._value_collection[_VALUE];
    }

    private Object doRemove(Comparable comparable, int i) {
        Node lookup = lookup(comparable, i);
        if (lookup == null) {
            return null;
        }
        Comparable data = lookup.getData(oppositeIndex(i));
        doRedBlackDelete(lookup);
        return data;
    }

    private Object doGet(Comparable comparable, int i) {
        checkNonNullComparable(comparable, i);
        Node lookup = lookup(comparable, i);
        if (lookup == null) {
            return null;
        }
        return lookup.getData(oppositeIndex(i));
    }

    private int oppositeIndex(int i) {
        return _INDEX_SUM - i;
    }

    public Node lookup(Comparable comparable, int i) {
        Node node = this._root[i];
        while (node != null) {
            int compare = compare(comparable, node.getData(i));
            if (compare == 0) {
                return node;
            }
            node = compare < 0 ? node.getLeft(i) : node.getRight(i);
        }
        return null;
    }

    private static int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    static Node leastNode(Node node, int i) {
        if (node != null) {
            while (node.getLeft(i) != null) {
                node = node.getLeft(i);
            }
        }
        return node;
    }

    static Node nextGreater(Node node, int i) {
        if (node == null) {
            return null;
        }
        if (node.getRight(i) != null) {
            return leastNode(node.getRight(i), i);
        }
        Node parent = node.getParent(i);
        while (true) {
            Node node2 = parent;
            Node node3 = node;
            node = node2;
            if (node == null || node3 != node.getRight(i)) {
                return node;
            }
            parent = node.getParent(i);
        }
    }

    private static void copyColor(Node node, Node node2, int i) {
        if (node2 != null) {
            if (node == null) {
                node2.setBlack(i);
            } else {
                node2.copyColor(node, i);
            }
        }
    }

    private static boolean isRed(Node node, int i) {
        if (node == null) {
            return false;
        }
        return node.isRed(i);
    }

    private static boolean isBlack(Node node, int i) {
        if (node == null) {
            return true;
        }
        return node.isBlack(i);
    }

    private static void makeRed(Node node, int i) {
        if (node != null) {
            node.setRed(i);
        }
    }

    private static void makeBlack(Node node, int i) {
        if (node != null) {
            node.setBlack(i);
        }
    }

    private static Node getGrandParent(Node node, int i) {
        return getParent(getParent(node, i), i);
    }

    private static Node getParent(Node node, int i) {
        if (node == null) {
            return null;
        }
        return node.getParent(i);
    }

    private static Node getRightChild(Node node, int i) {
        if (node == null) {
            return null;
        }
        return node.getRight(i);
    }

    private static Node getLeftChild(Node node, int i) {
        if (node == null) {
            return null;
        }
        return node.getLeft(i);
    }

    private static boolean isLeftChild(Node node, int i) {
        if (node == null) {
            return true;
        }
        return node.getParent(i) != null && node == node.getParent(i).getLeft(i);
    }

    private static boolean isRightChild(Node node, int i) {
        if (node == null) {
            return true;
        }
        return node.getParent(i) != null && node == node.getParent(i).getRight(i);
    }

    private void rotateLeft(Node node, int i) {
        Node right = node.getRight(i);
        node.setRight(right.getLeft(i), i);
        if (right.getLeft(i) != null) {
            right.getLeft(i).setParent(node, i);
        }
        right.setParent(node.getParent(i), i);
        if (node.getParent(i) == null) {
            this._root[i] = right;
        } else if (node.getParent(i).getLeft(i) == node) {
            node.getParent(i).setLeft(right, i);
        } else {
            node.getParent(i).setRight(right, i);
        }
        right.setLeft(node, i);
        node.setParent(right, i);
    }

    private void rotateRight(Node node, int i) {
        Node left = node.getLeft(i);
        node.setLeft(left.getRight(i), i);
        if (left.getRight(i) != null) {
            left.getRight(i).setParent(node, i);
        }
        left.setParent(node.getParent(i), i);
        if (node.getParent(i) == null) {
            this._root[i] = left;
        } else if (node.getParent(i).getRight(i) == node) {
            node.getParent(i).setRight(left, i);
        } else {
            node.getParent(i).setLeft(left, i);
        }
        left.setRight(node, i);
        node.setParent(left, i);
    }

    private void doRedBlackInsert(Node node, int i) {
        makeRed(node, i);
        while (node != null && node != this._root[i] && isRed(node.getParent(i), i)) {
            if (isLeftChild(getParent(node, i), i)) {
                Node rightChild = getRightChild(getGrandParent(node, i), i);
                if (isRed(rightChild, i)) {
                    makeBlack(getParent(node, i), i);
                    makeBlack(rightChild, i);
                    makeRed(getGrandParent(node, i), i);
                    node = getGrandParent(node, i);
                } else {
                    if (isRightChild(node, i)) {
                        node = getParent(node, i);
                        rotateLeft(node, i);
                    }
                    makeBlack(getParent(node, i), i);
                    makeRed(getGrandParent(node, i), i);
                    if (getGrandParent(node, i) != null) {
                        rotateRight(getGrandParent(node, i), i);
                    }
                }
            } else {
                Node leftChild = getLeftChild(getGrandParent(node, i), i);
                if (isRed(leftChild, i)) {
                    makeBlack(getParent(node, i), i);
                    makeBlack(leftChild, i);
                    makeRed(getGrandParent(node, i), i);
                    node = getGrandParent(node, i);
                } else {
                    if (isLeftChild(node, i)) {
                        node = getParent(node, i);
                        rotateRight(node, i);
                    }
                    makeBlack(getParent(node, i), i);
                    makeRed(getGrandParent(node, i), i);
                    if (getGrandParent(node, i) != null) {
                        rotateLeft(getGrandParent(node, i), i);
                    }
                }
            }
        }
        makeBlack(this._root[i], i);
    }

    void doRedBlackDelete(Node node) {
        for (int i = _MINIMUM_INDEX; i < _INDEX_COUNT; i++) {
            if (node.getLeft(i) != null && node.getRight(i) != null) {
                swapPosition(nextGreater(node, i), node, i);
            }
            Node left = node.getLeft(i) != null ? node.getLeft(i) : node.getRight(i);
            if (left != null) {
                left.setParent(node.getParent(i), i);
                if (node.getParent(i) == null) {
                    this._root[i] = left;
                } else if (node == node.getParent(i).getLeft(i)) {
                    node.getParent(i).setLeft(left, i);
                } else {
                    node.getParent(i).setRight(left, i);
                }
                node.setLeft(null, i);
                node.setRight(null, i);
                node.setParent(null, i);
                if (isBlack(node, i)) {
                    doRedBlackDeleteFixup(left, i);
                }
            } else if (node.getParent(i) == null) {
                this._root[i] = null;
            } else {
                if (isBlack(node, i)) {
                    doRedBlackDeleteFixup(node, i);
                }
                if (node.getParent(i) != null) {
                    if (node == node.getParent(i).getLeft(i)) {
                        node.getParent(i).setLeft(null, i);
                    } else {
                        node.getParent(i).setRight(null, i);
                    }
                    node.setParent(null, i);
                }
            }
        }
        shrink();
    }

    private void doRedBlackDeleteFixup(Node node, int i) {
        while (node != this._root[i] && isBlack(node, i)) {
            if (isLeftChild(node, i)) {
                Node rightChild = getRightChild(getParent(node, i), i);
                if (isRed(rightChild, i)) {
                    makeBlack(rightChild, i);
                    makeRed(getParent(node, i), i);
                    rotateLeft(getParent(node, i), i);
                    rightChild = getRightChild(getParent(node, i), i);
                }
                if (isBlack(getLeftChild(rightChild, i), i) && isBlack(getRightChild(rightChild, i), i)) {
                    makeRed(rightChild, i);
                    node = getParent(node, i);
                } else {
                    if (isBlack(getRightChild(rightChild, i), i)) {
                        makeBlack(getLeftChild(rightChild, i), i);
                        makeRed(rightChild, i);
                        rotateRight(rightChild, i);
                        rightChild = getRightChild(getParent(node, i), i);
                    }
                    copyColor(getParent(node, i), rightChild, i);
                    makeBlack(getParent(node, i), i);
                    makeBlack(getRightChild(rightChild, i), i);
                    rotateLeft(getParent(node, i), i);
                    node = this._root[i];
                }
            } else {
                Node leftChild = getLeftChild(getParent(node, i), i);
                if (isRed(leftChild, i)) {
                    makeBlack(leftChild, i);
                    makeRed(getParent(node, i), i);
                    rotateRight(getParent(node, i), i);
                    leftChild = getLeftChild(getParent(node, i), i);
                }
                if (isBlack(getRightChild(leftChild, i), i) && isBlack(getLeftChild(leftChild, i), i)) {
                    makeRed(leftChild, i);
                    node = getParent(node, i);
                } else {
                    if (isBlack(getLeftChild(leftChild, i), i)) {
                        makeBlack(getRightChild(leftChild, i), i);
                        makeRed(leftChild, i);
                        rotateLeft(leftChild, i);
                        leftChild = getLeftChild(getParent(node, i), i);
                    }
                    copyColor(getParent(node, i), leftChild, i);
                    makeBlack(getParent(node, i), i);
                    makeBlack(getLeftChild(leftChild, i), i);
                    rotateRight(getParent(node, i), i);
                    node = this._root[i];
                }
            }
        }
        makeBlack(node, i);
    }

    private void swapPosition(Node node, Node node2, int i) {
        Node parent = node.getParent(i);
        Node left = node.getLeft(i);
        Node right = node.getRight(i);
        Node parent2 = node2.getParent(i);
        Node left2 = node2.getLeft(i);
        Node right2 = node2.getRight(i);
        boolean z = node.getParent(i) != null && node == node.getParent(i).getLeft(i);
        boolean z2 = node2.getParent(i) != null && node2 == node2.getParent(i).getLeft(i);
        if (node == parent2) {
            node.setParent(node2, i);
            if (z2) {
                node2.setLeft(node, i);
                node2.setRight(right, i);
            } else {
                node2.setRight(node, i);
                node2.setLeft(left, i);
            }
        } else {
            node.setParent(parent2, i);
            if (parent2 != null) {
                if (z2) {
                    parent2.setLeft(node, i);
                } else {
                    parent2.setRight(node, i);
                }
            }
            node2.setLeft(left, i);
            node2.setRight(right, i);
        }
        if (node2 == parent) {
            node2.setParent(node, i);
            if (z) {
                node.setLeft(node2, i);
                node.setRight(right2, i);
            } else {
                node.setRight(node2, i);
                node.setLeft(left2, i);
            }
        } else {
            node2.setParent(parent, i);
            if (parent != null) {
                if (z) {
                    parent.setLeft(node2, i);
                } else {
                    parent.setRight(node2, i);
                }
            }
            node.setLeft(left2, i);
            node.setRight(right2, i);
        }
        if (node.getLeft(i) != null) {
            node.getLeft(i).setParent(node, i);
        }
        if (node.getRight(i) != null) {
            node.getRight(i).setParent(node, i);
        }
        if (node2.getLeft(i) != null) {
            node2.getLeft(i).setParent(node2, i);
        }
        if (node2.getRight(i) != null) {
            node2.getRight(i).setParent(node2, i);
        }
        node.swapColors(node2, i);
        Node[] nodeArr = this._root;
        if (nodeArr[i] == node) {
            nodeArr[i] = node2;
        } else if (nodeArr[i] == node2) {
            nodeArr[i] = node;
        }
    }

    private static void checkNonNullComparable(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException(_data_name[i] + " cannot be null");
        }
        if (!(obj instanceof Comparable)) {
            throw new ClassCastException(_data_name[i] + " must be Comparable");
        }
    }

    private static void checkKey(Object obj) {
        checkNonNullComparable(obj, _KEY);
    }

    private static void checkValue(Object obj) {
        checkNonNullComparable(obj, _VALUE);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    private void modify() {
        this._modifications++;
    }

    private void grow() {
        modify();
        this._size++;
    }

    private void shrink() {
        modify();
        this._size--;
    }

    private void insertValue(Node node) throws IllegalArgumentException {
        Node node2 = this._root[_VALUE];
        while (true) {
            int compare = compare(node.getData(_VALUE), node2.getData(_VALUE));
            if (compare == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate value (\"" + node.getData(_VALUE) + "\") in this Map");
            }
            if (compare < 0) {
                if (node2.getLeft(_VALUE) != null) {
                    node2 = node2.getLeft(_VALUE);
                } else {
                    node2.setLeft(node, _VALUE);
                    node.setParent(node2, _VALUE);
                    doRedBlackInsert(node, _VALUE);
                    return;
                }
            } else if (node2.getRight(_VALUE) != null) {
                node2 = node2.getRight(_VALUE);
            } else {
                node2.setRight(node, _VALUE);
                node.setParent(node2, _VALUE);
                doRedBlackInsert(node, _VALUE);
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) throws ClassCastException, NullPointerException {
        checkKey(obj);
        return lookup((Comparable) obj, _KEY) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        checkValue(obj);
        return lookup((Comparable) obj, _VALUE) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) throws ClassCastException, NullPointerException {
        return doGet((Comparable) obj, _KEY);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) throws ClassCastException, NullPointerException, IllegalArgumentException {
        checkKeyAndValue(obj, obj2);
        Node node = this._root[_KEY];
        if (node == null) {
            Node node2 = new Node((Comparable) obj, (Comparable) obj2);
            Node[] nodeArr = this._root;
            nodeArr[_KEY] = node2;
            nodeArr[_VALUE] = node2;
            grow();
            return null;
        }
        while (true) {
            Comparable comparable = (Comparable) obj;
            int compare = compare(comparable, node.getData(_KEY));
            if (compare == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate key (\"" + obj + "\") in this Map");
            }
            if (compare < 0) {
                if (node.getLeft(_KEY) != null) {
                    node = node.getLeft(_KEY);
                } else {
                    Node node3 = new Node(comparable, (Comparable) obj2);
                    insertValue(node3);
                    node.setLeft(node3, _KEY);
                    node3.setParent(node, _KEY);
                    doRedBlackInsert(node3, _KEY);
                    grow();
                    return null;
                }
            } else if (node.getRight(_KEY) != null) {
                node = node.getRight(_KEY);
            } else {
                Node node4 = new Node(comparable, (Comparable) obj2);
                insertValue(node4);
                node.setRight(node4, _KEY);
                node4.setParent(node, _KEY);
                doRedBlackInsert(node4, _KEY);
                grow();
                return null;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return doRemove((Comparable) obj, _KEY);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        modify();
        this._size = 0;
        Node[] nodeArr = this._root;
        nodeArr[_KEY] = null;
        nodeArr[_VALUE] = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set[] setArr = this._key_set;
        int i = _KEY;
        if (setArr[i] == null) {
            setArr[i] = new AbstractSet() { // from class: org.apache.poi.util.BinaryTree.4
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new BinaryTreeIterator(BinaryTree._KEY) { // from class: org.apache.poi.util.BinaryTree.4.1
                        {
                            BinaryTree binaryTree = BinaryTree.this;
                        }

                        @Override // org.apache.poi.util.BinaryTree.BinaryTreeIterator
                        protected Object doGetNext() {
                            return this._last_returned_node.getData(BinaryTree._KEY);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return BinaryTree.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return BinaryTree.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    int i2 = BinaryTree.this._size;
                    BinaryTree.this.remove(obj);
                    return BinaryTree.this._size != i2;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    BinaryTree.this.clear();
                }
            };
        }
        return this._key_set[_KEY];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection[] collectionArr = this._value_collection;
        int i = _KEY;
        if (collectionArr[i] == null) {
            collectionArr[i] = new AbstractCollection() { // from class: org.apache.poi.util.BinaryTree.5
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator iterator() {
                    return new BinaryTreeIterator(BinaryTree._KEY) { // from class: org.apache.poi.util.BinaryTree.5.1
                        {
                            BinaryTree binaryTree = BinaryTree.this;
                        }

                        @Override // org.apache.poi.util.BinaryTree.BinaryTreeIterator
                        protected Object doGetNext() {
                            return this._last_returned_node.getData(BinaryTree._VALUE);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return BinaryTree.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return BinaryTree.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean remove(Object obj) {
                    int i2 = BinaryTree.this._size;
                    BinaryTree.this.removeValue(obj);
                    return BinaryTree.this._size != i2;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection collection) {
                    Iterator it = collection.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (BinaryTree.this.removeValue(it.next()) != null) {
                            z = true;
                        }
                    }
                    return z;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    BinaryTree.this.clear();
                }
            };
        }
        return this._value_collection[_KEY];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set[] setArr = this._entry_set;
        int i = _KEY;
        if (setArr[i] == null) {
            setArr[i] = new AbstractSet() { // from class: org.apache.poi.util.BinaryTree.6
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new BinaryTreeIterator(BinaryTree._KEY) { // from class: org.apache.poi.util.BinaryTree.6.1
                        {
                            BinaryTree binaryTree = BinaryTree.this;
                        }

                        @Override // org.apache.poi.util.BinaryTree.BinaryTreeIterator
                        protected Object doGetNext() {
                            return this._last_returned_node;
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object value = entry.getValue();
                    Node lookup = BinaryTree.this.lookup((Comparable) entry.getKey(), BinaryTree._KEY);
                    return lookup != null && lookup.getData(BinaryTree._VALUE).equals(value);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object value = entry.getValue();
                    Node lookup = BinaryTree.this.lookup((Comparable) entry.getKey(), BinaryTree._KEY);
                    if (lookup == null || !lookup.getData(BinaryTree._VALUE).equals(value)) {
                        return false;
                    }
                    BinaryTree.this.doRedBlackDelete(lookup);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return BinaryTree.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    BinaryTree.this.clear();
                }
            };
        }
        return this._entry_set[_KEY];
    }

    private abstract class BinaryTreeIterator implements Iterator {
        private int _expected_modifications;
        protected Node _last_returned_node = null;
        private Node _next_node;
        private int _type;

        protected abstract Object doGetNext();

        BinaryTreeIterator(int i) {
            this._type = i;
            this._expected_modifications = BinaryTree.this._modifications;
            Node[] nodeArr = BinaryTree.this._root;
            int i2 = this._type;
            this._next_node = BinaryTree.leastNode(nodeArr[i2], i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._next_node != null;
        }

        @Override // java.util.Iterator
        public Object next() throws NoSuchElementException, ConcurrentModificationException {
            if (this._next_node == null) {
                throw new NoSuchElementException();
            }
            if (BinaryTree.this._modifications != this._expected_modifications) {
                throw new ConcurrentModificationException();
            }
            Node node = this._next_node;
            this._last_returned_node = node;
            this._next_node = BinaryTree.nextGreater(node, this._type);
            return doGetNext();
        }

        @Override // java.util.Iterator
        public void remove() throws IllegalStateException, ConcurrentModificationException {
            if (this._last_returned_node == null) {
                throw new IllegalStateException();
            }
            if (BinaryTree.this._modifications != this._expected_modifications) {
                throw new ConcurrentModificationException();
            }
            BinaryTree.this.doRedBlackDelete(this._last_returned_node);
            this._expected_modifications++;
            this._last_returned_node = null;
        }
    }

    private static final class Node implements Map.Entry {
        private Comparable[] _data;
        private int _hashcode;
        private Node[] _left = {null, null};
        private Node[] _right = {null, null};
        private Node[] _parent = {null, null};
        private boolean[] _black = {true, true};
        private boolean _calculated_hashcode = false;

        Node(Comparable comparable, Comparable comparable2) {
            this._data = new Comparable[]{comparable, comparable2};
        }

        public Comparable getData(int i) {
            return this._data[i];
        }

        public void setLeft(Node node, int i) {
            this._left[i] = node;
        }

        public Node getLeft(int i) {
            return this._left[i];
        }

        public void setRight(Node node, int i) {
            this._right[i] = node;
        }

        public Node getRight(int i) {
            return this._right[i];
        }

        public void setParent(Node node, int i) {
            this._parent[i] = node;
        }

        public Node getParent(int i) {
            return this._parent[i];
        }

        public void swapColors(Node node, int i) {
            boolean[] zArr = this._black;
            boolean z = zArr[i];
            boolean[] zArr2 = node._black;
            zArr[i] = z ^ zArr2[i];
            zArr2[i] = zArr2[i] ^ zArr[i];
            zArr[i] = zArr2[i] ^ zArr[i];
        }

        public boolean isBlack(int i) {
            return this._black[i];
        }

        public boolean isRed(int i) {
            return !this._black[i];
        }

        public void setBlack(int i) {
            this._black[i] = true;
        }

        public void setRed(int i) {
            this._black[i] = false;
        }

        public void copyColor(Node node, int i) {
            this._black[i] = node._black[i];
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this._data[BinaryTree._KEY];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this._data[BinaryTree._VALUE];
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this._data[BinaryTree._KEY].equals(entry.getKey()) && this._data[BinaryTree._VALUE].equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this._calculated_hashcode) {
                this._hashcode = this._data[BinaryTree._KEY].hashCode() ^ this._data[BinaryTree._VALUE].hashCode();
                this._calculated_hashcode = true;
            }
            return this._hashcode;
        }
    }
}

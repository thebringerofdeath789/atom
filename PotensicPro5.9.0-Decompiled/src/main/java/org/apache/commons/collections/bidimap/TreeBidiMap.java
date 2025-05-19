package org.apache.commons.collections.bidimap;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections.keyvalue.UnmodifiableMapEntry;

/* loaded from: classes4.dex */
public class TreeBidiMap implements OrderedBidiMap {
    private static final int FIRST_INDEX = 0;
    private static final int INVERSEMAPENTRY = 3;
    private static final int KEY = 0;
    private static final int MAPENTRY = 2;
    private static final int NUMBER_OF_INDICES = 2;
    private static final int SUM_OF_INDICES = 1;
    private static final int VALUE = 1;
    private static final String[] dataName = {"key", "value"};
    private Set entrySet;
    private Inverse inverse;
    private Set keySet;
    private int modifications;
    private int nodeCount;
    private Node[] rootNode;
    private Set valuesSet;

    /* JADX INFO: Access modifiers changed from: private */
    public static int oppositeIndex(int i) {
        return 1 - i;
    }

    public TreeBidiMap() {
        this.rootNode = new Node[2];
        this.nodeCount = 0;
        this.modifications = 0;
        this.inverse = null;
    }

    public TreeBidiMap(Map map) {
        this.rootNode = new Node[2];
        this.nodeCount = 0;
        this.modifications = 0;
        this.inverse = null;
        putAll(map);
    }

    @Override // java.util.Map
    public int size() {
        return this.nodeCount;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.nodeCount == 0;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        checkKey(obj);
        return lookup((Comparable) obj, 0) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        checkValue(obj);
        return lookup((Comparable) obj, 1) != null;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return doGet((Comparable) obj, 0);
    }

    @Override // org.apache.commons.collections.BidiMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return doPut((Comparable) obj, (Comparable) obj2, 0);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return doRemove((Comparable) obj, 0);
    }

    @Override // java.util.Map
    public void clear() {
        modify();
        this.nodeCount = 0;
        Node[] nodeArr = this.rootNode;
        nodeArr[0] = null;
        nodeArr[1] = null;
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object getKey(Object obj) {
        return doGet((Comparable) obj, 1);
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object removeValue(Object obj) {
        return doRemove((Comparable) obj, 1);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        if (this.nodeCount == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return leastNode(this.rootNode[0], 0).getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        if (this.nodeCount == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        return greatestNode(this.rootNode[0], 0).getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        checkKey(obj);
        Node nextGreater = nextGreater(lookup((Comparable) obj, 0), 0);
        if (nextGreater == null) {
            return null;
        }
        return nextGreater.getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        checkKey(obj);
        Node nextSmaller = nextSmaller(lookup((Comparable) obj, 0), 0);
        if (nextSmaller == null) {
            return null;
        }
        return nextSmaller.getKey();
    }

    @Override // java.util.Map
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new View(this, 0, 0);
        }
        return this.keySet;
    }

    @Override // java.util.Map
    public Collection values() {
        if (this.valuesSet == null) {
            this.valuesSet = new View(this, 0, 1);
        }
        return this.valuesSet;
    }

    @Override // java.util.Map
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntryView(this, 0, 2);
        }
        return this.entrySet;
    }

    @Override // org.apache.commons.collections.BidiMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        if (isEmpty()) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new ViewMapIterator(this, 0);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        if (isEmpty()) {
            return EmptyOrderedMapIterator.INSTANCE;
        }
        return new ViewMapIterator(this, 0);
    }

    @Override // org.apache.commons.collections.OrderedBidiMap, org.apache.commons.collections.BidiMap
    public BidiMap inverseBidiMap() {
        return inverseOrderedBidiMap();
    }

    @Override // org.apache.commons.collections.OrderedBidiMap
    public OrderedBidiMap inverseOrderedBidiMap() {
        if (this.inverse == null) {
            this.inverse = new Inverse(this);
        }
        return this.inverse;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return doEquals(obj, 0);
    }

    @Override // java.util.Map
    public int hashCode() {
        return doHashCode(0);
    }

    public String toString() {
        return doToString(0);
    }

    private Object doGet(Comparable comparable, int i) {
        checkNonNullComparable(comparable, i);
        Node lookup = lookup(comparable, i);
        if (lookup == null) {
            return null;
        }
        return lookup.getData(oppositeIndex(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object doPut(Comparable comparable, Comparable comparable2, int i) {
        Node right;
        checkKeyAndValue(comparable, comparable2);
        Object doGet = i == 0 ? doGet(comparable, 0) : doGet(comparable2, 1);
        doRemove(comparable, 0);
        doRemove(comparable2, 1);
        Node node = this.rootNode[0];
        if (node == null) {
            Node node2 = new Node(comparable, comparable2);
            Node[] nodeArr = this.rootNode;
            nodeArr[0] = node2;
            nodeArr[1] = node2;
            grow();
        } else {
            while (true) {
                int compare = compare(comparable, node.getData(0));
                if (compare == 0) {
                    throw new IllegalArgumentException(new StringBuffer().append("Cannot store a duplicate key (\"").append(comparable).append("\") in this Map").toString());
                }
                if (compare < 0) {
                    if (node.getLeft(0) == null) {
                        Node node3 = new Node(comparable, comparable2);
                        insertValue(node3);
                        node.setLeft(node3, 0);
                        node3.setParent(node, 0);
                        doRedBlackInsert(node3, 0);
                        grow();
                        break;
                    }
                    right = node.getLeft(0);
                    node = right;
                } else {
                    if (node.getRight(0) == null) {
                        Node node4 = new Node(comparable, comparable2);
                        insertValue(node4);
                        node.setRight(node4, 0);
                        node4.setParent(node, 0);
                        doRedBlackInsert(node4, 0);
                        grow();
                        break;
                    }
                    right = node.getRight(0);
                    node = right;
                }
            }
        }
        return doGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object doRemove(Comparable comparable, int i) {
        Node lookup = lookup(comparable, i);
        if (lookup == null) {
            return null;
        }
        Comparable data = lookup.getData(oppositeIndex(i));
        doRedBlackDelete(lookup);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node lookup(Comparable comparable, int i) {
        Node node = this.rootNode[i];
        while (node != null) {
            int compare = compare(comparable, node.getData(i));
            if (compare == 0) {
                return node;
            }
            node = compare < 0 ? node.getLeft(i) : node.getRight(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node nextGreater(Node node, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public Node nextSmaller(Node node, int i) {
        if (node == null) {
            return null;
        }
        if (node.getLeft(i) != null) {
            return greatestNode(node.getLeft(i), i);
        }
        Node parent = node.getParent(i);
        while (true) {
            Node node2 = parent;
            Node node3 = node;
            node = node2;
            if (node == null || node3 != node.getLeft(i)) {
                return node;
            }
            parent = node.getParent(i);
        }
    }

    private static int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node leastNode(Node node, int i) {
        if (node != null) {
            while (node.getLeft(i) != null) {
                node = node.getLeft(i);
            }
        }
        return node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node greatestNode(Node node, int i) {
        if (node != null) {
            while (node.getRight(i) != null) {
                node = node.getRight(i);
            }
        }
        return node;
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
        return node == null || (node.getParent(i) != null && node == node.getParent(i).getLeft(i));
    }

    private static boolean isRightChild(Node node, int i) {
        return node == null || (node.getParent(i) != null && node == node.getParent(i).getRight(i));
    }

    private void rotateLeft(Node node, int i) {
        Node right = node.getRight(i);
        node.setRight(right.getLeft(i), i);
        if (right.getLeft(i) != null) {
            right.getLeft(i).setParent(node, i);
        }
        right.setParent(node.getParent(i), i);
        if (node.getParent(i) == null) {
            this.rootNode[i] = right;
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
            this.rootNode[i] = left;
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
        while (node != null && node != this.rootNode[i] && isRed(node.getParent(i), i)) {
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
        makeBlack(this.rootNode[i], i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRedBlackDelete(Node node) {
        for (int i = 0; i < 2; i++) {
            if (node.getLeft(i) != null && node.getRight(i) != null) {
                swapPosition(nextGreater(node, i), node, i);
            }
            Node left = node.getLeft(i) != null ? node.getLeft(i) : node.getRight(i);
            if (left != null) {
                left.setParent(node.getParent(i), i);
                if (node.getParent(i) == null) {
                    this.rootNode[i] = left;
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
                this.rootNode[i] = null;
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
        while (node != this.rootNode[i] && isBlack(node, i)) {
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
                    node = this.rootNode[i];
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
                    node = this.rootNode[i];
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
        Node[] nodeArr = this.rootNode;
        if (nodeArr[i] == node) {
            nodeArr[i] = node2;
        } else if (nodeArr[i] == node2) {
            nodeArr[i] = node;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkNonNullComparable(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException(new StringBuffer().append(dataName[i]).append(" cannot be null").toString());
        }
        if (!(obj instanceof Comparable)) {
            throw new ClassCastException(new StringBuffer().append(dataName[i]).append(" must be Comparable").toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkKey(Object obj) {
        checkNonNullComparable(obj, 0);
    }

    private static void checkValue(Object obj) {
        checkNonNullComparable(obj, 1);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    private void modify() {
        this.modifications++;
    }

    private void grow() {
        modify();
        this.nodeCount++;
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void insertValue(Node node) throws IllegalArgumentException {
        Node node2 = this.rootNode[1];
        while (true) {
            int compare = compare(node.getData(1), node2.getData(1));
            if (compare == 0) {
                throw new IllegalArgumentException(new StringBuffer().append("Cannot store a duplicate value (\"").append(node.getData(1)).append("\") in this Map").toString());
            }
            if (compare < 0) {
                if (node2.getLeft(1) != null) {
                    node2 = node2.getLeft(1);
                } else {
                    node2.setLeft(node, 1);
                    node.setParent(node2, 1);
                    doRedBlackInsert(node, 1);
                    return;
                }
            } else if (node2.getRight(1) != null) {
                node2 = node2.getRight(1);
            } else {
                node2.setRight(node, 1);
                node.setParent(node2, 1);
                doRedBlackInsert(node, 1);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doEquals(Object obj, int i) {
        ViewMapIterator viewMapIterator;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        if (this.nodeCount > 0) {
            try {
                viewMapIterator = new ViewMapIterator(this, i);
            } catch (ClassCastException | NullPointerException unused) {
            }
            while (viewMapIterator.hasNext()) {
                if (!viewMapIterator.getValue().equals(map.get(viewMapIterator.next()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doHashCode(int i) {
        int i2 = 0;
        if (this.nodeCount > 0) {
            ViewMapIterator viewMapIterator = new ViewMapIterator(this, i);
            while (viewMapIterator.hasNext()) {
                i2 += viewMapIterator.next().hashCode() ^ viewMapIterator.getValue().hashCode();
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doToString(int i) {
        if (this.nodeCount == 0) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(this.nodeCount * 32);
        stringBuffer.append('{');
        ViewMapIterator viewMapIterator = new ViewMapIterator(this, i);
        boolean hasNext = viewMapIterator.hasNext();
        while (hasNext) {
            Object next = viewMapIterator.next();
            Object value = viewMapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            StringBuffer append = stringBuffer.append(next).append('=');
            if (value == this) {
                value = "(this Map)";
            }
            append.append(value);
            hasNext = viewMapIterator.hasNext();
            if (hasNext) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    static class View extends AbstractSet {
        protected final int dataType;
        protected final TreeBidiMap main;
        protected final int orderType;

        View(TreeBidiMap treeBidiMap, int i, int i2) {
            this.main = treeBidiMap;
            this.orderType = i;
            this.dataType = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new ViewIterator(this.main, this.orderType, this.dataType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.main.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TreeBidiMap.checkNonNullComparable(obj, this.dataType);
            return this.main.lookup((Comparable) obj, this.dataType) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.main.doRemove((Comparable) obj, this.dataType) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.main.clear();
        }
    }

    static class ViewIterator implements OrderedIterator {
        protected final int dataType;
        private int expectedModifications;
        protected final TreeBidiMap main;
        protected Node nextNode;
        protected final int orderType;
        protected Node lastReturnedNode = null;
        protected Node previousNode = null;

        ViewIterator(TreeBidiMap treeBidiMap, int i, int i2) {
            this.main = treeBidiMap;
            this.orderType = i;
            this.dataType = i2;
            this.expectedModifications = treeBidiMap.modifications;
            this.nextNode = TreeBidiMap.leastNode(treeBidiMap.rootNode[i], i);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.nextNode != null) {
                if (this.main.modifications != this.expectedModifications) {
                    throw new ConcurrentModificationException();
                }
                Node node = this.nextNode;
                this.lastReturnedNode = node;
                this.previousNode = node;
                this.nextNode = this.main.nextGreater(node, this.orderType);
                return doGetData();
            }
            throw new NoSuchElementException();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.previousNode != null;
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            if (this.previousNode != null) {
                if (this.main.modifications != this.expectedModifications) {
                    throw new ConcurrentModificationException();
                }
                Node node = this.lastReturnedNode;
                this.nextNode = node;
                if (node == null) {
                    this.nextNode = this.main.nextGreater(this.previousNode, this.orderType);
                }
                Node node2 = this.previousNode;
                this.lastReturnedNode = node2;
                this.previousNode = this.main.nextSmaller(node2, this.orderType);
                return doGetData();
            }
            throw new NoSuchElementException();
        }

        protected Object doGetData() {
            int i = this.dataType;
            if (i == 0) {
                return this.lastReturnedNode.getKey();
            }
            if (i == 1) {
                return this.lastReturnedNode.getValue();
            }
            if (i == 2) {
                return this.lastReturnedNode;
            }
            if (i != 3) {
                return null;
            }
            return new UnmodifiableMapEntry(this.lastReturnedNode.getValue(), this.lastReturnedNode.getKey());
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.lastReturnedNode != null) {
                if (this.main.modifications == this.expectedModifications) {
                    this.main.doRedBlackDelete(this.lastReturnedNode);
                    this.expectedModifications++;
                    this.lastReturnedNode = null;
                    Node node = this.nextNode;
                    if (node == null) {
                        Node[] nodeArr = this.main.rootNode;
                        int i = this.orderType;
                        this.previousNode = TreeBidiMap.greatestNode(nodeArr[i], i);
                        return;
                    }
                    this.previousNode = this.main.nextSmaller(node, this.orderType);
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException();
        }
    }

    static class ViewMapIterator extends ViewIterator implements OrderedMapIterator {
        private final int oppositeType;

        ViewMapIterator(TreeBidiMap treeBidiMap, int i) {
            super(treeBidiMap, i, i);
            this.oppositeType = TreeBidiMap.oppositeIndex(this.dataType);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return this.lastReturnedNode.getData(this.dataType);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return this.lastReturnedNode.getData(this.oppositeType);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    static class EntryView extends View {
        private final int oppositeType;

        EntryView(TreeBidiMap treeBidiMap, int i, int i2) {
            super(treeBidiMap, i, i2);
            this.oppositeType = TreeBidiMap.oppositeIndex(i);
        }

        @Override // org.apache.commons.collections.bidimap.TreeBidiMap.View, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node lookup = this.main.lookup((Comparable) entry.getKey(), this.orderType);
            return lookup != null && lookup.getData(this.oppositeType).equals(value);
        }

        @Override // org.apache.commons.collections.bidimap.TreeBidiMap.View, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node lookup = this.main.lookup((Comparable) entry.getKey(), this.orderType);
            if (lookup == null || !lookup.getData(this.oppositeType).equals(value)) {
                return false;
            }
            this.main.doRedBlackDelete(lookup);
            return true;
        }
    }

    static class Node implements Map.Entry, KeyValue {
        private Comparable[] data;
        private int hashcodeValue;
        private Node[] leftNode = new Node[2];
        private Node[] rightNode = new Node[2];
        private Node[] parentNode = new Node[2];
        private boolean[] blackColor = {true, true};
        private boolean calculatedHashCode = false;

        Node(Comparable comparable, Comparable comparable2) {
            this.data = new Comparable[]{comparable, comparable2};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Comparable getData(int i) {
            return this.data[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeft(Node node, int i) {
            this.leftNode[i] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node getLeft(int i) {
            return this.leftNode[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRight(Node node, int i) {
            this.rightNode[i] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node getRight(int i) {
            return this.rightNode[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(Node node, int i) {
            this.parentNode[i] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node getParent(int i) {
            return this.parentNode[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void swapColors(Node node, int i) {
            boolean[] zArr = this.blackColor;
            boolean z = zArr[i];
            boolean[] zArr2 = node.blackColor;
            zArr[i] = z ^ zArr2[i];
            zArr2[i] = zArr2[i] ^ zArr[i];
            zArr[i] = zArr2[i] ^ zArr[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isBlack(int i) {
            return this.blackColor[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRed(int i) {
            return !this.blackColor[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlack(int i) {
            this.blackColor[i] = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRed(int i) {
            this.blackColor[i] = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyColor(Node node, int i) {
            this.blackColor[i] = node.blackColor[i];
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getKey() {
            return this.data[0];
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return this.data[1];
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.data[0].equals(entry.getKey()) && this.data[1].equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.calculatedHashCode) {
                this.hashcodeValue = this.data[0].hashCode() ^ this.data[1].hashCode();
                this.calculatedHashCode = true;
            }
            return this.hashcodeValue;
        }
    }

    static class Inverse implements OrderedBidiMap {
        private Set entrySet;
        private Set keySet;
        private final TreeBidiMap main;
        private Set valuesSet;

        Inverse(TreeBidiMap treeBidiMap) {
            this.main = treeBidiMap;
        }

        @Override // java.util.Map
        public int size() {
            return this.main.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.main.isEmpty();
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return this.main.getKey(obj);
        }

        @Override // org.apache.commons.collections.BidiMap
        public Object getKey(Object obj) {
            return this.main.get(obj);
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.main.containsValue(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.main.containsKey(obj);
        }

        @Override // org.apache.commons.collections.OrderedMap
        public Object firstKey() {
            if (this.main.nodeCount != 0) {
                return TreeBidiMap.leastNode(this.main.rootNode[1], 1).getValue();
            }
            throw new NoSuchElementException("Map is empty");
        }

        @Override // org.apache.commons.collections.OrderedMap
        public Object lastKey() {
            if (this.main.nodeCount != 0) {
                return TreeBidiMap.greatestNode(this.main.rootNode[1], 1).getValue();
            }
            throw new NoSuchElementException("Map is empty");
        }

        @Override // org.apache.commons.collections.OrderedMap
        public Object nextKey(Object obj) {
            TreeBidiMap.checkKey(obj);
            TreeBidiMap treeBidiMap = this.main;
            Node nextGreater = treeBidiMap.nextGreater(treeBidiMap.lookup((Comparable) obj, 1), 1);
            if (nextGreater == null) {
                return null;
            }
            return nextGreater.getValue();
        }

        @Override // org.apache.commons.collections.OrderedMap
        public Object previousKey(Object obj) {
            TreeBidiMap.checkKey(obj);
            TreeBidiMap treeBidiMap = this.main;
            Node nextSmaller = treeBidiMap.nextSmaller(treeBidiMap.lookup((Comparable) obj, 1), 1);
            if (nextSmaller == null) {
                return null;
            }
            return nextSmaller.getValue();
        }

        @Override // org.apache.commons.collections.BidiMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return this.main.doPut((Comparable) obj2, (Comparable) obj, 1);
        }

        @Override // java.util.Map
        public void putAll(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            return this.main.removeValue(obj);
        }

        @Override // org.apache.commons.collections.BidiMap
        public Object removeValue(Object obj) {
            return this.main.remove(obj);
        }

        @Override // java.util.Map
        public void clear() {
            this.main.clear();
        }

        @Override // java.util.Map
        public Set keySet() {
            if (this.keySet == null) {
                this.keySet = new View(this.main, 1, 1);
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public Collection values() {
            if (this.valuesSet == null) {
                this.valuesSet = new View(this.main, 1, 0);
            }
            return this.valuesSet;
        }

        @Override // java.util.Map
        public Set entrySet() {
            Set set = this.entrySet;
            return set == null ? new EntryView(this.main, 1, 3) : set;
        }

        @Override // org.apache.commons.collections.BidiMap, org.apache.commons.collections.IterableMap
        public MapIterator mapIterator() {
            if (isEmpty()) {
                return EmptyOrderedMapIterator.INSTANCE;
            }
            return new ViewMapIterator(this.main, 1);
        }

        @Override // org.apache.commons.collections.OrderedMap
        public OrderedMapIterator orderedMapIterator() {
            if (isEmpty()) {
                return EmptyOrderedMapIterator.INSTANCE;
            }
            return new ViewMapIterator(this.main, 1);
        }

        @Override // org.apache.commons.collections.OrderedBidiMap, org.apache.commons.collections.BidiMap
        public BidiMap inverseBidiMap() {
            return this.main;
        }

        @Override // org.apache.commons.collections.OrderedBidiMap
        public OrderedBidiMap inverseOrderedBidiMap() {
            return this.main;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.main.doEquals(obj, 1);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.main.doHashCode(1);
        }

        public String toString() {
            return this.main.doToString(1);
        }
    }
}

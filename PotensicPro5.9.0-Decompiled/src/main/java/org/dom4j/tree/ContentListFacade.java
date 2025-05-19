package org.dom4j.tree;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class ContentListFacade extends AbstractList {
    private AbstractBranch branch;
    private List branchContent;

    public ContentListFacade(AbstractBranch abstractBranch, List list) {
        this.branch = abstractBranch;
        this.branchContent = list;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        this.branch.childAdded(asNode(obj));
        return this.branchContent.add(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        this.branch.childAdded(asNode(obj));
        this.branchContent.add(i, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        this.branch.childAdded(asNode(obj));
        return this.branchContent.set(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        this.branch.childRemoved(asNode(obj));
        return this.branchContent.remove(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        Object remove = this.branchContent.remove(i);
        if (remove != null) {
            this.branch.childRemoved(asNode(remove));
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        int size = this.branchContent.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
            size++;
        }
        return size == this.branchContent.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        int size = this.branchContent.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            add(i, it.next());
            size--;
            i++;
        }
        return size == this.branchContent.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Iterator it = iterator();
        while (it.hasNext()) {
            this.branch.childRemoved(asNode(it.next()));
        }
        this.branchContent.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.branch.childRemoved(asNode(it.next()));
        }
        return this.branchContent.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.branchContent.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.branchContent.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.branchContent.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.branchContent.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        return this.branchContent.toArray(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection collection) {
        return this.branchContent.containsAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        return this.branchContent.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.branchContent.indexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.branchContent.lastIndexOf(obj);
    }

    protected Node asNode(Object obj) {
        if (obj instanceof Node) {
            return (Node) obj;
        }
        throw new IllegalAddException(new StringBuffer().append("This list must contain instances of Node. Invalid type: ").append(obj).toString());
    }

    protected List getBackingList() {
        return this.branchContent;
    }
}

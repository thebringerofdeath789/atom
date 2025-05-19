package org.dom4j.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class BackedList extends ArrayList {
    private AbstractBranch branch;
    private List branchContent;

    public BackedList(AbstractBranch abstractBranch, List list) {
        this(abstractBranch, list, list.size());
    }

    public BackedList(AbstractBranch abstractBranch, List list, int i) {
        super(i);
        this.branch = abstractBranch;
        this.branchContent = list;
    }

    public BackedList(AbstractBranch abstractBranch, List list, List list2) {
        super(list2);
        this.branch = abstractBranch;
        this.branchContent = list;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        this.branch.addNode(asNode(obj));
        return super.add(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int indexOf;
        int size = size();
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index value: ").append(i).append(" is less than zero").toString());
        }
        if (i > size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index value: ").append(i).append(" cannot be greater than ").append("the size: ").append(size).toString());
        }
        if (size == 0) {
            indexOf = this.branchContent.size();
        } else if (i < size) {
            indexOf = this.branchContent.indexOf(get(i));
        } else {
            indexOf = this.branchContent.indexOf(get(size - 1)) + 1;
        }
        this.branch.addNode(indexOf, asNode(obj));
        super.add(i, obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int indexOf = this.branchContent.indexOf(get(i));
        if (indexOf < 0) {
            indexOf = i == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (indexOf < this.branchContent.size()) {
            this.branch.removeNode(asNode(get(i)));
            this.branch.addNode(indexOf, asNode(obj));
        } else {
            this.branch.removeNode(asNode(get(i)));
            this.branch.addNode(asNode(obj));
        }
        this.branch.childAdded(asNode(obj));
        return super.set(i, obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        this.branch.removeNode(asNode(obj));
        return super.remove(obj);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object remove(int i) {
        Object remove = super.remove(i);
        if (remove != null) {
            this.branch.removeNode(asNode(remove));
        }
        return remove;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        ensureCapacity(size() + collection.size());
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
            size--;
        }
        return size != 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        ensureCapacity(size() + collection.size());
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            add(i, it.next());
            size--;
            i++;
        }
        return size != 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Iterator it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            this.branchContent.remove(next);
            this.branch.childRemoved(asNode(next));
        }
        super.clear();
    }

    public void addLocal(Object obj) {
        super.add(obj);
    }

    protected Node asNode(Object obj) {
        if (obj instanceof Node) {
            return (Node) obj;
        }
        throw new IllegalAddException(new StringBuffer().append("This list must contain instances of Node. Invalid type: ").append(obj).toString());
    }
}

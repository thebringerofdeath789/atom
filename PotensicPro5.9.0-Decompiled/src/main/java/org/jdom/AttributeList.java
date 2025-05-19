package org.jdom;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class AttributeList extends AbstractList implements List, Serializable {
    private static final String CVS_ID = "@(#) $RCSfile: AttributeList.java,v $ $Revision: 1.23 $ $Date: 2004/02/28 03:30:27 $ $Name: jdom_1_0 $";
    private static final int INITIAL_ARRAY_SIZE = 5;
    private Attribute[] elementData;
    private Element parent;
    private int size;

    private AttributeList() {
    }

    AttributeList(Element element) {
        this.parent = element;
    }

    final void uncheckedAddAttribute(Attribute attribute) {
        attribute.parent = this.parent;
        ensureCapacity(this.size + 1);
        Attribute[] attributeArr = this.elementData;
        int i = this.size;
        this.size = i + 1;
        attributeArr[i] = attribute;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        if (!(obj instanceof Attribute)) {
            if (obj == null) {
                throw new IllegalAddException("Cannot add null attribute");
            }
            throw new IllegalAddException(new StringBuffer("Class ").append(obj.getClass().getName()).append(" is not an attribute").toString());
        }
        Attribute attribute = (Attribute) obj;
        int indexOfDuplicate = indexOfDuplicate(attribute);
        if (indexOfDuplicate < 0) {
            add(size(), attribute);
            return true;
        }
        set(indexOfDuplicate, attribute);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        if (!(obj instanceof Attribute)) {
            if (obj == null) {
                throw new IllegalAddException("Cannot add null attribute");
            }
            throw new IllegalAddException(new StringBuffer("Class ").append(obj.getClass().getName()).append(" is not an attribute").toString());
        }
        Attribute attribute = (Attribute) obj;
        if (indexOfDuplicate(attribute) >= 0) {
            throw new IllegalAddException("Cannot add duplicate attribute");
        }
        add(i, attribute);
        ((AbstractList) this).modCount++;
    }

    void add(int i, Attribute attribute) {
        if (attribute.getParent() != null) {
            throw new IllegalAddException(new StringBuffer("The attribute already has an existing parent \"").append(attribute.getParent().getQualifiedName()).append("\"").toString());
        }
        String checkNamespaceCollision = Verifier.checkNamespaceCollision(attribute, this.parent);
        if (checkNamespaceCollision != null) {
            throw new IllegalAddException(this.parent, attribute, checkNamespaceCollision);
        }
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        attribute.setParent(this.parent);
        ensureCapacity(this.size + 1);
        int i2 = this.size;
        if (i == i2) {
            Attribute[] attributeArr = this.elementData;
            this.size = i2 + 1;
            attributeArr[i2] = attribute;
        } else {
            Attribute[] attributeArr2 = this.elementData;
            System.arraycopy(attributeArr2, i, attributeArr2, i + 1, i2 - i);
            this.elementData[i] = attribute;
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
                this.elementData[i].setParent(null);
            }
            this.elementData = null;
            this.size = 0;
        }
        ((AbstractList) this).modCount++;
    }

    void clearAndSet(Collection collection) {
        Attribute[] attributeArr = this.elementData;
        int i = this.size;
        this.elementData = null;
        this.size = 0;
        if (collection != null && collection.size() != 0) {
            ensureCapacity(collection.size());
            try {
                addAll(0, collection);
            } catch (RuntimeException e) {
                this.elementData = attributeArr;
                this.size = i;
                throw e;
            }
        }
        if (attributeArr != null) {
            for (int i2 = 0; i2 < i; i2++) {
                attributeArr[i2].setParent(null);
            }
        }
        ((AbstractList) this).modCount++;
    }

    private void ensureCapacity(int i) {
        Attribute[] attributeArr = this.elementData;
        if (attributeArr == null) {
            this.elementData = new Attribute[Math.max(i, 5)];
            return;
        }
        int length = attributeArr.length;
        if (i > length) {
            int i2 = ((length * 3) / 2) + 1;
            if (i2 >= i) {
                i = i2;
            }
            Attribute[] attributeArr2 = new Attribute[i];
            this.elementData = attributeArr2;
            System.arraycopy(attributeArr, 0, attributeArr2, 0, this.size);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        return this.elementData[i];
    }

    Object get(String str, Namespace namespace) {
        int indexOf = indexOf(str, namespace);
        if (indexOf < 0) {
            return null;
        }
        return this.elementData[indexOf];
    }

    int indexOf(String str, Namespace namespace) {
        String uri = namespace.getURI();
        if (this.elementData == null) {
            return -1;
        }
        for (int i = 0; i < this.size; i++) {
            Attribute attribute = this.elementData[i];
            String namespaceURI = attribute.getNamespaceURI();
            String name = attribute.getName();
            if (namespaceURI.equals(uri) && name.equals(str)) {
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
        Attribute attribute = this.elementData[i];
        attribute.setParent(null);
        int i2 = (this.size - i) - 1;
        if (i2 > 0) {
            Attribute[] attributeArr = this.elementData;
            System.arraycopy(attributeArr, i + 1, attributeArr, i, i2);
        }
        Attribute[] attributeArr2 = this.elementData;
        int i3 = this.size - 1;
        this.size = i3;
        attributeArr2[i3] = null;
        ((AbstractList) this).modCount++;
        return attribute;
    }

    boolean remove(String str, Namespace namespace) {
        int indexOf = indexOf(str, namespace);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        if (!(obj instanceof Attribute)) {
            if (obj == null) {
                throw new IllegalAddException("Cannot add null attribute");
            }
            throw new IllegalAddException(new StringBuffer("Class ").append(obj.getClass().getName()).append(" is not an attribute").toString());
        }
        Attribute attribute = (Attribute) obj;
        int indexOfDuplicate = indexOfDuplicate(attribute);
        if (indexOfDuplicate >= 0 && indexOfDuplicate != i) {
            throw new IllegalAddException("Cannot set duplicate attribute");
        }
        return set(i, attribute);
    }

    Object set(int i, Attribute attribute) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer("Index: ").append(i).append(" Size: ").append(size()).toString());
        }
        if (attribute.getParent() != null) {
            throw new IllegalAddException(new StringBuffer("The attribute already has an existing parent \"").append(attribute.getParent().getQualifiedName()).append("\"").toString());
        }
        String checkNamespaceCollision = Verifier.checkNamespaceCollision(attribute, this.parent);
        if (checkNamespaceCollision != null) {
            throw new IllegalAddException(this.parent, attribute, checkNamespaceCollision);
        }
        Attribute attribute2 = this.elementData[i];
        attribute2.setParent(null);
        this.elementData[i] = attribute;
        attribute.setParent(this.parent);
        return attribute2;
    }

    private int indexOfDuplicate(Attribute attribute) {
        return indexOf(attribute.getName(), attribute.getNamespace());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }
}

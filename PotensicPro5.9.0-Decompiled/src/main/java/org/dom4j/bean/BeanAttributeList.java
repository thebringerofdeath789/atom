package org.dom4j.bean;

import java.util.AbstractList;
import org.dom4j.Attribute;
import org.dom4j.QName;

/* loaded from: classes5.dex */
public class BeanAttributeList extends AbstractList {
    private BeanAttribute[] attributes;
    private BeanMetaData beanMetaData;
    private BeanElement parent;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return false;
    }

    public BeanAttributeList(BeanElement beanElement, BeanMetaData beanMetaData) {
        this.parent = beanElement;
        this.beanMetaData = beanMetaData;
        this.attributes = new BeanAttribute[beanMetaData.attributeCount()];
    }

    public BeanAttributeList(BeanElement beanElement) {
        this.parent = beanElement;
        Object data = beanElement.getData();
        BeanMetaData beanMetaData = BeanMetaData.get(data != null ? data.getClass() : null);
        this.beanMetaData = beanMetaData;
        this.attributes = new BeanAttribute[beanMetaData.attributeCount()];
    }

    public Attribute attribute(String str) {
        return attribute(this.beanMetaData.getIndex(str));
    }

    public Attribute attribute(QName qName) {
        return attribute(this.beanMetaData.getIndex(qName));
    }

    public BeanAttribute attribute(int i) {
        if (i < 0) {
            return null;
        }
        BeanAttribute[] beanAttributeArr = this.attributes;
        if (i > beanAttributeArr.length) {
            return null;
        }
        BeanAttribute beanAttribute = beanAttributeArr[i];
        if (beanAttribute != null) {
            return beanAttribute;
        }
        BeanAttribute createAttribute = createAttribute(this.parent, i);
        this.attributes[i] = createAttribute;
        return createAttribute;
    }

    public BeanElement getParent() {
        return this.parent;
    }

    public QName getQName(int i) {
        return this.beanMetaData.getQName(i);
    }

    public Object getData(int i) {
        return this.beanMetaData.getData(i, this.parent.getData());
    }

    public void setData(int i, Object obj) {
        this.beanMetaData.setData(i, this.parent.getData(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.attributes.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        BeanAttribute beanAttribute = this.attributes[i];
        if (beanAttribute != null) {
            return beanAttribute;
        }
        BeanAttribute createAttribute = createAttribute(this.parent, i);
        this.attributes[i] = createAttribute;
        return createAttribute;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("add(Object) unsupported");
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("add(int,Object) unsupported");
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException("set(int,Object) unsupported");
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        BeanAttribute beanAttribute = (BeanAttribute) get(i);
        String value = beanAttribute.getValue();
        beanAttribute.setValue(null);
        return value;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int length = this.attributes.length;
        for (int i = 0; i < length; i++) {
            BeanAttribute beanAttribute = this.attributes[i];
            if (beanAttribute != null) {
                beanAttribute.setValue(null);
            }
        }
    }

    protected BeanAttribute createAttribute(BeanElement beanElement, int i) {
        return new BeanAttribute(this, i);
    }
}

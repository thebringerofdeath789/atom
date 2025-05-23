package org.dom4j.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.QName;
import org.dom4j.tree.BackedList;
import org.dom4j.tree.DefaultElement;

/* loaded from: classes5.dex */
public class IndexedElement extends DefaultElement {
    private Map attributeIndex;
    private Map elementIndex;

    public IndexedElement(String str) {
        super(str);
    }

    public IndexedElement(QName qName) {
        super(qName);
    }

    public IndexedElement(QName qName, int i) {
        super(qName, i);
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Attribute attribute(String str) {
        return (Attribute) attributeIndex().get(str);
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Attribute attribute(QName qName) {
        return (Attribute) attributeIndex().get(qName);
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Element element(String str) {
        return asElement(elementIndex().get(str));
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Element element(QName qName) {
        return asElement(elementIndex().get(qName));
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public List elements(String str) {
        return asElementList(elementIndex().get(str));
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public List elements(QName qName) {
        return asElementList(elementIndex().get(qName));
    }

    protected Element asElement(Object obj) {
        if (obj instanceof Element) {
            return (Element) obj;
        }
        if (obj == null) {
            return null;
        }
        List list = (List) obj;
        if (list.size() >= 1) {
            return (Element) list.get(0);
        }
        return null;
    }

    protected List asElementList(Object obj) {
        if (obj instanceof Element) {
            return createSingleResultList(obj);
        }
        if (obj != null) {
            List list = (List) obj;
            BackedList createResultList = createResultList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                createResultList.addLocal(list.get(i));
            }
            return createResultList;
        }
        return createEmptyList();
    }

    protected Iterator asElementIterator(Object obj) {
        return asElementList(obj).iterator();
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractBranch
    protected void addNode(Node node) {
        super.addNode(node);
        if (this.elementIndex != null && (node instanceof Element)) {
            addToElementIndex((Element) node);
        } else {
            if (this.attributeIndex == null || !(node instanceof Attribute)) {
                return;
            }
            addToAttributeIndex((Attribute) node);
        }
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractBranch
    protected boolean removeNode(Node node) {
        if (!super.removeNode(node)) {
            return false;
        }
        if (this.elementIndex != null && (node instanceof Element)) {
            removeFromElementIndex((Element) node);
            return true;
        }
        if (this.attributeIndex == null || !(node instanceof Attribute)) {
            return true;
        }
        removeFromAttributeIndex((Attribute) node);
        return true;
    }

    protected Map attributeIndex() {
        if (this.attributeIndex == null) {
            this.attributeIndex = createAttributeIndex();
            Iterator attributeIterator = attributeIterator();
            while (attributeIterator.hasNext()) {
                addToAttributeIndex((Attribute) attributeIterator.next());
            }
        }
        return this.attributeIndex;
    }

    protected Map elementIndex() {
        if (this.elementIndex == null) {
            this.elementIndex = createElementIndex();
            Iterator elementIterator = elementIterator();
            while (elementIterator.hasNext()) {
                addToElementIndex((Element) elementIterator.next());
            }
        }
        return this.elementIndex;
    }

    protected Map createAttributeIndex() {
        return createIndex();
    }

    protected Map createElementIndex() {
        return createIndex();
    }

    protected void addToElementIndex(Element element) {
        QName qName = element.getQName();
        String name = qName.getName();
        addToElementIndex(qName, element);
        addToElementIndex(name, element);
    }

    protected void addToElementIndex(Object obj, Element element) {
        Object obj2 = this.elementIndex.get(obj);
        if (obj2 == null) {
            this.elementIndex.put(obj, element);
            return;
        }
        if (obj2 instanceof List) {
            ((List) obj2).add(element);
            return;
        }
        List createList = createList();
        createList.add(obj2);
        createList.add(element);
        this.elementIndex.put(obj, createList);
    }

    protected void removeFromElementIndex(Element element) {
        QName qName = element.getQName();
        String name = qName.getName();
        removeFromElementIndex(qName, element);
        removeFromElementIndex(name, element);
    }

    protected void removeFromElementIndex(Object obj, Element element) {
        Object obj2 = this.elementIndex.get(obj);
        if (obj2 instanceof List) {
            ((List) obj2).remove(element);
        } else {
            this.elementIndex.remove(obj);
        }
    }

    protected void addToAttributeIndex(Attribute attribute) {
        QName qName = attribute.getQName();
        String name = qName.getName();
        addToAttributeIndex(qName, attribute);
        addToAttributeIndex(name, attribute);
    }

    protected void addToAttributeIndex(Object obj, Attribute attribute) {
        if (this.attributeIndex.get(obj) != null) {
            this.attributeIndex.put(obj, attribute);
        }
    }

    protected void removeFromAttributeIndex(Attribute attribute) {
        QName qName = attribute.getQName();
        String name = qName.getName();
        removeFromAttributeIndex(qName, attribute);
        removeFromAttributeIndex(name, attribute);
    }

    protected void removeFromAttributeIndex(Object obj, Attribute attribute) {
        Object obj2 = this.attributeIndex.get(obj);
        if (obj2 == null || !obj2.equals(attribute)) {
            return;
        }
        this.attributeIndex.remove(obj);
    }

    protected Map createIndex() {
        return new HashMap();
    }

    protected List createList() {
        return new ArrayList();
    }
}

package org.jdom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jdom.filter.Filter;

/* loaded from: classes5.dex */
public class Document implements Parent {
    private static final String CVS_ID = "@(#) $RCSfile: Document.java,v $ $Revision: 1.84 $ $Date: 2004/08/31 21:47:51 $ $Name: jdom_1_0 $";
    protected String baseURI;
    ContentList content;
    private HashMap propertyMap;

    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // org.jdom.Parent
    public Document getDocument() {
        return this;
    }

    @Override // org.jdom.Parent
    public Parent getParent() {
        return null;
    }

    public Document() {
        this.content = new ContentList(this);
        this.baseURI = null;
        this.propertyMap = null;
    }

    public Document(Element element, DocType docType, String str) {
        this.content = new ContentList(this);
        this.baseURI = null;
        this.propertyMap = null;
        if (element != null) {
            setRootElement(element);
        }
        if (docType != null) {
            setDocType(docType);
        }
        if (str != null) {
            setBaseURI(str);
        }
    }

    public Document(Element element, DocType docType) {
        this(element, docType, null);
    }

    public Document(Element element) {
        this(element, null, null);
    }

    public Document(List list) {
        this.content = new ContentList(this);
        this.baseURI = null;
        this.propertyMap = null;
        setContent(list);
    }

    @Override // org.jdom.Parent
    public int getContentSize() {
        return this.content.size();
    }

    @Override // org.jdom.Parent
    public int indexOf(Content content) {
        return this.content.indexOf(content);
    }

    public boolean hasRootElement() {
        return this.content.indexOfFirstElement() >= 0;
    }

    public Element getRootElement() {
        int indexOfFirstElement = this.content.indexOfFirstElement();
        if (indexOfFirstElement < 0) {
            throw new IllegalStateException("Root element not set");
        }
        return (Element) this.content.get(indexOfFirstElement);
    }

    public Document setRootElement(Element element) {
        int indexOfFirstElement = this.content.indexOfFirstElement();
        if (indexOfFirstElement < 0) {
            this.content.add(element);
        } else {
            this.content.set(indexOfFirstElement, element);
        }
        return this;
    }

    public Element detachRootElement() {
        int indexOfFirstElement = this.content.indexOfFirstElement();
        if (indexOfFirstElement < 0) {
            return null;
        }
        return (Element) removeContent(indexOfFirstElement);
    }

    public DocType getDocType() {
        int indexOfDocType = this.content.indexOfDocType();
        if (indexOfDocType < 0) {
            return null;
        }
        return (DocType) this.content.get(indexOfDocType);
    }

    public Document setDocType(DocType docType) {
        if (docType == null) {
            int indexOfDocType = this.content.indexOfDocType();
            if (indexOfDocType >= 0) {
                this.content.remove(indexOfDocType);
            }
            return this;
        }
        if (docType.getParent() != null) {
            throw new IllegalAddException(docType, "The DocType already is attached to a document");
        }
        int indexOfDocType2 = this.content.indexOfDocType();
        if (indexOfDocType2 < 0) {
            this.content.add(0, (Content) docType);
        } else {
            this.content.set(indexOfDocType2, docType);
        }
        return this;
    }

    public Document addContent(Content content) {
        this.content.add(content);
        return this;
    }

    public Document addContent(Collection collection) {
        this.content.addAll(collection);
        return this;
    }

    public Document addContent(int i, Content content) {
        this.content.add(i, content);
        return this;
    }

    public Document addContent(int i, Collection collection) {
        this.content.addAll(i, collection);
        return this;
    }

    @Override // org.jdom.Parent
    public List cloneContent() {
        int contentSize = getContentSize();
        ArrayList arrayList = new ArrayList(contentSize);
        for (int i = 0; i < contentSize; i++) {
            arrayList.add(getContent(i).clone());
        }
        return arrayList;
    }

    @Override // org.jdom.Parent
    public Content getContent(int i) {
        return (Content) this.content.get(i);
    }

    @Override // org.jdom.Parent
    public List getContent() {
        if (!hasRootElement()) {
            throw new IllegalStateException("Root element not set");
        }
        return this.content;
    }

    @Override // org.jdom.Parent
    public List getContent(Filter filter) {
        if (!hasRootElement()) {
            throw new IllegalStateException("Root element not set");
        }
        return this.content.getView(filter);
    }

    @Override // org.jdom.Parent
    public List removeContent() {
        ArrayList arrayList = new ArrayList(this.content);
        this.content.clear();
        return arrayList;
    }

    @Override // org.jdom.Parent
    public List removeContent(Filter filter) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.content.getView(filter).iterator();
        while (it.hasNext()) {
            arrayList.add((Content) it.next());
            it.remove();
        }
        return arrayList;
    }

    public Document setContent(Collection collection) {
        this.content.clearAndSet(collection);
        return this;
    }

    public final void setBaseURI(String str) {
        this.baseURI = str;
    }

    public final String getBaseURI() {
        return this.baseURI;
    }

    public Document setContent(int i, Content content) {
        this.content.set(i, content);
        return this;
    }

    public Document setContent(int i, Collection collection) {
        this.content.remove(i);
        this.content.addAll(i, collection);
        return this;
    }

    @Override // org.jdom.Parent
    public boolean removeContent(Content content) {
        return this.content.remove(content);
    }

    @Override // org.jdom.Parent
    public Content removeContent(int i) {
        return (Content) this.content.remove(i);
    }

    public Document setContent(Content content) {
        this.content.clear();
        this.content.add(content);
        return this;
    }

    public String toString() {
        StringBuffer append = new StringBuffer().append("[Document: ");
        DocType docType = getDocType();
        if (docType != null) {
            append.append(docType.toString()).append(", ");
        } else {
            append.append(" No DOCTYPE declaration, ");
        }
        Element rootElement = getRootElement();
        if (rootElement != null) {
            append.append("Root is ").append(rootElement.toString());
        } else {
            append.append(" No root element");
        }
        append.append("]");
        return append.toString();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // org.jdom.Parent
    public Object clone() {
        Document document;
        try {
            document = (Document) super.clone();
        } catch (CloneNotSupportedException unused) {
            document = null;
        }
        document.content = new ContentList(document);
        for (int i = 0; i < this.content.size(); i++) {
            Object obj = this.content.get(i);
            if (obj instanceof Element) {
                document.content.add((Element) ((Element) obj).clone());
            } else if (obj instanceof Comment) {
                document.content.add((Comment) ((Comment) obj).clone());
            } else if (obj instanceof ProcessingInstruction) {
                document.content.add((ProcessingInstruction) ((ProcessingInstruction) obj).clone());
            } else if (obj instanceof DocType) {
                document.content.add((DocType) ((DocType) obj).clone());
            }
        }
        return document;
    }

    @Override // org.jdom.Parent
    public Iterator getDescendants() {
        return new DescendantIterator(this);
    }

    @Override // org.jdom.Parent
    public Iterator getDescendants(Filter filter) {
        return new FilterIterator(new DescendantIterator(this), filter);
    }

    public void setProperty(String str, Object obj) {
        if (this.propertyMap == null) {
            this.propertyMap = new HashMap();
        }
        this.propertyMap.put(str, obj);
    }

    public Object getProperty(String str) {
        HashMap hashMap = this.propertyMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }
}

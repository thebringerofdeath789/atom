package org.dom4j.tree;

import java.util.List;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

/* loaded from: classes5.dex */
public class BaseElement extends AbstractElement {
    protected List attributes;
    protected List content;
    private Branch parentBranch;
    private QName qname;

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }

    public BaseElement(String str) {
        this.qname = getDocumentFactory().createQName(str);
    }

    public BaseElement(QName qName) {
        this.qname = qName;
    }

    public BaseElement(String str, Namespace namespace) {
        this.qname = getDocumentFactory().createQName(str, namespace);
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Element getParent() {
        Branch branch = this.parentBranch;
        if (branch instanceof Element) {
            return (Element) branch;
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setParent(Element element) {
        if ((this.parentBranch instanceof Element) || element != null) {
            this.parentBranch = element;
        }
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Document getDocument() {
        Branch branch = this.parentBranch;
        if (branch instanceof Document) {
            return (Document) branch;
        }
        if (branch instanceof Element) {
            return ((Element) branch).getDocument();
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setDocument(Document document) {
        if ((this.parentBranch instanceof Document) || document != null) {
            this.parentBranch = document;
        }
    }

    @Override // org.dom4j.Element
    public QName getQName() {
        return this.qname;
    }

    @Override // org.dom4j.Element
    public void setQName(QName qName) {
        this.qname = qName;
    }

    @Override // org.dom4j.Branch
    public void clearContent() {
        contentList().clear();
    }

    @Override // org.dom4j.Branch
    public void setContent(List list) {
        this.content = list;
        if (list instanceof ContentListFacade) {
            this.content = ((ContentListFacade) list).getBackingList();
        }
    }

    @Override // org.dom4j.Element
    public void setAttributes(List list) {
        this.attributes = list;
        if (list instanceof ContentListFacade) {
            this.attributes = ((ContentListFacade) list).getBackingList();
        }
    }

    @Override // org.dom4j.tree.AbstractBranch
    protected List contentList() {
        if (this.content == null) {
            this.content = createContentList();
        }
        return this.content;
    }

    @Override // org.dom4j.tree.AbstractElement
    protected List attributeList() {
        if (this.attributes == null) {
            this.attributes = createAttributeList();
        }
        return this.attributes;
    }

    @Override // org.dom4j.tree.AbstractElement
    protected List attributeList(int i) {
        if (this.attributes == null) {
            this.attributes = createAttributeList(i);
        }
        return this.attributes;
    }

    protected void setAttributeList(List list) {
        this.attributes = list;
    }
}

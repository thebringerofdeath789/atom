package org.dom4j.tree;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.NodeFilter;
import org.dom4j.XPath;
import org.dom4j.rule.Pattern;

/* loaded from: classes5.dex */
public abstract class AbstractNode implements Node, Cloneable, Serializable {
    protected static final String[] NODE_TYPE_NAMES = {"Node", "Element", "Attribute", "Text", "CDATA", "Entity", "Entity", "ProcessingInstruction", "Comment", "Document", "DocumentType", "DocumentFragment", "Notation", "Namespace", "Unknown"};
    private static final DocumentFactory DOCUMENT_FACTORY = DocumentFactory.getInstance();

    @Override // org.dom4j.Node
    public String getName() {
        return null;
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 14;
    }

    @Override // org.dom4j.Node
    public Element getParent() {
        return null;
    }

    @Override // org.dom4j.Node
    public String getText() {
        return null;
    }

    @Override // org.dom4j.Node
    public boolean hasContent() {
        return false;
    }

    @Override // org.dom4j.Node
    public boolean isReadOnly() {
        return true;
    }

    @Override // org.dom4j.Node
    public void setDocument(Document document) {
    }

    @Override // org.dom4j.Node
    public void setParent(Element element) {
    }

    @Override // org.dom4j.Node
    public boolean supportsParent() {
        return false;
    }

    @Override // org.dom4j.Node
    public String getNodeTypeName() {
        short nodeType = getNodeType();
        if (nodeType < 0) {
            return "Unknown";
        }
        String[] strArr = NODE_TYPE_NAMES;
        return nodeType >= strArr.length ? "Unknown" : strArr[nodeType];
    }

    @Override // org.dom4j.Node
    public Document getDocument() {
        Element parent = getParent();
        if (parent != null) {
            return parent.getDocument();
        }
        return null;
    }

    @Override // org.dom4j.Node
    public String getPath() {
        return getPath(null);
    }

    @Override // org.dom4j.Node
    public String getUniquePath() {
        return getUniquePath(null);
    }

    @Override // org.dom4j.Node
    public Object clone() {
        if (isReadOnly()) {
            return this;
        }
        try {
            Node node = (Node) super.clone();
            node.setParent(null);
            node.setDocument(null);
            return node;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(new StringBuffer().append("This should never happen. Caught: ").append(e).toString());
        }
    }

    @Override // org.dom4j.Node
    public Node detach() {
        Element parent = getParent();
        if (parent != null) {
            parent.remove(this);
        } else {
            Document document = getDocument();
            if (document != null) {
                document.remove(this);
            }
        }
        setParent(null);
        setDocument(null);
        return this;
    }

    @Override // org.dom4j.Node
    public void setName(String str) {
        throw new UnsupportedOperationException("This node cannot be modified");
    }

    @Override // org.dom4j.Node
    public String getStringValue() {
        return getText();
    }

    @Override // org.dom4j.Node
    public void setText(String str) {
        throw new UnsupportedOperationException("This node cannot be modified");
    }

    @Override // org.dom4j.Node
    public void write(Writer writer) throws IOException {
        writer.write(asXML());
    }

    @Override // org.dom4j.Node
    public Object selectObject(String str) {
        return createXPath(str).evaluate(this);
    }

    @Override // org.dom4j.Node
    public List selectNodes(String str) {
        return createXPath(str).selectNodes(this);
    }

    @Override // org.dom4j.Node
    public List selectNodes(String str, String str2) {
        return selectNodes(str, str2, false);
    }

    @Override // org.dom4j.Node
    public List selectNodes(String str, String str2, boolean z) {
        return createXPath(str).selectNodes(this, createXPath(str2), z);
    }

    @Override // org.dom4j.Node
    public Node selectSingleNode(String str) {
        return createXPath(str).selectSingleNode(this);
    }

    @Override // org.dom4j.Node
    public String valueOf(String str) {
        return createXPath(str).valueOf(this);
    }

    @Override // org.dom4j.Node
    public Number numberValueOf(String str) {
        return createXPath(str).numberValueOf(this);
    }

    @Override // org.dom4j.Node
    public boolean matches(String str) {
        return createXPathFilter(str).matches(this);
    }

    @Override // org.dom4j.Node
    public XPath createXPath(String str) {
        return getDocumentFactory().createXPath(str);
    }

    public NodeFilter createXPathFilter(String str) {
        return getDocumentFactory().createXPathFilter(str);
    }

    public Pattern createPattern(String str) {
        return getDocumentFactory().createPattern(str);
    }

    @Override // org.dom4j.Node
    public Node asXPathResult(Element element) {
        return supportsParent() ? this : createXPathResult(element);
    }

    protected DocumentFactory getDocumentFactory() {
        return DOCUMENT_FACTORY;
    }

    protected Node createXPathResult(Element element) {
        throw new RuntimeException(new StringBuffer().append("asXPathResult() not yet implemented fully for: ").append(this).toString());
    }
}

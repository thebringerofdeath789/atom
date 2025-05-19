package org.dom4j.dom;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.DocumentFactory;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class DOMElement extends DefaultElement implements Element {
    private static final DocumentFactory DOCUMENT_FACTORY = DOMDocumentFactory.getInstance();

    @Override // org.w3c.dom.Node
    public String getNodeValue() throws DOMException {
        return null;
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String str) throws DOMException {
    }

    public DOMElement(String str) {
        super(str);
    }

    public DOMElement(QName qName) {
        super(qName);
    }

    public DOMElement(QName qName, int i) {
        super(qName, i);
    }

    public DOMElement(String str, Namespace namespace) {
        super(str, namespace);
    }

    public boolean supports(String str, String str2) {
        return DOMNodeHelper.supports(this, str, str2);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element, org.w3c.dom.Node
    public String getNamespaceURI() {
        return getQName().getNamespaceURI();
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return getQName().getNamespacePrefix();
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) throws DOMException {
        DOMNodeHelper.setPrefix(this, str);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return getQName().getName();
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return getName();
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return DOMNodeHelper.getParentNode(this);
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DOMNodeHelper.createNodeList(content());
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return DOMNodeHelper.asDOMNode(node(0));
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return DOMNodeHelper.asDOMNode(node(nodeCount() - 1));
    }

    @Override // org.w3c.dom.Node
    public Node getPreviousSibling() {
        return DOMNodeHelper.getPreviousSibling(this);
    }

    @Override // org.w3c.dom.Node
    public Node getNextSibling() {
        return DOMNodeHelper.getNextSibling(this);
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return new DOMAttributeNodeMap(this);
    }

    @Override // org.w3c.dom.Node
    public Document getOwnerDocument() {
        return DOMNodeHelper.getOwnerDocument(this);
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) throws DOMException {
        checkNewChildNode(node);
        return DOMNodeHelper.insertBefore(this, node, node2);
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) throws DOMException {
        checkNewChildNode(node);
        return DOMNodeHelper.replaceChild(this, node, node2);
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node node) throws DOMException {
        return DOMNodeHelper.removeChild(this, node);
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node node) throws DOMException {
        checkNewChildNode(node);
        return DOMNodeHelper.appendChild(this, node);
    }

    private void checkNewChildNode(Node node) throws DOMException {
        short nodeType = node.getNodeType();
        if (nodeType != 1 && nodeType != 3 && nodeType != 8 && nodeType != 7 && nodeType != 4 && nodeType != 5) {
            throw new DOMException((short) 3, "Given node cannot be a child of element");
        }
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return nodeCount() > 0;
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean z) {
        return DOMNodeHelper.cloneNode(this, z);
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return DOMNodeHelper.isSupported(this, str, str2);
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return DOMNodeHelper.hasAttributes(this);
    }

    @Override // org.w3c.dom.Element
    public String getTagName() {
        return getName();
    }

    @Override // org.w3c.dom.Element
    public String getAttribute(String str) {
        String attributeValue = attributeValue(str);
        return attributeValue != null ? attributeValue : "";
    }

    @Override // org.w3c.dom.Element
    public void setAttribute(String str, String str2) throws DOMException {
        addAttribute(str, str2);
    }

    @Override // org.w3c.dom.Element
    public void removeAttribute(String str) throws DOMException {
        Attribute attribute = attribute(str);
        if (attribute != null) {
            remove(attribute);
        }
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNode(String str) {
        return DOMNodeHelper.asDOMAttr(attribute(str));
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNode(Attr attr) throws DOMException {
        if (isReadOnly()) {
            throw new DOMException((short) 7, "No modification allowed");
        }
        Attribute attribute = attribute(attr);
        if (attribute != attr) {
            if (attr.getOwnerElement() != null) {
                throw new DOMException((short) 10, "Attribute is already in use");
            }
            Attribute createAttribute = createAttribute(attr);
            if (attribute != null) {
                attribute.detach();
            }
            add(createAttribute);
        }
        return DOMNodeHelper.asDOMAttr(attribute);
    }

    @Override // org.w3c.dom.Element
    public Attr removeAttributeNode(Attr attr) throws DOMException {
        Attribute attribute = attribute(attr);
        if (attribute != null) {
            attribute.detach();
            return DOMNodeHelper.asDOMAttr(attribute);
        }
        throw new DOMException((short) 8, "No such attribute");
    }

    @Override // org.w3c.dom.Element
    public String getAttributeNS(String str, String str2) {
        String value;
        Attribute attribute = attribute(str, str2);
        return (attribute == null || (value = attribute.getValue()) == null) ? "" : value;
    }

    @Override // org.w3c.dom.Element
    public void setAttributeNS(String str, String str2, String str3) throws DOMException {
        Attribute attribute = attribute(str, str2);
        if (attribute != null) {
            attribute.setValue(str3);
        } else {
            addAttribute(getQName(str, str2), str3);
        }
    }

    @Override // org.w3c.dom.Element
    public void removeAttributeNS(String str, String str2) throws DOMException {
        Attribute attribute = attribute(str, str2);
        if (attribute != null) {
            remove(attribute);
        }
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNodeNS(String str, String str2) {
        Attribute attribute = attribute(str, str2);
        if (attribute == null) {
            return null;
        }
        DOMNodeHelper.asDOMAttr(attribute);
        return null;
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNodeNS(Attr attr) throws DOMException {
        Attribute attribute = attribute(attr.getNamespaceURI(), attr.getLocalName());
        if (attribute != null) {
            attribute.setValue(attr.getValue());
        } else {
            attribute = createAttribute(attr);
            add(attribute);
        }
        return DOMNodeHelper.asDOMAttr(attribute);
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagName(String str) {
        ArrayList arrayList = new ArrayList();
        DOMNodeHelper.appendElementsByTagName(arrayList, this, str);
        return DOMNodeHelper.createNodeList(arrayList);
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagNameNS(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        DOMNodeHelper.appendElementsByTagNameNS(arrayList, this, str, str2);
        return DOMNodeHelper.createNodeList(arrayList);
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttribute(String str) {
        return attribute(str) != null;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttributeNS(String str, String str2) {
        return attribute(str, str2) != null;
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractNode
    protected DocumentFactory getDocumentFactory() {
        DocumentFactory documentFactory = getQName().getDocumentFactory();
        return documentFactory != null ? documentFactory : DOCUMENT_FACTORY;
    }

    protected Attribute attribute(Attr attr) {
        return attribute(DOCUMENT_FACTORY.createQName(attr.getLocalName(), attr.getPrefix(), attr.getNamespaceURI()));
    }

    protected Attribute attribute(String str, String str2) {
        List attributeList = attributeList();
        int size = attributeList.size();
        for (int i = 0; i < size; i++) {
            Attribute attribute = (Attribute) attributeList.get(i);
            if (str2.equals(attribute.getName()) && (((str == null || str.length() == 0) && (attribute.getNamespaceURI() == null || attribute.getNamespaceURI().length() == 0)) || (str != null && str.equals(attribute.getNamespaceURI())))) {
                return attribute;
            }
        }
        return null;
    }

    protected Attribute createAttribute(Attr attr) {
        QName createQName;
        String localName = attr.getLocalName();
        if (localName != null) {
            createQName = getDocumentFactory().createQName(localName, attr.getPrefix(), attr.getNamespaceURI());
        } else {
            createQName = getDocumentFactory().createQName(attr.getName());
        }
        return new DOMAttribute(createQName, attr.getValue());
    }

    protected QName getQName(String str, String str2) {
        String str3;
        int indexOf = str2.indexOf(58);
        if (indexOf >= 0) {
            str3 = str2.substring(0, indexOf);
            str2 = str2.substring(indexOf + 1);
        } else {
            str3 = "";
        }
        return getDocumentFactory().createQName(str2, str3, str);
    }
}

package org.dom4j.dom;

import org.dom4j.Element;
import org.dom4j.tree.DefaultText;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public class DOMText extends DefaultText implements Text {
    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return "#text";
    }

    public DOMText(String str) {
        super(str);
    }

    public DOMText(Element element, String str) {
        super(element, str);
    }

    public boolean supports(String str, String str2) {
        return DOMNodeHelper.supports(this, str, str2);
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return DOMNodeHelper.getNamespaceURI(this);
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return DOMNodeHelper.getPrefix(this);
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) throws DOMException {
        DOMNodeHelper.setPrefix(this, str);
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return DOMNodeHelper.getLocalName(this);
    }

    @Override // org.w3c.dom.Node
    public String getNodeValue() throws DOMException {
        return DOMNodeHelper.getNodeValue(this);
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String str) throws DOMException {
        DOMNodeHelper.setNodeValue(this, str);
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return DOMNodeHelper.getParentNode(this);
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DOMNodeHelper.getChildNodes(this);
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return DOMNodeHelper.getFirstChild(this);
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return DOMNodeHelper.getLastChild(this);
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
        throw new DOMException((short) 3, "Text nodes cannot have children");
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return DOMNodeHelper.hasChildNodes(this);
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean z) {
        return DOMNodeHelper.cloneNode(this, z);
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
        DOMNodeHelper.normalize(this);
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return DOMNodeHelper.isSupported(this, str, str2);
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return DOMNodeHelper.hasAttributes(this);
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() throws DOMException {
        return DOMNodeHelper.getData(this);
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String str) throws DOMException {
        DOMNodeHelper.setData(this, str);
    }

    @Override // org.w3c.dom.CharacterData
    public int getLength() {
        return DOMNodeHelper.getLength(this);
    }

    @Override // org.w3c.dom.CharacterData
    public String substringData(int i, int i2) throws DOMException {
        return DOMNodeHelper.substringData(this, i, i2);
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String str) throws DOMException {
        DOMNodeHelper.appendData(this, str);
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int i, String str) throws DOMException {
        DOMNodeHelper.insertData(this, i, str);
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int i, int i2) throws DOMException {
        DOMNodeHelper.deleteData(this, i, i2);
    }

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int i, int i2, String str) throws DOMException {
        DOMNodeHelper.replaceData(this, i, i2, str);
    }

    @Override // org.w3c.dom.Text
    public Text splitText(int i) throws DOMException {
        if (isReadOnly()) {
            throw new DOMException((short) 7, new StringBuffer().append("CharacterData node is read only: ").append(this).toString());
        }
        String text = getText();
        int length = text != null ? text.length() : 0;
        if (i < 0 || i >= length) {
            throw new DOMException((short) 1, new StringBuffer().append("No text at offset: ").append(i).toString());
        }
        String substring = text.substring(0, i);
        String substring2 = text.substring(i);
        setText(substring);
        Element parent = getParent();
        org.dom4j.Text createText = createText(substring2);
        if (parent != null) {
            parent.add(createText);
        }
        return DOMNodeHelper.asDOMText(createText);
    }

    protected org.dom4j.Text createText(String str) {
        return new DOMText(str);
    }
}

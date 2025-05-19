package org.dom4j.dom;

import org.dom4j.Element;
import org.dom4j.tree.DefaultComment;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class DOMComment extends DefaultComment implements Comment {
    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return "#comment";
    }

    public DOMComment(String str) {
        super(str);
    }

    public DOMComment(Element element, String str) {
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
        throw new DOMException((short) 3, "Comment nodes cannot have children");
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
}

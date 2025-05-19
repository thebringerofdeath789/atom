package org.dom4j.dom;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.List;
import org.dom4j.Branch;
import org.dom4j.CharacterData;
import org.dom4j.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public class DOMNodeHelper {
    public static final NodeList EMPTY_NODE_LIST = new EmptyNodeList();

    public static class EmptyNodeList implements NodeList {
        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i) {
            return null;
        }
    }

    public static NamedNodeMap getAttributes(org.dom4j.Node node) {
        return null;
    }

    public static Node getFirstChild(org.dom4j.Node node) {
        return null;
    }

    public static Node getLastChild(org.dom4j.Node node) {
        return null;
    }

    public static String getLocalName(org.dom4j.Node node) {
        return null;
    }

    public static String getNamespaceURI(org.dom4j.Node node) {
        return null;
    }

    public static String getPrefix(org.dom4j.Node node) {
        return null;
    }

    public static boolean hasChildNodes(org.dom4j.Node node) {
        return false;
    }

    public static boolean isSupported(org.dom4j.Node node, String str, String str2) {
        return false;
    }

    public static boolean supports(org.dom4j.Node node, String str, String str2) {
        return false;
    }

    protected DOMNodeHelper() {
    }

    public static void setPrefix(org.dom4j.Node node, String str) throws DOMException {
        notSupported();
    }

    public static String getNodeValue(org.dom4j.Node node) throws DOMException {
        return node.getText();
    }

    public static void setNodeValue(org.dom4j.Node node, String str) throws DOMException {
        node.setText(str);
    }

    public static Node getParentNode(org.dom4j.Node node) {
        return asDOMNode(node.getParent());
    }

    public static NodeList getChildNodes(org.dom4j.Node node) {
        return EMPTY_NODE_LIST;
    }

    public static Node getPreviousSibling(org.dom4j.Node node) {
        int indexOf;
        Element parent = node.getParent();
        if (parent == null || (indexOf = parent.indexOf(node)) <= 0) {
            return null;
        }
        return asDOMNode(parent.node(indexOf - 1));
    }

    public static Node getNextSibling(org.dom4j.Node node) {
        int indexOf;
        int i;
        Element parent = node.getParent();
        if (parent == null || (indexOf = parent.indexOf(node)) < 0 || (i = indexOf + 1) >= parent.nodeCount()) {
            return null;
        }
        return asDOMNode(parent.node(i));
    }

    public static Document getOwnerDocument(org.dom4j.Node node) {
        return asDOMDocument(node.getDocument());
    }

    public static Node insertBefore(org.dom4j.Node node, Node node2, Node node3) throws DOMException {
        if (node instanceof Branch) {
            Branch branch = (Branch) node;
            List content = branch.content();
            int indexOf = content.indexOf(node3);
            if (indexOf < 0) {
                branch.add((org.dom4j.Node) node2);
            } else {
                content.add(indexOf, node2);
            }
            return node2;
        }
        throw new DOMException((short) 3, new StringBuffer().append("Children not allowed for this node: ").append(node).toString());
    }

    public static Node replaceChild(org.dom4j.Node node, Node node2, Node node3) throws DOMException {
        if (node instanceof Branch) {
            List content = ((Branch) node).content();
            int indexOf = content.indexOf(node3);
            if (indexOf < 0) {
                throw new DOMException((short) 8, new StringBuffer().append("Tried to replace a non existing child for node: ").append(node).toString());
            }
            content.set(indexOf, node2);
            return node3;
        }
        throw new DOMException((short) 3, new StringBuffer().append("Children not allowed for this node: ").append(node).toString());
    }

    public static Node removeChild(org.dom4j.Node node, Node node2) throws DOMException {
        if (node instanceof Branch) {
            ((Branch) node).remove((org.dom4j.Node) node2);
            return node2;
        }
        throw new DOMException((short) 3, new StringBuffer().append("Children not allowed for this node: ").append(node).toString());
    }

    public static Node appendChild(org.dom4j.Node node, Node node2) throws DOMException {
        if (node instanceof Branch) {
            Branch branch = (Branch) node;
            Node parentNode = node2.getParentNode();
            if (parentNode != null) {
                parentNode.removeChild(node2);
            }
            branch.add((org.dom4j.Node) node2);
            return node2;
        }
        throw new DOMException((short) 3, new StringBuffer().append("Children not allowed for this node: ").append(node).toString());
    }

    public static Node cloneNode(org.dom4j.Node node, boolean z) {
        return asDOMNode((org.dom4j.Node) node.clone());
    }

    public static void normalize(org.dom4j.Node node) {
        notSupported();
    }

    public static boolean hasAttributes(org.dom4j.Node node) {
        return node != null && (node instanceof Element) && ((Element) node).attributeCount() > 0;
    }

    public static String getData(CharacterData characterData) throws DOMException {
        return characterData.getText();
    }

    public static void setData(CharacterData characterData, String str) throws DOMException {
        characterData.setText(str);
    }

    public static int getLength(CharacterData characterData) {
        String text = characterData.getText();
        if (text != null) {
            return text.length();
        }
        return 0;
    }

    public static String substringData(CharacterData characterData, int i, int i2) throws DOMException {
        if (i2 < 0) {
            throw new DOMException((short) 1, new StringBuffer().append("Illegal value for count: ").append(i2).toString());
        }
        String text = characterData.getText();
        int length = text != null ? text.length() : 0;
        if (i < 0 || i >= length) {
            throw new DOMException((short) 1, new StringBuffer().append("No text at offset: ").append(i).toString());
        }
        int i3 = i2 + i;
        if (i3 > length) {
            return text.substring(i);
        }
        return text.substring(i, i3);
    }

    public static void appendData(CharacterData characterData, String str) throws DOMException {
        if (characterData.isReadOnly()) {
            throw new DOMException((short) 7, new StringBuffer().append("CharacterData node is read only: ").append(characterData).toString());
        }
        String text = characterData.getText();
        if (text == null) {
            characterData.setText(text);
        } else {
            characterData.setText(new StringBuffer().append(text).append(str).toString());
        }
    }

    public static void insertData(CharacterData characterData, int i, String str) throws DOMException {
        if (characterData.isReadOnly()) {
            throw new DOMException((short) 7, new StringBuffer().append("CharacterData node is read only: ").append(characterData).toString());
        }
        String text = characterData.getText();
        if (text == null) {
            characterData.setText(str);
            return;
        }
        int length = text.length();
        if (i < 0 || i > length) {
            throw new DOMException((short) 1, new StringBuffer().append("No text at offset: ").append(i).toString());
        }
        StringBuffer stringBuffer = new StringBuffer(text);
        stringBuffer.insert(i, str);
        characterData.setText(stringBuffer.toString());
    }

    public static void deleteData(CharacterData characterData, int i, int i2) throws DOMException {
        if (characterData.isReadOnly()) {
            throw new DOMException((short) 7, new StringBuffer().append("CharacterData node is read only: ").append(characterData).toString());
        }
        if (i2 < 0) {
            throw new DOMException((short) 1, new StringBuffer().append("Illegal value for count: ").append(i2).toString());
        }
        String text = characterData.getText();
        if (text != null) {
            int length = text.length();
            if (i < 0 || i >= length) {
                throw new DOMException((short) 1, new StringBuffer().append("No text at offset: ").append(i).toString());
            }
            StringBuffer stringBuffer = new StringBuffer(text);
            stringBuffer.delete(i, i2 + i);
            characterData.setText(stringBuffer.toString());
        }
    }

    public static void replaceData(CharacterData characterData, int i, int i2, String str) throws DOMException {
        if (characterData.isReadOnly()) {
            throw new DOMException((short) 7, new StringBuffer().append("CharacterData node is read only: ").append(characterData).toString());
        }
        if (i2 < 0) {
            throw new DOMException((short) 1, new StringBuffer().append("Illegal value for count: ").append(i2).toString());
        }
        String text = characterData.getText();
        if (text != null) {
            int length = text.length();
            if (i < 0 || i >= length) {
                throw new DOMException((short) 1, new StringBuffer().append("No text at offset: ").append(i).toString());
            }
            StringBuffer stringBuffer = new StringBuffer(text);
            stringBuffer.replace(i, i2 + i, str);
            characterData.setText(stringBuffer.toString());
        }
    }

    public static void appendElementsByTagName(List list, Branch branch, String str) {
        boolean equals = WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD.equals(str);
        int nodeCount = branch.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            org.dom4j.Node node = branch.node(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                if (equals || str.equals(element.getName())) {
                    list.add(element);
                }
                appendElementsByTagName(list, element, str);
            }
        }
    }

    public static void appendElementsByTagNameNS(List list, Branch branch, String str, String str2) {
        boolean equals = WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD.equals(str);
        boolean equals2 = WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD.equals(str2);
        int nodeCount = branch.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            org.dom4j.Node node = branch.node(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                if ((equals || (((str == null || str.length() == 0) && (element.getNamespaceURI() == null || element.getNamespaceURI().length() == 0)) || (str != null && str.equals(element.getNamespaceURI())))) && (equals2 || str2.equals(element.getName()))) {
                    list.add(element);
                }
                appendElementsByTagNameNS(list, element, str, str2);
            }
        }
    }

    public static NodeList createNodeList(final List list) {
        return new NodeList() { // from class: org.dom4j.dom.DOMNodeHelper.1
            @Override // org.w3c.dom.NodeList
            public Node item(int i) {
                if (i >= getLength()) {
                    return null;
                }
                return DOMNodeHelper.asDOMNode((org.dom4j.Node) list.get(i));
            }

            @Override // org.w3c.dom.NodeList
            public int getLength() {
                return list.size();
            }
        };
    }

    public static Node asDOMNode(org.dom4j.Node node) {
        if (node == null) {
            return null;
        }
        if (node instanceof Node) {
            return (Node) node;
        }
        System.out.println(new StringBuffer().append("Cannot convert: ").append(node).append(" into a W3C DOM Node").toString());
        notSupported();
        return null;
    }

    public static Document asDOMDocument(org.dom4j.Document document) {
        if (document == null) {
            return null;
        }
        if (document instanceof Document) {
            return (Document) document;
        }
        notSupported();
        return null;
    }

    public static DocumentType asDOMDocumentType(org.dom4j.DocumentType documentType) {
        if (documentType == null) {
            return null;
        }
        if (documentType instanceof DocumentType) {
            return (DocumentType) documentType;
        }
        notSupported();
        return null;
    }

    public static Text asDOMText(CharacterData characterData) {
        if (characterData == null) {
            return null;
        }
        if (characterData instanceof Text) {
            return (Text) characterData;
        }
        notSupported();
        return null;
    }

    public static org.w3c.dom.Element asDOMElement(org.dom4j.Node node) {
        if (node == null) {
            return null;
        }
        if (node instanceof org.w3c.dom.Element) {
            return (org.w3c.dom.Element) node;
        }
        notSupported();
        return null;
    }

    public static Attr asDOMAttr(org.dom4j.Node node) {
        if (node == null) {
            return null;
        }
        if (node instanceof Attr) {
            return (Attr) node;
        }
        notSupported();
        return null;
    }

    public static void notSupported() {
        throw new DOMException((short) 9, "Not supported yet");
    }
}

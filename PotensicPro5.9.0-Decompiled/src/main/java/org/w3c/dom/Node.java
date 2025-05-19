package org.w3c.dom;

/* loaded from: classes6.dex */
public interface Node {
    public static final short ATTRIBUTE_NODE = 2;
    public static final short CDATA_SECTION_NODE = 4;
    public static final short COMMENT_NODE = 8;
    public static final short DOCUMENT_FRAGMENT_NODE = 11;
    public static final short DOCUMENT_NODE = 9;
    public static final short DOCUMENT_TYPE_NODE = 10;
    public static final short ELEMENT_NODE = 1;
    public static final short ENTITY_NODE = 6;
    public static final short ENTITY_REFERENCE_NODE = 5;
    public static final short NOTATION_NODE = 12;
    public static final short PROCESSING_INSTRUCTION_NODE = 7;
    public static final short TEXT_NODE = 3;

    Node appendChild(Node node) throws DOMException;

    Node cloneNode(boolean z);

    NamedNodeMap getAttributes();

    NodeList getChildNodes();

    Node getFirstChild();

    Node getLastChild();

    String getLocalName();

    String getNamespaceURI();

    Node getNextSibling();

    String getNodeName();

    short getNodeType();

    String getNodeValue() throws DOMException;

    Document getOwnerDocument();

    Node getParentNode();

    String getPrefix();

    Node getPreviousSibling();

    boolean hasAttributes();

    boolean hasChildNodes();

    Node insertBefore(Node node, Node node2) throws DOMException;

    boolean isSupported(String str, String str2);

    void normalize();

    Node removeChild(Node node) throws DOMException;

    Node replaceChild(Node node, Node node2) throws DOMException;

    void setNodeValue(String str) throws DOMException;

    void setPrefix(String str) throws DOMException;
}

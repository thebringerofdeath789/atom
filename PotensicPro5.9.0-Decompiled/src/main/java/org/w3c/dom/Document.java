package org.w3c.dom;

/* loaded from: classes6.dex */
public interface Document extends Node {
    Attr createAttribute(String str) throws DOMException;

    Attr createAttributeNS(String str, String str2) throws DOMException;

    CDATASection createCDATASection(String str) throws DOMException;

    Comment createComment(String str);

    DocumentFragment createDocumentFragment();

    Element createElement(String str) throws DOMException;

    Element createElementNS(String str, String str2) throws DOMException;

    EntityReference createEntityReference(String str) throws DOMException;

    ProcessingInstruction createProcessingInstruction(String str, String str2) throws DOMException;

    Text createTextNode(String str);

    DocumentType getDoctype();

    Element getDocumentElement();

    Element getElementById(String str);

    NodeList getElementsByTagName(String str);

    NodeList getElementsByTagNameNS(String str, String str2);

    DOMImplementation getImplementation();

    Node importNode(Node node, boolean z) throws DOMException;
}

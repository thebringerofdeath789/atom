package org.w3c.dom;

/* loaded from: classes6.dex */
public interface Element extends Node {
    String getAttribute(String str);

    String getAttributeNS(String str, String str2);

    Attr getAttributeNode(String str);

    Attr getAttributeNodeNS(String str, String str2);

    NodeList getElementsByTagName(String str);

    NodeList getElementsByTagNameNS(String str, String str2);

    String getTagName();

    boolean hasAttribute(String str);

    boolean hasAttributeNS(String str, String str2);

    void removeAttribute(String str) throws DOMException;

    void removeAttributeNS(String str, String str2) throws DOMException;

    Attr removeAttributeNode(Attr attr) throws DOMException;

    void setAttribute(String str, String str2) throws DOMException;

    void setAttributeNS(String str, String str2, String str3) throws DOMException;

    Attr setAttributeNode(Attr attr) throws DOMException;

    Attr setAttributeNodeNS(Attr attr) throws DOMException;
}

package org.apache.xmlbeans.impl.soap;

/* loaded from: classes5.dex */
public interface Node extends org.w3c.dom.Node {
    void detachNode();

    SOAPElement getParentElement();

    String getValue();

    void recycleNode();

    void setParentElement(SOAPElement sOAPElement) throws SOAPException;

    void setValue(String str);
}

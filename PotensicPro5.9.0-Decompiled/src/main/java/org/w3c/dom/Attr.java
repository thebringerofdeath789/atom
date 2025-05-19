package org.w3c.dom;

/* loaded from: classes6.dex */
public interface Attr extends Node {
    String getName();

    Element getOwnerElement();

    boolean getSpecified();

    String getValue();

    void setValue(String str) throws DOMException;
}

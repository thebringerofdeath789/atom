package org.w3c.dom;

/* loaded from: classes6.dex */
public interface DocumentType extends Node {
    NamedNodeMap getEntities();

    String getInternalSubset();

    String getName();

    NamedNodeMap getNotations();

    String getPublicId();

    String getSystemId();
}

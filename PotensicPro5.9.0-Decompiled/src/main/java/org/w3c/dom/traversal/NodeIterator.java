package org.w3c.dom.traversal;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface NodeIterator {
    void detach();

    boolean getExpandEntityReferences();

    NodeFilter getFilter();

    Node getRoot();

    int getWhatToShow();

    Node nextNode() throws DOMException;

    Node previousNode() throws DOMException;
}

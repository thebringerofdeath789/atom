package org.w3c.dom.traversal;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface TreeWalker {
    Node firstChild();

    Node getCurrentNode();

    boolean getExpandEntityReferences();

    NodeFilter getFilter();

    Node getRoot();

    int getWhatToShow();

    Node lastChild();

    Node nextNode();

    Node nextSibling();

    Node parentNode();

    Node previousNode();

    Node previousSibling();

    void setCurrentNode(Node node) throws DOMException;
}

package org.w3c.dom.traversal;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface DocumentTraversal {
    NodeIterator createNodeIterator(Node node, int i, NodeFilter nodeFilter, boolean z) throws DOMException;

    TreeWalker createTreeWalker(Node node, int i, NodeFilter nodeFilter, boolean z) throws DOMException;
}

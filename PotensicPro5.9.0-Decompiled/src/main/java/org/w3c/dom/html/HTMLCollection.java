package org.w3c.dom.html;

import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public interface HTMLCollection {
    int getLength();

    Node item(int i);

    Node namedItem(String str);
}

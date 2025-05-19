package org.dom4j.tree;

import java.util.Iterator;
import org.dom4j.Element;

/* loaded from: classes5.dex */
public class ElementIterator extends FilterIterator {
    public ElementIterator(Iterator it) {
        super(it);
    }

    @Override // org.dom4j.tree.FilterIterator
    protected boolean matches(Object obj) {
        return obj instanceof Element;
    }
}

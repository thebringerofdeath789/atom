package org.dom4j.tree;

import java.util.Iterator;
import org.dom4j.Element;

/* loaded from: classes5.dex */
public class ElementNameIterator extends FilterIterator {
    private String name;

    public ElementNameIterator(Iterator it, String str) {
        super(it);
        this.name = str;
    }

    @Override // org.dom4j.tree.FilterIterator
    protected boolean matches(Object obj) {
        if (obj instanceof Element) {
            return this.name.equals(((Element) obj).getName());
        }
        return false;
    }
}

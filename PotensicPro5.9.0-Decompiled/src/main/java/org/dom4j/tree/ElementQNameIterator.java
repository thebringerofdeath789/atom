package org.dom4j.tree;

import java.util.Iterator;
import org.dom4j.Element;
import org.dom4j.QName;

/* loaded from: classes5.dex */
public class ElementQNameIterator extends FilterIterator {
    private QName qName;

    public ElementQNameIterator(Iterator it, QName qName) {
        super(it);
        this.qName = qName;
    }

    @Override // org.dom4j.tree.FilterIterator
    protected boolean matches(Object obj) {
        if (obj instanceof Element) {
            return this.qName.equals(((Element) obj).getQName());
        }
        return false;
    }
}

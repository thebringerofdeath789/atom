package org.dom4j.tree;

import org.dom4j.CDATA;
import org.dom4j.Element;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class FlyweightCDATA extends AbstractCDATA implements CDATA {
    protected String text;

    public FlyweightCDATA(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }

    @Override // org.dom4j.tree.AbstractNode
    protected Node createXPathResult(Element element) {
        return new DefaultCDATA(element, getText());
    }
}

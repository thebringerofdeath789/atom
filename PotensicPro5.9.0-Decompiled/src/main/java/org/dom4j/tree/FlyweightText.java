package org.dom4j.tree;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;

/* loaded from: classes5.dex */
public class FlyweightText extends AbstractText implements Text {
    protected String text;

    public FlyweightText(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }

    @Override // org.dom4j.tree.AbstractNode
    protected Node createXPathResult(Element element) {
        return new DefaultText(element, getText());
    }
}

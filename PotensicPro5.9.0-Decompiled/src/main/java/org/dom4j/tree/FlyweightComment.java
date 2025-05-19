package org.dom4j.tree;

import org.dom4j.Comment;
import org.dom4j.Element;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class FlyweightComment extends AbstractComment implements Comment {
    protected String text;

    public FlyweightComment(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }

    @Override // org.dom4j.tree.AbstractNode
    protected Node createXPathResult(Element element) {
        return new DefaultComment(element, getText());
    }
}

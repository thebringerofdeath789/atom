package org.dom4j.tree;

import org.dom4j.Element;

/* loaded from: classes5.dex */
public class DefaultComment extends FlyweightComment {
    private Element parent;

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }

    public DefaultComment(String str) {
        super(str);
    }

    public DefaultComment(Element element, String str) {
        super(str);
        this.parent = element;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setText(String str) {
        this.text = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Element getParent() {
        return this.parent;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setParent(Element element) {
        this.parent = element;
    }
}

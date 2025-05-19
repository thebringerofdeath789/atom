package org.dom4j.tree;

import org.dom4j.Element;

/* loaded from: classes5.dex */
public class DefaultEntity extends FlyweightEntity {
    private Element parent;

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }

    public DefaultEntity(String str) {
        super(str);
    }

    public DefaultEntity(String str, String str2) {
        super(str, str2);
    }

    public DefaultEntity(Element element, String str, String str2) {
        super(str, str2);
        this.parent = element;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setName(String str) {
        this.name = str;
    }

    @Override // org.dom4j.tree.FlyweightEntity, org.dom4j.tree.AbstractNode, org.dom4j.Node
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

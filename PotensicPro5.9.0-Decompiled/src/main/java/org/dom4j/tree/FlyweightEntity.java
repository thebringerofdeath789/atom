package org.dom4j.tree;

import org.dom4j.Element;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class FlyweightEntity extends AbstractEntity {
    protected String name;
    protected String text;

    protected FlyweightEntity() {
    }

    public FlyweightEntity(String str) {
        this.name = str;
    }

    public FlyweightEntity(String str, String str2) {
        this.name = str;
        this.text = str2;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return this.name;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setText(String str) {
        if (this.text != null) {
            this.text = str;
            return;
        }
        throw new UnsupportedOperationException("This Entity is read-only. It cannot be modified");
    }

    @Override // org.dom4j.tree.AbstractNode
    protected Node createXPathResult(Element element) {
        return new DefaultEntity(element, getName(), getText());
    }
}

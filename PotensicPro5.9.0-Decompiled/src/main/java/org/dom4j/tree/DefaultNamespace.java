package org.dom4j.tree;

import org.dom4j.Element;
import org.dom4j.Namespace;

/* loaded from: classes5.dex */
public class DefaultNamespace extends Namespace {
    private Element parent;

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }

    public DefaultNamespace(String str, String str2) {
        super(str, str2);
    }

    public DefaultNamespace(Element element, String str, String str2) {
        super(str, str2);
        this.parent = element;
    }

    @Override // org.dom4j.Namespace
    protected int createHashCode() {
        int createHashCode = super.createHashCode();
        Element element = this.parent;
        return element != null ? createHashCode ^ element.hashCode() : createHashCode;
    }

    @Override // org.dom4j.Namespace
    public boolean equals(Object obj) {
        if ((obj instanceof DefaultNamespace) && ((DefaultNamespace) obj).parent == this.parent) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // org.dom4j.Namespace
    public int hashCode() {
        return super.hashCode();
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

package org.jdom;

import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class Content implements Cloneable, Serializable {
    protected Parent parent = null;

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public abstract String getValue();

    protected Content() {
    }

    public Content detach() {
        Parent parent = this.parent;
        if (parent != null) {
            parent.removeContent(this);
        }
        return this;
    }

    public Parent getParent() {
        return this.parent;
    }

    public Element getParentElement() {
        Parent parent = getParent();
        if (!(parent instanceof Element)) {
            parent = null;
        }
        return (Element) parent;
    }

    protected Content setParent(Parent parent) {
        this.parent = parent;
        return this;
    }

    public Document getDocument() {
        Parent parent = this.parent;
        if (parent == null) {
            return null;
        }
        return parent.getDocument();
    }

    public Object clone() {
        try {
            Content content = (Content) super.clone();
            content.parent = null;
            return content;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }
}

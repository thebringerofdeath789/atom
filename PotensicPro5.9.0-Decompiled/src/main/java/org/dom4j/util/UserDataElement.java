package org.dom4j.util;

import org.dom4j.Element;
import org.dom4j.QName;
import org.dom4j.tree.DefaultElement;

/* loaded from: classes5.dex */
public class UserDataElement extends DefaultElement {
    private Object data;

    public UserDataElement(String str) {
        super(str);
    }

    public UserDataElement(QName qName) {
        super(qName);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Object getData() {
        return this.data;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public void setData(Object obj) {
        this.data = obj;
    }

    @Override // org.dom4j.tree.AbstractElement
    public String toString() {
        return new StringBuffer().append(super.toString()).append(" userData: ").append(this.data).toString();
    }

    @Override // org.dom4j.tree.DefaultElement, org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Object clone() {
        UserDataElement userDataElement = (UserDataElement) super.clone();
        if (userDataElement != this) {
            userDataElement.data = getCopyOfUserData();
        }
        return userDataElement;
    }

    protected Object getCopyOfUserData() {
        return this.data;
    }

    @Override // org.dom4j.tree.AbstractElement
    protected Element createElement(String str) {
        Element createElement = getDocumentFactory().createElement(str);
        createElement.setData(getCopyOfUserData());
        return createElement;
    }

    @Override // org.dom4j.tree.AbstractElement
    protected Element createElement(QName qName) {
        Element createElement = getDocumentFactory().createElement(qName);
        createElement.setData(getCopyOfUserData());
        return createElement;
    }
}

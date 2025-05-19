package org.dom4j.util;

import org.dom4j.QName;
import org.dom4j.tree.DefaultAttribute;

/* loaded from: classes5.dex */
public class UserDataAttribute extends DefaultAttribute {
    private Object data;

    public UserDataAttribute(QName qName) {
        super(qName);
    }

    public UserDataAttribute(QName qName, String str) {
        super(qName, str);
    }

    @Override // org.dom4j.tree.AbstractAttribute, org.dom4j.Attribute
    public Object getData() {
        return this.data;
    }

    @Override // org.dom4j.tree.AbstractAttribute, org.dom4j.Attribute
    public void setData(Object obj) {
        this.data = obj;
    }
}

package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.Code;

/* loaded from: classes5.dex */
public class CodeImpl extends XmlComplexContentImpl implements Code {
    private static final QName ID$0 = new QName("", "ID");

    public CodeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public String getID() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public XmlToken xgetID() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(ID$0);
        }
        return xmlToken;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public boolean isSetID() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public void setID(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public void xsetID(XmlToken xmlToken) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
            if (xmlToken2 == null) {
                xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
            }
            xmlToken2.set(xmlToken);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.Code
    public void unsetID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }
}

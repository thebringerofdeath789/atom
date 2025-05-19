package org.apache.xmlbeans.impl.xb.xmlschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;

/* loaded from: classes5.dex */
public class LangAttributeImpl extends XmlComplexContentImpl implements LangAttribute {
    private static final QName LANG$0 = new QName("http://www.w3.org/XML/1998/namespace", "lang");

    public LangAttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public String getLang() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LANG$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public XmlLanguage xgetLang() {
        XmlLanguage xmlLanguage;
        synchronized (monitor()) {
            check_orphaned();
            xmlLanguage = (XmlLanguage) get_store().find_attribute_user(LANG$0);
        }
        return xmlLanguage;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public boolean isSetLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LANG$0) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void setLang(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void xsetLang(XmlLanguage xmlLanguage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LANG$0;
            XmlLanguage xmlLanguage2 = (XmlLanguage) typeStore.find_attribute_user(qName);
            if (xmlLanguage2 == null) {
                xmlLanguage2 = (XmlLanguage) get_store().add_attribute_user(qName);
            }
            xmlLanguage2.set(xmlLanguage);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void unsetLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LANG$0);
        }
    }
}

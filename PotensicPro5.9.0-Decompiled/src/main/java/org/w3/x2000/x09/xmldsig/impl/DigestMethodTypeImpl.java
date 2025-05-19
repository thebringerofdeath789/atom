package org.w3.x2000.x09.xmldsig.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.DigestMethodType;

/* loaded from: classes6.dex */
public class DigestMethodTypeImpl extends XmlComplexContentImpl implements DigestMethodType {
    private static final QName ALGORITHM$0 = new QName("", "Algorithm");

    public DigestMethodTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.DigestMethodType
    public String getAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALGORITHM$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.DigestMethodType
    public void setAlgorithm(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGORITHM$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.DigestMethodType
    public XmlAnyURI xgetAlgorithm() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(ALGORITHM$0);
        }
        return xmlAnyURI;
    }

    @Override // org.w3.x2000.x09.xmldsig.DigestMethodType
    public void xsetAlgorithm(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGORITHM$0;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}

package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;

/* loaded from: classes5.dex */
public class KeyrefDocumentImpl extends XmlComplexContentImpl implements KeyrefDocument {
    private static final QName KEYREF$0 = new QName("http://www.w3.org/2001/XMLSchema", "keyref");

    public KeyrefDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public KeyrefDocument.Keyref getKeyref() {
        synchronized (monitor()) {
            check_orphaned();
            KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref) get_store().find_element_user(KEYREF$0, 0);
            if (keyref == null) {
                return null;
            }
            return keyref;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public void setKeyref(KeyrefDocument.Keyref keyref) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYREF$0;
            KeyrefDocument.Keyref keyref2 = (KeyrefDocument.Keyref) typeStore.find_element_user(qName, 0);
            if (keyref2 == null) {
                keyref2 = (KeyrefDocument.Keyref) get_store().add_element_user(qName);
            }
            keyref2.set(keyref);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument
    public KeyrefDocument.Keyref addNewKeyref() {
        KeyrefDocument.Keyref keyref;
        synchronized (monitor()) {
            check_orphaned();
            keyref = (KeyrefDocument.Keyref) get_store().add_element_user(KEYREF$0);
        }
        return keyref;
    }

    public static class KeyrefImpl extends KeybaseImpl implements KeyrefDocument.Keyref {
        private static final QName REFER$0 = new QName("", "refer");

        public KeyrefImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public QName getRefer() {
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REFER$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getQNameValue();
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public XmlQName xgetRefer() {
            XmlQName xmlQName;
            synchronized (monitor()) {
                check_orphaned();
                xmlQName = (XmlQName) get_store().find_attribute_user(REFER$0);
            }
            return xmlQName;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public void setRefer(QName qName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName2 = REFER$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName2);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName2);
                }
                simpleValue.setQNameValue(qName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument.Keyref
        public void xsetRefer(XmlQName xmlQName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REFER$0;
                XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qName);
                if (xmlQName2 == null) {
                    xmlQName2 = (XmlQName) get_store().add_attribute_user(qName);
                }
                xmlQName2.set(xmlQName);
            }
        }
    }
}

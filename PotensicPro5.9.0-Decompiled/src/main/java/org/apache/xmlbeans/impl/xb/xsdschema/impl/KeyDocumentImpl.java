package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;

/* loaded from: classes5.dex */
public class KeyDocumentImpl extends XmlComplexContentImpl implements KeyDocument {
    private static final QName KEY$0 = new QName("http://www.w3.org/2001/XMLSchema", "key");

    public KeyDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public Keybase getKey() {
        synchronized (monitor()) {
            check_orphaned();
            Keybase keybase = (Keybase) get_store().find_element_user(KEY$0, 0);
            if (keybase == null) {
                return null;
            }
            return keybase;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public void setKey(Keybase keybase) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEY$0;
            Keybase keybase2 = (Keybase) typeStore.find_element_user(qName, 0);
            if (keybase2 == null) {
                keybase2 = (Keybase) get_store().add_element_user(qName);
            }
            keybase2.set(keybase);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument
    public Keybase addNewKey() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(KEY$0);
        }
        return keybase;
    }
}

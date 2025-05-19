package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument;

/* loaded from: classes5.dex */
public class UniqueDocumentImpl extends XmlComplexContentImpl implements UniqueDocument {
    private static final QName UNIQUE$0 = new QName("http://www.w3.org/2001/XMLSchema", "unique");

    public UniqueDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public Keybase getUnique() {
        synchronized (monitor()) {
            check_orphaned();
            Keybase keybase = (Keybase) get_store().find_element_user(UNIQUE$0, 0);
            if (keybase == null) {
                return null;
            }
            return keybase;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public void setUnique(Keybase keybase) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNIQUE$0;
            Keybase keybase2 = (Keybase) typeStore.find_element_user(qName, 0);
            if (keybase2 == null) {
                keybase2 = (Keybase) get_store().add_element_user(qName);
            }
            keybase2.set(keybase);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UniqueDocument
    public Keybase addNewUnique() {
        Keybase keybase;
        synchronized (monitor()) {
            check_orphaned();
            keybase = (Keybase) get_store().add_element_user(UNIQUE$0);
        }
        return keybase;
    }
}

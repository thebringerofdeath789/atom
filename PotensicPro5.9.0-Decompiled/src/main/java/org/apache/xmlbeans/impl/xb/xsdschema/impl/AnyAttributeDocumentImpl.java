package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes5.dex */
public class AnyAttributeDocumentImpl extends XmlComplexContentImpl implements AnyAttributeDocument {
    private static final QName ANYATTRIBUTE$0 = new QName("http://www.w3.org/2001/XMLSchema", "anyAttribute");

    public AnyAttributeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument
    public Wildcard getAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            Wildcard wildcard = (Wildcard) get_store().find_element_user(ANYATTRIBUTE$0, 0);
            if (wildcard == null) {
                return null;
            }
            return wildcard;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument
    public void setAnyAttribute(Wildcard wildcard) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ANYATTRIBUTE$0;
            Wildcard wildcard2 = (Wildcard) typeStore.find_element_user(qName, 0);
            if (wildcard2 == null) {
                wildcard2 = (Wildcard) get_store().add_element_user(qName);
            }
            wildcard2.set(wildcard);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(ANYATTRIBUTE$0);
        }
        return wildcard;
    }
}

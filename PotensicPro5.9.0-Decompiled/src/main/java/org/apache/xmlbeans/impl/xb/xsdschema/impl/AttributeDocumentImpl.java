package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;

/* loaded from: classes5.dex */
public class AttributeDocumentImpl extends XmlComplexContentImpl implements AttributeDocument {
    private static final QName ATTRIBUTE$0 = new QName("http://www.w3.org/2001/XMLSchema", "attribute");

    public AttributeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument
    public TopLevelAttribute getAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelAttribute topLevelAttribute = (TopLevelAttribute) get_store().find_element_user(ATTRIBUTE$0, 0);
            if (topLevelAttribute == null) {
                return null;
            }
            return topLevelAttribute;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument
    public void setAttribute(TopLevelAttribute topLevelAttribute) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ATTRIBUTE$0;
            TopLevelAttribute topLevelAttribute2 = (TopLevelAttribute) typeStore.find_element_user(qName, 0);
            if (topLevelAttribute2 == null) {
                topLevelAttribute2 = (TopLevelAttribute) get_store().add_element_user(qName);
            }
            topLevelAttribute2.set(topLevelAttribute);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument
    public TopLevelAttribute addNewAttribute() {
        TopLevelAttribute topLevelAttribute;
        synchronized (monitor()) {
            check_orphaned();
            topLevelAttribute = (TopLevelAttribute) get_store().add_element_user(ATTRIBUTE$0);
        }
        return topLevelAttribute;
    }
}

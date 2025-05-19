package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* loaded from: classes5.dex */
public class SimpleTypeDocumentImpl extends XmlComplexContentImpl implements SimpleTypeDocument {
    private static final QName SIMPLETYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "simpleType");

    public SimpleTypeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument
    public TopLevelSimpleType getSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelSimpleType topLevelSimpleType = (TopLevelSimpleType) get_store().find_element_user(SIMPLETYPE$0, 0);
            if (topLevelSimpleType == null) {
                return null;
            }
            return topLevelSimpleType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument
    public void setSimpleType(TopLevelSimpleType topLevelSimpleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIMPLETYPE$0;
            TopLevelSimpleType topLevelSimpleType2 = (TopLevelSimpleType) typeStore.find_element_user(qName, 0);
            if (topLevelSimpleType2 == null) {
                topLevelSimpleType2 = (TopLevelSimpleType) get_store().add_element_user(qName);
            }
            topLevelSimpleType2.set(topLevelSimpleType);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument
    public TopLevelSimpleType addNewSimpleType() {
        TopLevelSimpleType topLevelSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            topLevelSimpleType = (TopLevelSimpleType) get_store().add_element_user(SIMPLETYPE$0);
        }
        return topLevelSimpleType;
    }
}

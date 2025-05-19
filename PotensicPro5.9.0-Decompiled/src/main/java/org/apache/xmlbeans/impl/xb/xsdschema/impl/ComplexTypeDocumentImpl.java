package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;

/* loaded from: classes5.dex */
public class ComplexTypeDocumentImpl extends XmlComplexContentImpl implements ComplexTypeDocument {
    private static final QName COMPLEXTYPE$0 = new QName("http://www.w3.org/2001/XMLSchema", "complexType");

    public ComplexTypeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public TopLevelComplexType getComplexType() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelComplexType topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(COMPLEXTYPE$0, 0);
            if (topLevelComplexType == null) {
                return null;
            }
            return topLevelComplexType;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public void setComplexType(TopLevelComplexType topLevelComplexType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COMPLEXTYPE$0;
            TopLevelComplexType topLevelComplexType2 = (TopLevelComplexType) typeStore.find_element_user(qName, 0);
            if (topLevelComplexType2 == null) {
                topLevelComplexType2 = (TopLevelComplexType) get_store().add_element_user(qName);
            }
            topLevelComplexType2.set(topLevelComplexType);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public TopLevelComplexType addNewComplexType() {
        TopLevelComplexType topLevelComplexType;
        synchronized (monitor()) {
            check_orphaned();
            topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(COMPLEXTYPE$0);
        }
        return topLevelComplexType;
    }
}

package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;

/* loaded from: classes5.dex */
public class ElementDocumentImpl extends XmlComplexContentImpl implements ElementDocument {
    private static final QName ELEMENT$0 = new QName("http://www.w3.org/2001/XMLSchema", "element");

    public ElementDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public TopLevelElement getElement() {
        synchronized (monitor()) {
            check_orphaned();
            TopLevelElement topLevelElement = (TopLevelElement) get_store().find_element_user(ELEMENT$0, 0);
            if (topLevelElement == null) {
                return null;
            }
            return topLevelElement;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public void setElement(TopLevelElement topLevelElement) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ELEMENT$0;
            TopLevelElement topLevelElement2 = (TopLevelElement) typeStore.find_element_user(qName, 0);
            if (topLevelElement2 == null) {
                topLevelElement2 = (TopLevelElement) get_store().add_element_user(qName);
            }
            topLevelElement2.set(topLevelElement);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public TopLevelElement addNewElement() {
        TopLevelElement topLevelElement;
        synchronized (monitor()) {
            check_orphaned();
            topLevelElement = (TopLevelElement) get_store().add_element_user(ELEMENT$0);
        }
        return topLevelElement;
    }
}

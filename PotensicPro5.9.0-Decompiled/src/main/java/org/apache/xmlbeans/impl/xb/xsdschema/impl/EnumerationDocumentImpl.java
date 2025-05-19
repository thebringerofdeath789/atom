package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;

/* loaded from: classes5.dex */
public class EnumerationDocumentImpl extends XmlComplexContentImpl implements EnumerationDocument {
    private static final QName ENUMERATION$0 = new QName("http://www.w3.org/2001/XMLSchema", "enumeration");

    public EnumerationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument
    public NoFixedFacet getEnumeration() {
        synchronized (monitor()) {
            check_orphaned();
            NoFixedFacet noFixedFacet = (NoFixedFacet) get_store().find_element_user(ENUMERATION$0, 0);
            if (noFixedFacet == null) {
                return null;
            }
            return noFixedFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument
    public void setEnumeration(NoFixedFacet noFixedFacet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENUMERATION$0;
            NoFixedFacet noFixedFacet2 = (NoFixedFacet) typeStore.find_element_user(qName, 0);
            if (noFixedFacet2 == null) {
                noFixedFacet2 = (NoFixedFacet) get_store().add_element_user(qName);
            }
            noFixedFacet2.set(noFixedFacet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument
    public NoFixedFacet addNewEnumeration() {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().add_element_user(ENUMERATION$0);
        }
        return noFixedFacet;
    }
}

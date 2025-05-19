package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument;

/* loaded from: classes5.dex */
public class MaxExclusiveDocumentImpl extends XmlComplexContentImpl implements MaxExclusiveDocument {
    private static final QName MAXEXCLUSIVE$0 = new QName("http://www.w3.org/2001/XMLSchema", "maxExclusive");

    public MaxExclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public Facet getMaxExclusive() {
        synchronized (monitor()) {
            check_orphaned();
            Facet facet = (Facet) get_store().find_element_user(MAXEXCLUSIVE$0, 0);
            if (facet == null) {
                return null;
            }
            return facet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public void setMaxExclusive(Facet facet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXEXCLUSIVE$0;
            Facet facet2 = (Facet) typeStore.find_element_user(qName, 0);
            if (facet2 == null) {
                facet2 = (Facet) get_store().add_element_user(qName);
            }
            facet2.set(facet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public Facet addNewMaxExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MAXEXCLUSIVE$0);
        }
        return facet;
    }
}

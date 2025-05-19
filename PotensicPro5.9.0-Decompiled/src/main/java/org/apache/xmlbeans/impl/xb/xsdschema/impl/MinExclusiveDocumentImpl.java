package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument;

/* loaded from: classes5.dex */
public class MinExclusiveDocumentImpl extends XmlComplexContentImpl implements MinExclusiveDocument {
    private static final QName MINEXCLUSIVE$0 = new QName("http://www.w3.org/2001/XMLSchema", "minExclusive");

    public MinExclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument
    public Facet getMinExclusive() {
        synchronized (monitor()) {
            check_orphaned();
            Facet facet = (Facet) get_store().find_element_user(MINEXCLUSIVE$0, 0);
            if (facet == null) {
                return null;
            }
            return facet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument
    public void setMinExclusive(Facet facet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINEXCLUSIVE$0;
            Facet facet2 = (Facet) typeStore.find_element_user(qName, 0);
            if (facet2 == null) {
                facet2 = (Facet) get_store().add_element_user(qName);
            }
            facet2.set(facet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument
    public Facet addNewMinExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(MINEXCLUSIVE$0);
        }
        return facet;
    }
}

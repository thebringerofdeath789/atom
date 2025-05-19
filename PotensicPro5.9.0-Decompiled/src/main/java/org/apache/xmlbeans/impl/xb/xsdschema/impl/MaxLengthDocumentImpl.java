package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;

/* loaded from: classes5.dex */
public class MaxLengthDocumentImpl extends XmlComplexContentImpl implements MaxLengthDocument {
    private static final QName MAXLENGTH$0 = new QName("http://www.w3.org/2001/XMLSchema", "maxLength");

    public MaxLengthDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument
    public NumFacet getMaxLength() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(MAXLENGTH$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument
    public void setMaxLength(NumFacet numFacet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MAXLENGTH$0;
            NumFacet numFacet2 = (NumFacet) typeStore.find_element_user(qName, 0);
            if (numFacet2 == null) {
                numFacet2 = (NumFacet) get_store().add_element_user(qName);
            }
            numFacet2.set(numFacet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxLengthDocument
    public NumFacet addNewMaxLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(MAXLENGTH$0);
        }
        return numFacet;
    }
}

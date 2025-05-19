package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;

/* loaded from: classes5.dex */
public class MinLengthDocumentImpl extends XmlComplexContentImpl implements MinLengthDocument {
    private static final QName MINLENGTH$0 = new QName("http://www.w3.org/2001/XMLSchema", "minLength");

    public MinLengthDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument
    public NumFacet getMinLength() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(MINLENGTH$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument
    public void setMinLength(NumFacet numFacet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MINLENGTH$0;
            NumFacet numFacet2 = (NumFacet) typeStore.find_element_user(qName, 0);
            if (numFacet2 == null) {
                numFacet2 = (NumFacet) get_store().add_element_user(qName);
            }
            numFacet2.set(numFacet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument
    public NumFacet addNewMinLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(MINLENGTH$0);
        }
        return numFacet;
    }
}

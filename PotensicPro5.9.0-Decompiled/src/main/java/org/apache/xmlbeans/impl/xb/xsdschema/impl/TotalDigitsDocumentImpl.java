package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;

/* loaded from: classes5.dex */
public class TotalDigitsDocumentImpl extends XmlComplexContentImpl implements TotalDigitsDocument {
    private static final QName TOTALDIGITS$0 = new QName("http://www.w3.org/2001/XMLSchema", "totalDigits");

    public TotalDigitsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument
    public TotalDigitsDocument.TotalDigits getTotalDigits() {
        synchronized (monitor()) {
            check_orphaned();
            TotalDigitsDocument.TotalDigits totalDigits = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(TOTALDIGITS$0, 0);
            if (totalDigits == null) {
                return null;
            }
            return totalDigits;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument
    public void setTotalDigits(TotalDigitsDocument.TotalDigits totalDigits) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TOTALDIGITS$0;
            TotalDigitsDocument.TotalDigits totalDigits2 = (TotalDigitsDocument.TotalDigits) typeStore.find_element_user(qName, 0);
            if (totalDigits2 == null) {
                totalDigits2 = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(qName);
            }
            totalDigits2.set(totalDigits);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument
    public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(TOTALDIGITS$0);
        }
        return totalDigits;
    }

    public static class TotalDigitsImpl extends NumFacetImpl implements TotalDigitsDocument.TotalDigits {
        public TotalDigitsImpl(SchemaType schemaType) {
            super(schemaType);
        }
    }
}

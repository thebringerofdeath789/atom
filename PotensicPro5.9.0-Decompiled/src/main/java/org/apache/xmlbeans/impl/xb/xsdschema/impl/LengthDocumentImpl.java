package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;

/* loaded from: classes5.dex */
public class LengthDocumentImpl extends XmlComplexContentImpl implements LengthDocument {
    private static final QName LENGTH$0 = new QName("http://www.w3.org/2001/XMLSchema", SessionDescription.ATTR_LENGTH);

    public LengthDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument
    public NumFacet getLength() {
        synchronized (monitor()) {
            check_orphaned();
            NumFacet numFacet = (NumFacet) get_store().find_element_user(LENGTH$0, 0);
            if (numFacet == null) {
                return null;
            }
            return numFacet;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument
    public void setLength(NumFacet numFacet) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LENGTH$0;
            NumFacet numFacet2 = (NumFacet) typeStore.find_element_user(qName, 0);
            if (numFacet2 == null) {
                numFacet2 = (NumFacet) get_store().add_element_user(qName);
            }
            numFacet2.set(numFacet);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument
    public NumFacet addNewLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(LENGTH$0);
        }
        return numFacet;
    }
}

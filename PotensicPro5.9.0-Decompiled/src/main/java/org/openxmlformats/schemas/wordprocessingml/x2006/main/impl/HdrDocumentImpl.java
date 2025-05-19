package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

/* loaded from: classes6.dex */
public class HdrDocumentImpl extends XmlComplexContentImpl implements HdrDocument {
    private static final QName HDR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hdr");

    public HdrDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument
    public CTHdrFtr addNewHdr() {
        CTHdrFtr cTHdrFtr;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtr = (CTHdrFtr) get_store().add_element_user(HDR$0);
        }
        return cTHdrFtr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument
    public CTHdrFtr getHdr() {
        synchronized (monitor()) {
            check_orphaned();
            CTHdrFtr cTHdrFtr = (CTHdrFtr) get_store().find_element_user(HDR$0, 0);
            if (cTHdrFtr == null) {
                return null;
            }
            return cTHdrFtr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument
    public void setHdr(CTHdrFtr cTHdrFtr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HDR$0;
            CTHdrFtr cTHdrFtr2 = (CTHdrFtr) typeStore.find_element_user(qName, 0);
            if (cTHdrFtr2 == null) {
                cTHdrFtr2 = (CTHdrFtr) get_store().add_element_user(qName);
            }
            cTHdrFtr2.set(cTHdrFtr);
        }
    }
}

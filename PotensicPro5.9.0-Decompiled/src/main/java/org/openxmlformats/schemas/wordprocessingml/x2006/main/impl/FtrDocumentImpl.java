package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;

/* loaded from: classes6.dex */
public class FtrDocumentImpl extends XmlComplexContentImpl implements FtrDocument {
    private static final QName FTR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ftr");

    public FtrDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument
    public CTHdrFtr addNewFtr() {
        CTHdrFtr cTHdrFtr;
        synchronized (monitor()) {
            check_orphaned();
            cTHdrFtr = (CTHdrFtr) get_store().add_element_user(FTR$0);
        }
        return cTHdrFtr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument
    public CTHdrFtr getFtr() {
        synchronized (monitor()) {
            check_orphaned();
            CTHdrFtr cTHdrFtr = (CTHdrFtr) get_store().find_element_user(FTR$0, 0);
            if (cTHdrFtr == null) {
                return null;
            }
            return cTHdrFtr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument
    public void setFtr(CTHdrFtr cTHdrFtr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FTR$0;
            CTHdrFtr cTHdrFtr2 = (CTHdrFtr) typeStore.find_element_user(qName, 0);
            if (cTHdrFtr2 == null) {
                cTHdrFtr2 = (CTHdrFtr) get_store().add_element_user(qName);
            }
            cTHdrFtr2.set(cTHdrFtr);
        }
    }
}

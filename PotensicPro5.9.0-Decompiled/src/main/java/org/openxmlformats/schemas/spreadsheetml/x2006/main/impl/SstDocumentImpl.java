package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

/* loaded from: classes6.dex */
public class SstDocumentImpl extends XmlComplexContentImpl implements SstDocument {
    private static final QName SST$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sst");

    public SstDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument
    public CTSst addNewSst() {
        CTSst cTSst;
        synchronized (monitor()) {
            check_orphaned();
            cTSst = (CTSst) get_store().add_element_user(SST$0);
        }
        return cTSst;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument
    public CTSst getSst() {
        synchronized (monitor()) {
            check_orphaned();
            CTSst cTSst = (CTSst) get_store().find_element_user(SST$0, 0);
            if (cTSst == null) {
                return null;
            }
            return cTSst;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument
    public void setSst(CTSst cTSst) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SST$0;
            CTSst cTSst2 = (CTSst) typeStore.find_element_user(qName, 0);
            if (cTSst2 == null) {
                cTSst2 = (CTSst) get_store().add_element_user(qName);
            }
            cTSst2.set(cTSst);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;

/* loaded from: classes6.dex */
public class CTPPrDefaultImpl extends XmlComplexContentImpl implements CTPPrDefault {
    private static final QName PPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");

    public CTPPrDefaultImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault
    public CTPPr addNewPPr() {
        CTPPr cTPPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPPr = (CTPPr) get_store().add_element_user(PPR$0);
        }
        return cTPPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault
    public CTPPr getPPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPr cTPPr = (CTPPr) get_store().find_element_user(PPR$0, 0);
            if (cTPPr == null) {
                return null;
            }
            return cTPPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault
    public void setPPr(CTPPr cTPPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPR$0;
            CTPPr cTPPr2 = (CTPPr) typeStore.find_element_user(qName, 0);
            if (cTPPr2 == null) {
                cTPPr2 = (CTPPr) get_store().add_element_user(qName);
            }
            cTPPr2.set(cTPPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPR$0, 0);
        }
    }
}

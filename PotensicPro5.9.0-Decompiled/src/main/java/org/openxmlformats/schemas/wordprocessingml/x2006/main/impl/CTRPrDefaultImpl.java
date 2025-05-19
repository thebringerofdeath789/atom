package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;

/* loaded from: classes6.dex */
public class CTRPrDefaultImpl extends XmlComplexContentImpl implements CTRPrDefault {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");

    public CTRPrDefaultImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(RPR$0);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault
    public CTRPr getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPr = (CTRPr) get_store().find_element_user(RPR$0, 0);
            if (cTRPr == null) {
                return null;
            }
            return cTRPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault
    public void setRPr(CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$0;
            CTRPr cTRPr2 = (CTRPr) typeStore.find_element_user(qName, 0);
            if (cTRPr2 == null) {
                cTRPr2 = (CTRPr) get_store().add_element_user(qName);
            }
            cTRPr2.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, 0);
        }
    }
}

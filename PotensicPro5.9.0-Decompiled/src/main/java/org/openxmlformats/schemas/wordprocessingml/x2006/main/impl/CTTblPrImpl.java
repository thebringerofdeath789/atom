package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrChange;

/* loaded from: classes6.dex */
public class CTTblPrImpl extends CTTblPrBaseImpl implements CTTblPr {
    private static final QName TBLPRCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrChange");

    public CTTblPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public CTTblPrChange addNewTblPrChange() {
        CTTblPrChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLPRCHANGE$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public CTTblPrChange getTblPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPrChange find_element_user = get_store().find_element_user(TBLPRCHANGE$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public boolean isSetTblPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPRCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public void setTblPrChange(CTTblPrChange cTTblPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPRCHANGE$0;
            CTTblPrChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblPrChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr
    public void unsetTblPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPRCHANGE$0, 0);
        }
    }
}

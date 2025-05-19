package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExChange;

/* loaded from: classes6.dex */
public class CTTblPrExImpl extends CTTblPrExBaseImpl implements CTTblPrEx {
    private static final QName TBLPREXCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPrExChange");

    public CTTblPrExImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange addNewTblPrExChange() {
        CTTblPrExChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLPREXCHANGE$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public CTTblPrExChange getTblPrExChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPrExChange find_element_user = get_store().find_element_user(TBLPREXCHANGE$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public boolean isSetTblPrExChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPREXCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void setTblPrExChange(CTTblPrExChange cTTblPrExChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPREXCHANGE$0;
            CTTblPrExChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblPrExChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblPrExChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrEx
    public void unsetTblPrExChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPREXCHANGE$0, 0);
        }
    }
}

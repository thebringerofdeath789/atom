package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridChange;

/* loaded from: classes6.dex */
public class CTTblGridImpl extends CTTblGridBaseImpl implements CTTblGrid {
    private static final QName TBLGRIDCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblGridChange");

    public CTTblGridImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public CTTblGridChange addNewTblGridChange() {
        CTTblGridChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLGRIDCHANGE$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public CTTblGridChange getTblGridChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblGridChange find_element_user = get_store().find_element_user(TBLGRIDCHANGE$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public boolean isSetTblGridChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLGRIDCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public void setTblGridChange(CTTblGridChange cTTblGridChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLGRIDCHANGE$0;
            CTTblGridChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblGridChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblGridChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid
    public void unsetTblGridChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLGRIDCHANGE$0, 0);
        }
    }
}

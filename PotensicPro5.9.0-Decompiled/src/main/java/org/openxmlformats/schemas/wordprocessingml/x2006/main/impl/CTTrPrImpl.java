package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes6.dex */
public class CTTrPrImpl extends CTTrPrBaseImpl implements CTTrPr {
    private static final QName INS$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName TRPRCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trPrChange");

    public CTTrPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange addNewDel() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(DEL$2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange addNewIns() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(INS$0);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrPrChange addNewTrPrChange() {
        CTTrPrChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TRPRCHANGE$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange getDel() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(DEL$2, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrackChange getIns() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(INS$0, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public CTTrPrChange getTrPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrPrChange find_element_user = get_store().find_element_user(TRPRCHANGE$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public boolean isSetDel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public boolean isSetIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INS$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public boolean isSetTrPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRPRCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void setDel(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEL$2;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void setIns(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INS$0;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void setTrPrChange(CTTrPrChange cTTrPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRPRCHANGE$4;
            CTTrPrChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTrPrChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTrPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void unsetDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void unsetIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr
    public void unsetTrPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRPRCHANGE$4, 0);
        }
    }
}

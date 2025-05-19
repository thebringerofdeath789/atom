package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangeNumbering;

/* loaded from: classes6.dex */
public class CTNumPrImpl extends XmlComplexContentImpl implements CTNumPr {
    private static final QName ILVL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
    private static final QName NUMID$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numId");
    private static final QName NUMBERINGCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numberingChange");
    private static final QName INS$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");

    public CTNumPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber addNewIlvl() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(ILVL$0);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChange addNewIns() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(INS$6);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber addNewNumId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(NUMID$2);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChangeNumbering addNewNumberingChange() {
        CTTrackChangeNumbering add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NUMBERINGCHANGE$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber getIlvl() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(ILVL$0, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChange getIns() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChange cTTrackChange = (CTTrackChange) get_store().find_element_user(INS$6, 0);
            if (cTTrackChange == null) {
                return null;
            }
            return cTTrackChange;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTDecimalNumber getNumId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(NUMID$2, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public CTTrackChangeNumbering getNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTrackChangeNumbering find_element_user = get_store().find_element_user(NUMBERINGCHANGE$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetIlvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ILVL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetNumId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMID$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public boolean isSetNumberingChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMBERINGCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setIlvl(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ILVL$0;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setIns(CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = INS$6;
            CTTrackChange cTTrackChange2 = (CTTrackChange) typeStore.find_element_user(qName, 0);
            if (cTTrackChange2 == null) {
                cTTrackChange2 = (CTTrackChange) get_store().add_element_user(qName);
            }
            cTTrackChange2.set(cTTrackChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setNumId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMID$2;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMBERINGCHANGE$4;
            CTTrackChangeNumbering find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTrackChangeNumbering) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTrackChangeNumbering);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetIlvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ILVL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetNumId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMID$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPr
    public void unsetNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMBERINGCHANGE$4, 0);
        }
    }
}

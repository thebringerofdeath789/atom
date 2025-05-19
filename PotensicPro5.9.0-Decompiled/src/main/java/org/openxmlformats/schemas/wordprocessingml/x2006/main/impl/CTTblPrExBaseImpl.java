package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

/* loaded from: classes6.dex */
public class CTTblPrExBaseImpl extends XmlComplexContentImpl implements CTTblPrExBase {
    private static final QName TBLW$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblW");
    private static final QName JC$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
    private static final QName TBLCELLSPACING$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
    private static final QName TBLIND$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblInd");
    private static final QName TBLBORDERS$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblBorders");
    private static final QName SHD$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName TBLLAYOUT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLayout");
    private static final QName TBLCELLMAR$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellMar");
    private static final QName TBLLOOK$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLook");

    public CTTblPrExBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTJc addNewJc() {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().add_element_user(JC$2);
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(SHD$10);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblBorders addNewTblBorders() {
        CTTblBorders cTTblBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTTblBorders = (CTTblBorders) get_store().add_element_user(TBLBORDERS$8);
        }
        return cTTblBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblCellMar addNewTblCellMar() {
        CTTblCellMar cTTblCellMar;
        synchronized (monitor()) {
            check_orphaned();
            cTTblCellMar = (CTTblCellMar) get_store().add_element_user(TBLCELLMAR$14);
        }
        return cTTblCellMar;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblWidth addNewTblCellSpacing() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLCELLSPACING$4);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblWidth addNewTblInd() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLIND$6);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblLayoutType addNewTblLayout() {
        CTTblLayoutType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLLAYOUT$12);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTShortHexNumber addNewTblLook() {
        CTShortHexNumber add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLLOOK$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblWidth addNewTblW() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLW$0);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTJc getJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJc = (CTJc) get_store().find_element_user(JC$2, 0);
            if (cTJc == null) {
                return null;
            }
            return cTJc;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShd = (CTShd) get_store().find_element_user(SHD$10, 0);
            if (cTShd == null) {
                return null;
            }
            return cTShd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblBorders getTblBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblBorders cTTblBorders = (CTTblBorders) get_store().find_element_user(TBLBORDERS$8, 0);
            if (cTTblBorders == null) {
                return null;
            }
            return cTTblBorders;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblCellMar getTblCellMar() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblCellMar cTTblCellMar = (CTTblCellMar) get_store().find_element_user(TBLCELLMAR$14, 0);
            if (cTTblCellMar == null) {
                return null;
            }
            return cTTblCellMar;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblWidth getTblCellSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLCELLSPACING$4, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblWidth getTblInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLIND$6, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblLayoutType getTblLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblLayoutType find_element_user = get_store().find_element_user(TBLLAYOUT$12, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTShortHexNumber getTblLook() {
        synchronized (monitor()) {
            check_orphaned();
            CTShortHexNumber find_element_user = get_store().find_element_user(TBLLOOK$16, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public CTTblWidth getTblW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLW$0, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(JC$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLBORDERS$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblCellMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLCELLMAR$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblCellSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLCELLSPACING$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLIND$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLLAYOUT$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblLook() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLLOOK$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public boolean isSetTblW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLW$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JC$2;
            CTJc cTJc2 = (CTJc) typeStore.find_element_user(qName, 0);
            if (cTJc2 == null) {
                cTJc2 = (CTJc) get_store().add_element_user(qName);
            }
            cTJc2.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$10;
            CTShd cTShd2 = (CTShd) typeStore.find_element_user(qName, 0);
            if (cTShd2 == null) {
                cTShd2 = (CTShd) get_store().add_element_user(qName);
            }
            cTShd2.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblBorders(CTTblBorders cTTblBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLBORDERS$8;
            CTTblBorders cTTblBorders2 = (CTTblBorders) typeStore.find_element_user(qName, 0);
            if (cTTblBorders2 == null) {
                cTTblBorders2 = (CTTblBorders) get_store().add_element_user(qName);
            }
            cTTblBorders2.set(cTTblBorders);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblCellMar(CTTblCellMar cTTblCellMar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLCELLMAR$14;
            CTTblCellMar cTTblCellMar2 = (CTTblCellMar) typeStore.find_element_user(qName, 0);
            if (cTTblCellMar2 == null) {
                cTTblCellMar2 = (CTTblCellMar) get_store().add_element_user(qName);
            }
            cTTblCellMar2.set(cTTblCellMar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblCellSpacing(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLCELLSPACING$4;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblInd(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLIND$6;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblLayout(CTTblLayoutType cTTblLayoutType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLLAYOUT$12;
            CTTblLayoutType find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblLayoutType) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblLayoutType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblLook(CTShortHexNumber cTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLLOOK$16;
            CTShortHexNumber find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTShortHexNumber) get_store().add_element_user(qName);
            }
            find_element_user.set(cTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void setTblW(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLW$0;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLBORDERS$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblCellMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLMAR$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblCellSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLSPACING$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLIND$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLLAYOUT$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblLook() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLLOOK$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrExBase
    public void unsetTblW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLW$0, 0);
        }
    }
}

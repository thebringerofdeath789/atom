package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;

/* loaded from: classes6.dex */
public class CTTcPrBaseImpl extends XmlComplexContentImpl implements CTTcPrBase {
    private static final QName CNFSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle");
    private static final QName TCW$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcW");
    private static final QName GRIDSPAN$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridSpan");
    private static final QName HMERGE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hMerge");
    private static final QName VMERGE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vMerge");
    private static final QName TCBORDERS$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcBorders");
    private static final QName SHD$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName NOWRAP$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noWrap");
    private static final QName TCMAR$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcMar");
    private static final QName TEXTDIRECTION$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection");
    private static final QName TCFITTEXT$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcFitText");
    private static final QName VALIGN$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vAlign");
    private static final QName HIDEMARK$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideMark");

    public CTTcPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CNFSTYLE$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTDecimalNumber addNewGridSpan() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(GRIDSPAN$4);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHMerge addNewHMerge() {
        CTHMerge cTHMerge;
        synchronized (monitor()) {
            check_orphaned();
            cTHMerge = (CTHMerge) get_store().add_element_user(HMERGE$6);
        }
        return cTHMerge;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewHideMark() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(HIDEMARK$24);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewNoWrap() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(NOWRAP$14);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(SHD$12);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcBorders addNewTcBorders() {
        CTTcBorders cTTcBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTTcBorders = (CTTcBorders) get_store().add_element_user(TCBORDERS$10);
        }
        return cTTcBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewTcFitText() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(TCFITTEXT$20);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcMar addNewTcMar() {
        CTTcMar add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TCMAR$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTblWidth addNewTcW() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TCW$2);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTextDirection addNewTextDirection() {
        CTTextDirection add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TEXTDIRECTION$18);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVerticalJc addNewVAlign() {
        CTVerticalJc cTVerticalJc;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJc = (CTVerticalJc) get_store().add_element_user(VALIGN$22);
        }
        return cTVerticalJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVMerge addNewVMerge() {
        CTVMerge cTVMerge;
        synchronized (monitor()) {
            check_orphaned();
            cTVMerge = (CTVMerge) get_store().add_element_user(VMERGE$8);
        }
        return cTVMerge;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTCnf getCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTCnf find_element_user = get_store().find_element_user(CNFSTYLE$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTDecimalNumber getGridSpan() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(GRIDSPAN$4, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHMerge getHMerge() {
        synchronized (monitor()) {
            check_orphaned();
            CTHMerge cTHMerge = (CTHMerge) get_store().find_element_user(HMERGE$6, 0);
            if (cTHMerge == null) {
                return null;
            }
            return cTHMerge;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getHideMark() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(HIDEMARK$24, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getNoWrap() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(NOWRAP$14, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShd = (CTShd) get_store().find_element_user(SHD$12, 0);
            if (cTShd == null) {
                return null;
            }
            return cTShd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcBorders getTcBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcBorders cTTcBorders = (CTTcBorders) get_store().find_element_user(TCBORDERS$10, 0);
            if (cTTcBorders == null) {
                return null;
            }
            return cTTcBorders;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getTcFitText() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(TCFITTEXT$20, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcMar getTcMar() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcMar find_element_user = get_store().find_element_user(TCMAR$16, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTblWidth getTcW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TCW$2, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTextDirection getTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            CTTextDirection find_element_user = get_store().find_element_user(TEXTDIRECTION$18, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVerticalJc getVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            CTVerticalJc cTVerticalJc = (CTVerticalJc) get_store().find_element_user(VALIGN$22, 0);
            if (cTVerticalJc == null) {
                return null;
            }
            return cTVerticalJc;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVMerge getVMerge() {
        synchronized (monitor()) {
            check_orphaned();
            CTVMerge cTVMerge = (CTVMerge) get_store().find_element_user(VMERGE$8, 0);
            if (cTVMerge == null) {
                return null;
            }
            return cTVMerge;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetCnfStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CNFSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetGridSpan() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRIDSPAN$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HMERGE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHideMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HIDEMARK$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetNoWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOWRAP$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCBORDERS$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcFitText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCFITTEXT$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCMAR$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCW$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTextDirection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TEXTDIRECTION$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetVAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VALIGN$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetVMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(VMERGE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setCnfStyle(CTCnf cTCnf) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CNFSTYLE$0;
            CTCnf find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTCnf) get_store().add_element_user(qName);
            }
            find_element_user.set(cTCnf);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setGridSpan(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = GRIDSPAN$4;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHMerge(CTHMerge cTHMerge) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HMERGE$6;
            CTHMerge cTHMerge2 = (CTHMerge) typeStore.find_element_user(qName, 0);
            if (cTHMerge2 == null) {
                cTHMerge2 = (CTHMerge) get_store().add_element_user(qName);
            }
            cTHMerge2.set(cTHMerge);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHideMark(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HIDEMARK$24;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setNoWrap(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NOWRAP$14;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$12;
            CTShd cTShd2 = (CTShd) typeStore.find_element_user(qName, 0);
            if (cTShd2 == null) {
                cTShd2 = (CTShd) get_store().add_element_user(qName);
            }
            cTShd2.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcBorders(CTTcBorders cTTcBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCBORDERS$10;
            CTTcBorders cTTcBorders2 = (CTTcBorders) typeStore.find_element_user(qName, 0);
            if (cTTcBorders2 == null) {
                cTTcBorders2 = (CTTcBorders) get_store().add_element_user(qName);
            }
            cTTcBorders2.set(cTTcBorders);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcFitText(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCFITTEXT$20;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcMar(CTTcMar cTTcMar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCMAR$16;
            CTTcMar find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTcMar) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTcMar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcW(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCW$2;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTextDirection(CTTextDirection cTTextDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TEXTDIRECTION$18;
            CTTextDirection find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTextDirection) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTextDirection);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setVAlign(CTVerticalJc cTVerticalJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VALIGN$22;
            CTVerticalJc cTVerticalJc2 = (CTVerticalJc) typeStore.find_element_user(qName, 0);
            if (cTVerticalJc2 == null) {
                cTVerticalJc2 = (CTVerticalJc) get_store().add_element_user(qName);
            }
            cTVerticalJc2.set(cTVerticalJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setVMerge(CTVMerge cTVMerge) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VMERGE$8;
            CTVMerge cTVMerge2 = (CTVMerge) typeStore.find_element_user(qName, 0);
            if (cTVMerge2 == null) {
                cTVMerge2 = (CTVMerge) get_store().add_element_user(qName);
            }
            cTVMerge2.set(cTVMerge);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CNFSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetGridSpan() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRIDSPAN$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HMERGE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHideMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HIDEMARK$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetNoWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOWRAP$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCBORDERS$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcFitText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCFITTEXT$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCMAR$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCW$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TEXTDIRECTION$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VALIGN$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetVMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VMERGE$8, 0);
        }
    }
}

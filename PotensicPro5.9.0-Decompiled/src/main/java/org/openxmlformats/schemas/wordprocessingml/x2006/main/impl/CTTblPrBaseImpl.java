package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShortHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

/* loaded from: classes6.dex */
public class CTTblPrBaseImpl extends XmlComplexContentImpl implements CTTblPrBase {
    private static final QName TBLSTYLE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyle");
    private static final QName TBLPPR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblpPr");
    private static final QName TBLOVERLAP$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblOverlap");
    private static final QName BIDIVISUAL$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bidiVisual");
    private static final QName TBLSTYLEROWBANDSIZE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyleRowBandSize");
    private static final QName TBLSTYLECOLBANDSIZE$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStyleColBandSize");
    private static final QName TBLW$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblW");
    private static final QName JC$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc");
    private static final QName TBLCELLSPACING$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing");
    private static final QName TBLIND$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblInd");
    private static final QName TBLBORDERS$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblBorders");
    private static final QName SHD$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd");
    private static final QName TBLLAYOUT$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLayout");
    private static final QName TBLCELLMAR$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellMar");
    private static final QName TBLLOOK$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblLook");

    public CTTblPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTOnOff addNewBidiVisual() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(BIDIVISUAL$6);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTJc addNewJc() {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().add_element_user(JC$14);
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(SHD$22);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblBorders addNewTblBorders() {
        CTTblBorders cTTblBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTTblBorders = (CTTblBorders) get_store().add_element_user(TBLBORDERS$20);
        }
        return cTTblBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblCellMar addNewTblCellMar() {
        CTTblCellMar cTTblCellMar;
        synchronized (monitor()) {
            check_orphaned();
            cTTblCellMar = (CTTblCellMar) get_store().add_element_user(TBLCELLMAR$26);
        }
        return cTTblCellMar;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth addNewTblCellSpacing() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLCELLSPACING$16);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth addNewTblInd() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLIND$18);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblLayoutType addNewTblLayout() {
        CTTblLayoutType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLLAYOUT$24);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShortHexNumber addNewTblLook() {
        CTShortHexNumber add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLLOOK$28);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblOverlap addNewTblOverlap() {
        CTTblOverlap add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLOVERLAP$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTString addNewTblStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(TBLSTYLE$0);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber addNewTblStyleColBandSize() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(TBLSTYLECOLBANDSIZE$10);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber addNewTblStyleRowBandSize() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(TBLSTYLEROWBANDSIZE$8);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth addNewTblW() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TBLW$12);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblPPr addNewTblpPr() {
        CTTblPPr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TBLPPR$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTOnOff getBidiVisual() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(BIDIVISUAL$6, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTJc getJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJc = (CTJc) get_store().find_element_user(JC$14, 0);
            if (cTJc == null) {
                return null;
            }
            return cTJc;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShd getShd() {
        synchronized (monitor()) {
            check_orphaned();
            CTShd cTShd = (CTShd) get_store().find_element_user(SHD$22, 0);
            if (cTShd == null) {
                return null;
            }
            return cTShd;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblBorders getTblBorders() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblBorders cTTblBorders = (CTTblBorders) get_store().find_element_user(TBLBORDERS$20, 0);
            if (cTTblBorders == null) {
                return null;
            }
            return cTTblBorders;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblCellMar getTblCellMar() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblCellMar cTTblCellMar = (CTTblCellMar) get_store().find_element_user(TBLCELLMAR$26, 0);
            if (cTTblCellMar == null) {
                return null;
            }
            return cTTblCellMar;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth getTblCellSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLCELLSPACING$16, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth getTblInd() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLIND$18, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblLayoutType getTblLayout() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblLayoutType find_element_user = get_store().find_element_user(TBLLAYOUT$24, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTShortHexNumber getTblLook() {
        synchronized (monitor()) {
            check_orphaned();
            CTShortHexNumber find_element_user = get_store().find_element_user(TBLLOOK$28, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblOverlap getTblOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblOverlap find_element_user = get_store().find_element_user(TBLOVERLAP$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTString getTblStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(TBLSTYLE$0, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber getTblStyleColBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(TBLSTYLECOLBANDSIZE$10, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTDecimalNumber getTblStyleRowBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(TBLSTYLEROWBANDSIZE$8, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblWidth getTblW() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TBLW$12, 0);
            if (cTTblWidth == null) {
                return null;
            }
            return cTTblWidth;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public CTTblPPr getTblpPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTTblPPr find_element_user = get_store().find_element_user(TBLPPR$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetBidiVisual() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BIDIVISUAL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(JC$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHD$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLBORDERS$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblCellMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLCELLMAR$26) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblCellSpacing() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLCELLSPACING$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblInd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLIND$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLLAYOUT$24) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblLook() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLLOOK$28) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblOverlap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLOVERLAP$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLSTYLE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblStyleColBandSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLSTYLECOLBANDSIZE$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblStyleRowBandSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLSTYLEROWBANDSIZE$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLW$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public boolean isSetTblpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TBLPPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setBidiVisual(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BIDIVISUAL$6;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = JC$14;
            CTJc cTJc2 = (CTJc) typeStore.find_element_user(qName, 0);
            if (cTJc2 == null) {
                cTJc2 = (CTJc) get_store().add_element_user(qName);
            }
            cTJc2.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setShd(CTShd cTShd) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHD$22;
            CTShd cTShd2 = (CTShd) typeStore.find_element_user(qName, 0);
            if (cTShd2 == null) {
                cTShd2 = (CTShd) get_store().add_element_user(qName);
            }
            cTShd2.set(cTShd);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblBorders(CTTblBorders cTTblBorders) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLBORDERS$20;
            CTTblBorders cTTblBorders2 = (CTTblBorders) typeStore.find_element_user(qName, 0);
            if (cTTblBorders2 == null) {
                cTTblBorders2 = (CTTblBorders) get_store().add_element_user(qName);
            }
            cTTblBorders2.set(cTTblBorders);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblCellMar(CTTblCellMar cTTblCellMar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLCELLMAR$26;
            CTTblCellMar cTTblCellMar2 = (CTTblCellMar) typeStore.find_element_user(qName, 0);
            if (cTTblCellMar2 == null) {
                cTTblCellMar2 = (CTTblCellMar) get_store().add_element_user(qName);
            }
            cTTblCellMar2.set(cTTblCellMar);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblCellSpacing(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLCELLSPACING$16;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblInd(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLIND$18;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblLayout(CTTblLayoutType cTTblLayoutType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLLAYOUT$24;
            CTTblLayoutType find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblLayoutType) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblLayoutType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblLook(CTShortHexNumber cTShortHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLLOOK$28;
            CTShortHexNumber find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTShortHexNumber) get_store().add_element_user(qName);
            }
            find_element_user.set(cTShortHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblOverlap(CTTblOverlap cTTblOverlap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLOVERLAP$4;
            CTTblOverlap find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblOverlap) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblOverlap);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLSTYLE$0;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblStyleColBandSize(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLSTYLECOLBANDSIZE$10;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblStyleRowBandSize(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLSTYLEROWBANDSIZE$8;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblW(CTTblWidth cTTblWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLW$12;
            CTTblWidth cTTblWidth2 = (CTTblWidth) typeStore.find_element_user(qName, 0);
            if (cTTblWidth2 == null) {
                cTTblWidth2 = (CTTblWidth) get_store().add_element_user(qName);
            }
            cTTblWidth2.set(cTTblWidth);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void setTblpPr(CTTblPPr cTTblPPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TBLPPR$2;
            CTTblPPr find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTblPPr) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTblPPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetBidiVisual() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BIDIVISUAL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHD$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLBORDERS$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblCellMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLMAR$26, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblCellSpacing() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLCELLSPACING$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblInd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLIND$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLLAYOUT$24, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblLook() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLLOOK$28, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblOverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLOVERLAP$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblStyleColBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLECOLBANDSIZE$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblStyleRowBandSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLSTYLEROWBANDSIZE$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLW$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase
    public void unsetTblpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TBLPPR$2, 0);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelSuffix;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLevelText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvlLegacy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* loaded from: classes6.dex */
public class CTLvlImpl extends XmlComplexContentImpl implements CTLvl {
    private static final QName START$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", TtmlNode.START);
    private static final QName NUMFMT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numFmt");
    private static final QName LVLRESTART$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlRestart");
    private static final QName PSTYLE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pStyle");
    private static final QName ISLGL$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "isLgl");
    private static final QName SUFF$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "suff");
    private static final QName LVLTEXT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlText");
    private static final QName LVLPICBULLETID$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlPicBulletId");
    private static final QName LEGACY$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "legacy");
    private static final QName LVLJC$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlJc");
    private static final QName PPR$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");
    private static final QName RPR$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
    private static final QName ILVL$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");
    private static final QName TPLC$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tplc");
    private static final QName TENTATIVE$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tentative");

    public CTLvlImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTOnOff addNewIsLgl() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(ISLGL$8);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLvlLegacy addNewLegacy() {
        CTLvlLegacy add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LEGACY$16);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTJc addNewLvlJc() {
        CTJc cTJc;
        synchronized (monitor()) {
            check_orphaned();
            cTJc = (CTJc) get_store().add_element_user(LVLJC$18);
        }
        return cTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber addNewLvlPicBulletId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(LVLPICBULLETID$14);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber addNewLvlRestart() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(LVLRESTART$4);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelText addNewLvlText() {
        CTLevelText cTLevelText;
        synchronized (monitor()) {
            check_orphaned();
            cTLevelText = (CTLevelText) get_store().add_element_user(LVLTEXT$12);
        }
        return cTLevelText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(NUMFMT$2);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTPPr addNewPPr() {
        CTPPr cTPPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPPr = (CTPPr) get_store().add_element_user(PPR$20);
        }
        return cTPPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTString addNewPStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PSTYLE$6);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(RPR$22);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber addNewStart() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(START$0);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelSuffix addNewSuff() {
        CTLevelSuffix add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SUFF$10);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public BigInteger getIlvl() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ILVL$24);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTOnOff getIsLgl() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(ISLGL$8, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLvlLegacy getLegacy() {
        synchronized (monitor()) {
            check_orphaned();
            CTLvlLegacy find_element_user = get_store().find_element_user(LEGACY$16, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTJc getLvlJc() {
        synchronized (monitor()) {
            check_orphaned();
            CTJc cTJc = (CTJc) get_store().find_element_user(LVLJC$18, 0);
            if (cTJc == null) {
                return null;
            }
            return cTJc;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber getLvlPicBulletId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(LVLPICBULLETID$14, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber getLvlRestart() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(LVLRESTART$4, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelText getLvlText() {
        synchronized (monitor()) {
            check_orphaned();
            CTLevelText cTLevelText = (CTLevelText) get_store().find_element_user(LVLTEXT$12, 0);
            if (cTLevelText == null) {
                return null;
            }
            return cTLevelText;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTNumFmt getNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            CTNumFmt cTNumFmt = (CTNumFmt) get_store().find_element_user(NUMFMT$2, 0);
            if (cTNumFmt == null) {
                return null;
            }
            return cTNumFmt;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTPPr getPPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPr cTPPr = (CTPPr) get_store().find_element_user(PPR$20, 0);
            if (cTPPr == null) {
                return null;
            }
            return cTPPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTString getPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(PSTYLE$6, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTRPr getRPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPr = (CTRPr) get_store().find_element_user(RPR$22, 0);
            if (cTRPr == null) {
                return null;
            }
            return cTRPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTDecimalNumber getStart() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(START$0, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public CTLevelSuffix getSuff() {
        synchronized (monitor()) {
            check_orphaned();
            CTLevelSuffix find_element_user = get_store().find_element_user(SUFF$10, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STOnOff.Enum getTentative() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TENTATIVE$28);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public byte[] getTplc() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TPLC$26);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetIsLgl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ISLGL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLegacy() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEGACY$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLJC$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlPicBulletId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLPICBULLETID$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlRestart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLRESTART$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetLvlText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVLTEXT$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMFMT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPR$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetPStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PSTYLE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPR$22) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetStart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(START$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetSuff() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUFF$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetTentative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TENTATIVE$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public boolean isSetTplc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TPLC$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setIlvl(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ILVL$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setIsLgl(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISLGL$8;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLegacy(CTLvlLegacy cTLvlLegacy) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEGACY$16;
            CTLvlLegacy find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTLvlLegacy) get_store().add_element_user(qName);
            }
            find_element_user.set(cTLvlLegacy);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlJc(CTJc cTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLJC$18;
            CTJc cTJc2 = (CTJc) typeStore.find_element_user(qName, 0);
            if (cTJc2 == null) {
                cTJc2 = (CTJc) get_store().add_element_user(qName);
            }
            cTJc2.set(cTJc);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlPicBulletId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLPICBULLETID$14;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlRestart(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLRESTART$4;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setLvlText(CTLevelText cTLevelText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LVLTEXT$12;
            CTLevelText cTLevelText2 = (CTLevelText) typeStore.find_element_user(qName, 0);
            if (cTLevelText2 == null) {
                cTLevelText2 = (CTLevelText) get_store().add_element_user(qName);
            }
            cTLevelText2.set(cTLevelText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setNumFmt(CTNumFmt cTNumFmt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMT$2;
            CTNumFmt cTNumFmt2 = (CTNumFmt) typeStore.find_element_user(qName, 0);
            if (cTNumFmt2 == null) {
                cTNumFmt2 = (CTNumFmt) get_store().add_element_user(qName);
            }
            cTNumFmt2.set(cTNumFmt);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setPPr(CTPPr cTPPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPR$20;
            CTPPr cTPPr2 = (CTPPr) typeStore.find_element_user(qName, 0);
            if (cTPPr2 == null) {
                cTPPr2 = (CTPPr) get_store().add_element_user(qName);
            }
            cTPPr2.set(cTPPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setPStyle(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PSTYLE$6;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setRPr(CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPR$22;
            CTRPr cTRPr2 = (CTRPr) typeStore.find_element_user(qName, 0);
            if (cTRPr2 == null) {
                cTRPr2 = (CTRPr) get_store().add_element_user(qName);
            }
            cTRPr2.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setStart(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = START$0;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setSuff(CTLevelSuffix cTLevelSuffix) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SUFF$10;
            CTLevelSuffix find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTLevelSuffix) get_store().add_element_user(qName);
            }
            find_element_user.set(cTLevelSuffix);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setTentative(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TENTATIVE$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void setTplc(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TPLC$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetIsLgl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ISLGL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLegacy() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEGACY$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLJC$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlPicBulletId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLPICBULLETID$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlRestart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLRESTART$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetLvlText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLTEXT$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMFMT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPR$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetPStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PSTYLE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$22, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetStart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(START$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetSuff() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUFF$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetTentative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TENTATIVE$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void unsetTplc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TPLC$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STDecimalNumber xgetIlvl() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(ILVL$24);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STOnOff xgetTentative() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(TENTATIVE$28);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public STLongHexNumber xgetTplc() {
        STLongHexNumber sTLongHexNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTLongHexNumber = (STLongHexNumber) get_store().find_attribute_user(TPLC$26);
        }
        return sTLongHexNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void xsetIlvl(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ILVL$24;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void xsetTentative(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TENTATIVE$28;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl
    public void xsetTplc(STLongHexNumber sTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TPLC$26;
            STLongHexNumber sTLongHexNumber2 = (STLongHexNumber) typeStore.find_attribute_user(qName);
            if (sTLongHexNumber2 == null) {
                sTLongHexNumber2 = (STLongHexNumber) get_store().add_attribute_user(qName);
            }
            sTLongHexNumber2.set(sTLongHexNumber);
        }
    }
}

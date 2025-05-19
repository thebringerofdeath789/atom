package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellStyleXfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFillId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STNumFmtId;

/* loaded from: classes6.dex */
public class CTXfImpl extends XmlComplexContentImpl implements CTXf {
    private static final QName ALIGNMENT$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", CellUtil.ALIGNMENT);
    private static final QName PROTECTION$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protection");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName NUMFMTID$6 = new QName("", "numFmtId");
    private static final QName FONTID$8 = new QName("", "fontId");
    private static final QName FILLID$10 = new QName("", "fillId");
    private static final QName BORDERID$12 = new QName("", "borderId");
    private static final QName XFID$14 = new QName("", "xfId");
    private static final QName QUOTEPREFIX$16 = new QName("", "quotePrefix");
    private static final QName PIVOTBUTTON$18 = new QName("", "pivotButton");
    private static final QName APPLYNUMBERFORMAT$20 = new QName("", "applyNumberFormat");
    private static final QName APPLYFONT$22 = new QName("", "applyFont");
    private static final QName APPLYFILL$24 = new QName("", "applyFill");
    private static final QName APPLYBORDER$26 = new QName("", "applyBorder");
    private static final QName APPLYALIGNMENT$28 = new QName("", "applyAlignment");
    private static final QName APPLYPROTECTION$30 = new QName("", "applyProtection");

    public CTXfImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public CTCellAlignment addNewAlignment() {
        CTCellAlignment cTCellAlignment;
        synchronized (monitor()) {
            check_orphaned();
            cTCellAlignment = (CTCellAlignment) get_store().add_element_user(ALIGNMENT$0);
        }
        return cTCellAlignment;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public CTCellProtection addNewProtection() {
        CTCellProtection cTCellProtection;
        synchronized (monitor()) {
            check_orphaned();
            cTCellProtection = (CTCellProtection) get_store().add_element_user(PROTECTION$2);
        }
        return cTCellProtection;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public CTCellAlignment getAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellAlignment cTCellAlignment = (CTCellAlignment) get_store().find_element_user(ALIGNMENT$0, 0);
            if (cTCellAlignment == null) {
                return null;
            }
            return cTCellAlignment;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getApplyAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(APPLYALIGNMENT$28);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getApplyBorder() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(APPLYBORDER$26);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getApplyFill() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(APPLYFILL$24);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getApplyFont() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(APPLYFONT$22);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getApplyNumberFormat() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(APPLYNUMBERFORMAT$20);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getApplyProtection() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(APPLYPROTECTION$30);
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public long getBorderId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BORDERID$12);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public long getFillId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLID$10);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public long getFontId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FONTID$8);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public long getNumFmtId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NUMFMTID$6);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getPivotButton() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOTBUTTON$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public CTCellProtection getProtection() {
        synchronized (monitor()) {
            check_orphaned();
            CTCellProtection cTCellProtection = (CTCellProtection) get_store().find_element_user(PROTECTION$2, 0);
            if (cTCellProtection == null) {
                return null;
            }
            return cTCellProtection;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean getQuotePrefix() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUOTEPREFIX$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return false;
            }
            return simpleValue.getBooleanValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public long getXfId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(XFID$14);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetAlignment() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ALIGNMENT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetApplyAlignment() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYALIGNMENT$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetApplyBorder() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYBORDER$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetApplyFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYFILL$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetApplyFont() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYFONT$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetApplyNumberFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYNUMBERFORMAT$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetApplyProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(APPLYPROTECTION$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetBorderId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BORDERID$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetFillId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLID$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetFontId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FONTID$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetNumFmtId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NUMFMTID$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetPivotButton() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PIVOTBUTTON$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetProtection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROTECTION$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetQuotePrefix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(QUOTEPREFIX$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public boolean isSetXfId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(XFID$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setAlignment(CTCellAlignment cTCellAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$0;
            CTCellAlignment cTCellAlignment2 = (CTCellAlignment) typeStore.find_element_user(qName, 0);
            if (cTCellAlignment2 == null) {
                cTCellAlignment2 = (CTCellAlignment) get_store().add_element_user(qName);
            }
            cTCellAlignment2.set(cTCellAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setApplyAlignment(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYALIGNMENT$28;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setApplyBorder(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYBORDER$26;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setApplyFill(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYFILL$24;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setApplyFont(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYFONT$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setApplyNumberFormat(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYNUMBERFORMAT$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setApplyProtection(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYPROTECTION$30;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setBorderId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERID$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setFillId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLID$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setFontId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTID$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setNumFmtId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMTID$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setPivotButton(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOTBUTTON$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setProtection(CTCellProtection cTCellProtection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PROTECTION$2;
            CTCellProtection cTCellProtection2 = (CTCellProtection) typeStore.find_element_user(qName, 0);
            if (cTCellProtection2 == null) {
                cTCellProtection2 = (CTCellProtection) get_store().add_element_user(qName);
            }
            cTCellProtection2.set(cTCellProtection);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setQuotePrefix(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUOTEPREFIX$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void setXfId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XFID$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ALIGNMENT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetApplyAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYALIGNMENT$28);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetApplyBorder() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYBORDER$26);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetApplyFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYFILL$24);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetApplyFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYFONT$22);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetApplyNumberFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYNUMBERFORMAT$20);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetApplyProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(APPLYPROTECTION$30);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetBorderId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BORDERID$12);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetFillId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLID$10);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetFontId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FONTID$8);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetNumFmtId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NUMFMTID$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetPivotButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PIVOTBUTTON$18);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetProtection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROTECTION$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetQuotePrefix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(QUOTEPREFIX$16);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void unsetXfId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(XFID$14);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetApplyAlignment() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(APPLYALIGNMENT$28);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetApplyBorder() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(APPLYBORDER$26);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetApplyFill() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(APPLYFILL$24);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetApplyFont() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(APPLYFONT$22);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetApplyNumberFormat() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(APPLYNUMBERFORMAT$20);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetApplyProtection() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(APPLYPROTECTION$30);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public STBorderId xgetBorderId() {
        STBorderId sTBorderId;
        synchronized (monitor()) {
            check_orphaned();
            sTBorderId = (STBorderId) get_store().find_attribute_user(BORDERID$12);
        }
        return sTBorderId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public STFillId xgetFillId() {
        STFillId sTFillId;
        synchronized (monitor()) {
            check_orphaned();
            sTFillId = (STFillId) get_store().find_attribute_user(FILLID$10);
        }
        return sTFillId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public STFontId xgetFontId() {
        STFontId sTFontId;
        synchronized (monitor()) {
            check_orphaned();
            sTFontId = (STFontId) get_store().find_attribute_user(FONTID$8);
        }
        return sTFontId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public STNumFmtId xgetNumFmtId() {
        STNumFmtId sTNumFmtId;
        synchronized (monitor()) {
            check_orphaned();
            sTNumFmtId = (STNumFmtId) get_store().find_attribute_user(NUMFMTID$6);
        }
        return sTNumFmtId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetPivotButton() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOTBUTTON$18;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public XmlBoolean xgetQuotePrefix() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUOTEPREFIX$16;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public STCellStyleXfId xgetXfId() {
        STCellStyleXfId sTCellStyleXfId;
        synchronized (monitor()) {
            check_orphaned();
            sTCellStyleXfId = (STCellStyleXfId) get_store().find_attribute_user(XFID$14);
        }
        return sTCellStyleXfId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetApplyAlignment(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYALIGNMENT$28;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetApplyBorder(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYBORDER$26;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetApplyFill(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYFILL$24;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetApplyFont(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYFONT$22;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetApplyNumberFormat(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYNUMBERFORMAT$20;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetApplyProtection(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = APPLYPROTECTION$30;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetBorderId(STBorderId sTBorderId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BORDERID$12;
            STBorderId sTBorderId2 = (STBorderId) typeStore.find_attribute_user(qName);
            if (sTBorderId2 == null) {
                sTBorderId2 = (STBorderId) get_store().add_attribute_user(qName);
            }
            sTBorderId2.set(sTBorderId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetFillId(STFillId sTFillId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FILLID$10;
            STFillId sTFillId2 = (STFillId) typeStore.find_attribute_user(qName);
            if (sTFillId2 == null) {
                sTFillId2 = (STFillId) get_store().add_attribute_user(qName);
            }
            sTFillId2.set(sTFillId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetFontId(STFontId sTFontId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTID$8;
            STFontId sTFontId2 = (STFontId) typeStore.find_attribute_user(qName);
            if (sTFontId2 == null) {
                sTFontId2 = (STFontId) get_store().add_attribute_user(qName);
            }
            sTFontId2.set(sTFontId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetNumFmtId(STNumFmtId sTNumFmtId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMFMTID$6;
            STNumFmtId sTNumFmtId2 = (STNumFmtId) typeStore.find_attribute_user(qName);
            if (sTNumFmtId2 == null) {
                sTNumFmtId2 = (STNumFmtId) get_store().add_attribute_user(qName);
            }
            sTNumFmtId2.set(sTNumFmtId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetPivotButton(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PIVOTBUTTON$18;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetQuotePrefix(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = QUOTEPREFIX$16;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf
    public void xsetXfId(STCellStyleXfId sTCellStyleXfId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = XFID$14;
            STCellStyleXfId sTCellStyleXfId2 = (STCellStyleXfId) typeStore.find_attribute_user(qName);
            if (sTCellStyleXfId2 == null) {
                sTCellStyleXfId2 = (STCellStyleXfId) get_store().add_attribute_user(qName);
            }
            sTCellStyleXfId2.set(sTCellStyleXfId);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChangeNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* loaded from: classes6.dex */
public class CTFldCharImpl extends XmlComplexContentImpl implements CTFldChar {
    private static final QName FLDDATA$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldData");
    private static final QName FFDATA$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ffData");
    private static final QName NUMBERINGCHANGE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numberingChange");
    private static final QName FLDCHARTYPE$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldCharType");
    private static final QName FLDLOCK$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldLock");
    private static final QName DIRTY$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty");

    public CTFldCharImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTFFData addNewFfData() {
        CTFFData cTFFData;
        synchronized (monitor()) {
            check_orphaned();
            cTFFData = (CTFFData) get_store().add_element_user(FFDATA$2);
        }
        return cTFFData;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTText addNewFldData() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(FLDDATA$0);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTTrackChangeNumbering addNewNumberingChange() {
        CTTrackChangeNumbering add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NUMBERINGCHANGE$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff.Enum getDirty() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DIRTY$10);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTFFData getFfData() {
        synchronized (monitor()) {
            check_orphaned();
            CTFFData cTFFData = (CTFFData) get_store().find_element_user(FFDATA$2, 0);
            if (cTFFData == null) {
                return null;
            }
            return cTFFData;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STFldCharType.Enum getFldCharType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FLDCHARTYPE$6);
            if (simpleValue == null) {
                return null;
            }
            return (STFldCharType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public CTText getFldData() {
        synchronized (monitor()) {
            check_orphaned();
            CTText cTText = (CTText) get_store().find_element_user(FLDDATA$0, 0);
            if (cTText == null) {
                return null;
            }
            return cTText;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff.Enum getFldLock() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FLDLOCK$8);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetDirty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DIRTY$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetFfData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FFDATA$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetFldData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FLDDATA$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetFldLock() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FLDLOCK$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public boolean isSetNumberingChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMBERINGCHANGE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setDirty(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIRTY$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFfData(CTFFData cTFFData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FFDATA$2;
            CTFFData cTFFData2 = (CTFFData) typeStore.find_element_user(qName, 0);
            if (cTFFData2 == null) {
                cTFFData2 = (CTFFData) get_store().add_element_user(qName);
            }
            cTFFData2.set(cTFFData);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFldCharType(STFldCharType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDCHARTYPE$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFldData(CTText cTText) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDDATA$0;
            CTText cTText2 = (CTText) typeStore.find_element_user(qName, 0);
            if (cTText2 == null) {
                cTText2 = (CTText) get_store().add_element_user(qName);
            }
            cTText2.set(cTText);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void setFldLock(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDLOCK$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetDirty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DIRTY$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetFfData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FFDATA$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetFldData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLDDATA$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetFldLock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FLDLOCK$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void unsetNumberingChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMBERINGCHANGE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff xgetDirty() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(DIRTY$10);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STFldCharType xgetFldCharType() {
        STFldCharType sTFldCharType;
        synchronized (monitor()) {
            check_orphaned();
            sTFldCharType = (STFldCharType) get_store().find_attribute_user(FLDCHARTYPE$6);
        }
        return sTFldCharType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public STOnOff xgetFldLock() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(FLDLOCK$8);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void xsetDirty(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIRTY$10;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void xsetFldCharType(STFldCharType sTFldCharType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDCHARTYPE$6;
            STFldCharType sTFldCharType2 = (STFldCharType) typeStore.find_attribute_user(qName);
            if (sTFldCharType2 == null) {
                sTFldCharType2 = (STFldCharType) get_store().add_attribute_user(qName);
            }
            sTFldCharType2.set(sTFldCharType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar
    public void xsetFldLock(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FLDLOCK$8;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }
}

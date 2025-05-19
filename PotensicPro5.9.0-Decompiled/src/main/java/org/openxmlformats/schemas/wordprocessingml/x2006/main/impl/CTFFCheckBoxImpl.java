package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;

/* loaded from: classes6.dex */
public class CTFFCheckBoxImpl extends XmlComplexContentImpl implements CTFFCheckBox {
    private static final QName SIZE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "size");
    private static final QName SIZEAUTO$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sizeAuto");
    private static final QName DEFAULT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "default");
    private static final QName CHECKED$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checked");

    public CTFFCheckBoxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff addNewChecked() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(CHECKED$6);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff addNewDefault() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(DEFAULT$4);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTHpsMeasure addNewSize() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(SIZE$0);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff addNewSizeAuto() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(SIZEAUTO$2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff getChecked() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(CHECKED$6, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff getDefault() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(DEFAULT$4, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTHpsMeasure getSize() {
        synchronized (monitor()) {
            check_orphaned();
            CTHpsMeasure cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(SIZE$0, 0);
            if (cTHpsMeasure == null) {
                return null;
            }
            return cTHpsMeasure;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public CTOnOff getSizeAuto() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(SIZEAUTO$2, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetChecked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHECKED$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DEFAULT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIZE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public boolean isSetSizeAuto() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIZEAUTO$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setChecked(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CHECKED$6;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setDefault(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFAULT$4;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setSize(CTHpsMeasure cTHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZE$0;
            CTHpsMeasure cTHpsMeasure2 = (CTHpsMeasure) typeStore.find_element_user(qName, 0);
            if (cTHpsMeasure2 == null) {
                cTHpsMeasure2 = (CTHpsMeasure) get_store().add_element_user(qName);
            }
            cTHpsMeasure2.set(cTHpsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void setSizeAuto(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIZEAUTO$2;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetChecked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHECKED$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEFAULT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIZE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox
    public void unsetSizeAuto() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIZEAUTO$2, 0);
        }
    }
}

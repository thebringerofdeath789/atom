package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;

/* loaded from: classes6.dex */
public class CTBrImpl extends XmlComplexContentImpl implements CTBr {
    private static final QName TYPE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
    private static final QName CLEAR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "clear");

    public CTBrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrClear.Enum getClear() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CLEAR$2);
            if (simpleValue == null) {
                return null;
            }
            return (STBrClear.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$0);
            if (simpleValue == null) {
                return null;
            }
            return (STBrType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public boolean isSetClear() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CLEAR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void setClear(STBrClear.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLEAR$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void setType(STBrType.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void unsetClear() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CLEAR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrClear xgetClear() {
        STBrClear sTBrClear;
        synchronized (monitor()) {
            check_orphaned();
            sTBrClear = (STBrClear) get_store().find_attribute_user(CLEAR$2);
        }
        return sTBrClear;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public STBrType xgetType() {
        STBrType sTBrType;
        synchronized (monitor()) {
            check_orphaned();
            sTBrType = (STBrType) get_store().find_attribute_user(TYPE$0);
        }
        return sTBrType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void xsetClear(STBrClear sTBrClear) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CLEAR$2;
            STBrClear sTBrClear2 = (STBrClear) typeStore.find_attribute_user(qName);
            if (sTBrClear2 == null) {
                sTBrClear2 = (STBrClear) get_store().add_attribute_user(qName);
            }
            sTBrClear2.set(sTBrClear);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr
    public void xsetType(STBrType sTBrType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STBrType sTBrType2 = (STBrType) typeStore.find_attribute_user(qName);
            if (sTBrType2 == null) {
                sTBrType2 = (STBrType) get_store().add_attribute_user(qName);
            }
            sTBrType2.set(sTBrType);
        }
    }
}

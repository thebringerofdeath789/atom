package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPhoneticAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPhoneticAlignment$Enum;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPhoneticType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPhoneticType$Enum;

/* loaded from: classes6.dex */
public class CTPhoneticPrImpl extends XmlComplexContentImpl implements CTPhoneticPr {
    private static final QName FONTID$0 = new QName("", "fontId");
    private static final QName TYPE$2 = new QName("", "type");
    private static final QName ALIGNMENT$4 = new QName("", CellUtil.ALIGNMENT);

    public CTPhoneticPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public STPhoneticAlignment$Enum getAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STPhoneticAlignment$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public long getFontId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FONTID$0);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public STPhoneticType$Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STPhoneticType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public boolean isSetAlignment() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALIGNMENT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void setAlignment(STPhoneticAlignment$Enum sTPhoneticAlignment$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTPhoneticAlignment$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void setFontId(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTID$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void setType(STPhoneticType$Enum sTPhoneticType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTPhoneticType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void unsetAlignment() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALIGNMENT$4);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public STPhoneticAlignment xgetAlignment() {
        STPhoneticAlignment find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$4;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPhoneticAlignment) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public STFontId xgetFontId() {
        STFontId sTFontId;
        synchronized (monitor()) {
            check_orphaned();
            sTFontId = (STFontId) get_store().find_attribute_user(FONTID$0);
        }
        return sTFontId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public STPhoneticType xgetType() {
        STPhoneticType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPhoneticType) get_default_attribute_value(qName);
            }
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void xsetAlignment(STPhoneticAlignment sTPhoneticAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALIGNMENT$4;
            STPhoneticAlignment find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPhoneticAlignment) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTPhoneticAlignment);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void xsetFontId(STFontId sTFontId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FONTID$0;
            STFontId sTFontId2 = (STFontId) typeStore.find_attribute_user(qName);
            if (sTFontId2 == null) {
                sTFontId2 = (STFontId) get_store().add_attribute_user(qName);
            }
            sTFontId2.set(sTFontId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr
    public void xsetType(STPhoneticType sTPhoneticType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$2;
            STPhoneticType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STPhoneticType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTPhoneticType);
        }
    }
}

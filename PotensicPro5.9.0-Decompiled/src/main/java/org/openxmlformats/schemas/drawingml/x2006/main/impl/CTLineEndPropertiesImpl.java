package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;

/* loaded from: classes5.dex */
public class CTLineEndPropertiesImpl extends XmlComplexContentImpl implements CTLineEndProperties {
    private static final QName TYPE$0 = new QName("", "type");
    private static final QName W$2 = new QName("", "w");
    private static final QName LEN$4 = new QName("", "len");

    public CTLineEndPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public STLineEndLength.Enum getLen() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LEN$4);
            if (simpleValue == null) {
                return null;
            }
            return (STLineEndLength.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public STLineEndType.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$0);
            if (simpleValue == null) {
                return null;
            }
            return (STLineEndType.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public STLineEndWidth.Enum getW() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(W$2);
            if (simpleValue == null) {
                return null;
            }
            return (STLineEndWidth.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public boolean isSetLen() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LEN$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(W$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void setLen(STLineEndLength.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEN$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void setType(STLineEndType.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void setW(STLineEndWidth.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void unsetLen() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LEN$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(W$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public STLineEndLength xgetLen() {
        STLineEndLength sTLineEndLength;
        synchronized (monitor()) {
            check_orphaned();
            sTLineEndLength = (STLineEndLength) get_store().find_attribute_user(LEN$4);
        }
        return sTLineEndLength;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public STLineEndType xgetType() {
        STLineEndType sTLineEndType;
        synchronized (monitor()) {
            check_orphaned();
            sTLineEndType = (STLineEndType) get_store().find_attribute_user(TYPE$0);
        }
        return sTLineEndType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public STLineEndWidth xgetW() {
        STLineEndWidth sTLineEndWidth;
        synchronized (monitor()) {
            check_orphaned();
            sTLineEndWidth = (STLineEndWidth) get_store().find_attribute_user(W$2);
        }
        return sTLineEndWidth;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void xsetLen(STLineEndLength sTLineEndLength) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEN$4;
            STLineEndLength sTLineEndLength2 = (STLineEndLength) typeStore.find_attribute_user(qName);
            if (sTLineEndLength2 == null) {
                sTLineEndLength2 = (STLineEndLength) get_store().add_attribute_user(qName);
            }
            sTLineEndLength2.set(sTLineEndLength);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void xsetType(STLineEndType sTLineEndType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STLineEndType sTLineEndType2 = (STLineEndType) typeStore.find_attribute_user(qName);
            if (sTLineEndType2 == null) {
                sTLineEndType2 = (STLineEndType) get_store().add_attribute_user(qName);
            }
            sTLineEndType2.set(sTLineEndType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties
    public void xsetW(STLineEndWidth sTLineEndWidth) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$2;
            STLineEndWidth sTLineEndWidth2 = (STLineEndWidth) typeStore.find_attribute_user(qName);
            if (sTLineEndWidth2 == null) {
                sTLineEndWidth2 = (STLineEndWidth) get_store().add_attribute_user(qName);
            }
            sTLineEndWidth2.set(sTLineEndWidth);
        }
    }
}

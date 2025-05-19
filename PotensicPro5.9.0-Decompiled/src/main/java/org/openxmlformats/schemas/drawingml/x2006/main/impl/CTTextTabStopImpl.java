package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTabAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTabAlignType$Enum;

/* loaded from: classes5.dex */
public class CTTextTabStopImpl extends XmlComplexContentImpl implements CTTextTabStop {
    private static final QName POS$0 = new QName("", "pos");
    private static final QName ALGN$2 = new QName("", "algn");

    public CTTextTabStopImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public STTextTabAlignType$Enum getAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ALGN$2);
            if (simpleValue == null) {
                return null;
            }
            return (STTextTabAlignType$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public int getPos() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(POS$0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public boolean isSetAlgn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ALGN$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public boolean isSetPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(POS$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public void setAlgn(STTextTabAlignType$Enum sTTextTabAlignType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTTextTabAlignType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public void setPos(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POS$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public void unsetAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ALGN$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public void unsetPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(POS$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public STTextTabAlignType xgetAlgn() {
        STTextTabAlignType find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(ALGN$2);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public STCoordinate32 xgetPos() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(POS$0);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public void xsetAlgn(STTextTabAlignType sTTextTabAlignType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ALGN$2;
            STTextTabAlignType find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STTextTabAlignType) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTTextTabAlignType);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop
    public void xsetPos(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = POS$0;
            STCoordinate32 sTCoordinate322 = (STCoordinate32) typeStore.find_attribute_user(qName);
            if (sTCoordinate322 == null) {
                sTCoordinate322 = (STCoordinate32) get_store().add_attribute_user(qName);
            }
            sTCoordinate322.set(sTCoordinate32);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutMode;

/* loaded from: classes5.dex */
public class CTLayoutModeImpl extends XmlComplexContentImpl implements CTLayoutMode {
    private static final QName VAL$0 = new QName("", "val");

    public CTLayoutModeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode
    public STLayoutMode.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qName);
            }
            if (simpleValue == null) {
                return null;
            }
            return (STLayoutMode.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode
    public void setVal(STLayoutMode.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode
    public STLayoutMode xgetVal() {
        STLayoutMode sTLayoutMode;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTLayoutMode = (STLayoutMode) typeStore.find_attribute_user(qName);
            if (sTLayoutMode == null) {
                sTLayoutMode = (STLayoutMode) get_default_attribute_value(qName);
            }
        }
        return sTLayoutMode;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode
    public void xsetVal(STLayoutMode sTLayoutMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STLayoutMode sTLayoutMode2 = (STLayoutMode) typeStore.find_attribute_user(qName);
            if (sTLayoutMode2 == null) {
                sTLayoutMode2 = (STLayoutMode) get_store().add_attribute_user(qName);
            }
            sTLayoutMode2.set(sTLayoutMode);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

/* loaded from: classes5.dex */
public class CTLegendPosImpl extends XmlComplexContentImpl implements CTLegendPos {
    private static final QName VAL$0 = new QName("", "val");

    public CTLegendPosImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos
    public STLegendPos.Enum getVal() {
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
            return (STLegendPos.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos
    public void setVal(STLegendPos.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos
    public STLegendPos xgetVal() {
        STLegendPos sTLegendPos;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTLegendPos = (STLegendPos) typeStore.find_attribute_user(qName);
            if (sTLegendPos == null) {
                sTLegendPos = (STLegendPos) get_default_attribute_value(qName);
            }
        }
        return sTLegendPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos
    public void xsetVal(STLegendPos sTLegendPos) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STLegendPos sTLegendPos2 = (STLegendPos) typeStore.find_attribute_user(qName);
            if (sTLegendPos2 == null) {
                sTLegendPos2 = (STLegendPos) get_store().add_attribute_user(qName);
            }
            sTLegendPos2.set(sTLegendPos);
        }
    }
}

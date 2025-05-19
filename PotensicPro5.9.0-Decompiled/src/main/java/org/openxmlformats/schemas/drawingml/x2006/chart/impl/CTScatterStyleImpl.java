package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;

/* loaded from: classes5.dex */
public class CTScatterStyleImpl extends XmlComplexContentImpl implements CTScatterStyle {
    private static final QName VAL$0 = new QName("", "val");

    public CTScatterStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle
    public STScatterStyle.Enum getVal() {
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
            return (STScatterStyle.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle
    public void setVal(STScatterStyle.Enum r4) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle
    public STScatterStyle xgetVal() {
        STScatterStyle sTScatterStyle;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            sTScatterStyle = (STScatterStyle) typeStore.find_attribute_user(qName);
            if (sTScatterStyle == null) {
                sTScatterStyle = (STScatterStyle) get_default_attribute_value(qName);
            }
        }
        return sTScatterStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle
    public void xsetVal(STScatterStyle sTScatterStyle) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STScatterStyle sTScatterStyle2 = (STScatterStyle) typeStore.find_attribute_user(qName);
            if (sTScatterStyle2 == null) {
                sTScatterStyle2 = (STScatterStyle) get_store().add_attribute_user(qName);
            }
            sTScatterStyle2.set(sTScatterStyle);
        }
    }
}

package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STFixedPercentage;

/* loaded from: classes5.dex */
public class CTFixedPercentageImpl extends XmlComplexContentImpl implements CTFixedPercentage {
    private static final QName VAL$0 = new QName("", "val");

    public CTFixedPercentageImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage
    public int getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage
    public void setVal(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage
    public STFixedPercentage xgetVal() {
        STFixedPercentage sTFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            sTFixedPercentage = (STFixedPercentage) get_store().find_attribute_user(VAL$0);
        }
        return sTFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFixedPercentage
    public void xsetVal(STFixedPercentage sTFixedPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STFixedPercentage sTFixedPercentage2 = (STFixedPercentage) typeStore.find_attribute_user(qName);
            if (sTFixedPercentage2 == null) {
                sTFixedPercentage2 = (STFixedPercentage) get_store().add_attribute_user(qName);
            }
            sTFixedPercentage2.set(sTFixedPercentage);
        }
    }
}

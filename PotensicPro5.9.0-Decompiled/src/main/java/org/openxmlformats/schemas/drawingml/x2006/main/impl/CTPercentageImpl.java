package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;

/* loaded from: classes5.dex */
public class CTPercentageImpl extends XmlComplexContentImpl implements CTPercentage {
    private static final QName VAL$0 = new QName("", "val");

    public CTPercentageImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage
    public STPercentage xgetVal() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            check_orphaned();
            sTPercentage = (STPercentage) get_store().find_attribute_user(VAL$0);
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPercentage
    public void xsetVal(STPercentage sTPercentage) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
            if (sTPercentage2 == null) {
                sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
            }
            sTPercentage2.set(sTPercentage);
        }
    }
}

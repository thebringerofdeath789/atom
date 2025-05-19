package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignRun;

/* loaded from: classes6.dex */
public class CTVerticalAlignFontPropertyImpl extends XmlComplexContentImpl implements CTVerticalAlignFontProperty {
    private static final QName VAL$0 = new QName("", "val");

    public CTVerticalAlignFontPropertyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty
    public STVerticalAlignRun.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return (STVerticalAlignRun.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty
    public void setVal(STVerticalAlignRun.Enum r4) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty
    public STVerticalAlignRun xgetVal() {
        STVerticalAlignRun sTVerticalAlignRun;
        synchronized (monitor()) {
            check_orphaned();
            sTVerticalAlignRun = (STVerticalAlignRun) get_store().find_attribute_user(VAL$0);
        }
        return sTVerticalAlignRun;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty
    public void xsetVal(STVerticalAlignRun sTVerticalAlignRun) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STVerticalAlignRun sTVerticalAlignRun2 = (STVerticalAlignRun) typeStore.find_attribute_user(qName);
            if (sTVerticalAlignRun2 == null) {
                sTVerticalAlignRun2 = (STVerticalAlignRun) get_store().add_attribute_user(qName);
            }
            sTVerticalAlignRun2.set(sTVerticalAlignRun);
        }
    }
}

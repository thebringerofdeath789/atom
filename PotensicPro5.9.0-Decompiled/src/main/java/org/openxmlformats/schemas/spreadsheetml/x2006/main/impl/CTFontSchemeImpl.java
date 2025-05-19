package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;

/* loaded from: classes6.dex */
public class CTFontSchemeImpl extends XmlComplexContentImpl implements CTFontScheme {
    private static final QName VAL$0 = new QName("", "val");

    public CTFontSchemeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme
    public STFontScheme.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return (STFontScheme.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme
    public void setVal(STFontScheme.Enum r4) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme
    public STFontScheme xgetVal() {
        STFontScheme sTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            sTFontScheme = (STFontScheme) get_store().find_attribute_user(VAL$0);
        }
        return sTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme
    public void xsetVal(STFontScheme sTFontScheme) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STFontScheme sTFontScheme2 = (STFontScheme) typeStore.find_attribute_user(qName);
            if (sTFontScheme2 == null) {
                sTFontScheme2 = (STFontScheme) get_store().add_attribute_user(qName);
            }
            sTFontScheme2.set(sTFontScheme);
        }
    }
}

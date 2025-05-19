package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

/* loaded from: classes6.dex */
public class CTNumFmtImpl extends XmlComplexContentImpl implements CTNumFmt {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTNumFmtImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt
    public STNumberFormat.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return (STNumberFormat.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt
    public void setVal(STNumberFormat.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt
    public STNumberFormat xgetVal() {
        STNumberFormat sTNumberFormat;
        synchronized (monitor()) {
            check_orphaned();
            sTNumberFormat = (STNumberFormat) get_store().find_attribute_user(VAL$0);
        }
        return sTNumberFormat;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumFmt
    public void xsetVal(STNumberFormat sTNumberFormat) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STNumberFormat sTNumberFormat2 = (STNumberFormat) typeStore.find_attribute_user(qName);
            if (sTNumberFormat2 == null) {
                sTNumberFormat2 = (STNumberFormat) get_store().add_attribute_user(qName);
            }
            sTNumberFormat2.set(sTNumberFormat);
        }
    }
}

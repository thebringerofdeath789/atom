package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;

/* loaded from: classes6.dex */
public class CTTextAlignmentImpl extends XmlComplexContentImpl implements CTTextAlignment {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTTextAlignmentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public STTextAlignment.Enum getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return (STTextAlignment.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public void setVal(STTextAlignment.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public STTextAlignment xgetVal() {
        STTextAlignment sTTextAlignment;
        synchronized (monitor()) {
            check_orphaned();
            sTTextAlignment = (STTextAlignment) get_store().find_attribute_user(VAL$0);
        }
        return sTTextAlignment;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public void xsetVal(STTextAlignment sTTextAlignment) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTextAlignment sTTextAlignment2 = (STTextAlignment) typeStore.find_attribute_user(qName);
            if (sTTextAlignment2 == null) {
                sTTextAlignment2 = (STTextAlignment) get_store().add_attribute_user(qName);
            }
            sTTextAlignment2.set(sTTextAlignment);
        }
    }
}

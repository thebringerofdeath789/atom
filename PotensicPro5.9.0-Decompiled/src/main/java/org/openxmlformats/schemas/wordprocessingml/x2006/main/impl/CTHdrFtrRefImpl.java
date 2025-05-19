package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;

/* loaded from: classes6.dex */
public class CTHdrFtrRefImpl extends CTRelImpl implements CTHdrFtrRef {
    private static final QName TYPE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");

    public CTHdrFtrRefImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public STHdrFtr.Enum getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$0);
            if (simpleValue == null) {
                return null;
            }
            return (STHdrFtr.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public void setType(STHdrFtr.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public STHdrFtr xgetType() {
        STHdrFtr sTHdrFtr;
        synchronized (monitor()) {
            check_orphaned();
            sTHdrFtr = (STHdrFtr) get_store().find_attribute_user(TYPE$0);
        }
        return sTHdrFtr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtrRef
    public void xsetType(STHdrFtr sTHdrFtr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$0;
            STHdrFtr sTHdrFtr2 = (STHdrFtr) typeStore.find_attribute_user(qName);
            if (sTHdrFtr2 == null) {
                sTHdrFtr2 = (STHdrFtr) get_store().add_attribute_user(qName);
            }
            sTHdrFtr2.set(sTHdrFtr);
        }
    }
}

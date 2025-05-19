package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedHpsMeasure;

/* loaded from: classes6.dex */
public class CTSignedHpsMeasureImpl extends XmlComplexContentImpl implements CTSignedHpsMeasure {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");

    public CTSignedHpsMeasureImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public BigInteger getVal() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public void setVal(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public STSignedHpsMeasure xgetVal() {
        STSignedHpsMeasure sTSignedHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedHpsMeasure = (STSignedHpsMeasure) get_store().find_attribute_user(VAL$0);
        }
        return sTSignedHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure
    public void xsetVal(STSignedHpsMeasure sTSignedHpsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STSignedHpsMeasure sTSignedHpsMeasure2 = (STSignedHpsMeasure) typeStore.find_attribute_user(qName);
            if (sTSignedHpsMeasure2 == null) {
                sTSignedHpsMeasure2 = (STSignedHpsMeasure) get_store().add_attribute_user(qName);
            }
            sTSignedHpsMeasure2.set(sTSignedHpsMeasure);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* loaded from: classes6.dex */
public class CTTblGridColImpl extends XmlComplexContentImpl implements CTTblGridCol {
    private static final QName W$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");

    public CTTblGridColImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol
    public BigInteger getW() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(W$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol
    public boolean isSetW() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(W$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol
    public void setW(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol
    public void unsetW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(W$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol
    public STTwipsMeasure xgetW() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(W$0);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol
    public void xsetW(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = W$0;
            STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
            if (sTTwipsMeasure2 == null) {
                sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasure2.set(sTTwipsMeasure);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* loaded from: classes6.dex */
public class CTHeightImpl extends XmlComplexContentImpl implements CTHeight {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
    private static final QName HRULE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hRule");

    public CTHeightImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public STHeightRule$Enum getHRule() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HRULE$2);
            if (simpleValue == null) {
                return null;
            }
            return (STHeightRule$Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public boolean isSetHRule() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HRULE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void setHRule(STHeightRule$Enum sTHeightRule$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRULE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(sTHeightRule$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void unsetHRule() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HRULE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public STHeightRule xgetHRule() {
        STHeightRule find_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            find_attribute_user = get_store().find_attribute_user(HRULE$2);
        }
        return find_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public STTwipsMeasure xgetVal() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(VAL$0);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void xsetHRule(STHeightRule sTHeightRule) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HRULE$2;
            STHeightRule find_attribute_user = typeStore.find_attribute_user(qName);
            if (find_attribute_user == null) {
                find_attribute_user = (STHeightRule) get_store().add_attribute_user(qName);
            }
            find_attribute_user.set(sTHeightRule);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight
    public void xsetVal(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = VAL$0;
            STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
            if (sTTwipsMeasure2 == null) {
                sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasure2.set(sTTwipsMeasure);
        }
    }
}

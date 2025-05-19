package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* loaded from: classes6.dex */
public class CTBookmarkRangeImpl extends CTMarkupRangeImpl implements CTBookmarkRange {
    private static final QName COLFIRST$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "colFirst");
    private static final QName COLLAST$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "colLast");

    public CTBookmarkRangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public BigInteger getColFirst() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLFIRST$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public BigInteger getColLast() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLLAST$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public boolean isSetColFirst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLFIRST$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public boolean isSetColLast() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLLAST$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public void setColFirst(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLFIRST$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public void setColLast(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLLAST$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public void unsetColFirst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLFIRST$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public void unsetColLast() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLLAST$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public STDecimalNumber xgetColFirst() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(COLFIRST$0);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public STDecimalNumber xgetColLast() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(COLLAST$2);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public void xsetColFirst(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLFIRST$0;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmarkRange
    public void xsetColLast(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COLLAST$2;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }
}

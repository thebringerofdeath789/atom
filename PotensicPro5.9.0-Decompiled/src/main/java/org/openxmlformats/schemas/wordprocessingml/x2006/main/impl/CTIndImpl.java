package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* loaded from: classes6.dex */
public class CTIndImpl extends XmlComplexContentImpl implements CTInd {
    private static final QName LEFT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName LEFTCHARS$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "leftChars");
    private static final QName RIGHT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
    private static final QName RIGHTCHARS$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rightChars");
    private static final QName HANGING$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hanging");
    private static final QName HANGINGCHARS$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hangingChars");
    private static final QName FIRSTLINE$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "firstLine");
    private static final QName FIRSTLINECHARS$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "firstLineChars");

    public CTIndImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getFirstLine() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FIRSTLINE$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getFirstLineChars() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FIRSTLINECHARS$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getHanging() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HANGING$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getHangingChars() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HANGINGCHARS$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getLeft() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LEFT$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getLeftChars() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LEFTCHARS$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getRight() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RIGHT$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public BigInteger getRightChars() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RIGHTCHARS$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetFirstLine() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTLINE$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetFirstLineChars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTLINECHARS$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetHanging() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HANGING$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetHangingChars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HANGINGCHARS$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LEFT$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetLeftChars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LEFTCHARS$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RIGHT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public boolean isSetRightChars() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RIGHTCHARS$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setFirstLine(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTLINE$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setFirstLineChars(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTLINECHARS$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setHanging(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANGING$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setHangingChars(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANGINGCHARS$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setLeft(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setLeftChars(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFTCHARS$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setRight(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void setRightChars(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHTCHARS$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetFirstLine() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTLINE$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetFirstLineChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTLINECHARS$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetHanging() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HANGING$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetHangingChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HANGINGCHARS$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LEFT$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetLeftChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LEFTCHARS$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RIGHT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void unsetRightChars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RIGHTCHARS$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STTwipsMeasure xgetFirstLine() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(FIRSTLINE$12);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STDecimalNumber xgetFirstLineChars() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(FIRSTLINECHARS$14);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STTwipsMeasure xgetHanging() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(HANGING$8);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STDecimalNumber xgetHangingChars() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(HANGINGCHARS$10);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STSignedTwipsMeasure xgetLeft() {
        STSignedTwipsMeasure sTSignedTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedTwipsMeasure = (STSignedTwipsMeasure) get_store().find_attribute_user(LEFT$0);
        }
        return sTSignedTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STDecimalNumber xgetLeftChars() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(LEFTCHARS$2);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STSignedTwipsMeasure xgetRight() {
        STSignedTwipsMeasure sTSignedTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedTwipsMeasure = (STSignedTwipsMeasure) get_store().find_attribute_user(RIGHT$4);
        }
        return sTSignedTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public STDecimalNumber xgetRightChars() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(RIGHTCHARS$6);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetFirstLine(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTLINE$12;
            STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
            if (sTTwipsMeasure2 == null) {
                sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasure2.set(sTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetFirstLineChars(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = FIRSTLINECHARS$14;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetHanging(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANGING$8;
            STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
            if (sTTwipsMeasure2 == null) {
                sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTTwipsMeasure2.set(sTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetHangingChars(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HANGINGCHARS$10;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetLeft(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFT$0;
            STSignedTwipsMeasure sTSignedTwipsMeasure2 = (STSignedTwipsMeasure) typeStore.find_attribute_user(qName);
            if (sTSignedTwipsMeasure2 == null) {
                sTSignedTwipsMeasure2 = (STSignedTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTSignedTwipsMeasure2.set(sTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetLeftChars(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = LEFTCHARS$2;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetRight(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHT$4;
            STSignedTwipsMeasure sTSignedTwipsMeasure2 = (STSignedTwipsMeasure) typeStore.find_attribute_user(qName);
            if (sTSignedTwipsMeasure2 == null) {
                sTSignedTwipsMeasure2 = (STSignedTwipsMeasure) get_store().add_attribute_user(qName);
            }
            sTSignedTwipsMeasure2.set(sTSignedTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd
    public void xsetRightChars(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RIGHTCHARS$6;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

/* loaded from: classes6.dex */
public class CTLatentStylesImpl extends XmlComplexContentImpl implements CTLatentStyles {
    private static final QName LSDEXCEPTION$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lsdException");
    private static final QName DEFLOCKEDSTATE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defLockedState");
    private static final QName DEFUIPRIORITY$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defUIPriority");
    private static final QName DEFSEMIHIDDEN$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defSemiHidden");
    private static final QName DEFUNHIDEWHENUSED$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defUnhideWhenUsed");
    private static final QName DEFQFORMAT$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "defQFormat");
    private static final QName COUNT$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "count");

    public CTLatentStylesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException addNewLsdException() {
        CTLsdException cTLsdException;
        synchronized (monitor()) {
            check_orphaned();
            cTLsdException = (CTLsdException) get_store().add_element_user(LSDEXCEPTION$0);
        }
        return cTLsdException;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public BigInteger getCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COUNT$12);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefLockedState() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFLOCKEDSTATE$2);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFQFORMAT$10);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFSEMIHIDDEN$6);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public BigInteger getDefUIPriority() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFUIPRIORITY$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff.Enum getDefUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
            if (simpleValue == null) {
                return null;
            }
            return (STOnOff.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException getLsdExceptionArray(int i) {
        CTLsdException cTLsdException;
        synchronized (monitor()) {
            check_orphaned();
            cTLsdException = (CTLsdException) get_store().find_element_user(LSDEXCEPTION$0, i);
            if (cTLsdException == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLsdException;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException[] getLsdExceptionArray() {
        CTLsdException[] cTLsdExceptionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LSDEXCEPTION$0, arrayList);
            cTLsdExceptionArr = new CTLsdException[arrayList.size()];
            arrayList.toArray(cTLsdExceptionArr);
        }
        return cTLsdExceptionArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public List<CTLsdException> getLsdExceptionList() {
        1LsdExceptionList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LsdExceptionList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public CTLsdException insertNewLsdException(int i) {
        CTLsdException cTLsdException;
        synchronized (monitor()) {
            check_orphaned();
            cTLsdException = (CTLsdException) get_store().insert_element_user(LSDEXCEPTION$0, i);
        }
        return cTLsdException;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COUNT$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefLockedState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFLOCKEDSTATE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefQFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFQFORMAT$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefSemiHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFSEMIHIDDEN$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefUIPriority() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFUIPRIORITY$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public boolean isSetDefUnhideWhenUsed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DEFUNHIDEWHENUSED$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void removeLsdException(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LSDEXCEPTION$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setCount(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefLockedState(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFLOCKEDSTATE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefQFormat(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFQFORMAT$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefSemiHidden(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFSEMIHIDDEN$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefUIPriority(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUIPRIORITY$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setDefUnhideWhenUsed(STOnOff.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUNHIDEWHENUSED$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setLsdExceptionArray(int i, CTLsdException cTLsdException) {
        synchronized (monitor()) {
            check_orphaned();
            CTLsdException cTLsdException2 = (CTLsdException) get_store().find_element_user(LSDEXCEPTION$0, i);
            if (cTLsdException2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLsdException2.set(cTLsdException);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void setLsdExceptionArray(CTLsdException[] cTLsdExceptionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLsdExceptionArr, LSDEXCEPTION$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public int sizeOfLsdExceptionArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LSDEXCEPTION$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COUNT$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefLockedState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFLOCKEDSTATE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFQFORMAT$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFSEMIHIDDEN$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefUIPriority() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFUIPRIORITY$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void unsetDefUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DEFUNHIDEWHENUSED$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STDecimalNumber xgetCount() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(COUNT$12);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefLockedState() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(DEFLOCKEDSTATE$2);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefQFormat() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(DEFQFORMAT$10);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefSemiHidden() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(DEFSEMIHIDDEN$6);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STDecimalNumber xgetDefUIPriority() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(DEFUIPRIORITY$4);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public STOnOff xgetDefUnhideWhenUsed() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(DEFUNHIDEWHENUSED$8);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetCount(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = COUNT$12;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefLockedState(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFLOCKEDSTATE$2;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefQFormat(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFQFORMAT$10;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefSemiHidden(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFSEMIHIDDEN$6;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefUIPriority(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUIPRIORITY$4;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles
    public void xsetDefUnhideWhenUsed(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DEFUNHIDEWHENUSED$8;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
            }
            sTOnOff2.set(sTOnOff);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* loaded from: classes6.dex */
public class CTNumImpl extends XmlComplexContentImpl implements CTNum {
    private static final QName ABSTRACTNUMID$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId");
    private static final QName LVLOVERRIDE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvlOverride");
    private static final QName NUMID$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numId");

    public CTNumImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTDecimalNumber addNewAbstractNumId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(ABSTRACTNUMID$0);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl addNewLvlOverride() {
        CTNumLvl add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(LVLOVERRIDE$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTDecimalNumber getAbstractNumId() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(ABSTRACTNUMID$0, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl getLvlOverrideArray(int i) {
        CTNumLvl find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(LVLOVERRIDE$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl[] getLvlOverrideArray() {
        CTNumLvl[] cTNumLvlArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LVLOVERRIDE$2, arrayList);
            cTNumLvlArr = new CTNumLvl[arrayList.size()];
            arrayList.toArray(cTNumLvlArr);
        }
        return cTNumLvlArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public List<CTNumLvl> getLvlOverrideList() {
        1LvlOverrideList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LvlOverrideList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public BigInteger getNumId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NUMID$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public CTNumLvl insertNewLvlOverride(int i) {
        CTNumLvl insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(LVLOVERRIDE$2, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void removeLvlOverride(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVLOVERRIDE$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setAbstractNumId(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACTNUMID$0;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setLvlOverrideArray(int i, CTNumLvl cTNumLvl) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumLvl find_element_user = get_store().find_element_user(LVLOVERRIDE$2, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTNumLvl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setLvlOverrideArray(CTNumLvl[] cTNumLvlArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNumLvlArr, LVLOVERRIDE$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void setNumId(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMID$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public int sizeOfLvlOverrideArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LVLOVERRIDE$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public STDecimalNumber xgetNumId() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(NUMID$4);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum
    public void xsetNumId(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMID$4;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }
}

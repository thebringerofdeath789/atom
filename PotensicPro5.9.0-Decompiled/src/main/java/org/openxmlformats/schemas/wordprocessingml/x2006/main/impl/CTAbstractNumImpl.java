package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* loaded from: classes6.dex */
public class CTAbstractNumImpl extends XmlComplexContentImpl implements CTAbstractNum {
    private static final QName NSID$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "nsid");
    private static final QName MULTILEVELTYPE$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "multiLevelType");
    private static final QName TMPL$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tmpl");
    private static final QName NAME$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
    private static final QName STYLELINK$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLink");
    private static final QName NUMSTYLELINK$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numStyleLink");
    private static final QName LVL$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvl");
    private static final QName ABSTRACTNUMID$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId");

    public CTAbstractNumImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl addNewLvl() {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().add_element_user(LVL$12);
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTMultiLevelType addNewMultiLevelType() {
        CTMultiLevelType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(MULTILEVELTYPE$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewName() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(NAME$6);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber addNewNsid() {
        CTLongHexNumber add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NSID$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewNumStyleLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(NUMSTYLELINK$10);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewStyleLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(STYLELINK$8);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber addNewTmpl() {
        CTLongHexNumber add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TMPL$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public BigInteger getAbstractNumId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ABSTRACTNUMID$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getBigIntegerValue();
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl getLvlArray(int i) {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().find_element_user(LVL$12, i);
            if (cTLvl == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl[] getLvlArray() {
        CTLvl[] cTLvlArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LVL$12, arrayList);
            cTLvlArr = new CTLvl[arrayList.size()];
            arrayList.toArray(cTLvlArr);
        }
        return cTLvlArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public List<CTLvl> getLvlList() {
        1LvlList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1LvlList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTMultiLevelType getMultiLevelType() {
        synchronized (monitor()) {
            check_orphaned();
            CTMultiLevelType find_element_user = get_store().find_element_user(MULTILEVELTYPE$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getName() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(NAME$6, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber getNsid() {
        synchronized (monitor()) {
            check_orphaned();
            CTLongHexNumber find_element_user = get_store().find_element_user(NSID$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getNumStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(NUMSTYLELINK$10, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(STYLELINK$8, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber getTmpl() {
        synchronized (monitor()) {
            check_orphaned();
            CTLongHexNumber find_element_user = get_store().find_element_user(TMPL$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl insertNewLvl(int i) {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().insert_element_user(LVL$12, i);
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetMultiLevelType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(MULTILEVELTYPE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NAME$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetNsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NSID$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetNumStyleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMSTYLELINK$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetStyleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLELINK$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetTmpl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TMPL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void removeLvl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setAbstractNumId(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACTNUMID$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setLvlArray(int i, CTLvl cTLvl) {
        synchronized (monitor()) {
            check_orphaned();
            CTLvl cTLvl2 = (CTLvl) get_store().find_element_user(LVL$12, i);
            if (cTLvl2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTLvl2.set(cTLvl);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setLvlArray(CTLvl[] cTLvlArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLvlArr, LVL$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setMultiLevelType(CTMultiLevelType cTMultiLevelType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = MULTILEVELTYPE$2;
            CTMultiLevelType find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTMultiLevelType) get_store().add_element_user(qName);
            }
            find_element_user.set(cTMultiLevelType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setName(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NAME$6;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setNsid(CTLongHexNumber cTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NSID$0;
            CTLongHexNumber find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTLongHexNumber) get_store().add_element_user(qName);
            }
            find_element_user.set(cTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setNumStyleLink(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMSTYLELINK$10;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setStyleLink(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = STYLELINK$8;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setTmpl(CTLongHexNumber cTLongHexNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TMPL$4;
            CTLongHexNumber find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTLongHexNumber) get_store().add_element_user(qName);
            }
            find_element_user.set(cTLongHexNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public int sizeOfLvlArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(LVL$12);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetMultiLevelType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MULTILEVELTYPE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NAME$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetNsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NSID$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetNumStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMSTYLELINK$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLELINK$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetTmpl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TMPL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public STDecimalNumber xgetAbstractNumId() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(ABSTRACTNUMID$14);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void xsetAbstractNumId(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ABSTRACTNUMID$14;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }
}

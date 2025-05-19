package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPicBullet;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;

/* loaded from: classes6.dex */
public class CTNumberingImpl extends XmlComplexContentImpl implements CTNumbering {
    private static final QName NUMPICBULLET$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPicBullet");
    private static final QName ABSTRACTNUM$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNum");
    private static final QName NUM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "num");
    private static final QName NUMIDMACATCLEANUP$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numIdMacAtCleanup");

    public CTNumberingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum addNewAbstractNum() {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().add_element_user(ABSTRACTNUM$2);
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum addNewNum() {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().add_element_user(NUM$4);
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber addNewNumIdMacAtCleanup() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(NUMIDMACATCLEANUP$6);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet addNewNumPicBullet() {
        CTNumPicBullet add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(NUMPICBULLET$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum getAbstractNumArray(int i) {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().find_element_user(ABSTRACTNUM$2, i);
            if (cTAbstractNum == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum[] getAbstractNumArray() {
        CTAbstractNum[] cTAbstractNumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ABSTRACTNUM$2, arrayList);
            cTAbstractNumArr = new CTAbstractNum[arrayList.size()];
            arrayList.toArray(cTAbstractNumArr);
        }
        return cTAbstractNumArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTAbstractNum> getAbstractNumList() {
        1AbstractNumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AbstractNumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum getNumArray(int i) {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().find_element_user(NUM$4, i);
            if (cTNum == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum[] getNumArray() {
        CTNum[] cTNumArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NUM$4, arrayList);
            cTNumArr = new CTNum[arrayList.size()];
            arrayList.toArray(cTNumArr);
        }
        return cTNumArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber getNumIdMacAtCleanup() {
        synchronized (monitor()) {
            check_orphaned();
            CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(NUMIDMACATCLEANUP$6, 0);
            if (cTDecimalNumber == null) {
                return null;
            }
            return cTDecimalNumber;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNum> getNumList() {
        1NumList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NumList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet getNumPicBulletArray(int i) {
        CTNumPicBullet find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(NUMPICBULLET$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet[] getNumPicBulletArray() {
        CTNumPicBullet[] cTNumPicBulletArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NUMPICBULLET$0, arrayList);
            cTNumPicBulletArr = new CTNumPicBullet[arrayList.size()];
            arrayList.toArray(cTNumPicBulletArr);
        }
        return cTNumPicBulletArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNumPicBullet> getNumPicBulletList() {
        1NumPicBulletList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1NumPicBulletList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum insertNewAbstractNum(int i) {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().insert_element_user(ABSTRACTNUM$2, i);
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum insertNewNum(int i) {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().insert_element_user(NUM$4, i);
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet insertNewNumPicBullet(int i) {
        CTNumPicBullet insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(NUMPICBULLET$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public boolean isSetNumIdMacAtCleanup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NUMIDMACATCLEANUP$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeAbstractNum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ABSTRACTNUM$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNum(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUM$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNumPicBullet(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMPICBULLET$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(int i, CTAbstractNum cTAbstractNum) {
        synchronized (monitor()) {
            check_orphaned();
            CTAbstractNum cTAbstractNum2 = (CTAbstractNum) get_store().find_element_user(ABSTRACTNUM$2, i);
            if (cTAbstractNum2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTAbstractNum2.set(cTAbstractNum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAbstractNumArr, ABSTRACTNUM$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(int i, CTNum cTNum) {
        synchronized (monitor()) {
            check_orphaned();
            CTNum cTNum2 = (CTNum) get_store().find_element_user(NUM$4, i);
            if (cTNum2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTNum2.set(cTNum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(CTNum[] cTNumArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNumArr, NUM$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = NUMIDMACATCLEANUP$6;
            CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
            if (cTDecimalNumber2 == null) {
                cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
            }
            cTDecimalNumber2.set(cTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(int i, CTNumPicBullet cTNumPicBullet) {
        synchronized (monitor()) {
            check_orphaned();
            CTNumPicBullet find_element_user = get_store().find_element_user(NUMPICBULLET$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTNumPicBullet);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNumPicBulletArr, NUMPICBULLET$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfAbstractNumArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ABSTRACTNUM$2);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NUM$4);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumPicBulletArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(NUMPICBULLET$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void unsetNumIdMacAtCleanup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NUMIDMACATCLEANUP$6, 0);
        }
    }
}

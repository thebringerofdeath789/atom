package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAttr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr;

/* loaded from: classes6.dex */
public class CTSmartTagPrImpl extends XmlComplexContentImpl implements CTSmartTagPr {
    private static final QName ATTR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "attr");

    public CTSmartTagPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr addNewAttr() {
        CTAttr add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(ATTR$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr getAttrArray(int i) {
        CTAttr find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(ATTR$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr[] getAttrArray() {
        CTAttr[] cTAttrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ATTR$0, arrayList);
            cTAttrArr = new CTAttr[arrayList.size()];
            arrayList.toArray(cTAttrArr);
        }
        return cTAttrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public List<CTAttr> getAttrList() {
        1AttrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1AttrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public CTAttr insertNewAttr(int i) {
        CTAttr insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(ATTR$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void removeAttr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ATTR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void setAttrArray(int i, CTAttr cTAttr) {
        synchronized (monitor()) {
            check_orphaned();
            CTAttr find_element_user = get_store().find_element_user(ATTR$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTAttr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public void setAttrArray(CTAttr[] cTAttrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAttrArr, ATTR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagPr
    public int sizeOfAttrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(ATTR$0);
        }
        return count_elements;
    }
}

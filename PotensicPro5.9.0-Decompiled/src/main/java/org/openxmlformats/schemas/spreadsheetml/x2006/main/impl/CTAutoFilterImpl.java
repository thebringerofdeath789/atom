package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilterColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

/* loaded from: classes6.dex */
public class CTAutoFilterImpl extends XmlComplexContentImpl implements CTAutoFilter {
    private static final QName FILTERCOLUMN$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "filterColumn");
    private static final QName SORTSTATE$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortState");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
    private static final QName REF$6 = new QName("", "ref");

    public CTAutoFilterImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn addNewFilterColumn() {
        CTFilterColumn add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(FILTERCOLUMN$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTSortState addNewSortState() {
        CTSortState add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(SORTSTATE$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn getFilterColumnArray(int i) {
        CTFilterColumn find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(FILTERCOLUMN$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn[] getFilterColumnArray() {
        CTFilterColumn[] cTFilterColumnArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FILTERCOLUMN$0, arrayList);
            cTFilterColumnArr = new CTFilterColumn[arrayList.size()];
            arrayList.toArray(cTFilterColumnArr);
        }
        return cTFilterColumnArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public List<CTFilterColumn> getFilterColumnList() {
        1FilterColumnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FilterColumnList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public String getRef() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REF$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTSortState getSortState() {
        synchronized (monitor()) {
            check_orphaned();
            CTSortState find_element_user = get_store().find_element_user(SORTSTATE$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public CTFilterColumn insertNewFilterColumn(int i) {
        CTFilterColumn insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(FILTERCOLUMN$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REF$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public boolean isSetSortState() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SORTSTATE$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void removeFilterColumn(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILTERCOLUMN$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$4;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setFilterColumnArray(int i, CTFilterColumn cTFilterColumn) {
        synchronized (monitor()) {
            check_orphaned();
            CTFilterColumn find_element_user = get_store().find_element_user(FILTERCOLUMN$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTFilterColumn);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setFilterColumnArray(CTFilterColumn[] cTFilterColumnArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFilterColumnArr, FILTERCOLUMN$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setRef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void setSortState(CTSortState cTSortState) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SORTSTATE$2;
            CTSortState find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTSortState) get_store().add_element_user(qName);
            }
            find_element_user.set(cTSortState);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public int sizeOfFilterColumnArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FILTERCOLUMN$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REF$6);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void unsetSortState() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SORTSTATE$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public STRef xgetRef() {
        STRef sTRef;
        synchronized (monitor()) {
            check_orphaned();
            sTRef = (STRef) get_store().find_attribute_user(REF$6);
        }
        return sTRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter
    public void xsetRef(STRef sTRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = REF$6;
            STRef sTRef2 = (STRef) typeStore.find_attribute_user(qName);
            if (sTRef2 == null) {
                sTRef2 = (STRef) get_store().add_attribute_user(qName);
            }
            sTRef2.set(sTRef);
        }
    }
}

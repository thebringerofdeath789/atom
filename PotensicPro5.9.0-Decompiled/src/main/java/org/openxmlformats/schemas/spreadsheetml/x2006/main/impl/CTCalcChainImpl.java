package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

/* loaded from: classes6.dex */
public class CTCalcChainImpl extends XmlComplexContentImpl implements CTCalcChain {
    private static final QName C$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "c");
    private static final QName EXTLST$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTCalcChainImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell addNewC() {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().add_element_user(C$0);
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell getCArray(int i) {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().find_element_user(C$0, i);
            if (cTCalcCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell[] getCArray() {
        CTCalcCell[] cTCalcCellArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(C$0, arrayList);
            cTCalcCellArr = new CTCalcCell[arrayList.size()];
            arrayList.toArray(cTCalcCellArr);
        }
        return cTCalcCellArr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public List<CTCalcCell> getCList() {
        1CList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell insertNewC(int i) {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().insert_element_user(C$0, i);
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void removeC(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(C$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setCArray(int i, CTCalcCell cTCalcCell) {
        synchronized (monitor()) {
            check_orphaned();
            CTCalcCell cTCalcCell2 = (CTCalcCell) get_store().find_element_user(C$0, i);
            if (cTCalcCell2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTCalcCell2.set(cTCalcCell);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setCArray(CTCalcCell[] cTCalcCellArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCalcCellArr, C$0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$2;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public int sizeOfCArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(C$0);
        }
        return count_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }
}

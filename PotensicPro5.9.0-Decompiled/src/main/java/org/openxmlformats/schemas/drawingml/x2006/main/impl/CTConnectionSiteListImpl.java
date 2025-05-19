package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;

/* loaded from: classes5.dex */
public class CTConnectionSiteListImpl extends XmlComplexContentImpl implements CTConnectionSiteList {
    private static final QName CXN$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cxn");

    public CTConnectionSiteListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite addNewCxn() {
        CTConnectionSite add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(CXN$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite getCxnArray(int i) {
        CTConnectionSite find_element_user;
        synchronized (monitor()) {
            check_orphaned();
            find_element_user = get_store().find_element_user(CXN$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return find_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite[] getCxnArray() {
        CTConnectionSite[] cTConnectionSiteArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CXN$0, arrayList);
            cTConnectionSiteArr = new CTConnectionSite[arrayList.size()];
            arrayList.toArray(cTConnectionSiteArr);
        }
        return cTConnectionSiteArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public List<CTConnectionSite> getCxnList() {
        1CxnList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1CxnList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite insertNewCxn(int i) {
        CTConnectionSite insert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            insert_element_user = get_store().insert_element_user(CXN$0, i);
        }
        return insert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void removeCxn(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CXN$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void setCxnArray(int i, CTConnectionSite cTConnectionSite) {
        synchronized (monitor()) {
            check_orphaned();
            CTConnectionSite find_element_user = get_store().find_element_user(CXN$0, i);
            if (find_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
            find_element_user.set(cTConnectionSite);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void setCxnArray(CTConnectionSite[] cTConnectionSiteArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTConnectionSiteArr, CXN$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public int sizeOfCxnArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(CXN$0);
        }
        return count_elements;
    }
}

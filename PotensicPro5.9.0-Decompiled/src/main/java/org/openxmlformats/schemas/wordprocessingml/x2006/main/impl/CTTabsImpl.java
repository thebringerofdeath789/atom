package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;

/* loaded from: classes6.dex */
public class CTTabsImpl extends XmlComplexContentImpl implements CTTabs {
    private static final QName TAB$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab");

    public CTTabsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop addNewTab() {
        CTTabStop cTTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStop = (CTTabStop) get_store().add_element_user(TAB$0);
        }
        return cTTabStop;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop getTabArray(int i) {
        CTTabStop cTTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStop = (CTTabStop) get_store().find_element_user(TAB$0, i);
            if (cTTabStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTabStop;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop[] getTabArray() {
        CTTabStop[] cTTabStopArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TAB$0, arrayList);
            cTTabStopArr = new CTTabStop[arrayList.size()];
            arrayList.toArray(cTTabStopArr);
        }
        return cTTabStopArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public List<CTTabStop> getTabList() {
        1TabList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1TabList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop insertNewTab(int i) {
        CTTabStop cTTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStop = (CTTabStop) get_store().insert_element_user(TAB$0, i);
        }
        return cTTabStop;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void removeTab(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TAB$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void setTabArray(int i, CTTabStop cTTabStop) {
        synchronized (monitor()) {
            check_orphaned();
            CTTabStop cTTabStop2 = (CTTabStop) get_store().find_element_user(TAB$0, i);
            if (cTTabStop2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTTabStop2.set(cTTabStop);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void setTabArray(CTTabStop[] cTTabStopArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTabStopArr, TAB$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public int sizeOfTabArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(TAB$0);
        }
        return count_elements;
    }
}

package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;

/* loaded from: classes6.dex */
public class CTSlideMasterIdListImpl extends XmlComplexContentImpl implements CTSlideMasterIdList {
    private static final QName SLDMASTERID$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldMasterId");

    public CTSlideMasterIdListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry addNewSldMasterId() {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().add_element_user(SLDMASTERID$0);
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry getSldMasterIdArray(int i) {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().find_element_user(SLDMASTERID$0, i);
            if (cTSlideMasterIdListEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry[] getSldMasterIdArray() {
        CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SLDMASTERID$0, arrayList);
            cTSlideMasterIdListEntryArr = new CTSlideMasterIdListEntry[arrayList.size()];
            arrayList.toArray(cTSlideMasterIdListEntryArr);
        }
        return cTSlideMasterIdListEntryArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public List<CTSlideMasterIdListEntry> getSldMasterIdList() {
        1SldMasterIdList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1SldMasterIdList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public CTSlideMasterIdListEntry insertNewSldMasterId(int i) {
        CTSlideMasterIdListEntry cTSlideMasterIdListEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideMasterIdListEntry = (CTSlideMasterIdListEntry) get_store().insert_element_user(SLDMASTERID$0, i);
        }
        return cTSlideMasterIdListEntry;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void removeSldMasterId(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDMASTERID$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void setSldMasterIdArray(int i, CTSlideMasterIdListEntry cTSlideMasterIdListEntry) {
        synchronized (monitor()) {
            check_orphaned();
            CTSlideMasterIdListEntry cTSlideMasterIdListEntry2 = (CTSlideMasterIdListEntry) get_store().find_element_user(SLDMASTERID$0, i);
            if (cTSlideMasterIdListEntry2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTSlideMasterIdListEntry2.set(cTSlideMasterIdListEntry);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public void setSldMasterIdArray(CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSlideMasterIdListEntryArr, SLDMASTERID$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList
    public int sizeOfSldMasterIdArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(SLDMASTERID$0);
        }
        return count_elements;
    }
}

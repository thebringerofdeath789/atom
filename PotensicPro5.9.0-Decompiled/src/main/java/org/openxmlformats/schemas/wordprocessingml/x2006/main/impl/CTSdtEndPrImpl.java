package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;

/* loaded from: classes6.dex */
public class CTSdtEndPrImpl extends XmlComplexContentImpl implements CTSdtEndPr {
    private static final QName RPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");

    public CTSdtEndPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(RPR$0);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public CTRPr getRPrArray(int i) {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().find_element_user(RPR$0, i);
            if (cTRPr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public CTRPr[] getRPrArray() {
        CTRPr[] cTRPrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RPR$0, arrayList);
            cTRPrArr = new CTRPr[arrayList.size()];
            arrayList.toArray(cTRPrArr);
        }
        return cTRPrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public List<CTRPr> getRPrList() {
        1RPrList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1RPrList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public CTRPr insertNewRPr(int i) {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().insert_element_user(RPR$0, i);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public void removeRPr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public void setRPrArray(int i, CTRPr cTRPr) {
        synchronized (monitor()) {
            check_orphaned();
            CTRPr cTRPr2 = (CTRPr) get_store().find_element_user(RPR$0, i);
            if (cTRPr2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTRPr2.set(cTRPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public void setRPrArray(CTRPr[] cTRPrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRPrArr, RPR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr
    public int sizeOfRPrArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(RPR$0);
        }
        return count_elements;
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;

/* loaded from: classes6.dex */
public class CTFootnotesImpl extends XmlComplexContentImpl implements CTFootnotes {
    private static final QName FOOTNOTE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnote");

    public CTFootnotesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public CTFtnEdn addNewFootnote() {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().add_element_user(FOOTNOTE$0);
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public CTFtnEdn getFootnoteArray(int i) {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().find_element_user(FOOTNOTE$0, i);
            if (cTFtnEdn == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public CTFtnEdn[] getFootnoteArray() {
        CTFtnEdn[] cTFtnEdnArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FOOTNOTE$0, arrayList);
            cTFtnEdnArr = new CTFtnEdn[arrayList.size()];
            arrayList.toArray(cTFtnEdnArr);
        }
        return cTFtnEdnArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public List<CTFtnEdn> getFootnoteList() {
        1FootnoteList r1;
        synchronized (monitor()) {
            check_orphaned();
            r1 = new 1FootnoteList(this);
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public CTFtnEdn insertNewFootnote(int i) {
        CTFtnEdn cTFtnEdn;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdn = (CTFtnEdn) get_store().insert_element_user(FOOTNOTE$0, i);
        }
        return cTFtnEdn;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public void removeFootnote(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FOOTNOTE$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public void setFootnoteArray(int i, CTFtnEdn cTFtnEdn) {
        synchronized (monitor()) {
            check_orphaned();
            CTFtnEdn cTFtnEdn2 = (CTFtnEdn) get_store().find_element_user(FOOTNOTE$0, i);
            if (cTFtnEdn2 == null) {
                throw new IndexOutOfBoundsException();
            }
            cTFtnEdn2.set(cTFtnEdn);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public void setFootnoteArray(CTFtnEdn[] cTFtnEdnArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFtnEdnArr, FOOTNOTE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes
    public int sizeOfFootnoteArray() {
        int count_elements;
        synchronized (monitor()) {
            check_orphaned();
            count_elements = get_store().count_elements(FOOTNOTE$0);
        }
        return count_elements;
    }
}

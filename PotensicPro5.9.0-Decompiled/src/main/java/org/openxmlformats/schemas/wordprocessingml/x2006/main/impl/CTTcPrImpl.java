package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrChange;

/* loaded from: classes6.dex */
public class CTTcPrImpl extends CTTcPrInnerImpl implements CTTcPr {
    private static final QName TCPRCHANGE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPrChange");

    public CTTcPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public CTTcPrChange addNewTcPrChange() {
        CTTcPrChange add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TCPRCHANGE$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public CTTcPrChange getTcPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            CTTcPrChange find_element_user = get_store().find_element_user(TCPRCHANGE$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public boolean isSetTcPrChange() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TCPRCHANGE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public void setTcPrChange(CTTcPrChange cTTcPrChange) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TCPRCHANGE$0;
            CTTcPrChange find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTTcPrChange) get_store().add_element_user(qName);
            }
            find_element_user.set(cTTcPrChange);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr
    public void unsetTcPrChange() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TCPRCHANGE$0, 0);
        }
    }
}

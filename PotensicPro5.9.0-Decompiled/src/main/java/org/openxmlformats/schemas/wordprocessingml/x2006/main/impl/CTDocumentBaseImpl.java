package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBackground;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase;

/* loaded from: classes6.dex */
public class CTDocumentBaseImpl extends XmlComplexContentImpl implements CTDocumentBase {
    private static final QName BACKGROUND$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "background");

    public CTDocumentBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public CTBackground addNewBackground() {
        CTBackground add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(BACKGROUND$0);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public CTBackground getBackground() {
        synchronized (monitor()) {
            check_orphaned();
            CTBackground find_element_user = get_store().find_element_user(BACKGROUND$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public boolean isSetBackground() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BACKGROUND$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public void setBackground(CTBackground cTBackground) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BACKGROUND$0;
            CTBackground find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTBackground) get_store().add_element_user(qName);
            }
            find_element_user.set(cTBackground);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocumentBase
    public void unsetBackground() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BACKGROUND$0, 0);
        }
    }
}

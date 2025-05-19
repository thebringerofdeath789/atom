package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDdeLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalBook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleLink;

/* loaded from: classes6.dex */
public class CTExternalLinkImpl extends XmlComplexContentImpl implements CTExternalLink {
    private static final QName EXTERNALBOOK$0 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalBook");
    private static final QName DDELINK$2 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ddeLink");
    private static final QName OLELINK$4 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleLink");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");

    public CTExternalLinkImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTDdeLink addNewDdeLink() {
        CTDdeLink add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(DDELINK$2);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTExtensionList addNewExtLst() {
        CTExtensionList add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(EXTLST$6);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTExternalBook addNewExternalBook() {
        CTExternalBook cTExternalBook;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalBook = (CTExternalBook) get_store().add_element_user(EXTERNALBOOK$0);
        }
        return cTExternalBook;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTOleLink addNewOleLink() {
        CTOleLink add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OLELINK$4);
        }
        return add_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTDdeLink getDdeLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTDdeLink find_element_user = get_store().find_element_user(DDELINK$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            CTExtensionList find_element_user = get_store().find_element_user(EXTLST$6, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTExternalBook getExternalBook() {
        synchronized (monitor()) {
            check_orphaned();
            CTExternalBook cTExternalBook = (CTExternalBook) get_store().find_element_user(EXTERNALBOOK$0, 0);
            if (cTExternalBook == null) {
                return null;
            }
            return cTExternalBook;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public CTOleLink getOleLink() {
        synchronized (monitor()) {
            check_orphaned();
            CTOleLink find_element_user = get_store().find_element_user(OLELINK$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public boolean isSetDdeLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DDELINK$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public boolean isSetExternalBook() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTERNALBOOK$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public boolean isSetOleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OLELINK$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void setDdeLink(CTDdeLink cTDdeLink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DDELINK$2;
            CTDdeLink find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTDdeLink) get_store().add_element_user(qName);
            }
            find_element_user.set(cTDdeLink);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTLST$6;
            CTExtensionList find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTExtensionList) get_store().add_element_user(qName);
            }
            find_element_user.set(cTExtensionList);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void setExternalBook(CTExternalBook cTExternalBook) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = EXTERNALBOOK$0;
            CTExternalBook cTExternalBook2 = (CTExternalBook) typeStore.find_element_user(qName, 0);
            if (cTExternalBook2 == null) {
                cTExternalBook2 = (CTExternalBook) get_store().add_element_user(qName);
            }
            cTExternalBook2.set(cTExternalBook);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void setOleLink(CTOleLink cTOleLink) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OLELINK$4;
            CTOleLink find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (CTOleLink) get_store().add_element_user(qName);
            }
            find_element_user.set(cTOleLink);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void unsetDdeLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DDELINK$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void unsetExternalBook() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTERNALBOOK$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink
    public void unsetOleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OLELINK$4, 0);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;

/* loaded from: classes6.dex */
public class CTSdtDocPartImpl extends XmlComplexContentImpl implements CTSdtDocPart {
    private static final QName DOCPARTGALLERY$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartGallery");
    private static final QName DOCPARTCATEGORY$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartCategory");
    private static final QName DOCPARTUNIQUE$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "docPartUnique");

    public CTSdtDocPartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public CTString addNewDocPartCategory() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(DOCPARTCATEGORY$2);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public CTString addNewDocPartGallery() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(DOCPARTGALLERY$0);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public CTOnOff addNewDocPartUnique() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(DOCPARTUNIQUE$4);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public CTString getDocPartCategory() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(DOCPARTCATEGORY$2, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public CTString getDocPartGallery() {
        synchronized (monitor()) {
            check_orphaned();
            CTString cTString = (CTString) get_store().find_element_user(DOCPARTGALLERY$0, 0);
            if (cTString == null) {
                return null;
            }
            return cTString;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public CTOnOff getDocPartUnique() {
        synchronized (monitor()) {
            check_orphaned();
            CTOnOff cTOnOff = (CTOnOff) get_store().find_element_user(DOCPARTUNIQUE$4, 0);
            if (cTOnOff == null) {
                return null;
            }
            return cTOnOff;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public boolean isSetDocPartCategory() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCPARTCATEGORY$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public boolean isSetDocPartGallery() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCPARTGALLERY$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public boolean isSetDocPartUnique() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(DOCPARTUNIQUE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public void setDocPartCategory(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCPARTCATEGORY$2;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public void setDocPartGallery(CTString cTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCPARTGALLERY$0;
            CTString cTString2 = (CTString) typeStore.find_element_user(qName, 0);
            if (cTString2 == null) {
                cTString2 = (CTString) get_store().add_element_user(qName);
            }
            cTString2.set(cTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public void setDocPartUnique(CTOnOff cTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DOCPARTUNIQUE$4;
            CTOnOff cTOnOff2 = (CTOnOff) typeStore.find_element_user(qName, 0);
            if (cTOnOff2 == null) {
                cTOnOff2 = (CTOnOff) get_store().add_element_user(qName);
            }
            cTOnOff2.set(cTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public void unsetDocPartCategory() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTCATEGORY$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public void unsetDocPartGallery() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTGALLERY$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDocPart
    public void unsetDocPartUnique() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DOCPARTUNIQUE$4, 0);
        }
    }
}

package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtEndPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

/* loaded from: classes6.dex */
public class CTSdtRunImpl extends XmlComplexContentImpl implements CTSdtRun {
    private static final QName SDTPR$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtPr");
    private static final QName SDTENDPR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtEndPr");
    private static final QName SDTCONTENT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdtContent");

    public CTSdtRunImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public CTSdtContentRun addNewSdtContent() {
        CTSdtContentRun cTSdtContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtContentRun = (CTSdtContentRun) get_store().add_element_user(SDTCONTENT$4);
        }
        return cTSdtContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public CTSdtEndPr addNewSdtEndPr() {
        CTSdtEndPr cTSdtEndPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtEndPr = (CTSdtEndPr) get_store().add_element_user(SDTENDPR$2);
        }
        return cTSdtEndPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public CTSdtPr addNewSdtPr() {
        CTSdtPr cTSdtPr;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtPr = (CTSdtPr) get_store().add_element_user(SDTPR$0);
        }
        return cTSdtPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public CTSdtContentRun getSdtContent() {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtContentRun cTSdtContentRun = (CTSdtContentRun) get_store().find_element_user(SDTCONTENT$4, 0);
            if (cTSdtContentRun == null) {
                return null;
            }
            return cTSdtContentRun;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public CTSdtEndPr getSdtEndPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtEndPr cTSdtEndPr = (CTSdtEndPr) get_store().find_element_user(SDTENDPR$2, 0);
            if (cTSdtEndPr == null) {
                return null;
            }
            return cTSdtEndPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public CTSdtPr getSdtPr() {
        synchronized (monitor()) {
            check_orphaned();
            CTSdtPr cTSdtPr = (CTSdtPr) get_store().find_element_user(SDTPR$0, 0);
            if (cTSdtPr == null) {
                return null;
            }
            return cTSdtPr;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public boolean isSetSdtContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SDTCONTENT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public boolean isSetSdtEndPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SDTENDPR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public boolean isSetSdtPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SDTPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public void setSdtContent(CTSdtContentRun cTSdtContentRun) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SDTCONTENT$4;
            CTSdtContentRun cTSdtContentRun2 = (CTSdtContentRun) typeStore.find_element_user(qName, 0);
            if (cTSdtContentRun2 == null) {
                cTSdtContentRun2 = (CTSdtContentRun) get_store().add_element_user(qName);
            }
            cTSdtContentRun2.set(cTSdtContentRun);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public void setSdtEndPr(CTSdtEndPr cTSdtEndPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SDTENDPR$2;
            CTSdtEndPr cTSdtEndPr2 = (CTSdtEndPr) typeStore.find_element_user(qName, 0);
            if (cTSdtEndPr2 == null) {
                cTSdtEndPr2 = (CTSdtEndPr) get_store().add_element_user(qName);
            }
            cTSdtEndPr2.set(cTSdtEndPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public void setSdtPr(CTSdtPr cTSdtPr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SDTPR$0;
            CTSdtPr cTSdtPr2 = (CTSdtPr) typeStore.find_element_user(qName, 0);
            if (cTSdtPr2 == null) {
                cTSdtPr2 = (CTSdtPr) get_store().add_element_user(qName);
            }
            cTSdtPr2.set(cTSdtPr);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public void unsetSdtContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDTCONTENT$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public void unsetSdtEndPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDTENDPR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun
    public void unsetSdtPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDTPR$0, 0);
        }
    }
}

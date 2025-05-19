package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import aavax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;

/* loaded from: classes6.dex */
public class CTDocDefaultsImpl extends XmlComplexContentImpl implements CTDocDefaults {
    private static final QName RPRDEFAULT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPrDefault");
    private static final QName PPRDEFAULT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPrDefault");

    public CTDocDefaultsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTPPrDefault addNewPPrDefault() {
        CTPPrDefault cTPPrDefault;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrDefault = (CTPPrDefault) get_store().add_element_user(PPRDEFAULT$2);
        }
        return cTPPrDefault;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTRPrDefault addNewRPrDefault() {
        CTRPrDefault cTRPrDefault;
        synchronized (monitor()) {
            check_orphaned();
            cTRPrDefault = (CTRPrDefault) get_store().add_element_user(RPRDEFAULT$0);
        }
        return cTRPrDefault;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTPPrDefault getPPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            CTPPrDefault cTPPrDefault = (CTPPrDefault) get_store().find_element_user(PPRDEFAULT$2, 0);
            if (cTPPrDefault == null) {
                return null;
            }
            return cTPPrDefault;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public CTRPrDefault getRPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            CTRPrDefault cTRPrDefault = (CTRPrDefault) get_store().find_element_user(RPRDEFAULT$0, 0);
            if (cTRPrDefault == null) {
                return null;
            }
            return cTRPrDefault;
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public boolean isSetPPrDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPRDEFAULT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public boolean isSetRPrDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RPRDEFAULT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void setPPrDefault(CTPPrDefault cTPPrDefault) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = PPRDEFAULT$2;
            CTPPrDefault cTPPrDefault2 = (CTPPrDefault) typeStore.find_element_user(qName, 0);
            if (cTPPrDefault2 == null) {
                cTPPrDefault2 = (CTPPrDefault) get_store().add_element_user(qName);
            }
            cTPPrDefault2.set(cTPPrDefault);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void setRPrDefault(CTRPrDefault cTRPrDefault) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = RPRDEFAULT$0;
            CTRPrDefault cTRPrDefault2 = (CTRPrDefault) typeStore.find_element_user(qName, 0);
            if (cTRPrDefault2 == null) {
                cTRPrDefault2 = (CTRPrDefault) get_store().add_element_user(qName);
            }
            cTRPrDefault2.set(cTRPrDefault);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void unsetPPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPRDEFAULT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults
    public void unsetRPrDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RPRDEFAULT$0, 0);
        }
    }
}

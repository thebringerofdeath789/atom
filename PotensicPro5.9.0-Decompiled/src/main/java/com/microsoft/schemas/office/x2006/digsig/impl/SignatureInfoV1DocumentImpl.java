package com.microsoft.schemas.office.x2006.digsig.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class SignatureInfoV1DocumentImpl extends XmlComplexContentImpl implements SignatureInfoV1Document {
    private static final QName SIGNATUREINFOV1$0 = new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureInfoV1");

    public SignatureInfoV1DocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document
    public CTSignatureInfoV1 addNewSignatureInfoV1() {
        CTSignatureInfoV1 cTSignatureInfoV1;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureInfoV1 = (CTSignatureInfoV1) get_store().add_element_user(SIGNATUREINFOV1$0);
        }
        return cTSignatureInfoV1;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document
    public CTSignatureInfoV1 getSignatureInfoV1() {
        synchronized (monitor()) {
            check_orphaned();
            CTSignatureInfoV1 cTSignatureInfoV1 = (CTSignatureInfoV1) get_store().find_element_user(SIGNATUREINFOV1$0, 0);
            if (cTSignatureInfoV1 == null) {
                return null;
            }
            return cTSignatureInfoV1;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document
    public void setSignatureInfoV1(CTSignatureInfoV1 cTSignatureInfoV1) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATUREINFOV1$0;
            CTSignatureInfoV1 cTSignatureInfoV12 = (CTSignatureInfoV1) typeStore.find_element_user(qName, 0);
            if (cTSignatureInfoV12 == null) {
                cTSignatureInfoV12 = (CTSignatureInfoV1) get_store().add_element_user(qName);
            }
            cTSignatureInfoV12.set(cTSignatureInfoV1);
        }
    }
}

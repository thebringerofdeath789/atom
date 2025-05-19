package org.w3.x2000.x09.xmldsig.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.SignatureDocument;
import org.w3.x2000.x09.xmldsig.SignatureType;

/* loaded from: classes6.dex */
public class SignatureDocumentImpl extends XmlComplexContentImpl implements SignatureDocument {
    private static final QName SIGNATURE$0 = new QName(SignatureFacet.XML_DIGSIG_NS, "Signature");

    public SignatureDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureDocument
    public SignatureType addNewSignature() {
        SignatureType signatureType;
        synchronized (monitor()) {
            check_orphaned();
            signatureType = (SignatureType) get_store().add_element_user(SIGNATURE$0);
        }
        return signatureType;
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureDocument
    public SignatureType getSignature() {
        synchronized (monitor()) {
            check_orphaned();
            SignatureType signatureType = (SignatureType) get_store().find_element_user(SIGNATURE$0, 0);
            if (signatureType == null) {
                return null;
            }
            return signatureType;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.SignatureDocument
    public void setSignature(SignatureType signatureType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNATURE$0;
            SignatureType signatureType2 = (SignatureType) typeStore.find_element_user(qName, 0);
            if (signatureType2 == null) {
                signatureType2 = (SignatureType) get_store().add_element_user(qName);
            }
            signatureType2.set(signatureType);
        }
    }
}

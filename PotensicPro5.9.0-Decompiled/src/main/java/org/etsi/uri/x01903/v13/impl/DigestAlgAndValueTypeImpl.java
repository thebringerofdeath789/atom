package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.w3.x2000.x09.xmldsig.DigestMethodType;
import org.w3.x2000.x09.xmldsig.DigestValueType;

/* loaded from: classes5.dex */
public class DigestAlgAndValueTypeImpl extends XmlComplexContentImpl implements DigestAlgAndValueType {
    private static final QName DIGESTMETHOD$0 = new QName(SignatureFacet.XML_DIGSIG_NS, "DigestMethod");
    private static final QName DIGESTVALUE$2 = new QName(SignatureFacet.XML_DIGSIG_NS, "DigestValue");

    public DigestAlgAndValueTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public DigestMethodType addNewDigestMethod() {
        DigestMethodType digestMethodType;
        synchronized (monitor()) {
            check_orphaned();
            digestMethodType = (DigestMethodType) get_store().add_element_user(DIGESTMETHOD$0);
        }
        return digestMethodType;
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public DigestMethodType getDigestMethod() {
        synchronized (monitor()) {
            check_orphaned();
            DigestMethodType digestMethodType = (DigestMethodType) get_store().find_element_user(DIGESTMETHOD$0, 0);
            if (digestMethodType == null) {
                return null;
            }
            return digestMethodType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public byte[] getDigestValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DIGESTVALUE$2, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public void setDigestMethod(DigestMethodType digestMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTMETHOD$0;
            DigestMethodType digestMethodType2 = (DigestMethodType) typeStore.find_element_user(qName, 0);
            if (digestMethodType2 == null) {
                digestMethodType2 = (DigestMethodType) get_store().add_element_user(qName);
            }
            digestMethodType2.set(digestMethodType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public void setDigestValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public DigestValueType xgetDigestValue() {
        DigestValueType digestValueType;
        synchronized (monitor()) {
            check_orphaned();
            digestValueType = (DigestValueType) get_store().find_element_user(DIGESTVALUE$2, 0);
        }
        return digestValueType;
    }

    @Override // org.etsi.uri.x01903.v13.DigestAlgAndValueType
    public void xsetDigestValue(DigestValueType digestValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$2;
            DigestValueType digestValueType2 = (DigestValueType) typeStore.find_element_user(qName, 0);
            if (digestValueType2 == null) {
                digestValueType2 = (DigestValueType) get_store().add_element_user(qName);
            }
            digestValueType2.set(digestValueType);
        }
    }
}

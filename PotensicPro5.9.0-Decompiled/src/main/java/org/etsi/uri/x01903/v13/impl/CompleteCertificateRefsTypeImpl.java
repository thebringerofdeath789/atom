package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertIDListType;
import org.etsi.uri.x01903.v13.CompleteCertificateRefsType;

/* loaded from: classes5.dex */
public class CompleteCertificateRefsTypeImpl extends XmlComplexContentImpl implements CompleteCertificateRefsType {
    private static final QName CERTREFS$0 = new QName(SignatureFacet.XADES_132_NS, "CertRefs");
    private static final QName ID$2 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);

    public CompleteCertificateRefsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public CertIDListType addNewCertRefs() {
        CertIDListType certIDListType;
        synchronized (monitor()) {
            check_orphaned();
            certIDListType = (CertIDListType) get_store().add_element_user(CERTREFS$0);
        }
        return certIDListType;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public CertIDListType getCertRefs() {
        synchronized (monitor()) {
            check_orphaned();
            CertIDListType certIDListType = (CertIDListType) get_store().find_element_user(CERTREFS$0, 0);
            if (certIDListType == null) {
                return null;
            }
            return certIDListType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void setCertRefs(CertIDListType certIDListType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CERTREFS$0;
            CertIDListType certIDListType2 = (CertIDListType) typeStore.find_element_user(qName, 0);
            if (certIDListType2 == null) {
                certIDListType2 = (CertIDListType) get_store().add_element_user(qName);
            }
            certIDListType2.set(certIDListType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$2);
        }
        return xmlID;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteCertificateRefsType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$2;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }
}

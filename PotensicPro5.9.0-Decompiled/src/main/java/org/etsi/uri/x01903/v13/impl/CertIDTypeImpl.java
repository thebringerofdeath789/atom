package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CertIDType;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;

/* loaded from: classes5.dex */
public class CertIDTypeImpl extends XmlComplexContentImpl implements CertIDType {
    private static final QName CERTDIGEST$0 = new QName(SignatureFacet.XADES_132_NS, "CertDigest");
    private static final QName ISSUERSERIAL$2 = new QName(SignatureFacet.XADES_132_NS, "IssuerSerial");
    private static final QName URI$4 = new QName("", "URI");

    public CertIDTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public DigestAlgAndValueType addNewCertDigest() {
        DigestAlgAndValueType digestAlgAndValueType;
        synchronized (monitor()) {
            check_orphaned();
            digestAlgAndValueType = (DigestAlgAndValueType) get_store().add_element_user(CERTDIGEST$0);
        }
        return digestAlgAndValueType;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public X509IssuerSerialType addNewIssuerSerial() {
        X509IssuerSerialType x509IssuerSerialType;
        synchronized (monitor()) {
            check_orphaned();
            x509IssuerSerialType = (X509IssuerSerialType) get_store().add_element_user(ISSUERSERIAL$2);
        }
        return x509IssuerSerialType;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public DigestAlgAndValueType getCertDigest() {
        synchronized (monitor()) {
            check_orphaned();
            DigestAlgAndValueType digestAlgAndValueType = (DigestAlgAndValueType) get_store().find_element_user(CERTDIGEST$0, 0);
            if (digestAlgAndValueType == null) {
                return null;
            }
            return digestAlgAndValueType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public X509IssuerSerialType getIssuerSerial() {
        synchronized (monitor()) {
            check_orphaned();
            X509IssuerSerialType x509IssuerSerialType = (X509IssuerSerialType) get_store().find_element_user(ISSUERSERIAL$2, 0);
            if (x509IssuerSerialType == null) {
                return null;
            }
            return x509IssuerSerialType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void setCertDigest(DigestAlgAndValueType digestAlgAndValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CERTDIGEST$0;
            DigestAlgAndValueType digestAlgAndValueType2 = (DigestAlgAndValueType) typeStore.find_element_user(qName, 0);
            if (digestAlgAndValueType2 == null) {
                digestAlgAndValueType2 = (DigestAlgAndValueType) get_store().add_element_user(qName);
            }
            digestAlgAndValueType2.set(digestAlgAndValueType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void setIssuerSerial(X509IssuerSerialType x509IssuerSerialType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ISSUERSERIAL$2;
            X509IssuerSerialType x509IssuerSerialType2 = (X509IssuerSerialType) typeStore.find_element_user(qName, 0);
            if (x509IssuerSerialType2 == null) {
                x509IssuerSerialType2 = (X509IssuerSerialType) get_store().add_element_user(qName);
            }
            x509IssuerSerialType2.set(x509IssuerSerialType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(URI$4);
        }
        return xmlAnyURI;
    }

    @Override // org.etsi.uri.x01903.v13.CertIDType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}

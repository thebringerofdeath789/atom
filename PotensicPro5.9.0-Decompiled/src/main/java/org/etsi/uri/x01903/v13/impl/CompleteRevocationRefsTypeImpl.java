package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.CRLRefsType;
import org.etsi.uri.x01903.v13.CompleteRevocationRefsType;
import org.etsi.uri.x01903.v13.OCSPRefsType;
import org.etsi.uri.x01903.v13.OtherCertStatusRefsType;

/* loaded from: classes5.dex */
public class CompleteRevocationRefsTypeImpl extends XmlComplexContentImpl implements CompleteRevocationRefsType {
    private static final QName CRLREFS$0 = new QName(SignatureFacet.XADES_132_NS, "CRLRefs");
    private static final QName OCSPREFS$2 = new QName(SignatureFacet.XADES_132_NS, "OCSPRefs");
    private static final QName OTHERREFS$4 = new QName(SignatureFacet.XADES_132_NS, "OtherRefs");
    private static final QName ID$6 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);

    public CompleteRevocationRefsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public CRLRefsType addNewCRLRefs() {
        CRLRefsType cRLRefsType;
        synchronized (monitor()) {
            check_orphaned();
            cRLRefsType = (CRLRefsType) get_store().add_element_user(CRLREFS$0);
        }
        return cRLRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public OCSPRefsType addNewOCSPRefs() {
        OCSPRefsType oCSPRefsType;
        synchronized (monitor()) {
            check_orphaned();
            oCSPRefsType = (OCSPRefsType) get_store().add_element_user(OCSPREFS$2);
        }
        return oCSPRefsType;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public OtherCertStatusRefsType addNewOtherRefs() {
        OtherCertStatusRefsType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(OTHERREFS$4);
        }
        return add_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public CRLRefsType getCRLRefs() {
        synchronized (monitor()) {
            check_orphaned();
            CRLRefsType cRLRefsType = (CRLRefsType) get_store().find_element_user(CRLREFS$0, 0);
            if (cRLRefsType == null) {
                return null;
            }
            return cRLRefsType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$6);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public OCSPRefsType getOCSPRefs() {
        synchronized (monitor()) {
            check_orphaned();
            OCSPRefsType oCSPRefsType = (OCSPRefsType) get_store().find_element_user(OCSPREFS$2, 0);
            if (oCSPRefsType == null) {
                return null;
            }
            return oCSPRefsType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public OtherCertStatusRefsType getOtherRefs() {
        synchronized (monitor()) {
            check_orphaned();
            OtherCertStatusRefsType find_element_user = get_store().find_element_user(OTHERREFS$4, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public boolean isSetCRLRefs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CRLREFS$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public boolean isSetOCSPRefs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OCSPREFS$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public boolean isSetOtherRefs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OTHERREFS$4) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void setCRLRefs(CRLRefsType cRLRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CRLREFS$0;
            CRLRefsType cRLRefsType2 = (CRLRefsType) typeStore.find_element_user(qName, 0);
            if (cRLRefsType2 == null) {
                cRLRefsType2 = (CRLRefsType) get_store().add_element_user(qName);
            }
            cRLRefsType2.set(cRLRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void setOCSPRefs(OCSPRefsType oCSPRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OCSPREFS$2;
            OCSPRefsType oCSPRefsType2 = (OCSPRefsType) typeStore.find_element_user(qName, 0);
            if (oCSPRefsType2 == null) {
                oCSPRefsType2 = (OCSPRefsType) get_store().add_element_user(qName);
            }
            oCSPRefsType2.set(oCSPRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void setOtherRefs(OtherCertStatusRefsType otherCertStatusRefsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = OTHERREFS$4;
            OtherCertStatusRefsType find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (OtherCertStatusRefsType) get_store().add_element_user(qName);
            }
            find_element_user.set(otherCertStatusRefsType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void unsetCRLRefs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CRLREFS$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void unsetOCSPRefs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OCSPREFS$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void unsetOtherRefs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OTHERREFS$4, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$6);
        }
        return xmlID;
    }

    @Override // org.etsi.uri.x01903.v13.CompleteRevocationRefsType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$6;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }
}

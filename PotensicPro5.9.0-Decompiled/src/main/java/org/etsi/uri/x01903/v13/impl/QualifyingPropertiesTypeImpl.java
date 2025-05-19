package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.SignedPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;

/* loaded from: classes5.dex */
public class QualifyingPropertiesTypeImpl extends XmlComplexContentImpl implements QualifyingPropertiesType {
    private static final QName SIGNEDPROPERTIES$0 = new QName(SignatureFacet.XADES_132_NS, "SignedProperties");
    private static final QName UNSIGNEDPROPERTIES$2 = new QName(SignatureFacet.XADES_132_NS, "UnsignedProperties");
    private static final QName TARGET$4 = new QName("", PackageRelationship.TARGET_ATTRIBUTE_NAME);
    private static final QName ID$6 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);

    public QualifyingPropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public SignedPropertiesType addNewSignedProperties() {
        SignedPropertiesType signedPropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            signedPropertiesType = (SignedPropertiesType) get_store().add_element_user(SIGNEDPROPERTIES$0);
        }
        return signedPropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public UnsignedPropertiesType addNewUnsignedProperties() {
        UnsignedPropertiesType unsignedPropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            unsignedPropertiesType = (UnsignedPropertiesType) get_store().add_element_user(UNSIGNEDPROPERTIES$2);
        }
        return unsignedPropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
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

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public SignedPropertiesType getSignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            SignedPropertiesType signedPropertiesType = (SignedPropertiesType) get_store().find_element_user(SIGNEDPROPERTIES$0, 0);
            if (signedPropertiesType == null) {
                return null;
            }
            return signedPropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public String getTarget() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TARGET$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public UnsignedPropertiesType getUnsignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            UnsignedPropertiesType unsignedPropertiesType = (UnsignedPropertiesType) get_store().find_element_user(UNSIGNEDPROPERTIES$2, 0);
            if (unsignedPropertiesType == null) {
                return null;
            }
            return unsignedPropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public boolean isSetSignedProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SIGNEDPROPERTIES$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public boolean isSetUnsignedProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNSIGNEDPROPERTIES$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
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

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setSignedProperties(SignedPropertiesType signedPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SIGNEDPROPERTIES$0;
            SignedPropertiesType signedPropertiesType2 = (SignedPropertiesType) typeStore.find_element_user(qName, 0);
            if (signedPropertiesType2 == null) {
                signedPropertiesType2 = (SignedPropertiesType) get_store().add_element_user(qName);
            }
            signedPropertiesType2.set(signedPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setTarget(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void setUnsignedProperties(UnsignedPropertiesType unsignedPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNSIGNEDPROPERTIES$2;
            UnsignedPropertiesType unsignedPropertiesType2 = (UnsignedPropertiesType) typeStore.find_element_user(qName, 0);
            if (unsignedPropertiesType2 == null) {
                unsignedPropertiesType2 = (UnsignedPropertiesType) get_store().add_element_user(qName);
            }
            unsignedPropertiesType2.set(unsignedPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void unsetSignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SIGNEDPROPERTIES$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void unsetUnsignedProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNSIGNEDPROPERTIES$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$6);
        }
        return xmlID;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public XmlAnyURI xgetTarget() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(TARGET$4);
        }
        return xmlAnyURI;
    }

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
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

    @Override // org.etsi.uri.x01903.v13.QualifyingPropertiesType
    public void xsetTarget(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TARGET$4;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}

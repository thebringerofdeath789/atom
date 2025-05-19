package org.w3.x2000.x09.xmldsig.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.w3.x2000.x09.xmldsig.DigestMethodType;
import org.w3.x2000.x09.xmldsig.DigestValueType;
import org.w3.x2000.x09.xmldsig.ReferenceType;
import org.w3.x2000.x09.xmldsig.TransformsType;

/* loaded from: classes6.dex */
public class ReferenceTypeImpl extends XmlComplexContentImpl implements ReferenceType {
    private static final QName TRANSFORMS$0 = new QName(SignatureFacet.XML_DIGSIG_NS, "Transforms");
    private static final QName DIGESTMETHOD$2 = new QName(SignatureFacet.XML_DIGSIG_NS, "DigestMethod");
    private static final QName DIGESTVALUE$4 = new QName(SignatureFacet.XML_DIGSIG_NS, "DigestValue");
    private static final QName ID$6 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);
    private static final QName URI$8 = new QName("", "URI");
    private static final QName TYPE$10 = new QName("", PackageRelationship.TYPE_ATTRIBUTE_NAME);

    public ReferenceTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public DigestMethodType addNewDigestMethod() {
        DigestMethodType digestMethodType;
        synchronized (monitor()) {
            check_orphaned();
            digestMethodType = (DigestMethodType) get_store().add_element_user(DIGESTMETHOD$2);
        }
        return digestMethodType;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public TransformsType addNewTransforms() {
        TransformsType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(TRANSFORMS$0);
        }
        return add_element_user;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public DigestMethodType getDigestMethod() {
        synchronized (monitor()) {
            check_orphaned();
            DigestMethodType digestMethodType = (DigestMethodType) get_store().find_element_user(DIGESTMETHOD$2, 0);
            if (digestMethodType == null) {
                return null;
            }
            return digestMethodType;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public byte[] getDigestValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(DIGESTVALUE$4, 0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
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

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public TransformsType getTransforms() {
        synchronized (monitor()) {
            check_orphaned();
            TransformsType find_element_user = get_store().find_element_user(TRANSFORMS$0, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public String getType() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$10);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public String getURI() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$8);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$6) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetTransforms() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRANSFORMS$0) != 0;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$10) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public boolean isSetURI() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$8) != null;
        }
        return z;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setDigestMethod(DigestMethodType digestMethodType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTMETHOD$2;
            DigestMethodType digestMethodType2 = (DigestMethodType) typeStore.find_element_user(qName, 0);
            if (digestMethodType2 == null) {
                digestMethodType2 = (DigestMethodType) get_store().add_element_user(qName);
            }
            digestMethodType2.set(digestMethodType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setDigestValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
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

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setTransforms(TransformsType transformsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TRANSFORMS$0;
            TransformsType find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (TransformsType) get_store().add_element_user(qName);
            }
            find_element_user.set(transformsType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setType(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void setURI(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetTransforms() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRANSFORMS$0, 0);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$10);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void unsetURI() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$8);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public DigestValueType xgetDigestValue() {
        DigestValueType digestValueType;
        synchronized (monitor()) {
            check_orphaned();
            digestValueType = (DigestValueType) get_store().find_element_user(DIGESTVALUE$4, 0);
        }
        return digestValueType;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$6);
        }
        return xmlID;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public XmlAnyURI xgetType() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(TYPE$10);
        }
        return xmlAnyURI;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public XmlAnyURI xgetURI() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(URI$8);
        }
        return xmlAnyURI;
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetDigestValue(DigestValueType digestValueType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DIGESTVALUE$4;
            DigestValueType digestValueType2 = (DigestValueType) typeStore.find_element_user(qName, 0);
            if (digestValueType2 == null) {
                digestValueType2 = (DigestValueType) get_store().add_element_user(qName);
            }
            digestValueType2.set(digestValueType);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
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

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetType(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = TYPE$10;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.w3.x2000.x09.xmldsig.ReferenceType
    public void xsetURI(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$8;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }
}

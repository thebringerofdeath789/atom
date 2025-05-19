package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.etsi.uri.x01903.v13.UnsignedDataObjectPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType;

/* loaded from: classes5.dex */
public class UnsignedPropertiesTypeImpl extends XmlComplexContentImpl implements UnsignedPropertiesType {
    private static final QName UNSIGNEDSIGNATUREPROPERTIES$0 = new QName(SignatureFacet.XADES_132_NS, "UnsignedSignatureProperties");
    private static final QName UNSIGNEDDATAOBJECTPROPERTIES$2 = new QName(SignatureFacet.XADES_132_NS, "UnsignedDataObjectProperties");
    private static final QName ID$4 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);

    public UnsignedPropertiesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedDataObjectPropertiesType addNewUnsignedDataObjectProperties() {
        UnsignedDataObjectPropertiesType add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            add_element_user = get_store().add_element_user(UNSIGNEDDATAOBJECTPROPERTIES$2);
        }
        return add_element_user;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedSignaturePropertiesType addNewUnsignedSignatureProperties() {
        UnsignedSignaturePropertiesType unsignedSignaturePropertiesType;
        synchronized (monitor()) {
            check_orphaned();
            unsignedSignaturePropertiesType = (UnsignedSignaturePropertiesType) get_store().add_element_user(UNSIGNEDSIGNATUREPROPERTIES$0);
        }
        return unsignedSignaturePropertiesType;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$4);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedDataObjectPropertiesType getUnsignedDataObjectProperties() {
        synchronized (monitor()) {
            check_orphaned();
            UnsignedDataObjectPropertiesType find_element_user = get_store().find_element_user(UNSIGNEDDATAOBJECTPROPERTIES$2, 0);
            if (find_element_user == null) {
                return null;
            }
            return find_element_user;
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public UnsignedSignaturePropertiesType getUnsignedSignatureProperties() {
        synchronized (monitor()) {
            check_orphaned();
            UnsignedSignaturePropertiesType unsignedSignaturePropertiesType = (UnsignedSignaturePropertiesType) get_store().find_element_user(UNSIGNEDSIGNATUREPROPERTIES$0, 0);
            if (unsignedSignaturePropertiesType == null) {
                return null;
            }
            return unsignedSignaturePropertiesType;
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$4) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public boolean isSetUnsignedDataObjectProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNSIGNEDDATAOBJECTPROPERTIES$2) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public boolean isSetUnsignedSignatureProperties() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(UNSIGNEDSIGNATUREPROPERTIES$0) != 0;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void setUnsignedDataObjectProperties(UnsignedDataObjectPropertiesType unsignedDataObjectPropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNSIGNEDDATAOBJECTPROPERTIES$2;
            UnsignedDataObjectPropertiesType find_element_user = typeStore.find_element_user(qName, 0);
            if (find_element_user == null) {
                find_element_user = (UnsignedDataObjectPropertiesType) get_store().add_element_user(qName);
            }
            find_element_user.set(unsignedDataObjectPropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void setUnsignedSignatureProperties(UnsignedSignaturePropertiesType unsignedSignaturePropertiesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = UNSIGNEDSIGNATUREPROPERTIES$0;
            UnsignedSignaturePropertiesType unsignedSignaturePropertiesType2 = (UnsignedSignaturePropertiesType) typeStore.find_element_user(qName, 0);
            if (unsignedSignaturePropertiesType2 == null) {
                unsignedSignaturePropertiesType2 = (UnsignedSignaturePropertiesType) get_store().add_element_user(qName);
            }
            unsignedSignaturePropertiesType2.set(unsignedSignaturePropertiesType);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$4);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void unsetUnsignedDataObjectProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNSIGNEDDATAOBJECTPROPERTIES$2, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void unsetUnsignedSignatureProperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(UNSIGNEDSIGNATUREPROPERTIES$0, 0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$4);
        }
        return xmlID;
    }

    @Override // org.etsi.uri.x01903.v13.UnsignedPropertiesType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$4;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }
}

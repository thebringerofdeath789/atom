package org.etsi.uri.x01903.v13.impl;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;

/* loaded from: classes5.dex */
public class EncapsulatedPKIDataTypeImpl extends JavaBase64HolderEx implements EncapsulatedPKIDataType {
    private static final QName ID$0 = new QName("", PackageRelationship.ID_ATTRIBUTE_NAME);
    private static final QName ENCODING$2 = new QName("", "Encoding");

    public EncapsulatedPKIDataTypeImpl(SchemaType schemaType) {
        super(schemaType, true);
    }

    protected EncapsulatedPKIDataTypeImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public String getEncoding() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENCODING$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public String getId() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getStringValue();
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public boolean isSetEncoding() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ENCODING$2) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void setEncoding(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCODING$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void unsetEncoding() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ENCODING$2);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public XmlAnyURI xgetEncoding() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(ENCODING$2);
        }
        return xmlAnyURI;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public XmlID xgetId() {
        XmlID xmlID;
        synchronized (monitor()) {
            check_orphaned();
            xmlID = (XmlID) get_store().find_attribute_user(ID$0);
        }
        return xmlID;
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void xsetEncoding(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCODING$2;
            XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
            if (xmlAnyURI2 == null) {
                xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
            }
            xmlAnyURI2.set(xmlAnyURI);
        }
    }

    @Override // org.etsi.uri.x01903.v13.EncapsulatedPKIDataType
    public void xsetId(XmlID xmlID) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ID$0;
            XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qName);
            if (xmlID2 == null) {
                xmlID2 = (XmlID) get_store().add_attribute_user(qName);
            }
            xmlID2.set(xmlID);
        }
    }
}

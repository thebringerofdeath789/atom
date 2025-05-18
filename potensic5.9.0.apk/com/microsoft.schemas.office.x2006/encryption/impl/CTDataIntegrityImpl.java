package com.microsoft.schemas.office.x2006.encryption.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class CTDataIntegrityImpl extends XmlComplexContentImpl implements CTDataIntegrity {
    private static final QName ENCRYPTEDHMACKEY$0 = new QName("", "encryptedHmacKey");
    private static final QName ENCRYPTEDHMACVALUE$2 = new QName("", "encryptedHmacValue");

    public CTDataIntegrityImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public byte[] getEncryptedHmacKey() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public byte[] getEncryptedHmacValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void setEncryptedHmacKey(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACKEY$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void setEncryptedHmacValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACVALUE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public XmlBase64Binary xgetEncryptedHmacKey() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(ENCRYPTEDHMACKEY$0);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public XmlBase64Binary xgetEncryptedHmacValue() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(ENCRYPTEDHMACVALUE$2);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void xsetEncryptedHmacKey(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACKEY$0;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity
    public void xsetEncryptedHmacValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDHMACVALUE$2;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }
}
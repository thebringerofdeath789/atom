package com.microsoft.schemas.office.x2006.encryption.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class CTKeyEncryptorImpl extends XmlComplexContentImpl implements CTKeyEncryptor {
    private static final QName ENCRYPTEDPASSWORDKEY$0 = new QName("http://schemas.microsoft.com/office/2006/keyEncryptor/password", "encryptedKey");
    private static final QName ENCRYPTEDCERTIFICATEKEY$2 = new QName("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate", "encryptedKey");
    private static final QName URI$4 = new QName("", "uri");

    public static class UriImpl extends JavaStringEnumerationHolderEx implements CTKeyEncryptor.Uri {
        public UriImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected UriImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public CTKeyEncryptorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTCertificateKeyEncryptor addNewEncryptedCertificateKey() {
        CTCertificateKeyEncryptor cTCertificateKeyEncryptor;
        synchronized (monitor()) {
            check_orphaned();
            cTCertificateKeyEncryptor = (CTCertificateKeyEncryptor) get_store().add_element_user(ENCRYPTEDCERTIFICATEKEY$2);
        }
        return cTCertificateKeyEncryptor;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTPasswordKeyEncryptor addNewEncryptedPasswordKey() {
        CTPasswordKeyEncryptor cTPasswordKeyEncryptor;
        synchronized (monitor()) {
            check_orphaned();
            cTPasswordKeyEncryptor = (CTPasswordKeyEncryptor) get_store().add_element_user(ENCRYPTEDPASSWORDKEY$0);
        }
        return cTPasswordKeyEncryptor;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTCertificateKeyEncryptor getEncryptedCertificateKey() {
        synchronized (monitor()) {
            check_orphaned();
            CTCertificateKeyEncryptor cTCertificateKeyEncryptor = (CTCertificateKeyEncryptor) get_store().find_element_user(ENCRYPTEDCERTIFICATEKEY$2, 0);
            if (cTCertificateKeyEncryptor == null) {
                return null;
            }
            return cTCertificateKeyEncryptor;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTPasswordKeyEncryptor getEncryptedPasswordKey() {
        synchronized (monitor()) {
            check_orphaned();
            CTPasswordKeyEncryptor cTPasswordKeyEncryptor = (CTPasswordKeyEncryptor) get_store().find_element_user(ENCRYPTEDPASSWORDKEY$0, 0);
            if (cTPasswordKeyEncryptor == null) {
                return null;
            }
            return cTPasswordKeyEncryptor;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTKeyEncryptor.Uri.Enum getUri() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$4);
            if (simpleValue == null) {
                return null;
            }
            return (CTKeyEncryptor.Uri.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public boolean isSetEncryptedCertificateKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENCRYPTEDCERTIFICATEKEY$2) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public boolean isSetEncryptedPasswordKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENCRYPTEDPASSWORDKEY$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void setEncryptedCertificateKey(CTCertificateKeyEncryptor cTCertificateKeyEncryptor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDCERTIFICATEKEY$2;
            CTCertificateKeyEncryptor cTCertificateKeyEncryptor2 = (CTCertificateKeyEncryptor) typeStore.find_element_user(qName, 0);
            if (cTCertificateKeyEncryptor2 == null) {
                cTCertificateKeyEncryptor2 = (CTCertificateKeyEncryptor) get_store().add_element_user(qName);
            }
            cTCertificateKeyEncryptor2.set(cTCertificateKeyEncryptor);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void setEncryptedPasswordKey(CTPasswordKeyEncryptor cTPasswordKeyEncryptor) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDPASSWORDKEY$0;
            CTPasswordKeyEncryptor cTPasswordKeyEncryptor2 = (CTPasswordKeyEncryptor) typeStore.find_element_user(qName, 0);
            if (cTPasswordKeyEncryptor2 == null) {
                cTPasswordKeyEncryptor2 = (CTPasswordKeyEncryptor) get_store().add_element_user(qName);
            }
            cTPasswordKeyEncryptor2.set(cTPasswordKeyEncryptor);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void setUri(CTKeyEncryptor.Uri.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void unsetEncryptedCertificateKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENCRYPTEDCERTIFICATEKEY$2, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void unsetEncryptedPasswordKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENCRYPTEDPASSWORDKEY$0, 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public CTKeyEncryptor.Uri xgetUri() {
        CTKeyEncryptor.Uri uri;
        synchronized (monitor()) {
            check_orphaned();
            uri = (CTKeyEncryptor.Uri) get_store().find_attribute_user(URI$4);
        }
        return uri;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor
    public void xsetUri(CTKeyEncryptor.Uri uri) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = URI$4;
            CTKeyEncryptor.Uri uri2 = (CTKeyEncryptor.Uri) typeStore.find_attribute_user(qName);
            if (uri2 == null) {
                uri2 = (CTKeyEncryptor.Uri) get_store().add_attribute_user(qName);
            }
            uri2.set(uri);
        }
    }
}
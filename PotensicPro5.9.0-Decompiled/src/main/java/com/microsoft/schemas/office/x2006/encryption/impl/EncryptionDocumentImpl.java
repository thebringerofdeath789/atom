package com.microsoft.schemas.office.x2006.encryption.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class EncryptionDocumentImpl extends XmlComplexContentImpl implements EncryptionDocument {
    private static final QName ENCRYPTION$0 = new QName("http://schemas.microsoft.com/office/2006/encryption", "encryption");

    public EncryptionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.EncryptionDocument
    public CTEncryption addNewEncryption() {
        CTEncryption cTEncryption;
        synchronized (monitor()) {
            check_orphaned();
            cTEncryption = (CTEncryption) get_store().add_element_user(ENCRYPTION$0);
        }
        return cTEncryption;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.EncryptionDocument
    public CTEncryption getEncryption() {
        synchronized (monitor()) {
            check_orphaned();
            CTEncryption cTEncryption = (CTEncryption) get_store().find_element_user(ENCRYPTION$0, 0);
            if (cTEncryption == null) {
                return null;
            }
            return cTEncryption;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.EncryptionDocument
    public void setEncryption(CTEncryption cTEncryption) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTION$0;
            CTEncryption cTEncryption2 = (CTEncryption) typeStore.find_element_user(qName, 0);
            if (cTEncryption2 == null) {
                cTEncryption2 = (CTEncryption) get_store().add_element_user(qName);
            }
            cTEncryption2.set(cTEncryption);
        }
    }
}

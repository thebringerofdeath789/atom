package com.microsoft.schemas.office.x2006.encryption.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTEncryption;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptors;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class CTEncryptionImpl extends XmlComplexContentImpl implements CTEncryption {
    private static final QName KEYDATA$0 = new QName("http://schemas.microsoft.com/office/2006/encryption", "keyData");
    private static final QName DATAINTEGRITY$2 = new QName("http://schemas.microsoft.com/office/2006/encryption", "dataIntegrity");
    private static final QName KEYENCRYPTORS$4 = new QName("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptors");

    public CTEncryptionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTDataIntegrity addNewDataIntegrity() {
        CTDataIntegrity cTDataIntegrity;
        synchronized (monitor()) {
            check_orphaned();
            cTDataIntegrity = (CTDataIntegrity) get_store().add_element_user(DATAINTEGRITY$2);
        }
        return cTDataIntegrity;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyData addNewKeyData() {
        CTKeyData cTKeyData;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyData = (CTKeyData) get_store().add_element_user(KEYDATA$0);
        }
        return cTKeyData;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyEncryptors addNewKeyEncryptors() {
        CTKeyEncryptors cTKeyEncryptors;
        synchronized (monitor()) {
            check_orphaned();
            cTKeyEncryptors = (CTKeyEncryptors) get_store().add_element_user(KEYENCRYPTORS$4);
        }
        return cTKeyEncryptors;
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTDataIntegrity getDataIntegrity() {
        synchronized (monitor()) {
            check_orphaned();
            CTDataIntegrity cTDataIntegrity = (CTDataIntegrity) get_store().find_element_user(DATAINTEGRITY$2, 0);
            if (cTDataIntegrity == null) {
                return null;
            }
            return cTDataIntegrity;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyData getKeyData() {
        synchronized (monitor()) {
            check_orphaned();
            CTKeyData cTKeyData = (CTKeyData) get_store().find_element_user(KEYDATA$0, 0);
            if (cTKeyData == null) {
                return null;
            }
            return cTKeyData;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public CTKeyEncryptors getKeyEncryptors() {
        synchronized (monitor()) {
            check_orphaned();
            CTKeyEncryptors cTKeyEncryptors = (CTKeyEncryptors) get_store().find_element_user(KEYENCRYPTORS$4, 0);
            if (cTKeyEncryptors == null) {
                return null;
            }
            return cTKeyEncryptors;
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public void setDataIntegrity(CTDataIntegrity cTDataIntegrity) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = DATAINTEGRITY$2;
            CTDataIntegrity cTDataIntegrity2 = (CTDataIntegrity) typeStore.find_element_user(qName, 0);
            if (cTDataIntegrity2 == null) {
                cTDataIntegrity2 = (CTDataIntegrity) get_store().add_element_user(qName);
            }
            cTDataIntegrity2.set(cTDataIntegrity);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public void setKeyData(CTKeyData cTKeyData) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYDATA$0;
            CTKeyData cTKeyData2 = (CTKeyData) typeStore.find_element_user(qName, 0);
            if (cTKeyData2 == null) {
                cTKeyData2 = (CTKeyData) get_store().add_element_user(qName);
            }
            cTKeyData2.set(cTKeyData);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.encryption.CTEncryption
    public void setKeyEncryptors(CTKeyEncryptors cTKeyEncryptors) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYENCRYPTORS$4;
            CTKeyEncryptors cTKeyEncryptors2 = (CTKeyEncryptors) typeStore.find_element_user(qName, 0);
            if (cTKeyEncryptors2 == null) {
                cTKeyEncryptors2 = (CTKeyEncryptors) get_store().add_element_user(qName);
            }
            cTKeyEncryptors2.set(cTKeyEncryptors);
        }
    }
}
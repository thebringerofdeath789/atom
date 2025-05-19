package com.microsoft.schemas.office.x2006.keyEncryptor.password.impl;

import aavax.xml.namespace.QName;
import com.microsoft.schemas.office.x2006.encryption.STBlockSize;
import com.microsoft.schemas.office.x2006.encryption.STCipherAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STCipherChaining;
import com.microsoft.schemas.office.x2006.encryption.STHashAlgorithm;
import com.microsoft.schemas.office.x2006.encryption.STHashSize;
import com.microsoft.schemas.office.x2006.encryption.STKeyBits;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;
import com.microsoft.schemas.office.x2006.encryption.STSpinCount;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* loaded from: classes3.dex */
public class CTPasswordKeyEncryptorImpl extends XmlComplexContentImpl implements CTPasswordKeyEncryptor {
    private static final QName SALTSIZE$0 = new QName("", "saltSize");
    private static final QName BLOCKSIZE$2 = new QName("", "blockSize");
    private static final QName KEYBITS$4 = new QName("", "keyBits");
    private static final QName HASHSIZE$6 = new QName("", "hashSize");
    private static final QName CIPHERALGORITHM$8 = new QName("", "cipherAlgorithm");
    private static final QName CIPHERCHAINING$10 = new QName("", "cipherChaining");
    private static final QName HASHALGORITHM$12 = new QName("", "hashAlgorithm");
    private static final QName SALTVALUE$14 = new QName("", "saltValue");
    private static final QName SPINCOUNT$16 = new QName("", "spinCount");
    private static final QName ENCRYPTEDVERIFIERHASHINPUT$18 = new QName("", "encryptedVerifierHashInput");
    private static final QName ENCRYPTEDVERIFIERHASHVALUE$20 = new QName("", "encryptedVerifierHashValue");
    private static final QName ENCRYPTEDKEYVALUE$22 = new QName("", "encryptedKeyValue");

    public CTPasswordKeyEncryptorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getBlockSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BLOCKSIZE$2);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherAlgorithm.Enum getCipherAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CIPHERALGORITHM$8);
            if (simpleValue == null) {
                return null;
            }
            return (STCipherAlgorithm.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherChaining.Enum getCipherChaining() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CIPHERCHAINING$10);
            if (simpleValue == null) {
                return null;
            }
            return (STCipherChaining.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getEncryptedKeyValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENCRYPTEDKEYVALUE$22);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getEncryptedVerifierHashInput() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHINPUT$18);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getEncryptedVerifierHashValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHVALUE$20);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STHashAlgorithm.Enum getHashAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HASHALGORITHM$12);
            if (simpleValue == null) {
                return null;
            }
            return (STHashAlgorithm.Enum) simpleValue.getEnumValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getHashSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HASHSIZE$6);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public long getKeyBits() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(KEYBITS$4);
            if (simpleValue == null) {
                return 0L;
            }
            return simpleValue.getLongValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getSaltSize() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SALTSIZE$0);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public byte[] getSaltValue() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SALTVALUE$14);
            if (simpleValue == null) {
                return null;
            }
            return simpleValue.getByteArrayValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public int getSpinCount() {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPINCOUNT$16);
            if (simpleValue == null) {
                return 0;
            }
            return simpleValue.getIntValue();
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setBlockSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCKSIZE$2;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setCipherAlgorithm(STCipherAlgorithm.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERALGORITHM$8;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setCipherChaining(STCipherChaining.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERCHAINING$10;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setEncryptedKeyValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDKEYVALUE$22;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setEncryptedVerifierHashInput(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHINPUT$18;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setEncryptedVerifierHashValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHVALUE$20;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setHashAlgorithm(STHashAlgorithm.Enum r4) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHALGORITHM$12;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setEnumValue(r4);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setHashSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHSIZE$6;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setKeyBits(long j) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYBITS$4;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setLongValue(j);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setSaltSize(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTSIZE$0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setSaltValue(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTVALUE$14;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setByteArrayValue(bArr);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void setSpinCount(int i) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPINCOUNT$16;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
            }
            simpleValue.setIntValue(i);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STBlockSize xgetBlockSize() {
        STBlockSize sTBlockSize;
        synchronized (monitor()) {
            check_orphaned();
            sTBlockSize = (STBlockSize) get_store().find_attribute_user(BLOCKSIZE$2);
        }
        return sTBlockSize;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherAlgorithm xgetCipherAlgorithm() {
        STCipherAlgorithm sTCipherAlgorithm;
        synchronized (monitor()) {
            check_orphaned();
            sTCipherAlgorithm = (STCipherAlgorithm) get_store().find_attribute_user(CIPHERALGORITHM$8);
        }
        return sTCipherAlgorithm;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STCipherChaining xgetCipherChaining() {
        STCipherChaining sTCipherChaining;
        synchronized (monitor()) {
            check_orphaned();
            sTCipherChaining = (STCipherChaining) get_store().find_attribute_user(CIPHERCHAINING$10);
        }
        return sTCipherChaining;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetEncryptedKeyValue() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(ENCRYPTEDKEYVALUE$22);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetEncryptedVerifierHashInput() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHINPUT$18);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetEncryptedVerifierHashValue() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(ENCRYPTEDVERIFIERHASHVALUE$20);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STHashAlgorithm xgetHashAlgorithm() {
        STHashAlgorithm sTHashAlgorithm;
        synchronized (monitor()) {
            check_orphaned();
            sTHashAlgorithm = (STHashAlgorithm) get_store().find_attribute_user(HASHALGORITHM$12);
        }
        return sTHashAlgorithm;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STHashSize xgetHashSize() {
        STHashSize sTHashSize;
        synchronized (monitor()) {
            check_orphaned();
            sTHashSize = (STHashSize) get_store().find_attribute_user(HASHSIZE$6);
        }
        return sTHashSize;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STKeyBits xgetKeyBits() {
        STKeyBits sTKeyBits;
        synchronized (monitor()) {
            check_orphaned();
            sTKeyBits = (STKeyBits) get_store().find_attribute_user(KEYBITS$4);
        }
        return sTKeyBits;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STSaltSize xgetSaltSize() {
        STSaltSize sTSaltSize;
        synchronized (monitor()) {
            check_orphaned();
            sTSaltSize = (STSaltSize) get_store().find_attribute_user(SALTSIZE$0);
        }
        return sTSaltSize;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public XmlBase64Binary xgetSaltValue() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_attribute_user(SALTVALUE$14);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public STSpinCount xgetSpinCount() {
        STSpinCount sTSpinCount;
        synchronized (monitor()) {
            check_orphaned();
            sTSpinCount = (STSpinCount) get_store().find_attribute_user(SPINCOUNT$16);
        }
        return sTSpinCount;
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetBlockSize(STBlockSize sTBlockSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = BLOCKSIZE$2;
            STBlockSize sTBlockSize2 = (STBlockSize) typeStore.find_attribute_user(qName);
            if (sTBlockSize2 == null) {
                sTBlockSize2 = (STBlockSize) get_store().add_attribute_user(qName);
            }
            sTBlockSize2.set(sTBlockSize);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetCipherAlgorithm(STCipherAlgorithm sTCipherAlgorithm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERALGORITHM$8;
            STCipherAlgorithm sTCipherAlgorithm2 = (STCipherAlgorithm) typeStore.find_attribute_user(qName);
            if (sTCipherAlgorithm2 == null) {
                sTCipherAlgorithm2 = (STCipherAlgorithm) get_store().add_attribute_user(qName);
            }
            sTCipherAlgorithm2.set(sTCipherAlgorithm);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetCipherChaining(STCipherChaining sTCipherChaining) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CIPHERCHAINING$10;
            STCipherChaining sTCipherChaining2 = (STCipherChaining) typeStore.find_attribute_user(qName);
            if (sTCipherChaining2 == null) {
                sTCipherChaining2 = (STCipherChaining) get_store().add_attribute_user(qName);
            }
            sTCipherChaining2.set(sTCipherChaining);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetEncryptedKeyValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDKEYVALUE$22;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetEncryptedVerifierHashInput(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHINPUT$18;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetEncryptedVerifierHashValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = ENCRYPTEDVERIFIERHASHVALUE$20;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetHashAlgorithm(STHashAlgorithm sTHashAlgorithm) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHALGORITHM$12;
            STHashAlgorithm sTHashAlgorithm2 = (STHashAlgorithm) typeStore.find_attribute_user(qName);
            if (sTHashAlgorithm2 == null) {
                sTHashAlgorithm2 = (STHashAlgorithm) get_store().add_attribute_user(qName);
            }
            sTHashAlgorithm2.set(sTHashAlgorithm);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetHashSize(STHashSize sTHashSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = HASHSIZE$6;
            STHashSize sTHashSize2 = (STHashSize) typeStore.find_attribute_user(qName);
            if (sTHashSize2 == null) {
                sTHashSize2 = (STHashSize) get_store().add_attribute_user(qName);
            }
            sTHashSize2.set(sTHashSize);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetKeyBits(STKeyBits sTKeyBits) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = KEYBITS$4;
            STKeyBits sTKeyBits2 = (STKeyBits) typeStore.find_attribute_user(qName);
            if (sTKeyBits2 == null) {
                sTKeyBits2 = (STKeyBits) get_store().add_attribute_user(qName);
            }
            sTKeyBits2.set(sTKeyBits);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetSaltSize(STSaltSize sTSaltSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTSIZE$0;
            STSaltSize sTSaltSize2 = (STSaltSize) typeStore.find_attribute_user(qName);
            if (sTSaltSize2 == null) {
                sTSaltSize2 = (STSaltSize) get_store().add_attribute_user(qName);
            }
            sTSaltSize2.set(sTSaltSize);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetSaltValue(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SALTVALUE$14;
            XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_attribute_user(qName);
            if (xmlBase64Binary2 == null) {
                xmlBase64Binary2 = (XmlBase64Binary) get_store().add_attribute_user(qName);
            }
            xmlBase64Binary2.set(xmlBase64Binary);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor
    public void xsetSpinCount(STSpinCount sTSpinCount) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SPINCOUNT$16;
            STSpinCount sTSpinCount2 = (STSpinCount) typeStore.find_attribute_user(qName);
            if (sTSpinCount2 == null) {
                sTSpinCount2 = (STSpinCount) get_store().add_attribute_user(qName);
            }
            sTSpinCount2.set(sTSpinCount);
        }
    }
}

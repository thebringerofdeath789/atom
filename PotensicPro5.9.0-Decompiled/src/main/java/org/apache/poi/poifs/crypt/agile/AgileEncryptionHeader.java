package org.apache.poi.poifs.crypt.agile;

import com.microsoft.schemas.office.x2006.encryption.CTDataIntegrity;
import com.microsoft.schemas.office.x2006.encryption.CTKeyData;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* loaded from: classes5.dex */
public class AgileEncryptionHeader extends EncryptionHeader {
    private byte[] encryptedHmacKey;
    private byte[] encryptedHmacValue;

    public AgileEncryptionHeader(String str) {
        this(AgileEncryptionInfoBuilder.parseDescriptor(str));
    }

    protected AgileEncryptionHeader(EncryptionDocument encryptionDocument) {
        try {
            CTKeyData keyData = encryptionDocument.getEncryption().getKeyData();
            if (keyData == null) {
                throw new NullPointerException("keyData not set");
            }
            setKeySize((int) keyData.getKeyBits());
            setFlags(0);
            setSizeExtra(0);
            setCspName(null);
            setBlockSize(keyData.getBlockSize());
            CipherAlgorithm fromXmlId = CipherAlgorithm.fromXmlId(keyData.getCipherAlgorithm().toString(), (int) keyData.getKeyBits());
            setCipherAlgorithm(fromXmlId);
            setCipherProvider(fromXmlId.provider);
            int intValue = keyData.getCipherChaining().intValue();
            if (intValue == 1) {
                setChainingMode(ChainingMode.cbc);
            } else if (intValue == 2) {
                setChainingMode(ChainingMode.cfb);
            } else {
                throw new EncryptedDocumentException("Unsupported chaining mode - " + keyData.getCipherChaining().toString());
            }
            int hashSize = keyData.getHashSize();
            setHashAlgorithm(HashAlgorithm.fromEcmaId(keyData.getHashAlgorithm().toString()));
            if (getHashAlgorithmEx().hashSize != hashSize) {
                throw new EncryptedDocumentException("Unsupported hash algorithm: " + keyData.getHashAlgorithm() + " @ " + hashSize + " bytes");
            }
            int saltSize = keyData.getSaltSize();
            setKeySalt(keyData.getSaltValue());
            if (getKeySalt().length != saltSize) {
                throw new EncryptedDocumentException("Invalid salt length");
            }
            CTDataIntegrity dataIntegrity = encryptionDocument.getEncryption().getDataIntegrity();
            setEncryptedHmacKey(dataIntegrity.getEncryptedHmacKey());
            setEncryptedHmacValue(dataIntegrity.getEncryptedHmacValue());
        } catch (Exception unused) {
            throw new EncryptedDocumentException("Unable to parse keyData");
        }
    }

    public AgileEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setKeySize(i);
        setBlockSize(i2);
        setChainingMode(chainingMode);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    protected void setKeySalt(byte[] bArr) {
        if (bArr == null || bArr.length != getBlockSize()) {
            throw new EncryptedDocumentException("invalid verifier salt");
        }
        super.setKeySalt(bArr);
    }

    public byte[] getEncryptedHmacKey() {
        return this.encryptedHmacKey;
    }

    protected void setEncryptedHmacKey(byte[] bArr) {
        this.encryptedHmacKey = bArr;
    }

    public byte[] getEncryptedHmacValue() {
        return this.encryptedHmacValue;
    }

    protected void setEncryptedHmacValue(byte[] bArr) {
        this.encryptedHmacValue = bArr;
    }
}

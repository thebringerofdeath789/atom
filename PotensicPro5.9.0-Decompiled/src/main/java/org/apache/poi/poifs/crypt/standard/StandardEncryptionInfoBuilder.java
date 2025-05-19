package org.apache.poi.poifs.crypt.standard;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* loaded from: classes5.dex */
public class StandardEncryptionInfoBuilder implements EncryptionInfoBuilder {
    StandardDecryptor decryptor;
    StandardEncryptor encryptor;
    StandardEncryptionHeader header;
    EncryptionInfo info;
    StandardEncryptionVerifier verifier;

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        this.info = encryptionInfo;
        littleEndianInput.readInt();
        this.header = new StandardEncryptionHeader(littleEndianInput);
        this.verifier = new StandardEncryptionVerifier(littleEndianInput, this.header);
        if (encryptionInfo.getVersionMinor() == 2) {
            if (encryptionInfo.getVersionMajor() == 3 || encryptionInfo.getVersionMajor() == 4) {
                this.decryptor = new StandardDecryptor(this);
            }
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.info = encryptionInfo;
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.aes128;
        }
        if (cipherAlgorithm != CipherAlgorithm.aes128 && cipherAlgorithm != CipherAlgorithm.aes192 && cipherAlgorithm != CipherAlgorithm.aes256) {
            throw new EncryptedDocumentException("Standard encryption only supports AES128/192/256.");
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        if (hashAlgorithm != HashAlgorithm.sha1) {
            throw new EncryptedDocumentException("Standard encryption only supports SHA-1.");
        }
        if (chainingMode == null) {
            chainingMode = ChainingMode.ecb;
        }
        if (chainingMode != ChainingMode.ecb) {
            throw new EncryptedDocumentException("Standard encryption only supports ECB chaining.");
        }
        if (i == -1) {
            i = cipherAlgorithm.defaultKeySize;
        }
        if (i2 == -1) {
            i2 = cipherAlgorithm.blockSize;
        }
        boolean z = false;
        for (int i3 : cipherAlgorithm.allowedKeySize) {
            z |= i3 == i;
        }
        if (!z) {
            throw new EncryptedDocumentException("KeySize " + i + " not allowed for Cipher " + cipherAlgorithm.toString());
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        int i4 = i;
        int i5 = i2;
        ChainingMode chainingMode2 = chainingMode;
        this.header = new StandardEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2);
        this.verifier = new StandardEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2);
        this.decryptor = new StandardDecryptor(this);
        this.encryptor = new StandardEncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public StandardEncryptionHeader getHeader() {
        return this.header;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public StandardEncryptionVerifier getVerifier() {
        return this.verifier;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public StandardDecryptor getDecryptor() {
        return this.decryptor;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public StandardEncryptor getEncryptor() {
        return this.encryptor;
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.info;
    }
}

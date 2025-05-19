package org.apache.poi.poifs.crypt.cryptoapi;

import java.io.IOException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* loaded from: classes5.dex */
public class CryptoAPIEncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    CryptoAPIDecryptor decryptor;
    CryptoAPIEncryptor encryptor;
    CryptoAPIEncryptionHeader header;
    EncryptionInfo info;
    CryptoAPIEncryptionVerifier verifier;

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        this.info = encryptionInfo;
        littleEndianInput.readInt();
        this.header = new CryptoAPIEncryptionHeader(littleEndianInput);
        this.verifier = new CryptoAPIEncryptionVerifier(littleEndianInput, this.header);
        this.decryptor = new CryptoAPIDecryptor(this);
        this.encryptor = new CryptoAPIEncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.info = encryptionInfo;
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.rc4;
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        if (i == -1) {
            i = 40;
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        int i3 = i;
        this.header = new CryptoAPIEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i3, i2, chainingMode);
        this.verifier = new CryptoAPIEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i3, i2, chainingMode);
        this.decryptor = new CryptoAPIDecryptor(this);
        this.encryptor = new CryptoAPIEncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public CryptoAPIEncryptionHeader getHeader() {
        return this.header;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public CryptoAPIEncryptionVerifier getVerifier() {
        return this.verifier;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public CryptoAPIDecryptor getDecryptor() {
        return this.decryptor;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public CryptoAPIEncryptor getEncryptor() {
        return this.encryptor;
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.info;
    }
}

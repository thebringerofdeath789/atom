package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.IOException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* loaded from: classes5.dex */
public class BinaryRC4EncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    BinaryRC4Decryptor decryptor;
    BinaryRC4Encryptor encryptor;
    BinaryRC4EncryptionHeader header;
    EncryptionInfo info;
    BinaryRC4EncryptionVerifier verifier;

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        this.info = encryptionInfo;
        encryptionInfo.getVersionMajor();
        encryptionInfo.getVersionMinor();
        this.header = new BinaryRC4EncryptionHeader();
        this.verifier = new BinaryRC4EncryptionVerifier(littleEndianInput);
        this.decryptor = new BinaryRC4Decryptor(this);
        this.encryptor = new BinaryRC4Encryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.info = encryptionInfo;
        this.header = new BinaryRC4EncryptionHeader();
        this.verifier = new BinaryRC4EncryptionVerifier();
        this.decryptor = new BinaryRC4Decryptor(this);
        this.encryptor = new BinaryRC4Encryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public BinaryRC4EncryptionHeader getHeader() {
        return this.header;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public BinaryRC4EncryptionVerifier getVerifier() {
        return this.verifier;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public BinaryRC4Decryptor getDecryptor() {
        return this.decryptor;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public BinaryRC4Encryptor getEncryptor() {
        return this.encryptor;
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.info;
    }
}

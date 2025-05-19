package org.apache.poi.poifs.crypt.agile;

import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;
import org.apache.xmlbeans.XmlException;

/* loaded from: classes5.dex */
public class AgileEncryptionInfoBuilder implements EncryptionInfoBuilder {
    AgileDecryptor decryptor;
    AgileEncryptor encryptor;
    AgileEncryptionHeader header;
    EncryptionInfo info;
    AgileEncryptionVerifier verifier;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) throws IOException {
        this.info = encryptionInfo;
        EncryptionDocument parseDescriptor = parseDescriptor((InputStream) littleEndianInput);
        this.header = new AgileEncryptionHeader(parseDescriptor);
        this.verifier = new AgileEncryptionVerifier(parseDescriptor);
        if (encryptionInfo.getVersionMajor() == EncryptionMode.agile.versionMajor && encryptionInfo.getVersionMinor() == EncryptionMode.agile.versionMinor) {
            this.decryptor = new AgileDecryptor(this);
            this.encryptor = new AgileEncryptor(this);
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.info = encryptionInfo;
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.aes128;
        }
        if (cipherAlgorithm == CipherAlgorithm.rc4) {
            throw new EncryptedDocumentException("RC4 must not be used with agile encryption.");
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        if (chainingMode == null) {
            chainingMode = ChainingMode.cbc;
        }
        if (chainingMode != ChainingMode.cbc && chainingMode != ChainingMode.cfb) {
            throw new EncryptedDocumentException("Agile encryption only supports CBC/CFB chaining.");
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
        this.header = new AgileEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2);
        this.verifier = new AgileEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i4, i5, chainingMode2);
        this.decryptor = new AgileDecryptor(this);
        this.encryptor = new AgileEncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public AgileEncryptionHeader getHeader() {
        return this.header;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public AgileEncryptionVerifier getVerifier() {
        return this.verifier;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public AgileDecryptor getDecryptor() {
        return this.decryptor;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public AgileEncryptor getEncryptor() {
        return this.encryptor;
    }

    protected EncryptionInfo getInfo() {
        return this.info;
    }

    protected static EncryptionDocument parseDescriptor(String str) {
        try {
            return EncryptionDocument.Factory.parse(str);
        } catch (XmlException e) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor", e);
        }
    }

    protected static EncryptionDocument parseDescriptor(InputStream inputStream) {
        try {
            return EncryptionDocument.Factory.parse(inputStream);
        } catch (Exception e) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor", e);
        }
    }
}

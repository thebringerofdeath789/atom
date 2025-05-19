package org.apache.poi.poifs.crypt.agile;

import com.google.android.exoplayer2.audio.AacUtil;
import com.microsoft.schemas.office.x2006.encryption.CTKeyEncryptor;
import com.microsoft.schemas.office.x2006.encryption.EncryptionDocument;
import com.microsoft.schemas.office.x2006.keyEncryptor.certificate.CTCertificateKeyEncryptor;
import com.microsoft.schemas.office.x2006.keyEncryptor.password.CTPasswordKeyEncryptor;
import java.io.ByteArrayInputStream;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* loaded from: classes5.dex */
public class AgileEncryptionVerifier extends EncryptionVerifier {
    private List<AgileCertificateEntry> certList;

    public static class AgileCertificateEntry {
        byte[] certVerifier;
        byte[] encryptedKey;
        X509Certificate x509;
    }

    public AgileEncryptionVerifier(String str) {
        this(AgileEncryptionInfoBuilder.parseDescriptor(str));
    }

    protected AgileEncryptionVerifier(EncryptionDocument encryptionDocument) {
        this.certList = new ArrayList();
        Iterator<CTKeyEncryptor> it = encryptionDocument.getEncryption().getKeyEncryptors().getKeyEncryptorList().iterator();
        try {
            CTPasswordKeyEncryptor encryptedPasswordKey = it.next().getEncryptedPasswordKey();
            if (encryptedPasswordKey == null) {
                throw new NullPointerException("encryptedKey not set");
            }
            setCipherAlgorithm(CipherAlgorithm.fromXmlId(encryptedPasswordKey.getCipherAlgorithm().toString(), (int) encryptedPasswordKey.getKeyBits()));
            int hashSize = encryptedPasswordKey.getHashSize();
            setHashAlgorithm(HashAlgorithm.fromEcmaId(encryptedPasswordKey.getHashAlgorithm().toString()));
            if (getHashAlgorithm().hashSize != hashSize) {
                throw new EncryptedDocumentException("Unsupported hash algorithm: " + encryptedPasswordKey.getHashAlgorithm() + " @ " + hashSize + " bytes");
            }
            setSpinCount(encryptedPasswordKey.getSpinCount());
            setEncryptedVerifier(encryptedPasswordKey.getEncryptedVerifierHashInput());
            setSalt(encryptedPasswordKey.getSaltValue());
            setEncryptedKey(encryptedPasswordKey.getEncryptedKeyValue());
            setEncryptedVerifierHash(encryptedPasswordKey.getEncryptedVerifierHashValue());
            if (encryptedPasswordKey.getSaltSize() != getSalt().length) {
                throw new EncryptedDocumentException("Invalid salt size");
            }
            int intValue = encryptedPasswordKey.getCipherChaining().intValue();
            if (intValue == 1) {
                setChainingMode(ChainingMode.cbc);
            } else if (intValue == 2) {
                setChainingMode(ChainingMode.cfb);
            } else {
                throw new EncryptedDocumentException("Unsupported chaining mode - " + encryptedPasswordKey.getCipherChaining().toString());
            }
            if (it.hasNext()) {
                try {
                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                    while (it.hasNext()) {
                        CTCertificateKeyEncryptor encryptedCertificateKey = it.next().getEncryptedCertificateKey();
                        AgileCertificateEntry agileCertificateEntry = new AgileCertificateEntry();
                        agileCertificateEntry.certVerifier = encryptedCertificateKey.getCertVerifier();
                        agileCertificateEntry.encryptedKey = encryptedCertificateKey.getEncryptedKeyValue();
                        agileCertificateEntry.x509 = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(encryptedCertificateKey.getX509Certificate()));
                        this.certList.add(agileCertificateEntry);
                    }
                } catch (GeneralSecurityException e) {
                    throw new EncryptedDocumentException("can't parse X509 certificate", e);
                }
            }
        } catch (Exception e2) {
            throw new EncryptedDocumentException("Unable to parse keyData", e2);
        }
    }

    public AgileEncryptionVerifier(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.certList = new ArrayList();
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setChainingMode(chainingMode);
        setSpinCount(AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setSalt(byte[] bArr) {
        if (bArr == null || bArr.length != getCipherAlgorithm().blockSize) {
            throw new EncryptedDocumentException("invalid verifier salt");
        }
        super.setSalt(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedVerifier(byte[] bArr) {
        super.setEncryptedVerifier(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedVerifierHash(byte[] bArr) {
        super.setEncryptedVerifierHash(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    protected void setEncryptedKey(byte[] bArr) {
        super.setEncryptedKey(bArr);
    }

    public void addCertificate(X509Certificate x509Certificate) {
        AgileCertificateEntry agileCertificateEntry = new AgileCertificateEntry();
        agileCertificateEntry.x509 = x509Certificate;
        this.certList.add(agileCertificateEntry);
    }

    public List<AgileCertificateEntry> getCertificates() {
        return this.certList;
    }
}

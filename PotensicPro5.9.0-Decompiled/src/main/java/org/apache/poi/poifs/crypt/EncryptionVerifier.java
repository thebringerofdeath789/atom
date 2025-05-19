package org.apache.poi.poifs.crypt;

/* loaded from: classes5.dex */
public abstract class EncryptionVerifier {
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private byte[] encryptedKey;
    private byte[] encryptedVerifier;
    private byte[] encryptedVerifierHash;
    private HashAlgorithm hashAlgorithm;
    private byte[] salt;
    private int spinCount;

    protected EncryptionVerifier() {
    }

    public byte[] getSalt() {
        return this.salt;
    }

    @Deprecated
    public byte[] getVerifier() {
        return this.encryptedVerifier;
    }

    public byte[] getEncryptedVerifier() {
        return this.encryptedVerifier;
    }

    @Deprecated
    public byte[] getVerifierHash() {
        return this.encryptedVerifierHash;
    }

    public byte[] getEncryptedVerifierHash() {
        return this.encryptedVerifierHash;
    }

    public int getSpinCount() {
        return this.spinCount;
    }

    public int getCipherMode() {
        return this.chainingMode.ecmaId;
    }

    public int getAlgorithm() {
        return this.cipherAlgorithm.ecmaId;
    }

    @Deprecated
    public String getAlgorithmName() {
        return this.cipherAlgorithm.jceId;
    }

    public byte[] getEncryptedKey() {
        return this.encryptedKey;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    protected void setSalt(byte[] bArr) {
        this.salt = bArr;
    }

    protected void setEncryptedVerifier(byte[] bArr) {
        this.encryptedVerifier = bArr;
    }

    protected void setEncryptedVerifierHash(byte[] bArr) {
        this.encryptedVerifierHash = bArr;
    }

    protected void setEncryptedKey(byte[] bArr) {
        this.encryptedKey = bArr;
    }

    protected void setSpinCount(int i) {
        this.spinCount = i;
    }

    protected void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
    }

    protected void setChainingMode(ChainingMode chainingMode) {
        this.chainingMode = chainingMode;
    }

    protected void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }
}

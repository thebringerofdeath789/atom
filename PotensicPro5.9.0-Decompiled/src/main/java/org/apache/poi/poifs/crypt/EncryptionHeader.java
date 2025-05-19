package org.apache.poi.poifs.crypt;

/* loaded from: classes5.dex */
public abstract class EncryptionHeader {
    private int blockSize;
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private String cspName;
    private int flags;
    private HashAlgorithm hashAlgorithm;
    private int keyBits;
    private byte[] keySalt;
    private CipherProvider providerType;
    private int sizeExtra;
    public static final int ALGORITHM_RC4 = CipherAlgorithm.rc4.ecmaId;
    public static final int ALGORITHM_AES_128 = CipherAlgorithm.aes128.ecmaId;
    public static final int ALGORITHM_AES_192 = CipherAlgorithm.aes192.ecmaId;
    public static final int ALGORITHM_AES_256 = CipherAlgorithm.aes256.ecmaId;
    public static final int HASH_NONE = HashAlgorithm.none.ecmaId;
    public static final int HASH_SHA1 = HashAlgorithm.sha1.ecmaId;
    public static final int HASH_SHA256 = HashAlgorithm.sha256.ecmaId;
    public static final int HASH_SHA384 = HashAlgorithm.sha384.ecmaId;
    public static final int HASH_SHA512 = HashAlgorithm.sha512.ecmaId;
    public static final int PROVIDER_RC4 = CipherProvider.rc4.ecmaId;
    public static final int PROVIDER_AES = CipherProvider.aes.ecmaId;
    public static final int MODE_ECB = ChainingMode.ecb.ecmaId;
    public static final int MODE_CBC = ChainingMode.cbc.ecmaId;
    public static final int MODE_CFB = ChainingMode.cfb.ecmaId;

    protected EncryptionHeader() {
    }

    public int getCipherMode() {
        return this.chainingMode.ecmaId;
    }

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    protected void setChainingMode(ChainingMode chainingMode) {
        this.chainingMode = chainingMode;
    }

    public int getFlags() {
        return this.flags;
    }

    protected void setFlags(int i) {
        this.flags = i;
    }

    public int getSizeExtra() {
        return this.sizeExtra;
    }

    protected void setSizeExtra(int i) {
        this.sizeExtra = i;
    }

    public int getAlgorithm() {
        return this.cipherAlgorithm.ecmaId;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    protected void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
    }

    public int getHashAlgorithm() {
        return this.hashAlgorithm.ecmaId;
    }

    public HashAlgorithm getHashAlgorithmEx() {
        return this.hashAlgorithm;
    }

    protected void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    protected void setKeySize(int i) {
        this.keyBits = i;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    protected void setBlockSize(int i) {
        this.blockSize = i;
    }

    public byte[] getKeySalt() {
        return this.keySalt;
    }

    protected void setKeySalt(byte[] bArr) {
        this.keySalt = bArr;
    }

    public int getProviderType() {
        return this.providerType.ecmaId;
    }

    public CipherProvider getCipherProvider() {
        return this.providerType;
    }

    protected void setCipherProvider(CipherProvider cipherProvider) {
        this.providerType = cipherProvider;
    }

    public String getCspName() {
        return this.cspName;
    }

    protected void setCspName(String str) {
        this.cspName = str;
    }
}

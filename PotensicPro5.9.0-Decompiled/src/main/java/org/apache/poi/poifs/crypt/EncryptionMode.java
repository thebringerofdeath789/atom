package org.apache.poi.poifs.crypt;

/* loaded from: classes5.dex */
public enum EncryptionMode {
    binaryRC4("org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionInfoBuilder", 1, 1, 0),
    cryptoAPI("org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionInfoBuilder", 4, 2, 4),
    standard("org.apache.poi.poifs.crypt.standard.StandardEncryptionInfoBuilder", 4, 2, 36),
    agile("org.apache.poi.poifs.crypt.agile.AgileEncryptionInfoBuilder", 4, 4, 64);

    public final String builder;
    public final int encryptionFlags;
    public final int versionMajor;
    public final int versionMinor;

    EncryptionMode(String str, int i, int i2, int i3) {
        this.builder = str;
        this.versionMajor = i;
        this.versionMinor = i2;
        this.encryptionFlags = i3;
    }
}

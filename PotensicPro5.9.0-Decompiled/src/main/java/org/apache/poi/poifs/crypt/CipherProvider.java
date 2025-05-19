package org.apache.poi.poifs.crypt;

import org.apache.poi.EncryptedDocumentException;

/* loaded from: classes5.dex */
public enum CipherProvider {
    rc4("RC4", 1, "Microsoft Base Cryptographic Provider v1.0"),
    aes("AES", 24, "Microsoft Enhanced RSA and AES Cryptographic Provider");

    public final String cipherProviderName;
    public final int ecmaId;
    public final String jceId;

    public static CipherProvider fromEcmaId(int i) {
        for (CipherProvider cipherProvider : values()) {
            if (cipherProvider.ecmaId == i) {
                return cipherProvider;
            }
        }
        throw new EncryptedDocumentException("cipher provider not found");
    }

    CipherProvider(String str, int i, String str2) {
        this.jceId = str;
        this.ecmaId = i;
        this.cipherProviderName = str2;
    }
}

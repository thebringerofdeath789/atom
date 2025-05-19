package org.apache.poi.hssf.record.crypto;

import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.Decryptor;

/* loaded from: classes5.dex */
public abstract class Biff8EncryptionKey {
    private static final ThreadLocal<String> _userPasswordTLS = new ThreadLocal<>();
    protected SecretKey _secretKey;

    public static Biff8EncryptionKey create(byte[] bArr) {
        return Biff8RC4Key.create(Decryptor.DEFAULT_PASSWORD, bArr);
    }

    public static Biff8EncryptionKey create(String str, byte[] bArr) {
        return Biff8RC4Key.create(str, bArr);
    }

    public boolean validate(byte[] bArr, byte[] bArr2) {
        throw new EncryptedDocumentException("validate is not supported (in super-class).");
    }

    public static void setCurrentUserPassword(String str) {
        _userPasswordTLS.set(str);
    }

    public static String getCurrentUserPassword() {
        return _userPasswordTLS.get();
    }
}

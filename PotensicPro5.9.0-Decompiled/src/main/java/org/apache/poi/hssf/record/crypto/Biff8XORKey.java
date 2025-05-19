package org.apache.poi.hssf.record.crypto;

import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.poifs.crypt.CryptoFunctions;

/* loaded from: classes5.dex */
public class Biff8XORKey extends Biff8EncryptionKey {
    final int _xorKey;

    public Biff8XORKey(String str, int i) {
        this._xorKey = i;
        this._secretKey = new SecretKeySpec(CryptoFunctions.createXorArray1(str), "XOR");
    }

    public static Biff8XORKey create(String str, int i) {
        return new Biff8XORKey(str, i);
    }

    public boolean validate(String str, int i) {
        return this._xorKey == CryptoFunctions.createXorKey1(str) && CryptoFunctions.createXorVerifier1(str) == i;
    }
}

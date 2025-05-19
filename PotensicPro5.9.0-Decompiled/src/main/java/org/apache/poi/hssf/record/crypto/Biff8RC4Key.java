package org.apache.poi.hssf.record.crypto;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes5.dex */
public class Biff8RC4Key extends Biff8EncryptionKey {
    public static final int KEY_DIGEST_LENGTH = 5;
    private static final int PASSWORD_HASH_NUMBER_OF_BYTES_USED = 5;
    private static POILogger log = POILogFactory.getLogger((Class<?>) Biff8RC4Key.class);

    Biff8RC4Key(byte[] bArr) {
        if (bArr.length != 5) {
            throw new IllegalArgumentException("Expected 5 byte key digest, but got " + HexDump.toHex(bArr));
        }
        this._secretKey = new SecretKeySpec(bArr, CipherAlgorithm.rc4.jceId);
    }

    public static Biff8RC4Key create(String str, byte[] bArr) {
        return new Biff8RC4Key(createKeyDigest(str, bArr));
    }

    @Override // org.apache.poi.hssf.record.crypto.Biff8EncryptionKey
    public boolean validate(byte[] bArr, byte[] bArr2) {
        check16Bytes(bArr, "verifier");
        check16Bytes(bArr2, "verifierHash");
        Cipher cipher = getCipher();
        initCipherForBlock(cipher, 0);
        byte[] bArr3 = (byte[]) bArr.clone();
        byte[] bArr4 = (byte[]) bArr2.clone();
        try {
            cipher.update(bArr3, 0, bArr3.length, bArr3);
            cipher.update(bArr4, 0, bArr4.length, bArr4);
            MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.md5);
            messageDigest.update(bArr3);
            byte[] digest = messageDigest.digest();
            if (log.check(1)) {
                log.log(1, "valid verifierHash value", HexDump.toHex(xor(bArr2, xor(bArr4, digest))));
            }
            return Arrays.equals(bArr4, digest);
        } catch (ShortBufferException e) {
            throw new EncryptedDocumentException("buffer too short", e);
        }
    }

    Cipher getCipher() {
        return CryptoFunctions.getCipher(this._secretKey, CipherAlgorithm.rc4, null, null, 1);
    }

    static byte[] createKeyDigest(String str, byte[] bArr) {
        check16Bytes(bArr, "docId");
        int min = Math.min(str.length(), 16);
        byte[] bArr2 = new byte[min * 2];
        for (int i = 0; i < min; i++) {
            char charAt = str.charAt(i);
            int i2 = i * 2;
            bArr2[i2 + 0] = (byte) ((charAt << 0) & 255);
            bArr2[i2 + 1] = (byte) ((charAt << '\b') & 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.md5);
        messageDigest.update(bArr2);
        byte[] digest = messageDigest.digest();
        messageDigest.reset();
        for (int i3 = 0; i3 < 16; i3++) {
            messageDigest.update(digest, 0, 5);
            messageDigest.update(bArr, 0, bArr.length);
        }
        return CryptoFunctions.getBlock0(messageDigest.digest(), 5);
    }

    void initCipherForBlock(Cipher cipher, int i) {
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, 0, i);
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(HashAlgorithm.md5);
        messageDigest.update(this._secretKey.getEncoded());
        messageDigest.update(bArr);
        try {
            cipher.init(1, new SecretKeySpec(messageDigest.digest(), this._secretKey.getAlgorithm()));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Can't rekey for next block", e);
        }
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static void check16Bytes(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("Expected 16 byte " + str + ", but got " + HexDump.toHex(bArr));
        }
    }
}

package net.lingala.zip4j.crypto;

import java.util.Objects;
import java.util.Random;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

/* loaded from: classes4.dex */
public class StandardEncrypter implements IEncrypter {
    private byte[] headerBytes;
    private ZipCryptoEngine zipCryptoEngine;

    public StandardEncrypter(char[] cArr, int i) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty in standard encrpyter constructor");
        }
        this.zipCryptoEngine = new ZipCryptoEngine();
        this.headerBytes = new byte[12];
        init(cArr, i);
    }

    private void init(char[] cArr, int i) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.zipCryptoEngine.initKeys(cArr);
        this.headerBytes = generateRandomBytes(12);
        this.zipCryptoEngine.initKeys(cArr);
        byte[] bArr = this.headerBytes;
        bArr[11] = (byte) (i >>> 24);
        bArr[10] = (byte) (i >>> 16);
        if (bArr.length < 12) {
            throw new ZipException("invalid header bytes generated, cannot perform standard encryption");
        }
        encryptData(bArr);
    }

    @Override // net.lingala.zip4j.crypto.IEncrypter
    public int encryptData(byte[] bArr) throws ZipException {
        Objects.requireNonNull(bArr);
        return encryptData(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.crypto.IEncrypter
    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 < 0) {
            throw new ZipException("invalid length specified to decrpyt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                bArr[i3] = encryptByte(bArr[i3]);
            } catch (Exception e) {
                throw new ZipException(e);
            }
        }
        return i2;
    }

    protected byte encryptByte(byte b) {
        byte decryptByte = (byte) ((this.zipCryptoEngine.decryptByte() & 255) ^ b);
        this.zipCryptoEngine.updateKeys(b);
        return decryptByte;
    }

    protected byte[] generateRandomBytes(int i) throws ZipException {
        if (i <= 0) {
            throw new ZipException("size is either 0 or less than 0, cannot generate header for standard encryptor");
        }
        byte[] bArr = new byte[i];
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = encryptByte((byte) random.nextInt(256));
        }
        return bArr;
    }

    public byte[] getHeaderBytes() {
        return this.headerBytes;
    }
}

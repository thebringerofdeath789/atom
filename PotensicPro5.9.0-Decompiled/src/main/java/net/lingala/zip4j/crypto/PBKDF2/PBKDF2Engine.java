package net.lingala.zip4j.crypto.PBKDF2;

import java.util.Objects;
import net.lingala.zip4j.util.Raw;

/* loaded from: classes4.dex */
public class PBKDF2Engine {
    protected PBKDF2Parameters parameters;
    protected PRF prf;

    public PBKDF2Engine() {
        this.parameters = null;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
        this.prf = null;
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters, PRF prf) {
        this.parameters = pBKDF2Parameters;
        this.prf = prf;
    }

    public byte[] deriveKey(char[] cArr) {
        return deriveKey(cArr, 0);
    }

    public byte[] deriveKey(char[] cArr, int i) {
        Objects.requireNonNull(cArr);
        assertPRF(Raw.convertCharArrayToByteArray(cArr));
        if (i == 0) {
            i = this.prf.getHLen();
        }
        return PBKDF2(this.prf, this.parameters.getSalt(), this.parameters.getIterationCount(), i);
    }

    public boolean verifyKey(char[] cArr) {
        byte[] deriveKey;
        byte[] derivedKey = getParameters().getDerivedKey();
        if (derivedKey == null || derivedKey.length == 0 || (deriveKey = deriveKey(cArr, derivedKey.length)) == null || deriveKey.length != derivedKey.length) {
            return false;
        }
        for (int i = 0; i < deriveKey.length; i++) {
            if (deriveKey[i] != derivedKey[i]) {
                return false;
            }
        }
        return true;
    }

    protected void assertPRF(byte[] bArr) {
        if (this.prf == null) {
            this.prf = new MacBasedPRF(this.parameters.getHashAlgorithm());
        }
        this.prf.init(bArr);
    }

    public PRF getPseudoRandomFunction() {
        return this.prf;
    }

    protected byte[] PBKDF2(PRF prf, byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int hLen = prf.getHLen();
        int ceil = ceil(i2, hLen);
        int i3 = i2 - ((ceil - 1) * hLen);
        byte[] bArr3 = new byte[ceil * hLen];
        int i4 = 0;
        for (int i5 = 1; i5 <= ceil; i5++) {
            _F(bArr3, i4, prf, bArr2, i, i5);
            i4 += hLen;
        }
        if (i3 >= hLen) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(bArr3, 0, bArr4, 0, i2);
        return bArr4;
    }

    protected int ceil(int i, int i2) {
        return (i / i2) + (i % i2 > 0 ? 1 : 0);
    }

    protected void _F(byte[] bArr, int i, PRF prf, byte[] bArr2, int i2, int i3) {
        int hLen = prf.getHLen();
        byte[] bArr3 = new byte[hLen];
        byte[] bArr4 = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        INT(bArr4, bArr2.length, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            bArr4 = prf.doFinal(bArr4);
            xor(bArr3, bArr4);
        }
        System.arraycopy(bArr3, 0, bArr, i, hLen);
    }

    protected void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    protected void INT(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 / 16777216);
        bArr[i + 1] = (byte) (i2 / 65536);
        bArr[i + 2] = (byte) (i2 / 256);
        bArr[i + 3] = (byte) i2;
    }

    public PBKDF2Parameters getParameters() {
        return this.parameters;
    }

    public void setParameters(PBKDF2Parameters pBKDF2Parameters) {
        this.parameters = pBKDF2Parameters;
    }

    public void setPseudoRandomFunction(PRF prf) {
        this.prf = prf;
    }
}

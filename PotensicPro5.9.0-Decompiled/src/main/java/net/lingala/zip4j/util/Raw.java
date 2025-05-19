package net.lingala.zip4j.util;

import java.io.DataInput;
import java.io.IOException;
import java.util.Objects;
import net.lingala.zip4j.exception.ZipException;

/* loaded from: classes4.dex */
public class Raw {
    public static byte[] toByteArray(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static long readLongLittleEndian(byte[] bArr, int i) {
        return (bArr[i] & 255) | (((((((((((((((bArr[i + 7] & 255) | 0) << 8) | (bArr[i + 6] & 255)) << 8) | (bArr[i + 5] & 255)) << 8) | (bArr[i + 4] & 255)) << 8) | (bArr[i + 3] & 255)) << 8) | (bArr[i + 2] & 255)) << 8) | (bArr[i + 1] & 255)) << 8);
    }

    public static int readLeInt(DataInput dataInput, byte[] bArr) throws ZipException {
        try {
            dataInput.readFully(bArr, 0, 4);
            return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16);
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    public static int readShortLittleEndian(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static final short readShortBigEndian(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((short) (((short) ((bArr[i] & 255) | 0)) << 8)));
    }

    public static int readIntLittleEndian(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public static byte[] toByteArray(int i, int i2) {
        byte[] bArr = new byte[i2];
        byte[] byteArray = toByteArray(i);
        for (int i3 = 0; i3 < byteArray.length && i3 < i2; i3++) {
            bArr[i3] = byteArray[i3];
        }
        return bArr;
    }

    public static final void writeShortLittleEndian(byte[] bArr, int i, short s) {
        bArr[i + 1] = (byte) (s >>> 8);
        bArr[i] = (byte) (s & 255);
    }

    public static final void writeIntLittleEndian(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >>> 24);
        bArr[i + 2] = (byte) (i2 >>> 16);
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public static void writeLongLittleEndian(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) (j >>> 56);
        bArr[i + 6] = (byte) (j >>> 48);
        bArr[i + 5] = (byte) (j >>> 40);
        bArr[i + 4] = (byte) (j >>> 32);
        bArr[i + 3] = (byte) (j >>> 24);
        bArr[i + 2] = (byte) (j >>> 16);
        bArr[i + 1] = (byte) (j >>> 8);
        bArr[i] = (byte) (j & 255);
    }

    public static byte bitArrayToByte(int[] iArr) throws ZipException {
        if (iArr == null) {
            throw new ZipException("bit array is null, cannot calculate byte from bits");
        }
        if (iArr.length != 8) {
            throw new ZipException("invalid bit array length, cannot calculate byte");
        }
        if (!checkBits(iArr)) {
            throw new ZipException("invalid bits provided, bits contain other values than 0 or 1");
        }
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            i = (int) (i + (Math.pow(2.0d, i2) * iArr[i2]));
        }
        return (byte) i;
    }

    private static boolean checkBits(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != 0 && iArr[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void prepareBuffAESIVBytes(byte[] bArr, int i, int i2) {
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) (i >> 24);
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 0;
        bArr[13] = 0;
        bArr[14] = 0;
        bArr[15] = 0;
    }

    public static byte[] convertCharArrayToByteArray(char[] cArr) {
        Objects.requireNonNull(cArr);
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }
}

package com.ipotensic.baselib.netty;

import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.text.DecimalFormat;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class ParseUtil {
    public static int getBit(byte b, int i) {
        return (b >> i) & 1;
    }

    public static int getHigh4(byte b) {
        return (b & 240) >> 4;
    }

    public static int getLow4(byte b) {
        return b & 15;
    }

    public static int getUnsignedByte(byte b) {
        return b & 255;
    }

    public static int getUnsignedShort(short s) {
        return s & 65535;
    }

    public static byte[] intBigByteArr(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] longToBytesBig(long j) {
        return new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    public static byte[] longToBytesLittle(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 56) & 255)};
    }

    public static byte setBit(byte b, int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = b | (1 << i);
        } else {
            if (i2 != 0) {
                return b;
            }
            i3 = b & (~(1 << i));
        }
        return (byte) i3;
    }

    public static byte[] short2ByteArr(short s) {
        return new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)};
    }

    public static byte[] short2ByteArr1(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    public static byte[] short2ByteArrSmall(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    public static int hexStringToAlgorism(String str) {
        String upperCase = str.toUpperCase();
        int i = 0;
        for (int length = upperCase.length(); length > 0; length--) {
            char charAt = upperCase.charAt(length - 1);
            i = (int) (i + (Math.pow(16.0d, r0 - length) * ((charAt < '0' || charAt > '9') ? charAt - '7' : charAt - '0')));
        }
        return i;
    }

    public static String intToHexString(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() % 2 != 0) {
            hexString = SessionDescription.SUPPORTED_SDP_VERSION + hexString;
        }
        return hexString.toUpperCase();
    }

    public static byte[] hexStringToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            bArr[i] = Byte.valueOf((byte) Integer.decode("0x" + str.substring(i2, i3) + str.substring(i3, i3 + 1)).intValue()).byteValue();
        }
        return bArr;
    }

    public static String byteToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = SessionDescription.SUPPORTED_SDP_VERSION + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString().trim();
    }

    public static String byteToHexString(byte b) {
        return byteToHexString(new byte[]{b});
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int contain(byte[] r9, byte[] r10) {
        /*
            r0 = -1
            if (r9 == 0) goto L2f
            if (r10 != 0) goto L6
            goto L2f
        L6:
            int r1 = r9.length
            int r2 = r10.length
            if (r1 >= r2) goto Lb
            return r0
        Lb:
            int r1 = r1 - r2
            int r1 = r1 + 1
            r3 = 0
            r4 = r3
        L10:
            if (r4 >= r1) goto L2f
            r5 = r3
        L13:
            if (r5 >= r2) goto L2c
            int r6 = r4 + r5
            r7 = r9[r6]
            r8 = r10[r5]
            if (r7 == r8) goto L1e
            goto L2c
        L1e:
            int r7 = r2 + (-1)
            if (r5 != r7) goto L29
            r6 = r9[r6]
            r7 = r10[r5]
            if (r6 != r7) goto L29
            return r4
        L29:
            int r5 = r5 + 1
            goto L13
        L2c:
            int r4 = r4 + 1
            goto L10
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.baselib.netty.ParseUtil.contain(byte[], byte[]):int");
    }

    public static String byteToHexString(byte[] bArr, int i) {
        if (bArr.length < i) {
            i = bArr.length;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                hexString = SessionDescription.SUPPORTED_SDP_VERSION + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString().trim();
    }

    public static String byteToHexString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder("");
        for (int i3 = 0; i3 < i2; i3++) {
            String hexString = Integer.toHexString(bArr[i3 + i] & 255);
            if (hexString.length() == 1) {
                hexString = SessionDescription.SUPPORTED_SDP_VERSION + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString().trim();
    }

    public static void intBigByteArr(int i, byte[] bArr, int i2) {
        int i3;
        if (bArr == null || (i3 = i2 + 3) > bArr.length - 1) {
            return;
        }
        bArr[i3] = (byte) (i & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2] = (byte) (i >>> 24);
    }

    public static void intSmallByteArr(int i, byte[] bArr, int i2) {
        int i3;
        if (bArr == null || (i3 = i2 + 3) > bArr.length - 1) {
            return;
        }
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i3] = (byte) (i >>> 24);
    }

    public static int byteArrayToInt(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        int length = bArr.length - 1;
        int i = 3;
        while (i >= 0) {
            if (length >= 0) {
                bArr2[i] = bArr[length];
            } else {
                bArr2[i] = 0;
            }
            i--;
            length--;
        }
        return ((bArr2[0] & 255) << 24) + ((bArr2[1] & 255) << 16) + ((bArr2[2] & 255) << 8) + (bArr2[3] & 255);
    }

    public static float getFloatFromBytesSmall(byte[] bArr, int i) {
        return Float.intBitsToFloat(((bArr[i] & 255) << 24) | ((bArr[i + 3] & 255) << 0) | 0 | ((bArr[i + 2] & 255) << 8) | ((bArr[i + 1] & 255) << 16));
    }

    public static float getFloatFromBytesBig(byte[] bArr, int i) {
        return Float.intBitsToFloat(((bArr[i + 3] & 255) << 24) | ((bArr[i] & 255) << 0) | 0 | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16));
    }

    public static byte[] float2byte(float f) {
        int floatToIntBits = Float.floatToIntBits(f);
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr[i] = (byte) (floatToIntBits >> (24 - (i * 8)));
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        for (int i2 = 0; i2 < 2; i2++) {
            byte b = bArr2[i2];
            int i3 = (4 - i2) - 1;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b;
        }
        return bArr2;
    }

    public static byte[] long2ByteArr(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((j >> (64 - (r3 * 8))) & 255);
        }
        return bArr;
    }

    public static long byteArrayToLong(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | (bArr[i] & 255);
        }
        return j;
    }

    public static long byteArrayToLong(byte[] bArr, int i) {
        int i2 = i + 7;
        long j = 0;
        if (bArr.length <= i2) {
            return 0L;
        }
        if (i2 < bArr.length) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i3 << 3;
                j |= (255 << i4) & (bArr[i + i3] << i4);
            }
        }
        return j;
    }

    public static long byteArrayToLongBig(byte[] bArr, int i) {
        int i2 = i + 7;
        long j = 0;
        if (bArr.length <= i2) {
            return 0L;
        }
        if (i2 < bArr.length) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = (7 - i3) << 3;
                j |= (255 << i4) & (bArr[i + i3] << i4);
            }
        }
        return j;
    }

    public static void short2ByteArr(short s, byte[] bArr, int i) {
        int i2;
        if (bArr == null || (i2 = i + 1) > bArr.length - 1) {
            return;
        }
        bArr[i2] = (byte) ((s >> 8) & 255);
        bArr[i] = (byte) (s & 255);
    }

    public static int getUnsignedShortFromByteArr(byte[] bArr, int i) {
        int i2 = i + 1;
        if (i2 > bArr.length - 1) {
            return -1;
        }
        return getUnsignedShort((short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255)));
    }

    public static byte[] interceptBytes(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length < i + i2) {
            return null;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static short getSignedShortFromByteArr(byte[] bArr, int i) {
        int i2 = i + 1;
        if (i2 > bArr.length - 1) {
            return (short) -1;
        }
        return (short) (((bArr[i2] & 255) << 8) | (bArr[i] & 255));
    }

    public static int getIntFromByteArr(byte[] bArr, int i) {
        if (i + 3 > bArr.length - 1) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 += (bArr[i3 + i] & 255) << (i3 * 8);
        }
        return i2;
    }

    public static int getBigIntFromByteArr(byte[] bArr, int i) {
        if (i + 3 > bArr.length - 1) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 += (bArr[i3 + i] & 255) << ((3 - i3) * 8);
        }
        return i2;
    }

    public static short byteArr2short(byte[] bArr) {
        byte b = bArr[0];
        return (short) ((bArr[1] & 255) | ((b & 255) << 8));
    }

    public static short byteArr2short1(byte[] bArr) {
        byte b = bArr[1];
        return (short) ((bArr[0] & 255) | ((b & 255) << 8));
    }

    public static String divInt(int i, int i2, int i3) {
        String str = "0.";
        for (int i4 = 0; i4 < i3; i4++) {
            str = str + SessionDescription.SUPPORTED_SDP_VERSION;
        }
        return new DecimalFormat(str).format(i / i2);
    }

    public static byte[] concatAll(byte[]... bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
            i2 += bArr4.length;
        }
        return bArr3;
    }

    public static byte decodeBinaryString(String str) {
        int parseInt;
        if (str == null) {
            return (byte) 0;
        }
        String replace = str.replace(StringUtils.SPACE, "");
        int length = replace.length();
        if (length != 4 && length != 8) {
            return (byte) 0;
        }
        if (length == 8) {
            if (replace.charAt(0) == '0') {
                parseInt = Integer.parseInt(replace, 2);
            } else {
                parseInt = Integer.parseInt(replace, 2) + InputDeviceCompat.SOURCE_ANY;
            }
        } else {
            parseInt = Integer.parseInt(replace, 2);
        }
        return (byte) parseInt;
    }

    public static String byteToBit(byte b) {
        return "" + ((int) ((byte) ((b >> 7) & 1))) + ((int) ((byte) ((b >> 6) & 1))) + ((int) ((byte) ((b >> 5) & 1))) + ((int) ((byte) ((b >> 4) & 1))) + ((int) ((byte) ((b >> 3) & 1))) + ((int) ((byte) ((b >> 2) & 1))) + ((int) ((byte) ((b >> 1) & 1))) + ((int) ((byte) ((b >> 0) & 1)));
    }

    public static int getByteContainIndex(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null && bArr.length != 0 && bArr2.length != 0 && bArr.length >= bArr2.length) {
            int i = 0;
            while (true) {
                int i2 = 1;
                if (i >= (bArr.length - bArr2.length) + 1) {
                    break;
                }
                if (bArr[i] == bArr2[0]) {
                    while (i2 < bArr2.length && bArr[i + i2] == bArr2[i2]) {
                        i2++;
                    }
                    if (i2 == bArr2.length) {
                        return i;
                    }
                }
                i++;
            }
        }
        return -1;
    }

    public static byte getByteFromBits(byte b, int i, int i2) {
        if (i > 7 || i2 > 7) {
            return b;
        }
        byte b2 = 0;
        int i3 = 0;
        for (int i4 = i; i4 < i + i2 + 1; i4++) {
            b2 = setBit(b2, i3, getBit(b, i4));
            i3++;
        }
        return b2;
    }

    public static String getAllBit(byte b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(getBit(b, i));
        }
        String sb2 = sb.reverse().toString();
        sb.delete(0, sb.length());
        return sb2;
    }

    public static boolean isBytesEqual(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int byteToDecimalInt(byte b) {
        return Integer.valueOf("" + (b & 255), 10).intValue();
    }

    public static byte getCheckCode(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        if (i == i2) {
            return b;
        }
        while (true) {
            i++;
            if (i > i2) {
                return b;
            }
            b = (byte) (b ^ bArr[i]);
        }
    }

    public static int getCRC32(byte[] bArr, int i, int i2) {
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = i3;
            for (int i5 = 8; i5 > 0; i5--) {
                i4 = (i4 & 1) == 1 ? (i4 >> 1) ^ (-306674912) : i4 >> 1;
            }
            iArr[i3] = i4;
        }
        int i6 = -1;
        while (i < i2) {
            i6 = iArr[(((byte) i6) & 255) ^ bArr[i]] ^ (i6 >> 8);
            i++;
        }
        return ~i6;
    }
}

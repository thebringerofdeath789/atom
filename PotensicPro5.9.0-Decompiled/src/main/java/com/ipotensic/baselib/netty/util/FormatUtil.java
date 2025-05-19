package com.ipotensic.baselib.netty.util;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* loaded from: classes2.dex */
public class FormatUtil {
    public static String StringToAsciiString(String str) {
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < length; i++) {
            str2 = str2 + Integer.toHexString(str.charAt(i));
        }
        return str2;
    }

    public static String hexStringToString(String str, int i) {
        int length = str.length() / i;
        String str2 = "";
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            i2++;
            str2 = str2 + ((char) hexStringToAlgorism(str.substring(i3, i2 * i)));
        }
        return str2;
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

    public static String hexStringToBinary(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        String str2 = "";
        for (int i = 0; i < length; i++) {
            char charAt = upperCase.charAt(i);
            switch (charAt) {
                case '0':
                    str2 = str2 + "0000";
                    break;
                case '1':
                    str2 = str2 + "0001";
                    break;
                case '2':
                    str2 = str2 + "0010";
                    break;
                case '3':
                    str2 = str2 + "0011";
                    break;
                case '4':
                    str2 = str2 + "0100";
                    break;
                case '5':
                    str2 = str2 + "0101";
                    break;
                case '6':
                    str2 = str2 + "0110";
                    break;
                case '7':
                    str2 = str2 + "0111";
                    break;
                case '8':
                    str2 = str2 + "1000";
                    break;
                case '9':
                    str2 = str2 + "1001";
                    break;
                default:
                    switch (charAt) {
                        case 'A':
                            str2 = str2 + "1010";
                            break;
                        case 'B':
                            str2 = str2 + "1011";
                            break;
                        case 'C':
                            str2 = str2 + "1100";
                            break;
                        case 'D':
                            str2 = str2 + "1101";
                            break;
                        case 'E':
                            str2 = str2 + "1110";
                            break;
                        case 'F':
                            str2 = str2 + "1111";
                            break;
                    }
            }
        }
        return str2;
    }

    public static String AsciiStringToString(String str) {
        int length = str.length() / 2;
        String str2 = "";
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            str2 = str2 + String.valueOf((char) hexStringToAlgorism(str.substring(i2, i2 + 2)));
        }
        return str2;
    }

    public static String algorismToHEXString(int i, int i2) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() % 2 == 1) {
            hexString = SessionDescription.SUPPORTED_SDP_VERSION + hexString;
        }
        return patchHexString(hexString.toUpperCase(), i2);
    }

    public static String bytetoString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + ((char) b);
        }
        return str;
    }

    public static int binaryToAlgorism(String str) {
        int i = 0;
        for (int length = str.length(); length > 0; length--) {
            i = (int) (i + (Math.pow(2.0d, r0 - length) * (str.charAt(length - 1) - '0')));
        }
        return i;
    }

    public static String algorismToHEXString(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() % 2 == 1) {
            hexString = SessionDescription.SUPPORTED_SDP_VERSION + hexString;
        }
        return hexString.toUpperCase();
    }

    public static String patchHexString(String str, int i) {
        String str2 = "";
        for (int i2 = 0; i2 < i - str.length(); i2++) {
            str2 = SessionDescription.SUPPORTED_SDP_VERSION + str2;
        }
        return (str2 + str).substring(0, i);
    }

    public static int parseToInt(String str, int i, int i2) {
        try {
            return Integer.parseInt(str, i2);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int parseToInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static byte[] hexStringToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        String hexStringToBinary = hexStringToBinary(str);
        int i = 0;
        while (i < length) {
            int i2 = i * 8;
            int i3 = i + 1;
            bArr[i] = (byte) binaryToAlgorism(hexStringToBinary.substring(i2 + 1, i3 * 8));
            if (hexStringToBinary.charAt(i2) == '1') {
                bArr[i] = (byte) (0 - bArr[i]);
            }
            i = i3;
        }
        return bArr;
    }

    public static final byte[] hex2byte(String str) throws IllegalArgumentException {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[str.length() / 2];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            bArr[i2] = new Integer(Integer.parseInt("" + charArray[i] + charArray[i3], 16) & 255).byteValue();
            i = i3 + 1;
            i2++;
        }
        return bArr;
    }

    public static final String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + SessionDescription.SUPPORTED_SDP_VERSION + hexString;
            } else {
                str = str + hexString;
            }
        }
        return str.toUpperCase();
    }
}

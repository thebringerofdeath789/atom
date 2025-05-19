package com.logan.nativeapp;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* loaded from: classes3.dex */
public class ParseUtils {
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

    public static int binaryToAlgorism(String str) {
        int i = 0;
        for (int length = str.length(); length > 0; length--) {
            i = (int) (i + (Math.pow(2.0d, r0 - length) * (str.charAt(length - 1) - '0')));
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
}

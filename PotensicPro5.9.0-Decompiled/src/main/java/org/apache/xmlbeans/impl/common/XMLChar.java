package org.apache.xmlbeans.impl.common;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import okhttp3.internal.http.StatusLine;
import okio.Utf8;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.telnet.TelnetCommand;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes5.dex */
public class XMLChar {
    private static final byte[] CHARS = new byte[65536];
    public static final int MASK_CONTENT = 32;
    public static final int MASK_NAME = 8;
    public static final int MASK_NAME_START = 4;
    public static final int MASK_NCNAME = 128;
    public static final int MASK_NCNAME_START = 64;
    public static final int MASK_PUBID = 16;
    public static final int MASK_SPACE = 2;
    public static final int MASK_VALID = 1;

    public static char highSurrogate(int i) {
        return (char) (((i - 65536) >> 10) + 55296);
    }

    public static boolean isHighSurrogate(int i) {
        return 55296 <= i && i <= 56319;
    }

    public static boolean isLowSurrogate(int i) {
        return 56320 <= i && i <= 57343;
    }

    public static boolean isMarkup(int i) {
        return i == 60 || i == 38 || i == 37;
    }

    public static boolean isSupplemental(int i) {
        return i >= 65536 && i <= 1114111;
    }

    public static char lowSurrogate(int i) {
        return (char) (((i - 65536) & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    public static int supplemental(char c, char c2) {
        return ((c - 55296) * 1024) + (c2 - Utf8.LOG_SURROGATE_HEADER) + 65536;
    }

    static {
        int[] iArr;
        int[] iArr2 = {9, 10, 13, 13, 32, 55295, 57344, Utf8.REPLACEMENT_CODE_POINT};
        int[] iArr3 = {32, 9, 13, 10};
        int[] iArr4 = {45, 46};
        int[] iArr5 = {58, 95};
        int[] iArr6 = {10, 13, 32, 33, 35, 36, 37, 61, 95};
        int[] iArr7 = {39, 59, 63, 90, 97, 122};
        int[] iArr8 = {65, 90, 97, 122, 192, 214, 216, TelnetCommand.AYT, TelnetCommand.EL, 305, StatusLine.HTTP_PERM_REDIRECT, 318, 321, 328, 330, 382, 384, 451, 461, 496, 500, 501, 506, FTPReply.FAILED_SECURITY_CHECK, 592, 680, 699, 705, 904, 906, 910, 929, 931, 974, 976, 982, 994, 1011, 1025, AnalyticsListener.EVENT_PLAYER_RELEASED, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, 1103, 1105, 1116, 1118, 1153, 1168, 1220, 1223, 1224, 1227, 1228, 1232, 1259, 1262, 1269, 1272, 1273, 1329, 1366, 1377, 1414, 1488, 1514, 1520, 1522, 1569, 1594, 1601, 1610, 1649, 1719, 1722, 1726, 1728, 1742, 1744, 1747, 1765, 1766, 2309, 2361, 2392, 2401, 2437, 2444, 2447, 2448, 2451, 2472, 2474, 2480, 2486, 2489, 2524, 2525, 2527, 2529, 2544, 2545, 2565, 2570, 2575, 2576, 2579, 2600, 2602, 2608, 2610, 2611, 2613, 2614, 2616, 2617, 2649, 2652, 2674, 2676, 2693, 2699, 2703, 2705, 2707, 2728, 2730, 2736, 2738, 2739, 2741, 2745, 2821, 2828, 2831, 2832, 2835, 2856, 2858, 2864, 2866, 2867, 2870, 2873, 2908, 2909, 2911, 2913, 2949, 2954, 2958, 2960, 2962, 2965, 2969, 2970, 2974, 2975, 2979, 2980, 2984, 2986, 2990, 2997, 2999, 3001, 3077, 3084, 3086, 3088, 3090, 3112, 3114, 3123, 3125, 3129, 3168, 3169, 3205, 3212, 3214, 3216, 3218, 3240, 3242, 3251, 3253, 3257, 3296, 3297, 3333, 3340, 3342, 3344, 3346, 3368, 3370, 3385, 3424, 3425, 3585, 3630, 3634, 3635, 3648, 3653, 3713, 3714, 3719, 3720, 3732, 3735, 3737, 3743, 3745, 3747, 3754, 3755, 3757, 3758, 3762, 3763, 3776, 3780, 3904, 3911, 3913, 3945, 4256, 4293, 4304, 4342, 4354, 4355, 4357, 4359, 4363, 4364, 4366, 4370, 4436, 4437, 4447, 4449, 4461, 4462, 4466, 4467, 4526, 4527, 4535, 4536, 4540, 4546, 7680, 7835, 7840, 7929, 7936, 7957, 7960, 7965, 7968, 8005, 8008, 8013, 8016, 8023, 8031, 8061, 8064, 8116, 8118, 8124, 8130, 8132, 8134, 8140, 8144, 8147, 8150, 8155, 8160, 8172, 8178, 8180, 8182, 8188, 8490, 8491, 8576, 8578, 12353, 12436, 12449, 12538, 12549, 12588, 44032, 55203, 12321, 12329, 19968, 40869};
        int[] iArr9 = {IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT, 908, 986, 988, FTPSClient.DEFAULT_FTPS_PORT, 992, 1369, 1749, 2365, 2482, 2654, 2701, 2749, 2784, 2877, 2972, 3294, 3632, 3716, 3722, 3725, 3749, 3751, 3760, 3773, 4352, 4361, 4412, 4414, 4416, 4428, 4430, 4432, 4441, 4451, 4453, 4455, 4457, 4469, 4510, 4520, 4523, 4538, 4587, 4592, 4601, 8025, 8027, 8029, 8126, 8486, 8494, 12295};
        int[] iArr10 = {768, 837, 864, 865, 1155, 1158, 1425, 1441, 1443, 1465, 1467, 1469, 1473, 1474, 1611, 1618, 1750, 1756, 1757, 1759, 1760, 1764, 1767, 1768, 1770, 1773, 2305, 2307, 2366, 2380, 2385, 2388, 2402, 2403, 2433, 2435, 2496, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 2503, 2504, 2507, 2509, 2530, 2531, 2624, 2626, 2631, 2632, 2635, 2637, 2672, 2673, 2689, 2691, 2750, 2757, 2759, 2761, 2763, 2765, 2817, 2819, 2878, 2883, 2887, 2888, 2891, 2893, 2902, 2903, 2946, 2947, 3006, 3010, 3014, 3016, 3018, 3021, 3073, 3075, 3134, 3140, 3142, 3144, 3146, 3149, 3157, 3158, 3202, 3203, 3262, 3268, 3270, 3272, 3274, 3277, 3285, 3286, 3330, 3331, 3390, 3395, 3398, 3400, 3402, 3405, 3636, 3642, 3655, 3662, 3764, 3769, 3771, 3772, 3784, 3789, 3864, 3865, 3953, 3972, 3974, 3979, 3984, 3989, 3993, 4013, 4017, 4023, 8400, 8412, 12330, 12335};
        int[] iArr11 = {1471, 1476, 1648, 2364, 2381, 2492, 2494, 2495, 2519, 2562, 2620, 2622, 2623, 2748, 2876, 3031, 3415, 3633, 3761, 3893, 3895, 3897, 3902, 3903, 3991, 4025, 8417, 12441, 12442};
        int[] iArr12 = {48, 57, 1632, 1641, 1776, 1785, 2406, 2415, 2534, 2543, 2662, 2671, 2790, 2799, 2918, 2927, 3047, 3055, 3174, 3183, 3302, 3311, 3430, 3439, 3664, 3673, 3792, 3801, 3872, 3881};
        int[] iArr13 = {12337, 12341, 12445, 12446, 12540, 12542};
        int[] iArr14 = {183, 720, 721, 903, 1600, 3654, 3782, 12293};
        int[] iArr15 = {60, 38, 10, 13, 93};
        int i = 0;
        for (int i2 = 8; i < i2; i2 = 8) {
            int i3 = iArr2[i];
            while (true) {
                iArr = iArr7;
                if (i3 <= iArr2[i + 1]) {
                    byte[] bArr = CHARS;
                    bArr[i3] = (byte) (bArr[i3] | 33);
                    i3++;
                    iArr7 = iArr;
                    iArr2 = iArr2;
                }
            }
            i += 2;
            iArr7 = iArr;
        }
        int[] iArr16 = iArr7;
        for (int i4 = 0; i4 < 5; i4++) {
            byte[] bArr2 = CHARS;
            bArr2[iArr15[i4]] = (byte) (bArr2[iArr15[i4]] & (-33));
        }
        for (int i5 = 0; i5 < 4; i5++) {
            byte[] bArr3 = CHARS;
            int i6 = iArr3[i5];
            bArr3[i6] = (byte) (bArr3[i6] | 2);
        }
        int i7 = 0;
        for (int i8 = 2; i7 < i8; i8 = 2) {
            byte[] bArr4 = CHARS;
            int i9 = iArr5[i7];
            bArr4[i9] = (byte) (bArr4[i9] | 204);
            i7++;
        }
        for (int i10 = 0; i10 < 302; i10 += 2) {
            for (int i11 = iArr8[i10]; i11 <= iArr8[i10 + 1]; i11++) {
                byte[] bArr5 = CHARS;
                bArr5[i11] = (byte) (bArr5[i11] | 204);
            }
        }
        for (int i12 = 0; i12 < 53; i12++) {
            byte[] bArr6 = CHARS;
            int i13 = iArr9[i12];
            bArr6[i13] = (byte) (bArr6[i13] | 204);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            byte[] bArr7 = CHARS;
            int i15 = iArr4[i14];
            bArr7[i15] = (byte) (bArr7[i15] | 136);
        }
        for (int i16 = 0; i16 < 30; i16 += 2) {
            for (int i17 = iArr12[i16]; i17 <= iArr12[i16 + 1]; i17++) {
                byte[] bArr8 = CHARS;
                bArr8[i17] = (byte) (bArr8[i17] | 136);
            }
        }
        for (int i18 = 0; i18 < 132; i18 += 2) {
            for (int i19 = iArr10[i18]; i19 <= iArr10[i18 + 1]; i19++) {
                byte[] bArr9 = CHARS;
                bArr9[i19] = (byte) (bArr9[i19] | 136);
            }
        }
        for (int i20 = 0; i20 < 29; i20++) {
            byte[] bArr10 = CHARS;
            int i21 = iArr11[i20];
            bArr10[i21] = (byte) (bArr10[i21] | 136);
        }
        for (int i22 = 0; i22 < 6; i22 += 2) {
            for (int i23 = iArr13[i22]; i23 <= iArr13[i22 + 1]; i23++) {
                byte[] bArr11 = CHARS;
                bArr11[i23] = (byte) (bArr11[i23] | 136);
            }
        }
        for (int i24 = 0; i24 < 8; i24++) {
            byte[] bArr12 = CHARS;
            int i25 = iArr14[i24];
            bArr12[i25] = (byte) (bArr12[i25] | 136);
        }
        byte[] bArr13 = CHARS;
        bArr13[58] = (byte) (bArr13[58] & (-193));
        for (int i26 = 0; i26 < 9; i26++) {
            byte[] bArr14 = CHARS;
            int i27 = iArr6[i26];
            bArr14[i27] = (byte) (bArr14[i27] | 16);
        }
        for (int i28 = 0; i28 < 6; i28 += 2) {
            for (int i29 = iArr16[i28]; i29 <= iArr16[i28 + 1]; i29++) {
                byte[] bArr15 = CHARS;
                bArr15[i29] = (byte) (bArr15[i29] | 16);
            }
        }
    }

    public static boolean isValid(int i) {
        if (i >= 65536 || (CHARS[i] & 1) == 0) {
            return 65536 <= i && i <= 1114111;
        }
        return true;
    }

    public static boolean isInvalid(int i) {
        return !isValid(i);
    }

    public static boolean isContent(int i) {
        return (i < 65536 && (CHARS[i] & 32) != 0) || (65536 <= i && i <= 1114111);
    }

    public static boolean isSpace(int i) {
        return i < 65536 && (CHARS[i] & 2) != 0;
    }

    public static boolean isXML11Space(int i) {
        return (i < 65536 && (CHARS[i] & 2) != 0) || i == 133 || i == 8232;
    }

    public static boolean isNameStart(int i) {
        return i < 65536 && (CHARS[i] & 4) != 0;
    }

    public static boolean isName(int i) {
        return i < 65536 && (CHARS[i] & 8) != 0;
    }

    public static boolean isNCNameStart(int i) {
        return i < 65536 && (CHARS[i] & 64) != 0;
    }

    public static boolean isNCName(int i) {
        return i < 65536 && (CHARS[i] & 128) != 0;
    }

    public static boolean isPubid(int i) {
        return i < 65536 && (CHARS[i] & 16) != 0;
    }

    public static boolean isValidName(String str) {
        if (str.length() == 0 || !isNameStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!isName(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidNCName(String str) {
        if (str.length() == 0 || !isNCNameStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!isNCName(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidNmtoken(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isName(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIANAEncoding(String str) {
        int length;
        char charAt;
        if (str == null || (length = str.length()) <= 0 || (((charAt = str.charAt(0)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
            return false;
        }
        for (int i = 1; i < length; i++) {
            char charAt2 = str.charAt(i);
            if ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < 'a' || charAt2 > 'z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '.' || charAt2 == '_' || charAt2 == '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidJavaEncoding(String str) {
        int length;
        if (str == null || (length = str.length()) <= 0) {
            return false;
        }
        for (int i = 1; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '.' || charAt == '_' || charAt == '-'))) {
                return false;
            }
        }
        return true;
    }
}

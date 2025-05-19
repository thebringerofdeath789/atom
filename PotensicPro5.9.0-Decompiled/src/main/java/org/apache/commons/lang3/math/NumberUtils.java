package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Long LONG_INT_MAX_VALUE = 2147483647L;
    public static final Long LONG_INT_MIN_VALUE = -2147483648L;

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int compare(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, 0.0d);
    }

    public static double toDouble(BigDecimal bigDecimal, double d) {
        return bigDecimal == null ? d : bigDecimal.doubleValue();
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Float f) {
        return toScaledBigDecimal(f, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Float f, int i, RoundingMode roundingMode) {
        if (f == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(f.floatValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(Double d) {
        return toScaledBigDecimal(d, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double d, int i, RoundingMode roundingMode) {
        if (d == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d.doubleValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(String str, int i, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i, roundingMode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x011d, code lost:
    
        if (r2 == 'l') goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Number createNumber(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static String getMantissa(String str, int i) {
        char charAt = str.charAt(0);
        return charAt == '-' || charAt == '+' ? str.substring(1, i) : str.substring(0, i);
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return !str.isEmpty();
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.math.BigInteger createBigInteger(java.lang.String r5) {
        /*
            if (r5 != 0) goto L4
            r5 = 0
            return r5
        L4:
            r0 = 10
            java.lang.String r1 = "-"
            boolean r1 = r5.startsWith(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L12
            r2 = r3
            goto L13
        L12:
            r3 = r2
        L13:
            java.lang.String r1 = "0x"
            boolean r1 = r5.startsWith(r1, r2)
            r4 = 16
            if (r1 != 0) goto L45
            java.lang.String r1 = "0X"
            boolean r1 = r5.startsWith(r1, r2)
            if (r1 == 0) goto L26
            goto L45
        L26:
            java.lang.String r1 = "#"
            boolean r1 = r5.startsWith(r1, r2)
            if (r1 == 0) goto L31
            int r2 = r2 + 1
            goto L47
        L31:
            java.lang.String r1 = "0"
            boolean r1 = r5.startsWith(r1, r2)
            if (r1 == 0) goto L48
            int r1 = r5.length()
            int r4 = r2 + 1
            if (r1 <= r4) goto L48
            r0 = 8
            r2 = r4
            goto L48
        L45:
            int r2 = r2 + 2
        L47:
            r0 = r4
        L48:
            java.math.BigInteger r1 = new java.math.BigInteger
            java.lang.String r5 = r5.substring(r2)
            r1.<init>(r5, r0)
            if (r3 == 0) goto L57
            java.math.BigInteger r1 = r1.negate()
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.createBigInteger(java.lang.String):java.math.BigInteger");
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(str);
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] < d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    private static void validateArray(Object obj) {
        Validate.notNull(obj, "array", new Object[0]);
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00e7, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00e8, code lost:
    
        if (r13 == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00ea, code lost:
    
        if (r14 != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00ec, code lost:
    
        if (r15 != false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ef, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00f0, code lost:
    
        if (r7 != false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00f2, code lost:
    
        if (r13 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00f5, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0114, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0130, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r3 >= r0.length) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a6, code lost:
    
        if (r0[r3] < '0') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00aa, code lost:
    
        if (r0[r3] > '9') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ac, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00af, code lost:
    
        if (r0[r3] == 'e') goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00b3, code lost:
    
        if (r0[r3] != 'E') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b8, code lost:
    
        if (r0[r3] != '.') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ba, code lost:
    
        if (r15 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00bc, code lost:
    
        if (r14 == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00bf, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00c0, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c1, code lost:
    
        if (r7 != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00c7, code lost:
    
        if (r0[r3] == 'd') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00cd, code lost:
    
        if (r0[r3] == 'D') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00d1, code lost:
    
        if (r0[r3] == 'f') goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00d7, code lost:
    
        if (r0[r3] != 'F') goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00d9, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00de, code lost:
    
        if (r0[r3] == 'l') goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00e4, code lost:
    
        if (r0[r3] != 'L') goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCreatable(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.NumberUtils.isCreatable(java.lang.String):boolean");
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return withDecimalsParsing(str, 1);
        }
        return withDecimalsParsing(str, 0);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            boolean z = str.charAt(i) == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}

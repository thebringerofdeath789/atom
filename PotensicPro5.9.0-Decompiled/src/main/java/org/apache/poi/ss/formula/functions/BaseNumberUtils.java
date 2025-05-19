package org.apache.poi.ss.formula.functions;

/* loaded from: classes5.dex */
public class BaseNumberUtils {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double convertToDecimal(java.lang.String r17, int r18, int r19) throws java.lang.IllegalArgumentException {
        /*
            r0 = r18
            r1 = r19
            r2 = 0
            if (r17 == 0) goto L86
            int r4 = r17.length()
            if (r4 != 0) goto L10
            goto L86
        L10:
            int r4 = r17.length()
            long r4 = (long) r4
            long r6 = (long) r1
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L80
            r5 = 0
            char[] r7 = r17.toCharArray()
            int r8 = r7.length
            r9 = 0
            r10 = 1
            r15 = r2
            r2 = r9
            r3 = r10
        L26:
            if (r2 >= r8) goto L67
            char r11 = r7[r2]
            r12 = 48
            if (r12 > r11) goto L36
            r12 = 57
            if (r11 > r12) goto L36
            int r11 = r11 + (-48)
        L34:
            long r11 = (long) r11
            goto L4f
        L36:
            r12 = 65
            if (r12 > r11) goto L43
            r12 = 90
            if (r11 > r12) goto L43
            int r11 = r11 + (-65)
        L40:
            int r11 = r11 + 10
            goto L34
        L43:
            r12 = 97
            if (r12 > r11) goto L4e
            r12 = 122(0x7a, float:1.71E-43)
            if (r11 > r12) goto L4e
            int r11 = r11 + (-97)
            goto L40
        L4e:
            long r11 = (long) r0
        L4f:
            long r13 = (long) r0
            int r13 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r13 >= 0) goto L5f
            if (r3 == 0) goto L58
            r3 = r9
            r5 = r11
        L58:
            double r13 = (double) r0
            double r15 = r15 * r13
            double r11 = (double) r11
            double r15 = r15 + r11
            int r2 = r2 + 1
            goto L26
        L5f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "character not allowed"
            r0.<init>(r1)
            throw r0
        L67:
            if (r3 != 0) goto L73
            if (r4 != 0) goto L73
            int r2 = r0 / 2
            long r2 = (long) r2
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 < 0) goto L73
            r9 = r10
        L73:
            if (r9 == 0) goto L7f
            double r11 = (double) r0
            double r13 = (double) r1
            double r0 = getTwoComplement(r11, r13, r15)
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            double r15 = r0 * r2
        L7f:
            return r15
        L80:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L86:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.formula.functions.BaseNumberUtils.convertToDecimal(java.lang.String, int, int):double");
    }

    private static double getTwoComplement(double d, double d2, double d3) {
        return Math.pow(d, d2) - d3;
    }
}

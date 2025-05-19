package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class DurationFormatUtils {
    static final String H = "H";
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    static final String M = "M";
    static final String S = "S";
    static final String d = "d";
    static final String m = "m";
    static final String s = "s";
    static final String y = "y";

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "HH:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false);
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Validate.inclusiveBetween(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
        Token[] lexx = lexx(str);
        if (Token.containsTokenWithValue(lexx, d)) {
            long j8 = j / 86400000;
            j2 = j - (86400000 * j8);
            j3 = j8;
        } else {
            j2 = j;
            j3 = 0;
        }
        if (Token.containsTokenWithValue(lexx, H)) {
            long j9 = j2 / DateUtils.MILLIS_PER_HOUR;
            j2 -= DateUtils.MILLIS_PER_HOUR * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (Token.containsTokenWithValue(lexx, m)) {
            long j10 = j2 / 60000;
            j2 -= 60000 * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            long j11 = j2 / 1000;
            j7 = j2 - (1000 * j11);
            j6 = j11;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return format(lexx, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = StringUtils.SPACE + formatDuration;
            String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (!formatDuration.isEmpty()) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.SPACE + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i = 0;
        Validate.isTrue(j <= j2, "startMillis must not be greater than endMillis", new Object[0]);
        Token[] lexx = lexx(str);
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(new Date(j2));
        int i2 = calendar2.get(14) - calendar.get(14);
        int i3 = calendar2.get(13) - calendar.get(13);
        int i4 = calendar2.get(12) - calendar.get(12);
        int i5 = calendar2.get(11) - calendar.get(11);
        int i6 = calendar2.get(5) - calendar.get(5);
        int i7 = calendar2.get(2) - calendar.get(2);
        int i8 = calendar2.get(1) - calendar.get(1);
        while (i2 < 0) {
            i2 += 1000;
            i3--;
        }
        while (i3 < 0) {
            i3 += 60;
            i4--;
        }
        while (i4 < 0) {
            i4 += 60;
            i5--;
        }
        while (i5 < 0) {
            i5 += 24;
            i6--;
        }
        if (Token.containsTokenWithValue(lexx, M)) {
            while (i6 < 0) {
                i6 += calendar.getActualMaximum(5);
                i7--;
                calendar.add(2, 1);
            }
            while (i7 < 0) {
                i7 += 12;
                i8--;
            }
            if (!Token.containsTokenWithValue(lexx, y) && i8 != 0) {
                while (i8 != 0) {
                    i7 += i8 * 12;
                    i8 = 0;
                }
            }
        } else {
            if (!Token.containsTokenWithValue(lexx, y)) {
                int i9 = calendar2.get(1);
                if (i7 < 0) {
                    i9--;
                }
                while (calendar.get(1) != i9) {
                    int actualMaximum = i6 + (calendar.getActualMaximum(6) - calendar.get(6));
                    if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                        actualMaximum++;
                    }
                    calendar.add(1, 1);
                    i6 = actualMaximum + calendar.get(6);
                }
                i8 = 0;
            }
            while (calendar.get(2) != calendar2.get(2)) {
                i6 += calendar.getActualMaximum(5);
                calendar.add(2, 1);
            }
            i7 = 0;
            while (i6 < 0) {
                i6 += calendar.getActualMaximum(5);
                i7--;
                calendar.add(2, 1);
            }
        }
        if (!Token.containsTokenWithValue(lexx, d)) {
            i5 += i6 * 24;
            i6 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, H)) {
            i4 += i5 * 60;
            i5 = 0;
        }
        if (!Token.containsTokenWithValue(lexx, m)) {
            i3 += i4 * 60;
            i4 = 0;
        }
        if (Token.containsTokenWithValue(lexx, s)) {
            i = i3;
        } else {
            i2 += i3 * 1000;
        }
        return format(lexx, i8, i7, i6, i5, i4, i, i2, z);
    }

    static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        Token[] tokenArr2 = tokenArr;
        StringBuilder sb = new StringBuilder();
        int length = tokenArr2.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            Token token = tokenArr2[i3];
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuilder) {
                sb.append(value.toString());
                i2 = length;
                i = i3;
            } else {
                if (value.equals(y)) {
                    sb.append(paddedValue(j, z, count));
                    i2 = length;
                    i = i3;
                } else {
                    if (value.equals(M)) {
                        i = i3;
                        sb.append(paddedValue(j2, z, count));
                    } else {
                        i = i3;
                        if (value.equals(d)) {
                            sb.append(paddedValue(j3, z, count));
                        } else if (value.equals(H)) {
                            sb.append(paddedValue(j4, z, count));
                            i2 = length;
                        } else if (value.equals(m)) {
                            sb.append(paddedValue(j5, z, count));
                            i2 = length;
                        } else {
                            if (value.equals(s)) {
                                i2 = length;
                                sb.append(paddedValue(j6, z, count));
                                z2 = true;
                            } else {
                                i2 = length;
                                if (value.equals(S)) {
                                    if (z2) {
                                        sb.append(paddedValue(j7, true, z ? Math.max(3, count) : 3));
                                    } else {
                                        sb.append(paddedValue(j7, z, count));
                                    }
                                    z2 = false;
                                }
                            }
                            i3 = i + 1;
                            length = i2;
                            tokenArr2 = tokenArr;
                        }
                    }
                    i2 = length;
                }
                z2 = false;
            }
            i3 = i + 1;
            length = i2;
            tokenArr2 = tokenArr;
        }
        return sb.toString();
    }

    private static String paddedValue(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? StringUtils.leftPad(l, i, '0') : l;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static org.apache.commons.lang3.time.DurationFormatUtils.Token[] lexx(java.lang.String r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length()
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r3 = r1
            r4 = r3
            r5 = r2
            r6 = r5
        Lf:
            int r7 = r9.length()
            if (r3 >= r7) goto L9f
            char r7 = r9.charAt(r3)
            r8 = 39
            if (r4 == 0) goto L24
            if (r7 == r8) goto L24
            r5.append(r7)
            goto L9b
        L24:
            if (r7 == r8) goto L6a
            r8 = 72
            if (r7 == r8) goto L67
            r8 = 77
            if (r7 == r8) goto L64
            r8 = 83
            if (r7 == r8) goto L61
            r8 = 100
            if (r7 == r8) goto L5e
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L5b
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L58
            r8 = 121(0x79, float:1.7E-43)
            if (r7 == r8) goto L55
            if (r5 != 0) goto L51
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r8 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r8.<init>(r5)
            r0.add(r8)
        L51:
            r5.append(r7)
            goto L7e
        L55:
            java.lang.String r7 = "y"
            goto L7f
        L58:
            java.lang.String r7 = "s"
            goto L7f
        L5b:
            java.lang.String r7 = "m"
            goto L7f
        L5e:
            java.lang.String r7 = "d"
            goto L7f
        L61:
            java.lang.String r7 = "S"
            goto L7f
        L64:
            java.lang.String r7 = "M"
            goto L7f
        L67:
            java.lang.String r7 = "H"
            goto L7f
        L6a:
            if (r4 == 0) goto L70
            r4 = r1
            r5 = r2
            r7 = r5
            goto L7f
        L70:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            org.apache.commons.lang3.time.DurationFormatUtils$Token r4 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r4.<init>(r5)
            r0.add(r4)
            r4 = 1
        L7e:
            r7 = r2
        L7f:
            if (r7 == 0) goto L9b
            if (r6 == 0) goto L91
            java.lang.Object r5 = r6.getValue()
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L91
            r6.increment()
            goto L9a
        L91:
            org.apache.commons.lang3.time.DurationFormatUtils$Token r5 = new org.apache.commons.lang3.time.DurationFormatUtils$Token
            r5.<init>(r7)
            r0.add(r5)
            r6 = r5
        L9a:
            r5 = r2
        L9b:
            int r3 = r3 + 1
            goto Lf
        L9f:
            if (r4 != 0) goto Lac
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = org.apache.commons.lang3.time.DurationFormatUtils.Token.access$000()
            java.lang.Object[] r9 = r0.toArray(r9)
            org.apache.commons.lang3.time.DurationFormatUtils$Token[] r9 = (org.apache.commons.lang3.time.DurationFormatUtils.Token[]) r9
            return r9
        Lac:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unmatched quote in format: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DurationFormatUtils.lexx(java.lang.String):org.apache.commons.lang3.time.DurationFormatUtils$Token[]");
    }

    static class Token {
        private static final Token[] EMPTY_ARRAY = new Token[0];
        private int count;
        private final Object value;

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token token : tokenArr) {
                if (token.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }

        void increment() {
            this.count++;
        }

        int getCount() {
            return this.count;
        }

        Object getValue() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            return obj2 == token.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return StringUtils.repeat(this.value.toString(), this.count);
        }
    }
}

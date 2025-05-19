package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    private enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw nullDateIllegalArgumentException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return isSameDay(calendar, calendar2);
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw nullDateIllegalArgumentException();
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw nullDateIllegalArgumentException();
        }
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw nullDateIllegalArgumentException();
        }
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw nullDateIllegalArgumentException();
        }
        return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, false);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale2 = LocaleUtils.toLocale(locale);
        ParsePosition parsePosition = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance(timeZone, locale2);
        calendar.setLenient(z);
        for (String str2 : strArr) {
            FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale2);
            calendar.clear();
            try {
                if (fastDateParser.parse(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                    return calendar.getTime();
                }
            } catch (IllegalArgumentException unused) {
            }
            parsePosition.setIndex(0);
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    private static Date add(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i, i2);
        return calendar.getTime();
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    private static Date set(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(i, i2);
        return calendar.getTime();
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        return calendar;
    }

    public static Date round(Date date, int i) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i, ModifyType.ROUND);
        return calendar.getTime();
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar == null) {
            throw nullDateIllegalArgumentException();
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        modify(calendar2, i, ModifyType.ROUND);
        return calendar2;
    }

    private static IllegalArgumentException nullDateIllegalArgumentException() {
        return new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        }
        if (obj instanceof Date) {
            return round((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return round((Calendar) obj, i).getTime();
        }
        throw new ClassCastException("Could not round " + obj);
    }

    public static Date truncate(Date date, int i) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i, ModifyType.TRUNCATE);
        return calendar.getTime();
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar == null) {
            throw nullDateIllegalArgumentException();
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        modify(calendar2, i, ModifyType.TRUNCATE);
        return calendar2;
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        }
        if (obj instanceof Date) {
            return truncate((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return truncate((Calendar) obj, i).getTime();
        }
        throw new ClassCastException("Could not truncate " + obj);
    }

    public static Date ceiling(Date date, int i) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i, ModifyType.CEILING);
        return calendar.getTime();
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar == null) {
            throw nullDateIllegalArgumentException();
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        modify(calendar2, i, ModifyType.CEILING);
        return calendar2;
    }

    public static Date ceiling(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        }
        if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return ceiling((Calendar) obj, i).getTime();
        }
        throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
    }

    private static void modify(Calendar calendar, int i, ModifyType modifyType) {
        int i2;
        char c;
        boolean z;
        int i3;
        boolean z2;
        char c2;
        if (calendar.get(1) > 280000000) {
            throw new ArithmeticException("Calendar value too large for accurate calculations");
        }
        if (i == 14) {
            return;
        }
        Date time = calendar.getTime();
        long time2 = time.getTime();
        int i4 = calendar.get(14);
        if (ModifyType.TRUNCATE == modifyType || i4 < 500) {
            time2 -= i4;
        }
        boolean z3 = i == 13;
        int i5 = calendar.get(13);
        if (!z3 && (ModifyType.TRUNCATE == modifyType || i5 < 30)) {
            time2 -= i5 * 1000;
        }
        if (i == 12) {
            z3 = true;
        }
        int i6 = calendar.get(12);
        if (!z3 && (ModifyType.TRUNCATE == modifyType || i6 < 30)) {
            time2 -= i6 * 60000;
        }
        if (time.getTime() != time2) {
            time.setTime(time2);
            calendar.setTime(time);
        }
        int[][] iArr = fields;
        int length = iArr.length;
        int i7 = 0;
        boolean z4 = false;
        while (i7 < length) {
            int[] iArr2 = iArr[i7];
            for (int i8 : iArr2) {
                if (i8 == i) {
                    if (modifyType == ModifyType.CEILING || (modifyType == ModifyType.ROUND && z4)) {
                        if (i == 1001) {
                            if (calendar.get(5) == 1) {
                                calendar.add(5, 15);
                                return;
                            } else {
                                calendar.add(5, -15);
                                calendar.add(2, 1);
                                return;
                            }
                        }
                        if (i == 9) {
                            if (calendar.get(11) == 0) {
                                calendar.add(11, 12);
                                return;
                            } else {
                                calendar.add(11, -12);
                                calendar.add(5, 1);
                                return;
                            }
                        }
                        calendar.add(iArr2[0], 1);
                        return;
                    }
                    return;
                }
            }
            if (i != 9) {
                if (i == 1001 && iArr2[0] == 5) {
                    i2 = calendar.get(5) - 1;
                    if (i2 >= 15) {
                        i2 -= 15;
                    }
                    z = i2 > 7;
                    c = '\f';
                    i3 = i2;
                    z2 = true;
                }
                c = '\f';
                z = z4;
                z2 = false;
                i3 = 0;
            } else {
                if (iArr2[0] == 11) {
                    i2 = calendar.get(11);
                    c = '\f';
                    if (i2 >= 12) {
                        i2 -= 12;
                    }
                    z = i2 >= 6;
                    i3 = i2;
                    z2 = true;
                }
                c = '\f';
                z = z4;
                z2 = false;
                i3 = 0;
            }
            if (z2) {
                c2 = 0;
            } else {
                c2 = 0;
                int actualMinimum = calendar.getActualMinimum(iArr2[0]);
                int actualMaximum = calendar.getActualMaximum(iArr2[0]);
                int i9 = calendar.get(iArr2[0]) - actualMinimum;
                z = i9 > (actualMaximum - actualMinimum) / 2;
                i3 = i9;
            }
            if (i3 != 0) {
                calendar.set(iArr2[c2], calendar.get(iArr2[c2]) - i3);
            }
            i7++;
            z4 = z;
        }
        throw new IllegalArgumentException("The field " + i + " is not supported");
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return iterator(calendar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080 A[LOOP:0: B:20:0x007a->B:22:0x0080, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a A[LOOP:1: B:24:0x0084->B:26:0x008a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L94
            r0 = -1
            r1 = 2
            r2 = 5
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L44;
                case 2: goto L44;
                case 3: goto L44;
                case 4: goto L44;
                case 5: goto L29;
                case 6: goto L29;
                default: goto La;
            }
        La:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The range style "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r9 = r0.append(r9)
            java.lang.String r0 = " is not valid."
            java.lang.StringBuilder r9 = r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L29:
            java.util.Calendar r8 = truncate(r8, r1)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r1, r3)
            r5.add(r2, r0)
            r6 = 6
            if (r9 != r6) goto L3f
            r6 = r5
            r5 = r8
            goto L69
        L3f:
            r1 = r3
            r6 = r5
            r5 = r8
        L42:
            r8 = r4
            goto L6a
        L44:
            java.util.Calendar r5 = truncate(r8, r2)
            java.util.Calendar r6 = truncate(r8, r2)
            if (r9 == r1) goto L69
            r1 = 3
            if (r9 == r1) goto L62
            r7 = 4
            if (r9 == r7) goto L56
            r1 = r3
            goto L42
        L56:
            int r9 = r8.get(r4)
            int r9 = r9 - r1
            int r8 = r8.get(r4)
            int r8 = r8 + r1
            r1 = r9
            goto L6a
        L62:
            int r1 = r8.get(r4)
            int r8 = r1 + (-1)
            goto L6a
        L69:
            r8 = r3
        L6a:
            if (r1 >= r3) goto L6e
            int r1 = r1 + 7
        L6e:
            if (r1 <= r4) goto L72
            int r1 = r1 + (-7)
        L72:
            if (r8 >= r3) goto L76
            int r8 = r8 + 7
        L76:
            if (r8 <= r4) goto L7a
            int r8 = r8 + (-7)
        L7a:
            int r9 = r5.get(r4)
            if (r9 == r1) goto L84
            r5.add(r2, r0)
            goto L7a
        L84:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L8e
            r6.add(r2, r3)
            goto L84
        L8e:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L94:
            java.lang.IllegalArgumentException r8 = nullDateIllegalArgumentException()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        }
        if (obj instanceof Date) {
            return iterator((Date) obj, i);
        }
        if (obj instanceof Calendar) {
            return iterator((Calendar) obj, i);
        }
        throw new ClassCastException("Could not iterate based on " + obj);
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.SECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, TimeUnit.HOURS);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, TimeUnit.DAYS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.SECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.HOURS);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.DAYS);
    }

    private static long getFragment(Date date, int i, TimeUnit timeUnit) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFragment(calendar, i, timeUnit);
    }

    private static long getFragment(Calendar calendar, int i, TimeUnit timeUnit) {
        long convert;
        if (calendar == null) {
            throw nullDateIllegalArgumentException();
        }
        long j = 0;
        int i2 = timeUnit == TimeUnit.DAYS ? 0 : 1;
        if (i == 1) {
            convert = timeUnit.convert(calendar.get(6) - i2, TimeUnit.DAYS);
        } else {
            if (i == 2) {
                convert = timeUnit.convert(calendar.get(5) - i2, TimeUnit.DAYS);
            }
            if (i != 1 || i == 2 || i == 5 || i == 6) {
                j += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
            } else {
                switch (i) {
                    case 11:
                        break;
                    case 12:
                        j += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                    case 13:
                        return j + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                    case 14:
                        return j;
                    default:
                        throw new IllegalArgumentException("The fragment " + i + " is not supported");
                }
            }
            j += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
            j += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            return j + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
        }
        j = 0 + convert;
        if (i != 1) {
        }
        j += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
        j += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
        j += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
        return j + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    private static void validateDateNotNull(Date date) {
        Validate.notNull(date, "date", new Object[0]);
    }

    static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (this.spot.equals(this.endFinal)) {
                throw new NoSuchElementException();
            }
            this.spot.add(5, 1);
            return (Calendar) this.spot.clone();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

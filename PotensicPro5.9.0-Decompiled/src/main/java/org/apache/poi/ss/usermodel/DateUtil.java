package org.apache.poi.ss.usermodel;

import com.mapbox.android.accounts.v1.MapboxAccounts;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes5.dex */
public class DateUtil {
    private static final int BAD_DATE = -1;
    public static final long DAY_MILLISECONDS = 86400000;
    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_MINUTE = 60;
    private static final Pattern TIME_SEPARATOR_PATTERN = Pattern.compile(":");
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
    private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
    private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/,. :\"\\\\]+0*[ampAMP/]*$");
    private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    private static ThreadLocal<Integer> lastFormatIndex = new ThreadLocal<Integer>() { // from class: org.apache.poi.ss.usermodel.DateUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return -1;
        }
    };
    private static ThreadLocal<String> lastFormatString = new ThreadLocal<>();
    private static ThreadLocal<Boolean> lastCachedResult = new ThreadLocal<>();

    public static boolean isInternalDateFormat(int i) {
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                switch (i) {
                    case 45:
                    case 46:
                    case 47:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static boolean isValidExcelDate(double d) {
        return d > -4.9E-324d;
    }

    protected DateUtil() {
    }

    public static double getExcelDate(Date date) {
        return getExcelDate(date, false);
    }

    public static double getExcelDate(Date date, boolean z) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return internalGetExcelDate(gregorianCalendar, z);
    }

    public static double getExcelDate(Calendar calendar, boolean z) {
        return internalGetExcelDate((Calendar) calendar.clone(), z);
    }

    private static double internalGetExcelDate(Calendar calendar, boolean z) {
        if (!z && calendar.get(1) < 1900) {
            return -1.0d;
        }
        if (z && calendar.get(1) < 1904) {
            return -1.0d;
        }
        double absoluteDay = (((((((calendar.get(11) * 60) + calendar.get(12)) * 60) + calendar.get(13)) * 1000) + calendar.get(14)) / 8.64E7d) + absoluteDay(dayStart(calendar), z);
        return (z || absoluteDay < 60.0d) ? z ? absoluteDay - 1.0d : absoluteDay : absoluteDay + 1.0d;
    }

    public static Date getJavaDate(double d, TimeZone timeZone) {
        return getJavaDate(d, false, timeZone);
    }

    public static Date getJavaDate(double d) {
        return getJavaDate(d, (TimeZone) null);
    }

    public static Date getJavaDate(double d, boolean z, TimeZone timeZone) {
        return getJavaCalendar(d, z, timeZone, false).getTime();
    }

    public static Date getJavaDate(double d, boolean z, TimeZone timeZone, boolean z2) {
        return getJavaCalendar(d, z, timeZone, z2).getTime();
    }

    public static Date getJavaDate(double d, boolean z) {
        return getJavaCalendar(d, z, null, false).getTime();
    }

    public static void setCalendar(Calendar calendar, int i, int i2, boolean z, boolean z2) {
        int i3;
        int i4 = 1900;
        if (z) {
            i4 = 1904;
            i3 = 1;
        } else {
            i3 = i < 61 ? 0 : -1;
        }
        calendar.set(i4, 0, i + i3, 0, 0, 0);
        calendar.set(14, i2);
        if (z2) {
            calendar.add(14, 500);
            calendar.clear(14);
        }
    }

    public static Calendar getJavaCalendar(double d) {
        return getJavaCalendar(d, false, (TimeZone) null, false);
    }

    public static Calendar getJavaCalendar(double d, boolean z) {
        return getJavaCalendar(d, z, (TimeZone) null, false);
    }

    public static Calendar getJavaCalendarUTC(double d, boolean z) {
        return getJavaCalendar(d, z, TIMEZONE_UTC, false);
    }

    public static Calendar getJavaCalendar(double d, boolean z, TimeZone timeZone) {
        return getJavaCalendar(d, z, timeZone, false);
    }

    public static Calendar getJavaCalendar(double d, boolean z, TimeZone timeZone, boolean z2) {
        GregorianCalendar gregorianCalendar;
        if (!isValidExcelDate(d)) {
            return null;
        }
        int floor = (int) Math.floor(d);
        int i = (int) (((d - floor) * 8.64E7d) + 0.5d);
        if (timeZone != null) {
            gregorianCalendar = new GregorianCalendar(timeZone);
        } else {
            gregorianCalendar = new GregorianCalendar();
        }
        setCalendar(gregorianCalendar, floor, i, z, z2);
        return gregorianCalendar;
    }

    private static boolean isCached(String str, int i) {
        String str2 = lastFormatString.get();
        return str2 != null && i == lastFormatIndex.get().intValue() && str.equals(str2);
    }

    private static void cache(String str, int i, boolean z) {
        lastFormatIndex.set(Integer.valueOf(i));
        lastFormatString.set(str);
        lastCachedResult.set(Boolean.valueOf(z));
    }

    public static boolean isADateFormat(int i, String str) {
        if (isInternalDateFormat(i)) {
            cache(str, i, true);
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        if (isCached(str, i)) {
            return lastCachedResult.get().booleanValue();
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (i2 < str.length() - 1) {
                int i3 = i2 + 1;
                char charAt2 = str.charAt(i3);
                if (charAt == '\\') {
                    if (charAt2 != ' ' && charAt2 != '\\') {
                        switch (charAt2) {
                        }
                    }
                } else if (charAt == ';' && charAt2 == '@') {
                    i2 = i3;
                }
                i2++;
            }
            sb.append(charAt);
            i2++;
        }
        String sb2 = sb.toString();
        if (date_ptrn4.matcher(sb2).matches()) {
            cache(str, i, true);
            return true;
        }
        String replaceAll = date_ptrn2.matcher(date_ptrn1.matcher(sb2).replaceAll("")).replaceAll("");
        if (replaceAll.indexOf(59) > 0 && replaceAll.indexOf(59) < replaceAll.length() - 1) {
            replaceAll = replaceAll.substring(0, replaceAll.indexOf(59));
        }
        if (!date_ptrn3a.matcher(replaceAll).find()) {
            return false;
        }
        boolean matches = date_ptrn3b.matcher(replaceAll).matches();
        cache(str, i, matches);
        return matches;
    }

    public static boolean isCellDateFormatted(Cell cell) {
        CellStyle cellStyle;
        if (cell == null || !isValidExcelDate(cell.getNumericCellValue()) || (cellStyle = cell.getCellStyle()) == null) {
            return false;
        }
        return isADateFormat(cellStyle.getDataFormat(), cellStyle.getDataFormatString());
    }

    public static boolean isCellInternalDateFormatted(Cell cell) {
        if (cell != null && isValidExcelDate(cell.getNumericCellValue())) {
            return isInternalDateFormat(cell.getCellStyle().getDataFormat());
        }
        return false;
    }

    protected static int absoluteDay(Calendar calendar, boolean z) {
        return calendar.get(6) + daysInPriorYears(calendar.get(1), z);
    }

    private static int daysInPriorYears(int i, boolean z) {
        if ((!z && i < 1900) || (z && i < 1900)) {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }
        int i2 = i - 1;
        return ((i - (z ? 1904 : 1900)) * 365) + ((((i2 / 4) - (i2 / 100)) + (i2 / NNTPReply.SERVICE_DISCONTINUED)) - 460);
    }

    private static Calendar dayStart(Calendar calendar) {
        calendar.get(11);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.get(11);
        return calendar;
    }

    private static final class FormatException extends Exception {
        public FormatException(String str) {
            super(str);
        }
    }

    public static double convertTime(String str) {
        try {
            return convertTimeInternal(str);
        } catch (FormatException e) {
            throw new IllegalArgumentException("Bad time format '" + str + "' expected 'HH:MM' or 'HH:MM:SS' - " + e.getMessage());
        }
    }

    private static double convertTimeInternal(String str) throws FormatException {
        String str2;
        int length = str.length();
        if (length < 4 || length > 8) {
            throw new FormatException("Bad length");
        }
        String[] split = TIME_SEPARATOR_PATTERN.split(str);
        int length2 = split.length;
        if (length2 == 2) {
            str2 = MapboxAccounts.SKU_ID_MAPS_MAUS;
        } else if (length2 == 3) {
            str2 = split[2];
        } else {
            throw new FormatException("Expected 2 or 3 fields but got (" + split.length + ")");
        }
        String str3 = split[0];
        String str4 = split[1];
        int parseInt = parseInt(str3, "hour", 24);
        return (parseInt(str2, "second", 60) + ((parseInt(str4, "minute", 60) + (parseInt * 60)) * 60)) / 86400.0d;
    }

    public static Date parseYYYYMMDDDate(String str) {
        try {
            return parseYYYYMMDDDateInternal(str);
        } catch (FormatException e) {
            throw new IllegalArgumentException("Bad time format " + str + " expected 'YYYY/MM/DD' - " + e.getMessage());
        }
    }

    private static Date parseYYYYMMDDDateInternal(String str) throws FormatException {
        if (str.length() != 10) {
            throw new FormatException("Bad length");
        }
        String substring = str.substring(0, 4);
        String substring2 = str.substring(5, 7);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(parseInt(substring, "year", -32768, 32767), parseInt(substring2, "month", 1, 12) - 1, parseInt(str.substring(8, 10), "day", 1, 31), 0, 0, 0);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTime();
    }

    private static int parseInt(String str, String str2, int i) throws FormatException {
        return parseInt(str, str2, 0, i - 1);
    }

    private static int parseInt(String str, String str2, int i, int i2) throws FormatException {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < i || parseInt > i2) {
                throw new FormatException(str2 + " value (" + parseInt + ") is outside the allowable range(0.." + i2 + ")");
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            throw new FormatException("Bad int format '" + str + "' for " + str2 + " field");
        }
    }
}

package com.ipotensic.baselib.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes2.dex */
public class DateUtils {
    public static final String YMDHMS1 = "yyyy-MM-dd HH-mm-ss";
    public static final String YMDHMS2 = "yyyy-MM-dd";
    public static final String YMDHMS3 = "HH:mm:ss";

    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static boolean isSameDay(long j, long j2) {
        String sdfTime = getSdfTime(j, YMDHMS1);
        String sdfTime2 = getSdfTime(j2, YMDHMS1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YMDHMS1, Locale.US);
        try {
            return Math.abs(differentDays(simpleDateFormat.parse(sdfTime), simpleDateFormat.parse(sdfTime2))) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int differentDays(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int i = calendar.get(6);
        int i2 = calendar2.get(6);
        int i3 = calendar.get(1);
        int i4 = calendar2.get(1);
        if (i3 == i4) {
            return i2 - i;
        }
        int i5 = 0;
        while (i3 < i4) {
            i5 = ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % NNTPReply.SERVICE_DISCONTINUED != 0) ? i5 + 365 : i5 + 366;
            i3++;
        }
        return i5 + (i2 - i);
    }

    public static String getSdfTime(String str, String str2) {
        return new SimpleDateFormat(str2, Locale.US).format(new Date(Long.valueOf(str).longValue()));
    }

    public static String getSdfTime(long j, String str) {
        return getSdfTime(j + "", str);
    }

    public static String getEnglishDate(long j) {
        return new SimpleDateFormat("MMM dd, yyyy", Locale.US).format(new Date(j));
    }

    public static String stringForTime(long j) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(5) + "," + (calendar.get(2) + 1) + "," + calendar.get(1);
    }
}

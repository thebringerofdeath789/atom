package com.ipotensic.baselib.utils;

import android.text.format.Time;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.DDLog;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FormatUtil {
    public static String secondToHHmmss(int i) {
        String str;
        String str2;
        String str3;
        long j = i * 1000;
        if (j < 1000) {
            return "00:00:00";
        }
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = j2 / 60;
        long j5 = 0;
        if (j4 >= 60) {
            j5 = j4 / 60;
            j4 %= 60;
        }
        if (j3 < 10) {
            str = SessionDescription.SUPPORTED_SDP_VERSION + j3;
        } else {
            str = j3 + "";
        }
        if (j4 < 10) {
            str2 = SessionDescription.SUPPORTED_SDP_VERSION + j4 + ":";
        } else {
            str2 = j4 + ":";
        }
        if (j5 < 10) {
            str3 = SessionDescription.SUPPORTED_SDP_VERSION + j5 + ":";
        } else {
            str3 = j5 + ":";
        }
        return str3 + str2 + str;
    }

    public static String formatCreateTime(long j) {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.US).format(new Date(j));
    }

    public static String formatCreateTime1(long j) {
        return new SimpleDateFormat(DateUtils.YMDHMS2, Locale.US).format(new Date(j));
    }

    public static String formatCreateTime2(long j) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US).format(new Date(j));
    }

    public static String formatCreateTime3(long j) {
        return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(j));
    }

    public static String formatCreateTime4(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
    }

    public static String formatCurTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(System.currentTimeMillis()));
    }

    public static String formatCurTime1(long j) {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(j));
    }

    public static String formatCurTime2(long j) {
        return new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(j));
    }

    public static String getCurTime() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
    }

    public static String getCurTime2() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
    }

    public static String getCurTime1() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).format(new Date());
    }

    public static String formatTimeSss(long j) {
        return new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j));
    }

    public static String getCurTime4() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.US).format(new Date());
    }

    public static DateTime getCurTime3() {
        try {
            String[] split = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss", Locale.US).format(new Date()).split(":");
            return new DateTime(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]));
        } catch (Exception e) {
            DDLog.m1684e("设置相机时间出错:" + e.getMessage());
            Time time = new Time();
            time.setToNow();
            return new DateTime(time.year, time.month + 1, time.monthDay, time.hour, time.minute, time.second);
        }
    }

    public static long getMillisTime(String str) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-DD HH:mm:ss", Locale.US).parse(str).getTime();
    }

    public static long getMillisTime1(String str) throws ParseException {
        return new SimpleDateFormat("yyyy/MM/DD HH:mm:ss", Locale.US).parse(str).getTime();
    }

    public static long getMillisTime2(String str) throws ParseException {
        return new SimpleDateFormat("yyyy/MM/DD HH:mm:ss", Locale.US).parse(str).getTime();
    }

    public static String formatDuration(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        return i4 > 0 ? String.format("%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)) : String.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static String formatVideoDuration(int i) {
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        return i4 == 0 ? String.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)) : String.format("%02d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static String formatDuration1(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        return i4 > 0 ? String.format("%dh %dmin %ds", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)) : i3 > 0 ? String.format("%dmin %ds", Integer.valueOf(i3), Integer.valueOf(i2)) : String.format("%ds", Integer.valueOf(i2));
    }

    public static boolean isEmail(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(str).matches();
    }

    public static boolean isTruePassword(String str) {
        if (str == null || str.length() < 6) {
            return false;
        }
        if (Pattern.compile("[0-9]*").matcher(str).matches() || Pattern.compile("[a-zA-Z]+").matcher(str).matches()) {
            return true;
        }
        return Pattern.compile("^[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]").matcher(str).matches();
    }

    public static boolean passwordLength(String str) {
        return str != null && str.length() >= 6;
    }

    public static String getPicOrVideoSize(long j) {
        if (j < 1024) {
            return Math.round(j) + "B";
        }
        long longValue = new BigDecimal(j / 1024).setScale(2, 1).longValue();
        if (longValue < 1024) {
            return Math.round(longValue) + "KB";
        }
        long longValue2 = new BigDecimal(longValue / 1024).setScale(2, 1).longValue();
        if (longValue2 < 1024) {
            return Math.round(longValue2) + "M";
        }
        long j2 = longValue2 / 1024;
        return (new BigDecimal(j2).setScale(2, 1).longValue() + new BigDecimal((longValue2 - (1024 * j2)) / 1024.0f).setScale(1, 4).floatValue()) + "G";
    }

    public static String getSdCardSpaceRatio(long j, long j2) {
        DDLog.m1684e("解析相机数据：, sdFreeSpace: " + j + ", sdTotalSpace:" + j2);
        return (j / 1024) + "G/" + (j2 / 1024) + "G";
    }

    public static class DateTime {
        public int day;
        public int hour;
        public int min;
        public int month;
        public int second;
        public int year;

        public DateTime(int i, int i2, int i3, int i4, int i5, int i6) {
            this.year = i;
            this.month = i2;
            this.day = i3;
            this.hour = i4;
            this.min = i5;
            this.second = i6;
        }
    }
}
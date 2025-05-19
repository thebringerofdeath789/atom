package com.ipotensic.baselib.mediadataretriever.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TimeUtil {
    public static String getTime(long j) {
        if (j <= 0) {
            return "00:00:00";
        }
        int i = (int) (j / 1000);
        return String.format("%02d:%02d:%02d", Integer.valueOf(i / 3600), Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60));
    }

    public static String getTimeMinSecond(long j) {
        if (j <= 0) {
            return "00:00";
        }
        int i = (int) (j / 1000);
        return String.format("%02d:%02d", Integer.valueOf(i / 60), Integer.valueOf(i % 60));
    }

    public static String getNowTime() {
        return new SimpleDateFormat("HH:mm", Locale.US).format(new Date());
    }
}

package com.ipotensic.baselib.utils;

import android.util.TypedValue;
import com.ipotensic.baselib.configs.PhoneConfig;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public class UnitUtil {
    public static int round(float f) {
        if (f < 0.0f) {
            int i = (int) f;
            return ((double) (f - ((float) i))) <= -0.5d ? i - 1 : i;
        }
        int i2 = (int) f;
        return f - ((float) i2) >= 0.5f ? i2 + 1 : i2;
    }

    public static int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, PhoneConfig.applicationContext.getResources().getDisplayMetrics());
    }

    public static float dp2px(float f) {
        return TypedValue.applyDimension(1, f, PhoneConfig.applicationContext.getResources().getDisplayMetrics());
    }

    public static int px2dp(float f) {
        return (int) ((f / PhoneConfig.applicationContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / PhoneConfig.applicationContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float px2sp(int i) {
        return TypedValue.applyDimension(0, i, PhoneConfig.applicationContext.getResources().getDisplayMetrics());
    }

    public static int px2dip(float f) {
        return (int) ((f / PhoneConfig.applicationContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dip2px(float f) {
        return (int) ((f * PhoneConfig.applicationContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * PhoneConfig.applicationContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float sp2px(int i) {
        return TypedValue.applyDimension(2, i, PhoneConfig.applicationContext.getResources().getDisplayMetrics());
    }

    public static float double2Float(double d) {
        return new BigDecimal(d).setScale(1, 4).floatValue();
    }

    public static float keepOneDigit(float f) {
        return new BigDecimal(f).setScale(1, 4).floatValue();
    }

    public static float keepTwoDigit(float f) {
        return new BigDecimal(f).setScale(2, 4).floatValue();
    }

    public static float keepOneDigit(String str) {
        return new BigDecimal(str).setScale(1, 4).floatValue();
    }
}

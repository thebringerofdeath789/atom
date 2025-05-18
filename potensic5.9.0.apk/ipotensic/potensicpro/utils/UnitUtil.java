package com.ipotensic.potensicpro.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes2.dex */
public class UnitUtil {
    public static int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }

    public static int px2dp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float px2sp(int i) {
        return TypedValue.applyDimension(0, i, Resources.getSystem().getDisplayMetrics());
    }

    public static int px2dip(float f) {
        return (int) ((f / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int dip2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float sp2px(int i) {
        return TypedValue.applyDimension(2, i, Resources.getSystem().getDisplayMetrics());
    }
}
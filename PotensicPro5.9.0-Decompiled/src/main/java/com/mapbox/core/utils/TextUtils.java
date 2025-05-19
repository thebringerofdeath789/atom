package com.mapbox.core.utils;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TextUtils {
    private TextUtils() {
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String join(CharSequence charSequence, Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        boolean z = true;
        if (objArr.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public static String formatCoordinate(double d) {
        return String.format(Locale.US, "%s", new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static String formatCoordinate(double d, int i) {
        String str = "0." + new String(new char[i]).replace("\u0000", SessionDescription.SUPPORTED_SDP_VERSION);
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
        decimalFormat.applyPattern(str);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return decimalFormat.format(d);
    }

    @Deprecated
    public static String formatRadiuses(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            return null;
        }
        String[] strArr = new String[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            if (dArr[i] == Double.POSITIVE_INFINITY) {
                strArr[i] = "unlimited";
            } else {
                strArr[i] = String.format(Locale.US, "%s", formatCoordinate(dArr[i]));
            }
        }
        return join(";", strArr);
    }

    @Deprecated
    public static String formatBearing(List<Double[]> list) {
        if (list.isEmpty()) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length == 0) {
                strArr[i] = "";
            } else {
                strArr[i] = String.format(Locale.US, "%s,%s", formatCoordinate(list.get(i)[0].doubleValue()), formatCoordinate(list.get(i)[1].doubleValue()));
            }
        }
        return join(";", strArr);
    }

    @Deprecated
    public static String formatDistributions(List<Integer[]> list) {
        if (list.isEmpty()) {
            return null;
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length == 0) {
                strArr[i] = "";
            } else {
                strArr[i] = String.format(Locale.US, "%s,%s", formatCoordinate(list.get(i)[0].intValue()), formatCoordinate(list.get(i)[1].intValue()));
            }
        }
        return join(";", strArr);
    }

    @Deprecated
    public static String formatApproaches(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                strArr[i] = "";
            } else if (!strArr[i].equals(DirectionsCriteria.APPROACH_UNRESTRICTED) && !strArr[i].equals(DirectionsCriteria.APPROACH_CURB) && !strArr[i].isEmpty()) {
                return null;
            }
        }
        return join(";", strArr);
    }

    @Deprecated
    public static String formatWaypointNames(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                strArr[i] = "";
            }
        }
        return join(";", strArr);
    }
}

package com.mapbox.api.directions.v5.utils;

import com.mapbox.api.directions.v5.models.Bearing;
import com.mapbox.geojson.Point;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class FormatUtils {
    public static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm";

    public static String join(CharSequence charSequence, List<?> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i <= list.size() - 1; i++) {
            if (z) {
                z = false;
            } else {
                sb.append(charSequence);
            }
            Object obj = list.get(i);
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String formatDouble(double d) {
        return String.format(Locale.US, "%s", new DecimalFormat("0.#######", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    public static String formatRadiuses(List<Double> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Double d : list) {
            if (d == null) {
                arrayList.add(null);
            } else if (d.doubleValue() == Double.POSITIVE_INFINITY) {
                arrayList.add("unlimited");
            } else {
                arrayList.add(String.format(Locale.US, "%s", formatDouble(d.doubleValue())));
            }
        }
        return join(";", arrayList);
    }

    public static String formatBearings(List<Bearing> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Bearing bearing : list) {
            if (bearing == null) {
                arrayList.add(null);
            } else {
                arrayList.add(String.format(Locale.US, "%s,%s", formatDouble(bearing.angle()), formatDouble(bearing.degrees())));
            }
        }
        return join(";", arrayList);
    }

    public static String formatDistributions(List<Integer[]> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer[]> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().length == 0) {
                arrayList.add(null);
            } else {
                arrayList.add(String.format(Locale.US, "%s,%s", formatDouble(r2[0].intValue()), formatDouble(r2[1].intValue())));
            }
        }
        return join(";", arrayList);
    }

    public static String formatPointsList(List<Point> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Point point : list) {
            if (point == null) {
                arrayList.add(null);
            } else {
                arrayList.add(String.format(Locale.US, "%s,%s", formatDouble(point.longitude()), formatDouble(point.latitude())));
            }
        }
        return join(";", arrayList);
    }

    public static String formatIntegers(List<Integer> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            if (num == null) {
                arrayList.add(null);
            } else {
                arrayList.add(Integer.toString(num.intValue()));
            }
        }
        return join(";", arrayList);
    }
}

package com.ipotensic.kernel.utils;

import android.text.TextUtils;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.logan.flight.FlightConfig;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.turf.TurfConstants;
import com.mapbox.turf.TurfMeasurement;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public class MapUtil {
    public static final int PAIR_DEGREE = 10;
    private static final String TAG = "MapUtil";

    public static boolean isPair(LatLng latLng, LatLng latLng2, int i) {
        double bearing = TurfMeasurement.bearing(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()), Point.fromLngLat(latLng2.getLongitude(), latLng2.getLatitude())) - i;
        return -10.0d <= bearing && bearing <= 10.0d;
    }

    public static double distance(LatLng latLng, LatLng latLng2) {
        try {
            return TurfMeasurement.distance(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()), Point.fromLngLat(latLng2.getLongitude(), latLng2.getLatitude()), TurfConstants.UNIT_METERS);
        } catch (Exception e) {
            DDLog.m1686e(TAG, "计算两点之间距离异常", e);
            return 0.0d;
        }
    }

    public static String getMapPointsDistance(LatLng latLng, LatLng latLng2) {
        try {
            double distance = TurfMeasurement.distance(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()), Point.fromLngLat(latLng2.getLongitude(), latLng2.getLatitude()), TurfConstants.UNIT_METERS);
            if (PhoneConfig.isFt) {
                return Math.round(FlightConfig.get_value((float) distance)) + "ft";
            }
            if (distance <= 500.0d) {
                return Math.round(distance) + "m";
            }
            return new BigDecimal(distance / 1000.0d).setScale(2, 1).floatValue() + "km";
        } catch (Exception e) {
            DDLog.m1686e(TAG, "计算两点之间距离异常", e);
            return PhoneConfig.isFt ? "0ft" : "0m";
        }
    }

    public static String getMapPointsDistance(float f) {
        try {
            if (PhoneConfig.isFt) {
                return Math.round(FlightConfig.get_value(f)) + "ft";
            }
            if (f <= 500.0f) {
                return Math.round(f) + "m";
            }
            return new BigDecimal(f / 1000.0f).setScale(2, 1).floatValue() + "km";
        } catch (Exception e) {
            DDLog.m1685e(TAG, "getMapPointsDistance exception" + e.getMessage());
            return PhoneConfig.isFt ? "0ft" : "0m";
        }
    }

    public static String removeSpecialCharacters(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
}
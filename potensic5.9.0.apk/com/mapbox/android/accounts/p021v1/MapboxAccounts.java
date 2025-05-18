package com.mapbox.android.accounts.p021v1;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.security.SecureRandom;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class MapboxAccounts {
    public static final String SKU_ID_MAPS_MAUS = "00";
    public static final String SKU_ID_NAVIGATION_MAUS = "02";
    public static final String SKU_ID_NAVIGATION_TRIPS = "07";
    public static final String SKU_ID_VISION_FLEET_MAUS = "06";
    public static final String SKU_ID_VISION_MAUS = "04";

    /* renamed from: a */
    public static String m1736a() {
        String l = Long.toString(getNow(), 36);
        return l.length() > 8 ? l.substring(l.length() - 8) : l.length() < 8 ? String.format("%1$8s", l).replace(StringUtils.SPACE, SessionDescription.SUPPORTED_SDP_VERSION) : l;
    }

    /* renamed from: a */
    public static String m1737a(CharSequence charSequence, Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
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

    public static long getNow() {
        return System.currentTimeMillis();
    }

    public static String obtainEndUserId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String obtainMapsSkuUserToken(String str) {
        return m1737a("", new String[]{"1", SKU_ID_MAPS_MAUS, m1736a(), str});
    }

    public static String obtainNavigationSkuSessionToken() {
        String[] strArr = new String[3];
        strArr[0] = "1";
        strArr[1] = SKU_ID_NAVIGATION_TRIPS;
        char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] cArr = new char[10];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            cArr[i] = charArray[secureRandom.nextInt(charArray.length)];
        }
        strArr[2] = new String(cArr);
        return m1737a("", strArr);
    }

    public static String obtainNavigationSkuUserToken(String str) {
        return m1737a("", new String[]{"1", SKU_ID_NAVIGATION_MAUS, m1736a(), str});
    }

    public static String obtainVisionFleetSkuUserToken(String str) {
        return m1737a("", new String[]{"1", SKU_ID_VISION_FLEET_MAUS, m1736a(), str});
    }

    public static String obtainVisionSkuUserToken(String str) {
        return m1737a("", new String[]{"1", SKU_ID_VISION_MAUS, m1736a(), str});
    }
}
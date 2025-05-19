package com.mapbox.android.telemetry;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.mapbox.android.core.MapboxSdkInfoForUserAgentGenerator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.net.SocketFactory;
import okhttp3.OkHttpClient;
import okio.Buffer;

/* loaded from: classes3.dex */
public class TelemetryUtils {
    private static final String BACKGROUND = "Background";
    private static final String CODE_DIVISION_MULTIPLE_ACCESS = "CDMA";
    private static final int DEFAULT_BATTERY_LEVEL = -1;
    private static final String EMPTY_STRING = "";
    private static final String ENHANCED_DATA_GSM_EVOLUTION = "EDGE";
    private static final String ENHANCED_HIGH_RATE_PACKET_DATA = "EHRPD";
    private static final String EVOLUTION_DATA_OPTIMIZED_0 = "EVDO_0";
    private static final String EVOLUTION_DATA_OPTIMIZED_A = "EVDO_A";
    private static final String EVOLUTION_DATA_OPTIMIZED_B = "EVDO_B";
    private static final String FOREGROUND = "Foreground";
    private static final String GENERAL_PACKET_RADIO_SERVICE = "GPRS";
    private static final String HIGH_SPEED_DOWNLINK_PACKET_ACCESS = "HSDPA";
    private static final String HIGH_SPEED_PACKET_ACCESS = "HSPA";
    private static final String HIGH_SPEED_PACKET_ACCESS_PLUS = "HSPAP";
    private static final String HIGH_SPEED_UNLINK_PACKET_ACCESS = "HSUPA";
    private static final String INTEGRATED_DIGITAL_ENHANCED_NETWORK = "IDEN";
    private static final String KEY_META_DATA_WAKE_UP = "com.mapbox.AdjustWakeUp";
    private static final String LONG_TERM_EVOLUTION = "LTE";
    static final String MAPBOX_SHARED_PREFERENCE_KEY_VENDOR_ID = "mapboxVendorId";
    private static final String NO_STATE = "";
    private static final int PERCENT_SCALE = 100;
    private static final String SINGLE_CARRIER_RTT = "1xRTT";
    private static final String TAG = "TelemetryUtils";
    private static final String THREE_STRING_FORMAT = "%s/%s/%s";
    private static final String TWO_STRING_FORMAT = "%s %s";
    private static final int UNAVAILABLE_BATTERY_LEVEL = -1;
    private static final String UNIVERSAL_MOBILE_TELCO_SERVICE = "UMTS";
    private static final String UNKNOWN = "Unknown";
    private static final String USER_AGENT_APP_ID_FORMAT = "%s/%s (%s; %s; %s)";
    private static final String USER_AGENT_VERSION_CODE_FORMAT = "v%d";
    private static final String DATE_AND_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_AND_TIME_PATTERN, Locale.US);
    private static final Locale DEFAULT_LOCALE = Locale.US;
    private static final String OPERATING_SYSTEM = "Android - " + Build.VERSION.RELEASE;
    private static final Map<Integer, String> NETWORKS = new HashMap<Integer, String>() { // from class: com.mapbox.android.telemetry.TelemetryUtils.1
        {
            put(7, TelemetryUtils.SINGLE_CARRIER_RTT);
            put(4, TelemetryUtils.CODE_DIVISION_MULTIPLE_ACCESS);
            put(2, TelemetryUtils.ENHANCED_DATA_GSM_EVOLUTION);
            put(14, TelemetryUtils.ENHANCED_HIGH_RATE_PACKET_DATA);
            put(5, TelemetryUtils.EVOLUTION_DATA_OPTIMIZED_0);
            put(6, TelemetryUtils.EVOLUTION_DATA_OPTIMIZED_A);
            put(12, TelemetryUtils.EVOLUTION_DATA_OPTIMIZED_B);
            put(1, TelemetryUtils.GENERAL_PACKET_RADIO_SERVICE);
            put(8, TelemetryUtils.HIGH_SPEED_DOWNLINK_PACKET_ACCESS);
            put(10, TelemetryUtils.HIGH_SPEED_PACKET_ACCESS);
            put(15, TelemetryUtils.HIGH_SPEED_PACKET_ACCESS_PLUS);
            put(9, TelemetryUtils.HIGH_SPEED_UNLINK_PACKET_ACCESS);
            put(11, TelemetryUtils.INTEGRATED_DIGITAL_ENHANCED_NETWORK);
            put(13, TelemetryUtils.LONG_TERM_EVOLUTION);
            put(3, TelemetryUtils.UNIVERSAL_MOBILE_TELCO_SERVICE);
            put(0, TelemetryUtils.UNKNOWN);
        }
    };

    public static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt > 31 && codePointAt < 127) {
                i += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i);
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    buffer.writeUtf8CodePoint((codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2);
                    i += Character.charCount(codePointAt2);
                }
                return buffer.readUtf8();
            }
        }
        return str;
    }

    public static String obtainUniversalUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }

    public static String obtainApplicationState(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return FOREGROUND;
            }
        }
        return BACKGROUND;
    }

    public static int obtainBatteryLevel(Context context) {
        Intent registerBatteryUpdates = registerBatteryUpdates(context);
        if (registerBatteryUpdates == null) {
            return -1;
        }
        int intExtra = registerBatteryUpdates.getIntExtra("level", -1);
        int intExtra2 = registerBatteryUpdates.getIntExtra(RtspHeaders.SCALE, -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            return -1;
        }
        return Math.round((intExtra / intExtra2) * 100.0f);
    }

    public static boolean isPluggedIn(Context context) {
        Intent registerBatteryUpdates = registerBatteryUpdates(context);
        if (registerBatteryUpdates == null) {
            return false;
        }
        int intExtra = registerBatteryUpdates.getIntExtra("plugged", -1);
        return (intExtra == 2) || (intExtra == 1);
    }

    public static String obtainCellularNetworkType(Context context) {
        int i;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                i = telephonyManager.getDataNetworkType();
            } catch (SecurityException e) {
                Log.e(TAG, e.toString());
                i = 0;
            }
        } else {
            i = telephonyManager.getNetworkType();
        }
        return NETWORKS.get(Integer.valueOf(i));
    }

    public static String obtainCurrentDate() {
        return dateFormat.format(new Date());
    }

    public static String generateCreateDateFormatted(Date date) {
        return dateFormat.format(date);
    }

    static String createFullUserAgent(String str, Context context) {
        String obtainApplicationIdentifier = obtainApplicationIdentifier(context);
        return TextUtils.isEmpty(obtainApplicationIdentifier) ? str : toHumanReadableAscii(String.format(DEFAULT_LOCALE, TWO_STRING_FORMAT, obtainApplicationIdentifier, str));
    }

    static String createReformedFullUserAgent(Context context) {
        String obtainApplicationIdentifierForReformedUserAgent = obtainApplicationIdentifierForReformedUserAgent(context);
        String humanReadableAscii = toHumanReadableAscii(String.format(DEFAULT_LOCALE, TWO_STRING_FORMAT, obtainApplicationIdentifierForReformedUserAgent, MapboxSdkInfoForUserAgentGenerator.getInstance(context.getAssets()).getSdkInfoForUserAgent()));
        return TextUtils.isEmpty(humanReadableAscii) ? obtainApplicationIdentifierForReformedUserAgent : humanReadableAscii;
    }

    static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String retrieveVendorId() {
        if (MapboxTelemetry.applicationContext == null) {
            return updateVendorId();
        }
        String string = obtainSharedPreferences(MapboxTelemetry.applicationContext).getString(MAPBOX_SHARED_PREFERENCE_KEY_VENDOR_ID, "");
        return isEmpty(string) ? updateVendorId() : string;
    }

    static SharedPreferences obtainSharedPreferences(Context context) {
        return context.getSharedPreferences("MapboxSharedPreferences", 0);
    }

    private static String updateVendorId() {
        String obtainUniversalUniqueIdentifier = obtainUniversalUniqueIdentifier();
        if (MapboxTelemetry.applicationContext == null) {
            return obtainUniversalUniqueIdentifier;
        }
        SharedPreferences.Editor edit = obtainSharedPreferences(MapboxTelemetry.applicationContext).edit();
        edit.putString(MAPBOX_SHARED_PREFERENCE_KEY_VENDOR_ID, obtainUniversalUniqueIdentifier);
        edit.apply();
        return obtainUniversalUniqueIdentifier;
    }

    private static String obtainApplicationIdentifier(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            return String.format(DEFAULT_LOCALE, THREE_STRING_FORMAT, packageName, packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String obtainApplicationIdentifierForReformedUserAgent(Context context) {
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            Locale locale = DEFAULT_LOCALE;
            return String.format(locale, USER_AGENT_APP_ID_FORMAT, getApplicationName(context), packageInfo.versionName == null ? SessionDescription.SUPPORTED_SDP_VERSION : packageInfo.versionName, packageName, String.format(locale, USER_AGENT_VERSION_CODE_FORMAT, Integer.valueOf(packageInfo.versionCode)), OPERATING_SYSTEM);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    private static Intent registerBatteryUpdates(Context context) {
        try {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.e(TAG, String.format("%s: Failed receiver registration for ACTION_BATTERY_CHANGED", e.toString()));
            return null;
        }
    }

    static boolean adjustWakeUpMode(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData.getBoolean(KEY_META_DATA_WAKE_UP, false);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    static OkHttpClient createOkHttpClientWithStrictModeWorkAround() {
        return new OkHttpClient().newBuilder().socketFactory(new SocketFactory() { // from class: com.mapbox.android.telemetry.TelemetryUtils.2
            private static final int THREAD_ID = 10000;
            SocketFactory socketFactory = SocketFactory.getDefault();

            @Override // javax.net.SocketFactory
            public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
                TrafficStats.setThreadStatsTag(10000);
                return this.socketFactory.createSocket(str, i);
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
                TrafficStats.setThreadStatsTag(10000);
                return this.socketFactory.createSocket(str, i, inetAddress, i2);
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
                TrafficStats.setThreadStatsTag(10000);
                return this.socketFactory.createSocket(inetAddress, i);
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
                TrafficStats.setThreadStatsTag(10000);
                return this.socketFactory.createSocket(inetAddress, i, inetAddress2, i2);
            }
        }).build();
    }
}

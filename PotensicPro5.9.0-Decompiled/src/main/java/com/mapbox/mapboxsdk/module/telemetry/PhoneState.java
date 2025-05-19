package com.mapbox.mapboxsdk.module.telemetry;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.mapbox.android.telemetry.TelemetryUtils;

/* loaded from: classes3.dex */
class PhoneState {
    private static final String NO_CARRIER = "EMPTY_CARRIER";
    private static final int NO_NETWORK = -1;
    private float accessibilityFontScale;
    private int batteryLevel;
    private String carrier;
    private String cellularNetworkType;
    private String created;
    private Orientation orientation;
    private boolean pluggedIn;
    private float resolution;
    private boolean wifi;

    PhoneState() {
    }

    PhoneState(Context context) {
        this.created = TelemetryUtils.obtainCurrentDate();
        this.batteryLevel = TelemetryUtils.obtainBatteryLevel(context);
        this.pluggedIn = TelemetryUtils.isPluggedIn(context);
        this.cellularNetworkType = TelemetryUtils.obtainCellularNetworkType(context);
        this.orientation = Orientation.getOrientation(context.getResources().getConfiguration().orientation);
        this.accessibilityFontScale = context.getResources().getConfiguration().fontScale;
        this.carrier = obtainCellularCarrier(context);
        this.resolution = obtainDisplayDensity(context);
        this.wifi = isConnectedToWifi(context);
    }

    private String obtainCellularCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return NO_CARRIER;
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        return TextUtils.isEmpty(networkOperatorName) ? NO_CARRIER : networkOperatorName;
    }

    private float obtainDisplayDensity(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    private boolean isConnectedToWifi(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return false;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (wifiManager.isWifiEnabled()) {
                return connectionInfo.getNetworkId() != -1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    String getCreated() {
        return this.created;
    }

    void setCreated(String str) {
        this.created = str;
    }

    int getBatteryLevel() {
        return this.batteryLevel;
    }

    void setBatteryLevel(int i) {
        this.batteryLevel = i;
    }

    boolean isPluggedIn() {
        return this.pluggedIn;
    }

    void setPluggedIn(boolean z) {
        this.pluggedIn = z;
    }

    String getCellularNetworkType() {
        return this.cellularNetworkType;
    }

    void setCellularNetworkType(String str) {
        this.cellularNetworkType = str;
    }

    String getOrientation() {
        return this.orientation.getOrientation();
    }

    void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    String getCarrier() {
        return this.carrier;
    }

    void setCarrier(String str) {
        this.carrier = str;
    }

    boolean isWifi() {
        return this.wifi;
    }

    void setWifi(boolean z) {
        this.wifi = z;
    }

    float getAccessibilityFontScale() {
        return this.accessibilityFontScale;
    }

    void setAccessibilityFontScale(float f) {
        this.accessibilityFontScale = f;
    }

    float getResolution() {
        return this.resolution;
    }

    void setResolution(float f) {
        this.resolution = f;
    }

    enum Orientation {
        ORIENTATION_PORTRAIT("Portrait"),
        ORIENTATION_LANDSCAPE("Landscape");

        private String orientation;

        Orientation(String str) {
            this.orientation = str;
        }

        public static Orientation getOrientation(int i) {
            if (1 == i) {
                return ORIENTATION_PORTRAIT;
            }
            return ORIENTATION_LANDSCAPE;
        }

        public String getOrientation() {
            return this.orientation;
        }
    }
}

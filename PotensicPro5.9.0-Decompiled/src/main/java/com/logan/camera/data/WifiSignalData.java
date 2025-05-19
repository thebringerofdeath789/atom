package com.logan.camera.data;

/* loaded from: classes2.dex */
public class WifiSignalData extends BaseData {
    private int frameRate;
    private int rssi;
    private int wifiSignal;

    public WifiSignalData(int i, int i2) {
        this.wifiSignal = i;
        this.frameRate = i2;
    }

    public int getWifiSignal() {
        return this.wifiSignal;
    }

    public int getWifiRssiRange() {
        int i = this.wifiSignal;
        if (i <= 0) {
            this.rssi = 0;
        } else if (i <= 5) {
            this.rssi = 1;
        } else if (i <= 15) {
            this.rssi = 2;
        } else if (i <= 20) {
            this.rssi = 3;
        } else if (i <= 25) {
            this.rssi = 4;
        }
        return this.rssi;
    }

    public int getFrameRate() {
        return this.frameRate;
    }
}

package com.logan.camera.data;

/* loaded from: classes2.dex */
public class DeviceInfoData extends BaseData {
    private String model;
    private String softVersion;

    public DeviceInfoData(String str, String str2) {
        this.model = str;
        this.softVersion = str2;
    }

    public String getModel() {
        return this.model;
    }

    public String getSoftVersion() {
        return this.softVersion;
    }
}
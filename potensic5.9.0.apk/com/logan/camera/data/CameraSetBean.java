package com.logan.camera.data;

/* loaded from: classes2.dex */
public class CameraSetBean {
    private boolean isSelect = false;
    private boolean isUsb;
    private int maxZoom;
    private int realValueForUsb;
    private String realValueForWifi;
    private String showString;

    public CameraSetBean(String str, String str2, boolean z) {
        this.isUsb = false;
        this.showString = str;
        this.realValueForWifi = str2;
        this.isUsb = z;
    }

    public CameraSetBean(String str, int i, boolean z) {
        this.isUsb = false;
        this.showString = str;
        this.realValueForUsb = i;
        this.isUsb = z;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public String getShowString() {
        return this.showString;
    }

    public int getRealValueForUsb() {
        return this.realValueForUsb;
    }

    public String getRealValueForWifi() {
        return this.realValueForWifi;
    }

    public boolean isUsb() {
        return this.isUsb;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public void setMaxZoom(int i) {
        this.maxZoom = i;
    }

    public String toString() {
        return "CameraSetBean{showString='" + this.showString + "', realValueForUsb=" + this.realValueForUsb + ", realValueForWifi='" + this.realValueForWifi + "', isUsb=" + this.isUsb + ", maxZoom=" + this.maxZoom + '}';
    }
}
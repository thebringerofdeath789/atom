package com.ipotensic.baselib.enums;

/* loaded from: classes2.dex */
public enum FlightCmdID2021 {
    USB_TYPE_LIVE_VIEW((byte) 1),
    USB_TYPE_CAMERA_TO_APP((byte) 2),
    USB_TYPE_LIVE_VIEW_NEW((byte) 4),
    USB_TYPE_FLIGHT_TO_APP((byte) 32),
    USB_TYPE_FPV_TO_APP((byte) 48),
    USB_TYPE_REMOTER_TO_APP((byte) 64),
    USB_TYPE_APP_TO_FLIGHT((byte) 16),
    USB_TYPE_APP_TO_CAMERA((byte) 17),
    USB_TYPE_APP_TO_FPV((byte) 18),
    USB_TYPE_APP_TO_REMOTER((byte) 19);

    public byte value;

    FlightCmdID2021(byte b) {
        this.value = b;
    }
}
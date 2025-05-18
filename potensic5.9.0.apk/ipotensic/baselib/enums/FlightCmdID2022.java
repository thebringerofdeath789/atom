package com.ipotensic.baselib.enums;

/* loaded from: classes2.dex */
public enum FlightCmdID2022 {
    USB_TYPE_CAMERA_TO_APP((byte) 5),
    USB_TYPE_LIVE_VIEW_NEW((byte) 6),
    USB_TYPE_FLIGHT_TO_APP((byte) 33),
    USB_TYPE_FPV_TO_APP((byte) 49),
    USB_TYPE_REMOTER_TO_APP((byte) 65),
    USB_TYPE_APP_TO_FLIGHT((byte) 20),
    USB_TYPE_APP_TO_CAMERA((byte) 21),
    USB_TYPE_APP_TO_FPV((byte) 22),
    USB_TYPE_APP_TO_REMOTER((byte) 23);

    public byte value;

    FlightCmdID2022(byte b) {
        this.value = b;
    }
}
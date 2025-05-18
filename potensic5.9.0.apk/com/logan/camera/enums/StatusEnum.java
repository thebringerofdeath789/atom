package com.logan.camera.enums;

/* loaded from: classes2.dex */
public enum StatusEnum {
    STATUS_SUCCESS("Success"),
    STATUS_NO_SD_CARD("sd is not ready"),
    STATUS_SD_CARD_FULL("sd is full"),
    STATUS_FAIL("Fail"),
    STATUS_SD_SPEED_LOW("tf card speed low");

    private String value;

    StatusEnum(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
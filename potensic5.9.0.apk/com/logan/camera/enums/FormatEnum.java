package com.logan.camera.enums;

/* loaded from: classes2.dex */
public enum FormatEnum {
    FORMAT_SUCCESS(1);

    private int state;

    FormatEnum(int i) {
        this.state = i;
    }

    public int getValue() {
        return this.state;
    }
}
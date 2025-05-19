package com.logan.nativeapp;

/* loaded from: classes3.dex */
public enum H265Type {
    TYPE_VPS(64),
    TYPE_SPS(66),
    TYPE_PPS(68),
    TYPE_SEI(78),
    TYPE_IDR(38),
    TYPE_SS(2);

    public int nal_byte;

    H265Type(int i) {
        this.nal_byte = i;
    }

    public static H265Type findType(byte b) {
        for (H265Type h265Type : values()) {
            if (h265Type.nal_byte == b) {
                return h265Type;
            }
        }
        return null;
    }
}

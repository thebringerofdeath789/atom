package com.logan.nativeapp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class Frame {
    public static final int FRAME_P = 14;
    public static final int FRAME_SPS_PPS_SEI_I = 10;
    private byte[] data;
    private int length;
    private byte[] pps;
    private byte[] sps;
    private int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public Frame(byte[] bArr) {
        this.data = bArr;
        this.length = bArr.length;
        byte b = bArr[4];
        if (b == 97) {
            this.type = 14;
        } else {
            if (b != 103) {
                return;
            }
            this.type = 10;
            parseSpsPps();
        }
    }

    public int getFrameType() {
        return this.type;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte[] getSps() {
        return this.sps;
    }

    public byte[] getPps() {
        return this.pps;
    }

    private void parseSpsPps() {
        int i = 0;
        int i2 = -1;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length - 5) {
                return;
            }
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1) {
                if (i2 != -1) {
                    int i3 = i - i2;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i2, bArr2, 0, i3);
                    if (bArr2[4] == 103) {
                        this.sps = bArr2;
                    }
                    if (bArr2[4] == 104) {
                        this.pps = bArr2;
                    }
                    if (this.sps != null && this.pps != null) {
                        return;
                    }
                }
                i2 = i;
            }
            i++;
        }
    }
}

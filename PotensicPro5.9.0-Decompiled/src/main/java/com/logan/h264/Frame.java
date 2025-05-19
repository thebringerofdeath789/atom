package com.logan.h264;

/* loaded from: classes.dex */
public class Frame {
    private byte[] data;
    private int length;
    private FrameType type;

    public enum FrameType {
        SPS,
        PPS,
        SEI,
        I,
        B,
        P
    }

    public Frame(byte[] bArr) {
        this.data = bArr;
        this.length = bArr.length;
        byte b = bArr[4];
        if (b == 6) {
            this.type = FrameType.SEI;
            return;
        }
        if (b == 65) {
            this.type = FrameType.P;
            return;
        }
        if (b == 97) {
            this.type = FrameType.B;
            return;
        }
        if (b == 101) {
            this.type = FrameType.I;
        } else if (b == 103) {
            this.type = FrameType.SPS;
        } else {
            if (b != 104) {
                return;
            }
            this.type = FrameType.PPS;
        }
    }

    public FrameType getFrameType() {
        return this.type;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getData() {
        return this.data;
    }
}

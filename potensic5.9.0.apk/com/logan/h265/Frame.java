package com.logan.h265;

import com.logan.nativeapp.H265Type;
import java.util.Objects;

/* loaded from: classes.dex */
public class Frame {
    private byte[] data;
    private int length;
    private byte[] pps;
    private byte[] sps;
    private H265Type type;
    private byte[] vps;

    public Frame(byte[] bArr) throws Exception {
        this.data = bArr;
        this.length = bArr.length;
        H265Type findType = H265Type.findType(bArr[4]);
        this.type = findType;
        Objects.requireNonNull(findType);
        if (findType == H265Type.TYPE_VPS) {
            parseVpsSpsPps();
        }
    }

    public H265Type getFrameType() {
        return this.type;
    }

    public byte[] getVps() {
        return this.vps;
    }

    public byte[] getSps() {
        return this.sps;
    }

    public byte[] getPps() {
        return this.pps;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getData() {
        return this.data;
    }

    private void parseVpsSpsPps() {
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
                    if (bArr2[4] == H265Type.TYPE_VPS.nal_byte) {
                        this.vps = bArr2;
                    }
                    if (bArr2[4] == H265Type.TYPE_SPS.nal_byte) {
                        this.sps = bArr2;
                    }
                    if (bArr2[4] == H265Type.TYPE_PPS.nal_byte) {
                        this.pps = bArr2;
                    }
                    if (this.vps != null && this.sps != null && this.pps != null) {
                        return;
                    }
                }
                i2 = i;
            }
            i++;
        }
    }
}
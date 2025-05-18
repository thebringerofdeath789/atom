package com.logan.camera.data;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes2.dex */
public class HardwareStateUploadData {
    public int code;
    public boolean isMainShotAbnormal = false;
    public boolean isOpticalFlowAbnormal = false;

    public String toString() {
        return "HardwareStateUploadData{isMainShotAbnormal=" + this.isMainShotAbnormal + ", isOpticalFlowAbnormal=" + this.isOpticalFlowAbnormal + ", code=" + this.code + '}';
    }

    public void parseData(byte[] bArr, int i) {
        int i2 = i + 2;
        this.isMainShotAbnormal = ParseUtil.getBit(bArr[i2], 0) == 1;
        this.isOpticalFlowAbnormal = ParseUtil.getBit(bArr[i2], 1) == 1;
        if (bArr.length > i + 6) {
            this.code = ParseUtil.getSignedShortFromByteArr(bArr, i + 4);
        }
    }

    public boolean isCMOSError() {
        return this.code == 2 && this.isMainShotAbnormal;
    }
}
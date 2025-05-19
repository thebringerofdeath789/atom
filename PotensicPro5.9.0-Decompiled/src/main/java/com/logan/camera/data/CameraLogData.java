package com.logan.camera.data;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes2.dex */
public class CameraLogData extends BaseData {
    private boolean isGimbal;
    private boolean isLinux;
    private boolean isLiteOs;
    private byte[] payload;

    public CameraLogData(byte[] bArr, int i) throws Exception {
        this.isLinux = false;
        this.isLiteOs = false;
        this.isGimbal = false;
        int i2 = i + 1;
        this.isLinux = bArr[i2] == 0;
        this.isLiteOs = bArr[i2] == 1;
        this.isGimbal = bArr[i2] == 2;
        int unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 2);
        byte[] bArr2 = new byte[unsignedShortFromByteArr];
        this.payload = bArr2;
        System.arraycopy(bArr, i + 4, bArr2, 0, unsignedShortFromByteArr);
    }

    public boolean isLinux() {
        return this.isLinux;
    }

    public boolean isLiteOs() {
        return this.isLiteOs;
    }

    public boolean isGimbal() {
        return this.isGimbal;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public String toString() {
        return "CameraLogData{isLinux=" + this.isLinux + ", isLiteOs=" + this.isLiteOs + ", payload=" + ParseUtil.byteToHexString(this.payload, 10) + '}';
    }
}

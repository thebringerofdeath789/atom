package com.logan.nativeapp;

/* loaded from: classes3.dex */
public class H265Frame {
    private byte[] data;
    private H265Type nalType;

    public H265Frame(byte[] bArr) {
        this.data = bArr;
        if (bArr == null || bArr.length <= 5) {
            return;
        }
        this.nalType = H265Type.findType(bArr[4]);
    }

    public H265Type getNalType() {
        return this.nalType;
    }

    public byte[] getData() {
        return this.data;
    }
}
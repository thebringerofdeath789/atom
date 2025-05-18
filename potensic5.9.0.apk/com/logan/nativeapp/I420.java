package com.logan.nativeapp;

/* loaded from: classes3.dex */
public class I420 {

    /* renamed from: U */
    public byte[] f2548U;

    /* renamed from: V */
    public byte[] f2549V;

    /* renamed from: Y */
    public byte[] f2550Y;
    public int height;
    public int width;

    public I420(int i, int i2) {
        this.width = i;
        this.height = i2;
        int i3 = i * i2;
        this.f2550Y = new byte[i3];
        int i4 = i3 / 4;
        this.f2548U = new byte[i4];
        this.f2549V = new byte[i4];
    }

    public I420(byte[] bArr, int i, int i2) {
        this.width = i;
        this.height = i2;
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        this.f2550Y = bArr2;
        int i4 = i3 / 4;
        this.f2548U = new byte[i4];
        this.f2549V = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        int length = this.f2550Y.length;
        byte[] bArr3 = this.f2548U;
        System.arraycopy(bArr, length, bArr3, 0, bArr3.length);
        int length2 = this.f2550Y.length + this.f2548U.length;
        byte[] bArr4 = this.f2549V;
        System.arraycopy(bArr, length2, bArr4, 0, bArr4.length);
    }

    public I420(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.f2550Y = bArr;
        this.f2548U = bArr2;
        this.f2549V = bArr3;
    }
}
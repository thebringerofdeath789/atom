package com.logan.h264;

/* loaded from: classes.dex */
public class Buffer {
    private OnFrameOutputListener outputListener;
    private byte[] data = new byte[204800];
    private int writeIndex = -1;

    public interface OnFrameOutputListener {
        void output(byte[] bArr);
    }

    public Buffer(OnFrameOutputListener onFrameOutputListener) {
        this.outputListener = onFrameOutputListener;
    }

    public void parse(byte[] bArr) {
        System.arraycopy(bArr, 0, this.data, this.writeIndex + 1, bArr.length);
        this.writeIndex += bArr.length;
        byte[] oneFrame = getOneFrame();
        while (oneFrame != null) {
            OnFrameOutputListener onFrameOutputListener = this.outputListener;
            if (onFrameOutputListener != null) {
                onFrameOutputListener.output(oneFrame);
            }
            oneFrame = getOneFrame();
        }
    }

    public byte[] getOneFrame() {
        int i = -1;
        for (int i2 = 0; i2 < this.writeIndex - 4; i2++) {
            byte[] bArr = this.data;
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 0 && bArr[i2 + 3] == 1) {
                if (i >= 0) {
                    int i3 = i2 - i;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i, bArr2, 0, i3);
                    byte[] bArr3 = this.data;
                    System.arraycopy(bArr3, i2, bArr3, 0, (this.writeIndex - i2) + 1);
                    this.writeIndex -= i2;
                    return bArr2;
                }
                i = i2;
            }
        }
        return null;
    }
}
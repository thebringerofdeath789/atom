package com.logan.camera.data;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes2.dex */
public class PhotoChildMode {
    public static final int AEB = 2;
    public static final int SINGLE = 0;
    public static final int TIMER = 1;
    public boolean isTimeTaking;
    public int childMode = 0;
    public int intervalTime = 0;
    public int photoCount = 0;

    public String toString() {
        return "PhotoChildMode{childMode=" + this.childMode + ", intervalTime=" + this.intervalTime + ", photoCount=" + this.photoCount + ", isTimeTaking=" + this.isTimeTaking + '}';
    }

    public void parseData(byte[] bArr, int i, boolean z) {
        int i2 = i + 6;
        if (bArr.length > i2) {
            this.childMode = bArr[i + 2];
            this.intervalTime = ParseUtil.byteArr2short1(new byte[]{bArr[i + 3], bArr[i + 4]}) / 1000;
            this.photoCount = ParseUtil.byteArr2short1(new byte[]{bArr[i + 5], bArr[i2]});
            if (z) {
                this.isTimeTaking = ParseUtil.getLow4(bArr[i + 7]) == 1;
            }
        }
    }

    public boolean isTimerMode() {
        return this.childMode == 1 && this.intervalTime > 0;
    }
}

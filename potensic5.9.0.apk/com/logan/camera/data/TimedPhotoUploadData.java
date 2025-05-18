package com.logan.camera.data;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes2.dex */
public class TimedPhotoUploadData {
    public int childMode = 0;
    public int countDown = 0;
    public int finishCount = 0;

    public String toString() {
        return "TimedPhotoUploadData{childMode=" + this.childMode + ", countDown=" + this.countDown + ", finishCount=" + this.finishCount + '}';
    }

    public String getCountDownString() {
        return this.countDown > 0 ? "" + this.countDown : "";
    }

    public String getPhotoCountString() {
        return "" + this.finishCount + TtmlNode.TAG_P;
    }

    public void parseData(byte[] bArr, int i) {
        int i2 = i + 5;
        if (bArr.length > i2) {
            this.childMode = bArr[i + 2];
            this.finishCount = ParseUtil.getUnsignedShort(ParseUtil.byteArr2short1(new byte[]{bArr[i + 3], bArr[i + 4]}));
            this.countDown = bArr[i2];
        }
    }
}
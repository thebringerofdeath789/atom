package com.logan.fpv8030;

/* loaded from: classes.dex */
public class PreviewData {
    public byte[] data;
    public int dataLen;
    public int pkgOrder;
    public int videoHeight;
    public int videoWidth;
    public boolean isStart = false;
    public boolean isEnd = false;
    public StreamType streamType = StreamType.H264;

    public String toString() {
        return "PreviewData{dataLen=" + this.dataLen + ", pkgOrder=" + this.pkgOrder + ", isStart=" + this.isStart + ", isEnd=" + this.isEnd + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", streamType=" + this.streamType + '}';
    }
}
package com.logan.camera.data;

/* loaded from: classes2.dex */
public class FormatSdCardData extends BaseData {
    private int partitionNum;
    private long sdFreeSpace;
    private int sdStatus;
    private long sdTotalSpace;

    public FormatSdCardData(int i, long j, long j2, int i2) {
        this.sdStatus = -1;
        this.sdFreeSpace = -1L;
        this.sdTotalSpace = -1L;
        this.partitionNum = -1;
        this.sdStatus = i;
        this.sdFreeSpace = j;
        this.sdTotalSpace = j2;
        this.partitionNum = i2;
    }

    public int getSdStatus() {
        return this.sdStatus;
    }

    public long getSdFreeSpace() {
        return this.sdFreeSpace;
    }

    public long getSdTotalSpace() {
        return this.sdTotalSpace;
    }

    public int getPartitionNum() {
        return this.partitionNum;
    }
}

package com.logan.camera.data;

import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes2.dex */
public class DownloadData extends BaseData {
    private boolean isFileEnd;
    private boolean isUnitEnd;
    private long offset;
    private byte[] payload;
    private int payloadLen;

    public DownloadData(byte[] bArr) throws Exception {
        this.isFileEnd = false;
        this.isUnitEnd = false;
        this.offset = 0L;
        this.payloadLen = 0;
        this.payload = null;
        int payloadIndex = UsbConfig.getPayloadIndex(0);
        int i = payloadIndex + 2;
        this.isUnitEnd = bArr[i] == 1;
        boolean z = bArr[i] == 2;
        this.isFileEnd = z;
        if (!z) {
            this.offset = ParseUtil.byteArrayToLong(bArr, payloadIndex + 3);
            int unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex + 11);
            this.payloadLen = unsignedShortFromByteArr;
            byte[] bArr2 = new byte[unsignedShortFromByteArr];
            this.payload = bArr2;
            System.arraycopy(bArr, payloadIndex + 13, bArr2, 0, unsignedShortFromByteArr);
            return;
        }
        this.offset = ParseUtil.byteArrayToLong(bArr, payloadIndex + 3 + 32);
        int unsignedShortFromByteArr2 = ParseUtil.getUnsignedShortFromByteArr(bArr, payloadIndex + 11 + 32);
        this.payloadLen = unsignedShortFromByteArr2;
        byte[] bArr3 = new byte[unsignedShortFromByteArr2];
        this.payload = bArr3;
        System.arraycopy(bArr, payloadIndex + 13 + 32, bArr3, 0, unsignedShortFromByteArr2);
    }

    public boolean isUnitEnd() {
        return this.isUnitEnd;
    }

    public boolean isFileEnd() {
        return this.isFileEnd;
    }

    public long getOffset() {
        return this.offset;
    }

    public int getPayloadLen() {
        return this.payloadLen;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public String toString() {
        return "DownloadData{isFileEnd=" + this.isFileEnd + "isUnitEnd=" + this.isUnitEnd + ", offset=" + this.offset + '}';
    }
}
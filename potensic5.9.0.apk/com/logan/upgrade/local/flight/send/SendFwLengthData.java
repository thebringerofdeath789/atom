package com.logan.upgrade.local.flight.send;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes3.dex */
public class SendFwLengthData extends BaseSendData {
    private int packageNum;

    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    public byte getRequestCode() {
        return (byte) -12;
    }

    public void init(int i, byte b, int i2) {
        setData(ParseUtil.concatAll(ParseUtil.intBigByteArr(i), new byte[]{b}, ParseUtil.intBigByteArr(i2)));
        this.packageNum = i / (b * 256);
    }

    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    public byte[] getDataLength() {
        return new byte[]{0, 9};
    }

    public int totalPackageNum() {
        return this.packageNum;
    }
}
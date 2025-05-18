package com.logan.upgrade.local.flight.send;

/* loaded from: classes3.dex */
public class SendShakeHandData extends BaseSendData {
    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    public byte getRequestCode() {
        return (byte) -16;
    }

    public SendShakeHandData() {
        setData(0);
    }

    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    public byte[] getDataLength() {
        return new byte[]{0, 1};
    }
}
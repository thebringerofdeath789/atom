package com.logan.upgrade.local.flight.send;

/* loaded from: classes3.dex */
public class SendFwRunData extends BaseSendData {
    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    protected byte getRequestCode() {
        return (byte) -8;
    }

    public SendFwRunData() {
        setData(null);
    }

    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    protected byte[] getDataLength() {
        return new byte[]{0, 0};
    }
}
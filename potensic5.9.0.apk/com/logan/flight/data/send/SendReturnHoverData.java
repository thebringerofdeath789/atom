package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendReturnHoverData extends BaseSendData {
    public static final int CANCEL_HOVER_ID = 2;
    public static final int CONFIRM_HOVER_ID = 3;

    /* renamed from: ID */
    public static final int f2482ID = 0;
    public static final int REV_HOVER_ID = 1;

    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 4;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 8;
    }

    public void setId(int i, int i2) {
        this.payload[0] = (byte) i;
        this.payload[2] = (byte) i2;
    }
}
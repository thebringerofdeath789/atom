package com.logan.flight.data.recv;

/* loaded from: classes.dex */
public class FlightRevP1V2TestData extends BaseFlightRevData implements Cloneable {
    public static final byte MSG_ID = 11;
    private byte[] data;
    private int payloadIndex;

    public static byte getMsgId() {
        return (byte) 11;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    public void parseData(byte[] bArr, int i) {
        this.data = bArr;
        this.payloadIndex = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getPayloadIndex() {
        return this.payloadIndex;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevP1V2TestData m26clone() throws CloneNotSupportedException {
        return (FlightRevP1V2TestData) super.clone();
    }
}

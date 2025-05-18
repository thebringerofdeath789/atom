package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public abstract class BaseSendData {
    protected byte[] payload;

    public abstract short getFunctionCode();

    public abstract int getPayloadLen();

    public BaseSendData() {
        this.payload = null;
        this.payload = new byte[getPayloadLen()];
    }

    public byte[] getBytes() {
        return UsbPayloadWrapper.wrap(getFunctionCode(), this.payload);
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public String toString() {
        return getClass().getSimpleName() + " : " + ParseUtil.byteToHexString(getBytes());
    }
}
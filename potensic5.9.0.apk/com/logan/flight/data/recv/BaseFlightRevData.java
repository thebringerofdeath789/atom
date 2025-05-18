package com.logan.flight.data.recv;

/* loaded from: classes.dex */
public abstract class BaseFlightRevData {
    private boolean isInit = false;

    protected abstract void parseData(byte[] bArr, int i);

    public final void parse(byte[] bArr, int i) {
        parseData(bArr, i);
        this.isInit = true;
    }

    public boolean isInit() {
        return this.isInit;
    }
}
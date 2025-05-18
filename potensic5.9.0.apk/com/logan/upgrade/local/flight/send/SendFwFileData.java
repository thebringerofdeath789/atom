package com.logan.upgrade.local.flight.send;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes3.dex */
public class SendFwFileData extends BaseSendData {
    private short index;
    private boolean isLastPackage = false;
    private short length;

    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    public byte getRequestCode() {
        return (byte) -10;
    }

    public void init(byte[] bArr, short s, short s2, boolean z) {
        this.length = s2;
        this.index = s;
        this.isLastPackage = z;
        setData(ParseUtil.concatAll(ParseUtil.short2ByteArr(s), bArr));
    }

    @Override // com.logan.upgrade.local.flight.send.BaseSendData
    public byte[] getDataLength() {
        return ParseUtil.short2ByteArr((short) (this.length + 2));
    }

    public boolean isLastPackage() {
        return this.isLastPackage;
    }

    public short getIndex() {
        return this.index;
    }
}
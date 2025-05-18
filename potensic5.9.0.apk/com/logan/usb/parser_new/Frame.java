package com.logan.usb.parser_new;

import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes3.dex */
public class Frame {
    private byte[] data;
    private short from;
    private short msgId;
    private int payloadLen;

    public short getMsgId() {
        return this.msgId;
    }

    public void setMsgId(short s) {
        this.msgId = s;
    }

    public short getFrom() {
        return this.from;
    }

    public void setFrom(short s) {
        this.from = s;
    }

    public int getPayloadLen() {
        return this.payloadLen;
    }

    public void setPayloadLen(int i) {
        this.payloadLen = i;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public int getPayloadIndex() {
        return UsbConfig.isNewFC ? 6 : 5;
    }

    public String toString() {
        return "Frame{type=" + ParseUtil.byteToHexString(ParseUtil.short2ByteArr(this.msgId)) + ", payloadLen=" + this.payloadLen + ", payload=" + ParseUtil.byteToHexString(this.data, 30) + '}';
    }
}
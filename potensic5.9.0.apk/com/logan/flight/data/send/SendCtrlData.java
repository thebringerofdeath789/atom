package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.enums.CtrlType;

/* loaded from: classes.dex */
public class SendCtrlData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 20;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 32;
    }

    public void setCtrlType(CtrlType ctrlType) {
        ParseUtil.short2ByteArr(ctrlType.command, this.payload, 2);
        ParseUtil.intSmallByteArr(ctrlType.result_param2, this.payload, 20);
    }

    public static void main(String[] strArr) {
        SendCtrlData sendCtrlData = new SendCtrlData();
        sendCtrlData.setCtrlType(CtrlType.TYPE_LOST_RETURN_TO_120M);
        System.out.println(ParseUtil.byteToHexString(sendCtrlData.getBytes()));
    }
}
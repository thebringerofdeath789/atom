package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.enums.CommonMsgType;
import com.logan.flight.utils.ByteUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SendGeneralData extends BaseSendData {
    private static final String TAG = "SendGeneralData";

    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 27;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 21;
    }

    public void setDataType(CommonMsgType commonMsgType) {
        ArrayList arrayList = new ArrayList();
        ByteUtil.listAddArray(arrayList, ParseUtil.short2ByteArrSmall(commonMsgType.getCommand()));
        arrayList.add(Byte.valueOf(commonMsgType.getParam1()));
        byte[] byteListToByteArray = ByteUtil.byteListToByteArray(arrayList);
        for (int i = 0; i < byteListToByteArray.length; i++) {
            this.payload[i] = byteListToByteArray[i];
        }
    }
}

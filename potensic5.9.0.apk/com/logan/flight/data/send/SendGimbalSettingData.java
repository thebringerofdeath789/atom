package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;

/* loaded from: classes.dex */
public class SendGimbalSettingData extends BaseSendData {
    private int FPV_smooth;
    private int gimbal_calibration;
    private int gimbal_model;
    private int gimbal_reset;
    private int pitch_control;
    private short pitch_speed;
    private short tuning_roll;
    private short tuning_yaw;

    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 26;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 11;
    }

    public void init(FlightRevGimbalSettingData flightRevGimbalSettingData) {
    }

    public void init(int i, short s, boolean z, int i2, int i3, short s2, short s3, int i4) {
        this.payload[0] = (byte) i;
        ParseUtil.short2ByteArr(s, this.payload, 1);
        this.payload[3] = (byte) (!z ? 1 : 0);
        this.payload[4] = (byte) i2;
        this.payload[5] = (byte) i3;
        ParseUtil.short2ByteArr(s2, this.payload, 6);
        ParseUtil.short2ByteArr(s3, this.payload, 8);
        this.payload[10] = (byte) i4;
    }
}
package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.UnitUtil;

/* loaded from: classes.dex */
public class FlightRevGimbalStateData extends BaseFlightRevData implements Cloneable {
    private double control_pitch;
    private short error_status;
    private boolean is_pitch_change;
    private int pitch;
    private float pitch_speed;
    private double roll;
    private float roll_speed;
    private double yaw;
    private float yaw_speed;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.roll = ParseUtil.getSignedShortFromByteArr(bArr, i) / 100.0d;
        int i2 = i + 2;
        System.out.println(ParseUtil.byteToHexString(new byte[]{bArr[i2], bArr[i + 3]}));
        System.out.println((int) ParseUtil.getSignedShortFromByteArr(bArr, i2));
        this.pitch = UnitUtil.round(ParseUtil.getSignedShortFromByteArr(bArr, i2) / 100.0f);
        this.yaw = ParseUtil.getSignedShortFromByteArr(bArr, i + 4) / 100.0d;
        this.roll_speed = ParseUtil.getFloatFromBytesBig(bArr, i + 6);
        this.pitch_speed = ParseUtil.getFloatFromBytesBig(bArr, i + 10);
        this.yaw_speed = ParseUtil.getFloatFromBytesBig(bArr, i + 14);
        this.error_status = (short) ParseUtil.getUnsignedShortFromByteArr(bArr, i + 18);
        this.is_pitch_change = bArr[i + 20] == 1;
        this.control_pitch = ParseUtil.getSignedShortFromByteArr(bArr, i + 21) / 100.0d;
    }

    public double getRoll() {
        return this.roll;
    }

    public int getPitch() {
        return this.pitch;
    }

    public double getYaw() {
        return this.yaw;
    }

    public float getRoll_speed() {
        return this.roll_speed;
    }

    public float getPitch_speed() {
        return this.pitch_speed;
    }

    public float getYaw_speed() {
        return this.yaw_speed;
    }

    public short getError_status() {
        return this.error_status;
    }

    public boolean isIs_pitch_change() {
        return this.is_pitch_change;
    }

    public int getControl_pitch() {
        return UnitUtil.round((float) this.control_pitch);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevGimbalStateData m2617clone() throws CloneNotSupportedException {
        return (FlightRevGimbalStateData) super.clone();
    }

    public boolean isGimbalError() {
        short s = this.error_status;
        return s == 1 || s == 2;
    }

    public boolean isGimbalNeedCalibration() {
        return this.error_status == 3;
    }

    public boolean isGimbalStuck() {
        return this.error_status == 4;
    }

    public boolean isGimbalOverload() {
        return this.error_status == 5;
    }

    public boolean isGimbalAngleTooBig() {
        return this.error_status == 6;
    }

    public boolean isGimbalPreparing() {
        return this.error_status == 7;
    }

    public boolean isGimbalTempTooHigh() {
        return this.error_status == 16;
    }

    public String toString() {
        return "FlightRevGimbalStateData{\nroll=" + this.roll + "\n, pitch=" + this.pitch + "\n, yaw=" + this.yaw + "\n, roll_speed=" + this.roll_speed + "\n, pitch_speed=" + this.pitch_speed + "\n, yaw_speed=" + this.yaw_speed + "\n, error_status=" + ((int) this.error_status) + "\n, is_pitch_change=" + this.is_pitch_change + "\n, control_pitch=" + this.control_pitch + '}';
    }
}
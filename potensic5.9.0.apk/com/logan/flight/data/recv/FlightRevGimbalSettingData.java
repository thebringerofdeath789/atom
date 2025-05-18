package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class FlightRevGimbalSettingData extends BaseFlightRevData {
    public static final int GIMBAL_CALIBRATION_AUTO = 1;
    public static final int GIMBAL_CALIBRATION_DEFAULT = 0;
    public static final int GIMBAL_CALIBRATION_FAILED = 4;
    public static final int GIMBAL_CALIBRATION_SUCCESS = 3;
    public static final int GIMBAL_CLEAR_IMU = 5;
    public static final int GIMBAL_PITCH_CTRL_0 = 1;
    public static final int GIMBAL_PITCH_CTRL_45 = 3;
    public static final int GIMBAL_PITCH_CTRL_90 = 2;
    public static final int GIMBAL_PITCH_CTRL_DEFAULT = 0;
    public static final int GIMBAL_RESET_DEFAULT = 0;
    public static final int GIMBAL_RESET_FPV_SMOOTH = 2;
    public static final int GIMBAL_RESET_PITCH_SPEED = 1;
    public static final int GIMBAL_RESET_ROLL = 3;
    public static final int GIMBAL_RESET_YAW = 4;
    private int fpvSmooth;
    private int gimbalCalibration;
    private int gimbalReset;
    private boolean isStableMode;
    private int pitchControl;
    private int pitchSpeed;
    private short tuningRoll;
    private short tuningYaw;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GimbalCalibration {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GimbalPitchAngle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GimbalReset {
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.pitchControl = bArr[i];
        this.pitchSpeed = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 1);
        this.isStableMode = bArr[i + 3] == 0;
        this.fpvSmooth = bArr[i + 4];
        this.gimbalCalibration = bArr[i + 5];
        this.tuningRoll = ParseUtil.getSignedShortFromByteArr(bArr, i + 6);
        this.tuningYaw = ParseUtil.getSignedShortFromByteArr(bArr, i + 8);
        this.gimbalReset = bArr[i + 10];
    }

    public int getPitchControl() {
        return this.pitchControl;
    }

    public int getPitchSpeed() {
        return this.pitchSpeed;
    }

    public boolean isStableMode() {
        return this.isStableMode;
    }

    public int getFpvSmooth() {
        return this.fpvSmooth;
    }

    public int getGimbalCalibration() {
        return this.gimbalCalibration;
    }

    public short getTuningRoll() {
        return this.tuningRoll;
    }

    public short getTuningYaw() {
        return this.tuningYaw;
    }

    public int getGimbalReset() {
        return this.gimbalReset;
    }

    public String toString() {
        return "FlightRevGimbalSettingData{\n, pitchControl=" + this.pitchControl + "\n, pitchSpeed=" + this.pitchSpeed + "\n, isStableMode=" + this.isStableMode + "\n, fpvSmooth=" + this.fpvSmooth + "\n, gimbalCalibration=" + this.gimbalCalibration + "\n, tuningRoll=" + ((int) this.tuningRoll) + "\n, tuningYaw=" + ((int) this.tuningYaw) + "\n, gimbalReset=" + this.gimbalReset + '}';
    }
}
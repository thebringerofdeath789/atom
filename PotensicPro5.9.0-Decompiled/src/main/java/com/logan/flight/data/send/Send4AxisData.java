package com.logan.flight.data.send;

import com.logan.flight.listeners.IAxisController;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class Send4AxisData extends BaseSendData implements IAxisController {
    public static final int LIGHT_HIGH = 128;
    public static final int LIGHT_LOW = 0;
    public static final int LIGHT_MEDIUM = 64;
    public static final int SPEED_HIGH = 2;
    public static final int SPEED_LOW = 0;
    public static final int SPEED_NORMAL = 1;
    public static final int UNKNOWN = -1;
    private int channel = 4;
    private int accelerator = 125;
    private int rotate = 125;
    private int frontBack = 125;
    private int leftRight = 125;
    private int gimbal = 125;
    private int camera = 125;
    private byte lightControl = 0;
    private byte others = 0;
    private byte calibration = 0;
    private byte recTakePic = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LightControl {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Speed {
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 1;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 11;
    }

    public Send4AxisData() {
        this.payload[0] = 4;
        this.payload[1] = SendOthersData.FUNC_ID_REMOTER_OUTPUT;
        this.payload[2] = SendOthersData.FUNC_ID_REMOTER_OUTPUT;
        this.payload[3] = SendOthersData.FUNC_ID_REMOTER_OUTPUT;
        this.payload[4] = SendOthersData.FUNC_ID_REMOTER_OUTPUT;
        this.payload[5] = SendOthersData.FUNC_ID_REMOTER_OUTPUT;
        this.payload[6] = SendOthersData.FUNC_ID_REMOTER_OUTPUT;
        this.payload[7] = 0;
        this.payload[8] = 0;
        this.payload[9] = 0;
        this.payload[10] = 0;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setChanel(int i) {
        this.channel = i;
        this.payload[0] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setAccelerator(int i) {
        this.accelerator = i;
        this.payload[1] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setRotate(int i) {
        this.rotate = i;
        this.payload[2] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setFrontBack(int i) {
        this.frontBack = i;
        this.payload[3] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setLeftRight(int i) {
        this.leftRight = i;
        this.payload[4] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setGimbal(int i) {
        this.gimbal = i;
        this.payload[5] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setCamera(int i) {
        this.camera = i;
        this.payload[6] = (byte) i;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setWorkMode() {
        this.lightControl = (byte) (this.lightControl ^ 1);
        this.payload[7] = this.lightControl;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setLightControl(int i) {
        byte b = (byte) (this.lightControl | (-64));
        this.lightControl = b;
        if (i == 0) {
            byte b2 = (byte) (b ^ 64);
            this.lightControl = b2;
            this.lightControl = (byte) (b2 ^ Byte.MIN_VALUE);
        } else if (i == 64) {
            this.lightControl = (byte) (b ^ Byte.MIN_VALUE);
        } else if (i == 128) {
            this.lightControl = (byte) (b ^ 64);
        }
        this.payload[7] = this.lightControl;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setRotateMode() {
        this.others = (byte) (this.others ^ 4);
        this.payload[8] = this.others;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setReturnMode() {
        this.others = (byte) (this.others ^ 8);
        this.payload[8] = this.others;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setNoHeadMode() {
        this.others = (byte) (this.others ^ 16);
        this.payload[8] = this.others;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setFastStopMode() {
        this.others = (byte) (this.others ^ 32);
        this.payload[8] = this.others;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setLaunch() {
        this.others = (byte) (this.others ^ 64);
        this.payload[8] = this.others;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setGeoCalibration() {
        this.calibration = (byte) (this.calibration ^ 1);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setHorizontalCalibration() {
        this.calibration = (byte) (this.calibration ^ 2);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setUnLock() {
        this.calibration = (byte) (this.calibration ^ 4);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setCircleFly() {
        this.calibration = (byte) (this.calibration ^ 8);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setPointFly() {
        this.calibration = (byte) (this.calibration ^ 16);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setOneKeyCalibration() {
        this.calibration = (byte) (this.calibration ^ 32);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setFixedHeight() {
        this.calibration = (byte) (this.calibration ^ 64);
        this.payload[9] = this.calibration;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void takePhoto() {
        this.recTakePic = (byte) (this.recTakePic ^ 1);
        this.payload[10] = this.recTakePic;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void record() {
        this.recTakePic = (byte) (this.recTakePic ^ 2);
        this.payload[10] = this.recTakePic;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void takePhotoCallback() {
        this.recTakePic = (byte) (this.recTakePic ^ 4);
        this.payload[10] = this.recTakePic;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void recordCallback() {
        this.recTakePic = (byte) (this.recTakePic ^ 8);
        this.payload[10] = this.recTakePic;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void cameraToDownOrRight() {
        this.recTakePic = (byte) (this.recTakePic ^ 16);
        this.payload[10] = this.recTakePic;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void cameraToUpOrLeft() {
        this.recTakePic = (byte) (this.recTakePic ^ 32);
        this.payload[10] = this.recTakePic;
    }

    @Override // com.logan.flight.listeners.IAxisController
    public void setPhoneOrRemoter() {
        this.recTakePic = (byte) (this.recTakePic ^ Byte.MIN_VALUE);
        this.payload[10] = this.recTakePic;
    }
}

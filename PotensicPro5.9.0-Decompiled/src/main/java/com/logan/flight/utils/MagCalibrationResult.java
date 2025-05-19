package com.logan.flight.utils;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MagCalibrationResult {
    private float[] bias_result;
    private float[] mg_db_result;
    private float[] msg_sample;
    private float[] offdiag_result;
    private boolean[] reference_flag_result;
    private float[] scale_result;
    public int x;
    public int y;

    public int getX() {
        return this.x;
    }

    public void setX(int i) {
        this.x = i;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int i) {
        this.y = i;
    }

    public float[] getScale_result() {
        return this.scale_result;
    }

    public void setScale_result(float[] fArr) {
        this.scale_result = fArr;
    }

    public float[] getBias_result() {
        return this.bias_result;
    }

    public void setBias_result(float[] fArr) {
        this.bias_result = fArr;
    }

    public float[] getOffdiag_result() {
        return this.offdiag_result;
    }

    public void setOffdiag_result(float[] fArr) {
        this.offdiag_result = fArr;
    }

    public float[] getMsg_sample() {
        return this.msg_sample;
    }

    public void setMsg_sample(float[] fArr) {
        this.msg_sample = fArr;
    }

    public boolean isHorizontalCalibration() {
        return (this.x != 0 || isCalibrationFinish() || isCalibrationTimeout() || isCalibrationFailed()) ? false : true;
    }

    public boolean isVerticalCalibration() {
        return (this.x != 1 || isCalibrationFinish() || isCalibrationTimeout() || isCalibrationFailed()) ? false : true;
    }

    public boolean isCalibrationTimeout() {
        return this.y == 1;
    }

    public boolean isCalibrationFinish() {
        return this.y == 2;
    }

    public boolean isCalibrationFailed() {
        return this.y == 3;
    }

    public String toString() {
        if (isCalibrationFailed()) {
            return "MagCalibrationResult{水平校准=" + isHorizontalCalibration() + ", 垂直校准=" + isVerticalCalibration() + ", 校准超时=" + isCalibrationTimeout() + ", 校准失败=" + isCalibrationFailed() + ", 校准成功=" + isCalibrationFinish() + ", scale_result=" + Arrays.toString(this.scale_result) + ", bias_result=" + Arrays.toString(this.bias_result) + ", offdiag_result=" + Arrays.toString(this.offdiag_result) + ", reference_flag_result=" + Arrays.toString(this.reference_flag_result) + ", mg_db_result=" + Arrays.toString(this.mg_db_result) + ", x = " + this.x + ", y = " + this.y + '}';
        }
        if (isCalibrationTimeout()) {
            return "MagCalibrationResult{水平校准=" + isHorizontalCalibration() + ", 垂直校准=" + isVerticalCalibration() + ", 校准超时=" + isCalibrationTimeout() + ", 校准成功=" + isCalibrationFinish() + ", x = " + this.x + ", y = " + this.y + '}';
        }
        return "MagCalibrationResult{水平校准=" + isHorizontalCalibration() + ", 垂直校准=" + isVerticalCalibration() + ", 校准超时=" + isCalibrationTimeout() + ", 校准成功=" + isCalibrationFinish() + ", scale_result=" + Arrays.toString(this.scale_result) + ", bias_result=" + Arrays.toString(this.bias_result) + ", offdiag_result=" + Arrays.toString(this.offdiag_result) + ", reference_flag_result=" + Arrays.toString(this.reference_flag_result) + ", mg_db_result=" + Arrays.toString(this.mg_db_result) + ", x = " + this.x + ", y = " + this.y + '}';
    }

    public ArrayList<Result> getAllResult() {
        ArrayList<Result> arrayList = new ArrayList<>();
        arrayList.add(new Result("SENS_MAG_XOFF", this.bias_result[0]));
        arrayList.add(new Result("SENS_MAG_YOFF", this.bias_result[1]));
        arrayList.add(new Result("SENS_MAG_ZOFF", this.bias_result[2]));
        arrayList.add(new Result("SENS_MAG_XXSCALE", this.scale_result[0]));
        arrayList.add(new Result("SENS_MAG_XYSCALE", this.offdiag_result[0]));
        arrayList.add(new Result("SENS_MAG_XZSCALE", this.offdiag_result[1]));
        arrayList.add(new Result("SENS_MAG_YXSCALE", this.offdiag_result[0]));
        arrayList.add(new Result("SENS_MAG_YYSCALE", this.scale_result[1]));
        arrayList.add(new Result("SENS_MAG_YZSCALE", this.offdiag_result[2]));
        arrayList.add(new Result("SENS_MAG_ZXSCALE", this.offdiag_result[1]));
        arrayList.add(new Result("SENS_MAG_ZYSCALE", this.offdiag_result[2]));
        arrayList.add(new Result("SENS_MAG_ZZSCALE", this.scale_result[2]));
        return arrayList;
    }

    public float[] getAllFloatResult() {
        float[] fArr = this.bias_result;
        float[] fArr2 = this.scale_result;
        float[] fArr3 = this.offdiag_result;
        return new float[]{fArr[0], fArr[1], fArr[2], fArr2[0], fArr3[0], fArr3[1], fArr3[0], fArr2[1], fArr3[2], fArr3[1], fArr3[2], fArr2[2]};
    }

    public boolean[] getReference_flag_result() {
        return this.reference_flag_result;
    }

    public void setReference_flag_result(boolean[] zArr) {
        this.reference_flag_result = zArr;
    }

    public float[] getMg_db_result() {
        return this.mg_db_result;
    }

    public void setMg_db_result(float[] fArr) {
        this.mg_db_result = fArr;
    }

    public static class Result {
        private String id;
        private float value;
        private byte[] param_id = new byte[17];
        private boolean isNotifyFc = false;

        public Result(String str, float f) {
            this.id = str;
            byte[] bytes = str.getBytes();
            System.arraycopy(bytes, 0, this.param_id, 0, bytes.length);
            this.value = f;
        }

        public String getId() {
            return this.id;
        }

        public byte[] getParam_id() {
            return this.param_id;
        }

        public float getValue() {
            return this.value;
        }

        public boolean isNotifyFc() {
            return this.isNotifyFc;
        }

        public void setNotifyFc(boolean z) {
            this.isNotifyFc = z;
        }
    }
}

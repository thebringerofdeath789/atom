package com.logan.flight.calibration;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.flight.DataSender;
import com.logan.flight.FlightConfig;
import com.logan.flight.JniUtils;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevCalResultData;
import com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormal;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevMagCalibrationResultData;
import com.logan.flight.data.send.SendCalFeedbackData;
import com.logan.flight.data.send.SendCalResultData;
import com.logan.flight.data.send.SendEnterQuitCalibrationData;
import com.logan.flight.utils.MagCalibrationResult;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MiniMagCalibrationHelper implements IMagCalibrationHelper {
    private MagCalibrationResult.Result currentResult;
    private double lat;
    private double lng;
    private FileOutputStream outputStream;
    private MagCalibrationResult result;
    private ArrayList<MagCalibrationResult.Result> resultList;
    private OnCalibrationResultListener resultListener;
    private long startTime;
    private final int TIMEOUT = 2000;
    private boolean isStart = false;
    private boolean isCalibrationEnd = false;
    private final Runnable sendResultRunnable = new Runnable() { // from class: com.logan.flight.calibration.MiniMagCalibrationHelper.2
        @Override // java.lang.Runnable
        public void run() {
            if (MiniMagCalibrationHelper.this.currentResult == null || MiniMagCalibrationHelper.this.isCalibrationEnd || !FlightConfig.isConnectFlight()) {
                return;
            }
            SendCalResultData sendCalResultData = new SendCalResultData();
            sendCalResultData.set(MiniMagCalibrationHelper.this.currentResult.getParam_id(), MiniMagCalibrationHelper.this.currentResult.getValue());
            DDLog.m1684e("发送校准数据给飞控:" + ParseUtil.byteToHexString(sendCalResultData.getBytes()));
            if (MiniMagCalibrationHelper.this.outputStream != null) {
                try {
                    MiniMagCalibrationHelper.this.outputStream.write(("\n发送校准结果给飞控:id:" + new String(MiniMagCalibrationHelper.this.currentResult.getParam_id()) + ",value:" + MiniMagCalibrationHelper.this.currentResult.getValue() + ",data:" + ParseUtil.byteToHexString(sendCalResultData.getBytes())).getBytes());
                } catch (Exception e) {
                    DDLog.m1684e("保存出错:" + e.getMessage());
                }
            }
            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendCalResultData.getBytes());
            PhoneConfig.mainHandler.postDelayed(this, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    };

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void revData(FlightRevFlightCtrlToAppNormal flightRevFlightCtrlToAppNormal) {
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void revData(FlightRevMagCalibrationResultData flightRevMagCalibrationResultData) {
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void start() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        if (!FlightConfig.GPS.isLastLocation() && FlightConfig.GPS.getLat() != 0.0d && FlightConfig.GPS.getLng() != 0.0d) {
            this.lat = FlightConfig.GPS.getLat();
            this.lng = FlightConfig.GPS.getLng();
        } else {
            this.lat = flightRevFlightInfoData.getLat();
            this.lng = flightRevFlightInfoData.getLng();
        }
        JniUtils.startCalibration(this.lat, this.lng);
        SendEnterQuitCalibrationData sendEnterQuitCalibrationData = new SendEnterQuitCalibrationData();
        sendEnterQuitCalibrationData.set(true);
        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendEnterQuitCalibrationData.getBytes());
        this.startTime = System.currentTimeMillis();
        try {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.outputStream = null;
            }
            this.outputStream = new FileOutputStream(LocalFileManager.getInstance().getLogDir() + File.separator + "Geo_Cal_" + FormatUtil.getCurTime() + ".txt");
        } catch (Exception unused) {
        }
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public boolean isStart() {
        return this.isStart;
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void calibration(FlightRevGeoTestData flightRevGeoTestData) {
        float doubleValue;
        OnCalibrationResultListener onCalibrationResultListener;
        OnCalibrationResultListener onCalibrationResultListener2;
        OnCalibrationResultListener onCalibrationResultListener3;
        OnCalibrationResultListener onCalibrationResultListener4;
        if (!this.isStart || flightRevGeoTestData == null) {
            return;
        }
        float currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000.0f;
        try {
            doubleValue = Float.parseFloat(new DecimalFormat(".000").format(currentTimeMillis));
        } catch (Exception unused) {
            doubleValue = (float) new BigDecimal(currentTimeMillis).setScale(3, 4).doubleValue();
        }
        this.startTime = System.currentTimeMillis();
        DDLog.m1684e("校准2");
        this.result = JniUtils.magCalibration(flightRevGeoTestData.getCompassX(), flightRevGeoTestData.getCompassY(), flightRevGeoTestData.getCompassZ(), flightRevGeoTestData.getXGyro(), flightRevGeoTestData.getYGyro(), flightRevGeoTestData.getZGyro(), doubleValue, false, 0.0f);
        DDLog.m1684e("校准结果:" + this.result.toString());
        SendCalFeedbackData sendCalFeedbackData = new SendCalFeedbackData();
        sendCalFeedbackData.update(this.result);
        DDLog.m1684e("发送每次校准数据给飞控：" + ParseUtil.byteToHexString(sendCalFeedbackData.getBytes()));
        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendCalFeedbackData.getBytes());
        if (this.result.isCalibrationFinish() || this.result.isCalibrationFailed()) {
            try {
                this.outputStream.write((this.result.toString() + "\n\n").getBytes());
                this.outputStream.write(("\n lat = " + this.lat + "; lng = " + this.lng + "\n\n").getBytes());
                for (int i = 0; i < this.result.getMsg_sample().length; i++) {
                    this.outputStream.write((i + " : " + this.result.getMsg_sample()[i] + "\n").getBytes());
                }
            } catch (Exception e) {
                DDLog.m1684e("校准存储失败：" + e.getMessage());
            }
        }
        if (this.result.isHorizontalCalibration() && (onCalibrationResultListener4 = this.resultListener) != null) {
            onCalibrationResultListener4.onHorizontalCalibration();
        }
        if (this.result.isVerticalCalibration() && (onCalibrationResultListener3 = this.resultListener) != null) {
            onCalibrationResultListener3.onVerticalCalibration();
        }
        if (this.result.isCalibrationFailed() && (onCalibrationResultListener2 = this.resultListener) != null) {
            onCalibrationResultListener2.onResultFailed(this.result);
        }
        if (this.result.isCalibrationTimeout() && (onCalibrationResultListener = this.resultListener) != null) {
            onCalibrationResultListener.onResultTimeout(this.result);
        }
        if (this.result.isCalibrationTimeout() || this.result.isCalibrationFailed() || this.result.isCalibrationFinish()) {
            stop();
        }
        if (this.result.isCalibrationFinish()) {
            this.resultList = this.result.getAllResult();
            MagCalibrationResult.Result nextResult = getNextResult();
            this.currentResult = nextResult;
            if (nextResult != null) {
                PhoneConfig.mainHandler.post(this.sendResultRunnable);
            }
        }
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void revData(FlightRevCalResultData flightRevCalResultData) {
        DDLog.m1684e("飞控收到校准结果：" + flightRevCalResultData.toString());
        PhoneConfig.mainHandler.removeCallbacks(this.sendResultRunnable);
        if (!flightRevCalResultData.isSuccess() || (this.currentResult != null && !ParseUtil.isBytesEqual(flightRevCalResultData.getParam_id(), this.currentResult.getParam_id()))) {
            PhoneConfig.mainHandler.post(this.sendResultRunnable);
            return;
        }
        this.currentResult.setNotifyFc(true);
        this.currentResult = getNextResult();
        DDLog.m1684e("校准结果 是否完成：" + this.currentResult);
        if (this.currentResult != null) {
            PhoneConfig.mainHandler.post(this.sendResultRunnable);
            return;
        }
        this.isCalibrationEnd = true;
        try {
            FileOutputStream fileOutputStream = this.outputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.outputStream = null;
            }
        } catch (Exception unused) {
        }
        OnCalibrationResultListener onCalibrationResultListener = this.resultListener;
        if (onCalibrationResultListener != null) {
            onCalibrationResultListener.onResultSuccess(this.result);
        }
    }

    private MagCalibrationResult.Result getNextResult() {
        if (this.resultList == null) {
            return null;
        }
        for (int i = 0; i < this.resultList.size(); i++) {
            MagCalibrationResult.Result result = this.resultList.get(i);
            if (!result.isNotifyFc()) {
                return result;
            }
        }
        return null;
    }

    private void stop() {
        if (this.isStart) {
            SendEnterQuitCalibrationData sendEnterQuitCalibrationData = new SendEnterQuitCalibrationData();
            sendEnterQuitCalibrationData.set(false);
            DDLog.m1684e("发送停止校准指令：" + ParseUtil.byteToHexString(sendEnterQuitCalibrationData.getBytes()));
            DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendEnterQuitCalibrationData.getBytes());
        }
        this.isStart = false;
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void release() {
        PhoneConfig.mainHandler.removeCallbacks(this.sendResultRunnable);
        stop();
        this.isCalibrationEnd = true;
        OnCalibrationResultListener onCalibrationResultListener = this.resultListener;
        if (onCalibrationResultListener != null) {
            onCalibrationResultListener.onRelease();
        }
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void setCalibrationResultListener(OnCalibrationResultListener onCalibrationResultListener) {
        this.resultListener = onCalibrationResultListener;
    }
}
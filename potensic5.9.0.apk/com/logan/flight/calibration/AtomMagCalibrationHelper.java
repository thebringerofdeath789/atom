package com.logan.flight.calibration;

import androidx.databinding.Observable;
import androidx.databinding.ObservableInt;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.CustomTimer;
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
import com.logan.flight.data.send.SendEnterQuitCalibrationData;
import com.logan.flight.data.send.SendMagCalibrationResult;
import com.logan.flight.enums.NormalCmdType;
import com.logan.flight.utils.MagCalibrationResult;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AtomMagCalibrationHelper implements IMagCalibrationHelper {
    private final long SEND_TIMEOUT;
    private final long TIMEOUT_REQUEST_NUM;
    private MagCalibrationResult calibratingResult;
    private final ObservableInt calibrationStep;
    private boolean isQuitCalibration;
    private double lat;
    private double lng;
    private FileOutputStream outputStream;
    private float[] resultList;
    private OnCalibrationResultListener resultListener;
    private byte[] resultPayload;
    private long startTime;
    private FileOutputStream testOutPutStream;
    private CustomTimer timer;
    private final int STEP_NOT_START = -1;
    private final int STEP_CALL_START = 0;
    private final int STEP_STARTED = 1;
    private final int STEP_START_HORIZONTAL = 2;
    private final int STEP_HORIZONTAL_NOTIFIED = 3;
    private final int STEP_START_VERTICAL = 4;
    private final int STEP_VERTICAL_NOTIFIED = 5;
    private final int STEP_TIMEOUT = 6;
    private final int STEP_SUCCESS = 7;
    private final int STEP_FAILED = 8;
    private final int STEP_CALL_STOP = 9;
    private final int STEP_STOPPED = 10;
    private final int STEP_END = 11;
    private final int STEP_STOP_WHATEVER = 12;

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void revData(FlightRevCalResultData flightRevCalResultData) {
    }

    public AtomMagCalibrationHelper() {
        ObservableInt observableInt = new ObservableInt(-1);
        this.calibrationStep = observableInt;
        this.resultPayload = null;
        this.isQuitCalibration = false;
        this.testOutPutStream = null;
        this.SEND_TIMEOUT = 200L;
        this.TIMEOUT_REQUEST_NUM = 50L;
        observableInt.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.logan.flight.calibration.AtomMagCalibrationHelper.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                switch (AtomMagCalibrationHelper.this.calibrationStep.get()) {
                    case 0:
                        AtomMagCalibrationHelper.this.sendStartCalibration();
                        break;
                    case 1:
                        AtomMagCalibrationHelper.this.startCalibration();
                        break;
                    case 2:
                        if (AtomMagCalibrationHelper.this.resultListener != null) {
                            AtomMagCalibrationHelper.this.resultListener.onHorizontalCalibration();
                        }
                        AtomMagCalibrationHelper.this.sendCalibratingResult();
                        break;
                    case 4:
                        if (AtomMagCalibrationHelper.this.resultListener != null) {
                            AtomMagCalibrationHelper.this.resultListener.onVerticalCalibration();
                        }
                        AtomMagCalibrationHelper.this.sendCalibratingResult();
                        break;
                    case 6:
                    case 7:
                    case 8:
                        AtomMagCalibrationHelper.this.sendCalibratingResult();
                        break;
                    case 9:
                    case 12:
                        AtomMagCalibrationHelper.this.sendQuitCalibration();
                        break;
                    case 10:
                        if (AtomMagCalibrationHelper.this.resultListener != null && AtomMagCalibrationHelper.this.calibratingResult != null) {
                            if (!AtomMagCalibrationHelper.this.calibratingResult.isCalibrationFinish()) {
                                if (AtomMagCalibrationHelper.this.calibratingResult.isCalibrationTimeout()) {
                                    AtomMagCalibrationHelper.this.resultListener.onResultTimeout(AtomMagCalibrationHelper.this.calibratingResult);
                                    break;
                                } else if (AtomMagCalibrationHelper.this.calibratingResult.isCalibrationFailed()) {
                                    AtomMagCalibrationHelper.this.resultListener.onResultFailed(AtomMagCalibrationHelper.this.calibratingResult);
                                    break;
                                }
                            } else {
                                AtomMagCalibrationHelper atomMagCalibrationHelper = AtomMagCalibrationHelper.this;
                                atomMagCalibrationHelper.resultList = atomMagCalibrationHelper.calibratingResult.getAllFloatResult();
                                AtomMagCalibrationHelper.this.sendSuccessData();
                                break;
                            }
                        }
                        break;
                }
            }
        });
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void start() {
        this.calibrationStep.set(0);
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public boolean isStart() {
        return this.calibrationStep.get() == 1 || this.calibrationStep.get() == 2 || this.calibrationStep.get() == 3 || this.calibrationStep.get() == 4 || this.calibrationStep.get() == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCalibration() {
        FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        if (!FlightConfig.GPS.isLastLocation() && FlightConfig.GPS.getLat() != 0.0d && FlightConfig.GPS.getLng() != 0.0d) {
            this.lat = FlightConfig.GPS.getLat();
            this.lng = FlightConfig.GPS.getLng();
        } else {
            this.lat = flightRevFlightInfoData.getLat();
            this.lng = flightRevFlightInfoData.getLng();
        }
        DDLog.m1684e("校准0 ： " + this.lat + "," + this.lng);
        JniUtils.startCalibration(this.lat, this.lng);
        this.startTime = System.currentTimeMillis();
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void calibration(FlightRevGeoTestData flightRevGeoTestData) {
        float doubleValue;
        if (isStart()) {
            float currentTimeMillis = (System.currentTimeMillis() - this.startTime) / 1000.0f;
            try {
                doubleValue = Float.parseFloat(new DecimalFormat(".000").format(currentTimeMillis));
            } catch (Exception unused) {
                doubleValue = (float) new BigDecimal(currentTimeMillis).setScale(3, 4).doubleValue();
            }
            this.startTime = System.currentTimeMillis();
            this.calibratingResult = JniUtils.magCalibration(flightRevGeoTestData.getCompassX(), flightRevGeoTestData.getCompassY(), flightRevGeoTestData.getCompassZ(), flightRevGeoTestData.getXGyro(), flightRevGeoTestData.getYGyro(), flightRevGeoTestData.getZGyro(), doubleValue, false, 0.0f);
            DDLog.m1684e("校准结果:" + this.calibratingResult.toString());
            if (isStart()) {
                if (this.calibratingResult.isHorizontalCalibration()) {
                    if (this.calibrationStep.get() != 3) {
                        this.calibrationStep.set(2);
                    }
                } else if (this.calibratingResult.isVerticalCalibration()) {
                    if (this.calibrationStep.get() != 5) {
                        this.calibrationStep.set(4);
                    }
                } else if (this.calibratingResult.isCalibrationFinish()) {
                    this.calibrationStep.set(7);
                } else if (this.calibratingResult.isCalibrationFailed()) {
                    this.calibrationStep.set(8);
                } else if (this.calibratingResult.isCalibrationTimeout()) {
                    this.calibrationStep.set(6);
                }
                if (this.calibratingResult.isCalibrationFinish() || this.calibratingResult.isCalibrationFailed() || this.calibratingResult.isCalibrationTimeout()) {
                    try {
                        FileOutputStream fileOutputStream = this.outputStream;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            this.outputStream = null;
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(LocalFileManager.getInstance().getLogDir() + File.separator + "Geo_Cal_" + FormatUtil.getCurTime() + ".txt");
                        this.outputStream = fileOutputStream2;
                        fileOutputStream2.write((this.calibratingResult.toString() + "\n\n").getBytes());
                        this.outputStream.write(("\n lat = " + this.lat + "; lng = " + this.lng + "\n\n").getBytes());
                        float[] msg_sample = this.calibratingResult.getMsg_sample();
                        for (int i = 0; i < msg_sample.length; i++) {
                            this.outputStream.write((i + " : " + msg_sample[i] + "\n").getBytes());
                        }
                        ArrayList<MagCalibrationResult.Result> allResult = this.calibratingResult.getAllResult();
                        for (int i2 = 0; i2 < allResult.size(); i2++) {
                            MagCalibrationResult.Result result = allResult.get(i2);
                            this.outputStream.write(("\n 校准成功的参数:" + result.getId() + " , data:" + result.getValue()).getBytes());
                        }
                        this.outputStream.close();
                        this.outputStream = null;
                        FileOutputStream fileOutputStream3 = this.testOutPutStream;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (Exception unused2) {
                            }
                            this.testOutPutStream = null;
                        }
                    } catch (Exception e) {
                        DDLog.m1684e("校准存储失败：" + e.getMessage());
                    }
                }
            }
        }
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void release() {
        DDLog.m1684e("校准3  release ： " + this.calibrationStep.get());
        removeTask();
        if (isStart()) {
            this.calibrationStep.set(12);
        } else {
            this.calibrationStep.set(11);
        }
        OnCalibrationResultListener onCalibrationResultListener = this.resultListener;
        if (onCalibrationResultListener != null) {
            onCalibrationResultListener.onRelease();
        }
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void setCalibrationResultListener(OnCalibrationResultListener onCalibrationResultListener) {
        this.resultListener = onCalibrationResultListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStartCalibration() {
        DDLog.m1684e("开始发送进入校准数据:" + this.calibrationStep.get());
        removeTask();
        CustomTimer customTimer = new CustomTimer(0L, 200L, 50, new CustomTimer.OnUpdateInChildThreadListener() { // from class: com.logan.flight.calibration.AtomMagCalibrationHelper.2
            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void update() {
                if (FlightConfig.isConnectFlight() && AtomMagCalibrationHelper.this.calibrationStep.get() == 0) {
                    SendEnterQuitCalibrationData sendEnterQuitCalibrationData = new SendEnterQuitCalibrationData();
                    sendEnterQuitCalibrationData.set(true);
                    DDLog.m1684e("发送开始校准指令：" + ParseUtil.byteToHexString(sendEnterQuitCalibrationData.getBytes()));
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendEnterQuitCalibrationData.getBytes());
                }
            }

            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void timeout() {
                AtomMagCalibrationHelper.this.onRequestTimeout();
            }
        });
        this.timer = customTimer;
        customTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQuitCalibration() {
        DDLog.m1684e("开始发送退出校准数据:" + this.calibrationStep.get());
        removeTask();
        CustomTimer customTimer = new CustomTimer(0L, 200L, 50, new CustomTimer.OnUpdateInChildThreadListener() { // from class: com.logan.flight.calibration.AtomMagCalibrationHelper.3
            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void update() {
                DDLog.m1684e("开始发送退出校准数据111");
                if (FlightConfig.isConnectFlight()) {
                    if (AtomMagCalibrationHelper.this.calibrationStep.get() == 9 || AtomMagCalibrationHelper.this.calibrationStep.get() == 12) {
                        SendEnterQuitCalibrationData sendEnterQuitCalibrationData = new SendEnterQuitCalibrationData();
                        sendEnterQuitCalibrationData.set(false);
                        DDLog.m1684e("发送停止校准指令：" + ParseUtil.byteToHexString(sendEnterQuitCalibrationData.getBytes()));
                        DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendEnterQuitCalibrationData.getBytes());
                    }
                }
            }

            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void timeout() {
                AtomMagCalibrationHelper.this.onRequestTimeout();
            }
        });
        this.timer = customTimer;
        customTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCalibratingResult() {
        DDLog.m1684e("开始发送每次校准数据");
        removeTask();
        CustomTimer customTimer = new CustomTimer(0L, 200L, 50, new CustomTimer.OnUpdateInChildThreadListener() { // from class: com.logan.flight.calibration.AtomMagCalibrationHelper.4
            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void update() {
                if (!FlightConfig.isConnectFlight() || AtomMagCalibrationHelper.this.calibratingResult == null) {
                    return;
                }
                if (AtomMagCalibrationHelper.this.calibrationStep.get() == 2 || AtomMagCalibrationHelper.this.calibrationStep.get() == 4 || AtomMagCalibrationHelper.this.calibrationStep.get() == 8 || AtomMagCalibrationHelper.this.calibrationStep.get() == 7 || AtomMagCalibrationHelper.this.calibrationStep.get() == 6) {
                    SendCalFeedbackData sendCalFeedbackData = new SendCalFeedbackData();
                    sendCalFeedbackData.update(AtomMagCalibrationHelper.this.calibratingResult);
                    DDLog.m1684e("发送校准结果给飞控：" + ParseUtil.byteToHexString(sendCalFeedbackData.getBytes()));
                    DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendCalFeedbackData.getBytes());
                }
            }

            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void timeout() {
                AtomMagCalibrationHelper.this.onRequestTimeout();
            }
        });
        this.timer = customTimer;
        customTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSuccessData() {
        DDLog.m1684e("开始发送校准成功数据:" + this.calibrationStep.get());
        removeTask();
        CustomTimer customTimer = new CustomTimer(0L, 200L, 50, new CustomTimer.OnUpdateInChildThreadListener() { // from class: com.logan.flight.calibration.AtomMagCalibrationHelper.5
            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void update() {
                if (!FlightConfig.isConnectFlight() || AtomMagCalibrationHelper.this.calibratingResult == null || !AtomMagCalibrationHelper.this.calibratingResult.isCalibrationFinish() || AtomMagCalibrationHelper.this.calibrationStep.get() == 11 || AtomMagCalibrationHelper.this.calibrationStep.get() == 12) {
                    return;
                }
                SendMagCalibrationResult sendMagCalibrationResult = new SendMagCalibrationResult();
                sendMagCalibrationResult.init(AtomMagCalibrationHelper.this.resultList);
                AtomMagCalibrationHelper.this.resultPayload = sendMagCalibrationResult.getPayload();
                DDLog.m1684e("发送校准成功数据给飞控：" + ParseUtil.byteToHexString(sendMagCalibrationResult.getBytes()));
                DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, sendMagCalibrationResult.getBytes());
            }

            @Override // com.ipotensic.baselib.utils.CustomTimer.OnUpdateInChildThreadListener
            public void timeout() {
                AtomMagCalibrationHelper.this.onRequestTimeout();
            }
        });
        this.timer = customTimer;
        customTimer.start();
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void revData(FlightRevFlightCtrlToAppNormal flightRevFlightCtrlToAppNormal) {
        DDLog.m1684e("收到校准数据1:" + flightRevFlightCtrlToAppNormal.toString() + "   ,calibrationStep :" + this.calibrationStep.get());
        if (flightRevFlightCtrlToAppNormal.getCommand() == NormalCmdType.ENTER_QUIT_MAG_CALIBRATION) {
            boolean isEnterCalibration = flightRevFlightCtrlToAppNormal.getIsEnterCalibration();
            if (isEnterCalibration || this.calibrationStep.get() != 10) {
                removeTask();
                if (isEnterCalibration) {
                    this.calibrationStep.set(1);
                    return;
                } else if (this.calibrationStep.get() == 9) {
                    this.calibrationStep.set(10);
                    return;
                } else {
                    if (this.calibrationStep.get() == 12) {
                        this.calibrationStep.set(11);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (flightRevFlightCtrlToAppNormal.getCommand() == NormalCmdType.MAG_CALIBRATION_ANSWER) {
            if (this.calibrationStep.get() == 9) {
                return;
            }
            removeTask();
            if (this.calibrationStep.get() == 2) {
                this.calibrationStep.set(3);
                return;
            }
            if (this.calibrationStep.get() == 4) {
                this.calibrationStep.set(5);
                return;
            } else {
                if (this.calibrationStep.get() == 8 || this.calibrationStep.get() == 7 || this.calibrationStep.get() == 6) {
                    this.calibrationStep.set(9);
                    return;
                }
                return;
            }
        }
        if (flightRevFlightCtrlToAppNormal.getCommand() == NormalCmdType.MAG_CALIBRATION_TIMEOUT) {
            DDLog.m1684e("主动退出地磁校准");
            removeTask();
            if (flightRevFlightCtrlToAppNormal.getIsQuitCalibration()) {
                if (!this.isQuitCalibration) {
                    this.isQuitCalibration = true;
                    OnCalibrationResultListener onCalibrationResultListener = this.resultListener;
                    if (onCalibrationResultListener != null) {
                        onCalibrationResultListener.onResultFailed(this.calibratingResult);
                    }
                }
                this.calibrationStep.set(11);
            }
        }
    }

    @Override // com.logan.flight.calibration.IMagCalibrationHelper
    public void revData(FlightRevMagCalibrationResultData flightRevMagCalibrationResultData) {
        DDLog.m1684e("收到校准数据2:" + ParseUtil.byteToHexString(this.resultPayload));
        DDLog.m1684e("收到校准数据3:" + ParseUtil.byteToHexString(flightRevMagCalibrationResultData.getResult()));
        byte[] bArr = this.resultPayload;
        if (bArr == null || !ParseUtil.isBytesEqual(bArr, flightRevMagCalibrationResultData.getResult())) {
            return;
        }
        removeTask();
        this.calibrationStep.set(11);
        OnCalibrationResultListener onCalibrationResultListener = this.resultListener;
        if (onCalibrationResultListener != null) {
            onCalibrationResultListener.onResultSuccess(this.calibratingResult);
        }
    }

    private void removeTask() {
        CustomTimer customTimer = this.timer;
        if (customTimer != null) {
            customTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestTimeout() {
        release();
        try {
            OnCalibrationResultListener onCalibrationResultListener = this.resultListener;
            if (onCalibrationResultListener != null) {
                onCalibrationResultListener.onRequestTimeout();
            }
        } catch (Exception e) {
            DDLog.m1684e("校准超时:" + e);
        }
    }
}
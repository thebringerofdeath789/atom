package com.ipotensic.kernel.controllers;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Observable;
import androidx.databinding.ObservableDouble;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.FileSaver;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.data.WifiSignalData;
import com.logan.flight.DataManager;
import com.logan.flight.DataSender;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightReturnAltitudeTestData;
import com.logan.flight.data.recv.FlightRevBatteryData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevFpvData;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevP1V1TestData;
import com.logan.flight.data.recv.FlightRevPTZFeedbackData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.recv.FlightRevTestData;
import com.logan.flight.data.send.UsbPayloadWrapper;
import com.logan.flight.enums.CommonMsgType;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class TesterController extends BaseController {
    private Button btnGpsModeOpen;
    private Button btnNoConditionUnlock;
    private Button btnOptionFlowOpen;
    private Button btnPtzCalibration;
    private FileSaver geoFileSaver;
    private ObservableDouble imuTemp;
    private boolean isNoConditionUnlockOpen;
    private boolean isReturnHighOpen;
    private LinearLayout layoutMain;
    private GeneralDialog ptzFailDialog;
    private GeneralDialog ptzSuccessDialog;
    private ScanWifiThread scanWifiThread;
    private TextView tvAngle;
    private TextView tvBeidou;
    private TextView tvCameraState;
    private TextView tvChannel;
    private TextView tvCompass;
    private TextView tvDbmState;
    private TextView tvFlightCtrlNum;
    private TextView tvFlightState;
    private TextView tvFpvState;
    private TextView tvFrameRate;
    private TextView tvGeoLevel;
    private TextView tvHorizontalAcc;
    private TextView tvImuTemperature;
    private TextView tvMcuState;
    private TextView tvPitch;
    private TextView tvPositionAcc;
    private TextView tvRemoteRevNum;
    private TextView tvReturnAltitude;
    private TextView tvRoll;
    private TextView tvSixCalibration;
    private TextView tvSpeedAcc;
    private TextView tvSpeedVertical;
    private TextView tvTofHeight;
    private TextView tvTofPrecision;
    private TextView tvTofTemperature;
    private TextView tvVerticalAcc;
    private TextView tvVoltage1;
    private TextView tvVoltage2;
    private TextView tvVoltage3;
    private TextView tvVoltage4;
    private TextView tvWifiSignal;
    private TextView tvWifiSignalValue;
    private TextView tvWindDirection;
    private TextView tvWindSpeed;

    public TesterController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.isReturnHighOpen = false;
        this.isNoConditionUnlockOpen = false;
        this.imuTemp = new ObservableDouble();
        this.scanWifiThread = null;
        this.tvSixCalibration = (TextView) view.findViewById(C1965R.id.tv_six_calibration);
        TextView textView = (TextView) view.findViewById(C1965R.id.tv_return_altitude);
        this.tvReturnAltitude = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FlightSendData.get().getReturnAltitudeData().setReturnHigh(!TesterController.this.isReturnHighOpen);
                DataManager.getInstance().sendReturnAltitude();
            }
        });
        Button button = (Button) view.findViewById(C1965R.id.btn_no_condition_unlock);
        this.btnNoConditionUnlock = button;
        button.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                FlightSendData.get().getReturnAltitudeData().setNoConditionUnlock(!TesterController.this.isNoConditionUnlockOpen);
                DataManager.getInstance().sendReturnAltitude();
            }
        });
        view.findViewById(C1965R.id.btn_atti_takeoff).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                FlightSendData.get().getSendGeneralData().setDataType(CommonMsgType.ATTITUDE_MODE_TAKE_OFF);
                DataManager.getInstance().sendGeneralData();
            }
        });
        this.imuTemp.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.controllers.TesterController.4
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                double d = TesterController.this.imuTemp.get();
                if (TesterController.this.tvImuTemperature != null) {
                    TesterController.this.tvImuTemperature.setText("IMU温度:" + d);
                }
            }
        });
        startScanWifi();
        initUI();
    }

    private void initUI() {
        getBaseView().setVisibility(PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER ? 0 : 8);
        if (this.layoutMain == null || PhoneConfig.PACK_TYPE != PackageType.TYPE_TESTER) {
            return;
        }
        this.layoutMain.setVisibility(0);
        this.tvFrameRate.setVisibility(8);
        this.tvWifiSignalValue.setVisibility(8);
    }

    public void onConnectStateChanged(boolean z) {
        TextView textView;
        if (z) {
            Button button = this.btnGpsModeOpen;
            if (button == null || this.btnOptionFlowOpen == null) {
                return;
            }
            button.setBackgroundColor(getContext().getResources().getColor(FlightRevData.get().getTestData().isGpsOpen() ? C1965R.color.color_connect_green : C1965R.color.colorGray));
            this.btnOptionFlowOpen.setBackgroundColor(getContext().getResources().getColor(FlightRevData.get().getTestData().isOptionFlowOpen() ? C1965R.color.color_connect_green : C1965R.color.colorGray));
            return;
        }
        stopSaveGeoLog();
        Button button2 = this.btnGpsModeOpen;
        if (button2 != null && this.btnOptionFlowOpen != null) {
            button2.setBackgroundColor(getContext().getResources().getColor(C1965R.color.colorGray));
            this.btnOptionFlowOpen.setBackgroundColor(getContext().getResources().getColor(C1965R.color.colorGray));
        }
        if (PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER && (textView = this.tvSixCalibration) != null) {
            textView.setText("六面校准失败");
        }
        this.isReturnHighOpen = false;
        this.isNoConditionUnlockOpen = false;
        this.tvReturnAltitude.setText("返航高度设置为10M关闭");
        this.btnNoConditionUnlock.setBackgroundColor(getContext().getResources().getColor(this.isNoConditionUnlockOpen ? C1965R.color.color_connect_green : C1965R.color.color_login_blue_transparent));
        this.tvWindSpeed.setText("风速：");
        this.tvWindDirection.setText("风向：");
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1965R.id.layout_test);
        this.layoutMain = linearLayout;
        linearLayout.setVisibility(8);
        this.tvWifiSignal = (TextView) view.findViewById(C1965R.id.wifi_signal);
        this.tvRemoteRevNum = (TextView) view.findViewById(C1965R.id.remote_rev_num);
        this.tvFlightCtrlNum = (TextView) view.findViewById(C1965R.id.flight_ctrl_rev_num);
        this.tvVerticalAcc = (TextView) view.findViewById(C1965R.id.vertical_accuracy);
        this.tvHorizontalAcc = (TextView) view.findViewById(C1965R.id.horizontal_accuracy);
        this.tvPositionAcc = (TextView) view.findViewById(C1965R.id.position_accuracy);
        this.tvSpeedAcc = (TextView) view.findViewById(C1965R.id.speed_accuracy);
        this.tvSpeedVertical = (TextView) view.findViewById(C1965R.id.speed_vertical);
        this.tvFlightState = (TextView) view.findViewById(C1965R.id.flight_ctrl_state);
        this.tvMcuState = (TextView) view.findViewById(C1965R.id.mcu_state);
        this.tvCameraState = (TextView) view.findViewById(C1965R.id.camera_ctrl_state);
        this.tvFpvState = (TextView) view.findViewById(C1965R.id.fpv_state);
        this.tvDbmState = (TextView) view.findViewById(C1965R.id.dbm_state);
        this.tvChannel = (TextView) view.findViewById(C1965R.id.tv_channel);
        this.tvFrameRate = (TextView) view.findViewById(C1965R.id.tv_frame_rate);
        this.tvWifiSignalValue = (TextView) view.findViewById(C1965R.id.tv_wifi_signal_value);
        this.tvAngle = (TextView) view.findViewById(C1965R.id.tv_angle);
        this.tvVoltage1 = (TextView) view.findViewById(C1965R.id.tv_voltage_1);
        this.tvVoltage2 = (TextView) view.findViewById(C1965R.id.tv_voltage_2);
        this.tvVoltage3 = (TextView) view.findViewById(C1965R.id.tv_voltage_3);
        this.tvVoltage4 = (TextView) view.findViewById(C1965R.id.tv_voltage_4);
        this.tvPitch = (TextView) view.findViewById(C1965R.id.tv_pitch);
        this.tvRoll = (TextView) view.findViewById(C1965R.id.tv_roll);
        this.tvCompass = (TextView) view.findViewById(C1965R.id.tv_compass);
        this.tvWindSpeed = (TextView) view.findViewById(C1965R.id.tv_wind_speed);
        this.tvWindDirection = (TextView) view.findViewById(C1965R.id.tv_wind_direction);
        this.tvBeidou = (TextView) view.findViewById(C1965R.id.tv_beidou);
        this.tvGeoLevel = (TextView) view.findViewById(C1965R.id.tv_geo_level);
        this.tvTofHeight = (TextView) view.findViewById(C1965R.id.tof_height);
        this.tvTofPrecision = (TextView) view.findViewById(C1965R.id.tof_precision);
        this.tvTofTemperature = (TextView) view.findViewById(C1965R.id.tof_temperature);
        this.tvImuTemperature = (TextView) view.findViewById(C1965R.id.imu_temperature);
        view.findViewById(C1965R.id.tv_start_save).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.5
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (FlightConfig.isConnectFlight()) {
                    TesterController.this.startSaveGeoLog();
                }
            }
        });
        view.findViewById(C1965R.id.tv_stop_save).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.6
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                TesterController.this.stopSaveGeoLog();
            }
        });
        Button button = (Button) view.findViewById(C1965R.id.btn_gps_mode_open);
        this.btnGpsModeOpen = button;
        button.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.7
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                byte[] bArr = {1, ParseUtil.setBit(FlightRevData.get().getTestData().getValidByte(), 0, FlightRevData.get().getTestData().isGpsOpen() ? 1 : 0)};
                DDLog.m1684e("发送测试数据:" + ParseUtil.getAllBit(bArr[1]));
                DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, UsbPayloadWrapper.wrap((short) 4, bArr));
            }
        });
        Button button2 = (Button) view.findViewById(C1965R.id.btn_flow_mode_open);
        this.btnOptionFlowOpen = button2;
        button2.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.8
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                byte[] bArr = {1, ParseUtil.setBit(FlightRevData.get().getTestData().getValidByte(), 1, FlightRevData.get().getTestData().isOptionFlowOpen() ? 1 : 0)};
                DDLog.m1684e("发送测试数据:" + ParseUtil.getAllBit(bArr[1]));
                DataSender.getInstance().sendData(UsbConfig.USB_TYPE_APP_TO_FLIGHT, UsbPayloadWrapper.wrap((short) 4, bArr));
            }
        });
        Button button3 = (Button) view.findViewById(C1965R.id.btn_ptz_calibration);
        this.btnPtzCalibration = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.TesterController.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FlightSendData.get().getSendPTZData().startPtzCalibration();
                DataManager.getInstance().startSendPTZData();
            }
        });
    }

    private void setTest1(byte[] bArr, int i) {
        double unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(bArr, i) / 100.0d;
        double unsignedShortFromByteArr2 = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 2) / 1000.0d;
        double unsignedShortFromByteArr3 = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 4) / 1000.0d;
        double unsignedShortFromByteArr4 = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 6) / 1000.0d;
        int unsignedShortFromByteArr5 = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 8);
        int unsignedShortFromByteArr6 = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 10);
        this.tvVerticalAcc.setText("垂直精度:" + unsignedShortFromByteArr3);
        this.tvHorizontalAcc.setText("水平精度:" + unsignedShortFromByteArr2);
        this.tvPositionAcc.setText("位置精度:" + unsignedShortFromByteArr);
        this.tvSpeedAcc.setText("速度精度:" + unsignedShortFromByteArr4);
        this.tvFlightCtrlNum.setText("飞机接收包数:" + unsignedShortFromByteArr5);
        this.tvRemoteRevNum.setText("遥控接收包数:" + unsignedShortFromByteArr6);
        this.tvSpeedVertical.setText("垂直速度：" + (ParseUtil.getSignedShortFromByteArr(bArr, i + 12) / 1000.0d));
    }

    private void setTvWifiSignal(int i) {
        TextView textView = this.tvWifiSignal;
        if (textView != null) {
            textView.setText("WIFI信号强度: " + i);
        }
    }

    public void setFrameRate(WifiSignalData wifiSignalData) {
        TextView textView = this.tvWifiSignalValue;
        if (textView != null) {
            textView.setText("WIFI强度:" + wifiSignalData.getWifiSignal());
        }
        TextView textView2 = this.tvFrameRate;
        if (textView2 != null) {
            textView2.setText("码率:" + wifiSignalData.getFrameRate());
        }
    }

    private void setTest2(FlightRevConnectData flightRevConnectData) {
        setTvWifiSignal(flightRevConnectData.getRssi());
        this.tvFlightState.setBackgroundColor(getContext().getResources().getColor(flightRevConnectData.isFlightCtrlConnected() ? C1965R.color.color_connect_green : C1965R.color.color_disconnect_red));
        this.tvFlightState.setText("飞控连接状态:" + (flightRevConnectData.isFlightCtrlConnected() ? "已连接" : "连接断开"));
        this.tvMcuState.setBackgroundColor(getContext().getResources().getColor(flightRevConnectData.isRemoterConnected() ? C1965R.color.color_connect_green : C1965R.color.color_disconnect_red));
        this.tvMcuState.setText("遥控MCU连接状态:" + (flightRevConnectData.isRemoterConnected() ? "已连接" : "连接断开"));
        this.tvCameraState.setBackgroundColor(getContext().getResources().getColor(flightRevConnectData.isCameraCtrlConnected() ? C1965R.color.color_connect_green : C1965R.color.color_disconnect_red));
        this.tvCameraState.setText("相机连接状态:" + (flightRevConnectData.isCameraCtrlConnected() ? "已连接" : "连接断开"));
        this.tvFpvState.setBackgroundColor(getContext().getResources().getColor(flightRevConnectData.isFpvConnected() ? C1965R.color.color_connect_green : C1965R.color.color_disconnect_red));
        this.tvFpvState.setText("FPV连接状态:" + (flightRevConnectData.isFpvConnected() ? "已连接" : "连接断开"));
        this.tvDbmState.setText("发射功率:" + (flightRevConnectData.isHighDbm() ? "高" : "低"));
    }

    public void startScanWifi() {
        if (this.scanWifiThread == null) {
            ScanWifiThread scanWifiThread = new ScanWifiThread();
            this.scanWifiThread = scanWifiThread;
            scanWifiThread.start();
        }
    }

    public void stopScanWifi() {
        ScanWifiThread scanWifiThread = this.scanWifiThread;
        if (scanWifiThread != null) {
            scanWifiThread.isRunning = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSaveGeoLog() {
        if (this.geoFileSaver == null) {
            FileSaver fileSaver = new FileSaver(new File(LocalFileManager.getInstance().getGeoLogDir(), FormatUtil.getCurTime() + ".GEO"));
            this.geoFileSaver = fileSaver;
            fileSaver.start();
            ToastUtil.toast(getContext(), "开始存储地磁日志");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopSaveGeoLog() {
        FileSaver fileSaver = this.geoFileSaver;
        if (fileSaver != null) {
            fileSaver.close(new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TesterController.10
                @Override // com.ipotensic.baselib.listener.SimpleResultListener
                public void onResult(Boolean bool) {
                    TesterController.this.geoFileSaver = null;
                    ToastUtil.toast(TesterController.this.getContext(), "停止存储地磁日志");
                }
            });
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            initUI();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        stopSaveGeoLog();
    }

    private class ScanWifiThread extends Thread {
        private boolean isRunning;
        private WifiInfo wifiInfo;

        private ScanWifiThread() {
            this.isRunning = true;
        }

        public int getCurrentChannel(Context context) {
            WifiManager wifiManager = (WifiManager) PhoneConfig.applicationContext.getSystemService("wifi");
            this.wifiInfo = wifiManager.getConnectionInfo();
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                if (scanResult.BSSID.equalsIgnoreCase(this.wifiInfo.getBSSID()) && scanResult.SSID.equalsIgnoreCase(this.wifiInfo.getSSID().substring(1, this.wifiInfo.getSSID().length() - 1))) {
                    return convertFrequencyToChannel(scanResult.frequency);
                }
            }
            return -1;
        }

        public int convertFrequencyToChannel(int i) {
            if (i >= 2412 && i <= 2484) {
                return ((i - 2412) / 5) + 1;
            }
            if (i < 5170 || i > 5825) {
                return -1;
            }
            return ((i - 5170) / 5) + 34;
        }

        private int getSignal() {
            WifiInfo wifiInfo = this.wifiInfo;
            if (wifiInfo == null) {
                return -1;
            }
            int rssi = wifiInfo.getRssi();
            if ((rssi <= -50 || rssi >= 0) && ((rssi <= -70 || rssi >= -50) && ((rssi <= -80 || rssi >= -70) && ((rssi <= -100 || rssi >= -80) && rssi < -100)))) {
                return -1;
            }
            return rssi + 100;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (this.isRunning) {
                try {
                    final int currentChannel = getCurrentChannel(TesterController.this.tvChannel.getContext());
                    final int signal = (this.wifiInfo == null || UsbConfig.isUsbConnected) ? -1 : getSignal();
                    TesterController.this.tvChannel.post(new Runnable() { // from class: com.ipotensic.kernel.controllers.TesterController.ScanWifiThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                TextView textView = TesterController.this.tvChannel;
                                StringBuilder append = new StringBuilder().append("信道: ");
                                int i = currentChannel;
                                textView.setText(append.append(i == -1 ? "Unknown" : Integer.valueOf(i)).toString());
                                if (ScanWifiThread.this.wifiInfo == null || UsbConfig.isUsbConnected) {
                                    return;
                                }
                                int i2 = signal;
                                if (i2 == -1) {
                                    TesterController.this.tvWifiSignal.setText("信号强度: 0");
                                } else {
                                    TesterController.this.tvWifiSignal.setText("信号强度: " + Math.min(Integer.parseInt(String.valueOf(i2), 16), 100));
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                    Thread.sleep(1500L);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.TesterController$12 */
    static /* synthetic */ class C221612 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_LOG_RECORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_RETURN_ALTITUDE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_GEO_CALIBRATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_GPS_TEST_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_BATTERY_DATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_PTZ_FEEDBACK_INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_P1_TEST_DATA_V1.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        Button button;
        super.onEvent(eventID, event);
        switch (C221612.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                FlightRevFpvData flightRevFpvData = FlightRevData.get().getFlightRevFpvData();
                if (flightRevFpvData != null && flightRevFpvData.isFlightLog()) {
                    this.imuTemp.set(flightRevFpvData.getImuTemp());
                    break;
                }
                break;
            case 2:
                FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
                if (flightRevFlightInfoData != null && PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER) {
                    this.tvAngle.setText("飞机的方向角：" + flightRevFlightInfoData.getDirectToNorth());
                    this.tvPitch.setText("俯仰角:" + flightRevFlightInfoData.getAngleOfPitch());
                    this.tvRoll.setText("翻滚角:" + flightRevFlightInfoData.getAngleOfRoll());
                    this.tvWindSpeed.setText("风速：" + flightRevFlightInfoData.getWindSpeed() + "m/s");
                    this.tvWindDirection.setText("风向：" + flightRevFlightInfoData.getWindDirection() + "rad");
                    if (FlightRevData.get().getGeoTestData().isInit()) {
                        this.tvCompass.setText(String.format("地磁：x:%s y:%s z:%s", Float.valueOf(FlightRevData.get().getGeoTestData().getCompassX()), Float.valueOf(FlightRevData.get().getGeoTestData().getCompassY()), Float.valueOf(FlightRevData.get().getGeoTestData().getCompassZ())));
                        break;
                    }
                }
                break;
            case 3:
                FlightReturnAltitudeTestData returnAltitudeTestData = FlightRevData.get().getReturnAltitudeTestData();
                if (returnAltitudeTestData != null) {
                    boolean isTurnOpen = returnAltitudeTestData.isTurnOpen();
                    this.isReturnHighOpen = isTurnOpen;
                    this.tvReturnAltitude.setText(isTurnOpen ? "返航高度设置为10M开启" : "返航高度设置为10M关闭");
                    this.isNoConditionUnlockOpen = returnAltitudeTestData.isNoConditionUnlock();
                    this.btnNoConditionUnlock.setBackgroundColor(getContext().getResources().getColor(this.isNoConditionUnlockOpen ? C1965R.color.color_connect_green : C1965R.color.color_login_blue_transparent));
                    break;
                }
                break;
            case 4:
                FlightRevGeoTestData geoTestData = FlightRevData.get().getGeoTestData();
                if (geoTestData != null) {
                    TextView textView = this.tvGeoLevel;
                    if (textView != null) {
                        textView.setText("地磁强度: " + geoTestData.getLevel() + StringUtils.SPACE);
                    }
                    TextView textView2 = this.tvTofHeight;
                    if (textView2 != null) {
                        textView2.setText("TOF高度：" + geoTestData.getTofHeight());
                        this.tvTofPrecision.setText("TOF精度：" + geoTestData.getTofPrecision());
                    }
                    TextView textView3 = this.tvTofTemperature;
                    if (textView3 != null) {
                        textView3.setText("TOF温度：" + ((int) geoTestData.getTofTemperature()));
                    }
                    FileSaver fileSaver = this.geoFileSaver;
                    if (fileSaver != null) {
                        fileSaver.write(geoTestData.getPayload());
                        break;
                    }
                }
                break;
            case 5:
                FlightRevTestData testData = FlightRevData.get().getTestData();
                if (testData != null && (button = this.btnGpsModeOpen) != null && this.btnOptionFlowOpen != null) {
                    button.setBackgroundColor(getContext().getResources().getColor(testData.isGpsOpen() ? C1965R.color.color_connect_green : C1965R.color.colorGray));
                    this.btnOptionFlowOpen.setBackgroundColor(getContext().getResources().getColor(testData.isOptionFlowOpen() ? C1965R.color.color_connect_green : C1965R.color.colorGray));
                    break;
                }
                break;
            case 6:
                FlightRevBatteryData flightRevBatteryData = FlightRevData.get().getFlightRevBatteryData();
                if (flightRevBatteryData != null && PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER) {
                    float firstVoltage = flightRevBatteryData.getFirstVoltage();
                    float secondVoltage = flightRevBatteryData.getSecondVoltage();
                    float thirdVoltage = flightRevBatteryData.getThirdVoltage();
                    float fourthVoltage = flightRevBatteryData.getFourthVoltage();
                    this.tvVoltage1.setText(String.format("%s%.2f%s", "电压1：", Float.valueOf(firstVoltage), "V"));
                    this.tvVoltage2.setText(String.format("%s%.2f%s", "电压2：", Float.valueOf(secondVoltage), "V"));
                    this.tvVoltage3.setText(String.format("%s%.2f%s", "电压3：", Float.valueOf(thirdVoltage), "V"));
                    this.tvVoltage4.setText(String.format("%s%.2f%s", "电压4：", Float.valueOf(fourthVoltage), "V"));
                    break;
                }
                break;
            case 7:
                FlightRevPTZFeedbackData revPTZFeedbackData = FlightRevData.get().getRevPTZFeedbackData();
                if (revPTZFeedbackData != null && revPTZFeedbackData != null && PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER) {
                    if (revPTZFeedbackData.getFunCode() == 2) {
                        if (revPTZFeedbackData.getCalibrationValue() == 2) {
                            if (this.ptzSuccessDialog == null) {
                                this.ptzSuccessDialog = new GeneralDialog((Context) getContext(), "云台校准", "校准成功", (String) null, (String) null, false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.TesterController.11
                                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                                    public void confirm() {
                                    }
                                });
                            }
                            if (!this.ptzSuccessDialog.isShowing()) {
                                this.ptzSuccessDialog.show();
                                break;
                            }
                        }
                    } else {
                        revPTZFeedbackData.getCalibrationValue();
                        break;
                    }
                }
                break;
            case 8:
                FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
                if (flightRevStateData != null) {
                    if (PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER) {
                        this.tvSixCalibration.setText(flightRevStateData.isSixCalibrationComplete() ? "六面校准成功" : "六面校准失败");
                    }
                    if (flightRevStateData.isBeidouOpen()) {
                        this.tvBeidou.setText("北斗开关:开");
                        break;
                    } else {
                        this.tvBeidou.setText("北斗开关:关");
                        break;
                    }
                }
                break;
            case 9:
                FlightRevP1V1TestData p1V1TestData = FlightRevData.get().getP1V1TestData();
                if (p1V1TestData != null) {
                    setTest1(p1V1TestData.getData(), p1V1TestData.getPayloadIndex());
                    break;
                }
                break;
            case 10:
                FlightRevConnectData flightRevConnectData = FlightRevData.get().getFlightRevConnectData();
                if (flightRevConnectData != null && PhoneConfig.PACK_TYPE == PackageType.TYPE_TESTER) {
                    setTest2(flightRevConnectData);
                    break;
                }
                break;
        }
    }
}
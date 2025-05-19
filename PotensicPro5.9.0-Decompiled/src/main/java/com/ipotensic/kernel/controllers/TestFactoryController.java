package com.ipotensic.kernel.controllers;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSONObject;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.PackageType;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevP1V2TestData;
import com.logan.flight.data.recv.FlightRevP1V3TestData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.type.Flight;

/* loaded from: classes2.dex */
public class TestFactoryController extends BaseController implements View.OnClickListener {
    private Button btnCamTemp;
    private Button btnCameraTest;
    private Button btnClearImuData;
    private Button btnFlight24gOn;
    private Button btnFlightAlwaysLight;
    private Button btnFlightFixedFreq;
    private Button btnFlightFixedSpeed;
    private Button btnFlightFlash;
    private Button btnFlightSweepFreq;
    private Button btnFlightTest;
    private Button btnFlightVariableSpeed;
    private Button btnLossPkgClose;
    private Button btnLossPkgOpen;
    private Drawable drawableGray;
    private Drawable drawableGreen;
    private boolean is24gOn;
    private boolean isAlwaysLightModeOpen;
    private boolean isFixedFreqModeOpen;
    private boolean isFixedSpeedModeOpen;
    private boolean isFlashModeOpen;
    private boolean isFlightTestModeOpen;
    private boolean isSweepFreqModeOpen;
    private boolean isVariableSpeedModeOpen;
    private Button restoreFactorySetting;

    /* renamed from: com.ipotensic.kernel.controllers.TestFactoryController$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_P1_TEST_DATA_V2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_P1_TEST_DATA_V3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_GIMBAL_SETTING_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        FlightRevP1V2TestData p1V2TestData;
        FlightRevP1V3TestData p1V3TestData;
        super.onEvent(eventID, event);
        int i = AnonymousClass4.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (PhoneConfig.PACK_TYPE != PackageType.TYPE_FACTORY || (p1V2TestData = FlightRevData.get().getP1V2TestData()) == null) {
                return;
            }
            setP1SelfTestView(p1V2TestData.getData(), p1V2TestData.getPayloadIndex());
            return;
        }
        if (i == 2) {
            if (PhoneConfig.PACK_TYPE != PackageType.TYPE_FACTORY || (p1V3TestData = FlightRevData.get().getP1V3TestData()) == null) {
                return;
            }
            updateSettingData(p1V3TestData.getData(), p1V3TestData.getPayloadIndex());
            return;
        }
        if (i == 3 && FlightRevData.get().getGimbalSettingData().getGimbalReset() == 5) {
            ToastUtil.toast(getContext(), "清除IMU温补数据 成功!!");
        }
    }

    public TestFactoryController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.isFlightTestModeOpen = false;
        this.isSweepFreqModeOpen = false;
        this.isFixedFreqModeOpen = false;
        this.isVariableSpeedModeOpen = false;
        this.isFixedSpeedModeOpen = false;
        this.isFlashModeOpen = false;
        this.isAlwaysLightModeOpen = false;
        this.is24gOn = false;
        view.setVisibility(PhoneConfig.PACK_TYPE != PackageType.TYPE_FACTORY ? 8 : 0);
        if (this.drawableGreen == null) {
            this.drawableGreen = getContext().getResources().getDrawable(R.drawable.bg_p1_self_test_green_shape);
        }
        if (this.drawableGray == null) {
            this.drawableGray = getContext().getResources().getDrawable(R.drawable.bg_p1_self_test_gray_shape);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.btnCameraTest = (Button) view.findViewById(R.id.tv_camera_test_mode);
        this.btnFlightTest = (Button) view.findViewById(R.id.tv_flight_test_mode);
        this.btnFlightSweepFreq = (Button) view.findViewById(R.id.tv_flight_sweep_mode);
        this.btnFlightFixedFreq = (Button) view.findViewById(R.id.tv_flight_fixed_mode);
        this.btnFlightVariableSpeed = (Button) view.findViewById(R.id.tv_flight_variable_mode);
        this.btnFlightFixedSpeed = (Button) view.findViewById(R.id.tv_flight_fixed_speed_mode);
        this.btnFlightFlash = (Button) view.findViewById(R.id.tv_flight_shining_mode);
        this.btnFlightAlwaysLight = (Button) view.findViewById(R.id.tv_flight_always_light_mode);
        this.btnFlight24gOn = (Button) view.findViewById(R.id.tv_flight_24g_test);
        this.btnClearImuData = (Button) view.findViewById(R.id.tv_clear_imu_data);
        this.restoreFactorySetting = (Button) view.findViewById(R.id.tv_restore_factory_setting);
        this.btnLossPkgOpen = (Button) view.findViewById(R.id.btn_loss_pkg_open);
        this.btnLossPkgClose = (Button) view.findViewById(R.id.btn_loss_pkg_close);
        this.btnCamTemp = (Button) view.findViewById(R.id.btn_cam_temp);
        this.btnCameraTest.setOnClickListener(this);
        this.btnFlightTest.setOnClickListener(this);
        this.btnFlightSweepFreq.setOnClickListener(this);
        this.btnFlightFixedFreq.setOnClickListener(this);
        this.btnFlightVariableSpeed.setOnClickListener(this);
        this.btnFlightFixedSpeed.setOnClickListener(this);
        this.btnFlightFlash.setOnClickListener(this);
        this.btnFlightAlwaysLight.setOnClickListener(this);
        this.btnFlight24gOn.setOnClickListener(this);
        this.btnClearImuData.setOnClickListener(this);
        this.restoreFactorySetting.setOnClickListener(this);
        this.btnLossPkgOpen.setOnClickListener(this);
        this.btnLossPkgClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int i = 0;
        if (id == R.id.tv_camera_test_mode) {
            if (FlightConfig.curFlight != null && Flight.Flight_P1_PRO != FlightConfig.curFlight) {
                OkHttpUtil.getInstance().get(1100, "http://192.168.29.1/cgi-bin/hisnet/testmode.cgi?", new CallBackString<String>() { // from class: com.ipotensic.kernel.controllers.TestFactoryController.1
                    @Override // com.ipotensic.baselib.okhttp.CallBackString
                    public void onFailure(int i2, Exception exc) {
                    }

                    @Override // com.ipotensic.baselib.okhttp.CallBackString
                    public String onParseResponse(int i2, String str) throws Exception {
                        if (str == null) {
                            return null;
                        }
                        try {
                            return JSONObject.parseObject(str).getString(NotificationCompat.CATEGORY_STATUS);
                        } catch (Exception unused) {
                            return null;
                        }
                    }

                    @Override // com.ipotensic.baselib.okhttp.CallBackString
                    public void onResponse(int i2, String str) {
                        if (str != null) {
                            if (str.equals("test mode is running")) {
                                ToastUtil.toast(TestFactoryController.this.getContext(), "已经是相机测试模式");
                                TestFactoryController.this.btnCameraTest.setBackground(TestFactoryController.this.drawableGreen);
                            } else if (str.equals("sd is not ready")) {
                                ToastUtil.toast(TestFactoryController.this.getContext(), "SD卡没有准备好");
                            } else if (str.equals("sd is full")) {
                                ToastUtil.toast(TestFactoryController.this.getContext(), "SD卡已满");
                            } else if (str.equals("Success")) {
                                TestFactoryController.this.btnCameraTest.setBackground(TestFactoryController.this.drawableGreen);
                            }
                        }
                    }
                });
            }
        } else if (id == R.id.tv_flight_test_mode) {
            if (this.isFlightTestModeOpen) {
                i = DataManager.getInstance().sendFactoryTestData(new byte[]{1, -16});
            } else {
                new P1SelfTestOpenDialog(getContext(), new P1SelfTestOpenDialog.OnNumberCallback() { // from class: com.ipotensic.kernel.controllers.TestFactoryController.2
                    @Override // com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog.OnNumberCallback
                    public void onNumber(int i2) {
                        if (i2 < 1) {
                            i2 = 1;
                        } else if (i2 > 255) {
                            i2 = 255;
                        }
                        TestFactoryController.this.showError(DataManager.getInstance().sendFactoryTestData(new byte[]{1, FlightConfig.P1_SELF, (byte) i2}));
                    }
                }).show();
            }
        } else if (id == R.id.tv_flight_sweep_mode) {
            i = DataManager.getInstance().sendFactoryTestData(new byte[]{2, 1});
        } else if (id == R.id.tv_flight_fixed_mode) {
            i = DataManager.getInstance().sendFactoryTestData(new byte[]{2, 2});
        } else if (id == R.id.tv_flight_variable_mode) {
            i = DataManager.getInstance().sendFactoryTestData(new byte[]{3, 1});
        } else if (id == R.id.tv_flight_fixed_speed_mode) {
            i = DataManager.getInstance().sendFactoryTestData(new byte[]{3, 2});
        } else if (id == R.id.tv_flight_shining_mode) {
            i = DataManager.getInstance().sendFactoryTestData(new byte[]{4, 1});
        } else if (id == R.id.tv_flight_always_light_mode) {
            i = DataManager.getInstance().sendFactoryTestData(new byte[]{4, 2});
        } else if (id == R.id.tv_flight_24g_test) {
            if (!this.is24gOn) {
                new P1SelfTestOpenDialog(getContext(), new P1SelfTestOpenDialog.OnNumberCallback() { // from class: com.ipotensic.kernel.controllers.TestFactoryController.3
                    @Override // com.ipotensic.kernel.view.dialog.P1SelfTestOpenDialog.OnNumberCallback
                    public void onNumber(int i2) {
                        if (i2 < 1) {
                            i2 = 1;
                        } else if (i2 > 255) {
                            i2 = 255;
                        }
                        TestFactoryController.this.showError(DataManager.getInstance().sendFactoryTestData(new byte[]{5, FlightConfig.P1_SELF, (byte) i2}));
                    }
                }).show();
            } else {
                i = DataManager.getInstance().sendFactoryTestData(new byte[]{5, -16});
            }
        } else if (id != R.id.tv_clear_imu_data) {
            if (id == R.id.tv_restore_factory_setting) {
                if (this.restoreFactorySetting.getBackground() == this.drawableGreen) {
                    ToastUtil.toast(getContext(), "当前已经是出厂模式");
                    return;
                }
                FlightSendData.get().getSendFlightSetData().setDistanceLimit((short) FlightConfig.getMaxDistance());
                FlightSendData.get().getSendFlightSetData().setHeightLimit(FlightConfig.getMaxHeight());
                FlightSendData.get().getSendFlightSetData().setNewerMode(false);
                DataManager.getInstance().startSendSetting();
            } else if (id == R.id.btn_loss_pkg_open) {
                i = DataManager.getInstance().sendFactoryTestData(new byte[]{6, FlightConfig.P1_SELF});
            } else if (id == R.id.btn_loss_pkg_close) {
                i = DataManager.getInstance().sendFactoryTestData(new byte[]{6, -16});
            }
        }
        showError(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError(int i) {
        if (i != 0) {
            if (i == 1) {
                ToastUtil.toast(getContext(), "请先同步飞控信息!");
            } else if (i == 2) {
                ToastUtil.toast(getContext(), "请连接外置电源!");
            }
        }
    }

    public void showCamTemp(int i) {
        this.btnCamTemp.setText("相机芯片温度：" + i);
    }

    private void setP1SelfTestView(byte[] bArr, int i) {
        byte b = bArr[i];
        this.isFlightTestModeOpen = ParseUtil.getBit(b, 0) == 1;
        this.isSweepFreqModeOpen = ParseUtil.getBit(b, 1) == 1;
        this.isFixedFreqModeOpen = ParseUtil.getBit(b, 2) == 1;
        this.isVariableSpeedModeOpen = ParseUtil.getBit(b, 3) == 1;
        this.isFixedSpeedModeOpen = ParseUtil.getBit(b, 4) == 1;
        this.isFlashModeOpen = ParseUtil.getBit(b, 5) == 1;
        this.isAlwaysLightModeOpen = ParseUtil.getBit(b, 6) == 1;
        this.is24gOn = ParseUtil.getBit(b, 7) == 1;
        this.btnFlightTest.setBackground(this.isFlightTestModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlightSweepFreq.setBackground(this.isSweepFreqModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlightFixedFreq.setBackground(this.isFixedFreqModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlightVariableSpeed.setBackground(this.isVariableSpeedModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlightFixedSpeed.setBackground(this.isFixedSpeedModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlightFlash.setBackground(this.isFlashModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlightAlwaysLight.setBackground(this.isAlwaysLightModeOpen ? this.drawableGreen : this.drawableGray);
        this.btnFlight24gOn.setBackground(this.is24gOn ? this.drawableGreen : this.drawableGray);
        if (bArr[i + 1] == 6) {
            byte b2 = bArr[i + 2];
            short signedShortFromByteArr = ParseUtil.getSignedShortFromByteArr(bArr, i + 3);
            short signedShortFromByteArr2 = ParseUtil.getSignedShortFromByteArr(bArr, i + 5);
            if (b2 == 1) {
                this.btnLossPkgOpen.setText("飞:" + ((int) signedShortFromByteArr) + ", 遥:" + ((int) signedShortFromByteArr2));
                this.btnLossPkgOpen.setBackground(this.drawableGreen);
            } else if (b2 == 0) {
                this.btnLossPkgOpen.setText("丢包率测试开");
                this.btnLossPkgOpen.setBackground(this.drawableGray);
            }
        }
    }

    public void onReceiveFlightConfig(FlightRevVersionData flightRevVersionData) {
        if (FlightConfig.curFlight == null) {
            return;
        }
        if (Flight.Flight_P1_PRO == FlightConfig.curFlight) {
            this.btnFlightVariableSpeed.setVisibility(0);
            this.btnFlightFixedSpeed.setVisibility(0);
            this.btnFlight24gOn.setVisibility(4);
        } else {
            this.btnFlightVariableSpeed.setVisibility(0);
            this.btnFlightFixedSpeed.setVisibility(0);
            this.btnFlight24gOn.setVisibility(0);
        }
    }

    public void updateSettingData(byte[] bArr, int i) {
        if (bArr[i] == 1) {
            ToastUtil.toast(getContext(), "恢复出厂设置成功");
        }
    }

    public void updateSettingData(FlightRevSettingData flightRevSettingData) {
        int limitHeight = flightRevSettingData.getLimitHeight();
        int limitDistance = flightRevSettingData.getLimitDistance();
        boolean isNewerModeOpen = flightRevSettingData.isNewerModeOpen();
        if (limitDistance == FlightConfig.getMaxDistance() && limitHeight == FlightConfig.getMaxHeight() && !isNewerModeOpen) {
            this.restoreFactorySetting.setBackground(this.drawableGreen);
        } else {
            this.restoreFactorySetting.setBackground(this.drawableGray);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
    }
}

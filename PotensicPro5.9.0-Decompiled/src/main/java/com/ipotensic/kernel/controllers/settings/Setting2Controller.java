package com.ipotensic.kernel.controllers.settings;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.dialog.GeoCalResultDialog;
import com.ipotensic.kernel.view.dialog.HexahedralCalibrationDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.calibration.AtomMagCalibrationHelper;
import com.logan.flight.calibration.IMagCalibrationHelper;
import com.logan.flight.calibration.MiniMagCalibrationHelper;
import com.logan.flight.calibration.OnCalibrationResultListener;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevCalResultData;
import com.logan.flight.data.recv.FlightRevCalibrationFeedbackData;
import com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormal;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevMagCalibrationResultData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.type.Flight;
import com.logan.flight.utils.MagCalibrationResult;

/* loaded from: classes2.dex */
public class Setting2Controller extends BaseController {
    private TextView btnMiniStartGeo;
    private TextView btnStartGeo;
    private TextView btnStartHexahedral;
    private HexahedralCalibrationDialog calibrationDialog;
    private Context context;
    private GeneralDialog generalDialog;
    private AnimationDrawable horizontalDrawable;
    private ImageView imgMiniGeoHorizontal;
    private ImageView imgMiniGeoVertical;
    private boolean isCalibrating;
    private boolean isGeoFault;
    private boolean isGeoHorizontalComplete;
    private boolean isGeoVerticalComplete;
    private boolean isNewCalSystem;
    private ImageView ivHorizontal;
    private ImageView ivMiniGeoStepTips;
    private ImageView ivSixSideCalibrationBg;
    private ImageView ivVertical;
    private IMagCalibrationHelper miniMagCalibrationHelper;
    private View miniProductGeoView;
    private ConstraintLayout oldProductGeoView;
    private GeoCalResultDialog resultDialog;
    private TextView tvMiniGeoStepTips;
    private TextView tvMiniGeoTip;
    private TextView tvP5CalibrationTips;
    private TextView tvSixSideCalibrationTitle;
    private AnimationDrawable verticalDrawable;

    public void showResultDialog(MagCalibrationResult magCalibrationResult) {
    }

    public Setting2Controller(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.isGeoHorizontalComplete = false;
        this.isGeoVerticalComplete = false;
        this.isGeoFault = false;
        this.isNewCalSystem = false;
        this.isCalibrating = false;
        this.resultDialog = null;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        AppCompatActivity context;
        int i;
        this.context = view.getContext();
        view.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Setting2Controller.this.onBackClick();
            }
        });
        this.btnStartGeo = (TextView) view.findViewById(R.id.tv_start_geo_btn);
        this.ivHorizontal = (ImageView) view.findViewById(R.id.img_geo_horizontal);
        this.ivVertical = (ImageView) view.findViewById(R.id.img_geo_vertical);
        this.btnStartHexahedral = (TextView) view.findViewById(R.id.tv_start_hexahedral_btn);
        this.tvSixSideCalibrationTitle = (TextView) view.findViewById(R.id.tv_hexahedral_title);
        this.ivSixSideCalibrationBg = (ImageView) view.findViewById(R.id.img_hexahedral_bg);
        this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
        this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
        this.oldProductGeoView = (ConstraintLayout) view.findViewById(R.id.view_old_product_geo);
        this.miniProductGeoView = view.findViewById(R.id.view_mini_product_geo);
        this.imgMiniGeoHorizontal = (ImageView) view.findViewById(R.id.img_mini_geo_horizontal);
        this.imgMiniGeoVertical = (ImageView) view.findViewById(R.id.img_mini_geo_vertical);
        this.btnMiniStartGeo = (TextView) view.findViewById(R.id.tv_mini_start_geo_btn);
        this.tvMiniGeoTip = (TextView) view.findViewById(R.id.tv_mini_geo_tip);
        this.tvMiniGeoStepTips = (TextView) view.findViewById(R.id.tv_mini_geo_step_tips);
        this.ivMiniGeoStepTips = (ImageView) view.findViewById(R.id.iv_mini_geo_step_tips);
        TextView textView = (TextView) view.findViewById(R.id.tv_p5_calibration_tips);
        this.tvP5CalibrationTips = textView;
        textView.setText(getContext().getString(R.string.compass_calibration_tips));
        initClickListener();
        setBtnEnable();
        setFlightType();
        TextView textView2 = this.tvMiniGeoTip;
        if (PhoneConfig.isFt) {
            context = getContext();
            i = R.string.setting_mini_geo_tip1;
        } else {
            context = getContext();
            i = R.string.setting_mini_geo_tip;
        }
        textView2.setText(context.getString(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOutDoor() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (flightRevStateData == null) {
            return false;
        }
        if (FlightConfig.isOldProduct() || !CommonUtil.hasNewVersion("1.0.9", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) {
            return true;
        }
        return flightRevStateData.isOutdoor();
    }

    private void setBtnEnable() {
        try {
            float f = 1.0f;
            boolean z = true;
            if (FlightConfig.isConnectFlight() && isOutDoor() && !FlightRevData.get().getFlightRevStateData().isUnLock() && !FlightRevData.get().getFlightRevStateData().isFlight()) {
                if (!FlightRevData.get().getFlightRevStateData().isMagnetometerHorizontalCalibrating() && !FlightRevData.get().getFlightRevStateData().isMagnetometerVerticalCalibrating()) {
                    this.btnStartGeo.setEnabled(true);
                    this.btnStartGeo.setAlpha(1.0f);
                }
                this.btnStartGeo.setEnabled(false);
                this.btnStartGeo.setAlpha(0.4f);
            } else {
                TextView textView = this.btnStartGeo;
                if (textView != null) {
                    textView.setEnabled(false);
                    this.btnStartGeo.setAlpha(0.4f);
                }
            }
            setMiniStartStatus();
            TextView textView2 = this.btnStartHexahedral;
            if (!FlightConfig.isConnectFlight() || FlightRevData.get().getFlightRevStateData().isUnLock()) {
                z = false;
            }
            textView2.setEnabled(z);
            TextView textView3 = this.btnStartHexahedral;
            if (!FlightConfig.isConnectFlight() || FlightRevData.get().getFlightRevStateData().isUnLock()) {
                f = 0.4f;
            }
            textView3.setAlpha(f);
        } catch (Exception unused) {
            DDLog.e("设置出错");
        }
    }

    private void setMiniStartStatus() {
        TextView textView = this.btnMiniStartGeo;
        if (textView == null || this.isCalibrating) {
            return;
        }
        textView.setEnabled(isMiniStartEnable());
        this.btnMiniStartGeo.setClickable(isMiniStartEnable());
        this.btnMiniStartGeo.setAlpha(isMiniStartEnable() ? 1.0f : 0.4f);
    }

    private boolean isMiniStartEnable() {
        return (!FlightConfig.isConnectFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isFlight()) ? false : true;
    }

    private void setFlightType() {
        this.btnStartHexahedral.setVisibility(8);
        this.ivSixSideCalibrationBg.setVisibility(8);
        this.tvSixSideCalibrationTitle.setVisibility(8);
        Flight lastFlight = FlightConfig.getLastFlight();
        if (lastFlight != null) {
            this.oldProductGeoView.setVisibility(0);
            this.miniProductGeoView.setVisibility(8);
            this.tvP5CalibrationTips.setVisibility(lastFlight == Flight.Flight_P5 ? 0 : 8);
            this.tvP5CalibrationTips.setText(getContext().getString(R.string.compass_calibration_tips));
            if (lastFlight == Flight.Flight_P3SE || lastFlight == Flight.Flight_P3SE_V0) {
                this.ivHorizontal.setImageResource(R.drawable.anim_geo_horizontal_p3se);
                this.ivVertical.setImageResource(R.drawable.anim_geo_vertical_p3se);
                this.ivSixSideCalibrationBg.setImageResource(R.mipmap.img_p3se_level);
                this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
                this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
                return;
            }
            if (FlightConfig.is_Atom_Series()) {
                this.imgMiniGeoHorizontal.setImageResource(R.drawable.anim_geo_horizontal_mini);
                this.imgMiniGeoHorizontal.setBackgroundResource(R.mipmap.img_mini_calibration_bg_setting);
                this.horizontalDrawable = (AnimationDrawable) this.imgMiniGeoHorizontal.getDrawable();
                this.imgMiniGeoVertical.setImageResource(R.drawable.anim_geo_vertical_mini);
                this.imgMiniGeoVertical.setBackgroundResource(R.mipmap.img_mini_calibration_bg_setting);
                this.verticalDrawable = (AnimationDrawable) this.imgMiniGeoVertical.getDrawable();
                this.btnStartHexahedral.setVisibility(8);
                this.ivSixSideCalibrationBg.setVisibility(8);
                this.tvSixSideCalibrationTitle.setVisibility(8);
                this.oldProductGeoView.setVisibility(8);
                this.miniProductGeoView.setVisibility(0);
                return;
            }
            if (lastFlight == Flight.Flight_P5) {
                this.ivHorizontal.setImageResource(R.drawable.anim_geo_horizontal_p5se);
                this.ivVertical.setImageResource(R.drawable.anim_geo_vertical_p5se);
                this.horizontalDrawable = (AnimationDrawable) this.ivHorizontal.getDrawable();
                this.verticalDrawable = (AnimationDrawable) this.ivVertical.getDrawable();
                this.ivSixSideCalibrationBg.setImageResource(R.mipmap.img_p5se_level);
                return;
            }
            if (lastFlight == Flight.Flight_P1_SELF || lastFlight == Flight.Flight_P1_SELF_A) {
                this.btnStartHexahedral.setVisibility(8);
                this.ivSixSideCalibrationBg.setVisibility(8);
                this.tvSixSideCalibrationTitle.setVisibility(8);
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if ((i == 0 || getBaseView() != null) && i == 0) {
            setFlightType();
        }
    }

    private void initClickListener() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (flightRevStateData.isMagnetometerHorizontalCalibrating() || flightRevStateData.isMagnetometerVerticalCalibrating()) {
            return;
        }
        this.btnStartGeo.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FlightRevData.get().getFlightRevStateData().isGeoTooMuchInterfere() && FlightConfig.curFlight != null && FlightConfig.isOldProduct()) {
                    new GeneralDialog((Context) Setting2Controller.this.getContext(), Setting2Controller.this.getContext().getString(R.string.unable_to_calibrate), Setting2Controller.this.getContext().getString(R.string.unable_to_calibrate_tips), (String) null, (String) null, false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.2.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }
                    }).show();
                    return;
                }
                if ((FlightConfig.isOldProduct() || Setting2Controller.this.isOutDoor()) && FlightConfig.isConnectFlight()) {
                    if (FlightRevData.get().getFlightRevStateData().isGeomagneticFault()) {
                        ToastUtil.toast(Setting2Controller.this.getContext(), Setting2Controller.this.getContext().getString(R.string.error_geo_fault));
                    } else {
                        if (FlightRevData.get().getFlightRevStateData().isUnLock()) {
                            return;
                        }
                        Setting2Controller.this.generalDialog = new GeneralDialog(Setting2Controller.this.context, Setting2Controller.this.context.getString(R.string.sys_calibration_start), Setting2Controller.this.context.getString(R.string.dialog_geo_calibration_tips_one), Setting2Controller.this.context.getString(R.string.dialog_cancel), Setting2Controller.this.context.getString(R.string.dialog_ok), false, 2, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.2.2
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                                if (FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isFlight()) {
                                    return;
                                }
                                Setting2Controller.this.isNewCalSystem = false;
                                FlightSendData.get().getSend4AxisData().setGeoCalibration();
                            }
                        });
                        Setting2Controller.this.generalDialog.show();
                    }
                }
            }
        });
        this.btnMiniStartGeo.setOnClickListener(new AnonymousClass3(1000, flightRevStateData));
        this.btnStartHexahedral.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FlightRevData.get().getFlightRevStateData().isUnLock()) {
                    return;
                }
                if (SPHelper.getInstance().getFirstHexahedralCalibration()) {
                    SPHelper.getInstance().setFirstHexahedralCalibration(false);
                    new GeneralDialog((Context) Setting2Controller.this.getContext(), true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.4.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                            DataManager.getInstance().startSendHexahedralCalibration();
                        }
                    }).show();
                } else {
                    DataManager.getInstance().startSendHexahedralCalibration();
                }
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.controllers.settings.Setting2Controller$3, reason: invalid class name */
    class AnonymousClass3 extends ScaleClickListener {
        final /* synthetic */ FlightRevStateData val$stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Integer num, FlightRevStateData flightRevStateData) {
            super(num);
            this.val$stateData = flightRevStateData;
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (this.val$stateData.isGeoTooMuchInterfere() && FlightConfig.curFlight != null && FlightConfig.isOldProduct()) {
                new GeneralDialog((Context) Setting2Controller.this.getContext(), Setting2Controller.this.getContext().getString(R.string.unable_to_calibrate), Setting2Controller.this.getContext().getString(R.string.unable_to_calibrate_tips), (String) null, (String) null, false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.3.1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }
                }).show();
                return;
            }
            if (!FlightConfig.isOldProduct() && !Setting2Controller.this.isOutDoor()) {
                ToastUtil.toast(Setting2Controller.this.getContext(), Setting2Controller.this.getContext().getString(R.string.settings_calibration_compass_calibration_failed_tips_outside_calibrate));
            } else if (FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isUnLock()) {
                Setting2Controller.this.generalDialog = new GeneralDialog(Setting2Controller.this.context, Setting2Controller.this.context.getString(R.string.sys_calibration_start), Setting2Controller.this.context.getString(R.string.dialog_geo_calibration_tips_one), Setting2Controller.this.context.getString(R.string.dialog_cancel), Setting2Controller.this.context.getString(R.string.dialog_ok), false, 2, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.3.2
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                        if (FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isFlight() || !Setting2Controller.this.btnMiniStartGeo.isEnabled()) {
                            return;
                        }
                        Setting2Controller.this.isNewCalSystem = true;
                        if (UsbConfig.isUsbConnected) {
                            if (Conditions.isNewMagCalSystem()) {
                                Setting2Controller.this.miniMagCalibrationHelper = new AtomMagCalibrationHelper();
                            } else {
                                Setting2Controller.this.miniMagCalibrationHelper = new MiniMagCalibrationHelper();
                            }
                            Setting2Controller.this.isCalibrating = false;
                            Setting2Controller.this.miniMagCalibrationHelper.setCalibrationResultListener(new OnCalibrationResultListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.3.2.1
                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onHorizontalCalibration() {
                                    Setting2Controller.this.isCalibrating = true;
                                    ViewUtils.setViewEnableWithAlpha(Setting2Controller.this.btnMiniStartGeo, false);
                                    if (!Setting2Controller.this.isGeoHorizontalComplete) {
                                        EventDispatcher.get().sendEvent(EventID.AUDIO_START_HORIZONTAL_CALIBRATION);
                                    }
                                    FlightConfig.isSettingCalibration = true;
                                    Setting2Controller.this.isGeoHorizontalComplete = true;
                                    Setting2Controller.this.horizontalDrawable.start();
                                    Setting2Controller.this.tvMiniGeoTip.setVisibility(8);
                                    Setting2Controller.this.ivMiniGeoStepTips.setVisibility(0);
                                    Setting2Controller.this.tvMiniGeoStepTips.setVisibility(0);
                                }

                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onVerticalCalibration() {
                                    Setting2Controller.this.isCalibrating = true;
                                    ViewUtils.setViewEnableWithAlpha(Setting2Controller.this.btnMiniStartGeo, false);
                                    if (Setting2Controller.this.isGeoHorizontalComplete) {
                                        Setting2Controller.this.isGeoHorizontalComplete = false;
                                        Setting2Controller.this.horizontalDrawable.selectDrawable(0);
                                        Setting2Controller.this.horizontalDrawable.stop();
                                        EventDispatcher.get().sendEvent(EventID.AUDIO_START_VERTICAL_CALIBRATION);
                                    }
                                    Setting2Controller.this.imgMiniGeoHorizontal.setVisibility(4);
                                    Setting2Controller.this.imgMiniGeoVertical.setVisibility(0);
                                    Setting2Controller.this.verticalDrawable.start();
                                    Setting2Controller.this.ivMiniGeoStepTips.setImageResource(R.mipmap.icon_mini_geo_step_two);
                                    Setting2Controller.this.tvMiniGeoStepTips.setText(Setting2Controller.this.getContext().getResources().getString(R.string.dialog_geo_vertical_tips));
                                }

                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onRequestTimeout() {
                                    DDLog.e("校准请求超时...");
                                    Setting2Controller.this.isCalibrating = false;
                                    ViewUtils.setViewEnableWithAlpha(Setting2Controller.this.btnMiniStartGeo, true);
                                    Setting2Controller.this.onCalibrateFail(2);
                                    Setting2Controller.this.resetMiniCalibrationUI();
                                }

                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onResultSuccess(MagCalibrationResult magCalibrationResult) {
                                    DDLog.e("校准成功");
                                    Setting2Controller.this.isCalibrating = false;
                                    ViewUtils.setViewEnableWithAlpha(Setting2Controller.this.btnMiniStartGeo, true);
                                    Setting2Controller.this.resetMiniCalibrationUI();
                                    ToastUtil.showImageTop(Setting2Controller.this.getContext(), Setting2Controller.this.context.getString(R.string.toast_geo_calibration_finish), R.mipmap.icon_toast_successful);
                                    EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_SUCCESS);
                                    Setting2Controller.this.showResultDialog(magCalibrationResult);
                                }

                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onResultFailed(MagCalibrationResult magCalibrationResult) {
                                    DDLog.e("校准失败...");
                                    Setting2Controller.this.isCalibrating = false;
                                    ViewUtils.setViewEnableWithAlpha(Setting2Controller.this.btnMiniStartGeo, true);
                                    Setting2Controller.this.resetMiniCalibrationUI();
                                    Setting2Controller.this.onCalibrateFail(1);
                                    Setting2Controller.this.showResultDialog(magCalibrationResult);
                                }

                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onResultTimeout(MagCalibrationResult magCalibrationResult) {
                                    DDLog.e("校准超时...");
                                    Setting2Controller.this.isCalibrating = false;
                                    ViewUtils.setViewEnableWithAlpha(Setting2Controller.this.btnMiniStartGeo, true);
                                    Setting2Controller.this.resetMiniCalibrationUI();
                                    Setting2Controller.this.onCalibrateFail(1);
                                    Setting2Controller.this.showResultDialog(magCalibrationResult);
                                }

                                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                                public void onRelease() {
                                    Setting2Controller.this.isCalibrating = false;
                                }
                            });
                            Setting2Controller.this.miniMagCalibrationHelper.start();
                        }
                    }
                });
                Setting2Controller.this.generalDialog.show();
            }
        }
    }

    public void dismissResultDialog() {
        GeoCalResultDialog geoCalResultDialog = this.resultDialog;
        if (geoCalResultDialog == null || !geoCalResultDialog.isShowing()) {
            return;
        }
        this.resultDialog.dismiss();
        this.resultDialog = null;
    }

    private void releaseCalibrationHelper() {
        IMagCalibrationHelper iMagCalibrationHelper = this.miniMagCalibrationHelper;
        if (iMagCalibrationHelper != null) {
            iMagCalibrationHelper.release();
            this.miniMagCalibrationHelper.setCalibrationResultListener(null);
            this.miniMagCalibrationHelper = null;
        }
    }

    public void onBackClick() {
        if (!FlightConfig.isConnectFlight()) {
            EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
            this.horizontalDrawable.stop();
            this.verticalDrawable.stop();
            releaseCalibrationHelper();
            return;
        }
        if (FlightConfig.isOldProduct()) {
            if (!FlightRevData.get().getFlightRevStateData().isGeomagneticFault() && (FlightRevData.get().getFlightRevStateData().isMagnetometerHorizontalCalibrating() || FlightRevData.get().getFlightRevStateData().isMagnetometerVerticalCalibrating())) {
                ToastUtil.showImageTop(getContext(), this.context.getString(R.string.toast_calibration_close), R.mipmap.icon_gyroscope_galibration);
                return;
            }
            EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
            this.horizontalDrawable.stop();
            this.verticalDrawable.stop();
            return;
        }
        if (this.isCalibrating) {
            ToastUtil.showImageTop(getContext(), this.context.getString(R.string.toast_calibration_close), R.mipmap.icon_gyroscope_galibration);
            return;
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
        this.horizontalDrawable.stop();
        this.verticalDrawable.stop();
        releaseCalibrationHelper();
    }

    public void setAnimationStop() {
        if (getBaseView() == null) {
            return;
        }
        this.isGeoHorizontalComplete = false;
        this.isGeoVerticalComplete = false;
        AnimationDrawable animationDrawable = this.horizontalDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        AnimationDrawable animationDrawable2 = this.verticalDrawable;
        if (animationDrawable2 != null) {
            animationDrawable2.stop();
        }
        HexahedralCalibrationDialog hexahedralCalibrationDialog = this.calibrationDialog;
        if (hexahedralCalibrationDialog == null || !hexahedralCalibrationDialog.isShowing()) {
            return;
        }
        this.calibrationDialog.disconnect();
        this.btnStartHexahedral.setEnabled(true);
        this.btnStartHexahedral.setAlpha(1.0f);
    }

    public void updateData() {
        if (this.isNewCalSystem) {
            return;
        }
        SettingController settingController = (SettingController) EventDispatcher.get().getController(SettingController.class);
        boolean z = settingController != null && settingController.getVisibility() == 0;
        if (getBaseView() == null || !z) {
            return;
        }
        setBtnEnable();
        if (FlightConfig.curFlight == null || !FlightConfig.is_Atom_Series()) {
            if (FlightRevData.get().getFlightRevStateData().isGeomagneticFault()) {
                if (this.isGeoFault) {
                    return;
                }
                if (this.horizontalDrawable.isRunning() || this.verticalDrawable.isRunning()) {
                    this.isGeoFault = true;
                    this.horizontalDrawable.stop();
                    this.horizontalDrawable.selectDrawable(0);
                    this.verticalDrawable.stop();
                    this.verticalDrawable.selectDrawable(0);
                    this.btnStartGeo.setEnabled(true);
                    this.btnStartGeo.setAlpha(1.0f);
                    FlightConfig.isSettingCalibration = false;
                    ToastUtil.toast(getContext(), getContext().getString(R.string.error_geo_fault));
                    return;
                }
                return;
            }
            this.isGeoFault = false;
            boolean isGeoCalibrationFailureFlag = FlightRevData.get().getFlightRevStateData().isGeoCalibrationFailureFlag();
            boolean isMagnetometerHorizontalCalibrating = FlightRevData.get().getFlightRevStateData().isMagnetometerHorizontalCalibrating();
            boolean isMagnetometerVerticalCalibrating = FlightRevData.get().getFlightRevStateData().isMagnetometerVerticalCalibrating();
            if (isMagnetometerHorizontalCalibrating) {
                if (!this.isGeoHorizontalComplete) {
                    EventDispatcher.get().sendEvent(EventID.AUDIO_START_HORIZONTAL_CALIBRATION);
                }
                FlightConfig.isSettingCalibration = true;
                this.isGeoHorizontalComplete = true;
                this.horizontalDrawable.start();
            } else {
                boolean z2 = this.isGeoHorizontalComplete;
                if (z2 && isGeoCalibrationFailureFlag) {
                    this.isGeoHorizontalComplete = false;
                    this.horizontalDrawable.stop();
                    DDLog.e("校准失败2");
                    Context context = this.context;
                    GeneralDialog generalDialog = new GeneralDialog(context, context.getString(R.string.sys_calibration_start), this.context.getString(R.string.toast_geo_calibration_fail), this.context.getString(R.string.dialog_cancel), this.context.getString(R.string.dialog_ok), false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.5
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                            FlightSendData.get().getSend4AxisData().setGeoCalibration();
                        }
                    });
                    generalDialog.show();
                    generalDialog.setCancelable(false);
                    EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
                } else if (z2) {
                    this.isGeoHorizontalComplete = false;
                    this.horizontalDrawable.selectDrawable(0);
                    this.horizontalDrawable.stop();
                    EventDispatcher.get().sendEvent(EventID.AUDIO_START_VERTICAL_CALIBRATION);
                }
            }
            if (isMagnetometerVerticalCalibrating) {
                this.isGeoVerticalComplete = true;
                this.verticalDrawable.start();
                return;
            }
            boolean z3 = this.isGeoVerticalComplete;
            if (z3 && isGeoCalibrationFailureFlag) {
                this.isGeoVerticalComplete = false;
                this.verticalDrawable.stop();
                DDLog.e("校准失败3");
                Context context2 = this.context;
                GeneralDialog generalDialog2 = new GeneralDialog(context2, context2.getString(R.string.sys_calibration_start), this.context.getString(R.string.toast_geo_calibration_fail), this.context.getString(R.string.dialog_cancel), this.context.getString(R.string.dialog_ok), false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.6
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                        FlightSendData.get().getSend4AxisData().setGeoCalibration();
                    }
                });
                generalDialog2.show();
                generalDialog2.setCancelable(false);
                EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
                return;
            }
            if (z3) {
                FlightConfig.isSettingCalibration = false;
                this.isGeoVerticalComplete = false;
                this.verticalDrawable.stop();
                this.verticalDrawable.selectDrawable(0);
                this.btnStartGeo.setEnabled(true);
                this.btnStartGeo.setAlpha(1.0f);
                ToastUtil.showImageTop(getContext(), this.context.getString(R.string.toast_geo_calibration_finish), R.mipmap.icon_toast_successful);
                EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_SUCCESS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCalibrateFail(int i) {
        DDLog.e("校准失败4");
        String string = this.context.getString(R.string.settings_calibration_compass_calibration_failed_tips_magnetic_interference_detected);
        if (i == 2) {
            string = this.context.getString(R.string.calibration_failed_tips_remote_controller_signal_weak);
        }
        Context context = this.context;
        GeneralDialog generalDialog = new GeneralDialog(context, context.getString(R.string.sys_calibration_geomagnetic), string, this.context.getString(R.string.dialog_cancel), this.context.getString(R.string.dialog_ok), false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.settings.Setting2Controller.7
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
            }
        });
        generalDialog.show();
        generalDialog.setCancelable(false);
        EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetMiniCalibrationUI() {
        releaseCalibrationHelper();
        FlightConfig.isSettingCalibration = false;
        this.horizontalDrawable.stop();
        this.horizontalDrawable.selectDrawable(0);
        this.verticalDrawable.stop();
        this.verticalDrawable.selectDrawable(0);
        this.btnMiniStartGeo.setEnabled(true);
        this.btnMiniStartGeo.setAlpha(1.0f);
        this.imgMiniGeoHorizontal.setVisibility(0);
        this.imgMiniGeoVertical.setVisibility(4);
        this.tvMiniGeoTip.setVisibility(0);
        this.ivMiniGeoStepTips.setImageResource(R.mipmap.icon_mini_geo_step_one);
        this.ivMiniGeoStepTips.setVisibility(8);
        this.tvMiniGeoStepTips.setText(getContext().getResources().getString(R.string.dialog_geo_horizontal_tips));
        this.tvMiniGeoStepTips.setVisibility(8);
    }

    public void updateHexahedralCalibration(Context context) {
        if (getBaseView() == null) {
            return;
        }
        if (this.calibrationDialog == null) {
            this.calibrationDialog = new HexahedralCalibrationDialog(context);
        }
        if (!this.calibrationDialog.isShowing()) {
            this.calibrationDialog.show();
        }
        this.calibrationDialog.updateData(false);
        FlightRevCalibrationFeedbackData revCalibrationFeedbackData = FlightRevData.get().getRevCalibrationFeedbackData();
        this.btnStartHexahedral.setEnabled(revCalibrationFeedbackData.isCalibrationSuccess() != null);
        this.btnStartHexahedral.setAlpha(revCalibrationFeedbackData.isCalibrationSuccess() != null ? 1.0f : 0.4f);
    }

    /* renamed from: com.ipotensic.kernel.controllers.settings.Setting2Controller$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GEO_CALIBRATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_CALIBRATION_RESULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TAKEOFF_HIDE_UPGRADE_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_UNIT_CHANGED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_FLIGHT_CTRL_TO_APP_NORMAL_DATA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MAG_CALIBRATION_RESULT_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        AppCompatActivity context;
        int i;
        super.onEvent(eventID, event);
        boolean z = false;
        switch (AnonymousClass8.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                FlightRevGeoTestData flightRevGeoTestData = (FlightRevGeoTestData) event.obj;
                IMagCalibrationHelper iMagCalibrationHelper = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper != null && iMagCalibrationHelper.isStart()) {
                    try {
                        if (this.isNewCalSystem) {
                            SettingController settingController = (SettingController) EventDispatcher.get().getController(SettingController.class);
                            if (settingController != null && settingController.getVisibility() == 0) {
                                z = true;
                            }
                            if (getBaseView() != null && z) {
                                this.miniMagCalibrationHelper.calibration(flightRevGeoTestData);
                                break;
                            }
                        }
                    } catch (Exception e) {
                        DDLog.e("校准结果报错:" + e.getMessage());
                        return;
                    }
                }
                break;
            case 2:
                FlightRevCalResultData flightRevCalResultData = (FlightRevCalResultData) event.obj;
                IMagCalibrationHelper iMagCalibrationHelper2 = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper2 != null) {
                    iMagCalibrationHelper2.revData(flightRevCalResultData);
                    DDLog.e("校准结果的结果:" + flightRevCalResultData.toString());
                    break;
                }
                break;
            case 3:
                if (!((Boolean) event.obj).booleanValue()) {
                    this.isNewCalSystem = false;
                    resetMiniCalibrationUI();
                    dismissResultDialog();
                }
                setMiniStartStatus();
                break;
            case 4:
                setBtnEnable();
                break;
            case 5:
                if (((Boolean) event.obj).booleanValue()) {
                    GeneralDialog generalDialog = this.generalDialog;
                    if (generalDialog != null && generalDialog.isShowing()) {
                        this.generalDialog.dismiss();
                        this.generalDialog = null;
                    }
                    HexahedralCalibrationDialog hexahedralCalibrationDialog = this.calibrationDialog;
                    if (hexahedralCalibrationDialog != null && hexahedralCalibrationDialog.isShowing()) {
                        this.calibrationDialog.disconnect();
                        this.calibrationDialog = null;
                        break;
                    }
                }
                break;
            case 6:
                this.tvP5CalibrationTips.setText(getContext().getString(R.string.compass_calibration_tips));
                TextView textView = this.tvMiniGeoTip;
                if (PhoneConfig.isFt) {
                    context = getContext();
                    i = R.string.setting_mini_geo_tip1;
                } else {
                    context = getContext();
                    i = R.string.setting_mini_geo_tip;
                }
                textView.setText(context.getString(i));
                break;
            case 7:
                IMagCalibrationHelper iMagCalibrationHelper3 = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper3 != null) {
                    iMagCalibrationHelper3.revData((FlightRevFlightCtrlToAppNormal) event.obj);
                    break;
                }
                break;
            case 8:
                IMagCalibrationHelper iMagCalibrationHelper4 = this.miniMagCalibrationHelper;
                if (iMagCalibrationHelper4 != null) {
                    iMagCalibrationHelper4.revData((FlightRevMagCalibrationResultData) event.obj);
                    break;
                }
                break;
        }
    }
}

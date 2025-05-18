package com.ipotensic.kernel.controllers.settings;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.utils.ForceUpgradeCheck;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.enums.SdCardState;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.type.Flight;
import com.logan.upgrade.server.Version;
import com.logan.usb.AOAEngine;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class Setting5Controller extends BaseController implements View.OnClickListener, SwitchButton.SwitchStateListener {

    /* renamed from: NA */
    private String f2188NA;
    private GeneralDialog batteryDialog;
    private SwitchButton btnSlide;
    private GeneralDialog cameraDialog;
    private ConstraintLayout clEsc;
    private ConstraintLayout clFpv;
    private ConstraintLayout clPtz;
    private Context context;
    private GeneralDialog fpvDialog;
    private FwUpgradeConditionDialog fwUpgradeConditionDialog;
    private GeneralDialog gimbalDialog;
    private LinearLayout layoutBatteryUpdate;
    private LinearLayout layoutCameraUpdate;
    private LinearLayout layoutFlightUpdate;
    private LinearLayout layoutFpvUpdate;
    private LinearLayout layoutPtzUpdate;
    private LinearLayout layoutRemoteUpdate;
    private String notEnoughSpace;
    private GeneralDialog remoteDialog;
    private GeneralDialog tofDialog;
    private TextView tvApp;
    private TextView tvBattery;
    private TextView tvBatteryUpdate;
    private TextView tvCamUpdate;
    private TextView tvCamera;
    private TextView tvCurProject;
    private TextView tvEsc;
    private TextView tvFlight;
    private TextView tvFlightSN;
    private TextView tvFlightType;
    private TextView tvFlightUpdate;
    private TextView tvFpv;
    private TextView tvFpvUpdate;
    private TextView tvImperial;
    private TextView tvMetric;
    private TextView tvPtz;
    private TextView tvPtzUpdate;
    private TextView tvRemote;
    private TextView tvRemoteSN;
    private TextView tvRemoteUpdate;

    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
    public void onDisableClick() {
    }

    public Setting5Controller(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.f2188NA = "  N/A";
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.context = view.getContext();
        view.findViewById(C1965R.id.iv_back).setOnClickListener(this);
        this.tvFlight = (TextView) view.findViewById(C1965R.id.tv_flight);
        this.tvCamera = (TextView) view.findViewById(C1965R.id.tv_camera);
        this.tvApp = (TextView) view.findViewById(C1965R.id.tv_app);
        this.tvRemote = (TextView) view.findViewById(C1965R.id.iv_remote);
        this.tvBattery = (TextView) view.findViewById(C1965R.id.tv_battery);
        this.tvFpv = (TextView) view.findViewById(C1965R.id.tv_fpv);
        this.tvPtz = (TextView) view.findViewById(C1965R.id.tv_ptz);
        SwitchButton switchButton = (SwitchButton) view.findViewById(C1965R.id.slide_hard_decode);
        this.btnSlide = switchButton;
        switchButton.switchStateListener(this);
        this.tvCurProject = (TextView) view.findViewById(C1965R.id.tv_cur_project);
        TextView textView = (TextView) view.findViewById(C1965R.id.tv_flight_update);
        this.tvFlightUpdate = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(C1965R.id.tv_cam_update);
        this.tvCamUpdate = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) view.findViewById(C1965R.id.tv_remote_update);
        this.tvRemoteUpdate = textView3;
        textView3.setOnClickListener(this);
        TextView textView4 = (TextView) view.findViewById(C1965R.id.tv_fpv_update);
        this.tvFpvUpdate = textView4;
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) view.findViewById(C1965R.id.tv_ptz_update);
        this.tvPtzUpdate = textView5;
        textView5.setOnClickListener(this);
        TextView textView6 = (TextView) view.findViewById(C1965R.id.tv_battery_update);
        this.tvBatteryUpdate = textView6;
        textView6.setOnClickListener(this);
        this.layoutFlightUpdate = (LinearLayout) view.findViewById(C1965R.id.layout_flight_update);
        this.layoutCameraUpdate = (LinearLayout) view.findViewById(C1965R.id.layout_camera_update);
        this.layoutRemoteUpdate = (LinearLayout) view.findViewById(C1965R.id.layout_remote_update);
        this.layoutFpvUpdate = (LinearLayout) view.findViewById(C1965R.id.layout_fpv_update);
        this.layoutPtzUpdate = (LinearLayout) view.findViewById(C1965R.id.layout_ptz_update);
        this.layoutBatteryUpdate = (LinearLayout) view.findViewById(C1965R.id.layout_battery_update);
        this.tvMetric = (TextView) view.findViewById(C1965R.id.tv_metric);
        this.tvImperial = (TextView) view.findViewById(C1965R.id.tv_imperial);
        this.tvMetric.setOnClickListener(this);
        this.tvImperial.setOnClickListener(this);
        this.clFpv = (ConstraintLayout) view.findViewById(C1965R.id.cl_fpv);
        this.clPtz = (ConstraintLayout) view.findViewById(C1965R.id.cl_ptz);
        this.btnSlide.setChecked(SPHelper.getInstance().isHardDecode());
        this.clEsc = (ConstraintLayout) view.findViewById(C1965R.id.cl_esc);
        this.tvEsc = (TextView) view.findViewById(C1965R.id.tv_esc);
        View findViewById = view.findViewById(C1965R.id.line_sn);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C1965R.id.ll_sn);
        this.tvFlightType = (TextView) view.findViewById(C1965R.id.tv_flight_type);
        this.tvFlightSN = (TextView) view.findViewById(C1965R.id.tv_flight_sn);
        this.tvRemoteSN = (TextView) view.findViewById(C1965R.id.tv_remote_sn);
        findViewById.setVisibility(8);
        linearLayout.setVisibility(8);
        if (FlightConfig.isAtomPanTilt() || FlightConfig.isP1Pro()) {
            this.clFpv.setVisibility(0);
            this.clPtz.setVisibility(0);
        } else if (FlightConfig.is_Atom_SE_Series() || FlightConfig.isP1SelfB()) {
            this.clFpv.setVisibility(0);
            this.clPtz.setVisibility(8);
        } else {
            this.clFpv.setVisibility(8);
            this.clPtz.setVisibility(8);
        }
        updateData();
    }

    private boolean isEmptyVersion(String str) {
        return TextUtils.isEmpty(str) || str.equals("0.0.0");
    }

    public void updateData() {
        if (getBaseView() == null) {
            return;
        }
        this.tvApp.setText("  V6.9.0");
        if (SPHelper.getInstance().isFt()) {
            this.tvMetric.setBackgroundResource(C1965R.drawable.bg_setting_units_default_left);
            this.tvImperial.setBackgroundResource(C1965R.drawable.bg_setting_button_select_right);
        } else {
            this.tvMetric.setBackgroundResource(C1965R.drawable.bg_setting_button_select_left);
            this.tvImperial.setBackgroundResource(C1965R.drawable.bg_setting_units_default_right);
        }
        if (FlightConfig.isConnectFlight() || UsbConfig.isUsbConnected) {
            FlightRevVersionData flightRevVersionData = FlightRevData.get().getFlightRevVersionData();
            this.tvFlight.setText(isEmptyVersion(flightRevVersionData.getFlightControlVersion()) ? this.f2188NA : "  V" + flightRevVersionData.getFlightControlVersion());
            int i = 0;
            if (isEmptyVersion(flightRevVersionData.getFlightControlVersion()) || FwDownloadManager.getInstance().getNewFlightControlVersion(false) == null) {
                this.layoutFlightUpdate.setVisibility(4);
            } else {
                this.layoutFlightUpdate.setVisibility(0);
            }
            if (flightRevVersionData.getEscVersion() != null) {
                this.clEsc.setVisibility(0);
                this.tvEsc.setText(flightRevVersionData.getEscVersion());
            } else {
                this.clEsc.setVisibility(8);
            }
            if (FlightConfig.isConnectFlight()) {
                this.tvCamera.setText(isEmptyVersion(CameraConfig.get().getSoftVersion()) ? this.f2188NA : "  " + CameraConfig.get().getSoftVersion());
            }
            if (isEmptyVersion(CameraConfig.get().getSoftVersion()) || FwDownloadManager.getInstance().getNewCameraVersion(false) == null) {
                this.layoutCameraUpdate.setVisibility(4);
            } else {
                this.layoutCameraUpdate.setVisibility(0);
            }
            String remoterVersion = flightRevVersionData.getRemoterVersion();
            if (UsbConfig.isUsbConnected && FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() != null) {
                remoterVersion = FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion();
            }
            this.tvRemote.setText(isEmptyVersion(remoterVersion) ? this.f2188NA : "  V" + remoterVersion);
            if (isEmptyVersion(remoterVersion) || FwDownloadManager.getInstance().getNewRemoterVersion(false) == null) {
                this.layoutRemoteUpdate.setVisibility(4);
            } else {
                this.layoutRemoteUpdate.setVisibility(0);
            }
            String string = FlightRevData.get().getFlightRemoterBatteryData().isRemoterLowPower() ? getContext().getString(C1965R.string.dialog_upgrade_remote_power_low) : null;
            if (!FlightConfig.isConnectFlight() && UsbConfig.isUsbConnected && string != null) {
                this.layoutRemoteUpdate.setVisibility(4);
            }
            DDLog.m1685e("固件下载", "电池版本：" + flightRevVersionData.getBatteryVersion());
            DDLog.m1685e("固件下载", "电池是否有版本：" + FwDownloadManager.getInstance().getNewBatteryVersion(false));
            this.tvBattery.setText(isEmptyVersion(flightRevVersionData.getBatteryVersion()) ? this.f2188NA : "  V" + flightRevVersionData.getBatteryVersion());
            if (isEmptyVersion(flightRevVersionData.getBatteryVersion()) || FwDownloadManager.getInstance().getNewBatteryVersion(false) == null) {
                this.layoutBatteryUpdate.setVisibility(4);
            } else if (updateBattery()) {
                this.layoutBatteryUpdate.setVisibility(0);
            } else {
                this.layoutBatteryUpdate.setVisibility(4);
            }
            this.tvPtz.setText(isEmptyVersion(flightRevVersionData.getGimbalVersion()) ? this.f2188NA : "  V" + flightRevVersionData.getGimbalVersion());
            if (FlightConfig.curFlight == Flight.Flight_P1_PRO || FlightConfig.curFlight == Flight.Flight_ATOM || FlightConfig.curFlight == Flight.Flight_P1_PRO_2) {
                this.clFpv.setVisibility(0);
                this.clPtz.setVisibility(0);
            } else {
                this.clFpv.setVisibility(8);
                this.clPtz.setVisibility(8);
            }
            if (isEmptyVersion(flightRevVersionData.getGimbalVersion()) || FwDownloadManager.getInstance().getNewGimbalVersion(false) == null) {
                this.layoutPtzUpdate.setVisibility(4);
            } else {
                this.layoutPtzUpdate.setVisibility(0);
            }
            String fpvVersion = FlightRevData.get().getFlightRevFpvData().getFpvVersion();
            if (fpvVersion != null) {
                this.clFpv.setVisibility(0);
                this.tvFpv.setText(isEmptyVersion(fpvVersion) ? this.f2188NA : "  V" + fpvVersion);
                if (isEmptyVersion(fpvVersion) || FwDownloadManager.getInstance().getNewFpvVersion(false) == null) {
                    this.layoutFpvUpdate.setVisibility(4);
                } else {
                    this.layoutFpvUpdate.setVisibility(0);
                }
            }
            CopyOnWriteArrayList<Version> forceVersions = ForceUpgradeCheck.getInstance().getForceVersions();
            if (!forceVersions.isEmpty()) {
                while (true) {
                    if (i >= forceVersions.size()) {
                        break;
                    }
                    if (forceVersions.get(i).getIsforce() == 0) {
                        setUpgradeBtnVisible();
                        break;
                    }
                    i++;
                }
            }
        } else {
            disConnected();
        }
        if (FlightConfig.curFlight != null) {
            this.tvCurProject.setText(FlightConfig.curFlight.getFlightName());
        }
        if (FlightConfig.isConnectFlight() && !canUpgrade()) {
            this.layoutRemoteUpdate.setVisibility(4);
            this.layoutFpvUpdate.setVisibility(4);
        }
        if (!canUpgrade()) {
            this.layoutCameraUpdate.setVisibility(4);
            this.layoutFlightUpdate.setVisibility(4);
            this.layoutPtzUpdate.setVisibility(4);
        }
        if (FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevStateData().isUnLock()) {
            setUpgradeBtnVisible();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        BaseSyncDialog.isShow = false;
        boolean z = FlightRevData.get().getFlightRemoterBatteryData() != null && FlightRevData.get().getFlightRemoterBatteryData().isRemoterLowPower();
        boolean z2 = FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() != -1 && FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() < 30;
        if (id == C1965R.id.iv_back) {
            EventDispatcher.get().sendEvent(EventID.EVENT_UI_HIDE_FLIGHT_SETTING);
            return;
        }
        if (id == C1965R.id.tv_flight_update) {
            if (z2 || z) {
                Context context = this.context;
                FwUpgradeConditionDialog fwUpgradeConditionDialog = new FwUpgradeConditionDialog(context, context.getString(C1965R.string.flightcontrol), true, z2, z, null, false);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog;
                fwUpgradeConditionDialog.show();
                return;
            }
            Version newFlightControlVersion = FwDownloadManager.getInstance().getNewFlightControlVersion(false);
            if (newFlightControlVersion == null || !canUpgrade()) {
                return;
            }
            FwDownloadManager.getInstance().showUpgradeDialog(getContext(), newFlightControlVersion, false);
            return;
        }
        if (id == C1965R.id.tv_cam_update) {
            String string = CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_EXIST ? this.context.getString(C1965R.string.sd_no_sdcard) : null;
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NEED_FORMAT) {
                string = this.context.getString(C1965R.string.title_pls_format);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_ENOUGH_SPACE) {
                string = this.context.getString(C1965R.string.sd_sdcard_is_full);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_LOW_SPEED) {
                string = this.context.getString(C1965R.string.sd_speed_low);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_UNRECOGNIZED) {
                string = this.context.getString(C1965R.string.sd_unknown_type);
            }
            String str = string;
            if (z2 || z || str != null) {
                Context context2 = this.context;
                FwUpgradeConditionDialog fwUpgradeConditionDialog2 = new FwUpgradeConditionDialog(context2, context2.getString(C1965R.string.camera), true, z2, z, str, false);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog2;
                fwUpgradeConditionDialog2.show();
                return;
            }
            Version newCameraVersion = FwDownloadManager.getInstance().getNewCameraVersion(false);
            if (newCameraVersion == null || !canUpgrade() || PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
                return;
            }
            if (UsbConfig.isUsbConnected) {
                FwDownloadManager.getInstance().showUpgradeDialog(getContext(), newCameraVersion, false);
                return;
            } else {
                FwDownloadManager.getInstance().showCamUpgradeDialog(getContext(), newCameraVersion, false);
                return;
            }
        }
        if (id == C1965R.id.tv_remote_update) {
            if (!FlightConfig.isConnectFlight()) {
                if (z) {
                    Context context3 = this.context;
                    FwUpgradeConditionDialog fwUpgradeConditionDialog3 = new FwUpgradeConditionDialog(context3, context3.getString(C1965R.string.remotecontrol), false, false, z, null, false);
                    this.fwUpgradeConditionDialog = fwUpgradeConditionDialog3;
                    fwUpgradeConditionDialog3.show();
                    return;
                }
                new GeneralDialog((Context) getContext(), true, "").show();
                return;
            }
            if (z2 || z) {
                Context context4 = this.context;
                FwUpgradeConditionDialog fwUpgradeConditionDialog4 = new FwUpgradeConditionDialog(context4, context4.getString(C1965R.string.remotecontrol), true, z2, z, null, false);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog4;
                fwUpgradeConditionDialog4.show();
                return;
            }
            new GeneralDialog((Context) getContext(), true, "").show();
            return;
        }
        if (id == C1965R.id.tv_fpv_update) {
            Version newFpvVersion = FwDownloadManager.getInstance().getNewFpvVersion(false);
            if (!FlightConfig.isConnectFlight()) {
                if (z) {
                    Context context5 = this.context;
                    FwUpgradeConditionDialog fwUpgradeConditionDialog5 = new FwUpgradeConditionDialog(context5, context5.getString(C1965R.string.fpv), false, false, z, null, false);
                    this.fwUpgradeConditionDialog = fwUpgradeConditionDialog5;
                    fwUpgradeConditionDialog5.show();
                    return;
                }
                if (!UsbConfig.isUsbConnected || newFpvVersion == null || PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
                    return;
                }
                FwDownloadManager.getInstance().showUpgradeDialog(getContext(), newFpvVersion, false);
                return;
            }
            if (z2 || z) {
                Context context6 = this.context;
                FwUpgradeConditionDialog fwUpgradeConditionDialog6 = new FwUpgradeConditionDialog(context6, context6.getString(C1965R.string.fpv), true, z2, z, null, false);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog6;
                fwUpgradeConditionDialog6.show();
                return;
            }
            if (!UsbConfig.isUsbConnected || newFpvVersion == null || PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
                return;
            }
            FwDownloadManager.getInstance().showUpgradeDialog(getContext(), newFpvVersion, false);
            return;
        }
        if (id == C1965R.id.tv_ptz_update) {
            if (z2 || z) {
                Context context7 = this.context;
                FwUpgradeConditionDialog fwUpgradeConditionDialog7 = new FwUpgradeConditionDialog(context7, context7.getString(C1965R.string.gimbal), true, z2, z, null, false);
                this.fwUpgradeConditionDialog = fwUpgradeConditionDialog7;
                fwUpgradeConditionDialog7.show();
                return;
            }
            Version newGimbalVersion = FwDownloadManager.getInstance().getNewGimbalVersion(false);
            if (!canUpgrade() || newGimbalVersion == null || PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
                return;
            }
            FwDownloadManager.getInstance().showUpgradeDialog(getContext(), newGimbalVersion, false);
            return;
        }
        if (id != C1965R.id.tv_battery_update) {
            if (id == C1965R.id.tv_metric) {
                this.tvMetric.setBackgroundResource(C1965R.drawable.bg_setting_button_select_left);
                this.tvImperial.setBackgroundResource(C1965R.drawable.bg_setting_units_default_right);
                SPHelper.getInstance().setFt(false);
                PhoneConfig.isFt = false;
                EventDispatcher.get().sendEvent(EventID.EVENT_UNIT_CHANGED);
                return;
            }
            if (id == C1965R.id.tv_imperial) {
                this.tvMetric.setBackgroundResource(C1965R.drawable.bg_setting_units_default_left);
                this.tvImperial.setBackgroundResource(C1965R.drawable.bg_setting_button_select_right);
                SPHelper.getInstance().setFt(true);
                PhoneConfig.isFt = true;
                EventDispatcher.get().sendEvent(EventID.EVENT_UNIT_CHANGED);
                return;
            }
            return;
        }
        if (z2 || z) {
            Context context8 = this.context;
            FwUpgradeConditionDialog fwUpgradeConditionDialog8 = new FwUpgradeConditionDialog(context8, context8.getString(C1965R.string.battery), true, z2, z, null, false);
            this.fwUpgradeConditionDialog = fwUpgradeConditionDialog8;
            fwUpgradeConditionDialog8.show();
            return;
        }
        Version newBatteryVersion = FwDownloadManager.getInstance().getNewBatteryVersion(false);
        if (!canUpgrade() || newBatteryVersion == null || PhoneConfig.isKernelActivityPause || !PhoneConfig.isKernelActivityRunning || BaseSyncDialog.isShow) {
            return;
        }
        FwDownloadManager.getInstance().showUpgradeDialog(getContext(), newBatteryVersion, false);
    }

    private boolean canUpgrade() {
        return (FlightConfig.curFlight == null || FlightRevData.get().getFlightRevStateData().isFlight() || !FlightConfig.isConnectFlight() || FlightRevData.get().getFlightRevStateData().isTakeOff()) ? false : true;
    }

    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
    public void onStateChanged(View view, boolean z) {
        DDLog.m1687i("切换解码硬解:" + z);
        SPHelper.getInstance().setHardDecode(z);
        AOAEngine.getInstance().switchDecoder();
        EventDispatcher.get().sendEvent(EventID.EVENT_SET_HARDWARE_DECODE, Boolean.valueOf(z));
    }

    private void setUpgradeBtnVisible() {
        this.layoutFlightUpdate.setVisibility(4);
        this.layoutCameraUpdate.setVisibility(4);
        this.layoutRemoteUpdate.setVisibility(4);
        this.layoutFpvUpdate.setVisibility(4);
        this.layoutPtzUpdate.setVisibility(4);
        this.layoutBatteryUpdate.setVisibility(4);
    }

    public void disConnected() {
        if (getBaseView() == null) {
            return;
        }
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.fwUpgradeConditionDialog;
        if (fwUpgradeConditionDialog != null && fwUpgradeConditionDialog.isShowing()) {
            this.fwUpgradeConditionDialog.dismiss();
            this.fwUpgradeConditionDialog = null;
        }
        setUpgradeBtnVisible();
        this.tvFlight.setText(this.f2188NA);
        this.tvCamera.setText(this.f2188NA);
        this.tvRemote.setText(this.f2188NA);
        this.tvFpv.setText(this.f2188NA);
        this.tvPtz.setText(this.f2188NA);
        this.tvBattery.setText(this.f2188NA);
        this.tvEsc.setText(this.f2188NA);
    }

    public void refreshFwUpgradeConditionDialogShow() {
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.fwUpgradeConditionDialog;
        if (fwUpgradeConditionDialog == null || !fwUpgradeConditionDialog.isShowing()) {
            return;
        }
        this.fwUpgradeConditionDialog.refreshSdcard();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C22971.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (((Boolean) event.obj).booleanValue()) {
                setUpgradeBtnVisible();
                return;
            } else {
                updateData();
                return;
            }
        }
        if (i != 2) {
            return;
        }
        String str = (String) event.obj;
        TextView textView = this.tvFlightType;
        if (textView != null) {
            textView.setText("飞机型号:" + FlightConfig.getLastProductClass() + (str == null ? "" : "(" + str + ")"));
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.settings.Setting5Controller$1 */
    static /* synthetic */ class C22971 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_TAKEOFF_HIDE_UPGRADE_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_VERSION_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private boolean updateBattery() {
        int batteryDeviceId = FlightRevData.get().getFlightRevVersionData().getBatteryDeviceId();
        if (FlightConfig.getLastFlight() == null) {
            return false;
        }
        if ((!FlightConfig.is_Atom_Series() || batteryDeviceId != 112 || SPHelper.getInstance().getIsBigPackage()) && (FlightConfig.getLastFlight() != Flight.Flight_P1_PRO || !FlightConfig.isP1ProBattery())) {
            return false;
        }
        DDLog.m1685e("固件下载", "电池去升级");
        return true;
    }
}
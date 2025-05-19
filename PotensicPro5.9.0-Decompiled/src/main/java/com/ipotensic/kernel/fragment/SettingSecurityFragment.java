package com.ipotensic.kernel.fragment;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingBatteryBinding;
import com.ipotensic.kernel.databinding.ViewLayoutSettingSecurityBinding;
import com.ipotensic.kernel.fragment.SettingSecurityFragment;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.kernel.view.dialog.GeneralOneButtonDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.enums.CtrlType;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class SettingSecurityFragment extends BaseKFragment<ViewLayoutSettingSecurityBinding> implements SettingSecurityModel.OnSecurityListener {
    private static final long DIALOG_DISMISS_TIME = 15000;
    private static final long HIDE_LOST_ACTION_TIPS_TIME = 3000;
    private static final int MSG_HIDE_HIGH_SPEED_TIPS = 2;
    private static final int MSG_HIDE_NEW_HAND_DIALOG = 0;
    private static final String TAG = "SettingSecurityFragment";
    private ViewLayoutSettingBatteryBinding batteryBinding;
    private GeneralOneButtonDialog closeNewHandModeDialog;
    private KernelViewModel kernelViewModel;
    private GeneralDialog lostActionDialog;
    private SettingSecurityModel model;
    private GeneralDialog over120Dialog;
    private GeneralDialog returnHeightVideoDialog;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                SettingSecurityFragment.this.hideCloseNewHandModeDialog();
            } else if (message.what == 2) {
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).tvSpeedChange.setVisibility(8);
            }
        }
    };
    private final String[] EU_CODE = {"AT", "BE", "HR", "CY", "CZ", "DK", "EE", "FI", "FR", "DE", "GR", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "RO", "SK", "SI", "ES", "SE", "BG", "GB", "LI", "IS", "CH", "NO"};

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.view_layout_setting_security;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtReturnHeight.setKeyboardListener(getActivity(), ((ViewLayoutSettingSecurityBinding) this.mBind).getRoot());
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtHeightLimit.setKeyboardListener(getActivity(), ((ViewLayoutSettingSecurityBinding) this.mBind).getRoot());
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setKeyboardListener(getActivity(), ((ViewLayoutSettingSecurityBinding) this.mBind).getRoot());
        ((ViewLayoutSettingSecurityBinding) this.mBind).viewTitle.setListener(new CommonTitleView.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$kB9rXqULHvxcRj4U6v0y2O8QbHg
            @Override // com.ipotensic.kernel.view.CommonTitleView.OnClickListener
            public final void onRightClick(View view) {
                SettingSecurityFragment.this.lambda$initListener$0$SettingSecurityFragment(view);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvBeginner.setListener(new CommonSwitchView.OnSwitchChangeListener() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.2
            @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
            public void onCheckedChanged(View view, boolean z) {
                SettingSecurityFragment.this.model.isFromUser = true;
                SettingSecurityFragment.this.model.beginnerMode.set(z);
                if (z) {
                    return;
                }
                SettingSecurityFragment.this.showCloseNewHandModeDialog();
            }

            @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
            public void onDisableClick(View view) {
                SettingSecurityFragment.this.onToast(R.string.toast_unconnected_tips);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).crv.setListener(new CommonSelectionView.OnItemCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$RafKBApnSK_eLHJhC1Faip656-o
            @Override // com.ipotensic.kernel.view.CommonSelectionView.OnItemCheckedChangeListener
            public final void changed(int i, View view) {
                SettingSecurityFragment.this.lambda$initListener$1$SettingSecurityFragment(i, view);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvUnit.setListener(new CommonSelectionView.OnItemCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$6Vl7WbtnZ9972So4jzlYcdQpxB4
            @Override // com.ipotensic.kernel.view.CommonSelectionView.OnItemCheckedChangeListener
            public final void changed(int i, View view) {
                SettingSecurityFragment.this.lambda$initListener$2$SettingSecurityFragment(i, view);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.setListener(new CommonSelectionView.OnItemCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$FXzx8KUOCcxIW8oNeVIe00Mhv-4
            @Override // com.ipotensic.kernel.view.CommonSelectionView.OnItemCheckedChangeListener
            public final void changed(int i, View view) {
                SettingSecurityFragment.this.lambda$initListener$3$SettingSecurityFragment(i, view);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).viewFightTip.setListener(new CommonSwitchView.OnSwitchChangeListener() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.3
            @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
            public void onDisableClick(View view) {
            }

            @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
            public void onCheckedChanged(View view, boolean z) {
                SPHelper.getInstance().setShowFlightTips(z);
                if (FlightConfig.isAtomPanTilt() || FlightConfig.is_Atom_SE_Series() || FlightConfig.isAtomLT()) {
                    EventDispatcher.get().sendEvent(EventID.EVENT_SHOW_FLIGHT_TIPS, Boolean.valueOf(z));
                }
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).ivPlayReturnHeightVideo.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$Fnr8-XcQRZTLUPa2EHc4hASdSE8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingSecurityFragment.this.lambda$initListener$4$SettingSecurityFragment(view);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtReturnHeight.setOnTouchListener(new View.OnTouchListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$aULTS8mHkV2VzV32UYWjPlEo77s
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SettingSecurityFragment.this.lambda$initListener$5$SettingSecurityFragment(view, motionEvent);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).switchBtnNoLimit.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.4
            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onDisableClick() {
            }

            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onStateChanged(View view, boolean z) {
                if (view.isEnabled()) {
                    if (!z) {
                        FlightSendData.get().getSendFlightSetData().setDistanceLimit(SettingSecurityFragment.this.model.inputLimitDistance.get());
                    } else {
                        FlightSendData.get().getSendFlightSetData().setDistanceLimit(65535);
                    }
                    SettingSecurityFragment.this.model.sendSettings();
                }
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setInputFinishListener(this.model.limitDistanceInputListener);
        ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit.setOnSeekBarChangeListener(this.model.limitDistanceSeekbarListener);
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvLostChild.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$7c0s9asK00pMMn1myu_LKsAovzI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingSecurityFragment.this.lambda$initListener$6$SettingSecurityFragment(view);
            }
        });
        ((ViewLayoutSettingSecurityBinding) this.mBind).viewSilentReturn.setListener(new CommonSwitchView.OnSwitchChangeListener() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.5
            @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
            public void onDisableClick(View view) {
            }

            @Override // com.ipotensic.kernel.view.CommonSwitchView.OnSwitchChangeListener
            public void onCheckedChanged(View view, boolean z) {
                SPHelper.getInstance().setSilentReturn(z);
                EventDispatcher.get().sendEvent(EventID.EVENT_SILENT_RETURN, Boolean.valueOf(z));
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingSecurityFragment(View view) {
        this.kernelViewModel.getCloseSetting().setValue(null);
    }

    public /* synthetic */ void lambda$initListener$1$SettingSecurityFragment(int i, View view) {
        if (i == 0) {
            this.model.btnLowSpeedClick(view);
        } else if (i == 1) {
            this.model.btnNormalSpeedClick(view);
        } else {
            if (i != 2) {
                return;
            }
            this.model.btnHighSpeedClick(view);
        }
    }

    public /* synthetic */ void lambda$initListener$2$SettingSecurityFragment(int i, View view) {
        if (i == 0) {
            this.model.btnMetricClick(view);
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvUnit.checked(0);
        } else {
            this.model.btnFtClick(view);
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvUnit.checked(1);
        }
    }

    public /* synthetic */ void lambda$initListener$3$SettingSecurityFragment(int i, View view) {
        showLostActionDialog(i);
    }

    public /* synthetic */ void lambda$initListener$4$SettingSecurityFragment(View view) {
        showReturnHeightVideo();
    }

    public /* synthetic */ boolean lambda$initListener$5$SettingSecurityFragment(View view, MotionEvent motionEvent) {
        if (!FlightConfig.isConnectFlight() || SPHelper.getInstance().isRthGuideVideoShown() || motionEvent.getAction() != 0) {
            return false;
        }
        showReturnHeightVideo();
        return true;
    }

    public /* synthetic */ void lambda$initListener$6$SettingSecurityFragment(View view) {
        this.model.btnLostToReturnClick(view);
    }

    private void showLostActionDialog(final int i) {
        String string = getString(R.string.settings_safety_signal_lost_change_drone_behavior_return_tips);
        if (i == 1) {
            string = getString(R.string.settings_safety_signal_lost_change_drone_behavior_landing_tips);
        } else if (i == 2) {
            string = getString(R.string.settings_safety_signal_lost_change_drone_behavior_hovering_tips);
        }
        GeneralDialog generalDialog = new GeneralDialog(requireContext(), getString(R.string.settings_safety_signal_lost_change_drone_behavior_title), string, getString(R.string.dialog_cancel), getString(R.string.dialog_confirm), new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.6
            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onFailed(Exception exc) {
            }

            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    int i2 = i;
                    if (i2 == 0) {
                        SettingSecurityFragment.this.model.btnReturnClick(null);
                    } else if (i2 == 1) {
                        SettingSecurityFragment.this.model.btnLandClick(null);
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        SettingSecurityFragment.this.model.btnHoverClick(null);
                    }
                }
            }
        });
        this.lostActionDialog = generalDialog;
        generalDialog.show();
    }

    private void hideLostActionDialog() {
        GeneralDialog generalDialog = this.lostActionDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.lostActionDialog.dismiss();
        this.lostActionDialog = null;
    }

    private void controlDistanceLimitView(boolean z) {
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setNoLimit(z, FlightConfig.get_value(this.model.inputLimitDistance.get()));
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setInputEnable(this.model.isDistanceEnable(true));
        ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit.setProgress(this.model.inputLimitDistance.get());
        ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit, this.model.isDistanceEnable(false));
        if (z) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit.setProgress(((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit.getLimitMax());
            this.model.inputLimitDistance.set(this.model.limitDistanceMaxNoUnit.get());
        }
    }

    private void showReturnHeightVideo() {
        DDLog.d("showReturnHeightVideo");
        GeneralDialog generalDialog = this.returnHeightVideoDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            GeneralDialog generalDialog2 = new GeneralDialog(getContext(), R.raw.video_rth_guide);
            this.returnHeightVideoDialog = generalDialog2;
            generalDialog2.show();
        }
    }

    private void hideReturnHeightVideoDialog() {
        GeneralDialog generalDialog = this.returnHeightVideoDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.returnHeightVideoDialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GeneralDialog generalDialog = this.returnHeightVideoDialog;
        if (generalDialog != null) {
            generalDialog.onPauseVideo();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingSecurityModel(this);
        ((ViewLayoutSettingSecurityBinding) this.mBind).setSettingSecurityModel(this.model);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        this.model.updateFlightType();
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setLimit(FlightConfig.get_value(this.model.limitDistanceMaxNoUnit.get()), FlightConfig.get_value(30), FlightConfig.get_value(20));
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setText(String.valueOf(FlightConfig.get_value(this.model.inputLimitDistance.get())));
        if (FlightRevData.get().getFlightRevSettingData().isInit()) {
            this.model.update(FlightRevData.get().getFlightRevSettingData());
        }
        if (FlightRevData.get().getFlightRevBatteryData().isInit()) {
            this.model.update(FlightRevData.get().getFlightRevBatteryData());
        }
        if (FlightRevData.get().getFlightRevStateData().isInit()) {
            this.model.update(FlightRevData.get().getFlightRevStateData());
        }
        if (FlightConfig.isConnectFlight()) {
            this.model.update();
        }
        setUnitString();
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvBeginner.setSwitchButtonEnable(this.model.FlightIsConnect.get());
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvBeginner.check(this.model.beginnerMode.get());
        ((ViewLayoutSettingSecurityBinding) this.mBind).crv.setItems(getString(R.string.txt_speed_gently), getString(R.string.txt_speed_normal), getString(R.string.txt_speed_sport));
        ((ViewLayoutSettingSecurityBinding) this.mBind).crv.setEnabled(this.model.FlightIsConnect.get() && this.model.speedModeIsShow.get());
        if (SPHelper.getInstance().isFt()) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvUnit.checked(1);
        } else {
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvUnit.checked(0);
        }
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.setEnabled(this.model.FlightIsConnect.get());
        ((ViewLayoutSettingSecurityBinding) this.mBind).viewFightTip.check(SPHelper.getInstance().isShowFlightTips());
        this.model.showBatteryInfo.addOnPropertyChangedCallback(new AnonymousClass7());
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setInputEnable(this.model.isDistanceEnable(true));
        ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit, this.model.isDistanceEnable(false));
        ((ViewLayoutSettingSecurityBinding) this.mBind).viewSilentReturn.check(SPHelper.getInstance().isSilentReturn());
        onFlightTypeDefine();
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingSecurityFragment$7, reason: invalid class name */
    class AnonymousClass7 extends Observable.OnPropertyChangedCallback {
        AnonymousClass7() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            SettingSecurityFragment.this.inflateBattery();
            if (SettingSecurityFragment.this.model.showBatteryInfo.get()) {
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).tvBatteryInfo.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.mipmap.img_btn_function_close, 0);
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).layoutSetting.post(new Runnable() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$7$SrsXHdr4v2HeycWw8UDdgQotjK4
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingSecurityFragment.AnonymousClass7.this.lambda$onPropertyChanged$0$SettingSecurityFragment$7();
                    }
                });
            } else {
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).tvBatteryInfo.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.mipmap.img_btn_function_open, 0);
            }
        }

        public /* synthetic */ void lambda$onPropertyChanged$0$SettingSecurityFragment$7() {
            ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).layoutSetting.fullScroll(130);
            SettingSecurityFragment.this.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inflateBattery() {
        ViewStub viewStub;
        if (this.batteryBinding == null && (viewStub = ((ViewLayoutSettingSecurityBinding) this.mBind).vsBattery.getViewStub()) != null) {
            viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$wlbosSUvS2goHldPfn710XayzAo
                @Override // android.view.ViewStub.OnInflateListener
                public final void onInflate(ViewStub viewStub2, View view) {
                    SettingSecurityFragment.this.lambda$inflateBattery$7$SettingSecurityFragment(viewStub2, view);
                }
            });
            viewStub.inflate();
        }
    }

    public /* synthetic */ void lambda$inflateBattery$7$SettingSecurityFragment(ViewStub viewStub, View view) {
        ViewLayoutSettingBatteryBinding viewLayoutSettingBatteryBinding = (ViewLayoutSettingBatteryBinding) DataBindingUtil.bind(view);
        this.batteryBinding = viewLayoutSettingBatteryBinding;
        viewLayoutSettingBatteryBinding.setSettingSecurityModel(this.model);
        this.batteryBinding.batteryProgressView.setProgress(this.model.batteryProgressValue.get());
    }

    private void onFlightTypeDefine() {
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.setLimit(FlightConfig.get_value(this.model.limitDistanceMaxNoUnit.get()), FlightConfig.get_value(30), FlightConfig.get_value(20));
        ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit.setLimit(this.model.limitDistanceMaxNoUnit.get(), 30, 20);
        ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarDistanceLimit.setProgress(this.model.inputLimitDistance.get());
        int i = 8;
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvHeightNoLimit.setVisibility((!FlightConfig.is_Atom_SE_Series() || CommonUtil.hasNewVersion("3.0.2", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) ? 0 : 8);
        ((ViewLayoutSettingSecurityBinding) this.mBind).switchBtnNoLimit.setVisibility((!FlightConfig.is_Atom_SE_Series() || CommonUtil.hasNewVersion("3.0.2", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) ? 0 : 8);
        ((ViewLayoutSettingSecurityBinding) this.mBind).viewFightTip.setVisibility((FlightConfig.isAtomPanTilt() || FlightConfig.is_Atom_SE_Series() || FlightConfig.isAtomLT()) ? 0 : 8);
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvSignalLost.setVisibility((!FlightConfig.is_Atom_SE_Series() || CommonUtil.hasNewVersion("3.0.7", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) ? 0 : 8);
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.setVisibility((!FlightConfig.is_Atom_SE_Series() || CommonUtil.hasNewVersion("3.0.7", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) ? 0 : 8);
        ((ViewLayoutSettingSecurityBinding) this.mBind).line2.setVisibility((!FlightConfig.is_Atom_SE_Series() || CommonUtil.hasNewVersion("3.0.7", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) ? 0 : 8);
        ((ViewLayoutSettingSecurityBinding) this.mBind).line3.setVisibility((FlightConfig.isOldProduct() || FlightConfig.isAtomSE() || !FlightConfig.isConnectFlight() || !CommonUtil.hasNewVersion("1.2.0", SPHelper.getInstance().getRemoterCurVersion())) ? 8 : 0);
        CommonSwitchView commonSwitchView = ((ViewLayoutSettingSecurityBinding) this.mBind).viewSilentReturn;
        if (!FlightConfig.isOldProduct() && !FlightConfig.isAtomSE() && FlightConfig.isConnectFlight() && CommonUtil.hasNewVersion("1.2.0", SPHelper.getInstance().getRemoterCurVersion())) {
            i = 0;
        }
        commonSwitchView.setVisibility(i);
        if (this.model.lostAction.getValue() != null) {
            this.model.lostAction.setValue(this.model.lostAction.getValue());
        }
        updateHeightLimit();
        updateDistanceLimit();
        if (this.model.isNoLimit.getValue() == null) {
            controlDistanceLimitView(false);
        } else {
            controlDistanceLimitView(this.model.isNoLimit.getValue().booleanValue());
        }
    }

    private void updateHeightLimit() {
        this.model.maxHeight.get();
        int i = 800;
        if (Arrays.asList(this.EU_CODE).contains(SPHelper.getInstance().getCountryCode()) || SPHelper.getInstance().getCountryCode() == null) {
            this.model.maxHeight.set(120);
            this.model.warnMaxHeight.set(120);
            if (this.model.inputLimitHeight.get() > 120 && FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance() < 120) {
                this.model.inputLimitHeight.set(120);
                if (FlightRevData.get().getFlightRevSettingData().getLimitHeight() > 120) {
                    FlightSendData.get().getSendFlightSetData().setHeightLimit(120);
                    this.model.sendSettings();
                }
            }
            i = 120;
        } else if ("JP".equalsIgnoreCase(SPHelper.getInstance().getCountryCode())) {
            if (FlightConfig.getMaxHeight() < 800) {
                i = FlightConfig.getMaxHeight();
                this.model.maxHeight.set(i);
                this.model.warnMaxHeight.set(120);
            } else {
                this.model.maxHeight.set(800);
                this.model.warnMaxHeight.set(150);
            }
        } else if (FlightConfig.getMaxHeight() < 800) {
            i = FlightConfig.getMaxHeight();
            this.model.maxHeight.set(i);
            this.model.warnMaxHeight.set(120);
        } else {
            this.model.maxHeight.set(800);
            this.model.warnMaxHeight.set(120);
        }
        int i2 = 10;
        if (this.model.unitIsFt.get()) {
            i2 = FlightConfig.get_value(10);
            i = FlightConfig.get_value(i);
        }
        if (this.kernelViewModel.getMaxHeight().getValue().intValue() != i) {
            this.kernelViewModel.getMaxHeight().setValue(Integer.valueOf(i));
        }
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvHeightLimit.setText(getString(R.string.txt_flight_height_limit, Integer.valueOf(i2), Integer.valueOf(i), this.model.unitTips.get()));
        DDLog.e(TAG, "updateHeightLimit max:" + i);
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvAltitudeCarefulTips.setText(getString(R.string.settings_safety_virtual_fence_altitude_limit_over_tip, FlightConfig.get_value(this.model.warnMaxHeight.get()) + "", this.model.unitTips.get()));
        ((ViewLayoutSettingSecurityBinding) this.mBind).edtHeightLimit.setLimit(i, FlightConfig.get_value(30), i2);
        ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarHeightLimit.setLimit(i, FlightConfig.get_value(30), i2);
        ((ViewLayoutSettingSecurityBinding) this.mBind).seekbarHeightLimit.setProgress(FlightConfig.get_value(this.model.inputLimitHeight.get()));
    }

    private void updateDistanceLimit() {
        int i = this.model.limitDistanceMaxNoUnit.get();
        int i2 = 20;
        if (this.model.unitIsFt.get()) {
            i2 = FlightConfig.get_value(20);
            i = FlightConfig.get_value(i);
        }
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvDistanceLimit.setText(getString(R.string.txt_flight_distance_limit, Integer.valueOf(i2), Integer.valueOf(i), this.model.unitTips.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFocus() {
        View findFocus = requireActivity().getWindow().getDecorView().findFocus();
        if (findFocus != null) {
            findFocus.clearFocus();
        }
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingSecurityFragment$15, reason: invalid class name */
    static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;
        static final /* synthetic */ int[] $SwitchMap$com$logan$flight$enums$CtrlType;

        static {
            int[] iArr = new int[CtrlType.values().length];
            $SwitchMap$com$logan$flight$enums$CtrlType = iArr;
            try {
                iArr[CtrlType.TYPE_LOST_HOVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$logan$flight$enums$CtrlType[CtrlType.TYPE_LOST_LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$logan$flight$enums$CtrlType[CtrlType.TYPE_LOST_RETURN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$logan$flight$enums$CtrlType[CtrlType.TYPE_LOST_RETURN_TO_120M.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr2;
            try {
                iArr2[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_BATTERY_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_SETTING_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_CTRL_CMD.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SILENT_RETURN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_UNIT_CHANGED.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_UPDATE_COUNTRY_CODE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        this.model.lostAction.observe(getViewLifecycleOwner(), new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$rx73AAWh8PMX5d16BTnxvY_jcbs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingSecurityFragment.this.lambda$initObserver$8$SettingSecurityFragment((CtrlType) obj);
            }
        });
        this.model.speedMode.observe(getViewLifecycleOwner(), new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$dkjYUDWy8p-stWWdVbHPeakdL7M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingSecurityFragment.this.lambda$initObserver$9$SettingSecurityFragment((Integer) obj);
            }
        });
        this.model.speedModeIsShow.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.8
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).crv.setEnabled(SettingSecurityFragment.this.model.FlightIsConnect.get() && SettingSecurityFragment.this.model.speedModeIsShow.get());
            }
        });
        this.model.FlightIsConnect.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.9
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).crv.setEnabled(SettingSecurityFragment.this.model.FlightIsConnect.get() && SettingSecurityFragment.this.model.speedModeIsShow.get());
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).csvBeginner.setSwitchButtonEnable(SettingSecurityFragment.this.model.FlightIsConnect.get());
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).csvLost.setEnabled(SettingSecurityFragment.this.model.FlightIsConnect.get());
            }
        });
        this.model.unitIsFt.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.10
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                DDLog.d(SettingSecurityFragment.TAG, "unitIsFt---" + SettingSecurityFragment.this.model.unitIsFt.get());
                if (SettingSecurityFragment.this.model.isNoLimit()) {
                    return;
                }
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).edtDistanceLimit.setLimit(FlightConfig.get_value(SettingSecurityFragment.this.model.limitDistanceMaxNoUnit.get()), FlightConfig.get_value(30), FlightConfig.get_value(20));
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).edtDistanceLimit.setText(String.valueOf(FlightConfig.get_value(SettingSecurityFragment.this.model.inputLimitDistance.get())));
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).edtDistanceLimit.setInputEnable(SettingSecurityFragment.this.model.isDistanceEnable(true));
            }
        });
        this.model.beginnerMode.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.11
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                DDLog.d(SettingSecurityFragment.TAG, "beginnerMode---" + SettingSecurityFragment.this.model.beginnerMode.get());
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).csvBeginner.check(SettingSecurityFragment.this.model.beginnerMode.get());
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).edtDistanceLimit.setInputEnable(SettingSecurityFragment.this.model.isDistanceEnable(true));
                ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).seekbarDistanceLimit, SettingSecurityFragment.this.model.isDistanceEnable(false));
                if (SettingSecurityFragment.this.model.beginnerMode.get()) {
                    SettingSecurityFragment.this.model.setNoLimit(false);
                }
                SettingSecurityFragment.this.model.onBeginnerModeChange();
            }
        });
        this.model.batteryProgressValue.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.12
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (SettingSecurityFragment.this.batteryBinding != null) {
                    SettingSecurityFragment.this.batteryBinding.batteryProgressView.setProgress(SettingSecurityFragment.this.model.batteryProgressValue.get());
                }
            }
        });
        this.model.playReturnHeightVideo.observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$_V6KApVPSAPLg00m1Q3FNgn0ZjY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingSecurityFragment.this.lambda$initObserver$10$SettingSecurityFragment((Void) obj);
            }
        });
        this.kernelViewModel.isReturnOrLanding().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$2_6Yq_zbiqzTj1ED7Uuotbcm_oY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingSecurityFragment.this.lambda$initObserver$11$SettingSecurityFragment((Boolean) obj);
            }
        });
        this.model.inputLimitDistance.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.13
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                DDLog.d(SettingSecurityFragment.TAG, "inputLimitDistance---" + SettingSecurityFragment.this.model.inputLimitDistance.get());
                if (SettingSecurityFragment.this.model.isNoLimit()) {
                    return;
                }
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).edtDistanceLimit.setText(String.valueOf(FlightConfig.get_value(SettingSecurityFragment.this.model.inputLimitDistance.get())));
                ((ViewLayoutSettingSecurityBinding) SettingSecurityFragment.this.mBind).seekbarDistanceLimit.setProgress(SettingSecurityFragment.this.model.inputLimitDistance.get());
                FlightSendData.get().getSendFlightSetData().setDistanceLimit(SettingSecurityFragment.this.model.inputLimitDistance.get());
            }
        });
        this.model.isNoLimit.observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$zdCDq8d13ExXwG1ssfHxZ3He9ic
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingSecurityFragment.this.lambda$initObserver$12$SettingSecurityFragment((Boolean) obj);
            }
        });
        this.model.showHighSpeedTips.observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingSecurityFragment$Eb7LBEeQjjvCnpKSb9etyUil72E
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingSecurityFragment.this.lambda$initObserver$13$SettingSecurityFragment((Void) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$8$SettingSecurityFragment(CtrlType ctrlType) {
        int i = AnonymousClass15.$SwitchMap$com$logan$flight$enums$CtrlType[ctrlType.ordinal()];
        if (i == 1) {
            controlLostActionNotice(false);
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.checked(2);
        } else if (i == 2) {
            controlLostActionNotice(false);
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.checked(1);
        } else if (i == 3) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).tvLostChild.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.img_btn_signal_lost_child_return_unselect, 0, 0, 0);
            controlLostActionNotice(true);
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.checked(0);
        } else if (i == 4) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).tvLostChild.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.img_btn_signal_lost_child_return_select, 0, 0, 0);
            controlLostActionNotice(true);
            ((ViewLayoutSettingSecurityBinding) this.mBind).csvLost.checked(0);
        }
        scrollToLostAction();
    }

    public /* synthetic */ void lambda$initObserver$9$SettingSecurityFragment(Integer num) {
        if (num.intValue() == 0) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).crv.checked(0);
        } else if (num.intValue() == 1) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).crv.checked(1);
        } else if (num.intValue() == 2) {
            ((ViewLayoutSettingSecurityBinding) this.mBind).crv.checked(2);
        }
    }

    public /* synthetic */ void lambda$initObserver$10$SettingSecurityFragment(Void r1) {
        showReturnHeightVideo();
    }

    public /* synthetic */ void lambda$initObserver$11$SettingSecurityFragment(Boolean bool) {
        if (bool.booleanValue()) {
            hideReturnHeightVideoDialog();
        }
    }

    public /* synthetic */ void lambda$initObserver$12$SettingSecurityFragment(Boolean bool) {
        DDLog.d(TAG, "isNoLimit---" + bool);
        ((ViewLayoutSettingSecurityBinding) this.mBind).switchBtnNoLimit.setChecked(bool.booleanValue());
        controlDistanceLimitView(bool.booleanValue());
    }

    public /* synthetic */ void lambda$initObserver$13$SettingSecurityFragment(Void r4) {
        if (((ViewLayoutSettingSecurityBinding) this.mBind).tvSpeedChange.getVisibility() == 8) {
            AnimationUtil.transInTop(((ViewLayoutSettingSecurityBinding) this.mBind).tvSpeedChange);
        }
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageDelayed(2, HIDE_LOST_ACTION_TIPS_TIME);
    }

    private void scrollToLostAction() {
        if (((ViewLayoutSettingSecurityBinding) this.mBind).line2.getGlobalVisibleRect(new Rect())) {
            return;
        }
        ((ViewLayoutSettingSecurityBinding) this.mBind).layoutSetting.smoothScrollTo(0, ((ViewLayoutSettingSecurityBinding) this.mBind).line2.getTop());
    }

    private void setUnitString() {
        ((ViewLayoutSettingSecurityBinding) this.mBind).csvBeginner.setContent(getString(R.string.txt_beginner_mode_tips));
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvLostChild.setText(getString(R.string.txt_lost_to_return));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseNewHandModeDialog() {
        GeneralOneButtonDialog confirmStr = new GeneralOneButtonDialog(getContext()).setTitleId(R.string.settings_safety_exit_beginner_mode_title).setContent(getString(R.string.settings_safety_exit_beginner_mode_tips)).setConfirmStr(R.string.txt_guide_map_know);
        this.closeNewHandModeDialog = confirmStr;
        confirmStr.show();
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCloseNewHandModeDialog() {
        GeneralOneButtonDialog generalOneButtonDialog = this.closeNewHandModeDialog;
        if (generalOneButtonDialog == null || !generalOneButtonDialog.isShowing()) {
            return;
        }
        this.closeNewHandModeDialog.dismiss();
        this.closeNewHandModeDialog = null;
    }

    private void controlLostActionNotice(boolean z) {
        int i = 0;
        ((ViewLayoutSettingSecurityBinding) this.mBind).tvLostActionWarning.setVisibility((z || (FlightConfig.is_Atom_SE_Series() && !CommonUtil.hasNewVersion("3.0.7", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion()))) ? 8 : 0);
        TextView textView = ((ViewLayoutSettingSecurityBinding) this.mBind).tvLostChild;
        if (!z || (FlightConfig.is_Atom_SE_Series() && !CommonUtil.hasNewVersion("3.0.7", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion()))) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void refreshData() {
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (flightRevStateData.isInit()) {
            this.model.speedMode.setValue(Integer.valueOf(flightRevStateData.getSpeedMode()));
        }
    }

    public void updateHeight() {
        if (this.mBind == 0) {
            return;
        }
        int curValue = ((ViewLayoutSettingSecurityBinding) this.mBind).edtReturnHeight.getCurValue();
        int curValue2 = ((ViewLayoutSettingSecurityBinding) this.mBind).edtHeightLimit.getCurValue();
        int curValue3 = ((ViewLayoutSettingSecurityBinding) this.mBind).edtDistanceLimit.getCurValue();
        if (this.model.unitIsFt.get()) {
            curValue = UnitUtil.round((float) (curValue / 3.28083989501d));
            curValue2 = UnitUtil.round((float) (curValue2 / 3.28083989501d));
            curValue3 = UnitUtil.round((float) (curValue3 / 3.28083989501d));
        }
        if (this.model.inputReturnHeight.get() != curValue) {
            this.model.inputReturnHeight.set(curValue);
        }
        if (this.model.inputLimitHeight.get() != curValue2) {
            this.model.inputLimitHeight.set(curValue2);
        }
        if (this.model.inputLimitDistance.get() != curValue3) {
            this.model.inputLimitDistance.set(curValue3);
        }
        this.model.sendSettings();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        switch (AnonymousClass15.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                this.model.updateFlightType();
                onFlightTypeDefine();
                break;
            case 2:
                this.model.update(FlightRevData.get().getFlightRevBatteryData());
                break;
            case 3:
                this.model.update(FlightRevData.get().getFlightRevSettingData());
                break;
            case 4:
                this.model.update(FlightRevData.get().getFlightRevStateData());
                break;
            case 5:
                this.model.update();
                if (!FlightConfig.isConnectFlight()) {
                    hideCloseNewHandModeDialog();
                    hideReturnHeightVideoDialog();
                    hideLostActionDialog();
                    hideOver120Dialog();
                    hideSoftKeyboard();
                    this.model.setNoLimit(false);
                }
                ((ViewLayoutSettingSecurityBinding) this.mBind).line3.setVisibility((FlightConfig.isOldProduct() || FlightConfig.isAtomSE() || !FlightConfig.isConnectFlight() || !CommonUtil.hasNewVersion("1.2.0", SPHelper.getInstance().getRemoterCurVersion())) ? 8 : 0);
                ((ViewLayoutSettingSecurityBinding) this.mBind).viewSilentReturn.setVisibility((FlightConfig.isOldProduct() || FlightConfig.isAtomSE() || !FlightConfig.isConnectFlight() || !CommonUtil.hasNewVersion("1.2.0", SPHelper.getInstance().getRemoterCurVersion())) ? 8 : 0);
                break;
            case 6:
                this.model.updateLostAction(FlightRevData.get().getCtrlData().getCtrlType());
                break;
            case 7:
                DataManager.getInstance().controlRemoterMute(((Boolean) event.obj).booleanValue());
                break;
            case 8:
            case 9:
                updateHeightLimit();
                break;
        }
    }

    @Override // com.ipotensic.kernel.model.SettingSecurityModel.OnSecurityListener
    public void onToast(int i) {
        if (i == R.string.switch_sport_mode_tip) {
            if (PhoneConfig.isFt) {
                ToastUtil.toast(getActivity(), getString(R.string.switch_sport_mode_tip, "26ft"));
                return;
            } else {
                ToastUtil.toast(getActivity(), getString(R.string.switch_sport_mode_tip, "8m"));
                return;
            }
        }
        ToastUtil.toast(getActivity(), getString(i));
    }

    @Override // com.ipotensic.kernel.model.SettingSecurityModel.OnSecurityListener
    public void showOver120Dialog(final SimpleResultListener<Boolean> simpleResultListener) {
        GeneralDialog generalDialog = this.over120Dialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            GeneralDialog generalDialog2 = new GeneralDialog(getContext(), getContext().getString(R.string.txt_disclaimer), getContext().getString(R.string.txt_disclaimer_content, FlightConfig.getValueWithUnit(this.model.warnMaxHeight.get()), ""), getContext().getString(R.string.dialog_cancel), getContext().getString(R.string.user_agree), new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.fragment.SettingSecurityFragment.14
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Boolean bool) {
                    simpleResultListener.onResult(bool);
                }
            });
            this.over120Dialog = generalDialog2;
            generalDialog2.show();
        }
    }

    private void hideOver120Dialog() {
        GeneralDialog generalDialog = this.returnHeightVideoDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.returnHeightVideoDialog.dismiss();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        hideReturnHeightVideoDialog();
        this.returnHeightVideoDialog = null;
    }
}

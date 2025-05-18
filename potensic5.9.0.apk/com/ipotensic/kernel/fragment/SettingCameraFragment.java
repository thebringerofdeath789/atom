package com.ipotensic.kernel.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.RightController;
import com.ipotensic.kernel.databinding.ViewLayoutSettingCameraBinding;
import com.ipotensic.kernel.fragment.SettingCameraFragment;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.SettingCameraModel;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.data.PhotoChildMode;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class SettingCameraFragment extends BaseKFragment<ViewLayoutSettingCameraBinding> {
    private GeneralDialog formatDialog;
    private KernelViewModel kernelViewModel;
    private SettingCameraModel model;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CameraCtrlPresenter.getInstance().getPhotoRecordGps();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_setting_camera;
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingCameraFragment$1 */
    class C23081 implements SettingCameraModel.OnSettingCameraListener {
        C23081() {
        }

        @Override // com.ipotensic.kernel.model.SettingCameraModel.OnSettingCameraListener
        public void onFormatSD(OnResultListener<Boolean> onResultListener) {
            RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
            if (rightController == null || !rightController.isRecording()) {
                if (!CameraConfig.get().isSdCardAvailable()) {
                    ToastUtil.toast(SettingCameraFragment.this.getActivity(), SettingCameraFragment.this.getString(C1965R.string.no_sd_card));
                    EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD_TIP);
                } else {
                    SettingCameraFragment.this.formatDialog = new GeneralDialog(SettingCameraFragment.this.getContext(), SettingCameraFragment.this.getResources().getString(C1965R.string.dialog_sd_format), SettingCameraFragment.this.getResources().getString(C1965R.string.dialog_sd_format_describe), (String) null, (String) null, false, 2, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$1$LG5R9FqKaOTq6JxnkTl8Lkd3V0E
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public final void confirm() {
                            SettingCameraFragment.C23081.this.lambda$onFormatSD$0$SettingCameraFragment$1();
                        }
                    });
                    SettingCameraFragment.this.formatDialog.show();
                }
            }
        }

        public /* synthetic */ void lambda$onFormatSD$0$SettingCameraFragment$1() {
            RightController rightController = (RightController) EventDispatcher.get().getController(RightController.class);
            if (rightController == null || !rightController.isRecording()) {
                if (CameraConfig.get().isSdCardAvailable()) {
                    SettingCameraFragment.this.kernelViewModel.getFormatSdcard().setValue(null);
                } else {
                    ToastUtil.toast(SettingCameraFragment.this.getActivity(), SettingCameraFragment.this.getString(C1965R.string.no_sd_card));
                }
            }
        }

        @Override // com.ipotensic.kernel.model.SettingCameraModel.OnSettingCameraListener
        public void onToast(int i) {
            ToastUtil.toast(SettingCameraFragment.this.getActivity(), SettingCameraFragment.this.getString(i));
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingCameraModel(new C23081());
        ((ViewLayoutSettingCameraBinding) this.mBind).setSettingCameraModel(this.model);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        boolean z = false;
        ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.setIconItems(C1965R.mipmap.cb_dot_unselected, C1965R.mipmap.cb_cross_unselected, C1965R.mipmap.cb_sharp_unselected, C1965R.mipmap.cb_dot_select, C1965R.mipmap.cb_cross_select, C1965R.mipmap.cb_sharp_select);
        this.model.isTrackOpen.setValue(Boolean.valueOf(Conditions.isTrackTargetOpen()));
        PhotoChildMode value = this.kernelViewModel.getPhotoChildModeData().getValue();
        if (value != null && value.isTimeTaking) {
            z = true;
        }
        controlViews(z);
        refreshData();
        onFlightTypeDefine();
    }

    private boolean isHidePictureGpsLocation() {
        return (FlightConfig.isAtomSEV2() && !CommonUtil.hasNewVersion("2.0.4", CameraConfig.get().getSoftVersion())) || (FlightConfig.isAtomSEV3() && !CommonUtil.hasNewVersion("3.0.16", CameraConfig.get().getSoftVersion())) || FlightConfig.isAtomSE();
    }

    private void onFlightTypeDefine() {
        ((ViewLayoutSettingCameraBinding) this.mBind).tvWhiteBalanceTip.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).tvAutoWhiteBalance.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).edtWhiteBalance.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).sbWhiteBalance.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).line1.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).tvPhotoLocationTips.setVisibility(isHidePictureGpsLocation() ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).switchBtnPhotoGpsLocation.setVisibility(isHidePictureGpsLocation() ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).line4.setVisibility(isHidePictureGpsLocation() ? 8 : 0);
        ((ViewLayoutSettingCameraBinding) this.mBind).viewOthers.getLayoutParams().height = UnitUtil.dp2px(isHidePictureGpsLocation() ? 50 : 100);
    }

    public void refreshData() {
        this.model.updateManualWhiteBalance();
        this.model.update();
        ((ViewLayoutSettingCameraBinding) this.mBind).segRecLayout.checked(this.model.recSeg.get());
        ((ViewLayoutSettingCameraBinding) this.mBind).segRecLayout.setEnabled(this.model.isFlightConnect.get());
        ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.setCheckState(0, SPHelper.getInstance().isPreviewShowDot());
        ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.setCheckState(1, SPHelper.getInstance().isPreviewShowCross());
        ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.setCheckState(2, SPHelper.getInstance().isPreviewShowLine());
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutSettingCameraBinding) this.mBind).edtWhiteBalance.setKeyboardListener(getActivity(), ((ViewLayoutSettingCameraBinding) this.mBind).getRoot());
        ((ViewLayoutSettingCameraBinding) this.mBind).viewTitle.setListener(new CommonTitleView.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$jMTIE8baqMNwzDKLcEGt3pFpiKE
            @Override // com.ipotensic.kernel.view.CommonTitleView.OnClickListener
            public final void onRightClick(View view) {
                SettingCameraFragment.this.lambda$initListener$0$SettingCameraFragment(view);
            }
        });
        ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.setListener(new CommonSelectionView.OnItemCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$I9fO90EOdJWo1toQuIh1zQmAh7I
            @Override // com.ipotensic.kernel.view.CommonSelectionView.OnItemCheckedChangeListener
            public final void changed(int i, View view) {
                SettingCameraFragment.this.lambda$initListener$1$SettingCameraFragment(i, view);
            }
        });
        ((ViewLayoutSettingCameraBinding) this.mBind).segRecLayout.setListener(new CommonSelectionView.OnItemCheckedChangeListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$vI8Y6x5gfeQEJLBP12qvXgxYQ8E
            @Override // com.ipotensic.kernel.view.CommonSelectionView.OnItemCheckedChangeListener
            public final void changed(int i, View view) {
                SettingCameraFragment.this.lambda$initListener$2$SettingCameraFragment(i, view);
            }
        });
        ((ViewLayoutSettingCameraBinding) this.mBind).sbWater.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.fragment.SettingCameraFragment.2
            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onStateChanged(View view, boolean z) {
                SettingCameraFragment.this.model.waterMarkStateChangedListener.onStateChanged(view, z);
            }

            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onDisableClick() {
                if (SettingCameraFragment.this.isTimedTakingCheck()) {
                    return;
                }
                SettingCameraFragment.this.model.waterMarkStateChangedListener.onDisableClick();
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingCameraFragment(View view) {
        this.kernelViewModel.getCloseSetting().setValue(null);
    }

    public /* synthetic */ void lambda$initListener$1$SettingCameraFragment(int i, View view) {
        if (i == 0) {
            ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.checked(0);
            this.model.onDotClick(view.isSelected());
        } else if (i == 1) {
            ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.checked(1);
            this.model.onCrossClick(view.isSelected());
        } else {
            if (i != 2) {
                return;
            }
            ((ViewLayoutSettingCameraBinding) this.mBind).gridLayout.checked(2);
            this.model.onSharpClick(view.isSelected());
        }
    }

    public /* synthetic */ void lambda$initListener$2$SettingCameraFragment(int i, View view) {
        if (isTimedTakingCheck()) {
            return;
        }
        if (i == 0) {
            this.model.onSegAutoClick(view);
            return;
        }
        if (i == 1) {
            this.model.onSeg1Click(view);
        } else if (i == 2) {
            this.model.onSeg3Click(view);
        } else {
            if (i != 3) {
                return;
            }
            this.model.onSeg5Click(view);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        this.model.recSeg.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingCameraFragment.3
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                ((ViewLayoutSettingCameraBinding) SettingCameraFragment.this.mBind).segRecLayout.checked(SettingCameraFragment.this.model.recSeg.get());
            }
        });
        this.model.isFlightConnect.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingCameraFragment.4
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                ((ViewLayoutSettingCameraBinding) SettingCameraFragment.this.mBind).segRecLayout.setEnabled(SettingCameraFragment.this.model.isFlightConnect.get());
                PhotoChildMode value = SettingCameraFragment.this.kernelViewModel.getPhotoChildModeData().getValue();
                SettingCameraFragment.this.controlViews(value != null && value.isTimeTaking);
            }
        });
        this.kernelViewModel.getPhotoChildModeData().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$zpD88kfj8UG5lTVA7gIzgs3QsaQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingCameraFragment.this.lambda$initObserver$3$SettingCameraFragment((PhotoChildMode) obj);
            }
        });
        this.model.wbIsMwb.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.fragment.SettingCameraFragment.5
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                PhotoChildMode value = SettingCameraFragment.this.kernelViewModel.getPhotoChildModeData().getValue();
                SettingCameraFragment.this.controlViews(value != null && value.isTimeTaking);
            }
        });
        this.model.isTrackOpen.observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$BrCtlo_4bQUjt_oIJJQ2qozwIEo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingCameraFragment.this.lambda$initObserver$4$SettingCameraFragment((Boolean) obj);
            }
        });
        this.kernelViewModel.getSdcardPullOut().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingCameraFragment$8taP9pgwb36JdLvNHAvNIsJ2RcQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingCameraFragment.this.lambda$initObserver$5$SettingCameraFragment((Void) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$3$SettingCameraFragment(PhotoChildMode photoChildMode) {
        controlViews(photoChildMode.isTimeTaking);
        this.model.isTimeTaking = photoChildMode.isTimeTaking;
        if (photoChildMode.isTimeTaking) {
            this.model.waterMarkIsClickable.set(false);
        } else {
            this.model.waterMarkIsClickable.set(CameraConfig.get().isGetConfigMenu);
        }
    }

    public /* synthetic */ void lambda$initObserver$4$SettingCameraFragment(Boolean bool) {
        PhotoChildMode value = this.kernelViewModel.getPhotoChildModeData().getValue();
        controlViews(value != null && value.isTimeTaking);
    }

    public /* synthetic */ void lambda$initObserver$5$SettingCameraFragment(Void r1) {
        GeneralDialog generalDialog = this.formatDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.formatDialog.dismiss();
        this.formatDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTimedTakingCheck() {
        PhotoChildMode value = this.kernelViewModel.getPhotoChildModeData().getValue();
        boolean z = value != null && value.isTimeTaking;
        if (z) {
            ToastUtil.toast(getActivity(), getString(C1965R.string.flight_interface_exit_self_timer_mode_before_setting_tips));
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void controlViews(boolean z) {
        DDLog.m1683d("SettingCameraFragment", "controlViews=" + z);
        boolean z2 = false;
        if (z) {
            ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingCameraBinding) this.mBind).tvAutoWhiteBalance, false);
            ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingCameraBinding) this.mBind).sbWhiteBalance, false);
            ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingCameraBinding) this.mBind).tvFormat, false);
            return;
        }
        boolean booleanValue = this.model.isTrackOpen.getValue() != null ? this.model.isTrackOpen.getValue().booleanValue() : false;
        ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingCameraBinding) this.mBind).tvAutoWhiteBalance, this.model.isFlightConnect.get() && !booleanValue);
        CustomSeekbar customSeekbar = ((ViewLayoutSettingCameraBinding) this.mBind).sbWhiteBalance;
        if (this.model.isFlightConnect.get() && this.model.wbIsMwb.get() && !booleanValue) {
            z2 = true;
        }
        ViewUtils.setViewEnableWithAlpha(customSeekbar, z2);
        ViewUtils.setViewEnableWithAlpha(((ViewLayoutSettingCameraBinding) this.mBind).tvFormat, this.model.isFlightConnect.get());
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingCameraFragment$6 */
    static /* synthetic */ class C23136 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_GET_CONFIG_MENU_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SDCARD_STATE_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MANUAL_SETTING_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MANUAL_SETTING_EXPOSURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MANUAL_SETTING_ACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SET_FORMAT_SD_CARD_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_PHOTO_GPS_SUCCESS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_OPEN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_CLOSE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        switch (C23136.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                this.model.update();
                CameraCtrlPresenter.getInstance().getPhotoRecordGps();
                onFlightTypeDefine();
                break;
            case 2:
            case 3:
                this.model.updateManualWhiteBalance();
                this.model.update();
                break;
            case 4:
                this.model.updateAutoWhiteBalance();
                break;
            case 5:
                this.model.updateManualWhiteBalance();
                break;
            case 6:
                this.model.update(FlightRevData.get().getFlightRevStateData());
                break;
            case 7:
                this.model.formatSuccess();
                break;
            case 8:
                if (!FlightConfig.isConnectFlight()) {
                    this.model.reset();
                    break;
                }
                break;
            case 9:
                this.model.update();
                break;
            case 10:
                onFlightTypeDefine();
                break;
            case 11:
                this.model.isTrackOpen.setValue(true);
                break;
            case 12:
                this.model.isTrackOpen.setValue(false);
                break;
        }
    }
}
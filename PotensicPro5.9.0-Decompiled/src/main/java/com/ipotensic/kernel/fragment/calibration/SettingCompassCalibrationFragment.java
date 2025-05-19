package com.ipotensic.kernel.fragment.calibration;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutCompassCalibrationBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.calibration.SettingCompassCalibrationModel;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.dialog.GeoCalResultDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.calibration.AtomMagCalibrationHelper;
import com.logan.flight.calibration.IMagCalibrationHelper;
import com.logan.flight.calibration.MiniMagCalibrationHelper;
import com.logan.flight.calibration.OnCalibrationResultListener;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevCalResultData;
import com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormal;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevMagCalibrationResultData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.utils.MagCalibrationResult;

/* loaded from: classes2.dex */
public class SettingCompassCalibrationFragment extends BaseKFragment<ViewLayoutCompassCalibrationBinding> {
    private static final int EXIT_TIME_FAIL = 15;
    private static final int EXIT_TIME_SUCCESS = 3;
    private AnimationDrawable animationDrawable;
    private int horizontalRes;
    private KernelViewModel kernelViewModel;
    private IMagCalibrationHelper miniMagCalibrationHelper;
    private SettingCompassCalibrationModel model;
    private int verticalRes;
    private final String TAG = "SettingCompassCalibrationFragment";
    private boolean isStartHorizontalCalibration = false;
    private boolean isStartVerticalCalibration = false;
    private boolean isResetCalibration = false;
    private boolean isCalibrating = false;
    private GeoCalResultDialog resultDialog = null;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.fragment.calibration.SettingCompassCalibrationFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.arg1;
            ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).tvCountDown.setText(String.format(SettingCompassCalibrationFragment.this.getString(R.string.exiting), Integer.valueOf(i)));
            if (i <= 0) {
                SettingCompassCalibrationFragment.this.kernelViewModel.getCompassCalibrate().setValue(false);
                return;
            }
            Message obtain = Message.obtain();
            obtain.arg1 = i - 1;
            SettingCompassCalibrationFragment.this.handler.sendMessageDelayed(obtain, 1000L);
        }
    };

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    public void showResultDialog(MagCalibrationResult magCalibrationResult) {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.view_layout_compass_calibration;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingCompassCalibrationModel(new SettingCompassCalibrationModel.OnCalibrationListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingCompassCalibrationFragment$q0CIwG92aL79qddnQUFpfRki9eA
            @Override // com.ipotensic.kernel.model.calibration.SettingCompassCalibrationModel.OnCalibrationListener
            public final void startCalibration() {
                SettingCompassCalibrationFragment.this.lambda$initData$0$SettingCompassCalibrationFragment();
            }
        });
        ((ViewLayoutCompassCalibrationBinding) this.mBind).setCompassCalibrationModel(this.model);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutCompassCalibrationBinding) this.mBind).btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingCompassCalibrationFragment$78dM5_V1bXGHAkTTzNND7lfXVgs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingCompassCalibrationFragment.this.lambda$initListener$1$SettingCompassCalibrationFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$1$SettingCompassCalibrationFragment(View view) {
        if (this.isCalibrating) {
            ToastUtil.showImageTop(getActivity(), getString(R.string.toast_calibration_close), R.mipmap.icon_gyroscope_galibration);
        } else {
            this.kernelViewModel.getCompassCalibrate().setValue(false);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.model.setCompassHeight();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        resetMiniCalibrationUI();
    }

    /* renamed from: com.ipotensic.kernel.fragment.calibration.SettingCompassCalibrationFragment$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_FLIGHT_CTRL_TO_APP_NORMAL_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MAG_CALIBRATION_RESULT_DATA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass3.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            FlightRevGeoTestData flightRevGeoTestData = (FlightRevGeoTestData) event.obj;
            IMagCalibrationHelper iMagCalibrationHelper = this.miniMagCalibrationHelper;
            if (iMagCalibrationHelper == null || !iMagCalibrationHelper.isStart()) {
                return;
            }
            try {
                this.miniMagCalibrationHelper.calibration(flightRevGeoTestData);
                return;
            } catch (Exception e) {
                DDLog.e("SettingCompassCalibrationFragment", "校准结果报错:" + e.getMessage());
                return;
            }
        }
        if (i == 2) {
            FlightRevCalResultData flightRevCalResultData = (FlightRevCalResultData) event.obj;
            IMagCalibrationHelper iMagCalibrationHelper2 = this.miniMagCalibrationHelper;
            if (iMagCalibrationHelper2 != null) {
                iMagCalibrationHelper2.revData(flightRevCalResultData);
                return;
            }
            return;
        }
        if (i == 3) {
            IMagCalibrationHelper iMagCalibrationHelper3 = this.miniMagCalibrationHelper;
            if (iMagCalibrationHelper3 != null) {
                iMagCalibrationHelper3.revData((FlightRevFlightCtrlToAppNormal) event.obj);
                return;
            }
            return;
        }
        if (i == 4) {
            IMagCalibrationHelper iMagCalibrationHelper4 = this.miniMagCalibrationHelper;
            if (iMagCalibrationHelper4 != null) {
                iMagCalibrationHelper4.revData((FlightRevMagCalibrationResultData) event.obj);
                return;
            }
            return;
        }
        if (i == 5 && !((Boolean) event.obj).booleanValue()) {
            dismissResultDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: beginCalibration, reason: merged with bridge method [inline-methods] */
    public void lambda$initData$0$SettingCompassCalibrationFragment() {
        if (getActivity() == null) {
            return;
        }
        this.isResetCalibration = false;
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        if (!flightRevStateData.isOutdoor()) {
            ToastUtil.toast(getActivity(), getString(R.string.settings_calibration_compass_calibration_failed_tips_outside_calibrate));
            return;
        }
        if (flightRevStateData.isGeomagneticFault()) {
            ToastUtil.toast(getActivity(), getString(R.string.error_geo_fault));
            return;
        }
        if (!flightRevStateData.isUnLock() && !flightRevStateData.isFlight()) {
            IMagCalibrationHelper iMagCalibrationHelper = this.miniMagCalibrationHelper;
            if (iMagCalibrationHelper != null) {
                iMagCalibrationHelper.release();
                this.miniMagCalibrationHelper.setCalibrationResultListener(null);
            }
            if (Conditions.isNewMagCalSystem()) {
                this.miniMagCalibrationHelper = new AtomMagCalibrationHelper();
            } else {
                this.miniMagCalibrationHelper = new MiniMagCalibrationHelper();
            }
            this.isCalibrating = false;
            if (FlightConfig.isAtomPanTilt()) {
                this.horizontalRes = R.drawable.anim_geo_horizontal_atom;
                this.verticalRes = R.drawable.anim_geo_vertical_atom;
            } else if (FlightConfig.isAtomLT()) {
                this.horizontalRes = R.drawable.anim_geo_horizontal_atomlt;
                this.verticalRes = R.drawable.anim_geo_vertical_atomlt;
            } else {
                this.horizontalRes = R.drawable.anim_geo_horizontal_mini;
                this.verticalRes = R.drawable.anim_geo_vertical_mini;
            }
            this.miniMagCalibrationHelper.setCalibrationResultListener(new OnCalibrationResultListener() { // from class: com.ipotensic.kernel.fragment.calibration.SettingCompassCalibrationFragment.2
                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onHorizontalCalibration() {
                    SettingCompassCalibrationFragment.this.isCalibrating = true;
                    if (SettingCompassCalibrationFragment.this.isStartHorizontalCalibration) {
                        return;
                    }
                    DDLog.e("SettingCompassCalibrationFragment", "开始水平校准");
                    EventDispatcher.get().sendEvent(EventID.AUDIO_START_HORIZONTAL_CALIBRATION);
                    SettingCompassCalibrationFragment.this.isStartHorizontalCalibration = true;
                    ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).tvCompassTitle.setText(SettingCompassCalibrationFragment.this.getString(R.string.compass_level_calibrate));
                    ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).tvMiniGeoStepTips.setText(SettingCompassCalibrationFragment.this.getString(R.string.dialog_geo_horizontal_tips));
                    SettingCompassCalibrationFragment.this.model.setViewVisible(1);
                    SettingCompassCalibrationFragment.this.model.setImageId(R.mipmap.icon_mini_geo_step_one);
                    ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).imgAtom.setImageResource(SettingCompassCalibrationFragment.this.horizontalRes);
                    SettingCompassCalibrationFragment settingCompassCalibrationFragment = SettingCompassCalibrationFragment.this;
                    settingCompassCalibrationFragment.animationDrawable = (AnimationDrawable) ((ViewLayoutCompassCalibrationBinding) settingCompassCalibrationFragment.mBind).imgAtom.getDrawable();
                    if (!SettingCompassCalibrationFragment.this.animationDrawable.isRunning()) {
                        SettingCompassCalibrationFragment.this.animationDrawable.start();
                    }
                    FlightConfig.isSettingCalibration = true;
                }

                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onVerticalCalibration() {
                    SettingCompassCalibrationFragment.this.isCalibrating = true;
                    if (SettingCompassCalibrationFragment.this.isStartVerticalCalibration) {
                        return;
                    }
                    DDLog.e("SettingCompassCalibrationFragment", "开始垂直校准");
                    ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).imgAtom.setImageResource(SettingCompassCalibrationFragment.this.verticalRes);
                    SettingCompassCalibrationFragment settingCompassCalibrationFragment = SettingCompassCalibrationFragment.this;
                    settingCompassCalibrationFragment.animationDrawable = (AnimationDrawable) ((ViewLayoutCompassCalibrationBinding) settingCompassCalibrationFragment.mBind).imgAtom.getDrawable();
                    if (!SettingCompassCalibrationFragment.this.animationDrawable.isRunning()) {
                        SettingCompassCalibrationFragment.this.animationDrawable.start();
                    }
                    SettingCompassCalibrationFragment.this.isStartVerticalCalibration = true;
                    EventDispatcher.get().sendEvent(EventID.AUDIO_START_VERTICAL_CALIBRATION);
                    ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).tvCompassTitle.setText(SettingCompassCalibrationFragment.this.getString(R.string.compass_vertical_calibration));
                    ((ViewLayoutCompassCalibrationBinding) SettingCompassCalibrationFragment.this.mBind).tvMiniGeoStepTips.setText(SettingCompassCalibrationFragment.this.getString(R.string.dialog_geo_vertical_tips));
                    SettingCompassCalibrationFragment.this.model.setImageId(R.mipmap.icon_mini_geo_step_two);
                }

                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onRequestTimeout() {
                    SettingCompassCalibrationFragment.this.isCalibrating = false;
                    SettingCompassCalibrationFragment.this.calibrateEnd(2);
                }

                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onResultSuccess(MagCalibrationResult magCalibrationResult) {
                    SettingCompassCalibrationFragment.this.isCalibrating = false;
                    SettingCompassCalibrationFragment.this.calibrateEnd(0);
                    SettingCompassCalibrationFragment.this.dismissLoadingDialog();
                    SettingCompassCalibrationFragment.this.showCalibrationResult(true);
                    SettingCompassCalibrationFragment.this.showResultDialog(magCalibrationResult);
                }

                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onResultFailed(MagCalibrationResult magCalibrationResult) {
                    SettingCompassCalibrationFragment.this.isCalibrating = false;
                    SettingCompassCalibrationFragment.this.calibrateEnd(1);
                    SettingCompassCalibrationFragment.this.showResultDialog(magCalibrationResult);
                }

                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onResultTimeout(MagCalibrationResult magCalibrationResult) {
                    SettingCompassCalibrationFragment.this.isCalibrating = false;
                    SettingCompassCalibrationFragment.this.calibrateEnd(1);
                    SettingCompassCalibrationFragment.this.showResultDialog(magCalibrationResult);
                }

                @Override // com.logan.flight.calibration.OnCalibrationResultListener
                public void onRelease() {
                    SettingCompassCalibrationFragment.this.isCalibrating = false;
                }
            });
            this.miniMagCalibrationHelper.start();
            return;
        }
        ToastUtil.toast(getActivity(), getString(R.string.txt_error_flighting_unavailable));
    }

    public void dismissResultDialog() {
        GeoCalResultDialog geoCalResultDialog = this.resultDialog;
        if (geoCalResultDialog == null || !geoCalResultDialog.isShowing()) {
            return;
        }
        this.resultDialog.dismiss();
        this.resultDialog = null;
    }

    public void calibrateEnd(int i) {
        DDLog.e("SettingCompassCalibrationFragment", "校准结果：" + i);
        this.model.setViewVisible(2);
        ((ViewLayoutCompassCalibrationBinding) this.mBind).tvFailNotice.setVisibility(i == 0 ? 8 : 0);
        this.model.setCalibrationResult(i == 0);
        if (i == 0) {
            ((ViewLayoutCompassCalibrationBinding) this.mBind).tvCompassTitle.setText(getString(R.string.calibration_successful));
            EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_SUCCESS);
            showLoadingDialog();
        } else {
            if (i == 1) {
                ((ViewLayoutCompassCalibrationBinding) this.mBind).tvFailNotice.setText(getString(R.string.settings_calibration_compass_calibration_failed_tips_magnetic_interference_detected));
            } else {
                ((ViewLayoutCompassCalibrationBinding) this.mBind).tvFailNotice.setText(getString(R.string.calibration_failed_tips_remote_controller_signal_weak));
            }
            ((ViewLayoutCompassCalibrationBinding) this.mBind).tvCompassTitle.setText(getString(R.string.calibration_failed));
            EventDispatcher.get().sendEvent(EventID.AUDIO_CALIBRATION_FAIL);
            showCalibrationResult(false);
        }
    }

    private void resetMiniCalibrationUI() {
        dismissLoadingDialog();
        if (this.isResetCalibration) {
            return;
        }
        this.isResetCalibration = true;
        DDLog.e("SettingCompassCalibrationFragment", "重置校准UI");
        FlightConfig.isSettingCalibration = false;
        this.isStartHorizontalCalibration = false;
        this.isStartVerticalCalibration = false;
        AnimationDrawable animationDrawable = this.animationDrawable;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.animationDrawable.stop();
            this.animationDrawable.selectDrawable(0);
        }
        IMagCalibrationHelper iMagCalibrationHelper = this.miniMagCalibrationHelper;
        if (iMagCalibrationHelper != null) {
            iMagCalibrationHelper.release();
            this.miniMagCalibrationHelper.setCalibrationResultListener(null);
        }
        this.model.setViewVisible(0);
        ((ViewLayoutCompassCalibrationBinding) this.mBind).tvCompassTitle.setText(getString(R.string.setting_compass_calibration));
        ((ViewLayoutCompassCalibrationBinding) this.mBind).imgAtom.setImageResource(R.drawable.anim_geo_horizontal_mini);
        ((ViewLayoutCompassCalibrationBinding) this.mBind).tvMiniGeoStepTips.setText(getString(R.string.dialog_geo_horizontal_tips));
        this.model.setImageId(R.mipmap.icon_mini_geo_step_one);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCalibrationResult(boolean z) {
        ((ViewLayoutCompassCalibrationBinding) this.mBind).ivCalibrationResult.animate().alpha(1.0f).setDuration(100L).start();
        AnimationDrawable animationDrawable = this.animationDrawable;
        if (animationDrawable != null && animationDrawable.isRunning()) {
            this.animationDrawable.stop();
            this.animationDrawable.selectDrawable(0);
        }
        sendCountDownMessage(z ? 3 : 15);
    }

    private void sendCountDownMessage(int i) {
        Message obtain = Message.obtain();
        obtain.arg1 = i;
        this.handler.sendMessage(obtain);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }
}

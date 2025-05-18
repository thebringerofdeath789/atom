package com.ipotensic.kernel.fragment.calibration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewLayoutRemoterControllerCalibrationBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.calibration.SettingRemoterCalibrationModel;
import com.ipotensic.kernel.test.BaseModelObservable;
import com.logan.flight.DataManager;
import com.logan.flight.data.recv.FlightRevRemoterCalibrationData;

/* loaded from: classes2.dex */
public class SettingRemoterCalibrationFragment extends BaseKFragment<ViewLayoutRemoterControllerCalibrationBinding> implements BaseModelObservable.OnPropertyChangeListener {
    private KernelViewModel kernelViewModel;
    private SettingRemoterCalibrationModel model;
    private FlightRevRemoterCalibrationData remoterCalibrationData;
    private final String TAG = "SettingRemoteControllerCalibrationFragment";
    private Boolean isExit = false;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.fragment.calibration.SettingRemoterCalibrationFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.arg1;
            ((ViewLayoutRemoterControllerCalibrationBinding) SettingRemoterCalibrationFragment.this.mBind).tvCountDown.setText(String.format(SettingRemoterCalibrationFragment.this.getString(C1965R.string.exiting), Integer.valueOf(i)));
            if (i <= 0) {
                SettingRemoterCalibrationFragment.this.quitAndExitActivity();
                return;
            }
            Message obtain = Message.obtain();
            obtain.arg1 = i - 1;
            SettingRemoterCalibrationFragment.this.handler.sendMessageDelayed(obtain, 1000L);
        }
    };

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_remoter_controller_calibration;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingRemoterCalibrationModel(getLifecycle(), this);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).setRemoterControllerModel(this.model);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewLeft.setLeftRocker(true);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewRight.setLeftRocker(false);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingRemoterCalibrationFragment$YuYa3vrK0DdDQd_coKh-H19nmrg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingRemoterCalibrationFragment.this.lambda$initListener$0$SettingRemoterCalibrationFragment(view);
            }
        });
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).btnStartCal.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingRemoterCalibrationFragment$sb4EM4cQqVEgR4h2Z6WvxrBFBO8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingRemoterCalibrationFragment.this.lambda$initListener$1$SettingRemoterCalibrationFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingRemoterCalibrationFragment(View view) {
        quitAndExitActivity();
    }

    public /* synthetic */ void lambda$initListener$1$SettingRemoterCalibrationFragment(View view) {
        DataManager.getInstance().openRemoterCalibration();
        showLoadingDialog();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DDLog.m1685e("SettingRemoteControllerCalibrationFragment", "onResume isExit" + this.isExit);
        if (this.isExit.booleanValue()) {
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewLeft.setLeftRocker(true);
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewRight.setLeftRocker(false);
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep1.setVisibility(0);
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep2.setVisibility(8);
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).clCalibrationResult.setVisibility(8);
        }
    }

    @Override // com.ipotensic.kernel.test.BaseModelObservable.OnPropertyChangeListener
    public void onPropertyChanged(Observable observable, int i) {
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).setRemoterControllerModel(this.model);
    }

    /* renamed from: com.ipotensic.kernel.fragment.calibration.SettingRemoterCalibrationFragment$2 */
    static /* synthetic */ class C23602 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_CALIBRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData;
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData2;
        super.onEvent(eventID, event);
        int i = C23602.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            DDLog.m1685e("SettingRemoteControllerCalibrationFragment", "遥控器校准结果: 飞机断开");
            quitAndExitActivity();
            return;
        }
        if (i != 2) {
            return;
        }
        FlightRevRemoterCalibrationData flightRevRemoterCalibrationData3 = (FlightRevRemoterCalibrationData) event.obj;
        if (flightRevRemoterCalibrationData3 != null) {
            DDLog.m1685e("SettingRemoteControllerCalibrationFragment", "遥控器校准结果:" + flightRevRemoterCalibrationData3.toString());
            if (flightRevRemoterCalibrationData3.isStep2() && flightRevRemoterCalibrationData3.isRockerMove()) {
                setAlpha(true);
            }
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewLeft.setProgress(flightRevRemoterCalibrationData3);
            ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewRight.setProgress(flightRevRemoterCalibrationData3);
            setWheelState(flightRevRemoterCalibrationData3);
            if (flightRevRemoterCalibrationData3.isStep2()) {
                dismissLoadingDialog();
                if (((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep2.getVisibility() != 0) {
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep1.setVisibility(8);
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep2.setVisibility(0);
                }
            }
            if (flightRevRemoterCalibrationData3.isStep0() && flightRevRemoterCalibrationData3.isCalSuccess() && ((flightRevRemoterCalibrationData2 = this.remoterCalibrationData) == null || !flightRevRemoterCalibrationData2.isCalSuccess())) {
                this.model.setCalibrationResult(true);
                ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).tvResultTitle.setText(C1965R.string.calibration_successful);
                if (((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).clCalibrationResult.getVisibility() != 0) {
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).ivCalibrationResult.animate().alpha(1.0f).setDuration(100L).start();
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep2.setVisibility(8);
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).clCalibrationResult.setVisibility(0);
                }
                sendCountDownMessage();
            }
            if (flightRevRemoterCalibrationData3.isCalFailed() && ((flightRevRemoterCalibrationData = this.remoterCalibrationData) == null || !flightRevRemoterCalibrationData.isCalFailed())) {
                DDLog.m1685e("SettingRemoteControllerCalibrationFragment", "指南针校准  失败");
                this.model.setCalibrationResult(true);
                ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).tvResultTitle.setText(C1965R.string.calibration_failed);
                if (((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).clCalibrationResult.getVisibility() != 0) {
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).ivCalibrationResult.animate().alpha(1.0f).setDuration(100L).start();
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).layoutCalStep2.setVisibility(8);
                    ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).clCalibrationResult.setVisibility(0);
                }
                sendCountDownMessage();
            }
        }
        try {
            this.remoterCalibrationData = flightRevRemoterCalibrationData3.m2624clone();
        } catch (Exception e) {
            DDLog.m1685e("SettingRemoteControllerCalibrationFragment", "赋值失败:" + e.getMessage());
        }
    }

    private void sendCountDownMessage() {
        Message obtain = Message.obtain();
        obtain.arg1 = 3;
        this.handler.sendMessage(obtain);
    }

    private void setAlpha(boolean z) {
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewLeft.setGray(z);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).calRockerViewRight.setGray(z);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).tvRockerTips.setAlpha(z ? 0.2f : 1.0f);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).tvWheelTips.setAlpha(z ? 0.2f : 1.0f);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).imgWheelSegment.setAlpha(z ? 0.2f : 1.0f);
    }

    private void setWheelState(FlightRevRemoterCalibrationData flightRevRemoterCalibrationData) {
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).imgLeftWheel.setImageResource(flightRevRemoterCalibrationData.isLeftTrackWheelCalSuccess() ? C1965R.mipmap.img_bg_track_wheel_left_enable : C1965R.mipmap.img_bg_track_wheel_left_disable);
        ((ViewLayoutRemoterControllerCalibrationBinding) this.mBind).imgRightWheel.setImageResource(flightRevRemoterCalibrationData.isRightTrackWheelCalSuccess() ? C1965R.mipmap.img_bg_track_wheel_right_enable : C1965R.mipmap.img_bg_track_wheel_right_disable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitAndExitActivity() {
        DDLog.m1685e("SettingRemoteControllerCalibrationFragment", "quitAndExitActivity");
        this.kernelViewModel.getRemoterCalibrate().setValue(false);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.isExit = true;
        this.handler.removeCallbacksAndMessages(null);
        DataManager.getInstance().closeRemoterCalibration();
    }
}
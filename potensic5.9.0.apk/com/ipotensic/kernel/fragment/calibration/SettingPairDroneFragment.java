package com.ipotensic.kernel.fragment.calibration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewLayoutPairDroneAgainBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.calibration.SettingPairDroneModel;
import com.ipotensic.kernel.test.BaseModelObservable;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevMiniPairData;
import com.logan.flight.type.Flight;

/* loaded from: classes2.dex */
public class SettingPairDroneFragment extends BaseKFragment<ViewLayoutPairDroneAgainBinding> implements BaseModelObservable.OnPropertyChangeListener {
    private KernelViewModel kernelViewModel;
    private SettingPairDroneModel model;
    private boolean isGrantResult = false;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.fragment.calibration.SettingPairDroneFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                SettingPairDroneFragment.this.resetUI();
                return;
            }
            int i = message.arg1;
            ((ViewLayoutPairDroneAgainBinding) SettingPairDroneFragment.this.mBind).tvCountDown.setText(String.format(SettingPairDroneFragment.this.getString(C1965R.string.exiting), Integer.valueOf(i)));
            if (i <= 0) {
                SettingPairDroneFragment.this.kernelViewModel.getCompassCalibrate().setValue(false);
                return;
            }
            Message obtain = Message.obtain();
            obtain.arg1 = i - 1;
            SettingPairDroneFragment.this.handler.sendMessageDelayed(obtain, 1000L);
        }
    };

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_pair_drone_again;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingPairDroneModel(getLifecycle(), this);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).setPairDroneModel(this.model);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStep.setText(getString(FlightConfig.isAtomLT() ? C1965R.string.atom_lt_frequency_pairing_mode_tips1 : C1965R.string.mini_code_step_one));
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStepTwo.setText(getString(FlightConfig.isAtomLT() ? C1965R.string.atom_lt_frequency_pairing_mode_tips2 : C1965R.string.mini_code_step_two));
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutPairDroneAgainBinding) this.mBind).ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingPairDroneFragment$enM9Qul60SWTBKpTW8ngl-QwW7o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingPairDroneFragment.this.lambda$initListener$0$SettingPairDroneFragment(view);
            }
        });
        ((ViewLayoutPairDroneAgainBinding) this.mBind).ivClose2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingPairDroneFragment$2UI4vhfjjoZ0UeuAOBKLcwW67kM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingPairDroneFragment.this.lambda$initListener$1$SettingPairDroneFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingPairDroneFragment(View view) {
        this.kernelViewModel.getPairDrone().setValue(false);
    }

    public /* synthetic */ void lambda$initListener$1$SettingPairDroneFragment(View view) {
        this.kernelViewModel.getPairDrone().setValue(false);
    }

    @Override // com.ipotensic.kernel.test.BaseModelObservable.OnPropertyChangeListener
    public void onPropertyChanged(Observable observable, int i) {
        ((ViewLayoutPairDroneAgainBinding) this.mBind).setPairDroneModel(this.model);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DDLog.m1684e("开始对频");
        this.isGrantResult = false;
        int i = C1965R.drawable.gif_mini_pair;
        Flight remoterType = FlightRevData.get().getFlightRevFpvData().getRemoterType();
        if (remoterType != null) {
            if (FlightConfig.isAtomPanTilt(remoterType)) {
                i = C1965R.drawable.gif_atom_pair;
            } else if (FlightConfig.isAtomLT(remoterType)) {
                i = C1965R.drawable.gif_atomlt_pair;
            }
        }
        Glide.with(getActivity()).load(Integer.valueOf(i)).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(((ViewLayoutPairDroneAgainBinding) this.mBind).ivRepairGif);
    }

    /* renamed from: com.ipotensic.kernel.fragment.calibration.SettingPairDroneFragment$2 */
    static /* synthetic */ class C23582 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_MINI_PAIR_RESULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C23582.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (((FlightRevConnectData) event.obj).isRemoterConnected()) {
                    return;
                }
                resetUI();
                return;
            } else {
                if (i == 3 && !UsbConfig.isUsbConnected) {
                    resetUI();
                    return;
                }
                return;
            }
        }
        FlightRevMiniPairData flightRevMiniPairData = (FlightRevMiniPairData) event.obj;
        DDLog.m1684e("对频------结果: " + flightRevMiniPairData.isPairSuccess());
        if (flightRevMiniPairData.isPairSuccess()) {
            DataManager.getInstance().requestFpvInfo();
            if (this.isGrantResult) {
                return;
            }
            this.isGrantResult = true;
            ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStep.setText(getString(C1965R.string.repair_will_complete));
            ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStep.setCompoundDrawables(null, null, null, null);
            ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStepTwo.setVisibility(8);
            this.handler.sendEmptyMessageDelayed(1, 4000L);
            return;
        }
        if (this.isGrantResult) {
            return;
        }
        DDLog.m1684e("对频失败");
        this.isGrantResult = true;
        ((ViewLayoutPairDroneAgainBinding) this.mBind).clStartPair.setVisibility(8);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).clPairResult.setVisibility(0);
        sendCountDownMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUI() {
        this.isGrantResult = false;
        ((ViewLayoutPairDroneAgainBinding) this.mBind).clStartPair.setVisibility(0);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).clPairResult.setVisibility(8);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStep.setText(getString(FlightConfig.isAtomLT() ? C1965R.string.atom_lt_frequency_pairing_mode_tips1 : C1965R.string.mini_code_step_one));
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStep.setCompoundDrawablesWithIntrinsicBounds(C1965R.mipmap.img_code_step_one, 0, 0, 0);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStepTwo.setCompoundDrawablesWithIntrinsicBounds(C1965R.mipmap.img_code_step_two, 0, 0, 0);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStepTwo.setVisibility(0);
        ((ViewLayoutPairDroneAgainBinding) this.mBind).tvCodeStepTwo.setText(getString(FlightConfig.isAtomLT() ? C1965R.string.atom_lt_frequency_pairing_mode_tips2 : C1965R.string.mini_code_step_two));
        this.kernelViewModel.getPairDrone().setValue(false);
    }

    private void sendCountDownMessage() {
        Message obtain = Message.obtain();
        obtain.arg1 = 10;
        this.handler.sendMessage(obtain);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }
}
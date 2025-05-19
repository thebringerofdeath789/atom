package com.ipotensic.kernel.fragment.calibration;

import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutGimbalFineTuningBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.calibration.SettingGimbalFineTuningModel;
import com.ipotensic.kernel.test.BaseModelObservable;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.TimedPhotoUploadData;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.h264.H264Player;
import com.logan.rtsp.OnYuvListener;

/* loaded from: classes2.dex */
public class SettingGimbalFineTuningFragment extends BaseKFragment<ViewLayoutGimbalFineTuningBinding> implements BaseModelObservable.OnPropertyChangeListener {
    private KernelViewModel kernelViewModel;
    private SettingGimbalFineTuningModel model;
    private final OnYuvListener yuvListener = new OnYuvListener() { // from class: com.ipotensic.kernel.fragment.calibration.SettingGimbalFineTuningFragment.1
        @Override // com.logan.rtsp.OnYuvListener
        public void onYuv(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            ((ViewLayoutGimbalFineTuningBinding) SettingGimbalFineTuningFragment.this.mBind).viewVideo.setYUVData(i, i2, bArr, bArr2, bArr3);
        }
    };

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.view_layout_gimbal_fine_tuning;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingGimbalFineTuningModel(getActivity());
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        ((ViewLayoutGimbalFineTuningBinding) this.mBind).setGimbalFineTuningModel(this.model);
        if (FlightRevData.get().getGimbalSettingData().isInit()) {
            this.model.update(FlightRevData.get().getGimbalSettingData());
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutGimbalFineTuningBinding) this.mBind).etLevelValue.setKeyboardListener(getActivity(), ((ViewLayoutGimbalFineTuningBinding) this.mBind).getRoot());
        ((ViewLayoutGimbalFineTuningBinding) this.mBind).etYawValue.setKeyboardListener(getActivity(), ((ViewLayoutGimbalFineTuningBinding) this.mBind).getRoot());
        ((ViewLayoutGimbalFineTuningBinding) this.mBind).btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingGimbalFineTuningFragment$EER8jUDjUP_Bulc8Buh_Bg1K_oM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingGimbalFineTuningFragment.this.lambda$initListener$0$SettingGimbalFineTuningFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingGimbalFineTuningFragment(View view) {
        this.kernelViewModel.getGimbalAdjustment().setValue(false);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        this.kernelViewModel.getPhotoChildModeData().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingGimbalFineTuningFragment$Yswwc7Hf2vgn8uvVlcaB06uZdn4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingGimbalFineTuningFragment.this.lambda$initObserver$1$SettingGimbalFineTuningFragment((PhotoChildMode) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$1$SettingGimbalFineTuningFragment(PhotoChildMode photoChildMode) {
        if (photoChildMode.isTimeTaking) {
            ((ViewLayoutGimbalFineTuningBinding) this.mBind).tvCountDown.setVisibility(0);
        } else {
            ((ViewLayoutGimbalFineTuningBinding) this.mBind).tvCountDown.setVisibility(8);
        }
    }

    /* renamed from: com.ipotensic.kernel.fragment.calibration.SettingGimbalFineTuningFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GIMBAL_SETTING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_CONNECT_STATE_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_TIMED_PHOTO_UPLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass2.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (FlightRevData.get().getGimbalSettingData().isInit()) {
                this.model.update(FlightRevData.get().getGimbalSettingData());
            }
        } else {
            if (i == 2) {
                this.kernelViewModel.getGimbalAdjustment().setValue(false);
                return;
            }
            if (i == 3) {
                if (FlightConfig.isConnectFlight()) {
                    return;
                }
                this.kernelViewModel.getGimbalAdjustment().setValue(false);
            } else {
                if (i != 4) {
                    return;
                }
                ((ViewLayoutGimbalFineTuningBinding) this.mBind).tvCountDown.setText(((TimedPhotoUploadData) event.obj).getCountDownString());
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H264Player.addYuvListener(this.yuvListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H264Player.removeYuvListener(this.yuvListener);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        H264Player.removeYuvListener(this.yuvListener);
    }

    @Override // com.ipotensic.kernel.test.BaseModelObservable.OnPropertyChangeListener
    public void onPropertyChanged(Observable observable, int i) {
        ((ViewLayoutGimbalFineTuningBinding) this.mBind).setGimbalFineTuningModel(this.model);
    }
}

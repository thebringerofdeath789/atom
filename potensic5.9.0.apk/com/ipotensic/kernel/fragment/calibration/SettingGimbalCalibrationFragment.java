package com.ipotensic.kernel.fragment.calibration;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewLayoutGimbalCalibrationBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.calibration.SettingGimbalCalibrationModel;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.TimedPhotoUploadData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;
import com.logan.h264.H264Player;
import com.logan.rtsp.OnYuvListener;

/* loaded from: classes2.dex */
public class SettingGimbalCalibrationFragment extends BaseKFragment<ViewLayoutGimbalCalibrationBinding> {
    private static final int COUNT_DOWN_TIME = 5;
    private KernelViewModel kernelViewModel;
    private SettingGimbalCalibrationModel model;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.fragment.calibration.SettingGimbalCalibrationFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.arg1;
            if (i <= 0) {
                SettingGimbalCalibrationFragment.this.kernelViewModel.getGimbalCalibrate().setValue(false);
                SettingGimbalCalibrationFragment.this.kernelViewModel.getCloseSetting().setValue(null);
            } else {
                SettingGimbalCalibrationFragment.this.model.resultStr.set(SettingGimbalCalibrationFragment.this.getString(C1965R.string.calibration_successful_wait_reboot) + "  (" + i + "s)");
                Message obtain = Message.obtain();
                obtain.arg1 = i - 1;
                sendMessageDelayed(obtain, 1000L);
            }
        }
    };
    private final OnYuvListener yuvListener = new OnYuvListener() { // from class: com.ipotensic.kernel.fragment.calibration.SettingGimbalCalibrationFragment.2
        @Override // com.logan.rtsp.OnYuvListener
        public void onYuv(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            ((ViewLayoutGimbalCalibrationBinding) SettingGimbalCalibrationFragment.this.mBind).viewVideo.setYUVData(i, i2, bArr, bArr2, bArr3);
        }
    };

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_gimbal_calibration;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingGimbalCalibrationModel(getActivity(), (ViewLayoutGimbalCalibrationBinding) this.mBind);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        ((ViewLayoutGimbalCalibrationBinding) this.mBind).setGimbalCalibrationModel(this.model);
        this.model.resetUI(false);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutGimbalCalibrationBinding) this.mBind).btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingGimbalCalibrationFragment$7Mxk-i0i5uFjixdOdusjiUHjCmY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingGimbalCalibrationFragment.this.lambda$initListener$0$SettingGimbalCalibrationFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingGimbalCalibrationFragment(View view) {
        this.kernelViewModel.getGimbalCalibrate().setValue(false);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        this.kernelViewModel.getPhotoChildModeData().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingGimbalCalibrationFragment$D8ZDyuC-YE5F0TzLWJUJhdsY9BI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingGimbalCalibrationFragment.this.lambda$initObserver$1$SettingGimbalCalibrationFragment((PhotoChildMode) obj);
            }
        });
        this.model.calibrateResult.observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingGimbalCalibrationFragment$0JgTuvOZOimsL_ck-c-lrcbeDHk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingGimbalCalibrationFragment.this.lambda$initObserver$2$SettingGimbalCalibrationFragment((Integer) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$1$SettingGimbalCalibrationFragment(PhotoChildMode photoChildMode) {
        if (photoChildMode.isTimeTaking) {
            ((ViewLayoutGimbalCalibrationBinding) this.mBind).tvCountDown.setVisibility(0);
        } else {
            ((ViewLayoutGimbalCalibrationBinding) this.mBind).tvCountDown.setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$initObserver$2$SettingGimbalCalibrationFragment(Integer num) {
        if (num.intValue() == 1) {
            Message obtain = Message.obtain();
            obtain.arg1 = 5;
            this.handler.sendMessage(obtain);
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
        this.handler.removeCallbacksAndMessages(null);
    }

    /* renamed from: com.ipotensic.kernel.fragment.calibration.SettingGimbalCalibrationFragment$3 */
    static /* synthetic */ class C23543 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GIMBAL_SETTING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_TIMED_PHOTO_UPLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C23543.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            this.model.update((FlightRevGimbalSettingData) event.obj);
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                ((ViewLayoutGimbalCalibrationBinding) this.mBind).tvCountDown.setText(((TimedPhotoUploadData) event.obj).getCountDownString());
                return;
            }
            if (UsbConfig.isUsbConnected) {
                return;
            }
            this.model.resetUI(true);
            this.kernelViewModel.getGimbalCalibrate().setValue(false);
        }
    }
}
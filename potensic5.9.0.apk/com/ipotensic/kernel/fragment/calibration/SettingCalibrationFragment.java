package com.ipotensic.kernel.fragment.calibration;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.activitys.MiniRepairActivity;
import com.ipotensic.kernel.databinding.ViewLayoutSettingCalibrationBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.view.CommonTitleView;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class SettingCalibrationFragment extends BaseKFragment<ViewLayoutSettingCalibrationBinding> implements View.OnClickListener {
    private KernelViewModel kernelViewModel;
    private final long PAIR_TIMEOUT = 3000;
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingCalibrationFragment$LKcNJoO05RGnUvwoLIoZ5xeTcfY
        @Override // java.lang.Runnable
        public final void run() {
            SettingCalibrationFragment.this.lambda$new$1$SettingCalibrationFragment();
        }
    };

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_setting_calibration;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutSettingCalibrationBinding) this.mBind).viewTitle.setListener(new CommonTitleView.OnClickListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingCalibrationFragment$S2IA_A_4ryIj3obudDeTTLOp5WA
            @Override // com.ipotensic.kernel.view.CommonTitleView.OnClickListener
            public final void onRightClick(View view) {
                SettingCalibrationFragment.this.lambda$initListener$0$SettingCalibrationFragment(view);
            }
        });
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvCalibration.setOnClickListener(this);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvGimbalCalibration.setOnClickListener(this);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvGimbalAdjustment.setOnClickListener(this);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvRemoterCalibration.setOnClickListener(this);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvPairDrone.setOnClickListener(this);
    }

    public /* synthetic */ void lambda$initListener$0$SettingCalibrationFragment(View view) {
        this.kernelViewModel.getCloseSetting().setValue(null);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        onFlightTypeDefine();
    }

    private void onFlightTypeDefine() {
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvGimbalCalibration.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).tvGimbalAdjustment.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).viewGimbalBg.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingCalibrationBinding) this.mBind).viewGimbalLine.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismissLoadingDialog();
        PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
    }

    /* renamed from: com.ipotensic.kernel.fragment.calibration.SettingCalibrationFragment$1 */
    static /* synthetic */ class C23481 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MINI_PAIR_RESULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C23481.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (FlightRevData.get().getFlightRevConnectData().isMiniPairing()) {
                dismissLoadingDialog();
                PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
                return;
            }
            return;
        }
        if (i == 2) {
            if (!FlightRevData.get().getMiniPairData().isInit() || FlightRevData.get().getMiniPairData().isPairSuccess()) {
                return;
            }
            dismissLoadingDialog();
            PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
            return;
        }
        if (i == 3) {
            dismissLoadingDialog();
            PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
        } else {
            if (i != 4) {
                return;
            }
            onFlightTypeDefine();
        }
    }

    public /* synthetic */ void lambda$new$1$SettingCalibrationFragment() {
        dismissLoadingDialog();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C1965R.id.tv_calibration) {
            this.kernelViewModel.getCompassCalibrate().setValue(true);
            return;
        }
        if (id == C1965R.id.tv_gimbal_calibration) {
            this.kernelViewModel.getGimbalCalibrate().setValue(true);
            return;
        }
        if (id == C1965R.id.tv_gimbal_adjustment) {
            this.kernelViewModel.getGimbalAdjustment().setValue(true);
            return;
        }
        if (id == C1965R.id.tv_remoter_calibration) {
            this.kernelViewModel.getRemoterCalibrate().setValue(true);
            return;
        }
        if (id == C1965R.id.tv_pair_drone) {
            int pairDroneAgain = this.kernelViewModel.pairDroneAgain();
            if (pairDroneAgain == -1) {
                showLoadingDialog();
                MiniRepairActivity.isStartPair = true;
                DataManager.getInstance().sendMiniPair();
                PhoneConfig.mainHandler.removeCallbacks(this.timeoutRunnable);
                PhoneConfig.mainHandler.postDelayed(this.timeoutRunnable, 3000L);
                Dialog loadingDialog = getLoadingDialog();
                if (loadingDialog != null) {
                    loadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.fragment.calibration.-$$Lambda$SettingCalibrationFragment$A_S14Ik1-oPT0SDIPVZBhQCr1PA
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            SettingCalibrationFragment.this.lambda$onClick$2$SettingCalibrationFragment(dialogInterface);
                        }
                    });
                    return;
                }
                return;
            }
            ToastUtil.toast(getActivity(), getString(pairDroneAgain));
        }
    }

    public /* synthetic */ void lambda$onClick$2$SettingCalibrationFragment(DialogInterface dialogInterface) {
        if (FlightRevData.get().getFlightRevConnectData().isMiniPairing()) {
            this.kernelViewModel.getPairDrone().setValue(true);
        }
    }
}
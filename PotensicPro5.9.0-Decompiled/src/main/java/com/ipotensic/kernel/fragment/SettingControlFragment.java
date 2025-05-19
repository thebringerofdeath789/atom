package com.ipotensic.kernel.fragment;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Observable;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingControlBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.SettingControlModel;
import com.ipotensic.kernel.test.BaseModelObservable;
import com.ipotensic.kernel.view.CommonTitleView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class SettingControlFragment extends BaseKFragment<ViewLayoutSettingControlBinding> implements BaseModelObservable.OnPropertyChangeListener {
    private KernelViewModel kernelViewModel;
    private SettingControlModel model;

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.view_layout_setting_control;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingControlModel(new SettingControlModel.OnSettingControlListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingControlFragment$8vEwMDeVgbnsF43ok-WfqjQYt84
            @Override // com.ipotensic.kernel.model.SettingControlModel.OnSettingControlListener
            public final void onToast(int i) {
                SettingControlFragment.this.lambda$initData$0$SettingControlFragment(i);
            }
        });
        ((ViewLayoutSettingControlBinding) this.mBind).setSettingControlModel(this.model);
        if (FlightRevData.get().getGimbalSettingData().isInit()) {
            this.model.update(FlightRevData.get().getGimbalSettingData());
        }
        if (FlightRevData.get().getGimbalStateData().isInit()) {
            this.model.update(FlightRevData.get().getGimbalStateData());
        }
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        ((ViewLayoutSettingControlBinding) this.mBind).layoutPitchAngle45.setVisibility(8);
        ((ViewLayoutSettingControlBinding) this.mBind).linePitchAngle45.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((ViewLayoutSettingControlBinding) this.mBind).layoutPitchAngle.getLayoutParams();
        layoutParams.matchConstraintPercentWidth = 0.33f;
        layoutParams.dimensionRatio = "6:1";
        ((ViewLayoutSettingControlBinding) this.mBind).layoutPitchAngle.setLayoutParams(layoutParams);
        onFlightTypeDefine();
    }

    public /* synthetic */ void lambda$initData$0$SettingControlFragment(int i) {
        ToastUtil.toast(getActivity(), getString(i));
    }

    private void onFlightTypeDefine() {
        ((ViewLayoutSettingControlBinding) this.mBind).tvGimbalSetting.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
        ((ViewLayoutSettingControlBinding) this.mBind).groutGimbal.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutSettingControlBinding) this.mBind).edtSpeed.setKeyboardListener(getActivity(), ((ViewLayoutSettingControlBinding) this.mBind).getRoot());
        ((ViewLayoutSettingControlBinding) this.mBind).edtSmooth.setKeyboardListener(getActivity(), ((ViewLayoutSettingControlBinding) this.mBind).getRoot());
        ((ViewLayoutSettingControlBinding) this.mBind).viewTitle.setListener(new CommonTitleView.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingControlFragment$Tie7uCoSKOdOWfqDRru5wHTRYNs
            @Override // com.ipotensic.kernel.view.CommonTitleView.OnClickListener
            public final void onRightClick(View view) {
                SettingControlFragment.this.lambda$initListener$1$SettingControlFragment(view);
            }
        });
        ((ViewLayoutSettingControlBinding) this.mBind).tvStickMode.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingControlFragment$ERyUe9qjbcn00fPurRcBdJ9zpm0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingControlFragment.this.lambda$initListener$2$SettingControlFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$1$SettingControlFragment(View view) {
        this.kernelViewModel.getCloseSetting().setValue(null);
    }

    public /* synthetic */ void lambda$initListener$2$SettingControlFragment(View view) {
        this.kernelViewModel.getStickMode().setValue(true);
    }

    public void updateSpeed() {
        if (this.mBind == 0) {
            return;
        }
        int curValue = ((ViewLayoutSettingControlBinding) this.mBind).edtSpeed.getCurValue();
        if (curValue != this.model.pitchSpeed.get()) {
            this.model.setPitchSpeed(curValue);
        }
        int curValue2 = ((ViewLayoutSettingControlBinding) this.mBind).edtSmooth.getCurValue();
        if (curValue2 != this.model.fpvSmooth.get()) {
            this.model.setFpvSmooth(curValue2);
        }
        this.model.sendSetting();
    }

    @Override // com.ipotensic.kernel.test.BaseModelObservable.OnPropertyChangeListener
    public void onPropertyChanged(Observable observable, int i) {
        ((ViewLayoutSettingControlBinding) this.mBind).setSettingControlModel(this.model);
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingControlFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GIMBAL_SETTING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_GIMBAL_STATE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 3;
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
        int i = AnonymousClass1.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            this.model.update(FlightRevData.get().getGimbalSettingData());
            return;
        }
        if (i == 2) {
            this.model.update(FlightRevData.get().getGimbalStateData());
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            onFlightTypeDefine();
        } else {
            this.model.isConnectFlight.set(FlightConfig.isConnectFlight());
            if (FlightConfig.isConnectFlight()) {
                return;
            }
            this.model.reset();
        }
    }
}

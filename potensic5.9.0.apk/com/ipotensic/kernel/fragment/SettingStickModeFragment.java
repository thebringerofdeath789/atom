package com.ipotensic.kernel.fragment;

import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingStickModeBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.SettingStickModeModel;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class SettingStickModeFragment extends BaseKFragment<ViewLayoutSettingStickModeBinding> {
    private KernelViewModel kernelViewModel;
    private SettingStickModeModel model;

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return C1965R.layout.view_layout_setting_stick_mode;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.model = new SettingStickModeModel(getContext());
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        ((ViewLayoutSettingStickModeBinding) this.mBind).setSettingStickMode(this.model);
        if (FlightRevData.get().getFlightRevSettingData().isInit()) {
            this.model.update(FlightRevData.get().getFlightRevSettingData());
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutSettingStickModeBinding) this.mBind).ibBack.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingStickModeFragment$3X1kCwOAloAq_q3h3TRDFFngUZU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingStickModeFragment.this.lambda$initListener$0$SettingStickModeFragment(view);
            }
        });
        ((ViewLayoutSettingStickModeBinding) this.mBind).btnExit.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingStickModeFragment$H7sPUbgBIYpwvJBtnmFPNfmV6D4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingStickModeFragment.this.lambda$initListener$1$SettingStickModeFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingStickModeFragment(View view) {
        this.kernelViewModel.getStickMode().setValue(false);
    }

    public /* synthetic */ void lambda$initListener$1$SettingStickModeFragment(View view) {
        this.kernelViewModel.getCloseSetting().setValue(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.model.onPause();
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingStickModeFragment$1 */
    static /* synthetic */ class C23351 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_SETTING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = C23351.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            this.model.update(FlightRevData.get().getFlightRevSettingData());
        } else if (i == 2 && !FlightConfig.isConnectFlight()) {
            this.model.onPause();
        }
    }
}
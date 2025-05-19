package com.ipotensic.kernel.fragment;

import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ViewLayoutSettingAboutBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.model.SettingAboutModel;
import com.ipotensic.kernel.test.BaseModelObservable;
import com.ipotensic.kernel.view.CommonTitleView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class SettingAboutFragment extends BaseKFragment<ViewLayoutSettingAboutBinding> implements BaseModelObservable.OnPropertyChangeListener {
    private KernelViewModel kernelViewModel;
    private SettingAboutModel settingAboutModel;

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.view_layout_setting_about;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
        ((ViewLayoutSettingAboutBinding) this.mBind).viewTitle.setListener(new CommonTitleView.OnClickListener() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingAboutFragment$9LTxMvQVlc0VvZha43UZiS0-N6I
            @Override // com.ipotensic.kernel.view.CommonTitleView.OnClickListener
            public final void onRightClick(View view) {
                SettingAboutFragment.this.lambda$initListener$0$SettingAboutFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initListener$0$SettingAboutFragment(View view) {
        this.kernelViewModel.getCloseSetting().setValue(null);
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.settingAboutModel = new SettingAboutModel();
        ((ViewLayoutSettingAboutBinding) this.mBind).setSettingAboutModel(this.settingAboutModel);
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(getActivity()).get(KernelViewModel.class);
        this.settingAboutModel.update();
        showBigPackageVersion();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        this.kernelViewModel.getGetBigPackageVersion().observe(this, new Observer() { // from class: com.ipotensic.kernel.fragment.-$$Lambda$SettingAboutFragment$3aKsuaHutAYXYlbegapxyWYS-r8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SettingAboutFragment.this.lambda$initObserver$1$SettingAboutFragment((Void) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$1$SettingAboutFragment(Void r1) {
        showBigPackageVersion();
    }

    private void showBigPackageVersion() {
        ((ViewLayoutSettingAboutBinding) this.mBind).tvBigPackageVersion.setVisibility(8);
    }

    /* renamed from: com.ipotensic.kernel.fragment.SettingAboutFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.EVENT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_SETTING_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_FPV_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_VERSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_CONFIG_MENU_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        switch (AnonymousClass1.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
            case 2:
                if (!FlightConfig.isConnectFlight()) {
                    this.settingAboutModel.onFlightDisconnect();
                }
                if (!FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
                    this.settingAboutModel.onRemoterDisconnect();
                }
                showBigPackageVersion();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                this.settingAboutModel.update();
                break;
            case 8:
                ((ViewLayoutSettingAboutBinding) this.mBind).llGimbalVersion.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
                ((ViewLayoutSettingAboutBinding) this.mBind).llEscVersion.setVisibility((FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) ? 8 : 0);
                break;
        }
    }

    @Override // com.ipotensic.kernel.test.BaseModelObservable.OnPropertyChangeListener
    public void onPropertyChanged(Observable observable, int i) {
        ((ViewLayoutSettingAboutBinding) this.mBind).setSettingAboutModel(this.settingAboutModel);
    }
}

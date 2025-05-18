package com.ipotensic.kernel.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.base.BaseKFragment;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.DroneNoticeBean;
import com.ipotensic.kernel.bean.ErrorCode;
import com.ipotensic.kernel.databinding.FragmentFriendlyTipsBinding;
import com.ipotensic.kernel.model.KernelViewModel;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevNoFlyZone;
import com.logan.flight.data.recv.FlightRevStateData;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FriendlyTipsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/ipotensic/kernel/fragment/FriendlyTipsFragment;", "Lcom/ipotensic/baselib/base/BaseKFragment;", "Lcom/ipotensic/kernel/databinding/FragmentFriendlyTipsBinding;", "()V", "kernelViewModel", "Lcom/ipotensic/kernel/model/KernelViewModel;", "closeLongTip", "", "getLayoutId", "", "initData", "initListener", "initObserver", "onDestroy", "onEvent", "what", "Lcom/ipotensic/baselib/dispatcher/EventID;", NotificationCompat.CATEGORY_EVENT, "Lcom/ipotensic/baselib/dispatcher/Event;", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FriendlyTipsFragment extends BaseKFragment<FragmentFriendlyTipsBinding> {
    private static final String TAG = "FriendlyTipsFragment";
    private HashMap _$_findViewCache;
    private KernelViewModel kernelViewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventID.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            iArr[EventID.FLIGHT_RECEIVE_NO_FLY_ZONE_DATA.ordinal()] = 2;
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initListener() {
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public int getLayoutId() {
        return R.layout.fragment_friendly_tips;
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initData() {
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(requireActivity()).get(KernelViewModel.class);
        closeLongTip();
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment
    public void initObserver() {
        KernelViewModel kernelViewModel = this.kernelViewModel;
        if (kernelViewModel == null) {
            Intrinsics.throwNpe();
        }
        FriendlyTipsFragment friendlyTipsFragment = this;
        kernelViewModel.getAddLongTip().observe(friendlyTipsFragment, new Observer<DroneNoticeBean>() { // from class: com.ipotensic.kernel.fragment.FriendlyTipsFragment$initObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(DroneNoticeBean droneNoticeBean) {
                FragmentFriendlyTipsBinding mBind;
                FragmentFriendlyTipsBinding mBind2;
                FragmentFriendlyTipsBinding mBind3;
                FragmentFriendlyTipsBinding mBind4;
                if (droneNoticeBean != null) {
                    mBind = FriendlyTipsFragment.this.getMBind();
                    RelativeLayout relativeLayout = mBind.rlLongTipRoot;
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "mBind.rlLongTipRoot");
                    if (relativeLayout.getVisibility() != 0) {
                        mBind4 = FriendlyTipsFragment.this.getMBind();
                        RelativeLayout relativeLayout2 = mBind4.rlLongTipRoot;
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "mBind.rlLongTipRoot");
                        relativeLayout2.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(droneNoticeBean.getParam())) {
                        mBind3 = FriendlyTipsFragment.this.getMBind();
                        TextView textView = mBind3.tvLongTipContent;
                        Intrinsics.checkExpressionValueIsNotNull(textView, "mBind.tvLongTipContent");
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = FriendlyTipsFragment.this.getString(droneNoticeBean.getErrorCode().getCodeName());
                        Intrinsics.checkExpressionValueIsNotNull(string, "getString(it.errorCode.codeName)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{droneNoticeBean.getParam()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        textView.setText(format);
                        return;
                    }
                    mBind2 = FriendlyTipsFragment.this.getMBind();
                    TextView textView2 = mBind2.tvLongTipContent;
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "mBind.tvLongTipContent");
                    textView2.setText(FriendlyTipsFragment.this.getString(droneNoticeBean.getErrorCode().getCodeName()));
                }
            }
        });
        KernelViewModel kernelViewModel2 = this.kernelViewModel;
        if (kernelViewModel2 == null) {
            Intrinsics.throwNpe();
        }
        kernelViewModel2.getRemoveLongTip().observe(friendlyTipsFragment, new Observer<DroneNoticeBean>() { // from class: com.ipotensic.kernel.fragment.FriendlyTipsFragment$initObserver$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(DroneNoticeBean droneNoticeBean) {
                KernelViewModel kernelViewModel3;
                FragmentFriendlyTipsBinding mBind;
                KernelViewModel kernelViewModel4;
                FragmentFriendlyTipsBinding mBind2;
                FragmentFriendlyTipsBinding mBind3;
                FragmentFriendlyTipsBinding mBind4;
                FragmentFriendlyTipsBinding mBind5;
                if (droneNoticeBean != null) {
                    kernelViewModel3 = FriendlyTipsFragment.this.kernelViewModel;
                    if (kernelViewModel3 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!kernelViewModel3.getLongTipList().isEmpty()) {
                        kernelViewModel4 = FriendlyTipsFragment.this.kernelViewModel;
                        if (kernelViewModel4 == null) {
                            Intrinsics.throwNpe();
                        }
                        kernelViewModel4.getLongTipList().get(0);
                        mBind2 = FriendlyTipsFragment.this.getMBind();
                        RelativeLayout relativeLayout = mBind2.rlLongTipRoot;
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "mBind.rlLongTipRoot");
                        if (relativeLayout.getVisibility() != 0) {
                            mBind5 = FriendlyTipsFragment.this.getMBind();
                            RelativeLayout relativeLayout2 = mBind5.rlLongTipRoot;
                            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "mBind.rlLongTipRoot");
                            relativeLayout2.setVisibility(0);
                        }
                        if (!TextUtils.isEmpty(droneNoticeBean.getParam())) {
                            mBind4 = FriendlyTipsFragment.this.getMBind();
                            TextView textView = mBind4.tvLongTipContent;
                            Intrinsics.checkExpressionValueIsNotNull(textView, "mBind.tvLongTipContent");
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = FriendlyTipsFragment.this.getString(droneNoticeBean.getErrorCode().getCodeName());
                            Intrinsics.checkExpressionValueIsNotNull(string, "getString(it.errorCode.codeName)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{droneNoticeBean.getParam()}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                            textView.setText(format);
                            return;
                        }
                        mBind3 = FriendlyTipsFragment.this.getMBind();
                        TextView textView2 = mBind3.tvLongTipContent;
                        Intrinsics.checkExpressionValueIsNotNull(textView2, "mBind.tvLongTipContent");
                        textView2.setText(FriendlyTipsFragment.this.getString(droneNoticeBean.getErrorCode().getCodeName()));
                        return;
                    }
                    mBind = FriendlyTipsFragment.this.getMBind();
                    RelativeLayout relativeLayout3 = mBind.rlLongTipRoot;
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "mBind.rlLongTipRoot");
                    relativeLayout3.setVisibility(8);
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID what, Event event) {
        Object obj;
        super.onEvent(what, event);
        if (what == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[what.ordinal()];
        if (i == 1) {
            if (FlightConfig.isConnectFlight()) {
                return;
            }
            closeLongTip();
            return;
        }
        if (i != 2 || event == null || (obj = event.obj) == null) {
            return;
        }
        if (obj != null) {
            FlightRevNoFlyZone flightRevNoFlyZone = (FlightRevNoFlyZone) obj;
            if (flightRevNoFlyZone.getIsLocatedNoFlyZone()) {
                FlightRevData flightRevData = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
                FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
                if (flightRevStateData.isLanding()) {
                    KernelViewModel kernelViewModel = this.kernelViewModel;
                    if (kernelViewModel == null) {
                        Intrinsics.throwNpe();
                    }
                    KernelViewModel.addDroneLongTip$default(kernelViewModel, ErrorCode.NOFLY_FORCED_LANDING_PROGRESS, null, 0, false, 14, null);
                } else {
                    KernelViewModel kernelViewModel2 = this.kernelViewModel;
                    if (kernelViewModel2 == null) {
                        Intrinsics.throwNpe();
                    }
                    kernelViewModel2.removeDroneLongTip(ErrorCode.NOFLY_FORCED_LANDING_PROGRESS);
                }
            } else {
                KernelViewModel kernelViewModel3 = this.kernelViewModel;
                if (kernelViewModel3 == null) {
                    Intrinsics.throwNpe();
                }
                kernelViewModel3.removeDroneLongTip(ErrorCode.NOFLY_FORCED_LANDING_PROGRESS);
            }
            if (flightRevNoFlyZone.getIsNearLocatedNoFlyZone()) {
                FlightRevData flightRevData2 = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
                FlightRevStateData flightRevStateData2 = flightRevData2.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData2, "FlightRevData.get().flightRevStateData");
                if (flightRevStateData2.isReturning()) {
                    KernelViewModel kernelViewModel4 = this.kernelViewModel;
                    if (kernelViewModel4 == null) {
                        Intrinsics.throwNpe();
                    }
                    KernelViewModel.addDroneLongTip$default(kernelViewModel4, ErrorCode.NOFLY_FORCED_RETURN_PROGRESS, null, 0, false, 14, null);
                } else {
                    KernelViewModel kernelViewModel5 = this.kernelViewModel;
                    if (kernelViewModel5 == null) {
                        Intrinsics.throwNpe();
                    }
                    kernelViewModel5.removeDroneLongTip(ErrorCode.NOFLY_FORCED_RETURN_PROGRESS);
                }
            } else {
                KernelViewModel kernelViewModel6 = this.kernelViewModel;
                if (kernelViewModel6 == null) {
                    Intrinsics.throwNpe();
                }
                kernelViewModel6.removeDroneLongTip(ErrorCode.NOFLY_FORCED_RETURN_PROGRESS);
            }
            if (flightRevNoFlyZone.getIsRestrictedZone()) {
                FlightRevData flightRevData3 = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData3, "FlightRevData.get()");
                FlightRevStateData flightRevStateData3 = flightRevData3.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData3, "FlightRevData.get().flightRevStateData");
                if (flightRevStateData3.isFlight()) {
                    FlightRevData flightRevData4 = FlightRevData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevData4, "FlightRevData.get()");
                    double status_2 = flightRevData4.getNoFlyZoneData().getStatus_2();
                    FlightRevData flightRevData5 = FlightRevData.get();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevData5, "FlightRevData.get()");
                    FlightRevFlightInfoData flightRevFlightInfoData = flightRevData5.getFlightRevFlightInfoData();
                    Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData, "FlightRevData.get().flightRevFlightInfoData");
                    if (status_2 < flightRevFlightInfoData.getVerticalDistance()) {
                        KernelViewModel kernelViewModel7 = this.kernelViewModel;
                        if (kernelViewModel7 == null) {
                            Intrinsics.throwNpe();
                        }
                        KernelViewModel.addDroneLongTip$default(kernelViewModel7, ErrorCode.ALTITUDE_EXCEEDED_HEIGHT_LIMIT, null, 0, false, 14, null);
                        return;
                    }
                }
            }
            KernelViewModel kernelViewModel8 = this.kernelViewModel;
            if (kernelViewModel8 == null) {
                Intrinsics.throwNpe();
            }
            kernelViewModel8.removeDroneLongTip(ErrorCode.ALTITUDE_EXCEEDED_HEIGHT_LIMIT);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.logan.flight.data.recv.FlightRevNoFlyZone");
    }

    @Override // com.ipotensic.baselib.base.BaseKFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        closeLongTip();
        super.onDestroy();
    }

    private final void closeLongTip() {
        RelativeLayout relativeLayout = getMBind().rlLongTipRoot;
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "mBind.rlLongTipRoot");
        relativeLayout.setVisibility(8);
    }
}
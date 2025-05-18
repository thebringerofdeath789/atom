package com.ipotensic.kernel.controllers;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.controllers.LeftController;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.utils.MapUtil;
import com.ipotensic.kernel.view.dialog.ForceTakeoffDialog;
import com.ipotensic.kernel.view.dialog.MiniLandSlideUnlockDialog;
import com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog;
import com.ipotensic.kernel.view.dialog.SlideUnlockDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class LeftController extends BaseController {
    public static final int SHOW_LAND_OR_GO_HOME_DIALOG_DISTANCE_LIMIT = 20;
    private ImageView ivFlySet;
    private ImageView ivGoHome;
    private ImageView ivTakeOff;
    private KernelViewModel kernelViewModel;
    private LeftControllerListener leftControllerListener;
    private Context mContext;
    private MiniTakeoffSlideUnlockDialog miniExitLandUnlockDialog;
    private MiniLandSlideUnlockDialog miniLandSlideUnlockDialog;
    private MiniTakeoffSlideUnlockDialog miniTakeoffSlideUnlockDialog;
    private SlideUnlockDialog slideUnlockDialog;

    public interface LeftControllerListener {
        void goHome();

        void goLand();

        void intelligentMode();

        void takeOff();
    }

    public LeftController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        setGoHomeBtnVisibility();
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(appCompatActivity).get(KernelViewModel.class);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.mContext = view.getContext();
        this.ivTakeOff = (ImageView) view.findViewById(R.id.iv_take_off);
        this.ivGoHome = (ImageView) view.findViewById(R.id.iv_go_home);
        this.ivFlySet = (ImageView) view.findViewById(R.id.iv_fly_set);
        setGoHomeBtnVisibility();
        if (!FlightConfig.isOldProduct()) {
            setIvTakeOffEnable(false, 0.4f);
        }
        this.ivTakeOff.setOnClickListener(new AnonymousClass1(1000));
        this.ivGoHome.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.controllers.LeftController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (SPHelper.getInstance().getGoHome()) {
                    SPHelper.getInstance().setGoHome(false);
                    NewbieGuide.with(LeftController.this.getContext()).addGuidePage(GuidePage.newInstance().addHighLight(LeftController.this.ivGoHome, new RelativeGuide(R.layout.guide_left, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.LeftController.2.1
                        @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                        public void onLayoutInflated(View view3, Controller controller) {
                            ((TextView) view3.findViewById(R.id.tv_view)).setText(LeftController.this.getContext().getResources().getString(R.string.guide_left_go_home));
                        }
                    }).setBackgroundColor(LeftController.this.getContext().getResources().getColor(R.color.color_guide_bg))).show();
                } else if (FlightRevData.get().getFlightRevStateData().isReturning()) {
                    new SlideUnlockDialog(LeftController.this.mContext, LeftController.this.mContext.getString(R.string.dialog_exit_go_home), LeftController.this.mContext.getString(R.string.dialog_exit_go_home_describe), new SlideUnlockDialog.SlideResultListener() { // from class: com.ipotensic.kernel.controllers.LeftController.2.2
                        @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
                        public void dealEvent() {
                            FlightSendData.get().setReturnMode();
                        }
                    }).show();
                } else {
                    new SlideUnlockDialog(LeftController.this.mContext, LeftController.this.mContext.getString(R.string.dialog_go_home), LeftController.this.mContext.getString(R.string.dialog_go_home_describe), new SlideUnlockDialog.SlideResultListener() { // from class: com.ipotensic.kernel.controllers.LeftController.2.3
                        @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
                        public void dealEvent() {
                            LeftController.this.leftControllerListener.goHome();
                        }
                    }).show();
                }
            }
        });
        this.ivFlySet.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.controllers.LeftController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (!SPHelper.getInstance().getIntelligentMode()) {
                    LeftController.this.leftControllerListener.intelligentMode();
                } else {
                    SPHelper.getInstance().setIntelligentMode(false);
                    NewbieGuide.with(LeftController.this.getContext()).addGuidePage(GuidePage.newInstance().addHighLight(LeftController.this.ivFlySet, new RelativeGuide(R.layout.guide_left, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.LeftController.3.1
                        @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                        public void onLayoutInflated(View view3, Controller controller) {
                            ((TextView) view3.findViewById(R.id.tv_view)).setText(LeftController.this.getContext().getResources().getString(R.string.guide_left_intelligent_mode));
                        }
                    }).setBackgroundColor(LeftController.this.getContext().getResources().getColor(R.color.color_guide_bg))).show();
                }
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.controllers.LeftController$1, reason: invalid class name */
    class AnonymousClass1 extends ScaleClickListener {
        AnonymousClass1(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (SPHelper.getInstance().getTakeOff()) {
                SPHelper.getInstance().setTakeOff(false);
                NewbieGuide.with(LeftController.this.getContext()).addGuidePage(GuidePage.newInstance().addHighLight(LeftController.this.ivTakeOff, new RelativeGuide(R.layout.guide_left, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.LeftController.1.1
                    @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                    public void onLayoutInflated(View view2, Controller controller) {
                        ((TextView) view2.findViewById(R.id.tv_view)).setText(LeftController.this.getContext().getResources().getString(R.string.guide_left_take_off));
                    }
                }).setBackgroundColor(LeftController.this.getContext().getResources().getColor(R.color.color_guide_bg))).show();
                return;
            }
            boolean z = FlightRevData.get().getFlightRevStateData().isTakeOff() || FlightRevData.get().getFlightRevStateData().isUnLock() || FlightRevData.get().getFlightRevStateData().isFlight();
            boolean isLanding = FlightRevData.get().getFlightRevStateData().isLanding();
            if (FlightConfig.isOldProduct()) {
                if (!z) {
                    new SlideUnlockDialog(LeftController.this.mContext, LeftController.this.getContext().getString(R.string.dialog_takeoff), LeftController.this.getContext().getString(R.string.dialog_takeoff_describe), new SlideUnlockDialog.SlideResultListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$rl0QR0k53psYyD1WNrgChbRGsU4
                        @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
                        public final void dealEvent() {
                            LeftController.AnonymousClass1.this.lambda$click$0$LeftController$1();
                        }
                    }).show();
                    return;
                } else if (!isLanding) {
                    new SlideUnlockDialog(LeftController.this.mContext, LeftController.this.getContext().getString(R.string.dialog_landing), LeftController.this.getContext().getString(R.string.dialog_landing_describe), new SlideUnlockDialog.SlideResultListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$llWMXwqFCmNvSsVQ1-zaXjvxBdQ
                        @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
                        public final void dealEvent() {
                            LeftController.AnonymousClass1.this.lambda$click$1$LeftController$1();
                        }
                    }).show();
                    return;
                } else {
                    new SlideUnlockDialog(LeftController.this.mContext, LeftController.this.getContext().getString(R.string.dialog_exit_landing), LeftController.this.getContext().getString(R.string.dialog_exit_landing_describe), new SlideUnlockDialog.SlideResultListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$sPDzpV63ovY-GIy0xayiYku2ziA
                        @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
                        public final void dealEvent() {
                            FlightSendData.get().setLaunch();
                        }
                    }).show();
                    return;
                }
            }
            int remainedBattery = FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery();
            if (z) {
                if (!isLanding) {
                    LeftController.this.miniLandSlideUnlockDialog = new MiniLandSlideUnlockDialog(LeftController.this.mContext, new MiniLandSlideUnlockDialog.SlideUnlockListener() { // from class: com.ipotensic.kernel.controllers.LeftController.1.2
                        @Override // com.ipotensic.kernel.view.dialog.MiniLandSlideUnlockDialog.SlideUnlockListener
                        public void onKeyLand() {
                            LeftController.this.leftControllerListener.goLand();
                        }

                        @Override // com.ipotensic.kernel.view.dialog.MiniLandSlideUnlockDialog.SlideUnlockListener
                        public void onKeyReturn() {
                            LeftController.this.leftControllerListener.goHome();
                        }
                    }, false);
                    LeftController.this.miniLandSlideUnlockDialog.show();
                    return;
                } else {
                    LeftController.this.miniExitLandUnlockDialog = new MiniTakeoffSlideUnlockDialog(LeftController.this.mContext, LeftController.this.getContext().getString(R.string.dialog_exit_landing), LeftController.this.getContext().getString(R.string.dialog_exit_landing_describe), false, true, new MiniTakeoffSlideUnlockDialog.SlideUnlockListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$IqZK17lZuOF6h7_07x8muPKG1v0
                        @Override // com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog.SlideUnlockListener
                        public final void takeOff(boolean z2) {
                            FlightSendData.get().setLaunch();
                        }
                    });
                    LeftController.this.miniExitLandUnlockDialog.show();
                    return;
                }
            }
            if (FlightConfig.isConnectFlight() && remainedBattery < 5) {
                DDLog.e("\u7535\u91cf\u4f4e\u4e8e5%\u4e0d\u53d1\u8d77\u98de\u547d\u4ee4");
                return;
            }
            if (FlightConfig.isConnectFlight() && remainedBattery < 20) {
                DDLog.e("\u7535\u91cf\u4f4e\u4e8e20%\u5f39\u5f3a\u5236\u8d77\u98de");
                new ForceTakeoffDialog(LeftController.this.getContext()).show();
            } else if (Conditions.isShowBatteryInstallSafetyDialog()) {
                if (LeftController.this.kernelViewModel != null) {
                    LeftController.this.kernelViewModel.getIsShowBatterySafetyDialog().set(true);
                }
            } else {
                LeftController.this.miniTakeoffSlideUnlockDialog = new MiniTakeoffSlideUnlockDialog(LeftController.this.mContext, LeftController.this.getContext().getString(R.string.dialog_mini_takeoff_title), LeftController.this.getContext().getString(R.string.dialog_mini_takeoff_content), true, true, new MiniTakeoffSlideUnlockDialog.SlideUnlockListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$jH_iWlO1phqC3QCKPfFCZtGAOg0
                    @Override // com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog.SlideUnlockListener
                    public final void takeOff(boolean z2) {
                        LeftController.AnonymousClass1.this.lambda$click$3$LeftController$1(z2);
                    }
                });
                LeftController.this.miniTakeoffSlideUnlockDialog.show();
            }
        }

        public /* synthetic */ void lambda$click$0$LeftController$1() {
            LeftController.this.leftControllerListener.takeOff();
        }

        public /* synthetic */ void lambda$click$1$LeftController$1() {
            LeftController.this.leftControllerListener.goLand();
        }

        public /* synthetic */ void lambda$click$3$LeftController$1(boolean z) {
            if (z) {
                DDLog.e("\u53d1\u9001\u4e00\u952e\u8d77\u98de");
                LeftController.this.leftControllerListener.takeOff();
            } else {
                DDLog.e("\u53d1\u9001\u4e00\u952e\u7740\u843d");
                LeftController.this.leftControllerListener.goLand();
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            if (getBaseView().getVisibility() != 0) {
                AnimationUtil.transInLeft(getBaseView());
            }
        } else if (getBaseView().getVisibility() == 0) {
            AnimationUtil.transOutLeft(getBaseView());
        }
    }

    public void setGoHomeBtnVisibility() {
        if (FlightConfig.getLastFlight() != null) {
            this.ivGoHome.setVisibility(FlightConfig.is_Atom_Series() ? 8 : 0);
            this.ivFlySet.setVisibility(FlightConfig.isAtomPanTilt() ? 8 : 0);
        }
    }

    private void setIvTakeOffEnable(boolean z, float f) {
        this.ivTakeOff.setEnabled(z);
        this.ivTakeOff.setClickable(z);
        this.ivTakeOff.setAlpha(f);
    }

    public void setUpDown(FlightRevStateData flightRevStateData) {
        MiniTakeoffSlideUnlockDialog miniTakeoffSlideUnlockDialog;
        this.ivTakeOff.setImageResource(flightRevStateData.isUnLock() ? R.mipmap.icon_take_landing : R.mipmap.icon_take_off);
        setIvTakeOffEnable(true, 1.0f);
        if (FlightConfig.isOldProduct() || (miniTakeoffSlideUnlockDialog = this.miniTakeoffSlideUnlockDialog) == null || !miniTakeoffSlideUnlockDialog.isShowing() || !flightRevStateData.isUnLock()) {
            return;
        }
        this.miniTakeoffSlideUnlockDialog.setTextChange(getContext().getString(R.string.dialog_landing), getContext().getString(R.string.dialog_landing_describe), false, true);
    }

    private void dialogDismiss() {
        MiniTakeoffSlideUnlockDialog miniTakeoffSlideUnlockDialog = this.miniTakeoffSlideUnlockDialog;
        if (miniTakeoffSlideUnlockDialog != null && miniTakeoffSlideUnlockDialog.isShowing()) {
            this.miniTakeoffSlideUnlockDialog.dismiss();
        }
        MiniTakeoffSlideUnlockDialog miniTakeoffSlideUnlockDialog2 = this.miniExitLandUnlockDialog;
        if (miniTakeoffSlideUnlockDialog2 != null && miniTakeoffSlideUnlockDialog2.isShowing()) {
            this.miniExitLandUnlockDialog.dismiss();
        }
        MiniLandSlideUnlockDialog miniLandSlideUnlockDialog = this.miniLandSlideUnlockDialog;
        if (miniLandSlideUnlockDialog != null && miniLandSlideUnlockDialog.isShowing() && this.miniLandSlideUnlockDialog.isShowing()) {
            this.miniLandSlideUnlockDialog.dismiss();
        }
    }

    public void setLeftControllerListener(LeftControllerListener leftControllerListener) {
        this.leftControllerListener = leftControllerListener;
    }

    /* renamed from: com.ipotensic.kernel.controllers.LeftController$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_TRACK_CLOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass4.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            setGoHomeBtnVisibility();
            return;
        }
        if (i == 2) {
            if (!((Boolean) event.obj).booleanValue()) {
                this.ivTakeOff.setImageResource(R.mipmap.icon_take_off);
                setIvTakeOffEnable(false, 0.4f);
                dialogDismiss();
            }
            ViewUtils.setViewEnableWithAlpha(this.ivFlySet, true);
            return;
        }
        if (i == 3) {
            ViewUtils.setViewEnableWithAlpha(this.ivFlySet, false);
        } else {
            if (i != 4) {
                return;
            }
            ViewUtils.setViewEnableWithAlpha(this.ivFlySet, true);
        }
    }

    private boolean needShowLandOrGoHomeDialog() {
        return Conditions.isGpsMode() && FlightConfig.is_Atom_Series();
    }

    private boolean validHomePoint() {
        FlightRevHomePointData flightRevHomePointData = FlightRevData.get().getFlightRevHomePointData();
        FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
        if (!flightRevHomePointData.valid() || !flightRevFlightInfoData.valid()) {
            return false;
        }
        double distance = MapUtil.distance(flightRevHomePointData.getLatLng(), flightRevFlightInfoData.getLatLng());
        return distance > 0.0d && distance < 20.0d;
    }
}
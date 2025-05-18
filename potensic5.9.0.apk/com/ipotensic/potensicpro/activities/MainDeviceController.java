package com.ipotensic.potensicpro.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.base.WebActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.State;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Builder;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.activitys.KernelActivity;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.kernel.services.OnLocationChangedListener;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.view.dialog.MiniPairDialog;
import com.ipotensic.kernel.view.dialog.MiniPairFailDialog;
import com.ipotensic.kernel.view.dialog.OpenGuideDialog;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.activities.MainDeviceController;
import com.ipotensic.potensicpro.view.ConnectStateView;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevMiniPairData;
import com.logan.flight.listeners.OnCloseListener;
import com.logan.flight.type.Flight;
import com.logan.usb.AOAEngine;
import javax.xml.transform.OutputKeys;

/* loaded from: classes2.dex */
public class MainDeviceController extends BaseController implements View.OnClickListener, AOAEngine.IEngineCallback, OnGuideChangedListener, OnLocationChangedListener {
    public final int REQUEST_DEVICE_CHOOSE;
    public final int REQUEST_FW_DOWNLOAD_CODE;
    public final int REQUEST_MENU_DISMISS;
    private Runnable animRun;
    private View bgEnterDevice;
    private TextView btnEnterDevice;
    private ImageButton btnMenu;
    private ImageButton btnMenuClose;
    private Group group;
    private Group groupAtom;
    private OpenGuideDialog guideDialog;
    private View guideModelSelect;
    private Handler handler;
    private boolean isAnimating;
    private boolean isPairing;
    private boolean isTopMenuDismiss;
    private ImageView ivCloseAtom;
    private ImageView ivDeviceType;
    private ImageView ivLogo;
    private ConstraintLayout layout_menu;
    private LinearLayout llTop;
    private MiniPairDialog miniPairDialog;
    private MiniPairFailDialog miniPairFailDialog;
    private int step;
    private TextView tvAircraftLogAtom;
    private TextView tvCheckUpgrade;
    private TextView tvChoose;
    private ConnectStateView tvDeviceState;
    private TextView tvFlightLog;
    private TextView tvFlightRecord;
    private TextView tvFlightRecordAtom;
    private TextView tvInstructions;
    private TextView tvVideoTeach;
    private View viewBlank;

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onGpsSystemClose() {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onGpsSystemOpen() {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onPhoneOrientationChanged(float f) {
    }

    @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
    public void onRemoved(Controller controller) {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onSatelliteCount(int i) {
    }

    @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
    public void onShowed(Controller controller) {
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onSystemLocationChanged(double d, double d2, float f) {
    }

    public MainDeviceController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.REQUEST_FW_DOWNLOAD_CODE = 101;
        this.REQUEST_DEVICE_CHOOSE = 102;
        this.REQUEST_MENU_DISMISS = 103;
        this.isTopMenuDismiss = true;
        this.isAnimating = false;
        this.handler = new Handler();
        this.animRun = new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MainDeviceController.this.tvDeviceState != null) {
                        MainDeviceController.this.tvDeviceState.onAnimResume();
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.ivLogo = (ImageView) view.findViewById(C2640R.id.iv_logo);
        this.guideModelSelect = view.findViewById(C2640R.id.guide_model_select);
        this.tvChoose = (TextView) view.findViewById(C2640R.id.tv_choose);
        this.llTop = (LinearLayout) view.findViewById(C2640R.id.ll_top);
        this.btnEnterDevice = (TextView) view.findViewById(C2640R.id.btn_enter_device);
        this.bgEnterDevice = view.findViewById(C2640R.id.view_enter_bg);
        ConnectStateView connectStateView = (ConnectStateView) view.findViewById(C2640R.id.tv_connect_state);
        this.tvDeviceState = connectStateView;
        connectStateView.setConnectStateListener(new ConnectStateView.OnConnectStateChangeListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$SPnKeAJwekGSrqeD5NGiUAcuPLM
            @Override // com.ipotensic.potensicpro.view.ConnectStateView.OnConnectStateChangeListener
            public final void onStateChanged(State state) {
                MainDeviceController.this.lambda$initView$0$MainDeviceController(state);
            }
        });
        ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_menu);
        this.btnMenu = imageButton;
        imageButton.setOnClickListener(this);
        this.btnMenuClose = (ImageButton) view.findViewById(C2640R.id.btn_menu_close);
        ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_close_atom);
        this.ivCloseAtom = imageView;
        imageView.setOnClickListener(this);
        this.btnMenuClose.setOnClickListener(this);
        View findViewById = view.findViewById(C2640R.id.view_blank);
        this.viewBlank = findViewById;
        findViewById.setOnClickListener(this);
        this.layout_menu = (ConstraintLayout) view.findViewById(C2640R.id.layout_menu);
        this.group = (Group) view.findViewById(C2640R.id.group);
        this.groupAtom = (Group) view.findViewById(C2640R.id.gp_atom);
        this.tvFlightRecordAtom = (TextView) view.findViewById(C2640R.id.tv_flight_record_atom);
        this.tvAircraftLogAtom = (TextView) view.findViewById(C2640R.id.tv_aircraft_log_atom);
        this.tvCheckUpgrade = (TextView) view.findViewById(C2640R.id.tv_check_upgrade);
        this.tvVideoTeach = (TextView) view.findViewById(C2640R.id.tv_video_teach);
        this.tvInstructions = (TextView) view.findViewById(C2640R.id.tv_instructions);
        this.tvFlightRecord = (TextView) view.findViewById(C2640R.id.tv_flight_record);
        this.tvFlightLog = (TextView) view.findViewById(C2640R.id.tv_flight_log);
        this.ivDeviceType = (ImageView) view.findViewById(C2640R.id.iv_device_type);
        AOAEngine.getInstance().addConnectListener(this);
        setFlightRes();
        setOnClickListener(view);
        controlMenu();
        LocationService.getInstance().setOnLocationChangedListener(this);
    }

    public /* synthetic */ void lambda$initView$0$MainDeviceController(State state) {
        boolean z = state == State.STATE_USB_CONNECT_FLIGHT || state == State.STATE_USB_FLIGHT_BOOTLOADER || state == State.STATE_WIFI_CONNECT_FLIGHT || state == State.STATE_WIFI_CONNECT_REMOTER;
        setConnectUI(z);
        this.btnEnterDevice.setBackgroundResource(z ? C2640R.drawable.bg_device_enter_select : C2640R.drawable.bg_device_enter_no_select);
    }

    private void controlMenu() {
        if (FlightConfig.is_Atom_Series()) {
            this.group.setVisibility(8);
            this.groupAtom.setVisibility(0);
        } else {
            this.group.setVisibility(0);
            this.groupAtom.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBtnEnableClick(boolean z) {
        TextView textView = this.tvVideoTeach;
        if (textView == null || this.tvInstructions == null || this.tvFlightRecord == null || this.tvFlightLog == null || this.btnMenuClose == null || this.viewBlank == null || this.layout_menu == null) {
            return;
        }
        textView.setClickable(z);
        this.tvInstructions.setClickable(z);
        this.tvFlightRecord.setClickable(z);
        this.tvFlightLog.setClickable(z);
        this.btnMenuClose.setClickable(z);
        this.viewBlank.setVisibility(z ? 0 : 8);
        this.layout_menu.setVisibility(z ? 0 : 8);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            hideMenu();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        ConnectStateView connectStateView = this.tvDeviceState;
        if (connectStateView != null) {
            connectStateView.onEvent(eventID, event);
        }
        if (PhoneConfig.isMainActivityPause) {
            return;
        }
        int i = C274118.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (UsbConfig.isUsbConnected) {
                return;
            }
            this.isPairing = false;
            MiniPairDialog miniPairDialog = this.miniPairDialog;
            if (miniPairDialog != null && miniPairDialog.isShowing()) {
                this.miniPairDialog.dismiss();
            }
            MiniPairFailDialog miniPairFailDialog = this.miniPairFailDialog;
            if (miniPairFailDialog == null || !miniPairFailDialog.isShowing()) {
                return;
            }
            this.miniPairFailDialog.dismiss();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            FlightRevMiniPairData flightRevMiniPairData = (FlightRevMiniPairData) event.obj;
            MiniPairDialog miniPairDialog2 = this.miniPairDialog;
            if (miniPairDialog2 == null || !miniPairDialog2.isShowing()) {
                return;
            }
            if (flightRevMiniPairData.isPairSuccess()) {
                DDLog.m1684e("对频成功");
                this.miniPairDialog.success();
                this.isPairing = false;
                DataManager.getInstance().requestFpvInfo();
                return;
            }
            DDLog.m1684e("对频失败");
            MiniPairFailDialog miniPairFailDialog2 = new MiniPairFailDialog(getContext(), C2640R.layout.view_dialog_repair_main, new MiniPairFailDialog.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$cUcR06aJRZRWTJJZogvCuhZ2Rls
                @Override // com.ipotensic.kernel.view.dialog.MiniPairFailDialog.OnClickListener
                public final void onConfirm() {
                    MainDeviceController.this.lambda$onEvent$1$MainDeviceController();
                }
            });
            this.miniPairFailDialog = miniPairFailDialog2;
            miniPairFailDialog2.show();
            return;
        }
        FlightRevConnectData flightRevConnectData = (FlightRevConnectData) event.obj;
        DDLog.m1684e("对频状态" + flightRevConnectData.isMiniPairing());
        if (flightRevConnectData.isMiniPairing() && !this.isPairing) {
            this.isPairing = true;
            MiniPairDialog miniPairDialog3 = new MiniPairDialog(getContext());
            this.miniPairDialog = miniPairDialog3;
            miniPairDialog3.show();
        }
        if (flightRevConnectData.isRemoterConnected()) {
            return;
        }
        this.isPairing = false;
        MiniPairDialog miniPairDialog4 = this.miniPairDialog;
        if (miniPairDialog4 != null && miniPairDialog4.isShowing()) {
            this.miniPairDialog.dismiss();
        }
        MiniPairFailDialog miniPairFailDialog3 = this.miniPairFailDialog;
        if (miniPairFailDialog3 == null || !miniPairFailDialog3.isShowing()) {
            return;
        }
        this.miniPairFailDialog.dismiss();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainDeviceController$18 */
    static /* synthetic */ class C274118 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_MINI_PAIR_RESULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ void lambda$onEvent$1$MainDeviceController() {
        this.miniPairDialog.dismiss();
        this.isPairing = false;
    }

    private void startGuide() {
        this.guideModelSelect.setVisibility(0);
        showFlightModeGuide();
    }

    private void showFlightModeGuide() {
        NewbieGuide.with(getContext()).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.1
            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onShowed(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                MainDeviceController.this.tvChoose.clearAnimation();
                MainDeviceController.this.toChooseFlightType();
                SPHelper.getInstance().setFirstEnterMain(false);
            }
        }).addGuidePage(getDefaultGuidePage().addHighLight(this.tvChoose, new RelativeGuide(C2640R.layout.guide_view_main_top, 80, UnitUtil.dip2px(8.0f), 0, 0, 0, 0)).addHighLight(this.guideModelSelect).addClickView(this.ivLogo).setEverywhereCancelable(false).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$kk_YBc1ODeuNbwvB1B3kDkgggXc
            @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
            public final void onLayoutInflated(View view, Controller controller) {
                MainDeviceController.this.lambda$showFlightModeGuide$2$MainDeviceController(view, controller);
            }
        })).show(false);
    }

    public /* synthetic */ void lambda$showFlightModeGuide$2$MainDeviceController(View view, Controller controller) {
        setFlightModeBgAlpha(true);
        this.tvChoose.startAnimation(AnimationUtil.getTwinkleAnimation());
    }

    private void showMenuGuidePage() {
        boolean z = SPHelper.getInstance().getBoolean(SPHelper.KEY_ENTER_MAIN_SECOND, false);
        boolean firstEnterMain = SPHelper.getInstance().getFirstEnterMain();
        if (z && !firstEnterMain && this.step == 0) {
            this.step = 1;
            this.guideModelSelect.setVisibility(0);
            NewbieGuide.with(getContext()).setOnGuideChangedListener(this).addGuidePage(getDefaultGuidePage().addHighLight(this.btnMenu, new RelativeGuide(C2640R.layout.guide_view_main_right_offset, GravityCompat.END, 0, 0, 0, 0, 0)).addHighLight(this.guideModelSelect).setEverywhereCancelable(false).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$1o_sK1c0iDgg34vwh7GCGDx406A
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    MainDeviceController.this.lambda$showMenuGuidePage$3$MainDeviceController(view, controller);
                }
            })).show(false);
        }
    }

    public /* synthetic */ void lambda$showMenuGuidePage$3$MainDeviceController(View view, Controller controller) {
        setFlightModeBgAlpha(false);
        this.btnMenu.startAnimation(AnimationUtil.getTwinkleAnimation());
    }

    private void setFlightModeBgAlpha(boolean z) {
        this.ivLogo.setAlpha(z ? 1.0f : 0.5f);
        this.tvChoose.setAlpha(z ? 1.0f : 0.5f);
        this.btnMenu.setAlpha(z ? 0.5f : 1.0f);
    }

    private void showItemsGuide() {
        this.handler.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$zGe_opOXSdeVECy9iA1EA_al4oE
            @Override // java.lang.Runnable
            public final void run() {
                MainDeviceController.this.lambda$showItemsGuide$8$MainDeviceController();
            }
        }, 400L);
    }

    public /* synthetic */ void lambda$showItemsGuide$8$MainDeviceController() {
        Builder onGuideChangedListener = NewbieGuide.with(getContext()).setOnGuideChangedListener(this);
        if (FlightConfig.is_Atom_Series()) {
            onGuideChangedListener.addGuidePage(getDefaultGuidePage().addHighLight(this.tvFlightRecordAtom, new RelativeGuide(C2640R.layout.guide_view_main_top_left, GravityCompat.START, 0, UnitUtil.dp2px(32), 0, 0, 0)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$2T0bUPL3cBl5xi7TOp2c3Q5LHdM
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    ((TextView) view.findViewById(C2640R.id.tv_view)).setText(C2640R.string.guide_homepage_flight_record_tips);
                }
            }).setShowCanClick(true, true, false)).addGuidePage(getDefaultGuidePage().addHighLight(this.tvAircraftLogAtom, new RelativeGuide(C2640R.layout.guide_view_main_top_left, GravityCompat.START, 0, UnitUtil.dp2px(32), 0, 0, 0)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$PSq-BHO_pnEHvpYEQyGYBnFUpF8
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    ((TextView) view.findViewById(C2640R.id.tv_view)).setText(C2640R.string.guide_homepage_flight_log_tips);
                }
            }).setShowCanClick(true, true, false));
        } else {
            onGuideChangedListener.addGuidePage(getDefaultGuidePage().addHighLight(this.tvVideoTeach, new RelativeGuide(C2640R.layout.guide_view_main_top, GravityCompat.START, 0, UnitUtil.dp2px(20), 0, 0, 0)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$UtHGnOk_ngKGLfAI7UZfUB6GY6I
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    MainDeviceController.this.lambda$showItemsGuide$6$MainDeviceController(view, controller);
                }
            }).setShowCanClick(false, true, false)).addGuidePage(getDefaultGuidePage().addHighLight(this.tvInstructions, new RelativeGuide(C2640R.layout.guide_view_main_top, GravityCompat.START, 0, UnitUtil.dp2px(20), 0, 0, 0)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$YKPIWSddrPrLnyIR-0XRGYVtAzg
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    MainDeviceController.this.lambda$showItemsGuide$7$MainDeviceController(view, controller);
                }
            }).setShowCanClick(true, true, false));
        }
        onGuideChangedListener.show();
    }

    public /* synthetic */ void lambda$showItemsGuide$6$MainDeviceController(View view, Controller controller) {
        ((TextView) view.findViewById(C2640R.id.tv_view)).setText(getContext().getResources().getString(C2640R.string.guide_drop_down_menu1));
    }

    public /* synthetic */ void lambda$showItemsGuide$7$MainDeviceController(View view, Controller controller) {
        ((TextView) view.findViewById(C2640R.id.tv_view)).setText(getContext().getResources().getString(C2640R.string.guide_drop_down_menu2));
    }

    private void showConnectGuide() {
        this.handler.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$ElZKPox9TDk5YX0BEOsih9MUzLk
            @Override // java.lang.Runnable
            public final void run() {
                MainDeviceController.this.lambda$showConnectGuide$11$MainDeviceController();
            }
        }, 400L);
    }

    public /* synthetic */ void lambda$showConnectGuide$11$MainDeviceController() {
        NewbieGuide.with(getContext()).setOnGuideChangedListener(this).addGuidePage(getDefaultGuidePage().addHighLight(this.tvDeviceState, new RelativeGuide(C2640R.layout.guide_view_main_left, 5), UnitUtil.dip2px(8.0f), UnitUtil.dip2px(8.0f)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$4fGFUpsCl2wSNsLErwYBNiaegik
            @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
            public final void onLayoutInflated(View view, Controller controller) {
                MainDeviceController.this.lambda$showConnectGuide$9$MainDeviceController(view, controller);
            }
        })).addGuidePage(getDefaultGuidePage().addHighLight(this.tvDeviceState, new RelativeGuide(C2640R.layout.guide_view_main_left, 5), UnitUtil.dip2px(8.0f), UnitUtil.dip2px(8.0f)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$hHIFaZB4INqoNRHvi9ewx1Wv2J4
            @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
            public final void onLayoutInflated(View view, Controller controller) {
                MainDeviceController.this.lambda$showConnectGuide$10$MainDeviceController(view, controller);
            }
        })).show();
    }

    public /* synthetic */ void lambda$showConnectGuide$9$MainDeviceController(View view, Controller controller) {
        this.tvDeviceState.setGuideStep1();
    }

    public /* synthetic */ void lambda$showConnectGuide$10$MainDeviceController(View view, Controller controller) {
        ((TextView) view.findViewById(C2640R.id.tv_view)).setText(getContext().getResources().getString(C2640R.string.guide_main_left2));
        this.tvDeviceState.setGuideStep2();
    }

    private void showEnterGuide() {
        NewbieGuide.with(getContext()).setOnGuideChangedListener(this).addGuidePage(getDefaultGuidePage().addHighLight(this.bgEnterDevice, new RelativeGuide(C2640R.layout.guide_view_main_bottom, 48, 0, 0, 0, 0, 0)).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$IKiA6d24T9xrJwsUg1cFbt80hJw
            @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
            public final void onLayoutInflated(View view, Controller controller) {
                MainDeviceController.this.lambda$showEnterGuide$12$MainDeviceController(view, controller);
            }
        })).show();
    }

    public /* synthetic */ void lambda$showEnterGuide$12$MainDeviceController(View view, Controller controller) {
        ((TextView) view.findViewById(C2640R.id.tv_view)).setText(C2640R.string.guide_homepage_enter_flight_interface_tips);
        this.bgEnterDevice.setVisibility(0);
    }

    private GuidePage getDefaultGuidePage() {
        return GuidePage.newInstance().setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setEverywhereCancelable(true).setBackgroundColor(ContextCompat.getColor(getContext(), C2640R.color.colorFiftyPercent));
    }

    private void setFlightRes() {
        Flight lastFlight = FlightConfig.getLastFlight();
        if (lastFlight == null) {
            toChooseFlightType();
            return;
        }
        int flightBg = lastFlight.getFlightBg();
        if (flightBg != 0) {
            this.ivDeviceType.setImageResource(flightBg);
        }
        String flightTypeString = lastFlight.getFlightTypeString();
        if (flightTypeString != null) {
            this.tvChoose.setText(flightTypeString);
        }
    }

    public void openGuide() {
        if (SPHelper.getInstance().getFirstEnterMain()) {
            OpenGuideDialog openGuideDialog = new OpenGuideDialog(getContext());
            this.guideDialog = openGuideDialog;
            openGuideDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$abDxmDZayP5U3nDIcl8-Te7I46o
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainDeviceController.this.lambda$openGuide$13$MainDeviceController(dialogInterface);
                }
            });
            this.guideDialog.show();
        }
    }

    public /* synthetic */ void lambda$openGuide$13$MainDeviceController(DialogInterface dialogInterface) {
        startGuide();
    }

    public void changeModelBg() {
        if (FlightConfig.curFlight == null || this.ivDeviceType == null || this.tvChoose == null) {
            return;
        }
        DDLog.m1685e("升级模式", FlightConfig.curFlight + "");
        setFlightRes();
        controlMenu();
    }

    public void setConnectUI(boolean z) {
        ConnectStateView connectStateView = this.tvDeviceState;
        if (connectStateView == null) {
            return;
        }
        if (z) {
            connectStateView.setConnectedState();
        } else {
            connectStateView.setSearchState();
        }
    }

    private void hideMenu() {
        setBtnEnableClick(false);
    }

    public void showUpgradeButton(boolean z) {
        DDLog.m1685e(OutputKeys.VERSION, "isNewVersion: " + z);
        TextView textView = this.tvCheckUpgrade;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
            this.tvCheckUpgrade.setText(getContext().getString(C2640R.string.upgrade_check));
            this.tvCheckUpgrade.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission(final SimpleResultListener<Boolean> simpleResultListener) {
        PermissionUtil.requestAllPermissionWithDialog(getContext(), new PermissionUtil.OnPermissionListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.2
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                PermissionUtil.requestLocationPermissionAndGpsEnable((BaseActivity) MainDeviceController.this.getContext(), simpleResultListener);
            }
        });
    }

    private void setOnClickListener(View view) {
        view.findViewById(C2640R.id.iv_logo).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainDeviceController.this.toChooseFlightType();
            }
        });
        this.tvChoose.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainDeviceController.this.toChooseFlightType();
            }
        });
        this.tvDeviceState.setCheckBtnClickListener(new C27455());
        int i = 1000;
        view.findViewById(C2640R.id.tv_video_teach).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.6
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (MainDeviceController.this.isGuideShow()) {
                    return;
                }
                MainDeviceController.this.getContext().startActivityForResult(new Intent(MainDeviceController.this.getContext(), (Class<?>) VideoTeachActivity.class), 103);
            }
        });
        view.findViewById(C2640R.id.tv_instructions).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.7
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (MainDeviceController.this.isGuideShow()) {
                    return;
                }
                MainDeviceController.this.getContext().startActivityForResult(new Intent(MainDeviceController.this.getContext(), (Class<?>) InstructionActivity.class), 103);
            }
        });
        view.findViewById(C2640R.id.tv_flight_record).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.8
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (MainDeviceController.this.isGuideShow()) {
                    return;
                }
                MainDeviceController.this.getContext().startActivityForResult(new Intent(MainDeviceController.this.getContext(), (Class<?>) FlightRecordActivity.class), 103);
            }
        });
        view.findViewById(C2640R.id.tv_aircraft_log_atom).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.9
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainDeviceController.this.startAircraftLogActivity();
            }
        });
        view.findViewById(C2640R.id.tv_flight_log).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.10
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainDeviceController.this.startAircraftLogActivity();
            }
        });
        view.findViewById(C2640R.id.tv_flight_record_atom).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.11
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (MainDeviceController.this.isGuideShow()) {
                    return;
                }
                MainDeviceController.this.getContext().startActivityForResult(new Intent(MainDeviceController.this.getContext(), (Class<?>) FlightRecordActivity.class), 103);
            }
        });
        this.tvFlightRecordAtom.setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.12
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (MainDeviceController.this.isGuideShow()) {
                    return;
                }
                MainDeviceController.this.getContext().startActivityForResult(new Intent(MainDeviceController.this.getContext(), (Class<?>) FlightRecordActivity.class), 103);
            }
        });
        view.findViewById(C2640R.id.tv_check_upgrade).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.13
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainDeviceController.this.getContext().startActivityForResult(new Intent(MainDeviceController.this.getContext(), (Class<?>) FwDownloadActivity.class), 101);
            }
        });
        this.btnEnterDevice.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.14
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainDeviceController.this.startKernelActivity();
            }
        });
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainDeviceController$5 */
    class C27455 extends ScaleClickListener {
        C27455() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainDeviceController.this.checkPermission(new SimpleResultListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$5$lfB0mHcBA6vjJOkMifJQHM7QF10
                @Override // com.ipotensic.baselib.listener.SimpleResultListener
                public final void onResult(Object obj) {
                    MainDeviceController.C27455.this.lambda$click$0$MainDeviceController$5((Boolean) obj);
                }
            });
        }

        public /* synthetic */ void lambda$click$0$MainDeviceController$5(Boolean bool) {
            if (bool.booleanValue()) {
                LocalFileManager.getInstance().initExternalDir();
                LocalFileManager.getInstance().initMediaDir();
                LocationService.getInstance().init();
                MainDeviceController.this.toTeach();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGuideShow() {
        return this.step != 0;
    }

    private void startWebActivity(String str, String str2) {
        Intent intent = new Intent(getContext(), (Class<?>) PdfWebActivity.class);
        intent.putExtra(WebActivity.WEB_URL, str);
        intent.putExtra(WebActivity.WEB_TITLE, str2);
        getContext().startActivityForResult(intent, 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAircraftLogActivity() {
        if (isGuideShow()) {
            return;
        }
        getContext().startActivityForResult(new Intent(getContext(), (Class<?>) AircraftLogActivity.class), 103);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainDeviceController$15 */
    class C273815 implements SimpleResultListener<Boolean> {
        C273815() {
        }

        @Override // com.ipotensic.baselib.listener.SimpleResultListener
        public void onResult(Boolean bool) {
            if (bool.booleanValue()) {
                PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LocalFileManager.getInstance().initExternalDir();
                        LocalFileManager.getInstance().initMediaDir();
                        LocationService.getInstance().init();
                    }
                });
                AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                if (UsbConfig.isUsbConnected) {
                    anonymousClass2.onClosed();
                } else {
                    DataManager.getInstance().close(anonymousClass2);
                }
            }
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainDeviceController$15$2, reason: invalid class name */
        class AnonymousClass2 implements OnCloseListener {
            AnonymousClass2() {
            }

            @Override // com.logan.flight.listeners.OnCloseListener
            public void onClosed() {
                MainDeviceController.this.getContext().runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.15.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityHelper.getInstance().makeActivityOnlyOne(KernelActivity.class, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.15.2.1.1
                            @Override // com.ipotensic.baselib.listener.SimpleResultListener
                            public void onResult(Boolean bool) {
                                MainDeviceController.this.getContext().startActivity(new Intent(MainDeviceController.this.getContext(), (Class<?>) KernelActivity.class));
                            }
                        });
                        MainDeviceController.this.showUpgradeButton(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startKernelActivity() {
        hideMenu();
        checkPermission(new C273815());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C2640R.id.btn_menu /* 2131296420 */:
                controlMenuView(true);
                break;
            case C2640R.id.btn_menu_close /* 2131296421 */:
            case C2640R.id.iv_close_atom /* 2131296761 */:
            case C2640R.id.view_blank /* 2131297917 */:
                if (!isGuideShow()) {
                    controlMenuView(false);
                    break;
                }
                break;
        }
    }

    private void controlMenuView(final boolean z) {
        if (this.isAnimating) {
            return;
        }
        Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.ipotensic.potensicpro.activities.MainDeviceController.16
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MainDeviceController.this.isAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MainDeviceController.this.setBtnEnableClick(z);
                MainDeviceController.this.isAnimating = false;
            }
        };
        if (z) {
            this.viewBlank.setVisibility(0);
            this.layout_menu.setVisibility(0);
            AnimationUtil.transInTop(this.layout_menu, animationListener);
        } else {
            this.viewBlank.setVisibility(8);
            this.layout_menu.setVisibility(8);
            AnimationUtil.transOutTop(this.layout_menu, animationListener);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        AOAEngine.getInstance().removeListener(this);
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryConnected() {
        EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryDisconnected() {
        EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
        this.isPairing = false;
        MiniPairDialog miniPairDialog = this.miniPairDialog;
        if (miniPairDialog == null || !miniPairDialog.isShowing()) {
            return;
        }
        this.miniPairDialog.dismiss();
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryConnectError() {
        EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
        this.isPairing = false;
        MiniPairDialog miniPairDialog = this.miniPairDialog;
        if (miniPairDialog == null || !miniPairDialog.isShowing()) {
            return;
        }
        this.miniPairDialog.dismiss();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        com.logan.flight.FlightConfig.setFlightType(r1.getFlightByte());
        setFlightRes();
        controlMenu();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r5 = 0
            r0 = 103(0x67, float:1.44E-43)
            if (r4 != r0) goto La
            r3.setBtnEnableClick(r5)
            goto L7e
        La:
            r0 = 101(0x65, float:1.42E-43)
            if (r4 != r0) goto L34
            if (r6 == 0) goto L34
            java.lang.String r4 = "isDownloadEnd"
            boolean r4 = r6.getBooleanExtra(r4, r5)
            android.widget.TextView r5 = r3.tvCheckUpgrade
            androidx.appcompat.app.AppCompatActivity r6 = r3.getContext()
            if (r4 == 0) goto L22
            r0 = 2131755356(0x7f10015c, float:1.9141589E38)
            goto L25
        L22:
            r0 = 2131756339(0x7f100533, float:1.9143583E38)
        L25:
            java.lang.String r6 = r6.getString(r0)
            r5.setText(r6)
            android.widget.TextView r5 = r3.tvCheckUpgrade
            r4 = r4 ^ 1
            r5.setEnabled(r4)
            goto L7e
        L34:
            java.lang.String r0 = com.logan.flight.FlightConfig.getLastFlightModel()
            boolean r1 = com.logan.flight.FlightConfig.isConnectFlight()
            if (r1 == 0) goto L44
            if (r0 == 0) goto L44
            r3.showMenuGuidePage()
            return
        L44:
            if (r0 != 0) goto L49
            r3.toTeach()
        L49:
            r0 = 102(0x66, float:1.43E-43)
            if (r4 != r0) goto L7e
            if (r6 == 0) goto L7b
            java.lang.String r4 = "device_name"
            java.lang.String r4 = r6.getStringExtra(r4)     // Catch: java.lang.Exception -> L7b
            if (r4 == 0) goto L7b
            com.logan.flight.type.Flight[] r6 = com.logan.flight.type.Flight.values()     // Catch: java.lang.Exception -> L7b
            int r0 = r6.length     // Catch: java.lang.Exception -> L7b
        L5c:
            if (r5 >= r0) goto L7b
            r1 = r6[r5]     // Catch: java.lang.Exception -> L7b
            java.lang.String r2 = r1.getFlightTypeString()     // Catch: java.lang.Exception -> L7b
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Exception -> L7b
            if (r2 == 0) goto L78
            byte r4 = r1.getFlightByte()     // Catch: java.lang.Exception -> L7b
            com.logan.flight.FlightConfig.setFlightType(r4)     // Catch: java.lang.Exception -> L7b
            r3.setFlightRes()     // Catch: java.lang.Exception -> L7b
            r3.controlMenu()     // Catch: java.lang.Exception -> L7b
            goto L7b
        L78:
            int r5 = r5 + 1
            goto L5c
        L7b:
            r3.showMenuGuidePage()
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.potensicpro.activities.MainDeviceController.onActivityResult(int, int, android.content.Intent):void");
    }

    private boolean isGuideDialogShowing() {
        OpenGuideDialog openGuideDialog = this.guideDialog;
        return openGuideDialog != null && openGuideDialog.isShowing();
    }

    @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
    public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
        DDLog.m1682d("onRemoved=" + this.step);
        int i = this.step;
        if (i == 1) {
            this.step = i + 1;
            this.guideModelSelect.setVisibility(8);
            controlMenuView(true);
            showItemsGuide();
            return;
        }
        if (i == 2) {
            this.step = i + 1;
            this.btnMenu.clearAnimation();
            this.ivLogo.setAlpha(1.0f);
            this.tvChoose.setAlpha(1.0f);
            this.btnMenu.setAlpha(1.0f);
            controlMenuView(false);
            showConnectGuide();
            return;
        }
        if (i == 3) {
            this.step = i + 1;
            this.tvDeviceState.resetGuide();
            showEnterGuide();
        } else if (i == 4) {
            this.step = 0;
            this.bgEnterDevice.setVisibility(4);
            SPHelper.getInstance().putBoolean(SPHelper.KEY_ENTER_MAIN_SECOND, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toChooseFlightType() {
        Intent intent = new Intent(getContext(), (Class<?>) ChooseFlightActivity.class);
        intent.putExtra("device_type", 0);
        getContext().startActivityForResult(intent, 102);
        getContext().overridePendingTransition(C2640R.anim.trans_in_top, C2640R.anim.alpha_out_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toTeach() {
        Intent intent = new Intent(getContext(), (Class<?>) ChooseFlightActivity.class);
        intent.putExtra("device_type", 2);
        getContext().startActivity(intent);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onResume() {
        this.handler.removeCallbacks(this.animRun);
        this.handler.post(this.animRun);
        EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
        showMenuGuidePage();
    }

    @Override // com.ipotensic.kernel.services.OnLocationChangedListener
    public void onBDLocationChanged(double d, double d2, float f) {
        if (TextUtils.isEmpty(SPHelper.getInstance().getCountryCode())) {
            LocationService.getInstance().getCountryCode();
        }
    }
}
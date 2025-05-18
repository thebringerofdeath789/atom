package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.kernel.activitys.KernelActivity;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.DeviceMethodController;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.recv.FlightRevUpgradeData;
import com.logan.flight.listeners.OnCloseListener;

/* loaded from: classes2.dex */
public class ChooseFlightActivity extends BaseActivity implements EventDispatcher.OnEventListener {
    private BaseController curController;
    private ViewStub layoutDevice;
    private DeviceListController listController;
    private DeviceMethodController methodController;
    private int type = -1;
    DeviceMethodController.DeviceMethodListener methodListener = new DeviceMethodController.DeviceMethodListener() { // from class: com.ipotensic.potensicpro.activities.ChooseFlightActivity.1
        @Override // com.ipotensic.potensicpro.activities.DeviceMethodController.DeviceMethodListener
        public void methodListener() {
            ChooseFlightActivity.this.finish();
        }
    };

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_device);
        initView();
        int i = getIntent().getExtras().getInt("device_type", -1);
        if (i != -1) {
            if (i == 0) {
                this.type = 0;
                setCurPage(this.listController);
            } else if (i == 2) {
                this.type = 2;
                setCurPage(this.methodController);
            }
        }
        EventDispatcher.get().registerEvent(getLifecycle(), this);
    }

    private void initView() {
        this.layoutDevice = (ViewStub) findViewById(R.id.stub_list);
        this.listController = new DeviceListController(this, this.layoutDevice);
        DeviceMethodController deviceMethodController = new DeviceMethodController(this, (ViewStub) findViewById(R.id.stub_method));
        this.methodController = deviceMethodController;
        deviceMethodController.setMethodListener(this.methodListener);
    }

    public void setCurPage(BaseController baseController) {
        this.curController = baseController;
        this.listController.setVisibility(baseController instanceof DeviceListController ? 0 : 8);
        this.methodController.setVisibility(this.curController instanceof DeviceMethodController ? 0 : 8);
        if (this.curController instanceof DeviceListController) {
            this.listController.initData();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.type == 0) {
            overridePendingTransition(0, R.anim.trans_out_top);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.ChooseFlightActivity$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_REMOTER_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_UPGRADE_MODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_MINI_CONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        int i = AnonymousClass3.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            if (isFinishing()) {
                return;
            }
            DDLog.e("\u5df2\u83b7\u53d6\u9065\u63a7\u5668\u7248\u672c\u53f7");
            this.methodController.setMiniCurShowItem();
            return;
        }
        if (i == 2) {
            if (isFinishing()) {
                return;
            }
            DDLog.e("\u98de\u63a7\u5df2\u8fde\u4e0a");
            this.methodController.onConnectStateChanged(((Boolean) event.obj).booleanValue());
            return;
        }
        if (i == 3) {
            if (isFinishing()) {
                return;
            }
            this.methodController.onReceiveFlightType();
        } else {
            if (i == 4) {
                FlightConfig.setFlightType(((FlightRevUpgradeData) event.obj).getUpgradeType());
                if (isFinishing()) {
                    return;
                }
                this.methodController.onReceiveFlightType();
                return;
            }
            if (i == 5 && !ActivityHelper.getInstance().isActivityRunning(KernelActivity.class)) {
                PermissionUtil.requestAllPermissionWithDialog(this, new AnonymousClass2());
            }
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.ChooseFlightActivity$2, reason: invalid class name */
    class AnonymousClass2 implements PermissionUtil.OnPermissionListener {
        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass2() {
        }

        /* renamed from: com.ipotensic.potensicpro.activities.ChooseFlightActivity$2$1, reason: invalid class name */
        class AnonymousClass1 implements SimpleResultListener<Boolean> {
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(Boolean bool) {
                if (bool.booleanValue()) {
                    ActivityHelper.getInstance().makeActivityOnlyOne(KernelActivity.class, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.ChooseFlightActivity.2.1.1
                        @Override // com.ipotensic.baselib.listener.SimpleResultListener
                        public void onResult(Boolean bool2) {
                            LocalFileManager.getInstance().initExternalDir();
                            LocalFileManager.getInstance().initMediaDir();
                            LocationService.getInstance().init();
                            DataManager.getInstance().close(new OnCloseListener() { // from class: com.ipotensic.potensicpro.activities.ChooseFlightActivity.2.1.1.1
                                @Override // com.logan.flight.listeners.OnCloseListener
                                public void onClosed() {
                                    ChooseFlightActivity.this.startActivity(new Intent(ChooseFlightActivity.this, (Class<?>) KernelActivity.class));
                                    ChooseFlightActivity.this.finish();
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            PermissionUtil.requestLocationPermissionAndGpsEnable(ChooseFlightActivity.this, new AnonymousClass1());
        }
    }
}
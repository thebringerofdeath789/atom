package com.ipotensic.potensicpro.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewStub;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.hjq.permissions.Permission;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.broadcasts.NetworkStateReceiver;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.listener.OnNetworkChangeListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.manager.FlightFirmwareChecker;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.kernel.utils.FwDownloadHelper;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.potensicpro.BuildConfig;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.MainMediaController;
import com.ipotensic.potensicpro.adapter.MainPagerAdapter;
import com.ipotensic.potensicpro.models.MainViewModel;
import com.ipotensic.potensicpro.view.BottomItemView;
import com.ipotensic.potensicpro.view.BottomTabView;
import com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevUpgradeData;
import com.logan.flight.data.recv.FlightRevVersionData;
import com.logan.flight.type.Flight;
import com.logan.upgrade.server.Version;
import com.logan.user.model.rev.RevUserAppVersionData;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IUnreadMsgView;

/* loaded from: classes2.dex */
public class MainActivity extends BaseActivity implements OnNetworkChangeListener, IUnreadMsgView, EventDispatcher.OnEventListener {
    private static final String LOGIN_SUCCESS = "login_success";
    private BottomTabView bottomTabView;
    private long exitTime;
    private MainDeviceController mainDeviceController;
    private MainMeController mainMeController;
    private MainMediaController mainMediaController;
    private MainViewModel mainViewModel;
    private VersionUpdateDialog updateDialog;
    private boolean isRevUpgradeMode = false;
    private MainMediaController.MediaControllerListener mediaControllerListener = new MainMediaController.MediaControllerListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.2
        @Override // com.ipotensic.potensicpro.activities.MainMediaController.MediaControllerListener
        public void setSelectUI(boolean z) {
            if (MainActivity.this.bottomTabView != null) {
                MainActivity.this.bottomTabView.setVisibility(z ? 4 : 0);
            }
        }
    };
    private BottomTabView.onTabChangeListener tabChangeListener = new AnonymousClass3();
    private FwDownloadHelper.DownloadResultListener onResultListener = new FwDownloadHelper.DownloadResultListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.4
        @Override // com.ipotensic.kernel.utils.FwDownloadHelper.DownloadResultListener
        public void downloadRequest() {
        }

        @Override // com.ipotensic.kernel.utils.FwDownloadHelper.DownloadResultListener
        public void downloadResult(boolean z) {
            MainActivity.this.mainDeviceController.showUpgradeButton(z);
        }

        @Override // com.ipotensic.kernel.utils.FwDownloadHelper.DownloadResultListener
        public void downloadSuccess(boolean z) {
            MainActivity.this.isRevUpgradeMode = false;
            MainActivity.this.mainDeviceController.showUpgradeButton(!z);
        }

        @Override // com.ipotensic.kernel.utils.FwDownloadHelper.DownloadResultListener
        public void downloadFailed() {
            if (MainActivity.this.isRevUpgradeMode) {
                MainActivity mainActivity = MainActivity.this;
                ToastUtil.toast(mainActivity, mainActivity.getString(R.string.txt_no_fireware_file_tips));
            }
        }
    };
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.5
        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.isRevUpgradeMode = false;
        }
    };

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onCellularStateChanged(boolean z) {
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_main);
        this.mainViewModel = (MainViewModel) new ViewModelProvider(this).get(MainViewModel.class);
        LocalFileManager.getInstance().initExternalDir();
        if (PermissionUtil.hasStoragePermission(this)) {
            LocalFileManager.getInstance().initMediaDir();
            LocalFileManager.getInstance().clearCacheDir();
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$ytOBURCJNndg7S1Lls3f9WILnUY
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.lambda$onCreate$0$MainActivity();
                }
            });
        }
        if (PermissionUtil.hasPermission(this, Permission.ACCESS_FINE_LOCATION)) {
            LocationService.getInstance().init();
        }
        this.mainDeviceController = new MainDeviceController(this, findViewById(R.id.layout_device));
        MainMediaController mainMediaController = new MainMediaController(this, (ViewStub) findViewById(R.id.stub_media));
        this.mainMediaController = mainMediaController;
        mainMediaController.setMediaControllerListener(this.mediaControllerListener);
        this.mainMeController = new MainMeController(this, (ViewStub) findViewById(R.id.stub_me));
        BottomTabView bottomTabView = (BottomTabView) findViewById(R.id.bottom_view);
        this.bottomTabView = bottomTabView;
        bottomTabView.setAttachedActivity(this);
        this.bottomTabView.setMainMediaController(this.mainMediaController);
        this.bottomTabView.setTabChangedListener(this.tabChangeListener);
        this.bottomTabView.init(BottomItemView.buildWithTitleAndDrawableRes(this, getString(R.string.bottom_main_equipment), R.mipmap.img_btn_main_tab_equipme_selected, R.mipmap.img_btn_main_tab_equipme_normal), BottomItemView.buildWithTitleAndDrawableRes(this, getString(R.string.bottom_main_editor), R.mipmap.img_btn_main_tab_media_selected, R.mipmap.img_btn_main_tab_media_normal), BottomItemView.buildWithTitleAndDrawableRes(this, getString(R.string.bottom_main_me), R.mipmap.img_btn_main_tab_me_selected, R.mipmap.img_btn_main_tab_me_normal));
        this.bottomTabView.setAdapter(new MainPagerAdapter(this.mainDeviceController, this.mainMediaController, this.mainMeController));
        initRequest();
        initObserver();
    }

    public /* synthetic */ void lambda$onCreate$0$MainActivity() {
        this.mainViewModel.uploadDumpLog();
    }

    private void initRequest() {
        EventDispatcher.get().registerEvent(getLifecycle(), this);
        NetworkStateReceiver.getInstance().addCallback(this);
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra(LOGIN_SUCCESS, false)) {
            return;
        }
        this.mainMeController.onLoginLoadHeadImg();
    }

    private void initObserver() {
        this.mainViewModel.getVersionData().observe(this, new Observer() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$Z8I6RugYoP9ujg6m8ceE_cEpwFk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$initObserver$1$MainActivity((RevUserAppVersionData.Version) obj);
            }
        });
        this.mainViewModel.getUpdateFinishData().observe(this, new Observer() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$q7XTrz9U6wCGQ1HxiiuTMUvhwbQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$initObserver$2$MainActivity((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initObserver$1$MainActivity(RevUserAppVersionData.Version version) {
        if (version != null) {
            showVersionUpdateDialog(version);
        }
    }

    public /* synthetic */ void lambda$initObserver$2$MainActivity(Boolean bool) {
        if (bool.booleanValue()) {
            PhoneConfig.appUpgradeVersion = true;
            upgradeFinish();
        }
    }

    private void showVersionUpdateDialog(final RevUserAppVersionData.Version version) {
        if (BaseSyncDialog.isShow) {
            return;
        }
        VersionUpdateDialog versionUpdateDialog = new VersionUpdateDialog(this, version.getAppver(), version.getContent(), version.getIsforceupdate(), new VersionUpdateDialog.OnItemClickListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.1
            @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
            public void toUpdate() {
                MainActivity.this.downloadFromGooglePlay(version.getDown_url());
            }

            @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
            public void cancel() {
                MainActivity.this.mainViewModel.getUpdateFinishData().setValue(true);
            }
        });
        this.updateDialog = versionUpdateDialog;
        versionUpdateDialog.show();
    }

    private void hideVersionUpdateDialog() {
        VersionUpdateDialog versionUpdateDialog = this.updateDialog;
        if (versionUpdateDialog == null || !versionUpdateDialog.isShowing()) {
            return;
        }
        this.updateDialog.dismiss();
    }

    public void downloadFromPGY() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://www.pgyer.com/1888"));
            startActivity(intent);
        } catch (Exception e) {
            DDLog.e("跳转失败：" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFromGooglePlay(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.ipotensic.potensicpro"));
            intent.setPackage(MainViewModel.googlePlayNew);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(BuildConfig.UpdateAppUrl));
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                } else {
                    hideVersionUpdateDialog();
                    this.mainViewModel.getUpdateFinishData().setValue(true);
                }
            }
        } catch (ActivityNotFoundException unused) {
            DDLog.e("GoogleMarket Intent not found");
        }
    }

    private void toBrowser(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$3, reason: invalid class name */
    class AnonymousClass3 implements BottomTabView.onTabChangeListener {
        AnonymousClass3() {
        }

        @Override // com.ipotensic.potensicpro.view.BottomTabView.onTabChangeListener
        public void onTabChanged(int i) {
            if (i == 0) {
                MainActivity.this.mainDeviceController.openGuide();
            }
            DDLog.e("固件下载", "PhoneConfig.appUpgradeVersion: " + PhoneConfig.appUpgradeVersion);
            if (PhoneConfig.appUpgradeVersion) {
                MainActivity.this.upgradeFinish();
                MainActivity.this.requestUnreadMessage();
            }
        }

        @Override // com.ipotensic.potensicpro.view.BottomTabView.onTabChangeListener
        public boolean isAllowChange(int i) {
            if (i == 1) {
                if (!PermissionUtil.hasStoragePermission(MainActivity.this)) {
                    SPHelper.getInstance().putBoolean(SPHelper.KEY_IS_FIRST_ALBUM_PERMISSION_SHOW, true);
                    PermissionUtil.requestStoragePermissionWithDialog(MainActivity.this, new AnonymousClass1());
                    return false;
                }
                if (LocalFileManager.getInstance().isScanning()) {
                    MainActivity.this.showLoadingDialog(false);
                    LocalFileManager.getInstance().setScanningListener(new OnResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainActivity.3.2
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onFailed(Exception exc) {
                        }

                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(Boolean bool) {
                            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.3.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        MainActivity.this.dismissLoadingDialog();
                                        MainActivity.this.bottomTabView.setCurTab(1);
                                    } catch (Exception unused) {
                                    }
                                }
                            });
                        }
                    });
                    return false;
                }
            }
            return true;
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$3$1, reason: invalid class name */
        class AnonymousClass1 implements PermissionUtil.OnPermissionListener {
            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDenied() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onDeniedWithNeverAsk(String... strArr) {
            }

            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
            public void onGrant() {
                MainActivity.this.showLoadingDialog(false);
                LocalFileManager.getInstance().scanAlbum(new OnResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainActivity.3.1.1
                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onFailed(Exception exc) {
                    }

                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onSuccess(Boolean bool) {
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.3.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    MainActivity.this.dismissLoadingDialog();
                                    MainActivity.this.bottomTabView.setCurTab(1);
                                } catch (Exception unused) {
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public void requestUnreadMessage() {
        if (PhoneConfig.usrToken != null) {
            UserRequestPresenter.getInstance().getUnreadMessage(PhoneConfig.usrToken, this);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PhoneConfig.isMainActivityRunning = true;
        PhoneConfig.isMainActivityPause = false;
        requestUnreadMessage();
        this.mainDeviceController.onResume();
        this.mainViewModel.checkAppVersionUpdate();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        PhoneConfig.isMainActivityPause = true;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        PhoneConfig.isMainActivityRunning = false;
        this.mainMeController.onDestroy();
        this.mainDeviceController.onDestroy();
        this.mainViewModel.release();
        NetworkStateReceiver.getInstance().removeCallback(this);
        DataManager.getInstance().resetSetting();
        DataManager.getInstance().close();
        UserRequestPresenter.getInstance().removeUnreadMesView();
        super.onDestroy();
    }

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onNetworkChanged(NetworkType networkType) {
        this.mainViewModel.checkAppVersionUpdate();
        DDLog.i("是否连接飞机:" + PhoneConfig.isConnectFlightWifi());
        if (!PhoneConfig.isConnectFlightWifi()) {
            if (UsbConfig.isUsbConnected && FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevVersionData().getFlightControlVersion() != null) {
                this.mainDeviceController.changeModelBg();
            }
        } else if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevVersionData().getFlightControlVersion() != null) {
            this.mainDeviceController.changeModelBg();
        } else {
            DataManager.getInstance().connect();
        }
        if (networkType.equals(NetworkType.TYPE_NONE)) {
            FwDownloadHelper.getInstance().release(this);
            this.mainDeviceController.showUpgradeButton(false);
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.exitTime > System.currentTimeMillis()) {
            this.exitTime = 0L;
        }
        if (System.currentTimeMillis() - this.exitTime > SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.exitTime = System.currentTimeMillis();
        } else {
            ActivityHelper.getInstance().exitApp();
            super.onBackPressed();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mainMeController.getClass();
        if (i == 100) {
            this.mainMeController.onActivityResult(i, i2, intent);
            return;
        }
        this.mainMediaController.getClass();
        if (i != 98) {
            this.mainMediaController.getClass();
            if (i != 99) {
                this.mainDeviceController.getClass();
                if (i != 102) {
                    this.mainDeviceController.getClass();
                    if (i != 101) {
                        this.mainDeviceController.getClass();
                        if (i != 103) {
                            return;
                        }
                    }
                }
                this.mainDeviceController.onActivityResult(i, i2, intent);
                return;
            }
        }
        this.mainMediaController.onActivityResult(i, i2, intent);
    }

    @Override // com.logan.user.view.IUnreadMsgView
    public void getUnreadNum(int i) {
        MainMeController mainMeController = this.mainMeController;
        if (mainMeController != null) {
            mainMeController.setUnReadNum(i);
        }
        this.bottomTabView.showRedPoint(i);
        this.mainMeController.showFeedbackMsg();
    }

    public void upgradeFinish() {
        DDLog.e("固件下载:获取固件信息0 :" + (!SPHelper.getInstance().getIsBigPackage()));
        if (BaseSyncDialog.isShow || SPHelper.getInstance().getIsBigPackage()) {
            return;
        }
        DDLog.e("固件下载:获取固件信息");
        FlightFirmwareChecker.getInstance().checkFirmwareVersion(this, false, this.onResultListener);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_UPGRADE_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        MainDeviceController mainDeviceController;
        switch (AnonymousClass6.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                if (((FlightRevVersionData) event.obj) != null && (mainDeviceController = this.mainDeviceController) != null) {
                    mainDeviceController.changeModelBg();
                    break;
                }
                break;
            case 2:
                MainDeviceController mainDeviceController2 = this.mainDeviceController;
                if (mainDeviceController2 != null) {
                    mainDeviceController2.changeModelBg();
                    break;
                }
                break;
            case 3:
                FlightRevUpgradeData flightRevUpgradeData = (FlightRevUpgradeData) event.obj;
                FlightConfig.setFlightType(flightRevUpgradeData.getUpgradeType());
                MainDeviceController mainDeviceController3 = this.mainDeviceController;
                if (mainDeviceController3 != null) {
                    mainDeviceController3.changeModelBg();
                }
                EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
                if (flightRevUpgradeData.isUpgradeMode()) {
                    Flight[] values = Flight.values();
                    Version version = null;
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            Flight flight = values[i];
                            if (flightRevUpgradeData.getUpgradeType() == flight.getFlightByte()) {
                                version = FwDownloadManager.getInstance().getNewFlightControlVersion(true);
                            } else if (flightRevUpgradeData.getUpgradeType() == flight.getRcByte()) {
                                version = FwDownloadManager.getInstance().getNewRemoterVersion(true);
                            } else if (flightRevUpgradeData.getUpgradeType() == flight.getGimbalByte()) {
                                version = FwDownloadManager.getInstance().getNewGimbalVersion(true);
                            } else if (flight.isBatteryBytes(flightRevUpgradeData.getUpgradeType())) {
                                version = FwDownloadManager.getInstance().getNewBatteryVersion(true);
                            } else {
                                i++;
                            }
                        }
                    }
                    if (version == null) {
                        DDLog.e("没有升级固件");
                        SPHelper.getInstance().setNeedDownloadFw(true);
                        if (!this.isRevUpgradeMode) {
                            this.isRevUpgradeMode = true;
                            FlightFirmwareChecker.getInstance().checkFirmwareVersion(this, false, this.onResultListener);
                            break;
                        }
                    }
                }
                break;
            case 4:
                if (!((Boolean) event.obj).booleanValue()) {
                    this.mainDeviceController.showUpgradeButton(false);
                }
                EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
                break;
            case 5:
            case 6:
            case 7:
                EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
                break;
        }
    }
}

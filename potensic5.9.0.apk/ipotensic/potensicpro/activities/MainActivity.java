package com.ipotensic.potensicpro.activities;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.listener.OnNetworkChangeListener;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.manager.FlightFirmwareChecker;
import com.ipotensic.kernel.maps.utils.NoFlyZoneUtil;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.kernel.utils.FwDownloadHelper;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.BuildConfig;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.MainMediaController;
import com.ipotensic.potensicpro.models.MainViewModel;
import com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
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
import java.util.Objects;

/* loaded from: classes2.dex */
public class MainActivity extends BaseActivity implements OnNetworkChangeListener, IUnreadMsgView, EventDispatcher.OnEventListener {
    private static final String LOGIN_SUCCESS = "login_success";
    private static final int TAB_ACADEMY = 1;
    private static final int TAB_DEVICE = 0;
    private static final int TAB_GALLERY = 2;
    private static final int TAB_ME = 3;
    private TextView btnTabAcademy;
    private TextView btnTabDevice;
    private TextView btnTabGallery;
    private TextView btnTabMe;
    private long exitTime;
    private LinearLayout layoutBottomTab;
    private MainAcademyController mainAcademyController;
    private MainDeviceController mainDeviceController;
    private MainMeController mainMeController;
    private MainMediaController mainMediaController;
    private MainViewModel mainViewModel;
    private VersionUpdateDialog updateDialog;
    private GeneralDialog updateNoFlyZoneDataDialog;
    private boolean isRevUpgradeMode = false;
    private final MainMediaController.MediaControllerListener mediaControllerListener = new MainMediaController.MediaControllerListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.6
        AnonymousClass6() {
        }

        @Override // com.ipotensic.potensicpro.activities.MainMediaController.MediaControllerListener
        public void setSelectUI(boolean z) {
            if (MainActivity.this.layoutBottomTab != null) {
                MainActivity.this.layoutBottomTab.setVisibility(z ? 4 : 0);
            }
        }
    };
    private FwDownloadHelper.DownloadResultListener onResultListener = new FwDownloadHelper.DownloadResultListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.9
        @Override // com.ipotensic.kernel.utils.FwDownloadHelper.DownloadResultListener
        public void downloadRequest() {
        }

        AnonymousClass9() {
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
    private final Runnable timeoutRunnable = new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.10
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.isRevUpgradeMode = false;
        }
    };

    static /* synthetic */ void lambda$initObserver$3(Boolean bool) {
    }

    @Override // com.ipotensic.baselib.listener.OnNetworkChangeListener
    public void onCellularStateChanged(boolean z) {
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_main);
        MainViewModel mainViewModel = (MainViewModel) new ViewModelProvider(this).get(MainViewModel.class);
        this.mainViewModel = mainViewModel;
        mainViewModel.isAtomSeries().setValue(Boolean.valueOf(FlightConfig.is_Atom_Series()));
        LocalFileManager.getInstance().initExternalDir();
        if (PermissionUtil.hasStoragePermission(this)) {
            LocalFileManager.getInstance().initMediaDir();
            LocalFileManager.getInstance().clearCacheDir();
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$ytOBURCJNndg7S1Lls3f9WILnUY
                public /* synthetic */ $$Lambda$MainActivity$ytOBURCJNndg7S1Lls3f9WILnUY() {
                }

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
        this.mainAcademyController = new MainAcademyController(this, (ViewStub) findViewById(R.id.stub_academy));
        MainMediaController mainMediaController = new MainMediaController(this, (ViewStub) findViewById(R.id.stub_media));
        this.mainMediaController = mainMediaController;
        mainMediaController.setMediaControllerListener(this.mediaControllerListener);
        this.mainMeController = new MainMeController(this, (ViewStub) findViewById(R.id.stub_me));
        this.layoutBottomTab = (LinearLayout) findViewById(R.id.layoutBottomTab);
        this.btnTabDevice = (TextView) findViewById(R.id.btnTabDevice);
        this.btnTabAcademy = (TextView) findViewById(R.id.btnTabAcademy);
        this.btnTabGallery = (TextView) findViewById(R.id.btnTabGallery);
        this.btnTabMe = (TextView) findViewById(R.id.btnTabMe);
        this.btnTabDevice.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.1
            AnonymousClass1() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainActivity.this.setCurrentTab(0);
            }
        });
        this.btnTabAcademy.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.2
            AnonymousClass2() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainActivity.this.setCurrentTab(1);
            }
        });
        this.btnTabGallery.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.3
            AnonymousClass3() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainActivity.this.setCurrentTab(2);
            }
        });
        this.btnTabMe.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.4
            AnonymousClass4() {
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                MainActivity.this.setCurrentTab(3);
            }
        });
        initRequest();
        initObserver();
        setCurrentTab(0);
    }

    public /* synthetic */ void lambda$onCreate$0$MainActivity() {
        this.mainViewModel.uploadDumpLog();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$1 */
    class AnonymousClass1 extends ScaleClickListener {
        AnonymousClass1() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainActivity.this.setCurrentTab(0);
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$2 */
    class AnonymousClass2 extends ScaleClickListener {
        AnonymousClass2() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainActivity.this.setCurrentTab(1);
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$3 */
    class AnonymousClass3 extends ScaleClickListener {
        AnonymousClass3() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainActivity.this.setCurrentTab(2);
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$4 */
    class AnonymousClass4 extends ScaleClickListener {
        AnonymousClass4() {
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            MainActivity.this.setCurrentTab(3);
        }
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
            public /* synthetic */ $$Lambda$MainActivity$Z8I6RugYoP9ujg6m8ceE_cEpwFk() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$initObserver$1$MainActivity((RevUserAppVersionData.Version) obj);
            }
        });
        this.mainViewModel.getUpdateFinishData().observe(this, new Observer() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$q7XTrz9U6wCGQ1HxiiuTMUvhwbQ
            public /* synthetic */ $$Lambda$MainActivity$q7XTrz9U6wCGQ1HxiiuTMUvhwbQ() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$initObserver$2$MainActivity((Boolean) obj);
            }
        });
        this.mainViewModel.isAtomSeries().observe(this, $$Lambda$MainActivity$EffjaXnlewjLRAcGSIIgBFzpA_E.INSTANCE);
        this.mainViewModel.getCurrentTab().observe(this, new Observer() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$9PwPb2dL1nSfMWOkVviBEB_9Mv0
            public /* synthetic */ $$Lambda$MainActivity$9PwPb2dL1nSfMWOkVviBEB_9Mv0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$initObserver$4$MainActivity((Integer) obj);
            }
        });
        this.mainViewModel.getUnReadNum().observe(this, new Observer() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$5wIofwL9-CXCLy8hu21nEaw9R5c
            public /* synthetic */ $$Lambda$MainActivity$5wIofwL9CXCLy8hu21nEaw9R5c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$initObserver$5$MainActivity((Integer) obj);
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

    public /* synthetic */ void lambda$initObserver$4$MainActivity(Integer num) {
        TextView textView = this.btnTabDevice;
        int intValue = num.intValue();
        int i = R.color.text_color_setting_blue;
        textView.setTextColor(getColor(intValue == 0 ? R.color.text_color_setting_blue : R.color.color_main_media_indicator_gray));
        this.btnTabAcademy.setTextColor(getColor(num.intValue() == 1 ? R.color.text_color_setting_blue : R.color.color_main_media_indicator_gray));
        this.btnTabGallery.setTextColor(getColor(num.intValue() == 2 ? R.color.text_color_setting_blue : R.color.color_main_media_indicator_gray));
        TextView textView2 = this.btnTabMe;
        if (num.intValue() != 3) {
            i = R.color.color_main_media_indicator_gray;
        }
        textView2.setTextColor(getColor(i));
        ViewUtils.setDrawableTop(this.btnTabDevice, num.intValue() == 0 ? R.mipmap.img_btn_main_tab_equipme_selected : R.mipmap.img_btn_main_tab_equipme_normal);
        ViewUtils.setDrawableTop(this.btnTabAcademy, num.intValue() == 1 ? R.mipmap.icon_academy_selected : R.mipmap.icon_academy_normal);
        ViewUtils.setDrawableTop(this.btnTabGallery, num.intValue() == 2 ? R.mipmap.img_btn_main_tab_media_selected : R.mipmap.img_btn_main_tab_media_normal);
        setTabUnReadView();
        this.mainDeviceController.setVisibility(num.intValue() == 0 ? 0 : 8);
        this.mainAcademyController.setVisibility(num.intValue() == 1 ? 0 : 8);
        this.mainMediaController.setVisibility(num.intValue() == 2 ? 0 : 8);
        this.mainMeController.setVisibility(num.intValue() != 3 ? 8 : 0);
    }

    public /* synthetic */ void lambda$initObserver$5$MainActivity(Integer num) {
        setTabUnReadView();
    }

    public void setCurrentTab(int i) {
        Integer value = this.mainViewModel.getCurrentTab().getValue();
        if (value != null && value.intValue() != i && isAllowChange(i)) {
            this.mainViewModel.getCurrentTab().setValue(Integer.valueOf(i));
        }
        if (i == 0) {
            this.mainDeviceController.openGuide();
        }
        DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d", "PhoneConfig.appUpgradeVersion: " + PhoneConfig.appUpgradeVersion);
        if (PhoneConfig.appUpgradeVersion) {
            upgradeFinish();
            requestUnreadMessage();
        }
    }

    private void setTabUnReadView() {
        Integer value = this.mainViewModel.getCurrentTab().getValue();
        Integer value2 = this.mainViewModel.getUnReadNum().getValue();
        if (value == null || value2 == null) {
            return;
        }
        if (value.intValue() == 3) {
            ViewUtils.setDrawableTop(this.btnTabMe, value2.intValue() > 0 ? R.drawable.bg_tab_me_unread_selected : R.mipmap.img_btn_main_tab_me_selected);
        } else {
            ViewUtils.setDrawableTop(this.btnTabMe, value2.intValue() > 0 ? R.drawable.bg_tab_me_unread_normal : R.mipmap.img_btn_main_tab_me_normal);
        }
    }

    private void showVersionUpdateDialog(RevUserAppVersionData.Version version) {
        if (BaseSyncDialog.isShow) {
            return;
        }
        VersionUpdateDialog versionUpdateDialog = new VersionUpdateDialog(this, version.getAppver(), version.getContent(), version.getIsforceupdate(), new VersionUpdateDialog.OnItemClickListener() { // from class: com.ipotensic.potensicpro.activities.MainActivity.5
            final /* synthetic */ RevUserAppVersionData.Version val$version;

            AnonymousClass5(RevUserAppVersionData.Version version2) {
                r2 = version2;
            }

            @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
            public void toUpdate() {
                MainActivity.this.downloadFromGooglePlay(r2.getDown_url());
            }

            @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
            public void cancel() {
                MainActivity.this.mainViewModel.getUpdateFinishData().setValue(true);
            }
        });
        this.updateDialog = versionUpdateDialog;
        versionUpdateDialog.show();
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$5 */
    class AnonymousClass5 implements VersionUpdateDialog.OnItemClickListener {
        final /* synthetic */ RevUserAppVersionData.Version val$version;

        AnonymousClass5(RevUserAppVersionData.Version version2) {
            r2 = version2;
        }

        @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
        public void toUpdate() {
            MainActivity.this.downloadFromGooglePlay(r2.getDown_url());
        }

        @Override // com.ipotensic.potensicpro.view.dialog.VersionUpdateDialog.OnItemClickListener
        public void cancel() {
            MainActivity.this.mainViewModel.getUpdateFinishData().setValue(true);
        }
    }

    private void hideVersionUpdateDialog() {
        VersionUpdateDialog versionUpdateDialog = this.updateDialog;
        if (versionUpdateDialog == null || !versionUpdateDialog.isShowing()) {
            return;
        }
        this.updateDialog.dismiss();
    }

    private void showUpdateNoFlyZoneDataDialog() {
        if (this.updateNoFlyZoneDataDialog == null) {
            this.updateNoFlyZoneDataDialog = new GeneralDialog((Context) this, false, getString(R.string.popup_drone_safety_data_needs_updating_title), getString(R.string.popup_drone_safety_data_needs_updating_tips), getString(R.string.button_copy_address_and_close), (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.-$$Lambda$MainActivity$nMKpB23HnQo757Q7VAHlYp5YFxw
                public /* synthetic */ $$Lambda$MainActivity$nMKpB23HnQo757Q7VAHlYp5YFxw() {
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public final void confirm() {
                    MainActivity.this.lambda$showUpdateNoFlyZoneDataDialog$6$MainActivity();
                }
            });
        }
        if (this.updateNoFlyZoneDataDialog.isShowing()) {
            return;
        }
        this.updateNoFlyZoneDataDialog.show();
    }

    public /* synthetic */ void lambda$showUpdateNoFlyZoneDataDialog$6$MainActivity() {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newUri(null, null, Uri.parse(NoFlyZoneUtil.NO_FLY_ZONE_DATA_DOWNLOAD_URL)));
        String flightSN = FlightRevData.get().getFlightRevVersionData().getFlightSN();
        SPHelper.getInstance().setShowUpdateNoFlyZoneData(flightSN, false);
        DDLog.e("showUpdateNoFlyZoneDataDialog isShow:" + SPHelper.getInstance().isShowUpdateNoFlyZoneData(flightSN) + ",sn=" + flightSN);
    }

    private void hideUpdateNoFlyZoneDataDialog() {
        GeneralDialog generalDialog = this.updateNoFlyZoneDataDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.updateNoFlyZoneDataDialog.dismiss();
        this.updateNoFlyZoneDataDialog = null;
    }

    public void downloadFromPGY() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://www.pgyer.com/1888"));
            startActivity(intent);
        } catch (Exception e) {
            DDLog.e("\u8df3\u8f6c\u5931\u8d25\uff1a" + e.getMessage());
        }
    }

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

    private void goHWMarket() {
        Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withid");
        intent.setPackage("com.huawei.appmarket");
        intent.putExtra("appId", "110544063");
        startActivity(intent);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$6 */
    class AnonymousClass6 implements MainMediaController.MediaControllerListener {
        AnonymousClass6() {
        }

        @Override // com.ipotensic.potensicpro.activities.MainMediaController.MediaControllerListener
        public void setSelectUI(boolean z) {
            if (MainActivity.this.layoutBottomTab != null) {
                MainActivity.this.layoutBottomTab.setVisibility(z ? 4 : 0);
            }
        }
    }

    public boolean isAllowChange(int i) {
        if (i == 2) {
            if (!PermissionUtil.hasStoragePermission(this)) {
                SPHelper.getInstance().putBoolean(SPHelper.KEY_IS_FIRST_ALBUM_PERMISSION_SHOW, true);
                PermissionUtil.requestStoragePermissionWithDialog(this, new AnonymousClass7());
                return false;
            }
            if (LocalFileManager.getInstance().isScanning()) {
                showLoadingDialog(false);
                LocalFileManager.getInstance().setScanningListener(new OnResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainActivity.8
                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onFailed(Exception exc) {
                    }

                    AnonymousClass8() {
                    }

                    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$8$1 */
                    class AnonymousClass1 implements Runnable {
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                MainActivity.this.dismissLoadingDialog();
                                MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                            } catch (Exception unused) {
                            }
                        }
                    }

                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onSuccess(Boolean bool) {
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.8.1
                            AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    MainActivity.this.dismissLoadingDialog();
                                    MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
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

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$7 */
    class AnonymousClass7 implements PermissionUtil.OnPermissionListener {
        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass7() {
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$7$1 */
        class AnonymousClass1 implements OnResultListener<Boolean> {
            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onFailed(Exception exc) {
            }

            AnonymousClass1() {
            }

            /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$7$1$1 */
            class RunnableC00901 implements Runnable {
                RunnableC00901() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MainActivity.this.dismissLoadingDialog();
                        MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onSuccess(Boolean bool) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.7.1.1
                    RunnableC00901() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            MainActivity.this.dismissLoadingDialog();
                            MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            MainActivity.this.showLoadingDialog(false);
            LocalFileManager.getInstance().scanAlbum(new OnResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainActivity.7.1
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                }

                AnonymousClass1() {
                }

                /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$7$1$1 */
                class RunnableC00901 implements Runnable {
                    RunnableC00901() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            MainActivity.this.dismissLoadingDialog();
                            MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                        } catch (Exception unused) {
                        }
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Boolean bool) {
                    MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.7.1.1
                        RunnableC00901() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                MainActivity.this.dismissLoadingDialog();
                                MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            });
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$8 */
    class AnonymousClass8 implements OnResultListener<Boolean> {
        @Override // com.ipotensic.baselib.okhttp.OnResultListener
        public void onFailed(Exception exc) {
        }

        AnonymousClass8() {
        }

        /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$8$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    MainActivity.this.dismissLoadingDialog();
                    MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.ipotensic.baselib.okhttp.OnResultListener
        public void onSuccess(Boolean bool) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainActivity.8.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MainActivity.this.dismissLoadingDialog();
                        MainActivity.this.mainViewModel.getCurrentTab().setValue(2);
                    } catch (Exception unused) {
                    }
                }
            });
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
        DDLog.i("\u662f\u5426\u8fde\u63a5\u98de\u673a:" + PhoneConfig.isConnectFlightWifi());
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

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$9 */
    class AnonymousClass9 implements FwDownloadHelper.DownloadResultListener {
        @Override // com.ipotensic.kernel.utils.FwDownloadHelper.DownloadResultListener
        public void downloadRequest() {
        }

        AnonymousClass9() {
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
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mainViewModel.getCurrentTab().getValue() != null && this.mainViewModel.getCurrentTab().getValue().intValue() == 1 && this.mainAcademyController.getVisibility() == 0 && this.mainAcademyController.onBackPressed()) {
            return;
        }
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
        Objects.requireNonNull(this.mainMeController);
        if (i == 100) {
            this.mainMeController.onActivityResult(i, i2, intent);
            return;
        }
        Objects.requireNonNull(this.mainMediaController);
        if (i != 98) {
            Objects.requireNonNull(this.mainMediaController);
            if (i != 99) {
                Objects.requireNonNull(this.mainDeviceController);
                if (i != 102) {
                    Objects.requireNonNull(this.mainDeviceController);
                    if (i != 101) {
                        Objects.requireNonNull(this.mainDeviceController);
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
        this.mainViewModel.getUnReadNum().setValue(Integer.valueOf(i));
        this.mainMeController.showFeedbackMsg();
    }

    public void upgradeFinish() {
        DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d:\u83b7\u53d6\u56fa\u4ef6\u4fe1\u606f0 :" + (!SPHelper.getInstance().getIsBigPackage()));
        if (BaseSyncDialog.isShow || SPHelper.getInstance().getIsBigPackage()) {
            return;
        }
        DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d:\u83b7\u53d6\u56fa\u4ef6\u4fe1\u606f");
        FlightFirmwareChecker.getInstance().checkFirmwareVersion(this, false, this.onResultListener);
    }

    private void initCameraParams() {
        if (UsbConfig.isUsbConnected || FlightConfig.isConnectFlightSocket) {
            DDLog.e("initCameraParams");
            CameraCtrlPresenter.getInstance().getConfigMenu();
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$11 */
    static /* synthetic */ class AnonymousClass11 {
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
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_GET_CONFIG_MENU_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_VERSION_INFO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        MainDeviceController mainDeviceController;
        switch (AnonymousClass11.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
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
                }
                this.mainViewModel.isAtomSeries().setValue(Boolean.valueOf(FlightConfig.is_Atom_Series()));
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
                        DDLog.e("\u6ca1\u6709\u5347\u7ea7\u56fa\u4ef6");
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
                initCameraParams();
                break;
            case 5:
            case 6:
            case 7:
                EventDispatcher.get().sendEvent(EventID.EVENT_CONNECT_STATE_CHANGED);
                break;
            case 8:
                if (PhoneConfig.isMainActivityRunning && !PhoneConfig.isMainActivityPause) {
                    CameraConfig.get().isGetConfigMenu = false;
                    break;
                }
                break;
            case 9:
                if (NoFlyZoneUtil.INSTANCE.isShowUpdateNoFlyZoneTip((String) event.obj) && PhoneConfig.isMainActivityRunning && !PhoneConfig.isMainActivityPause) {
                    showUpdateNoFlyZoneDataDialog();
                    break;
                }
                break;
        }
    }

    /* renamed from: com.ipotensic.potensicpro.activities.MainActivity$10 */
    class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.isRevUpgradeMode = false;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mainAcademyController.getVisibility() == 0) {
            this.mainAcademyController.onConfigurationChanged(configuration);
        }
    }
}
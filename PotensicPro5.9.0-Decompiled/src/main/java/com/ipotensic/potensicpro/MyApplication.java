package com.ipotensic.potensicpro;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.multidex.MultiDexApplication;
import com.bumptech.glide.request.target.ViewTarget;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.broadcasts.NetworkStateReceiver;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.okhttp.ClientManager;
import com.ipotensic.baselib.utils.AppUtils;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.SoundPoolPlayer;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.activities.LoginActivity;
import com.ipotensic.potensicpro.utils.CrashHandler;
import com.ipotensic.potensicpro.utils.FontsUtils;
import com.logan.flight.DataManager;
import com.logan.usb.AOAEngine;
import com.logan.usb.FpvLogRecorder;
import com.logan.user.presenter.UserRequestPresenter;
import com.mapbox.mapboxsdk.Mapbox;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.Objects;
import org.apache.commons.lang3.BooleanUtils;
import org.litepal.LitePal;
import xyz.doikki.videoplayer.exo.ExoMediaPlayerFactory;
import xyz.doikki.videoplayer.player.VideoViewConfig;
import xyz.doikki.videoplayer.player.VideoViewManager;

/* loaded from: classes2.dex */
public class MyApplication extends MultiDexApplication {
    private static final String TAG = "MyApplication";
    private boolean isExiting = false;
    private final Thread startThread = new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.-$$Lambda$MyApplication$usFQDTy30fk5uYCD3a0IxcZqkik
        @Override // java.lang.Runnable
        public final void run() {
            MyApplication.this.lambda$new$3$MyApplication();
        }
    });

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (Objects.equals(AppUtils.getProcessName(this), AppUtils.getPackageName(this))) {
            SPHelper.getInstance().init(this);
            CrashHandler.getInstance().init(getApplicationContext());
            CrashReport.initCrashReport(getApplicationContext(), "5c32fa1cd9", true);
            NetworkStateReceiver.getInstance().register(this);
            PhoneConfig.applicationContext = this;
            PhoneConfig.curLocal = getResources().getConfiguration().locale;
            if (PhoneConfig.customTypeface == null) {
                PhoneConfig.customTypeface = Typeface.createFromAsset(getAssets(), "fonts/PingFangRegular.ttf");
            }
            PhoneConfig.typeface = PhoneConfig.customTypeface;
            FontsUtils.setDefaultFont(this, "SERIF", PhoneConfig.typeface);
            registerActivityLifecycleCallbacks(ActivityHelper.getInstance());
            SoundPoolPlayer.getInstance().init(this);
            this.startThread.start();
            AOAEngine.getInstance().init(this);
            EventDispatcher.get().registerEvent(FpvLogRecorder.getInstance().writeLogEvenListener);
            LitePal.initialize(this);
            ClientManager.getInstance().init();
            UserRequestPresenter.getInstance().setOnTokenErrorListener(new UserRequestPresenter.OnTokenErrorListener() { // from class: com.ipotensic.potensicpro.-$$Lambda$MyApplication$TdytKoB4FigU7XFms06vRPb-Zzk
                @Override // com.logan.user.presenter.UserRequestPresenter.OnTokenErrorListener
                public final void onTokenError() {
                    MyApplication.this.lambda$onCreate$2$MyApplication();
                }
            });
            initPlayer();
            try {
                Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
            } catch (Exception e) {
                DDLog.e(TAG, "初始化地图报错", e);
            }
            ViewTarget.setTagId(R.id.tag_glide);
            DataManager.getInstance().init();
            SPHelper.getInstance().setCountryCode(null);
            DDLog.e("初始化結束");
        }
    }

    public /* synthetic */ void lambda$onCreate$2$MyApplication() {
        if (ActivityHelper.getInstance().isActivityRunning(LoginActivity.class) || PhoneConfig.runningActivity == null || this.isExiting) {
            return;
        }
        this.isExiting = true;
        ToastUtil.toast(PhoneConfig.runningActivity, getResources().getString(R.string.toast_token_error));
        PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.-$$Lambda$MyApplication$nWFRRanKDR8K-CnG-jd4sWjtoNw
            @Override // java.lang.Runnable
            public final void run() {
                MyApplication.this.lambda$null$1$MyApplication();
            }
        }, 3000L);
    }

    public /* synthetic */ void lambda$null$1$MyApplication() {
        SPHelper.getInstance().clearToken();
        PhoneConfig.usrToken = null;
        PhoneConfig.runningActivity.startActivity(new Intent(PhoneConfig.runningActivity, (Class<?>) LoginActivity.class));
        PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.-$$Lambda$MyApplication$HoH5PxrjtrfOq0QspZBul1JsUtA
            @Override // java.lang.Runnable
            public final void run() {
                MyApplication.this.lambda$null$0$MyApplication();
            }
        }, 3000L);
    }

    public /* synthetic */ void lambda$null$0$MyApplication() {
        this.isExiting = false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        if (resources != null && resources.getConfiguration().fontScale != 1.0f) {
            Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    private void initPlayer() {
        VideoViewManager.setConfig(VideoViewConfig.newBuilder().setLogEnabled(false).setPlayerFactory(ExoMediaPlayerFactory.create()).setEnableOrientation(false).build());
    }

    public /* synthetic */ void lambda$new$3$MyApplication() {
        try {
            if (PhoneConfig.sourceHanSansCN == null) {
                PhoneConfig.sourceHanSansCN = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Heavy.ttf");
            }
            PhoneConfig.usrToken = SPHelper.getInstance().getToken();
            String fileProviderAuthority = CommonUtil.getFileProviderAuthority(this);
            if (fileProviderAuthority == null) {
                fileProviderAuthority = "com.ipotensic.potensicpro.fileprovider";
            }
            PhoneConfig.fileProviderAuthority = fileProviderAuthority;
            boolean appFirstInstall = SPHelper.getInstance().getAppFirstInstall();
            if (appFirstInstall) {
                SPHelper.getInstance().setHardDecode(false);
            }
            PhoneConfig.isFt = SPHelper.getInstance().isFt();
            if (appFirstInstall) {
                if (getString(R.string.is_ft).equals(BooleanUtils.TRUE)) {
                    if (!PhoneConfig.isFt) {
                        PhoneConfig.isFt = true;
                        SPHelper.getInstance().setFt(true);
                    }
                } else if (PhoneConfig.isFt) {
                    PhoneConfig.isFt = false;
                    SPHelper.getInstance().setFt(false);
                }
            }
            SPHelper.getInstance().setAppFirstInstall(false);
        } catch (Exception e) {
            DDLog.e(TAG, "app启动对sp初始化失败", e);
        }
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (LanguageHelper.isTraditionalChinese(this)) {
            PhoneConfig.typeface = Typeface.DEFAULT;
            FontsUtils.setDefaultFont(this, "SERIF", PhoneConfig.typeface);
        } else {
            if (PhoneConfig.customTypeface == null) {
                PhoneConfig.customTypeface = Typeface.createFromAsset(getAssets(), "fonts/PingFangRegular.ttf");
            }
            PhoneConfig.typeface = PhoneConfig.customTypeface;
            FontsUtils.setDefaultFont(this, "SERIF", PhoneConfig.typeface);
        }
        try {
            if (Objects.equals(AppUtils.getProcessName(this), AppUtils.getPackageName(this))) {
                if (PhoneConfig.curLocal == null || !PhoneConfig.curLocal.getLanguage().equals(configuration.locale.getLanguage())) {
                    DDLog.e("语言已切换:" + configuration.locale.getLanguage());
                    PhoneConfig.curLocal = configuration.locale;
                    SoundPoolPlayer.getInstance().init(this);
                }
            }
        } catch (Exception e) {
            DDLog.e("切换语言出错:" + e);
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        DDLog.e("onTerminate");
        AOAEngine.getInstance().onDestroy();
        EventDispatcher.get().unRegisterEvent(FpvLogRecorder.getInstance().writeLogEvenListener);
        FpvLogRecorder.getInstance().finish();
        NetworkStateReceiver.getInstance().unRegister(this);
        SoundPoolPlayer.getInstance().release();
        super.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        DDLog.w("onLowMemory");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        DDLog.w("onTrimMemory :" + i);
    }
}

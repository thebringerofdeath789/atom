package com.ipotensic.kernel.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.DownloadListener2;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.databinding.ActivityBigPackageBinding;
import com.ipotensic.kernel.enums.FwType;
import com.ipotensic.kernel.fragment.UpgradeQuestionFragment;
import com.ipotensic.kernel.manager.BigPackageFirmwareDownload;
import com.ipotensic.kernel.model.BigPackageViewModel;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.upgrade.big.BigPackageHelper;
import com.logan.upgrade.enums.BigPackageUpgradeStage;
import com.logan.upgrade.enums.BigPackageUploadFailType;
import com.logan.upgrade.server.Version;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class BigPackageActivity extends BaseActivity implements EventDispatcher.OnEventListener, DownloadListener2 {
    private static final String TAG = "BigPackageActivity";
    private static boolean isOpenBigPackageActivity = false;
    private ActivityBigPackageBinding binding;
    private FwUpgradeConditionDialog fwUpgradeConditionDialog;
    private BigPackageViewModel model;
    private ArrayList<Version.ProductData> typeList;
    private BigPackageHelper.UpgradeInfo upgradeInfo;
    private boolean isNeedFormatSdcard = false;
    private int retryNum = -1;
    private FwType type = FwType.NONE;

    @Override // com.ipotensic.baselib.okhttp.DownloadListener2
    public void onDownloadFinished() {
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityBigPackageBinding) DataBindingUtil.setContentView(this, R.layout.activity_big_package);
        BigPackageViewModel bigPackageViewModel = (BigPackageViewModel) new ViewModelProvider(this).get(BigPackageViewModel.class);
        this.model = bigPackageViewModel;
        this.binding.setBigPackageViewModel(bigPackageViewModel);
        this.binding.setLifecycleOwner(this);
        EventDispatcher.get().registerEvent(getLifecycle(), this);
        initView();
        requestData();
        DDLog.e("\u5927\u5305 BigPackageActivity onCreate");
    }

    public void requestData() {
        getLocalBigPackageVersionTypeList();
        Intent intent = getIntent();
        if (intent != null) {
            this.model.isNeedDownloadFw.setValue(Boolean.valueOf(intent.getBooleanExtra(BigPackageHelper.NEED_DOWNLOAD_FILE, true)));
            this.model.isUpgrading.setValue(Boolean.valueOf(intent.getBooleanExtra(BigPackageHelper.UPGRADING_PROGRESS, false)));
            this.model.upgradingProgress.setValue(Integer.valueOf(intent.getIntExtra(BigPackageHelper.UPGRADING_PROGRESS_VALUE, 0)));
            this.model.upgradingTotalProgress.setValue(Integer.valueOf(intent.getIntExtra(BigPackageHelper.UPGRADING_TOTAL_PROGRESS_VALUE, 0)));
            this.model.upgradingState.setValue(Integer.valueOf(intent.getIntExtra(BigPackageHelper.UPGRADING_STATE, 0)));
            DDLog.e(TAG, "\u5927\u5305\u662f\u5426\u9700\u8981\u4e0b\u8f7d\uff1a " + this.model.isNeedDownloadFw.getValue() + ", \u662f\u5426\u5347\u7ea7\u72b6\u6001: " + this.model.isUpgrading.getValue() + ", upgradingProgress: " + this.model.upgradingProgress.getValue() + ", upgradingTotalProgress: " + this.model.upgradingTotalProgress.getValue());
        }
        if (!this.model.isUpgrading.getValue().booleanValue()) {
            DDLog.e(TAG, "requestData isUpgrading false");
            if (this.model.isNeedDownloadFw.getValue().booleanValue()) {
                DDLog.e("\u5927\u5305 \u5f00\u59cb\u4e0b\u8f7d");
                startBigPackageDownload();
                return;
            } else {
                DDLog.e("\u5927\u5305 \u5f00\u59cb\u68c0\u6d4b");
                enterDetectionModel();
                return;
            }
        }
        DDLog.e(TAG, "requestData isUpgrading true");
        if (this.binding.scrollViewDownloadTips.getVisibility() == 0) {
            this.binding.scrollViewDownloadTips.setVisibility(8);
        }
        if (this.binding.scrollViewCheckCondition.getVisibility() != 0) {
            this.binding.scrollViewCheckCondition.setVisibility(0);
            this.binding.scrollViewUpgradeTips.setVisibility(0);
        }
        setCurUpgradeStateView(this.model.upgradingState.getValue().intValue());
    }

    public static synchronized void startBigPackageActivity(Activity activity, BigPackageHelper.UpgradeInfo upgradeInfo) {
        synchronized (BigPackageActivity.class) {
            DDLog.e("\u5927\u5305 isOpenBigPackageActivity= " + isOpenBigPackageActivity);
            if (!isOpenBigPackageActivity) {
                isOpenBigPackageActivity = true;
                if (!ActivityHelper.getInstance().isActivityRunning(BigPackageActivity.class)) {
                    Intent intent = new Intent(activity, (Class<?>) BigPackageActivity.class);
                    intent.putExtra(BigPackageHelper.NEED_DOWNLOAD_FILE, false);
                    intent.putExtra(BigPackageHelper.UPGRADING_PROGRESS, true);
                    intent.putExtra(BigPackageHelper.UPGRADING_PROGRESS_VALUE, upgradeInfo != null ? upgradeInfo.getProgress() : 0);
                    intent.putExtra(BigPackageHelper.UPGRADING_TOTAL_PROGRESS_VALUE, upgradeInfo != null ? upgradeInfo.getTotalProgress() : 0);
                    intent.putExtra(BigPackageHelper.UPGRADING_STATE, upgradeInfo != null ? upgradeInfo.getState() : 0);
                    activity.startActivity(intent);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        BigPackageHelper.get().interruptUploadFile();
        finishActivity();
        DDLog.e("\u5927\u5305 BigPackageActivity onStop");
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DDLog.e("\u5927\u5305 BigPackageActivity onDestroy");
        isOpenBigPackageActivity = false;
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$1 */
    class AnonymousClass1 extends ScaleClickListener {
        AnonymousClass1(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (BigPackageActivity.this.isNeedFormatSdcard) {
                CameraCtrlPresenter.getInstance().formatSdCard();
            }
        }
    }

    private void initView() {
        this.binding.tvFormatSd.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.1
            AnonymousClass1(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (BigPackageActivity.this.isNeedFormatSdcard) {
                    CameraCtrlPresenter.getInstance().formatSdCard();
                }
            }
        });
        this.binding.btnClose.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.2
            AnonymousClass2(Integer num) {
                super(num);
            }

            /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$2$1 */
            class AnonymousClass1 implements FwUpgradeConditionDialog.FwDownLoadListener {
                @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                public void startDownLoad() {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                public void cancelDownLoad() {
                    BigPackageActivity.this.finishActivity();
                }
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.fwUpgradeConditionDialog = new FwUpgradeConditionDialog(BigPackageActivity.this, new FwUpgradeConditionDialog.FwDownLoadListener() { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.2.1
                    @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                    public void startDownLoad() {
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                    public void cancelDownLoad() {
                        BigPackageActivity.this.finishActivity();
                    }
                });
                BigPackageActivity.this.fwUpgradeConditionDialog.show();
            }
        });
        this.binding.layoutUpgradeFinished.btnUpgradeFinishedClose.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.3
            AnonymousClass3(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.finishActivity();
                ActivityHelper.getInstance().finishAllActivity(KernelActivity.class);
            }
        });
        this.binding.layoutTransferFail.btnUpgradeExit.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.4
            AnonymousClass4(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.finishActivity();
            }
        });
        this.binding.layoutTransferFail.btnUpgradeRetry.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.5
            AnonymousClass5(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.binding.layoutTransferFail.getRoot().setVisibility(8);
                BigPackageActivity.this.requestData();
            }
        });
        this.binding.layoutTransferFail.btnTransferExit.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.6
            AnonymousClass6(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.finishActivity();
            }
        });
        this.binding.layoutTransferFail.tvUpgradeFailFaqs.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.7
            AnonymousClass7(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_upgrade_question, new UpgradeQuestionFragment()).commitAllowingStateLoss();
            }
        });
        this.binding.layoutTransferFail.btnUpgradeFailClose.setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.8
            AnonymousClass8(Integer num) {
                super(num);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                BigPackageActivity.this.finishActivity();
            }
        });
        this.model.upgradingTotalProgress.observe(this, new Observer() { // from class: com.ipotensic.kernel.activitys.-$$Lambda$BigPackageActivity$Haif_jcHj0uCJf7IBekpQ8G23jI
            public /* synthetic */ $$Lambda$BigPackageActivity$Haif_jcHj0uCJf7IBekpQ8G23jI() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BigPackageActivity.this.lambda$initView$0$BigPackageActivity((Integer) obj);
            }
        });
        this.model.upgradingProgress.observe(this, new Observer() { // from class: com.ipotensic.kernel.activitys.-$$Lambda$BigPackageActivity$lROU47HYYFZTrBZW2uQ4rKzySGw
            public /* synthetic */ $$Lambda$BigPackageActivity$lROU47HYYFZTrBZW2uQ4rKzySGw() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BigPackageActivity.this.lambda$initView$1$BigPackageActivity((Integer) obj);
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$2 */
    class AnonymousClass2 extends ScaleClickListener {
        AnonymousClass2(Integer num) {
            super(num);
        }

        /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$2$1 */
        class AnonymousClass1 implements FwUpgradeConditionDialog.FwDownLoadListener {
            @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
            public void startDownLoad() {
            }

            AnonymousClass1() {
            }

            @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
            public void cancelDownLoad() {
                BigPackageActivity.this.finishActivity();
            }
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.fwUpgradeConditionDialog = new FwUpgradeConditionDialog(BigPackageActivity.this, new FwUpgradeConditionDialog.FwDownLoadListener() { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.2.1
                @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                public void startDownLoad() {
                }

                AnonymousClass1() {
                }

                @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                public void cancelDownLoad() {
                    BigPackageActivity.this.finishActivity();
                }
            });
            BigPackageActivity.this.fwUpgradeConditionDialog.show();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$3 */
    class AnonymousClass3 extends ScaleClickListener {
        AnonymousClass3(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.finishActivity();
            ActivityHelper.getInstance().finishAllActivity(KernelActivity.class);
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$4 */
    class AnonymousClass4 extends ScaleClickListener {
        AnonymousClass4(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.finishActivity();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$5 */
    class AnonymousClass5 extends ScaleClickListener {
        AnonymousClass5(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.binding.layoutTransferFail.getRoot().setVisibility(8);
            BigPackageActivity.this.requestData();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$6 */
    class AnonymousClass6 extends ScaleClickListener {
        AnonymousClass6(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.finishActivity();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$7 */
    class AnonymousClass7 extends ScaleClickListener {
        AnonymousClass7(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_upgrade_question, new UpgradeQuestionFragment()).commitAllowingStateLoss();
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$8 */
    class AnonymousClass8 extends ScaleClickListener {
        AnonymousClass8(Integer num) {
            super(num);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            BigPackageActivity.this.finishActivity();
        }
    }

    public /* synthetic */ void lambda$initView$0$BigPackageActivity(Integer num) {
        this.binding.viewBigPackageDownloadUpgrade.uploadProgress(num.intValue());
    }

    public /* synthetic */ void lambda$initView$1$BigPackageActivity(Integer num) {
        this.binding.viewSingleFirmwareProgress.setUpgradeProgress(num.intValue());
        this.binding.tvSingleFwUpgradeProgress.setText(String.format("%s", num + "%"));
    }

    public void finishActivity() {
        DDLog.e("\u5927\u5305 finishActivity");
        if (this.model.isFwDownloading.getValue().booleanValue()) {
            OkHttpUtil.getInstance().cancelDownload();
        }
        release();
        finish();
    }

    private void release() {
        this.model.isCameraHighTemp.setValue(false);
        this.model.isStartCheck.setValue(false);
        this.model.isFwDownloading.setValue(false);
        this.retryNum = -1;
        this.binding.tvCountDown.stopCountDown();
        this.binding.layoutUpgradeFinished.tvUpgradeFinishedCountDown.stopCountDown();
        this.binding.viewBigPackageModuleDetection.stopCheckModule();
        this.binding.layoutBigPackageDownloadUpgrade.setVisibility(8);
        BigPackageHelper.get().release();
    }

    public void startBigPackageDownload() {
        this.binding.tvFirmwareState.setText(getString(R.string.fw_downloading));
        BigPackageFirmwareDownload.getInstance().startDownloadFirmware(this);
    }

    private void enterDetectionModel() {
        DDLog.e("\u5f00\u59cb\u5927\u5305\u5347\u7ea7\u73af\u5883\u68c0\u6d4b");
        this.binding.btnClose.setVisibility(0);
        this.binding.tvTitle.setText(getString(R.string.fw_upgrade_environment_detection_tips));
        this.binding.layoutTransferFail.getRoot().setVisibility(8);
        this.binding.viewBigPackageDownloadUpgrade.setVisibility(8);
        this.binding.layoutUpgradeState.setVisibility(8);
        this.binding.scrollViewDownloadTips.setVisibility(8);
        this.binding.scrollViewCheckCondition.setVisibility(8);
        this.binding.scrollViewUpgradeTips.setVisibility(8);
        this.binding.tvCountDown.setVisibility(8);
        this.binding.viewBigPackageModuleDetection.setVisibility(0);
        this.binding.viewBigPackageModuleDetection.startCheckModule();
        this.binding.tvCurrentDetectionModule.setVisibility(0);
        this.binding.tvCurrentDetectionModule.setText(getString(R.string.fw_module_detection_tips));
    }

    private void getLocalBigPackageVersionTypeList() {
        String localBigPackageVersion = SPHelper.getInstance().getLocalBigPackageVersion();
        if (localBigPackageVersion != null) {
            Version version = (Version) JSONObject.parseObject(localBigPackageVersion, Version.class);
            this.typeList = version.getTypeList();
            this.model.filePath.setValue(version.getLocalPath());
        }
    }

    private synchronized void startUpgradeCondition() {
        DDLog.e("\u5927\u5305\u68c0\u6d4b\u5404\u4e2a\u6a21\u5757\u6761\u4ef6");
        this.binding.tvDownloadTips.setVisibility(8);
        this.binding.tvCurrentDetectionModule.setVisibility(8);
        this.binding.viewBigPackageModuleDetection.setVisibility(8);
        this.binding.viewBigPackageDownloadUpgrade.setVisibility(0);
        this.binding.layoutUpgradeState.setVisibility(0);
        this.binding.scrollViewDownloadTips.setVisibility(0);
        DDLog.e("\u5927\u5305\u5347\u7ea7\u4ecb\u8d28\u662f\u5426\u4e3aSD\u5361\uff1a" + SPHelper.getInstance().getBigPackageUpgradeMediaIsSdcard());
        if (this.model.checkUpgradeCondition()) {
            DDLog.e("\u5927\u5305", "\u5347\u7ea7\u6761\u4ef6\u6ee1\u8db3");
            upgradeConditionPass();
        } else {
            DDLog.e("\u5927\u5305", "\u5347\u7ea7\u6761\u4ef6\u4e0d\u6ee1\u8db3");
            upgradeConditionFail();
        }
    }

    private void upgradeConditionPass() {
        this.model.isStartCheck.setValue(false);
        this.binding.layoutNotConditions.setVisibility(8);
        this.binding.layoutUpgradeConsiderations.setVisibility(0);
        this.binding.tvDownloadConsiderationsContent.setText(getString(FlightConfig.isAtomPanTilt() ? R.string.atom_firmware_upgrade_precautionary_tips : R.string.fw_upgrade_considerations_content));
        this.binding.tvCountDown.stopCountDown();
        this.binding.tvCountDown.setVisibility(8);
        this.binding.ivFirmwareState.setVisibility(0);
        this.binding.ivFirmwareState.setImageResource(R.mipmap.icon_big_package_uploading);
        this.binding.tvTitle.setText(getString(R.string.fw_transfer));
        this.binding.tvFirmwareState.setText(getString(R.string.fw_uploading));
        this.binding.viewBigPackageDownloadUpgrade.unableUpgrade(false);
        this.binding.btnClose.setVisibility(8);
        FwUpgradeConditionDialog fwUpgradeConditionDialog = this.fwUpgradeConditionDialog;
        if (fwUpgradeConditionDialog != null && fwUpgradeConditionDialog.isShowing()) {
            this.fwUpgradeConditionDialog.dismiss();
            this.fwUpgradeConditionDialog = null;
        }
        this.model.sendFile();
    }

    private void upgradeConditionFail() {
        this.model.isStartCheck.setValue(true);
        this.binding.layoutNotConditions.setVisibility(0);
        this.binding.layoutUpgradeConsiderations.setVisibility(8);
        this.binding.tvCountDown.setVisibility(0);
        this.binding.tvCountDown.startCountDown(60);
        this.binding.ivFirmwareState.setVisibility(8);
        this.binding.tvTitle.setText(getString(R.string.fw_upgrade_meet_the_conditions));
        this.binding.tvFirmwareState.setText(getString(R.string.fw_upgrade_unable));
        this.binding.viewBigPackageDownloadUpgrade.unableUpgrade(true);
        this.binding.btnClose.setVisibility(0);
        this.binding.clConnectedState.setVisibility(this.model.notConnectFlight.getValue().booleanValue() ? 0 : 8);
        this.binding.clRemoteBatteryLow.setVisibility(this.model.isRemotePowerLow.getValue().booleanValue() ? 0 : 8);
        this.binding.clPlaneBatteryLow.setVisibility(this.model.isPlanePowerLow.getValue().booleanValue() ? 0 : 8);
        if (this.model.unLock.getValue().booleanValue()) {
            finishActivity();
        } else {
            this.binding.clPlaneUnlock.setVisibility(8);
        }
        this.binding.clPlaneHighTemp.setVisibility(this.model.isCameraHighTemp.getValue().booleanValue() ? 0 : 8);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        DDLog.e("\u5927\u5305 keyCode\uff1a" + i + ", event: " + keyEvent.getAction());
        if (i == 4 && keyEvent.getAction() == 0) {
            DDLog.e("\u5927\u5305 \u62e6\u622a\u8fd4\u56de\u6309\u952e");
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        try {
            boolean z = true;
            switch (AnonymousClass12.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
                case 1:
                    boolean booleanValue = ((Boolean) event.obj).booleanValue();
                    DDLog.e(TAG, "\u5927\u5305\u8fde\u63a5\u65ad\u5f00 isConnect = " + booleanValue);
                    if (!booleanValue && this.binding.layoutUpgradeFinished.getRoot().getVisibility() != 0 && this.binding.layoutTransferFail.getRoot().getVisibility() != 0) {
                        finishActivity();
                        break;
                    }
                    break;
                case 2:
                    DDLog.e("\u5927\u5305 \u505c\u6b62\u6a21\u5757\u68c0\u6d4b");
                    this.binding.viewBigPackageModuleDetection.stopCheckModule();
                    startUpgradeCondition();
                    break;
                case 3:
                    int i = event.arg2;
                    MutableLiveData<Boolean> mutableLiveData = this.model.isCameraHighTemp;
                    if (i < 105) {
                        z = false;
                    }
                    mutableLiveData.setValue(Boolean.valueOf(z));
                    DDLog.e("\u5927\u5305 \u76f8\u673a\u6e29\u5ea6:" + i);
                    if (this.model.isStartCheck.getValue().booleanValue()) {
                        DDLog.e("\u5927\u5305", "\u6761\u4ef6\u4e0d\u6ee1\u8db3\u5faa\u73af\u68c0\u6d4b");
                        startUpgradeCondition();
                        break;
                    }
                    break;
                case 4:
                    int intValue = ((Integer) event.obj).intValue();
                    finishActivity();
                    if (intValue != 60) {
                        ActivityHelper.getInstance().finishAllActivity(KernelActivity.class);
                        break;
                    }
                    break;
                case 5:
                    String str = (String) event.obj;
                    DDLog.e("\u5927\u5305 \u56fa\u4ef6\u4f20\u8f93\u5931\u8d25code:" + str);
                    FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
                    this.binding.layoutTransferFail.getRoot().setVisibility(0);
                    this.binding.layoutTransferFail.tvUpgradeFailContent.setText(getString(BigPackageUploadFailType.UPLOAD_FAIL_TIMEOUT.value.equals(str) ? R.string.bigpackage_upgrade_fw_transfer_interference_detected_tips : R.string.fw_upgrade_fail_tips));
                    this.binding.layoutTransferFail.tvErrorCode.setText(getString(R.string.txt_error_code, new Object[]{str}));
                    this.binding.layoutTransferFail.tvUpgradeFailFaqs.setVisibility(8);
                    this.binding.layoutTransferFail.btnUpgradeFailClose.setVisibility(8);
                    this.binding.layoutTransferFail.btnTransferExit.setVisibility(0);
                    this.binding.layoutTransferFail.btnUpgradeRetry.setVisibility(8);
                    this.binding.layoutTransferFail.btnUpgradeExit.setVisibility(8);
                    BigPackageHelper.get().onSendBigPackageStatistics(SessionDescription.SUPPORTED_SDP_VERSION, str);
                    break;
                case 6:
                    FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
                    String str2 = (String) event.obj;
                    DDLog.e("\u6536\u5230\u5927\u5305\u5347\u7ea7\u5931\u8d25code:" + str2);
                    DDLog.e("\u5927\u5305\u5347\u7ea7\u5931\u8d25\u91cd\u8bd5\u6b21\u6570:" + this.retryNum);
                    this.binding.layoutTransferFail.getRoot().setVisibility(0);
                    this.binding.layoutTransferFail.tvUpgradeFailContent.setText(getString(R.string.upgrade_fails_issue_via_homepage_me_feedback_tips));
                    this.binding.layoutTransferFail.tvErrorCode.setText(getString(R.string.txt_error_code, new Object[]{str2}));
                    this.binding.layoutTransferFail.tvUpgradeFailFaqs.setVisibility(0);
                    this.binding.layoutTransferFail.btnUpgradeFailClose.setVisibility(0);
                    this.binding.layoutTransferFail.btnTransferExit.setVisibility(8);
                    this.binding.layoutTransferFail.btnUpgradeRetry.setVisibility(0);
                    this.binding.layoutTransferFail.btnUpgradeExit.setVisibility(0);
                    BigPackageHelper.get().onSendBigPackageStatistics(SessionDescription.SUPPORTED_SDP_VERSION, str2);
                    break;
                case 7:
                    if (this.binding.layoutTransferFail.getRoot().getVisibility() == 0) {
                        this.binding.layoutTransferFail.getRoot().setVisibility(8);
                    }
                    BigPackageHelper.UpgradeInfo upgradeInfo = (BigPackageHelper.UpgradeInfo) event.obj;
                    this.upgradeInfo = upgradeInfo;
                    int state = upgradeInfo.getState();
                    int progress = this.upgradeInfo.getProgress();
                    int totalProgress = this.upgradeInfo.getTotalProgress();
                    DDLog.e("\u5927\u5305\u5347\u7ea7\u4e2d\uff1astate: " + state + ", \u5355\u56fa\u4ef6\u5347\u7ea7\u8fdb\u5ea6\uff1a" + progress + ", \u603b\u5347\u7ea7\u8fdb\u5ea6\uff1a" + totalProgress);
                    this.binding.btnClose.setVisibility(8);
                    if (state != BigPackageUpgradeStage.STAGE_INIT.value && state != BigPackageUpgradeStage.STAGE_TRANSFER.value && state != BigPackageUpgradeStage.STAGE_PARSE_FW.value) {
                        if (this.binding.scrollViewDownloadTips.getVisibility() == 0) {
                            this.binding.scrollViewDownloadTips.setVisibility(8);
                        }
                        if (this.binding.scrollViewCheckCondition.getVisibility() != 0) {
                            this.binding.scrollViewCheckCondition.setVisibility(0);
                            this.binding.scrollViewUpgradeTips.setVisibility(0);
                        }
                        FlightRevConnectData flightRevConnectData = FlightRevData.get().getFlightRevConnectData();
                        if (state != 10 && state != 11) {
                            z = false;
                        }
                        flightRevConnectData.setRemoterOrFpvUpgrade(z);
                    }
                    this.model.upgradingTotalProgress.setValue(Integer.valueOf(totalProgress));
                    this.model.upgradingProgress.setValue(Integer.valueOf(progress));
                    setCurUpgradeStateView(state);
                    break;
                case 8:
                    FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
                    this.binding.layoutUpgradeFinished.getRoot().setVisibility(0);
                    Glide.with((FragmentActivity) this).load(Integer.valueOf(R.drawable.img_big_package_success)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into((DrawableRequestBuilder<Integer>) new GlideDrawableImageViewTarget(this.binding.layoutUpgradeFinished.ivUpgradeSuccess, 1));
                    this.binding.layoutUpgradeFinished.tvUpgradeFinishedCountDown.startCountDown(6);
                    BigPackageHelper.get().onSendBigPackageStatistics("1", "");
                    break;
                case 9:
                    DDLog.e("\u5927\u5305 bigPackageActivity\u56fa\u4ef6\u4f20\u8f93\u8d85\u65f6\uff0c\u9000\u51fa\u5347\u7ea7");
                    DataManager.getInstance().requestSettingInfo();
                    FlightRevData.get().getFlightRevConnectData().setRemoterOrFpvUpgrade(false);
                    ToastUtil.toast(this, "\u56fa\u4ef6\u4f20\u8f93\u8d85\u65f6\uff0c\u9000\u51fa\u5347\u7ea7");
                    finishActivity();
                    break;
            }
        } catch (Exception e) {
            DDLog.e("\u5927\u5305\u5347\u7ea7eeee: " + e);
        }
    }

    private void parseUpgradeFwVersionAndContent(FwType fwType) {
        ArrayList<Version.ProductData> arrayList;
        DDLog.e("\u5347\u7ea7\u7c7b\u578b type:" + this.type + ", state:" + fwType);
        ArrayList<Version.ProductData> arrayList2 = this.typeList;
        if (arrayList2 != null) {
            Iterator<Version.ProductData> it = arrayList2.iterator();
            while (it.hasNext()) {
                DDLog.e("\u9700\u8981\u5347\u7ea7\u7684\u53c2\u6570:" + it.next().toString());
            }
        }
        if (this.type == fwType || (arrayList = this.typeList) == null) {
            return;
        }
        Iterator<Version.ProductData> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Version.ProductData next = it2.next();
            if (next.getType().equalsIgnoreCase(fwType.toString())) {
                if (next.getType().equalsIgnoreCase("bms")) {
                    if (next.getDev_id() == FlightRevData.get().getFlightRevVersionData().getBatteryDeviceId()) {
                        this.binding.tvFirmwareVersion.setText(String.format("V%s", next.getVersion()));
                        this.binding.tvUpgradeDetail.setText(next.getContent());
                        this.type = fwType;
                        return;
                    }
                } else {
                    this.binding.tvFirmwareVersion.setText(String.format("V%s", next.getVersion()));
                    this.binding.tvUpgradeDetail.setText(next.getContent());
                    this.type = fwType;
                    return;
                }
            }
        }
    }

    @Override // com.ipotensic.baselib.okhttp.DownloadListener2
    public void onDownloadStart(long j) {
        this.model.onDownloadStart(j);
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ long val$size;

        AnonymousClass9(long j) {
            r2 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BigPackageActivity.this.model.totalSize.getValue().longValue() > 0) {
                long longValue = (r2 * 100) / BigPackageActivity.this.model.totalSize.getValue().longValue();
                DDLog.e("\u5927\u5305\u4e0b\u8f7d\u8fdb\u5ea6progress:" + longValue + " ,size: " + r2);
                BigPackageActivity.this.binding.viewBigPackageDownloadUpgrade.downloadProgress(longValue);
            } else {
                BigPackageActivity.this.handleDownloadError();
            }
            if (FlightRevData.get().getFlightRevStateData().isUnLock()) {
                BigPackageActivity.this.finishActivity();
            }
        }
    }

    @Override // com.ipotensic.baselib.okhttp.DownloadListener2
    public void onDownloadProgress(long j) {
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.9
            final /* synthetic */ long val$size;

            AnonymousClass9(long j2) {
                r2 = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BigPackageActivity.this.model.totalSize.getValue().longValue() > 0) {
                    long longValue = (r2 * 100) / BigPackageActivity.this.model.totalSize.getValue().longValue();
                    DDLog.e("\u5927\u5305\u4e0b\u8f7d\u8fdb\u5ea6progress:" + longValue + " ,size: " + r2);
                    BigPackageActivity.this.binding.viewBigPackageDownloadUpgrade.downloadProgress(longValue);
                } else {
                    BigPackageActivity.this.handleDownloadError();
                }
                if (FlightRevData.get().getFlightRevStateData().isUnLock()) {
                    BigPackageActivity.this.finishActivity();
                }
            }
        });
    }

    @Override // com.ipotensic.baselib.okhttp.DownloadListener2
    public void onDownloadEnd(String str, String str2, String str3) {
        if (FwDownloadManager.getInstance().updateFileMD5Align((Version) JSONObject.parseObject(SPHelper.getInstance().getLocalBigPackageVersion(), Version.class), str)) {
            BigPackageFirmwareDownload.getInstance().saveToLocal();
            SPHelper.getInstance().setNeedDownloadFw(false);
            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.-$$Lambda$BigPackageActivity$_DqxEWkK8KgF4bz4HiO3UCA8GcI
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;
                public final /* synthetic */ String f$3;

                public /* synthetic */ $$Lambda$BigPackageActivity$_DqxEWkK8KgF4bz4HiO3UCA8GcI(String str22, String str32, String str4) {
                    r2 = str22;
                    r3 = str32;
                    r4 = str4;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BigPackageActivity.this.lambda$onDownloadEnd$2$BigPackageActivity(r2, r3, r4);
                }
            });
            return;
        }
        PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.10
            AnonymousClass10() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BigPackageFirmwareDownload.getInstance().retryDownload(BigPackageActivity.this);
            }
        });
    }

    public /* synthetic */ void lambda$onDownloadEnd$2$BigPackageActivity(String str, String str2, String str3) {
        DDLog.e("\u5927\u5305\u4e0b\u8f7d\u5b8c\u6210, productClass:" + str + ", fileSize: " + str2 + ", filePath:" + str3);
        this.binding.viewBigPackageDownloadUpgrade.downloadProgress(100L);
        this.model.filePath.postValue(str3);
        DDLog.e("\u5927\u5305\u56fa\u4ef6\u4e0b\u8f7d\u5b8c\u6210");
        this.binding.viewBigPackageDownloadUpgrade.clearProgress();
        enterDetectionModel();
        this.model.isFwDownloading.postValue(false);
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$10 */
    class AnonymousClass10 implements Runnable {
        AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BigPackageFirmwareDownload.getInstance().retryDownload(BigPackageActivity.this);
        }
    }

    @Override // com.ipotensic.baselib.okhttp.DownloadListener2
    public void onDownloadError(Exception exc) {
        DDLog.e("\u5927\u5305\u4e0b\u8f7d\u5931\u8d25e:" + exc.getMessage());
        handleDownloadError();
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$11 */
    class AnonymousClass11 implements Runnable {
        AnonymousClass11() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DDLog.e("\u5927\u5305  onDownloadError, isFinishing() = " + BigPackageActivity.this.isFinishing());
            if (BigPackageActivity.this.isFinishing()) {
                return;
            }
            BigPackageActivity.this.binding.viewBigPackageDownloadUpgrade.setVisibility(8);
            BigPackageActivity.this.binding.layoutUpgradeState.setVisibility(8);
            BigPackageActivity.this.binding.scrollViewDownloadTips.setVisibility(8);
            DDLog.e("\u5927\u5305\u4e0b\u8f7d\u5931\u8d25isFwDownloading\uff1a " + BigPackageActivity.this.model.isFwDownloading.getValue());
            BigPackageActivity.this.binding.layoutNotNetwork.setVisibility(0);
            BigPackageActivity.this.model.isFwDownloading.postValue(false);
        }
    }

    public void handleDownloadError() {
        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.activitys.BigPackageActivity.11
            AnonymousClass11() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DDLog.e("\u5927\u5305  onDownloadError, isFinishing() = " + BigPackageActivity.this.isFinishing());
                if (BigPackageActivity.this.isFinishing()) {
                    return;
                }
                BigPackageActivity.this.binding.viewBigPackageDownloadUpgrade.setVisibility(8);
                BigPackageActivity.this.binding.layoutUpgradeState.setVisibility(8);
                BigPackageActivity.this.binding.scrollViewDownloadTips.setVisibility(8);
                DDLog.e("\u5927\u5305\u4e0b\u8f7d\u5931\u8d25isFwDownloading\uff1a " + BigPackageActivity.this.model.isFwDownloading.getValue());
                BigPackageActivity.this.binding.layoutNotNetwork.setVisibility(0);
                BigPackageActivity.this.model.isFwDownloading.postValue(false);
            }
        });
    }

    private void setCurUpgradeStateView(int i) {
        if (i >= 3) {
            this.binding.ivFirmwareState.setImageResource(R.mipmap.icon_big_package_upgrading);
            this.binding.tvFirmwareState.setText(getString(R.string.fw_upgrading));
            this.binding.tvTitle.setText(getString(R.string.fw_upgrade));
            this.binding.tvUpgradeConsiderationsContent.setText(getString(FlightConfig.isAtomPanTilt() ? R.string.atom_firmware_upgrade_precautionary_tips : R.string.fw_upgrade_considerations_content));
        }
        switch (BigPackageUpgradeStage.getByValue(i)) {
            case STAGE_UPGRADE_CAM:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_camera));
                parseUpgradeFwVersionAndContent(FwType.CAM);
                break;
            case STAGE_UPGRADE_FCS:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_flight_control));
                parseUpgradeFwVersionAndContent(FwType.FCS);
                break;
            case STAGE_UPGRADE_GIMBAL:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_gimbal));
                parseUpgradeFwVersionAndContent(FwType.GIMBAL);
                break;
            case STAGE_UPGRADE_ESC:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_electric_control));
                parseUpgradeFwVersionAndContent(FwType.ESC);
                break;
            case STAGE_UPGRADE_BMS:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_battery));
                parseUpgradeFwVersionAndContent(FwType.BMS);
                break;
            case STAGE_UPGRADE_ITG:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_fpv));
                parseUpgradeFwVersionAndContent(FwType.ITG);
                break;
            case STAGE_UPGRADE_RC:
                this.binding.tvFirmwareName.setText(getString(R.string.fw_remote_control));
                parseUpgradeFwVersionAndContent(FwType.RC);
                break;
        }
    }

    /* renamed from: com.ipotensic.kernel.activitys.BigPackageActivity$12 */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[BigPackageUpgradeStage.values().length];
            $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage = iArr;
            try {
                iArr[BigPackageUpgradeStage.STAGE_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_TRANSFER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_PARSE_FW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_ITA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_CAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_FCS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_GIMBAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_ESC.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_BMS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_ITG.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$logan$upgrade$enums$BigPackageUpgradeStage[BigPackageUpgradeStage.STAGE_UPGRADE_RC.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr2;
            try {
                iArr2[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_UPGRADE_STOP_ENVIRONMENT_CHECK.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_CAMERA_HIGH_TEMP.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_COUNT_DOWN_FINISH.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_UPLOAD_FAIL.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_UPGRADE_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_UPGRADE_STATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_UPGRADE_FINISHED.ordinal()] = 8;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.MSG_BIG_PACKAGE_FIRMWARE_TIME_OUT_FINISH.ordinal()] = 9;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }
}
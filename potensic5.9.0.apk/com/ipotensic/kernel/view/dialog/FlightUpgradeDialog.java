package com.ipotensic.kernel.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.ZipUtils;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.flight.FlightConfig;
import com.logan.upgrade.local.camera.UsbCamUpgradeManager;
import com.logan.upgrade.local.flight.UpgradeManager;
import com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener;
import com.logan.upgrade.server.Version;
import com.logan.user.model.HttpPresenter;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FlightUpgradeDialog extends BaseSyncDialog implements View.OnClickListener {
    private final Button btnCancel;
    private final Button btnConfirm;
    private Button btnUpgrade;
    private Context context;
    private GeneralDialog failDialog;
    private String formatStr;
    private Handler handler;
    private boolean isForce;
    private final ImageView ivCancel;
    private LinearLayout layoutBottom;
    private ScrollView layoutTop;
    private ProgressBar progressBar;
    private IFlightUpgradeProgressListener progressListener;
    private GeneralDialog successDialog;
    private TextView tvProgress;
    private TextView tvProgressPercent;
    private TextView tvTitle;
    private String upgradeFailTip;
    private String upgradeSuccessTip;
    private String upgradeTypeTitle;
    private String upgradingTitle;
    private View upgradingView;
    private Version version;

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public FlightUpgradeDialog(Context context, Version version, boolean z) {
        super(context, C1965R.layout.view_dialog_flight_upgrade);
        this.handler = new Handler(Looper.getMainLooper());
        this.upgradeTypeTitle = null;
        this.upgradingTitle = null;
        this.isForce = false;
        this.progressListener = new C25672();
        this.context = context;
        this.version = version;
        this.isForce = z;
        this.tvTitle = (TextView) findViewById(C1965R.id.tv_code_title);
        TextView textView = (TextView) findViewById(C1965R.id.tv_detail);
        this.layoutTop = (ScrollView) findViewById(C1965R.id.layout_top);
        this.layoutBottom = (LinearLayout) findViewById(C1965R.id.layout_bottom);
        Button button = (Button) findViewById(C1965R.id.btn_confirm);
        this.btnConfirm = button;
        Button button2 = (Button) findViewById(C1965R.id.btn_cancel);
        this.btnCancel = button2;
        this.btnUpgrade = (Button) findViewById(C1965R.id.btn_upgrade);
        this.ivCancel = (ImageView) findViewById(C1965R.id.iv_cancel);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.btnUpgrade.setOnClickListener(this);
        this.layoutBottom.setVisibility(z ? 4 : 0);
        this.btnUpgrade.setVisibility(z ? 0 : 8);
        TextView textView2 = (TextView) findViewById(C1965R.id.tv_upgrade_conditions);
        if (version != null) {
            switch (C25694.f2249xa0b71515[LanguageHelper.getLanguage(getContext()).ordinal()]) {
                case 1:
                case 2:
                    textView.setText("" + version.getUpdatenote_cn());
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    textView.setText("" + version.getUpdatenote_en());
                    break;
            }
            DDLog.m1684e("升级 version：" + version);
            if (FlightConfig.isP1ProByProductClass(version.getProductclass()) || FlightConfig.isAtomOrAtomSeByProductClass(version.getProductclass())) {
                if (version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL)) {
                    this.upgradeTypeTitle = context.getString(C1965R.string.dialog_upgrade_type_gimbal);
                    this.upgradingTitle = context.getString(C1965R.string.dialog_upgrade_type_gimbal_content);
                    this.upgradeSuccessTip = context.getString(C1965R.string.dialog_upgrade_gimbal_success);
                    this.upgradeFailTip = context.getString(C1965R.string.dialog_upgrade_gimbal_fail);
                    textView2.setText(context.getString(C1965R.string.dialog_upgrade_gimbal_conditions));
                    DDLog.m1687i("云台升级");
                } else if (version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_RC)) {
                    this.upgradeTypeTitle = context.getString(C1965R.string.dialog_upgrade_type_remoter);
                    this.upgradingTitle = context.getString(C1965R.string.dialog_upgrade_type_remoter_content);
                    this.upgradeSuccessTip = context.getString(C1965R.string.dialog_upgrade_remoter_success);
                    this.upgradeFailTip = context.getString(C1965R.string.dialog_upgrade_remoter_fail);
                    textView2.setText(context.getString(C1965R.string.dialog_upgrade_remoter_conditions));
                    DDLog.m1687i("遥控器升级");
                } else if (version.getClassname().equals(FlightConfig.PRODUCT_CLASS_CAMERA) || version.getClassname().equals(CameraConfig.ATOM_SP)) {
                    this.upgradeTypeTitle = context.getString(C1965R.string.dialog_cam_upgrade_title);
                    this.upgradingTitle = context.getString(C1965R.string.dialog_camera_upgrading);
                    this.upgradeSuccessTip = context.getString(C1965R.string.dialog_camera_update_success_describe);
                    this.upgradeFailTip = context.getString(C1965R.string.dialog_camera_failure_describe);
                    textView2.setText(context.getString(C1965R.string.dialog_upgrade_camera_conditions));
                    DDLog.m1687i("usb相机升级");
                } else if (version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV)) {
                    this.upgradeTypeTitle = context.getString(C1965R.string.dialog_upgrade_type_fpv);
                    this.upgradingTitle = context.getString(C1965R.string.dialog_upgrade_type_fpv_content);
                    this.upgradeSuccessTip = context.getString(C1965R.string.dialog_upgrade_fpv_success);
                    this.upgradeFailTip = context.getString(C1965R.string.dialog_upgrade_fpv_fail);
                    textView2.setText(context.getString(C1965R.string.dialog_upgrade_fpv_conditions));
                    DDLog.m1687i("图传升级");
                } else if (version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_BATTERY)) {
                    this.upgradeTypeTitle = context.getString(C1965R.string.dialog_battery_upgrade_title);
                    this.upgradingTitle = context.getString(C1965R.string.dialog_battery_upgrading);
                    this.upgradeSuccessTip = context.getString(C1965R.string.dialog_upgrade_battery_success);
                    this.upgradeFailTip = context.getString(C1965R.string.dialog_upgrade_battery_fail);
                    textView2.setText(context.getString(C1965R.string.dialog_upgrade_battery_conditions));
                } else if (version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL)) {
                    this.upgradeTypeTitle = context.getString(C1965R.string.dialog_flight_upgrade_title);
                    this.upgradingTitle = context.getString(C1965R.string.dialog_firmware_upgrade);
                    this.upgradeSuccessTip = context.getString(C1965R.string.dialog_flight_upgrade_success_describe);
                    this.upgradeFailTip = context.getString(C1965R.string.dialog_flight_upgrade_failed);
                    textView2.setText(context.getString(C1965R.string.dialog_upgrade_flight_conditions));
                }
            }
            this.tvTitle.setText(this.upgradeTypeTitle);
        }
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog$4 */
    static /* synthetic */ class C25694 {

        /* renamed from: $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE */
        static final /* synthetic */ int[] f2249xa0b71515;

        static {
            int[] iArr = new int[LanguageHelper.LANGUAGE_TYPE.values().length];
            f2249xa0b71515 = iArr;
            try {
                iArr[LanguageHelper.LANGUAGE_TYPE.CHINESE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.CHINESETAIWAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.FRENCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.ITALY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.GERMANY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.JAPAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.SPANISH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2249xa0b71515[LanguageHelper.LANGUAGE_TYPE.ENGLISH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public void setIsForceUpgrade(boolean z) {
        this.isForce = z;
    }

    public void forceUpgrade(int i) {
        showUpgradingView();
        UsbCamUpgradeManager.getInstance().setUpgradeProgressListener(this.progressListener);
        this.progressListener.onUploadProgress(i, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUsbCameraUpgrade() {
        String productclass = this.version.getProductclass();
        if (productclass == null) {
            return false;
        }
        return (FlightConfig.isP1ProByProductClass(productclass) || FlightConfig.isAtomOrAtomSeByProductClass(productclass)) && (this.version.getClassname().equalsIgnoreCase(CameraConfig.ATOM_SP) || this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA) || this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C1965R.id.btn_confirm) {
            if (FwDownloadManager.getInstance().upgradeCondition(this.context, this.version)) {
                showUpgradingView();
                if (isUsbCameraUpgrade()) {
                    DDLog.m1684e("开始相机升级");
                    startUsbCameraUpgrade();
                    return;
                } else {
                    DDLog.m1684e("开始升级");
                    startUpgrade();
                    return;
                }
            }
            return;
        }
        if (id == C1965R.id.btn_upgrade && FwDownloadManager.getInstance().upgradeCondition(this.context, this.version)) {
            showUpgradingView();
            if (isUsbCameraUpgrade()) {
                DDLog.m1684e("开始相机强制升级");
                startUsbCameraUpgrade();
            } else {
                DDLog.m1684e("开始强制升级");
                startUpgrade();
            }
        }
    }

    private void showUpgradingView() {
        if (this.upgradingView == null) {
            this.upgradingView = ((ViewStub) findViewById(C1965R.id.stub_upgrading)).inflate();
        }
        this.upgradingView.setVisibility(0);
        this.tvTitle.setText(this.upgradingTitle);
        this.layoutBottom.setVisibility(8);
        this.layoutTop.setVisibility(8);
        this.btnUpgrade.setVisibility(8);
        this.tvProgress = (TextView) findViewById(C1965R.id.tv_progress);
        this.progressBar = (ProgressBar) findViewById(C1965R.id.progress_bar);
        this.tvProgressPercent = (TextView) findViewById(C1965R.id.tv_progress_percent);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(this.context) * 0.45d), (int) (ScreenUtils.getScreenHeight(this.context) * 0.736d));
    }

    private void startUpgrade() {
        if (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_FLIGHT_CTRL)) {
            UpgradeManager.getInstance().setUpgradeType((byte) 16);
        } else if (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_GIMBAL)) {
            UpgradeManager.getInstance().setUpgradeType((byte) 20);
        } else if (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_RC)) {
            UpgradeManager.getInstance().setUpgradeType((byte) 17);
        } else if (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_TOF)) {
            UpgradeManager.getInstance().setUpgradeType((byte) 23);
        } else if (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_BATTERY)) {
            UpgradeManager.getInstance().setUpgradeType((byte) 23);
        }
        UpgradeManager.getInstance().setFlightUpgradeProgressListener(this.progressListener);
        DDLog.m1687i(" 相机升级  switchToUpgradeMode 1");
        UpgradeManager.getInstance().switchToUpgradeMode();
        refreshProgress(0);
    }

    private void startUsbCameraUpgrade() {
        try {
            DDLog.m1684e("点击开始升级相机/图传:" + this.version.toString());
            UsbCamUpgradeManager.getInstance().setUpgradeProgressListener(this.progressListener);
            if (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_P1_PRO_FPV)) {
                UsbCamUpgradeManager.getInstance().UpgradeTo(UsbConfig.USB_TYPE_APP_TO_FPV);
            } else if ((FlightConfig.isAtomOrAtomSeByProductClass(this.version.getProductclass()) || FlightConfig.isP1ProByProductClass(this.version.getProductclass()) || FlightConfig.isP1SelfBByProductClass(this.version.getProductclass())) && (this.version.getClassname().equalsIgnoreCase(FlightConfig.PRODUCT_CLASS_CAMERA) || this.version.getClassname().equalsIgnoreCase(CameraConfig.ATOM_SP))) {
                UsbCamUpgradeManager.getInstance().UpgradeTo(UsbConfig.USB_TYPE_APP_TO_CAMERA);
            }
            UsbCamUpgradeManager.getInstance().requestUpgrade(new File(this.version.getLocalPath()));
        } catch (Exception e) {
            DDLog.m1684e("usb升级失败：" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshProgress(final int i) {
        this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.1
            @Override // java.lang.Runnable
            public void run() {
                FlightUpgradeDialog.this.progressBar.setProgress(i);
                FlightUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Integer.valueOf(i), "%"));
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog$2 */
    class C25672 implements IFlightUpgradeProgressListener {
        C25672() {
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void onSwitchUpgradeModeSuccess() {
            if (FlightUpgradeDialog.this.isUsbCameraUpgrade()) {
                FlightUpgradeDialog.this.refreshProgress(0);
            } else {
                FlightUpgradeDialog.this.refreshProgress(1);
                UpgradeManager.getInstance().checkFile(FlightUpgradeDialog.this.version.getLocalPath());
            }
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void isFileAccept(boolean z) {
            if (FlightUpgradeDialog.this.isUsbCameraUpgrade()) {
                FlightUpgradeDialog.this.refreshProgress(0);
            } else {
                FlightUpgradeDialog.this.refreshProgress(2);
                UpgradeManager.getInstance().uploadFle();
            }
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void onUploadProgress(int i, int i2) {
            if (FlightUpgradeDialog.this.isUsbCameraUpgrade()) {
                FlightUpgradeDialog.this.refreshProgress((i * 100) / i2);
            } else {
                FlightUpgradeDialog.this.refreshProgress(((i * 95) / i2) + 3);
            }
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void onUploadEnd() {
            if (FlightUpgradeDialog.this.isUsbCameraUpgrade()) {
                FlightUpgradeDialog.this.refreshProgress(100);
            } else {
                FlightUpgradeDialog.this.refreshProgress(98);
                UpgradeManager.getInstance().sendRunFw();
            }
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void onRunFwSuccess() {
            if (FlightUpgradeDialog.this.isUsbCameraUpgrade()) {
                FlightUpgradeDialog.this.refreshProgress(100);
            } else {
                FlightUpgradeDialog.this.refreshProgress(99);
            }
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void onUpgradeSuccess() {
            FlightUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PhoneConfig.isKernelActivityRunning) {
                        FlightUpgradeDialog.this.refreshProgress(100);
                        FlightUpgradeDialog.this.dismiss();
                        if (BaseSyncDialog.isShow) {
                            return;
                        }
                        FlightUpgradeDialog.this.successDialog = new GeneralDialog(FlightUpgradeDialog.this.getContext(), FlightUpgradeDialog.this.getContext().getString(C1965R.string.dialog_success), FlightUpgradeDialog.this.upgradeSuccessTip, 1, C1965R.mipmap.icon_camera_update_success, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.2.1.1
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                                ((Activity) FlightUpgradeDialog.this.context).finish();
                            }
                        });
                        FlightUpgradeDialog.this.successDialog.show();
                    }
                }
            });
        }

        @Override // com.logan.upgrade.local.flight.listeners.IFlightUpgradeProgressListener
        public void onUpgradeFailed(Exception exc) {
            int i;
            DDLog.m1684e("升级失败 e: " + exc.getMessage());
            try {
                i = Integer.parseInt(exc.getMessage());
            } catch (Exception unused) {
                i = -1;
            }
            if (i == 4) {
                FlightUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FlightUpgradeDialog.this.dismiss();
                        if (BaseSyncDialog.isShow) {
                            return;
                        }
                        FlightUpgradeDialog.this.failDialog = new GeneralDialog(FlightUpgradeDialog.this.getContext(), FlightUpgradeDialog.this.getContext().getString(C1965R.string.dialog_failure), FlightUpgradeDialog.this.getContext().getString(C1965R.string.dialog_upgrade_camera_error), 1, C1965R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.2.2.1
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        });
                        FlightUpgradeDialog.this.failDialog.show();
                    }
                });
            } else {
                FlightUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FlightUpgradeDialog.this.dismiss();
                        if (BaseSyncDialog.isShow) {
                            return;
                        }
                        FlightUpgradeDialog.this.failDialog = new GeneralDialog(FlightUpgradeDialog.this.getContext(), FlightUpgradeDialog.this.getContext().getString(C1965R.string.dialog_failure), FlightUpgradeDialog.this.upgradeFailTip, 1, C1965R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.2.3.1
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        });
                        FlightUpgradeDialog.this.failDialog.show();
                    }
                });
            }
        }
    }

    private void uploadLogs() {
        new Thread(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String formatCurTime = FormatUtil.formatCurTime();
                    DDLog.m1684e("上传日志:" + formatCurTime);
                    ArrayList<String> arrayList = LocalFileManager.getInstance().get12HoursLogs();
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    final String str = FlightUpgradeDialog.this.getContext().getCacheDir().toString() + File.separator + formatCurTime + ".zip";
                    long currentTimeMillis = System.currentTimeMillis();
                    ZipUtils.zipFiles(arrayList, str);
                    DDLog.m1684e("压缩耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                    HttpPresenter.getInstance().postDumpFile(FlightUpgradeDialog.this.getContext(), str, new OnResultListener<String>() { // from class: com.ipotensic.kernel.view.dialog.FlightUpgradeDialog.3.1
                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onFailed(Exception exc) {
                        }

                        @Override // com.ipotensic.baselib.okhttp.OnResultListener
                        public void onSuccess(String str2) {
                            File file = new File(str);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public boolean isUpgradeTipsDialogShowing() {
        GeneralDialog generalDialog;
        GeneralDialog generalDialog2 = this.successDialog;
        return (generalDialog2 != null && generalDialog2.isShowing()) || ((generalDialog = this.failDialog) != null && generalDialog.isShowing());
    }

    public void setDialogDismiss() {
        GeneralDialog generalDialog = this.successDialog;
        if (generalDialog != null && generalDialog.isShowing()) {
            this.successDialog.dismiss();
            this.successDialog = null;
        }
        GeneralDialog generalDialog2 = this.failDialog;
        if (generalDialog2 == null || !generalDialog2.isShowing()) {
            return;
        }
        this.failDialog.dismiss();
        this.failDialog = null;
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.5d), (int) (ScreenUtils.getScreenHeight(getContext()) * 0.8d));
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenHeight(getContext()) * 0.5d), (int) (ScreenUtils.getScreenWidth(getContext()) * 0.8d));
        }
        getWindow().setGravity(17);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (isUsbCameraUpgrade()) {
            UsbCamUpgradeManager.getInstance().setUpgradeProgressListener(null);
        } else {
            UpgradeManager.getInstance().setFlightUpgradeProgressListener(null);
        }
    }
}
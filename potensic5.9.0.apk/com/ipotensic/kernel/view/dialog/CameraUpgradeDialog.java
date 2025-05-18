package com.ipotensic.kernel.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.enums.CameraModel;
import com.logan.camera.listeners.ICheckUpgradeCallback;
import com.logan.camera.listeners.IStartUpgradeCallback;
import com.logan.upgrade.local.camera.ftp.FTPUtils;
import com.logan.upgrade.local.flight.FileGiver;
import com.logan.upgrade.server.Version;
import java.io.File;

/* loaded from: classes2.dex */
public class CameraUpgradeDialog extends BaseSyncDialog implements View.OnClickListener {
    private Button btnCancel;
    private Button btnConfirm;
    private Button btnUpgrade;
    private Context context;
    private GeneralDialog failDialog;
    private long fileSize;
    private Handler handler;
    private LinearLayout layoutBottom;
    private ScrollView layoutTop;
    private ProgressBar progressBar;
    private GeneralDialog successDialog;
    private TextView tvProgressPercent;
    private TextView tvTitle;
    private View upgradingView;
    private String uploadSuccessTips;
    private Version version;

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public CameraUpgradeDialog(Context context, Version version, boolean z) {
        super(context, C1965R.layout.view_dialog_flight_upgrade);
        this.handler = new Handler(Looper.getMainLooper());
        this.context = context;
        this.version = version;
        this.tvTitle = (TextView) findViewById(C1965R.id.tv_code_title);
        TextView textView = (TextView) findViewById(C1965R.id.tv_detail);
        this.layoutTop = (ScrollView) findViewById(C1965R.id.layout_top);
        this.layoutBottom = (LinearLayout) findViewById(C1965R.id.layout_bottom);
        this.tvTitle.setText(getContext().getResources().getString(C1965R.string.dialog_cam_upgrade_title));
        Button button = (Button) findViewById(C1965R.id.btn_confirm);
        this.btnConfirm = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(C1965R.id.btn_cancel);
        this.btnCancel = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(C1965R.id.btn_upgrade);
        this.btnUpgrade = button3;
        button3.setOnClickListener(this);
        this.btnUpgrade.setVisibility(z ? 0 : 8);
        this.layoutBottom.setVisibility(z ? 4 : 0);
        if (version != null) {
            switch (C25627.f2248xa0b71515[LanguageHelper.getLanguage(getContext()).ordinal()]) {
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
        }
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$7 */
    static /* synthetic */ class C25627 {

        /* renamed from: $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE */
        static final /* synthetic */ int[] f2248xa0b71515;

        static {
            int[] iArr = new int[LanguageHelper.LANGUAGE_TYPE.values().length];
            f2248xa0b71515 = iArr;
            try {
                iArr[LanguageHelper.LANGUAGE_TYPE.CHINESE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.CHINESETAIWAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.FRENCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.ITALY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.GERMANY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.JAPAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.SPANISH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2248xa0b71515[LanguageHelper.LANGUAGE_TYPE.ENGLISH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C1965R.id.btn_confirm || id == C1965R.id.btn_upgrade) {
            if (FwDownloadManager.getInstance().upgradeCondition(this.context, this.version)) {
                showUpgradingView();
                startWifiUpgrade();
                return;
            }
            return;
        }
        if (id == C1965R.id.btn_cancel) {
            Context context = this.context;
            new GeneralDialog(context, context.getString(C1965R.string.dialog_exit_upgrade), this.context.getString(C1965R.string.dialog_exit_upgrade_describe), true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                    CameraUpgradeDialog.this.dismiss();
                }
            }).show();
        }
    }

    private void startWifiUpgrade() {
        String localPath = this.version.getLocalPath();
        if (localPath != null) {
            this.fileSize = new File(localPath).length();
            CameraCtrlPresenter.getInstance().checkUpgrade(this.fileSize, this.version.getComparedate(), new ICheckUpgradeCallback() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.2
                @Override // com.logan.camera.listeners.ICheckUpgradeCallback
                public void canUpgrade() {
                    DDLog.m1684e("sd卡可以升级");
                    CameraUpgradeDialog.this.sendUpgradeFile();
                }

                @Override // com.logan.camera.listeners.ICheckUpgradeCallback
                public void notUpgrade(int i) {
                    String string;
                    if (i == -1) {
                        string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.sd_sdcard_is_full);
                    } else if (i == -2) {
                        string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.upgrade_camera_sd_error);
                    } else if (i == -3) {
                        string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.upgrade_camera_version_too_big);
                    } else {
                        string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.dialog_camera_failure_describe);
                    }
                    String str = string;
                    CameraUpgradeDialog.this.dismiss();
                    if (BaseSyncDialog.isShow) {
                        return;
                    }
                    CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.getContext(), CameraUpgradeDialog.this.getContext().getString(C1965R.string.dialog_failure), str, 1, C1965R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.2.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }
                    });
                    CameraUpgradeDialog.this.failDialog.show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpgradeFile() {
        FTPUtils.getInstance().uploadFile(this.version.getFilename(), this.version.getLocalPath(), this.fileSize, FTPUtils.CAM_USERNAME, "192.168.29.1", new FTPUtils.UploadProgressListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3
            @Override // com.logan.upgrade.local.camera.ftp.FTPUtils.UploadProgressListener
            public void onUploadProgress(final long j) {
                CameraUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DDLog.m1685e("ftp", ", progress: " + j);
                        if (CameraUpgradeDialog.this.progressBar != null) {
                            CameraUpgradeDialog.this.progressBar.setProgress((int) j);
                            CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Long.valueOf(j), "%"));
                        }
                    }
                });
            }

            @Override // com.logan.upgrade.local.camera.ftp.FTPUtils.UploadProgressListener
            public void onUploadEnd(final boolean z) {
                CameraUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            DDLog.m1685e("ftp", "升级文件发送成功");
                            CameraUpgradeDialog.this.uploadFirmware();
                            return;
                        }
                        CameraUpgradeDialog.this.dismiss();
                        DDLog.m1685e("ftp", "升级文件发送失败");
                        if (BaseSyncDialog.isShow) {
                            return;
                        }
                        CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.context, CameraUpgradeDialog.this.context.getString(C1965R.string.dialog_camera_save_failed), CameraUpgradeDialog.this.context.getString(C1965R.string.dialog_camera_save_failed_describe), 1, C1965R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2.1
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }
                        });
                        CameraUpgradeDialog.this.failDialog.show();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFirmware() {
        CameraCtrlPresenter.getInstance().startUpgrade(this.version.getFilename(), String.valueOf(new FileGiver(this.version.getLocalPath(), 0).getUnsignedCheckCode()), new IStartUpgradeCallback() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.4
            @Override // com.logan.camera.listeners.IStartUpgradeCallback
            public void upgradeSuccess() {
                DDLog.m1685e("ftp", "立即进入升级状态");
                if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_56) {
                    CameraUpgradeDialog.this.dismiss();
                    CameraUpgradeDialog.this.showDialog();
                }
            }

            @Override // com.logan.camera.listeners.IStartUpgradeCallback
            public void upgradeFailed(int i) {
                String string;
                DDLog.m1685e("ftp", "error: " + i);
                if (i == 1) {
                    string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.upgrade_camera_file_not_exist);
                } else if (i == 2) {
                    string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.upgrade_camera_crc_check_error);
                } else if (i == 3) {
                    string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.upgrade_camera_file_not_match);
                } else if (i == 4) {
                    string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.upgrade_camera_file_incorrect);
                } else {
                    string = CameraUpgradeDialog.this.getContext().getString(C1965R.string.dialog_camera_failure_describe);
                }
                String str = string;
                CameraUpgradeDialog.this.dismiss();
                if (BaseSyncDialog.isShow) {
                    return;
                }
                CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.getContext(), CameraUpgradeDialog.this.getContext().getString(C1965R.string.dialog_failure), str, 1, C1965R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.4.1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }
                });
                CameraUpgradeDialog.this.failDialog.show();
            }
        });
    }

    private void showUpgradingView() {
        if (this.upgradingView == null) {
            View inflate = ((ViewStub) findViewById(C1965R.id.stub_upgrading)).inflate();
            this.upgradingView = inflate;
            if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_56) {
                this.tvTitle.setText(this.context.getResources().getString(C1965R.string.dialog_camera_file_upgrading));
                this.uploadSuccessTips = this.context.getResources().getString(C1965R.string.dialog_camera_file_success_describe);
            } else if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_59) {
                this.tvTitle.setText(this.context.getResources().getString(C1965R.string.dialog_camera_upgrading));
                this.uploadSuccessTips = this.context.getResources().getString(C1965R.string.dialog_camera_update_success_describe);
            }
        }
        this.upgradingView.setVisibility(0);
        this.layoutBottom.setVisibility(8);
        this.btnUpgrade.setVisibility(8);
        this.layoutTop.setVisibility(8);
        this.progressBar = (ProgressBar) findViewById(C1965R.id.progress_bar);
        this.tvProgressPercent = (TextView) findViewById(C1965R.id.tv_progress_percent);
    }

    public void refreshProgress(final int i) {
        this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.5
            @Override // java.lang.Runnable
            public void run() {
                DDLog.m1685e("ftp", ", progress: " + i);
                if (CameraUpgradeDialog.this.progressBar != null) {
                    CameraUpgradeDialog.this.progressBar.setProgress(i);
                    CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Integer.valueOf(i), "%"));
                    if (i == 100) {
                        DDLog.m1685e("ftp", ", 升级成功:");
                        CameraUpgradeDialog.this.dismiss();
                        CameraUpgradeDialog.this.showDialog();
                    }
                }
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (((Activity) this.context).isFinishing() || BaseSyncDialog.isShow) {
            return;
        }
        Context context = this.context;
        GeneralDialog generalDialog = new GeneralDialog(context, context.getString(C1965R.string.dialog_success), this.uploadSuccessTips, 1, C1965R.mipmap.icon_camera_update_success, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.6
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
                ((Activity) CameraUpgradeDialog.this.context).finish();
            }
        });
        this.successDialog = generalDialog;
        generalDialog.show();
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
}
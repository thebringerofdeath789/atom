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
import com.ipotensic.kernel.R;
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
        super(context, R.layout.view_dialog_flight_upgrade);
        this.handler = new Handler(Looper.getMainLooper());
        this.context = context;
        this.version = version;
        this.tvTitle = (TextView) findViewById(R.id.tv_code_title);
        TextView textView = (TextView) findViewById(R.id.tv_detail);
        this.layoutTop = (ScrollView) findViewById(R.id.layout_top);
        this.layoutBottom = (LinearLayout) findViewById(R.id.layout_bottom);
        this.tvTitle.setText(getContext().getResources().getString(R.string.dialog_cam_upgrade_title));
        Button button = (Button) findViewById(R.id.btn_confirm);
        this.btnConfirm = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.btn_cancel);
        this.btnCancel = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.btn_upgrade);
        this.btnUpgrade = button3;
        button3.setOnClickListener(this);
        this.btnUpgrade.setVisibility(z ? 0 : 8);
        this.layoutBottom.setVisibility(z ? 4 : 0);
        if (version != null) {
            switch (AnonymousClass7.$SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.getLanguage(getContext()).ordinal()]) {
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
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE;

        static {
            int[] iArr = new int[LanguageHelper.LANGUAGE_TYPE.values().length];
            $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE = iArr;
            try {
                iArr[LanguageHelper.LANGUAGE_TYPE.CHINESE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.CHINESETAIWAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.FRENCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.ITALY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.GERMANY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.JAPAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.SPANISH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$utils$LanguageHelper$LANGUAGE_TYPE[LanguageHelper.LANGUAGE_TYPE.ENGLISH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_confirm || id == R.id.btn_upgrade) {
            if (FwDownloadManager.getInstance().upgradeCondition(this.context, this.version)) {
                showUpgradingView();
                startWifiUpgrade();
                return;
            }
            return;
        }
        if (id == R.id.btn_cancel) {
            Context context = this.context;
            new GeneralDialog(context, context.getString(R.string.dialog_exit_upgrade), this.context.getString(R.string.dialog_exit_upgrade_describe), true, (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.1
                AnonymousClass1() {
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                    CameraUpgradeDialog.this.dismiss();
                }
            }).show();
        }
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$1 */
    class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
        AnonymousClass1() {
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            CameraUpgradeDialog.this.dismiss();
        }
    }

    private void startWifiUpgrade() {
        String localPath = this.version.getLocalPath();
        if (localPath != null) {
            this.fileSize = new File(localPath).length();
            CameraCtrlPresenter.getInstance().checkUpgrade(this.fileSize, this.version.getComparedate(), new ICheckUpgradeCallback() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.2
                AnonymousClass2() {
                }

                @Override // com.logan.camera.listeners.ICheckUpgradeCallback
                public void canUpgrade() {
                    DDLog.e("sd\u5361\u53ef\u4ee5\u5347\u7ea7");
                    CameraUpgradeDialog.this.sendUpgradeFile();
                }

                @Override // com.logan.camera.listeners.ICheckUpgradeCallback
                public void notUpgrade(int i) {
                    String string;
                    if (i == -1) {
                        string = CameraUpgradeDialog.this.getContext().getString(R.string.sd_sdcard_is_full);
                    } else if (i == -2) {
                        string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_sd_error);
                    } else if (i == -3) {
                        string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_version_too_big);
                    } else {
                        string = CameraUpgradeDialog.this.getContext().getString(R.string.dialog_camera_failure_describe);
                    }
                    String str = string;
                    CameraUpgradeDialog.this.dismiss();
                    if (BaseSyncDialog.isShow) {
                        return;
                    }
                    CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.getContext(), CameraUpgradeDialog.this.getContext().getString(R.string.dialog_failure), str, 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.2.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }

                        AnonymousClass1() {
                        }
                    });
                    CameraUpgradeDialog.this.failDialog.show();
                }

                /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$2$1 */
                class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }

                    AnonymousClass1() {
                    }
                }
            });
        }
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$2 */
    class AnonymousClass2 implements ICheckUpgradeCallback {
        AnonymousClass2() {
        }

        @Override // com.logan.camera.listeners.ICheckUpgradeCallback
        public void canUpgrade() {
            DDLog.e("sd\u5361\u53ef\u4ee5\u5347\u7ea7");
            CameraUpgradeDialog.this.sendUpgradeFile();
        }

        @Override // com.logan.camera.listeners.ICheckUpgradeCallback
        public void notUpgrade(int i) {
            String string;
            if (i == -1) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.sd_sdcard_is_full);
            } else if (i == -2) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_sd_error);
            } else if (i == -3) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_version_too_big);
            } else {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.dialog_camera_failure_describe);
            }
            String str = string;
            CameraUpgradeDialog.this.dismiss();
            if (BaseSyncDialog.isShow) {
                return;
            }
            CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.getContext(), CameraUpgradeDialog.this.getContext().getString(R.string.dialog_failure), str, 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.2.1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }

                AnonymousClass1() {
                }
            });
            CameraUpgradeDialog.this.failDialog.show();
        }

        /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$2$1 */
        class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
            }

            AnonymousClass1() {
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3 */
    class AnonymousClass3 implements FTPUtils.UploadProgressListener {
        AnonymousClass3() {
        }

        /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ long val$progress;

            AnonymousClass1(long j) {
                r2 = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                DDLog.e("ftp", ", progress: " + r2);
                if (CameraUpgradeDialog.this.progressBar != null) {
                    CameraUpgradeDialog.this.progressBar.setProgress((int) r2);
                    CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Long.valueOf(r2), "%"));
                }
            }
        }

        @Override // com.logan.upgrade.local.camera.ftp.FTPUtils.UploadProgressListener
        public void onUploadProgress(long j) {
            CameraUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.1
                final /* synthetic */ long val$progress;

                AnonymousClass1(long j2) {
                    r2 = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DDLog.e("ftp", ", progress: " + r2);
                    if (CameraUpgradeDialog.this.progressBar != null) {
                        CameraUpgradeDialog.this.progressBar.setProgress((int) r2);
                        CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Long.valueOf(r2), "%"));
                    }
                }
            });
        }

        /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ boolean val$result;

            AnonymousClass2(boolean z) {
                r2 = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (r2) {
                    DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u6210\u529f");
                    CameraUpgradeDialog.this.uploadFirmware();
                    return;
                }
                CameraUpgradeDialog.this.dismiss();
                DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u5931\u8d25");
                if (BaseSyncDialog.isShow) {
                    return;
                }
                CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.context, CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed), CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed_describe), 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2.1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }

                    AnonymousClass1() {
                    }
                });
                CameraUpgradeDialog.this.failDialog.show();
            }

            /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$2$1 */
            class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }

                AnonymousClass1() {
                }
            }
        }

        @Override // com.logan.upgrade.local.camera.ftp.FTPUtils.UploadProgressListener
        public void onUploadEnd(boolean z) {
            CameraUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2
                final /* synthetic */ boolean val$result;

                AnonymousClass2(boolean z2) {
                    r2 = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (r2) {
                        DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u6210\u529f");
                        CameraUpgradeDialog.this.uploadFirmware();
                        return;
                    }
                    CameraUpgradeDialog.this.dismiss();
                    DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u5931\u8d25");
                    if (BaseSyncDialog.isShow) {
                        return;
                    }
                    CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.context, CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed), CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed_describe), 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }

                        AnonymousClass1() {
                        }
                    });
                    CameraUpgradeDialog.this.failDialog.show();
                }

                /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$2$1 */
                class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }

                    AnonymousClass1() {
                    }
                }
            });
        }
    }

    public void sendUpgradeFile() {
        FTPUtils.getInstance().uploadFile(this.version.getFilename(), this.version.getLocalPath(), this.fileSize, FTPUtils.CAM_USERNAME, "192.168.29.1", new FTPUtils.UploadProgressListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3
            AnonymousClass3() {
            }

            /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$1 */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ long val$progress;

                AnonymousClass1(long j2) {
                    r2 = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    DDLog.e("ftp", ", progress: " + r2);
                    if (CameraUpgradeDialog.this.progressBar != null) {
                        CameraUpgradeDialog.this.progressBar.setProgress((int) r2);
                        CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Long.valueOf(r2), "%"));
                    }
                }
            }

            @Override // com.logan.upgrade.local.camera.ftp.FTPUtils.UploadProgressListener
            public void onUploadProgress(long j2) {
                CameraUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.1
                    final /* synthetic */ long val$progress;

                    AnonymousClass1(long j22) {
                        r2 = j22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DDLog.e("ftp", ", progress: " + r2);
                        if (CameraUpgradeDialog.this.progressBar != null) {
                            CameraUpgradeDialog.this.progressBar.setProgress((int) r2);
                            CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Long.valueOf(r2), "%"));
                        }
                    }
                });
            }

            /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$2 */
            class AnonymousClass2 implements Runnable {
                final /* synthetic */ boolean val$result;

                AnonymousClass2(boolean z2) {
                    r2 = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (r2) {
                        DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u6210\u529f");
                        CameraUpgradeDialog.this.uploadFirmware();
                        return;
                    }
                    CameraUpgradeDialog.this.dismiss();
                    DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u5931\u8d25");
                    if (BaseSyncDialog.isShow) {
                        return;
                    }
                    CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.context, CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed), CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed_describe), 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }

                        AnonymousClass1() {
                        }
                    });
                    CameraUpgradeDialog.this.failDialog.show();
                }

                /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$2$1 */
                class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }

                    AnonymousClass1() {
                    }
                }
            }

            @Override // com.logan.upgrade.local.camera.ftp.FTPUtils.UploadProgressListener
            public void onUploadEnd(boolean z2) {
                CameraUpgradeDialog.this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2
                    final /* synthetic */ boolean val$result;

                    AnonymousClass2(boolean z22) {
                        r2 = z22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (r2) {
                            DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u6210\u529f");
                            CameraUpgradeDialog.this.uploadFirmware();
                            return;
                        }
                        CameraUpgradeDialog.this.dismiss();
                        DDLog.e("ftp", "\u5347\u7ea7\u6587\u4ef6\u53d1\u9001\u5931\u8d25");
                        if (BaseSyncDialog.isShow) {
                            return;
                        }
                        CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.context, CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed), CameraUpgradeDialog.this.context.getString(R.string.dialog_camera_save_failed_describe), 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.3.2.1
                            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                            public void confirm() {
                            }

                            AnonymousClass1() {
                            }
                        });
                        CameraUpgradeDialog.this.failDialog.show();
                    }

                    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$3$2$1 */
                    class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }

                        AnonymousClass1() {
                        }
                    }
                });
            }
        });
    }

    public void uploadFirmware() {
        CameraCtrlPresenter.getInstance().startUpgrade(this.version.getFilename(), String.valueOf(new FileGiver(this.version.getLocalPath(), 0).getUnsignedCheckCode()), new IStartUpgradeCallback() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.4
            AnonymousClass4() {
            }

            @Override // com.logan.camera.listeners.IStartUpgradeCallback
            public void upgradeSuccess() {
                DDLog.e("ftp", "\u7acb\u5373\u8fdb\u5165\u5347\u7ea7\u72b6\u6001");
                if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_56) {
                    CameraUpgradeDialog.this.dismiss();
                    CameraUpgradeDialog.this.showDialog();
                }
            }

            @Override // com.logan.camera.listeners.IStartUpgradeCallback
            public void upgradeFailed(int i) {
                String string;
                DDLog.e("ftp", "error: " + i);
                if (i == 1) {
                    string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_file_not_exist);
                } else if (i == 2) {
                    string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_crc_check_error);
                } else if (i == 3) {
                    string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_file_not_match);
                } else if (i == 4) {
                    string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_file_incorrect);
                } else {
                    string = CameraUpgradeDialog.this.getContext().getString(R.string.dialog_camera_failure_describe);
                }
                String str = string;
                CameraUpgradeDialog.this.dismiss();
                if (BaseSyncDialog.isShow) {
                    return;
                }
                CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.getContext(), CameraUpgradeDialog.this.getContext().getString(R.string.dialog_failure), str, 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.4.1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                    }

                    AnonymousClass1() {
                    }
                });
                CameraUpgradeDialog.this.failDialog.show();
            }

            /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$4$1 */
            class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }

                AnonymousClass1() {
                }
            }
        });
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$4 */
    class AnonymousClass4 implements IStartUpgradeCallback {
        AnonymousClass4() {
        }

        @Override // com.logan.camera.listeners.IStartUpgradeCallback
        public void upgradeSuccess() {
            DDLog.e("ftp", "\u7acb\u5373\u8fdb\u5165\u5347\u7ea7\u72b6\u6001");
            if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_56) {
                CameraUpgradeDialog.this.dismiss();
                CameraUpgradeDialog.this.showDialog();
            }
        }

        @Override // com.logan.camera.listeners.IStartUpgradeCallback
        public void upgradeFailed(int i) {
            String string;
            DDLog.e("ftp", "error: " + i);
            if (i == 1) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_file_not_exist);
            } else if (i == 2) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_crc_check_error);
            } else if (i == 3) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_file_not_match);
            } else if (i == 4) {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.upgrade_camera_file_incorrect);
            } else {
                string = CameraUpgradeDialog.this.getContext().getString(R.string.dialog_camera_failure_describe);
            }
            String str = string;
            CameraUpgradeDialog.this.dismiss();
            if (BaseSyncDialog.isShow) {
                return;
            }
            CameraUpgradeDialog.this.failDialog = new GeneralDialog(CameraUpgradeDialog.this.getContext(), CameraUpgradeDialog.this.getContext().getString(R.string.dialog_failure), str, 1, R.mipmap.img_dialog_failure, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.4.1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }

                AnonymousClass1() {
                }
            });
            CameraUpgradeDialog.this.failDialog.show();
        }

        /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$4$1 */
        class AnonymousClass1 implements GeneralDialog.ClickConfirmListener {
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
            }

            AnonymousClass1() {
            }
        }
    }

    private void showUpgradingView() {
        if (this.upgradingView == null) {
            View inflate = ((ViewStub) findViewById(R.id.stub_upgrading)).inflate();
            this.upgradingView = inflate;
            if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_56) {
                this.tvTitle.setText(this.context.getResources().getString(R.string.dialog_camera_file_upgrading));
                this.uploadSuccessTips = this.context.getResources().getString(R.string.dialog_camera_file_success_describe);
            } else if (CameraConfig.get().getCameraModel() == CameraModel.MODEL_59) {
                this.tvTitle.setText(this.context.getResources().getString(R.string.dialog_camera_upgrading));
                this.uploadSuccessTips = this.context.getResources().getString(R.string.dialog_camera_update_success_describe);
            }
        }
        this.upgradingView.setVisibility(0);
        this.layoutBottom.setVisibility(8);
        this.btnUpgrade.setVisibility(8);
        this.layoutTop.setVisibility(8);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.tvProgressPercent = (TextView) findViewById(R.id.tv_progress_percent);
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int val$progress;

        AnonymousClass5(int i) {
            r2 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DDLog.e("ftp", ", progress: " + r2);
            if (CameraUpgradeDialog.this.progressBar != null) {
                CameraUpgradeDialog.this.progressBar.setProgress(r2);
                CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Integer.valueOf(r2), "%"));
                if (r2 == 100) {
                    DDLog.e("ftp", ", \u5347\u7ea7\u6210\u529f:");
                    CameraUpgradeDialog.this.dismiss();
                    CameraUpgradeDialog.this.showDialog();
                }
            }
        }
    }

    public void refreshProgress(int i) {
        this.handler.post(new Runnable() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.5
            final /* synthetic */ int val$progress;

            AnonymousClass5(int i2) {
                r2 = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DDLog.e("ftp", ", progress: " + r2);
                if (CameraUpgradeDialog.this.progressBar != null) {
                    CameraUpgradeDialog.this.progressBar.setProgress(r2);
                    CameraUpgradeDialog.this.tvProgressPercent.setText(String.format("%d%s", Integer.valueOf(r2), "%"));
                    if (r2 == 100) {
                        DDLog.e("ftp", ", \u5347\u7ea7\u6210\u529f:");
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

    public void showDialog() {
        if (((Activity) this.context).isFinishing() || BaseSyncDialog.isShow) {
            return;
        }
        Context context = this.context;
        GeneralDialog generalDialog = new GeneralDialog(context, context.getString(R.string.dialog_success), this.uploadSuccessTips, 1, R.mipmap.icon_camera_update_success, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog.6
            AnonymousClass6() {
            }

            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
                ((Activity) CameraUpgradeDialog.this.context).finish();
            }
        });
        this.successDialog = generalDialog;
        generalDialog.show();
    }

    /* renamed from: com.ipotensic.kernel.view.dialog.CameraUpgradeDialog$6 */
    class AnonymousClass6 implements GeneralDialog.ClickConfirmListener {
        AnonymousClass6() {
        }

        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
        public void confirm() {
            ((Activity) CameraUpgradeDialog.this.context).finish();
        }
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
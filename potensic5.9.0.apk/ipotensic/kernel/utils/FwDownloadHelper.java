package com.ipotensic.kernel.utils;

import android.content.DialogInterface;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.okhttp.DownloadListener2;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public class FwDownloadHelper {
    private static volatile FwDownloadHelper instance;
    private BaseActivity activity;
    private FwUpgradeConditionDialog downLoadDialog;
    private DownloadResultListener onResultListener;
    private long totalSize;
    private FwUpgradeConditionDialog upgradeDialog;
    private boolean isDownloadFail = false;
    private long progressSize = 0;
    private boolean isDownloadingFw = false;
    private DownloadListener2 downloadListener = new DownloadListener2() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.2
        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadStart(long j) {
            DDLog.e("progress: \u9700\u8981\u4e0b\u8f7d\u56fa\u4ef6\u7684\u603b\u5927\u5c0f= " + j);
            FwDownloadHelper.this.progressSize = 0L;
            FwDownloadHelper.this.totalSize = j;
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadProgress(final long j) {
            DDLog.e("progress\uff1a" + j);
            DDLog.e("progress\uff1a,!activity.isFinishing(): " + (!FwDownloadHelper.this.activity.isFinishing()));
            DDLog.e("progress\uff1a,totalSize != 0: " + (FwDownloadHelper.this.totalSize != 0));
            DDLog.e("progress\uff1a,upgradeDialog != null:  " + (FwDownloadHelper.this.upgradeDialog != null));
            FwDownloadHelper.this.activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.2.1
                @Override // java.lang.Runnable
                public void run() {
                    DDLog.e("progress111111111111111");
                    if (FwDownloadHelper.this.activity.isFinishing() || FwDownloadHelper.this.totalSize == 0 || FwDownloadHelper.this.upgradeDialog == null) {
                        return;
                    }
                    DDLog.e("progress22222222222");
                    int i = (int) (((FwDownloadHelper.this.progressSize + j) * 100) / FwDownloadHelper.this.totalSize);
                    DDLog.e("progress -> \u4e0b\u8f7d\u8fdb\u5ea6= " + FwDownloadHelper.this.progressSize + ", size= " + j + ", \u603b\u5927\u5c0f= " + FwDownloadHelper.this.totalSize + ", \u5f53\u524d\u8fdb\u5ea6= " + i);
                    if (i >= 100) {
                        i = 100;
                    }
                    FwDownloadHelper.this.upgradeDialog.setProgress(i);
                }
            });
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                DDLog.e("progress: \u4e0b\u8f7d\u8fdb\u5ea6\u51fa\u9519\uff1a" + e);
                e.printStackTrace();
            }
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadEnd(String str, String str2, String str3) {
            FwDownloadHelper.access$514(FwDownloadHelper.this, Long.parseLong(str3) * 1024);
            DDLog.e("progress \u5355\u4e2a\u56fa\u4ef6\u4e0b\u8f7d\u7ed3\u675f= " + FwDownloadHelper.this.progressSize + ", fileSize = " + str3);
            DDLog.e("\u56fa\u4ef6\u4e0b\u8f7d \u5f53\u524d\u4e0b\u8f7d\u7684\u56fa\u4ef6\u662f\uff1a " + str2 + ", filePath = " + str);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadFinished() {
            FwDownloadHelper.this.isDownloadingFw = false;
            SPHelper.getInstance().setNeedDownloadFw(false);
            FwDownloadHelper.this.activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.2.2
                @Override // java.lang.Runnable
                public void run() {
                    DDLog.e("progress: onDownloadFinished");
                    if (!FwDownloadHelper.this.isDownloadFail && FwDownloadHelper.this.upgradeDialog != null && !FwDownloadHelper.this.activity.isFinishing()) {
                        FwDownloadHelper.this.upgradeDialog.setProgress(100);
                        FwDownloadHelper.this.upgradeDialog.dismiss();
                    }
                    if (FwDownloadHelper.this.onResultListener != null) {
                        FwDownloadHelper.this.onResultListener.downloadSuccess(true);
                    }
                }
            });
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadError(final Exception exc) {
            DDLog.e("progress: onDownloadError" + exc.getMessage());
            FwDownloadHelper.this.isDownloadingFw = false;
            FwDownloadHelper.this.activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.2.3
                @Override // java.lang.Runnable
                public void run() {
                    FwDownloadHelper.this.progressSize = 0L;
                    if (FwDownloadHelper.this.activity.isFinishing()) {
                        return;
                    }
                    FwDownloadHelper.this.isDownloadFail = true;
                    if (exc instanceof UnknownHostException) {
                        ToastUtil.toast(FwDownloadHelper.this.activity, FwDownloadHelper.this.activity.getString(R.string.toast_no_network));
                    } else {
                        ToastUtil.toast(FwDownloadHelper.this.activity, FwDownloadHelper.this.activity.getString(R.string.download_fail));
                    }
                    if (FwDownloadHelper.this.upgradeDialog != null && FwDownloadHelper.this.upgradeDialog.isShowing()) {
                        FwDownloadHelper.this.upgradeDialog.dismiss();
                    }
                    if (FwDownloadHelper.this.onResultListener != null) {
                        FwDownloadHelper.this.onResultListener.downloadSuccess(false);
                    }
                }
            });
        }
    };

    public interface DownloadResultListener {
        void downloadFailed();

        void downloadRequest();

        void downloadResult(boolean z);

        void downloadSuccess(boolean z);
    }

    static /* synthetic */ long access$514(FwDownloadHelper fwDownloadHelper, long j) {
        long j2 = fwDownloadHelper.progressSize + j;
        fwDownloadHelper.progressSize = j2;
        return j2;
    }

    private FwDownloadHelper() {
    }

    public static FwDownloadHelper getInstance() {
        if (instance == null) {
            synchronized (FwDownloadHelper.class) {
                if (instance == null) {
                    instance = new FwDownloadHelper();
                }
            }
        }
        return instance;
    }

    public void downloadFw(final BaseActivity baseActivity, final boolean z, final DownloadResultListener downloadResultListener) {
        if (FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || SPHelper.getInstance().getIsBigPackage()) {
            return;
        }
        this.activity = baseActivity;
        this.onResultListener = downloadResultListener;
        if (FlightConfig.getLastProductClass() != null) {
            FwDownloadManager.getInstance().getFwFromServer(new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.1
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Boolean bool) {
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "isForceDownload: " + bool);
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "BaseSyncDialog.isShow: " + BaseSyncDialog.isShow);
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "upgradeDialog != null && upgradeDialog.isShowing(): " + (FwDownloadHelper.this.upgradeDialog != null && FwDownloadHelper.this.upgradeDialog.isShowing()));
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "FlightRevData.get().getFlightRevStateData().isFlight(): " + FlightRevData.get().getFlightRevStateData().isFlight());
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "FlightRevData.get().getFlightRevStateData().isUnLock(): " + FlightRevData.get().getFlightRevStateData().isUnLock());
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "activity.isFinishing(): " + baseActivity.isFinishing());
                    DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6", "FwDownloadManager.getInstance().isDialogShowing(): " + FwDownloadManager.getInstance().isDialogShowing());
                    if ((FwDownloadHelper.this.upgradeDialog != null && FwDownloadHelper.this.upgradeDialog.isShowing()) || FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevStateData().isUnLock() || baseActivity.isFinishing() || FwDownloadManager.getInstance().isDialogShowing()) {
                        return;
                    }
                    if (FwDownloadHelper.this.downLoadDialog == null || !FwDownloadHelper.this.downLoadDialog.isShowing()) {
                        if (FwDownloadHelper.this.downLoadDialog != null) {
                            FwDownloadHelper.this.downLoadDialog.dismiss();
                            FwDownloadHelper.this.downLoadDialog = null;
                        }
                        DDLog.e("\u4e0b\u8f7d\u56fa\u4ef6\u5f39\u6846isHorizontal: " + z);
                        int i = z ? R.layout.view_dialog_fw_download_black : R.layout.view_dialog_fw_download_white;
                        if (FwDownloadHelper.this.downLoadDialog == null) {
                            FwDownloadHelper.this.downLoadDialog = new FwUpgradeConditionDialog(baseActivity, i, z, bool, new FwUpgradeConditionDialog.FwDownLoadListener() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.1.1
                                @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                                public void cancelDownLoad() {
                                }

                                @Override // com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.FwDownLoadListener
                                public void startDownLoad() {
                                    DDLog.e("\u5f00\u59cb\u4e0b\u8f7d\u56fa\u4ef6");
                                    FwDownloadHelper.this.isDownloadFail = false;
                                    if (!baseActivity.isFinishing()) {
                                        FwDownloadHelper.this.isDownloadingFw = true;
                                        DDLog.e("\u6b63\u4e0b\u8f7d\u56fa\u4ef6", "1111111111");
                                        FwDownloadHelper.this.upgradeDialog = new FwUpgradeConditionDialog(baseActivity, z ? R.layout.view_dialog_fw_upgrade_black : R.layout.view_dialog_fw_upgrade_white, z);
                                        DDLog.e("\u6b63\u4e0b\u8f7d\u56fa\u4ef6", "222222222");
                                        FwDownloadHelper.this.upgradeDialog.show();
                                        DDLog.e("\u6b63\u4e0b\u8f7d\u56fa\u4ef6", "333333333");
                                    }
                                    FwDownloadManager.getInstance().startDownloadFw(FwDownloadHelper.this.downloadListener);
                                }
                            });
                        }
                        if (!FwDownloadHelper.this.downLoadDialog.isShowing()) {
                            FwDownloadHelper.this.downLoadDialog.show();
                        }
                        DownloadResultListener downloadResultListener2 = downloadResultListener;
                        if (downloadResultListener2 != null) {
                            downloadResultListener2.downloadResult(true);
                        }
                        FwDownloadHelper.this.downLoadDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ipotensic.kernel.utils.FwDownloadHelper.1.2
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                FwDownloadHelper.this.downLoadDialog = null;
                            }
                        });
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                    DownloadResultListener downloadResultListener2 = downloadResultListener;
                    if (downloadResultListener2 != null) {
                        downloadResultListener2.downloadResult(false);
                    }
                    if (FwDownloadHelper.this.downLoadDialog == null || !FwDownloadHelper.this.downLoadDialog.isShowing()) {
                        return;
                    }
                    FwDownloadHelper.this.downLoadDialog.dismiss();
                    FwDownloadHelper.this.downLoadDialog = null;
                }
            });
        }
    }

    public boolean isDownloadingFw() {
        return this.isDownloadingFw;
    }

    public void release(BaseActivity baseActivity) {
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        try {
            this.isDownloadingFw = false;
            this.isDownloadFail = false;
            FwUpgradeConditionDialog fwUpgradeConditionDialog = this.downLoadDialog;
            if (fwUpgradeConditionDialog != null && fwUpgradeConditionDialog.isShowing() && (baseActivity3 = this.activity) != null && !baseActivity3.isFinishing() && this.activity.getClass() == baseActivity.getClass()) {
                this.downLoadDialog.dismiss();
            }
            FwUpgradeConditionDialog fwUpgradeConditionDialog2 = this.upgradeDialog;
            if (fwUpgradeConditionDialog2 == null || !fwUpgradeConditionDialog2.isShowing() || (baseActivity2 = this.activity) == null || baseActivity2.isFinishing() || this.activity.getClass() != baseActivity.getClass()) {
                return;
            }
            this.upgradeDialog.dismiss();
        } catch (Exception e) {
            DDLog.e("\u5f39\u7a97\u6d88\u5931\u5f02\u5e38:" + e.getMessage());
        }
    }
}
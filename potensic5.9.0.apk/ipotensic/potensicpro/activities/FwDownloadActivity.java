package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.okhttp.DownloadListener2;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.utils.FwDownloadManager;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public class FwDownloadActivity extends BaseActivity implements View.OnClickListener {
    private Button btnStartDownload;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private TextView tvDownloadTips;
    private TextView tvProgress;
    private TextView tvTips;
    private boolean isDownloading = false;
    private long totalSize = 0;
    private boolean isDownloadFail = false;
    private long progressSize = 0;
    private DownloadListener2 listener = new DownloadListener2() { // from class: com.ipotensic.potensicpro.activities.FwDownloadActivity.1
        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadStart(long j) {
            FwDownloadActivity.this.progressSize = 0L;
            FwDownloadActivity.this.totalSize = j;
            FwDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FwDownloadActivity.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FwDownloadActivity.this.isFinishing()) {
                        return;
                    }
                    FwDownloadActivity.this.setViewShow(true);
                }
            });
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadProgress(final long j) {
            try {
                Thread.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FwDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FwDownloadActivity.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FwDownloadActivity.this.isFinishing() || FwDownloadActivity.this.totalSize == 0) {
                        return;
                    }
                    int i = (int) (((FwDownloadActivity.this.progressSize + j) * 100) / FwDownloadActivity.this.totalSize);
                    if (i >= 100) {
                        i = 100;
                    }
                    FwDownloadActivity.this.progressBar.setProgress(i);
                    FwDownloadActivity.this.tvProgress.setText(String.format("%d%s", Integer.valueOf(i), "%"));
                }
            });
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadEnd(String str, String str2, String str3) {
            FwDownloadActivity.access$014(FwDownloadActivity.this, Long.parseLong(str3) * 1024);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadFinished() {
            FwDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FwDownloadActivity.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (FwDownloadActivity.this.isDownloadFail || FwDownloadActivity.this.isFinishing()) {
                        return;
                    }
                    FwDownloadActivity.this.tvProgress.setText("100%");
                    FwDownloadActivity.this.finish(true);
                }
            });
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener2
        public void onDownloadError(final Exception exc) {
            if (FwDownloadActivity.this.isFinishing()) {
                return;
            }
            FwDownloadActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FwDownloadActivity.1.4
                @Override // java.lang.Runnable
                public void run() {
                    FwDownloadActivity.this.isDownloadFail = true;
                    if (exc instanceof UnknownHostException) {
                        ToastUtil.toast(FwDownloadActivity.this, FwDownloadActivity.this.getString(R.string.toast_no_network));
                    } else {
                        ToastUtil.toast(FwDownloadActivity.this, FwDownloadActivity.this.getString(R.string.download_fail));
                    }
                    FwDownloadActivity.this.setViewShow(false);
                }
            });
        }
    };

    static /* synthetic */ long access$014(FwDownloadActivity fwDownloadActivity, long j) {
        long j2 = fwDownloadActivity.progressSize + j;
        fwDownloadActivity.progressSize = j2;
        return j2;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_fw_download);
        setToolBar();
        initView();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        ((TextView) this.toolbar.findViewById(R.id.tv_code_title)).setText(getResources().getString(R.string.download_fw_title));
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        this.tvDownloadTips = (TextView) findViewById(R.id.tv_download_tips);
        Button button = (Button) findViewById(R.id.btn_start_download);
        this.btnStartDownload = button;
        button.setOnClickListener(this);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.tvProgress = (TextView) findViewById(R.id.tv_progress);
        this.tvTips = (TextView) findViewById(R.id.tv_tips);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            if (this.isDownloading) {
                exitDownload();
                return;
            } else {
                finish();
                return;
            }
        }
        if (view.getId() == R.id.btn_start_download) {
            this.isDownloadFail = false;
            FwDownloadManager.getInstance().startDownloadFw(this.listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewShow(boolean z) {
        this.isDownloading = z;
        this.progressBar.setVisibility(z ? 0 : 4);
        this.tvProgress.setVisibility(z ? 0 : 4);
        this.tvTips.setVisibility(z ? 0 : 4);
        this.btnStartDownload.setVisibility(z ? 8 : 0);
        this.tvDownloadTips.setText(getString(z ? R.string.download_start_tips : R.string.download_new_fw_tips));
    }

    private void exitDownload() {
        new GeneralDialog((Context) this, getString(R.string.exit_download), getString(R.string.exit_download_content), getString(R.string.dialog_cancel), getString(R.string.dialog_confirm), true, false, new GeneralDialog.DialogListener() { // from class: com.ipotensic.potensicpro.activities.FwDownloadActivity.2
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
            public void cancel() {
            }

            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
            public void confirm() {
                FwDownloadActivity.this.setViewShow(false);
                FwDownloadManager.getInstance().cancelDownload();
                FwDownloadActivity.this.finish(false);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("isDownloadEnd", z);
        setResult(-1, intent);
        finish();
    }
}
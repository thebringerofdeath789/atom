package com.ipotensic.potensicpro.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ZipUtils;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.potensicpro.R;
import com.logan.user.model.HttpPresenter;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class UploadLogDialog extends BaseSyncDialog {
    private Activity activity;
    private Button btnOk;
    private ImageView loadingView;
    private TextView tvContent;
    private TextView tvTitle;

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public UploadLogDialog(Activity activity) {
        super(activity, R.layout.view_dialog_upload_log);
        setCanceledOnTouchOutside(false);
        this.activity = activity;
        this.tvTitle = (TextView) findViewById(R.id.tv_title);
        this.tvContent = (TextView) findViewById(R.id.tv_content);
        this.loadingView = (ImageView) findViewById(R.id.img_loading);
        Button button = (Button) findViewById(R.id.btn_sure);
        this.btnOk = button;
        button.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.view.dialog.UploadLogDialog.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                UploadLogDialog.this.dismiss();
            }
        });
        this.tvTitle.setText("Uploading...");
        showLoadingView();
        uploadLogs();
    }

    private void uploadLogs() {
        new Thread(new Runnable() { // from class: com.ipotensic.potensicpro.view.dialog.UploadLogDialog.2
            @Override // java.lang.Runnable
            public void run() {
                final String formatCurTime = FormatUtil.formatCurTime();
                DDLog.e("\u4e0a\u4f20\u65e5\u5fd7:" + formatCurTime);
                ArrayList<String> arrayList = LocalFileManager.getInstance().get12HoursLogs();
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                final String str = UploadLogDialog.this.getContext().getCacheDir().toString() + File.separator + formatCurTime + ".zip";
                long currentTimeMillis = System.currentTimeMillis();
                ZipUtils.zipFiles(arrayList, str);
                DDLog.e("\u538b\u7f29\u8017\u65f6:" + (System.currentTimeMillis() - currentTimeMillis));
                HttpPresenter.getInstance().postDumpFile(UploadLogDialog.this.getContext(), str, new OnResultListener<String>() { // from class: com.ipotensic.potensicpro.view.dialog.UploadLogDialog.2.1
                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onSuccess(String str2) {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        UploadLogDialog.this.upResult(true, formatCurTime);
                    }

                    @Override // com.ipotensic.baselib.okhttp.OnResultListener
                    public void onFailed(Exception exc) {
                        UploadLogDialog.this.upResult(false, formatCurTime);
                    }
                });
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upResult(final boolean z, final String str) {
        if (this.activity.isFinishing()) {
            return;
        }
        this.activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.view.dialog.UploadLogDialog.3
            @Override // java.lang.Runnable
            public void run() {
                UploadLogDialog.this.hideLoadingView();
                if (z) {
                    UploadLogDialog.this.tvContent.setVisibility(0);
                    UploadLogDialog.this.tvTitle.setText("Upload Successs!");
                    UploadLogDialog.this.tvContent.setText("Code : " + str + "\nPlease Show The Code To US");
                } else {
                    UploadLogDialog.this.tvContent.setVisibility(0);
                    UploadLogDialog.this.tvTitle.setText("Upload Failed");
                    UploadLogDialog.this.tvContent.setText("Upload Failed! Please Check the network!");
                }
            }
        });
    }

    private void showLoadingView() {
        this.btnOk.setVisibility(8);
        ImageView imageView = this.loadingView;
        if (imageView == null || imageView.getVisibility() == 0) {
            return;
        }
        this.loadingView.setVisibility(0);
        this.loadingView.bringToFront();
        AnimationUtil.selfRotate(this.loadingView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.btnOk.setVisibility(0);
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            if (imageView.getVisibility() == 0) {
                this.loadingView.setVisibility(8);
            }
            this.loadingView.clearAnimation();
        }
    }
}
package com.ipotensic.kernel.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseDialog;
import com.ipotensic.baselib.okhttp.DownloadListener;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.logan.camera.CameraConfig;
import com.logan.camera.enums.SdCardState;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class DownloadFileDialog extends BaseDialog {
    private Context context;
    private int curDownloadNum;
    private DownloadCallback downloadCallback;
    private String formatStr;
    private boolean isShowDownloadSuccess;
    private ImageView iv;
    private CancelListener listener;
    private int needDownloadNum;
    private NumberProgressBar progressBar;
    private TextView tvProgress;

    public interface CancelListener {
        void noEnoughMemory();

        void onCancelClicked();

        void onDownloadError(String str);

        void onDownloadFinished();
    }

    static /* synthetic */ int access$308(DownloadFileDialog downloadFileDialog) {
        int i = downloadFileDialog.curDownloadNum;
        downloadFileDialog.curDownloadNum = i + 1;
        return i;
    }

    public DownloadFileDialog(Context context, int i, CancelListener cancelListener) {
        super(context, R.layout.view_dialog_download_file);
        this.curDownloadNum = 0;
        this.isShowDownloadSuccess = true;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.needDownloadNum = i;
        this.listener = cancelListener;
        this.downloadCallback = new DownloadCallback();
        String charSequence = this.tvProgress.getText().toString();
        this.formatStr = charSequence;
        this.tvProgress.setText(String.format(charSequence, "1/" + i));
        AnimationUtil.selfRotate(this.iv);
        getWindow().setGravity(17);
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.45d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.75d), -2);
        }
    }

    public DownloadListener getDownloadListener() {
        return this.downloadCallback;
    }

    public void setShowDownloadSuccess(boolean z) {
        this.isShowDownloadSuccess = z;
    }

    public void setTitleVisible(int i) {
        this.tvProgress.setVisibility(i);
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.context = context;
        this.iv = (ImageView) findViewById(R.id.iv_rotate);
        this.tvProgress = (TextView) findViewById(R.id.tv_progress);
        this.progressBar = (NumberProgressBar) findViewById(R.id.progress_bar);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.DownloadFileDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DownloadFileDialog.this.listener != null) {
                    DownloadFileDialog.this.listener.onCancelClicked();
                }
                DownloadFileDialog.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            LocalFileManager.getInstance().scanAlbum(null);
            this.downloadCallback.removeAllMsg();
            this.iv.clearAnimation();
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    private class DownloadCallback implements Handler.Callback, DownloadListener {
        private final int DOWNLOAD_END;
        private final int DOWNLOAD_ERROR;
        private final int DOWNLOAD_PROGRESS;
        private final int DOWNLOAD_SPACE_NOT_ENOUGH;
        private final int DOWNLOAD_START;
        private Handler handler;

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadEnd(String str, String str2) {
        }

        private DownloadCallback() {
            this.DOWNLOAD_START = 1;
            this.DOWNLOAD_PROGRESS = 2;
            this.DOWNLOAD_END = 3;
            this.DOWNLOAD_ERROR = 4;
            this.DOWNLOAD_SPACE_NOT_ENOUGH = 5;
            this.handler = new Handler(this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DownloadFileDialog.access$308(DownloadFileDialog.this);
                AnimationUtil.selfRotate(DownloadFileDialog.this.iv);
            } else if (i == 2) {
                int i2 = message.arg1;
                DownloadFileDialog.this.tvProgress.setText(String.format(DownloadFileDialog.this.formatStr, DownloadFileDialog.this.curDownloadNum + InternalZipConstants.ZIP_FILE_SEPARATOR + DownloadFileDialog.this.needDownloadNum, Integer.valueOf(i2)));
                DownloadFileDialog.this.progressBar.setProgress(i2);
            } else if (i != 3) {
                if (i == 4) {
                    DownloadFileDialog.this.dismiss();
                    if (CameraConfig.get().sdCardState != SdCardState.SD_CARD_NOT_EXIST) {
                        ToastUtil.toast((Activity) DownloadFileDialog.this.context, DownloadFileDialog.this.getContext().getResources().getString(R.string.dialog_download_failure));
                        String str = (String) message.obj;
                        DDLog.i("error:" + str);
                        if (DownloadFileDialog.this.listener != null) {
                            DownloadFileDialog.this.listener.onDownloadError(str);
                        }
                    }
                } else if (i == 5) {
                    DownloadFileDialog.this.dismiss();
                    ToastUtil.toast((Activity) DownloadFileDialog.this.context, DownloadFileDialog.this.getContext().getResources().getString(R.string.dialog_download_failure_sd_not_space));
                    if (DownloadFileDialog.this.listener != null) {
                        DownloadFileDialog.this.listener.noEnoughMemory();
                    }
                }
            } else if (DownloadFileDialog.this.curDownloadNum == DownloadFileDialog.this.needDownloadNum) {
                DownloadFileDialog.this.dismiss();
                if (DownloadFileDialog.this.isShowDownloadSuccess) {
                    ToastUtil.showImageTop((Activity) DownloadFileDialog.this.context, DownloadFileDialog.this.getContext().getResources().getString(R.string.toast_download_success), R.mipmap.icon_toast_successful);
                }
                if (DownloadFileDialog.this.listener != null) {
                    DownloadFileDialog.this.listener.onDownloadFinished();
                }
            }
            return false;
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadStart() {
            this.handler.sendEmptyMessage(1);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadProgress(float f, long j) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = (int) f;
            this.handler.sendMessage(message);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadEnd(String str) {
            this.handler.sendEmptyMessage(3);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void onDownloadError(Exception exc) {
            Message message = new Message();
            message.what = 4;
            message.obj = exc.getMessage();
            this.handler.sendMessage(message);
        }

        @Override // com.ipotensic.baselib.okhttp.DownloadListener
        public void notEnoughSpace() {
            this.handler.sendEmptyMessage(5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAllMsg() {
            this.handler.removeMessages(1);
            this.handler.removeMessages(2);
            this.handler.removeMessages(3);
            this.handler.removeMessages(4);
            this.handler.removeMessages(5);
        }
    }

    private static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
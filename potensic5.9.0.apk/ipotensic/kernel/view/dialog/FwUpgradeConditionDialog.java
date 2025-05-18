package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;
import com.logan.camera.CameraConfig;
import com.logan.camera.enums.SdCardState;

/* loaded from: classes2.dex */
public class FwUpgradeConditionDialog extends BaseSyncDialog {
    private Context context;
    private ProgressBar progressBar;
    private TextView tvProgress;
    private TextView tvSdState;

    public interface BigPackageUpgradeListener {
        void toUpgrade();
    }

    public interface FwDownLoadListener {
        void cancelDownLoad();

        void startDownLoad();
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public FwUpgradeConditionDialog(Context context, int i, boolean z, boolean z2, final FwDownLoadListener fwDownLoadListener) {
        super(context, i);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                if (context.getResources().getConfiguration().orientation == 2) {
                    attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.45d);
                    attributes.height = -2;
                } else {
                    attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.45d);
                    attributes.height = -2;
                }
            } else {
                attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.9d);
                attributes.height = -2;
            }
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        Button button = (Button) findViewById(R.id.btn_download);
        Button button2 = (Button) findViewById(R.id.btn_cancel);
        Button button3 = (Button) findViewById(R.id.btn_ok);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_btn);
        TextView textView = (TextView) findViewById(R.id.tv_content);
        button3.setVisibility(z2 ? 0 : 8);
        linearLayout.setVisibility(z2 ? 8 : 0);
        textView.setText(context.getString(z2 ? R.string.fw_detected_important_firmware : R.string.fw_detected_new_firmware));
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FwUpgradeConditionDialog.this.dismiss();
                FwDownLoadListener fwDownLoadListener2 = fwDownLoadListener;
                if (fwDownLoadListener2 != null) {
                    fwDownLoadListener2.startDownLoad();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FwUpgradeConditionDialog.this.dismiss();
                FwDownLoadListener fwDownLoadListener2 = fwDownLoadListener;
                if (fwDownLoadListener2 != null) {
                    fwDownLoadListener2.startDownLoad();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FwUpgradeConditionDialog.this.dismiss();
                FwDownLoadListener fwDownLoadListener2 = fwDownLoadListener;
                if (fwDownLoadListener2 != null) {
                    fwDownLoadListener2.cancelDownLoad();
                }
            }
        });
    }

    public FwUpgradeConditionDialog(Context context, int i, boolean z, Boolean bool, final FwDownLoadListener fwDownLoadListener) {
        super(context, i);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                if (context.getResources().getConfiguration().orientation == 2) {
                    attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.5d);
                } else {
                    attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.5d);
                }
            } else if (context.getResources().getConfiguration().orientation == 2) {
                attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.85d);
            } else {
                attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.85d);
            }
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        Button button = (Button) findViewById(R.id.btn_download);
        Button button2 = (Button) findViewById(R.id.btn_cancel);
        Button button3 = (Button) findViewById(R.id.btn_ok);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_btn);
        button3.setVisibility(bool.booleanValue() ? 0 : 8);
        linearLayout.setVisibility(bool.booleanValue() ? 8 : 0);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FwUpgradeConditionDialog.this.dismiss();
                FwDownLoadListener fwDownLoadListener2 = fwDownLoadListener;
                if (fwDownLoadListener2 != null) {
                    fwDownLoadListener2.startDownLoad();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FwUpgradeConditionDialog.this.dismiss();
                FwDownLoadListener fwDownLoadListener2 = fwDownLoadListener;
                if (fwDownLoadListener2 != null) {
                    fwDownLoadListener2.startDownLoad();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.FwUpgradeConditionDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FwUpgradeConditionDialog.this.dismiss();
                FwDownLoadListener fwDownLoadListener2 = fwDownLoadListener;
                if (fwDownLoadListener2 != null) {
                    fwDownLoadListener2.cancelDownLoad();
                }
            }
        });
    }

    public FwUpgradeConditionDialog(Context context, int i, boolean z) {
        super(context, i);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                if (context.getResources().getConfiguration().orientation == 2) {
                    attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.45d);
                    attributes.height = (int) (ScreenUtils.getScreenHeight(context) * 0.69d);
                } else {
                    attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.45d);
                    attributes.height = (int) (ScreenUtils.getScreenWidth(context) * 0.69d);
                }
            } else {
                if (context.getResources().getConfiguration().orientation == 2) {
                    attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.9d);
                } else {
                    attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.9d);
                }
                attributes.height = -2;
            }
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.tvProgress = (TextView) findViewById(R.id.tv_progress);
    }

    public FwUpgradeConditionDialog(Context context, String str, boolean z, boolean z2, boolean z3, String str2, final boolean z4) {
        super(context, R.layout.view_dialog_unable_upgrade_tip_new);
        this.context = context;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (context.getResources().getConfiguration().orientation == 2) {
                attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.5d);
            } else {
                attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.5d);
            }
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        ((TextView) findViewById(R.id.tv_upgrade_firmware)).setText(String.format("%s%s", getContext().getString(R.string.dialog_upgrade_firmware), str));
        TextView textView = (TextView) findViewById(R.id.tv_plane_battery_low);
        TextView textView2 = (TextView) findViewById(R.id.line_plane);
        ImageView imageView = (ImageView) findViewById(R.id.iv_plane);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_remote);
        this.tvSdState = (TextView) findViewById(R.id.tv_sd_state);
        TextView textView3 = (TextView) findViewById(R.id.line_sd);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_sd);
        textView.setVisibility(z ? 0 : 8);
        textView2.setVisibility(z ? 0 : 8);
        imageView.setVisibility(z ? 0 : 8);
        imageView.setImageResource(z2 ? R.mipmap.icon_upgrade_fail : R.mipmap.icon_upgrade_success);
        imageView2.setImageResource(z3 ? R.mipmap.icon_upgrade_fail : R.mipmap.icon_upgrade_success);
        if (str2 == null) {
            this.tvSdState.setVisibility(8);
            textView3.setVisibility(8);
            imageView3.setVisibility(8);
        } else {
            this.tvSdState.setVisibility(0);
            textView3.setVisibility(0);
            imageView3.setVisibility(0);
            this.tvSdState.setText(str2);
        }
        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$FwUpgradeConditionDialog$Wi0Mlswta66BrXaySXFsz913BJo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FwUpgradeConditionDialog.this.lambda$new$0$FwUpgradeConditionDialog(z4, view);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$FwUpgradeConditionDialog(boolean z, View view) {
        if (z) {
            EventDispatcher.get().sendEvent(EventID.EVENT_REFRESH_CHECK_FORCE_UPGRADE);
        }
        dismiss();
    }

    public FwUpgradeConditionDialog(Context context, final FwDownLoadListener fwDownLoadListener) {
        super(context, R.layout.view_dialog_big_package_exit);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.43d), -2);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$FwUpgradeConditionDialog$QwK8JbK3MaGB63qzLd2G2O-lCvQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FwUpgradeConditionDialog.this.lambda$new$1$FwUpgradeConditionDialog(view);
            }
        });
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$FwUpgradeConditionDialog$18n4KDwWPOXEfL7lpQ65flf48b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FwUpgradeConditionDialog.this.lambda$new$2$FwUpgradeConditionDialog(fwDownLoadListener, view);
            }
        });
    }

    public /* synthetic */ void lambda$new$1$FwUpgradeConditionDialog(View view) {
        dismiss();
    }

    public /* synthetic */ void lambda$new$2$FwUpgradeConditionDialog(FwDownLoadListener fwDownLoadListener, View view) {
        if (fwDownLoadListener != null) {
            fwDownLoadListener.cancelDownLoad();
        }
        dismiss();
    }

    public FwUpgradeConditionDialog(Context context, final BigPackageUpgradeListener bigPackageUpgradeListener) {
        super(context, R.layout.view_dialog_big_package_upgrade_not_completed);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.43d), -2);
        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.-$$Lambda$FwUpgradeConditionDialog$oMr5CMllCAds6y1nueNRVE1GKOc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FwUpgradeConditionDialog.this.lambda$new$3$FwUpgradeConditionDialog(bigPackageUpgradeListener, view);
            }
        });
    }

    public /* synthetic */ void lambda$new$3$FwUpgradeConditionDialog(BigPackageUpgradeListener bigPackageUpgradeListener, View view) {
        dismiss();
        if (bigPackageUpgradeListener != null) {
            bigPackageUpgradeListener.toUpgrade();
        }
    }

    public void refreshSdcard() {
        if (this.tvSdState != null) {
            String string = CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_EXIST ? this.context.getString(R.string.sd_no_sdcard) : null;
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NEED_FORMAT) {
                string = this.context.getString(R.string.title_pls_format);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NOT_ENOUGH_SPACE) {
                string = this.context.getString(R.string.sd_sdcard_is_full);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_LOW_SPEED) {
                string = this.context.getString(R.string.sd_speed_low);
            }
            if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_UNRECOGNIZED) {
                string = this.context.getString(R.string.sd_unknown_type);
            }
            if (string != null) {
                this.tvSdState.setText(string);
            }
        }
    }

    public void setProgress(int i) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null || this.tvProgress == null) {
            return;
        }
        progressBar.setProgress(i);
        this.tvProgress.setText(String.format("%d%s", Integer.valueOf(i), "%"));
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, com.ipotensic.baselib.base.BaseDialog, android.app.Dialog
    public void show() {
        super.show();
    }
}
package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.dialog.LandConfirmDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.type.Flight;
import java.util.ArrayList;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class GeneralDialog extends BaseSyncDialog {
    private Button cancelBtn;
    public Button confirmBtn;
    private int currentPosition;
    private DialogListener dialogListener;
    private ImageView img;
    private ClickConfirmListener listener;
    private View llBtn;
    private TextView messageView;
    private Button okBtn;
    private final double ratio;
    private TextView titleView;
    private VideoView videoView;
    private int zoomHeight;
    private int zoomWidth;

    public interface ClickConfirmListener {
        void confirm();
    }

    public interface ConnectStatusListener {
        void confirm();

        void toFeedBack();
    }

    public interface DialogListener {
        void cancel();

        void confirm();
    }

    public GeneralDialog(Context context, boolean z, String str) {
        super(context, R.layout.view_dialog_remote);
        String string;
        this.ratio = 2.0d;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        if (context.getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.43d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenHeight(context) * 0.43d), -2);
        }
        if (FlightConfig.getLastFlight() != null && (FlightConfig.getLastFlight().getFlightByte() == Flight.Flight_ATOM_SE.getFlightByte() || FlightConfig.getLastFlight().getFlightByte() == Flight.Flight_ATOM_LT.getFlightByte() || FlightConfig.getLastFlight().getFlightByte() == Flight.Flight_ATOM.getFlightByte())) {
            string = getContext().getString(R.string.dialog_remoter_upgrade_tips_mini);
        } else {
            string = getContext().getString(R.string.dialog_remoter_upgrade_tips);
        }
        ((TextView) findViewById(R.id.tv_content)).setText(string);
    }

    public GeneralDialog(Context context, final LandConfirmDialog.OnConfirmListener onConfirmListener) {
        super(context, R.layout.view_dialog_switch_mode);
        this.ratio = 2.0d;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onConfirmListener.onCancel();
                GeneralDialog.this.dismiss();
            }
        });
        findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onConfirmListener.onConfirm();
                GeneralDialog.this.dismiss();
            }
        });
    }

    public GeneralDialog(Context context, boolean z, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_guide_hexahedral_calibration);
        this.ratio = 2.0d;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.listener = clickConfirmListener;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = (int) (ScreenUtils.getScreenHeight(context) * 0.65d);
        attributes.width = (int) (ScreenUtils.getScreenWidth(context) * 0.5d);
        window.setAttributes(attributes);
    }

    public GeneralDialog(Context context, String str, String str2) {
        super(context, R.layout.view_dialog_return_count_down);
        this.ratio = 2.0d;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.height = -2;
        attributes.width = (int) (ScreenUtils.getScreenHeight(context) * 0.3d);
        window.setAttributes(attributes);
        this.titleView.setText(str);
    }

    public GeneralDialog(Context context, int i, final ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_new_map_guide);
        this.ratio = 2.0d;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        window.setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.682d), -2);
        window.setGravity(17);
        window.setWindowAnimations(R.style.mapGuideStyle);
        this.confirmBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralDialog.this.dismiss();
                clickConfirmListener.confirm();
            }
        });
    }

    public GeneralDialog(Context context, final int i) {
        super(context, R.layout.guide_video_view);
        this.ratio = 2.0d;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.getDecorView().setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 16) {
            window.getDecorView().setBackground(ContextCompat.getDrawable(context, R.color.colorBlack));
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.mapGuideStyle);
        this.videoView = (VideoView) findViewById(R.id.video_view);
        final Button button = (Button) findViewById(R.id.btn_cancel);
        final Button button2 = (Button) findViewById(R.id.btn_confirm);
        final ImageButton imageButton = (ImageButton) findViewById(R.id.btn_close);
        if (i == R.raw.video_rth_guide) {
            if (SPHelper.getInstance().isRthGuideVideoShown()) {
                imageButton.setVisibility(0);
            } else {
                imageButton.setVisibility(8);
            }
        }
        final String str = "android.resource://" + getContext().getPackageName() + InternalZipConstants.ZIP_FILE_SEPARATOR + i;
        this.videoView.setVideoURI(Uri.parse(str));
        this.currentPosition = 0;
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                GeneralDialog.this.videoView.seekTo(GeneralDialog.this.currentPosition);
                GeneralDialog.this.videoView.start();
            }
        });
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                GeneralDialog.this.videoView.stopPlayback();
                GeneralDialog.this.videoView.suspend();
                button.setVisibility(0);
                button2.setVisibility(0);
                imageButton.setVisibility(8);
                if (i == R.raw.video_rth_guide) {
                    SPHelper.getInstance().setRthGuideVideoShown(true);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                button.setVisibility(8);
                button2.setVisibility(8);
                GeneralDialog.this.videoView.setVideoURI(Uri.parse(str));
                GeneralDialog.this.videoView.start();
                imageButton.setVisibility(0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                button.setVisibility(8);
                button2.setVisibility(8);
                GeneralDialog.this.videoView = null;
                GeneralDialog.this.dismiss();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralDialog.this.videoView.stopPlayback();
                GeneralDialog.this.videoView.suspend();
                imageButton.setVisibility(8);
                GeneralDialog.this.videoView = null;
                GeneralDialog.this.dismiss();
            }
        });
    }

    public void onPauseVideo() {
        VideoView videoView = this.videoView;
        if (videoView != null) {
            this.currentPosition = videoView.getCurrentPosition();
        }
    }

    private void setScreenZoomRatio(Window window) {
        float screenHeight = ScreenUtils.getScreenHeight(getContext());
        float screenWidth = ScreenUtils.getScreenWidth(getContext());
        if (screenWidth / screenHeight >= 2.0d) {
            int i = (int) (screenHeight * 0.85d);
            this.zoomHeight = i;
            this.zoomWidth = (int) (i * 2.0d);
        } else {
            int i2 = (int) (screenWidth * 0.85d);
            this.zoomWidth = i2;
            this.zoomHeight = (int) (i2 / 2.0d);
        }
        window.setLayout(this.zoomWidth, this.zoomHeight);
    }

    public GeneralDialog(Context context, final DialogListener dialogListener) {
        super(context, R.layout.view_dialog_format_sd);
        this.ratio = 2.0d;
        this.dialogListener = dialogListener;
        setCanceledOnTouchOutside(false);
        this.cancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralDialog.this.dismiss();
                dialogListener.cancel();
            }
        });
        this.confirmBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralDialog.this.dismiss();
                dialogListener.confirm();
            }
        });
    }

    public GeneralDialog(Context context, String str, String str2, String str3, final DialogListener dialogListener) {
        super(context, R.layout.view_dialog_general_gray);
        this.ratio = 2.0d;
        this.dialogListener = dialogListener;
        setCanceledOnTouchOutside(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        if (str3 != null) {
            this.confirmBtn.setText(str3);
        } else {
            this.confirmBtn.setText(context.getString(R.string.dialog_confirm));
        }
        Button button = this.cancelBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    dialogListener.cancel();
                }
            });
        }
        Button button2 = this.confirmBtn;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    dialogListener.confirm();
                }
            });
        }
    }

    public GeneralDialog(Context context, boolean z, String str, String str2, String str3, ClickConfirmListener clickConfirmListener) {
        super(context, z ? R.layout.view_dialog_button_one : R.layout.view_dialog_white_button_one);
        this.ratio = 2.0d;
        this.listener = clickConfirmListener;
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        Button button = this.okBtn;
        if (button != null) {
            button.setText(TextUtils.isEmpty(str3) ? "" : str3);
        }
        Button button2 = this.confirmBtn;
        if (button2 != null) {
            button2.setText(TextUtils.isEmpty(str3) ? "" : str3);
        }
    }

    public GeneralDialog(Context context, String str, String str2, int i, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_dialog_user_peron_info);
        this.ratio = 2.0d;
        this.listener = clickConfirmListener;
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
    }

    public GeneralDialog(Context context, String str) {
        super(context, R.layout.view_dialog_open_network);
        this.ratio = 2.0d;
        Window window = getWindow();
        if (context.getResources().getConfiguration().orientation == 2) {
            window.setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.4d), -2);
        } else {
            window.setLayout((int) (ScreenUtils.getScreenHeight(context) * 0.8d), -2);
        }
        window.setGravity(17);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = (TextView) findViewById(R.id.tv_dialog_message);
        if (str != null) {
            textView.setText(str);
        }
    }

    public GeneralDialog(Context context, String str, String str2, int i, int i2, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_dialog_upgrade_tips);
        this.ratio = 2.0d;
        Window window = getWindow();
        if (context.getResources().getConfiguration().orientation == 2) {
            window.setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.4d), -2);
        } else {
            window.setLayout((int) (ScreenUtils.getScreenHeight(context) * 0.4d), -2);
        }
        this.listener = clickConfirmListener;
        window.setGravity(17);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        this.llBtn.setVisibility(i == 1 ? 8 : 0);
        this.okBtn.setVisibility(i != 1 ? 8 : 0);
        this.img.setImageResource(i2);
    }

    public GeneralDialog(Context context, String... strArr) {
        super(context, R.layout.view_dialog_setting_tips);
        this.ratio = 2.0d;
        getWindow().setDimAmount(0.0f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        String str = null;
        for (String str2 : strArr) {
            if (str2 != null) {
                arrayList.add(str2);
                str = str2;
            }
        }
        if (arrayList.size() >= 2) {
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 == arrayList.size() - 1) {
                    i++;
                    sb.append(i).append(".").append((String) arrayList.get(i2));
                } else {
                    i++;
                    sb.append(i).append(".").append((String) arrayList.get(i2)).append("\n");
                }
            }
            this.messageView.setText(sb.toString());
            return;
        }
        if (arrayList.size() == 1) {
            this.messageView.setText(str);
        }
    }

    public GeneralDialog(Context context, String str, String str2, String str3, String str4, boolean z, int i, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_dialog_general_gray);
        this.ratio = 2.0d;
        this.listener = clickConfirmListener;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        if (str3 != null) {
            this.cancelBtn.setText(str3);
        } else {
            this.cancelBtn.setText(context.getString(R.string.dialog_cancel));
        }
        if (str4 != null) {
            this.confirmBtn.setText(str4);
        } else {
            this.confirmBtn.setText(context.getString(R.string.dialog_confirm));
        }
        if (z) {
            this.confirmBtn.setBackgroundColor(context.getResources().getColor(R.color.color_dialog_red_bg));
        }
        if (i == 1) {
            this.llBtn.setVisibility(8);
            this.okBtn.setVisibility(0);
        } else {
            this.llBtn.setVisibility(0);
            this.okBtn.setVisibility(8);
        }
    }

    public GeneralDialog(Context context, String str, String str2, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_dialog_roll);
        this.ratio = 2.0d;
        this.listener = clickConfirmListener;
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.55d), -2);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
    }

    public GeneralDialog(Context context, String str, String str2, String str3, String str4, final OnResultListener<Boolean> onResultListener) {
        super(context, R.layout.view_dialog_roll);
        this.ratio = 2.0d;
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.45d), -2);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = (Button) findViewById(R.id.btn_cancel);
        Button button2 = (Button) findViewById(R.id.btn_confirm);
        button.setText(str3);
        button2.setText(str4);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralDialog.this.dismiss();
                OnResultListener onResultListener2 = onResultListener;
                if (onResultListener2 != null) {
                    onResultListener2.onSuccess(false);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralDialog.this.dismiss();
                OnResultListener onResultListener2 = onResultListener;
                if (onResultListener2 != null) {
                    onResultListener2.onSuccess(true);
                }
            }
        });
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
    }

    public GeneralDialog(Context context, String str, String str2, final DialogListener dialogListener) {
        super(context, R.layout.view_dialog_general_cancel_account);
        this.ratio = 2.0d;
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.8d), -2);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        Button button = this.confirmBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    dialogListener.confirm();
                }
            });
        }
        Button button2 = this.cancelBtn;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                }
            });
        }
    }

    public GeneralDialog(Context context, String str, String str2, String str3, String str4, boolean z, boolean z2, DialogListener dialogListener) {
        super(context, R.layout.view_dialog_general_while_bg);
        this.ratio = 2.0d;
        getWindow().setLayout((int) (ScreenUtils.getScreenWidth(context) * 0.8d), -2);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.dialogListener = dialogListener;
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        if (str3 != null) {
            this.cancelBtn.setText(str3);
        } else {
            this.cancelBtn.setText(context.getString(R.string.dialog_cancel));
        }
        if (str4 != null) {
            this.confirmBtn.setText(str4);
        } else {
            this.confirmBtn.setText(context.getString(R.string.dialog_confirm));
        }
        if (z) {
            this.confirmBtn.setTextColor(context.getResources().getColor(R.color.color_dialog_update_bg));
            this.cancelBtn.setTextColor(context.getResources().getColor(R.color.color_dialog_blue_bg));
        }
        Button button = this.confirmBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    GeneralDialog.this.dialogListener.confirm();
                }
            });
        }
        Button button2 = this.cancelBtn;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    GeneralDialog.this.dialogListener.cancel();
                }
            });
        }
    }

    public GeneralDialog(Context context, String str, String str2, int i, boolean z, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_dialog_general_white_top_icon);
        this.ratio = 2.0d;
        this.listener = clickConfirmListener;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
        if (z) {
            this.okBtn.setTextColor(context.getResources().getColor(R.color.color_dialog_blue_bg));
        }
        this.img.setImageResource(i);
    }

    public GeneralDialog(Context context, String str, String str2, boolean z, ClickConfirmListener clickConfirmListener) {
        super(context, R.layout.view_dialog_general_top_icon);
        this.ratio = 2.0d;
        this.listener = clickConfirmListener;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(str) ? "" : str);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null) {
            textView2.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
        this.titleView = (TextView) findViewById(R.id.tv_dialog_title);
        this.messageView = (TextView) findViewById(R.id.tv_dialog_message);
        this.cancelBtn = (Button) findViewById(R.id.btn_cancel);
        this.confirmBtn = (Button) findViewById(R.id.btn_confirm);
        this.llBtn = findViewById(R.id.ll_btn);
        this.okBtn = (Button) findViewById(R.id.btn_ok);
        this.img = (ImageView) findViewById(R.id.iv_img);
        initListener();
    }

    private void initListener() {
        Button button = this.cancelBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.confirmBtn;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    if (GeneralDialog.this.listener != null) {
                        GeneralDialog.this.listener.confirm();
                    }
                }
            });
        }
        Button button3 = this.okBtn;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GeneralDialog.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GeneralDialog.this.dismiss();
                    if (GeneralDialog.this.listener != null) {
                        GeneralDialog.this.listener.confirm();
                    }
                }
            });
        }
    }

    @Override // com.ipotensic.baselib.base.BaseDialog, android.app.Dialog, android.view.Window.Callback
    public void onContentChanged() {
        if (getContext().getResources().getConfiguration().orientation == 2) {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.45d), -2);
        } else {
            getWindow().setLayout((int) (ScreenUtils.getScreenWidth(getContext()) * 0.7d), -2);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseSyncDialog, com.ipotensic.baselib.base.BaseDialog, android.app.Dialog
    public void show() {
        super.show();
    }
}

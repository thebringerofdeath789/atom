package com.ipotensic.kernel.view.dialog;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;
import com.ipotensic.kernel.C1965R;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes2.dex */
public class GimbalModeDialog extends com.ipotensic.baselib.base.BaseDialog {
    private ImageButton btnPlay;
    private boolean isStable;
    private TextView tvFpv;
    private TextView tvStable;
    private String uri;
    private VideoView videoView;

    @Override // com.ipotensic.baselib.base.BaseDialog
    protected void initView(Context context) {
    }

    public GimbalModeDialog(Context context, boolean z) {
        super(context, C1965R.layout.view_dialog_gimbal_model_guide_video);
        this.isStable = z;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.getDecorView().setBackground(context.getResources().getDrawable(C1965R.color.colorBlack));
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(2);
        this.tvStable = (TextView) findViewById(C1965R.id.tv_stable);
        this.tvFpv = (TextView) findViewById(C1965R.id.tv_fpv);
        this.btnPlay = (ImageButton) findViewById(C1965R.id.btn_play);
        this.videoView = (VideoView) findViewById(C1965R.id.video_view);
        switchTo(z);
        start();
        this.tvStable.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GimbalModeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GimbalModeDialog.this.isStable) {
                    return;
                }
                GimbalModeDialog.this.isStable = true;
                GimbalModeDialog gimbalModeDialog = GimbalModeDialog.this;
                gimbalModeDialog.switchTo(gimbalModeDialog.isStable);
            }
        });
        this.tvFpv.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GimbalModeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GimbalModeDialog.this.isStable) {
                    GimbalModeDialog.this.isStable = false;
                    GimbalModeDialog gimbalModeDialog = GimbalModeDialog.this;
                    gimbalModeDialog.switchTo(gimbalModeDialog.isStable);
                }
            }
        });
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.view.dialog.GimbalModeDialog.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                GimbalModeDialog.this.stop();
            }
        });
        this.btnPlay.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GimbalModeDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GimbalModeDialog.this.start();
            }
        });
        findViewById(C1965R.id.btn_exit).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.dialog.GimbalModeDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GimbalModeDialog.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchTo(boolean z) {
        stop();
        if (z) {
            this.tvStable.setTextColor(getContext().getColor(C1965R.color.white));
            this.tvFpv.setTextColor(getContext().getColor(C1965R.color.color_white_sixty_percent));
        } else {
            this.tvStable.setTextColor(getContext().getColor(C1965R.color.color_white_sixty_percent));
            this.tvFpv.setTextColor(getContext().getColor(C1965R.color.white));
        }
        String str = "android.resource://" + getContext().getPackageName() + InternalZipConstants.ZIP_FILE_SEPARATOR + (z ? C1965R.raw.video_stable_mode : C1965R.raw.video_fpv_mode);
        this.uri = str;
        this.videoView.setVideoURI(Uri.parse(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        this.btnPlay.setVisibility(8);
        this.videoView.setVideoURI(Uri.parse(this.uri));
        this.videoView.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        this.videoView.stopPlayback();
        this.videoView.suspend();
        this.btnPlay.setVisibility(0);
    }
}
package xyz.doikki.videocontroller.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.player.VideoViewManager;

/* loaded from: classes6.dex */
public class PrepareView extends FrameLayout implements IControlComponent {
    private ControlWrapper mControlWrapper;
    private ProgressBar mLoading;
    private FrameLayout mNetWarning;
    private ImageView mStartPlay;
    private ImageView mThumb;

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public View getView() {
        return this;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onLockStateChanged(boolean z) {
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayerStateChanged(int i) {
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onVisibilityChanged(boolean z, Animation animation) {
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void setProgress(int i, int i2) {
    }

    public PrepareView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_prepare_view, (ViewGroup) this, true);
        this.mThumb = (ImageView) findViewById(R.id.thumb);
        this.mStartPlay = (ImageView) findViewById(R.id.start_play);
        this.mLoading = (ProgressBar) findViewById(R.id.loading);
        this.mNetWarning = (FrameLayout) findViewById(R.id.net_warning_layout);
        findViewById(R.id.status_btn).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.PrepareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrepareView.this.mNetWarning.setVisibility(8);
                VideoViewManager.instance().setPlayOnMobileNetwork(true);
                PrepareView.this.mControlWrapper.start();
            }
        });
    }

    public PrepareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_prepare_view, (ViewGroup) this, true);
        this.mThumb = (ImageView) findViewById(R.id.thumb);
        this.mStartPlay = (ImageView) findViewById(R.id.start_play);
        this.mLoading = (ProgressBar) findViewById(R.id.loading);
        this.mNetWarning = (FrameLayout) findViewById(R.id.net_warning_layout);
        findViewById(R.id.status_btn).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.PrepareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrepareView.this.mNetWarning.setVisibility(8);
                VideoViewManager.instance().setPlayOnMobileNetwork(true);
                PrepareView.this.mControlWrapper.start();
            }
        });
    }

    public PrepareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_prepare_view, (ViewGroup) this, true);
        this.mThumb = (ImageView) findViewById(R.id.thumb);
        this.mStartPlay = (ImageView) findViewById(R.id.start_play);
        this.mLoading = (ProgressBar) findViewById(R.id.loading);
        this.mNetWarning = (FrameLayout) findViewById(R.id.net_warning_layout);
        findViewById(R.id.status_btn).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.PrepareView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrepareView.this.mNetWarning.setVisibility(8);
                VideoViewManager.instance().setPlayOnMobileNetwork(true);
                PrepareView.this.mControlWrapper.start();
            }
        });
    }

    public ImageView getThumbView() {
        return this.mThumb;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        switch (i) {
            case -1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setVisibility(8);
                break;
            case 0:
                setVisibility(0);
                bringToFront();
                this.mLoading.setVisibility(8);
                this.mNetWarning.setVisibility(8);
                this.mStartPlay.setVisibility(8);
                this.mThumb.setVisibility(0);
                break;
            case 1:
                bringToFront();
                setVisibility(0);
                this.mStartPlay.setVisibility(8);
                this.mNetWarning.setVisibility(8);
                this.mLoading.setVisibility(0);
                break;
            case 8:
                setVisibility(0);
                this.mNetWarning.setVisibility(0);
                this.mNetWarning.bringToFront();
                break;
        }
    }
}

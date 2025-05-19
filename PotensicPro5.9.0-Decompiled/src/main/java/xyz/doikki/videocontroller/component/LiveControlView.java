package xyz.doikki.videocontroller.component;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class LiveControlView extends FrameLayout implements IControlComponent, View.OnClickListener {
    private LinearLayout mBottomContainer;
    private ControlWrapper mControlWrapper;
    private ImageView mFullScreen;
    private ImageView mPlayButton;

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public View getView() {
        return this;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void setProgress(int i, int i2) {
    }

    public LiveControlView(Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_live_control_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.fullscreen);
        this.mFullScreen = imageView;
        imageView.setOnClickListener(this);
        this.mBottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_play);
        this.mPlayButton = imageView2;
        imageView2.setOnClickListener(this);
        ((ImageView) findViewById(R.id.iv_refresh)).setOnClickListener(this);
    }

    public LiveControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_live_control_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.fullscreen);
        this.mFullScreen = imageView;
        imageView.setOnClickListener(this);
        this.mBottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_play);
        this.mPlayButton = imageView2;
        imageView2.setOnClickListener(this);
        ((ImageView) findViewById(R.id.iv_refresh)).setOnClickListener(this);
    }

    public LiveControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_live_control_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.fullscreen);
        this.mFullScreen = imageView;
        imageView.setOnClickListener(this);
        this.mBottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_play);
        this.mPlayButton = imageView2;
        imageView2.setOnClickListener(this);
        ((ImageView) findViewById(R.id.iv_refresh)).setOnClickListener(this);
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onVisibilityChanged(boolean z, Animation animation) {
        if (z) {
            if (getVisibility() == 8) {
                setVisibility(0);
                if (animation != null) {
                    startAnimation(animation);
                    return;
                }
                return;
            }
            return;
        }
        if (getVisibility() == 0) {
            setVisibility(8);
            if (animation != null) {
                startAnimation(animation);
            }
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 5:
            case 8:
                setVisibility(8);
                break;
            case 3:
                this.mPlayButton.setSelected(true);
                break;
            case 4:
                this.mPlayButton.setSelected(false);
                break;
            case 6:
            case 7:
                this.mPlayButton.setSelected(this.mControlWrapper.isPlaying());
                break;
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayerStateChanged(int i) {
        if (i == 10) {
            this.mFullScreen.setSelected(false);
        } else if (i == 11) {
            this.mFullScreen.setSelected(true);
        }
        Activity scanForActivity = PlayerUtils.scanForActivity(getContext());
        if (scanForActivity == null || !this.mControlWrapper.hasCutout()) {
            return;
        }
        int requestedOrientation = scanForActivity.getRequestedOrientation();
        int cutoutHeight = this.mControlWrapper.getCutoutHeight();
        if (requestedOrientation == 1) {
            this.mBottomContainer.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            this.mBottomContainer.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            this.mBottomContainer.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onLockStateChanged(boolean z) {
        onVisibilityChanged(!z, (Animation) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.fullscreen) {
            toggleFullScreen();
        } else if (id == R.id.iv_play) {
            this.mControlWrapper.togglePlay();
        } else if (id == R.id.iv_refresh) {
            this.mControlWrapper.replay(true);
        }
    }

    private void toggleFullScreen() {
        this.mControlWrapper.toggleFullScreen(PlayerUtils.scanForActivity(getContext()));
    }
}

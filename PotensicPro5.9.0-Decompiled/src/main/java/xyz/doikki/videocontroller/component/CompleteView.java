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
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class CompleteView extends FrameLayout implements IControlComponent {
    private ControlWrapper mControlWrapper;
    private ImageView mStopFullscreen;

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public View getView() {
        return this;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onLockStateChanged(boolean z) {
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onVisibilityChanged(boolean z, Animation animation) {
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void setProgress(int i, int i2) {
    }

    public CompleteView(Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(R.id.iv_replay).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.CompleteView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CompleteView.this.mControlWrapper.replay(true);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.stop_fullscreen);
        this.mStopFullscreen = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.CompleteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity scanForActivity;
                if (!CompleteView.this.mControlWrapper.isFullScreen() || (scanForActivity = PlayerUtils.scanForActivity(CompleteView.this.getContext())) == null || scanForActivity.isFinishing()) {
                    return;
                }
                scanForActivity.setRequestedOrientation(1);
                CompleteView.this.mControlWrapper.stopFullScreen();
            }
        });
    }

    public CompleteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(R.id.iv_replay).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.CompleteView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CompleteView.this.mControlWrapper.replay(true);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.stop_fullscreen);
        this.mStopFullscreen = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.CompleteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity scanForActivity;
                if (!CompleteView.this.mControlWrapper.isFullScreen() || (scanForActivity = PlayerUtils.scanForActivity(CompleteView.this.getContext())) == null || scanForActivity.isFinishing()) {
                    return;
                }
                scanForActivity.setRequestedOrientation(1);
                CompleteView.this.mControlWrapper.stopFullScreen();
            }
        });
    }

    public CompleteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_complete_view, (ViewGroup) this, true);
        findViewById(R.id.iv_replay).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.CompleteView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CompleteView.this.mControlWrapper.replay(true);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.stop_fullscreen);
        this.mStopFullscreen = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.CompleteView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity scanForActivity;
                if (!CompleteView.this.mControlWrapper.isFullScreen() || (scanForActivity = PlayerUtils.scanForActivity(CompleteView.this.getContext())) == null || scanForActivity.isFinishing()) {
                    return;
                }
                scanForActivity.setRequestedOrientation(1);
                CompleteView.this.mControlWrapper.stopFullScreen();
            }
        });
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        if (i == 5) {
            setVisibility(0);
            this.mStopFullscreen.setVisibility(this.mControlWrapper.isFullScreen() ? 0 : 8);
            bringToFront();
            return;
        }
        setVisibility(8);
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayerStateChanged(int i) {
        if (i == 11) {
            this.mStopFullscreen.setVisibility(0);
        } else if (i == 10) {
            this.mStopFullscreen.setVisibility(8);
        }
        Activity scanForActivity = PlayerUtils.scanForActivity(getContext());
        if (scanForActivity == null || !this.mControlWrapper.hasCutout()) {
            return;
        }
        int requestedOrientation = scanForActivity.getRequestedOrientation();
        int cutoutHeight = this.mControlWrapper.getCutoutHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mStopFullscreen.getLayoutParams();
        if (requestedOrientation == 1) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            layoutParams.setMargins(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            layoutParams.setMargins(0, 0, 0, 0);
        }
    }
}

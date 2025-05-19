package xyz.doikki.videocontroller.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IGestureComponent;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class GestureView extends FrameLayout implements IGestureComponent {
    private LinearLayout mCenterContainer;
    private ControlWrapper mControlWrapper;
    private ImageView mIcon;
    private ProgressBar mProgressPercent;
    private TextView mTextPercent;

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

    public GestureView(Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.mIcon = (ImageView) findViewById(R.id.iv_icon);
        this.mProgressPercent = (ProgressBar) findViewById(R.id.pro_percent);
        this.mTextPercent = (TextView) findViewById(R.id.tv_percent);
        this.mCenterContainer = (LinearLayout) findViewById(R.id.center_container);
    }

    public GestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.mIcon = (ImageView) findViewById(R.id.iv_icon);
        this.mProgressPercent = (ProgressBar) findViewById(R.id.pro_percent);
        this.mTextPercent = (TextView) findViewById(R.id.tv_percent);
        this.mCenterContainer = (LinearLayout) findViewById(R.id.center_container);
    }

    public GestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.mIcon = (ImageView) findViewById(R.id.iv_icon);
        this.mProgressPercent = (ProgressBar) findViewById(R.id.pro_percent);
        this.mTextPercent = (TextView) findViewById(R.id.tv_percent);
        this.mCenterContainer = (LinearLayout) findViewById(R.id.center_container);
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IGestureComponent
    public void onStartSlide() {
        this.mControlWrapper.hide();
        this.mCenterContainer.setVisibility(0);
        this.mCenterContainer.setAlpha(1.0f);
    }

    @Override // xyz.doikki.videoplayer.controller.IGestureComponent
    public void onStopSlide() {
        this.mCenterContainer.animate().alpha(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: xyz.doikki.videocontroller.component.GestureView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                GestureView.this.mCenterContainer.setVisibility(8);
            }
        }).start();
    }

    @Override // xyz.doikki.videoplayer.controller.IGestureComponent
    public void onPositionChange(int i, int i2, int i3) {
        this.mProgressPercent.setVisibility(8);
        if (i > i2) {
            this.mIcon.setImageResource(R.drawable.dkplayer_ic_action_fast_forward);
        } else {
            this.mIcon.setImageResource(R.drawable.dkplayer_ic_action_fast_rewind);
        }
        this.mTextPercent.setText(String.format("%s/%s", PlayerUtils.stringForTime(i), PlayerUtils.stringForTime(i3)));
    }

    @Override // xyz.doikki.videoplayer.controller.IGestureComponent
    public void onBrightnessChange(int i) {
        this.mProgressPercent.setVisibility(0);
        this.mIcon.setImageResource(R.drawable.dkplayer_ic_action_brightness);
        this.mTextPercent.setText(i + "%");
        this.mProgressPercent.setProgress(i);
    }

    @Override // xyz.doikki.videoplayer.controller.IGestureComponent
    public void onVolumeChange(int i) {
        this.mProgressPercent.setVisibility(0);
        if (i <= 0) {
            this.mIcon.setImageResource(R.drawable.dkplayer_ic_action_volume_off);
        } else {
            this.mIcon.setImageResource(R.drawable.dkplayer_ic_action_volume_up);
        }
        this.mTextPercent.setText(i + "%");
        this.mProgressPercent.setProgress(i);
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        if (i == 0 || i == 8 || i == 1 || i == 2 || i == -1 || i == 5) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }
}

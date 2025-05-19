package xyz.doikki.videocontroller.component;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class VodControlView extends FrameLayout implements IControlComponent, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private LinearLayout mBottomContainer;
    private ProgressBar mBottomProgress;
    protected ControlWrapper mControlWrapper;
    private TextView mCurrTime;
    private ImageView mFullScreen;
    private boolean mIsDragging;
    private boolean mIsShowBottomProgress;
    private ImageView mPlayButton;
    private TextView mTotalTime;
    private SeekBar mVideoProgress;
    private OnVodControllerViewChangeListener viewChangeListener;

    public interface OnVodControllerViewChangeListener {
        void onBottomViewVisible(int i);
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public View getView() {
        return this;
    }

    public VodControlView(Context context) {
        super(context);
        this.mIsShowBottomProgress = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.fullscreen);
        this.mFullScreen = imageView;
        imageView.setOnClickListener(this);
        this.mBottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.mVideoProgress = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.mTotalTime = (TextView) findViewById(R.id.total_time);
        this.mCurrTime = (TextView) findViewById(R.id.curr_time);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_play);
        this.mPlayButton = imageView2;
        imageView2.setOnClickListener(this);
        this.mBottomProgress = (ProgressBar) findViewById(R.id.bottom_progress);
        if (Build.VERSION.SDK_INT <= 22) {
            this.mVideoProgress.getLayoutParams().height = -2;
        }
    }

    public VodControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsShowBottomProgress = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.fullscreen);
        this.mFullScreen = imageView;
        imageView.setOnClickListener(this);
        this.mBottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.mVideoProgress = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.mTotalTime = (TextView) findViewById(R.id.total_time);
        this.mCurrTime = (TextView) findViewById(R.id.curr_time);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_play);
        this.mPlayButton = imageView2;
        imageView2.setOnClickListener(this);
        this.mBottomProgress = (ProgressBar) findViewById(R.id.bottom_progress);
        if (Build.VERSION.SDK_INT <= 22) {
            this.mVideoProgress.getLayoutParams().height = -2;
        }
    }

    public VodControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsShowBottomProgress = true;
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.fullscreen);
        this.mFullScreen = imageView;
        imageView.setOnClickListener(this);
        this.mBottomContainer = (LinearLayout) findViewById(R.id.bottom_container);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        this.mVideoProgress = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        this.mTotalTime = (TextView) findViewById(R.id.total_time);
        this.mCurrTime = (TextView) findViewById(R.id.curr_time);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_play);
        this.mPlayButton = imageView2;
        imageView2.setOnClickListener(this);
        this.mBottomProgress = (ProgressBar) findViewById(R.id.bottom_progress);
        if (Build.VERSION.SDK_INT <= 22) {
            this.mVideoProgress.getLayoutParams().height = -2;
        }
    }

    protected int getLayoutId() {
        return R.layout.dkplayer_layout_vod_control_view;
    }

    public void showBottomProgress(boolean z) {
        this.mIsShowBottomProgress = z;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onVisibilityChanged(boolean z, Animation animation) {
        if (z) {
            this.mBottomContainer.setVisibility(0);
            if (animation != null) {
                this.mBottomContainer.startAnimation(animation);
            }
            if (this.mIsShowBottomProgress) {
                this.mBottomProgress.setVisibility(8);
            }
        } else {
            this.mBottomContainer.setVisibility(8);
            if (animation != null) {
                this.mBottomContainer.startAnimation(animation);
            }
            if (this.mIsShowBottomProgress) {
                this.mBottomProgress.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300L);
                this.mBottomProgress.startAnimation(alphaAnimation);
            }
        }
        OnVodControllerViewChangeListener onVodControllerViewChangeListener = this.viewChangeListener;
        if (onVodControllerViewChangeListener != null) {
            onVodControllerViewChangeListener.onBottomViewVisible(this.mBottomContainer.getVisibility());
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        switch (i) {
            case -1:
            case 1:
            case 2:
            case 8:
                setVisibility(8);
                break;
            case 0:
            case 5:
                setVisibility(8);
                this.mBottomProgress.setProgress(0);
                this.mBottomProgress.setSecondaryProgress(0);
                this.mVideoProgress.setProgress(0);
                this.mVideoProgress.setSecondaryProgress(0);
                break;
            case 3:
                this.mPlayButton.setSelected(true);
                if (this.mIsShowBottomProgress) {
                    if (this.mControlWrapper.isShowing()) {
                        this.mBottomProgress.setVisibility(8);
                        this.mBottomContainer.setVisibility(0);
                    } else {
                        this.mBottomContainer.setVisibility(8);
                        this.mBottomProgress.setVisibility(0);
                    }
                } else {
                    this.mBottomContainer.setVisibility(8);
                }
                OnVodControllerViewChangeListener onVodControllerViewChangeListener = this.viewChangeListener;
                if (onVodControllerViewChangeListener != null) {
                    onVodControllerViewChangeListener.onBottomViewVisible(this.mBottomContainer.getVisibility());
                }
                setVisibility(0);
                this.mControlWrapper.startProgress();
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
            this.mBottomProgress.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            this.mBottomContainer.setPadding(cutoutHeight, 0, 0, 0);
            this.mBottomProgress.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            this.mBottomContainer.setPadding(0, 0, cutoutHeight, 0);
            this.mBottomProgress.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void setProgress(int i, int i2) {
        if (this.mIsDragging) {
            return;
        }
        SeekBar seekBar = this.mVideoProgress;
        if (seekBar != null) {
            if (i > 0) {
                seekBar.setEnabled(true);
                int max = (int) (((i2 * 1.0d) / i) * this.mVideoProgress.getMax());
                this.mVideoProgress.setProgress(max);
                this.mBottomProgress.setProgress(max);
            } else {
                seekBar.setEnabled(false);
            }
            int bufferedPercentage = this.mControlWrapper.getBufferedPercentage();
            if (bufferedPercentage >= 95) {
                SeekBar seekBar2 = this.mVideoProgress;
                seekBar2.setSecondaryProgress(seekBar2.getMax());
                ProgressBar progressBar = this.mBottomProgress;
                progressBar.setSecondaryProgress(progressBar.getMax());
            } else {
                int i3 = bufferedPercentage * 10;
                this.mVideoProgress.setSecondaryProgress(i3);
                this.mBottomProgress.setSecondaryProgress(i3);
            }
        }
        TextView textView = this.mTotalTime;
        if (textView != null) {
            textView.setText(PlayerUtils.stringForTime(i));
        }
        TextView textView2 = this.mCurrTime;
        if (textView2 != null) {
            textView2.setText(PlayerUtils.stringForTime(i2));
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
        }
    }

    private void toggleFullScreen() {
        this.mControlWrapper.toggleFullScreen(PlayerUtils.scanForActivity(getContext()));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        this.mIsDragging = true;
        this.mControlWrapper.stopProgress();
        this.mControlWrapper.stopFadeOut();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        this.mControlWrapper.seekTo((int) ((this.mControlWrapper.getDuration() * seekBar.getProgress()) / this.mVideoProgress.getMax()));
        this.mIsDragging = false;
        this.mControlWrapper.startProgress();
        this.mControlWrapper.startFadeOut();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            long duration = (this.mControlWrapper.getDuration() * i) / this.mVideoProgress.getMax();
            TextView textView = this.mCurrTime;
            if (textView != null) {
                textView.setText(PlayerUtils.stringForTime((int) duration));
            }
        }
    }

    public void setViewChangeListener(OnVodControllerViewChangeListener onVodControllerViewChangeListener) {
        this.viewChangeListener = onVodControllerViewChangeListener;
    }
}

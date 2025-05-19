package xyz.doikki.videocontroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import xyz.doikki.videocontroller.component.CompleteView;
import xyz.doikki.videocontroller.component.ErrorView;
import xyz.doikki.videocontroller.component.GestureView;
import xyz.doikki.videocontroller.component.LiveControlView;
import xyz.doikki.videocontroller.component.PrepareView;
import xyz.doikki.videocontroller.component.TitleView;
import xyz.doikki.videocontroller.component.VodControlView;
import xyz.doikki.videoplayer.controller.GestureVideoController;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class StandardVideoController extends GestureVideoController implements View.OnClickListener {
    protected ProgressBar mLoadingProgress;
    protected ImageView mLockButton;

    public StandardVideoController(Context context) {
        this(context, null);
    }

    public StandardVideoController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StandardVideoController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return R.layout.dkplayer_layout_standard_controller;
    }

    @Override // xyz.doikki.videoplayer.controller.GestureVideoController, xyz.doikki.videoplayer.controller.BaseVideoController
    protected void initView() {
        super.initView();
        ImageView imageView = (ImageView) findViewById(R.id.lock);
        this.mLockButton = imageView;
        imageView.setOnClickListener(this);
        this.mLoadingProgress = (ProgressBar) findViewById(R.id.loading);
    }

    public void addDefaultControlComponent(String str, boolean z) {
        IControlComponent completeView = new CompleteView(getContext());
        IControlComponent errorView = new ErrorView(getContext());
        IControlComponent prepareView = new PrepareView(getContext());
        TitleView titleView = new TitleView(getContext());
        titleView.setTitle(str);
        addControlComponent(completeView, errorView, prepareView, titleView);
        if (z) {
            addControlComponent(new LiveControlView(getContext()));
        } else {
            addControlComponent(new VodControlView(getContext()));
        }
        addControlComponent(new GestureView(getContext()));
        setCanChangePosition(!z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.lock) {
            this.mControlWrapper.toggleLockState();
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected void onLockStateChanged(boolean z) {
        if (z) {
            this.mLockButton.setSelected(true);
            Toast.makeText(getContext(), R.string.dkplayer_locked, 0).show();
        } else {
            this.mLockButton.setSelected(false);
            Toast.makeText(getContext(), R.string.dkplayer_unlocked, 0).show();
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected void onVisibilityChanged(boolean z, Animation animation) {
        if (this.mControlWrapper.isFullScreen()) {
            if (z) {
                if (this.mLockButton.getVisibility() == 8) {
                    this.mLockButton.setVisibility(0);
                    if (animation != null) {
                        this.mLockButton.startAnimation(animation);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mLockButton.setVisibility(8);
            if (animation != null) {
                this.mLockButton.startAnimation(animation);
            }
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected void onPlayerStateChanged(int i) {
        super.onPlayerStateChanged(i);
        if (i == 10) {
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mLockButton.setVisibility(8);
        } else if (i == 11) {
            if (isShowing()) {
                this.mLockButton.setVisibility(0);
            } else {
                this.mLockButton.setVisibility(8);
            }
        }
        if (this.mActivity == null || !hasCutout()) {
            return;
        }
        int requestedOrientation = this.mActivity.getRequestedOrientation();
        int dp2px = PlayerUtils.dp2px(getContext(), 24.0f);
        int cutoutHeight = getCutoutHeight();
        if (requestedOrientation == 1) {
            ((FrameLayout.LayoutParams) this.mLockButton.getLayoutParams()).setMargins(dp2px, 0, dp2px, 0);
            return;
        }
        if (requestedOrientation == 0) {
            int i2 = dp2px + cutoutHeight;
            ((FrameLayout.LayoutParams) this.mLockButton.getLayoutParams()).setMargins(i2, 0, i2, 0);
        } else if (requestedOrientation == 8) {
            ((FrameLayout.LayoutParams) this.mLockButton.getLayoutParams()).setMargins(dp2px, 0, dp2px, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected void onPlayStateChanged(int i) {
        super.onPlayStateChanged(i);
        switch (i) {
            case -1:
            case 2:
            case 3:
            case 4:
            case 7:
                this.mLoadingProgress.setVisibility(8);
                break;
            case 0:
                this.mLockButton.setSelected(false);
                this.mLoadingProgress.setVisibility(8);
                break;
            case 1:
            case 6:
                this.mLoadingProgress.setVisibility(0);
                break;
            case 5:
                this.mLoadingProgress.setVisibility(8);
                this.mLockButton.setVisibility(8);
                this.mLockButton.setSelected(false);
                break;
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public boolean onBackPressed() {
        if (isLocked()) {
            show();
            Toast.makeText(getContext(), R.string.dkplayer_lock_tip, 0).show();
            return true;
        }
        if (this.mControlWrapper.isFullScreen()) {
            return stopFullScreen();
        }
        return super.onBackPressed();
    }
}

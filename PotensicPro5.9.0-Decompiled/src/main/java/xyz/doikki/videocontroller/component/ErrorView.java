package xyz.doikki.videocontroller.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;

/* loaded from: classes6.dex */
public class ErrorView extends LinearLayout implements IControlComponent {
    private ControlWrapper mControlWrapper;
    private float mDownX;
    private float mDownY;

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

    public ErrorView(Context context) {
        this(context, null);
    }

    public ErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_error_view, (ViewGroup) this, true);
        findViewById(R.id.status_btn).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.ErrorView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorView.this.setVisibility(8);
                ErrorView.this.mControlWrapper.replay(false);
            }
        });
        setClickable(true);
    }

    public ErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_error_view, (ViewGroup) this, true);
        findViewById(R.id.status_btn).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.ErrorView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorView.this.setVisibility(8);
                ErrorView.this.mControlWrapper.replay(false);
            }
        });
        setClickable(true);
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        if (i == -1) {
            bringToFront();
            setVisibility(0);
        } else if (i == 0) {
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.mDownX);
            float abs2 = Math.abs(motionEvent.getY() - this.mDownY);
            if (abs > ViewConfiguration.get(getContext()).getScaledTouchSlop() || abs2 > ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}

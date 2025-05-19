package xyz.doikki.videocontroller.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import xyz.doikki.videocontroller.R;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* loaded from: classes6.dex */
public class TitleView extends FrameLayout implements IControlComponent {
    private BatteryReceiver mBatteryReceiver;
    private ControlWrapper mControlWrapper;
    private boolean mIsRegister;
    private TextView mSysTime;
    private TextView mTitle;
    private LinearLayout mTitleContainer;

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public View getView() {
        return this;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void setProgress(int i, int i2) {
    }

    public TitleView(Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.mTitleContainer = (LinearLayout) findViewById(R.id.title_container);
        ((ImageView) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.TitleView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity scanForActivity = PlayerUtils.scanForActivity(TitleView.this.getContext());
                if (scanForActivity == null || !TitleView.this.mControlWrapper.isFullScreen()) {
                    return;
                }
                scanForActivity.setRequestedOrientation(1);
                TitleView.this.mControlWrapper.stopFullScreen();
            }
        });
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mSysTime = (TextView) findViewById(R.id.sys_time);
        this.mBatteryReceiver = new BatteryReceiver((ImageView) findViewById(R.id.iv_battery));
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.mTitleContainer = (LinearLayout) findViewById(R.id.title_container);
        ((ImageView) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.TitleView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity scanForActivity = PlayerUtils.scanForActivity(TitleView.this.getContext());
                if (scanForActivity == null || !TitleView.this.mControlWrapper.isFullScreen()) {
                    return;
                }
                scanForActivity.setRequestedOrientation(1);
                TitleView.this.mControlWrapper.stopFullScreen();
            }
        });
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mSysTime = (TextView) findViewById(R.id.sys_time);
        this.mBatteryReceiver = new BatteryReceiver((ImageView) findViewById(R.id.iv_battery));
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_title_view, (ViewGroup) this, true);
        this.mTitleContainer = (LinearLayout) findViewById(R.id.title_container);
        ((ImageView) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() { // from class: xyz.doikki.videocontroller.component.TitleView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity scanForActivity = PlayerUtils.scanForActivity(TitleView.this.getContext());
                if (scanForActivity == null || !TitleView.this.mControlWrapper.isFullScreen()) {
                    return;
                }
                scanForActivity.setRequestedOrientation(1);
                TitleView.this.mControlWrapper.stopFullScreen();
            }
        });
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mSysTime = (TextView) findViewById(R.id.sys_time);
        this.mBatteryReceiver = new BatteryReceiver((ImageView) findViewById(R.id.iv_battery));
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsRegister) {
            getContext().unregisterReceiver(this.mBatteryReceiver);
            this.mIsRegister = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsRegister) {
            return;
        }
        getContext().registerReceiver(this.mBatteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.mIsRegister = true;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void attach(ControlWrapper controlWrapper) {
        this.mControlWrapper = controlWrapper;
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onVisibilityChanged(boolean z, Animation animation) {
        if (this.mControlWrapper.isFullScreen()) {
            if (z) {
                if (getVisibility() == 8) {
                    this.mSysTime.setText(PlayerUtils.getCurrentSystemTime());
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
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayStateChanged(int i) {
        if (i == -1 || i == 0 || i == 1 || i == 2 || i == 5 || i == 8) {
            setVisibility(8);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onPlayerStateChanged(int i) {
        if (i == 11) {
            if (this.mControlWrapper.isShowing() && !this.mControlWrapper.isLocked()) {
                setVisibility(0);
                this.mSysTime.setText(PlayerUtils.getCurrentSystemTime());
            }
            this.mTitle.setSelected(true);
        } else {
            setVisibility(8);
            this.mTitle.setSelected(false);
        }
        Activity scanForActivity = PlayerUtils.scanForActivity(getContext());
        if (scanForActivity == null || !this.mControlWrapper.hasCutout()) {
            return;
        }
        int requestedOrientation = scanForActivity.getRequestedOrientation();
        int cutoutHeight = this.mControlWrapper.getCutoutHeight();
        if (requestedOrientation == 1) {
            this.mTitleContainer.setPadding(0, 0, 0, 0);
        } else if (requestedOrientation == 0) {
            this.mTitleContainer.setPadding(cutoutHeight, 0, 0, 0);
        } else if (requestedOrientation == 8) {
            this.mTitleContainer.setPadding(0, 0, cutoutHeight, 0);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IControlComponent
    public void onLockStateChanged(boolean z) {
        if (z) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.mSysTime.setText(PlayerUtils.getCurrentSystemTime());
        }
    }

    private static class BatteryReceiver extends BroadcastReceiver {
        private ImageView pow;

        public BatteryReceiver(ImageView imageView) {
            this.pow = imageView;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            this.pow.getDrawable().setLevel((extras.getInt("level") * 100) / extras.getInt(RtspHeaders.SCALE));
        }
    }
}

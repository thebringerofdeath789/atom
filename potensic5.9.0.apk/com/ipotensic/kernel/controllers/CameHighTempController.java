package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.listener.AnimationListenerAdapter;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.logan.camera.CameraConfig;
import com.logan.flight.data.FlightRevData;

/* loaded from: classes2.dex */
public class CameHighTempController extends BaseController {
    private AlphaAnimation enterAnimation;
    private final Handler handler;
    private int highTempMark;
    private Boolean isMapMode;
    private Boolean isStart;
    private ImageView ivHighTemp;
    private AlphaAnimation outerAnimation;
    private final Runnable runnable;
    private int showToastTag;

    public CameHighTempController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.highTempMark = -1;
        this.handler = new Handler(Looper.getMainLooper());
        this.isStart = null;
        this.isMapMode = false;
        this.runnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.CameHighTempController.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameHighTempController.this.isStart != null) {
                    if (CameHighTempController.this.isStart.booleanValue()) {
                        CameHighTempController cameHighTempController = CameHighTempController.this;
                        cameHighTempController.alphaIn(cameHighTempController.getBaseView());
                    } else {
                        CameHighTempController cameHighTempController2 = CameHighTempController.this;
                        cameHighTempController2.alphaOut(cameHighTempController2.getBaseView());
                    }
                    CameHighTempController.this.isStart = Boolean.valueOf(!r0.isStart.booleanValue());
                    CameHighTempController.this.handler.postDelayed(CameHighTempController.this.runnable, 1000L);
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.ivHighTemp = (ImageView) view.findViewById(C1965R.id.iv_high_temp);
    }

    public void isMapMode(boolean z) {
        this.isMapMode = Boolean.valueOf(z);
    }

    private synchronized void show(int i) {
        if (this.isMapMode.booleanValue()) {
            this.isStart = null;
            this.handler.removeCallbacks(this.runnable);
            getBaseView().setVisibility(8);
            return;
        }
        if (PhoneConfig.isKernelActivityPause) {
            remove();
            return;
        }
        if (i == -1) {
            remove();
        } else if (i == 0) {
            if (this.isStart == null) {
                this.isStart = true;
                this.handler.post(this.runnable);
            }
            if (this.showToastTag == 0) {
                this.showToastTag = 1;
                ToastUtil.toast(getContext(), getContext().getString(C1965R.string.tips_cam_temperature_too_high));
            }
        } else if (i == 1) {
            if (this.isStart == null) {
                this.isStart = true;
                this.handler.post(this.runnable);
            }
            if (this.showToastTag < 2) {
                this.showToastTag = 2;
                ToastUtil.toast((Activity) getContext(), getContext().getString(C1965R.string.tips_cam_stop_record), getContext().getResources().getColor(C1965R.color.text_mini_geo_color));
            }
        } else if (i == 2) {
            if (this.isStart == null) {
                this.isStart = true;
                this.handler.post(this.runnable);
            }
            if (this.showToastTag < 3) {
                this.showToastTag = 3;
                ToastUtil.toast((Activity) getContext(), getContext().getString(C1965R.string.tips_flight_auto_shut_down), getContext().getResources().getColor(C1965R.color.toast_red));
            }
        }
    }

    public void remove() {
        if (this.isStart != null) {
            this.isStart = null;
            this.showToastTag = 0;
            this.handler.removeCallbacks(this.runnable);
            alphaOut(getBaseView());
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (eventID == EventID.EVENT_CAMERA_HIGH_TEMP) {
            this.highTempMark = event.arg1;
            if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                remove();
            } else {
                DDLog.m1684e("相机温度：highTempMark = " + this.highTempMark + ", isCaptureEnable = " + CameraConfig.get().isAllowCaptureInHighTemp() + ", 温度：" + event.arg2);
                show(this.highTempMark);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alphaIn(final View view) {
        if (this.enterAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.enterAnimation = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.enterAnimation.setInterpolator(new DecelerateInterpolator());
        }
        view.startAnimation(this.enterAnimation);
        this.enterAnimation.setAnimationListener(new AnimationListenerAdapter() { // from class: com.ipotensic.kernel.controllers.CameHighTempController.2
            @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                super.onAnimationStart(animation);
                if (CameHighTempController.this.isMapMode.booleanValue()) {
                    return;
                }
                view.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alphaOut(final View view) {
        if (this.outerAnimation == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.outerAnimation = alphaAnimation;
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            this.outerAnimation.setDuration(200L);
        }
        view.startAnimation(this.outerAnimation);
        this.outerAnimation.setAnimationListener(new AnimationListenerAdapter() { // from class: com.ipotensic.kernel.controllers.CameHighTempController.3
            @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                super.onAnimationStart(animation);
                view.setVisibility(8);
            }
        });
    }
}
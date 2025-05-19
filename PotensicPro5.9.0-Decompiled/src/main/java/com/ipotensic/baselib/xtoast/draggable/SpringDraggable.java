package com.ipotensic.baselib.xtoast.draggable;

import android.animation.ValueAnimator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.ipotensic.baselib.xtoast.BaseDraggable;
import com.ipotensic.baselib.xtoast.XToast;

/* loaded from: classes2.dex */
public class SpringDraggable extends BaseDraggable {
    private float mScreenWidth;
    private float mViewDownX;
    private float mViewDownY;

    @Override // com.ipotensic.baselib.xtoast.BaseDraggable
    public void start(XToast xToast) {
        super.start(xToast);
        this.mScreenWidth = getScreenWidth();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) (motionEvent.getRawY() - getStatusBarHeight());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mViewDownX = (int) motionEvent.getX();
            this.mViewDownY = (int) motionEvent.getY();
        } else {
            if (action == 1) {
                float f = rawX;
                float f2 = this.mScreenWidth;
                if (f < f2 / 2.0f) {
                    f2 = 0.0f;
                }
                float f3 = this.mViewDownX;
                startAnimation(f - f3, f2 - f3, rawY - this.mViewDownY);
                return (this.mViewDownX == ((float) ((int) motionEvent.getX())) && this.mViewDownY == ((float) ((int) motionEvent.getY()))) ? false : true;
            }
            if (action == 2) {
                updateLocation(rawX - this.mViewDownX, rawY - this.mViewDownY);
            }
        }
        return false;
    }

    private int getScreenWidth() {
        WindowManager windowManager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private void startAnimation(float f, float f2, final float f3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(500L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.baselib.xtoast.draggable.SpringDraggable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpringDraggable.this.updateLocation(((Float) valueAnimator.getAnimatedValue()).floatValue(), f3);
            }
        });
        ofFloat.start();
    }
}

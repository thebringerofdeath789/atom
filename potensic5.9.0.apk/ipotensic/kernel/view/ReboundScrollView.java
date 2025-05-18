package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.ipotensic.baselib.utils.UnitUtil;

/* loaded from: classes2.dex */
public class ReboundScrollView extends ScrollView {
    private View childView;
    private int downY;
    private boolean isFinishAnimation;
    private int lastY;
    private Rect normal;

    public ReboundScrollView(Context context) {
        super(context);
        this.normal = new Rect();
        this.isFinishAnimation = true;
    }

    public ReboundScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.normal = new Rect();
        this.isFinishAnimation = true;
    }

    public ReboundScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.normal = new Rect();
        this.isFinishAnimation = true;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downY = y;
            this.lastY = y;
        } else if (action == 2) {
            r1 = Math.abs(y - this.downY) >= UnitUtil.dp2px(10);
            this.lastY = y;
        }
        return r1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.childView = getChildAt(0);
        }
    }

    private boolean isNeedMove() {
        int measuredHeight = this.childView.getMeasuredHeight() - getMeasuredHeight();
        int scrollY = getScrollY();
        return scrollY <= 0 || scrollY >= measuredHeight;
    }

    private boolean isNeedAnimation() {
        return !this.normal.isEmpty();
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.childView == null || !this.isFinishAnimation) {
            return super.onTouchEvent(motionEvent);
        }
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastY = y;
        } else if (action != 1) {
            if (action == 2) {
                int i = y - this.lastY;
                if (isNeedMove()) {
                    if (this.normal.isEmpty()) {
                        this.normal.set(this.childView.getLeft(), this.childView.getTop(), this.childView.getRight(), this.childView.getBottom());
                    }
                    View view = this.childView;
                    int i2 = i / 2;
                    view.layout(view.getLeft(), this.childView.getTop() + i2, this.childView.getRight(), this.childView.getBottom() + i2);
                }
                this.lastY = y;
            }
        } else if (isNeedAnimation()) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -(this.childView.getBottom() - this.normal.bottom));
            translateAnimation.setDuration(200L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.view.ReboundScrollView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    ReboundScrollView.this.isFinishAnimation = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ReboundScrollView.this.isFinishAnimation = true;
                    ReboundScrollView.this.childView.clearAnimation();
                    ReboundScrollView.this.childView.layout(ReboundScrollView.this.normal.left, ReboundScrollView.this.normal.top, ReboundScrollView.this.normal.right, ReboundScrollView.this.normal.bottom);
                    ReboundScrollView.this.normal.setEmpty();
                }
            });
            this.childView.startAnimation(translateAnimation);
        }
        return super.onTouchEvent(motionEvent);
    }
}
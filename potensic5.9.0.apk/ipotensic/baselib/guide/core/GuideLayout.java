package com.ipotensic.baselib.guide.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.listener.AnimationListenerAdapter;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.HighLight;
import com.ipotensic.baselib.guide.model.HighlightOptions;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.listener.ScaleClickListener;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class GuideLayout extends FrameLayout {
    public static final int DEFAULT_BACKGROUND_COLOR = -872415232;
    private Controller controller;
    private OnGuideLayoutDismissListener dismissListener;
    private float downX;
    private float downY;
    public GuidePage guidePage;
    private Paint mPaint;
    private int touchSlop;

    public interface OnGuideLayoutDismissListener {
        void onClick();

        void onGuideLayoutDismiss(GuideLayout guideLayout);
    }

    public GuideLayout(Context context, GuidePage guidePage, Controller controller) {
        super(context);
        bringToFront();
        init();
        setGuidePage(guidePage);
        this.controller = controller;
    }

    private GuideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private GuideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayerType(1, null);
        setWillNotDraw(false);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* renamed from: com.ipotensic.baselib.guide.core.GuideLayout$1 */
    class AnonymousClass1 extends ScaleClickListener {
        AnonymousClass1(Integer num, boolean z) {
            super(num, z);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (GuideLayout.this.guidePage.isEverywhereCancelable()) {
                GuideLayout.this.remove();
            }
        }
    }

    private void setGuidePage(GuidePage guidePage) {
        this.guidePage = guidePage;
        setOnClickListener(new ScaleClickListener(1000, false) { // from class: com.ipotensic.baselib.guide.core.GuideLayout.1
            AnonymousClass1(Integer num, boolean z) {
                super(num, z);
            }

            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (GuideLayout.this.guidePage.isEverywhereCancelable()) {
                    GuideLayout.this.remove();
                }
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.guidePage.isEverywhereCancelable()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (Math.abs(x - this.downX) < this.touchSlop && Math.abs(y - this.downY) < this.touchSlop) {
                for (HighLight highLight : this.guidePage.getHighLights()) {
                    if (highLight.getRectF((ViewGroup) getParent()).contains(x, y)) {
                        notifyClickListener(highLight);
                        return true;
                    }
                }
                performClick();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void notifyClickListener(HighLight highLight) {
        HighlightOptions options = highLight.getOptions();
        if (options == null || options.onClickListener == null) {
            return;
        }
        options.onClickListener.onClick(this);
        this.dismissListener.onClick();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.guidePage.getBackgroundColor());
        drawHighlights(canvas);
    }

    private void drawHighlights(Canvas canvas) {
        List<HighLight> highLights = this.guidePage.getHighLights();
        if (highLights != null) {
            for (HighLight highLight : highLights) {
                RectF rectF = highLight.getRectF((ViewGroup) getParent());
                int i = AnonymousClass4.$SwitchMap$com$ipotensic$baselib$guide$model$HighLight$Shape[highLight.getShape().ordinal()];
                if (i == 1) {
                    canvas.drawCircle(rectF.centerX(), rectF.centerY(), highLight.getRadius(), this.mPaint);
                } else if (i == 2) {
                    canvas.drawOval(rectF, this.mPaint);
                } else if (i == 3) {
                    canvas.drawRoundRect(rectF, highLight.getRound(), highLight.getRound(), this.mPaint);
                } else {
                    canvas.drawRect(rectF, this.mPaint);
                }
                notifyDrewListener(canvas, highLight, rectF);
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.guide.core.GuideLayout$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$guide$model$HighLight$Shape;

        static {
            int[] iArr = new int[HighLight.Shape.values().length];
            $SwitchMap$com$ipotensic$baselib$guide$model$HighLight$Shape = iArr;
            try {
                iArr[HighLight.Shape.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$guide$model$HighLight$Shape[HighLight.Shape.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$guide$model$HighLight$Shape[HighLight.Shape.ROUND_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$guide$model$HighLight$Shape[HighLight.Shape.RECTANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void notifyDrewListener(Canvas canvas, HighLight highLight, RectF rectF) {
        HighlightOptions options = highLight.getOptions();
        if (options == null || options.onHighlightDrewListener == null) {
            return;
        }
        options.onHighlightDrewListener.onHighlightDrew(canvas, rectF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addCustomToLayout(this.guidePage);
        Animation enterAnimation = this.guidePage.getEnterAnimation();
        if (enterAnimation != null) {
            startAnimation(enterAnimation);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void addCustomToLayout(GuidePage guidePage) {
        removeAllViews();
        int layoutResId = guidePage.getLayoutResId();
        if (layoutResId != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(layoutResId, (ViewGroup) this, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int[] clickToDismissIds = guidePage.getClickToDismissIds();
            if (clickToDismissIds != null && clickToDismissIds.length > 0) {
                for (int i : clickToDismissIds) {
                    View findViewById = inflate.findViewById(i);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(new ScaleClickListener(1000, false) { // from class: com.ipotensic.baselib.guide.core.GuideLayout.2
                            AnonymousClass2(Integer num, boolean z) {
                                super(num, z);
                            }

                            @Override // com.ipotensic.baselib.listener.ScaleClickListener
                            public void click(View view) {
                                GuideLayout.this.remove();
                            }
                        });
                    } else {
                        Log.w(NewbieGuide.TAG, "can't find the view by id : " + i + " which used to remove guide page");
                    }
                }
            }
            OnLayoutInflatedListener onLayoutInflatedListener = guidePage.getOnLayoutInflatedListener();
            if (onLayoutInflatedListener != null) {
                onLayoutInflatedListener.onLayoutInflated(inflate, this.controller);
            }
            addView(inflate, layoutParams);
        }
        List<RelativeGuide> relativeGuides = guidePage.getRelativeGuides();
        if (relativeGuides.size() > 0) {
            Iterator<RelativeGuide> it = relativeGuides.iterator();
            while (it.hasNext()) {
                addView(it.next().getGuideLayout((ViewGroup) getParent(), this.controller, guidePage));
            }
        }
    }

    /* renamed from: com.ipotensic.baselib.guide.core.GuideLayout$2 */
    class AnonymousClass2 extends ScaleClickListener {
        AnonymousClass2(Integer num, boolean z) {
            super(num, z);
        }

        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            GuideLayout.this.remove();
        }
    }

    public void setOnGuideLayoutDismissListener(OnGuideLayoutDismissListener onGuideLayoutDismissListener) {
        this.dismissListener = onGuideLayoutDismissListener;
    }

    public void remove() {
        Animation exitAnimation = this.guidePage.getExitAnimation();
        if (exitAnimation != null) {
            exitAnimation.setAnimationListener(new AnimationListenerAdapter() { // from class: com.ipotensic.baselib.guide.core.GuideLayout.3
                AnonymousClass3() {
                }

                @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GuideLayout.this.dismiss();
                }
            });
            startAnimation(exitAnimation);
        } else {
            dismiss();
        }
    }

    /* renamed from: com.ipotensic.baselib.guide.core.GuideLayout$3 */
    class AnonymousClass3 extends AnimationListenerAdapter {
        AnonymousClass3() {
        }

        @Override // com.ipotensic.baselib.guide.listener.AnimationListenerAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            GuideLayout.this.dismiss();
        }
    }

    public void dismiss() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
            OnGuideLayoutDismissListener onGuideLayoutDismissListener = this.dismissListener;
            if (onGuideLayoutDismissListener != null) {
                onGuideLayoutDismissListener.onGuideLayoutDismiss(this);
            }
        }
    }
}
package com.ipotensic.kernel.utils;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class CircularAnim {
    public static final int MINI_RADIUS = 0;
    public static final long PERFECT_MILLS = 618;
    private static Integer sColorOrImageRes;
    private static Long sFullActivityPerfectMills;
    private static OnAnimatorDeployListener sHideAnimatorDeployListener;
    private static Long sPerfectMills;
    private static OnAnimatorDeployListener sReturnAnimatorDeployListener;
    private static OnAnimatorDeployListener sShowAnimatorDeployListener;
    private static OnAnimatorDeployListener sStartAnimatorDeployListener;

    public interface OnAnimationEndListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public interface OnAnimatorDeployListener {
        void deployAnimator(Animator animator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getPerfectMills() {
        Long l = sPerfectMills;
        if (l != null) {
            return l.longValue();
        }
        return 618L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getFullActivityMills() {
        Long l = sFullActivityPerfectMills;
        if (l != null) {
            return l.longValue();
        }
        return 618L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getColorOrImageRes() {
        Integer num = sColorOrImageRes;
        return num != null ? num.intValue() : R.color.white;
    }

    public static class VisibleBuilder {
        private boolean isShow;
        private View mAnimView;
        private long mDurationMills = CircularAnim.getPerfectMills();
        private Float mEndRadius;
        private OnAnimationEndListener mOnAnimationEndListener;
        private OnAnimatorDeployListener mOnAnimatorDeployListener;
        private Float mStartRadius;
        private Point mTriggerPoint;
        private View mTriggerView;

        public VisibleBuilder(View view, boolean z) {
            this.mAnimView = view;
            this.isShow = z;
            Float valueOf = Float.valueOf(0.0f);
            if (z) {
                this.mStartRadius = valueOf;
            } else {
                this.mEndRadius = valueOf;
            }
        }

        public VisibleBuilder triggerView(View view) {
            this.mTriggerView = view;
            return this;
        }

        public VisibleBuilder triggerPoint(Point point) {
            this.mTriggerPoint = point;
            return this;
        }

        public VisibleBuilder startRadius(float f) {
            this.mStartRadius = Float.valueOf(f);
            return this;
        }

        public VisibleBuilder endRadius(float f) {
            this.mEndRadius = Float.valueOf(f);
            return this;
        }

        public VisibleBuilder duration(long j) {
            this.mDurationMills = j;
            return this;
        }

        public VisibleBuilder deployAnimator(OnAnimatorDeployListener onAnimatorDeployListener) {
            this.mOnAnimatorDeployListener = onAnimatorDeployListener;
            return this;
        }

        public void go() {
            go(null);
        }

        public void go(final OnAnimationEndListener onAnimationEndListener) {
            this.mOnAnimationEndListener = onAnimationEndListener;
            if (Build.VERSION.SDK_INT < 21) {
                doOnEnd();
                return;
            }
            if (this.mTriggerPoint == null) {
                View view = this.mTriggerView;
                if (view != null) {
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int width = iArr[0] + (this.mTriggerView.getWidth() / 2);
                    int height = iArr[1] + (this.mTriggerView.getHeight() / 2);
                    int[] iArr2 = new int[2];
                    this.mAnimView.getLocationInWindow(iArr2);
                    int i = iArr2[0];
                    int i2 = iArr2[1];
                    this.mTriggerPoint = new Point(Math.min(Math.max(i, width), this.mAnimView.getWidth() + i) - i, Math.min(Math.max(i2, height), this.mAnimView.getHeight() + i2) - i2);
                } else {
                    this.mTriggerPoint = new Point((this.mAnimView.getLeft() + this.mAnimView.getRight()) / 2, (this.mAnimView.getTop() + this.mAnimView.getBottom()) / 2);
                }
            }
            int max = Math.max(this.mTriggerPoint.x, this.mAnimView.getWidth() - this.mTriggerPoint.x);
            int max2 = Math.max(this.mTriggerPoint.y, this.mAnimView.getHeight() - this.mTriggerPoint.y);
            int sqrt = ((int) Math.sqrt((max * max) + (max2 * max2))) + 1;
            boolean z = this.isShow;
            if (z && this.mEndRadius == null) {
                this.mEndRadius = Float.valueOf(sqrt + 0.0f);
            } else if (!z && this.mStartRadius == null) {
                this.mStartRadius = Float.valueOf(sqrt + 0.0f);
            }
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(this.mAnimView, this.mTriggerPoint.x, this.mTriggerPoint.y, this.mStartRadius.floatValue(), this.mEndRadius.floatValue());
            this.mAnimView.setVisibility(0);
            createCircularReveal.setDuration(this.mDurationMills);
            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.kernel.utils.CircularAnim.VisibleBuilder.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    OnAnimationEndListener onAnimationEndListener2 = onAnimationEndListener;
                    if (onAnimationEndListener2 != null) {
                        onAnimationEndListener2.onAnimationStart();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    VisibleBuilder.this.doOnEnd();
                }
            });
            if (this.mOnAnimatorDeployListener == null) {
                this.mOnAnimatorDeployListener = this.isShow ? CircularAnim.sShowAnimatorDeployListener : CircularAnim.sHideAnimatorDeployListener;
            }
            OnAnimatorDeployListener onAnimatorDeployListener = this.mOnAnimatorDeployListener;
            if (onAnimatorDeployListener != null) {
                onAnimatorDeployListener.deployAnimator(createCircularReveal);
            }
            createCircularReveal.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doOnEnd() {
            if (this.isShow) {
                this.mAnimView.setVisibility(0);
            } else {
                this.mAnimView.setVisibility(4);
            }
            OnAnimationEndListener onAnimationEndListener = this.mOnAnimationEndListener;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.onAnimationEnd();
            }
        }
    }

    public static class FullActivityBuilder {
        private Activity mActivity;
        private Drawable mDrawable;
        private Long mDurationMills;
        private OnAnimationEndListener mOnAnimationEndListener;
        private OnAnimatorDeployListener mReturnAnimatorDeployListener;
        private OnAnimatorDeployListener mStartAnimatorDeployListener;
        private Point mTriggerPoint;
        private float mStartRadius = 0.0f;
        private int mColorOrImageRes = CircularAnim.getColorOrImageRes();
        private int mEnterAnim = R.anim.fade_in;
        private int mExitAnim = R.anim.fade_out;

        public FullActivityBuilder(Activity activity, View view) {
            this.mActivity = activity;
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            this.mTriggerPoint = new Point(iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2));
        }

        public FullActivityBuilder(Activity activity, Point point) {
            this.mActivity = activity;
            this.mTriggerPoint = point;
        }

        public FullActivityBuilder startRadius(float f) {
            this.mStartRadius = f;
            return this;
        }

        public FullActivityBuilder colorOrImageRes(int i) {
            this.mColorOrImageRes = i;
            return this;
        }

        public FullActivityBuilder drawable(Drawable drawable) {
            this.mDrawable = drawable;
            return this;
        }

        public FullActivityBuilder duration(long j) {
            this.mDurationMills = Long.valueOf(j);
            return this;
        }

        public FullActivityBuilder overridePendingTransition(int i, int i2) {
            this.mEnterAnim = i;
            this.mExitAnim = i2;
            return this;
        }

        public FullActivityBuilder deployStartAnimator(OnAnimatorDeployListener onAnimatorDeployListener) {
            this.mStartAnimatorDeployListener = onAnimatorDeployListener;
            return this;
        }

        public FullActivityBuilder deployReturnAnimator(OnAnimatorDeployListener onAnimatorDeployListener) {
            this.mReturnAnimatorDeployListener = onAnimatorDeployListener;
            return this;
        }

        public void go(OnAnimationEndListener onAnimationEndListener) {
            this.mOnAnimationEndListener = onAnimationEndListener;
            if (Build.VERSION.SDK_INT < 21) {
                doOnEnd();
                return;
            }
            ImageView imageView = new ImageView(this.mActivity);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageResource(this.mColorOrImageRes);
            }
            ViewGroup viewGroup = (ViewGroup) this.mActivity.getWindow().getDecorView();
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            viewGroup.addView(imageView, width, height);
            int max = Math.max(this.mTriggerPoint.x, width - this.mTriggerPoint.x);
            int max2 = Math.max(this.mTriggerPoint.y, height - this.mTriggerPoint.y);
            int sqrt = ((int) Math.sqrt((max * max) + (max2 * max2))) + 1;
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(imageView, this.mTriggerPoint.x, this.mTriggerPoint.y, this.mStartRadius, sqrt);
            int sqrt2 = ((int) Math.sqrt((width * width) + (height * height))) + 1;
            if (this.mDurationMills == null) {
                this.mDurationMills = Long.valueOf((long) (CircularAnim.getFullActivityMills() * Math.sqrt((sqrt * 1.0d) / sqrt2)));
            }
            long longValue = this.mDurationMills.longValue();
            createCircularReveal.setDuration((long) (longValue * 0.9d));
            createCircularReveal.addListener(new AnonymousClass1(viewGroup, imageView, sqrt, longValue));
            if (this.mStartAnimatorDeployListener == null) {
                this.mStartAnimatorDeployListener = CircularAnim.sStartAnimatorDeployListener;
            }
            OnAnimatorDeployListener onAnimatorDeployListener = this.mStartAnimatorDeployListener;
            if (onAnimatorDeployListener != null) {
                onAnimatorDeployListener.deployAnimator(createCircularReveal);
            }
            createCircularReveal.start();
        }

        /* renamed from: com.ipotensic.kernel.utils.CircularAnim$FullActivityBuilder$1, reason: invalid class name */
        class AnonymousClass1 extends AnimatorListenerAdapter {
            final /* synthetic */ ViewGroup val$decorView;
            final /* synthetic */ long val$finalDuration;
            final /* synthetic */ int val$finalRadius;
            final /* synthetic */ ImageView val$view;

            AnonymousClass1(ViewGroup viewGroup, ImageView imageView, int i, long j) {
                this.val$decorView = viewGroup;
                this.val$view = imageView;
                this.val$finalRadius = i;
                this.val$finalDuration = j;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FullActivityBuilder.this.doOnEnd();
                this.val$decorView.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.utils.CircularAnim.FullActivityBuilder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FullActivityBuilder.this.mActivity.isFinishing()) {
                            return;
                        }
                        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(AnonymousClass1.this.val$view, FullActivityBuilder.this.mTriggerPoint.x, FullActivityBuilder.this.mTriggerPoint.y, AnonymousClass1.this.val$finalRadius, FullActivityBuilder.this.mStartRadius);
                        createCircularReveal.setDuration(AnonymousClass1.this.val$finalDuration);
                        createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.kernel.utils.CircularAnim.FullActivityBuilder.1.1.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                super.onAnimationEnd(animator2);
                                if (FullActivityBuilder.this.mActivity.isFinishing() || AnonymousClass1.this.val$view.getParent() == null) {
                                    return;
                                }
                                ((ViewGroup) AnonymousClass1.this.val$view.getParent()).removeView(AnonymousClass1.this.val$view);
                            }
                        });
                        if (FullActivityBuilder.this.mReturnAnimatorDeployListener == null) {
                            FullActivityBuilder.this.mReturnAnimatorDeployListener = CircularAnim.sReturnAnimatorDeployListener;
                        }
                        if (FullActivityBuilder.this.mReturnAnimatorDeployListener != null) {
                            FullActivityBuilder.this.mReturnAnimatorDeployListener.deployAnimator(createCircularReveal);
                        }
                        createCircularReveal.start();
                    }
                }, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doOnEnd() {
            this.mOnAnimationEndListener.onAnimationEnd();
        }
    }

    public static VisibleBuilder show(View view) {
        return new VisibleBuilder(view, true);
    }

    public static VisibleBuilder hide(View view) {
        return new VisibleBuilder(view, false);
    }

    public static FullActivityBuilder fullActivity(Activity activity, View view) {
        return new FullActivityBuilder(activity, view);
    }

    public static void init(long j, long j2, int i) {
        sPerfectMills = Long.valueOf(j);
        sFullActivityPerfectMills = Long.valueOf(j2);
        sColorOrImageRes = Integer.valueOf(i);
    }

    public static void initDefaultDeployAnimators(OnAnimatorDeployListener onAnimatorDeployListener, OnAnimatorDeployListener onAnimatorDeployListener2, OnAnimatorDeployListener onAnimatorDeployListener3, OnAnimatorDeployListener onAnimatorDeployListener4) {
        sShowAnimatorDeployListener = onAnimatorDeployListener;
        sHideAnimatorDeployListener = onAnimatorDeployListener2;
        sStartAnimatorDeployListener = onAnimatorDeployListener3;
        sReturnAnimatorDeployListener = onAnimatorDeployListener4;
    }
}
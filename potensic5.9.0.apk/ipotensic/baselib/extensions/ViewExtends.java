package com.ipotensic.baselib.extensions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.ipotensic.baselib.extensions.ViewExtends;
import com.ipotensic.baselib.listener.ScaleClickListener;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewExtends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u00020\u0007*\u00020\bJ\n\u0010\t\u001a\u00020\u0007*\u00020\nJ\n\u0010\u000b\u001a\u00020\f*\u00020\nJ\n\u0010\r\u001a\u00020\u000e*\u00020\u000fJ\n\u0010\u0010\u001a\u00020\u000e*\u00020\u000fJ\u001a\u0010\u0011\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0012\u0010\u0015\u001a\u00020\u0007*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u0014\u0010\u0018\u001a\u00020\u0007*\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0014\u0010\u001b\u001a\u00020\u0007*\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0014\u0010\u001c\u001a\u00020\u0007*\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ,\u0010\u001d\u001a\u00020\u0007*\u00020\n2\u0016\u0010\u001e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u0012J\u0014\u0010!\u001a\u00020\u0007*\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\"J\u0012\u0010#\u001a\u00020\u0007*\u00020$2\u0006\u0010\u0017\u001a\u00020\u0012J\u0012\u0010%\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0012J\u0012\u0010&\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0012J\u0012\u0010'\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0012J\u0014\u0010(\u001a\u00020)*\u00020\n2\b\b\u0002\u0010*\u001a\u00020+J)\u0010,\u001a\u00020\u0007\"\n\b\u0000\u0010-\u0018\u0001*\u00020.*\u00020\n2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0086\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/ipotensic/baselib/extensions/ViewExtends;", "", "()V", "VIEW_WITHOUT_ALPHA", "", "VIEW_WITH_ALPHA", "clearDrawable", "", "Landroid/widget/TextView;", "flashScreen", "Landroid/view/View;", "getMeasureSize", "", "getVisibleFirstIndex", "", "Landroidx/recyclerview/widget/RecyclerView;", "getVisibleLastIndex", "isClickInView", "", "x", "y", "setChildViewClickable", "Lcom/google/android/material/tabs/TabLayout;", "isEnable", "setDrawableLeft", "drawable", "Landroid/graphics/drawable/Drawable;", "setDrawableRight", "setDrawableTop", "setOnScaleClickListener", "clickListener", "Lkotlin/Function1;", "withAnim", "setOnSingleClickListener", "Landroid/view/View$OnClickListener;", "setSlideAble", "Landroidx/viewpager2/widget/ViewPager2;", "setViewEnable", "setViewEnableWithAlpha", "setViewWithAlpha", "startFlickerAnimator", "Landroid/animation/ObjectAnimator;", "duration", "", "updateViewSize", "T", "Landroid/view/ViewGroup$LayoutParams;", "sWidth", "sHeight", "OnSingleClickListener", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ViewExtends {
    public static final ViewExtends INSTANCE = new ViewExtends();
    public static final float VIEW_WITHOUT_ALPHA = 1.0f;
    public static final float VIEW_WITH_ALPHA = 0.3f;

    private ViewExtends() {
    }

    public final boolean isClickInView(View isClickInView, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(isClickInView, "$this$isClickInView");
        int[] iArr = new int[2];
        isClickInView.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return f2 >= ((float) i2) && f2 <= ((float) (isClickInView.getMeasuredHeight() + i2)) && f >= ((float) i) && f <= ((float) (isClickInView.getMeasuredWidth() + i));
    }

    public final void flashScreen(View flashScreen) {
        Intrinsics.checkParameterIsNotNull(flashScreen, "$this$flashScreen");
        flashScreen.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(150L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.baselib.extensions.ViewExtends$flashScreen$1
            final /* synthetic */ View $this_flashScreen;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            ViewExtends$flashScreen$1(View flashScreen2) {
                r1 = flashScreen2;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                r1.setVisibility(8);
            }
        });
        flashScreen2.startAnimation(alphaAnimation);
    }

    public final void setViewEnableWithAlpha(View setViewEnableWithAlpha, boolean z) {
        Intrinsics.checkParameterIsNotNull(setViewEnableWithAlpha, "$this$setViewEnableWithAlpha");
        setViewEnableWithAlpha.setClickable(z);
        setViewEnableWithAlpha.setEnabled(z);
        setViewEnableWithAlpha.setFocusable(z);
        setViewWithAlpha(setViewEnableWithAlpha, z);
    }

    public final void setViewWithAlpha(View setViewWithAlpha, boolean z) {
        Intrinsics.checkParameterIsNotNull(setViewWithAlpha, "$this$setViewWithAlpha");
        setViewWithAlpha.setAlpha(z ? 1.0f : 0.3f);
    }

    public final void setViewEnable(View setViewEnable, boolean z) {
        Intrinsics.checkParameterIsNotNull(setViewEnable, "$this$setViewEnable");
        setViewEnable.setClickable(z);
        setViewEnable.setEnabled(z);
        setViewEnable.setFocusable(z);
    }

    public final int getVisibleFirstIndex(RecyclerView getVisibleFirstIndex) {
        Intrinsics.checkParameterIsNotNull(getVisibleFirstIndex, "$this$getVisibleFirstIndex");
        RecyclerView.LayoutManager layoutManager = getVisibleFirstIndex.getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final int getVisibleLastIndex(RecyclerView getVisibleLastIndex) {
        Intrinsics.checkParameterIsNotNull(getVisibleLastIndex, "$this$getVisibleLastIndex");
        RecyclerView.LayoutManager layoutManager = getVisibleLastIndex.getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void setSlideAble(ViewPager2 setSlideAble, boolean z) {
        Intrinsics.checkParameterIsNotNull(setSlideAble, "$this$setSlideAble");
        setSlideAble.setUserInputEnabled(z);
    }

    public final void setChildViewClickable(TabLayout setChildViewClickable, boolean z) {
        TabLayout.TabView tabView;
        Intrinsics.checkParameterIsNotNull(setChildViewClickable, "$this$setChildViewClickable");
        int tabCount = setChildViewClickable.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tabAt = setChildViewClickable.getTabAt(i);
            if (tabAt != null && (tabView = tabAt.view) != null) {
                setViewEnable(tabView, z);
            }
        }
    }

    public static /* synthetic */ void setOnScaleClickListener$default(ViewExtends viewExtends, View view, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        viewExtends.setOnScaleClickListener(view, function1, z);
    }

    public final void setOnScaleClickListener(View setOnScaleClickListener, Function1<? super View, Unit> function1, boolean z) {
        Intrinsics.checkParameterIsNotNull(setOnScaleClickListener, "$this$setOnScaleClickListener");
        if (function1 != null) {
            setOnScaleClickListener.setOnClickListener(new ScaleClickListener(z) { // from class: com.ipotensic.baselib.extensions.ViewExtends$setOnScaleClickListener$$inlined$let$lambda$1
                final /* synthetic */ View $this_setOnScaleClickListener$inlined;
                final /* synthetic */ boolean $withAnim$inlined;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                ViewExtends$setOnScaleClickListener$$inlined$let$lambda$1(boolean z2, View setOnScaleClickListener2, boolean z22) {
                    super(z22);
                    r3 = setOnScaleClickListener2;
                    r4 = z22;
                }

                @Override // com.ipotensic.baselib.listener.ScaleClickListener
                public void click(View view) {
                    Function1.this.invoke(view);
                }
            });
        }
    }

    public final void setOnSingleClickListener(View setOnSingleClickListener, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(setOnSingleClickListener, "$this$setOnSingleClickListener");
        if (onClickListener != null) {
            setOnSingleClickListener.setOnClickListener(new OnSingleClickListener(onClickListener, 0L, 2, null));
            if (onClickListener != null) {
                return;
            }
        }
        setOnSingleClickListener.setOnClickListener(null);
        Unit unit = Unit.INSTANCE;
    }

    public final void setDrawableLeft(TextView setDrawableLeft, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(setDrawableLeft, "$this$setDrawableLeft");
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            setDrawableLeft.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public final void setDrawableTop(TextView setDrawableTop, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(setDrawableTop, "$this$setDrawableTop");
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            setDrawableTop.setCompoundDrawables(null, drawable, null, null);
        }
    }

    public final void setDrawableRight(TextView setDrawableRight, Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(setDrawableRight, "$this$setDrawableRight");
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            setDrawableRight.setCompoundDrawables(null, null, drawable, null);
        }
    }

    public final void clearDrawable(TextView clearDrawable) {
        Intrinsics.checkParameterIsNotNull(clearDrawable, "$this$clearDrawable");
        clearDrawable.setCompoundDrawables(null, null, null, null);
    }

    /* compiled from: ViewExtends.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/ipotensic/baselib/extensions/ViewExtends$OnSingleClickListener;", "Landroid/view/View$OnClickListener;", "clickListener", "intervalMs", "", "(Landroid/view/View$OnClickListener;J)V", "canClick", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onClick", "", "v", "Landroid/view/View;", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
    public static final class OnSingleClickListener implements View.OnClickListener {
        private AtomicBoolean canClick;
        private final View.OnClickListener clickListener;
        private final long intervalMs;

        public OnSingleClickListener(View.OnClickListener clickListener, long j) {
            Intrinsics.checkParameterIsNotNull(clickListener, "clickListener");
            this.clickListener = clickListener;
            this.intervalMs = j;
            this.canClick = new AtomicBoolean(true);
        }

        public /* synthetic */ OnSingleClickListener(View.OnClickListener onClickListener, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(onClickListener, (i & 2) != 0 ? 1000L : j);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intrinsics.checkParameterIsNotNull(v, "v");
            if (this.canClick.getAndSet(false)) {
                v.postDelayed(new Runnable() { // from class: com.ipotensic.baselib.extensions.ViewExtends$OnSingleClickListener$onClick$$inlined$run$lambda$1
                    final /* synthetic */ View $v$inlined;

                    ViewExtends$OnSingleClickListener$onClick$$inlined$run$lambda$1(View v2) {
                        r2 = v2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AtomicBoolean atomicBoolean;
                        atomicBoolean = ViewExtends.OnSingleClickListener.this.canClick;
                        atomicBoolean.set(true);
                    }
                }, this.intervalMs);
                this.clickListener.onClick(v2);
            }
        }
    }

    public final int[] getMeasureSize(View getMeasureSize) {
        Intrinsics.checkParameterIsNotNull(getMeasureSize, "$this$getMeasureSize");
        getMeasureSize.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{getMeasureSize.getMeasuredWidth(), getMeasureSize.getMeasuredHeight()};
    }

    public static /* synthetic */ ObjectAnimator startFlickerAnimator$default(ViewExtends viewExtends, View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        return viewExtends.startFlickerAnimator(view, j);
    }

    public final ObjectAnimator startFlickerAnimator(View startFlickerAnimator, long j) {
        Intrinsics.checkParameterIsNotNull(startFlickerAnimator, "$this$startFlickerAnimator");
        ObjectAnimator flickerAnimator = ObjectAnimator.ofFloat(startFlickerAnimator, "alpha", 1.0f, 0.2f);
        flickerAnimator.setRepeatCount(-1);
        flickerAnimator.setRepeatMode(2);
        flickerAnimator.setInterpolator(new LinearInterpolator());
        Intrinsics.checkExpressionValueIsNotNull(flickerAnimator, "this");
        flickerAnimator.setDuration(j);
        flickerAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.baselib.extensions.ViewExtends$startFlickerAnimator$$inlined$apply$lambda$1
            final /* synthetic */ long $duration$inlined;
            final /* synthetic */ View $this_startFlickerAnimator$inlined;

            ViewExtends$startFlickerAnimator$$inlined$apply$lambda$1(View startFlickerAnimator2, long j2) {
                r1 = startFlickerAnimator2;
                r2 = j2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                r1.setAlpha(1.0f);
            }
        });
        flickerAnimator.start();
        Intrinsics.checkExpressionValueIsNotNull(flickerAnimator, "flickerAnimator");
        return flickerAnimator;
    }

    public final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateViewSize(View updateViewSize, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(updateViewSize, "$this$updateViewSize");
        ViewGroup.LayoutParams layoutParams = updateViewSize.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        layoutParams2.width = i;
        layoutParams2.height = i2;
        updateViewSize.setLayoutParams(layoutParams2);
    }
}
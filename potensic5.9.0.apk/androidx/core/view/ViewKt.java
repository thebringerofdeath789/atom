package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a2\u0010\u0019\u001a\u00020\u001a*\u00020\u00032#\b\u0004\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\b\u001a2\u0010 \u001a\u00020\u001a*\u00020\u00032#\b\u0004\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\b\u001a2\u0010!\u001a\u00020\"*\u00020\u00032#\b\u0004\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\b\u001a\u0014\u0010#\u001a\u00020$*\u00020\u00032\b\b\u0002\u0010%\u001a\u00020&\u001a%\u0010'\u001a\u00020(*\u00020\u00032\u0006\u0010)\u001a\u00020*2\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0+H\u0086\b\u001a%\u0010,\u001a\u00020(*\u00020\u00032\u0006\u0010)\u001a\u00020*2\u000e\b\u0004\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0+H\u0087\b\u001a\u0017\u0010-\u001a\u00020\u001a*\u00020\u00032\b\b\u0001\u0010.\u001a\u00020\fH\u0086\b\u001a7\u0010/\u001a\u00020\u001a\"\n\b\u0000\u00100\u0018\u0001*\u000201*\u00020\u00032\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b3H\u0087\b¢\u0006\u0002\b4\u001a&\u0010/\u001a\u00020\u001a*\u00020\u00032\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b3H\u0086\b\u001a5\u00105\u001a\u00020\u001a*\u00020\u00032\b\b\u0003\u00106\u001a\u00020\f2\b\b\u0003\u00107\u001a\u00020\f2\b\b\u0003\u00108\u001a\u00020\f2\b\b\u0003\u00109\u001a\u00020\fH\u0086\b\u001a5\u0010:\u001a\u00020\u001a*\u00020\u00032\b\b\u0003\u0010;\u001a\u00020\f2\b\b\u0003\u00107\u001a\u00020\f2\b\b\u0003\u0010<\u001a\u00020\f2\b\b\u0003\u00109\u001a\u00020\fH\u0087\b\"*\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"*\u0010\u0007\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006\"*\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006\"\u0016\u0010\u000b\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0016\u0010\u0011\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\"\u0016\u0010\u0013\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\"\u0016\u0010\u0015\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e\"\u0016\u0010\u0017\u001a\u00020\f*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006="}, m2338d2 = {"value", "", "isGone", "Landroid/view/View;", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnLayout", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", TtmlNode.START, TtmlNode.END, "core-ktx_release"}, m2339k = 2, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnNextLayout(View doOnNextLayout, final Function1<? super View, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnNextLayout, "$this$doOnNextLayout");
        Intrinsics.checkParameterIsNotNull(action, "action");
        doOnNextLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Intrinsics.checkParameterIsNotNull(view, "view");
                view.removeOnLayoutChangeListener(this);
                Function1.this.invoke(view);
            }
        });
    }

    public static final void doOnLayout(View doOnLayout, final Function1<? super View, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnLayout, "$this$doOnLayout");
        Intrinsics.checkParameterIsNotNull(action, "action");
        if (ViewCompat.isLaidOut(doOnLayout) && !doOnLayout.isLayoutRequested()) {
            action.invoke(doOnLayout);
        } else {
            doOnLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkParameterIsNotNull(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    Function1.this.invoke(view);
                }
            });
        }
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View doOnPreDraw, final Function1<? super View, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnPreDraw, "$this$doOnPreDraw");
        Intrinsics.checkParameterIsNotNull(action, "action");
        OneShotPreDrawListener add = OneShotPreDrawListener.add(doOnPreDraw, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                action.invoke(doOnPreDraw);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    public static /* synthetic */ void updatePaddingRelative$default(View updatePaddingRelative, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updatePaddingRelative.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = updatePaddingRelative.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = updatePaddingRelative.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = updatePaddingRelative.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i, i2, i3, i4);
    }

    public static final void updatePaddingRelative(View updatePaddingRelative, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(updatePaddingRelative, "$this$updatePaddingRelative");
        updatePaddingRelative.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View updatePadding, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = updatePadding.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = updatePadding.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = updatePadding.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = updatePadding.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i, i2, i3, i4);
    }

    public static final void updatePadding(View updatePadding, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(updatePadding, "$this$updatePadding");
        updatePadding.setPadding(i, i2, i3, i4);
    }

    public static final void setPadding(View setPadding, int i) {
        Intrinsics.checkParameterIsNotNull(setPadding, "$this$setPadding");
        setPadding.setPadding(i, i, i, i);
    }

    public static final Runnable postDelayed(View postDelayed, long j, final Function0<Unit> action) {
        Intrinsics.checkParameterIsNotNull(postDelayed, "$this$postDelayed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        postDelayed.postDelayed(runnable, j);
        return runnable;
    }

    public static final Runnable postOnAnimationDelayed(View postOnAnimationDelayed, long j, final Function0<Unit> action) {
        Intrinsics.checkParameterIsNotNull(postOnAnimationDelayed, "$this$postOnAnimationDelayed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        postOnAnimationDelayed.postOnAnimationDelayed(runnable, j);
        return runnable;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final Bitmap drawToBitmap(View drawToBitmap, Bitmap.Config config) {
        Intrinsics.checkParameterIsNotNull(drawToBitmap, "$this$drawToBitmap");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (!ViewCompat.isLaidOut(drawToBitmap)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawToBitmap.getWidth(), drawToBitmap.getHeight(), config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-drawToBitmap.getScrollX(), -drawToBitmap.getScrollY());
        drawToBitmap.draw(canvas);
        return createBitmap;
    }

    public static final boolean isVisible(View isVisible) {
        Intrinsics.checkParameterIsNotNull(isVisible, "$this$isVisible");
        return isVisible.getVisibility() == 0;
    }

    public static final void setVisible(View isVisible, boolean z) {
        Intrinsics.checkParameterIsNotNull(isVisible, "$this$isVisible");
        isVisible.setVisibility(z ? 0 : 8);
    }

    public static final boolean isInvisible(View isInvisible) {
        Intrinsics.checkParameterIsNotNull(isInvisible, "$this$isInvisible");
        return isInvisible.getVisibility() == 4;
    }

    public static final void setInvisible(View isInvisible, boolean z) {
        Intrinsics.checkParameterIsNotNull(isInvisible, "$this$isInvisible");
        isInvisible.setVisibility(z ? 4 : 0);
    }

    public static final boolean isGone(View isGone) {
        Intrinsics.checkParameterIsNotNull(isGone, "$this$isGone");
        return isGone.getVisibility() == 8;
    }

    public static final void setGone(View isGone, boolean z) {
        Intrinsics.checkParameterIsNotNull(isGone, "$this$isGone");
        isGone.setVisibility(z ? 8 : 0);
    }

    private static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        function1.invoke(layoutParams2);
        view.setLayoutParams(layoutParams2);
    }

    public static final int getMarginLeft(View marginLeft) {
        Intrinsics.checkParameterIsNotNull(marginLeft, "$this$marginLeft");
        ViewGroup.LayoutParams layoutParams = marginLeft.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginTop(View marginTop) {
        Intrinsics.checkParameterIsNotNull(marginTop, "$this$marginTop");
        ViewGroup.LayoutParams layoutParams = marginTop.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View marginRight) {
        Intrinsics.checkParameterIsNotNull(marginRight, "$this$marginRight");
        ViewGroup.LayoutParams layoutParams = marginRight.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginBottom(View marginBottom) {
        Intrinsics.checkParameterIsNotNull(marginBottom, "$this$marginBottom");
        ViewGroup.LayoutParams layoutParams = marginBottom.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View marginStart) {
        Intrinsics.checkParameterIsNotNull(marginStart, "$this$marginStart");
        ViewGroup.LayoutParams layoutParams = marginStart.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginEnd(View marginEnd) {
        Intrinsics.checkParameterIsNotNull(marginEnd, "$this$marginEnd");
        ViewGroup.LayoutParams layoutParams = marginEnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final void updateLayoutParams(View updateLayoutParams, Function1<? super ViewGroup.LayoutParams, Unit> block) {
        Intrinsics.checkParameterIsNotNull(updateLayoutParams, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ViewGroup.LayoutParams layoutParams = updateLayoutParams.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        block.invoke(layoutParams);
        updateLayoutParams.setLayoutParams(layoutParams);
    }
}
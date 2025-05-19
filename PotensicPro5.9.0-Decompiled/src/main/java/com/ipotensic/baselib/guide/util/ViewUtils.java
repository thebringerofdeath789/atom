package com.ipotensic.baselib.guide.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class ViewUtils {
    private static final String FRAGMENT_CON = "NoSaveStateFrameLayout";

    public static Rect getLocationInView(View view, View view2) {
        if (view2 == null || view == null) {
            throw new IllegalArgumentException("parent and child can not be null .");
        }
        Context context = view2.getContext();
        View decorView = context instanceof Activity ? ((Activity) context).getWindow().getDecorView() : null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        if (view2 == view) {
            view2.getHitRect(rect);
            return rect;
        }
        View view3 = view2;
        while (view3 != decorView && view3 != view) {
            LogUtil.i("tmp class:" + view3.getClass().getSimpleName());
            view3.getHitRect(rect2);
            LogUtil.i("tmp hit Rect:" + rect2);
            if (!view3.getClass().equals(FRAGMENT_CON)) {
                rect.left += rect2.left;
                rect.top += rect2.top;
            }
            view3 = (View) view3.getParent();
            if (view3 == null) {
                throw new IllegalArgumentException("the view is not showing in the window!");
            }
            if (view3.getParent() instanceof ScrollView) {
                int scrollY = ((ScrollView) view3.getParent()).getScrollY();
                LogUtil.i("scrollY:" + scrollY);
                rect.top -= scrollY;
            }
            if (view3.getParent() instanceof HorizontalScrollView) {
                int scrollX = ((HorizontalScrollView) view3.getParent()).getScrollX();
                LogUtil.i("scrollX:" + scrollX);
                rect.left -= scrollX;
            }
            if (view3.getParent() != null && (view3.getParent() instanceof ViewPager)) {
                view3 = (View) view3.getParent();
            }
        }
        rect.right = rect.left + view2.getMeasuredWidth();
        rect.bottom = rect.top + view2.getMeasuredHeight();
        return rect;
    }

    public static void setDrawableTop(TextView textView, int i) {
        Drawable drawable = textView.getContext().getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static void setClickable(View view, boolean z) {
        view.setEnabled(z);
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    public static void setViewEnable(View view, boolean z) {
        view.setClickable(z);
        view.setEnabled(z);
        view.setFocusable(z);
    }

    public static void setViewEnableWithAlpha(View view, boolean z) {
        view.setClickable(z);
        view.setEnabled(z);
        view.setFocusable(z);
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    public static void show(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(0);
        }
    }

    public static void dismiss(View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(8);
        }
    }
}

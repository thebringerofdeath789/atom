package com.ipotensic.baselib.guide.model;

import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.util.LogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class RelativeGuide {
    public int bottom;
    public int gravity;
    public HighLight highLight;
    public int layout;
    public int left;
    public int padding;
    public int right;
    public int top;

    @Retention(RetentionPolicy.SOURCE)
    @interface LimitGravity {
    }

    protected void offsetMargin(MarginInfo marginInfo, ViewGroup viewGroup, View view) {
    }

    @Deprecated
    protected void onLayoutInflated(View view) {
    }

    protected void onLayoutInflated(View view, Controller controller) {
    }

    public static class MarginInfo {
        public int bottomMargin;
        public int gravity;
        public int leftMargin;
        public int rightMargin;
        public int topMargin;

        public String toString() {
            return "MarginInfo{leftMargin=" + this.leftMargin + ", topMargin=" + this.topMargin + ", rightMargin=" + this.rightMargin + ", bottomMargin=" + this.bottomMargin + ", gravity=" + this.gravity + '}';
        }
    }

    public RelativeGuide(int i, int i2) {
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.layout = i;
        this.gravity = i2;
    }

    public RelativeGuide(int i, int i2, int i3) {
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.layout = i;
        this.gravity = i2;
        this.padding = i3;
    }

    public RelativeGuide(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.layout = i;
        this.gravity = i2;
        this.padding = i3;
        this.top = i5;
        this.left = i4;
        this.right = i6;
        this.bottom = i7;
    }

    public final View getGuideLayout(ViewGroup viewGroup, Controller controller, GuidePage guidePage) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.layout, viewGroup, false);
        OnLayoutInflatedListener onLayoutInflatedListener = guidePage.getOnLayoutInflatedListener();
        if (onLayoutInflatedListener != null) {
            onLayoutInflatedListener.onLayoutInflated(inflate, controller);
        }
        onLayoutInflated(inflate);
        onLayoutInflated(inflate, controller);
        inflate.post(new Runnable() { // from class: com.ipotensic.baselib.guide.model.RelativeGuide.1
            final /* synthetic */ FrameLayout.LayoutParams val$layoutParams;
            final /* synthetic */ View val$view;
            final /* synthetic */ ViewGroup val$viewGroup;

            AnonymousClass1(ViewGroup viewGroup2, View inflate2, FrameLayout.LayoutParams layoutParams) {
                r2 = viewGroup2;
                r3 = inflate2;
                r4 = layoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                RelativeGuide relativeGuide = RelativeGuide.this;
                MarginInfo marginInfo = relativeGuide.getMarginInfo(relativeGuide.gravity, r2, r3.getHeight(), r3.getWidth());
                LogUtil.e(marginInfo.toString());
                RelativeGuide.this.offsetMargin(marginInfo, r2, r3);
                r4.gravity = marginInfo.gravity;
                r4.leftMargin += marginInfo.leftMargin;
                r4.topMargin += marginInfo.topMargin;
                r4.rightMargin += marginInfo.rightMargin;
                r4.bottomMargin += marginInfo.bottomMargin;
                r3.setLayoutParams(r4);
            }
        });
        return inflate2;
    }

    /* renamed from: com.ipotensic.baselib.guide.model.RelativeGuide$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ FrameLayout.LayoutParams val$layoutParams;
        final /* synthetic */ View val$view;
        final /* synthetic */ ViewGroup val$viewGroup;

        AnonymousClass1(ViewGroup viewGroup2, View inflate2, FrameLayout.LayoutParams layoutParams) {
            r2 = viewGroup2;
            r3 = inflate2;
            r4 = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            RelativeGuide relativeGuide = RelativeGuide.this;
            MarginInfo marginInfo = relativeGuide.getMarginInfo(relativeGuide.gravity, r2, r3.getHeight(), r3.getWidth());
            LogUtil.e(marginInfo.toString());
            RelativeGuide.this.offsetMargin(marginInfo, r2, r3);
            r4.gravity = marginInfo.gravity;
            r4.leftMargin += marginInfo.leftMargin;
            r4.topMargin += marginInfo.topMargin;
            r4.rightMargin += marginInfo.rightMargin;
            r4.bottomMargin += marginInfo.bottomMargin;
            r3.setLayoutParams(r4);
        }
    }

    public MarginInfo getMarginInfo(int i, ViewGroup viewGroup, int i2, int i3) {
        MarginInfo marginInfo = new MarginInfo();
        RectF rectF = this.highLight.getRectF(viewGroup);
        float height = rectF.height();
        float width = rectF.width();
        if (i == 3) {
            marginInfo.gravity = 5;
            marginInfo.rightMargin = (int) ((viewGroup.getWidth() - rectF.left) + this.padding);
            marginInfo.topMargin = (((int) rectF.bottom) - (((int) height) / 2)) - (i2 / 2);
        } else if (i == 5) {
            marginInfo.leftMargin = (int) (rectF.right + this.padding);
            marginInfo.topMargin = ((((int) rectF.bottom) - (((int) height) / 2)) - (i2 / 2)) - this.top;
        } else if (i == 48) {
            marginInfo.gravity = 80;
            marginInfo.bottomMargin = (int) ((viewGroup.getHeight() - rectF.top) + this.padding);
            marginInfo.leftMargin = ((((int) rectF.right) - (((int) width) / 2)) - (i3 / 2)) + this.left;
        } else if (i == 80) {
            marginInfo.topMargin = (int) (rectF.bottom + this.padding);
            marginInfo.leftMargin = ((((int) rectF.right) - (((int) width) / 2)) - (i3 / 2)) + this.left;
        } else if (i == 8388611) {
            marginInfo.topMargin = (int) (rectF.bottom + this.padding);
            marginInfo.leftMargin = ((int) rectF.left) + this.left;
        } else if (i == 8388613) {
            marginInfo.topMargin = (int) (rectF.bottom + this.padding);
            marginInfo.leftMargin = (((int) rectF.right) + this.right) - i3;
        }
        return marginInfo;
    }

    private MarginInfo getMarginInfo2(int i, ViewGroup viewGroup, int i2, int i3) {
        MarginInfo marginInfo = new MarginInfo();
        RectF rectF = this.highLight.getRectF(viewGroup);
        float height = rectF.height();
        float width = rectF.width();
        if (i == 3) {
            marginInfo.gravity = 5;
            marginInfo.rightMargin = (int) ((viewGroup.getWidth() - rectF.left) + this.padding);
            marginInfo.topMargin = (((int) rectF.bottom) - (((int) height) / 2)) - (i2 / 2);
        } else if (i == 5) {
            marginInfo.leftMargin = (int) (rectF.right + this.padding);
            marginInfo.topMargin = ((((int) rectF.bottom) - (((int) height) / 2)) - (i2 / 2)) - this.top;
        } else if (i == 48) {
            marginInfo.gravity = 80;
            marginInfo.bottomMargin = (int) ((viewGroup.getHeight() - rectF.top) + this.padding);
            marginInfo.leftMargin = ((((int) rectF.right) - (((int) width) / 2)) - (i3 / 2)) + this.left;
        } else if (i == 80) {
            marginInfo.topMargin = (int) (rectF.bottom + this.padding);
            marginInfo.leftMargin = ((((int) rectF.right) - (((int) width) / 2)) - (i3 / 2)) + this.left;
        }
        return marginInfo;
    }
}
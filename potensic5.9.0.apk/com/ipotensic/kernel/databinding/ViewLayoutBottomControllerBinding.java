package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutBottomControllerBinding implements ViewBinding {
    public final ImageView ivD;
    public final ImageView ivH;
    public final ImageView ivSpeed;
    public final ImageView ivVerticalSpeed;
    public final LinearLayout layoutBottom;
    private final LinearLayout rootView;
    public final StrokeTextView tvHeight;
    public final StrokeTextView tvHorizontalDistance;
    public final StrokeTextView tvHorizontalSpeed;
    public final StrokeTextView tvM;
    public final StrokeTextView tvMHeight;
    public final StrokeTextView tvMs;
    public final StrokeTextView tvMsHeight;
    public final StrokeTextView tvVerticalSpeed;

    private ViewLayoutBottomControllerBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, StrokeTextView strokeTextView4, StrokeTextView strokeTextView5, StrokeTextView strokeTextView6, StrokeTextView strokeTextView7, StrokeTextView strokeTextView8) {
        this.rootView = linearLayout;
        this.ivD = imageView;
        this.ivH = imageView2;
        this.ivSpeed = imageView3;
        this.ivVerticalSpeed = imageView4;
        this.layoutBottom = linearLayout2;
        this.tvHeight = strokeTextView;
        this.tvHorizontalDistance = strokeTextView2;
        this.tvHorizontalSpeed = strokeTextView3;
        this.tvM = strokeTextView4;
        this.tvMHeight = strokeTextView5;
        this.tvMs = strokeTextView6;
        this.tvMsHeight = strokeTextView7;
        this.tvVerticalSpeed = strokeTextView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutBottomControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutBottomControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_bottom_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutBottomControllerBinding bind(View view) {
        int i = C1965R.id.iv_d;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1965R.id.iv_h;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1965R.id.iv_speed;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = C1965R.id.iv_vertical_speed;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        i = C1965R.id.tv_height;
                        StrokeTextView strokeTextView = (StrokeTextView) view.findViewById(i);
                        if (strokeTextView != null) {
                            i = C1965R.id.tv_horizontal_distance;
                            StrokeTextView strokeTextView2 = (StrokeTextView) view.findViewById(i);
                            if (strokeTextView2 != null) {
                                i = C1965R.id.tv_horizontal_speed;
                                StrokeTextView strokeTextView3 = (StrokeTextView) view.findViewById(i);
                                if (strokeTextView3 != null) {
                                    i = C1965R.id.tv_m;
                                    StrokeTextView strokeTextView4 = (StrokeTextView) view.findViewById(i);
                                    if (strokeTextView4 != null) {
                                        i = C1965R.id.tv_m_height;
                                        StrokeTextView strokeTextView5 = (StrokeTextView) view.findViewById(i);
                                        if (strokeTextView5 != null) {
                                            i = C1965R.id.tv_ms;
                                            StrokeTextView strokeTextView6 = (StrokeTextView) view.findViewById(i);
                                            if (strokeTextView6 != null) {
                                                i = C1965R.id.tv_ms_height;
                                                StrokeTextView strokeTextView7 = (StrokeTextView) view.findViewById(i);
                                                if (strokeTextView7 != null) {
                                                    i = C1965R.id.tv_vertical_speed;
                                                    StrokeTextView strokeTextView8 = (StrokeTextView) view.findViewById(i);
                                                    if (strokeTextView8 != null) {
                                                        return new ViewLayoutBottomControllerBinding(linearLayout, imageView, imageView2, imageView3, imageView4, linearLayout, strokeTextView, strokeTextView2, strokeTextView3, strokeTextView4, strokeTextView5, strokeTextView6, strokeTextView7, strokeTextView8);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
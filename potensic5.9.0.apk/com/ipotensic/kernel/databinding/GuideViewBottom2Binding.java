package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class GuideViewBottom2Binding implements ViewBinding {
    public final ImageView ivHorizontalSpeed;
    public final ImageView ivVerticalSpeed;
    private final ConstraintLayout rootView;
    public final TextView tvDistance;
    public final TextView tvDistanceTips;
    public final TextView tvHeight;
    public final TextView tvHeightTips;
    public final TextView tvHorizontalSpeedTips;
    public final ConstraintLayout tvReturn;
    public final TextView tvVerticalSpeedTips;

    private GuideViewBottom2Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ConstraintLayout constraintLayout2, TextView textView6) {
        this.rootView = constraintLayout;
        this.ivHorizontalSpeed = imageView;
        this.ivVerticalSpeed = imageView2;
        this.tvDistance = textView;
        this.tvDistanceTips = textView2;
        this.tvHeight = textView3;
        this.tvHeightTips = textView4;
        this.tvHorizontalSpeedTips = textView5;
        this.tvReturn = constraintLayout2;
        this.tvVerticalSpeedTips = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GuideViewBottom2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuideViewBottom2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.guide_view_bottom2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GuideViewBottom2Binding bind(View view) {
        int i = C1965R.id.iv_horizontal_speed;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1965R.id.iv_vertical_speed;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1965R.id.tv_distance;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1965R.id.tv_distance_tips;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C1965R.id.tv_height;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            i = C1965R.id.tv_height_tips;
                            TextView textView4 = (TextView) view.findViewById(i);
                            if (textView4 != null) {
                                i = C1965R.id.tv_horizontal_speed_tips;
                                TextView textView5 = (TextView) view.findViewById(i);
                                if (textView5 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i = C1965R.id.tv_vertical_speed_tips;
                                    TextView textView6 = (TextView) view.findViewById(i);
                                    if (textView6 != null) {
                                        return new GuideViewBottom2Binding(constraintLayout, imageView, imageView2, textView, textView2, textView3, textView4, textView5, constraintLayout, textView6);
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
package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting1Binding implements ViewBinding {
    public final ViewLayoutSetting1Item1Binding include1;
    public final ImageView ivBack;
    public final LinearLayout layoutFlyFence;
    public final LinearLayout layoutReturnHeight;
    public final LinearLayout layoutSpeedMode;
    public final View line1;
    public final View line5;
    public final View line7;
    private final ConstraintLayout rootView;
    public final TextView tvControllerSet;
    public final TextView tvDataChange;
    public final TextView tvFlightTips;
    public final TextView tvFlyFenceTitle;
    public final TextView tvReturnHeightTitle;
    public final TextView tvSpeedChange;

    private ViewLayoutSetting1Binding(ConstraintLayout constraintLayout, ViewLayoutSetting1Item1Binding viewLayoutSetting1Item1Binding, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, View view2, View view3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.include1 = viewLayoutSetting1Item1Binding;
        this.ivBack = imageView;
        this.layoutFlyFence = linearLayout;
        this.layoutReturnHeight = linearLayout2;
        this.layoutSpeedMode = linearLayout3;
        this.line1 = view;
        this.line5 = view2;
        this.line7 = view3;
        this.tvControllerSet = textView;
        this.tvDataChange = textView2;
        this.tvFlightTips = textView3;
        this.tvFlyFenceTitle = textView4;
        this.tvReturnHeightTitle = textView5;
        this.tvSpeedChange = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting_1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting1Binding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        int i = C1965R.id.include1;
        View findViewById4 = view.findViewById(i);
        if (findViewById4 != null) {
            ViewLayoutSetting1Item1Binding bind = ViewLayoutSetting1Item1Binding.bind(findViewById4);
            i = C1965R.id.iv_back;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C1965R.id.layout_fly_fence;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = C1965R.id.layout_return_height;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                    if (linearLayout2 != null) {
                        i = C1965R.id.layout_speed_mode;
                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                        if (linearLayout3 != null && (findViewById = view.findViewById((i = C1965R.id.line1))) != null && (findViewById2 = view.findViewById((i = C1965R.id.line5))) != null && (findViewById3 = view.findViewById((i = C1965R.id.line7))) != null) {
                            i = C1965R.id.tv_controller_set;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C1965R.id.tv_data_change;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C1965R.id.tv_flight_tips;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = C1965R.id.tv_fly_fence_title;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = C1965R.id.tv_return_height_title;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                i = C1965R.id.tv_speed_change;
                                                TextView textView6 = (TextView) view.findViewById(i);
                                                if (textView6 != null) {
                                                    return new ViewLayoutSetting1Binding((ConstraintLayout) view, bind, imageView, linearLayout, linearLayout2, linearLayout3, findViewById, findViewById2, findViewById3, textView, textView2, textView3, textView4, textView5, textView6);
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
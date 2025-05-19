package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting5Binding implements ViewBinding {
    public final ViewLayoutSetting5Item1Binding include1;
    public final ViewLayoutSetting5Item2Binding include2;
    public final ViewLayoutSetting5Item3Binding include3;
    public final ImageView ivBack;
    public final View lineSn;
    public final LinearLayout llSn;
    private final ConstraintLayout rootView;
    public final TextView tvCurProject;
    public final TextView tvFlightSn;
    public final TextView tvFlightType;
    public final TextView tvRemoteSn;
    public final TextView tvSetting;

    private ViewLayoutSetting5Binding(ConstraintLayout constraintLayout, ViewLayoutSetting5Item1Binding viewLayoutSetting5Item1Binding, ViewLayoutSetting5Item2Binding viewLayoutSetting5Item2Binding, ViewLayoutSetting5Item3Binding viewLayoutSetting5Item3Binding, ImageView imageView, View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.include1 = viewLayoutSetting5Item1Binding;
        this.include2 = viewLayoutSetting5Item2Binding;
        this.include3 = viewLayoutSetting5Item3Binding;
        this.ivBack = imageView;
        this.lineSn = view;
        this.llSn = linearLayout;
        this.tvCurProject = textView;
        this.tvFlightSn = textView2;
        this.tvFlightType = textView3;
        this.tvRemoteSn = textView4;
        this.tvSetting = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting5Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting_5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting5Binding bind(View view) {
        View findViewById;
        int i = R.id.include1;
        View findViewById2 = view.findViewById(i);
        if (findViewById2 != null) {
            ViewLayoutSetting5Item1Binding bind = ViewLayoutSetting5Item1Binding.bind(findViewById2);
            i = R.id.include2;
            View findViewById3 = view.findViewById(i);
            if (findViewById3 != null) {
                ViewLayoutSetting5Item2Binding bind2 = ViewLayoutSetting5Item2Binding.bind(findViewById3);
                i = R.id.include3;
                View findViewById4 = view.findViewById(i);
                if (findViewById4 != null) {
                    ViewLayoutSetting5Item3Binding bind3 = ViewLayoutSetting5Item3Binding.bind(findViewById4);
                    i = R.id.iv_back;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null && (findViewById = view.findViewById((i = R.id.line_sn))) != null) {
                        i = R.id.ll_sn;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                        if (linearLayout != null) {
                            i = R.id.tv_cur_project;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = R.id.tv_flight_sn;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = R.id.tv_flight_type;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = R.id.tv_remote_sn;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = R.id.tv_setting;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                return new ViewLayoutSetting5Binding((ConstraintLayout) view, bind, bind2, bind3, imageView, findViewById, linearLayout, textView, textView2, textView3, textView4, textView5);
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

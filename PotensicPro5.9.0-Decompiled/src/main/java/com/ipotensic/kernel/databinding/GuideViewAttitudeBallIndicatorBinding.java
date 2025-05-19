package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class GuideViewAttitudeBallIndicatorBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvView;

    private GuideViewAttitudeBallIndicatorBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GuideViewAttitudeBallIndicatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuideViewAttitudeBallIndicatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.guide_view_attitude_ball_indicator, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GuideViewAttitudeBallIndicatorBinding bind(View view) {
        int i = R.id.tv_view;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            return new GuideViewAttitudeBallIndicatorBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

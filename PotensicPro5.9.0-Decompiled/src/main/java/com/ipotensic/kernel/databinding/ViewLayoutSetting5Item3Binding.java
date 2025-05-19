package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting5Item3Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvImperial;
    public final TextView tvMetric;

    private ViewLayoutSetting5Item3Binding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvCodeTitle = textView;
        this.tvImperial = textView2;
        this.tvMetric = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting5Item3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting5Item3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting5_item3, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting5Item3Binding bind(View view) {
        int i = R.id.tv_code_title;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.tv_imperial;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.tv_metric;
                TextView textView3 = (TextView) view.findViewById(i);
                if (textView3 != null) {
                    return new ViewLayoutSetting5Item3Binding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

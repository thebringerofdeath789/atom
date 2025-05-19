package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutUpgradeTipsBinding implements ViewBinding {
    public final TextView btnDoubleCancel;
    public final TextView btnDoubleConfirm;
    public final TextView btnSingleConfirm;
    public final View lineHorizontal;
    public final View lineVertical;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvDetail;

    private ViewLayoutUpgradeTipsBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, View view, View view2, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnDoubleCancel = textView;
        this.btnDoubleConfirm = textView2;
        this.btnSingleConfirm = textView3;
        this.lineHorizontal = view;
        this.lineVertical = view2;
        this.tvCodeTitle = textView4;
        this.tvDetail = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutUpgradeTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutUpgradeTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_upgrade_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutUpgradeTipsBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = R.id.btn_double_cancel;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.btn_double_confirm;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.btn_single_confirm;
                TextView textView3 = (TextView) view.findViewById(i);
                if (textView3 != null && (findViewById = view.findViewById((i = R.id.line_horizontal))) != null && (findViewById2 = view.findViewById((i = R.id.line_vertical))) != null) {
                    i = R.id.tv_code_title;
                    TextView textView4 = (TextView) view.findViewById(i);
                    if (textView4 != null) {
                        i = R.id.tv_detail;
                        TextView textView5 = (TextView) view.findViewById(i);
                        if (textView5 != null) {
                            return new ViewLayoutUpgradeTipsBinding((ConstraintLayout) view, textView, textView2, textView3, findViewById, findViewById2, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

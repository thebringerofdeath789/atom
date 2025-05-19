package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting1Item1Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final SwitchButton slideBtnNewMode;
    public final TextView tvBeginnerMode;
    public final TextView tvCodeTitle;

    private ViewLayoutSetting1Item1Binding(ConstraintLayout constraintLayout, SwitchButton switchButton, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.slideBtnNewMode = switchButton;
        this.tvBeginnerMode = textView;
        this.tvCodeTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting1Item1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting1Item1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting1_item1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting1Item1Binding bind(View view) {
        int i = R.id.slideBtn_new_mode;
        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
        if (switchButton != null) {
            i = R.id.tv_beginner_mode;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_code_title;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewLayoutSetting1Item1Binding((ConstraintLayout) view, switchButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

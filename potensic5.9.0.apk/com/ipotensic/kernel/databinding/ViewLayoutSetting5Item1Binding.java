package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting5Item1Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final SwitchButton slideHardDecode;
    public final TextView tvCodeTitle;

    private ViewLayoutSetting5Item1Binding(ConstraintLayout constraintLayout, SwitchButton switchButton, TextView textView) {
        this.rootView = constraintLayout;
        this.slideHardDecode = switchButton;
        this.tvCodeTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting5Item1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting5Item1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting5_item1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting5Item1Binding bind(View view) {
        int i = C1965R.id.slide_hard_decode;
        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
        if (switchButton != null) {
            i = C1965R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new ViewLayoutSetting5Item1Binding((ConstraintLayout) view, switchButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
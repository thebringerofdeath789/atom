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
public final class ViewRightCameraSetItem1Binding implements ViewBinding {

    /* renamed from: cl */
    public final ConstraintLayout f2205cl;
    private final ConstraintLayout rootView;
    public final SwitchButton slideBtnGrid;
    public final TextView tvCodeTitle;

    private ViewRightCameraSetItem1Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, SwitchButton switchButton, TextView textView) {
        this.rootView = constraintLayout;
        this.f2205cl = constraintLayout2;
        this.slideBtnGrid = switchButton;
        this.tvCodeTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightCameraSetItem1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightCameraSetItem1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_right_camera_set_item1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightCameraSetItem1Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C1965R.id.slideBtn_grid;
        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
        if (switchButton != null) {
            i = C1965R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new ViewRightCameraSetItem1Binding(constraintLayout, constraintLayout, switchButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
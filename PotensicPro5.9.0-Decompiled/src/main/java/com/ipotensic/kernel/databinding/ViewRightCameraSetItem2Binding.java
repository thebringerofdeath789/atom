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
public final class ViewRightCameraSetItem2Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final SwitchButton slideBtnWaterMark;
    public final TextView tvCodeTitle;

    private ViewRightCameraSetItem2Binding(ConstraintLayout constraintLayout, SwitchButton switchButton, TextView textView) {
        this.rootView = constraintLayout;
        this.slideBtnWaterMark = switchButton;
        this.tvCodeTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightCameraSetItem2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightCameraSetItem2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_right_camera_set_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightCameraSetItem2Binding bind(View view) {
        int i = R.id.slideBtn_water_mark;
        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
        if (switchButton != null) {
            i = R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new ViewRightCameraSetItem2Binding((ConstraintLayout) view, switchButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

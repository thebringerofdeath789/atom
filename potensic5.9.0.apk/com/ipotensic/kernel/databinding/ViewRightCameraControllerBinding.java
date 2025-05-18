package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewRightCameraControllerBinding implements ViewBinding {
    public final View ivRightBg;
    private final ConstraintLayout rootView;
    public final View viewBlank;
    public final ViewRightCameraSetBinding viewCameraSet;

    private ViewRightCameraControllerBinding(ConstraintLayout constraintLayout, View view, View view2, ViewRightCameraSetBinding viewRightCameraSetBinding) {
        this.rootView = constraintLayout;
        this.ivRightBg = view;
        this.viewBlank = view2;
        this.viewCameraSet = viewRightCameraSetBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightCameraControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightCameraControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_right_camera_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightCameraControllerBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = C1965R.id.iv_right_bg;
        View findViewById3 = view.findViewById(i);
        if (findViewById3 != null && (findViewById = view.findViewById((i = C1965R.id.view_blank))) != null && (findViewById2 = view.findViewById((i = C1965R.id.view_camera_set))) != null) {
            return new ViewRightCameraControllerBinding((ConstraintLayout) view, findViewById3, findViewById, ViewRightCameraSetBinding.bind(findViewById2));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
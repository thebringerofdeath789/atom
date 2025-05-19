package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.UpDownSlideView;

/* loaded from: classes2.dex */
public final class ViewRightSlideControllerBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final UpDownSlideView viewSlide;

    private ViewRightSlideControllerBinding(ConstraintLayout constraintLayout, UpDownSlideView upDownSlideView) {
        this.rootView = constraintLayout;
        this.viewSlide = upDownSlideView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRightSlideControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRightSlideControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_right_slide_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRightSlideControllerBinding bind(View view) {
        int i = R.id.view_slide;
        UpDownSlideView upDownSlideView = (UpDownSlideView) view.findViewById(i);
        if (upDownSlideView != null) {
            return new ViewRightSlideControllerBinding((ConstraintLayout) view, upDownSlideView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.RockerTouchView;

/* loaded from: classes2.dex */
public final class ViewRockerTouchControllerBinding implements ViewBinding {
    public final RockerTouchView rockerViewLeft;
    public final RockerTouchView rockerViewRight;
    private final ConstraintLayout rootView;

    private ViewRockerTouchControllerBinding(ConstraintLayout constraintLayout, RockerTouchView rockerTouchView, RockerTouchView rockerTouchView2) {
        this.rootView = constraintLayout;
        this.rockerViewLeft = rockerTouchView;
        this.rockerViewRight = rockerTouchView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRockerTouchControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRockerTouchControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_rocker_touch_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRockerTouchControllerBinding bind(View view) {
        int i = R.id.rocker_view_left;
        RockerTouchView rockerTouchView = (RockerTouchView) view.findViewById(i);
        if (rockerTouchView != null) {
            i = R.id.rocker_view_right;
            RockerTouchView rockerTouchView2 = (RockerTouchView) view.findViewById(i);
            if (rockerTouchView2 != null) {
                return new ViewRockerTouchControllerBinding((ConstraintLayout) view, rockerTouchView, rockerTouchView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

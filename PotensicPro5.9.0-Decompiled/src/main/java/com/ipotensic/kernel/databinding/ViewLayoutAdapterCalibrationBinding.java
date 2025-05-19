package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutAdapterCalibrationBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ViewPager2 viewPager2;

    private ViewLayoutAdapterCalibrationBinding(ConstraintLayout constraintLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutAdapterCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutAdapterCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_adapter_calibration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutAdapterCalibrationBinding bind(View view) {
        int i = R.id.viewPager2;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
        if (viewPager2 != null) {
            return new ViewLayoutAdapterCalibrationBinding((ConstraintLayout) view, viewPager2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

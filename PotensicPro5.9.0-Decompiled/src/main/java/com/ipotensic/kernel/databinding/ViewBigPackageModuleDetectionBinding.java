package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.BigPackageModuleDetectionView;

/* loaded from: classes2.dex */
public final class ViewBigPackageModuleDetectionBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvCurrentDetectionModule;
    public final TextView tvTitle;
    public final BigPackageModuleDetectionView viewBigPackageModuleDetection;

    private ViewBigPackageModuleDetectionBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, BigPackageModuleDetectionView bigPackageModuleDetectionView) {
        this.rootView = constraintLayout;
        this.tvCurrentDetectionModule = textView;
        this.tvTitle = textView2;
        this.viewBigPackageModuleDetection = bigPackageModuleDetectionView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewBigPackageModuleDetectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewBigPackageModuleDetectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_big_package_module_detection, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewBigPackageModuleDetectionBinding bind(View view) {
        int i = R.id.tv_current_detection_module;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.tv_title;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.view_big_package_module_detection;
                BigPackageModuleDetectionView bigPackageModuleDetectionView = (BigPackageModuleDetectionView) view.findViewById(i);
                if (bigPackageModuleDetectionView != null) {
                    return new ViewBigPackageModuleDetectionBinding((ConstraintLayout) view, textView, textView2, bigPackageModuleDetectionView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

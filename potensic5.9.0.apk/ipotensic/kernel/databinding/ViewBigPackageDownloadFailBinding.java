package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewBigPackageDownloadFailBinding implements ViewBinding {
    public final ConstraintLayout layoutBigPackageDownloadUpgrade;
    private final ConstraintLayout rootView;

    private ViewBigPackageDownloadFailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.layoutBigPackageDownloadUpgrade = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewBigPackageDownloadFailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewBigPackageDownloadFailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_big_package_download_fail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewBigPackageDownloadFailBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new ViewBigPackageDownloadFailBinding(constraintLayout, constraintLayout);
    }
}
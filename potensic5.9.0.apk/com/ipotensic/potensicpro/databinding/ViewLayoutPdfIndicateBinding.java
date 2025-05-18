package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewLayoutPdfIndicateBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ViewLayoutPdfIndicateBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutPdfIndicateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutPdfIndicateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_layout_pdf_indicate, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutPdfIndicateBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ViewLayoutPdfIndicateBinding((ConstraintLayout) view);
    }
}
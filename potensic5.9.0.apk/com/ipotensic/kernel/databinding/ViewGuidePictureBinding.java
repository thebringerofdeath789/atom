package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewGuidePictureBinding implements ViewBinding {
    public final ConstraintLayout clGuide;
    private final ConstraintLayout rootView;

    private ViewGuidePictureBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.clGuide = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewGuidePictureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewGuidePictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_guide_picture, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewGuidePictureBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new ViewGuidePictureBinding(constraintLayout, constraintLayout);
    }
}
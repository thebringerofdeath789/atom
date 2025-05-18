package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CrossView;

/* loaded from: classes2.dex */
public final class ViewCrossLineBinding implements ViewBinding {
    public final CrossView crossView;
    private final ConstraintLayout rootView;

    private ViewCrossLineBinding(ConstraintLayout constraintLayout, CrossView crossView) {
        this.rootView = constraintLayout;
        this.crossView = crossView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCrossLineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCrossLineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_cross_line, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCrossLineBinding bind(View view) {
        int i = C1965R.id.cross_view;
        CrossView crossView = (CrossView) view.findViewById(i);
        if (crossView != null) {
            return new ViewCrossLineBinding((ConstraintLayout) view, crossView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
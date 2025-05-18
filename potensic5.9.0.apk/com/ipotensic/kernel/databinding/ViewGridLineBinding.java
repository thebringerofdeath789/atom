package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewGridLineBinding implements ViewBinding {
    public final View horizontalLine1;
    public final View horizontalLine2;
    private final ConstraintLayout rootView;
    public final View verticalLine1;
    public final View verticalLine2;

    private ViewGridLineBinding(ConstraintLayout constraintLayout, View view, View view2, View view3, View view4) {
        this.rootView = constraintLayout;
        this.horizontalLine1 = view;
        this.horizontalLine2 = view2;
        this.verticalLine1 = view3;
        this.verticalLine2 = view4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewGridLineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewGridLineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_grid_line, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewGridLineBinding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        int i = C1965R.id.horizontal_line_1;
        View findViewById4 = view.findViewById(i);
        if (findViewById4 != null && (findViewById = view.findViewById((i = C1965R.id.horizontal_line_2))) != null && (findViewById2 = view.findViewById((i = C1965R.id.vertical_line_1))) != null && (findViewById3 = view.findViewById((i = C1965R.id.vertical_line_2))) != null) {
            return new ViewGridLineBinding((ConstraintLayout) view, findViewById4, findViewById, findViewById2, findViewById3);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
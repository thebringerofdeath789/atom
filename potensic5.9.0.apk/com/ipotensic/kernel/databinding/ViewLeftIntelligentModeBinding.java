package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLeftIntelligentModeBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final View viewBg;
    public final View viewBlank;
    public final ViewLeftIntelligentModeSetBinding viewMode;

    private ViewLeftIntelligentModeBinding(ConstraintLayout constraintLayout, View view, View view2, ViewLeftIntelligentModeSetBinding viewLeftIntelligentModeSetBinding) {
        this.rootView = constraintLayout;
        this.viewBg = view;
        this.viewBlank = view2;
        this.viewMode = viewLeftIntelligentModeSetBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLeftIntelligentModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLeftIntelligentModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_left_intelligent_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLeftIntelligentModeBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = C1965R.id.view_bg;
        View findViewById3 = view.findViewById(i);
        if (findViewById3 != null && (findViewById = view.findViewById((i = C1965R.id.view_blank))) != null && (findViewById2 = view.findViewById((i = C1965R.id.view_mode))) != null) {
            return new ViewLeftIntelligentModeBinding((ConstraintLayout) view, findViewById3, findViewById, ViewLeftIntelligentModeSetBinding.bind(findViewById2));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
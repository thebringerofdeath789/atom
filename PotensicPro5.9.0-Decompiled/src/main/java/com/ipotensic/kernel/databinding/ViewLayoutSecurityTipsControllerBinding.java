package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutSecurityTipsControllerBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final LinearLayout securityTipsContainer;

    private ViewLayoutSecurityTipsControllerBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.securityTipsContainer = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSecurityTipsControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSecurityTipsControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_security_tips_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSecurityTipsControllerBinding bind(View view) {
        int i = R.id.security_tips_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            return new ViewLayoutSecurityTipsControllerBinding((ConstraintLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

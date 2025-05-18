package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ActivityUserAgreeBinding implements ViewBinding {
    public final FrameLayout flWebContainer;
    private final ConstraintLayout rootView;
    public final ViewToolbarBinding toolbar;

    private ActivityUserAgreeBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ViewToolbarBinding viewToolbarBinding) {
        this.rootView = constraintLayout;
        this.flWebContainer = frameLayout;
        this.toolbar = viewToolbarBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUserAgreeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUserAgreeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_user_agree, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUserAgreeBinding bind(View view) {
        int i = C2640R.id.fl_web_container;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C2640R.id.fl_web_container);
        if (frameLayout != null) {
            i = C2640R.id.toolbar;
            View findViewById = view.findViewById(C2640R.id.toolbar);
            if (findViewById != null) {
                return new ActivityUserAgreeBinding((ConstraintLayout) view, frameLayout, ViewToolbarBinding.bind(findViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;
import com.p019gs.keyboard.SecurityEditText;

/* loaded from: classes2.dex */
public final class ActivityTestBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SecurityEditText tvSecurity;

    private ActivityTestBinding(RelativeLayout relativeLayout, SecurityEditText securityEditText) {
        this.rootView = relativeLayout;
        this.tvSecurity = securityEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_test, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTestBinding bind(View view) {
        SecurityEditText securityEditText = (SecurityEditText) view.findViewById(C2640R.id.tv_security);
        if (securityEditText != null) {
            return new ActivityTestBinding((RelativeLayout) view, securityEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C2640R.id.tv_security)));
    }
}
package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewLayoutLogoutBinding implements ViewBinding {
    public final Button btnLogout;
    private final LinearLayout rootView;

    private ViewLayoutLogoutBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.btnLogout = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutLogoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutLogoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_layout_logout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutLogoutBinding bind(View view) {
        Button button = (Button) view.findViewById(C2640R.id.btn_logout);
        if (button != null) {
            return new ViewLayoutLogoutBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C2640R.id.btn_logout)));
    }
}
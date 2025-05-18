package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewLayoutCancelAccountBinding implements ViewBinding {
    public final Button btnCancelAccount;
    private final LinearLayout rootView;

    private ViewLayoutCancelAccountBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.btnCancelAccount = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutCancelAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutCancelAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_layout_cancel_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutCancelAccountBinding bind(View view) {
        Button button = (Button) view.findViewById(C2640R.id.btn_cancel_account);
        if (button != null) {
            return new ViewLayoutCancelAccountBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C2640R.id.btn_cancel_account)));
    }
}
package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class DialogForceTakeoffBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final LinearLayout llBtn;
    private final ShadowLayout rootView;
    public final TextView tvContent;

    private DialogForceTakeoffBinding(ShadowLayout shadowLayout, Button button, Button button2, LinearLayout linearLayout, TextView textView) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.llBtn = linearLayout;
        this.tvContent = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static DialogForceTakeoffBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogForceTakeoffBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.dialog_force_takeoff, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogForceTakeoffBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.ll_btn;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = C1965R.id.tv_content;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        return new DialogForceTakeoffBinding((ShadowLayout) view, button, button2, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
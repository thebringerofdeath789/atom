package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogButtonOneBinding implements ViewBinding {
    public final Button btnOk;
    private final ShadowLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;

    private ViewDialogButtonOneBinding(ShadowLayout shadowLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnOk = button;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogButtonOneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogButtonOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_button_one, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogButtonOneBinding bind(View view) {
        int i = R.id.btn_ok;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.tv_dialog_message;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_dialog_title;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewDialogButtonOneBinding((ShadowLayout) view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewLoginForgetPasswordBinding implements ViewBinding {
    public final Button btnNext;
    public final ImageButton btnReturn;
    public final EditText edtForgetPassword;
    private final ConstraintLayout rootView;
    public final TextView tvTitleForget;

    private ViewLoginForgetPasswordBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton, EditText editText, TextView textView) {
        this.rootView = constraintLayout;
        this.btnNext = button;
        this.btnReturn = imageButton;
        this.edtForgetPassword = editText;
        this.tvTitleForget = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLoginForgetPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLoginForgetPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_login_forget_password, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLoginForgetPasswordBinding bind(View view) {
        int i = C2640R.id.btn_next;
        Button button = (Button) view.findViewById(C2640R.id.btn_next);
        if (button != null) {
            i = C2640R.id.btn_return;
            ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_return);
            if (imageButton != null) {
                i = C2640R.id.edt_forget_password;
                EditText editText = (EditText) view.findViewById(C2640R.id.edt_forget_password);
                if (editText != null) {
                    i = C2640R.id.tv_title_forget;
                    TextView textView = (TextView) view.findViewById(C2640R.id.tv_title_forget);
                    if (textView != null) {
                        return new ViewLoginForgetPasswordBinding((ConstraintLayout) view, button, imageButton, editText, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
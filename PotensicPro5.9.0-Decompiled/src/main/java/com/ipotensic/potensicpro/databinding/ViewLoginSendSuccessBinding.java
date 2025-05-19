package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewLoginSendSuccessBinding implements ViewBinding {
    public final Button btnBack;
    public final ImageButton btnReturn;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvSendSuccess;

    private ViewLoginSendSuccessBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnBack = button;
        this.btnReturn = imageButton;
        this.tvCodeTitle = textView;
        this.tvSendSuccess = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLoginSendSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLoginSendSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_login_send_success, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLoginSendSuccessBinding bind(View view) {
        int i = R.id.btn_back;
        Button button = (Button) view.findViewById(R.id.btn_back);
        if (button != null) {
            i = R.id.btn_return;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_return);
            if (imageButton != null) {
                i = R.id.tv_code_title;
                TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                if (textView != null) {
                    i = R.id.tv_send_success;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_send_success);
                    if (textView2 != null) {
                        return new ViewLoginSendSuccessBinding((ConstraintLayout) view, button, imageButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

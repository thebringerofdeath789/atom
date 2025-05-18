package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDialogPrivacyPortraitBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final View line1;
    public final LinearLayout llBtn;
    private final LinearLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private ViewDialogPrivacyPortraitBinding(LinearLayout linearLayout, Button button, Button button2, View view, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.line1 = view;
        this.llBtn = linearLayout2;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogPrivacyPortraitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogPrivacyPortraitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_privacy_portrait, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogPrivacyPortraitBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(R.id.btn_confirm);
            if (button2 != null) {
                i = R.id.line1;
                View findViewById = view.findViewById(R.id.line1);
                if (findViewById != null) {
                    i = R.id.ll_btn;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_btn);
                    if (linearLayout != null) {
                        i = R.id.tv_code_title;
                        TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                        if (textView != null) {
                            i = R.id.tv_content;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_content);
                            if (textView2 != null) {
                                return new ViewDialogPrivacyPortraitBinding((LinearLayout) view, button, button2, findViewById, linearLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
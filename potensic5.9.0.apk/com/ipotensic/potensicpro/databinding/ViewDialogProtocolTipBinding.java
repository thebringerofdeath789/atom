package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewDialogProtocolTipBinding implements ViewBinding {
    public final Button btnCancel;
    public final View line1;
    public final LinearLayout llBtn;
    private final LinearLayout rootView;
    public final TextView tvContent;

    private ViewDialogProtocolTipBinding(LinearLayout linearLayout, Button button, View view, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.line1 = view;
        this.llBtn = linearLayout2;
        this.tvContent = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogProtocolTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogProtocolTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_dialog_protocol_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogProtocolTipBinding bind(View view) {
        int i = C2640R.id.btn_cancel;
        Button button = (Button) view.findViewById(C2640R.id.btn_cancel);
        if (button != null) {
            i = C2640R.id.line1;
            View findViewById = view.findViewById(C2640R.id.line1);
            if (findViewById != null) {
                i = C2640R.id.ll_btn;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C2640R.id.ll_btn);
                if (linearLayout != null) {
                    i = C2640R.id.tv_content;
                    TextView textView = (TextView) view.findViewById(C2640R.id.tv_content);
                    if (textView != null) {
                        return new ViewDialogProtocolTipBinding((LinearLayout) view, button, findViewById, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
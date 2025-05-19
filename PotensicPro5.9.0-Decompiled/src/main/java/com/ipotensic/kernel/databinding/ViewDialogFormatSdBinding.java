package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogFormatSdBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final LinearLayout llBtn;
    public final LinearLayout llHeight;
    private final ShadowLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;

    private ViewDialogFormatSdBinding(ShadowLayout shadowLayout, Button button, Button button2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.llBtn = linearLayout;
        this.llHeight = linearLayout2;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFormatSdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFormatSdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_format_sd, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFormatSdBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = R.id.ll_btn;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = R.id.ll_height;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                    if (linearLayout2 != null) {
                        i = R.id.tv_dialog_message;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = R.id.tv_dialog_title;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                return new ViewDialogFormatSdBinding((ShadowLayout) view, button, button2, linearLayout, linearLayout2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

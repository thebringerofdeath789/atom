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
public final class ViewDialogGeneralGrayBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final Button btnOk;
    public final LinearLayout llBtn;
    public final LinearLayout llHeight;
    private final ShadowLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;
    public final View viewLine;

    private ViewDialogGeneralGrayBinding(ShadowLayout shadowLayout, Button button, Button button2, Button button3, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.btnOk = button3;
        this.llBtn = linearLayout;
        this.llHeight = linearLayout2;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGeneralGrayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGeneralGrayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_general_gray, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGeneralGrayBinding bind(View view) {
        View findViewById;
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = R.id.btn_ok;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
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
                                if (textView2 != null && (findViewById = view.findViewById((i = R.id.view_line))) != null) {
                                    return new ViewDialogGeneralGrayBinding((ShadowLayout) view, button, button2, button3, linearLayout, linearLayout2, textView, textView2, findViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
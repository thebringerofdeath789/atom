package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogGeneralCancelAccountBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final LinearLayout llBtn;
    private final LinearLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;
    public final View viewLine;

    private ViewDialogGeneralCancelAccountBinding(LinearLayout linearLayout, Button button, Button button2, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.llBtn = linearLayout2;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGeneralCancelAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGeneralCancelAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_general_cancel_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGeneralCancelAccountBinding bind(View view) {
        View findViewById;
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = R.id.ll_btn;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = R.id.tv_dialog_message;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_dialog_title;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null && (findViewById = view.findViewById((i = R.id.view_line))) != null) {
                            return new ViewDialogGeneralCancelAccountBinding((LinearLayout) view, button, button2, linearLayout, textView, textView2, findViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

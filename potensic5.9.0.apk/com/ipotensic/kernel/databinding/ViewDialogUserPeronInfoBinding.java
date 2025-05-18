package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogUserPeronInfoBinding implements ViewBinding {
    public final Button btnConfirm;
    private final LinearLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;
    public final View viewLine;

    private ViewDialogUserPeronInfoBinding(LinearLayout linearLayout, Button button, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.btnConfirm = button;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUserPeronInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUserPeronInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_user_peron_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUserPeronInfoBinding bind(View view) {
        View findViewById;
        int i = C1965R.id.btn_confirm;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.tv_dialog_message;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C1965R.id.tv_dialog_title;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null && (findViewById = view.findViewById((i = C1965R.id.view_line))) != null) {
                    return new ViewDialogUserPeronInfoBinding((LinearLayout) view, button, textView, textView2, findViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
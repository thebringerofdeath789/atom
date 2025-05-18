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
public final class ViewPortraitDialogBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final LinearLayout llBtn;
    private final LinearLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;
    public final View viewLine;

    private ViewPortraitDialogBinding(LinearLayout linearLayout, Button button, Button button2, LinearLayout linearLayout2, TextView textView, TextView textView2, View view) {
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

    public static ViewPortraitDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewPortraitDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_portrait_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPortraitDialogBinding bind(View view) {
        View findViewById;
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.ll_btn;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = C1965R.id.tv_dialog_message;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C1965R.id.tv_dialog_title;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null && (findViewById = view.findViewById((i = C1965R.id.view_line))) != null) {
                            return new ViewPortraitDialogBinding((LinearLayout) view, button, button2, linearLayout, textView, textView2, findViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
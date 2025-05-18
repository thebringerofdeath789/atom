package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class DialogLandingConfirmBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final LinearLayout llBtn;
    private final ShadowLayout rootView;
    public final TextView tvDialogMessage;
    public final AppCompatTextView tvDialogTitle;
    public final TextView tvUpgradeFinishedCountDown;

    private DialogLandingConfirmBinding(ShadowLayout shadowLayout, Button button, Button button2, LinearLayout linearLayout, TextView textView, AppCompatTextView appCompatTextView, TextView textView2) {
        this.rootView = shadowLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.llBtn = linearLayout;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = appCompatTextView;
        this.tvUpgradeFinishedCountDown = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static DialogLandingConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLandingConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_landing_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogLandingConfirmBinding bind(View view) {
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
                        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i);
                        if (appCompatTextView != null) {
                            i = R.id.tv_upgrade_finished_count_down;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                return new DialogLandingConfirmBinding((ShadowLayout) view, button, button2, linearLayout, textView, appCompatTextView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.SlideUnlockButton;

/* loaded from: classes2.dex */
public final class ViewDialogSlideUnlockBinding implements ViewBinding {
    public final Button btnCancel;
    public final SlideUnlockButton btnSlideUnlock;
    private final ConstraintLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;

    private ViewDialogSlideUnlockBinding(ConstraintLayout constraintLayout, Button button, SlideUnlockButton slideUnlockButton, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnCancel = button;
        this.btnSlideUnlock = slideUnlockButton;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogSlideUnlockBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogSlideUnlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_slide_unlock, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogSlideUnlockBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_slide_unlock;
            SlideUnlockButton slideUnlockButton = (SlideUnlockButton) view.findViewById(i);
            if (slideUnlockButton != null) {
                i = R.id.tv_dialog_message;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = R.id.tv_dialog_title;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new ViewDialogSlideUnlockBinding((ConstraintLayout) view, button, slideUnlockButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

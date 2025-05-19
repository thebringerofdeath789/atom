package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogGeneralTopIconBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final ImageView ivImg;
    private final FrameLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;

    private ViewDialogGeneralTopIconBinding(FrameLayout frameLayout, Button button, Button button2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.ivImg = imageView;
        this.tvDialogMessage = textView;
        this.tvDialogTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGeneralTopIconBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGeneralTopIconBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_general_top_icon, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGeneralTopIconBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = R.id.iv_img;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = R.id.tv_dialog_message;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_dialog_title;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new ViewDialogGeneralTopIconBinding((FrameLayout) view, button, button2, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

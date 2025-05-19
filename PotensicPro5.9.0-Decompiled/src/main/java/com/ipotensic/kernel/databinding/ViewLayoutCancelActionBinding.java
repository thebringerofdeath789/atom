package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutCancelActionBinding implements ViewBinding {
    public final ImageButton btnCancelSwoopReturn;
    public final ImageView ivCancelAction;
    private final ConstraintLayout rootView;
    public final TextView textCancelSwoopReturn;

    private ViewLayoutCancelActionBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnCancelSwoopReturn = imageButton;
        this.ivCancelAction = imageView;
        this.textCancelSwoopReturn = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutCancelActionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutCancelActionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_cancel_action, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutCancelActionBinding bind(View view) {
        int i = R.id.btn_cancel_swoop_return;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.iv_cancel_action;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.text_cancel_swoop_return;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new ViewLayoutCancelActionBinding((ConstraintLayout) view, imageButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

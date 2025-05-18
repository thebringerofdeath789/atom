package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogSdFormattingBinding implements ViewBinding {
    public final ImageView ivLoading;
    private final ConstraintLayout rootView;

    private ViewDialogSdFormattingBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.ivLoading = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogSdFormattingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogSdFormattingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_sd_formatting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogSdFormattingBinding bind(View view) {
        int i = C1965R.id.iv_loading;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            return new ViewDialogSdFormattingBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogReturnCountDownBinding implements ViewBinding {
    public final ImageButton btnClose;
    public final ImageView ivReturn;
    private final ShadowLayout rootView;
    public final TextView tvDialogTitle;

    private ViewDialogReturnCountDownBinding(ShadowLayout shadowLayout, ImageButton imageButton, ImageView imageView, TextView textView) {
        this.rootView = shadowLayout;
        this.btnClose = imageButton;
        this.ivReturn = imageView;
        this.tvDialogTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogReturnCountDownBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogReturnCountDownBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_return_count_down, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogReturnCountDownBinding bind(View view) {
        int i = R.id.btn_close;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.iv_return;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.tv_dialog_title;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    return new ViewDialogReturnCountDownBinding((ShadowLayout) view, imageButton, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
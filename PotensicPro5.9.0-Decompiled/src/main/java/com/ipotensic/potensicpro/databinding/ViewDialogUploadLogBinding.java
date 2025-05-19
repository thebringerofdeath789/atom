package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDialogUploadLogBinding implements ViewBinding {
    public final Button btnSure;
    public final ImageView imgLoading;
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvTitle;

    private ViewDialogUploadLogBinding(LinearLayout linearLayout, Button button, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnSure = button;
        this.imgLoading = imageView;
        this.tvContent = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUploadLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUploadLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_upload_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUploadLogBinding bind(View view) {
        int i = R.id.btn_sure;
        Button button = (Button) view.findViewById(R.id.btn_sure);
        if (button != null) {
            i = R.id.img_loading;
            ImageView imageView = (ImageView) view.findViewById(R.id.img_loading);
            if (imageView != null) {
                i = R.id.tv_content;
                TextView textView = (TextView) view.findViewById(R.id.tv_content);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        return new ViewDialogUploadLogBinding((LinearLayout) view, button, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

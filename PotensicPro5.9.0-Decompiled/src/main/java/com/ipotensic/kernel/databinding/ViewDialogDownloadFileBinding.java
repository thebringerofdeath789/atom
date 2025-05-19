package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.NumberProgressBar;

/* loaded from: classes2.dex */
public final class ViewDialogDownloadFileBinding implements ViewBinding {
    public final ImageButton btnCancel;
    public final ImageView ivRotate;
    public final LinearLayout layoutDownload;
    public final NumberProgressBar progressBar;
    private final ShadowLayout rootView;
    public final TextView tvProgress;

    private ViewDialogDownloadFileBinding(ShadowLayout shadowLayout, ImageButton imageButton, ImageView imageView, LinearLayout linearLayout, NumberProgressBar numberProgressBar, TextView textView) {
        this.rootView = shadowLayout;
        this.btnCancel = imageButton;
        this.ivRotate = imageView;
        this.layoutDownload = linearLayout;
        this.progressBar = numberProgressBar;
        this.tvProgress = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogDownloadFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogDownloadFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_download_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogDownloadFileBinding bind(View view) {
        int i = R.id.btn_cancel;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.iv_rotate;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.layout_download;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                if (linearLayout != null) {
                    i = R.id.progress_bar;
                    NumberProgressBar numberProgressBar = (NumberProgressBar) view.findViewById(i);
                    if (numberProgressBar != null) {
                        i = R.id.tv_progress;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            return new ViewDialogDownloadFileBinding((ShadowLayout) view, imageButton, imageView, linearLayout, numberProgressBar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

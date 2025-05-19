package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogUpgradingBinding implements ViewBinding {
    public final ImageView imgRotate;
    public final ConstraintLayout layoutLogo;
    public final RelativeLayout layoutUpgrading;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final TextView tvDownloading;
    public final TextView tvProgressPercent;

    private ViewDialogUpgradingBinding(RelativeLayout relativeLayout, ImageView imageView, ConstraintLayout constraintLayout, RelativeLayout relativeLayout2, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.imgRotate = imageView;
        this.layoutLogo = constraintLayout;
        this.layoutUpgrading = relativeLayout2;
        this.progressBar = progressBar;
        this.tvDownloading = textView;
        this.tvProgressPercent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUpgradingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUpgradingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_upgrading, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUpgradingBinding bind(View view) {
        int i = R.id.img_rotate;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.layout_logo;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
            if (constraintLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) view.findViewById(i);
                if (progressBar != null) {
                    i = R.id.tv_downloading;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_progress_percent;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new ViewDialogUpgradingBinding(relativeLayout, imageView, constraintLayout, relativeLayout, progressBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

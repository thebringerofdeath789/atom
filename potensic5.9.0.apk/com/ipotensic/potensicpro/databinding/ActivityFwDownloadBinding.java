package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ActivityFwDownloadBinding implements ViewBinding {
    public final Button btnStartDownload;
    public final ImageView ivUpgradeReminder;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final ViewToolbarBinding toolbar;
    public final TextView tvDownloadTips;
    public final TextView tvProgress;
    public final TextView tvTips;

    private ActivityFwDownloadBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, ProgressBar progressBar, ViewToolbarBinding viewToolbarBinding, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnStartDownload = button;
        this.ivUpgradeReminder = imageView;
        this.progressBar = progressBar;
        this.toolbar = viewToolbarBinding;
        this.tvDownloadTips = textView;
        this.tvProgress = textView2;
        this.tvTips = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFwDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFwDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_fw_download, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFwDownloadBinding bind(View view) {
        int i = C2640R.id.btn_start_download;
        Button button = (Button) view.findViewById(C2640R.id.btn_start_download);
        if (button != null) {
            i = C2640R.id.iv_upgrade_reminder;
            ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_upgrade_reminder);
            if (imageView != null) {
                i = C2640R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) view.findViewById(C2640R.id.progress_bar);
                if (progressBar != null) {
                    i = C2640R.id.toolbar;
                    View findViewById = view.findViewById(C2640R.id.toolbar);
                    if (findViewById != null) {
                        ViewToolbarBinding bind = ViewToolbarBinding.bind(findViewById);
                        i = C2640R.id.tv_download_tips;
                        TextView textView = (TextView) view.findViewById(C2640R.id.tv_download_tips);
                        if (textView != null) {
                            i = C2640R.id.tv_progress;
                            TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_progress);
                            if (textView2 != null) {
                                i = C2640R.id.tv_tips;
                                TextView textView3 = (TextView) view.findViewById(C2640R.id.tv_tips);
                                if (textView3 != null) {
                                    return new ActivityFwDownloadBinding((ConstraintLayout) view, button, imageView, progressBar, bind, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogFwUpgradeWhiteBinding implements ViewBinding {
    public final LinearLayout clUpgradeDialog;
    public final ConstraintLayout clView;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvDownload;
    public final TextView tvProgress;

    private ViewDialogFwUpgradeWhiteBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.clUpgradeDialog = linearLayout2;
        this.clView = constraintLayout;
        this.progressBar = progressBar;
        this.tvCodeTitle = textView;
        this.tvDownload = textView2;
        this.tvProgress = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFwUpgradeWhiteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFwUpgradeWhiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_fw_upgrade_white, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFwUpgradeWhiteBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.cl_view;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
        if (constraintLayout != null) {
            i = R.id.progress_bar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(i);
            if (progressBar != null) {
                i = R.id.tv_code_title;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = R.id.tv_download;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = R.id.tv_progress;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            return new ViewDialogFwUpgradeWhiteBinding(linearLayout, linearLayout, constraintLayout, progressBar, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
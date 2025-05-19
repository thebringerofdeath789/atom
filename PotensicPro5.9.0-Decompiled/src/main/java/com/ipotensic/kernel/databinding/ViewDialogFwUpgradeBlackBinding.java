package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogFwUpgradeBlackBinding implements ViewBinding {
    public final ConstraintLayout clView;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvDownload;
    public final TextView tvProgress;

    private ViewDialogFwUpgradeBlackBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clView = constraintLayout2;
        this.progressBar = progressBar;
        this.tvCodeTitle = textView;
        this.tvDownload = textView2;
        this.tvProgress = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFwUpgradeBlackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFwUpgradeBlackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_fw_upgrade_black, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFwUpgradeBlackBinding bind(View view) {
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
                            return new ViewDialogFwUpgradeBlackBinding((ConstraintLayout) view, constraintLayout, progressBar, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.ProgressLoadingView;

/* loaded from: classes2.dex */
public final class ViewDialogFormatProgressBinding implements ViewBinding {
    public final ProgressLoadingView progressView;
    private final RelativeLayout rootView;
    public final TextView tvText;

    private ViewDialogFormatProgressBinding(RelativeLayout relativeLayout, ProgressLoadingView progressLoadingView, TextView textView) {
        this.rootView = relativeLayout;
        this.progressView = progressLoadingView;
        this.tvText = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFormatProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFormatProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_format_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFormatProgressBinding bind(View view) {
        int i = C1965R.id.progress_view;
        ProgressLoadingView progressLoadingView = (ProgressLoadingView) view.findViewById(i);
        if (progressLoadingView != null) {
            i = C1965R.id.tv_text;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new ViewDialogFormatProgressBinding((RelativeLayout) view, progressLoadingView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
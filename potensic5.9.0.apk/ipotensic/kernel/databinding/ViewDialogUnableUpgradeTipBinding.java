package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CircleProgressbar;

/* loaded from: classes2.dex */
public final class ViewDialogUnableUpgradeTipBinding implements ViewBinding {
    public final CircleProgressbar circleProgressBar;
    private final RelativeLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private ViewDialogUnableUpgradeTipBinding(RelativeLayout relativeLayout, CircleProgressbar circleProgressbar, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.circleProgressBar = circleProgressbar;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUnableUpgradeTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUnableUpgradeTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_unable_upgrade_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUnableUpgradeTipBinding bind(View view) {
        int i = R.id.circle_progress_bar;
        CircleProgressbar circleProgressbar = (CircleProgressbar) view.findViewById(i);
        if (circleProgressbar != null) {
            i = R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_content;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewDialogUnableUpgradeTipBinding((RelativeLayout) view, circleProgressbar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
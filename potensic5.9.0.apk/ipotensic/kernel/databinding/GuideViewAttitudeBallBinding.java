package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class GuideViewAttitudeBallBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvView;

    private GuideViewAttitudeBallBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvView = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static GuideViewAttitudeBallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuideViewAttitudeBallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.guide_view_attitude_ball, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GuideViewAttitudeBallBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new GuideViewAttitudeBallBinding(textView, textView);
    }
}
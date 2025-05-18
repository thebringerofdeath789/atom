package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class GuideViewMainRightOffsetBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvView;

    private GuideViewMainRightOffsetBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvView = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static GuideViewMainRightOffsetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuideViewMainRightOffsetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.guide_view_main_right_offset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GuideViewMainRightOffsetBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new GuideViewMainRightOffsetBinding(textView, textView);
    }
}
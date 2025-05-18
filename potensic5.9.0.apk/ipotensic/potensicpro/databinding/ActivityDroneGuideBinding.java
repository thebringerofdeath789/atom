package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityDroneGuideBinding implements ViewBinding {
    public final ImageView ivBack;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private ActivityDroneGuideBinding(ConstraintLayout constraintLayout, ImageView imageView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivBack = imageView;
        this.toolbar = toolbar;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDroneGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDroneGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_drone_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDroneGuideBinding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            if (toolbar != null) {
                i = R.id.tv_code_title;
                TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                if (textView != null) {
                    i = R.id.tv_content;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_content);
                    if (textView2 != null) {
                        return new ActivityDroneGuideBinding((ConstraintLayout) view, imageView, toolbar, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
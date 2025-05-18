package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityVideoTeachBinding implements ViewBinding {
    public final ImageView ivBlank;
    private final ConstraintLayout rootView;
    public final RecyclerView rvView;
    public final ViewToolbarBinding toolbar;
    public final TextView tvNoNetwork;

    private ActivityVideoTeachBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, ViewToolbarBinding viewToolbarBinding, TextView textView) {
        this.rootView = constraintLayout;
        this.ivBlank = imageView;
        this.rvView = recyclerView;
        this.toolbar = viewToolbarBinding;
        this.tvNoNetwork = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVideoTeachBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityVideoTeachBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_video_teach, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityVideoTeachBinding bind(View view) {
        int i = R.id.iv_blank;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_blank);
        if (imageView != null) {
            i = R.id.rv_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view);
            if (recyclerView != null) {
                i = R.id.toolbar;
                View findViewById = view.findViewById(R.id.toolbar);
                if (findViewById != null) {
                    ViewToolbarBinding bind = ViewToolbarBinding.bind(findViewById);
                    i = R.id.tv_no_network;
                    TextView textView = (TextView) view.findViewById(R.id.tv_no_network);
                    if (textView != null) {
                        return new ActivityVideoTeachBinding((ConstraintLayout) view, imageView, recyclerView, bind, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
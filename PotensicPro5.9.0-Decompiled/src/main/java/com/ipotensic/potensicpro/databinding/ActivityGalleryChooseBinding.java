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
public final class ActivityGalleryChooseBinding implements ViewBinding {
    public final ImageView ivBack;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView toolbar;

    private ActivityGalleryChooseBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivBack = imageView;
        this.recyclerView = recyclerView;
        this.toolbar = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGalleryChooseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityGalleryChooseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_gallery_choose, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityGalleryChooseBinding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i = R.id.toolbar;
                TextView textView = (TextView) view.findViewById(R.id.toolbar);
                if (textView != null) {
                    return new ActivityGalleryChooseBinding((ConstraintLayout) view, imageView, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

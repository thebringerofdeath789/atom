package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ActivityInstructionBinding implements ViewBinding {
    public final ImageView ivBlank;
    public final View line;
    private final ConstraintLayout rootView;
    public final RecyclerView rvView;
    public final ViewToolbarBinding toolbar;
    public final TextView tvNoNetwork;

    private ActivityInstructionBinding(ConstraintLayout constraintLayout, ImageView imageView, View view, RecyclerView recyclerView, ViewToolbarBinding viewToolbarBinding, TextView textView) {
        this.rootView = constraintLayout;
        this.ivBlank = imageView;
        this.line = view;
        this.rvView = recyclerView;
        this.toolbar = viewToolbarBinding;
        this.tvNoNetwork = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityInstructionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityInstructionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.activity_instruction, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityInstructionBinding bind(View view) {
        int i = C2640R.id.iv_blank;
        ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_blank);
        if (imageView != null) {
            i = C2640R.id.line;
            View findViewById = view.findViewById(C2640R.id.line);
            if (findViewById != null) {
                i = C2640R.id.rv_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C2640R.id.rv_view);
                if (recyclerView != null) {
                    i = C2640R.id.toolbar;
                    View findViewById2 = view.findViewById(C2640R.id.toolbar);
                    if (findViewById2 != null) {
                        ViewToolbarBinding bind = ViewToolbarBinding.bind(findViewById2);
                        i = C2640R.id.tv_no_network;
                        TextView textView = (TextView) view.findViewById(C2640R.id.tv_no_network);
                        if (textView != null) {
                            return new ActivityInstructionBinding((ConstraintLayout) view, imageView, findViewById, recyclerView, bind, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
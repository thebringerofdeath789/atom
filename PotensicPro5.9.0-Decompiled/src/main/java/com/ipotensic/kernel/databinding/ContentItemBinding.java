package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ContentItemBinding implements ViewBinding {
    public final View backgroundView;
    public final FrameLayout clTopLayout;
    private final FrameLayout rootView;

    private ContentItemBinding(FrameLayout frameLayout, View view, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.backgroundView = view;
        this.clTopLayout = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ContentItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.content_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ContentItemBinding bind(View view) {
        int i = R.id.backgroundView;
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            i = R.id.cl_top_layout;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
            if (frameLayout != null) {
                return new ContentItemBinding((FrameLayout) view, findViewById, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

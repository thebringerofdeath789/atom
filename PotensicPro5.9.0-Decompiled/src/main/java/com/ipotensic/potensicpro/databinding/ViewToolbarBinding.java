package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewToolbarBinding implements ViewBinding {
    public final ImageView ivBack;
    private final Toolbar rootView;
    public final TextView tvCodeTitle;

    private ViewToolbarBinding(Toolbar toolbar, ImageView imageView, TextView textView) {
        this.rootView = toolbar;
        this.ivBack = imageView;
        this.tvCodeTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public Toolbar getRoot() {
        return this.rootView;
    }

    public static ViewToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewToolbarBinding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            i = R.id.tv_code_title;
            TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
            if (textView != null) {
                return new ViewToolbarBinding((Toolbar) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

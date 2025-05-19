package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutSizeItem2Binding implements ViewBinding {
    public final ImageView ivBgSelect;
    public final RelativeLayout layoutMain;
    private final RelativeLayout rootView;
    public final AppCompatTextView txt;

    private ViewLayoutSizeItem2Binding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, AppCompatTextView appCompatTextView) {
        this.rootView = relativeLayout;
        this.ivBgSelect = imageView;
        this.layoutMain = relativeLayout2;
        this.txt = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSizeItem2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSizeItem2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_size_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSizeItem2Binding bind(View view) {
        int i = R.id.iv_bg_select;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = R.id.txt;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i2);
            if (appCompatTextView != null) {
                return new ViewLayoutSizeItem2Binding(relativeLayout, imageView, relativeLayout, appCompatTextView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

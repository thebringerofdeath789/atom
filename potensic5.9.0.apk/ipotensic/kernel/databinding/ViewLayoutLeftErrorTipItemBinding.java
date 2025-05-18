package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutLeftErrorTipItemBinding implements ViewBinding {
    public final ImageView imgTipIcon;
    private final ShadowLayout rootView;
    public final TextView tvTipMsg;
    public final TextView tvTipTitle;

    private ViewLayoutLeftErrorTipItemBinding(ShadowLayout shadowLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.imgTipIcon = imageView;
        this.tvTipMsg = textView;
        this.tvTipTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutLeftErrorTipItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutLeftErrorTipItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_left_error_tip_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutLeftErrorTipItemBinding bind(View view) {
        int i = R.id.img_tip_icon;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.tv_tip_msg;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_tip_title;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewLayoutLeftErrorTipItemBinding((ShadowLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
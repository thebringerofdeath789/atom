package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewAdapterDeviceListBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivBg;
    private final ConstraintLayout rootView;
    public final TextView tvDetail;
    public final TextView tvDeviceType;

    private ViewAdapterDeviceListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivBg = imageView;
        this.tvDetail = textView;
        this.tvDeviceType = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewAdapterDeviceListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterDeviceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_device_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterDeviceListBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
        if (imageView != null) {
            i = R.id.tv_detail;
            TextView textView = (TextView) view.findViewById(R.id.tv_detail);
            if (textView != null) {
                i = R.id.tv_device_type;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_device_type);
                if (textView2 != null) {
                    return new ViewAdapterDeviceListBinding(constraintLayout, constraintLayout, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

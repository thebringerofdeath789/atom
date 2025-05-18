package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewAdapterAircraftLogBinding implements ViewBinding {
    public final ImageView ivShare;
    public final ImageView ivUpload;
    private final LinearLayout rootView;
    public final TextView tvName;

    private ViewAdapterAircraftLogBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = linearLayout;
        this.ivShare = imageView;
        this.ivUpload = imageView2;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewAdapterAircraftLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterAircraftLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_aircraft_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterAircraftLogBinding bind(View view) {
        int i = R.id.iv_share;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_share);
        if (imageView != null) {
            i = R.id.iv_upload;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_upload);
            if (imageView2 != null) {
                i = R.id.tv_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    return new ViewAdapterAircraftLogBinding((LinearLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
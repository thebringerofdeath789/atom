package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewItemAppLogBinding implements ViewBinding {
    public final ImageView cbSelect;
    private final RelativeLayout rootView;
    public final TextView tvLogName;

    private ViewItemAppLogBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.cbSelect = imageView;
        this.tvLogName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewItemAppLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewItemAppLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_item_app_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewItemAppLogBinding bind(View view) {
        int i = R.id.cb_select;
        ImageView imageView = (ImageView) view.findViewById(R.id.cb_select);
        if (imageView != null) {
            i = R.id.tv_log_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_log_name);
            if (textView != null) {
                return new ViewItemAppLogBinding((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
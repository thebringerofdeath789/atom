package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutCenterTipsBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final RelativeLayout layoutCenterTips;
    private final RelativeLayout rootView;
    public final TextView tvDialogTitle;

    private ViewLayoutCenterTipsBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.ivIcon = imageView;
        this.layoutCenterTips = relativeLayout2;
        this.tvDialogTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutCenterTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutCenterTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_center_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutCenterTipsBinding bind(View view) {
        int i = C1965R.id.iv_icon;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = C1965R.id.tv_dialog_title;
            TextView textView = (TextView) view.findViewById(i2);
            if (textView != null) {
                return new ViewLayoutCenterTipsBinding(relativeLayout, imageView, relativeLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
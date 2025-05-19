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
public final class ViewItemFilePortBinding implements ViewBinding {
    public final ImageView imgSelect;
    public final ImageView imgThumbnail;
    public final RelativeLayout layoutMain;
    private final RelativeLayout rootView;
    public final TextView tvInfo;

    private ViewItemFilePortBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.imgSelect = imageView;
        this.imgThumbnail = imageView2;
        this.layoutMain = relativeLayout2;
        this.tvInfo = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewItemFilePortBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewItemFilePortBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_item_file_port, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewItemFilePortBinding bind(View view) {
        int i = R.id.img_select;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_select);
        if (imageView != null) {
            i = R.id.img_thumbnail;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_thumbnail);
            if (imageView2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.tv_info;
                TextView textView = (TextView) view.findViewById(R.id.tv_info);
                if (textView != null) {
                    return new ViewItemFilePortBinding(relativeLayout, imageView, imageView2, relativeLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

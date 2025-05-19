package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class AdapterPictureSelectBinding implements ViewBinding {
    public final ImageView imageView;
    private final RelativeLayout rootView;
    public final ImageView videoView;

    private AdapterPictureSelectBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.imageView = imageView;
        this.videoView = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AdapterPictureSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AdapterPictureSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.adapter_picture_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AdapterPictureSelectBinding bind(View view) {
        int i = R.id.image_view;
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        if (imageView != null) {
            i = R.id.video_view;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.video_view);
            if (imageView2 != null) {
                return new AdapterPictureSelectBinding((RelativeLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

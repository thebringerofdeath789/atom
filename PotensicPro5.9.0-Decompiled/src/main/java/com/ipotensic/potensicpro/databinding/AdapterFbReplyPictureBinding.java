package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.RoundImageView;

/* loaded from: classes2.dex */
public final class AdapterFbReplyPictureBinding implements ViewBinding {
    public final RoundImageView imageView;
    private final RelativeLayout rootView;
    public final ImageView videoView;

    private AdapterFbReplyPictureBinding(RelativeLayout relativeLayout, RoundImageView roundImageView, ImageView imageView) {
        this.rootView = relativeLayout;
        this.imageView = roundImageView;
        this.videoView = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AdapterFbReplyPictureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AdapterFbReplyPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.adapter_fb_reply_picture, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AdapterFbReplyPictureBinding bind(View view) {
        int i = R.id.image_view;
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.image_view);
        if (roundImageView != null) {
            i = R.id.video_view;
            ImageView imageView = (ImageView) view.findViewById(R.id.video_view);
            if (imageView != null) {
                return new AdapterFbReplyPictureBinding((RelativeLayout) view, roundImageView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.view.RoundImageView;

/* loaded from: classes2.dex */
public final class ViewItemPhotoBinding implements ViewBinding {
    public final ImageButton btnDeletePhoto;
    public final ImageButton btnSelectPhoto;
    public final RoundImageView iconImage;
    public final ImageView ivVideoView;
    private final RelativeLayout rootView;
    public final TextView tvVideoTime;

    private ViewItemPhotoBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, RoundImageView roundImageView, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.btnDeletePhoto = imageButton;
        this.btnSelectPhoto = imageButton2;
        this.iconImage = roundImageView;
        this.ivVideoView = imageView;
        this.tvVideoTime = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewItemPhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewItemPhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_item_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewItemPhotoBinding bind(View view) {
        int i = C2640R.id.btn_delete_photo;
        ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_delete_photo);
        if (imageButton != null) {
            i = C2640R.id.btn_select_photo;
            ImageButton imageButton2 = (ImageButton) view.findViewById(C2640R.id.btn_select_photo);
            if (imageButton2 != null) {
                i = C2640R.id.icon_image;
                RoundImageView roundImageView = (RoundImageView) view.findViewById(C2640R.id.icon_image);
                if (roundImageView != null) {
                    i = C2640R.id.iv_video_view;
                    ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_video_view);
                    if (imageView != null) {
                        i = C2640R.id.tv_video_time;
                        TextView textView = (TextView) view.findViewById(C2640R.id.tv_video_time);
                        if (textView != null) {
                            return new ViewItemPhotoBinding((RelativeLayout) view, imageButton, imageButton2, roundImageView, imageView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
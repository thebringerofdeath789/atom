package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewRemoteFileItemBinding implements ViewBinding {
    public final ImageView imgAlreadyDownloaded;
    public final ImageView ivSelectIcon;
    public final ImageView ivThumbnail;
    public final ImageView ivVideoIcon;
    private final ConstraintLayout rootView;

    private ViewRemoteFileItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        this.rootView = constraintLayout;
        this.imgAlreadyDownloaded = imageView;
        this.ivSelectIcon = imageView2;
        this.ivThumbnail = imageView3;
        this.ivVideoIcon = imageView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewRemoteFileItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewRemoteFileItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_remote_file_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewRemoteFileItemBinding bind(View view) {
        int i = R.id.img_already_downloaded;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_select_icon;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_thumbnail;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.iv_video_icon;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        return new ViewRemoteFileItemBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

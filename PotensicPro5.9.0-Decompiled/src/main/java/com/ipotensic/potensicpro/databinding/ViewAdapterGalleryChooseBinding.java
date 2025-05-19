package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ViewAdapterGalleryChooseBinding implements ViewBinding {
    public final ImageView ivPhoto;
    private final ImageView rootView;

    private ViewAdapterGalleryChooseBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.ivPhoto = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ViewAdapterGalleryChooseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterGalleryChooseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_gallery_choose, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterGalleryChooseBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        ImageView imageView = (ImageView) view;
        return new ViewAdapterGalleryChooseBinding(imageView, imageView);
    }
}

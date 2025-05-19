package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewMapPositionBinding implements ViewBinding {
    public final ImageButton ivFlyHomePosition;
    public final ImageButton ivFlyPosition;
    public final ImageView ivMapPosBg;
    public final ImageButton ivMyPosition;
    private final ConstraintLayout rootView;

    private ViewMapPositionBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, ImageButton imageButton3) {
        this.rootView = constraintLayout;
        this.ivFlyHomePosition = imageButton;
        this.ivFlyPosition = imageButton2;
        this.ivMapPosBg = imageView;
        this.ivMyPosition = imageButton3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapPositionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapPositionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_map_position, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapPositionBinding bind(View view) {
        int i = R.id.iv_fly_home_position;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.iv_fly_position;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.iv_map_pos_bg;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = R.id.iv_my_position;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                    if (imageButton3 != null) {
                        return new ViewMapPositionBinding((ConstraintLayout) view, imageButton, imageButton2, imageView, imageButton3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

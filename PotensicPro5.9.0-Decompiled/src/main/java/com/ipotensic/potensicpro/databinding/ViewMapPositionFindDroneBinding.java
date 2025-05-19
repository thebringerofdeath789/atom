package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewMapPositionFindDroneBinding implements ViewBinding {
    public final ImageButton ivFlyPosition;
    public final ImageView ivMapPosBg;
    public final ImageButton ivMyPosition;
    private final ConstraintLayout rootView;

    private ViewMapPositionFindDroneBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageView imageView, ImageButton imageButton2) {
        this.rootView = constraintLayout;
        this.ivFlyPosition = imageButton;
        this.ivMapPosBg = imageView;
        this.ivMyPosition = imageButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapPositionFindDroneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapPositionFindDroneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_map_position_find_drone, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapPositionFindDroneBinding bind(View view) {
        int i = R.id.iv_fly_position;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.iv_fly_position);
        if (imageButton != null) {
            i = R.id.iv_map_pos_bg;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_map_pos_bg);
            if (imageView != null) {
                i = R.id.iv_my_position;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.iv_my_position);
                if (imageButton2 != null) {
                    return new ViewMapPositionFindDroneBinding((ConstraintLayout) view, imageButton, imageView, imageButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

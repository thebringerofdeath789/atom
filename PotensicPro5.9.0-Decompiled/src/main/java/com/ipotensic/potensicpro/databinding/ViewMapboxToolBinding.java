package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.databinding.ViewMapTypeBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewMapboxToolBinding implements ViewBinding {
    public final ImageView ivMapCompassBg;
    public final ImageButton ivMapLock;
    public final ImageButton ivMapPosition;
    public final ImageButton ivMapSetHide;
    public final ImageButton ivMapType;
    private final ConstraintLayout rootView;
    public final ViewMapPositionFindDroneBinding viewMapPosition;
    public final ViewMapboxToolInfoShowBinding viewMapSet;
    public final ViewMapTypeBinding viewMapType;

    private ViewMapboxToolBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ViewMapPositionFindDroneBinding viewMapPositionFindDroneBinding, ViewMapboxToolInfoShowBinding viewMapboxToolInfoShowBinding, ViewMapTypeBinding viewMapTypeBinding) {
        this.rootView = constraintLayout;
        this.ivMapCompassBg = imageView;
        this.ivMapLock = imageButton;
        this.ivMapPosition = imageButton2;
        this.ivMapSetHide = imageButton3;
        this.ivMapType = imageButton4;
        this.viewMapPosition = viewMapPositionFindDroneBinding;
        this.viewMapSet = viewMapboxToolInfoShowBinding;
        this.viewMapType = viewMapTypeBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapboxToolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapboxToolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_mapbox_tool, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapboxToolBinding bind(View view) {
        int i = R.id.iv_map_compass_bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_map_compass_bg);
        if (imageView != null) {
            i = R.id.iv_map_lock;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.iv_map_lock);
            if (imageButton != null) {
                i = R.id.iv_map_position;
                ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.iv_map_position);
                if (imageButton2 != null) {
                    i = R.id.iv_map_set_hide;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.iv_map_set_hide);
                    if (imageButton3 != null) {
                        i = R.id.iv_map_type;
                        ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.iv_map_type);
                        if (imageButton4 != null) {
                            i = R.id.view_map_position;
                            View findViewById = view.findViewById(R.id.view_map_position);
                            if (findViewById != null) {
                                ViewMapPositionFindDroneBinding bind = ViewMapPositionFindDroneBinding.bind(findViewById);
                                i = R.id.view_map_set;
                                View findViewById2 = view.findViewById(R.id.view_map_set);
                                if (findViewById2 != null) {
                                    ViewMapboxToolInfoShowBinding bind2 = ViewMapboxToolInfoShowBinding.bind(findViewById2);
                                    i = R.id.view_map_type;
                                    View findViewById3 = view.findViewById(R.id.view_map_type);
                                    if (findViewById3 != null) {
                                        return new ViewMapboxToolBinding((ConstraintLayout) view, imageView, imageButton, imageButton2, imageButton3, imageButton4, bind, bind2, ViewMapTypeBinding.bind(findViewById3));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

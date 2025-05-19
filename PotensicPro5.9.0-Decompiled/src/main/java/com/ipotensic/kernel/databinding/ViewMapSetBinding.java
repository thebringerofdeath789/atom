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
public final class ViewMapSetBinding implements ViewBinding {
    public final ImageButton btnMapClear;
    public final ImageButton btnMapMark;
    public final ImageButton btnMapShow;
    public final ImageButton btnMarkSave;
    public final ImageView ivMapPositionBg;
    private final ConstraintLayout rootView;

    private ViewMapSetBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageView imageView) {
        this.rootView = constraintLayout;
        this.btnMapClear = imageButton;
        this.btnMapMark = imageButton2;
        this.btnMapShow = imageButton3;
        this.btnMarkSave = imageButton4;
        this.ivMapPositionBg = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_map_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapSetBinding bind(View view) {
        int i = R.id.btn_map_clear;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.btn_map_mark;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.btn_map_show;
                ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                if (imageButton3 != null) {
                    i = R.id.btn_mark_save;
                    ImageButton imageButton4 = (ImageButton) view.findViewById(i);
                    if (imageButton4 != null) {
                        i = R.id.iv_map_position_bg;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            return new ViewMapSetBinding((ConstraintLayout) view, imageButton, imageButton2, imageButton3, imageButton4, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

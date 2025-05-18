package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewMapTypeBinding implements ViewBinding {
    public final ImageButton ivMapNight;
    public final ImageButton ivMapSatellite;
    public final ImageButton ivMapStandard;
    public final ImageView ivMapTypeBg;
    private final ConstraintLayout rootView;
    public final TextView tvMapNight;
    public final TextView tvMapSatellite;
    public final TextView tvMapStandard;

    private ViewMapTypeBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ivMapNight = imageButton;
        this.ivMapSatellite = imageButton2;
        this.ivMapStandard = imageButton3;
        this.ivMapTypeBg = imageView;
        this.tvMapNight = textView;
        this.tvMapSatellite = textView2;
        this.tvMapStandard = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapTypeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_map_type, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapTypeBinding bind(View view) {
        int i = R.id.iv_map_night;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.iv_map_satellite;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.iv_map_standard;
                ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                if (imageButton3 != null) {
                    i = R.id.iv_map_type_bg;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null) {
                        i = R.id.tv_map_night;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = R.id.tv_map_satellite;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = R.id.tv_map_standard;
                                TextView textView3 = (TextView) view.findViewById(i);
                                if (textView3 != null) {
                                    return new ViewMapTypeBinding((ConstraintLayout) view, imageButton, imageButton2, imageButton3, imageView, textView, textView2, textView3);
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
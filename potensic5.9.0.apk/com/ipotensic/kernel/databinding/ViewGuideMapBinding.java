package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewGuideMapBinding implements ViewBinding {
    public final ImageView ivCompass;
    public final ImageView ivDirection;
    public final ImageView ivHome;
    public final ImageView ivLocation;
    public final ImageView ivMapType;
    public final ImageView ivRemoteLocation;
    private final ConstraintLayout rootView;
    public final TextView tvCompass;
    public final TextView tvDirection;
    public final TextView tvHome;
    public final TextView tvLocation;
    public final TextView tvMapType;
    public final TextView tvRemoteLocation;

    private ViewGuideMapBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.ivCompass = imageView;
        this.ivDirection = imageView2;
        this.ivHome = imageView3;
        this.ivLocation = imageView4;
        this.ivMapType = imageView5;
        this.ivRemoteLocation = imageView6;
        this.tvCompass = textView;
        this.tvDirection = textView2;
        this.tvHome = textView3;
        this.tvLocation = textView4;
        this.tvMapType = textView5;
        this.tvRemoteLocation = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewGuideMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewGuideMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_guide_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewGuideMapBinding bind(View view) {
        int i = C1965R.id.iv_compass;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1965R.id.iv_direction;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1965R.id.iv_home;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = C1965R.id.iv_location;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = C1965R.id.iv_map_type;
                        ImageView imageView5 = (ImageView) view.findViewById(i);
                        if (imageView5 != null) {
                            i = C1965R.id.iv_remote_location;
                            ImageView imageView6 = (ImageView) view.findViewById(i);
                            if (imageView6 != null) {
                                i = C1965R.id.tv_compass;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C1965R.id.tv_direction;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = C1965R.id.tv_home;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C1965R.id.tv_location;
                                            TextView textView4 = (TextView) view.findViewById(i);
                                            if (textView4 != null) {
                                                i = C1965R.id.tv_map_type;
                                                TextView textView5 = (TextView) view.findViewById(i);
                                                if (textView5 != null) {
                                                    i = C1965R.id.tv_remote_location;
                                                    TextView textView6 = (TextView) view.findViewById(i);
                                                    if (textView6 != null) {
                                                        return new ViewGuideMapBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, textView3, textView4, textView5, textView6);
                                                    }
                                                }
                                            }
                                        }
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
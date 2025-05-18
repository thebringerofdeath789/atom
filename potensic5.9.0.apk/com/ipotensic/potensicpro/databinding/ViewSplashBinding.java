package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewSplashBinding implements ViewBinding {
    public final TextView btnSkip;
    public final Button btnStart;
    public final ImageView imgLogo;
    public final LinearLayout layoutIndicator;
    private final ConstraintLayout rootView;
    public final ConstraintLayout splash;
    public final TextView tvExplain;
    public final ViewPager viewPager;

    private ViewSplashBinding(ConstraintLayout constraintLayout, TextView textView, Button button, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView2, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.btnSkip = textView;
        this.btnStart = button;
        this.imgLogo = imageView;
        this.layoutIndicator = linearLayout;
        this.splash = constraintLayout2;
        this.tvExplain = textView2;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewSplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewSplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewSplashBinding bind(View view) {
        int i = C2640R.id.btn_skip;
        TextView textView = (TextView) view.findViewById(C2640R.id.btn_skip);
        if (textView != null) {
            i = C2640R.id.btn_start;
            Button button = (Button) view.findViewById(C2640R.id.btn_start);
            if (button != null) {
                i = C2640R.id.img_logo;
                ImageView imageView = (ImageView) view.findViewById(C2640R.id.img_logo);
                if (imageView != null) {
                    i = C2640R.id.layout_indicator;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C2640R.id.layout_indicator);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = C2640R.id.tv_explain;
                        TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_explain);
                        if (textView2 != null) {
                            i = C2640R.id.view_pager;
                            ViewPager viewPager = (ViewPager) view.findViewById(C2640R.id.view_pager);
                            if (viewPager != null) {
                                return new ViewSplashBinding(constraintLayout, textView, button, imageView, linearLayout, constraintLayout, textView2, viewPager);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
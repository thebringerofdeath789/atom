package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDeviceMethodBinding implements ViewBinding {
    public final ImageButton btnBack;
    public final ImageButton btnClose;
    public final ImageView ivGif;
    public final ImageView ivStep;
    public final View line;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvExplain;
    public final TextView tvNext;

    private ViewDeviceMethodBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, ImageView imageView2, View view, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.btnClose = imageButton2;
        this.ivGif = imageView;
        this.ivStep = imageView2;
        this.line = view;
        this.tvCodeTitle = textView;
        this.tvExplain = textView2;
        this.tvNext = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDeviceMethodBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDeviceMethodBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_device_method, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDeviceMethodBinding bind(View view) {
        int i = R.id.btn_back;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_back);
        if (imageButton != null) {
            i = R.id.btn_close;
            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn_close);
            if (imageButton2 != null) {
                i = R.id.iv_gif;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_gif);
                if (imageView != null) {
                    i = R.id.iv_step;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_step);
                    if (imageView2 != null) {
                        i = R.id.line;
                        View findViewById = view.findViewById(R.id.line);
                        if (findViewById != null) {
                            i = R.id.tv_code_title;
                            TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                            if (textView != null) {
                                i = R.id.tv_explain;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_explain);
                                if (textView2 != null) {
                                    i = R.id.tv_next;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_next);
                                    if (textView3 != null) {
                                        return new ViewDeviceMethodBinding((ConstraintLayout) view, imageButton, imageButton2, imageView, imageView2, findViewById, textView, textView2, textView3);
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

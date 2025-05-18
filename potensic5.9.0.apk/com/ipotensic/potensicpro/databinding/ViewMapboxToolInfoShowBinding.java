package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewMapboxToolInfoShowBinding implements ViewBinding {
    public final ImageButton btnMapShow;
    public final ImageView ivSignalHd;
    public final LinearLayout llHd;
    private final LinearLayout rootView;
    public final TextView tvElectricity;
    public final TextView tvGps;

    private ViewMapboxToolInfoShowBinding(LinearLayout linearLayout, ImageButton imageButton, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnMapShow = imageButton;
        this.ivSignalHd = imageView;
        this.llHd = linearLayout2;
        this.tvElectricity = textView;
        this.tvGps = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapboxToolInfoShowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapboxToolInfoShowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_mapbox_tool_info_show, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapboxToolInfoShowBinding bind(View view) {
        int i = C2640R.id.btn_map_show;
        ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_map_show);
        if (imageButton != null) {
            i = C2640R.id.iv_signal_hd;
            ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_signal_hd);
            if (imageView != null) {
                i = C2640R.id.ll_hd;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C2640R.id.ll_hd);
                if (linearLayout != null) {
                    i = C2640R.id.tv_electricity;
                    TextView textView = (TextView) view.findViewById(C2640R.id.tv_electricity);
                    if (textView != null) {
                        i = C2640R.id.tv_gps;
                        TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_gps);
                        if (textView2 != null) {
                            return new ViewMapboxToolInfoShowBinding((LinearLayout) view, imageButton, imageView, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
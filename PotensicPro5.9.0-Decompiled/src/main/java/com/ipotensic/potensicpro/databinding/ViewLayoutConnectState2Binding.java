package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewLayoutConnectState2Binding implements ViewBinding {
    public final ImageView imgConnectStatus;
    public final ImageView imgIn;
    public final ImageView imgOut;
    private final LinearLayout rootView;
    public final TextView tvState;

    private ViewLayoutConnectState2Binding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = linearLayout;
        this.imgConnectStatus = imageView;
        this.imgIn = imageView2;
        this.imgOut = imageView3;
        this.tvState = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutConnectState2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutConnectState2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_connect_state2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutConnectState2Binding bind(View view) {
        int i = R.id.img_connect_status;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_connect_status);
        if (imageView != null) {
            i = R.id.img_in;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_in);
            if (imageView2 != null) {
                i = R.id.img_out;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.img_out);
                if (imageView3 != null) {
                    i = R.id.tv_state;
                    TextView textView = (TextView) view.findViewById(R.id.tv_state);
                    if (textView != null) {
                        return new ViewLayoutConnectState2Binding((LinearLayout) view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutTopTipsBinding implements ViewBinding {
    public final ImageView ivClose;
    public final RelativeLayout layoutTopTips;
    private final RelativeLayout rootView;
    public final TextView tvContent;
    public final TextView tvCountDown;

    private ViewLayoutTopTipsBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.ivClose = imageView;
        this.layoutTopTips = relativeLayout2;
        this.tvContent = textView;
        this.tvCountDown = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTopTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTopTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_top_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTopTipsBinding bind(View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.tv_content;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_count_down;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new ViewLayoutTopTipsBinding(relativeLayout, imageView, relativeLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogMiniPairBinding implements ViewBinding {
    public final RelativeLayout btnBottom;
    public final ConstraintLayout constraintLayout;
    public final ImageView ivCodeClose;
    public final ImageView ivMiniCodeGif;
    private final ConstraintLayout rootView;
    public final TextView tvCodeStep;
    public final TextView tvCodeStepTwo;
    public final TextView tvCodeTitle;

    private ViewDialogMiniPairBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBottom = relativeLayout;
        this.constraintLayout = constraintLayout2;
        this.ivCodeClose = imageView;
        this.ivMiniCodeGif = imageView2;
        this.tvCodeStep = textView;
        this.tvCodeStepTwo = textView2;
        this.tvCodeTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogMiniPairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogMiniPairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_mini_pair, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogMiniPairBinding bind(View view) {
        int i = R.id.btn_bottom;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
        if (relativeLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.iv_code_close;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.iv_mini_code_gif;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = R.id.tv_code_step;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_code_step_two;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = R.id.tv_code_title;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                return new ViewDialogMiniPairBinding(constraintLayout, relativeLayout, constraintLayout, imageView, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

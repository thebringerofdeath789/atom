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
public final class ActivityRepairBinding implements ViewBinding {
    public final RelativeLayout btnBottom;
    public final ImageView ivClose;
    public final ImageView ivRepairGif;
    private final ConstraintLayout rootView;
    public final TextView tvCodeStep;
    public final TextView tvCodeStepTwo;
    public final TextView tvRepairTitle;

    private ActivityRepairBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBottom = relativeLayout;
        this.ivClose = imageView;
        this.ivRepairGif = imageView2;
        this.tvCodeStep = textView;
        this.tvCodeStepTwo = textView2;
        this.tvRepairTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRepairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRepairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_repair, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityRepairBinding bind(View view) {
        int i = R.id.btn_bottom;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
        if (relativeLayout != null) {
            i = R.id.iv_close;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = R.id.iv_repair_gif;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = R.id.tv_code_step;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_code_step_two;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = R.id.tv_repair_title;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                return new ActivityRepairBinding((ConstraintLayout) view, relativeLayout, imageView, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}